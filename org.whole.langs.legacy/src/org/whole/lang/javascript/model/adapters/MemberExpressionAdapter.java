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
public class MemberExpressionAdapter extends AbstractEntityAdapter implements
		MemberExpression {
	private static final long serialVersionUID = 1;

	public MemberExpressionAdapter(IEntity implementor) {
		super(implementor);
	}

	public MemberExpressionAdapter() {
	}

	public void accept(IJavaScriptVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<MemberExpression> wGetEntityDescriptor() {
		return JavaScriptEntityDescriptorEnum.MemberExpression;
	}

	public Expression getObject() {
		return wGet(JavaScriptFeatureDescriptorEnum.object).wGetAdapter(
				JavaScriptEntityDescriptorEnum.Expression);
	}

	public void setObject(Expression object) {
		wSet(JavaScriptFeatureDescriptorEnum.object, object);
	}
}
