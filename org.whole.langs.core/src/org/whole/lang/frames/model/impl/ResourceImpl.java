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
public class ResourceImpl extends AbstractSimpleEntity implements Resource {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<Resource> wGetEntityDescriptor() {
		return FramesEntityDescriptorEnum.Resource;
	}

	public int wGetEntityOrd() {
		return FramesEntityDescriptorEnum.Resource_ord;
	}

	public void accept(IFramesVisitor visitor) {
		visitor.visit(this);
	}

	private URI uri;

	public URI getUri() {
		return notifyRequested(FramesFeatureDescriptorEnum.uri, uri);
	}

	public void setUri(URI uri) {
		notifyChanged(FramesFeatureDescriptorEnum.uri, this.uri, this.uri = uri);
	}

	private Location location;

	public Location getLocation() {
		return notifyRequested(FramesFeatureDescriptorEnum.location, location);
	}

	public void setLocation(Location location) {
		notifyChanged(FramesFeatureDescriptorEnum.location, this.location,
				this.location = location);
	}

	private Persistence persistence;

	public Persistence getPersistence() {
		return notifyRequested(FramesFeatureDescriptorEnum.persistence,
				persistence);
	}

	public void setPersistence(Persistence persistence) {
		notifyChanged(FramesFeatureDescriptorEnum.persistence,
				this.persistence, this.persistence = persistence);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getUri().wGetAdaptee(false);
		case 1:
			return getLocation().wGetAdaptee(false);
		case 2:
			return getPersistence().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setUri(value.wGetAdapter(FramesEntityDescriptorEnum.URI));
			break;
		case 1:
			setLocation(value.wGetAdapter(FramesEntityDescriptorEnum.Location));
			break;
		case 2:
			setPersistence(value
					.wGetAdapter(FramesEntityDescriptorEnum.Persistence));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 3;
	}
}
