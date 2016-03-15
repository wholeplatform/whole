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
/**
 * 
 */
package org.whole.lang.xsd.parsers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.whole.lang.exceptions.WholeIllegalArgumentException;
import org.whole.lang.parsers.DefaultDataTypePersistenceParser;
import org.whole.lang.parsers.IDataTypeParser;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.util.WholeMessages;

/**
 * @author Enrico Persiani
 */
public class XsiDefaultDataTypeParser extends DefaultDataTypePersistenceParser {
	public static final IDataTypeParser instance = new XsiDefaultDataTypeParser();
	public XsiDefaultDataTypeParser() {
	}

	private static final Pattern NORMALIZE_MATCHER = Pattern.compile("\\s*\\+?\\s*(.*)\\s*");
	protected String normalize(String value) {
		Matcher matcher = NORMALIZE_MATCHER.matcher(value);
		return matcher.matches() ? matcher.group(1) : value;
	}

	public Object parseObject(EntityDescriptor<?> ed, String value) {
		Class<?> dataType = ed.getDataType();
		
		try {
			return dataType.getConstructor(new Class[] { String.class }).newInstance(new Object[] { value });
		} catch (Exception e) {
			throw new WholeIllegalArgumentException(WholeMessages.no_data_type);
		}
	}
	public String unparseObject(EntityDescriptor<?> ed, Object value) {
		return String.valueOf(value);
	}

	public boolean parseBoolean(EntityDescriptor<?> ed, String value) {
		if ("true".equals(value) || "1".equals(value))
			return true;
		if ("false".equals(value) || "0".equals(value))
			return false;
		else
			throw new WholeIllegalArgumentException(WholeMessages.no_data_type);
	}

	public byte parseByte(EntityDescriptor<?> ed, String value) {
		return super.parseByte(ed, normalize(value));
	}

	public short parseShort(EntityDescriptor<?> ed, String value) {
		return super.parseShort(ed, normalize(value));
	}

	public int parseInt(EntityDescriptor<?> ed, String value) {
		return super.parseInt(ed, normalize(value));
	}

	public long parseLong(EntityDescriptor<?> ed, String value) {
		return super.parseLong(ed, normalize(value));
	}

	public double parseDouble(EntityDescriptor<?> ed, String value) {
		String normalizedValue = normalize(value);
		if ("-INF".equals(normalizedValue))
			return Double.NEGATIVE_INFINITY;
		else if ("INF".equals(normalizedValue))
			return Double.POSITIVE_INFINITY;
		else if (normalizedValue.endsWith("Infinity"))
			throw new WholeIllegalArgumentException(WholeMessages.no_data_type);
		else
			return super.parseDouble(ed, normalizedValue);
	}
	public String unparseDouble(EntityDescriptor<?> ed, double value) {
		if (Double.POSITIVE_INFINITY == value)
			return "INF";
		else if (Double.NEGATIVE_INFINITY == value)
			return "-INF";
		else if (Double.isNaN(value))
			return "NaN";
		else {
			String doubleString = super.unparseDouble(ed, value);
			return doubleString.indexOf('E') == -1 ? 
					doubleString+"E0" : doubleString;
		}
	}

	public float parseFloat(EntityDescriptor<?> ed, String value) {
		String normalizedValue = normalize(value);
		if ("-INF".equals(normalizedValue))
			return Float.NEGATIVE_INFINITY;
		else if ("INF".equals(normalizedValue))
			return Float.POSITIVE_INFINITY;
		else if (normalizedValue.endsWith("Infinity"))
			throw new WholeIllegalArgumentException(WholeMessages.no_data_type);
		else
			return super.parseFloat(ed, normalizedValue);
	}
	public String unparseFloat(EntityDescriptor<?> ed, float value) {
		if (Float.POSITIVE_INFINITY == value)
			return "INF";
		else if (Float.NEGATIVE_INFINITY == value)
			return "-INF";
		else if (Float.isNaN(value))
			return "NaN";
		else {
			String floatString = super.unparseFloat(ed, value);
			return floatString.indexOf('E') == -1 ?
					floatString+"E0" : floatString;
		}
	}

	public char parseChar(EntityDescriptor<?> ed, String value) {
		return super.parseChar(ed, value.trim());
	}
}