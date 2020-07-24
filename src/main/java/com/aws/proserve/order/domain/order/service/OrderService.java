package com.aws.proserve.order.domain.order.service;


import com.aws.proserve.order.domain.order.entity.Order;
import com.aws.proserve.order.domain.order.repository.OrderRepository;

public class OrderService {
    private OrderRepository orderRepository;

    public Order findById(Long id) {
        return orderRepository.findById(id);
    }
}
