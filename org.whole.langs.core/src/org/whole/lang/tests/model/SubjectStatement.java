package org.whole.lang.tests.model;

/** 
 * @generator Whole
 */
public interface SubjectStatement extends ITestsEntity, TestStatement {
	public Expression getSubject();

	public void setSubject(Expression subject);

	public Constraint getConstraint();

	public void setConstraint(Constraint constraint);
}
