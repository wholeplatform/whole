package org.whole.lang.versions.model.impl;

import org.whole.lang.factories.AbstractEntityRegistry;
import org.whole.lang.versions.reflect.VersionsEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class VersionsImplEntityRegistry extends AbstractEntityRegistry {
	public VersionsImplEntityRegistry() {
		super(VersionsEntityDescriptorEnum.instance);
	}

	protected void createPrototypes() {
		put(new HistoryImpl());
		put(new VersionImpl());
		put(new VersionsImpl());
		put(new VersionsRefsImpl());
		put(new VersionLabelImpl());
	}
}
