package com.aws.proserve.mad.order.application.listener.internal;

import com.aws.proserve.mad.order.domain.order.event.OrderCreatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 接受内部的领域的事件
 */
@Component
@Slf4j
public class OrderCreatedEventListener {

    @Order(1)
    @EventListener(condition = "#event.isInnerEvent == true ")
    public void process(OrderCreatedEvent event) {
        // receive message;
        log.info("OrderCreatedEventSubscriber: receive OrderCreatedEvent event!");
    }
}
