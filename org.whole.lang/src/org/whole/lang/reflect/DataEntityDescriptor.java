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

import org.whole.lang.commons.reflect.CommonsFeatureDescriptorEnum;
import org.whole.lang.model.EnumType;
import org.whole.lang.model.EnumValue;
import org.whole.lang.model.IEntity;
import org.whole.lang.util.DataTypeUtils;

/**
 * @author Riccardo Solmi
 */
public class DataEntityDescriptor<E extends IEntity> extends AbstractEntityDescriptor<E> {
	private static final long serialVersionUID = 1L;
	private Class<?> dataType;
	private EnumType<?> dataEnumType;
	private DataKinds dataKind;

	protected DataEntityDescriptor() {} //Reserved to standard serialization
	protected DataEntityDescriptor(int ordinal, String name, String implName, Class<E> type, 
			boolean isRelationship, Class<?> dataType) {
    	super(ordinal, name, implName, type, false, isRelationship);
    	this.dataType = dataType;
    	this.dataKind = DataTypeUtils.toDataKind(dataType);
	}

    public final EntityKinds getEntityKind() {
    	return EntityKinds.DATA;
    }
    public final DataKinds getDataKind() {
    	return dataKind;
    }
    public final Class<?> getDataType() {
    	return dataType;
    }
    public final EnumType<? extends EnumValue> getDataEnumType() {
    	if (dataEnumType == null)
    		return EnumType.instance(getDataType());
    	return dataEnumType;
    }
    public EntityDescriptor<E> withDataEnumType(EnumType<?> enumType) {
    	this.dataEnumType = enumType;
    	return this;
    }

    public boolean isAssignable(int index, EntityDescriptor<?> entity) {
    	return false;
    }
    public boolean isAssignable(FeatureDescriptor fd, EntityDescriptor<?> ed) {
    	return false;
    }

    public int indexOf(FeatureDescriptor fd) {
    	if (CommonsFeatureDescriptorEnum.data_value.equals(fd))
    		return 0;
    	else
    		return -1;
    }

	public int featureSize() {
		return 0;
	}
	public int childFeatureSize() {
		return 0;
	}
	public int adjacentFeatureSize() {
		return 0;
	}
}
