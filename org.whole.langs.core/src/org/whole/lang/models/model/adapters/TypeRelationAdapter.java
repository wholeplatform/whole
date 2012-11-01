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
public class TypeRelationAdapter extends AbstractEntityAdapter implements
		TypeRelation {
	private static final long serialVersionUID = 1;

	public TypeRelationAdapter(IEntity implementor) {
		super(implementor);
	}

	public TypeRelationAdapter() {
	}

	public void accept(IModelsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<TypeRelation> wGetEntityDescriptor() {
		return ModelsEntityDescriptorEnum.TypeRelation;
	}
}
