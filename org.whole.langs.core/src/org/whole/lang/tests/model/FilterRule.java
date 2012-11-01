package org.whole.lang.tests.model;

/** 
 * @generator Whole
 */
public interface FilterRule extends ITestsEntity {
	public Description getDescription();

	public void setDescription(Description description);

	public Name getName();

	public void setName(Name name);

	public Statement getBody();

	public void setBody(Statement body);
}
