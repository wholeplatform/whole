package org.whole.lang.xml.model.impl;

import org.whole.lang.model.AbstractDataEntity;
import org.whole.lang.xml.model.*;
import org.whole.lang.xml.visitors.IXmlVisitor;
import org.whole.lang.xml.reflect.XmlEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class CommentTextImpl extends AbstractDataEntity implements CommentText {
	private static final long serialVersionUID = 1;
	private String value;

	public String getValue() {
		return notifyRequested(value);
	}

	public void setValue(String value) {
		notifyChanged(this.value, this.value = value);
	}

	public void accept(IXmlVisitor visitor) {
		visitor.visit(this);
	}

	public int wGetEntityOrd() {
		return XmlEntityDescriptorEnum.CommentText_ord;
	}

	public EntityDescriptor<CommentText> wGetEntityDescriptor() {
		return XmlEntityDescriptorEnum.CommentText;
	}

	public Object wGetValue() {
		return getValue();
	}

	public void wSetValue(Object value) {
		setValue((String) value);
	}

	public String wStringValue() {
		return getValue();
	}

	public void wSetValue(String value) {
		setValue(value);
	}
}
