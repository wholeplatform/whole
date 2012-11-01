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
public class ThrowStatementImpl extends AbstractSimpleEntity implements
		ThrowStatement {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<ThrowStatement> wGetEntityDescriptor() {
		return JavaScriptEntityDescriptorEnum.ThrowStatement;
	}

	public int wGetEntityOrd() {
		return JavaScriptEntityDescriptorEnum.ThrowStatement_ord;
	}

	public void accept(IJavaScriptVisitor visitor) {
		visitor.visit(this);
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
