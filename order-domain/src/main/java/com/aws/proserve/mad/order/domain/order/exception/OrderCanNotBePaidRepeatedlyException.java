package com.aws.proserve.mad.order.domain.order.exception;

import com.aws.proserve.mad.common.exception.CommonException;

import java.util.Map;

public class OrderCanNotBePaidRepeatedlyException extends CommonException {

    // 可以根据需要进行国际化
    public OrderCanNotBePaidRepeatedlyException(Map<String, Object> data) {
        super(409, "ORDER_CAN_NOT_BE_PAID_REPEATEDLY", "Order Can Not BE Paid Repeatedly", data);
    }

}
