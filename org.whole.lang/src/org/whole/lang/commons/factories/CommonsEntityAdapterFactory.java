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
package org.whole.lang.commons.factories;

import org.whole.lang.commons.model.QuantifierEnum;
import org.whole.lang.commons.reflect.CommonsEntityDescriptorEnum;
import org.whole.lang.commons.reflect.CommonsFeatureDescriptorEnum;
import org.whole.lang.factories.GenericEntityFactory;
import org.whole.lang.factories.IEntityFactory;
import org.whole.lang.factories.RegistryConfigurations;
import org.whole.lang.model.IEntity;
import org.whole.lang.model.adapters.IEntityAdapter;
import org.whole.lang.reflect.EntityDescriptor;

/**
 * @author Riccardo Solmi
 */
public class CommonsEntityAdapterFactory {
	private static IEntityFactory eaf;
	public static <E extends IEntity> E create(EntityDescriptor<E> ed, IEntity implementor) {
		if (eaf == null)
			eaf = GenericEntityFactory.instance(RegistryConfigurations.ADAPTER);
		E adapter = eaf.shallowClone(ed);
		((IEntityAdapter) adapter).wSetAdaptee(implementor);
		return adapter;
	}

	public static <E extends IEntity> E createMultiplexer(EntityDescriptor<E> ed) {
		return CommonsEntityFactory.instance.createMultiplexer().wGetAdapter(ed);
//		return create(ed, ICommonsEntityFactory.instance.createMultiplexer());
	}

	public static <E extends IEntity> E createResolver(EntityDescriptor<E> ed) {
		return CommonsEntityFactory.instance.createResolver().wGetAdapter(ed);
	}

	public static <E extends IEntity> E createSameStageFragment(EntityDescriptor<E> ed, IEntity fragment) {
		return CommonsEntityFactory.instance.createSameStageFragment(
				fragment.wGetAdapter(CommonsEntityDescriptorEnum.Any)).wGetAdapter(ed);
	}
	public static <E extends IEntity> E createStageDownFragment(EntityDescriptor<E> ed, IEntity fragment) {
		return CommonsEntityFactory.instance.createStageDownFragment(
				fragment.wGetAdapter(CommonsEntityDescriptorEnum.Any)).wGetAdapter(ed);
	}
	public static <E extends IEntity> E createStageUpFragment(EntityDescriptor<E> ed, IEntity fragment) {
		return CommonsEntityFactory.instance.createStageUpFragment(
				fragment.wGetAdapter(CommonsEntityDescriptorEnum.Any)).wGetAdapter(ed);
	}

	public static <E extends IEntity> E createVariable(EntityDescriptor<E> ed, String name) {
		return createVariable(ed, name, ed);
	}
	public static <E extends IEntity> E createVariable(EntityDescriptor<E> ed, String name, EntityDescriptor<?> type) {
		return CommonsEntityFactory.instance.buildVariable()
				.set(CommonsFeatureDescriptorEnum.varType, CommonsEntityFactory.instance.createVarType(type))
				.set(CommonsFeatureDescriptorEnum.varName, CommonsEntityFactory.instance.createVarName(name))
				.getResult().wGetAdapter(ed);
	}
	public static <E extends IEntity> E createVariable(EntityDescriptor<E> ed, String name, EntityDescriptor<?> type, QuantifierEnum.Value quantifier) {
		return CommonsEntityFactory.instance.createVariable(
				CommonsEntityFactory.instance.createVarType(type),
				CommonsEntityFactory.instance.createVarName(name),
				CommonsEntityFactory.instance.createQuantifier(quantifier)).wGetAdapter(ed);
	}

	public static <E extends IEntity> E createInlineVariable(EntityDescriptor<E> ed, String name) {
		return createInlineVariable(ed, name, ed);
	}
	public static <E extends IEntity> E createInlineVariable(EntityDescriptor<E> ed, String name, EntityDescriptor<?> type) {
		return CommonsEntityFactory.instance.buildInlineVariable()
				.set(CommonsFeatureDescriptorEnum.varType, CommonsEntityFactory.instance.createVarType(type))
				.set(CommonsFeatureDescriptorEnum.varName, CommonsEntityFactory.instance.createVarName(name))
				.getResult().wGetAdapter(ed);
	}
	public static <E extends IEntity> E createInlineVariable(EntityDescriptor<E> ed, String name, EntityDescriptor<?> type, QuantifierEnum.Value quantifier) {
		return CommonsEntityFactory.instance.createInlineVariable(
				CommonsEntityFactory.instance.createVarType(type),
				CommonsEntityFactory.instance.createVarName(name),
				CommonsEntityFactory.instance.createQuantifier(quantifier)).wGetAdapter(ed);
	}
}
