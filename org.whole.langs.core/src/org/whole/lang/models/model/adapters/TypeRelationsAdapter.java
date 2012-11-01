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
public class TypeRelationsAdapter extends
		AbstractListEntityAdapter<TypeRelation> implements TypeRelations {
	private static final long serialVersionUID = 1;

	public TypeRelationsAdapter(IEntity implementor) {
		super(implementor);
	}

	public TypeRelationsAdapter() {
	}

	public void accept(IModelsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<TypeRelations> wGetEntityDescriptor() {
		return ModelsEntityDescriptorEnum.TypeRelations;
	}
}
