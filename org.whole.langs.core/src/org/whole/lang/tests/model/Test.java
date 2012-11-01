package org.whole.lang.tests.model;

/** 
 * @generator Whole
 */
public interface Test extends ITestsEntity, AbstractBehavior {
	public TestStatements getBody();

	public void setBody(TestStatements body);
}
