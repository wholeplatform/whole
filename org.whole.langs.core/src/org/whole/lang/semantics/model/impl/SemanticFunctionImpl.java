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
public class SemanticFunctionImpl extends AbstractSimpleEntity implements
		SemanticFunction {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<SemanticFunction> wGetEntityDescriptor() {
		return SemanticsEntityDescriptorEnum.SemanticFunction;
	}

	public int wGetEntityOrd() {
		return SemanticsEntityDescriptorEnum.SemanticFunction_ord;
	}

	public void accept(ISemanticsVisitor visitor) {
		visitor.visit(this);
	}

	private Name name;

	public Name getName() {
		return notifyRequested(SemanticsFeatureDescriptorEnum.name, name);
	}

	public void setName(Name name) {
		notifyChanged(SemanticsFeatureDescriptorEnum.name, this.name,
				this.name = name);
	}

	private FunctionType signature;

	public FunctionType getSignature() {
		return notifyRequested(SemanticsFeatureDescriptorEnum.signature,
				signature);
	}

	public void setSignature(FunctionType signature) {
		notifyChanged(SemanticsFeatureDescriptorEnum.signature, this.signature,
				this.signature = signature);
	}

	private FunctionBody rules;

	public FunctionBody getRules() {
		return notifyRequested(SemanticsFeatureDescriptorEnum.rules, rules);
	}

	public void setRules(FunctionBody rules) {
		notifyChanged(SemanticsFeatureDescriptorEnum.rules, this.rules,
				this.rules = rules);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getName().wGetAdaptee(false);
		case 1:
			return getSignature().wGetAdaptee(false);
		case 2:
			return getRules().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setName(value.wGetAdapter(SemanticsEntityDescriptorEnum.Name));
			break;
		case 1:
			setSignature(value
					.wGetAdapter(SemanticsEntityDescriptorEnum.FunctionType));
			break;
		case 2:
			setRules(value
					.wGetAdapter(SemanticsEntityDescriptorEnum.FunctionBody));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 3;
	}
}
