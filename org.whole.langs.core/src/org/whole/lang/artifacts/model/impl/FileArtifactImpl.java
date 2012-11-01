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
public class FileArtifactImpl extends AbstractSimpleEntity implements
		FileArtifact {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<FileArtifact> wGetEntityDescriptor() {
		return ArtifactsEntityDescriptorEnum.FileArtifact;
	}

	public int wGetEntityOrd() {
		return ArtifactsEntityDescriptorEnum.FileArtifact_ord;
	}

	public void accept(IArtifactsVisitor visitor) {
		visitor.visit(this);
	}

	private FileName name;

	public FileName getName() {
		return notifyRequested(ArtifactsFeatureDescriptorEnum.name, name);
	}

	public void setName(FileName name) {
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

	private Content content;

	public Content getContent() {
		return notifyRequested(ArtifactsFeatureDescriptorEnum.content, content);
	}

	public void setContent(Content content) {
		notifyChanged(ArtifactsFeatureDescriptorEnum.content, this.content,
				this.content = content);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getName().wGetAdaptee(false);
		case 1:
			return getMetadata().wGetAdaptee(false);
		case 2:
			return getContent().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setName(value.wGetAdapter(ArtifactsEntityDescriptorEnum.FileName));
			break;
		case 1:
			setMetadata(value
					.wGetAdapter(ArtifactsEntityDescriptorEnum.Metadata));
			break;
		case 2:
			setContent(value.wGetAdapter(ArtifactsEntityDescriptorEnum.Content));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 3;
	}
}
