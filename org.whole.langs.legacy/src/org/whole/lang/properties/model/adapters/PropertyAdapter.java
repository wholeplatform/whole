package org.whole.lang.properties.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.properties.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.properties.visitors.IPropertiesVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.properties.reflect.PropertiesEntityDescriptorEnum;
import org.whole.lang.properties.reflect.PropertiesFeatureDescriptorEnum;

/** 
 * @generator Whole
 */
public class PropertyAdapter extends AbstractEntityAdapter implements Property {
	private static final long serialVersionUID = 1;

	public PropertyAdapter(IEntity implementor) {
		super(implementor);
	}

	public PropertyAdapter() {
	}

	public void accept(IPropertiesVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Property> wGetEntityDescriptor() {
		return PropertiesEntityDescriptorEnum.Property;
	}

	public PropertyName getName() {
		return wGet(PropertiesFeatureDescriptorEnum.name).wGetAdapter(
				PropertiesEntityDescriptorEnum.PropertyName);
	}

	public void setName(PropertyName name) {
		wSet(PropertiesFeatureDescriptorEnum.name, name);
	}

	public PropertyValue getValue() {
		return wGet(PropertiesFeatureDescriptorEnum.value).wGetAdapter(
				PropertiesEntityDescriptorEnum.PropertyValue);
	}

	public void setValue(PropertyValue value) {
		wSet(PropertiesFeatureDescriptorEnum.value, value);
	}
}
