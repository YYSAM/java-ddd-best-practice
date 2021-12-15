package com.aws.proserve.mad.common.exception.handler;

import lombok.Builder;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

/**
 * 运行时异常转换器
 */
@Order
@ControllerAdvice
public class RuntimeExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(RuntimeExceptionHandler.class);

    private static final String SYSTEM_ERROR_MESSAGE = "系统存在错误，请联系管理员";

    @ResponseStatus(INTERNAL_SERVER_ERROR)
    @ResponseBody
    @ExceptionHandler(RuntimeException.class)
    public Error runtimeExceptionHandler(RuntimeException ex) {
        LOGGER.error(ex.getMessage(), ex);
        return new Error(ErrorResult.builder().message(SYSTEM_ERROR_MESSAGE).build());
    }

    @Data
    static class Error {
        private final ErrorResult errorResult;
    }

    @Data
    @Builder
    static class ErrorResult {
        private final int httpCode;
        private final String code;
        private final String message;
        private final String[] errorData;
    }
}