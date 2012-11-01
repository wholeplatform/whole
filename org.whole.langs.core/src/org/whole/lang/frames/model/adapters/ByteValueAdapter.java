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
public class ByteValueAdapter extends AbstractEntityAdapter implements
		ByteValue {
	private static final long serialVersionUID = 1;

	public ByteValueAdapter(IEntity implementor) {
		super(implementor);
	}

	public ByteValueAdapter() {
	}

	public void accept(IFramesVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<ByteValue> wGetEntityDescriptor() {
		return FramesEntityDescriptorEnum.ByteValue;
	}

	public byte getValue() {
		return wByteValue();
	}

	public void setValue(byte value) {
		wSetValue(value);
	}
}
