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
public class PersistenceAdapter extends AbstractEntityAdapter implements
		Persistence {
	private static final long serialVersionUID = 1;

	public PersistenceAdapter(IEntity implementor) {
		super(implementor);
	}

	public PersistenceAdapter() {
	}

	public void accept(IFramesVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Persistence> wGetEntityDescriptor() {
		return FramesEntityDescriptorEnum.Persistence;
	}
}
