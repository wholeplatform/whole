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
package org.whole.lang.events;

import java.util.Date;

import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.model.EnumValue;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.util.EntityUtils;

/**
 * @author Riccardo Solmi
 */
public abstract class AbstractDerivationRule<E extends IEntity> extends IdentityRequestEventHandler {
	protected FeatureDescriptor fd;
	
	protected AbstractDerivationRule(FeatureDescriptor fd) {
		this.fd = fd;
	}

	@SuppressWarnings("unchecked")
	public <V extends IEntity> V notifyRequested(IEntity entity, FeatureDescriptor fd, V value) {
		if (this.fd.equals(fd) && (EntityUtils.isResolver(value) || EntityUtils.isDefault(entity, fd, value))) {
			V newValue = (V) deriveRequested((E) entity, value);
			if (newValue != value) {
				newValue = (V) EntityUtils.convertCloneIfParented(newValue, entity.wGetEntityDescriptor(fd));
				entity.wSet(fd, newValue);
			}
			return newValue;
		}
		return value;
	}

	protected IEntity deriveRequested(E entity, IEntity value) {
		if (EntityUtils.isResolver(value))
			switch (entity.wGetEntityDescriptor(fd).getDataKind()) {
			case NOT_A_DATA:
				throw new RequestException();
			case BOOLEAN:
				return BindingManagerFactory.instance.createValue(deriveRequested(entity, value.wBooleanValue()));
			case BYTE:
				return BindingManagerFactory.instance.createValue(deriveRequested(entity, value.wByteValue()));
			case CHAR:
				return BindingManagerFactory.instance.createValue(deriveRequested(entity, value.wCharValue()));
			case DOUBLE:
				return BindingManagerFactory.instance.createValue(deriveRequested(entity, value.wDoubleValue()));
			case FLOAT:
				return BindingManagerFactory.instance.createValue(deriveRequested(entity, value.wFloatValue()));
			case INT:
				return BindingManagerFactory.instance.createValue(deriveRequested(entity, value.wIntValue()));
			case LONG:
				return BindingManagerFactory.instance.createValue(deriveRequested(entity, value.wLongValue()));
			case SHORT:
				return BindingManagerFactory.instance.createValue(deriveRequested(entity, value.wShortValue()));
			case STRING:
				return BindingManagerFactory.instance.createValue(deriveRequested(entity, value.wStringValue()));
			case DATE:
				return BindingManagerFactory.instance.createValue(deriveRequested(entity, value.wDateValue()));
			case ENUM_VALUE:
				return BindingManagerFactory.instance.createValue(deriveRequested(entity, value.wEnumValue()));
			case OBJECT:
				return BindingManagerFactory.instance.createValue(deriveRequested(entity, value.wGetValue()));
			}
		else
			switch (entity.wGetEntityDescriptor(fd).getDataKind()) {
			case NOT_A_DATA:
				throw new RequestException();
			case BOOLEAN:
				value.wSetValue(deriveRequested(entity, value.wBooleanValue()));
				break;
			case BYTE:
				value.wSetValue(deriveRequested(entity, value.wByteValue()));
				break;
			case CHAR:
				value.wSetValue(deriveRequested(entity, value.wCharValue()));
				break;
			case DOUBLE:
				value.wSetValue(deriveRequested(entity, value.wDoubleValue()));
				break;
			case FLOAT:
				value.wSetValue(deriveRequested(entity, value.wFloatValue()));
				break;
			case INT:
				value.wSetValue(deriveRequested(entity, value.wIntValue()));
				break;
			case LONG:
				value.wSetValue(deriveRequested(entity, value.wLongValue()));
				break;
			case SHORT:
				value.wSetValue(deriveRequested(entity, value.wShortValue()));
				break;
			case STRING:
				value.wSetValue(deriveRequested(entity, value.wStringValue()));
				break;
			case DATE:
				value.wSetValue(deriveRequested(entity, value.wDateValue()));
				break;
			case ENUM_VALUE:
				value.wSetValue(deriveRequested(entity, value.wEnumValue()));
				break;
			case OBJECT:
				value.wSetValue(deriveRequested(entity, value.wGetValue()));
				break;
			}
		return value;
	}

	protected boolean deriveRequested(E entity, boolean value) {
		throw new RequestException();
	}
	protected byte deriveRequested(E entity, byte value) {
		throw new RequestException();
	}
	protected char deriveRequested(E entity, char value) {
		throw new RequestException();
	}
	protected double deriveRequested(E entity, double value) {
		throw new RequestException();
	}
	protected float deriveRequested(E entity, float value) {
		throw new RequestException();
	}
	protected int deriveRequested(E entity, int value) {
		throw new RequestException();
	}
	protected long deriveRequested(E entity, long value) {
		throw new RequestException();
	}
	protected short deriveRequested(E entity, short value) {
		throw new RequestException();
	}
	protected String deriveRequested(E entity, String value) {
		throw new RequestException();
	}
	protected Date deriveRequested(E entity, Date value) {
		throw new RequestException();
	}
	protected EnumValue deriveRequested(E entity, EnumValue value) {
		throw new RequestException();
	}
	protected Object deriveRequested(E entity, Object value) {
		throw new RequestException();
	}
}
