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
public class EmptyAdapter extends AbstractEntityAdapter implements Empty {
	private static final long serialVersionUID = 1;

	public EmptyAdapter(IEntity implementor) {
		super(implementor);
	}

	public EmptyAdapter() {
	}

	public void accept(IFramesVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Empty> wGetEntityDescriptor() {
		return FramesEntityDescriptorEnum.Empty;
	}
}
