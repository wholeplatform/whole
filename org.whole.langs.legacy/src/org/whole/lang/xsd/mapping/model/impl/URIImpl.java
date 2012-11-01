package org.whole.lang.xsd.mapping.model.impl;

import org.whole.lang.model.AbstractDataEntity;
import org.whole.lang.xsd.mapping.model.*;
import org.whole.lang.xsd.mapping.visitors.IMappingVisitor;
import org.whole.lang.xsd.mapping.reflect.MappingEntityDescriptorEnum;
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

	public void accept(IMappingVisitor visitor) {
		visitor.visit(this);
	}

	public int wGetEntityOrd() {
		return MappingEntityDescriptorEnum.URI_ord;
	}

	public EntityDescriptor<URI> wGetEntityDescriptor() {
		return MappingEntityDescriptorEnum.URI;
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
