package org.whole.lang.tests.model;

/** 
 * @generator Whole
 */
public interface UsingFilter extends ITestsEntity, TestStatement {
	public Filter getFilter();

	public void setFilter(Filter filter);

	public SubjectStatement getSubjectStatement();

	public void setSubjectStatement(SubjectStatement subjectStatement);
}
