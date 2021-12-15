package com.aws.proserve.mad.order.presentation;

import com.aws.proserve.mad.order.application.dto.OrderDTO;
import com.aws.proserve.mad.order.application.service.OrderQueryService;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderQueryController {

    private final OrderQueryService orderQueryService;

    public OrderQueryController(OrderQueryService orderQueryService) {
        this.orderQueryService = orderQueryService;
    }

    public List<OrderDTO> queryByCreatePersonId(Long createPersonId) {
        orderQueryService.queryByCreatePersonId(createPersonId);
        return null;
    }

}
