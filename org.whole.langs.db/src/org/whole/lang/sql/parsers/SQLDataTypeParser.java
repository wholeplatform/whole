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
package org.whole.lang.sql.parsers;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import org.whole.lang.exceptions.WholeIllegalArgumentException;
import org.whole.lang.model.EnumValue;
import org.whole.lang.parsers.DefaultDataTypePresentationParser;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.sql.model.BinaryOperatorEnum;
import org.whole.lang.sql.model.BooleanOperatorEnum;
import org.whole.lang.sql.model.IsTypeEnum;
import org.whole.lang.sql.reflect.SQLEntityDescriptorEnum;
import org.whole.lang.util.WholeMessages;

/**
 * @author Riccardo Solmi
 */
public class SQLDataTypeParser extends DefaultDataTypePresentationParser {
	private static class SingletonHolder {
		private static final SQLDataTypeParser instance = new SQLDataTypeParser();
	}
	public static SQLDataTypeParser instance() {
		return SingletonHolder.instance;
	}
	protected SQLDataTypeParser() {
	}

	public String parseString(EntityDescriptor<?> ed, String value) {
		if (ed.getOrdinal() == SQLEntityDescriptorEnum.StringValue_ord)
			return value.replace("''", "'");
		else
			return super.parseString(ed, value);
	}
	public String unparseString(EntityDescriptor<?> ed, String value) {
		if (ed.getOrdinal() == SQLEntityDescriptorEnum.StringValue_ord)
			return value.replace("'", "''");
		else
			return super.unparseString(ed, value);
	}

	public Object parseObject(EntityDescriptor<?> ed, String value) {
		switch (ed.getOrdinal()) {
		case SQLEntityDescriptorEnum.DecimalValue_ord:
			return new BigDecimal(value);
		case SQLEntityDescriptorEnum.ArrayValue_ord:
			String[] values = value.split(",");
			Object[] array = new Object[values.length];
			for (int i=0; i<values.length; i++)
				array[i] = Integer.parseInt(values[i].trim());
			return array;
		case SQLEntityDescriptorEnum.BinaryValue_ord:
			int length = value.length()/2;
			byte[] bytes = new byte[length];
			for (int i=0; i<length; i++)
				bytes[i] = (byte)
						((Character.digit(value.charAt(i*2), 16) << 4) +
						Character.digit(value.charAt(i*2+1), 16));
			return bytes;
		case SQLEntityDescriptorEnum.DateValue_ord:
			return Date.valueOf(value);
		case SQLEntityDescriptorEnum.TimeValue_ord:
			return Time.valueOf(value);
		case SQLEntityDescriptorEnum.TimestampValue_ord:
			return Timestamp.valueOf(value);
		}
		throw new WholeIllegalArgumentException(WholeMessages.no_data_type);
	}
	public String unparseObject(EntityDescriptor<?> ed, Object value) {
		switch (ed.getOrdinal()) {
		case SQLEntityDescriptorEnum.ArrayValue_ord:
			assert value.getClass().isArray();
			
			StringBuilder sb = new StringBuilder();
			int length = Array.getLength(value);
			for (int i=0; i<length; i++) {
				if (i>0)
					sb.append(", ");
				sb.append(Array.get(value, i));
			}
			
			return sb.toString();
		case SQLEntityDescriptorEnum.BinaryValue_ord:
			assert value.getClass().isArray();
			
			StringBuilder sb2 = new StringBuilder();
			int length2 = Array.getLength(value);
			for (int i=0; i<length2; i++) {
				int byteVal = (Byte) Array.get(value, i);
				sb2.append(Character.forDigit((byteVal & 255) >>> 4, 16));
				sb2.append(Character.forDigit(byteVal & 15, 16));
			}

			return sb2.toString();
		}
		return value != null ? value.toString() : " ";	
	}

	public EnumValue parseEnumValue(EntityDescriptor<?> ed, String value) {
		EnumValue enumValue = null;
		switch (ed.getOrdinal()) {
		case SQLEntityDescriptorEnum.BinaryOperator_ord:
			enumValue = parseBinaryOperator(value);
			break;
		case SQLEntityDescriptorEnum.BooleanOperator_ord:
			enumValue = parseBooleanOperator(value);
			break;
		case SQLEntityDescriptorEnum.IsType_ord:
			enumValue = parseIsType(value);
			break;
		}
		if (enumValue != null)
			return enumValue;
		else
			return super.parseEnumValue(ed, value);			
	}
	public String unparseEnumValue(EntityDescriptor<?> ed, EnumValue value) {
		switch (ed.getOrdinal()) {
		case SQLEntityDescriptorEnum.BinaryOperator_ord:
			return unparseBinaryOperator(value);
		case SQLEntityDescriptorEnum.BooleanOperator_ord:
			return unparseBooleanOperator(value);
		case SQLEntityDescriptorEnum.IsType_ord:
			return unparseIsType(value);
		default:
			return super.unparseEnumValue(ed, value);
		}
	}

