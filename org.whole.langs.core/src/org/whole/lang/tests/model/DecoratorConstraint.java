package org.whole.lang.tests.model;

/** 
 * @generator Whole
 */
public interface DecoratorConstraint extends ITestsEntity, Constraint {
	public Constraint getConstraint();

	public void setConstraint(Constraint constraint);
}
