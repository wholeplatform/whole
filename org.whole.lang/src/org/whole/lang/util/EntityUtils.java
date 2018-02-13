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
package org.whole.lang.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.whole.lang.commons.reflect.CommonsEntityDescriptorEnum;
import org.whole.lang.comparators.IEntityComparator;
import org.whole.lang.factories.GenericEntityFactory;
import org.whole.lang.iterators.IEntityIterator;
import org.whole.lang.iterators.IteratorFactory;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.EnumValue;
import org.whole.lang.model.IEntity;
import org.whole.lang.model.NullEntity;
import org.whole.lang.operations.CloneOperation;
import org.whole.lang.operations.RemoveOperation;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reflect.EntityDescriptorEnum;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.reflect.ILanguageKit;
import org.whole.lang.reflect.ReflectionFactory;

/**
 * @author Riccardo Solmi
 */
public class EntityUtils {
	public static final boolean isSimple(EntityDescriptor<?> ed) {
		return ed.getEntityKind().isSimple();
	}
	public static final boolean isComposite(EntityDescriptor<?> ed) {
		return ed.getEntityKind().isComposite();
	}
	public static final boolean isData(EntityDescriptor<?> ed) {
		return ed.getEntityKind().isData();
	}
	public static final boolean isResolver(EntityDescriptor<?> ed) {
		return CommonsEntityDescriptorEnum.Resolver.equals(ed);//WAS ed.getEntityKind().isResolver();
	}
	public static final boolean isVariable(EntityDescriptor<?> ed) {
		return CommonsEntityDescriptorEnum.Variable.equals(ed) || isInlineVariable(ed);//WAS ed.getEntityKind().isVariable();
	}
	public static final boolean isInlineVariable(EntityDescriptor<?> ed) {
		return CommonsEntityDescriptorEnum.InlineVariable.equals(ed);
	}
	public static final boolean isFragment(EntityDescriptor<?> ed) {
		return isSameStageFragment(ed) || isStageDownFragment(ed) || isStageUpFragment(ed) ||
				CommonsEntityDescriptorEnum.RootFragment.equals(ed);//WAS ed.getEntityKind().isFragment();
	}
	public static final boolean isSameStageFragment(EntityDescriptor<?> ed) {
		return CommonsEntityDescriptorEnum.SameStageFragment.equals(ed);//WAS ed.getEntityKind().isSameStageFragment();
	}
	public static final boolean isStageDownFragment(EntityDescriptor<?> ed) {
		return CommonsEntityDescriptorEnum.StageDownFragment.equals(ed);//WAS ed.getEntityKind().isStageDownFragment();
	}
	public static final boolean isStageUpFragment(EntityDescriptor<?> ed) {
		return CommonsEntityDescriptorEnum.StageUpFragment.equals(ed);//WAS ed.getEntityKind().isStageUpFragment();
	}

	//FIXME before cleaning EntityKinds
//	public static final boolean isImpl(EntityDescriptor<?> ed) {
//		EntityKinds kind = ed.getEntityKind();
//		return (kind.isSimple() || kind.isComposite() || kind.isData()) && !ed.isAbstract();
//	}

	public static final boolean isIncompleteClone(IEntity entity) {
		for (int i=0; i<entity.wSize(); i++)
			if (entity.wGet(i).wGetParent() != entity)
				return true;
		return false;
	}

