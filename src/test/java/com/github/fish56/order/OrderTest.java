package com.github.fish56.order;

import com.alibaba.fastjson.JSONObject;
import com.github.fish56.ApplicationTest;
import com.github.fish56.request.OrderRequest;
import com.github.fish56.request.PurchaseUnitRequest;
import com.mashape.unirest.http.Unirest;
import org.junit.Test;

/**
 * https://developer.paypal.com/docs/api/reference/api-requests/
 */
public class OrderTest extends ApplicationTest {
    /**
     * 创建一个订单
     * @throws Exception
     */
    @Test
    public void createOrder() throws Exception{
        String url = baseUrl + "/v2/checkout/orders";

        PurchaseUnitRequest purchaseUnitRequest = new PurchaseUnitRequest()
                .setAmount(new PurchaseUnitRequest.Amount().setValue(8.00));
        PurchaseUnitRequest[] purchaseUnitRequests = {purchaseUnitRequest};

        OrderRequest orderRequest = new OrderRequest().setPurchase_units(purchaseUnitRequests);

        String res = Unirest.post(url)
                .header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json")
                .body(JSONObject.toJSONString(orderRequest))
                .asString().getBody();

        System.out.println(res);
        // {"id":"1K6991280B701335W","links":[{"href":"https://api.sandbox.paypal.com/v2/checkout/orders/1K6991280B701335W","rel":"self","method":"GET"},{"href":"https://www.sandbox.paypal.com/checkoutnow?token=1K6991280B701335W","rel":"approve","method":"GET"},{"href":"https://api.sandbox.paypal.com/v2/checkout/orders/1K6991280B701335W","rel":"update","method":"PATCH"},{"href":"https://api.sandbox.paypal.com/v2/checkout/orders/1K6991280B701335W/capture","rel":"capture","method":"POST"}],"status":"CREATED"}
    }
}
