package org.whole.lang.models.model.adapters;

import org.whole.lang.model.adapters.AbstractSetEntityAdapter;
import org.whole.lang.models.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.models.visitors.IModelsVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.models.reflect.ModelsEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class ComponentModifiersAdapter extends
		AbstractSetEntityAdapter<ComponentModifier> implements
		ComponentModifiers {
	private static final long serialVersionUID = 1;

	public ComponentModifiersAdapter(IEntity implementor) {
		super(implementor);
	}

	public ComponentModifiersAdapter() {
	}

	public void accept(IModelsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<ComponentModifiers> wGetEntityDescriptor() {
		return ModelsEntityDescriptorEnum.ComponentModifiers;
	}
}
