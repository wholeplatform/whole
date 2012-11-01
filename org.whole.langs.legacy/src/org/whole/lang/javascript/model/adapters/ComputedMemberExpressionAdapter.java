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
public class ComputedMemberExpressionAdapter extends AbstractEntityAdapter
		implements ComputedMemberExpression {
	private static final long serialVersionUID = 1;

	public ComputedMemberExpressionAdapter(IEntity implementor) {
		super(implementor);
	}

	public ComputedMemberExpressionAdapter() {
	}

	public void accept(IJavaScriptVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<ComputedMemberExpression> wGetEntityDescriptor() {
		return JavaScriptEntityDescriptorEnum.ComputedMemberExpression;
	}

	public Expression getObject() {
		return wGet(JavaScriptFeatureDescriptorEnum.object).wGetAdapter(
				JavaScriptEntityDescriptorEnum.Expression);
	}

	public void setObject(Expression object) {
		wSet(JavaScriptFeatureDescriptorEnum.object, object);
	}

	public Expression getExpression() {
		return wGet(JavaScriptFeatureDescriptorEnum.expression).wGetAdapter(
				JavaScriptEntityDescriptorEnum.Expression);
	}

	public void setExpression(Expression expression) {
		wSet(JavaScriptFeatureDescriptorEnum.expression, expression);
	}
}
