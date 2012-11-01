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
public class MetadataAdapter extends AbstractEntityAdapter implements Metadata {
	private static final long serialVersionUID = 1;

	public MetadataAdapter(IEntity implementor) {
		super(implementor);
	}

	public MetadataAdapter() {
	}

	public void accept(IArtifactsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Metadata> wGetEntityDescriptor() {
		return ArtifactsEntityDescriptorEnum.Metadata;
	}

	public Copyright getCopyright() {
		return wGet(ArtifactsFeatureDescriptorEnum.copyright).wGetAdapter(
				ArtifactsEntityDescriptorEnum.Copyright);
	}

	public void setCopyright(Copyright copyright) {
		wSet(ArtifactsFeatureDescriptorEnum.copyright, copyright);
	}

	public License getLicense() {
		return wGet(ArtifactsFeatureDescriptorEnum.license).wGetAdapter(
				ArtifactsEntityDescriptorEnum.License);
	}

	public void setLicense(License license) {
		wSet(ArtifactsFeatureDescriptorEnum.license, license);
	}

	public Author getAuthor() {
		return wGet(ArtifactsFeatureDescriptorEnum.author).wGetAdapter(
				ArtifactsEntityDescriptorEnum.Author);
	}

	public void setAuthor(Author author) {
		wSet(ArtifactsFeatureDescriptorEnum.author, author);
	}

	public Attributes getAttributes() {
		return wGet(ArtifactsFeatureDescriptorEnum.attributes).wGetAdapter(
				ArtifactsEntityDescriptorEnum.Attributes);
	}

	public void setAttributes(Attributes attributes) {
		wSet(ArtifactsFeatureDescriptorEnum.attributes, attributes);
	}

	public PersistenceKitId getPersistenceKitId() {
		return wGet(ArtifactsFeatureDescriptorEnum.persistenceKitId)
				.wGetAdapter(ArtifactsEntityDescriptorEnum.PersistenceKitId);
	}

	public void setPersistenceKitId(PersistenceKitId persistenceKitId) {
		wSet(ArtifactsFeatureDescriptorEnum.persistenceKitId, persistenceKitId);
	}
}
