package com.aws.proserve.mad.order.domain.order.event;

import com.aws.proserve.mad.common.CommonEvent;
import com.aws.proserve.mad.order.domain.order.entity.Order;
import org.springframework.context.ApplicationEvent;

public class OrderCreatedEvent extends CommonEvent {
    public OrderCreatedEvent(Order order) {
        super(order);
    }
}
