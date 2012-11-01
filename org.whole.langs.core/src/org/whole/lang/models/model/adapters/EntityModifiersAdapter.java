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
public class EntityModifiersAdapter extends
		AbstractSetEntityAdapter<EntityModifier> implements EntityModifiers {
	private static final long serialVersionUID = 1;

	public EntityModifiersAdapter(IEntity implementor) {
		super(implementor);
	}

	public EntityModifiersAdapter() {
	}

	public void accept(IModelsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<EntityModifiers> wGetEntityDescriptor() {
		return ModelsEntityDescriptorEnum.EntityModifiers;
	}
}
