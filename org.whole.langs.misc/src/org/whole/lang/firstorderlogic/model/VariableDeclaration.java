package org.whole.lang.firstorderlogic.model;

/** 
 * @generator Whole
 */
public interface VariableDeclaration extends IFirstOrderLogicEntity {
	public Name getName();

	public void setName(Name name);

	public Name getSort();

	public void setSort(Name sort);
}
