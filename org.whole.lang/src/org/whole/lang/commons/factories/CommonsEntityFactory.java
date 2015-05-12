/**
 * Copyright 2004-2015 Riccardo Solmi. All rights reserved.
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

import org.whole.lang.commons.model.Any;
import org.whole.lang.commons.model.InlineVariable;
import org.whole.lang.commons.model.Multiplexer;
import org.whole.lang.commons.model.Quantifier;
import org.whole.lang.commons.model.QuantifierEnum;
import org.whole.lang.commons.model.Resolver;
import org.whole.lang.commons.model.RootFragment;
import org.whole.lang.commons.model.SameStageFragment;
import org.whole.lang.commons.model.StageDownFragment;
import org.whole.lang.commons.model.StageUpFragment;
import org.whole.lang.commons.model.VarName;
import org.whole.lang.commons.model.VarType;
import org.whole.lang.commons.model.Variable;
import org.whole.lang.commons.reflect.CommonsEntityDescriptorEnum;
import org.whole.lang.factories.GenericEntityFactory;
import org.whole.lang.factories.IEntityRegistryProvider;
import org.whole.lang.factories.RegistryConfigurations;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.EntityDescriptor;

/**
 * @author Riccardo Solmi
 */
public class CommonsEntityFactory extends GenericEntityFactory {
	public static final CommonsEntityFactory instance = instance(RegistryConfigurations.DEFAULT);
	public static CommonsEntityFactory instance(IEntityRegistryProvider provider) {
		return new CommonsEntityFactory(provider);
	}
	protected CommonsEntityFactory(IEntityRegistryProvider provider) {
		super(provider);
	}

	public RootFragment createRootFragment() {
		return create(CommonsEntityDescriptorEnum.RootFragment);
	}

	public RootFragment createRootFragment(Any rootEntity) {
		return create(CommonsEntityDescriptorEnum.RootFragment, rootEntity);
	}

	public SameStageFragment createSameStageFragment() {
		return create(CommonsEntityDescriptorEnum.SameStageFragment);
	}

	public SameStageFragment createSameStageFragment(Any rootEntity) {
		return create(CommonsEntityDescriptorEnum.SameStageFragment, rootEntity);
	}

	public StageUpFragment createStageUpFragment() {
		return create(CommonsEntityDescriptorEnum.StageUpFragment);
	}

	public StageUpFragment createStageUpFragment(Any rootEntity) {
		return create(CommonsEntityDescriptorEnum.StageUpFragment, rootEntity);
	}

	public StageDownFragment createStageDownFragment() {
		return create(CommonsEntityDescriptorEnum.StageDownFragment);
	}

	public StageDownFragment createStageDownFragment(Any rootEntity) {
		return create(CommonsEntityDescriptorEnum.StageDownFragment, rootEntity);
	}

	public Resolver createResolver() {
		return create(CommonsEntityDescriptorEnum.Resolver);
	}

	public Multiplexer createMultiplexer() {
		return create(CommonsEntityDescriptorEnum.Multiplexer);
	}

	public Multiplexer createMultiplexer(Any... entities) {
		return create(CommonsEntityDescriptorEnum.Multiplexer,
				(IEntity[]) entities);
	}

	public Multiplexer createMultiplexer(int initialSize) {
		return clone(CommonsEntityDescriptorEnum.Multiplexer, initialSize);
	}

	public Variable createVariable() {
		return create(CommonsEntityDescriptorEnum.Variable);
	}

	public Variable createVariable(String name) {
		return createVariable(name, CommonsEntityDescriptorEnum.Resolver);
	}
	public Variable createVariable(String name, EntityDescriptor<?> type) {
		return create(CommonsEntityDescriptorEnum.Variable, createVarType(type), createVarName(name));
	}
	public Variable createVariable(String name, EntityDescriptor<?> type, QuantifierEnum.Value quantifier) {
		return create(CommonsEntityDescriptorEnum.Variable, createVarType(type), createVarName(name), createQuantifier(quantifier));
	}
	public Variable createVariable(VarType type, VarName name) {
		return create(CommonsEntityDescriptorEnum.Variable, type, name);
	}

	public Variable createVariable(VarType varType, VarName varName,
			Quantifier quantifier) {
		return create(CommonsEntityDescriptorEnum.Variable, varType, varName,
				quantifier);
	}

	public InlineVariable createInlineVariable(String name) {
		return createInlineVariable(name, CommonsEntityDescriptorEnum.Resolver);
	}
	public InlineVariable createInlineVariable(String name, EntityDescriptor<?> type) {
		return create(CommonsEntityDescriptorEnum.InlineVariable, createVarType(type), createVarName(name));
	}
	public InlineVariable createInlineVariable(String name, EntityDescriptor<?> type, QuantifierEnum.Value quantifier) {
		return create(CommonsEntityDescriptorEnum.InlineVariable, createVarType(type), createVarName(name), createQuantifier(quantifier));
	}
	public InlineVariable createInlineVariable(VarType type, VarName name) {
		return create(CommonsEntityDescriptorEnum.InlineVariable, type, name);
	}
	public InlineVariable createInlineVariable(VarType type, VarName name, Quantifier quantifier) {
		return create(CommonsEntityDescriptorEnum.InlineVariable, type, name, quantifier);
	}

	public VarName createVarName() {
		return create(CommonsEntityDescriptorEnum.VarName);
	}

	public VarName createVarName(String value) {
		return create(CommonsEntityDescriptorEnum.VarName, value);
	}

	public VarType createVarType() {
		return create(CommonsEntityDescriptorEnum.VarType);
	}

	public VarType createVarType(org.whole.lang.reflect.EntityDescriptor value) {
		return create(CommonsEntityDescriptorEnum.VarType, value);
	}

	public Quantifier createQuantifier() {
		return create(CommonsEntityDescriptorEnum.Quantifier);
	}

	public Quantifier createQuantifier(QuantifierEnum.Value value) {
		return create(CommonsEntityDescriptorEnum.Quantifier, value);
	}
}
