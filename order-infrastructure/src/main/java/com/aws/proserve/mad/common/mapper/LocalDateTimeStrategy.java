package com.aws.proserve.mad.common.mapper;


import com.aws.proserve.mad.common.util.LocalDateTimeUtils;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class LocalDateTimeStrategy {

    public String localDateTime2String(LocalDateTime localDateTime) {
        return LocalDateTimeUtils.toString(localDateTime);
    }

    public LocalDateTime string2LocalDateTime(String time) {
        return LocalDateTimeUtils.toLocalDateTime(time);
    }
}