	public static final boolean isNull(IEntity entity) {
		return NullEntity.instance.equals(entity);
	}
	public static final boolean isSimple(IEntity entity) {
		return entity.wGetEntityKind().isSimple();
	}
	public static final boolean isComposite(IEntity entity) {
		return entity.wGetEntityKind().isComposite();
	}
	public static final boolean isData(IEntity entity) {
		return entity.wGetEntityKind().isData();
	}
	public static final boolean isResolver(IEntity entity) {
		return Matcher.matchImpl(CommonsEntityDescriptorEnum.Resolver, entity);
	}
	public static final boolean isVariable(IEntity entity) {
		return Matcher.matchAnyImpl(entity,
				CommonsEntityDescriptorEnum.Variable, CommonsEntityDescriptorEnum.InlineVariable);
	}
	public static final boolean isInlineVariable(IEntity entity) {
		return Matcher.matchImpl(CommonsEntityDescriptorEnum.InlineVariable, entity);
	}
	public static final boolean isFragment(IEntity entity) {
		return Matcher.matchAnyImpl(entity,
				CommonsEntityDescriptorEnum.SameStageFragment,
				CommonsEntityDescriptorEnum.StageDownFragment,
				CommonsEntityDescriptorEnum.StageUpFragment,
				CommonsEntityDescriptorEnum.RootFragment);
	}
	public static final boolean isSameStageFragment(IEntity entity) {
		return Matcher.matchImpl(CommonsEntityDescriptorEnum.SameStageFragment, entity);
	}
	public static final boolean isStageDownFragment(IEntity entity) {
		return Matcher.matchImpl(CommonsEntityDescriptorEnum.StageDownFragment, entity);
	}
	public static final boolean isStageUpFragment(IEntity entity) {
		return Matcher.matchImpl(CommonsEntityDescriptorEnum.StageUpFragment, entity);
	}

	//TODO test and inline
	public static final boolean isNotResolver(IEntity entity) {
		return !isResolver(entity);
	}
	//FIXME before cleaning EntityKinds
//	public static final boolean isImpl(IEntity entity) {
//		EntityKinds kind = entity.wGetEntityKind();
//		return kind.isSimple() || kind.isComposite() || kind.isData();
//	}
	public static final boolean isImpl(IEntity... entities) {
		for (IEntity entity : entities)
			if (!isNotResolver(entity))
				return false;
		return true;
	}

	public static final boolean isDefault(IEntity entity, FeatureDescriptor fd, IEntity value) {
		return GenericEntityFactory.instance.matchFeature(entity.wGetEntityDescriptor(), fd, value);
	}
	public static final boolean isDefault(IEntity entity, int index, IEntity value) {
		return GenericEntityFactory.instance.matchFeature(entity.wGetEntityDescriptor(), index, value);
	}
	public static final void setDefault(IEntity entity, FeatureDescriptor fd) {
		entity.wSet(fd, GenericEntityFactory.instance.cloneFeature(entity.wGetEntityDescriptor(), fd));
	}
	public static final void setDefault(IEntity entity, int index) {
		entity.wSet(index, GenericEntityFactory.instance.cloneFeature(entity.wGetEntityDescriptor(), index));
	}

	public static final boolean isOptional(IEntity entity) {
		IEntity parent = entity.wGetParent();
		return isNull(parent) ? false : parent.wGetFeatureDescriptor(entity).isOptional();
	}

	public static final ILanguageKit getEnvironmentLanguageKit() {
		return ReflectionFactory.getLanguageKit("http://lang.whole.org/Environment", false, null);//EnvironmentLanguageKit.URI
	}
	public static final boolean isTuple(IEntity entity) {
		EntityDescriptorEnum edEnum = getEnvironmentLanguageKit().getEntityDescriptorEnum();
		return Matcher.matchImpl(edEnum.valueOf("ContainmentTuple"), entity) ||
				Matcher.matchImpl(edEnum.valueOf("Tuple"), entity);
	}

