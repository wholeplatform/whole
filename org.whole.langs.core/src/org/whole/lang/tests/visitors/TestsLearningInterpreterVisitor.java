package org.whole.lang.tests.visitors;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.ITransactionScope;
import org.whole.lang.commons.factories.CommonsEntityAdapterFactory;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.IEntity;
import org.whole.lang.queries.factories.QueriesEntityFactory;
import org.whole.lang.queries.model.PathExpression;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reflect.EntityKinds;
import org.whole.lang.tests.factories.TestsEntityFactory;
import org.whole.lang.tests.model.Equals;
import org.whole.lang.tests.model.Expression;
import org.whole.lang.tests.model.FilterFamilies;
import org.whole.lang.tests.model.FilterFamily;
import org.whole.lang.tests.model.FilterRule;
import org.whole.lang.tests.model.FilterRules;
import org.whole.lang.tests.model.HasKind;
import org.whole.lang.tests.model.HasType;
import org.whole.lang.tests.model.IsAssignableTo;
import org.whole.lang.tests.model.Kind;
import org.whole.lang.tests.model.KindEnum;
import org.whole.lang.tests.model.KindEnum.Value;
import org.whole.lang.tests.model.Matches;
import org.whole.lang.tests.model.Name;
import org.whole.lang.tests.model.SubjectStatement;
import org.whole.lang.tests.model.TestSuite;
import org.whole.lang.tests.model.ThrowableType;
import org.whole.lang.tests.model.Throws;
import org.whole.lang.tests.model.UsingFilter;
import org.whole.lang.tests.reflect.TestsEntityDescriptorEnum;
import org.whole.lang.tests.util.TestsHelpers;
import org.whole.lang.util.BehaviorUtils;
import org.whole.lang.util.EntityUtils;
import org.whole.lang.util.FreshNameGenerator;
import org.whole.lang.visitors.GenericTraversalFactory;

/**
 * @author Enrico Persiani
 */
public class TestsLearningInterpreterVisitor extends TestsInterpreterVisitor {
	private static final String GENERATED_FAMILY_NAME = "GeneratedFilters";
	private static final String GENERATED_FILTER_NAME = "generatedFilter";

	protected final boolean isLearning() {
		return getBindings().wIsSet("learnMode") &&  getBindings().wBooleanValue("learnMode");
	}
	protected final int learnCycles() {
		return getBindings().wIsSet("learnCycles") ? getBindings().wIntValue("learnCycles") : 1;
	}
	@SuppressWarnings("unchecked")
	protected Map<IEntity, List<IEntity>> getLearntMap() {
		if (!getBindings().wIsSet("learntMap"))
			getBindings().wDefValue("learntMap", new HashMap<IEntity, List<IEntity>>());
		return (Map<IEntity, List<IEntity>>) getBindings().wGetValue("learntMap");
	}
	protected void putLearntEntity(IEntity adapter, IEntity learnt) {
		List<IEntity> list = getLearntMap().get(adapter);
		if (list == null)
			getLearntMap().put(adapter, list = new ArrayList<IEntity>());
		list.add(EntityUtils.clone(learnt));
	}

	protected FilterFamily getFilterFamily(TestSuite suite) {
		FilterFamilies filterFamilies = suite.getFilterFamilies();
		FilterFamily filterFamily = null;
		for (int i=0; i<filterFamilies.wSize(); i++) {
			FilterFamily child = (FilterFamily) filterFamilies.wGet(i);
			if (EntityUtils.isNotResolver(child) &&
					GENERATED_FAMILY_NAME.equals(child.getName().getValue())) {
				filterFamily = child;
				break;
			}
		}

		TestsEntityFactory tef = TestsEntityFactory.instance;
		if (filterFamily == null) {
			filterFamily = tef.createFilterFamily(
					CommonsEntityAdapterFactory.createResolver(
							TestsEntityDescriptorEnum.PackageName),
					tef.createDescription("Auto-generated filter family"),
					tef.createName(GENERATED_FAMILY_NAME), tef.createFilterRules(0));
		}
		return filterFamily;
	}
	protected UsingFilter createUsingFilter(String filterName) {
		TestsEntityFactory tef = TestsEntityFactory.instance;
		UsingFilter usingFilter = tef.createUsingFilter();
		usingFilter.setFilter(tef.createFilter(tef.createName(GENERATED_FAMILY_NAME+'.'+filterName)));
		return usingFilter;
	}

