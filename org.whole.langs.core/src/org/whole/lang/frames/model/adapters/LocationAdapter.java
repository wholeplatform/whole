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
public class LocationAdapter extends AbstractEntityAdapter implements Location {
	private static final long serialVersionUID = 1;

	public LocationAdapter(IEntity implementor) {
		super(implementor);
	}

	public LocationAdapter() {
	}

	public void accept(IFramesVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Location> wGetEntityDescriptor() {
		return FramesEntityDescriptorEnum.Location;
	}
}
