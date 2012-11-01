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
public class YieldExpressionAdapter extends AbstractEntityAdapter implements
		YieldExpression {
	private static final long serialVersionUID = 1;

	public YieldExpressionAdapter(IEntity implementor) {
		super(implementor);
	}

	public YieldExpressionAdapter() {
	}

	public void accept(IJavaScriptVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<YieldExpression> wGetEntityDescriptor() {
		return JavaScriptEntityDescriptorEnum.YieldExpression;
	}

	public Expression getArgument() {
		return wGet(JavaScriptFeatureDescriptorEnum.argument).wGetAdapter(
				JavaScriptEntityDescriptorEnum.Expression);
	}

	public void setArgument(Expression argument) {
		wSet(JavaScriptFeatureDescriptorEnum.argument, argument);
	}
}
