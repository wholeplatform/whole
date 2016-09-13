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

import java.util.Collections;
import java.util.List;

import org.whole.lang.commons.reflect.CommonsFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/**
 * @author Riccardo Solmi
 */
public class CompositeEntityDescriptor<E extends IEntity> extends AbstractEntityDescriptor<E> {
	private static final long serialVersionUID = 1L;
	private CompositeKinds compositeKind;
	private FeatureDescriptor elementFeatureDescriptor;

    protected CompositeEntityDescriptor() {} //Reserved to standard serialization
	protected CompositeEntityDescriptor(int ordinal, String name, String implName, Class<E> type,
			boolean isRelationship, boolean isOrdered, boolean isUnique,
			int elementEdOrdinal, boolean isOptional, boolean isReference, boolean isDerived, boolean isShared) {
    	super(ordinal, name, implName, type, false, isRelationship);

		if (isOrdered)
			compositeKind = isUnique ? CompositeKinds.UNIQUE_LIST : CompositeKinds.LIST;
		else
			compositeKind = isUnique ? CompositeKinds.SET : CompositeKinds.BAG;

		withFeature(CommonsFeatureDescriptorEnum.composite_element, elementEdOrdinal,
				isOptional, false, isReference, isDerived, isShared);
	}

	public boolean isToManyRelationship() {
		return isRelationship();
	}

    public final EntityKinds getEntityKind() {
    	return EntityKinds.COMPOSITE;
    }
    public final CompositeKinds getCompositeKind() {
    	return compositeKind;
    }

	public int featureSize() {
		return 1;
	}
	public int childFeatureSize() {
		return elementFeatureDescriptor.isReference() ? 0 : 1;
	}
	public int adjacentFeatureSize() {
		return elementFeatureDescriptor.isReference() ? 1 : 0;
	}

    public List<FeatureDescriptor> getEntityFeatureDescriptors() {
    	return Collections.singletonList(elementFeatureDescriptor);
    }
    public FeatureDescriptor getEntityFeatureDescriptor(int index) {
		if (index < 0)
			throw new IllegalArgumentException("No such feature");
    	return elementFeatureDescriptor;
    }

    public int indexOf(FeatureDescriptor fd) {
    	if (CommonsFeatureDescriptorEnum.composite_element.equals(fd))
    		return 0;
    	else
    		return -1;
    }

    public EntityDescriptor<E> withFeature(FeatureDescriptor fd,
    		int edOrdinal, FeatureDescriptor oppositeFd, boolean isOptional,
			boolean isId, boolean isReference, boolean isDerived, boolean isShared) {

    	if (!CommonsFeatureDescriptorEnum.composite_element.equals(fd))
    		throw new IllegalArgumentException();

    	elementFeatureDescriptor = new EntityFeatureDescriptorImpl(
				this, fd, oppositeFd, edOrdinal,
				isOptional, isId, isReference, isDerived, isShared);
		
		return this;
    }
}
