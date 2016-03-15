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
package org.whole.lang.parsers;

import java.util.Date;

import org.whole.lang.exceptions.WholeIllegalArgumentException;
import org.whole.lang.model.EnumType;
import org.whole.lang.model.EnumValue;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.util.StringUtils;
import org.whole.lang.util.WholeMessages;

/**
 * @author Riccardo Solmi
 */
public class DefaultDataTypePersistenceParser extends FailureDataTypeParser {
	public static final IDataTypeParser instance = new DefaultDataTypePersistenceParser();
	protected DefaultDataTypePersistenceParser() {
	}

	public boolean parseBoolean(EntityDescriptor<?> ed, String value) {
		if ("true".equalsIgnoreCase(value))
			return true;
		if ("false".equalsIgnoreCase(value))
			return false;
		else
			throw new WholeIllegalArgumentException(WholeMessages.no_data_type);
	}
	public byte parseByte(EntityDescriptor<?> ed, String value) {
		try {
			return Byte.parseByte(value);
		} catch (NumberFormatException e) {
			throw new WholeIllegalArgumentException(WholeMessages.no_data_type);
		}
	}
	public char parseChar(EntityDescriptor<?> ed, String value) {
		if (value.length() > 1)
			throw new WholeIllegalArgumentException(WholeMessages.no_data_type);
			
		try {
			return value.charAt(0);
		} catch (IndexOutOfBoundsException e) {
			throw new WholeIllegalArgumentException(WholeMessages.no_data_type);
		}
	}
	public double parseDouble(EntityDescriptor<?> ed, String value) {
		try {
			return Double.parseDouble(value);
		} catch (NumberFormatException e) {
			throw new WholeIllegalArgumentException(WholeMessages.no_data_type);
		}
	}
	public float parseFloat(EntityDescriptor<?> ed, String value) {
		try {
			return Float.parseFloat(value);
		} catch (NumberFormatException e) {
			throw new WholeIllegalArgumentException(WholeMessages.no_data_type);
		}
	}
	public int parseInt(EntityDescriptor<?> ed, String value) {
		try {
			return Integer.parseInt(value);
		} catch (NumberFormatException e) {
			throw new WholeIllegalArgumentException(WholeMessages.no_data_type);
		}
	}
	public long parseLong(EntityDescriptor<?> ed, String value) {
		try {
			return Long.parseLong(value);
		} catch (NumberFormatException e) {
			throw new WholeIllegalArgumentException(WholeMessages.no_data_type);
		}
	}
	public short parseShort(EntityDescriptor<?> ed, String value) {
		try {
			return Short.parseShort(value);
		} catch (NumberFormatException e) {
			throw new WholeIllegalArgumentException(WholeMessages.no_data_type);
		}
	}
	public String parseString(EntityDescriptor<?> ed, String value) {
		return value;
	}
	public Date parseDate(EntityDescriptor<?> ed, String value) {
		return StringUtils.fromExtendedISO8601DateTime(value);
	}
	public EnumValue parseEnumValue(EntityDescriptor<?> ed, String value) {
		EnumType<?> dataEnumType = ed.getDataEnumType();
		if (dataEnumType == null)
			throw new WholeIllegalArgumentException(WholeMessages.no_data_type);
		
		EnumValue result = dataEnumType.valueOf(value);
		if (result == null)
			throw new WholeIllegalArgumentException(WholeMessages.no_data_type);
		
		return result;
	}
	public Object parseObject(EntityDescriptor<?> ed, String value) {
		if (value.length() == 0)
			return null;
		try {
			return ed.getDataType().getConstructor(
					new Class[] { String.class }).newInstance(
							new Object[] { value });
		} catch (Exception e) {
			throw new WholeIllegalArgumentException(WholeMessages.no_data_type);
		}
	}

	public String unparseBoolean(EntityDescriptor<?> ed, boolean value) {
		return Boolean.toString(value);
	}
	public String unparseByte(EntityDescriptor<?> ed, byte value) {
		return Byte.toString(value);
	}
	public String unparseChar(EntityDescriptor<?> ed, char value) {
		return Character.toString(value);
	}
	public String unparseDouble(EntityDescriptor<?> ed, double value) {
		return Double.toString(value);
	}
	public String unparseFloat(EntityDescriptor<?> ed, float value) {
		return Float.toString(value);
	}
	public String unparseInt(EntityDescriptor<?> ed, int value) {
		return Integer.toString(value);
	}
	public String unparseLong(EntityDescriptor<?> ed, long value) {
		return Long.toString(value);
	}
	public String unparseShort(EntityDescriptor<?> ed, short value) {
		return Short.toString(value);
	}
	public String unparseString(EntityDescriptor<?> ed, String value) {
		return value;
	}
	public String unparseDate(EntityDescriptor<?> ed, Date value) {
		return StringUtils.toExtendedISO8601DateTime(value);
	}
	public String unparseEnumValue(EntityDescriptor<?> ed, EnumValue value) {
		return value.getName();
	}
	public String unparseObject(EntityDescriptor<?> ed, Object value) {
		return value == null ? "" : value.toString();
	}
}
