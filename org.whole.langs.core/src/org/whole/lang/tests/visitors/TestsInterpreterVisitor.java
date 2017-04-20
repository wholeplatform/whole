package org.whole.lang.tests.visitors;

import static org.whole.lang.tests.reflect.TestsEntityDescriptorEnum.*;
import static org.whole.lang.tests.reflect.TestsFeatureDescriptorEnum.*;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Map;

import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.ITransactionScope;
import org.whole.lang.commons.factories.CommonsEntityAdapterFactory;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.exceptions.WholeIllegalArgumentException;
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
import org.whole.lang.tests.factories.TestsEntityFactory;
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
import org.whole.lang.tests.model.Outcome;
import org.whole.lang.tests.model.OutcomeEnum;
import org.whole.lang.tests.model.Result;
import org.whole.lang.tests.model.Results;
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
import org.whole.lang.tests.util.TestsHelpers;
import org.whole.lang.util.BehaviorUtils;
import org.whole.lang.util.EntityUtils;
import org.whole.lang.visitors.GenericTraversalFactory;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.visitors.MissingVariableException;

/**
 * @author Enrico Persiani
 */
public class TestsInterpreterVisitor extends TestsTraverseAllVisitor {
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
		Results results = TestsEntityFactory.instance.createResults();
		printWriter().printf("=== %s test suite ===\n\n", entity.getName().getValue());

		getBindings().wDefValue("filterRulesMap", TestsHelpers.createFilterRulesMap(entity));
		TestCases testCases = entity.getTestCases();

