package org.whole.lang.models.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.models.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.models.visitors.IModelsVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.models.reflect.ModelsEntityDescriptorEnum;
import org.whole.lang.models.model.FeatureModifierEnum.Value;

/** 
 * @generator Whole
 */
public class FeatureModifierAdapter extends AbstractEntityAdapter implements
		FeatureModifier {
	private static final long serialVersionUID = 1;

	public FeatureModifierAdapter(IEntity implementor) {
		super(implementor);
	}

	public FeatureModifierAdapter() {
	}

	public void accept(IModelsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<FeatureModifier> wGetEntityDescriptor() {
		return ModelsEntityDescriptorEnum.FeatureModifier;
	}

	public Value getValue() {
		return (Value) wEnumValue();
	}

	public void setValue(Value value) {
		wSetValue(value);
	}
}
