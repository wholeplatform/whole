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
public class XmlLiteralAdapter extends AbstractEntityAdapter implements
		XmlLiteral {
	private static final long serialVersionUID = 1;

	public XmlLiteralAdapter(IEntity implementor) {
		super(implementor);
	}

	public XmlLiteralAdapter() {
	}

	public void accept(IJavaScriptVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<XmlLiteral> wGetEntityDescriptor() {
		return JavaScriptEntityDescriptorEnum.XmlLiteral;
	}

	public XmlFragments getFragments() {
		return wGet(JavaScriptFeatureDescriptorEnum.fragments).wGetAdapter(
				JavaScriptEntityDescriptorEnum.XmlFragments);
	}

	public void setFragments(XmlFragments fragments) {
		wSet(JavaScriptFeatureDescriptorEnum.fragments, fragments);
	}
}
