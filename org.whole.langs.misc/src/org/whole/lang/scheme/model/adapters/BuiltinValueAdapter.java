package org.whole.lang.scheme.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.scheme.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.scheme.visitors.ISchemeVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.scheme.reflect.SchemeEntityDescriptorEnum;
import org.whole.lang.scheme.model.BuiltinValueEnum.Value;

/** 
 * @generator Whole
 */
public class BuiltinValueAdapter extends AbstractEntityAdapter implements
		BuiltinValue {
	private static final long serialVersionUID = 1;

	public BuiltinValueAdapter(IEntity implementor) {
		super(implementor);
	}

	public BuiltinValueAdapter() {
	}

	public void accept(ISchemeVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<BuiltinValue> wGetEntityDescriptor() {
		return SchemeEntityDescriptorEnum.BuiltinValue;
	}

	public Value getValue() {
		return (Value) wEnumValue();
	}

	public void setValue(Value value) {
		wSetValue(value);
	}
}
