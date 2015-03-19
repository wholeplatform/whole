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
public class ProjectImpl extends AbstractSimpleEntity implements Project {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<Project> wGetEntityDescriptor() {
		return ArtifactsEntityDescriptorEnum.Project;
	}

	public int wGetEntityOrd() {
		return ArtifactsEntityDescriptorEnum.Project_ord;
	}

	public void accept(IArtifactsVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	public int wHashCode() {
		return getName().wHashCode();
	}

	public boolean wEquals(IEntity entity) {
		if (this == entity)
			return true;
		if (!wGetEntityDescriptor().equals(entity.wGetEntityDescriptor()))
			return false;
		try {
			return getName().wEquals(
					entity.wGet(ArtifactsFeatureDescriptorEnum.name));
		} catch (Exception e) {
			return false;
		}
	}

	protected void toString(StringBuffer buffer) {
		buffer.append("name=");
		buffer.append(name);
	}

	private ProjectName name;

	public ProjectName getName() {
		return notifyRequested(ArtifactsFeatureDescriptorEnum.name, name);
	}

	public void setName(ProjectName name) {
		notifyChanged(ArtifactsFeatureDescriptorEnum.name, this.name,
				this.name = name);
	}

	private Natures natures;

	public Natures getNatures() {
		return notifyRequested(ArtifactsFeatureDescriptorEnum.natures, natures);
	}

	public void setNatures(Natures natures) {
		notifyChanged(ArtifactsFeatureDescriptorEnum.natures, this.natures,
				this.natures = natures);
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

	private Artifacts artifacts;

	public Artifacts getArtifacts() {
		return notifyRequested(ArtifactsFeatureDescriptorEnum.artifacts,
				artifacts);
	}

	public void setArtifacts(Artifacts artifacts) {
		notifyChanged(ArtifactsFeatureDescriptorEnum.artifacts, this.artifacts,
				this.artifacts = artifacts);
	}

	private LocationURI locationURI;

	public LocationURI getLocationURI() {
		return notifyRequested(ArtifactsFeatureDescriptorEnum.locationURI,
				locationURI);
	}

	public void setLocationURI(LocationURI locationURI) {
		notifyChanged(ArtifactsFeatureDescriptorEnum.locationURI,
				this.locationURI, this.locationURI = locationURI);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getName().wGetAdaptee(false);
		case 1:
			return getNatures().wGetAdaptee(false);
		case 2:
			return getMetadata().wGetAdaptee(false);
		case 3:
			return getArtifacts().wGetAdaptee(false);
		case 4:
			return getLocationURI().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setName(value
					.wGetAdapter(ArtifactsEntityDescriptorEnum.ProjectName));
			break;
		case 1:
			setNatures(value.wGetAdapter(ArtifactsEntityDescriptorEnum.Natures));
			break;
		case 2:
			setMetadata(value
					.wGetAdapter(ArtifactsEntityDescriptorEnum.Metadata));
			break;
		case 3:
			setArtifacts(value
					.wGetAdapter(ArtifactsEntityDescriptorEnum.Artifacts));
			break;
		case 4:
			setLocationURI(value
					.wGetAdapter(ArtifactsEntityDescriptorEnum.LocationURI));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 5;
	}
}
