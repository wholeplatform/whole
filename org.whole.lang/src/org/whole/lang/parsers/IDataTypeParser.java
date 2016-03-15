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
public interface IDataTypeParser {
	public void setStrategy(IDataTypeParser strategy);
	public IDataTypeParser getStrategy();
	public IDataTypeParser getStrategy(EntityDescriptor<?> ed);

	public Object parse(EntityDescriptor<?> ed, String value);
	public String unparse(EntityDescriptor<?> ed, Object value);

	public boolean parseBoolean(EntityDescriptor<?> ed, String value);
	public byte parseByte(EntityDescriptor<?> ed, String value);
	public char parseChar(EntityDescriptor<?> ed, String value);
	public double parseDouble(EntityDescriptor<?> ed, String value);
	public float parseFloat(EntityDescriptor<?> ed, String value);
	public int parseInt(EntityDescriptor<?> ed, String value);
	public long parseLong(EntityDescriptor<?> ed, String value);
	public short parseShort(EntityDescriptor<?> ed, String value);
	public String parseString(EntityDescriptor<?> ed, String value);
	public Date parseDate(EntityDescriptor<?> ed, String value);
	public EnumValue parseEnumValue(EntityDescriptor<?> ed, String value);
	public Object parseObject(EntityDescriptor<?> ed, String value);

	public String unparseBoolean(EntityDescriptor<?> ed, boolean value);
	public String unparseByte(EntityDescriptor<?> ed, byte value);
	public String unparseChar(EntityDescriptor<?> ed, char value);
	public String unparseDouble(EntityDescriptor<?> ed, double value);
	public String unparseFloat(EntityDescriptor<?> ed, float value);
	public String unparseInt(EntityDescriptor<?> ed, int value);
	public String unparseLong(EntityDescriptor<?> ed, long value);
	public String unparseShort(EntityDescriptor<?> ed, short value);
	public String unparseString(EntityDescriptor<?> ed, String value);
	public String unparseDate(EntityDescriptor<?> ed, Date value);
	public String unparseEnumValue(EntityDescriptor<?> ed, EnumValue value);
	public String unparseObject(EntityDescriptor<?> ed, Object value);
}
