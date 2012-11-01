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
public class FileArtifactAdapter extends AbstractEntityAdapter implements
		FileArtifact {
	private static final long serialVersionUID = 1;

	public FileArtifactAdapter(IEntity implementor) {
		super(implementor);
	}

	public FileArtifactAdapter() {
	}

	public void accept(IArtifactsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<FileArtifact> wGetEntityDescriptor() {
		return ArtifactsEntityDescriptorEnum.FileArtifact;
	}

	public FileName getName() {
		return wGet(ArtifactsFeatureDescriptorEnum.name).wGetAdapter(
				ArtifactsEntityDescriptorEnum.FileName);
	}

	public void setName(FileName name) {
		wSet(ArtifactsFeatureDescriptorEnum.name, name);
	}

	public Metadata getMetadata() {
		return wGet(ArtifactsFeatureDescriptorEnum.metadata).wGetAdapter(
				ArtifactsEntityDescriptorEnum.Metadata);
	}

	public void setMetadata(Metadata metadata) {
		wSet(ArtifactsFeatureDescriptorEnum.metadata, metadata);
	}

	public Content getContent() {
		return wGet(ArtifactsFeatureDescriptorEnum.content).wGetAdapter(
				ArtifactsEntityDescriptorEnum.Content);
	}

	public void setContent(Content content) {
		wSet(ArtifactsFeatureDescriptorEnum.content, content);
	}
}
