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
package org.whole.lang.xsd.parsers;

import static org.whole.lang.xml.util.XmlUtils.LANGUAGE_PATTERN;
import static org.whole.lang.xml.util.XmlUtils.NAME_PATTERN;
import static org.whole.lang.xml.util.XmlUtils.NCNAME_PATTERN;
import static org.whole.lang.xml.util.XmlUtils.NMTOKEN_PATTERN;
import static org.whole.lang.xml.util.XmlUtils.NORMALIZED_STRING_PATTERN;
import static org.whole.lang.xml.util.XmlUtils.STRING_PATTERN;
import static org.whole.lang.xml.util.XmlUtils.TOKEN_PATTERN;
import static org.whole.lang.xml.util.XmlUtils.isDecimal;
import static org.whole.lang.xml.util.XmlUtils.isQName;
import static org.whole.lang.xml.util.XmlUtils.parseURI;

import java.io.IOException;
import java.io.Writer;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.joda.time.Chronology;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.Days;
import org.joda.time.Interval;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.joda.time.LocalTime;
import org.joda.time.Months;
import org.joda.time.MutablePeriod;
import org.joda.time.ReadableInterval;
import org.joda.time.ReadablePartial;
import org.joda.time.Years;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.DateTimeFormatterBuilder;
import org.joda.time.format.DateTimeParser;
import org.joda.time.format.DateTimeParserBucket;
import org.joda.time.format.DateTimePrinter;
import org.joda.time.format.ISODateTimeFormat;
import org.joda.time.format.PeriodFormatter;
import org.joda.time.format.PeriodFormatterBuilder;
import org.whole.lang.parsers.FailureDataTypeParser;
import org.whole.lang.parsers.IDataTypeParser;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.util.Base64Utils;
import org.whole.lang.xml.util.QName;

/**
 * @author Enrico Persiani
 */
public class SchemaDataTypeParsers {

	private static IDataTypeParser unsignedByteDataTypeParser;
	public static IDataTypeParser unsignedByte() {
		if (unsignedByteDataTypeParser == null) {
			unsignedByteDataTypeParser = new FailureDataTypeParser() {
				public short parseShort(EntityDescriptor<?> ed, String value) {
					short unsignedByte = Short.parseShort(value);
					if (unsignedByte < 0 || unsignedByte > 255)
						throw new IllegalArgumentException("range error");
					return unsignedByte;
				}
				public String unparseShort(EntityDescriptor<?> ed, short value) {
					return String.valueOf(value);
				}
			};
		}
		return unsignedByteDataTypeParser;
	}
	private static IDataTypeParser unsignedShortDataTypeParser;
	public static IDataTypeParser unsignedShort() {
		if (unsignedShortDataTypeParser == null) {
			unsignedShortDataTypeParser = new FailureDataTypeParser() {
				public int parseInt(EntityDescriptor<?> ed, String value) {
					int unsignedShort = Integer.parseInt(value);
					if (unsignedShort < 0 || unsignedShort > 65535)
						throw new IllegalArgumentException("range error");
					return unsignedShort;
				}
				public String unparseInt(EntityDescriptor<?> ed, int value) {
					return String.valueOf(value);
				}
			};
		}
		return unsignedShortDataTypeParser;
	}
	private static IDataTypeParser unsignedIntDataTypeParser;
	public static IDataTypeParser unsignedInt() {
		if (unsignedIntDataTypeParser == null) {
			unsignedIntDataTypeParser = new FailureDataTypeParser() {
				public long parseLong(EntityDescriptor<?> ed, String value) {
					long unsignedInt = Long.parseLong(value);
					if (unsignedInt < 0 || unsignedInt > 4294967295L)
						throw new IllegalArgumentException("range error");
					return unsignedInt;
				}
				public String unparseLong(EntityDescriptor<?> ed, long value) {
					return String.valueOf(value);
				}
			};
		}
		return unsignedIntDataTypeParser;
	}


