package org.whole.lang.firstorderlogic.model;

/** 
 * @generator Whole
 */
public interface SubtypeDeclaration extends IFirstOrderLogicEntity, Declaration {
	public Name getSubSort();

	public void setSubSort(Name subSort);

	public Name getSuperSort();

	public void setSuperSort(Name superSort);
}
