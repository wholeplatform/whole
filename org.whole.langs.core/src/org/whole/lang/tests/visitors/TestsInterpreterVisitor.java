package org.whole.lang.tests.visitors;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.ResettableScope;
import org.whole.lang.iterators.AbstractPatternFilterIterator;
import org.whole.lang.iterators.IEntityIterator;
import org.whole.lang.iterators.IteratorFactory;
import org.whole.lang.matchers.GenericMatcherFactory;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.IEntity;
import org.whole.lang.model.NullEntity;
import org.whole.lang.operations.InterpreterOperation;
import org.whole.lang.operations.OperationCanceledException;
import org.whole.lang.queries.factories.QueriesEntityFactory;
import org.whole.lang.queries.model.Path;
import org.whole.lang.reflect.EntityKinds;
import org.whole.lang.tests.matchers.TestsMatcherFactory;
import org.whole.lang.tests.model.AfterTest;
import org.whole.lang.tests.model.AfterTestCase;
import org.whole.lang.tests.model.AllOf;
import org.whole.lang.tests.model.AnyOf;
import org.whole.lang.tests.model.AssertThat;
import org.whole.lang.tests.model.AssumeThat;
import org.whole.lang.tests.model.BeforeTest;
import org.whole.lang.tests.model.BeforeTestCase;
import org.whole.lang.tests.model.BooleanLiteral;
import org.whole.lang.tests.model.Comment;
import org.whole.lang.tests.model.Constraint;
import org.whole.lang.tests.model.DataName;
import org.whole.lang.tests.model.Equals;
import org.whole.lang.tests.model.Expression;
import org.whole.lang.tests.model.Filter;
import org.whole.lang.tests.model.FilterRule;
import org.whole.lang.tests.model.HasKind;
import org.whole.lang.tests.model.HasType;
import org.whole.lang.tests.model.IntLiteral;
import org.whole.lang.tests.model.IsAssignableTo;
import org.whole.lang.tests.model.IsDef;
import org.whole.lang.tests.model.IsFalse;
import org.whole.lang.tests.model.IsNull;
import org.whole.lang.tests.model.IsTrue;
import org.whole.lang.tests.model.IsUndef;
import org.whole.lang.tests.model.Matches;
import org.whole.lang.tests.model.Not;
import org.whole.lang.tests.model.Same;
import org.whole.lang.tests.model.Sequence;
import org.whole.lang.tests.model.StringLiteral;
import org.whole.lang.tests.model.SubjectStatement;
import org.whole.lang.tests.model.Test;
import org.whole.lang.tests.model.TestCase;
import org.whole.lang.tests.model.TestCases;
import org.whole.lang.tests.model.TestStatement;
import org.whole.lang.tests.model.TestStatements;
import org.whole.lang.tests.model.TestSuite;
import org.whole.lang.tests.model.Tests;
import org.whole.lang.tests.model.Throws;
import org.whole.lang.tests.model.UsingFilter;
import org.whole.lang.tests.reflect.TestsEntityDescriptorEnum;
import org.whole.lang.tests.util.TestsHelpers;
import org.whole.lang.util.BehaviorUtils;
import org.whole.lang.util.EntityUtils;
import org.whole.lang.visitors.GenericTraversalFactory;
import org.whole.lang.visitors.IVisitor;

/**
 * @author Enrico Persiani
 */
public class TestsInterpreterVisitor extends TestsTraverseAllVisitor {
	protected static final IEntity UNDEF_VALUE = BindingManagerFactory.instance.createValue((Object) null);

	@Override
	public InterpreterOperation getOperation() {
		return (InterpreterOperation) super.getOperation();
	}

	protected final PrintWriter printWriter() {
		return getOperation().getPrintWriter();
	}
	protected Object getResultValue() {
		return getResult().wGetValue();
	}
	protected void setResultValue(Object value) {
		setResult(BindingManagerFactory.instance.createSpecificValue(value));
	}
	protected void setResultVisitor(IVisitor visitor) {
		setResult(BindingManagerFactory.instance.createValue(visitor));
	}
	protected IVisitor getResultVisitor() {
		return (IVisitor) getResultValue();
	}
	protected void resetIterator(IEntityIterator<?> iterator) {
		IEntity selfEntity = getBindings().wGet("self");
		iterator.reset(selfEntity != null ? selfEntity : NullEntity.instance);
	}

