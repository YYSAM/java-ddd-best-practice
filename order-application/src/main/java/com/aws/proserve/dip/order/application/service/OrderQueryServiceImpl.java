package com.aws.proserve.dip.order.application.service;

import com.aws.proserve.dip.order.application.dto.OrderDTO;
import com.aws.proserve.dip.order.application.mapper.OrderDTOMapper;
import com.aws.proserve.dip.order.domain.order.entity.Order;
import com.aws.proserve.dip.order.domain.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class OrderQueryServiceImpl implements OrderQueryService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderDTOMapper orderDTOMapper;

    @Override
    public List<OrderDTO> queryByCreatePersonId(Long createPersonId) {
        List<Order> list = orderRepository.findByCreatePersonId(createPersonId);

        return list.stream().map(orderDTOMapper::toOrderDTO).collect(Collectors.toList());
    }
}
