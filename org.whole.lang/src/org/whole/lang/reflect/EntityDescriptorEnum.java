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

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.whole.lang.commons.parsers.CommonsDataTypePersistenceParser;
import org.whole.lang.model.DynamicEnumType;
import org.whole.lang.model.EnumType;
import org.whole.lang.model.EnumValue;
import org.whole.lang.model.EnumValueImpl;
import org.whole.lang.model.IEntity;
import org.whole.lang.resources.IResourceRegistryListener;

/**
 * @author Riccardo Solmi
 */
public class EntityDescriptorEnum extends EnumType<EntityDescriptor<?>> implements IResourceRegistryListener<ILanguageKit> {
	private static final long serialVersionUID = 1L;

	transient private ILanguageKit languageKit;

	private void readObject(java.io.ObjectInputStream in) throws IOException,
			ClassNotFoundException {
		languageKit = ReflectionFactory.getLanguageKit(in.readUTF(), true, null);
		in.defaultReadObject();
	}

	private void writeObject(java.io.ObjectOutputStream out) throws IOException {
		out.writeUTF(languageKit.getURI());
		out.defaultWriteObject();
	}

	public EntityDescriptorEnum() {
		initEntityDescriptors();
		initForeignTypeRelations();
	}
	protected void initEntityDescriptors() {
	}
	protected void initForeignTypeRelations() {
	}
	public void updateTypeRelations() {
	}
	public void updateForeignTypeRelations() {
		updateForeignTypeRelations(null, true);
	}

	public void notifyAdded(ILanguageKit resource) {
		updateForeignTypeRelations(resource, true);
	}
	public void notifyRemoved(ILanguageKit resource) {
		updateForeignTypeRelations(resource, false);
//FIXME		initForeignTypeRelations();
	}
	public void notifyChanged(ILanguageKit oldResource, ILanguageKit newResource) {
		notifyRemoved(oldResource);
		notifyAdded(newResource);
	}

	protected void updateForeignTypeRelations(ILanguageKit foreignLanguageKit, boolean enable) {
		if (foreignLanguageKit != null && foreignLanguageKit.equals(getLanguageKit()))
			return;

		for (Map.Entry<EntityDescriptor<?>, Set<String>> entry : directForeignSupertypes.entrySet())
			if (!isAllTypes(entry.getValue()))
				for (String foreignEdUri : entry.getValue()) {
					EntityDescriptor<?> foreignEd = CommonsDataTypePersistenceParser.getEntityDescriptor(foreignEdUri, false, null);
					if (foreignEd != null && (foreignLanguageKit == null || foreignEd.getLanguageKit().equals(foreignLanguageKit)))
						foreignEd.getEntityDescriptorEnum().setAssignableFromForeignType(enable,
								entry.getKey().getURI(), foreignEd.getOrdinal());
				}
		for (Map.Entry<EntityDescriptor<?>, Set<String>> entry : directForeignSubtypes.entrySet())
			if (!isAllTypes(entry.getValue()))
				for (String foreignEdUri : entry.getValue()) {
					EntityDescriptor<?> foreignEd = CommonsDataTypePersistenceParser.getEntityDescriptor(foreignEdUri, false, null);
					if (foreignEd != null && (foreignLanguageKit == null || foreignEd.getLanguageKit().equals(foreignLanguageKit)))
						foreignEd.getEntityDescriptorEnum().setAssignableToForeignType(enable,
								entry.getKey().getURI(), foreignEd.getOrdinal());
				}
	}

    public final boolean equals(Object o) {
    	if (!(o instanceof EntityDescriptorEnum))
        	return false;

    	return getLanguageKit().equals(((EntityDescriptorEnum) o).getLanguageKit());
    }

	public ILanguageKit getLanguageKit() {
		return languageKit;
	}

	public void setLanguageKit(ILanguageKit languageKit) {
		this.languageKit = languageKit;

		updateTypeRelations();
		updateForeignTypeRelations();
		ReflectionFactory.getLanguageKitRegistry().addResourceRegistryListener(this);
	}

	public static final Set<String> ALL_TYPES = Collections.emptySet();
	public static boolean isAllTypes(Set<?> types) {
		return types != null && types.isEmpty();
	}

	protected Map<EntityDescriptor<?>, Set<String>> directForeignSupertypes = new HashMap<EntityDescriptor<?>, Set<String>>();
	protected Map<EntityDescriptor<?>, Set<String>> directForeignSubtypes = new HashMap<EntityDescriptor<?>, Set<String>>();

