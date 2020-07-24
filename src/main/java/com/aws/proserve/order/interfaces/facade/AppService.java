package com.aws.proserve.order.interfaces.facade;

import com.aws.proserve.order.application.service.OrderApplicationService;
import com.aws.proserve.order.interfaces.dto.AppRequest;
import com.aws.proserve.order.interfaces.dto.AppResponse;

public class AppService {

    private OrderApplicationService orderApplicationService;

    public AppResponse doSomething(AppRequest weiXinRequest) {
        return null;
    }
}
