package com.aws.proserve.mad.order.application.service;

import com.aws.proserve.mad.order.application.dto.OrderDTO;
import com.aws.proserve.mad.order.application.mapper.OrderDTOMapper;
import com.aws.proserve.mad.order.domain.order.entity.Order;
import com.aws.proserve.mad.order.domain.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
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
