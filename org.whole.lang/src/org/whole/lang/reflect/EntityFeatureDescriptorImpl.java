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
import org.whole.lang.model.EnumType;
import org.whole.lang.model.EnumValue;

/**
 * @author Riccardo Solmi
 */
public class EntityFeatureDescriptorImpl implements FeatureDescriptor {
	private static final long serialVersionUID = 1L;

	private EntityDescriptor<?> parentEntityDescriptor;
	private FeatureDescriptor featureDescriptor;
	private FeatureDescriptor oppositeFeatureDescriptor;
	private EntityDescriptor<?> entityDescriptor;
	private int entityDescriptorOrd;
	private byte optional_id_reference_derived_shared_toMany;

	public EntityFeatureDescriptorImpl() {} // Reserved to standard serialization
	public EntityFeatureDescriptorImpl(
			EntityDescriptor<?> parentEd, FeatureDescriptor fd,
			FeatureDescriptor oppositeFd, EntityDescriptor<?> ed,
			boolean isOptional, boolean isId, boolean isReference, boolean isDerived, boolean isShared) {
		this(parentEd, fd, oppositeFd, ed.getOrdinal(),
				isOptional, isId, isReference, isDerived, isShared);
		this.entityDescriptor = ed;
	}
	public EntityFeatureDescriptorImpl(
			EntityDescriptor<?> parentEd, FeatureDescriptor fd,
			FeatureDescriptor oppositeFd, int edOrdinal,
			boolean isOptional, boolean isId, boolean isReference, boolean isDerived, boolean isShared) {
		this.parentEntityDescriptor = parentEd;
		this.featureDescriptor = fd;
		this.oppositeFeatureDescriptor = oppositeFd;
		this.entityDescriptorOrd = edOrdinal;
		setOptional(isOptional);
		setId(isId);
		setReference(isReference);
		setDerived(isDerived);
		setShared(isShared);
//		setToMany(isToMany);
	}

	public ILanguageKit getLanguageKit() {
		return getFeatureDescriptor().getLanguageKit();
	}

	public String getURI() {
		return CommonsDataTypePersistenceParser.unparseFeatureDescriptor(this);
	}

	public boolean isEntityFeatureDescriptor() {
		return true;
	}
	public FeatureDescriptor getFeatureDescriptor() {
		return featureDescriptor;
	}
	public EntityDescriptor<?> getParentEntityDescriptor() {
		return parentEntityDescriptor;
	}
	public void setParentEntityDescriptor(EntityDescriptor<?> ed) {
		if (parentEntityDescriptor != null)
			throw new IllegalArgumentException("The feature descriptor is already parented: "+this);
		parentEntityDescriptor = ed;
	}

	@Override
	public int hashCode() {
		return getFeatureDescriptor().hashCode();
	}
	public boolean equals(Object o) {
		if (o instanceof EntityFeatureDescriptorImpl) {
			FeatureDescriptor other = (FeatureDescriptor) o;
			return getFeatureDescriptor().equals(other.getFeatureDescriptor()) &&
					getParentEntityDescriptor().equals(other.getParentEntityDescriptor());
		}
		return getFeatureDescriptor().equals(o);
	}
	public int compareTo(EnumValue o) {
		int result = getFeatureDescriptor().compareTo(o);
		if (result == 0 && o instanceof EntityFeatureDescriptorImpl)
			return getParentEntityDescriptor().compareTo(
					((FeatureDescriptor) o).getParentEntityDescriptor());
		return result;
	}

    public EnumType<?> getEnumType() {
    	return getFeatureDescriptor().getEnumType();
    }
    public void setEnumType(EnumType<?> enumType) {
    	getFeatureDescriptor().setEnumType(enumType);
    }
	public FeatureDescriptorEnum getFeatureDescriptorEnum() {
		return getFeatureDescriptor().getFeatureDescriptorEnum();
	}
	public int getOrdinal() {
		return getFeatureDescriptor().getOrdinal();
	}
	public String getName() {
		return getFeatureDescriptor().getName();
	}
	public String getImplName() {
		return getFeatureDescriptor().getImplName();
	}

	protected final boolean wGetBooleanProperty(int bitValue) {
		return (optional_id_reference_derived_shared_toMany & bitValue) != 0;
	}
	protected final void wSetBooleanProperty(int bitValue, boolean value) {
		if (value)
			optional_id_reference_derived_shared_toMany |= bitValue;
		else
			optional_id_reference_derived_shared_toMany &= ~bitValue;
	}

	public boolean isOptional() {
		return wGetBooleanProperty(1);
	}
	public void setOptional(boolean isOptional) {
		wSetBooleanProperty(1, isOptional);
	}
	public boolean isId() {
		return wGetBooleanProperty(2);
	}
	public void setId(boolean isId) {
		wSetBooleanProperty(2, isId);
	}
	public boolean isReference() {
		return wGetBooleanProperty(4);
	}
	public void setReference(boolean isReference) {
		wSetBooleanProperty(4, isReference);
	}
	public boolean isDerived() {
		return wGetBooleanProperty(8);
	}
	public void setDerived(boolean isDerived) {
		wSetBooleanProperty(8, isDerived);
	}
	public boolean isShared() {
		return wGetBooleanProperty(16);
	}
	public void setShared(boolean isShared) {
		wSetBooleanProperty(16, isShared);
	}
	public boolean isToMany() {
		return getEntityDescriptor().isToManyRelationship();
//		return wGetBooleanProperty(32);
	}
//	public void setToMany(boolean isToMany) {
//		wSetBooleanProperty(32, isToMany);
//	}

	public FeatureDescriptor getOppositeFeatureDescriptor() {
		return oppositeFeatureDescriptor;
	}
	public EntityDescriptor<?> getEntityDescriptor() {
		if (entityDescriptor == null)
			entityDescriptor = getParentEntityDescriptor().getEntityDescriptorEnum().valueOf(entityDescriptorOrd);
		return entityDescriptor;
	}

	public String toString() {
		return getParentEntityDescriptor().toString()+"/"+getFeatureDescriptor().toString();
	}
}
