package org.whole.lang.properties.model.impl;

/** 
 * @generator Whole
 */
public class PropertiesStrictImplEntityRegistry extends
		PropertiesImplEntityRegistry {
	protected void createPrototypes() {
		super.createPrototypes();
		put(new EntriesStrictImpl());
	}
}
