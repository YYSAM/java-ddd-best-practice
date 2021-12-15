package com.aws.proserve.mad.order.domain.order.exception;

import com.aws.proserve.mad.common.exception.CommonException;

import java.util.Map;

public class OrderFinalPriceNotSameWithOrderPaidPriceException extends CommonException {

    // 可以根据需要进行国际化
    public OrderFinalPriceNotSameWithOrderPaidPriceException(Map<String, Object> data) {
        super(409, "ORDER_FINAL_PRICE_NOT_SAME_WITH_ORDER_PAID_PRICE", "Order Final Price Not Same With Order Paid Price", data);
    }

}
