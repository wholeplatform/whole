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
package org.whole.lang.commons.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.commons.model.InlineVariable;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.commons.reflect.CommonsEntityDescriptorEnum;
import org.whole.lang.commons.visitors.ICommonsVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.matchers.GenericMatcher;
import org.whole.lang.commons.model.VarType;
import org.whole.lang.commons.reflect.CommonsFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.commons.model.VarName;
import org.whole.lang.commons.model.Quantifier;


/**
 * @author Riccardo Solmi
 */
public class InlineVariableImpl extends AbstractSimpleEntity implements InlineVariable {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<InlineVariable> wGetEntityDescriptor() {
		return CommonsEntityDescriptorEnum.InlineVariable;
	}

	public int wGetEntityOrd() {
		return CommonsEntityDescriptorEnum.InlineVariable_ord;
	}

    public void wAccept(GenericMatcher matcher, IEntity other) {
    	matcher.matchEntityVariable(this, other);
    }
	public void accept(ICommonsVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	private VarType varType;

	public VarType getVarType() {
		return notifyRequested(CommonsFeatureDescriptorEnum.varType, varType);
	}

	public void setVarType(VarType varType) {
		notifyChanged(CommonsFeatureDescriptorEnum.varType, this.varType, this.varType = varType);
	}

	private VarName varName;

	public VarName getVarName() {
		return notifyRequested(CommonsFeatureDescriptorEnum.varName, varName);
	}

	public void setVarName(VarName varName) {
		notifyChanged(CommonsFeatureDescriptorEnum.varName, this.varName, this.varName = varName);
	}

	private Quantifier quantifier;

	public Quantifier getQuantifier() {
		return notifyRequested(CommonsFeatureDescriptorEnum.quantifier, quantifier);
	}

	public void setQuantifier(Quantifier quantifier) {
		notifyChanged(CommonsFeatureDescriptorEnum.quantifier, this.quantifier, this.quantifier = quantifier);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getVarType().wGetAdaptee(false);
		case 1:
			return getVarName().wGetAdaptee(false);
		case 2:
			return getQuantifier().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setVarType(value.wGetAdapter(CommonsEntityDescriptorEnum.VarType));
			break;
		case 1:
			setVarName(value.wGetAdapter(CommonsEntityDescriptorEnum.VarName));
			break;
		case 2:
			setQuantifier(value.wGetAdapter(CommonsEntityDescriptorEnum.Quantifier));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 3;
	}

	protected void toString(StringBuffer buffer) {
		buffer.append(wGet(0));
		buffer.append(", ");
		buffer.append(wGet(1));
		buffer.append(wGet(2));
	}
}
