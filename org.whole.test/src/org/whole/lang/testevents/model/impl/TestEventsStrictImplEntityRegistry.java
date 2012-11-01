package org.whole.lang.testevents.model.impl;

/** 
 * @generator Whole
 */
public class TestEventsStrictImplEntityRegistry extends
		TestEventsImplEntityRegistry {
	protected void createPrototypes() {
		super.createPrototypes();
		put(new CompositeShapeStrictImpl());
	}
}
