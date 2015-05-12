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
package org.whole.lang.commons.builders;

import static org.whole.lang.commons.reflect.CommonsEntityDescriptorEnum.*;
import org.whole.lang.builders.GenericIdentityBuilder;
import org.whole.lang.commons.model.QuantifierEnum;
import org.whole.lang.contexts.IEntityContext;
import org.whole.lang.model.EnumValue;
import org.whole.lang.reflect.EntityDescriptor;

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
		case RootFragment_ord:
			specificBuilder.RootFragment();
			break;
		case SameStageFragment_ord:
			specificBuilder.SameStageFragment();
			break;
		case StageUpFragment_ord:
			specificBuilder.StageUpFragment();
			break;
		case StageDownFragment_ord:
			specificBuilder.StageDownFragment();
			break;
		case Resolver_ord:
			specificBuilder.Resolver();
			break;
		case Any_ord:
			specificBuilder.Any();
			break;
		}
	}

	public void wEntity_(EntityDescriptor<?> entityDesc) {
		switch (entityDesc.getOrdinal()) {
		case RootFragment_ord:
			specificBuilder.RootFragment_();
			break;
		case SameStageFragment_ord:
			specificBuilder.SameStageFragment_();
			break;
		case StageUpFragment_ord:
			specificBuilder.StageUpFragment_();
			break;
		case StageDownFragment_ord:
			specificBuilder.StageDownFragment_();
			break;
		case Multiplexer_ord:
			specificBuilder.Multiplexer_();
			break;
		case Variable_ord:
			specificBuilder.Variable_();
			break;
		case InlineVariable_ord:
			specificBuilder.InlineVariable_();
			break;
		}
	}

	public void _wEntity(EntityDescriptor<?> entityDesc) {
		switch (entityDesc.getOrdinal()) {
		case RootFragment_ord:
			specificBuilder._RootFragment();
			break;
		case SameStageFragment_ord:
			specificBuilder._SameStageFragment();
			break;
		case StageUpFragment_ord:
			specificBuilder._StageUpFragment();
			break;
		case StageDownFragment_ord:
			specificBuilder._StageDownFragment();
			break;
		case Multiplexer_ord:
			specificBuilder._Multiplexer();
			break;
		case Variable_ord:
			specificBuilder._Variable();
			break;
		case InlineVariable_ord:
			specificBuilder._InlineVariable();
			break;
		}
	}

	public void wEntity_(EntityDescriptor<?> entityDesc, int initialCapacity) {
		switch (entityDesc.getOrdinal()) {
		case Multiplexer_ord:
			specificBuilder.Multiplexer_(initialCapacity);
			break;
		}
	}

	public void wEntity(EntityDescriptor<?> entityDesc, String value) {
		switch (entityDesc.getOrdinal()) {
		case VarName_ord:
			specificBuilder.VarName(value);
			break;
		}
	}

	public void wEntity(EntityDescriptor<?> entityDesc, EnumValue value) {
		switch (entityDesc.getOrdinal()) {
		case VarType_ord:
			specificBuilder.VarType((EntityDescriptor<?>) value);
			break;
		case Quantifier_ord:
			specificBuilder.Quantifier((QuantifierEnum.Value) value);
			break;
		}
	}
}
