package org.whole.examples.lang.imp.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.examples.lang.imp.model.Or;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.examples.lang.imp.reflect.ImpEntityDescriptorEnum;
import org.whole.examples.lang.imp.visitors.IImpVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.examples.lang.imp.model.Expression;
import org.whole.examples.lang.imp.reflect.ImpFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class OrImpl extends AbstractSimpleEntity implements Or {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<Or> wGetEntityDescriptor() {
		return ImpEntityDescriptorEnum.Or;
	}

	public int wGetEntityOrd() {
		return ImpEntityDescriptorEnum.Or_ord;
	}

	public void accept(IImpVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	private Expression exp1;

	public Expression getExp1() {
		return notifyRequested(ImpFeatureDescriptorEnum.exp1, exp1);
	}

	public void setExp1(Expression exp1) {
		notifyChanged(ImpFeatureDescriptorEnum.exp1, this.exp1, this.exp1 = exp1);
	}

	private Expression exp2;

	public Expression getExp2() {
		return notifyRequested(ImpFeatureDescriptorEnum.exp2, exp2);
	}

	public void setExp2(Expression exp2) {
		notifyChanged(ImpFeatureDescriptorEnum.exp2, this.exp2, this.exp2 = exp2);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getExp1().wGetAdaptee(false);
		case 1:
			return getExp2().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setExp1(value.wGetAdapter(ImpEntityDescriptorEnum.Expression));
			break;
		case 1:
			setExp2(value.wGetAdapter(ImpEntityDescriptorEnum.Expression));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 2;
	}
}
