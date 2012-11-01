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
public class IfTemplateImpl extends AbstractSimpleEntity implements IfTemplate {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<IfTemplate> wGetEntityDescriptor() {
		return SemanticsEntityDescriptorEnum.IfTemplate;
	}

	public int wGetEntityOrd() {
		return SemanticsEntityDescriptorEnum.IfTemplate_ord;
	}

	public void accept(ISemanticsVisitor visitor) {
		visitor.visit(this);
	}

	private Expression expression;

	public Expression getExpression() {
		return notifyRequested(SemanticsFeatureDescriptorEnum.expression,
				expression);
	}

	public void setExpression(Expression expression) {
		notifyChanged(SemanticsFeatureDescriptorEnum.expression,
				this.expression, this.expression = expression);
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
			return getExpression().wGetAdaptee(false);
		case 1:
			return getCondition().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setExpression(value
					.wGetAdapter(SemanticsEntityDescriptorEnum.Expression));
			break;
		case 1:
			setCondition(value
					.wGetAdapter(SemanticsEntityDescriptorEnum.Predicate));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 2;
	}
}
