package com.aws.proserve.mad.order.application.service;

import com.aws.proserve.mad.common.trace.TraceContext;
import com.aws.proserve.mad.common.trace.TraceContextUtil;
import com.aws.proserve.mad.common.type.Money;
import com.aws.proserve.mad.order.application.command.PayOrderCommand;
import com.aws.proserve.mad.order.domain.order.entity.Order;
import com.aws.proserve.mad.order.domain.order.entity.OrderAddress;
import com.aws.proserve.mad.order.domain.order.entity.OrderItem;
import com.aws.proserve.mad.order.domain.order.entity.types.OrderId;
import com.aws.proserve.mad.order.domain.order.entity.types.OrderStatus;
import com.aws.proserve.mad.order.domain.order.repository.OrderRepository;
import com.aws.proserve.mad.order.domain.order.service.OrderServiceImpl;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderPaymentServiceImplTest {

    OrderId orderId = null;
    Order order = null;
    OrderRepository orderRepository = null;

    @BeforeEach
    public void setUp() {
        List<OrderItem> orderItemList = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            OrderItem orderItem = OrderItem.newOrderItem("product_" + i, i, new Money(BigDecimal.valueOf(100 * i), Currency.getInstance(Locale.CHINA)));
            orderItemList.add(orderItem);
        }
        OrderAddress orderAddress = OrderAddress.builder().customerName("张三").cellPhoneNumber("12345678")
                .fullAddress("AA.BB.CC.DD.EE").build();
        String createPersonId = "1000000";

        order = Order.newOrder(orderItemList,orderAddress ,createPersonId);
        orderId = order.getId();

        orderRepository = Mockito.mock(OrderRepository.class);
        Mockito.when(orderRepository.find(orderId)).thenReturn(order);

        TraceContextUtil.set(new TraceContext("123","张三"));
    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    public void pay() {
        OrderPaymentService orderPaymentService = new OrderPaymentServiceImpl(new OrderServiceImpl(), orderRepository);

        orderPaymentService.pay(new PayOrderCommand(BigDecimal.valueOf(1400), orderId));

        assertEquals(order.getOrderStatus(), OrderStatus.PAID);
    }
}