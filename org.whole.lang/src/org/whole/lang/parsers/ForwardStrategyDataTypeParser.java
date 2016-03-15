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

import org.whole.lang.model.EnumValue;
import org.whole.lang.reflect.EntityDescriptor;

/**
 * @author Riccardo Solmi
 */
public class ForwardStrategyDataTypeParser implements IDataTypeParser {
	private IDataTypeParser strategy;

	public ForwardStrategyDataTypeParser() {
		this(FailureDataTypeParser.instance);
	}
	public ForwardStrategyDataTypeParser(IDataTypeParser parserStrategy) {
		setStrategy(parserStrategy);
	}

	public void setStrategy(IDataTypeParser strategy) {
		this.strategy = strategy;
	}
	public IDataTypeParser getStrategy() {
		return strategy;
	}
	public IDataTypeParser getStrategy(EntityDescriptor<?> ed) {
		return strategy.getStrategy(ed);
	}

	public Object parse(EntityDescriptor<?> ed, String value) {
		return getStrategy(ed).parse(ed, value);
	}

	public boolean parseBoolean(EntityDescriptor<?> ed, String value) {
		return getStrategy(ed).parseBoolean(ed, value);
	}

	public byte parseByte(EntityDescriptor<?> ed, String value) {
		return getStrategy(ed).parseByte(ed, value);
	}

	public char parseChar(EntityDescriptor<?> ed, String value) {
		return getStrategy(ed).parseChar(ed, value);
	}

	public Date parseDate(EntityDescriptor<?> ed, String value) {
		return getStrategy(ed).parseDate(ed, value);
	}

	public double parseDouble(EntityDescriptor<?> ed, String value) {
		return getStrategy(ed).parseDouble(ed, value);
	}

	public EnumValue parseEnumValue(EntityDescriptor<?> ed, String value) {
		return getStrategy(ed).parseEnumValue(ed, value);
	}

	public float parseFloat(EntityDescriptor<?> ed, String value) {
		return getStrategy(ed).parseFloat(ed, value);
	}

	public int parseInt(EntityDescriptor<?> ed, String value) {
		return getStrategy(ed).parseInt(ed, value);
	}

	public long parseLong(EntityDescriptor<?> ed, String value) {
		return getStrategy(ed).parseLong(ed, value);
	}

	public Object parseObject(EntityDescriptor<?> ed, String value) {
		return getStrategy(ed).parseObject(ed, value);
	}

	public short parseShort(EntityDescriptor<?> ed, String value) {
		return getStrategy(ed).parseShort(ed, value);
	}

	public String parseString(EntityDescriptor<?> ed, String value) {
		return getStrategy(ed).parseString(ed, value);
	}

	public String unparse(EntityDescriptor<?> ed, Object value) {
		return getStrategy(ed).unparse(ed, value);
	}

	public String unparseBoolean(EntityDescriptor<?> ed, boolean value) {
		return getStrategy(ed).unparseBoolean(ed, value);
	}

	public String unparseByte(EntityDescriptor<?> ed, byte value) {
		return getStrategy(ed).unparseByte(ed, value);
	}

	public String unparseChar(EntityDescriptor<?> ed, char value) {
		return getStrategy(ed).unparseChar(ed, value);
	}

	public String unparseDate(EntityDescriptor<?> ed, Date value) {
		return getStrategy(ed).unparseDate(ed, value);
	}

	public String unparseDouble(EntityDescriptor<?> ed, double value) {
		return getStrategy(ed).unparseDouble(ed, value);
	}

	public String unparseEnumValue(EntityDescriptor<?> ed, EnumValue value) {
		return getStrategy(ed).unparseEnumValue(ed, value);
	}

	public String unparseFloat(EntityDescriptor<?> ed, float value) {
		return getStrategy(ed).unparseFloat(ed, value);
	}

	public String unparseInt(EntityDescriptor<?> ed, int value) {
		return getStrategy(ed).unparseInt(ed, value);
	}

	public String unparseLong(EntityDescriptor<?> ed, long value) {
		return getStrategy(ed).unparseLong(ed, value);
	}

	public String unparseObject(EntityDescriptor<?> ed, Object value) {
		return getStrategy(ed).unparseObject(ed, value);
	}

	public String unparseShort(EntityDescriptor<?> ed, short value) {
		return getStrategy(ed).unparseShort(ed, value);
	}

	public String unparseString(EntityDescriptor<?> ed, String value) {
		return getStrategy(ed).unparseString(ed, value);
	}
}
