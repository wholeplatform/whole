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

import java.math.BigInteger;
import java.util.regex.Pattern;

import org.whole.lang.parsers.FailureDataTypeParser;
import org.whole.lang.parsers.IDataTypeParser;
import org.whole.lang.reflect.EntityDescriptor;

/**
 * @author Riccardo Solmi, Enrico Persiani
 */
public class BigIntegerDataTypeParser extends FailureDataTypeParser {
	protected static final Pattern ZERO_PATTERN = Pattern.compile("[-+]0+");
	protected static final Pattern INTEGER_PATTERN = Pattern.compile("[-+]?\\d+");
	public static boolean isInteger(String input) {
		return INTEGER_PATTERN.matcher(input).matches();
	}

	private static IDataTypeParser unsignedLongDataTypeParser;
	public static IDataTypeParser unsignedLongDataTypeParser() {
		if (unsignedLongDataTypeParser == null)
			unsignedLongDataTypeParser = new BigIntegerDataTypeParser("0", "18446744073709551615");
		return unsignedLongDataTypeParser;
	}
	private static IDataTypeParser integerDataTypeParser;
	public static IDataTypeParser integerDataTypeParser() {
		if (integerDataTypeParser == null)
			integerDataTypeParser = new BigIntegerDataTypeParser(null, null);
		return integerDataTypeParser;
	}
	private static IDataTypeParser positiveIntegerDataTypeParser;
	public static IDataTypeParser positiveIntegerDataTypeParser() {
		if (positiveIntegerDataTypeParser == null)
			positiveIntegerDataTypeParser = new BigIntegerDataTypeParser("1", null);
		return positiveIntegerDataTypeParser;
	}
	private static IDataTypeParser negativeIntegerDataTypeParser;
	public static IDataTypeParser negativeIntegerDataTypeParser() {
		if (negativeIntegerDataTypeParser == null)
			negativeIntegerDataTypeParser = new BigIntegerDataTypeParser(null, "-1");
		return negativeIntegerDataTypeParser;
	}
	private static IDataTypeParser nonPositiveIntegerDataTypeParser;
	public static IDataTypeParser nonPositiveIntegerDataTypeParser() {
		if (nonPositiveIntegerDataTypeParser == null)
			nonPositiveIntegerDataTypeParser = new BigIntegerDataTypeParser(null, "0");
		return nonPositiveIntegerDataTypeParser;
	}
	private static IDataTypeParser nonNegativeIntegerDataTypeParser;
	public static IDataTypeParser nonNegativeIntegerDataTypeParser() {
		if (nonNegativeIntegerDataTypeParser == null)
			nonNegativeIntegerDataTypeParser = new BigIntegerDataTypeParser("0", null);
		return nonNegativeIntegerDataTypeParser;
	}

	protected final BigInteger minValue;
	protected final BigInteger maxValue;
	public BigIntegerDataTypeParser(String minValue, String maxValue) {
		this.minValue = minValue != null ? new BigInteger(minValue) : null;
		this.maxValue = maxValue != null ? new BigInteger(maxValue) : null;
	}
	public Object parseObject(EntityDescriptor<?> ed, String value) {
		if (!isInteger(value))
			throw new IllegalArgumentException("bad integer format");

		if (ZERO_PATTERN.matcher(value).matches())
			value = "0";

		BigInteger integer = new BigInteger(value.charAt(0) == '+' ? value.substring(1) : value);
		if ((minValue != null && integer.compareTo(minValue) < 0) ||
				(maxValue != null && integer.compareTo(maxValue) > 0))
			throw new IllegalArgumentException("bad integer format");
		return integer;
	}
	public String unparseObject(EntityDescriptor<?> ed, Object value) {
		return String.valueOf(value);
	}
}