	@SuppressWarnings("unchecked")
	public static final <E extends IEntity> E safeGet(E entity) {
		return isNotResolver(entity) ? entity :
			(E) GenericEntityFactory.instance.create(entity.wGetEntityDescriptor());
	}
	public static final <E extends IEntity> E safeGet(E entity, E defaultEntity) {
		return isNotResolver(entity) ? entity : defaultEntity;
	}
	@SuppressWarnings("unchecked")
	public static final <E extends IEntity> E safeGet(E entity, Object defaultValue) {
		return isNotResolver(entity) ? entity :
				(E) GenericEntityFactory.instance.create(
						entity.wGetEntityDescriptor(), defaultValue);
	}
	public static final boolean safeBooleanValue(IEntity entity, boolean defaultValue) {
		return DataTypeUtils.getDataKind(entity).isBoolean() ? entity.wBooleanValue() : defaultValue;
	}
	public static final byte safeByteValue(IEntity entity, byte defaultValue) {
		return DataTypeUtils.getDataKind(entity).isByte() ? entity.wByteValue() : defaultValue;
	}
	public static final char safeCharValue(IEntity entity, char defaultValue) {
		return DataTypeUtils.getDataKind(entity).isChar() ? entity.wCharValue() : defaultValue;
	}
	public static final double safeDoubleValue(IEntity entity, double defaultValue) {
		return DataTypeUtils.getDataKind(entity).isDouble() ? entity.wDoubleValue() : defaultValue;
	}
	public static final float safeFloatValue(IEntity entity, float defaultValue) {
		return DataTypeUtils.getDataKind(entity).isFloat() ? entity.wFloatValue() : defaultValue;
	}
	public static final int safeIntValue(IEntity entity, int defaultValue) {
		return DataTypeUtils.getDataKind(entity).isInt() ? entity.wIntValue() : defaultValue;
	}
	public static final long safeLongValue(IEntity entity, long defaultValue) {
		return DataTypeUtils.getDataKind(entity).isLong() ? entity.wLongValue() : defaultValue;
	}
	public static final short safeShortValue(IEntity entity, short defaultValue) {
		return DataTypeUtils.getDataKind(entity).isShort() ? entity.wShortValue() : defaultValue;
	}
	public static final String safeStringValue(IEntity entity, String defaultValue) {
		return DataTypeUtils.getDataKind(entity).isString() ? entity.wStringValue() : defaultValue;
	}
	public static final Date safeDateValue(IEntity entity, Date defaultValue) {
		return DataTypeUtils.getDataKind(entity).isDate() ? entity.wDateValue() : defaultValue;
	}
	public static final EnumValue safeEnumValueValue(IEntity entity, EnumValue defaultValue) {
		return DataTypeUtils.getDataKind(entity).isEnumValue() ? entity.wEnumValue() : defaultValue;
	}
	@SuppressWarnings("unchecked")
	public static final <T, E extends T> T safeGetValue(IEntity entity, E defaultValue, Class<T> dataType) {
		return !DataTypeUtils.getDataKind(entity).isNotAData() && dataType.isAssignableFrom(entity.wGetValue().getClass()) ?
				(T) entity.wGetValue() : defaultValue;
	}

	@SuppressWarnings("unchecked")
	public static final <T, E extends T> T safeGetValue(IEntity entity, E defaultValue) {
		return EntityUtils.<T, E>safeGetValue(entity, defaultValue, (Class<T>) defaultValue.getClass());
	}

	public static final EntityDescriptor<?> getFormalEntityDescriptor(IEntity entity) {
		return entity.wGetParent().wGetEntityDescriptor(entity); //TODO ? replace with getFormalType
	}

	public static final EntityDescriptor<?> getParentFormalType(IEntity entity) {
		return entity.wGetParent().wGetEntityDescriptor(entity);
	}
	public static final EntityDescriptor<?> getAdjacentsFormalType(IEntity entity) {
		EntityDescriptor<?> adjacentsFormalType = CommonsEntityDescriptorEnum.Any;
		for (IEntity inverseAdjacent : entity.wInverseAdjacents()) {
			EntityDescriptor<?> ed = inverseAdjacent.wGetEntityDescriptor(entity);
			if (!ed.isExtendedLanguageSupertypeOf(adjacentsFormalType))
				adjacentsFormalType = ed;
		}
		return adjacentsFormalType;
	}
	public static final EntityDescriptor<?> getFormalType(IEntity entity) {
		EntityDescriptor<?> parentFormalType = getParentFormalType(entity);
		EntityDescriptor<?> adjacentsFormalType = getAdjacentsFormalType(entity);
		return parentFormalType.isExtendedLanguageSupertypeOf(adjacentsFormalType) ?
				adjacentsFormalType : parentFormalType;
	}

