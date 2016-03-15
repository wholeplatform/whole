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


import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.whole.lang.xsd.parsers.BigIntegerDataTypeParser.integerDataTypeParser;
import static org.whole.lang.xsd.parsers.BigIntegerDataTypeParser.negativeIntegerDataTypeParser;
import static org.whole.lang.xsd.parsers.BigIntegerDataTypeParser.nonNegativeIntegerDataTypeParser;
import static org.whole.lang.xsd.parsers.BigIntegerDataTypeParser.nonPositiveIntegerDataTypeParser;
import static org.whole.lang.xsd.parsers.BigIntegerDataTypeParser.positiveIntegerDataTypeParser;
import static org.whole.lang.xsd.parsers.BigIntegerDataTypeParser.unsignedLongDataTypeParser;
import static org.whole.lang.xsd.parsers.SchemaDataTypeParsers.anyURI;
import static org.whole.lang.xsd.parsers.SchemaDataTypeParsers.base64Binary;
import static org.whole.lang.xsd.parsers.SchemaDataTypeParsers.date;
import static org.whole.lang.xsd.parsers.SchemaDataTypeParsers.dateTime;
import static org.whole.lang.xsd.parsers.SchemaDataTypeParsers.day;
import static org.whole.lang.xsd.parsers.SchemaDataTypeParsers.decimal;
import static org.whole.lang.xsd.parsers.SchemaDataTypeParsers.duration;
import static org.whole.lang.xsd.parsers.SchemaDataTypeParsers.hexBinary;
import static org.whole.lang.xsd.parsers.SchemaDataTypeParsers.language;
import static org.whole.lang.xsd.parsers.SchemaDataTypeParsers.month;
import static org.whole.lang.xsd.parsers.SchemaDataTypeParsers.monthDay;
import static org.whole.lang.xsd.parsers.SchemaDataTypeParsers.name;
import static org.whole.lang.xsd.parsers.SchemaDataTypeParsers.ncname;
import static org.whole.lang.xsd.parsers.SchemaDataTypeParsers.nmtoken;
import static org.whole.lang.xsd.parsers.SchemaDataTypeParsers.normalizedString;
import static org.whole.lang.xsd.parsers.SchemaDataTypeParsers.qname;
import static org.whole.lang.xsd.parsers.SchemaDataTypeParsers.string;
import static org.whole.lang.xsd.parsers.SchemaDataTypeParsers.time;
import static org.whole.lang.xsd.parsers.SchemaDataTypeParsers.token;
import static org.whole.lang.xsd.parsers.SchemaDataTypeParsers.unsignedByte;
import static org.whole.lang.xsd.parsers.SchemaDataTypeParsers.unsignedInt;
import static org.whole.lang.xsd.parsers.SchemaDataTypeParsers.unsignedShort;
import static org.whole.lang.xsd.parsers.SchemaDataTypeParsers.year;
import static org.whole.lang.xsd.parsers.SchemaDataTypeParsers.yearMonth;

import org.junit.Test;
import org.whole.lang.parsers.IDataTypeParser;

/**
 * @author Enrico Persiani
 */
public class SchemaDataTypeParsersTest {

	@Test
	public void testTime() throws Exception {
		// test time zone canonicalization
		String timeString = "12:00:00";
		Object time = time().parseObject(null, timeString);
		assertEquals("12:00:00", time().unparseObject(null, time));

		// test fraction seconds canonicalization
		timeString = "12:00:00.120";
		time = time().parseObject(null, timeString);
		assertEquals("12:00:00.12", time().unparseObject(null, time));

		// test fraction seconds removal
		timeString = "12:00:00.000";
		time = time().parseObject(null, timeString);
		assertEquals("12:00:00", time().unparseObject(null, time));
	}

	@Test
	public void testTimeTZ() throws Exception {
		// test time zone canonicalization
		String timeString = "12:00:00-05:00";
		Object time = time().parseObject(null, timeString);
		assertEquals("17:00:00Z", time().unparseObject(null, time));

		// test fraction seconds canonicalization
		timeString = "12:00:00.120-00:00";
		time = time().parseObject(null, timeString);
		assertEquals("12:00:00.12Z", time().unparseObject(null, time));

		// test fraction seconds removal
		timeString = "12:00:00.000-00:00";
		time = time().parseObject(null, timeString);
		assertEquals("12:00:00Z", time().unparseObject(null, time));

		try {
			// test out of range time zone
			timeString = "12:00:00.000-14:01";
			time = time().parseObject(null, timeString);
			fail();
		} catch (Exception e) { }
	}

