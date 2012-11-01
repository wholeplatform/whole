package org.whole.lang.frames.model.impl;

/** 
 * @generator Whole
 */
public class FramesStrictImplEntityRegistry extends FramesImplEntityRegistry {
	protected void createPrototypes() {
		super.createPrototypes();
		put(new MutuallyRequireStrictImpl());
		put(new MutuallyExcludeStrictImpl());
		put(new FeatureNamesStrictImpl());
	}
}
