package com.aws.proserve.dip.order.presentation;

import com.aws.proserve.dip.order.application.service.OrderPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderPaymentController {

    @Autowired
    private OrderPaymentService orderPaymentService;

}
