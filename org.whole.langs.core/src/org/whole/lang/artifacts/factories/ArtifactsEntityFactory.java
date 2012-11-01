package org.whole.lang.artifacts.factories;

import org.whole.lang.factories.GenericEntityFactory;
import org.whole.lang.artifacts.model.*;
import org.whole.lang.factories.RegistryConfigurations;
import org.whole.lang.factories.IEntityRegistryProvider;
import org.whole.lang.artifacts.reflect.ArtifactsEntityDescriptorEnum;
import org.whole.lang.factories.IEntityBuilder;
import org.whole.lang.factories.EntityBuilder;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class ArtifactsEntityFactory extends GenericEntityFactory {
	public static final ArtifactsEntityFactory instance = instance(RegistryConfigurations.DEFAULT);

	public static ArtifactsEntityFactory instance(
			IEntityRegistryProvider provider) {
		return new ArtifactsEntityFactory(provider);
	}

	protected ArtifactsEntityFactory(IEntityRegistryProvider provider) {
		super(provider);
	}

	public Workspace createWorkspace() {
		return create(ArtifactsEntityDescriptorEnum.Workspace);
	}

	public Workspace createWorkspace(Metadata metadata, Projects projects) {
		return create(ArtifactsEntityDescriptorEnum.Workspace, metadata,
				projects);
	}

	public IEntityBuilder<Workspace> buildWorkspace() {
		return new EntityBuilder<Workspace>(
				create(ArtifactsEntityDescriptorEnum.Workspace));
	}

	public Projects createProjects() {
		return create(ArtifactsEntityDescriptorEnum.Projects);
	}

	public Projects createProjects(Project... entities) {
		return create(ArtifactsEntityDescriptorEnum.Projects,
				(IEntity[]) entities);
	}

	public Projects createProjects(int initialSize) {
		return clone(ArtifactsEntityDescriptorEnum.Projects, initialSize);
	}

	public Project createProject() {
		return create(ArtifactsEntityDescriptorEnum.Project);
	}

	public Project createProject(ProjectName name, Natures natures,
			Metadata metadata, Artifacts artifacts, LocationURI locationURI) {
		return create(ArtifactsEntityDescriptorEnum.Project, name, natures,
				metadata, artifacts, locationURI);
	}

	public IEntityBuilder<Project> buildProject() {
		return new EntityBuilder<Project>(
				create(ArtifactsEntityDescriptorEnum.Project));
	}

	public Artifacts createArtifacts() {
		return create(ArtifactsEntityDescriptorEnum.Artifacts);
	}

	public Artifacts createArtifacts(Artifact... entities) {
		return create(ArtifactsEntityDescriptorEnum.Artifacts,
				(IEntity[]) entities);
	}

	public Artifacts createArtifacts(int initialSize) {
		return clone(ArtifactsEntityDescriptorEnum.Artifacts, initialSize);
	}

	public PackageArtifact createPackageArtifact() {
		return create(ArtifactsEntityDescriptorEnum.PackageArtifact);
	}

	public PackageArtifact createPackageArtifact(PackageName name,
			Metadata metadata, Artifacts artifacts) {
		return create(ArtifactsEntityDescriptorEnum.PackageArtifact, name,
				metadata, artifacts);
	}

	public IEntityBuilder<PackageArtifact> buildPackageArtifact() {
		return new EntityBuilder<PackageArtifact>(
				create(ArtifactsEntityDescriptorEnum.PackageArtifact));
	}

	public FolderArtifact createFolderArtifact() {
		return create(ArtifactsEntityDescriptorEnum.FolderArtifact);
	}

	public FolderArtifact createFolderArtifact(FolderName name,
			Metadata metadata, Artifacts artifacts) {
		return create(ArtifactsEntityDescriptorEnum.FolderArtifact, name,
				metadata, artifacts);
	}

	public IEntityBuilder<FolderArtifact> buildFolderArtifact() {
		return new EntityBuilder<FolderArtifact>(
				create(ArtifactsEntityDescriptorEnum.FolderArtifact));
	}

	public FileArtifact createFileArtifact() {
		return create(ArtifactsEntityDescriptorEnum.FileArtifact);
	}

	public FileArtifact createFileArtifact(FileName name, Metadata metadata,
			Content content) {
		return create(ArtifactsEntityDescriptorEnum.FileArtifact, name,
				metadata, content);
	}

	public IEntityBuilder<FileArtifact> buildFileArtifact() {
		return new EntityBuilder<FileArtifact>(
				create(ArtifactsEntityDescriptorEnum.FileArtifact));
	}

	public Natures createNatures() {
		return create(ArtifactsEntityDescriptorEnum.Natures);
	}

	public Natures createNatures(Nature... entities) {
		return create(ArtifactsEntityDescriptorEnum.Natures,
				(IEntity[]) entities);
	}

	public Natures createNatures(int initialSize) {
		return clone(ArtifactsEntityDescriptorEnum.Natures, initialSize);
	}

	public Nature createNature() {
		return create(ArtifactsEntityDescriptorEnum.Nature);
	}

	public Nature createNature(String value) {
		return create(ArtifactsEntityDescriptorEnum.Nature, value);
	}

	public LocationURI createLocationURI() {
		return create(ArtifactsEntityDescriptorEnum.LocationURI);
	}

	public LocationURI createLocationURI(String value) {
		return create(ArtifactsEntityDescriptorEnum.LocationURI, value);
	}

	public Metadata createMetadata() {
		return create(ArtifactsEntityDescriptorEnum.Metadata);
	}

	public Metadata createMetadata(Copyright copyright, License license,
			Author author, Attributes attributes,
			PersistenceKitId persistenceKitId) {
		return create(ArtifactsEntityDescriptorEnum.Metadata, copyright,
				license, author, attributes, persistenceKitId);
	}

	public IEntityBuilder<Metadata> buildMetadata() {
		return new EntityBuilder<Metadata>(
				create(ArtifactsEntityDescriptorEnum.Metadata));
	}

	public Name createName() {
		return create(ArtifactsEntityDescriptorEnum.Name);
	}

	public Name createName(String value) {
		return create(ArtifactsEntityDescriptorEnum.Name, value);
	}

	public NameWithExtension createNameWithExtension() {
		return create(ArtifactsEntityDescriptorEnum.NameWithExtension);
	}

	public NameWithExtension createNameWithExtension(Name name,
			Extension extension) {
		return create(ArtifactsEntityDescriptorEnum.NameWithExtension, name,
				extension);
	}

	public IEntityBuilder<NameWithExtension> buildNameWithExtension() {
		return new EntityBuilder<NameWithExtension>(
				create(ArtifactsEntityDescriptorEnum.NameWithExtension));
	}

	public Copyright createCopyright() {
		return create(ArtifactsEntityDescriptorEnum.Copyright);
	}

	public Copyright createCopyright(String value) {
		return create(ArtifactsEntityDescriptorEnum.Copyright, value);
	}

	public License createLicense() {
		return create(ArtifactsEntityDescriptorEnum.License);
	}

	public License createLicense(String value) {
		return create(ArtifactsEntityDescriptorEnum.License, value);
	}

	public Author createAuthor() {
		return create(ArtifactsEntityDescriptorEnum.Author);
	}

	public Author createAuthor(String value) {
		return create(ArtifactsEntityDescriptorEnum.Author, value);
	}

	public Extension createExtension() {
		return create(ArtifactsEntityDescriptorEnum.Extension);
	}

	public Extension createExtension(String value) {
		return create(ArtifactsEntityDescriptorEnum.Extension, value);
	}

	public Attributes createAttributes() {
		return create(ArtifactsEntityDescriptorEnum.Attributes);
	}

	public Attributes createAttributes(Attribute... entities) {
		return create(ArtifactsEntityDescriptorEnum.Attributes,
				(IEntity[]) entities);
	}

	public Attributes createAttributes(int initialSize) {
		return clone(ArtifactsEntityDescriptorEnum.Attributes, initialSize);
	}

	public Attribute createAttribute() {
		return create(ArtifactsEntityDescriptorEnum.Attribute);
	}

	public Attribute createAttribute(AttributeEnum.Value value) {
		return create(ArtifactsEntityDescriptorEnum.Attribute, value);
	}

	public PersistenceKitId createPersistenceKitId() {
		return create(ArtifactsEntityDescriptorEnum.PersistenceKitId);
	}

	public PersistenceKitId createPersistenceKitId(String value) {
		return create(ArtifactsEntityDescriptorEnum.PersistenceKitId, value);
	}
}
