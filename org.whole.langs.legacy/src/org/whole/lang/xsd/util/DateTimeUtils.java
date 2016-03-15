/**
 * Copyright 2004-2016 Riccardo Solmi. All rights reserved.
 * This file is part of the Whole Platform.
 *
 * The Whole Platform is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * The Whole Platform is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with the Whole Platform. If not, see <http://www.gnu.org/licenses/>.
 */
package org.whole.lang.xsd.util;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import org.joda.time.DateTime;
import org.joda.time.Interval;
import org.joda.time.ReadablePartial;

/**
 * @author Enrico Persiani
 */
public class DateTimeUtils {
	public static GregorianCalendar toGregorianCalendar(Object jodaTime) {
		return toDateTime(jodaTime).toGregorianCalendar();
	}

	public static Calendar toCalendar(Object jodaTime, Locale locale) {
		return toDateTime(jodaTime).toCalendar(locale);
	}

	public static Date toDate(Object jodaTime) {
		return toDateTime(jodaTime).toDate();
	}

	public static DateTime toDateTime(Object jodaTime) {
		// use default locale/timezone and get actual instant
		return toDateTime(new DateTime(), jodaTime);
	}

	public static DateTime toDateTime(DateTime base, Object jodaTime) {
		if (jodaTime instanceof ReadablePartial) {
			return ((ReadablePartial) jodaTime).toDateTime(base);
		} else if (jodaTime instanceof Interval) {
			return ((Interval) jodaTime).getStart();
		} else if (jodaTime instanceof DateTime) {
			return (DateTime) jodaTime;
		} else
			throw new IllegalArgumentException("Not a date/time");
	}
}
