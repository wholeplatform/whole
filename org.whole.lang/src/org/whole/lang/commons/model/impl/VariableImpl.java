package org.whole.lang.commons.model.impl;

import org.whole.lang.commons.model.Quantifier;
import org.whole.lang.commons.model.VarName;
import org.whole.lang.commons.model.VarType;
import org.whole.lang.commons.model.Variable;
import org.whole.lang.commons.reflect.CommonsEntityDescriptorEnum;
import org.whole.lang.commons.reflect.CommonsFeatureDescriptorEnum;
import org.whole.lang.commons.visitors.ICommonsVisitor;
import org.whole.lang.matchers.GenericMatcher;
import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class VariableImpl extends AbstractSimpleEntity implements Variable {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<Variable> wGetEntityDescriptor() {
		return CommonsEntityDescriptorEnum.Variable;
	}

	public int wGetEntityOrd() {
		return CommonsEntityDescriptorEnum.Variable_ord;
	}

    public void wAccept(GenericMatcher matcher, IEntity other) {
    	matcher.matchEntityVariable(this, other);
    }
	public void accept(ICommonsVisitor visitor) {
		visitor.visit(this);
	}

	private VarType varType;

	public VarType getVarType() {
		return notifyRequested(CommonsFeatureDescriptorEnum.varType, varType);
	}

	public void setVarType(VarType varType) {
		notifyChanged(CommonsFeatureDescriptorEnum.varType, this.varType,
				this.varType = varType);
	}

	private VarName varName;

	public VarName getVarName() {
		return notifyRequested(CommonsFeatureDescriptorEnum.varName, varName);
	}

	public void setVarName(VarName varName) {
		notifyChanged(CommonsFeatureDescriptorEnum.varName, this.varName,
				this.varName = varName);
	}

	private Quantifier quantifier;

	public Quantifier getQuantifier() {
		return notifyRequested(CommonsFeatureDescriptorEnum.quantifier,
				quantifier);
	}

	public void setQuantifier(Quantifier quantifier) {
		notifyChanged(CommonsFeatureDescriptorEnum.quantifier, this.quantifier,
				this.quantifier = quantifier);
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
			setQuantifier(value
					.wGetAdapter(CommonsEntityDescriptorEnum.Quantifier));
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