	public static final boolean hasParent(IEntity entity) {
		return !isNull(entity.wGetParent());
	}
	public static final boolean hasInverseAdjacents(IEntity entity)  {
		return entity.wInverseAdjacentSize() > 0;
	}
	public static final boolean isReachable(IEntity entity) {
		return hasParent(entity) || hasInverseAdjacents(entity);
	}

	public static final IEntity safeGetRootEntity(IEntity entity) {
		while (hasParent(entity))
			entity = entity.wGetParent();
		return entity;
	}

	public static final void addCloneIfReparenting(IEntity entity, int index, IEntity value) {
		entity.wAdd(index, cloneIfReparenting(value, entity.wGetFeatureDescriptor(index).isReference()));
	}
	public static final void setCloneIfReparenting(IEntity entity, int index, IEntity value) {
		entity.wSet(index, cloneIfReparenting(value, entity.wGetFeatureDescriptor(index).isReference()));
	}
	public static final void setCloneIfReparenting(IEntity entity, FeatureDescriptor fd, IEntity value) {
		FeatureDescriptor efd = fd.isEntityFeatureDescriptor() ? fd : entity.wGetEntityDescriptor().getEntityFeatureDescriptor(fd);
		entity.wSet(fd, cloneIfReparenting(value, efd.isReference()));
	}

	public static final <E extends IEntity> E cloneIfReparenting(E entity, boolean assignToReference) {
		return !assignToReference && hasParent(entity) ? clone(entity) : entity;
	}
	public static final <E extends IEntity> E cloneIfParented(E entity) {
		return hasParent(entity) ? clone(entity) : entity;
	}
	public static final <E extends IEntity> E clone(E entity) {
		return new CloneOperation().clone(entity);
	}
	public static final <E extends IEntity> Collection<E> cloneAll(Collection<E> entities) {
		return new CloneOperation().cloneAll(entities);
	}
	public static final <E extends IEntity> E remove(E entity) {
		return new RemoveOperation().remove(entity);
	}
	public static final <E extends IEntity> Collection<E> removeAll(Collection<E> entities) {
		return new RemoveOperation().removeAll(entities);
	}

	public static boolean isReplaceable(IEntity oldEntity, IEntity newEntity) {
		return isReplaceable(oldEntity, newEntity.wGetEntityDescriptor());
	}
	public static boolean isReplaceableAsIs(IEntity oldEntity, IEntity newEntity) {
		return isReplaceableAsIs(oldEntity, newEntity.wGetEntityDescriptor());
	}
	public static boolean isReplaceable(IEntity oldEntity, EntityDescriptor<?> ed) {
		return getFormalEntityDescriptor(oldEntity).isExtendedLanguageSupertypeOf(ed);
	}
	public static boolean isReplaceableAsIs(IEntity oldEntity, EntityDescriptor<?> ed) {
		return getFormalEntityDescriptor(oldEntity).isLanguageSupertypeOf(ed);
	}
	public static boolean isAddable(IEntity compositeEntity, IEntity newEntity) {
		return isAddable(compositeEntity, newEntity.wGetEntityDescriptor());
	}
	public static boolean isAddableAsIs(IEntity compositeEntity, IEntity newEntity) {
		return isAddableAsIs(compositeEntity, newEntity.wGetEntityDescriptor());
	}
	public static boolean isAddable(IEntity entity, EntityDescriptor<?> ed) {
		return isComposite(entity) && entity.wGetEntityDescriptor(0).isExtendedLanguageSupertypeOf(ed);
	}
	public static boolean isAddableAsIs(IEntity entity, EntityDescriptor<?> ed) {
		return isComposite(entity) && entity.wGetEntityDescriptor(0).isLanguageSupertypeOf(ed);
	}

