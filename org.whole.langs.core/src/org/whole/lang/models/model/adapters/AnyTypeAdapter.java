package org.whole.lang.models.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.models.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.models.visitors.IModelsVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.models.reflect.ModelsEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class AnyTypeAdapter extends AbstractEntityAdapter implements AnyType {
	private static final long serialVersionUID = 1;

	public AnyTypeAdapter(IEntity implementor) {
		super(implementor);
	}

	public AnyTypeAdapter() {
	}

	public void accept(IModelsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<AnyType> wGetEntityDescriptor() {
		return ModelsEntityDescriptorEnum.AnyType;
	}
}
