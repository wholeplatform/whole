package org.whole.lang.artifacts.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.artifacts.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.artifacts.reflect.ArtifactsEntityDescriptorEnum;
import org.whole.lang.artifacts.visitors.IArtifactsVisitor;
import org.whole.lang.artifacts.reflect.ArtifactsFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class WorkspaceImpl extends AbstractSimpleEntity implements Workspace {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<Workspace> wGetEntityDescriptor() {
		return ArtifactsEntityDescriptorEnum.Workspace;
	}

	public int wGetEntityOrd() {
		return ArtifactsEntityDescriptorEnum.Workspace_ord;
	}

	public void accept(IArtifactsVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	private Metadata metadata;

	public Metadata getMetadata() {
		return notifyRequested(ArtifactsFeatureDescriptorEnum.metadata,
				metadata);
	}

	public void setMetadata(Metadata metadata) {
		notifyChanged(ArtifactsFeatureDescriptorEnum.metadata, this.metadata,
				this.metadata = metadata);
	}

	private Projects projects;

	public Projects getProjects() {
		return notifyRequested(ArtifactsFeatureDescriptorEnum.projects,
				projects);
	}

	public void setProjects(Projects projects) {
		notifyChanged(ArtifactsFeatureDescriptorEnum.projects, this.projects,
				this.projects = projects);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getMetadata().wGetAdaptee(false);
		case 1:
			return getProjects().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setMetadata(value
					.wGetAdapter(ArtifactsEntityDescriptorEnum.Metadata));
			break;
		case 1:
			setProjects(value
					.wGetAdapter(ArtifactsEntityDescriptorEnum.Projects));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 2;
	}
}
