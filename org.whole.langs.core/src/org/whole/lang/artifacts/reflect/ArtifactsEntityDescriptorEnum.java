package org.whole.lang.artifacts.reflect;

import org.whole.lang.reflect.EntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.artifacts.model.*;

/** 
 * @generator Whole
 */
@SuppressWarnings("unchecked")
public class ArtifactsEntityDescriptorEnum extends EntityDescriptorEnum {
	public static final int Workspace_ord = 0;
	public static final int Projects_ord = 1;
	public static final int Project_ord = 2;
	public static final int Artifacts_ord = 3;
	public static final int PackageArtifact_ord = 4;
	public static final int FolderArtifact_ord = 5;
	public static final int FileArtifact_ord = 6;
	public static final int Natures_ord = 7;
	public static final int Nature_ord = 8;
	public static final int LocationURI_ord = 9;
	public static final int Metadata_ord = 10;
	public static final int Name_ord = 11;
	public static final int NameWithExtension_ord = 12;
	public static final int Copyright_ord = 13;
	public static final int License_ord = 14;
	public static final int Author_ord = 15;
	public static final int Extension_ord = 16;
	public static final int Attributes_ord = 17;
	public static final int Attribute_ord = 18;
	public static final int PersistenceKitId_ord = 19;
	public static final int Content_ord = 20;
	public static final int ProjectName_ord = 21;
	public static final int Artifact_ord = 22;
	public static final int PackageName_ord = 23;
	public static final int FileName_ord = 24;
	public static final int FolderName_ord = 25;
	public static final ArtifactsEntityDescriptorEnum instance = new ArtifactsEntityDescriptorEnum();
	public static final EntityDescriptor<Workspace> Workspace = (EntityDescriptor<Workspace>) instance
			.valueOf(Workspace_ord);
	public static final EntityDescriptor<Projects> Projects = (EntityDescriptor<Projects>) instance
			.valueOf(Projects_ord);
	public static final EntityDescriptor<Project> Project = (EntityDescriptor<Project>) instance
			.valueOf(Project_ord);
	public static final EntityDescriptor<Artifacts> Artifacts = (EntityDescriptor<Artifacts>) instance
			.valueOf(Artifacts_ord);
	public static final EntityDescriptor<PackageArtifact> PackageArtifact = (EntityDescriptor<PackageArtifact>) instance
			.valueOf(PackageArtifact_ord);
	public static final EntityDescriptor<FolderArtifact> FolderArtifact = (EntityDescriptor<FolderArtifact>) instance
			.valueOf(FolderArtifact_ord);
	public static final EntityDescriptor<FileArtifact> FileArtifact = (EntityDescriptor<FileArtifact>) instance
			.valueOf(FileArtifact_ord);
	public static final EntityDescriptor<Natures> Natures = (EntityDescriptor<Natures>) instance
			.valueOf(Natures_ord);
	public static final EntityDescriptor<Nature> Nature = (EntityDescriptor<Nature>) instance
			.valueOf(Nature_ord);
	public static final EntityDescriptor<LocationURI> LocationURI = (EntityDescriptor<LocationURI>) instance
			.valueOf(LocationURI_ord);
	public static final EntityDescriptor<Metadata> Metadata = (EntityDescriptor<Metadata>) instance
			.valueOf(Metadata_ord);
	public static final EntityDescriptor<Name> Name = (EntityDescriptor<Name>) instance
			.valueOf(Name_ord);
	public static final EntityDescriptor<NameWithExtension> NameWithExtension = (EntityDescriptor<NameWithExtension>) instance
			.valueOf(NameWithExtension_ord);
	public static final EntityDescriptor<Copyright> Copyright = (EntityDescriptor<Copyright>) instance
			.valueOf(Copyright_ord);
	public static final EntityDescriptor<License> License = (EntityDescriptor<License>) instance
			.valueOf(License_ord);
	public static final EntityDescriptor<Author> Author = (EntityDescriptor<Author>) instance
			.valueOf(Author_ord);
	public static final EntityDescriptor<Extension> Extension = (EntityDescriptor<Extension>) instance
			.valueOf(Extension_ord);
	public static final EntityDescriptor<Attributes> Attributes = (EntityDescriptor<Attributes>) instance
			.valueOf(Attributes_ord);
	public static final EntityDescriptor<Attribute> Attribute = (EntityDescriptor<Attribute>) instance
			.valueOf(Attribute_ord);
	public static final EntityDescriptor<PersistenceKitId> PersistenceKitId = (EntityDescriptor<PersistenceKitId>) instance
			.valueOf(PersistenceKitId_ord);
	public static final EntityDescriptor<Content> Content = (EntityDescriptor<Content>) instance
			.valueOf(Content_ord);
	public static final EntityDescriptor<ProjectName> ProjectName = (EntityDescriptor<ProjectName>) instance
			.valueOf(ProjectName_ord);
	public static final EntityDescriptor<Artifact> Artifact = (EntityDescriptor<Artifact>) instance
			.valueOf(Artifact_ord);
	public static final EntityDescriptor<PackageName> PackageName = (EntityDescriptor<PackageName>) instance
			.valueOf(PackageName_ord);
	public static final EntityDescriptor<FileName> FileName = (EntityDescriptor<FileName>) instance
			.valueOf(FileName_ord);
	public static final EntityDescriptor<FolderName> FolderName = (EntityDescriptor<FolderName>) instance
			.valueOf(FolderName_ord);

