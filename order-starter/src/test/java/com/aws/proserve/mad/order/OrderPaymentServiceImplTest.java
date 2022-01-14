package com.aws.proserve.mad.order;

import com.aws.proserve.mad.common.context.ApplicationContextProvider;
import com.aws.proserve.mad.common.entity.type.Money;
import com.aws.proserve.mad.common.trace.TraceContext;
import com.aws.proserve.mad.common.trace.TraceContextUtil;
import com.aws.proserve.mad.order.application.command.PayOrderCommand;
import com.aws.proserve.mad.order.application.service.OrderPaymentService;
import com.aws.proserve.mad.order.application.service.OrderPaymentServiceImpl;
import com.aws.proserve.mad.order.domain.order.entity.Order;
import com.aws.proserve.mad.order.domain.order.entity.OrderAddress;
import com.aws.proserve.mad.order.domain.order.entity.OrderItem;
import com.aws.proserve.mad.order.domain.order.entity.types.OrderStatus;
import com.aws.proserve.mad.order.domain.order.repository.OrderRepository;
import com.aws.proserve.mad.order.domain.order.service.OrderServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.springframework.context.ApplicationEventPublisher;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class OrderPaymentServiceImplTest {

    String orderId = null;
    Order order = null;
    OrderRepository orderRepository = null;
    ApplicationEventPublisher applicationEventPublisher = null;

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
        orderId = order.getId().getValue();

        orderRepository = Mockito.mock(OrderRepository.class);
        Mockito.when(orderRepository.find(Mockito.any())).thenReturn(order);

        applicationEventPublisher = Mockito.mock(ApplicationEventPublisher.class);

        MockedStatic<ApplicationContextProvider> staticProvider = Mockito.mockStatic(ApplicationContextProvider.class);
        staticProvider.when(() -> ApplicationContextProvider.getBean(ApplicationEventPublisher.class))
                .thenReturn(applicationEventPublisher);

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

        verify(applicationEventPublisher, times(1)).publishEvent(Mockito.any());
    }
}