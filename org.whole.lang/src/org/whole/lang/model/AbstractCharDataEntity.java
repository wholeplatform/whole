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
package org.whole.lang.model;


/** 
 * @author Riccardo Solmi
 */
@SuppressWarnings("serial")
public abstract class AbstractCharDataEntity extends AbstractDataEntity {
	private char value;
	public char getValue() {
		return notifyRequested(value);
	}
	public void setValue(char value) {
		notifyChanged(this.value, this.value = value);
	}

	public Object wGetValue() {
		return new Character(getValue());
	}

	public void wSetValue(Object value) {
		if (value instanceof Integer)
			setValue((char) ((Integer) value).intValue());
		else
			setValue(((Character) value).charValue());
	}

	public char wCharValue() {
		return getValue();
	}

	public void wSetValue(char value) {
		setValue(value);
	}
}