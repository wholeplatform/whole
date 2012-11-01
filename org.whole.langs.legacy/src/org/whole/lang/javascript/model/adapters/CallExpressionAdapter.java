package org.whole.lang.javascript.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.javascript.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.javascript.visitors.IJavaScriptVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.javascript.reflect.JavaScriptEntityDescriptorEnum;
import org.whole.lang.javascript.reflect.JavaScriptFeatureDescriptorEnum;

/** 
 * @generator Whole
 */
public class CallExpressionAdapter extends AbstractEntityAdapter implements
		CallExpression {
	private static final long serialVersionUID = 1;

	public CallExpressionAdapter(IEntity implementor) {
		super(implementor);
	}

	public CallExpressionAdapter() {
	}

	public void accept(IJavaScriptVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<CallExpression> wGetEntityDescriptor() {
		return JavaScriptEntityDescriptorEnum.CallExpression;
	}

	public Expression getCallee() {
		return wGet(JavaScriptFeatureDescriptorEnum.callee).wGetAdapter(
				JavaScriptEntityDescriptorEnum.Expression);
	}

	public void setCallee(Expression callee) {
		wSet(JavaScriptFeatureDescriptorEnum.callee, callee);
	}

	public Expressions getArguments() {
		return wGet(JavaScriptFeatureDescriptorEnum.arguments).wGetAdapter(
				JavaScriptEntityDescriptorEnum.Expressions);
	}

	public void setArguments(Expressions arguments) {
		wSet(JavaScriptFeatureDescriptorEnum.arguments, arguments);
	}
}
