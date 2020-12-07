package com.aws.proserve.dip.order.persistence;

import com.aws.proserve.dip.common.type.Money;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OrderItemPO {
    private String productId;
    private int productCount;
    private Money totalPrice;
    private Money finalPrice;
}
