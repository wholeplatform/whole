package org.whole.lang.pojo.model.impl;

import org.whole.lang.model.AbstractDataEntity;
import org.whole.lang.pojo.model.*;
import org.whole.lang.pojo.visitors.IPojoVisitor;
import org.whole.lang.pojo.reflect.PojoEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class LanguageURIImpl extends AbstractDataEntity implements LanguageURI {
	private static final long serialVersionUID = 1;
	private String value;

	public String getValue() {
		return notifyRequested(value);
	}

	public void setValue(String value) {
		notifyChanged(this.value, this.value = value);
	}

	public void accept(IPojoVisitor visitor) {
		visitor.visit(this);
	}

	public int wGetEntityOrd() {
		return PojoEntityDescriptorEnum.LanguageURI_ord;
	}

	public EntityDescriptor<LanguageURI> wGetEntityDescriptor() {
		return PojoEntityDescriptorEnum.LanguageURI;
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
