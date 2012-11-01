package org.whole.lang.artifacts.model.impl;

/** 
 * @generator Whole
 */
public class ArtifactsStrictImplEntityRegistry extends
		ArtifactsImplEntityRegistry {
	protected void createPrototypes() {
		super.createPrototypes();
		put(new ProjectsStrictImpl());
		put(new AttributesStrictImpl());
	}
}
