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
public class ProjectNameAdapter extends AbstractEntityAdapter implements
		ProjectName {
	private static final long serialVersionUID = 1;

	public ProjectNameAdapter(IEntity implementor) {
		super(implementor);
	}

	public ProjectNameAdapter() {
	}

	public void accept(IArtifactsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<ProjectName> wGetEntityDescriptor() {
		return ArtifactsEntityDescriptorEnum.ProjectName;
	}
}
