package org.whole.lang.versions.model.adapters;

import org.whole.lang.factories.AbstractEntityRegistry;
import org.whole.lang.versions.reflect.VersionsEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class VersionsAdaptersEntityRegistry extends AbstractEntityRegistry {
	public VersionsAdaptersEntityRegistry() {
		super(VersionsEntityDescriptorEnum.instance);
	}

	protected void createPrototypes() {
		put(new HistoryAdapter());
		put(new VersionAdapter());
		put(new VersionableAdapter());
		put(new VersionsAdapter());
		put(new VersionsRefsAdapter());
		put(new VersionLabelAdapter());
	}
}
