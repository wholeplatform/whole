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
import org.whole.lang.model.EnumValue;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.util.WholeMessages;

/**
 * @author Riccardo Solmi
 */
public class FailureDataTypeParser implements IDataTypeParser {
	public static final IDataTypeParser instance = new FailureDataTypeParser();

	public static boolean canApply(IDataTypeParser parser, EntityDescriptor<?> ed) {
		return !instance.equals(parser.getStrategy(ed));
	}
	
	public static Object parseUsing(EntityDescriptor<?> ed, String value, IDataTypeParser parser) {
		switch (ed.getDataKind()) {
		case NOT_A_DATA:
			throw new WholeIllegalArgumentException(WholeMessages.no_data);			
		case BOOLEAN:
			return parser.parseBoolean(ed, value);
		case BYTE:
			return parser.parseByte(ed, value);
		case CHAR:
			return parser.parseChar(ed, value);
		case DOUBLE:
			return parser.parseDouble(ed, value);
		case FLOAT:
			return parser.parseFloat(ed, value);
		case INT:
			return parser.parseInt(ed, value);
		case LONG:
			return parser.parseLong(ed, value);
		case SHORT:
			return parser.parseShort(ed, value);
		case STRING:
			return parser.parseString(ed, value);
		case DATE:
			return parser.parseDate(ed, value);
		case ENUM_VALUE:
			return parser.parseEnumValue(ed, value);
		case OBJECT:
		default:
			return parser.parseObject(ed, value);
		}
	}
	public static String unparseUsing(EntityDescriptor<?> ed, Object value, IDataTypeParser parser) {
		try {
			switch (ed.getDataKind()) {
			case NOT_A_DATA:
				throw new WholeIllegalArgumentException(WholeMessages.no_data);
			case BOOLEAN:
				return parser.unparseBoolean(ed, ((Boolean) value).booleanValue());
			case BYTE:
				if (value instanceof Integer)
					return parser.unparseByte(ed, ((Integer) value).byteValue());
				else
					return parser.unparseByte(ed, ((Byte) value).byteValue());
			case CHAR:
				if (value instanceof Integer)
					return parser.unparseChar(ed, (char) ((Integer) value).intValue());
				else
					return parser.unparseChar(ed, ((Character) value).charValue());
			case DOUBLE:
				return parser.unparseDouble(ed, ((Double) value).doubleValue());
			case FLOAT:
				return parser.unparseFloat(ed, ((Float) value).floatValue());
			case INT:
				return parser.unparseInt(ed, ((Integer) value).intValue());
			case LONG:
				return parser.unparseLong(ed, ((Long) value).longValue());
			case SHORT:
				if (value instanceof Integer)
					return parser.unparseShort(ed, ((Integer) value).shortValue());
				else
					return parser.unparseShort(ed, ((Short) value).shortValue());
			case STRING:
				return parser.unparseString(ed, (String) value);
			case DATE:
				return parser.unparseDate(ed, (Date) value);
			case ENUM_VALUE:
				return parser.unparseEnumValue(ed, (EnumValue) value);
			case OBJECT:
			default:
				return parser.unparseObject(ed, value);
			}
		} catch (ClassCastException e) {
			throw new WholeIllegalArgumentException(WholeMessages.no_data_type);
		}
	}

	public void setStrategy(IDataTypeParser strategy) {
		throw new UnsupportedOperationException();
	}
	public IDataTypeParser getStrategy() {
		return this;
	}
	public IDataTypeParser getStrategy(EntityDescriptor<?> ed) {
		return this;
	}

	public Object parse(EntityDescriptor<?> ed, String value) {
		return parseUsing(ed, value, this);
	}

	public String unparse(EntityDescriptor<?> ed, Object value) {
		return unparseUsing(ed, value, this);
	}

	public boolean parseBoolean(EntityDescriptor<?> ed, String value) {
		throw new WholeIllegalArgumentException(WholeMessages.no_data_type);
	}

	public byte parseByte(EntityDescriptor<?> ed, String value) {
		throw new WholeIllegalArgumentException(WholeMessages.no_data_type);
	}

	public char parseChar(EntityDescriptor<?> ed, String value) {
		throw new WholeIllegalArgumentException(WholeMessages.no_data_type);
	}

	public Date parseDate(EntityDescriptor<?> ed, String value) {
		throw new WholeIllegalArgumentException(WholeMessages.no_data_type);
	}

	public double parseDouble(EntityDescriptor<?> ed, String value) {
		throw new WholeIllegalArgumentException(WholeMessages.no_data_type);
	}

	public EnumValue parseEnumValue(EntityDescriptor<?> ed, String value) {
		throw new WholeIllegalArgumentException(WholeMessages.no_data_type);
	}

	public float parseFloat(EntityDescriptor<?> ed, String value) {
		throw new WholeIllegalArgumentException(WholeMessages.no_data_type);
	}

	public int parseInt(EntityDescriptor<?> ed, String value) {
		throw new WholeIllegalArgumentException(WholeMessages.no_data_type);
	}

	public long parseLong(EntityDescriptor<?> ed, String value) {
		throw new WholeIllegalArgumentException(WholeMessages.no_data_type);
	}

	public Object parseObject(EntityDescriptor<?> ed, String value) {
		throw new WholeIllegalArgumentException(WholeMessages.no_data_type);
	}

	public short parseShort(EntityDescriptor<?> ed, String value) {
		throw new WholeIllegalArgumentException(WholeMessages.no_data_type);
	}

	public String parseString(EntityDescriptor<?> ed, String value) {
		throw new WholeIllegalArgumentException(WholeMessages.no_data_type);
	}

	public String unparseBoolean(EntityDescriptor<?> ed, boolean value) {
		throw new WholeIllegalArgumentException(WholeMessages.no_data_type);
	}

	public String unparseByte(EntityDescriptor<?> ed, byte value) {
		throw new WholeIllegalArgumentException(WholeMessages.no_data_type);
	}

	public String unparseChar(EntityDescriptor<?> ed, char value) {
		throw new WholeIllegalArgumentException(WholeMessages.no_data_type);
	}

	public String unparseDate(EntityDescriptor<?> ed, Date value) {
		throw new WholeIllegalArgumentException(WholeMessages.no_data_type);
	}

	public String unparseDouble(EntityDescriptor<?> ed, double value) {
		throw new WholeIllegalArgumentException(WholeMessages.no_data_type);
	}

	public String unparseEnumValue(EntityDescriptor<?> ed, EnumValue value) {
		throw new WholeIllegalArgumentException(WholeMessages.no_data_type);
	}

	public String unparseFloat(EntityDescriptor<?> ed, float value) {
		throw new WholeIllegalArgumentException(WholeMessages.no_data_type);
	}

	public String unparseInt(EntityDescriptor<?> ed, int value) {
		throw new WholeIllegalArgumentException(WholeMessages.no_data_type);
	}

	public String unparseLong(EntityDescriptor<?> ed, long value) {
		throw new WholeIllegalArgumentException(WholeMessages.no_data_type);
	}

	public String unparseObject(EntityDescriptor<?> ed, Object value) {
		throw new WholeIllegalArgumentException(WholeMessages.no_data_type);
	}

	public String unparseShort(EntityDescriptor<?> ed, short value) {
		throw new WholeIllegalArgumentException(WholeMessages.no_data_type);
	}

	public String unparseString(EntityDescriptor<?> ed, String value) {
		throw new WholeIllegalArgumentException(WholeMessages.no_data_type);
	}
}
