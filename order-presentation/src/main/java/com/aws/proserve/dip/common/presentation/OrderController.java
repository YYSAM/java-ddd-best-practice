package com.aws.proserve.dip.common.presentation;

import com.aws.proserve.dip.common.application.service.OrderQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    private OrderQueryService orderService;

}
