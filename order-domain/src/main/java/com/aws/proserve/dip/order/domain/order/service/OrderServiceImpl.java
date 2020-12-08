package com.aws.proserve.dip.order.domain.order.service;

import com.aws.proserve.dip.order.domain.order.entity.Order;
import com.aws.proserve.dip.order.domain.order.entity.types.OrderStatus;
import com.aws.proserve.dip.order.domain.order.exception.OrderCanNotBePaidRepeatedlyException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

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
