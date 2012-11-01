package org.whole.lang.models.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.models.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.models.visitors.IModelsVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.models.reflect.ModelsEntityDescriptorEnum;
import org.whole.lang.models.model.ComponentModifierEnum.Value;

/** 
 * @generator Whole
 */
public class ComponentModifierAdapter extends AbstractEntityAdapter implements
		ComponentModifier {
	private static final long serialVersionUID = 1;

	public ComponentModifierAdapter(IEntity implementor) {
		super(implementor);
	}

	public ComponentModifierAdapter() {
	}

	public void accept(IModelsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<ComponentModifier> wGetEntityDescriptor() {
		return ModelsEntityDescriptorEnum.ComponentModifier;
	}

	public Value getValue() {
		return (Value) wEnumValue();
	}

	public void setValue(Value value) {
		wSetValue(value);
	}
}
