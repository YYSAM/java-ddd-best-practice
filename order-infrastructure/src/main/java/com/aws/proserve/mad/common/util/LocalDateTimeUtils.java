package com.aws.proserve.mad.common.util;

import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeUtils {

    public static String toString(LocalDateTime localDateTime) {
        if (localDateTime == null) {
            return null;
        }

        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return df.format(localDateTime);
    }


    public static LocalDateTime toLocalDateTime(String localDateTime) {
        if (StringUtils.isEmpty(localDateTime)) {
            return null;
        }

        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return LocalDateTime.parse(localDateTime, df);
    }

    public static String toString(LocalDate localDate) {
        if (StringUtils.isEmpty(localDate)) {
            return null;
        }

        return toString(LocalDateTime.of(localDate, LocalTime.parse("00:00:00")));
    }
}
