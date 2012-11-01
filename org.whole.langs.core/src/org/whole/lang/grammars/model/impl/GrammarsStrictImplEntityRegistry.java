package org.whole.lang.grammars.model.impl;

/** 
 * @generator Whole
 */
public class GrammarsStrictImplEntityRegistry extends
		GrammarsImplEntityRegistry {
	protected void createPrototypes() {
		super.createPrototypes();
		put(new ProductionsStrictImpl());
	}
}
