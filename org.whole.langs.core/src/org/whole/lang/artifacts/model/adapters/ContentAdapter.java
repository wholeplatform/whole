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
public class ContentAdapter extends AbstractEntityAdapter implements Content {
	private static final long serialVersionUID = 1;

	public ContentAdapter(IEntity implementor) {
		super(implementor);
	}

	public ContentAdapter() {
	}

	public void accept(IArtifactsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Content> wGetEntityDescriptor() {
		return ArtifactsEntityDescriptorEnum.Content;
	}
}
