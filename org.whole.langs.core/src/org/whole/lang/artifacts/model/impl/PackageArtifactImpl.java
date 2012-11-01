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
public class PackageArtifactImpl extends AbstractSimpleEntity implements
		PackageArtifact {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<PackageArtifact> wGetEntityDescriptor() {
		return ArtifactsEntityDescriptorEnum.PackageArtifact;
	}

	public int wGetEntityOrd() {
		return ArtifactsEntityDescriptorEnum.PackageArtifact_ord;
	}

	public void accept(IArtifactsVisitor visitor) {
		visitor.visit(this);
	}

	private PackageName name;

	public PackageName getName() {
		return notifyRequested(ArtifactsFeatureDescriptorEnum.name, name);
	}

	public void setName(PackageName name) {
		notifyChanged(ArtifactsFeatureDescriptorEnum.name, this.name,
				this.name = name);
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

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getName().wGetAdaptee(false);
		case 1:
			return getMetadata().wGetAdaptee(false);
		case 2:
			return getArtifacts().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setName(value
					.wGetAdapter(ArtifactsEntityDescriptorEnum.PackageName));
			break;
		case 1:
			setMetadata(value
					.wGetAdapter(ArtifactsEntityDescriptorEnum.Metadata));
			break;
		case 2:
			setArtifacts(value
					.wGetAdapter(ArtifactsEntityDescriptorEnum.Artifacts));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 3;
	}
}