	@Test
	public void testDateTime() throws Exception {
		// test time zone canonicalization
		String dateTimeString = "2002-10-10T12:00:00";
		Object dateTime = dateTime().parseObject(null, dateTimeString);
		assertEquals("2002-10-10T12:00:00", dateTime().unparseObject(null, dateTime));

		// test fraction seconds canonicalization
		dateTimeString = "2002-10-10T12:00:00.120";
		dateTime = dateTime().parseObject(null, dateTimeString);
		assertEquals("2002-10-10T12:00:00.12", dateTime().unparseObject(null, dateTime));

		// test fraction seconds removal
		dateTimeString = "2002-10-10T12:00:00.000";
		dateTime = dateTime().parseObject(null, dateTimeString);
		assertEquals("2002-10-10T12:00:00", dateTime().unparseObject(null, dateTime));

		// test negative years
		dateTimeString = "-2002-10-10T12:00:00";
		dateTime = dateTime().parseObject(null, dateTimeString);
		assertEquals("-2002-10-10T12:00:00", dateTime().unparseObject(null, dateTime));
}

	@Test
	public void testDateTimeTZ() throws Exception {
		// test time zone canonicalization
		String dateTimeString = "2002-10-10T12:00:00-05:00";
		Object dateTime = dateTime().parseObject(null, dateTimeString);
		assertEquals("2002-10-10T17:00:00Z", dateTime().unparseObject(null, dateTime));

		// test fraction seconds canonicalization
		dateTimeString = "2002-10-10T12:00:00.120-00:00";
		dateTime = dateTime().parseObject(null, dateTimeString);
		assertEquals("2002-10-10T12:00:00.12Z", dateTime().unparseObject(null, dateTime));

		// test fraction seconds removal
		dateTimeString = "2002-10-10T12:00:00.000-00:00";
		dateTime = dateTime().parseObject(null, dateTimeString);
		assertEquals("2002-10-10T12:00:00Z", dateTime().unparseObject(null, dateTime));

		// test negative years
		dateTimeString = "-2002-10-10T12:00:00-00:00";
		dateTime = dateTime().parseObject(null, dateTimeString);
		assertEquals("-2002-10-10T12:00:00Z", dateTime().unparseObject(null, dateTime));

		try {
			// test out of range time zone
			dateTimeString = "-2002-10-10T12:00:00-14:30";
			dateTime = dateTime().parseObject(null, dateTimeString);
			fail();
		} catch (Exception e) { }

	}

	@Test
	public void testDate() throws Exception {
		// test date parsing
		String dateString = "2002-10-10";
		Object date = date().parseObject(null, dateString);
		assertEquals("2002-10-10", date().unparseObject(null, date));
	}

	@Test
	public void testDateTZ() throws Exception {
		// test no time zone canonicalization
		String dateString = "2000-12-12+05:00";
		Object date = date().parseObject(null, dateString);
		assertEquals("2000-12-12+05:00", date().unparseObject(null, date));

		// test time zone additive canonicalization
		dateString = "2000-12-12-13:00";
		date = date().parseObject(null, dateString);
		assertEquals("2000-12-13+11:00", date().unparseObject(null, date));

		// test time zone subtractive canonicalization
		dateString = "2000-12-12+13:00";
		date = date().parseObject(null, dateString);
		assertEquals("2000-12-11-11:00", date().unparseObject(null, date));

		try {
			// test out of range time zone
			dateString = "2000-12-12+15:00";
			date = date().parseObject(null, dateString);
			fail();
		} catch (Exception e) { }
	}

