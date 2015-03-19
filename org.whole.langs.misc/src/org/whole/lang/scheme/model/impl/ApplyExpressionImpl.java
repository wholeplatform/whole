package org.whole.lang.scheme.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.scheme.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.scheme.reflect.SchemeEntityDescriptorEnum;
import org.whole.lang.scheme.visitors.ISchemeVisitor;
import org.whole.lang.scheme.reflect.SchemeFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class ApplyExpressionImpl extends AbstractSimpleEntity implements
		ApplyExpression {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<ApplyExpression> wGetEntityDescriptor() {
		return SchemeEntityDescriptorEnum.ApplyExpression;
	}

	public int wGetEntityOrd() {
		return SchemeEntityDescriptorEnum.ApplyExpression_ord;
	}

	public void accept(ISchemeVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	private SchemeExpressions expressions;

	public SchemeExpressions getExpressions() {
		return notifyRequested(SchemeFeatureDescriptorEnum.expressions,
				expressions);
	}

	public void setExpressions(SchemeExpressions expressions) {
		notifyChanged(SchemeFeatureDescriptorEnum.expressions,
				this.expressions, this.expressions = expressions);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getExpressions().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setExpressions(value
					.wGetAdapter(SchemeEntityDescriptorEnum.SchemeExpressions));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 1;
	}
}
