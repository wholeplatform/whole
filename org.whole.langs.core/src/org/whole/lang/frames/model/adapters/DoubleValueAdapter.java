package org.whole.lang.frames.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.frames.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.frames.visitors.IFramesVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.frames.reflect.FramesEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class DoubleValueAdapter extends AbstractEntityAdapter implements
		DoubleValue {
	private static final long serialVersionUID = 1;

	public DoubleValueAdapter(IEntity implementor) {
		super(implementor);
	}

	public DoubleValueAdapter() {
	}

	public void accept(IFramesVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<DoubleValue> wGetEntityDescriptor() {
		return FramesEntityDescriptorEnum.DoubleValue;
	}

	public double getValue() {
		return wDoubleValue();
	}

	public void setValue(double value) {
		wSetValue(value);
	}
}
