package org.whole.lang.testentities.model.impl;

/** 
 * @generator Whole
 */
public class TestEntitiesStrictImplEntityRegistry extends
		TestEntitiesImplEntityRegistry {
	protected void createPrototypes() {
		super.createPrototypes();
		put(new UListTestEntityStrictImpl());
		put(new SetTestEntityStrictImpl());
		put(new BagTestEntityStrictImpl());
	}
}