	@Override
	protected IEntity evaluate(Expression subject, boolean catchExceptions) {
		IEntity entity = super.evaluate(subject, catchExceptions);
		if (isLearning())
			getBindings().wDef("evaluatedSubject", entity);
		return entity;
	}

	@Override
	protected void evaluate(SubjectStatement subjectStatement) {
		try {
			super.evaluate(subjectStatement);
		} finally {
			if (isLearning())
				getBindings().wUnset("evaluatedSubject");
		}
	}

	@Override
	public void visit(TestSuite entity) {
		if (isLearning()) {
			Map<IEntity, List<IEntity>> learntMap = getLearntMap();
			
			IEntity result = null;
			for (int cycle = 1; cycle <= learnCycles(); cycle++) {
				printWriter().printf("*** Learning cycle %d ***\n\n", cycle);
				ITransactionScope resettableScope = BindingManagerFactory.instance.createTransactionScope();
				getBindings().wEnterScope(resettableScope);	
				try {
					getBindings().wDefValue("learnCycle", cycle);
					super.visit(entity);
					result = getBindings().getResult();
				} finally {
					resettableScope.rollback();
					getBindings().wExitScope();
				}
			}
			getBindings().setResult(result);

			FilterFamily filterFamily = getFilterFamily(entity);
			FilterRules filterRules = filterFamily.getFilterRules();
			FreshNameGenerator fnGen = new FreshNameGenerator();
			for (IEntity name : BehaviorUtils.compileAndLazyEvaluate(createFindAllFilterRuleNamesQuery(), filterFamily))
				fnGen.addBoundName(name.wStringValue());

			for (IEntity adapter : learntMap.keySet()) {
				List<IEntity> learntEntities = learntMap.get(adapter);

				IEntity value = learntEntities.get(0);
				if (learntEntities.size() > 1 && EntityUtils.isData(value)) {
					for (IEntity learntEntity : learntEntities)
						if (!learntEntity.wEquals(value))
							continue;
				} else if (learntEntities.size() > 1) {
					for (IEntity learntEntity2 : learntEntities)
						if (EntityUtils.isData(learntEntity2))
							continue;

					// generate filter rule
					FilterRule filterRule = TestsHelpers.createFilterRule(learntEntities);
					if (EntityUtils.isNotResolver(filterRule)) {
						String filterName;
						IEntity filterBody;
						if ((filterBody = Matcher.find(filterRule.getBody(), filterRules, false)) != null) {
							// try to reuse a generated filter
							filterName = ((FilterRule) filterBody.wGetParent()).getName().getValue();
						} else {
							// add the filter rule to the filter family
							filterName = fnGen.nextFreshName(GENERATED_FILTER_NAME);
							ITransactionScope resettableScope = BindingManagerFactory.instance.createTransactionScope();
							getBindings().wEnterScope(resettableScope);	
							try {
								getBindings().wDefValue("filterName", filterName);
								Matcher.substitute(filterRule, getBindings(), false);
								filterRules.wAdd(filterRule);
							} finally {
								resettableScope.rollback();
								getBindings().wExitScope();
							}

						}

						// wrap SubjectStatement with a UsingFilter
						ITransactionScope resettableScope = BindingManagerFactory.instance.createTransactionScope();
						getBindings().wEnterScope(resettableScope);	
						try {
							SubjectStatement statement = BehaviorUtils.evaluateFirstResult(createFindAncestorSubjectStatement(), adapter, getBindings());
							UsingFilter usingFilter = createUsingFilter(filterName);
							statement.wGetParent().wSet(statement, usingFilter);
							usingFilter.setSubjectStatement(statement);
						} finally {
							resettableScope.rollback();
							getBindings().wExitScope();
						}
					}
				}

				TestsHelpers.replace(adapter, value);
			}
			// add the newly generated family
			if (!EntityUtils.hasParent(filterFamily) && !filterRules.wIsEmpty())
				entity.getFilterFamilies().wAdd(filterFamily);
		} else
			super.visit(entity);
	}

