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
public class IntValueAdapter extends AbstractEntityAdapter implements IntValue {
	private static final long serialVersionUID = 1;

	public IntValueAdapter(IEntity implementor) {
		super(implementor);
	}

	public IntValueAdapter() {
	}

	public void accept(IFramesVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<IntValue> wGetEntityDescriptor() {
		return FramesEntityDescriptorEnum.IntValue;
	}

	public int getValue() {
		return wIntValue();
	}

	public void setValue(int value) {
		wSetValue(value);
	}
}
