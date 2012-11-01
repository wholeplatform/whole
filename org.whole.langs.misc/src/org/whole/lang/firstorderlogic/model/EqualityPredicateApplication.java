package org.whole.lang.firstorderlogic.model;

/** 
 * @generator Whole
 */
public interface EqualityPredicateApplication extends IFirstOrderLogicEntity,
		Formula {
	public Term getLeftTerm();

	public void setLeftTerm(Term leftTerm);

	public Term getRightTerm();

	public void setRightTerm(Term rightTerm);
}
