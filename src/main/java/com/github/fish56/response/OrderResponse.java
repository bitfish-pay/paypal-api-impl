package com.github.fish56.response;

import com.github.fish56.request.PurchaseUnit;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class OrderResponse {
    private String id;
    private PurchaseUnit[] purchase_units;
}
