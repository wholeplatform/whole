package org.whole.lang.frames.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.frames.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.frames.visitors.IFramesVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.frames.reflect.FramesEntityDescriptorEnum;
import org.whole.lang.frames.model.BindingTimeEnum.Value;

/** 
 * @generator Whole
 */
public class BindingTimeAdapter extends AbstractEntityAdapter implements
		BindingTime {
	private static final long serialVersionUID = 1;

	public BindingTimeAdapter(IEntity implementor) {
		super(implementor);
	}

	public BindingTimeAdapter() {
	}

	public void accept(IFramesVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<BindingTime> wGetEntityDescriptor() {
		return FramesEntityDescriptorEnum.BindingTime;
	}

	public Value getValue() {
		return (Value) wEnumValue();
	}

	public void setValue(Value value) {
		wSetValue(value);
	}
}
