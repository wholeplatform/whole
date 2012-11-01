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
public class PropertyNameAdapter extends AbstractEntityAdapter implements
		PropertyName {
	private static final long serialVersionUID = 1;

	public PropertyNameAdapter(IEntity implementor) {
		super(implementor);
	}

	public PropertyNameAdapter() {
	}

	public void accept(IPropertiesVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<PropertyName> wGetEntityDescriptor() {
		return PropertiesEntityDescriptorEnum.PropertyName;
	}

	public String getValue() {
		return wStringValue();
	}

	public void setValue(String value) {
		wSetValue(value);
	}
}
