package org.whole.lang.types.model;

/** 
 * @generator Whole
 */
public interface Case extends ITypesEntity {
	public BasicType getType();

	public void setType(BasicType type);

	public Expressions getExpressions();

	public void setExpressions(Expressions expressions);
}
