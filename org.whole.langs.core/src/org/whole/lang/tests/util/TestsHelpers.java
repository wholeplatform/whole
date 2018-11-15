package org.whole.lang.tests.util;

import static org.whole.lang.commons.factories.CommonsEntityAdapterFactory.createResolver;
import static org.whole.lang.commons.factories.CommonsEntityAdapterFactory.createStageUpFragment;
import static org.whole.lang.commons.factories.CommonsEntityAdapterFactory.createVariable;
import static org.whole.lang.tests.reflect.TestsEntityDescriptorEnum.FilterRule;
import static org.whole.lang.tests.reflect.TestsEntityDescriptorEnum.Name;
import static org.whole.lang.tests.reflect.TestsEntityDescriptorEnum.Statement;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.bindings.IBindingScope;
import org.whole.lang.executables.ExecutableFactory;
import org.whole.lang.executables.IExecutable;
import org.whole.lang.factories.GenericEntityFactory;
import org.whole.lang.iterators.IEntityIterator;
import org.whole.lang.matchers.GenericMatcher;
import org.whole.lang.matchers.MatchException;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.InterpreterOperation;
import org.whole.lang.queries.factories.QueriesEntityFactory;
import org.whole.lang.queries.model.Sequence;
import org.whole.lang.queries.util.QueriesUtils;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reflect.EntityDescriptorEnum;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.templates.ITemplateManager;
import org.whole.lang.tests.factories.TestsEntityFactory;
import org.whole.lang.tests.model.FilterFamily;
import org.whole.lang.tests.model.FilterRule;
import org.whole.lang.tests.model.PackageName;
import org.whole.lang.tests.model.TestSuite;
import org.whole.lang.util.DataTypeUtils;
import org.whole.lang.util.EntityUtils;
import org.whole.lang.util.StringUtils;

/**
 * @author Enrico Persiani
 */
public class TestsHelpers {
	public static void replace(IEntity entity, IEntity replacement) {
		assert EntityUtils.hasParent(entity);

		IEntity parent = entity.wGetParent();
		EntityDescriptor<?> ed = parent.wGetEntityDescriptor(entity);
		replacement = createStageUpFragment(ed, replacement);
		parent.wSet(entity, replacement);
	}
	public static FilterRule createFilterRule(Collection<IEntity> entities) {
		// create the filter logic
		QueriesEntityFactory qef = QueriesEntityFactory.instance;
		Sequence sequence = qef.createSequence(0);
		Iterator<IEntity> iterator = entities.iterator();
		IEntity baseEntity = iterator.next();
		while (iterator.hasNext())
			updateFilterBody(baseEntity, iterator.next(), sequence);

		if (sequence.wIsEmpty())
			return createResolver(FilterRule);

		// create the filter rule
		TestsEntityFactory tef = TestsEntityFactory.instance;
		FilterRule filterRule = tef.createFilterRule(
				tef.createDescription("Auto-generated filter rule"),
				createVariable(Name, "filterName"),
				sequence.wGetAdapter(Statement)
				//WAS createSameStageFragment(Statement, sequence)
		);
		return filterRule;
	}

	public static IEntity updateFilterBody(IEntity pattern, IEntity model, Sequence sequence) {
		IBindingManager bindings = BindingManagerFactory.instance.createBindingManager();
		boolean match = false;
		while (!match) {
			try {
				bindings.wEnterScope();

				// try to match
				new GenericMatcher().withBindings(bindings).match(
						applyFilter(sequence, EntityUtils.clone(pattern), bindings),
						applyFilter(sequence, EntityUtils.clone(model), bindings));

				// eventually matches
				match = true;

			} catch (MatchException e) {
				// update normalization
				sequence.wAdd(QueriesEntityFactory.instance.createDelete(QueriesUtils.createRootPath(e.pattern)));
			} finally {
				// clear scope
				bindings.wExitScope();
			}
		}
		return sequence;
	}
	public static IEntity applyFilter(IEntity filter, IEntity subject, IBindingManager bm) {
		bm.wDef(IBindingManager.SELF, subject);
		IBindingScope bs = InterpreterOperation.lazyInterpretOnSelfBinding(EntityUtils.isFragment(filter) ? filter.wGetRoot() : filter, bm, false);

		if (bs.isExecutableResult()) {
			IEntityIterator<?> iterator = bs.getExecutableResult().iterator();
			bs.setExecutableResult(null);
			iterator.reset(subject);
			while (iterator.hasNext())
				iterator.next();
			return subject;
		} else {
			IEntity result = bs.getResult();
			return result != null ? result : subject;
		}
	}

	public static Map<String, FilterRule> createFilterRulesMap(TestSuite testSuite) {
		Map<String, FilterRule> filterRulesMap = new HashMap<String, FilterRule>();
		IExecutable<FilterFamily> filterFamilies = ExecutableFactory.instance.createChild();
		filterFamilies.reset(testSuite.getFilterFamilies());
		for (FilterFamily filterFamily : filterFamilies) {
			IExecutable<FilterRule> filterRules = ExecutableFactory.instance.createChild();
			filterRules.reset(filterFamily.getFilterRules());
			for (FilterRule filterRule : filterRules) {
				String name = filterFamily.getName().getValue()+'.'+filterRule.getName().getValue();
				if (filterRulesMap.get(name) != null)
					filterRulesMap.remove(name);
				else
					filterRulesMap.put(name, filterRule);
				PackageName packageName = filterFamily.getPackageName();
				if (DataTypeUtils.getDataKind(packageName).isString()) {
					String qualifiedName = packageName.wStringValue()+'.'+name;
					filterRulesMap.put(qualifiedName, filterRule);
				}
			}
		}
		return filterRulesMap;
	}
	public static Map<String, FilterRule> createFilterRulesMap(ITemplateManager templateManager) {
		Map<String, FilterRule> filterRulesMap = new HashMap<String, FilterRule>();
		TestsEntityFactory ef = TestsEntityFactory.instance;
		Class<? extends ITemplateManager> templateManagerClass = templateManager.getClass();

		for (String name : templateManager.names()) {
			FilterRule filterRule = ef.createFilterRule();
			filterRule.setName(ef.createName(name));
			filterRule.setBody(templateManager.create(name).wGetAdapter(Statement));

			filterRulesMap.put(templateManagerClass.getSimpleName() + "." + name, filterRule);
			filterRulesMap.put(templateManagerClass.getName() + "." + name, filterRule);
		}
		return filterRulesMap;
	}

	public static IEntity splitDescription(String description) {
		IEntity tuple = BindingManagerFactory.instance.createTuple();
		EntityDescriptorEnum edEnum = ReflectionFactory.getLanguageKit("http://lang.whole.org/Java", true, null).getEntityDescriptorEnum();
		for (String line : StringUtils.EOL_PATTERN.split(description))
			tuple.wAdd(GenericEntityFactory.instance.create(edEnum.valueOf("TextElement"), line));
		return tuple;
	}
}