	@SuppressWarnings("unchecked")
	protected FilterRule getFilterRule(UsingFilter usingFilter) {
		Filter filter = usingFilter.getFilter();
		Map<String, FilterRule> filterRulesMap = (Map<String, FilterRule>) getBindings().wGetValue("filterRulesMap");
		return filterRulesMap.get(filter.getName().getValue());
	}

	protected IEntity applyFilterRule(IEntity entity) {
		FilterRule filterRule = (FilterRule) getBindings().wGet("activeFilterRule");
		if (filterRule == null)
			return entity;

		IEntity filteredEntity = EntityUtils.clone(entity);
		getBindings().wDef("self", filteredEntity);
		
		stagedVisit(filterRule.getBody());
		return filteredEntity;
	}

	@Override
	public void visit(TestSuite entity) {
		boolean testSuiteSuccess = true;
		printWriter().printf("=== %s test suite ===\n\n", entity.getName().getValue());

		getBindings().wDef("lastVisitedStatement", UNDEF_VALUE);
		getBindings().wDefValue("filterRulesMap", TestsHelpers.createFilterRulesMap(entity));
		TestCases testCases = entity.getTestCases();

		for (int i = 0; i < testCases.wSize(); i++) {
			TestCase testCase = testCases.get(i);
			if (getBindings().wIsSet("runSingleTest") && getBindings().wGet("runSingleTest").wGetParent().wGetParent() != testCase)
				continue;
			testCase.accept(this);
			testSuiteSuccess &= getResult().wBooleanValue();
		}

		setResult(BindingManagerFactory.instance.createValue(testSuiteSuccess));
	}

	@Override
	public void visit(TestCase entity) {
		String name = entity.getName().getValue();
		boolean testCaseSuccess = true;
		printWriter().printf("* %s test case running:\n\n", name);
		try {
			// execute all BeforeTestCase
			AbstractPatternFilterIterator<BeforeTestCase> i1 = IteratorFactory.<BeforeTestCase>childMatcherIterator()
					.withPattern(TestsEntityDescriptorEnum.BeforeTestCase);
			i1.reset(entity.getAspects());
			for (BeforeTestCase beforeTestCase : i1)
				beforeTestCase.accept(this);

			// execute all tests
			Tests tests = entity.getTests();
			for (int i = 0; i < tests.wSize(); i++) {
				Test test = tests.get(i);
				if (getBindings().wIsSet("runSingleTest") && getBindings().wGet("runSingleTest") != test)
					continue;
				test.accept(this);
				testCaseSuccess &= getResult().wBooleanValue();
			}

			// execute all AfterTestCase
			AbstractPatternFilterIterator<AfterTestCase> i2 = IteratorFactory.<AfterTestCase>childMatcherIterator()
					.withPattern(TestsEntityDescriptorEnum.AfterTestCase);
			i2.reset(entity.getAspects());
			for (AfterTestCase afterTestCase : i2)
				afterTestCase.accept(this);

			printWriter().printf("\n* %s test case %s\n", name, testCaseSuccess ? "OK" : "FAILED");
		} catch (OperationCanceledException e) {
			throw e;
		} catch (Exception e) {
			testCaseSuccess = false;
			printWriter().printf("\n* %s test case ERRORS: %s\n", name, formatMessage(e));
			IEntity statement = getBindings().wGet("lastVisitedStatement");
			if (statement != UNDEF_VALUE)
				printWriter().printf(" [at %s]", EntityUtils.getLocation(statement));
		}
		setResult(BindingManagerFactory.instance.createValue(testCaseSuccess));
	}

