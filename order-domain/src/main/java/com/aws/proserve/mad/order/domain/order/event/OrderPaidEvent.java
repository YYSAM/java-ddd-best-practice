package com.aws.proserve.mad.order.domain.order.event;

import com.aws.proserve.mad.order.domain.order.entity.Order;
import org.springframework.context.ApplicationEvent;


public class OrderPaidEvent extends ApplicationEvent {

    public OrderPaidEvent(Order order) {
        super(order);
    }
}
