package org.whole.lang.models.model.adapters;

import org.whole.lang.model.adapters.AbstractListEntityAdapter;
import org.whole.lang.models.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.models.visitors.IModelsVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.models.reflect.ModelsEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class TypesAdapter extends AbstractListEntityAdapter<Type> implements
		Types {
	private static final long serialVersionUID = 1;

	public TypesAdapter(IEntity implementor) {
		super(implementor);
	}

	public TypesAdapter() {
	}

	public void accept(IModelsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Types> wGetEntityDescriptor() {
		return ModelsEntityDescriptorEnum.Types;
	}
}
