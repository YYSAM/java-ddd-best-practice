package com.aws.proserve.mad.order.application.service;

import com.aws.proserve.mad.order.application.command.PayOrderCommand;

public interface OrderPaymentService {
    /**
     * 订单付款;
     * @param payOrderCommand
     */
    void pay(PayOrderCommand payOrderCommand);
}
