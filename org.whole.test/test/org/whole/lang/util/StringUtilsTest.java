/**
 * Copyright 2004-2013 Riccardo Solmi. All rights reserved.
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
package org.whole.lang.util;

import java.text.ParseException;
import java.util.Date;

import junit.framework.TestCase;

public class StringUtilsTest extends TestCase {
	private static final int SECONDS_PER_MINUTE = 60;
	private static final int MILLIS_PER_SECONDS = 1000;
	private Date date;

	protected void setUp() throws Exception {
		super.setUp();
		date = new Date();
	}

	public void testISO8601DateFormatters() throws ParseException {
		String basicFormat = StringUtils.toBasicISO8601DateTime(date);
		Date basicDate = StringUtils.fromBasicISO8601DateTime(basicFormat);

		String extendedFormat = StringUtils.toExtendedISO8601DateTime(date);
		Date extendedDate = StringUtils.fromExtendedISO8601DateTime(extendedFormat);

		assertTrue(date.getTime() - basicDate.getTime() < (SECONDS_PER_MINUTE * MILLIS_PER_SECONDS));
		assertEquals(date.getTime(), extendedDate.getTime());
	}

	public void testToOrdinal() {
		try {
			StringUtils.toOrdinal(0);
			fail();
		} catch(IllegalArgumentException e) {}
		assertEquals("1st", StringUtils.toOrdinal(1));
		assertEquals("2nd", StringUtils.toOrdinal(2));
		assertEquals("3rd", StringUtils.toOrdinal(3));
		assertEquals("4th", StringUtils.toOrdinal(4));
		assertEquals("10th", StringUtils.toOrdinal(10));
		assertEquals("11th", StringUtils.toOrdinal(11));
		assertEquals("21st", StringUtils.toOrdinal(21));
	}
}
