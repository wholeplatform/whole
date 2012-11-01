package org.whole.lang.versions.model.impl;

/** 
 * @generator Whole
 */
public class VersionsStrictImplEntityRegistry extends
		VersionsImplEntityRegistry {
	protected void createPrototypes() {
		super.createPrototypes();
		put(new VersionsStrictImpl());
		put(new VersionsRefsStrictImpl());
	}
}
