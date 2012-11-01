package org.whole.lang.models.model.impl;

import org.whole.lang.model.AbstractDataEntity;
import org.whole.lang.models.model.*;
import org.whole.lang.models.visitors.IModelsVisitor;
import org.whole.lang.models.reflect.ModelsEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.model.EnumValue;

/** 
 * @generator Whole
 */
public class EntityModifierImpl extends AbstractDataEntity implements
		EntityModifier {
	private static final long serialVersionUID = 1;
	private org.whole.lang.models.model.EntityModifierEnum.Value value;

	public org.whole.lang.models.model.EntityModifierEnum.Value getValue() {
		return notifyRequested(value);
	}

	public void setValue(
			org.whole.lang.models.model.EntityModifierEnum.Value value) {
		notifyChanged(this.value, this.value = value);
	}

	public void accept(IModelsVisitor visitor) {
		visitor.visit(this);
	}

	public int wGetEntityOrd() {
		return ModelsEntityDescriptorEnum.EntityModifier_ord;
	}

	public EntityDescriptor<EntityModifier> wGetEntityDescriptor() {
		return ModelsEntityDescriptorEnum.EntityModifier;
	}

	public Object wGetValue() {
		return getValue();
	}

	public void wSetValue(Object value) {
		setValue((org.whole.lang.models.model.EntityModifierEnum.Value) value);
	}

	public String wStringValue() {
		return toString();
	}

	public void wSetValue(String value) {
		try {
			setValue(EntityModifierEnum.instance.valueOf(value));
		} catch (NumberFormatException e) {
		}
	}

	public EnumValue wEnumValue() {
		return value;
	}

	public void wSetValue(EnumValue value) {
		setValue((org.whole.lang.models.model.EntityModifierEnum.Value) value);
	}
}
