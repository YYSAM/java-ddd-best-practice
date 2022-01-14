package com.aws.proserve.mad.order.application.event;

import com.aws.proserve.mad.order.domain.order.event.OrderCreatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Slf4j
public class OrderCreatedEventSubscriber {

    @Order(1)
    @Transactional
    @EventListener(condition = "#event.isInnerEvent == true ")
    public void process(OrderCreatedEvent event) {
        // receive message;
        log.info("OrderCreatedEventSubscriber: receive OrderCreatedEvent event!");
    }
}
