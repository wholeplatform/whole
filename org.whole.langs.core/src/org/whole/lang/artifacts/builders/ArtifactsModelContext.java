package org.whole.lang.artifacts.builders;

import org.whole.lang.contexts.EntityContext;
import org.whole.lang.model.IEntity;
import org.whole.lang.artifacts.reflect.ArtifactsFeatureDescriptorEnum;

/** 
 * @generator Whole
 */
public class ArtifactsModelContext extends EntityContext {
	public ArtifactsModelContext(IEntity root) {
		super(root);
	}

	public ArtifactsModelContext getMetadata() {
		return (ArtifactsModelContext) wGet(ArtifactsFeatureDescriptorEnum.metadata);
	}

	public void setMetadata(ArtifactsModelContext metadata) {
		wSet(ArtifactsFeatureDescriptorEnum.metadata, metadata);
	}

	public ArtifactsModelContext getProjects() {
		return (ArtifactsModelContext) wGet(ArtifactsFeatureDescriptorEnum.projects);
	}

	public void setProjects(ArtifactsModelContext projects) {
		wSet(ArtifactsFeatureDescriptorEnum.projects, projects);
	}

	public ArtifactsModelContext getName() {
		return (ArtifactsModelContext) wGet(ArtifactsFeatureDescriptorEnum.name);
	}

	public void setName(ArtifactsModelContext name) {
		wSet(ArtifactsFeatureDescriptorEnum.name, name);
	}

	public ArtifactsModelContext getNatures() {
		return (ArtifactsModelContext) wGet(ArtifactsFeatureDescriptorEnum.natures);
	}

	public void setNatures(ArtifactsModelContext natures) {
		wSet(ArtifactsFeatureDescriptorEnum.natures, natures);
	}

	public ArtifactsModelContext getArtifacts() {
		return (ArtifactsModelContext) wGet(ArtifactsFeatureDescriptorEnum.artifacts);
	}

	public void setArtifacts(ArtifactsModelContext artifacts) {
		wSet(ArtifactsFeatureDescriptorEnum.artifacts, artifacts);
	}

	public ArtifactsModelContext getLocationURI() {
		return (ArtifactsModelContext) wGet(ArtifactsFeatureDescriptorEnum.locationURI);
	}

	public void setLocationURI(ArtifactsModelContext locationURI) {
		wSet(ArtifactsFeatureDescriptorEnum.locationURI, locationURI);
	}

	public ArtifactsModelContext getContent() {
		return (ArtifactsModelContext) wGet(ArtifactsFeatureDescriptorEnum.content);
	}

	public void setContent(ArtifactsModelContext content) {
		wSet(ArtifactsFeatureDescriptorEnum.content, content);
	}

	public ArtifactsModelContext getCopyright() {
		return (ArtifactsModelContext) wGet(ArtifactsFeatureDescriptorEnum.copyright);
	}

	public void setCopyright(ArtifactsModelContext copyright) {
		wSet(ArtifactsFeatureDescriptorEnum.copyright, copyright);
	}

	public ArtifactsModelContext getLicense() {
		return (ArtifactsModelContext) wGet(ArtifactsFeatureDescriptorEnum.license);
	}

	public void setLicense(ArtifactsModelContext license) {
		wSet(ArtifactsFeatureDescriptorEnum.license, license);
	}

	public ArtifactsModelContext getAuthor() {
		return (ArtifactsModelContext) wGet(ArtifactsFeatureDescriptorEnum.author);
	}

	public void setAuthor(ArtifactsModelContext author) {
		wSet(ArtifactsFeatureDescriptorEnum.author, author);
	}

	public ArtifactsModelContext getAttributes() {
		return (ArtifactsModelContext) wGet(ArtifactsFeatureDescriptorEnum.attributes);
	}

	public void setAttributes(ArtifactsModelContext attributes) {
		wSet(ArtifactsFeatureDescriptorEnum.attributes, attributes);
	}

	public ArtifactsModelContext getPersistenceKitId() {
		return (ArtifactsModelContext) wGet(ArtifactsFeatureDescriptorEnum.persistenceKitId);
	}

	public void setPersistenceKitId(ArtifactsModelContext persistenceKitId) {
		wSet(ArtifactsFeatureDescriptorEnum.persistenceKitId, persistenceKitId);
	}

	public ArtifactsModelContext getExtension() {
		return (ArtifactsModelContext) wGet(ArtifactsFeatureDescriptorEnum.extension);
	}

	public void setExtension(ArtifactsModelContext extension) {
		wSet(ArtifactsFeatureDescriptorEnum.extension, extension);
	}
}
