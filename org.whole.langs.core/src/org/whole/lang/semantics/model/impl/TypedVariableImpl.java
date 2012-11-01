package org.whole.lang.semantics.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.semantics.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.semantics.reflect.SemanticsEntityDescriptorEnum;
import org.whole.lang.semantics.visitors.ISemanticsVisitor;
import org.whole.lang.semantics.reflect.SemanticsFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class TypedVariableImpl extends AbstractSimpleEntity implements
		TypedVariable {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<TypedVariable> wGetEntityDescriptor() {
		return SemanticsEntityDescriptorEnum.TypedVariable;
	}

	public int wGetEntityOrd() {
		return SemanticsEntityDescriptorEnum.TypedVariable_ord;
	}

	public void accept(ISemanticsVisitor visitor) {
		visitor.visit(this);
	}

	private Variable variable;

	public Variable getVariable() {
		return notifyRequested(SemanticsFeatureDescriptorEnum.variable,
				variable);
	}

	public void setVariable(Variable variable) {
		notifyChanged(SemanticsFeatureDescriptorEnum.variable, this.variable,
				this.variable = variable);
	}

	private Num index;

	public Num getIndex() {
		return notifyRequested(SemanticsFeatureDescriptorEnum.index, index);
	}

	public void setIndex(Num index) {
		notifyChanged(SemanticsFeatureDescriptorEnum.index, this.index,
				this.index = index);
	}

	private Num time;

	public Num getTime() {
		return notifyRequested(SemanticsFeatureDescriptorEnum.time, time);
	}

	public void setTime(Num time) {
		notifyChanged(SemanticsFeatureDescriptorEnum.time, this.time,
				this.time = time);
	}

	private Signature signature;

	public Signature getSignature() {
		return notifyRequested(SemanticsFeatureDescriptorEnum.signature,
				signature);
	}

	public void setSignature(Signature signature) {
		notifyChanged(SemanticsFeatureDescriptorEnum.signature, this.signature,
				this.signature = signature);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getVariable().wGetAdaptee(false);
		case 1:
			return getIndex().wGetAdaptee(false);
		case 2:
			return getTime().wGetAdaptee(false);
		case 3:
			return getSignature().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setVariable(value
					.wGetAdapter(SemanticsEntityDescriptorEnum.Variable));
			break;
		case 1:
			setIndex(value.wGetAdapter(SemanticsEntityDescriptorEnum.Num));
			break;
		case 2:
			setTime(value.wGetAdapter(SemanticsEntityDescriptorEnum.Num));
			break;
		case 3:
			setSignature(value
					.wGetAdapter(SemanticsEntityDescriptorEnum.Signature));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 4;
	}
}
