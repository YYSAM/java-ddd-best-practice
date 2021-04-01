package com.aws.proserve.dip.order.application.service;

import com.aws.proserve.dip.order.application.command.PayOrderCommand;

public interface OrderPaymentService {
    /**
     * 订单付款;
     * @param payOrderCommand
     */
    void pay(PayOrderCommand payOrderCommand);
}