	@Override
	public void visit(Test entity) {
		ResettableScope bindingsRS;

		Set<String> bindingsNames = new HashSet<String>(getBindings().wNames());

		getBindings().wEnterScope(bindingsRS = BindingManagerFactory.instance.createResettableScope());

		String name = entity.getName().getValue();
		boolean testSuccess = false;
		try {
			// execute all BeforeTest
			for (BeforeTest beforeTest : BehaviorUtils.<BeforeTest>compileAndLazyEvaluate(createAspectPath("BeforeTest"), entity))
				beforeTest.accept(this);

			entity.getBody().accept(this);

			// execute all AfterTest
			for (AfterTest afterTest : BehaviorUtils.<AfterTest>compileAndLazyEvaluate(createAspectPath("AfterTest"), entity))
				afterTest.accept(this);

			printWriter().printf("    %32s(...) OK\n", name);
			testSuccess = true;
		} catch (AssumptionError e) {
			printWriter().printf("    %32s(...) SKIPPED: AssumptionError: %s", name, e.getMessage());
			printWriter().printf(" [at %s]\n", EntityUtils.getLocation(e.getAssumption()));
		} catch (AssertionError e) {
			printWriter().printf("    %32s(...) FAILED:  AssertionError: %s", name, e.getMessage());
			printWriter().printf(" [at %s]\n", EntityUtils.getLocation(e.getAssertion()));
		} catch (OperationCanceledException e) {
			throw e;
		} catch (Exception e) {
			printWriter().printf("    %32s(...) ERRORS: %s", name, formatMessage(e));
			IEntity statement = getBindings().wGet("lastVisitedStatement");
			if (statement != UNDEF_VALUE)
				printWriter().printf(" [at %s]\n\n", EntityUtils.getLocation(statement));
		}

		bindingsRS.reset();
		getBindings().wExitScope();

		//FIXME workaround for fresh variables not being reset by ResettableScope
		Set<String> toUnset = new HashSet<String>(getBindings().wNames());
		toUnset.removeAll(bindingsNames);
		for (String unsetName : toUnset)
			getBindings().wUnset(unsetName);

		setResult(BindingManagerFactory.instance.createValue(testSuccess));
	}

	protected String formatMessage(Exception e) {
		StringWriter sw = new StringWriter();
		e.printStackTrace(new PrintWriter(sw));
		return sw.toString();
	}

	@Override
	public void visit(TestStatements entity) {
		for (int i = 0; i < entity.wSize(); i++) {
			handleCancelRequest();

			TestStatement statement = entity.get(i);
			getBindings().wDef("lastVisitedStatement", statement);
			statement.accept(this);
		}
	}

	protected static Path createAspectPath(String aspectTypeName) {
		QueriesEntityFactory qef = QueriesEntityFactory.instance;
		return qef.createPath(
				qef.createFilter(qef.createAncestorStep(), qef.createTypeTest("TestCase")),
				qef.createFeatureStep("aspects"),
				qef.createFilter(qef.createChildStep(), qef.createTypeTest(aspectTypeName))
		);
	}

	@Override
	public void visit(AssumeThat entity) {
		evaluate(entity);
	}

	@Override
	public void visit(AssertThat entity) {
		evaluate(entity);
	}

	@Override
	public void visit(UsingFilter entity) {
		getBindings().wDef("activeFilterRule", getFilterRule(entity));
		super.visit(entity);
		getBindings().wUnset("activeFilterRule");
	}

	protected IEntity evaluate(Expression subject, boolean catchExceptions) {
		IEntity entity = NullEntity.instance;
		try {
			subject.accept(this);
			entity = getResult();
		} catch (RuntimeException e) {
			if (catchExceptions)
				// save exception for later evaluation
				getBindings().wDefValue("thrownException", e);
			else
				throw e;
		}
		return entity == null ? NullEntity.instance : entity;
	}
	protected IVisitor evaluate(Constraint constraint) {
		constraint.accept(this);
		return getResultVisitor();
		
	}
	protected void evaluate(SubjectStatement entity) {
		IEntity subject = evaluate(entity.getSubject(), true);
		if (!EntityUtils.isNull(subject))
			subject = applyFilterRule(subject);

		IVisitor visitor = evaluate(entity.getConstraint());
		boolean result = Matcher.match(visitor, subject);

		// exception already evaluated
		getBindings().wUnset("thrownException");

		if (!result) {
			if (Matcher.match(TestsEntityDescriptorEnum.AssertThat, entity))
				throw new AssertionError((AssertThat) entity, subject, visitor);
			else
				throw new AssumptionError((AssumeThat) entity, subject, visitor);
		}
	}

