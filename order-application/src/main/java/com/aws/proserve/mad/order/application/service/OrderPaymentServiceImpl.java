package com.aws.proserve.mad.order.application.service;

import com.aws.proserve.mad.order.application.command.PayOrderCommand;
import com.aws.proserve.mad.order.application.command.RefundOrderCommand;
import com.aws.proserve.mad.order.domain.order.entity.Order;
import com.aws.proserve.mad.order.domain.order.entity.types.OrderId;
import com.aws.proserve.mad.order.domain.order.repository.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderPaymentServiceImpl implements OrderPaymentService {

    private final com.aws.proserve.mad.order.domain.order.service.OrderService orderService;

    private final OrderRepository orderRepository;

    public OrderPaymentServiceImpl(com.aws.proserve.mad.order.domain.order.service.OrderService orderService,
                                   OrderRepository orderRepository) {
        this.orderService = orderService;
        this.orderRepository = orderRepository;
    }

    @Override
    @Transactional
    public void pay(PayOrderCommand payOrderCommand) {
        Order order = orderRepository.find(new OrderId(payOrderCommand.getOrderId()));

        orderService.pay(order, payOrderCommand.getPaidPrice());

        orderRepository.save(order);
    }

    @Override
    @Transactional
    public void refund(RefundOrderCommand refundOrderCommand) {
        Order order = orderRepository.find(new OrderId(refundOrderCommand.getOrderId()));

        orderService.refund(order);

        orderRepository.save(order);
    }
}
