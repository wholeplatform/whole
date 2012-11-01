package org.whole.lang.firstorderlogic.model;

/** 
 * @generator Whole
 */
public interface QualifiedFunction extends IFirstOrderLogicEntity, Function {
	public Name getTheoryAlias();

	public void setTheoryAlias(Name theoryAlias);

	public SimpleFunction getName();

	public void setName(SimpleFunction name);
}
