package org.whole.lang.types.model;

/** 
 * @generator Whole
 */
public interface TypeSystem extends ITypesEntity {
	public Operations getCheckBefore();

	public void setCheckBefore(Operations checkBefore);

	public TypeRules getRules();

	public void setRules(TypeRules rules);
}
