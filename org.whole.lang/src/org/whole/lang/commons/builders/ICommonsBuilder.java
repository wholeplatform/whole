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

import org.whole.lang.builders.IBuilder;
import org.whole.lang.commons.model.QuantifierEnum;
import org.whole.lang.reflect.EntityDescriptor;

/**
 * @author Riccardo Solmi
 */
public interface ICommonsBuilder extends IBuilder {
	public void visit();

	public void quantifier();

	public void varName();

	public void varType();

	public void phase();

	public void rootEntity();

	public void Resolver();

//	public void Resolver_();

//	public void _Resolver();

	public void RootFragment();

	public void RootFragment_();

	public void _RootFragment();

	public void SameStageFragment();

	public void SameStageFragment_();

	public void _SameStageFragment();

	public void StageUpFragment();

	public void StageUpFragment_();

	public void _StageUpFragment();

	public void StageDownFragment();

	public void StageDownFragment_();

	public void _StageDownFragment();

	public void TemplateFragment();

	public void TemplateFragment_();

	public void _TemplateFragment();

	public void BaseFragment();

	public void BaseFragment_();

	public void _BaseFragment();

	public void Phase();

	public void Phase(String value);

	public void Multiplexer();

	public void Multiplexer_();

	public void Multiplexer_(int initialCapacity);

	public void _Multiplexer();

	public void Variable(String name, EntityDescriptor<?> type, QuantifierEnum.Value quantifier);
	public void Variable(String name, String type, String quantifier);
	public void Variable_();
	public void _Variable();
	public void InlineVariable(String name, EntityDescriptor<?> type, QuantifierEnum.Value quantifier);
	public void InlineVariable(String name, String type, String quantifier);
	public void InlineVariable_();

	public void _InlineVariable();
	public void VarName(String value);

	public void VarType(EntityDescriptor<?> type);
	public void VarType(String value);

	public void Quantifier();

	public void Quantifier(QuantifierEnum.Value value);

	public void Quantifier(String value);
}
