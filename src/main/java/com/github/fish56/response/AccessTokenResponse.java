package com.github.fish56.response;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 获得token是的响应
 * https://developer.paypal.com/docs/api/get-an-access-token-postman/
 */
@Data
@Accessors(chain = true)
public class AccessTokenResponse {
    private String scope;
    private String accessToken;

    /**
     * Bearer 等
     */
    private String tokenType;
    private String appId;

    /**
     * 多少秒之后过期
     */
    private Integer expiresIn;
    private String nonce;
}
