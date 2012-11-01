package org.whole.lang.models.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.models.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.models.visitors.IModelsVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.models.reflect.ModelsEntityDescriptorEnum;
import org.whole.lang.models.model.EntityModifierEnum.Value;

/** 
 * @generator Whole
 */
public class EntityModifierAdapter extends AbstractEntityAdapter implements
		EntityModifier {
	private static final long serialVersionUID = 1;

	public EntityModifierAdapter(IEntity implementor) {
		super(implementor);
	}

	public EntityModifierAdapter() {
	}

	public void accept(IModelsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<EntityModifier> wGetEntityDescriptor() {
		return ModelsEntityDescriptorEnum.EntityModifier;
	}

	public Value getValue() {
		return (Value) wEnumValue();
	}

	public void setValue(Value value) {
		wSetValue(value);
	}
}
