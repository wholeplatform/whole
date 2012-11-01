package org.whole.lang.javascript.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.javascript.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.javascript.visitors.IJavaScriptVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.javascript.reflect.JavaScriptEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class EmptyExpressionAdapter extends AbstractEntityAdapter implements
		EmptyExpression {
	private static final long serialVersionUID = 1;

	public EmptyExpressionAdapter(IEntity implementor) {
		super(implementor);
	}

	public EmptyExpressionAdapter() {
	}

	public void accept(IJavaScriptVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<EmptyExpression> wGetEntityDescriptor() {
		return JavaScriptEntityDescriptorEnum.EmptyExpression;
	}
}
