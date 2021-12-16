package com.aws.proserve.mad.order.domain.order.event;

import com.aws.proserve.mad.common.CommonEvent;


public class OrderPaidEvent extends CommonEvent {

    public OrderPaidEvent(Object source) {
        super(source);
    }
}
