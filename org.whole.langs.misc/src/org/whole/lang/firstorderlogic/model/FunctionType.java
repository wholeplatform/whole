package org.whole.lang.firstorderlogic.model;

/** 
 * @generator Whole
 */
public interface FunctionType extends IFirstOrderLogicEntity, Type {
	public Parameters getParameters();

	public void setParameters(Parameters parameters);

	public Name getSort();

	public void setSort(Name sort);
}
