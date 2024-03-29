package com.aws.proserve.mad.order.domain.order.exception;

import com.aws.proserve.mad.common.exception.CommonException;

import java.util.Map;

public class OrderNotFoundException extends CommonException {

    // 可以根据需要进行国际化
    public OrderNotFoundException() {
        super(409, "ORDER_NOT_FOUND", "order not found");
    }

    public OrderNotFoundException(Map<String, Object> data) {
        super(409, "ORDER_NOT_FOUND", "order not found", data);
    }

}
