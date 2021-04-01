package com.aws.proserve.dip.order.application.service;

import com.aws.proserve.dip.order.application.command.PayOrderCommand;
import com.aws.proserve.dip.order.domain.order.entity.Order;
import com.aws.proserve.dip.order.domain.order.entity.types.OrderId;
import com.aws.proserve.dip.order.domain.order.repository.OrderRepository;
import com.aws.proserve.dip.order.domain.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class OrderPaymentServiceImpl implements OrderPaymentService {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    @Transactional
    public void pay(PayOrderCommand payOrderCommand) {
        Order order = orderRepository.find(new OrderId(payOrderCommand.getOrderId()));

        orderService.pay(order, payOrderCommand.getPaidPrice());

        orderRepository.save(order);
    }
}