	private ArtifactsEntityDescriptorEnum() {
	}

	private static final long serialVersionUID = 1;

	protected void initEntityDescriptors() {
		putSimpleEntity(Workspace_ord, "Workspace", Workspace.class, false)
				.withFeature(ArtifactsFeatureDescriptorEnum.metadata,
						Metadata_ord, true, false, false, false, false)
				.withFeature(ArtifactsFeatureDescriptorEnum.projects,
						Projects_ord);
		putCompositeEntity(
		Projects_ord, "Projects", Projects.class, false, Project_ord, true, true);
		putSimpleEntity(Project_ord, "Project", Project.class, false)
				.withFeature(ArtifactsFeatureDescriptorEnum.name,
						ProjectName_ord, false, true, false, false, false)
				.withFeature(ArtifactsFeatureDescriptorEnum.natures,
						Natures_ord)
				.withFeature(ArtifactsFeatureDescriptorEnum.metadata,
						Metadata_ord, true, false, false, false, false)
				.withFeature(ArtifactsFeatureDescriptorEnum.artifacts,
						Artifacts_ord)
				.withFeature(ArtifactsFeatureDescriptorEnum.locationURI,
						LocationURI_ord, true, false, false, false, false);
		putCompositeEntity(
		Artifacts_ord, "Artifacts", Artifacts.class, false, Artifact_ord, true, false);
		putSimpleEntity(PackageArtifact_ord, "PackageArtifact",
				PackageArtifact.class, false)
				.withFeature(ArtifactsFeatureDescriptorEnum.name,
						PackageName_ord)
				.withFeature(ArtifactsFeatureDescriptorEnum.metadata,
						Metadata_ord, true, false, false, false, false)
				.withFeature(ArtifactsFeatureDescriptorEnum.artifacts,
						Artifacts_ord);
		putSimpleEntity(FolderArtifact_ord, "FolderArtifact",
				FolderArtifact.class, false)
				.withFeature(ArtifactsFeatureDescriptorEnum.name,
						FolderName_ord)
				.withFeature(ArtifactsFeatureDescriptorEnum.metadata,
						Metadata_ord, true, false, false, false, false)
				.withFeature(ArtifactsFeatureDescriptorEnum.artifacts,
						Artifacts_ord);
		putSimpleEntity(FileArtifact_ord, "FileArtifact", FileArtifact.class,
				false)
				.withFeature(ArtifactsFeatureDescriptorEnum.name, FileName_ord)
				.withFeature(ArtifactsFeatureDescriptorEnum.metadata,
						Metadata_ord, true, false, false, false, false)
				.withFeature(ArtifactsFeatureDescriptorEnum.content,
						Content_ord);
		putCompositeEntity(
		Natures_ord, "Natures", Natures.class, false, Nature_ord, true, false);
		putDataEntity(Nature_ord, "Nature", Nature.class, false, String.class);
		putDataEntity(LocationURI_ord, "LocationURI", LocationURI.class, false,
				String.class);
		putSimpleEntity(Metadata_ord, "Metadata", Metadata.class, false)
				.withFeature(ArtifactsFeatureDescriptorEnum.copyright,
						Copyright_ord, true, false, false, false, false)
				.withFeature(ArtifactsFeatureDescriptorEnum.license,
						License_ord, true, false, false, false, false)
				.withFeature(ArtifactsFeatureDescriptorEnum.author, Author_ord,
						true, false, false, false, false)
				.withFeature(ArtifactsFeatureDescriptorEnum.attributes,
						Attributes_ord, true, false, false, false, false)
				.withFeature(ArtifactsFeatureDescriptorEnum.persistenceKitId,
						PersistenceKitId_ord, true, false, false, false, false);
		putDataEntity(Name_ord, "Name", Name.class, false, String.class);
		putSimpleEntity(NameWithExtension_ord, "NameWithExtension",
				NameWithExtension.class, false).withFeature(
				ArtifactsFeatureDescriptorEnum.name, Name_ord).withFeature(
				ArtifactsFeatureDescriptorEnum.extension, Extension_ord);
		putDataEntity(Copyright_ord, "Copyright", Copyright.class, false,
				String.class);
		putDataEntity(License_ord, "License", License.class, false,
				String.class);
		putDataEntity(Author_ord, "Author", Author.class, false, String.class);
		putDataEntity(Extension_ord, "Extension", Extension.class, false,
				String.class);
		putCompositeEntity(
		Attributes_ord, "Attributes", Attributes.class, false, Attribute_ord, false, true);
		putDataEntity(Attribute_ord, "Attribute", Attribute.class, false,
				AttributeEnum.Value.class);
		putDataEntity(PersistenceKitId_ord, "PersistenceKitId",
				PersistenceKitId.class, false, String.class);
		putSimpleEntity(Content_ord, "Content", Content.class, true);
		putSimpleEntity(ProjectName_ord, "ProjectName", ProjectName.class,
				true, Name_ord);
		putSimpleEntity(Artifact_ord, "Artifact", Artifact.class, true,
				FileArtifact_ord, FolderArtifact_ord, PackageArtifact_ord);
		putSimpleEntity(PackageName_ord, "PackageName", PackageName.class,
				true, Name_ord);
		putSimpleEntity(FileName_ord, "FileName", FileName.class, true,
				Name_ord, NameWithExtension_ord);
		putSimpleEntity(FolderName_ord, "FolderName", FolderName.class, true,
				Name_ord);
	}
}
