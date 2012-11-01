package org.whole.lang.artifacts.builders;

import org.whole.lang.builders.IBuilder;
import org.whole.lang.artifacts.model.AttributeEnum;

/** 
 * @generator Whole
 */
public interface IArtifactsBuilder extends IBuilder {
	public void visit();

	public void extension();

	public void persistenceKitId();

	public void attributes();

	public void author();

	public void license();

	public void copyright();

	public void content();

	public void locationURI();

	public void artifacts();

	public void natures();

	public void name();

	public void projects();

	public void metadata();

	public void Workspace();

	public void Workspace_();

	public void _Workspace();

	public void Projects();

	public void Projects_();

	public void Projects_(int initialCapacity);

	public void _Projects();

	public void Project();

	public void Project_();

	public void _Project();

	public void Artifacts();

	public void Artifacts_();

	public void Artifacts_(int initialCapacity);

	public void _Artifacts();

	public void PackageArtifact();

	public void PackageArtifact_();

	public void _PackageArtifact();

	public void FolderArtifact();

	public void FolderArtifact_();

	public void _FolderArtifact();

	public void FileArtifact();

	public void FileArtifact_();

	public void _FileArtifact();

	public void Natures();

	public void Natures_();

	public void Natures_(int initialCapacity);

	public void _Natures();

	public void Nature();

	public void Nature(String value);

	public void LocationURI();

	public void LocationURI(String value);

	public void Metadata();

	public void Metadata_();

	public void _Metadata();

	public void Name();

	public void Name(String value);

	public void NameWithExtension();

	public void NameWithExtension_();

	public void _NameWithExtension();

	public void Copyright();

	public void Copyright(String value);

	public void License();

	public void License(String value);

	public void Author();

	public void Author(String value);

	public void Extension();

	public void Extension(String value);

	public void Attributes();

	public void Attributes_();

	public void Attributes_(int initialCapacity);

	public void _Attributes();

	public void Attribute();

	public void Attribute(AttributeEnum.Value value);

	public void Attribute(String value);

	public void PersistenceKitId();

	public void PersistenceKitId(String value);
}
