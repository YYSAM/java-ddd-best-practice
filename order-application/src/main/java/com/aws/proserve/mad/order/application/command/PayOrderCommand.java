package com.aws.proserve.mad.order.application.command;

import com.aws.proserve.mad.order.domain.order.entity.types.OrderId;
import lombok.Value;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Value
public class PayOrderCommand {

    @NotNull
    private BigDecimal paidPrice;

    @NotNull
    private OrderId orderId;
}