	public boolean declaredForeignSupertypesUpto(EntityDescriptor<?> ed, EntityDescriptor<?> optTargetEd, Set<EntityDescriptor<?>> supertypes) {
		if (supertypes.add(ed)) {
			Set<String> foreignSupertypes = directForeignSupertypes.get(ed);
			if (foreignSupertypes == null)
				return false;
			else if (isAllTypes(foreignSupertypes)) {
				supertypes.clear();
				return true;
			} else if (optTargetEd != null && foreignSupertypes.contains(optTargetEd.getURI()))
				return true;
			else
				for (String foreignEdUri : foreignSupertypes) {
					EntityDescriptor<?> foreignEd = CommonsDataTypePersistenceParser.getEntityDescriptor(foreignEdUri, false, null);
					if (foreignEd != null && foreignEd.declaredSupertypesUpto(optTargetEd, supertypes))
						return true;
				}
		}
		return false;
	}
	public boolean declaredForeignSubtypesUpto(EntityDescriptor<?> ed, EntityDescriptor<?> optTargetEd, Set<EntityDescriptor<?>> subtypes) {
		if (subtypes.add(ed)) {
			Set<String> foreignSubtypes = directForeignSubtypes.get(ed);
			if (foreignSubtypes == null)
				return false;
			else if (isAllTypes(foreignSubtypes)) {
				subtypes.clear();
				return true;
			} else if (optTargetEd != null && foreignSubtypes.contains(optTargetEd.getURI()))
				return true;
			else
				for (String foreignEdUri : foreignSubtypes) {
					EntityDescriptor<?> foreignEd = CommonsDataTypePersistenceParser.getEntityDescriptor(foreignEdUri, false, null);
					if (foreignEd != null && foreignEd.declaredSubtypesUpto(optTargetEd, subtypes))
						return true;
				}
		}
		return false;
	}

	public void setAssignableToAll(boolean enable, int... edOrdinals) {
		for (int edOrdinal : edOrdinals)
			if (enable)
				directForeignSupertypes.put(valueOf(edOrdinal), ALL_TYPES);
			else
				directForeignSupertypes.remove(valueOf(edOrdinal));
	}
	public void setAssignableToForeignType(boolean enable, String foreignEdUri, int... edOrdinals) {
		for (int edOrdinal : edOrdinals) {
			EntityDescriptor<?> ed = valueOf(edOrdinal);
			Set<String> subtypes = directForeignSupertypes.get(ed);
			if (isAllTypes(subtypes))
				return;
			else if (subtypes == null && enable)
				directForeignSupertypes.put(ed, subtypes = new HashSet<String>());

			if (enable)
				subtypes.add(foreignEdUri);
			else if (subtypes != null) {
				subtypes.remove(foreignEdUri);
				if (subtypes.isEmpty())//otherwise isAllTypes(subtypes) true
					directForeignSupertypes.remove(ed);
			}
		}
	}
	public void setAssignableFromAll(boolean enable, int... edOrdinals) {
		for (int edOrdinal : edOrdinals)
			if (enable)
				directForeignSubtypes.put(valueOf(edOrdinal), ALL_TYPES);
			else
				directForeignSubtypes.remove(valueOf(edOrdinal));
	}
	public void setAssignableFromForeignType(boolean enable, String foreignEdUri, int... edOrdinals) {
		for (int edOrdinal : edOrdinals) {
			EntityDescriptor<?> ed = valueOf(edOrdinal);
			Set<String> supertypes = directForeignSubtypes.get(ed);
			if (isAllTypes(supertypes))
				return;
			else if (supertypes == null && enable)
				directForeignSubtypes.put(ed, supertypes = new HashSet<String>());

			if (enable)
				supertypes.add(foreignEdUri);
			else if (supertypes != null) {
				supertypes.remove(foreignEdUri);
				if (supertypes.isEmpty())//otherwise isAllTypes(supertypes) true
					directForeignSubtypes.remove(ed);
			}
		}
	}
	public void setAliasOf(boolean enable, String foreignEdUri, int edOrdinal) {
		setAssignableToForeignType(enable, foreignEdUri, edOrdinal);
		setAssignableFromForeignType(enable, foreignEdUri, edOrdinal);
	}


	public Set<EntityDescriptor<?>> getExtendedLanguageConcreteSubtypesOf(EntityDescriptor<?> foreignEd) {
		return getExtendedLanguageConcreteSubtypesOf(foreignEd, new HashSet<EntityDescriptor<?>>());
	}
	protected Set<EntityDescriptor<?>> getExtendedLanguageConcreteSubtypesOf(EntityDescriptor<?> foreignEd, Set<EntityDescriptor<?>> values) {
		for (EntityDescriptor<?> value : this)
			if (!value.isAbstract() && foreignEd.isExtendedLanguageSupertypeOf(value))
				values.add(value);
		return values;
	}

	protected <E extends IEntity> EntityDescriptor<E> putSimpleEntity(int ordinal,
			String name, Class<E> type, boolean isAbstract) {
		return putSimpleEntity(ordinal, name, name, type, isAbstract);
	}
	protected <E extends IEntity> EntityDescriptor<E> putSimpleEntity(int ordinal,
			String name, String implName, Class<E> type, boolean isAbstract) {
		assert (valueOf(name) == null);

		EntityDescriptor<E> ed = new SimpleEntityDescriptor<E>(ordinal, name, implName, type, isAbstract);
		putEnumValue(ed);
		return ed;
	}
	protected <E extends IEntity> EntityDescriptor<E> putSimpleEntity(int ordinal,
			String name, Class<E> type, boolean isAbstract, int... assignableEdOrdinals) {
		return putSimpleEntity(ordinal, name, name, type, isAbstract, assignableEdOrdinals);
	}
	protected <E extends IEntity> EntityDescriptor<E> putSimpleEntity(int ordinal,
			String name, String implName, Class<E> type, boolean isAbstract, int... assignableEdOrdinals) {
		EntityDescriptor<E> ed = putSimpleEntity(ordinal, name, implName, type, isAbstract);
		ed.setLanguageSubtypes(true, assignableEdOrdinals);
		return ed;
	}

