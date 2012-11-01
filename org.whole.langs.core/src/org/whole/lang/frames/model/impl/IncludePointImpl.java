package org.whole.lang.frames.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.frames.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.frames.reflect.FramesEntityDescriptorEnum;
import org.whole.lang.frames.visitors.IFramesVisitor;
import org.whole.lang.frames.reflect.FramesFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class IncludePointImpl extends AbstractSimpleEntity implements
		IncludePoint {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<IncludePoint> wGetEntityDescriptor() {
		return FramesEntityDescriptorEnum.IncludePoint;
	}

	public int wGetEntityOrd() {
		return FramesEntityDescriptorEnum.IncludePoint_ord;
	}

	public void accept(IFramesVisitor visitor) {
		visitor.visit(this);
	}

	private ResourceIdentifier resource;

	public ResourceIdentifier getResource() {
		return notifyRequested(FramesFeatureDescriptorEnum.resource, resource);
	}

	public void setResource(ResourceIdentifier resource) {
		notifyChanged(FramesFeatureDescriptorEnum.resource, this.resource,
				this.resource = resource);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getResource().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setResource(value
					.wGetAdapter(FramesEntityDescriptorEnum.ResourceIdentifier));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 1;
	}
}
