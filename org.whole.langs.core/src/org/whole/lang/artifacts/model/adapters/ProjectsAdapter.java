package org.whole.lang.artifacts.model.adapters;

import org.whole.lang.model.adapters.AbstractListEntityAdapter;
import org.whole.lang.artifacts.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.artifacts.visitors.IArtifactsVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.artifacts.reflect.ArtifactsEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class ProjectsAdapter extends AbstractListEntityAdapter<Project>
		implements Projects {
	private static final long serialVersionUID = 1;

	public ProjectsAdapter(IEntity implementor) {
		super(implementor);
	}

	public ProjectsAdapter() {
	}

	public void accept(IArtifactsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Projects> wGetEntityDescriptor() {
		return ArtifactsEntityDescriptorEnum.Projects;
	}
}