	private static IDataTypeParser decimalDataTypeParser;
	public static IDataTypeParser decimal() {
		if (decimalDataTypeParser == null) {
			decimalDataTypeParser = new FailureDataTypeParser() {
				public Object parseObject(EntityDescriptor<?> ed, String value) {
					if (!isDecimal(value))
						throw new IllegalArgumentException("bad decimal format");
					return new BigDecimal(value);
				}
				public String unparseObject(EntityDescriptor<?> ed, Object value) {
					String decimal = ((BigDecimal) value).toPlainString();
					int index = decimal.length();
					if (decimal.indexOf('.') != -1)
						while (decimal.charAt(index-1) == '0' && decimal.charAt(index-2) != '.')
							index--;
					return decimal.substring(0, index);
				}
			};
		}
		return decimalDataTypeParser;
	}

	public static DateTimeFormatter createMillisFormatter() {
		return new DateTimeFormatterBuilder()
		.appendLiteral('.')
		.appendMillisOfSecond(3)
		.toFormatter();
	}

	private static final int TZ_UPPER = DateTimeZone.forOffsetHoursMinutes(14, 0).getOffset(0L);
	private static final int TZ_LOWER = DateTimeZone.forOffsetHoursMinutes(-14, 00).getOffset(0L);
	private static DateTimeZone validate(DateTimeZone zone) {
		int zoneMillis = zone.getOffset(0L);
		if (zoneMillis > TZ_UPPER || zoneMillis < TZ_LOWER)
			throw new IllegalArgumentException("bad time zone format");
		return zone;
	}
	private static DateTimeFormatter tzf; 
	public static DateTimeFormatter timeZoneFormatter() {
		if (tzf == null) {
			tzf = new DateTimeFormatterBuilder()
			.appendTimeZoneOffset("Z", true, 2, 4)
			.toFormatter();
		}
		return tzf;
	}

	private static DateTimeParser tp;
	private static DateTimeParser timeParser() {
		if (tp == null) {
			tp = new DateTimeFormatterBuilder()
			.appendHourOfDay(2)
			.appendLiteral(':')
			.appendMinuteOfHour(2)
			.appendLiteral(':')
			.appendSecondOfMinute(2)
			.appendOptional(createMillisFormatter().getParser())
			.appendOptional(new TimeZoneValidatingParser(timeZoneFormatter().getParser()))
			.toParser();
		}
		return tp;
	}
	private static DateTimePrinter tprt;
	private static DateTimePrinter timePrinter() {
		if (tprt == null) {
			tprt = new DateTimeFormatterBuilder()
			.appendHourOfDay(2)
			.appendLiteral(':')
			.appendMinuteOfHour(2)
			.appendLiteral(':')
			.appendSecondOfMinute(2)
			.append(MillisOfSecondDateTimePrinter.instance)
            .append(timeZoneFormatter().getPrinter())
			.toPrinter();
		}
		return tprt;
	}
	private static DateTimeFormatter time;
	public static DateTimeFormatter timeFormatter() {
		if (time == null) {
			time = new DateTimeFormatter(timePrinter(), timeParser())
			.withZone(DateTimeZone.UTC);
		}
		return time;
	}
	private static IDataTypeParser timeDataTypeParser;
	public static IDataTypeParser time() {
		if (timeDataTypeParser == null) {
			timeDataTypeParser = new AbstractISO8601DataTypeParser(timeFormatter()) {
				protected Object parseWithTimeZone(DateTimeParserBucket bucket) {
					DateTimeZone zone = DateTimeZone.forOffsetMillis(bucket.getOffset());
					return new DateTime(bucket.computeMillis(), validate(zone));
				}
				protected Object parseWithoutTimeZone(DateTimeParserBucket bucket) {
					return new LocalTime(bucket.computeMillis());
				}
			};
		}
		return timeDataTypeParser;
	}

