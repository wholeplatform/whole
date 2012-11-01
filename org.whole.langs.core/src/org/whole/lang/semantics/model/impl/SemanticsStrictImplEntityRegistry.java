package org.whole.lang.semantics.model.impl;

/** 
 * @generator Whole
 */
public class SemanticsStrictImplEntityRegistry extends
		SemanticsImplEntityRegistry {
	protected void createPrototypes() {
		super.createPrototypes();
		put(new LocalBindingsStrictImpl());
	}
}
