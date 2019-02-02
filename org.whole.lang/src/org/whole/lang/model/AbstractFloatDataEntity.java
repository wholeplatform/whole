/**
 * Copyright 2004-2019 Riccardo Solmi. All rights reserved.
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
public abstract class AbstractFloatDataEntity extends AbstractDataEntity {
	private float value;
	public float getValue() {
		return notifyRequested(value);
	}
	public void setValue(float value) {
		notifyChanged(this.value, this.value = value);
	}

	public Object wGetValue() {
		return new Float(getValue());
	}

	public void wSetValue(Object value) {
		setValue(((Float) value).floatValue());
	}

	public float wFloatValue() {
		return getValue();
	}

	public void wSetValue(float value) {
		setValue(value);
	}
}