	private static DateTimeParser dtp;
	private static DateTimeParser dateTimeParser() {
		if (dtp == null) {
			dtp = new DateTimeFormatterBuilder()
			.append(ISODateTimeFormat.date())
			.appendLiteral('T')
			.append(timeParser())
			.toParser();
		}
		return dtp;
	}
	private static DateTimePrinter dtprt;
	private static DateTimePrinter dateTimePrinter() {
		if (dtprt == null) {
			dtprt = new DateTimeFormatterBuilder()
			.append(ISODateTimeFormat.date())
			.appendLiteral('T')
			.append(timePrinter())
			.toPrinter();
		}
		return dtprt;
	}
	private static DateTimeFormatter dateTime;
	public static DateTimeFormatter dateTimeFormatter() {
		if (dateTime == null) {
			dateTime = new DateTimeFormatter(dateTimePrinter(), dateTimeParser())
			.withZone(DateTimeZone.UTC);
		}
		return dateTime;
	}
	private static IDataTypeParser dateTimeDataTypeParser;
	public static IDataTypeParser dateTime() {
		if (dateTimeDataTypeParser == null) {
			dateTimeDataTypeParser = new AbstractISO8601DataTypeParser(dateTimeFormatter()) {
				protected Object parseWithTimeZone(DateTimeParserBucket bucket) {
					DateTimeZone zone = DateTimeZone.forOffsetMillis(bucket.getOffset());
					return new DateTime(bucket.computeMillis(), validate(zone));
				}
				protected Object parseWithoutTimeZone(DateTimeParserBucket bucket) {
					return new LocalDateTime(bucket.computeMillis());
				}
			};
		}
		return dateTimeDataTypeParser;
	}

	private static DateTimeParser dp;
	private static DateTimeParser dateParser() {
		if (dp == null) {
			dp = new DateTimeFormatterBuilder()
			.append(ISODateTimeFormat.date())
			.appendOptional(new TimeZoneValidatingParser(timeZoneFormatter().getParser()))
			.toParser();
		}
		return dp;
	}
	private static DateTimePrinter dprt;
	private static DateTimePrinter datePrinter() {
		if (dprt == null) {
			dprt = 	new DateTimeFormatterBuilder()
			.append(ISODateTimeFormat.date())
			.append(timeZoneFormatter())
			.toPrinter();
		}
		return dprt;
	}
	private static DateTimeFormatter date;
	public static DateTimeFormatter dateFormatter() {
		if (date == null) {
			date = new DateTimeFormatter(datePrinter(), dateParser())
			.withZone(DateTimeZone.UTC);
		}
		return date;
	}
	private static final int TZ_REC_UPPER_MILLIS = DateTimeZone.forOffsetHoursMinutes(12, 0).getOffset(0L);
	private static final int TZ_REC_LOWER_MILLIS = DateTimeZone.forOffsetHoursMinutes(-12, 00).getOffset(0L);
	private static final int H24 = TZ_REC_UPPER_MILLIS-TZ_REC_LOWER_MILLIS;

	private static IDataTypeParser dateDataTypeParser;
	public static IDataTypeParser date() {
		if (dateDataTypeParser == null) {
			dateDataTypeParser = new AbstractISO8601DataTypeParser(dateFormatter()) {
				protected Object parseWithTimeZone(DateTimeParserBucket bucket) {
					DateTimeZone zone = DateTimeZone.forOffsetMillis(bucket.getOffset());
					return new Interval(new DateTime(bucket.computeMillis(), validate(zone)), Days.ONE);
				}
				protected Object parseWithoutTimeZone(DateTimeParserBucket bucket) {
					return new LocalDate(bucket.computeMillis());
				}
				@Override
				public String unparseObject(EntityDescriptor<?> ed, Object value) {
					if (value instanceof ReadableInterval) {
						// make use of recoverable time zones
						DateTime start = ((ReadableInterval) value).getStart();
						int millisOffset = start.getZone().getOffset(0L);
						DateTimeZone zone = DateTimeZone.forOffsetMillis(
								millisOffset > TZ_REC_UPPER_MILLIS ? millisOffset-H24 :
									 (millisOffset <= TZ_REC_LOWER_MILLIS ?
										millisOffset+H24 : millisOffset));
						return getFormatter().withZone(zone).print(start);
					} else
						return super.unparseObject(ed, value);
				}
			};
		}
		return dateDataTypeParser;
	}

