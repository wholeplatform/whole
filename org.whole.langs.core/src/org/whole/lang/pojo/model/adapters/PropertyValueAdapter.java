package org.whole.lang.pojo.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.pojo.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.pojo.visitors.IPojoVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.pojo.reflect.PojoEntityDescriptorEnum;

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

	public void accept(IPojoVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<PropertyValue> wGetEntityDescriptor() {
		return PojoEntityDescriptorEnum.PropertyValue;
	}
}
