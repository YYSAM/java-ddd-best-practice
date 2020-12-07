package com.aws.proserve.dip.common.application.service;

import com.aws.proserve.dip.common.application.command.PayOrderCommand;

public interface OrderPaymentService {
    /**
     * 订单付款;
     * @param payOrderCommand
     */
    void pay(PayOrderCommand payOrderCommand);
}
