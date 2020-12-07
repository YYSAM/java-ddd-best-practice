package com.aws.proserve.dip.order.domain.order.entity;

import com.aws.proserve.dip.common.CommonEntity;
import com.aws.proserve.dip.common.type.Money;
import com.aws.proserve.dip.order.domain.order.entity.types.OrderId;
import com.aws.proserve.dip.order.domain.order.entity.types.OrderIdGenerator;
import com.aws.proserve.dip.order.domain.order.entity.types.OrderStatus;
import com.aws.proserve.dip.order.domain.order.event.OrderCreatedEvent;
import com.aws.proserve.dip.order.domain.order.event.OrderPaidEvent;
import com.aws.proserve.dip.order.domain.order.exception.OrderFinalPriceNotSameWithOrderPaidPriceException;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class Order extends CommonEntity {

    private OrderId id;
    private Money totalPrice;
    private Money finalPrice;
    private OrderStatus status;
    private Long createPersonId;
    private LocalDateTime createDateTime;

    private List<OrderItem> items;
    private OrderAddress address;

    public static Order newOrder(List<OrderItem> items, OrderAddress address, Long createPersonId) {
        Order order = Order.builder()
                .id(OrderIdGenerator.generate())
                .items(items)
                .totalPrice(items.stream().map(OrderItem::getTotalPrice)
                        .reduce(Money::add).orElse(Money.ZERO()))
                .finalPrice(items.stream().map(OrderItem::getFinalPrice)
                        .reduce(Money::add).orElse(Money.ZERO()))
                .status(OrderStatus.CREATED)
                .address(address)
                .createDateTime(LocalDateTime.now())
                .createPersonId(createPersonId)
                .build();
        order.publishEvent(new OrderCreatedEvent(order));
        return order;
    }

    public void pay(BigDecimal paidPrice) {
        if (!finalPrice.getAmount().equals(paidPrice)) {
            HashMap<String, Object> mymap = new HashMap<String, Object>() {
                {
                    put("finalPrice", finalPrice.getAmount());
                    put("paidPrice", paidPrice);
                    put("orderId", id);
                }
            };
            throw new OrderFinalPriceNotSameWithOrderPaidPriceException(mymap);
        }
        this.status = OrderStatus.PAID;
        publishEvent(new OrderPaidEvent(this));
    }

}
