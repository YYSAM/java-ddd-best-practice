package com.aws.proserve.mad.order.application.command;

import lombok.Value;

import javax.validation.constraints.NotNull;

@Value
public class RefundOrderCommand {

    @NotNull
    private String orderId;

    public RefundOrderCommand(String orderId) {
        this.orderId = orderId;
    }
}
