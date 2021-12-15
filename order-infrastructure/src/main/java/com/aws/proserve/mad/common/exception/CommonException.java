package com.aws.proserve.mad.common.exception;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * 公共异常类，负责公共的业务异常；
 */
@Builder
@Getter
@Setter
public class CommonException extends RuntimeException {

    private static final String ERROR_CODE = "错误编码";
    private static final String ERROR_DATA = "错误数据";

    private final int httpCode;

    private final String code;

    private final String message;

    private final String[] errorData;

    protected CommonException(int httpCode, String code, String message) {
        this(httpCode, code, message, null);
    }

    protected CommonException(int httpCode, String code, String message, String... errorData) {
        this(httpCode, code, message, null, errorData);
    }

    protected CommonException(int httpCode, String code, String message, Throwable cause, String... errorData) {
        super(format(httpCode, code, message, errorData), cause);
        this.message = message;
        this.errorData = errorData;
        this.httpCode = httpCode;
        this.code = code;
    }

    private static String format(int httpCode, String code, String message, String... errorData) {
        return String.format(ERROR_CODE + ": <%d> [%s] %s, " + ERROR_DATA + ": %s", httpCode, code, message, array2String(errorData));
    }

    private static String array2String(String... data) {
        if (data == null) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < data.length; i++) {
            sb.append(data[i]).append(" ");
            if (i / 2 != 0) {
                sb.append(":");
            }
        }
        return sb.toString();
    }

}
