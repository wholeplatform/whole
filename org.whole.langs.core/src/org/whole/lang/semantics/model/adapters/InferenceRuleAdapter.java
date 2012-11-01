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
public class InferenceRuleAdapter extends AbstractEntityAdapter implements
		InferenceRule {
	private static final long serialVersionUID = 1;

	public InferenceRuleAdapter(IEntity implementor) {
		super(implementor);
	}

	public InferenceRuleAdapter() {
	}

	public void accept(ISemanticsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<InferenceRule> wGetEntityDescriptor() {
		return SemanticsEntityDescriptorEnum.InferenceRule;
	}

	public RuleName getName() {
		return wGet(SemanticsFeatureDescriptorEnum.name).wGetAdapter(
				SemanticsEntityDescriptorEnum.RuleName);
	}

	public void setName(RuleName name) {
		wSet(SemanticsFeatureDescriptorEnum.name, name);
	}

	public Premises getPremises() {
		return wGet(SemanticsFeatureDescriptorEnum.premises).wGetAdapter(
				SemanticsEntityDescriptorEnum.Premises);
	}

	public void setPremises(Premises premises) {
		wSet(SemanticsFeatureDescriptorEnum.premises, premises);
	}

	public Transition getConclusion() {
		return wGet(SemanticsFeatureDescriptorEnum.conclusion).wGetAdapter(
				SemanticsEntityDescriptorEnum.Transition);
	}

	public void setConclusion(Transition conclusion) {
		wSet(SemanticsFeatureDescriptorEnum.conclusion, conclusion);
	}

	public Predicate getCondition() {
		return wGet(SemanticsFeatureDescriptorEnum.condition).wGetAdapter(
				SemanticsEntityDescriptorEnum.Predicate);
	}

	public void setCondition(Predicate condition) {
		wSet(SemanticsFeatureDescriptorEnum.condition, condition);
	}
}
