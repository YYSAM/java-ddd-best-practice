package com.aws.proserve.order.application.event.publish;

import com.aws.proserve.order.domain.order.event.OrderCreateEvent;

/**
 * 发送订单相关的领域事件
 */
public class OrderEventPublisher {

    public void sendOrderCreateEvent(OrderCreateEvent orderCreateEvent) {
        // send message;
    }
}