	@Test
	public void testDuration() throws Exception {
		// test simple years duration
		String durationString = "P1347Y";
		Object duration = duration().parseObject(null, durationString);
		assertEquals("P1347Y", duration().unparseObject(null, duration));

		// test simple months duration
		durationString = "P1347M";
		duration = duration().parseObject(null, durationString);
		assertEquals("P1347M", duration().unparseObject(null, duration));

		// test compound duration
		durationString = "P1Y2MT2H";
		duration = duration().parseObject(null, durationString);
		assertEquals("P1Y2MT2H", duration().unparseObject(null, duration));

		// test compound duration with zero valued years field
		durationString = "P0Y1347M";
		duration = duration().parseObject(null, durationString);
		assertEquals("P1347M", duration().unparseObject(null, duration));

		// test compound duration with zero valued years, days fields
		durationString = "P0Y1347M0D";
		duration = duration().parseObject(null, durationString);
		assertEquals("P1347M", duration().unparseObject(null, duration));

		// test negative simple duration
		durationString = "-P1347M";
		duration = duration().parseObject(null, durationString);
		assertEquals("-P1347M", duration().unparseObject(null, duration));

		// test negative compound duration
		durationString = "-P2Y1347M";
		duration = duration().parseObject(null, durationString);
		assertEquals("-P2Y1347M", duration().unparseObject(null, duration));

		try {
			// test malformed compound duration
			durationString = "P1Y2MT";
			duration = duration().parseObject(null, durationString);
			fail();
		} catch (Exception e) { }

		try {
			// test malformed negative duration
			durationString = "P-1347M";
			duration = duration().parseObject(null, durationString);
			fail();
		} catch (Exception e) { }
	}

	@Test
	public void testYearMonth() throws Exception {
		// test periodic year month
		String yearMonthString = "-1999-05";
		Object yearMonth = yearMonth().parseObject(null, yearMonthString);
		assertEquals("-1999-05", yearMonth().unparseObject(null, yearMonth));

		// test periodic year month with late years
		yearMonthString = "10071-05";
		yearMonth = yearMonth().parseObject(null, yearMonthString);
		assertEquals("10071-05", yearMonth().unparseObject(null, yearMonth));

		// test periodic year month with time zone
		yearMonthString = "1071-05+05:00";
		yearMonth = yearMonth().parseObject(null, yearMonthString);
		assertEquals("1071-05+05:00", yearMonth().unparseObject(null, yearMonth));

		try {
			// test malformed time zone in periodic year month
			yearMonthString = "10071-05+14:01";
			yearMonth = yearMonth().parseObject(null, yearMonthString);
			fail();
		} catch (Exception e) { }
	}

	@Test
	public void testMonthDay() throws Exception {
		// test periodic month day
		String monthDayString = "--11-02";
		Object monthDay = monthDay().parseObject(null, monthDayString);
		assertEquals("--11-02", monthDay().unparseObject(null, monthDay));

		// test periodic month day with time zone
		monthDayString = "--11-02+11:00";
		monthDay = monthDay().parseObject(null, monthDayString);
		assertEquals("--11-02+11:00", monthDay().unparseObject(null, monthDay));

		try {
			// test leap periodic month day
			monthDayString = "--02-29";
			monthDay = monthDay().parseObject(null, monthDayString);
		} catch (Exception e) { }
		
		try {
			// test malformed time zone in periodic month day
			monthDayString = "--11-02+18:00";
			monthDay = monthDay().parseObject(null, monthDayString);
			fail();
		} catch (Exception e) { }
	}

	@Test
	public void testYear() throws Exception {
		// test periodic year
		String yearString = "-1999";
		Object year = year().parseObject(null, yearString);
		assertEquals("-1999", year().unparseObject(null, year));

		// test periodic year with late years
		yearString = "10071";
		year = year().parseObject(null, yearString);
		assertEquals("10071", year().unparseObject(null, year));

		// test periodic year with time zone
		yearString = "1071+05:00";
		year = year().parseObject(null, yearString);
		assertEquals("1071+05:00", year().unparseObject(null, year));

		try {
			// test malformed time zone in periodic year
			yearString = "10071+25:00";
			year = year().parseObject(null, yearString);
			fail();
		} catch (Exception e) { }
	}

	@Test
	public void testMonth() throws Exception {
		// test periodic month
		String monthString = "--11";
		Object month = month().parseObject(null, monthString);
		assertEquals("--11", month().unparseObject(null, month));

		// test periodic month with time zone
		monthString = "--11+05:00";
		month = month().parseObject(null, monthString);
		assertEquals("--11+05:00", month().unparseObject(null, month));

		try {
			// test malformed time zone in periodic month
			monthString = "--11-14:10";
			month = month().parseObject(null, monthString);
			fail();
		} catch (Exception e) { }
	}

