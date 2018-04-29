package org.whole.examples.lang.imp.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.examples.lang.imp.model.ReturnStatement;
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
public class ReturnStatementImpl extends AbstractSimpleEntity implements ReturnStatement {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<ReturnStatement> wGetEntityDescriptor() {
		return ImpEntityDescriptorEnum.ReturnStatement;
	}

	public int wGetEntityOrd() {
		return ImpEntityDescriptorEnum.ReturnStatement_ord;
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
