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
public class XmlDotQueryAdapter extends AbstractEntityAdapter implements
		XmlDotQuery {
	private static final long serialVersionUID = 1;

	public XmlDotQueryAdapter(IEntity implementor) {
		super(implementor);
	}

	public XmlDotQueryAdapter() {
	}

	public void accept(IJavaScriptVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<XmlDotQuery> wGetEntityDescriptor() {
		return JavaScriptEntityDescriptorEnum.XmlDotQuery;
	}

	public Expression getLeft() {
		return wGet(JavaScriptFeatureDescriptorEnum.left).wGetAdapter(
				JavaScriptEntityDescriptorEnum.Expression);
	}

	public void setLeft(Expression left) {
		wSet(JavaScriptFeatureDescriptorEnum.left, left);
	}

	public Expression getRight() {
		return wGet(JavaScriptFeatureDescriptorEnum.right).wGetAdapter(
				JavaScriptEntityDescriptorEnum.Expression);
	}

	public void setRight(Expression right) {
		wSet(JavaScriptFeatureDescriptorEnum.right, right);
	}
}
