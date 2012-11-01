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
public class XmlExpressionAdapter extends AbstractEntityAdapter implements
		XmlExpression {
	private static final long serialVersionUID = 1;

	public XmlExpressionAdapter(IEntity implementor) {
		super(implementor);
	}

	public XmlExpressionAdapter() {
	}

	public void accept(IJavaScriptVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<XmlExpression> wGetEntityDescriptor() {
		return JavaScriptEntityDescriptorEnum.XmlExpression;
	}

	public Expression getExpression() {
		return wGet(JavaScriptFeatureDescriptorEnum.expression).wGetAdapter(
				JavaScriptEntityDescriptorEnum.Expression);
	}

	public void setExpression(Expression expression) {
		wSet(JavaScriptFeatureDescriptorEnum.expression, expression);
	}
}
