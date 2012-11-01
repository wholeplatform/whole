package org.whole.lang.models.model.impl;

/** 
 * @generator Whole
 */
public class ModelsStrictImplEntityRegistry extends ModelsImplEntityRegistry {
	protected void createPrototypes() {
		super.createPrototypes();
		put(new EntityModifiersStrictImpl());
		put(new FeatureModifiersStrictImpl());
		put(new ComponentModifiersStrictImpl());
		put(new EnumValuesStrictImpl());
	}
}
