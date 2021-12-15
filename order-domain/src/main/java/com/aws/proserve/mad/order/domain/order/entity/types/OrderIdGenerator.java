package com.aws.proserve.mad.order.domain.order.entity.types;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class OrderIdGenerator {

    public static OrderId generate() {
        return new OrderId(UUID.randomUUID().toString());
    }

}
