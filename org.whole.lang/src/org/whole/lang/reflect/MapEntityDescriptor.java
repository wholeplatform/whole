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

import java.util.ArrayList;
import java.util.List;

import org.whole.lang.commons.reflect.CommonsFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/**
 * @author Riccardo Solmi
 */
public class MapEntityDescriptor<E extends IEntity> extends AbstractEntityDescriptor<E> {
	private static final long serialVersionUID = 1L;
	private List<FeatureDescriptor> keyValueFeatureDescriptors;

    protected MapEntityDescriptor() {} //Reserved to standard serialization
    protected MapEntityDescriptor(int ordinal, String name, String implName, Class<E> type,
    		boolean isRelationship, int keyEdOrdinal, int valueEdOrdinal) {
    	super(ordinal, name, implName, type, false, isRelationship);

    	keyValueFeatureDescriptors = new ArrayList<FeatureDescriptor>(2);
    	withFeature(CommonsFeatureDescriptorEnum.composite_element, keyEdOrdinal);
    	withFeature(CommonsFeatureDescriptorEnum.data_value, valueEdOrdinal);
	}

    public final EntityKinds getEntityKind() {
    	return EntityKinds.COMPOSITE; //FIXME MapEntity
    }


	public int featureSize() {
		return 2;
	}
	public int childFeatureSize() {
		return 2;
	}
	public int adjacentFeatureSize() {
		return 0;
	}

    public List<FeatureDescriptor> getEntityFeatureDescriptors() {
    	return keyValueFeatureDescriptors;
    }
    public FeatureDescriptor getEntityFeatureDescriptor(int index) {
		try {
			return keyValueFeatureDescriptors.get(index);
		} catch (IndexOutOfBoundsException e) {
    		throw new IllegalArgumentException("No such feature");
		}
    }

    public EntityDescriptor<E> withFeature(FeatureDescriptor fd,
    		int edOrdinal, FeatureDescriptor oppositeFd,
    		boolean isOptional, boolean isId, boolean isReference, boolean isDerived, boolean isShared) {

    	//TODO check index and fd

    	keyValueFeatureDescriptors.add(new EntityFeatureDescriptorImpl(
				this, fd, oppositeFd, edOrdinal,
				false, false, false, false, false));
		
		return this;
    }

    public int indexOf(FeatureDescriptor fd) {
    	if (CommonsFeatureDescriptorEnum.composite_element.equals(fd))
    		return 0;
    	else if (CommonsFeatureDescriptorEnum.data_value.equals(fd))
    		return 1;
    	else
    		return -1;
    }
}