	@Override
	public void visit(AllOf entity) {
		int size = entity.wSize();
		IVisitor[] visitors = new IVisitor[size];
		for (int i = 0; i < size; i++) {
			entity.get(i).accept(this);
			visitors[i] = getResultVisitor();
		}
		setResultVisitor(GenericTraversalFactory.instance.all(visitors));
	}
	@Override
	public void visit(AnyOf entity) {
		int size = entity.wSize();
		IVisitor[] visitors = new IVisitor[size];
		for (int i = 0; i < size; i++) {
			entity.get(i).accept(this);
			visitors[i] = getResultVisitor();
		}
		setResultVisitor(GenericTraversalFactory.instance.one(visitors));
	}
	@Override
	public void visit(Not entity) {
		entity.getConstraint().accept(this);
		setResultVisitor(GenericTraversalFactory.instance.not(getResultVisitor()));
	}

	@Override
	public void visit(Equals entity) {
		setResultVisitor(TestsMatcherFactory.instance.equals(applyFilterRule(evaluate(entity.getObject(), false))));
	}
	@Override
	public void visit(Matches entity) {
		setResultVisitor(GenericMatcherFactory.instance.match(applyFilterRule(evaluate(entity.getObject(), false))));
	}

	@Override
	public void visit(Same entity) {
		entity.getObject().accept(this);
		setResultVisitor(TestsMatcherFactory.instance.same(evaluate(entity.getObject(), false)));
	}
	@Override
	public void visit(HasKind entity) {
		EntityKinds kind = EntityKinds.valueOf(entity.getKind().getValue().getName());
		setResultVisitor(GenericMatcherFactory.instance.hasKindMatcher(kind));
	}
	@Override
	public void visit(HasType entity) {
		setResultVisitor(GenericMatcherFactory.instance.hasTypeMatcher(entity.getDescriptorName().getValue()));
	}
	@Override
	public void visit(IsAssignableTo entity) {
		String edName = entity.getDescriptorName().getValue();
		setResultVisitor(GenericMatcherFactory.instance.isPlatformSubtypeOfMatcher(edName));
	}
	@Override
	public void visit(IsDef entity) {
		IVisitor v = TestsMatcherFactory.instance.defined();
		v.setBindings(getBindings());
		setResultVisitor(v);
	}
	@Override
	public void visit(IsUndef entity) {
		IVisitor v = TestsMatcherFactory.instance.defined();
		v.setBindings(getBindings());
		setResultVisitor(GenericTraversalFactory.instance.not(v));
	}
	@Override
	public void visit(IsFalse entity) {
		setResultVisitor(TestsMatcherFactory.instance.equalsValue(false));
	}
	@Override
	public void visit(IsTrue entity) {
		setResultVisitor(TestsMatcherFactory.instance.equalsValue(true));
	}
	@Override
	public void visit(Throws entity) {
		String className = entity.getThrowableType().getValue();
		IVisitor v = TestsMatcherFactory.instance.hasThrown(className);
		v.setBindings(getBindings());
		setResultVisitor(v);
	}
	@Override
	public void visit(IsNull entity) {
		setResultVisitor(TestsMatcherFactory.instance.isNull());
	}
	@Override
	public void visit(Comment entity) {
	}
	@Override
	public void visit(BooleanLiteral entity) {
		setResult(entity);
	}
	@Override
	public void visit(IntLiteral entity) {
		setResult(entity);
	}
	@Override
	public void visit(StringLiteral entity) {
		setResult(entity);
	}
	@Override
	public void visit(Sequence entity) {
		setResult(entity);
	}
	@Override
	public void visit(DataName entity) {
		String name = entity.getValue();
		IEntity result = getBindings().wGet(name);
		if (result == null)
			throw BindingManagerFactory.instance.createNoBindingException(name);
		else
			setResult(result);
	}

	protected class AssertionError extends java.lang.AssertionError {
		private static final long serialVersionUID = 1L;
		private final AssertThat assertion;

		public AssertionError(AssertThat assertion, IEntity subject, IVisitor constraint) {
			super(TestsHelpers.formatMessage(getBindings(), subject, constraint));
			this.assertion = assertion;
		}
		
		public AssertThat getAssertion() {
			return assertion;
		}
	}

	protected class AssumptionError extends java.lang.AssertionError {
		private static final long serialVersionUID = 1L;
		private final AssumeThat assumption;
		
		public AssumptionError(AssumeThat assumption, IEntity subject, IVisitor constraint) {
			super(TestsHelpers.formatMessage(getBindings(), subject, constraint));
			this.assumption = assumption;
		}
		
		public AssumeThat getAssumption() {
			return assumption;
		}
	}
}
