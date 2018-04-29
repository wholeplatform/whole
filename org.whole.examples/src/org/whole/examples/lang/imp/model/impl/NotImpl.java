package org.whole.examples.lang.imp.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.examples.lang.imp.model.Not;
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
public class NotImpl extends AbstractSimpleEntity implements Not {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<Not> wGetEntityDescriptor() {
		return ImpEntityDescriptorEnum.Not;
	}

	public int wGetEntityOrd() {
		return ImpEntityDescriptorEnum.Not_ord;
	}

	public void accept(IImpVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
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
			return getExp().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setExp(value.wGetAdapter(ImpEntityDescriptorEnum.Expression));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 1;
	}
}