	private static PeriodFormatter duration;
	public static PeriodFormatter durationFormatter() {
		if (duration == null) {
			duration = new PeriodFormatterBuilder()
			.rejectSignedValues(true)
			.appendLiteral("P")
			.appendYears()
			.appendSuffix("Y")
			.appendMonths()
			.appendSuffix("M")
			.appendWeeks()
			.appendSuffix("W")
			.appendDays()
			.appendSuffix("D")
			.appendSeparatorIfFieldsAfter("T")
			.appendHours()
			.appendSuffix("H")
			.appendMinutes()
			.appendSuffix("M")
			.appendSecondsWithOptionalMillis()
			.appendSuffix("S")
			.toFormatter();
		}
		return duration;
	}
	private static IDataTypeParser durationDataTypeParser;
	public static IDataTypeParser duration() {
		if (durationDataTypeParser == null) {
			durationDataTypeParser = new FailureDataTypeParser() {
				public Object parseObject(EntityDescriptor<?> ed, String value) {
					if (value.startsWith("-")) {
						MutablePeriod period = durationFormatter().parseMutablePeriod(value.substring(1));
						for (int i=0, size=period.size(); i<size; i++)
							period.setValue(i, -period.getValue(i));
						return period;
					} else
						return durationFormatter().parseMutablePeriod(value);
				}

				public String unparseObject(EntityDescriptor<?> ed, Object value) {
					if (value instanceof MutablePeriod) {
						MutablePeriod period = (MutablePeriod) value;
						int i=0;
						boolean isNegative = false;
						for (int size=period.size(); i<size; i++) {
							int n = period.getValue(i);
							if (n != 0) {
								isNegative = n < 0;
								break;
							}
						}

						if (isNegative) {
							for (int size=period.size(); i<size; i++) {
								int n = period.getValue(i);
								if (n>0)
									 throw new IllegalArgumentException("bad duration format");
								period.setValue(i, -n);
							}
						}
						return (isNegative ? "-" : "") + durationFormatter().print(period);
					} else
						return String.valueOf(value);
				}
			};
		}
		return durationDataTypeParser;
	}

	private static DateTimeParser ymp;
	private static DateTimeParser yearMonthParser() {
		if (ymp == null) {
			ymp = new DateTimeFormatterBuilder()
			.append(ISODateTimeFormat.yearMonth())
			.appendOptional(new TimeZoneValidatingParser(timeZoneFormatter().getParser()))
			.toParser();
		}
		return ymp;
	}
	private static DateTimePrinter ymprt;
	private static DateTimePrinter yearMonthPrinter() {
		if (ymprt == null) {
			ymprt = 	new DateTimeFormatterBuilder()
			.append(ISODateTimeFormat.yearMonth())
			.append(timeZoneFormatter())
			.toPrinter();
		}
		return ymprt;
	}
	private static DateTimeFormatter yearMonth;
	public static DateTimeFormatter yearMonthFormatter() {
		if (yearMonth == null)
			yearMonth = new DateTimeFormatter(yearMonthPrinter(), yearMonthParser());
		return yearMonth;
	}
	private static IDataTypeParser yearMonthDataTypeParser;
	public static IDataTypeParser yearMonth() {
		if (yearMonthDataTypeParser == null) {
			yearMonthDataTypeParser = new AbstractISO8601DataTypeParser(yearMonthFormatter()) {
				protected Object parseWithTimeZone(DateTimeParserBucket bucket) {
					DateTimeZone zone = DateTimeZone.forOffsetMillis(bucket.getOffset());
					return new Interval(new DateTime(bucket.computeMillis(), validate(zone)), Months.ONE);
				}
				protected Object parseWithoutTimeZone(DateTimeParserBucket bucket) {
					return new LocalDate(bucket.computeMillis());
				}
			};
		}
		return yearMonthDataTypeParser;
	}

	private static DateTimeParser yp;
	private static DateTimeParser yearParser() {
		if (yp == null) {
			yp = new DateTimeFormatterBuilder()
			.append(ISODateTimeFormat.year())
			.appendOptional(new TimeZoneValidatingParser(timeZoneFormatter().getParser()))
			.toParser();
		}
		return yp;
	}
	private static DateTimePrinter yprt;
	private static DateTimePrinter yearPrinter() {
		if (yprt == null) {
			yprt = 	new DateTimeFormatterBuilder()
			.append(ISODateTimeFormat.year())
			.append(timeZoneFormatter())
			.toPrinter();
		}
		return yprt;
	}
	private static DateTimeFormatter year;
	public static DateTimeFormatter yearFormatter() {
		if (year == null)
			year = new DateTimeFormatter(yearPrinter(), yearParser())
		.withOffsetParsed();
		return year;
	}
	private static IDataTypeParser yearDataTypeParser;
	public static IDataTypeParser year() {
		if (yearDataTypeParser == null) {
			yearDataTypeParser = new AbstractISO8601DataTypeParser(yearFormatter()) {
				protected Object parseWithTimeZone(DateTimeParserBucket bucket) {
					DateTimeZone zone = DateTimeZone.forOffsetMillis(bucket.getOffset());
					return new Interval(new DateTime(bucket.computeMillis(), validate(zone)), Years.ONE);
				}
				protected Object parseWithoutTimeZone(DateTimeParserBucket bucket) {
					return new LocalDate(bucket.computeMillis());
				}
			};
		}
		return yearDataTypeParser;
	}

