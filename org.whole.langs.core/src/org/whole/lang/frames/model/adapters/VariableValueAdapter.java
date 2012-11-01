package org.whole.lang.frames.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.frames.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.frames.visitors.IFramesVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.frames.reflect.FramesEntityDescriptorEnum;
import org.whole.lang.frames.model.VariableValueEnum.Value;

/** 
 * @generator Whole
 */
public class VariableValueAdapter extends AbstractEntityAdapter implements
		VariableValue {
	private static final long serialVersionUID = 1;

	public VariableValueAdapter(IEntity implementor) {
		super(implementor);
	}

	public VariableValueAdapter() {
	}

	public void accept(IFramesVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<VariableValue> wGetEntityDescriptor() {
		return FramesEntityDescriptorEnum.VariableValue;
	}

	public Value getValue() {
		return (Value) wEnumValue();
	}

	public void setValue(Value value) {
		wSetValue(value);
	}
}
