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
public class LongValueAdapter extends AbstractEntityAdapter implements
		LongValue {
	private static final long serialVersionUID = 1;

	public LongValueAdapter(IEntity implementor) {
		super(implementor);
	}

	public LongValueAdapter() {
	}

	public void accept(IFramesVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<LongValue> wGetEntityDescriptor() {
		return FramesEntityDescriptorEnum.LongValue;
	}

	public long getValue() {
		return wLongValue();
	}

	public void setValue(long value) {
		wSetValue(value);
	}
}
