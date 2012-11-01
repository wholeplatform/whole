package org.whole.lang.commons.model.impl;

/** 
 * @generator Whole
 */
public class CommonsStrictImplEntityRegistry extends CommonsImplEntityRegistry {
	protected void createPrototypes() {
		super.createPrototypes();
		put(new MultiplexerStrictImpl());
	}
}
