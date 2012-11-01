package org.whole.lang.xsd.util;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Pattern;

import junit.framework.TestCase;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.tz.FixedDateTimeZone;
import org.whole.lang.codebase.StreamPersistenceProvider;
import org.whole.lang.operations.InterpreterOperation;
import org.whole.lang.parsers.DataTypeParsers;
import org.whole.lang.parsers.IDataTypeParser;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reflect.EntityDescriptorEnum;
import org.whole.lang.reflect.ILanguageKit;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.xsd.codebase.XsdPersistenceKit;
import org.whole.lang.xsd.model.Schema;
import org.whole.lang.xsd.parsers.SchemaDataTypeParsersTest;

public class XsiDateTimeUtilsTest extends TestCase {

	private static final String DATATYPES_URI = "http://lang.whole.org/XsdDatatypes";
	protected void setUp() throws Exception {
		ReflectionFactory.deployWholePlatform();
		InterpreterOperation.interpret(loadXsd("datatypes.xsd"));
	}

	private Schema loadXsd(String fileName) throws Exception {
		return (Schema) XsdPersistenceKit.instance().readModel(
				new StreamPersistenceProvider(getInputStream(fileName)));
	}

	private InputStream getInputStream(String fileName) {
		return SchemaDataTypeParsersTest.class.getResourceAsStream(fileName);
	}

	private static void assertEquals(IDataTypeParser dataTypeParser, DateTime base, EntityDescriptor<?> dateTime, String toParse, String toMatch) {
		DateTime jodaDateTime = DateTimeUtils.toDateTime(base, dataTypeParser.parse(dateTime, toParse));
		Date javaDate = DateTimeUtils.toDate(jodaDateTime);
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
		dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
		assertEquals(dateFormat.format(javaDate), toMatch);
	}

	public void testGregorianCalendar() {
		ILanguageKit languageKit = ReflectionFactory.getLanguageKit(DATATYPES_URI);
		EntityDescriptorEnum edEnum = languageKit.getEntityDescriptorEnum();
		IDataTypeParser dataTypeParser = languageKit.getDataTypeParser(DataTypeParsers.PERSISTENCE);

		EntityDescriptor<?> dateTime = edEnum.valueOf("XSDateTime");
		EntityDescriptor<?> date = edEnum.valueOf("XSDate");
		EntityDescriptor<?> time = edEnum.valueOf("XSTime");
		EntityDescriptor<?> gYearMonth = edEnum.valueOf("XSGYearMonth");

		DateTime base = new DateTime(2001, 1, 1, 11, 22, 33, 444, DateTimeZone.UTC);

		assertEquals(dataTypeParser, base, dateTime,		"1990-11-30T12:30:43.999Z",	"1990-11-30T12:30:43.999Z");
		assertEquals(dataTypeParser, base, dateTime,		"1990-11-30T12:30:43",		"1990-11-30T12:30:43.000Z");

		assertEquals(dataTypeParser, base, gYearMonth,		"1990-11",					"1990-11-01T11:22:33.444Z");
		assertEquals(dataTypeParser, base, date,			"1990-11-30",				"1990-11-30T11:22:33.444Z");
		assertEquals(dataTypeParser, base, date,			"1990-11-30Z",				"1990-11-30T00:00:00.000Z");
		assertEquals(dataTypeParser, base, date,			"1990-11-30+02:00",			"1990-11-29T22:00:00.000Z");

		assertEquals(dataTypeParser, base, time,			"12:30:43",					"2001-01-01T12:30:43.000Z");
		assertEquals(dataTypeParser, base, time,			"12:30:43.999Z",			"1970-01-01T12:30:43.999Z");
	}

	private static Pattern OFFSET_TIME_ZONE_PATTERN;
	public static TimeZone getTimeZone(DateTimeZone zone) {
		if (OFFSET_TIME_ZONE_PATTERN == null)
			OFFSET_TIME_ZONE_PATTERN = Pattern.compile("[-+]\\d\\d:\\d\\d");

		String zoneID = zone.getID();
		if (zone instanceof FixedDateTimeZone && OFFSET_TIME_ZONE_PATTERN.matcher(zoneID).matches())
			return TimeZone.getTimeZone("GMT"+zoneID);
		else
			return zone.toTimeZone();
	}

	public void testCalendarConversions() {
		DateTime jodaTime = new DateTime();

		GregorianCalendar gregorianCalendar = new GregorianCalendar(getTimeZone(jodaTime.getZone()));
		gregorianCalendar.setTime(jodaTime.toDate());
		assertEquals(gregorianCalendar, DateTimeUtils.toGregorianCalendar(jodaTime));
		
		Calendar calendar = Calendar.getInstance(getTimeZone(jodaTime.getZone()), Locale.getDefault());
		calendar.setTime(jodaTime.toDate());
		assertEquals(calendar, DateTimeUtils.toGregorianCalendar(jodaTime));
	}
}
