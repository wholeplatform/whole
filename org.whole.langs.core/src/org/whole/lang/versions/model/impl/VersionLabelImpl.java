package org.whole.lang.versions.model.impl;

import org.whole.lang.model.AbstractDataEntity;
import org.whole.lang.versions.model.*;
import org.whole.lang.versions.visitors.IVersionsVisitor;
import org.whole.lang.versions.reflect.VersionsEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class VersionLabelImpl extends AbstractDataEntity implements
		VersionLabel {
	private static final long serialVersionUID = 1;
	private String value;

	public String getValue() {
		return notifyRequested(value);
	}

	public void setValue(String value) {
		notifyChanged(this.value, this.value = value);
	}

	public void accept(IVersionsVisitor visitor) {
		visitor.visit(this);
	}

	public int wGetEntityOrd() {
		return VersionsEntityDescriptorEnum.VersionLabel_ord;
	}

	public EntityDescriptor<VersionLabel> wGetEntityDescriptor() {
		return VersionsEntityDescriptorEnum.VersionLabel;
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
