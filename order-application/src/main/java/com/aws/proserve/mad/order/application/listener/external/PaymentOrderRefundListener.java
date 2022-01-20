package com.aws.proserve.mad.order.application.listener.external;

import com.aws.proserve.mad.order.application.command.RefundOrderCommand;
import com.aws.proserve.mad.order.application.listener.external.event.PaymentOrderRefundEvent;
import com.aws.proserve.mad.order.application.service.OrderPaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 接受其他领域的事件
 */
@Component
@Slf4j
public class PaymentOrderRefundListener {

    private OrderPaymentService orderPaymentService;

    public PaymentOrderRefundListener(OrderPaymentService orderPaymentService) {
        this.orderPaymentService = orderPaymentService;
    }

    /**
     * 接受外部支付单已退款的事件，例如执行一些订单的逻辑；
     *
     * @param event
     */
    //@SqsListener(value = "sqs.queue.***.**.**", deletionPolicy = SqsMessageDeletionPolicy.ON_SUCCESS)
    public void onEvent(PaymentOrderRefundEvent event) {
        // receive message;
        log.info("PaymentOrderRefundListener: receive PaymentOrderRefundEvent event!");

        // do refund;
        orderPaymentService.refund(new RefundOrderCommand(event.getOrderId()));
    }
}
