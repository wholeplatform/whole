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

import org.whole.lang.builders.GenericIdentityBuilder;
import org.whole.lang.contexts.IEntityContext;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.commons.reflect.CommonsEntityDescriptorEnum;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.commons.reflect.CommonsFeatureDescriptorEnum;
import org.whole.lang.model.EnumValue;
import org.whole.lang.commons.model.QuantifierEnum.Value;

/**
 * @author Riccardo Solmi
 */
public class CommonsGenericBuilderAdapter extends GenericIdentityBuilder {
	private ICommonsBuilder specificBuilder;

	public CommonsGenericBuilderAdapter(ICommonsBuilder specificBuilder) {
		this.specificBuilder = specificBuilder;
	}

	public CommonsGenericBuilderAdapter(ICommonsBuilder specificBuilder, IEntityContext entityContext) {
		this(specificBuilder);
		wSetEntityContext(entityContext);
	}

	public void visit() {
	}

	public void wEntity(EntityDescriptor<?> entityDesc) {
		switch (entityDesc.getOrdinal()) {
		case CommonsEntityDescriptorEnum.Resolver_ord:
			specificBuilder.Resolver();
			break;
		case CommonsEntityDescriptorEnum.RootFragment_ord:
			specificBuilder.RootFragment();
			break;
		case CommonsEntityDescriptorEnum.SameStageFragment_ord:
			specificBuilder.SameStageFragment();
			break;
		case CommonsEntityDescriptorEnum.StageUpFragment_ord:
			specificBuilder.StageUpFragment();
			break;
		case CommonsEntityDescriptorEnum.StageDownFragment_ord:
			specificBuilder.StageDownFragment();
			break;
		case CommonsEntityDescriptorEnum.TemplateFragment_ord:
			specificBuilder.TemplateFragment();
			break;
		case CommonsEntityDescriptorEnum.BaseFragment_ord:
			specificBuilder.BaseFragment();
			break;
		}
	}

	public void wEntity_(EntityDescriptor<?> entityDesc) {
		switch (entityDesc.getOrdinal()) {
		case CommonsEntityDescriptorEnum.RootFragment_ord:
			specificBuilder.RootFragment_();
			break;
		case CommonsEntityDescriptorEnum.SameStageFragment_ord:
			specificBuilder.SameStageFragment_();
			break;
		case CommonsEntityDescriptorEnum.StageUpFragment_ord:
			specificBuilder.StageUpFragment_();
			break;
		case CommonsEntityDescriptorEnum.StageDownFragment_ord:
			specificBuilder.StageDownFragment_();
			break;
		case CommonsEntityDescriptorEnum.TemplateFragment_ord:
			specificBuilder.TemplateFragment_();
			break;
		case CommonsEntityDescriptorEnum.BaseFragment_ord:
			specificBuilder.BaseFragment_();
			break;
		case CommonsEntityDescriptorEnum.Multiplexer_ord:
			specificBuilder.Multiplexer_();
			break;
		case CommonsEntityDescriptorEnum.Variable_ord:
			specificBuilder.Variable_();
			break;
		case CommonsEntityDescriptorEnum.InlineVariable_ord:
			specificBuilder.InlineVariable_();
			break;
		}
	}

	public void _wEntity(EntityDescriptor<?> entityDesc) {
		switch (entityDesc.getOrdinal()) {
		case CommonsEntityDescriptorEnum.RootFragment_ord:
			specificBuilder._RootFragment();
			break;
		case CommonsEntityDescriptorEnum.SameStageFragment_ord:
			specificBuilder._SameStageFragment();
			break;
		case CommonsEntityDescriptorEnum.StageUpFragment_ord:
			specificBuilder._StageUpFragment();
			break;
		case CommonsEntityDescriptorEnum.StageDownFragment_ord:
			specificBuilder._StageDownFragment();
			break;
		case CommonsEntityDescriptorEnum.TemplateFragment_ord:
			specificBuilder._TemplateFragment();
			break;
		case CommonsEntityDescriptorEnum.BaseFragment_ord:
			specificBuilder._BaseFragment();
			break;
		case CommonsEntityDescriptorEnum.Multiplexer_ord:
			specificBuilder._Multiplexer();
			break;
		case CommonsEntityDescriptorEnum.Variable_ord:
			specificBuilder._Variable();
			break;
		case CommonsEntityDescriptorEnum.InlineVariable_ord:
			specificBuilder._InlineVariable();
			break;
		}
	}

	public void wFeature(FeatureDescriptor featureDesc) {
		switch (featureDesc.getOrdinal()) {
		case CommonsFeatureDescriptorEnum.rootEntity_ord:
			specificBuilder.rootEntity();
			break;
		case CommonsFeatureDescriptorEnum.phase_ord:
			specificBuilder.phase();
			break;
		case CommonsFeatureDescriptorEnum.varType_ord:
			specificBuilder.varType();
			break;
		case CommonsFeatureDescriptorEnum.varName_ord:
			specificBuilder.varName();
			break;
		case CommonsFeatureDescriptorEnum.quantifier_ord:
			specificBuilder.quantifier();
			break;
		}
	}

	public void wEntity(EntityDescriptor<?> entityDesc, String value) {
		switch (entityDesc.getOrdinal()) {
		case CommonsEntityDescriptorEnum.Phase_ord:
			specificBuilder.Phase(value);
			break;
		case CommonsEntityDescriptorEnum.VarName_ord:
			specificBuilder.VarName(value);
			break;
		}
	}

	public void wEntity_(EntityDescriptor<?> entityDesc, int initialCapacity) {
		switch (entityDesc.getOrdinal()) {
		case CommonsEntityDescriptorEnum.Multiplexer_ord:
			specificBuilder.Multiplexer_(initialCapacity);
			break;
		}
	}

	public void wEntity(EntityDescriptor<?> entityDesc, EnumValue value) {
		switch (entityDesc.getOrdinal()) {
		case CommonsEntityDescriptorEnum.VarType_ord:
			specificBuilder.VarType((EntityDescriptor<?>) value);
			break;
		case CommonsEntityDescriptorEnum.Quantifier_ord:
			specificBuilder.Quantifier((Value) value);
			break;
		}
	}
}