		for (int i = 0; i < testCases.wSize(); i++) {
			TestCase testCase = testCases.get(i);
			if (getBindings().wIsSet("runSingleTest") && getBindings().wGet("runSingleTest").wGetParent().wGetParent() != testCase)
				continue;
			testCase.accept(this);

			Results testCaseResults = (Results) getResult();
			results.getErrors().setValue(results.getErrors().getValue() + testCaseResults.getErrors().getValue());
			results.getFailures().setValue(results.getFailures().getValue() + testCaseResults.getFailures().getValue());
			results.getSuccesses().setValue(results.getSuccesses().getValue() + testCaseResults.getSuccesses().getValue());
		}
		entity.setActualResults(results);
		setResult(results);
	}

	@Override
	public void visit(TestCase entity) {
		String name = entity.getName().getValue();
		Results results = TestsEntityFactory.instance.createResults();
		printWriter().printf("* %s test case running:\n\n", name);
		try {
			IEntityIterator<BeforeTestCase> beforeIterator = IteratorFactory.<BeforeTestCase>childMatcherIterator().withPattern(BeforeTestCase);
			beforeIterator.reset(entity.getAspects());
			for (BeforeTestCase beforeTestCase : beforeIterator)
				beforeTestCase.accept(this);

			Tests tests = entity.getTests();
			for (int i = 0; i < tests.wSize(); i++) {
				Test test = tests.get(i);
				if (getBindings().wIsSet("runSingleTest") && getBindings().wGet("runSingleTest") != test)
					continue;
				test.accept(this);

				IntLiteral result = null;
				switch (getResult().wGet(outcome).wEnumValue().getOrdinal()) {
				case OutcomeEnum.ERROR_ord:
					result = results.getErrors();
					break;
				case OutcomeEnum.FAILURE_ord:
					result = results.getErrors();
					break;
				case OutcomeEnum.SUCCESS_ord:
					result = results.getSuccesses();
					break;
				default:
					throw new WholeIllegalArgumentException("unsupported outcome");
				}
				result.setValue(result.getValue() + 1);
			}

			IEntityIterator<AfterTestCase> afterIterator = IteratorFactory.<AfterTestCase>childMatcherIterator().withPattern(AfterTestCase);
			afterIterator.reset(entity.getAspects());
			for (AfterTestCase afterTestCase : afterIterator)
				afterTestCase.accept(this);

			boolean testCaseSuccess = results.getErrors().getValue() + results.getFailures().getValue() == 0;
			printWriter().printf("\n* %s test case %s\n", name, testCaseSuccess ? "OK" : "FAILED");
		} catch (OperationCanceledException e) {
			throw e;
		} catch (RuntimeException e) {
			reportError(name, e);
			results.getErrors().setValue(entity.getTests().wSize());
			results.getFailures().setValue(0);
			results.getSuccesses().setValue(0);
		}
		entity.setActualResults(results);
		setResult(results);
	}

	@Override
	public void visit(Test entity) {
		ITransactionScope ts = BindingManagerFactory.instance.createTransactionScope();
		getBindings().wEnterScope(ts);

		String name = entity.getName().getValue();
		Outcome outcome = TestsEntityFactory.instance.createOutcome(OutcomeEnum.SUCCESS);
		StringLiteral location = CommonsEntityAdapterFactory.createResolver(StringLiteral);
		StringLiteral cause = CommonsEntityAdapterFactory.createResolver(StringLiteral);
		Result result = TestsEntityFactory.instance.createResult(outcome, location, cause);
		try {
			for (BeforeTest beforeTest : BehaviorUtils.<BeforeTest>compileAndLazyEvaluate(createAspectPath("BeforeTest"), entity))
				beforeTest.accept(this);

			entity.getBody().accept(this);

			for (AfterTest afterTest : BehaviorUtils.<AfterTest>compileAndLazyEvaluate(createAspectPath("AfterTest"), entity))
				afterTest.accept(this);

			printWriter().printf("    %32s(...) OK\n", name);
		} catch (OperationCanceledException e) {
			throw e;
		} catch (TestsException e) {
			outcome.wSetValue(OutcomeEnum.FAILURE);
			location.setValue(EntityUtils.getLocation(entity));
			cause.setValue(e.getMessage());
			reportFailure(name, e);
		} catch (RuntimeException e) {
			outcome.wSetValue(OutcomeEnum.ERROR);
			location.setValue(EntityUtils.getLocation(entity));
			cause.setValue(e.getMessage());
			reportError(name, e);
		} finally {
			ts.rollback();
			getBindings().wExitScope();
		}

		entity.setActualResult(result);
		setResult(result);
	}

	protected void reportFailure(String name, TestsException e) {
		String error = Matcher.matchImpl(AssertThat, e.getSubjectStatement()) ? "AssertionError" : "AssupmtionError";
		printWriter().printf("    %32s(...) FAILED:  %s: %s", name, error, e.getMessage());
		printWriter().printf(" [at %s]\n", EntityUtils.getLocation(e.getSubjectStatement()));
	}
	protected void reportError(String name, RuntimeException e) {
		StringWriter writer = new StringWriter();
		e.printStackTrace(new PrintWriter(writer));
		printWriter().printf("    %32s(...) ERRORS: %s", name, writer.toString());
		IWholeRuntimeException wre = (IWholeRuntimeException) e;
		if (wre.getSourceEntity() != null)
			printWriter().printf(" [at %s]\n\n", EntityUtils.getLocation(wre.getSourceEntity()));
	}

	@Override
	public void visit(TestStatements entity) {
		for (int i = 0; i < entity.wSize(); i++) {
			handleCancelRequest();

			TestStatement statement = entity.get(i);
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
		IEntity entity = NullEntity.instance; //null;
		try {
			subject.accept(this);
			entity = getResult();
		} catch (OperationCanceledException e) {
			throw e;
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
		ITransactionScope ts = BindingManagerFactory.instance.createTransactionScope();
		getBindings().wEnterScope(ts);

		try {
			IEntity subject = evaluate(entity.getSubject(), true);
			if (!EntityUtils.isNull(subject))
				subject = applyFilterRule(subject);
	
			IVisitor constraint = evaluate(entity.getConstraint());
			boolean result = Matcher.match(constraint, subject);
	
			if (getBindings().wIsSet("thrownException"))
				throw (RuntimeException) getBindings().wGetValue("thrownException");

			if (!result)
				throw new TestsException(entity, subject, constraint, getBindings());
		} finally {
			ts.rollback();
			getBindings().wExitScope();
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
		setResultVisitor(GenericTraversalFactory.instance.all(visitors).withSourceEntity(entity));
	}
	@Override
	public void visit(AnyOf entity) {
		int size = entity.wSize();
		IVisitor[] visitors = new IVisitor[size];
		for (int i = 0; i < size; i++) {
			entity.get(i).accept(this);
			visitors[i] = getResultVisitor();
		}
		setResultVisitor(GenericTraversalFactory.instance.one(visitors).withSourceEntity(entity));
	}
	@Override
	public void visit(Not entity) {
		entity.getConstraint().accept(this);
		setResultVisitor(GenericTraversalFactory.instance.not(getResultVisitor()).withSourceEntity(entity));
	}

	@Override
	public void visit(Equals entity) {
		setResultVisitor(TestsMatcherFactory.instance.equals(applyFilterRule(evaluate(entity.getObject(), false))).withSourceEntity(entity));
	}
	@Override
	public void visit(Matches entity) {
		setResultVisitor(GenericMatcherFactory.instance.match(applyFilterRule(evaluate(entity.getObject(), false))).withSourceEntity(entity));
	}

	@Override
	public void visit(Same entity) {
		entity.getObject().accept(this);
		setResultVisitor(TestsMatcherFactory.instance.same(evaluate(entity.getObject(), false)).withSourceEntity(entity));
	}
	@Override
	public void visit(HasKind entity) {
		EntityKinds kind = EntityKinds.valueOf(entity.getKind().getValue().getName());
		setResultVisitor(GenericMatcherFactory.instance.hasKindMatcher(kind).withSourceEntity(entity));
	}
	@Override
	public void visit(HasType entity) {
		setResultVisitor(GenericMatcherFactory.instance.hasTypeMatcher(entity.getDescriptorName().getValue()).withSourceEntity(entity));
	}
	@Override
	public void visit(IsAssignableTo entity) {
		String edName = entity.getDescriptorName().getValue();
		setResultVisitor(GenericMatcherFactory.instance.isPlatformSubtypeOfMatcher(edName).withSourceEntity(entity));
	}
	@Override
	public void visit(IsDef entity) {
		IVisitor v = TestsMatcherFactory.instance.defined();
		v.withSourceEntity(entity).setBindings(getBindings());
		setResultVisitor(v);
	}
	@Override
	public void visit(IsUndef entity) {
		IVisitor v = GenericTraversalFactory.instance.not(TestsMatcherFactory.instance.defined());
		v.withSourceEntity(entity).setBindings(getBindings());
		setResultVisitor(v);
	}
	@Override
	public void visit(IsFalse entity) {
		setResultVisitor(TestsMatcherFactory.instance.equalsValue(false).withSourceEntity(entity));
	}
	@Override
	public void visit(IsTrue entity) {
		setResultVisitor(TestsMatcherFactory.instance.equalsValue(true).withSourceEntity(entity));
	}
	@Override
	public void visit(Throws entity) {
		String className = entity.getThrowableType().getValue();
		IVisitor v = TestsMatcherFactory.instance.hasThrown(className);
		v.withSourceEntity(entity).setBindings(getBindings());
		setResultVisitor(v);
	}
	@Override
	public void visit(IsNull entity) {
		setResultVisitor(TestsMatcherFactory.instance.isNull().withSourceEntity(entity));
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
			throw new MissingVariableException(name).withSourceEntity(entity).withBindings(getBindings());
		else
			setResult(result);
	}
}
