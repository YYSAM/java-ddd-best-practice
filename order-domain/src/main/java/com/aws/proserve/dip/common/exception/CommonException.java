package com.aws.proserve.dip.common.exception;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public abstract class CommonException extends RuntimeException {

    private final int httpCode;

    private final String code;

    private final String message;

    private Map<String, Object> errorData;

    protected CommonException(int httpCode, String code, String message) {
        this(httpCode, code, message, null);
    }

    protected CommonException(int httpCode, String code, String message, Map<String, Object> data) {
        this(httpCode, code, message, data, null);
    }

    protected CommonException(int httpCode, String code, String message, Map<String, Object> data, Throwable cause) {
        super(format(httpCode, code, message, data), cause);
        if (data.isEmpty()) {
            errorData.putAll(data);
        }
        this.httpCode = httpCode;
        this.code = code;
        this.message = message;
    }

    private static String format(int httpCode, String code, String message, Map<String, Object> data) {
        return String.format("ERROR: <%d> [%s] %s, DATA: %s", httpCode, code, message, data.isEmpty() ? "" : data.toString());
    }

}
