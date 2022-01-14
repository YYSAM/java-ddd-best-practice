package com.aws.proserve.mad.order.domain.order.event;

import com.aws.proserve.mad.common.event.CommonEvent;
import com.aws.proserve.mad.order.domain.order.entity.Order;

public class OrderPaidEvent extends CommonEvent<Order> {

    public OrderPaidEvent(Order source) {
        super(source);
    }
}
