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
public class StaticMemberExpressionAdapter extends AbstractEntityAdapter
		implements StaticMemberExpression {
	private static final long serialVersionUID = 1;

	public StaticMemberExpressionAdapter(IEntity implementor) {
		super(implementor);
	}

	public StaticMemberExpressionAdapter() {
	}

	public void accept(IJavaScriptVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<StaticMemberExpression> wGetEntityDescriptor() {
		return JavaScriptEntityDescriptorEnum.StaticMemberExpression;
	}

	public Expression getObject() {
		return wGet(JavaScriptFeatureDescriptorEnum.object).wGetAdapter(
				JavaScriptEntityDescriptorEnum.Expression);
	}

	public void setObject(Expression object) {
		wSet(JavaScriptFeatureDescriptorEnum.object, object);
	}

	public IdentifierOrXmlAny getProperty() {
		return wGet(JavaScriptFeatureDescriptorEnum.property).wGetAdapter(
				JavaScriptEntityDescriptorEnum.IdentifierOrXmlAny);
	}

	public void setProperty(IdentifierOrXmlAny property) {
		wSet(JavaScriptFeatureDescriptorEnum.property, property);
	}
}
