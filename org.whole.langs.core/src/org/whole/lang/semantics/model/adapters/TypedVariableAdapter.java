package org.whole.lang.semantics.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.semantics.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.semantics.visitors.ISemanticsVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.semantics.reflect.SemanticsEntityDescriptorEnum;
import org.whole.lang.semantics.reflect.SemanticsFeatureDescriptorEnum;

/** 
 * @generator Whole
 */
public class TypedVariableAdapter extends AbstractEntityAdapter implements
		TypedVariable {
	private static final long serialVersionUID = 1;

	public TypedVariableAdapter(IEntity implementor) {
		super(implementor);
	}

	public TypedVariableAdapter() {
	}

	public void accept(ISemanticsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<TypedVariable> wGetEntityDescriptor() {
		return SemanticsEntityDescriptorEnum.TypedVariable;
	}

	public Variable getVariable() {
		return wGet(SemanticsFeatureDescriptorEnum.variable).wGetAdapter(
				SemanticsEntityDescriptorEnum.Variable);
	}

	public void setVariable(Variable variable) {
		wSet(SemanticsFeatureDescriptorEnum.variable, variable);
	}

	public Num getIndex() {
		return wGet(SemanticsFeatureDescriptorEnum.index).wGetAdapter(
				SemanticsEntityDescriptorEnum.Num);
	}

	public void setIndex(Num index) {
		wSet(SemanticsFeatureDescriptorEnum.index, index);
	}

	public Num getTime() {
		return wGet(SemanticsFeatureDescriptorEnum.time).wGetAdapter(
				SemanticsEntityDescriptorEnum.Num);
	}

	public void setTime(Num time) {
		wSet(SemanticsFeatureDescriptorEnum.time, time);
	}

	public Signature getSignature() {
		return wGet(SemanticsFeatureDescriptorEnum.signature).wGetAdapter(
				SemanticsEntityDescriptorEnum.Signature);
	}

	public void setSignature(Signature signature) {
		wSet(SemanticsFeatureDescriptorEnum.signature, signature);
	}
}
