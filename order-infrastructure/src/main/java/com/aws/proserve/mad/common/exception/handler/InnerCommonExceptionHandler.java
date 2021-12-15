package com.aws.proserve.mad.common.exception.handler;

import com.aws.proserve.mad.common.exception.CommonException;
import lombok.Builder;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

/**
 * 内部公共异常处理器
 */
@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class InnerCommonExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(InnerCommonExceptionHandler.class);

    @ResponseStatus(INTERNAL_SERVER_ERROR)
    @ResponseBody
    @ExceptionHandler(CommonException.class)
    public Error methodArgumentNotValidException(CommonException ex) {
        LOGGER.error(ex.getMessage(), ex);
        return new Error(ErrorResult.builder().code(ex.getCode()).message(ex.getMessage()).errorData(ex.getErrorData()).build());
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