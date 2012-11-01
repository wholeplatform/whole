package org.whole.lang.xsd.mapping.model.impl;

/** 
 * @generator Whole
 */
public class MappingStrictImplEntityRegistry extends MappingImplEntityRegistry {
	protected void createPrototypes() {
		super.createPrototypes();
		put(new MappingsStrictImpl());
		put(new TypesStrictImpl());
		put(new DataTypesStrictImpl());
		put(new EnumValuesStrictImpl());
	}
}
