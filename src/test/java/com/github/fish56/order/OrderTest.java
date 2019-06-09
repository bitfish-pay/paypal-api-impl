package com.github.fish56.order;

import com.alibaba.fastjson.JSONObject;
import com.github.fish56.ApplicationTest;
import com.github.fish56.request.OrderRequest;
import com.github.fish56.request.PurchaseUnit;
import com.github.fish56.response.OrderResponse;
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

        PurchaseUnit purchaseUnit = new PurchaseUnit()
                .setAmount(new PurchaseUnit.Amount().setValue(8.00));
        PurchaseUnit[] purchaseUnits = {purchaseUnit};

        OrderRequest orderRequest = new OrderRequest().setPurchase_units(purchaseUnits);

        String res = Unirest.post(url)
                .header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json")
                .body(JSONObject.toJSONString(orderRequest))
                .asString().getBody();

        System.out.println(res);
        // {"id":"1K6991280B701335W","links":[{"href":"https://api.sandbox.paypal.com/v2/checkout/orders/1K6991280B701335W","rel":"self","method":"GET"},{"href":"https://www.sandbox.paypal.com/checkoutnow?token=1K6991280B701335W","rel":"approve","method":"GET"},{"href":"https://api.sandbox.paypal.com/v2/checkout/orders/1K6991280B701335W","rel":"update","method":"PATCH"},{"href":"https://api.sandbox.paypal.com/v2/checkout/orders/1K6991280B701335W/capture","rel":"capture","method":"POST"}],"status":"CREATED"}
    }

    private String orderId = "44P1819642631645N";
    @Test
    public void getOrderInfo() throws Exception{
        String url = baseUrl + "/v2/checkout/orders/" + orderId;
        String res = Unirest.get(url)
                .header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json")
                .asString().getBody();
        System.out.println(res);

        OrderResponse response = JSONObject.parseObject(res, OrderResponse.class);
        System.out.println(JSONObject.toJSONString(response.getPurchase_units()[0]));
    }
}
