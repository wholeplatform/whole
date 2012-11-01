package org.whole.lang.properties.model.adapters;

import org.whole.lang.model.adapters.AbstractSetEntityAdapter;
import org.whole.lang.properties.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.properties.visitors.IPropertiesVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.properties.reflect.PropertiesEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class EntriesAdapter extends AbstractSetEntityAdapter<Property>
		implements Entries {
	private static final long serialVersionUID = 1;

	public EntriesAdapter(IEntity implementor) {
		super(implementor);
	}

	public EntriesAdapter() {
	}

	public void accept(IPropertiesVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Entries> wGetEntityDescriptor() {
		return PropertiesEntityDescriptorEnum.Entries;
	}
}
