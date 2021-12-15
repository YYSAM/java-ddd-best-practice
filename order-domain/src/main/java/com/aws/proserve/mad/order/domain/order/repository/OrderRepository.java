package com.aws.proserve.mad.order.domain.order.repository;

import com.aws.proserve.mad.order.domain.order.entity.Order;
import com.aws.proserve.mad.order.domain.order.entity.types.OrderId;

import java.util.List;

public interface OrderRepository {

    Order find(OrderId id);

    List<Order> findByCreatePersonId(Long createPersonId);

    void remove(Order order);

    Order save(Order order);
}
