package com.github.fish56.request;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class OrderRequest {
    private IntentEnum intent = IntentEnum.CAPTURE;

    private PurchaseUnit[] purchase_units;

    public enum IntentEnum{
        /**
         * The merchant intends to capture payment
         * immediately after the customer makes a payment.
         */
        CAPTURE,
        AUTHORIZE
    }
}
