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
public class XmlStringAdapter extends AbstractEntityAdapter implements
		XmlString {
	private static final long serialVersionUID = 1;

	public XmlStringAdapter(IEntity implementor) {
		super(implementor);
	}

	public XmlStringAdapter() {
	}

	public void accept(IJavaScriptVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<XmlString> wGetEntityDescriptor() {
		return JavaScriptEntityDescriptorEnum.XmlString;
	}

	public StringData getXml() {
		return wGet(JavaScriptFeatureDescriptorEnum.xml).wGetAdapter(
				JavaScriptEntityDescriptorEnum.StringData);
	}

	public void setXml(StringData xml) {
		wSet(JavaScriptFeatureDescriptorEnum.xml, xml);
	}
}
