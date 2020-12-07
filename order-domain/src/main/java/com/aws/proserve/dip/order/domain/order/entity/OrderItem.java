package com.aws.proserve.dip.order.domain.order.entity;

import com.aws.proserve.dip.common.type.Money;
import lombok.*;

import java.math.BigDecimal;


@Getter
@Setter
@Builder
@Data
@AllArgsConstructor
public class OrderItem {
    private String productId;
    private int productCount;
    private Money totalPrice;
    private Money finalPrice;

    public static OrderItem newOrderItem(String productId, int productCount, BigDecimal totalPrice, BigDecimal finalPrice) {
        return OrderItem.builder()
                .productId(productId)
                .productCount(productCount)
                .totalPrice(new Money(totalPrice))
                .finalPrice(new Money(finalPrice))
                .build();
    }

}
