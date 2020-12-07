package com.aws.proserve.dip.order.domain.order.event;

import com.aws.proserve.dip.order.domain.order.entity.Order;
import com.aws.proserve.dip.common.CommonEvent;

public class OrderPaidEvent extends CommonEvent {

    private final Order order;

    public OrderPaidEvent(Order order) {
        this.order = order;
    }
}
