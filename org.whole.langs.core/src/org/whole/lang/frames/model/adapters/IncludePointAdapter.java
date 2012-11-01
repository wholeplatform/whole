package org.whole.lang.frames.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.frames.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.frames.visitors.IFramesVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.frames.reflect.FramesEntityDescriptorEnum;
import org.whole.lang.frames.reflect.FramesFeatureDescriptorEnum;

/** 
 * @generator Whole
 */
public class IncludePointAdapter extends AbstractEntityAdapter implements
		IncludePoint {
	private static final long serialVersionUID = 1;

	public IncludePointAdapter(IEntity implementor) {
		super(implementor);
	}

	public IncludePointAdapter() {
	}

	public void accept(IFramesVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<IncludePoint> wGetEntityDescriptor() {
		return FramesEntityDescriptorEnum.IncludePoint;
	}

	public ResourceIdentifier getResource() {
		return wGet(FramesFeatureDescriptorEnum.resource).wGetAdapter(
				FramesEntityDescriptorEnum.ResourceIdentifier);
	}

	public void setResource(ResourceIdentifier resource) {
		wSet(FramesFeatureDescriptorEnum.resource, resource);
	}
}
