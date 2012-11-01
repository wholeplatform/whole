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
public class ComputedXmlRefAdapter extends AbstractEntityAdapter implements
		ComputedXmlRef {
	private static final long serialVersionUID = 1;

	public ComputedXmlRefAdapter(IEntity implementor) {
		super(implementor);
	}

	public ComputedXmlRefAdapter() {
	}

	public void accept(IJavaScriptVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<ComputedXmlRef> wGetEntityDescriptor() {
		return JavaScriptEntityDescriptorEnum.ComputedXmlRef;
	}

	public BooleanData getAttribute() {
		return wGet(JavaScriptFeatureDescriptorEnum.attribute).wGetAdapter(
				JavaScriptEntityDescriptorEnum.BooleanData);
	}

	public void setAttribute(BooleanData attribute) {
		wSet(JavaScriptFeatureDescriptorEnum.attribute, attribute);
	}

	public IdentifierOrXmlAny getNamespace() {
		return wGet(JavaScriptFeatureDescriptorEnum.namespace).wGetAdapter(
				JavaScriptEntityDescriptorEnum.IdentifierOrXmlAny);
	}

	public void setNamespace(IdentifierOrXmlAny namespace) {
		wSet(JavaScriptFeatureDescriptorEnum.namespace, namespace);
	}

	public Expression getExpression() {
		return wGet(JavaScriptFeatureDescriptorEnum.expression).wGetAdapter(
				JavaScriptEntityDescriptorEnum.Expression);
	}

	public void setExpression(Expression expression) {
		wSet(JavaScriptFeatureDescriptorEnum.expression, expression);
	}
}
