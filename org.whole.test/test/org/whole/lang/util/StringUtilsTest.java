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
package org.whole.lang.util;

import java.text.ParseException;
import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StringUtilsTest {
	private static final int SECONDS_PER_MINUTE = 60;
	private static final int MILLIS_PER_SECONDS = 1000;
	private Date date;

	@Before
	public void setUp() throws Exception {
		date = new Date();
	}

	@Test
	public void testISO8601DateFormatters() throws ParseException {
		String basicFormat = StringUtils.toBasicISO8601DateTime(date);
		Date basicDate = StringUtils.fromBasicISO8601DateTime(basicFormat);

		String extendedFormat = StringUtils.toExtendedISO8601DateTime(date);
		Date extendedDate = StringUtils.fromExtendedISO8601DateTime(extendedFormat);

		Assert.assertTrue(date.getTime() - basicDate.getTime() < (SECONDS_PER_MINUTE * MILLIS_PER_SECONDS));
		Assert.assertEquals(date.getTime(), extendedDate.getTime());
	}

	@Test
	public void testToOrdinal() {
		try {
			StringUtils.toOrdinal(0);
			Assert.fail();
		} catch(IllegalArgumentException e) {}
		Assert.assertEquals("1st", StringUtils.toOrdinal(1));
		Assert.assertEquals("2nd", StringUtils.toOrdinal(2));
		Assert.assertEquals("3rd", StringUtils.toOrdinal(3));
		Assert.assertEquals("4th", StringUtils.toOrdinal(4));
		Assert.assertEquals("10th", StringUtils.toOrdinal(10));
		Assert.assertEquals("11th", StringUtils.toOrdinal(11));
		Assert.assertEquals("21st", StringUtils.toOrdinal(21));
	}
}
