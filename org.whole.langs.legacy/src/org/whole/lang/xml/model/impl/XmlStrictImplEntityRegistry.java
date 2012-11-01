package org.whole.lang.xml.model.impl;

/** 
 * @generator Whole
 */
public class XmlStrictImplEntityRegistry extends XmlImplEntityRegistry {
	protected void createPrototypes() {
		super.createPrototypes();
		put(new AttributesStrictImpl());
	}
}
