package org.whole.lang.javascript.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.javascript.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.javascript.reflect.JavaScriptEntityDescriptorEnum;
import org.whole.lang.javascript.visitors.IJavaScriptVisitor;
import org.whole.lang.javascript.reflect.JavaScriptFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class XmlStringImpl extends AbstractSimpleEntity implements XmlString {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<XmlString> wGetEntityDescriptor() {
		return JavaScriptEntityDescriptorEnum.XmlString;
	}

	public int wGetEntityOrd() {
		return JavaScriptEntityDescriptorEnum.XmlString_ord;
	}

	public void accept(IJavaScriptVisitor visitor) {
		visitor.visit(this);
	}

	private StringData xml;

	public StringData getXml() {
		return notifyRequested(JavaScriptFeatureDescriptorEnum.xml, xml);
	}

	public void setXml(StringData xml) {
		notifyChanged(JavaScriptFeatureDescriptorEnum.xml, this.xml,
				this.xml = xml);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getXml().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setXml(value.wGetAdapter(JavaScriptEntityDescriptorEnum.StringData));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 1;
	}
}
