package com.aws.proserve.mad.order.application.listener.external.event;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentOrderRefundEvent {
    private String orderId;
}
