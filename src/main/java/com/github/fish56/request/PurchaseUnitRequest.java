package com.github.fish56.request;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * https://developer.paypal.com/docs/api/orders/v2/#definition-purchase_unit_request
 */
@Data
@Accessors(chain = true)
public class PurchaseUnitRequest {
    /**
     * The API caller-provided external ID for the
     * purchase unit. Required for multiple purchase units
     * when you must update the order through PATCH. If you
     * omit this value and the order contains only one purchase
     * unit, PayPal sets this value to
     */
    private String reference_id;

    /**
     * 商品价格信息
     */
    private Amount amount;

    @Data
    @Accessors(chain = true)
    public static class Amount{
        /**
         * 价格，默认单位为美元
         */
        private Double value;

        /**
         * 货币种类: https://developer.paypal.com/docs/integration/direct/rest/currency-codes/
         * United States dollar	USD
         */
        private String currency_code = "USD";
    }
}
