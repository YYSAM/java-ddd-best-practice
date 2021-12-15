package com.aws.proserve.mad.order.persistence;

import com.aws.proserve.mad.order.domain.order.entity.Order;
import com.aws.proserve.mad.order.domain.order.entity.types.OrderId;
import com.aws.proserve.mad.order.domain.order.exception.OrderNotFoundException;
import com.aws.proserve.mad.order.domain.order.repository.OrderRepository;
import com.aws.proserve.mad.order.persistence.mapper.OrderPOMapper;
import com.aws.proserve.mad.order.persistence.po.OrderPO;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class OrderRepositoryImpl implements OrderRepository {

    final OrderPOMapper orderPOMapper;
    final OrderDemoDAO orderDemoDAO;

    public OrderRepositoryImpl(OrderPOMapper orderPOMapper, OrderDemoDAO orderDemoDAO) {
        this.orderPOMapper = orderPOMapper;
        this.orderDemoDAO = orderDemoDAO;
    }

    @Override
    public Order find(OrderId id) {
        OrderPO orderPO = orderDemoDAO.selectById(id.getValue());
        if (orderPO == null) {
            HashMap<String, Object> hashmap = new HashMap<>();
            hashmap.put("orderId", id.getValue());
            throw new OrderNotFoundException(hashmap);
        }
        return orderPOMapper.toOrder(orderPO);
    }

    @Override
    public List<Order> findByCreatePersonId(Long createPersonId) {
        List<OrderPO> orderPO = orderDemoDAO.selectByUserId(createPersonId);

        return orderPO.stream().map(orderPOMapper::toOrder).collect(Collectors.toList());
    }

    @Override
    public Order save(Order order) {
        OrderPO orderPO = orderPOMapper.toOrderPO(order);
        if (orderPO.getId() == null) {
            OrderDemoDAO.insert(orderPO);
        } else {
            OrderDemoDAO.update(orderPO);
        }
        return orderPOMapper.toOrder(orderPO);
    }

    @Override
    public void remove(Order order) {
        OrderDemoDAO.remove(order.getId().getValue());
    }

}