	@Test
	public void testDay() throws Exception {
		// test periodic day
		String dayString = "---31";
		Object day = day().parseObject(null, dayString);
		assertEquals("---31", day().unparseObject(null, day));

		// test periodic day with time zone
		dayString = "---31+05:00";
		day = day().parseObject(null, dayString);
		assertEquals("---31+05:00", day().unparseObject(null, day));

		try {
			// test malformed time zone in periodic day
			dayString = "---31-25:00";
			day = day().parseObject(null, dayString);
			fail();
		} catch (Exception e) { }
	}

	@Test
	public void testAnyURI() throws Exception {
		// test URLs
		String urlString = "http://www.w3.org/XML/1998/namespace";
		String uri = anyURI().parseString(null, urlString);
		assertEquals(urlString, anyURI().unparseString(null, uri));

		urlString = "http://www.w3.org/2001/XMLSchema";
		uri = anyURI().parseString(null, urlString);
		assertEquals(urlString, anyURI().unparseString(null, uri));

		urlString = "http://www.w3.org/2001/XMLSchema-instance";
		uri = anyURI().parseString(null, urlString);
		assertEquals(urlString, anyURI().unparseString(null, uri));

		// test URNs
		String urnString = "urn:S2SDDSdf:xsd:$MPEDDSdfBlkDirDeb";
		uri = anyURI().parseString(null, urnString);
		assertEquals(urnString, anyURI().unparseString(null, uri));

		urnString = "urn:iso:std:iso:20022:tech:xsd:pacs.003.001.01";
		uri = anyURI().parseString(null, urnString);
		assertEquals(urnString, anyURI().unparseString(null, uri));

		// test LEIRIs
		String iriString = "http://xn--99zt52a.example.org/<e2><80><ae>";
		uri = anyURI().parseString(null, iriString);
		assertEquals(iriString, anyURI().unparseString(null, uri));
	}

	@Test
	public void testBinaries() throws Exception {
		// get some bytes
		byte[] buffer = new byte[128];
		getClass().getResourceAsStream("datatypes.xml").read(buffer);

		// test base64 encoding
		String base64 = base64Binary().unparseObject(null, buffer);
		assertArrayEquals(buffer, (byte[]) base64Binary().parseObject(null, base64));

		// test failure of base64 encoding
		try {
			base64Binary().parseObject(null, base64.substring(1));
			fail();
		} catch (Exception e) { }

		// test hex encoding
		String hex = hexBinary().unparseObject(null, buffer);
		assertArrayEquals(buffer, (byte[]) hexBinary().parseObject(null, hex));

		// test failure of hex encoding
		try {
			hexBinary().parseObject(null, hex.substring(1));
			fail();
		} catch (Exception e) { }
	}

	@Test
	public void testQname() throws Exception {
		// test simple qname
		String qnameString = "xs:name";
		Object qname = qname().parseObject(null, qnameString);
		assertEquals(qnameString, qname().unparseObject(null, qname));

		// test qname with exotic chars
		qnameString = "xs:n\u0300a\u0923m\u0453e";
		qname = qname().parseObject(null, qnameString);
		assertEquals(qnameString, qname().unparseObject(null, qname));

		// test some failing cases
		try {
			qname().parseObject(null, "xs:name:");
			fail();
		} catch (Exception e) { }
		try {
			qname().parseObject(null, "xsname:");
			fail();
		} catch (Exception e) { }
		try {
			qname().parseObject(null, "xsname");
			fail();
		} catch (Exception e) { }

		// U+300 can't be used as starting char of an NCName 
		try {
			qname().parseObject(null, "xs:\u0300name");
			fail();
		} catch (Exception e) { }
	}

	@Test
	public void testDecimal() throws Exception {
		// test simple decimal
		String decimalString = "-238.0659846";
		Object decimal = decimal().parseObject(null, decimalString);
		assertEquals(decimalString, decimal().unparseObject(null, decimal));

		// test decimal canonicalization
		decimalString = "+0000.10000000000000";
		decimal = decimal().parseObject(null, decimalString);
		assertEquals("0.1", decimal().unparseObject(null, decimal));

		// test decimal without exponent part
		decimalString = "-0.0000000000000000000001";
		decimal = decimal().parseObject(null, decimalString);
		assertEquals(decimalString, decimal().unparseObject(null, decimal));

		// test failures
		try {
			decimalString = "-1E89";
			decimal = decimal().parseObject(null, decimalString);
			fail();
		} catch (Exception e) { }
		try {
			decimalString = "-237326aae8437";
			decimal = decimal().parseObject(null, decimalString);
			fail();
		} catch (Exception e) { }
	}

