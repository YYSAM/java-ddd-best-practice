package com.aws.proserve.mad.common.exception;

public class CommonExceptionBuilder {

    // 数据错误；
    private static final String DATA_ERROR_CODE = "DATA_ERROR";
    private static final String DATA_ERROR_MESSAGE = "系统数据存在错误，请联系管理员";

    // 系统错误；
    private static final String SYSTEM_ERROR_CODE = "SYSTEM_ERROR";
    private static final String SYSTEM_ERROR_MESSAGE = "系统存在错误，请联系管理员";

    public static CommonException buildDataErrorException() {
        return CommonException.builder().code(DATA_ERROR_CODE).httpCode(500).message(DATA_ERROR_MESSAGE).build();
    }

    public static CommonException buildSystemErrorException() {
        return CommonException.builder().code(SYSTEM_ERROR_CODE).httpCode(500).message(SYSTEM_ERROR_MESSAGE).build();
    }

}
