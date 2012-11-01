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
public class ExecutionRuleAdapter extends AbstractEntityAdapter implements
		ExecutionRule {
	private static final long serialVersionUID = 1;

	public ExecutionRuleAdapter(IEntity implementor) {
		super(implementor);
	}

	public ExecutionRuleAdapter() {
	}

	public void accept(ISemanticsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<ExecutionRule> wGetEntityDescriptor() {
		return SemanticsEntityDescriptorEnum.ExecutionRule;
	}

	public Name getName() {
		return wGet(SemanticsFeatureDescriptorEnum.name).wGetAdapter(
				SemanticsEntityDescriptorEnum.Name);
	}

	public void setName(Name name) {
		wSet(SemanticsFeatureDescriptorEnum.name, name);
	}

	public Predicate getCondition() {
		return wGet(SemanticsFeatureDescriptorEnum.condition).wGetAdapter(
				SemanticsEntityDescriptorEnum.Predicate);
	}

	public void setCondition(Predicate condition) {
		wSet(SemanticsFeatureDescriptorEnum.condition, condition);
	}

	public Expression getMeaning() {
		return wGet(SemanticsFeatureDescriptorEnum.meaning).wGetAdapter(
				SemanticsEntityDescriptorEnum.Expression);
	}

	public void setMeaning(Expression meaning) {
		wSet(SemanticsFeatureDescriptorEnum.meaning, meaning);
	}
}