	@Test
	public void testIntegers() throws Exception {
		// test simple integer
		String integerString = "-23839480284209384023842934802302394802394";
		Object integer = integerDataTypeParser().parseObject(null, integerString);
		assertEquals(integerString, integerDataTypeParser().unparseObject(null, integer));

		// test integer canonicalization
		integerString = "+0000000000000000000000000011123132";
		integer = integerDataTypeParser().parseObject(null, integerString);
		assertEquals("11123132", integerDataTypeParser().unparseObject(null, integer));

		integerString = "-0";
		integer = integerDataTypeParser().parseObject(null, integerString);
		assertEquals("0", integerDataTypeParser().unparseObject(null, integer));

		// test failures
		try {
			integerString = "+80284.10000000000000";
			integer = integerDataTypeParser().parseObject(null, integerString);
			fail();
		} catch (Exception e) { }
		try {
			integerString = "+8028gf000000000";
			integer = integerDataTypeParser().parseObject(null, integerString);
			fail();
		} catch (Exception e) { }

		// test positiveInteger limits
		integerString = "+0072109480438509855032984032984098209843289034";
		integer = positiveIntegerDataTypeParser().parseObject(null, integerString);
		assertEquals("72109480438509855032984032984098209843289034", positiveIntegerDataTypeParser().unparseObject(null, integer));
		try {
			integerString = "+0";
			integer = positiveIntegerDataTypeParser().parseObject(null, integerString);
			fail();
		} catch (Exception e) { }

		// test nonNegativeInteger limits
		integerString = "-0";
		integer = nonNegativeIntegerDataTypeParser().parseObject(null, integerString);
		assertEquals("0", nonNegativeIntegerDataTypeParser().unparseObject(null, integer));
		try {
			integerString = "-1";
			integer = nonNegativeIntegerDataTypeParser().parseObject(null, integerString);
			fail();
		} catch (Exception e) { }

		// test negativeInteger limits
		integerString = "-0072109480438509855032984032984098209843289034";
		integer = negativeIntegerDataTypeParser().parseObject(null, integerString);
		assertEquals("-72109480438509855032984032984098209843289034", negativeIntegerDataTypeParser().unparseObject(null, integer));
		try {
			integerString = "-0";
			integer = negativeIntegerDataTypeParser().parseObject(null, integerString);
			fail();
		} catch (Exception e) { }

		// test nonPositiveInteger limits
		integerString = "+0";
		integer = nonPositiveIntegerDataTypeParser().parseObject(null, integerString);
		assertEquals("0", nonPositiveIntegerDataTypeParser().unparseObject(null, integer));
		try {
			integerString = "1";
			integer = nonPositiveIntegerDataTypeParser().parseObject(null, integerString);
			fail();
		} catch (Exception e) { }
	}

	@Test
	public void testBoolean() throws Exception {
		IDataTypeParser dtp = XsiDefaultDataTypeParser.instance;

		// test boolean
		String boolString = "true";
		boolean bValue = dtp.parseBoolean(null, boolString);
		assertEquals("true", dtp.unparseBoolean(null, bValue));

		boolString = "1";
		bValue = dtp.parseBoolean(null, boolString);
		assertEquals("true", dtp.unparseBoolean(null, bValue));

		boolString = "false";
		bValue = dtp.parseBoolean(null, boolString);
		assertEquals("false", dtp.unparseBoolean(null, bValue));

		boolString = "0";
		bValue = dtp.parseBoolean(null, boolString);
		assertEquals("false", dtp.unparseBoolean(null, bValue));

		try {
			dtp.parseBoolean(null, "False");
			fail();
		} catch (Exception e) { }
		try {
			dtp.parseBoolean(null, "TRUE");
			fail();
		} catch (Exception e) { }
	}

	@Test
	public void testByte() throws Exception {
		IDataTypeParser dtp = XsiDefaultDataTypeParser.instance;

		// test primitives
		assertEquals("-128", dtp.unparseByte(null, dtp.parseByte(null, "-128")));
		assertEquals("127", dtp.unparseByte(null, dtp.parseByte(null, "127")));
		try {
			dtp.parseByte(null, "128");
			fail();
		} catch (Exception e) { }
		try {
			dtp.parseByte(null, "-129");
			fail();
		} catch (Exception e) { }
	}

