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
public class ResourceAdapter extends AbstractEntityAdapter implements Resource {
	private static final long serialVersionUID = 1;

	public ResourceAdapter(IEntity implementor) {
		super(implementor);
	}

	public ResourceAdapter() {
	}

	public void accept(IFramesVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Resource> wGetEntityDescriptor() {
		return FramesEntityDescriptorEnum.Resource;
	}

	public URI getUri() {
		return wGet(FramesFeatureDescriptorEnum.uri).wGetAdapter(
				FramesEntityDescriptorEnum.URI);
	}

	public void setUri(URI uri) {
		wSet(FramesFeatureDescriptorEnum.uri, uri);
	}

	public Location getLocation() {
		return wGet(FramesFeatureDescriptorEnum.location).wGetAdapter(
				FramesEntityDescriptorEnum.Location);
	}

	public void setLocation(Location location) {
		wSet(FramesFeatureDescriptorEnum.location, location);
	}

	public Persistence getPersistence() {
		return wGet(FramesFeatureDescriptorEnum.persistence).wGetAdapter(
				FramesEntityDescriptorEnum.Persistence);
	}

	public void setPersistence(Persistence persistence) {
		wSet(FramesFeatureDescriptorEnum.persistence, persistence);
	}
}
