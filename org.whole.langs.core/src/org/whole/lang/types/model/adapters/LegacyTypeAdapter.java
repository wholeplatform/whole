package org.whole.lang.types.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.types.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.types.visitors.ITypesVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.types.reflect.TypesEntityDescriptorEnum;
import org.whole.lang.types.model.LegacyTypeEnum.Value;

/** 
 * @generator Whole
 */
public class LegacyTypeAdapter extends AbstractEntityAdapter implements
		LegacyType {
	private static final long serialVersionUID = 1;

	public LegacyTypeAdapter(IEntity implementor) {
		super(implementor);
	}

	public LegacyTypeAdapter() {
	}

	public void accept(ITypesVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<LegacyType> wGetEntityDescriptor() {
		return TypesEntityDescriptorEnum.LegacyType;
	}

	public Value getValue() {
		return (Value) wEnumValue();
	}

	public void setValue(Value value) {
		wSetValue(value);
	}
}
