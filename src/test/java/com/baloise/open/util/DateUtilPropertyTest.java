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

	@Example
	void developmentHelpers() throws ParseException {
		long from = simpleDateFormat.parse("2019-04-01T00:00:01").getTime(); // 1554069601000
		long to = simpleDateFormat.parse("2019-10-01T00:00:01").getTime(); // 1569880801000
		System.out.println("from = " + from);
		System.out.println("to = " + to);
		System.out.println(simpleDateFormat.format(new Date(1554069600000L)));
		System.out.println(simpleDateFormat.format(new Date(1554069601000L)));
	}

	@Property
	@Disabled("not working yet")
	void absoluteValueOfAllNumbersIsPositive(@ForAll @LongRange(min = 1554069601000L, max = 1569880801000L) long aLong ) {
		assertThat(DateUtil.convertToDate(DateUtil.convertToLocalDate(new java.util.Date(aLong))).getTime()).isEqualTo(aLong);
	}

}
