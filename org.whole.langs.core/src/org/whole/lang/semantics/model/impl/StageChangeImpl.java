package org.whole.lang.semantics.model.impl;

import org.whole.lang.model.AbstractDataEntity;
import org.whole.lang.semantics.model.*;
import org.whole.lang.semantics.visitors.ISemanticsVisitor;
import org.whole.lang.semantics.reflect.SemanticsEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.model.EnumValue;

/** 
 * @generator Whole
 */
public class StageChangeImpl extends AbstractDataEntity implements StageChange {
	private static final long serialVersionUID = 1;
	private org.whole.lang.semantics.model.StageChangeEnum.Value value;

	public org.whole.lang.semantics.model.StageChangeEnum.Value getValue() {
		return notifyRequested(value);
	}

	public void setValue(
			org.whole.lang.semantics.model.StageChangeEnum.Value value) {
		notifyChanged(this.value, this.value = value);
	}

	public void accept(ISemanticsVisitor visitor) {
		visitor.visit(this);
	}

	public int wGetEntityOrd() {
		return SemanticsEntityDescriptorEnum.StageChange_ord;
	}

	public EntityDescriptor<StageChange> wGetEntityDescriptor() {
		return SemanticsEntityDescriptorEnum.StageChange;
	}

	public Object wGetValue() {
		return getValue();
	}

	public void wSetValue(Object value) {
		setValue((org.whole.lang.semantics.model.StageChangeEnum.Value) value);
	}

	public String wStringValue() {
		return toString();
	}

	public void wSetValue(String value) {
		try {
			setValue(StageChangeEnum.instance.valueOf(value));
		} catch (NumberFormatException e) {
		}
	}

	public EnumValue wEnumValue() {
		return value;
	}

	public void wSetValue(EnumValue value) {
		setValue((org.whole.lang.semantics.model.StageChangeEnum.Value) value);
	}
}