	private static DateTimeParser mdp;
	private static DateTimeParser monthDayParser() {
		if (mdp == null) {
			mdp = new DateTimeFormatterBuilder()
			.appendLiteral("--")
			.appendMonthOfYear(2)
			.appendLiteral('-')
			.appendDayOfMonth(2)
			.appendOptional(new TimeZoneValidatingParser(timeZoneFormatter().getParser()))
			.toParser();
		}
		return mdp;
	}
	private static DateTimePrinter mdprt;
	private static DateTimePrinter monthDayPrinter() {
		if (mdprt == null) {
			mdprt = new DateTimeFormatterBuilder()
			.appendLiteral("--")
			.appendMonthOfYear(2)
			.appendLiteral('-')
			.appendDayOfMonth(2)
			.append(timeZoneFormatter())
			.toPrinter();
		}
		return mdprt;
	}
	private static DateTimeFormatter monthDay;
	public static DateTimeFormatter monthDayFormatter() {
		if (monthDay == null)
			monthDay = new DateTimeFormatter(monthDayPrinter(), monthDayParser());
		return monthDay;
	}
	private static IDataTypeParser monthDayDataTypeParser;
	public static IDataTypeParser monthDay() {
		if (monthDayDataTypeParser == null) {
			monthDayDataTypeParser = new AbstractISO8601DataTypeParser(monthDayFormatter()) {
				protected Object parseWithTimeZone(DateTimeParserBucket bucket) {
					DateTimeZone zone = DateTimeZone.forOffsetMillis(bucket.getOffset());
					return new Interval(new DateTime(bucket.computeMillis(), validate(zone)), Days.ONE);
				}
				protected Object parseWithoutTimeZone(DateTimeParserBucket bucket) {
					return new LocalDate(bucket.computeMillis());
				}
			};
		}
		return monthDayDataTypeParser;
	}

	private static DateTimeParser mp;
	private static DateTimeParser monthParser() {
		if (mp == null) {
			mp = new DateTimeFormatterBuilder()
			.appendLiteral("--")
			.appendMonthOfYear(2)
			.appendOptional(new TimeZoneValidatingParser(timeZoneFormatter().getParser()))
			.toParser();
		}
		return mp;
	}
	private static DateTimePrinter mprt;
	private static DateTimePrinter monthPrinter() {
		if (mprt == null) {
			mprt = new DateTimeFormatterBuilder()
			.appendLiteral("--")
			.appendMonthOfYear(2)
			.append(timeZoneFormatter())
			.toPrinter();
		}
		return mprt;
	}
	private static DateTimeFormatter month;
	public static DateTimeFormatter monthFormatter() {
		if (month == null)
			month = new DateTimeFormatter(monthPrinter(), monthParser());
		return month;
	}
	private static IDataTypeParser monthDataTypeParser;
	public static IDataTypeParser month() {
		if (monthDataTypeParser == null) {
			monthDataTypeParser = new AbstractISO8601DataTypeParser(monthFormatter()) {
				protected Object parseWithTimeZone(DateTimeParserBucket bucket) {
					DateTimeZone zone = DateTimeZone.forOffsetMillis(bucket.getOffset());
					return new Interval(new DateTime(bucket.computeMillis(), validate(zone)), Months.ONE);
				}
				protected Object parseWithoutTimeZone(DateTimeParserBucket bucket) {
					return new LocalDate(bucket.computeMillis());
				}
			};
		}
		return monthDataTypeParser;
	}

