package com.aws.proserve.mad.order.presentation;

import com.aws.proserve.mad.order.application.service.OrderPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderPaymentController {

    @Autowired
    private OrderPaymentService orderPaymentService;

}
