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
public class ReturnStatementImpl extends AbstractSimpleEntity implements
		ReturnStatement {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<ReturnStatement> wGetEntityDescriptor() {
		return JavaScriptEntityDescriptorEnum.ReturnStatement;
	}

	public int wGetEntityOrd() {
		return JavaScriptEntityDescriptorEnum.ReturnStatement_ord;
	}

	public void accept(IJavaScriptVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	private Expression argument;

	public Expression getArgument() {
		return notifyRequested(JavaScriptFeatureDescriptorEnum.argument,
				argument);
	}

	public void setArgument(Expression argument) {
		notifyChanged(JavaScriptFeatureDescriptorEnum.argument, this.argument,
				this.argument = argument);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getArgument().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setArgument(value
					.wGetAdapter(JavaScriptEntityDescriptorEnum.Expression));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 1;
	}
}
