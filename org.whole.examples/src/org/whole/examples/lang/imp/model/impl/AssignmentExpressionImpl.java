package org.whole.examples.lang.imp.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.examples.lang.imp.model.AssignmentExpression;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.examples.lang.imp.reflect.ImpEntityDescriptorEnum;
import org.whole.examples.lang.imp.visitors.IImpVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.examples.lang.imp.model.Name;
import org.whole.examples.lang.imp.reflect.ImpFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.examples.lang.imp.model.Expression;

/** 
 * @generator Whole
 */
public class AssignmentExpressionImpl extends AbstractSimpleEntity implements AssignmentExpression {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<AssignmentExpression> wGetEntityDescriptor() {
		return ImpEntityDescriptorEnum.AssignmentExpression;
	}

	public int wGetEntityOrd() {
		return ImpEntityDescriptorEnum.AssignmentExpression_ord;
	}

	public void accept(IImpVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	private Name name;

	public Name getName() {
		return notifyRequested(ImpFeatureDescriptorEnum.name, name);
	}

	public void setName(Name name) {
		notifyChanged(ImpFeatureDescriptorEnum.name, this.name, this.name = name);
	}

	private Expression exp;

	public Expression getExp() {
		return notifyRequested(ImpFeatureDescriptorEnum.exp, exp);
	}

	public void setExp(Expression exp) {
		notifyChanged(ImpFeatureDescriptorEnum.exp, this.exp, this.exp = exp);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getName().wGetAdaptee(false);
		case 1:
			return getExp().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setName(value.wGetAdapter(ImpEntityDescriptorEnum.Name));
			break;
		case 1:
			setExp(value.wGetAdapter(ImpEntityDescriptorEnum.Expression));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 2;
	}
}