	public static final IEntity convertCloneIfParented(IEntity value, EntityDescriptor<?> toType) {
		return convertCloneIfReparenting(value, toType, false);
	}
	public static final IEntity convertCloneIfReparenting(IEntity value, FeatureDescriptor toEFd) {
		return toEFd.isEntityFeatureDescriptor() ?
				convertCloneIfReparenting(value, toEFd.getEntityDescriptor(), toEFd.isReference()) :
				cloneIfReparenting(value, false);
	}
	public static final IEntity convertCloneIfReparenting(IEntity value, EntityDescriptor<?> toEd, boolean isToReference) {
		//FIXME (workaround) force conversion semantics for data types
		if (toEd.getEntityKind().isData() && value.wGetEntityKind().isData())
			try {
				return DataTypeUtils.convertCloneIfReparenting(value, toEd, isToReference);
			} catch (IllegalArgumentException e) {
			}

		if (toEd.isPlatformSupertypeOf(value.wGetEntityDescriptor()))
			return cloneIfReparenting(value, isToReference);
		else if (value.wGetEntityKind().isData())
			try {
				return DataTypeUtils.convertCloneIfReparenting(value, toEd, isToReference);
			} catch (IllegalArgumentException e) {
				//TODO test in synch with wGetAdaptee behavior on WholeEditPartFactory
				return cloneIfReparenting(value, isToReference).wGetAdapter(toEd);
			}
		else
			return cloneIfReparenting(value, isToReference).wGetAdapter(toEd);
	}

	public static final IEntity merge(IEntity merger, IEntity mergee, IEntityComparator<IEntity> comparator, boolean orderAware) {
		IEntity initialMerger = merger;
		IEntity initialMergee = mergee;

		merger = merger.wGetAdaptee(false);
		mergee = mergee.wGetAdaptee(false);

		EntityDescriptor<?> mergerED = merger.wGetEntityDescriptor();
		if (!mergerED.equals(mergee.wGetEntityDescriptor())) {
			IEntity parent = initialMerger.wGetParent();
			if (!EntityUtils.isNull(parent)) {
				int index = parent.wIndexOf(initialMerger);
				if (parent.wGetEntityDescriptor(index).isLanguageSupertypeOf(mergee.wGetEntityDescriptor()))
					setCloneIfReparenting(parent, index, mergee);
				return parent.wGet(index);
			} else
				return initialMergee;
		}

		switch (mergerED.getEntityKind()) {
		case SIMPLE:
			for (FeatureDescriptor fd : mergerED.getEntityFeatureDescriptors()) {
				IEntity mergerFeature = merger.wGet(fd).wGetAdaptee(false);
				IEntity mergeeFeature = mergee.wGet(fd).wGetAdaptee(false);
				if (mergerFeature.wGetEntityDescriptor().equals(mergeeFeature.wGetEntityDescriptor()))
					merge(mergerFeature, mergeeFeature, comparator, orderAware);
				else
					merger.wSet(fd, cloneIfParented(mergeeFeature));
			}
			break;

		case COMPOSITE:
			if (mergerED.getCompositeKind().isOrdered() && orderAware) {
				int i=0, j=0;
				while (i<merger.wSize() && j<mergee.wSize()) {
					IEntity mergerChild = merger.wGet(i).wGetAdaptee(false);
					while (j<mergee.wSize()) {
						IEntity mergeeChild = mergee.wGet(j++).wGetAdaptee(false);
						if (comparator.equals(mergerChild, mergeeChild))
							merger.wSet(i, cloneIfParented(merge(mergerChild, mergeeChild, comparator, orderAware)));
						else {
							merger.wAdd(++i, cloneIfParented(mergeeChild));
							break;
						}
					}
					i++;
				}
				while (j<mergee.wSize())
					merger.wAdd(cloneIfParented(mergee.wGet(j++).wGetAdaptee(false)));
			} else {
				IEntityIterator<IEntity> mergeeIterator = IteratorFactory.childIterator();
				mergeeIterator.reset(mergee);
				while (mergeeIterator.hasNext()) {
					IEntity mergeeChild = mergeeIterator.next();
					if (comparator.contains(merger, mergeeChild)) {
						IEntity mergerChild = comparator.get(merger, mergeeChild);
						merger.wSet(mergeeChild, merge(mergerChild, mergeeChild, comparator, orderAware));
					} else {
						merger.wAdd(cloneIfParented(mergeeChild));
					}
				}
			}
			break;

		default:
		case DATA:
			// do not merge data entities
			break;
		}
		return initialMerger;
	}