	@Override
	public void visit(HasKind entity) {
		Kind kind = entity.getKind();
		if (isLearning() && EntityUtils.isResolver(kind)) {

			EntityKinds entityKind = getBindings().wGet("evaluatedSubject").wGetEntityKind();
			Value entityKindValue = KindEnum.instance.valueOf(entityKind.name());
			Kind learntKind = TestsEntityFactory.instance.createKind(entityKindValue);

			putLearntEntity(kind, learntKind);
			setResultVisitor(GenericTraversalFactory.instance.identity());
		} else
			super.visit(entity);
	}

	@Override
	public void visit(HasType entity) {
		Name edName = entity.getDescriptorName();
		if (isLearning() && EntityUtils.isResolver(edName)) {
			EntityDescriptor<?> ed = getBindings().wGet("evaluatedSubject").wGetEntityDescriptor();
			Name learntEdName = TestsEntityFactory.instance.createName(ed.getName());

			putLearntEntity(edName, learntEdName);
			setResultVisitor(GenericTraversalFactory.instance.identity());
		} else
			super.visit(entity);
	}

	@Override
	public void visit(IsAssignableTo entity) {
		Name edName = entity.getDescriptorName();
		if (isLearning() && EntityUtils.isResolver(edName)) {
			IEntity subject = getBindings().wGet("evaluatedSubject");
			EntityDescriptor<?> ed = EntityUtils.hasParent(subject) ?
					subject.wGetParent().wGetEntityDescriptor(subject) : subject.wGetEntityDescriptor();
			Name learntEdName = TestsEntityFactory.instance.createName(ed.getName());

			putLearntEntity(edName, learntEdName);
			setResultVisitor(GenericTraversalFactory.instance.identity());
		} else
			super.visit(entity);
	}
	
	@Override
	public void visit(Throws entity) {
		ThrowableType throwableType = entity.getThrowableType();
		if (isLearning() && EntityUtils.isResolver(throwableType) && getBindings().wIsSet("thrownException")) {
			Exception throwable = (Exception) getBindings().wGetValue("thrownException");
			ThrowableType learntThrowable = TestsEntityFactory.instance.createThrowableType(throwable.getClass().getName());
			putLearntEntity(throwableType, learntThrowable);
			
			setResultVisitor(GenericTraversalFactory.instance.identity());
		} else
			super.visit(entity);
	}

	@Override
	public void visit(Equals entity) {
		Expression object = entity.getObject();
		if (isLearning() && EntityUtils.isResolver(object)) {
			putLearntEntity(object, getBindings().wGet("evaluatedSubject"));

			setResultVisitor(GenericTraversalFactory.instance.identity());
		} else
			super.visit(entity);
	}

	@Override
	public void visit(Matches entity) {
		Expression object = entity.getObject();
		if (isLearning() && EntityUtils.isResolver(object)) {
			putLearntEntity(object, getBindings().wGet("evaluatedSubject"));

			setResultVisitor(GenericTraversalFactory.instance.identity());
		} else
			super.visit(entity);
	}

	private static PathExpression createFindAncestorSubjectStatement() {
		QueriesEntityFactory qef = QueriesEntityFactory.instance;
		return qef.createFilter(
				qef.createAncestorStep(),
				qef.createSubtypeTest("SubjectStatement"));
	}
	private static PathExpression createFindAllFilterRuleNamesQuery() {
		QueriesEntityFactory qef = QueriesEntityFactory.instance;
		return qef.createPath(
				qef.createFeatureStep("filterRules"),
				qef.createChildStep(),
				qef.createFeatureStep("name"));
	}
}
