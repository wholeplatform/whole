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
package org.whole.lang.reflect;

/**
 * @author Riccardo Solmi
 */
public enum DataKinds {
	BOOLEAN, INT, LONG, FLOAT, DOUBLE, CHAR, BYTE, SHORT,
	DATE, ENUM_VALUE, OBJECT, STRING, NOT_A_DATA;

	public boolean isBoolean() {
		return equals(BOOLEAN);
	}
	public boolean isInt() {
		return equals(INT);
	}
	public boolean isLong() {
		return equals(LONG);
	}
	public boolean isFloat() {
		return equals(FLOAT);
	}
	public boolean isDouble() {
		return equals(DOUBLE);
	}
	public boolean isChar() {
		return equals(CHAR);
	}
	public boolean isByte() {
		return equals(BYTE);
	}
	public boolean isShort() {
		return equals(SHORT);
	}
	public boolean isDate() {
		return equals(DATE);
	}
	public boolean isEnumValue() {
		return equals(ENUM_VALUE);
	}
	public boolean isObject() {
		return equals(OBJECT);
	}
	public boolean isString() {
		return equals(STRING);
	}

	public boolean isReferenceKind() {
		return isString() || isDate() || isEnumValue() || isObject();
	}

	public boolean isNotAData() {
		return equals(NOT_A_DATA);
	}
}