	protected <E extends IEntity> EntityDescriptor<E> putCompositeEntity(
			int ordinal, String name, Class<E> type,
			boolean isRelationship, int elementEdOrdinal,
			boolean isOrdered, boolean isUnique) {
		return putCompositeEntity(
				ordinal, name, name, type, isRelationship, elementEdOrdinal, isOrdered, isUnique);
	}
	protected <E extends IEntity> EntityDescriptor<E> putCompositeEntity(
			int ordinal, String name, String implName, Class<E> type,
			boolean isRelationship, int elementEdOrdinal,
			boolean isOrdered, boolean isUnique) {
		return putCompositeEntity(ordinal, name, implName, type,
				isRelationship, elementEdOrdinal,
				isOrdered, isUnique, false, false, false);
	}
	protected <E extends IEntity> EntityDescriptor<E> putCompositeEntity(
			int ordinal, String name, Class<E> type,
			boolean isRelationship, int elementEdOrdinal,
			boolean isOrdered, boolean isUnique, boolean isReference,
			boolean isDerived, boolean isShared) {
		return putCompositeEntity(ordinal, name, name, type,
				isRelationship, elementEdOrdinal, isOrdered, isUnique,
				isReference, isDerived, isShared);
	}
	protected <E extends IEntity> EntityDescriptor<E> putCompositeEntity(
			int ordinal, String name, String implName, Class<E> type,
			boolean isRelationship, int elementEdOrdinal,
			boolean isOrdered, boolean isUnique, boolean isReference,
			boolean isDerived, boolean isShared) {
		assert (valueOf(name) == null);
		EntityDescriptor<E> ed = new CompositeEntityDescriptor<E>(ordinal, name, implName, type,
				isRelationship, isOrdered, isUnique,
				elementEdOrdinal, true, isReference, isDerived, isShared);
		putEnumValue(ed);
		return ed;
	}

	protected <E extends IEntity> EntityDescriptor<E> putMapEntity(int ordinal,
			String name, Class<E> type, boolean isRelationship,
			int keyEdOrdinal, int valueEdOrdinal) {
		return putMapEntity(ordinal, name, name, type,
				isRelationship, keyEdOrdinal, valueEdOrdinal);
	}
	protected <E extends IEntity> EntityDescriptor<E> putMapEntity(int ordinal,
			String name, String implName, Class<E> type, boolean isRelationship,
			int keyEdOrdinal, int valueEdOrdinal) {
		assert (valueOf(name) == null);
		EntityDescriptor<E> ed = new MapEntityDescriptor<E>(ordinal, name, implName, type,
				isRelationship, keyEdOrdinal, valueEdOrdinal);
		putEnumValue(ed);
		return ed;
	}

	protected <E extends IEntity> EntityDescriptor<E> putDataEntity(int ordinal,
			String name, Class<E> type, boolean isRelationship, Class<?> dataType) {
		return putDataEntity(ordinal, name, name, type, isRelationship, dataType);
	}
	protected <E extends IEntity> EntityDescriptor<E> putDataEntity(int ordinal,
			String name, String implName, Class<E> type, boolean isRelationship, Class<?> dataType) {
		assert (valueOf(name) == null);
		EntityDescriptor<E> ed = new DataEntityDescriptor<E>(ordinal, name, implName, type, isRelationship, dataType);
		putEnumValue(ed);
		return ed;
	}

	public EntityDescriptor<? extends IEntity> addSimpleEntity(String name, String implName, boolean isAbstract) {
		return putSimpleEntity(size(), name, implName, IEntity.class, isAbstract);
	}

	public EntityDescriptor<? extends IEntity> addCompositeEntity(String name, String implName, boolean isRelationship,
			boolean isOrdered, boolean isUnique) {
		return putCompositeEntity(size(), name, implName, IEntity.class, isRelationship, 0, isOrdered, isUnique, false, false, false);
	}

	public EntityDescriptor<? extends IEntity> addDataEntity(String name, String implName, boolean isRelationship, Class<?> dataType) {
		return putDataEntity(size(), name, implName, IEntity.class, isRelationship, dataType);
	}

	public EntityDescriptor<? extends IEntity> addEnumEntity(String name, String implName, final String... enumValues) {
		return putDataEntity(size(), name, implName, IEntity.class, false, EnumValue.class).withDataEnumType(new DynamicEnumType(name) {
			private static final long serialVersionUID = 1L;

			{
				int i=0;
				for (String value : enumValues)
					putEnumValue(new EnumValueImpl(i++, value));
			}
		});
	}
}
