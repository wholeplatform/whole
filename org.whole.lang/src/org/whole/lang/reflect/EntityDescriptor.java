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

import java.util.List;
import java.util.Set;

import org.whole.lang.model.EnumType;
import org.whole.lang.model.EnumValue;
import org.whole.lang.model.IEntity;

/**
 * @author Riccardo Solmi
 */
public interface EntityDescriptor<E extends IEntity> extends Descriptor {
	public EntityDescriptorEnum getEntityDescriptorEnum();
	public FeatureDescriptorEnum getFeatureDescriptorEnum();

	public Class<E> getEntityType();
	public EntityKinds getEntityKind();
	public CompositeKinds getCompositeKind();
	public DataKinds getDataKind();
	public Class<?> getDataType();
	public EnumType<? extends EnumValue> getDataEnumType();
	public EntityDescriptor<E> withDataEnumType(EnumType<?> enumType);

	public boolean isAbstract();
	public boolean isRelationship();
	public boolean isToManyRelationship();

	public boolean has(FeatureDescriptor fd);
	public int indexOf(FeatureDescriptor fd);
	public int featureSize();
	public int childFeatureSize();
	public int adjacentFeatureSize();
	public List<FeatureDescriptor> getEntityFeatureDescriptors();
	public FeatureDescriptor getEntityFeatureDescriptor(int index);
	public FeatureDescriptor getEntityFeatureDescriptor(FeatureDescriptor fd);
	public FeatureDescriptor getDirectFeatureDescriptor(FeatureDescriptor oppositeFd);
	public EntityDescriptor<?> getEntityDescriptor(FeatureDescriptor fd);
	public EntityDescriptor<?> getEntityDescriptor(int index);

	public boolean isSubtypeOfAny();
	public boolean isSupertypeOfAny();
	public boolean isLanguageSubtypeOf(EntityDescriptor<?> ed);
	public boolean isLanguageSupertypeOf(EntityDescriptor<?> ed);
	public boolean isExtendedLanguageSupertypeOf(EntityDescriptor<?> ed);
	public boolean isPlatformSupertypeOf(EntityDescriptor<?> ed);

	public void setLanguageSubtypes(boolean enable, int... edOrdinals);

	public Iterable<EntityDescriptor<?>> languageSupertypesIterable();
	public Iterable<EntityDescriptor<?>> languageSubtypesIterable();

	public Set<EntityDescriptor<?>> getLanguageConcreteSubtypes();
	public Set<EntityDescriptor<?>> getLanguageConcreteSubtypes(Set<EntityDescriptor<?>> edSet);
	
	public boolean declaredSupertypesUpto(EntityDescriptor<?> optTargetEd, Set<EntityDescriptor<?>> supertypes);
	public boolean declaredSubtypesUpto(EntityDescriptor<?> optTargetEd, Set<EntityDescriptor<?>> subtypes);

	public boolean isPolymorphic();

	public EntityDescriptor<E> withFeature(FeatureDescriptor fd, int edOrdinal);
    public EntityDescriptor<E> withFeature(FeatureDescriptor fd, int edOrdinal,
    		boolean isOptional, boolean isId, boolean isReference, boolean isDerived, boolean isShared);
    public EntityDescriptor<E> withFeature(FeatureDescriptor fd, int edOrdinal,
    		FeatureDescriptor oppositeFd,
    		boolean isOptional, boolean isId, boolean isReference, boolean isDerived, boolean isShared);
}
