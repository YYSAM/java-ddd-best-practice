package com.aws.proserve.mad.order.domain.order.service;

import com.aws.proserve.mad.order.domain.order.entity.Order;

import java.math.BigDecimal;

public interface OrderService {

    void pay(Order order, BigDecimal paidPrice);

    void refund(Order order);
}
