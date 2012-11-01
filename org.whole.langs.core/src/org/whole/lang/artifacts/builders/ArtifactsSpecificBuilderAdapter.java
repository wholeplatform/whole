package org.whole.lang.artifacts.builders;

import org.whole.lang.builders.GenericBuilderContext;
import org.whole.lang.builders.IBuilder;
import org.whole.lang.contexts.IEntityContext;
import org.whole.lang.artifacts.reflect.ArtifactsFeatureDescriptorEnum;
import org.whole.lang.artifacts.reflect.ArtifactsEntityDescriptorEnum;
import org.whole.lang.artifacts.model.AttributeEnum;

/** 
 * @generator Whole
 */
public class ArtifactsSpecificBuilderAdapter extends GenericBuilderContext
		implements IArtifactsBuilder {
	public ArtifactsSpecificBuilderAdapter(IBuilder strategy) {
		super(strategy);
	}

	public ArtifactsSpecificBuilderAdapter(IBuilder strategy,
			IEntityContext entityContext) {
		super(strategy, entityContext);
	}

	public void extension() {
		wFeature(ArtifactsFeatureDescriptorEnum.extension);
	}

	public void persistenceKitId() {
		wFeature(ArtifactsFeatureDescriptorEnum.persistenceKitId);
	}

	public void attributes() {
		wFeature(ArtifactsFeatureDescriptorEnum.attributes);
	}

	public void author() {
		wFeature(ArtifactsFeatureDescriptorEnum.author);
	}

	public void license() {
		wFeature(ArtifactsFeatureDescriptorEnum.license);
	}

	public void copyright() {
		wFeature(ArtifactsFeatureDescriptorEnum.copyright);
	}

	public void content() {
		wFeature(ArtifactsFeatureDescriptorEnum.content);
	}

	public void locationURI() {
		wFeature(ArtifactsFeatureDescriptorEnum.locationURI);
	}

	public void artifacts() {
		wFeature(ArtifactsFeatureDescriptorEnum.artifacts);
	}

	public void natures() {
		wFeature(ArtifactsFeatureDescriptorEnum.natures);
	}

	public void name() {
		wFeature(ArtifactsFeatureDescriptorEnum.name);
	}

	public void projects() {
		wFeature(ArtifactsFeatureDescriptorEnum.projects);
	}

	public void metadata() {
		wFeature(ArtifactsFeatureDescriptorEnum.metadata);
	}

	public void visit() {
	}

	public void Workspace() {
		wEntity(ArtifactsEntityDescriptorEnum.Workspace);
	}

	public void Workspace_() {
		wEntity_(ArtifactsEntityDescriptorEnum.Workspace);
	}

	public void _Workspace() {
		_wEntity(ArtifactsEntityDescriptorEnum.Workspace);
	}

	public void Projects() {
		wEntity(ArtifactsEntityDescriptorEnum.Projects);
	}

	public void Projects_() {
		wEntity_(ArtifactsEntityDescriptorEnum.Projects);
	}

	public void Projects_(int initialCapacity) {
		wEntity_(ArtifactsEntityDescriptorEnum.Projects, initialCapacity);
	}

	public void _Projects() {
		_wEntity(ArtifactsEntityDescriptorEnum.Projects);
	}

	public void Project() {
		wEntity(ArtifactsEntityDescriptorEnum.Project);
	}

	public void Project_() {
		wEntity_(ArtifactsEntityDescriptorEnum.Project);
	}

	public void _Project() {
		_wEntity(ArtifactsEntityDescriptorEnum.Project);
	}

	public void Artifacts() {
		wEntity(ArtifactsEntityDescriptorEnum.Artifacts);
	}

	public void Artifacts_() {
		wEntity_(ArtifactsEntityDescriptorEnum.Artifacts);
	}

	public void Artifacts_(int initialCapacity) {
		wEntity_(ArtifactsEntityDescriptorEnum.Artifacts, initialCapacity);
	}

	public void _Artifacts() {
		_wEntity(ArtifactsEntityDescriptorEnum.Artifacts);
	}

	public void PackageArtifact() {
		wEntity(ArtifactsEntityDescriptorEnum.PackageArtifact);
	}

	public void PackageArtifact_() {
		wEntity_(ArtifactsEntityDescriptorEnum.PackageArtifact);
	}

	public void _PackageArtifact() {
		_wEntity(ArtifactsEntityDescriptorEnum.PackageArtifact);
	}

	public void FolderArtifact() {
		wEntity(ArtifactsEntityDescriptorEnum.FolderArtifact);
	}

	public void FolderArtifact_() {
		wEntity_(ArtifactsEntityDescriptorEnum.FolderArtifact);
	}

	public void _FolderArtifact() {
		_wEntity(ArtifactsEntityDescriptorEnum.FolderArtifact);
	}

	public void FileArtifact() {
		wEntity(ArtifactsEntityDescriptorEnum.FileArtifact);
	}

	public void FileArtifact_() {
		wEntity_(ArtifactsEntityDescriptorEnum.FileArtifact);
	}

	public void _FileArtifact() {
		_wEntity(ArtifactsEntityDescriptorEnum.FileArtifact);
	}

	public void Natures() {
		wEntity(ArtifactsEntityDescriptorEnum.Natures);
	}

	public void Natures_() {
		wEntity_(ArtifactsEntityDescriptorEnum.Natures);
	}

	public void Natures_(int initialCapacity) {
		wEntity_(ArtifactsEntityDescriptorEnum.Natures, initialCapacity);
	}

	public void _Natures() {
		_wEntity(ArtifactsEntityDescriptorEnum.Natures);
	}

	public void Nature() {
		wEntity(ArtifactsEntityDescriptorEnum.Nature);
	}

	public void Nature(String value) {
		wEntity(ArtifactsEntityDescriptorEnum.Nature, value);
	}

	public void LocationURI() {
		wEntity(ArtifactsEntityDescriptorEnum.LocationURI);
	}

	public void LocationURI(String value) {
		wEntity(ArtifactsEntityDescriptorEnum.LocationURI, value);
	}

	public void Metadata() {
		wEntity(ArtifactsEntityDescriptorEnum.Metadata);
	}

	public void Metadata_() {
		wEntity_(ArtifactsEntityDescriptorEnum.Metadata);
	}

	public void _Metadata() {
		_wEntity(ArtifactsEntityDescriptorEnum.Metadata);
	}

	public void Name() {
		wEntity(ArtifactsEntityDescriptorEnum.Name);
	}

	public void Name(String value) {
		wEntity(ArtifactsEntityDescriptorEnum.Name, value);
	}

	public void NameWithExtension() {
		wEntity(ArtifactsEntityDescriptorEnum.NameWithExtension);
	}

	public void NameWithExtension_() {
		wEntity_(ArtifactsEntityDescriptorEnum.NameWithExtension);
	}

	public void _NameWithExtension() {
		_wEntity(ArtifactsEntityDescriptorEnum.NameWithExtension);
	}

	public void Copyright() {
		wEntity(ArtifactsEntityDescriptorEnum.Copyright);
	}

	public void Copyright(String value) {
		wEntity(ArtifactsEntityDescriptorEnum.Copyright, value);
	}

	public void License() {
		wEntity(ArtifactsEntityDescriptorEnum.License);
	}

	public void License(String value) {
		wEntity(ArtifactsEntityDescriptorEnum.License, value);
	}

	public void Author() {
		wEntity(ArtifactsEntityDescriptorEnum.Author);
	}

	public void Author(String value) {
		wEntity(ArtifactsEntityDescriptorEnum.Author, value);
	}

	public void Extension() {
		wEntity(ArtifactsEntityDescriptorEnum.Extension);
	}

	public void Extension(String value) {
		wEntity(ArtifactsEntityDescriptorEnum.Extension, value);
	}

	public void Attributes() {
		wEntity(ArtifactsEntityDescriptorEnum.Attributes);
	}

	public void Attributes_() {
		wEntity_(ArtifactsEntityDescriptorEnum.Attributes);
	}

	public void Attributes_(int initialCapacity) {
		wEntity_(ArtifactsEntityDescriptorEnum.Attributes, initialCapacity);
	}

	public void _Attributes() {
		_wEntity(ArtifactsEntityDescriptorEnum.Attributes);
	}

	public void Attribute() {
		wEntity(ArtifactsEntityDescriptorEnum.Attribute);
	}

	public void Attribute(AttributeEnum.Value value) {
		wEntity(ArtifactsEntityDescriptorEnum.Attribute, value);
	}

	public void Attribute(String value) {
		wEntity(ArtifactsEntityDescriptorEnum.Attribute, value);
	}

	public void PersistenceKitId() {
		wEntity(ArtifactsEntityDescriptorEnum.PersistenceKitId);
	}

	public void PersistenceKitId(String value) {
		wEntity(ArtifactsEntityDescriptorEnum.PersistenceKitId, value);
	}
}
