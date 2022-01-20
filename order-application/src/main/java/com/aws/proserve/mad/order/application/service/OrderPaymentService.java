package com.aws.proserve.mad.order.application.service;

import com.aws.proserve.mad.order.application.command.PayOrderCommand;
import com.aws.proserve.mad.order.application.command.RefundOrderCommand;

public interface OrderPaymentService {
    /**
     * 订单付款;
     *
     * @param payOrderCommand
     */
    void pay(PayOrderCommand payOrderCommand);

    /**
     * 订单退款；
     *
     * @param refundOrderCommand
     */
    void refund(RefundOrderCommand refundOrderCommand);
}
