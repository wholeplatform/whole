package org.whole.lang.pojo.model.adapters;

import org.whole.lang.model.adapters.AbstractListEntityAdapter;
import org.whole.lang.pojo.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.pojo.visitors.IPojoVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.pojo.reflect.PojoEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class PropertiesAdapter extends AbstractListEntityAdapter<Property>
		implements Properties {
	private static final long serialVersionUID = 1;

	public PropertiesAdapter(IEntity implementor) {
		super(implementor);
	}

	public PropertiesAdapter() {
	}

	public void accept(IPojoVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Properties> wGetEntityDescriptor() {
		return PojoEntityDescriptorEnum.Properties;
	}
}
