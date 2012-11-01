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
public class NewExpressionAdapter extends AbstractEntityAdapter implements
		NewExpression {
	private static final long serialVersionUID = 1;

	public NewExpressionAdapter(IEntity implementor) {
		super(implementor);
	}

	public NewExpressionAdapter() {
	}

	public void accept(IJavaScriptVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<NewExpression> wGetEntityDescriptor() {
		return JavaScriptEntityDescriptorEnum.NewExpression;
	}

	public Expression getConstructor() {
		return wGet(JavaScriptFeatureDescriptorEnum.constructor).wGetAdapter(
				JavaScriptEntityDescriptorEnum.Expression);
	}

	public void setConstructor(Expression constructor) {
		wSet(JavaScriptFeatureDescriptorEnum.constructor, constructor);
	}

	public Expressions getArguments() {
		return wGet(JavaScriptFeatureDescriptorEnum.arguments).wGetAdapter(
				JavaScriptEntityDescriptorEnum.Expressions);
	}

	public void setArguments(Expressions arguments) {
		wSet(JavaScriptFeatureDescriptorEnum.arguments, arguments);
	}
}