	public static final String unparseIsType(EnumValue value) {
    	switch (value.getOrdinal()) {
    	case IsTypeEnum.NULL_ord:
    		return "NULL";
    	case IsTypeEnum.NOT_NULL_ord:
    		return "NOT NULL";
    	case IsTypeEnum.TRUE_ord:
    		return "TRUE";
    	case IsTypeEnum.NOT_TRUE_ord:
    		return "NOT TRUE";
    	case IsTypeEnum.FALSE_ord:
    		return "FALSE";
    	case IsTypeEnum.NOT_FALSE_ord:
    		return "NOT FALSE";
    	case IsTypeEnum.UNKNOWN_ord:
    		return "UNKNOWN";
    	case IsTypeEnum.NOT_UNKNOWN_ord:
    		return "NOT UNKNOWN";
    	default:
    		throw new IllegalArgumentException();
    	}
	}

	public static final String unparseBinaryOperator(EnumValue value) {
    	switch (value.getOrdinal()) {
    	case BinaryOperatorEnum.concat_ord:
    		return "+";
    	case BinaryOperatorEnum.div_ord:
    		return "/";
    	case BinaryOperatorEnum.mul_ord:
    		return "*";
    	case BinaryOperatorEnum.sub_ord:
    		return "-";
    	case BinaryOperatorEnum.sum_ord:
    		return "+";
    	default:
    		throw new IllegalArgumentException();
    	}
	}

	public static final String unparseBooleanOperator(EnumValue value) {
    	switch (value.getOrdinal()) {
    	case BooleanOperatorEnum.and_ord:
    		return "and";
    	case BooleanOperatorEnum.eq_ord:
    		return "=";
    	case BooleanOperatorEnum.ge_ord:
    		return ">=";
    	case BooleanOperatorEnum.gt_ord:
    		return ">";
    	case BooleanOperatorEnum.le_ord:
    		return "<=";
    	case BooleanOperatorEnum.lt_ord:
    		return "<";
    	case BooleanOperatorEnum.ne_ord:
    		return "<>";
    	case BooleanOperatorEnum.or_ord:
    		return "or";
    	case BooleanOperatorEnum.like_ord:
    		return "LIKE";
    	default:
    		throw new IllegalArgumentException();
    	}
	}

	private static volatile Map<String, IsTypeEnum.Value> isTypeMap;
	public static final IsTypeEnum.Value parseIsType(String value) {
		if (isTypeMap == null) {
			synchronized (SQLDataTypeParser.class) {
				if (isTypeMap == null) {
					isTypeMap = new HashMap<String, IsTypeEnum.Value>();
		
					isTypeMap.put("NULL", IsTypeEnum.NULL);
					isTypeMap.put("NOT NULL", IsTypeEnum.NOT_NULL);
					isTypeMap.put("FALSE", IsTypeEnum.FALSE);
					isTypeMap.put("NOT FALSE", IsTypeEnum.NOT_FALSE);
					isTypeMap.put("TRUE", IsTypeEnum.TRUE);
					isTypeMap.put("NOT TRUE", IsTypeEnum.NOT_TRUE);
					isTypeMap.put("UNKNOWN", IsTypeEnum.UNKNOWN);
					isTypeMap.put("NOT UNKNOWN", IsTypeEnum.NOT_UNKNOWN);
		
					assert IsTypeEnum.instance.size() == isTypeMap.size();
				}
			}
		}
		return isTypeMap.get(value.toUpperCase());
	}
	private static volatile Map<String, BinaryOperatorEnum.Value> binaryOperatorMap;
	public static final BinaryOperatorEnum.Value parseBinaryOperator(String value) {
		if (binaryOperatorMap == null) {
			synchronized (SQLDataTypeParser.class) {
				if (binaryOperatorMap == null) {
					binaryOperatorMap = new HashMap<String, BinaryOperatorEnum.Value>();
		
					binaryOperatorMap.put("+", BinaryOperatorEnum.concat);
					binaryOperatorMap.put("/", BinaryOperatorEnum.div);
					binaryOperatorMap.put("*", BinaryOperatorEnum.mul);
					binaryOperatorMap.put("-", BinaryOperatorEnum.sub);
					binaryOperatorMap.put("+", BinaryOperatorEnum.sum);
		
					assert BinaryOperatorEnum.instance.size() == binaryOperatorMap.size();
				}
			}
		}
		return binaryOperatorMap.get(value);
	}

	private static volatile Map<String, BooleanOperatorEnum.Value> booleanOperatorMap;
	public static final BooleanOperatorEnum.Value parseBooleanOperator(String value) {
		if (booleanOperatorMap == null) {
			synchronized (SQLDataTypeParser.class) {
				if (booleanOperatorMap == null) {
					booleanOperatorMap = new HashMap<String, BooleanOperatorEnum.Value>();
		
					booleanOperatorMap.put("and", BooleanOperatorEnum.and);
					booleanOperatorMap.put("=", BooleanOperatorEnum.eq);
					booleanOperatorMap.put(">=", BooleanOperatorEnum.ge);
					booleanOperatorMap.put(">", BooleanOperatorEnum.gt);
					booleanOperatorMap.put("<=", BooleanOperatorEnum.le);
					booleanOperatorMap.put("<", BooleanOperatorEnum.lt);
					booleanOperatorMap.put("<>", BooleanOperatorEnum.ne);
					booleanOperatorMap.put("or", BooleanOperatorEnum.or);
					booleanOperatorMap.put("LIKE", BooleanOperatorEnum.like);

					assert BooleanOperatorEnum.instance.size() == booleanOperatorMap.size();
				}
			}
		}
		return booleanOperatorMap.get(value);
	}
}
