package com.baloise.open.util;

import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DateUtilTests {

    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

    String isoDatePattern = "yyyy-MM-dd'T'HH:mm:ss";
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(isoDatePattern);
    SimpleDateFormat localDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @Test
    void localDateTimeToDate() {
        LocalDateTime localDateTime = LocalDateTime.from(dateTimeFormatter.parse("2011-12-03T10:15:30"));

        Date d1 = DateUtil.convertToDate(localDateTime);

        assertEquals(simpleDateFormat.format(d1), dateTimeFormatter.format(localDateTime));
    }

    @Test
    void localDateToDate() {
        LocalDate localDate = LocalDate.from(dateTimeFormatter.parse("2011-12-03T10:15:30"));

        Date d1 = DateUtil.convertToDate(localDate);

        assertEquals(d1.toString(), localDate.toString());
    }

    @Test
    void dateToLocalDate() {
        Calendar cal = Calendar.getInstance();
        cal.set(2011, Calendar.DECEMBER, 24);
        Date date = cal.getTime();

        LocalDate localDate = DateUtil.convertToLocalDate(date);

        assertEquals(localDateFormat.format(date), localDate.toString());
    }

    @Test
    void dateToLocalDateWithFallback() {
        LocalDate localDateFallback = LocalDate.from(dateTimeFormatter.parse("2011-12-03T10:15:30"));

        LocalDate localDate = DateUtil.convertToLocalDate(null, localDateFallback);

        assertEquals(localDateFallback, localDate);
    }
}