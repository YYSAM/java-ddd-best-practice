package com.aws.proserve.dip.order.application.command;

import lombok.Value;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Value
public class PayOrderCommand {

    @NotNull
    private BigDecimal paidPrice;

    @NotNull
    private String orderId;
}
