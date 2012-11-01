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
public class ResourcesAdapter extends AbstractListEntityAdapter<Resource>
		implements Resources {
	private static final long serialVersionUID = 1;

	public ResourcesAdapter(IEntity implementor) {
		super(implementor);
	}

	public ResourcesAdapter() {
	}

	public void accept(IFramesVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Resources> wGetEntityDescriptor() {
		return FramesEntityDescriptorEnum.Resources;
	}
}
