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
public class XmlDefaultNamespaceAdapter extends AbstractEntityAdapter implements
		XmlDefaultNamespace {
	private static final long serialVersionUID = 1;

	public XmlDefaultNamespaceAdapter(IEntity implementor) {
		super(implementor);
	}

	public XmlDefaultNamespaceAdapter() {
	}

	public void accept(IJavaScriptVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<XmlDefaultNamespace> wGetEntityDescriptor() {
		return JavaScriptEntityDescriptorEnum.XmlDefaultNamespace;
	}

	public Expression getOperand() {
		return wGet(JavaScriptFeatureDescriptorEnum.operand).wGetAdapter(
				JavaScriptEntityDescriptorEnum.Expression);
	}

	public void setOperand(Expression operand) {
		wSet(JavaScriptFeatureDescriptorEnum.operand, operand);
	}
}
