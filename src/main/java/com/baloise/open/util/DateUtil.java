package com.baloise.open.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public final class DateUtil {

    public static LocalDate convertToLocalDate(Date dateToConvert) {
        return convertToLocalDate(dateToConvert, null);
    }

    public static LocalDate convertToLocalDate(Date dateToConvert, LocalDate fallBack) {
        return dateToConvert != null ? new java.sql.Date(dateToConvert.getTime()).toLocalDate() : fallBack;
    }

    public static LocalDateTime convertToLocalDateTime(Date dateToConvert) {
        return dateToConvert != null ? new java.sql.Timestamp(dateToConvert.getTime()).toLocalDateTime() : null;
    }

    public static Date convertToDate(LocalDateTime dateToConvert) {
        return dateToConvert != null ? java.sql.Timestamp.valueOf(dateToConvert) : null;
    }

    public static Date convertToDate(LocalDate dateToConvert) {
        return dateToConvert != null ? java.sql.Date.valueOf(dateToConvert) : null;
    }

}