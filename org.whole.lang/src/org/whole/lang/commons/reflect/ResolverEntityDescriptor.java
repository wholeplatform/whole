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
package org.whole.lang.commons.reflect;

import java.util.EnumSet;
import java.util.List;
import java.util.Set;

import org.whole.lang.model.EnumType;
import org.whole.lang.model.EnumValue;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.AbstractEntityDescriptor;
import org.whole.lang.reflect.CompositeKinds;
import org.whole.lang.reflect.DataKinds;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reflect.EntityDescriptorEnum;
import org.whole.lang.reflect.EntityKinds;
import org.whole.lang.reflect.EntityModifiers;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.reflect.FeatureDescriptorEnum;
import org.whole.lang.reflect.ILanguageKit;

/**
 * @author Riccardo Solmi
 */
public class ResolverEntityDescriptor extends /*EnumValueImpl*/ AbstractEntityDescriptor<IEntity> implements EntityDescriptor<IEntity> {
	private static final long serialVersionUID = 1L;
	protected EntityDescriptor<?> baseEntityDescriptor;
	protected ResolverFacade entityFacade;

	public ResolverEntityDescriptor(EntityDescriptor<?> baseEntityDescriptor, ResolverFacade entityFacade) {
//		super(0, "noname", "noname");
		super(0, "noname", "noname", IEntity.class, EnumSet.noneOf(EntityModifiers.class));
		this.baseEntityDescriptor = baseEntityDescriptor;
		this.entityFacade = entityFacade;
	}
	protected ResolverEntityDescriptor(int ordinal, String name, String implName) {
//		super(ordinal, name, implName);
		super(ordinal, name, implName, IEntity.class, EnumSet.noneOf(EntityModifiers.class));
	}

	public ResolverFacade getEntityFacade() {
		return entityFacade;
	}

	public EntityKinds getEntityKind() {
		return getEntityFacade().wGetEntityKind();
	}

	public boolean has(FeatureDescriptor fd) {
		return getEntityFacade().wContains(fd);
	}
	public int indexOf(FeatureDescriptor fd) {
		for (int i=0, size=featureSize(); i<size; i++)
			if (fd.equals(getEntityFeatureDescriptor(i)))
				return i;
		return -1;
	}

	public int featureSize() {
		return baseEntityDescriptor.featureSize();
	}
	public int childFeatureSize() {
		return baseEntityDescriptor.childFeatureSize();
	}
	public int adjacentFeatureSize() {
		return baseEntityDescriptor.adjacentFeatureSize();
	}

	public List<FeatureDescriptor> getEntityFeatureDescriptors() {
		return baseEntityDescriptor.getEntityFeatureDescriptors();
	}

    public boolean isExtendedLanguageSupertypeOf(EntityDescriptor<?> ed) {
    	return equals(ed);
    }

	public boolean isSubtypeOfAny() {
		return baseEntityDescriptor.isSubtypeOfAny();
	}
	public boolean isSupertypeOfAny() {
		return baseEntityDescriptor.isSupertypeOfAny();
	}
	public boolean isPlatformSupertypeOf(EntityDescriptor<?> ed) {
		return baseEntityDescriptor.isPlatformSupertypeOf(ed);
	}
	public boolean isLanguageSubtypeOf(EntityDescriptor<?> ed) {
		return baseEntityDescriptor.isLanguageSubtypeOf(ed);
	}
	public boolean isLanguageSupertypeOf(EntityDescriptor<?> ed) {
		return baseEntityDescriptor.isLanguageSupertypeOf(ed);
	}

	public boolean isPolymorphic() {
		return baseEntityDescriptor.isPolymorphic();
	}

	public Set<EntityDescriptor<?>> getLanguageConcreteSubtypes() {
		return baseEntityDescriptor.getLanguageConcreteSubtypes();
	}
	public Set<EntityDescriptor<?>> getLanguageConcreteSubtypes(Set<EntityDescriptor<?>> edSet) {
		return baseEntityDescriptor.getLanguageConcreteSubtypes(edSet);
	}

    public boolean declaredSupertypesUpto(EntityDescriptor<?> optTargetEd, Set<EntityDescriptor<?>> supertypes) {
    	return baseEntityDescriptor.declaredSupertypesUpto(optTargetEd, supertypes);
    }
    public boolean declaredSubtypesUpto(EntityDescriptor<?> optTargetEd, Set<EntityDescriptor<?>> subtypes) {
    	return baseEntityDescriptor.declaredSubtypesUpto(optTargetEd, subtypes);
    }

	public CompositeKinds getCompositeKind() {
		return baseEntityDescriptor.getCompositeKind();
	}
	public EnumType<? extends EnumValue> getDataEnumType() {
		return baseEntityDescriptor.getDataEnumType();
	}
	public DataKinds getDataKind() {
		return baseEntityDescriptor.getDataKind();
	}
	public Class<?> getDataType() {
		return baseEntityDescriptor.getDataType();
	}
	public EntityDescriptor<?> getEntityDescriptor(FeatureDescriptor fd) {
		return baseEntityDescriptor.getEntityDescriptor(fd);
	}
	public EntityDescriptor<?> getEntityDescriptor(int index) {
		return baseEntityDescriptor.getEntityDescriptor(index);
	}
	public EntityDescriptorEnum getEntityDescriptorEnum() {
		return baseEntityDescriptor.getEntityDescriptorEnum();
	}
	@SuppressWarnings("unchecked")
	public Class<IEntity> getEntityType() {
		return (Class<IEntity>) baseEntityDescriptor.getEntityType();
	}
	public EnumType<?> getEnumType() {
		return baseEntityDescriptor.getEnumType();
	}
	public FeatureDescriptor getEntityFeatureDescriptor(int index) {
		return baseEntityDescriptor.getEntityFeatureDescriptor(index);
	}
	public FeatureDescriptorEnum getFeatureDescriptorEnum() {
		return baseEntityDescriptor.getFeatureDescriptorEnum();
	}
	public ILanguageKit getLanguageKit() {
		return baseEntityDescriptor.getLanguageKit();
	}
	public String getImplName() {
		return baseEntityDescriptor.getImplName();
	}
	public String getName() {
		return baseEntityDescriptor.getName();
	}
	public int getOrdinal() {
		return baseEntityDescriptor.getOrdinal();
	}
	public boolean isAbstract() {
		return baseEntityDescriptor.isAbstract();
	}
	public boolean isRelationship() {
		return baseEntityDescriptor.isRelationship();
	}
	public boolean isToManyRelationship() {
		return baseEntityDescriptor.isToManyRelationship();
	}
}