	private static DateTimeParser dyp;
	private static DateTimeParser dayParser() {
		if (dyp == null) {
			dyp = new DateTimeFormatterBuilder()
			.appendLiteral("---")
			.appendDayOfMonth(2)
			.appendOptional(new TimeZoneValidatingParser(timeZoneFormatter().getParser()))
			.toParser();
		}
		return dyp;
	}
	private static DateTimePrinter dyprt;
	private static DateTimePrinter dayPrinter() {
		if (dyprt == null) {
			dyprt = new DateTimeFormatterBuilder()
			.appendLiteral("---")
			.appendDayOfMonth(2)
			.append(timeZoneFormatter())
			.toPrinter();
		}
		return dyprt;
	}
	private static DateTimeFormatter day;
	public static DateTimeFormatter dayFormatter() {
		if (day == null)
			day = new DateTimeFormatter(dayPrinter(), dayParser());
		return day;
	}
	private static IDataTypeParser dayDataTypeParser;
	public static IDataTypeParser day() {
		if (dayDataTypeParser == null) {
			dayDataTypeParser = new AbstractISO8601DataTypeParser(dayFormatter()) {
				protected Object parseWithTimeZone(DateTimeParserBucket bucket) {
					DateTimeZone zone = DateTimeZone.forOffsetMillis(bucket.getOffset());
					return new Interval(new DateTime(bucket.computeMillis(), validate(zone)), Days.ONE);
				}
				protected Object parseWithoutTimeZone(DateTimeParserBucket bucket) {
					return new LocalDate(bucket.computeMillis());
				}
			};
		}
		return dayDataTypeParser;
	}

	private static IDataTypeParser base64BinaryDataTypeParser;
	public static IDataTypeParser base64Binary() {
		if (base64BinaryDataTypeParser == null) {
			base64BinaryDataTypeParser = new FailureDataTypeParser() {
				public Object parseObject(EntityDescriptor<?> ed, String value) {
					return Base64Utils.decode(value);
				}
				public String unparseObject(EntityDescriptor<?> ed, Object value) {
					return Base64Utils.encode((byte[]) value);
				}
			};
		}
		return base64BinaryDataTypeParser;
	}
	private static IDataTypeParser hexBinaryDataTypeParser;
	public static IDataTypeParser hexBinary() {
		if (hexBinaryDataTypeParser == null) {
			hexBinaryDataTypeParser = new FailureDataTypeParser() {
				public Object parseObject(EntityDescriptor<?> ed, String value) {
					if (value.length() % 2 != 0)
						throw new IllegalArgumentException("bad hexadecimal format");
					return new BigInteger(value, 16).toByteArray();
				}
				public String unparseObject(EntityDescriptor<?> ed, Object value) {
					return new BigInteger((byte[]) value).toString(16);
				}
			};
		}
		return hexBinaryDataTypeParser;
	}

	private static IDataTypeParser anyURIDataTypeParser;
	public static IDataTypeParser anyURI() {
		if (anyURIDataTypeParser == null) {
			anyURIDataTypeParser = new FailureDataTypeParser() {
				public String parseString(EntityDescriptor<?> ed, String value) {
					parseURI(value);
					return value;
				}
				public String unparseString(EntityDescriptor<?> ed, String value) {
					return value;
				}
			};
		}
		return anyURIDataTypeParser;
	}
	
	private static IDataTypeParser qnameDataTypeParser;
	public static IDataTypeParser qname() {
		if (qnameDataTypeParser == null) {
			qnameDataTypeParser = new FailureDataTypeParser() {
				public Object parseObject(EntityDescriptor<?> ed, String value) {
					if (!isQName(value))
						throw new IllegalArgumentException("bad qname");
					int index = value.indexOf(':');
					return QName.create(null, value.substring(index+1), value.substring(0, index));
				}
				public String unparseObject(EntityDescriptor<?> ed, Object value) {
					QName qname = (QName) value;
					return qname.getPrefix()+':'+qname.getLocalPart();
				}
			};
		}
		return qnameDataTypeParser;
	}

