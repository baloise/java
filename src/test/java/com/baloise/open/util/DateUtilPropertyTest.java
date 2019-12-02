package com.baloise.open.util;

import net.jqwik.api.Disabled;
import net.jqwik.api.Example;
import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.constraints.LongRange;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

public class DateUtilPropertyTest {
	private String isoDatePattern = "yyyy-MM-dd'T'HH:mm:ss";
	private DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
	private SimpleDateFormat simpleDateFormat = new SimpleDateFormat(isoDatePattern);

	// simpleDateFormat.parse("2019-04-01T00:00:01").getTime(); // 1554069601000
	private final long T_2019_04_01 = 1554069600000L; // "2019-04-01T00:00:01"
	private final long T_2019_10_01 = 1569880801000L; // "2019-10-01T00:00:01

	@Example
	void developmentHelpers() throws ParseException {
		long from = simpleDateFormat.parse("2019-04-01T00:00:01").getTime(); // 1554069601000
		long to = simpleDateFormat.parse("2019-10-01T00:00:01").getTime(); // 1569880801000
	}

	@Property
	void absoluteValueOfAllNumbersIsPositive(@ForAll @LongRange(min = T_2019_04_01, max = T_2019_10_01) long aLong ) {
		assertThat(DateUtil.convertToDate(DateUtil.convertToLocalDateTime(new java.util.Date(aLong))).getTime()).isEqualTo(aLong);
	}

}
