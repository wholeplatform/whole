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
public class CharValueAdapter extends AbstractEntityAdapter implements
		CharValue {
	private static final long serialVersionUID = 1;

	public CharValueAdapter(IEntity implementor) {
		super(implementor);
	}

	public CharValueAdapter() {
	}

	public void accept(IFramesVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<CharValue> wGetEntityDescriptor() {
		return FramesEntityDescriptorEnum.CharValue;
	}

	public char getValue() {
		return wCharValue();
	}

	public void setValue(char value) {
		wSetValue(value);
	}
}
