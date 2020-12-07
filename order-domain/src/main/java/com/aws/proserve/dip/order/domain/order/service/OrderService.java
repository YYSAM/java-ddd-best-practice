package com.aws.proserve.dip.order.domain.order.service;

import com.aws.proserve.dip.order.domain.order.entity.Order;

import java.math.BigDecimal;

public interface OrderService {

    Order createNewOrder();

    void pay(Order order, BigDecimal paidPrice);

}
