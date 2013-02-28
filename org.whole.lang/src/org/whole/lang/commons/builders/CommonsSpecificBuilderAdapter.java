/**
 * Copyright 2004-2013 Riccardo Solmi. All rights reserved.
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

import static org.whole.lang.commons.reflect.CommonsEntityDescriptorEnum.Any;
import static org.whole.lang.commons.reflect.CommonsEntityDescriptorEnum.InlineVariable;
import static org.whole.lang.commons.reflect.CommonsEntityDescriptorEnum.Multiplexer;
import static org.whole.lang.commons.reflect.CommonsEntityDescriptorEnum.Quantifier;
import static org.whole.lang.commons.reflect.CommonsEntityDescriptorEnum.Resolver;
import static org.whole.lang.commons.reflect.CommonsEntityDescriptorEnum.RootFragment;
import static org.whole.lang.commons.reflect.CommonsEntityDescriptorEnum.SameStageFragment;
import static org.whole.lang.commons.reflect.CommonsEntityDescriptorEnum.StageDownFragment;
import static org.whole.lang.commons.reflect.CommonsEntityDescriptorEnum.StageUpFragment;
import static org.whole.lang.commons.reflect.CommonsEntityDescriptorEnum.VarName;
import static org.whole.lang.commons.reflect.CommonsEntityDescriptorEnum.VarType;
import static org.whole.lang.commons.reflect.CommonsEntityDescriptorEnum.Variable;

import org.whole.lang.builders.GenericBuilderContext;
import org.whole.lang.builders.IBuilder;
import org.whole.lang.commons.model.QuantifierEnum;
import org.whole.lang.contexts.IEntityContext;
import org.whole.lang.reflect.EntityDescriptor;

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

	public void RootFragment() {
		wEntity(RootFragment);
	}
	public void RootFragment_() {
		wEntity_(RootFragment);
	}
	public void _RootFragment() {
		_wEntity(RootFragment);
	}

	public void SameStageFragment() {
		wEntity(SameStageFragment);
	}
	public void SameStageFragment_() {
		wEntity_(SameStageFragment);
	}
	public void _SameStageFragment() {
		_wEntity(SameStageFragment);
	}

	public void StageUpFragment() {
		wEntity(StageUpFragment);
	}
	public void StageUpFragment_() {
		wEntity_(StageUpFragment);
	}
	public void _StageUpFragment() {
		_wEntity(StageUpFragment);
	}

	public void StageDownFragment() {
		wEntity(StageDownFragment);
	}
	public void StageDownFragment_() {
		wEntity_(StageDownFragment);
	}
	public void _StageDownFragment() {
		_wEntity(StageDownFragment);
	}

	public void Any() {
		wEntity(Any);
	}

	public void Resolver() {
		wEntity(Resolver);
	}
//	public void Resolver_() {
//		wEntity_(Resolver);
//	}
//	public void _Resolver() {
//		_wEntity(Resolver);
//	}

	public void Multiplexer() {
		wEntity(Multiplexer);
	}
	public void Multiplexer_() {
		wEntity_(Multiplexer);
	}
	public void Multiplexer_(int initialCapacity) {
		wEntity_(Multiplexer, initialCapacity);
	}
	public void _Multiplexer() {
		_wEntity(Multiplexer);
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
		wEntity_(Variable);
	}
	public void _Variable() {
		_wEntity(Variable);
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
		wEntity_(InlineVariable);
	}
	public void _InlineVariable() {
		_wEntity(InlineVariable);
	}

	public void VarName(String name) {
		wEntity(VarName, name);
	}
	public void VarType(EntityDescriptor<?> type) {
		wEntity(VarType, (Object) type);
	}
	public void VarType(String type) {
		wEntity(VarType, type);
	}

	public void Quantifier() {
		wEntity(Quantifier);
	}
	public void Quantifier(QuantifierEnum.Value value) {
		wEntity(Quantifier, value);
	}
	public void Quantifier(String value) {
		wEntity(Quantifier, value);
	}
}
