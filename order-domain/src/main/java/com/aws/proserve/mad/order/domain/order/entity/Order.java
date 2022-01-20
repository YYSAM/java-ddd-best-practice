package com.aws.proserve.mad.order.domain.order.entity;

import com.aws.proserve.mad.common.entity.CommonEntity;
import com.aws.proserve.mad.common.entity.type.Money;
import com.aws.proserve.mad.order.domain.order.entity.types.OrderId;
import com.aws.proserve.mad.order.domain.order.entity.types.OrderIdGenerator;
import com.aws.proserve.mad.order.domain.order.entity.types.OrderStatus;
import com.aws.proserve.mad.order.domain.order.event.OrderCreatedEvent;
import com.aws.proserve.mad.order.domain.order.event.OrderPaidEvent;
import com.aws.proserve.mad.order.domain.order.exception.OrderCanNotBePaidRepeatedlyException;
import com.aws.proserve.mad.order.domain.order.exception.OrderFinalPriceNotSameWithOrderPaidPriceException;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Order extends CommonEntity {

    private OrderId id;
    private Money totalPrice;
    private OrderStatus orderStatus;
    private List<OrderItem> items;
    private OrderAddress address;

    public static Order newOrder(List<OrderItem> items, OrderAddress address, String createPersonId) {
        Order order = Order.builder()
                .id(OrderIdGenerator.generate())
                .items(items)
                .totalPrice(items.stream().map(OrderItem::getTotalPrice)
                        .reduce(Money::add).orElse(Money.ZERO()))
                .orderStatus(OrderStatus.CREATED)
                .address(address)
                .build();
        order.setCreateDateTime(LocalDateTime.now());
        order.setCreatePersonId(createPersonId);

        order.publishEvent(new OrderCreatedEvent(order));
        return order;
    }

    public void pay(BigDecimal paidPrice) {
        if (getOrderStatus() == OrderStatus.PAID) {
            HashMap<String, Object> errorMap = new HashMap<String, Object>() {
                {
                    put("orderId", getId());
                }
            };
            throw new OrderCanNotBePaidRepeatedlyException(errorMap);
        } else if (!totalPrice.getAmount().equals(paidPrice)) {
            HashMap<String, Object> errorMap = new HashMap<String, Object>() {
                {
                    put("totalPrice", totalPrice.getAmount());
                    put("paidPrice", paidPrice);
                    put("orderId", id);
                }
            };
            throw new OrderFinalPriceNotSameWithOrderPaidPriceException(errorMap);
        }

        // 更新订单状态；
        this.orderStatus = OrderStatus.PAID;
        this.getItems().forEach(OrderItem::pay);

        publishEvent(new OrderPaidEvent(this));
    }

    public void refund() {

        // 更新订单状态；
        this.orderStatus = OrderStatus.REFUND;
        this.getItems().forEach(OrderItem::refund);

        publishEvent(new OrderPaidEvent(this));
    }
}
