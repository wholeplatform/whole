package org.whole.lang.artifacts.model.impl;

import org.whole.lang.factories.AbstractEntityRegistry;
import org.whole.lang.artifacts.reflect.ArtifactsEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class ArtifactsImplEntityRegistry extends AbstractEntityRegistry {
	public ArtifactsImplEntityRegistry() {
		super(ArtifactsEntityDescriptorEnum.instance);
	}

	protected void createPrototypes() {
		put(new WorkspaceImpl());
		put(new ProjectsImpl());
		put(new ProjectImpl());
		put(new ArtifactsImpl());
		put(new PackageArtifactImpl());
		put(new FolderArtifactImpl());
		put(new FileArtifactImpl());
		put(new NaturesImpl());
		put(new NatureImpl());
		put(new LocationURIImpl());
		put(new MetadataImpl());
		put(new NameImpl());
		put(new NameWithExtensionImpl());
		put(new CopyrightImpl());
		put(new LicenseImpl());
		put(new AuthorImpl());
		put(new ExtensionImpl());
		put(new AttributesImpl());
		put(new AttributeImpl());
		put(new PersistenceKitIdImpl());
	}
}
