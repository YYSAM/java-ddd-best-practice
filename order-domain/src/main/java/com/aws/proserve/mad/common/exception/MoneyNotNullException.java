package com.aws.proserve.mad.common.exception;

public class MoneyNotNullException extends CommonException {

    // 可以根据需要进行国际化
    public MoneyNotNullException() {
        super(409, "MONEY_CAN_NOT_BE_NULL", "the money cannot be null");
    }

}
