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
public class InferenceRuleImpl extends AbstractSimpleEntity implements
		InferenceRule {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<InferenceRule> wGetEntityDescriptor() {
		return SemanticsEntityDescriptorEnum.InferenceRule;
	}

	public int wGetEntityOrd() {
		return SemanticsEntityDescriptorEnum.InferenceRule_ord;
	}

	public void accept(ISemanticsVisitor visitor) {
		visitor.visit(this);
	}

	private RuleName name;

	public RuleName getName() {
		return notifyRequested(SemanticsFeatureDescriptorEnum.name, name);
	}

	public void setName(RuleName name) {
		notifyChanged(SemanticsFeatureDescriptorEnum.name, this.name,
				this.name = name);
	}

	private Premises premises;

	public Premises getPremises() {
		return notifyRequested(SemanticsFeatureDescriptorEnum.premises,
				premises);
	}

	public void setPremises(Premises premises) {
		notifyChanged(SemanticsFeatureDescriptorEnum.premises, this.premises,
				this.premises = premises);
	}

	private Transition conclusion;

	public Transition getConclusion() {
		return notifyRequested(SemanticsFeatureDescriptorEnum.conclusion,
				conclusion);
	}

	public void setConclusion(Transition conclusion) {
		notifyChanged(SemanticsFeatureDescriptorEnum.conclusion,
				this.conclusion, this.conclusion = conclusion);
	}

	private Predicate condition;

	public Predicate getCondition() {
		return notifyRequested(SemanticsFeatureDescriptorEnum.condition,
				condition);
	}

	public void setCondition(Predicate condition) {
		notifyChanged(SemanticsFeatureDescriptorEnum.condition, this.condition,
				this.condition = condition);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getName().wGetAdaptee(false);
		case 1:
			return getPremises().wGetAdaptee(false);
		case 2:
			return getConclusion().wGetAdaptee(false);
		case 3:
			return getCondition().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setName(value.wGetAdapter(SemanticsEntityDescriptorEnum.RuleName));
			break;
		case 1:
			setPremises(value
					.wGetAdapter(SemanticsEntityDescriptorEnum.Premises));
			break;
		case 2:
			setConclusion(value
					.wGetAdapter(SemanticsEntityDescriptorEnum.Transition));
			break;
		case 3:
			setCondition(value
					.wGetAdapter(SemanticsEntityDescriptorEnum.Predicate));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 4;
	}
}
