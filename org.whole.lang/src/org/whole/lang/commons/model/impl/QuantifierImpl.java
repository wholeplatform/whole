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
package org.whole.lang.commons.model.impl;

import org.whole.lang.model.AbstractDataEntity;
import org.whole.lang.commons.model.Quantifier;
import org.whole.lang.commons.visitors.ICommonsVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.commons.reflect.CommonsEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.commons.model.QuantifierEnum;
import org.whole.lang.model.EnumValue;

/**
 * @author Riccardo Solmi
 */
public class QuantifierImpl extends AbstractDataEntity implements Quantifier {
	private static final long serialVersionUID = 1;

	private QuantifierEnum.Value value;

	public QuantifierEnum.Value getValue() {
		return notifyRequested(value);
	}

	public void setValue(QuantifierEnum.Value value) {
		notifyChanged(this.value, this.value = value);
	}

	public void accept(ICommonsVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	public int wGetEntityOrd() {
		return CommonsEntityDescriptorEnum.Quantifier_ord;
	}

	public EntityDescriptor<Quantifier> wGetEntityDescriptor() {
		return CommonsEntityDescriptorEnum.Quantifier;
	}

	public Object wGetValue() {
		return getValue();
	}

	public void wSetValue(Object value) {
		setValue((QuantifierEnum.Value) value);
	}

	public String wStringValue() {
		return toString();
	}

	public void wSetValue(String value) {
		try {
			setValue(QuantifierEnum.instance.valueOf(value));
		} catch (NumberFormatException e) {
		}
	}

	public EnumValue wEnumValue() {
		return value;
	}

	public void wSetValue(EnumValue value) {
		setValue((QuantifierEnum.Value) value);
	}
}
