package org.whole.lang.editors.model.impl;

/** 
 * @generator Whole
 */
public class EditorsStrictImplEntityRegistry extends EditorsImplEntityRegistry {
	protected void createPrototypes() {
		super.createPrototypes();
		put(new ControllerDeclarationsStrictImpl());
		put(new EntityFeaturesStrictImpl());
		put(new ViewDeclarationsStrictImpl());
		put(new RowStrictImpl());
		put(new EntityNamesStrictImpl());
	}
}
