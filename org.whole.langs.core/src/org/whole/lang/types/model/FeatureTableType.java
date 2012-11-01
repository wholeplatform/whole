package org.whole.lang.types.model;

/** 
 * @generator Whole
 */
public interface FeatureTableType extends ITypesEntity, Type {
	public Arguments getArguments();

	public void setArguments(Arguments arguments);

	public Cases getCases();

	public void setCases(Cases cases);
}
