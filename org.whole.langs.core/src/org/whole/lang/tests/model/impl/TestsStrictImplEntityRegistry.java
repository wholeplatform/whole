package org.whole.lang.tests.model.impl;

/** 
 * @generator Whole
 */
public class TestsStrictImplEntityRegistry extends TestsImplEntityRegistry {
	protected void createPrototypes() {
		super.createPrototypes();
		put(new FilterFamiliesStrictImpl());
		put(new FilterRulesStrictImpl());
		put(new TestCasesStrictImpl());
		put(new AspectsStrictImpl());
		put(new TestsStrictImpl());
		put(new SequenceStrictImpl());
	}
}
