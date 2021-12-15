package com.aws.proserve.mad.common;

import com.aws.proserve.mad.common.exception.CommonExceptionBuilder;
import io.swagger.annotations.ApiModel;

@ApiModel
public enum Status {
    VALID,
    INVALID;

    public static Status toEnum(String obj) {
        if (obj == null) {
            return null;
        } else if (obj.equalsIgnoreCase("VALID")) {
            return Status.VALID;
        } else if (obj.equalsIgnoreCase("INVALID")) {
            return Status.INVALID;
        } else {
            throw CommonExceptionBuilder.buildDataErrorException();
        }
    }
}
