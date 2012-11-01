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
public class FeatureModifierImpl extends AbstractDataEntity implements
		FeatureModifier {
	private static final long serialVersionUID = 1;
	private org.whole.lang.models.model.FeatureModifierEnum.Value value;

	public org.whole.lang.models.model.FeatureModifierEnum.Value getValue() {
		return notifyRequested(value);
	}

	public void setValue(
			org.whole.lang.models.model.FeatureModifierEnum.Value value) {
		notifyChanged(this.value, this.value = value);
	}

	public void accept(IModelsVisitor visitor) {
		visitor.visit(this);
	}

	public int wGetEntityOrd() {
		return ModelsEntityDescriptorEnum.FeatureModifier_ord;
	}

	public EntityDescriptor<FeatureModifier> wGetEntityDescriptor() {
		return ModelsEntityDescriptorEnum.FeatureModifier;
	}

	public Object wGetValue() {
		return getValue();
	}

	public void wSetValue(Object value) {
		setValue((org.whole.lang.models.model.FeatureModifierEnum.Value) value);
	}

	public String wStringValue() {
		return toString();
	}

	public void wSetValue(String value) {
		try {
			setValue(FeatureModifierEnum.instance.valueOf(value));
		} catch (NumberFormatException e) {
		}
	}

	public EnumValue wEnumValue() {
		return value;
	}

	public void wSetValue(EnumValue value) {
		setValue((org.whole.lang.models.model.FeatureModifierEnum.Value) value);
	}
}
