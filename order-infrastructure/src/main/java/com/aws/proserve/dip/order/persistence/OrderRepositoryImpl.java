package com.aws.proserve.dip.order.persistence;

import com.aws.proserve.dip.common.CommonRepository;
import com.aws.proserve.dip.order.domain.order.entity.Order;
import com.aws.proserve.dip.order.domain.order.entity.types.OrderId;
import com.aws.proserve.dip.order.domain.order.exception.OrderNotFoundException;
import com.aws.proserve.dip.order.domain.order.repository.OrderRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class OrderRepositoryImpl extends CommonRepository<Order> implements OrderRepository {

    final OrderPOMapper orderPOMapper;
    final OrderDAO orderDAO;

    public OrderRepositoryImpl(OrderPOMapper orderPOMapper, OrderDAO orderDAO) {
        this.orderPOMapper = orderPOMapper;
        this.orderDAO = orderDAO;
    }

    @Override
    public Order find(OrderId id) {
        OrderPO orderPO = orderDAO.selectById(id.getValue());
        if (orderPO == null) {
            HashMap<String, Object> hashmap = new HashMap<>();
            hashmap.put("orderId", id.getValue());
            throw new OrderNotFoundException(hashmap);
        }
        return orderPOMapper.toOrder(orderPO);
    }

    @Override
    public List<Order> findByCreatePersonId(Long createPersonId) {
        List<OrderPO> orderPO = orderDAO.selectByUserId(createPersonId);

        return orderPO.stream().map(orderPOMapper::toOrder).collect(Collectors.toList());
    }

    protected Order saveEntity(Order Order) {
        OrderPO orderPO = orderPOMapper.toOrderPO(Order);
        if (orderPO.getId() == null) {
            OrderDAO.insert(orderPO);
        } else {
            OrderDAO.update(orderPO);
        }
        return orderPOMapper.toOrder(orderPO);
    }

    @Override
    public void remove(Order order) {
        OrderDAO.remove(order.getId().getValue());
    }

}
