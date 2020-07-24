package com.aws.proserve.order.domain.order.repository;


import com.aws.proserve.order.domain.order.entity.Order;

public interface OrderRepository {
    Order findById(Long id);
}
