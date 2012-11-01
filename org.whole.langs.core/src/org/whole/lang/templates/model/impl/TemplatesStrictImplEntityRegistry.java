package org.whole.lang.templates.model.impl;

/** 
 * @generator Whole
 */
public class TemplatesStrictImplEntityRegistry extends
		TemplatesImplEntityRegistry {
	protected void createPrototypes() {
		super.createPrototypes();
		put(new NamesStrictImpl());
	}
}
