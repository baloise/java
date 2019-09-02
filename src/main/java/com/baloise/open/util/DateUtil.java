package com.baloise.open.util;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public final class DateUtil {

    public static LocalDate convertToLocalDate(Date dateToConvert) {
        return convertToLocalDate(dateToConvert, null);
    }

    public static LocalDate convertToLocalDate(Date dateToConvert, LocalDate fallBack) {
        return dateToConvert != null ? new java.sql.Date(dateToConvert.getTime()).toLocalDate() : fallBack;
    }

    public static LocalDateTime convertToLocalDateTime(Date dateToConvert) {
        return dateToConvert != null ? new Timestamp(dateToConvert.getTime()).toLocalDateTime() : null;
    }

    public static Date convertToDate(LocalDateTime dateToConvert) {
        return dateToConvert != null ? Timestamp.valueOf(dateToConvert) : null;
    }

    public static Date convertToDate(LocalDate dateToConvert) {
        return dateToConvert != null ? java.sql.Date.valueOf(dateToConvert) : null;
    }

    public static Date createDate() { return convertToDate(LocalDate.now()); }

    public static Date createDate(int year, int month, int day) { return convertToDate(LocalDate.of(year,month,day)); }

    public static Timestamp convertToTimestamp(LocalDateTime dateToConvert) {
        return dateToConvert != null ? Timestamp.valueOf(dateToConvert) : null;
    }

    public static int getDaysBetween(LocalDate localDate1, LocalDate localDate2) {
        return Integer.parseInt(String.valueOf(Math.abs(ChronoUnit.DAYS.between(localDate1, localDate2))));
    }

    public static int getDaysBetween(LocalDateTime localDate1, LocalDateTime localDate2) {
        return Integer.parseInt(String.valueOf(Math.abs(ChronoUnit.DAYS.between(localDate1, localDate2))));
    }

    public static Date removeTimeInfo(Date date) {
        if(date == null) {
            return null;
        }
        LocalDate localDate = convertToLocalDate(date);
        return convertToDate(LocalDate.of(localDate.getYear(), localDate.getMonth(), localDate.getDayOfMonth()));
    }

    public static Date adjustTimeInfo(Date date, int hour, int minute, int second, int nanoOfSecond) {
        if(date == null) {
            return null;
        }
        LocalDate localDate = convertToLocalDate(date);
        return convertToDate(LocalDateTime.of(localDate.getYear(), localDate.getMonth(), localDate.getDayOfMonth(), hour, minute, second, nanoOfSecond));
    }

}