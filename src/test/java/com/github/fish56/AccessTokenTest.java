package com.github.fish56;

import com.alibaba.fastjson.JSONObject;
import com.github.fish56.response.AccessTokenResponse;
import com.mashape.unirest.http.Unirest;
import lombok.val;
import org.junit.Test;

public class AccessTokenTest extends ApplicationTest {
    /**
     * get access token for this app
     *   https://developer.paypal.com/docs/api/get-an-access-token-postman/
     * the test do the job instead from postman
     */
    @Test
    public void getToken() throws Exception{
        String url = baseUrl + "/v1/oauth2/token";
        val res = Unirest.post(url)
                .basicAuth(clientId, clientSecret)
                .header("Content-Type", "application/x-www-form-urlencoded")
                .field("grant_type","client_credentials")
                .asString();
        System.out.println(res.getBody());
        // {"access_token":"A21AAEBs5W2k54TuipdWwoFdTLaz4zuT102c-nxIO0t5dbgJnBcYnmTfTp31SoqU8lte7AIt8ZTHHyXiH1MRzjtljkIDiN2SQ","scope":"https://uri.paypal.com/services/invoicing https://uri.paypal.com/services/disputes/read-buyer https://uri.paypal.com/services/payments/realtimepayment https://uri.paypal.com/services/disputes/update-seller https://uri.paypal.com/services/payments/payment/authcapture openid https://uri.paypal.com/services/disputes/read-seller https://uri.paypal.com/services/payments/refund https://api.paypal.com/v1/vault/credit-card https://api.paypal.com/v1/payments/.* https://uri.paypal.com/payments/payouts https://api.paypal.com/v1/vault/credit-card/.* https://uri.paypal.com/services/subscriptions https://uri.paypal.com/services/applications/webhooks","token_type":"Bearer","app_id":"APP-80W284485P519543T","expires_in":31914,"nonce":"2019-06-09T09:10:49ZjcUq_HLx5pAat702JeMHpfIVNUILI0yHU9PFBq0Etgk"}

        AccessTokenResponse response = JSONObject.parseObject(res.getBody(), AccessTokenResponse.class);
        System.out.println(JSONObject.toJSONString(response, true));
    }

    @Test
    public void getToken2() throws Exception{
        String url = baseUrl + "/v1/oauth2/token";
        val res = Unirest.post(url)
                .basicAuth(clientId, clientSecret)
                .header("Content-Type", "application/x-www-form-urlencoded")
                .field("grant_type","client_credentials")
                .asObject(AccessTokenResponse.class);

        System.out.println(JSONObject.toJSONString(res.getBody(), true));
    }
}