	@Test
	public void testUnsignedByte() throws Exception {
		// test primitives
		assertEquals("0", unsignedByte().unparseShort(null, unsignedByte().parseShort(null, "0")));
		assertEquals("255", unsignedByte().unparseShort(null, unsignedByte().parseShort(null, "255")));
		try {
			unsignedByte().parseShort(null, "256");
			fail();
		} catch (Exception e) { }
		try {
			unsignedByte().parseShort(null, "-1");
			fail();
		} catch (Exception e) { }
	}

	@Test
	public void testShort() throws Exception {
		IDataTypeParser dtp = XsiDefaultDataTypeParser.instance;

		// test primitives
		assertEquals("-32768", dtp.unparseShort(null, dtp.parseShort(null, "-32768")));
		assertEquals("32767", dtp.unparseShort(null, dtp.parseShort(null, "32767")));
		try {
			dtp.parseShort(null, "32768");
			fail();
		} catch (Exception e) { }
		try {
			dtp.parseShort(null, "-32769");
			fail();
		} catch (Exception e) { }
	}

	@Test
	public void testUnsignedShort() throws Exception {
		// test primitives
		assertEquals("0", unsignedShort().unparseInt(null, unsignedShort().parseInt(null, "0")));
		assertEquals("65535", unsignedShort().unparseInt(null, unsignedShort().parseInt(null, "65535")));
		try {
			unsignedShort().parseInt(null, "65536");
			fail();
		} catch (Exception e) { }
		try {
			unsignedShort().parseInt(null, "-1");
			fail();
		} catch (Exception e) { }
	}

	@Test
	public void testInt() throws Exception {
		IDataTypeParser dtp = XsiDefaultDataTypeParser.instance;

		// test primitives
		assertEquals("-2147483648", dtp.unparseInt(null, dtp.parseInt(null, "-2147483648")));
		assertEquals("2147483647", dtp.unparseInt(null, dtp.parseInt(null, "2147483647")));
		try {
			dtp.parseInt(null, "2147483648");
			fail();
		} catch (Exception e) { }
		try {
			dtp.parseInt(null, "-2147483649");
			fail();
		} catch (Exception e) { }
	}

	@Test
	public void testUnsignedInt() throws Exception {
		// test primitives
		assertEquals("0", unsignedInt().unparseLong(null, unsignedInt().parseLong(null, "0")));
		assertEquals("4294967295", unsignedInt().unparseLong(null, unsignedInt().parseLong(null, "4294967295")));
		try {
			unsignedInt().parseLong(null, "4294967296");
			fail();
		} catch (Exception e) { }
		try {
			unsignedInt().parseLong(null, "-1");
			fail();
		} catch (Exception e) { }
	}

	@Test
	public void testLong() throws Exception {
		IDataTypeParser dtp = XsiDefaultDataTypeParser.instance;

		// test primitives
		assertEquals("-9223372036854775808", dtp.unparseLong(null, dtp.parseLong(null, "-9223372036854775808")));
		assertEquals("9223372036854775807", dtp.unparseLong(null, dtp.parseLong(null, "9223372036854775807")));
		try {
			dtp.parseLong(null, "9223372036854775808");
			fail();
		} catch (Exception e) { }
		try {
			dtp.parseLong(null, "-9223372036854775809");
			fail();
		} catch (Exception e) { }
	}

	@Test
	public void testUnsignedLong() throws Exception {
		// test primitives
		assertEquals("0", unsignedLongDataTypeParser().unparseObject(null, unsignedLongDataTypeParser().parseObject(null, "0")));
		assertEquals("18446744073709551615", unsignedLongDataTypeParser().unparseObject(null, unsignedLongDataTypeParser().parseObject(null, "18446744073709551615")));
		try {
			unsignedLongDataTypeParser().parseObject(null, "18446744073709551616");
			fail();
		} catch (Exception e) { }
		try {
			unsignedLongDataTypeParser().parseObject(null, "-1");
			fail();
		} catch (Exception e) { }
	}

