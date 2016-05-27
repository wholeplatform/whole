package org.whole.lang.commons.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.commons.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.commons.visitors.ICommonsVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.commons.reflect.CommonsEntityDescriptorEnum;
import org.whole.lang.commons.reflect.CommonsFeatureDescriptorEnum;

/** 
 * @generator Whole
 */
public class VariableAdapter extends AbstractEntityAdapter implements Variable {
	private static final long serialVersionUID = 1;

	public VariableAdapter(IEntity implementor) {
		super(implementor);
	}

	public VariableAdapter() {
	}

	public void accept(ICommonsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Variable> wGetEntityDescriptor() {
		return CommonsEntityDescriptorEnum.Variable;
	}

	public VarType getVarType() {
		return wGet(CommonsFeatureDescriptorEnum.varType).wGetAdapter(CommonsEntityDescriptorEnum.VarType);
	}

	public void setVarType(VarType varType) {
		wSet(CommonsFeatureDescriptorEnum.varType, varType);
	}

	public VarName getVarName() {
		return wGet(CommonsFeatureDescriptorEnum.varName).wGetAdapter(CommonsEntityDescriptorEnum.VarName);
	}

	public void setVarName(VarName varName) {
		wSet(CommonsFeatureDescriptorEnum.varName, varName);
	}

	public Quantifier getQuantifier() {
		return wGet(CommonsFeatureDescriptorEnum.quantifier).wGetAdapter(CommonsEntityDescriptorEnum.Quantifier);
	}

	public void setQuantifier(Quantifier quantifier) {
		wSet(CommonsFeatureDescriptorEnum.quantifier, quantifier);
	}
}
