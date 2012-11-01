package org.whole.lang.tests.model.adapters;

import org.whole.lang.factories.AbstractEntityRegistry;
import org.whole.lang.tests.reflect.TestsEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class TestsAdaptersEntityRegistry extends AbstractEntityRegistry {
	public TestsAdaptersEntityRegistry() {
		super(TestsEntityDescriptorEnum.instance);
	}

	protected void createPrototypes() {
		put(new TestSuiteAdapter());
		put(new FilterFamiliesAdapter());
		put(new FilterFamilyAdapter());
		put(new FilterRulesAdapter());
		put(new FilterRuleAdapter());
		put(new TestCasesAdapter());
		put(new TestCaseAdapter());
		put(new AbstractBehaviorAdapter());
		put(new AspectsAdapter());
		put(new AspectAdapter());
		put(new BeforeTestCaseAdapter());
		put(new AfterTestCaseAdapter());
		put(new BeforeTestAdapter());
		put(new AfterTestAdapter());
		put(new TestsAdapter());
		put(new TestAdapter());
		put(new TestStatementsAdapter());
		put(new TestStatementAdapter());
		put(new StatementAdapter());
		put(new CommentAdapter());
		put(new CommentKindAdapter());
		put(new UsingFilterAdapter());
		put(new SubjectStatementAdapter());
		put(new AssertThatAdapter());
		put(new AssumeThatAdapter());
		put(new FilterAdapter());
		put(new ConstraintAdapter());
		put(new IsNullAdapter());
		put(new IsTrueAdapter());
		put(new IsFalseAdapter());
		put(new IsDefAdapter());
		put(new IsUndefAdapter());
		put(new HasKindAdapter());
		put(new KindAdapter());
		put(new IsAssignableToAdapter());
		put(new HasTypeAdapter());
		put(new ThrowsAdapter());
		put(new ThrowableTypeAdapter());
		put(new ObjectConstraintAdapter());
		put(new SameAdapter());
		put(new EqualsAdapter());
		put(new MatchesAdapter());
		put(new DecoratorConstraintAdapter());
		put(new NotAdapter());
		put(new AllOfAdapter());
		put(new AnyOfAdapter());
		put(new ExpressionAdapter());
		put(new BooleanLiteralAdapter());
		put(new IntLiteralAdapter());
		put(new StringLiteralAdapter());
		put(new DataNameAdapter());
		put(new SequenceAdapter());
		put(new NameAdapter());
		put(new PackageNameAdapter());
		put(new DescriptionAdapter());
	}
}
