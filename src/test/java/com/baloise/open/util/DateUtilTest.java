package com.baloise.open.util;

import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DateUtilTests {

    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

    String isoDatePattern = "yyyy-MM-dd'T'HH:mm:ss";
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(isoDatePattern);

    @Test
    void localDateTimeToDate() {
        LocalDateTime localDateTime = LocalDateTime.from(dateTimeFormatter.parse("2011-12-03T10:15:30"));

        Date d1 = DateUtil.convertToDate(localDateTime);

        assertEquals(simpleDateFormat.format(d1), dateTimeFormatter.format(localDateTime));
    }
}