	private static IDataTypeParser stringDataTypeParser;
	public static IDataTypeParser string() {
		if (stringDataTypeParser == null)
			stringDataTypeParser = new PatternValidatingDataTypeParser(STRING_PATTERN);
		return stringDataTypeParser;
	}
	private static IDataTypeParser normalizedStringDataTypeParser;
	public static IDataTypeParser normalizedString() {
		if (normalizedStringDataTypeParser == null)
			normalizedStringDataTypeParser = new PatternValidatingDataTypeParser(NORMALIZED_STRING_PATTERN);
		return normalizedStringDataTypeParser;
	}
	private static IDataTypeParser tokenDataTypeParser;
	public static IDataTypeParser token() {
		if (tokenDataTypeParser == null)
			tokenDataTypeParser = new PatternValidatingDataTypeParser(TOKEN_PATTERN);
		return tokenDataTypeParser;
	}
	private static IDataTypeParser languageDataTypeParser;
	public static IDataTypeParser language() {
		if (languageDataTypeParser == null)
			languageDataTypeParser = new PatternValidatingDataTypeParser(LANGUAGE_PATTERN);
		return languageDataTypeParser;
	}
	private static IDataTypeParser nameDataTypeParser;
	public static IDataTypeParser name() {
		if (nameDataTypeParser == null)
			nameDataTypeParser = new PatternValidatingDataTypeParser(NAME_PATTERN);
		return nameDataTypeParser;
	}
	private static IDataTypeParser nmtokenDataTypeParser;
	public static IDataTypeParser nmtoken() {
		if (nmtokenDataTypeParser == null)
			nmtokenDataTypeParser = new PatternValidatingDataTypeParser(NMTOKEN_PATTERN);
		return nmtokenDataTypeParser;
	}
	private static IDataTypeParser ncnameDataTypeParser;
	public static IDataTypeParser ncname() {
		if (ncnameDataTypeParser == null)
			ncnameDataTypeParser = new PatternValidatingDataTypeParser(NCNAME_PATTERN);
		return ncnameDataTypeParser;
	}

	public static class PatternValidatingDataTypeParser extends FailureDataTypeParser {
		protected final Pattern pattern;
		public PatternValidatingDataTypeParser(Pattern pattern) {
			this.pattern = pattern;
		}
		@Override
		public String parseString(EntityDescriptor<?> ed, String value) {
			if (!pattern.matcher(value).matches())
				throw new IllegalArgumentException("bad format"); 
			return value;
		}
		@Override
		public String unparseString(EntityDescriptor<?> ed, String value) {
			return value;
		}
	}
	public static class TimeZoneValidatingParser implements DateTimeParser {
		private static final Pattern TZ_PATTERN = Pattern.compile("[-+](\\d\\d):(\\d\\d)");
		protected DateTimeParser timeZoneParser;
		public TimeZoneValidatingParser(DateTimeParser timeZoneParser) {
			this.timeZoneParser = timeZoneParser;
		}
		public int estimateParsedLength() {
			return timeZoneParser.estimateParsedLength();
		}
		public int parseInto(DateTimeParserBucket bucket, String text, int position) {
			int state = timeZoneParser.parseInto(bucket, text, position);

			Matcher matcher = TZ_PATTERN.matcher(text.subSequence(position, text.length()));
			if (matcher.matches() && Integer.valueOf(matcher.group(1)+matcher.group(2))>1400)
				throw new IllegalArgumentException("timezone out of range");

			return state;
		}
	}
	public static class MillisOfSecondDateTimePrinter implements DateTimePrinter {
		public static final  DateTimePrinter instance = new MillisOfSecondDateTimePrinter();

		protected DateTimePrinter printer;
		protected MillisOfSecondDateTimePrinter() {
			printer = new DateTimeFormatterBuilder()
			.appendLiteral('.')
            .appendFractionOfSecond(0, 3)
			.toPrinter();
		}

		public int estimatePrintedLength() {
			return printer.estimatePrintedLength();
		}
		public void printTo(StringBuffer buf, long instant, Chronology chrono, int displayOffset, DateTimeZone displayZone, Locale locale) {
			if (instant % 1000 != 0)
				printer.printTo(buf, instant, chrono, displayOffset, displayZone, locale);
		}
		public void printTo(StringBuffer buf, ReadablePartial partial, Locale locale) {
			long instant = partial.getChronology().set(partial, 0L);
			if (instant % 1000 != 0)
				printer.printTo(buf, partial, locale);
		}
		public void printTo(Writer out, long instant, Chronology chrono, int displayOffset, DateTimeZone displayZone, Locale locale) throws IOException {
			if (instant % 1000 != 0)
				printer.printTo(out, instant, chrono, displayOffset, displayZone, locale);
		}
		public void printTo(Writer out, ReadablePartial partial, Locale locale) throws IOException {
			long instant = partial.getChronology().set(partial, 0L);
			if (instant % 1000 != 0)
				printer.printTo(out, partial, locale);
		}
	}
}
