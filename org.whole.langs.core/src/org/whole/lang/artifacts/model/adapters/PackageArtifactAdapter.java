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
public class PackageArtifactAdapter extends AbstractEntityAdapter implements
		PackageArtifact {
	private static final long serialVersionUID = 1;

	public PackageArtifactAdapter(IEntity implementor) {
		super(implementor);
	}

	public PackageArtifactAdapter() {
	}

	public void accept(IArtifactsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<PackageArtifact> wGetEntityDescriptor() {
		return ArtifactsEntityDescriptorEnum.PackageArtifact;
	}

	public PackageName getName() {
		return wGet(ArtifactsFeatureDescriptorEnum.name).wGetAdapter(
				ArtifactsEntityDescriptorEnum.PackageName);
	}

	public void setName(PackageName name) {
		wSet(ArtifactsFeatureDescriptorEnum.name, name);
	}

	public Metadata getMetadata() {
		return wGet(ArtifactsFeatureDescriptorEnum.metadata).wGetAdapter(
				ArtifactsEntityDescriptorEnum.Metadata);
	}

	public void setMetadata(Metadata metadata) {
		wSet(ArtifactsFeatureDescriptorEnum.metadata, metadata);
	}

	public Artifacts getArtifacts() {
		return wGet(ArtifactsFeatureDescriptorEnum.artifacts).wGetAdapter(
				ArtifactsEntityDescriptorEnum.Artifacts);
	}

	public void setArtifacts(Artifacts artifacts) {
		wSet(ArtifactsFeatureDescriptorEnum.artifacts, artifacts);
	}
}
