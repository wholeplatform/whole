package org.whole.lang.properties.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.properties.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.properties.visitors.IPropertiesVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.properties.reflect.PropertiesEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class PropertyValueAdapter extends AbstractEntityAdapter implements
		PropertyValue {
	private static final long serialVersionUID = 1;

	public PropertyValueAdapter(IEntity implementor) {
		super(implementor);
	}

	public PropertyValueAdapter() {
	}

	public void accept(IPropertiesVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<PropertyValue> wGetEntityDescriptor() {
		return PropertiesEntityDescriptorEnum.PropertyValue;
	}

	public String getValue() {
		return wStringValue();
	}

	public void setValue(String value) {
		wSetValue(value);
	}
}
