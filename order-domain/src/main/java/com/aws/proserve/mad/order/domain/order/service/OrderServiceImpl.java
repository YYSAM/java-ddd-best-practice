package com.aws.proserve.mad.order.domain.order.service;

import com.aws.proserve.mad.order.domain.order.entity.Order;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class OrderServiceImpl implements OrderService {

    @Override
    public Order createNewOrder() {
        return null;
    }

    @Override
    public void pay(Order order, BigDecimal paidPrice) {
        order.pay(paidPrice);
    }

}
