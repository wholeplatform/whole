package org.whole.lang.tests.model;

/** 
 * @generator Whole
 */
public interface TestSuite extends ITestsEntity {
	public PackageName getPackageName();

	public void setPackageName(PackageName packageName);

	public Description getDescription();

	public void setDescription(Description description);

	public Name getName();

	public void setName(Name name);

	public Statement getDeployer();

	public void setDeployer(Statement deployer);

	public FilterFamilies getFilterFamilies();

	public void setFilterFamilies(FilterFamilies filterFamilies);

	public TestCases getTestCases();

	public void setTestCases(TestCases testCases);
}
