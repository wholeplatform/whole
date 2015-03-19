package org.whole.lang.javascript.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.javascript.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.javascript.reflect.JavaScriptEntityDescriptorEnum;
import org.whole.lang.javascript.visitors.IJavaScriptVisitor;
import org.whole.lang.javascript.reflect.JavaScriptFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class BreakStatementImpl extends AbstractSimpleEntity implements
		BreakStatement {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<BreakStatement> wGetEntityDescriptor() {
		return JavaScriptEntityDescriptorEnum.BreakStatement;
	}

	public int wGetEntityOrd() {
		return JavaScriptEntityDescriptorEnum.BreakStatement_ord;
	}

	public void accept(IJavaScriptVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	private Identifier target;

	public Identifier getTarget() {
		return notifyRequested(JavaScriptFeatureDescriptorEnum.target, target);
	}

	public void setTarget(Identifier target) {
		notifyChanged(JavaScriptFeatureDescriptorEnum.target, this.target,
				this.target = target);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getTarget().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setTarget(value
					.wGetAdapter(JavaScriptEntityDescriptorEnum.Identifier));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 1;
	}
}
