package org.whole.lang.tests.model;

/** 
 * @generator Whole
 */
public interface TestCase extends ITestsEntity {
	public PackageName getPackageName();

	public void setPackageName(PackageName packageName);

	public Description getDescription();

	public void setDescription(Description description);

	public Name getName();

	public void setName(Name name);

	public Statement getDeployer();

	public void setDeployer(Statement deployer);

	public Aspects getAspects();

	public void setAspects(Aspects aspects);

	public Tests getTests();

	public void setTests(Tests tests);
}
