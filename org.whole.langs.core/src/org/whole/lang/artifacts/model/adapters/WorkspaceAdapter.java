package org.whole.lang.artifacts.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.artifacts.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.artifacts.visitors.IArtifactsVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.artifacts.reflect.ArtifactsEntityDescriptorEnum;
import org.whole.lang.artifacts.reflect.ArtifactsFeatureDescriptorEnum;

/** 
 * @generator Whole
 */
public class WorkspaceAdapter extends AbstractEntityAdapter implements
		Workspace {
	private static final long serialVersionUID = 1;

	public WorkspaceAdapter(IEntity implementor) {
		super(implementor);
	}

	public WorkspaceAdapter() {
	}

	public void accept(IArtifactsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Workspace> wGetEntityDescriptor() {
		return ArtifactsEntityDescriptorEnum.Workspace;
	}

	public Metadata getMetadata() {
		return wGet(ArtifactsFeatureDescriptorEnum.metadata).wGetAdapter(
				ArtifactsEntityDescriptorEnum.Metadata);
	}

	public void setMetadata(Metadata metadata) {
		wSet(ArtifactsFeatureDescriptorEnum.metadata, metadata);
	}

	public Projects getProjects() {
		return wGet(ArtifactsFeatureDescriptorEnum.projects).wGetAdapter(
				ArtifactsEntityDescriptorEnum.Projects);
	}

	public void setProjects(Projects projects) {
		wSet(ArtifactsFeatureDescriptorEnum.projects, projects);
	}
}
