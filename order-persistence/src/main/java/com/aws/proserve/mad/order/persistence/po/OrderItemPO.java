package com.aws.proserve.mad.order.persistence.po;

import com.aws.proserve.mad.common.type.Money;
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
