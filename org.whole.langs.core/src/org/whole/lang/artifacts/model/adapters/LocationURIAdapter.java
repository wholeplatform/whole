package org.whole.lang.artifacts.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.artifacts.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.artifacts.visitors.IArtifactsVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.artifacts.reflect.ArtifactsEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class LocationURIAdapter extends AbstractEntityAdapter implements
		LocationURI {
	private static final long serialVersionUID = 1;

	public LocationURIAdapter(IEntity implementor) {
		super(implementor);
	}

	public LocationURIAdapter() {
	}

	public void accept(IArtifactsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<LocationURI> wGetEntityDescriptor() {
		return ArtifactsEntityDescriptorEnum.LocationURI;
	}

	public String getValue() {
		return wStringValue();
	}

	public void setValue(String value) {
		wSetValue(value);
	}
}
