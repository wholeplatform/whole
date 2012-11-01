package org.whole.lang.javascript.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.javascript.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.javascript.reflect.JavaScriptEntityDescriptorEnum;
import org.whole.lang.javascript.visitors.IJavaScriptVisitor;

/** 
 * @generator Whole
 */
public class XmlAnyImpl extends AbstractSimpleEntity implements XmlAny {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<XmlAny> wGetEntityDescriptor() {
		return JavaScriptEntityDescriptorEnum.XmlAny;
	}

	public int wGetEntityOrd() {
		return JavaScriptEntityDescriptorEnum.XmlAny_ord;
	}

	public void accept(IJavaScriptVisitor visitor) {
		visitor.visit(this);
	}
}
