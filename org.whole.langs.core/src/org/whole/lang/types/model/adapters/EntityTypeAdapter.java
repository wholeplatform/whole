package org.whole.lang.types.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.types.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.types.visitors.ITypesVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.types.reflect.TypesEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class EntityTypeAdapter extends AbstractEntityAdapter implements
		EntityType {
	private static final long serialVersionUID = 1;

	public EntityTypeAdapter(IEntity implementor) {
		super(implementor);
	}

	public EntityTypeAdapter() {
	}

	public void accept(ITypesVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<EntityType> wGetEntityDescriptor() {
		return TypesEntityDescriptorEnum.EntityType;
	}

	public String getValue() {
		return wStringValue();
	}

	public void setValue(String value) {
		wSetValue(value);
	}
}
