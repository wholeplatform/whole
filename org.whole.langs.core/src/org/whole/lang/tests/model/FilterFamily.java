package org.whole.lang.tests.model;

/** 
 * @generator Whole
 */
public interface FilterFamily extends ITestsEntity {
	public PackageName getPackageName();

	public void setPackageName(PackageName packageName);

	public Description getDescription();

	public void setDescription(Description description);

	public Name getName();

	public void setName(Name name);

	public FilterRules getFilterRules();

	public void setFilterRules(FilterRules filterRules);
}
