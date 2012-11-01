package org.whole.lang.artifacts.model.adapters;

import org.whole.lang.factories.AbstractEntityRegistry;
import org.whole.lang.artifacts.reflect.ArtifactsEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class ArtifactsAdaptersEntityRegistry extends AbstractEntityRegistry {
	public ArtifactsAdaptersEntityRegistry() {
		super(ArtifactsEntityDescriptorEnum.instance);
	}

	protected void createPrototypes() {
		put(new WorkspaceAdapter());
		put(new ProjectsAdapter());
		put(new ProjectAdapter());
		put(new ArtifactsAdapter());
		put(new PackageArtifactAdapter());
		put(new FolderArtifactAdapter());
		put(new FileArtifactAdapter());
		put(new NaturesAdapter());
		put(new NatureAdapter());
		put(new LocationURIAdapter());
		put(new MetadataAdapter());
		put(new NameAdapter());
		put(new NameWithExtensionAdapter());
		put(new CopyrightAdapter());
		put(new LicenseAdapter());
		put(new AuthorAdapter());
		put(new ExtensionAdapter());
		put(new AttributesAdapter());
		put(new AttributeAdapter());
		put(new PersistenceKitIdAdapter());
		put(new ContentAdapter());
		put(new ProjectNameAdapter());
		put(new ArtifactAdapter());
		put(new PackageNameAdapter());
		put(new FileNameAdapter());
		put(new FolderNameAdapter());
	}
}
