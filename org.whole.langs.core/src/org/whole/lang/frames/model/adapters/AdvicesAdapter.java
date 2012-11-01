package org.whole.lang.frames.model.adapters;

import org.whole.lang.model.adapters.AbstractListEntityAdapter;
import org.whole.lang.frames.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.frames.visitors.IFramesVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.frames.reflect.FramesEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class AdvicesAdapter extends AbstractListEntityAdapter<Advice> implements
		Advices {
	private static final long serialVersionUID = 1;

	public AdvicesAdapter(IEntity implementor) {
		super(implementor);
	}

	public AdvicesAdapter() {
	}

	public void accept(IFramesVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Advices> wGetEntityDescriptor() {
		return FramesEntityDescriptorEnum.Advices;
	}
}
