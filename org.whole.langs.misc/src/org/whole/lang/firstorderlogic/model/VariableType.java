package org.whole.lang.firstorderlogic.model;

/** 
 * @generator Whole
 */
public interface VariableType extends IFirstOrderLogicEntity, Type {
	public Name getSort();

	public void setSort(Name sort);
}
