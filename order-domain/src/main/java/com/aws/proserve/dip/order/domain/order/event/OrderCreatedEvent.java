package com.aws.proserve.dip.order.domain.order.event;

import com.aws.proserve.dip.order.domain.order.entity.Order;
import com.aws.proserve.dip.common.CommonEvent;

public class OrderCreatedEvent extends CommonEvent {

    private final Order order;

    public OrderCreatedEvent(Order order) {
        this.order = order;
    }
}
