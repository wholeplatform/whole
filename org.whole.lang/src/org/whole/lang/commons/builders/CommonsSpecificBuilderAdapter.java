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
package org.whole.lang.commons.builders;

import org.whole.lang.builders.GenericBuilderContext;
import org.whole.lang.builders.IBuilder;
import org.whole.lang.contexts.IEntityContext;
import org.whole.lang.commons.reflect.CommonsEntityDescriptorEnum;
import org.whole.lang.commons.reflect.CommonsFeatureDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.commons.model.QuantifierEnum;

/**
 * @author Riccardo Solmi
 */
public class CommonsSpecificBuilderAdapter extends GenericBuilderContext implements ICommonsBuilder {
	public CommonsSpecificBuilderAdapter(IBuilder strategy) {
		super(strategy);
	}

	public CommonsSpecificBuilderAdapter(IBuilder strategy, IEntityContext entityContext) {
		super(strategy, entityContext);
	}

	public void quantifier() {
		wFeature(CommonsFeatureDescriptorEnum.quantifier);
	}

	public void varName() {
		wFeature(CommonsFeatureDescriptorEnum.varName);
	}

	public void varType() {
		wFeature(CommonsFeatureDescriptorEnum.varType);
	}

	public void phase() {
		wFeature(CommonsFeatureDescriptorEnum.phase);
	}

	public void rootEntity() {
		wFeature(CommonsFeatureDescriptorEnum.rootEntity);
	}

	public void visit() {
	}

	public void Resolver() {
		wEntity(CommonsEntityDescriptorEnum.Resolver);
	}

//	public void Resolver_() {
//		wEntity_(CommonsEntityDescriptorEnum.Resolver);
//	}

//	public void _Resolver() {
//		_wEntity(CommonsEntityDescriptorEnum.Resolver);
//	}
	public void RootFragment() {
		wEntity(CommonsEntityDescriptorEnum.RootFragment);
	}

	public void RootFragment_() {
		wEntity_(CommonsEntityDescriptorEnum.RootFragment);
	}

	public void _RootFragment() {
		_wEntity(CommonsEntityDescriptorEnum.RootFragment);
	}

	public void SameStageFragment() {
		wEntity(CommonsEntityDescriptorEnum.SameStageFragment);
	}

	public void SameStageFragment_() {
		wEntity_(CommonsEntityDescriptorEnum.SameStageFragment);
	}

	public void _SameStageFragment() {
		_wEntity(CommonsEntityDescriptorEnum.SameStageFragment);
	}

	public void StageUpFragment() {
		wEntity(CommonsEntityDescriptorEnum.StageUpFragment);
	}

	public void StageUpFragment_() {
		wEntity_(CommonsEntityDescriptorEnum.StageUpFragment);
	}

	public void _StageUpFragment() {
		_wEntity(CommonsEntityDescriptorEnum.StageUpFragment);
	}

	public void StageDownFragment() {
		wEntity(CommonsEntityDescriptorEnum.StageDownFragment);
	}

	public void StageDownFragment_() {
		wEntity_(CommonsEntityDescriptorEnum.StageDownFragment);
	}

	public void _StageDownFragment() {
		_wEntity(CommonsEntityDescriptorEnum.StageDownFragment);
	}

	public void TemplateFragment() {
		wEntity(CommonsEntityDescriptorEnum.TemplateFragment);
	}

	public void TemplateFragment_() {
		wEntity_(CommonsEntityDescriptorEnum.TemplateFragment);
	}

	public void _TemplateFragment() {
		_wEntity(CommonsEntityDescriptorEnum.TemplateFragment);
	}

	public void BaseFragment() {
		wEntity(CommonsEntityDescriptorEnum.BaseFragment);
	}

	public void BaseFragment_() {
		wEntity_(CommonsEntityDescriptorEnum.BaseFragment);
	}

	public void _BaseFragment() {
		_wEntity(CommonsEntityDescriptorEnum.BaseFragment);
	}

	public void Phase() {
		wEntity(CommonsEntityDescriptorEnum.Phase);
	}

	public void Phase(String value) {
		wEntity(CommonsEntityDescriptorEnum.Phase, value);
	}

	public void Multiplexer() {
		wEntity(CommonsEntityDescriptorEnum.Multiplexer);
	}

	public void Multiplexer_() {
		wEntity_(CommonsEntityDescriptorEnum.Multiplexer);
	}

	public void Multiplexer_(int initialCapacity) {
		wEntity_(CommonsEntityDescriptorEnum.Multiplexer, initialCapacity);
	}

	public void _Multiplexer() {
		_wEntity(CommonsEntityDescriptorEnum.Multiplexer);
	}

	public void Variable(String name, EntityDescriptor<?> type, QuantifierEnum.Value quantifier) {
		Variable_();
		VarType(type);
		VarName(name);
		Quantifier(quantifier);
		_Variable();
	}
	public void Variable(String name, String type, String quantifier) {
		Variable_();
		VarType(type);
		VarName(name);
		Quantifier(quantifier);
		_Variable();
	}
	public void Variable_() {
		wEntity_(CommonsEntityDescriptorEnum.Variable);
	}

	public void _Variable() {
		_wEntity(CommonsEntityDescriptorEnum.Variable);
	}

	public void InlineVariable(String name, EntityDescriptor<?> type, QuantifierEnum.Value quantifier) {
		InlineVariable_();
		VarType(type);
		VarName(name);
		Quantifier(quantifier);
		_InlineVariable();
	}
	public void InlineVariable(String name, String type, String quantifier) {
		InlineVariable_();
		VarType(type);
		VarName(name);
		Quantifier(quantifier);
		_InlineVariable();
	}
	public void InlineVariable_() {
		wEntity_(CommonsEntityDescriptorEnum.InlineVariable);
	}

	public void _InlineVariable() {
		_wEntity(CommonsEntityDescriptorEnum.InlineVariable);
	}

	public void VarName(String value) {
		wEntity(CommonsEntityDescriptorEnum.VarName, value);
	}
	public void VarType(EntityDescriptor<?> value) {
		wEntity(CommonsEntityDescriptorEnum.VarType, (Object) value);
	}
	public void VarType(String value) {
		wEntity(CommonsEntityDescriptorEnum.VarType, value);
	}

	public void Quantifier() {
		wEntity(CommonsEntityDescriptorEnum.Quantifier);
	}

	public void Quantifier(QuantifierEnum.Value value) {
		wEntity(CommonsEntityDescriptorEnum.Quantifier, value);
	}

	public void Quantifier(String value) {
		wEntity(CommonsEntityDescriptorEnum.Quantifier, value);
	}
}
