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

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.ReadableInstant;
import org.joda.time.ReadableInterval;
import org.joda.time.ReadablePartial;
import org.joda.time.chrono.ISOChronology;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.DateTimeParser;
import org.joda.time.format.DateTimeParserBucket;
import org.joda.time.tz.FixedDateTimeZone;
import org.whole.lang.exceptions.WholeIllegalArgumentException;
import org.whole.lang.parsers.FailureDataTypeParser;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.util.WholeMessages;

/**
 * @author Enrico Persiani
 */
public abstract class AbstractISO8601DataTypeParser extends FailureDataTypeParser {
	public static final DateTimeZone UTC = new FixedDateTimeZone("UTC", "UTC", 0, 0);
	private DateTimeFormatter formatter;

	public AbstractISO8601DataTypeParser(DateTimeFormatter formatter) {
		this.formatter = formatter;
	}

	public DateTimeFormatter getFormatter() {
		return formatter;
	}
	public void setFormatter(DateTimeFormatter formatter) {
		this.formatter = formatter;
	}

	protected abstract Object parseWithoutTimeZone(DateTimeParserBucket bucket);
	protected abstract Object parseWithTimeZone(DateTimeParserBucket bucket);

	public Object parseObject(EntityDescriptor<?> ed, String value) {
		DateTimeParser parser = getFormatter().getParser();
		DateTimeParserBucket bucket = new DateTimeParserBucket(0, ISOChronology.getInstance(), null);
		
		// use a custom UTC to check if offset part is parsed
		if (bucket.getZone() == null)
			bucket.setZone(UTC);

		if (parser.parseInto(bucket, value, 0) < 0)
			throw new WholeIllegalArgumentException(WholeMessages.no_data_type);

		DateTimeZone zone = bucket.getZone();
		if (zone == null)
			return parseWithTimeZone(bucket);
		else
			return parseWithoutTimeZone(bucket);
	}

	public String unparseObject(EntityDescriptor<?> ed, Object value) {
		if (value instanceof ReadablePartial)
			return getFormatter().print((ReadablePartial) value);
		else if (value instanceof ReadableInstant)
			return getFormatter().print((ReadableInstant) value);
		else if (value instanceof ReadableInterval) {
			DateTime start = ((ReadableInterval) value).getStart();
			return getFormatter().print(start);
		} else
			return String.valueOf(value);
	}
}
