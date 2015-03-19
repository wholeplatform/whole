package org.whole.lang.javascript.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.javascript.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.javascript.reflect.JavaScriptEntityDescriptorEnum;
import org.whole.lang.javascript.visitors.IJavaScriptVisitor;

/** 
 * @generator Whole
 */
public class EmptyExpressionImpl extends AbstractSimpleEntity implements
		EmptyExpression {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<EmptyExpression> wGetEntityDescriptor() {
		return JavaScriptEntityDescriptorEnum.EmptyExpression;
	}

	public int wGetEntityOrd() {
		return JavaScriptEntityDescriptorEnum.EmptyExpression_ord;
	}

	public void accept(IJavaScriptVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}
}
