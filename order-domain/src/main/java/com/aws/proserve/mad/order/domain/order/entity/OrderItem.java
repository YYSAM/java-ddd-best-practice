package com.aws.proserve.mad.order.domain.order.entity;

import com.aws.proserve.mad.common.CommonEntity;
import com.aws.proserve.mad.common.type.Money;
import com.aws.proserve.mad.order.domain.order.entity.types.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;


@Data
@Builder
@AllArgsConstructor
public class OrderItem extends CommonEntity {
    private String productId;
    private int productCount;
    private Money unitPrice;
    private Money totalPrice;
    private OrderStatus orderItemStatus;

    public static OrderItem newOrderItem(String productId, int productCount, Money unitPrice) {
        return OrderItem.builder()
                .productId(productId)
                .productCount(productCount)
                .unitPrice(unitPrice)
                .totalPrice(new Money(new BigDecimal(productCount).multiply(unitPrice.getAmount())))
                .orderItemStatus(OrderStatus.CREATED)
                .build();
    }

    public void pay() {
        this.orderItemStatus = OrderStatus.PAID;
    }

}
