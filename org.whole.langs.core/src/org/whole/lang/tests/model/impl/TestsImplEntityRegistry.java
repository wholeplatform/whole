package org.whole.lang.tests.model.impl;

import org.whole.lang.factories.AbstractEntityRegistry;
import org.whole.lang.tests.reflect.TestsEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class TestsImplEntityRegistry extends AbstractEntityRegistry {
	public TestsImplEntityRegistry() {
		super(TestsEntityDescriptorEnum.instance);
	}

	protected void createPrototypes() {
		put(new TestSuiteImpl());
		put(new FilterFamiliesImpl());
		put(new FilterFamilyImpl());
		put(new FilterRulesImpl());
		put(new FilterRuleImpl());
		put(new TestCasesImpl());
		put(new TestCaseImpl());
		put(new AspectsImpl());
		put(new BeforeTestCaseImpl());
		put(new AfterTestCaseImpl());
		put(new BeforeTestImpl());
		put(new AfterTestImpl());
		put(new TestsImpl());
		put(new TestImpl());
		put(new TestStatementsImpl());
		put(new CommentImpl());
		put(new CommentKindImpl());
		put(new UsingFilterImpl());
		put(new AssertThatImpl());
		put(new AssumeThatImpl());
		put(new FilterImpl());
		put(new IsNullImpl());
		put(new IsTrueImpl());
		put(new IsFalseImpl());
		put(new IsDefImpl());
		put(new IsUndefImpl());
		put(new HasKindImpl());
		put(new KindImpl());
		put(new IsAssignableToImpl());
		put(new HasTypeImpl());
		put(new ThrowsImpl());
		put(new ThrowableTypeImpl());
		put(new SameImpl());
		put(new EqualsImpl());
		put(new MatchesImpl());
		put(new NotImpl());
		put(new AllOfImpl());
		put(new AnyOfImpl());
		put(new BooleanLiteralImpl());
		put(new IntLiteralImpl());
		put(new StringLiteralImpl());
		put(new DataNameImpl());
		put(new SequenceImpl());
		put(new NameImpl());
		put(new PackageNameImpl());
		put(new DescriptionImpl());
	}
}