	@Test
	public void testFloat() throws Exception {
		IDataTypeParser dtp = XsiDefaultDataTypeParser.instance;

		// test float
		String floatString = "-12.78e+28";
		float fValue = dtp.parseFloat(null, floatString);
		assertEquals("-1.278E29", dtp.unparseFloat(null, fValue));
		
		floatString = "+1267.43233E12";
		fValue = dtp.parseFloat(null, floatString);
		assertEquals("1.26743237E15", dtp.unparseFloat(null, fValue));
		
		floatString = "0";
		fValue = dtp.parseFloat(null, floatString);
		assertEquals("0.0E0", dtp.unparseFloat(null, fValue));
		
		assertEquals("INF", dtp.unparseFloat(null, Float.POSITIVE_INFINITY));
		assertEquals("-INF", dtp.unparseFloat(null, Float.NEGATIVE_INFINITY));
		assertEquals("NaN", dtp.unparseFloat(null, Float.NaN));

		try {
			dtp.parseFloat(null, "123,456");
			fail();
		} catch (Exception e) { }
		try {
			dtp.parseFloat(null, "1000FFFF");
			fail();
		} catch (Exception e) { }
	}

	@Test
	public void testDouble() throws Exception {
		IDataTypeParser dtp = XsiDefaultDataTypeParser.instance;

		// test double
		String doubleString = "-12.789438023842092304e+28";
		double dValue = dtp.parseDouble(null, doubleString);
		assertEquals("-1.2789438023842093E29", dtp.unparseDouble(null, dValue));
		
		doubleString = "+1267.789438023842092304928437987423982E12";
		dValue = dtp.parseDouble(null, doubleString);
		assertEquals("1.267789438023842E15", dtp.unparseDouble(null, dValue));
		
		doubleString = "00000000.000000";
		dValue = dtp.parseDouble(null, doubleString);
		assertEquals("0.0E0", dtp.unparseDouble(null, dValue));
		
		assertEquals("INF", dtp.unparseDouble(null, Double.POSITIVE_INFINITY));
		assertEquals("-INF", dtp.unparseDouble(null, Double.NEGATIVE_INFINITY));
		assertEquals("NaN", dtp.unparseDouble(null, Double.NaN));

		try {
			dtp.parseDouble(null, "123,456");
			fail();
		} catch (Exception e) { }
		try {
			dtp.parseDouble(null, "1000FFFF");
			fail();
		} catch (Exception e) { }
	}


	@Test
	public void testString() throws Exception {
		String string = "\n\n\n   hello    \tworld\n\r!!!   ";
		assertEquals(string, string().unparseString(null, string().parseString(null, string)));

		try {
			string().parseString(null, "invalid chars: \u001F\u0005");
			fail();
		} catch (Exception e) { }
	}

	@Test
	public void testNormalizedString() throws Exception {
		String normalizedString = "     hello    world    !!! ";
		assertEquals(normalizedString, normalizedString().unparseString(null, normalizedString().parseString(null, normalizedString)));

		try {
			normalizedString().parseString(null, "\n\n\n   hello    \tworld\n\r!!!   ");
			fail();
		} catch (Exception e) { }
	}

	@Test
	public void testToken() throws Exception {
		String token = "hello world !!!";
		assertEquals(token, token().unparseString(null, token().parseString(null, token)));

		try {
			token().parseString(null, "hello  world !!!");
			fail();
		} catch (Exception e) { }
	}
	
	@Test
	public void testLanguage() throws Exception {
		assertEquals("en", language().unparseString(null, language().parseString(null, "en")));
		assertEquals("mas", language().unparseString(null, language().parseString(null, "mas")));
		assertEquals("fr-CA", language().unparseString(null, language().parseString(null, "fr-CA")));
		assertEquals("es-419", language().unparseString(null, language().parseString(null, "es-419")));
		assertEquals("zh-Hans", language().unparseString(null, language().parseString(null, "zh-Hans")));

		try {
			language().parseString(null, "alpenladino");
			fail();
		} catch (Exception e) { }
	}

	
	@Test
	public void testName() throws Exception {
		assertEquals(":name99", name().unparseString(null, name().parseString(null, ":name99")));
		assertEquals("_tag", name().unparseString(null, name().parseString(null, "_tag")));

		try {
			name().parseString(null, "9inches");
			fail();
		} catch (Exception e) { }
	}

	@Test
	public void testNMToken() throws Exception {
		assertEquals("9:inches", nmtoken().unparseString(null, nmtoken().parseString(null, "9:inches")));

		try {
			nmtoken().parseString(null, "9 inches");
			fail();
		} catch (Exception e) { }
	}

	@Test
	public void testNCName() throws Exception {
		assertEquals("name99", ncname().unparseString(null, ncname().parseString(null, "name99")));

		try {
			ncname().parseString(null, "name99:");
			fail();
		} catch (Exception e) { }
	}
}
