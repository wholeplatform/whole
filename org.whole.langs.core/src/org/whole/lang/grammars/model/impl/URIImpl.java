package org.whole.lang.grammars.model.impl;

import org.whole.lang.model.AbstractDataEntity;
import org.whole.lang.grammars.model.*;
import org.whole.lang.grammars.visitors.IGrammarsVisitor;
import org.whole.lang.grammars.reflect.GrammarsEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class URIImpl extends AbstractDataEntity implements URI {
	private static final long serialVersionUID = 1;
	private String value;

	public String getValue() {
		return notifyRequested(value);
	}

	public void setValue(String value) {
		notifyChanged(this.value, this.value = value);
	}

	public void accept(IGrammarsVisitor visitor) {
		visitor.visit(this);
	}

	public int wGetEntityOrd() {
		return GrammarsEntityDescriptorEnum.URI_ord;
	}

	public EntityDescriptor<URI> wGetEntityDescriptor() {
		return GrammarsEntityDescriptorEnum.URI;
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
