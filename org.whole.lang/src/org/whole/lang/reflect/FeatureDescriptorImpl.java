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

import org.whole.lang.commons.parsers.CommonsDataTypePersistenceParser;
import org.whole.lang.model.EnumValueImpl;



/**
 * @author Riccardo Solmi
 */
public class FeatureDescriptorImpl extends EnumValueImpl implements FeatureDescriptor {
	private static final long serialVersionUID = 1L;

	public FeatureDescriptorImpl() {} // Reserved to standard serialization
    public FeatureDescriptorImpl(int ordinal, String name) {
    	super(ordinal, name, name);
    }
    public FeatureDescriptorImpl(int ordinal, String name, String implName) {
    	super(ordinal, name, implName);
    }

    public ILanguageKit getLanguageKit() {
    	return getFeatureDescriptorEnum().getLanguageKit();
    }

	public String getURI() {
		return CommonsDataTypePersistenceParser.unparseFeatureDescriptor(this);
	}

	public boolean isEntityFeatureDescriptor() {
		return false;
	}
	public FeatureDescriptor getFeatureDescriptor() {
		return this;
	}
	public FeatureDescriptorEnum getFeatureDescriptorEnum() {
		return getEnumType(FeatureDescriptorEnum.class);
	}

	public EntityDescriptor<?> getEntityDescriptor() {
		throw new UnsupportedOperationException();
	}
	public FeatureDescriptor getOppositeFeatureDescriptor() {
		throw new UnsupportedOperationException();
	}
	public EntityDescriptor<?> getParentEntityDescriptor() {
		throw new UnsupportedOperationException();
	}
	public void setParentEntityDescriptor(EntityDescriptor<?> ed) {
		throw new UnsupportedOperationException();
	}
	public boolean isDerived() {
		throw new UnsupportedOperationException();
	}
	public boolean isId() {
		throw new UnsupportedOperationException();
	}
	public boolean isOptional() {
		throw new UnsupportedOperationException();
	}
	public boolean isReference() {
		throw new UnsupportedOperationException();
	}
	public boolean isShared() {
		throw new UnsupportedOperationException();
	}
	public boolean isToMany() {
		throw new UnsupportedOperationException();
	}
}