	public static boolean isAncestorOrSelf(IEntity ancestorEntity, IEntity entity) {
		if (ancestorEntity == entity)
			return true;

		IEntity ancestor = entity.wGetParent();
		while (!isNull(ancestor) && ancestorEntity != ancestor)
			ancestor = ancestor.wGetParent();
		return !isNull(ancestor);
	}
	public static IEntity getCompoundRoot(IEntity entity) {
    	IEntity fragment = entity.wGetModel().getFragment();
		IEntity root = fragment != null ? fragment.wGetRoot() : entity;

		IEntity ancestor = entity.wGetParent();
		while (!(isNull(ancestor) || CommonsEntityDescriptorEnum.RootFragment.equals(ancestor.wGetEntityDescriptor()))) {
			root = ancestor;
			ancestor = ancestor.wGetParent();
		}
		return root;
	}
	public static IEntity getLanguageFragmentRoot(IEntity entity) {
		String languageURI = entity.wGetLanguageKit().getURI();
		IEntity root = entity;
		IEntity ancestor = entity.wGetParent();
		while (!isNull(ancestor) && ancestor.wGetLanguageKit().getURI().equals(languageURI)) {
			root = ancestor;
			ancestor = ancestor.wGetParent();
		}
		return root;
	}
	public static IEntity getFragmentRoot(IEntity entity) {
    	IEntity fragment = entity.wGetModel().getFragment();
    	if (fragment != null)
    		return fragment.wGetRoot();

		IEntity root = entity;
		IEntity ancestor = entity.wGetParent();
		while (!(isNull(ancestor) || isFragment(ancestor))) {
			root = ancestor;
			ancestor = ancestor.wGetParent();
		}
		return root;
	}

	public static String getLocation(IEntity entity) {
		StringBuffer path = new StringBuffer();
		if (entity != null) {
			IEntity parent = null;
			IEntityIterator<IEntity> i = IteratorFactory.ancestorOrSelfReverseIterator();
			i.reset(entity);
			if (CommonsEntityDescriptorEnum.RootFragment.equals(i.lookahead().wGetEntityDescriptor()))
				i.next();
			for (IEntity child : i) {
				if (parent != null) {
					path.append('/');
					if (EntityUtils.isSimple(parent))
						path.append(parent.wGetFeatureDescriptor(child).getName());
					else
						path.append(parent.wIndexOf(child));
				}
				parent = child;
			}
		}
		String result = path.toString();
		return result.equals("") ? "/" : result;
	}

	public static IEntity getEntity(IEntity rootEntity, String location) {
		IEntity result = rootEntity;
		if (location.charAt(0) != '/')
			return null;
		try {
			String substring = location.substring(1);
			if (substring.length() == 0)
				return rootEntity;
			String[] steps = substring.split("/");
			for (String step : steps) {
				try {
					int child = Integer.parseInt(step);
					result = result.wGet(child);
				} catch (NumberFormatException e) {
					result = result.wGet(result.wGetLanguageKit().getFeatureDescriptorEnum().valueOf(step));
				}
			}
		} catch (Exception e) {
			result = null;
		}
		return result;
	}
	public static IEntity mapEntity(IEntity entity, IEntity toModel) {
		return getEntity(toModel, getLocation(entity));
	}
	public static List<IEntity> mapEntities(List<IEntity> entities, IEntity toModel) {
		return entities.stream()
				.map((entity) -> mapEntity(entity, toModel))
				.filter((entity) -> entity != null)
				.collect(Collectors.toCollection(ArrayList::new));
	}
}
