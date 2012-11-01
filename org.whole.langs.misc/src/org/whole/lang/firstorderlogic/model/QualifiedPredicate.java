package org.whole.lang.firstorderlogic.model;

/** 
 * @generator Whole
 */
public interface QualifiedPredicate extends IFirstOrderLogicEntity, Predicate {
	public Name getTheoryAlias();

	public void setTheoryAlias(Name theoryAlias);

	public SimplePredicate getName();

	public void setName(SimplePredicate name);
}
