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

import org.whole.lang.factories.GenericEntityFactory;
import org.whole.lang.commons.model.*;
import org.whole.lang.factories.RegistryConfigurations;
import org.whole.lang.factories.IEntityRegistryProvider;
import org.whole.lang.commons.reflect.CommonsEntityDescriptorEnum;
import org.whole.lang.factories.IEntityBuilder;
import org.whole.lang.factories.EntityBuilder;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class CommonsEntityFactory extends GenericEntityFactory {
	public static final CommonsEntityFactory instance = instance(RegistryConfigurations.DEFAULT);

	public static CommonsEntityFactory instance(IEntityRegistryProvider provider) {
		return new CommonsEntityFactory(provider);
	}

	protected CommonsEntityFactory(IEntityRegistryProvider provider) {
		super(provider);
	}

	public Resolver createResolver() {
		return create(CommonsEntityDescriptorEnum.Resolver);
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

	public TemplateFragment createTemplateFragment() {
		return create(CommonsEntityDescriptorEnum.TemplateFragment);
	}

	public TemplateFragment createTemplateFragment(Phase phase, Any rootEntity) {
		return create(CommonsEntityDescriptorEnum.TemplateFragment, phase, rootEntity);
	}

	public IEntityBuilder<TemplateFragment> buildTemplateFragment() {
		return new EntityBuilder<TemplateFragment>(create(CommonsEntityDescriptorEnum.TemplateFragment));
	}

	public BaseFragment createBaseFragment() {
		return create(CommonsEntityDescriptorEnum.BaseFragment);
	}

	public BaseFragment createBaseFragment(Phase phase, Any rootEntity) {
		return create(CommonsEntityDescriptorEnum.BaseFragment, phase, rootEntity);
	}

	public IEntityBuilder<BaseFragment> buildBaseFragment() {
		return new EntityBuilder<BaseFragment>(create(CommonsEntityDescriptorEnum.BaseFragment));
	}

	public Phase createPhase() {
		return create(CommonsEntityDescriptorEnum.Phase);
	}

	public Phase createPhase(String value) {
		return create(CommonsEntityDescriptorEnum.Phase, value);
	}

	public Multiplexer createMultiplexer() {
		return create(CommonsEntityDescriptorEnum.Multiplexer);
	}

	public Multiplexer createMultiplexer(Any... entities) {
		return create(CommonsEntityDescriptorEnum.Multiplexer, (IEntity[]) entities);
	}

	public Multiplexer createMultiplexer(int initialSize) {
		return clone(CommonsEntityDescriptorEnum.Multiplexer, initialSize);
	}

	public Variable createVariable() {
		return create(CommonsEntityDescriptorEnum.Variable);
	}

	public Variable createVariable(VarType varType, VarName varName, Quantifier quantifier) {
		return create(CommonsEntityDescriptorEnum.Variable, varType, varName, quantifier);
	}

	public IEntityBuilder<Variable> buildVariable() {
		return new EntityBuilder<Variable>(create(CommonsEntityDescriptorEnum.Variable));
	}

	public InlineVariable createInlineVariable() {
		return create(CommonsEntityDescriptorEnum.InlineVariable);
	}

	public InlineVariable createInlineVariable(VarType varType, VarName varName, Quantifier quantifier) {
		return create(CommonsEntityDescriptorEnum.InlineVariable, varType, varName, quantifier);
	}

	public IEntityBuilder<InlineVariable> buildInlineVariable() {
		return new EntityBuilder<InlineVariable>(create(CommonsEntityDescriptorEnum.InlineVariable));
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

	public VarType createVarType(org.whole.lang.reflect.EntityDescriptor<?> value) {
		return create(CommonsEntityDescriptorEnum.VarType, (java.lang.Object) value);
	}

	public Quantifier createQuantifier() {
		return create(CommonsEntityDescriptorEnum.Quantifier);
	}

	public Quantifier createQuantifier(QuantifierEnum.Value value) {
		return create(CommonsEntityDescriptorEnum.Quantifier, value);
	}
}
