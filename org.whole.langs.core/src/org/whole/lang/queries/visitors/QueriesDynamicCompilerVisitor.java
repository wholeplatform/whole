/**
 * Copyright 2004-2016 Riccardo Solmi. All rights reserved.
 * This file is part of the Whole Platform.
 *
 * The Whole Platform is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * The Whole Platform is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with the Whole Platform. If not, see <http://www.gnu.org/licenses/>.
 */
package org.whole.lang.queries.visitors;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.bindings.ITransactionScope;
import org.whole.lang.commons.parsers.CommonsDataTypePersistenceParser;
import org.whole.lang.commons.reflect.CommonsEntityDescriptorEnum;
import org.whole.lang.commons.reflect.CommonsLanguageKit;
import org.whole.lang.comparators.BusinessIdentityComparator;
import org.whole.lang.comparators.IEntityComparator;
import org.whole.lang.comparators.IdentityIteratorComparator;
import org.whole.lang.exceptions.WholeIllegalArgumentException;
import org.whole.lang.factories.GenericEntityFactory;
import org.whole.lang.iterators.AbstractCollectIterator;
import org.whole.lang.iterators.AbstractSingleValuedRunnableIterator;
import org.whole.lang.iterators.ChooseByTypeIterator;
import org.whole.lang.iterators.DistinctScope;
import org.whole.lang.iterators.EmptyIterator;
import org.whole.lang.iterators.FilterByIndexRangeIterator;
import org.whole.lang.iterators.RegularIteratorFactory.FilterIterator;
import org.whole.lang.iterators.IEntityIterator;
import org.whole.lang.iterators.Placement;
import org.whole.lang.iterators.SelectIterator;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.IEntity;
import org.whole.lang.model.adapters.IEntityAdapter;
import org.whole.lang.operations.ICloneContext;
import org.whole.lang.queries.codebase.IfWithTemplate;
import org.whole.lang.queries.codebase.IfWithTypeTest;
import org.whole.lang.queries.model.*;
import org.whole.lang.queries.model.KindTestEnum.Value;
import org.whole.lang.queries.reflect.QueriesEntityDescriptorEnum;
import org.whole.lang.queries.reflect.QueriesLanguageKit;
import org.whole.lang.queries.util.MathUtils;
import org.whole.lang.reflect.CompositeKinds;
import org.whole.lang.reflect.DataKinds;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reflect.EntityKinds;
import org.whole.lang.reflect.ILanguageKit;
import org.whole.lang.util.EntityUtils;
import org.whole.lang.util.WholeMessages;
import org.whole.lang.visitors.IVisitor;

/**
 * @author Riccardo Solmi
 */
public class QueriesDynamicCompilerVisitor extends QueriesIdentityDefaultVisitor {
	private Set<String> declaredNames = new HashSet<String>();
	private Set<String> templateNames = new HashSet<String>();
	private Set<String> namesExp = new HashSet<String>();
	private boolean useNamesComplement;
	private DistinctScope<IEntity> distinctScope;
	private IEntityIterator<IEntity> filterByIndexIterator;
	private boolean canFilterByIndex;
	private int startIndex;
	private int endIndex;

	protected final String stringValue(Name entity) {
		setResult(null);
    	entity.accept(this);
    	IEntity result = getResult();
    	if (result == null)
    		throw new WholeIllegalArgumentException(WholeMessages.null_value_argument).withSourceEntity(entity).withBindings(getBindings());
    	return result.wStringValue();
	}

	@Override
	public boolean visitAdapter(IEntityAdapter entity) {
		IEntity adaptee = entity.wGetAdaptee(false);

		@Deprecated
		EntityDescriptor<?> adapteeEd = adaptee.wGetEntityDescriptor();
		if (adapteeEd.getLanguageKit().getURI().equals(CommonsLanguageKit.URI)) {
			switch (adapteeEd.getOrdinal()) {
			case CommonsEntityDescriptorEnum.Resolver_ord:
				setResultIterator(iteratorFactory().emptyIterator().withSourceEntity(adaptee));
				return false;
			case CommonsEntityDescriptorEnum.StageDownFragment_ord:
				setResultIterator(iteratorFactory().templateInterpreterIterator(
						GenericEntityFactory.instance.create(
								CommonsEntityDescriptorEnum.StageDownFragment, EntityUtils.clone(entity)))
						.withSourceEntity(adaptee));
				return false;
			}
		}

		stagedVisit(adaptee, 0);
		return false;
	}

	@Override
	public void visit(IQueriesEntity entity) {
		getOperation().stagedDefaultVisit(entity, 0);
	}

	@Override
	public void visit(QueryDeclaration entity) {
		String queryName = stringValue(entity.getName());
		declaredNames.add(queryName);

		setResultIterator(
				iteratorFactory().filterIterator(
						iteratorFactory().constantIterator(entity, true).withSourceEntity(entity),
								iteratorFactory().asVariableIterator(queryName))
						.withSourceEntity(entity));
	}

	@Override
	public void visit(Call entity) {
		Expressions arguments = entity.getArguments();

		IEntityIterator<? extends IEntity>[] argsIterators = new IEntityIterator<?>[arguments.wSize()];
		for (int i = 0, size = arguments.wSize(); i < size; i++) {
			arguments.get(i).accept(this);
			argsIterators[i] = getResultIterator();
		}

		setResultIterator(iteratorFactory().callIterator(stringValue(entity.getName()), argsIterators).withSourceEntity(entity));
	}

	@Override
	public void visit(Scope entity) {
		namesExp = Collections.emptySet();
		entity.getLocalNames().accept(this);
		Set<String> localNames = namesExp;

		entity.getExpression().accept(this);

		boolean withFreshNames = !(entity.getLocalNames() instanceof ScopeNames);
		if (!withFreshNames || !localNames.isEmpty())
			setResultIterator(iteratorFactory().scopeIterator(getResultIterator(), null, localNames, withFreshNames).withSourceEntity(entity));
	}

	@Override
	public void visit(Path entity) {
		DistinctScope<IEntity> oldDistinctScope = distinctScope;
		distinctScope = null;

		int nestedIndex = entity.wSize() - 1;
		IEntityIterator<?>[] nestedIterators = new IEntityIterator<?>[nestedIndex >= 0 ? nestedIndex : 0];
		nestedIndex--;
		for (int i = 0; i < entity.wSize() - 1; i++) {
			entity.get(i).accept(this);
			nestedIterators[nestedIndex - i] = getResultIterator();
		}
		entity.get(entity.wSize() - 1).accept(this);

		setResultIterator(
				iteratorFactory().composeIterator(getResultIterator(), nestedIterators).withSourceEntity(entity));

		if (distinctScope != null)
			setResultIterator(distinctScope.withIterator(getResultIterator()));

		distinctScope = oldDistinctScope;
	}

	@Override
	public void visit(Choose entity) {
		int size = entity.wSize();
		if (size == 1)
			entity.get(0).accept(this);
		else {
			boolean canOptimize = true;
			ILanguageKit languageKit = null;
			Map<EntityDescriptor<?>, Expression> typeMap = new HashMap<EntityDescriptor<?>, Expression>();

			If ifWithTemplate = new IfWithTemplate().create();
			If ifWithTypeTest = new IfWithTypeTest().create();

			ITransactionScope ts = BindingManagerFactory.instance.createTransactionScope();
			getBindings().wEnterScope(ts);
			for (int i = 0; i < size; i++) {
				Expression child = entity.get(i);
				try {
					if (!Matcher.match(ifWithTemplate, child, getBindings())
							&& !Matcher.match(ifWithTypeTest, child, getBindings())) {
						canOptimize = false;
						break;
					}

					EntityDescriptor<?> ed = getBindings().wIsSet("typeTest")
							&& getBindings().wGet("typeTest").wGetEntityDescriptor().getDataKind().isString()
									? CommonsDataTypePersistenceParser
											.getEntityDescriptor(getBindings().wStringValue("typeTest"))
									: getBindings().wIsSet("pattern")
											? getBindings().wGet("pattern").wGetEntityDescriptor() : null;

					if (ed == null) {
						canOptimize = false;
						break;
					}

					if (typeMap.containsKey(ed)) {
						Expression behavior = typeMap.get(ed);
						boolean isPattern = behavior.wGetParent() == entity;
						if (isPattern) {
							canOptimize = false;
							break;
						}
					} else {
						if (languageKit == null)
							languageKit = ed.getLanguageKit();
						else if (!languageKit.equals(ed.getLanguageKit())) {// ||
																			// !languageKit.getURI().equals("whole:org.whole.lang.javascript:JavaScript"))
																			// {
							canOptimize = false;
							break;
						}
						typeMap.put(ed,
								getBindings().wIsSet("pattern") ? child
										: getBindings().wGet("expression")
												.wGetAdapter(QueriesEntityDescriptorEnum.Expression));
					}
				} finally {
					ts.rollback();
				}
			}
			getBindings().wExitScope();

			if (canOptimize && languageKit != null) {
				IEntityIterator<?> ri = iteratorFactory().chooseIterator(languageKit);
				ChooseByTypeIterator<?> chooseIterator = (ChooseByTypeIterator<?>) ri.specificIterator();

				for (Entry<EntityDescriptor<?>, Expression> entry : typeMap.entrySet()) {
					Set<String> oldDeclaredNames = declaredNames;

					entry.getValue().accept(this);
					chooseIterator.setCase(entry.getKey(), getResultIterator());

					declaredNames = oldDeclaredNames;
				}

				setResultIterator(ri.withSourceEntity(entity));

			} else {
				IEntityIterator<? extends IEntity>[] iteratorChain = new IEntityIterator<?>[size];

				for (int i = 0; i < size; i++) {
					entity.get(i).accept(this);
					iteratorChain[i] = getResultIterator();
				}

				setResultIterator(iteratorFactory().chooseIterator(iteratorChain).withSourceEntity(entity));
			}
		}
	}

	@Override
	public void visit(Block entity) {
		int size = entity.wSize();
		if (size == 1)
			entity.get(0).accept(this);
		else {
			IEntityIterator<? extends IEntity>[] iteratorChain = new IEntityIterator<?>[size];

			for (int i = 0; i < size; i++) {
				entity.get(i).accept(this);
				iteratorChain[i] = getResultIterator();
			}

			setResultIterator(iteratorFactory().blockIterator(iteratorChain).withSourceEntity(entity));
		}
	}

	@Override
	public void visit(Sequence entity) {
		int size = entity.wSize();
		if (size == 1)
			entity.get(0).accept(this);// FIXME nested scope is exposed
		else {
			IEntityIterator<? extends IEntity>[] iteratorChain = new IEntityIterator<?>[size];

			for (int i = 0; i < size; i++) {
				entity.get(i).accept(this);
				iteratorChain[i] = getResultIterator();
			}

			setResultIterator(iteratorFactory().sequenceIterator(iteratorChain).withSourceEntity(entity));
		}
	}

	@Override
	public void visit(Prune entity) {
		entity.getPredicate().accept(this);
	}

	@Override
	public void visit(Filter entity) {
		IEntityIterator<IEntity> oldFilterByIndexIterator = filterByIndexIterator;
		filterByIndexIterator = null;
		DistinctScope<IEntity> oldDistinctScope = distinctScope;
		distinctScope = null;

		PruneOrPredicate predicate = entity.getPredicate();
		Expression expression = entity.getExpression();
		boolean optimizeIndexTest = false;

		int oldStartIndex = startIndex;
		int oldEndIndex = endIndex;
		boolean oldCanFilterByIndex = canFilterByIndex;
		startIndex = Integer.MAX_VALUE;
		endIndex = 0;
		canFilterByIndex = true;

		boolean usePruneFilter = Matcher.matchImpl(QueriesEntityDescriptorEnum.Prune, predicate);
		if (usePruneFilter)
			predicate = ((Prune) predicate).getPredicate();

		if (Matcher.matchImpl(QueriesEntityDescriptorEnum.ChildStep, expression)) {
			if (Matcher.matchImpl(QueriesEntityDescriptorEnum.IndexTest, predicate)) {
				int relativeIndex = predicate.wGet(0).wIntValue();
				setResultIterator(iteratorFactory().featureByIndexIterator(relativeIndex).withSourceEntity(entity));
				optimizeIndexTest = true;
			} else if (Matcher.matchImpl(QueriesEntityDescriptorEnum.AtIndexTest, predicate)) {
				int index = predicate.wIntValue();
				setResultIterator(iteratorFactory().featureByIndexIterator(index).withSourceEntity(entity));
				optimizeIndexTest = true;
			} else if (Matcher.matchImpl(QueriesEntityDescriptorEnum.IndexRangeTest, predicate)) {
				int relativeStartIndex = ((IndexRangeTest) predicate).getStartIndex().getValue();
				IntLiteral relativeEndIndexEntity = ((IndexRangeTest) predicate).getEndIndex();
				int relativeEndIndex = EntityUtils.isResolver(relativeEndIndexEntity) ? -1
						: relativeEndIndexEntity.getValue();
				setResultIterator(iteratorFactory().childRangeIterator(relativeStartIndex, relativeEndIndex)
						.withSourceEntity(entity));
				optimizeIndexTest = true;
			}
		}

		if (!optimizeIndexTest) {
			setResult(null);
			predicate.accept(this);
			IEntityIterator<IEntity> queryPredicateIterator = getResultIterator();

			expression.accept(this);
			if (getResultIterator().specificIterator() instanceof EmptyIterator)
				setResultIterator(iteratorFactory().selfIterator().withSourceEntity(entity));

			if (filterByIndexIterator != null) {
				((FilterByIndexRangeIterator<?>) filterByIndexIterator.specificIterator()).withIterator(getResultIterator());
				setResultIterator(filterByIndexIterator);

				if (canFilterByIndex) {
					// ((FilterByIndexRangeIterator<?>) filterByIndexIterator.specificIterator()).withStartIndex(startIndex);
					((FilterByIndexRangeIterator<?>) filterByIndexIterator.specificIterator()).withEndIndex(endIndex);
				}
			}

			if (distinctScope != null && !(EntityUtils.hasParent(entity)
					&& Matcher.match(QueriesEntityDescriptorEnum.Path, entity.wGetParent())))
				setResultIterator(distinctScope.withIterator(getResultIterator()));

			if (!(queryPredicateIterator.specificIterator() instanceof EmptyIterator)) {
				IEntityIterator<?> ri = iteratorFactory().filterIterator(getResultIterator(), queryPredicateIterator);
				((FilterIterator<?>) ri.specificIterator()).withAutoPrune(usePruneFilter);
				setResultIterator(ri.withSourceEntity(entity));
			}
		}

		startIndex = oldStartIndex;
		endIndex = oldEndIndex;
		canFilterByIndex = oldCanFilterByIndex;
		filterByIndexIterator = oldFilterByIndexIterator;
		distinctScope = oldDistinctScope;
	}

	@Override
	public void visit(AspectStep entity) {
		setResultIterator(iteratorFactory().aspectIterator().withSourceEntity(entity));
	}

	@Override
	public void visit(AdjacentStep entity) {
		setResultIterator(iteratorFactory().adjacentIterator().withSourceEntity(entity));
	}

	@Override
	public void visit(ReachableStep entity) {
		setResultIterator(iteratorFactory().reachableIterator(false).withSourceEntity(entity));
	}

	@Override
	public void visit(ReachableOrSelfStep entity) {
		setResultIterator(iteratorFactory().reachableIterator(true).withSourceEntity(entity));
	}

	@Override
	public void visit(InverseAdjacentStep entity) {
		setResultIterator(iteratorFactory().inverseAdjacentIterator().withSourceEntity(entity));
	}

	@Override
	public void visit(InverseReachableStep entity) {
		setResultIterator(iteratorFactory().inverseReachableIterator(false).withSourceEntity(entity));
	}

	@Override
	public void visit(InverseReachableOrSelfStep entity) {
		setResultIterator(iteratorFactory().inverseReachableIterator(true).withSourceEntity(entity));
	}

	@Override
	public void visit(RootStep entity) {
		setResultIterator(iteratorFactory().rootIterator().withSourceEntity(entity));
	}

	@Override
	public void visit(FragmentRootStep entity) {
		setResultIterator(iteratorFactory().fragmentRootIterator().withSourceEntity(entity));
	}

	@Override
	public void visit(SelfStep entity) {
		setResultIterator(iteratorFactory().selfIterator().withSourceEntity(entity));
	}

	@Override
	public void visit(FeatureStep entity) {
		setResultIterator(iteratorFactory().featureByNameIterator(entity.getValue()).withSourceEntity(entity));
	}

	@Override
	public void visit(ChildStep entity) {
		setResultIterator(iteratorFactory().childIterator().withSourceEntity(entity));
	}

	@Override
	public void visit(DescendantStep entity) {
		setResultIterator(iteratorFactory().descendantIterator().withSourceEntity(entity));
	}

	@Override
	public void visit(DescendantOrSelfStep entity) {
		setResultIterator(iteratorFactory().descendantOrSelfIterator().withSourceEntity(entity));
	}

	@Override
	public void visit(FollowingSiblingStep entity) {
		setResultIterator(iteratorFactory().followingSiblingIterator().withSourceEntity(entity));
	}

	@Override
	public void visit(FollowingSiblingOrSelfStep entity) {
		setResultIterator(iteratorFactory().followingSiblingOrSelfIterator().withSourceEntity(entity));
	}

	@Override
	public void visit(FollowingStep entity) {
		setResultIterator(iteratorFactory().followingIterator().withSourceEntity(entity));
	}

	@Override
	public void visit(FollowingOrSelfStep entity) {
		setResultIterator(iteratorFactory().followingOrSelfIterator().withSourceEntity(entity));
	}

	@Override
	public void visit(ParentStep entity) {
		setResultIterator(iteratorFactory().parentIterator().withSourceEntity(entity));
	}

	@Override
	public void visit(AncestorStep entity) {
		setResultIterator(iteratorFactory().ancestorIterator().withSourceEntity(entity));
	}

	@Override
	public void visit(AncestorOrSelfStep entity) {
		setResultIterator(iteratorFactory().ancestorOrSelfIterator().withSourceEntity(entity));
	}

	@Override
	public void visit(PrecedingSiblingStep entity) {
		setResultIterator(iteratorFactory().precedingSiblingIterator().withSourceEntity(entity));
	}

	@Override
	public void visit(PrecedingSiblingOrSelfStep entity) {
		setResultIterator(iteratorFactory().precedingSiblingOrSelfIterator().withSourceEntity(entity));
	}

	@Override
	public void visit(PrecedingStep entity) {
		setResultIterator(iteratorFactory().precedingIterator().withSourceEntity(entity));
	}

	@Override
	public void visit(PrecedingOrSelfStep entity) {
		setResultIterator(iteratorFactory().precedingOrSelfIterator().withSourceEntity(entity));
	}

	@Override
	public void visit(Reverse entity) {
		ReversibleStep step = entity.getExpression();

		IEntityIterator<?> iterator = null;

		if (step.wGetLanguageKit().getURI().equals(QueriesLanguageKit.URI)) {
			switch (step.wGetEntityOrd()) {
			case QueriesEntityDescriptorEnum.ChildStep_ord:
				iterator = iteratorFactory().childReverseIterator();
				break;
			case QueriesEntityDescriptorEnum.AdjacentStep_ord:
				iterator = iteratorFactory().adjacentReverseIterator();
				break;
			case QueriesEntityDescriptorEnum.DescendantStep_ord:
				iterator = iteratorFactory().descendantReverseIterator();
				break;
			case QueriesEntityDescriptorEnum.DescendantOrSelfStep_ord:
				iterator = iteratorFactory().descendantOrSelfReverseIterator();
				break;
			case QueriesEntityDescriptorEnum.FollowingSiblingStep_ord:
				iterator = iteratorFactory().followingSiblingReverseIterator();
				break;
			case QueriesEntityDescriptorEnum.FollowingSiblingOrSelfStep_ord:
				iterator = iteratorFactory().followingSiblingOrSelfReverseIterator();
				break;
			case QueriesEntityDescriptorEnum.PrecedingSiblingStep_ord:
				iterator = iteratorFactory().precedingSiblingReverseIterator();
				break;
			case QueriesEntityDescriptorEnum.PrecedingSiblingOrSelfStep_ord:
				iterator = iteratorFactory().precedingSiblingOrSelfReverseIterator();
				break;
			case QueriesEntityDescriptorEnum.AncestorStep_ord:
				iterator = iteratorFactory().ancestorReverseIterator();
				break;
			case QueriesEntityDescriptorEnum.AncestorOrSelfStep_ord:
				iterator = iteratorFactory().ancestorOrSelfReverseIterator();
				break;
			}
		}

		if (iterator != null)
			setResultIterator(iterator.withSourceEntity(entity));
		else
			throw new WholeIllegalArgumentException("Non reversible step").withSourceEntity(entity);
	}

	@Override
	public void visit(VariableRefStep entity) {
		String varName = entity.getValue();
    	setResultIterator((varName.equals(IBindingManager.SELF) ?
    			iteratorFactory().selfIterator() : iteratorFactory().variableIterator(varName)).withSourceEntity(entity));
	}

	@Override
	public void visit(VariableTest entity) {
		String name = entity.getValue();
		declaredNames.add(name);

		setResultIterator(iteratorFactory().asVariableIterator(name).withSourceEntity(entity));
	}

	@Override
	public void visit(CartesianProduct entity) {
		IEntityIterator<?>[] iterators = new IEntityIterator<?>[entity.wSize()];
		for (int i = 0; i < entity.wSize(); i++) {
			entity.get(i).accept(this);
			iterators[i] = getResultIterator();
		}

		setResultIterator(iteratorFactory().cartesianProductIterator(iterators).withSourceEntity(entity));
	}

	@Override
	public void visit(PointwiseProduct entity) {
		IEntityIterator<?>[] iterators = new IEntityIterator<?>[entity.wSize()];

		for (int i = 0; i < entity.wSize(); i++) {
			entity.get(i).accept(this);
			iterators[i] = getResultIterator();
		}

		setResultIterator(iteratorFactory().pointwiseProductIterator(iterators).withSourceEntity(entity));
	}

	@Override
	public void visit(Clone entity) {
		entity.getFromClause().accept(this);
		IEntityIterator<? extends IEntity> fromIterator = getResultIterator();

		setResultIterator(iteratorFactory().cloneReplacingIterator(fromIterator).withSourceEntity(entity));
	}

	@Override
	public void visit(Delete entity) {
		entity.getFromClause().accept(this);
		IEntityIterator<? extends IEntity> fromIterator = getResultIterator();

		setResultIterator(iteratorFactory().deleteIterator(fromIterator).withSourceEntity(entity));
	}

	@Override
	public void visit(Update entity) {
		entity.getFromClause().accept(this);
		IEntityIterator<IEntity> fromIterator = getResultIterator();

		setResultIterator(iteratorFactory().pointwiseUpdateIterator(
				iteratorFactory().repeatedSelfIterator().withSourceEntity(entity), fromIterator)
				.withSourceEntity(entity));
	}

	@Override
	public void visit(CartesianUpdate entity) {
		entity.getFromClause().accept(this);
		IEntityIterator<IEntity> fromIterator = getResultIterator();

		setResultIterator(iteratorFactory().emptyIterator().withSourceEntity(entity));
		entity.getValuesClause().accept(this);
		IEntityIterator<? extends IEntity> valuesIterator = getResultIterator();

		setResultIterator(iteratorFactory().cartesianUpdateIterator(
				valuesIterator, fromIterator).withSourceEntity(entity));
	}

	@Override
	public void visit(PointwiseUpdate entity) {
		entity.getFromClause().accept(this);
		IEntityIterator<IEntity> fromIterator = getResultIterator();

		setResultIterator(iteratorFactory().emptyIterator().withSourceEntity(entity));
		entity.getValuesClause().accept(this);
		IEntityIterator<? extends IEntity> valuesIterator = getResultIterator();

		setResultIterator(iteratorFactory().pointwiseUpdateIterator(
				valuesIterator, fromIterator).withSourceEntity(entity));
	}

	@Override
	public void visit(Insert entity) {
		entity.getFromClause().accept(this);
		IEntityIterator<IEntity> fromIterator = getResultIterator();

		Placement placement = Placement.valueOf(entity.getPlacement().getValue().getName());
		setResultIterator(iteratorFactory().pointwiseInsertIterator(
				iteratorFactory().repeatedSelfIterator().withSourceEntity(entity),
				fromIterator, placement)
				.withSourceEntity(entity));
	}

	@Override
	public void visit(CartesianInsert entity) {
		entity.getFromClause().accept(this);
		IEntityIterator<IEntity> fromIterator = getResultIterator();

		setResultIterator(iteratorFactory().emptyIterator().withSourceEntity(entity));
		entity.getValuesClause().accept(this);
		IEntityIterator<? extends IEntity> valuesIterator = getResultIterator();

		Placement placement = Placement.valueOf(entity.getPlacement().getValue().getName());
		setResultIterator(iteratorFactory().cartesianInsertIterator(
				valuesIterator, fromIterator, placement)
				.withSourceEntity(entity));
	}

	@Override
	public void visit(PointwiseInsert entity) {
		entity.getFromClause().accept(this);
		IEntityIterator<IEntity> fromIterator = getResultIterator();

		setResultIterator(iteratorFactory().emptyIterator().withSourceEntity(entity));
		entity.getValuesClause().accept(this);
		IEntityIterator<? extends IEntity> valuesIterator = getResultIterator();

		Placement placement = Placement.valueOf(entity.getPlacement().getValue().getName());
		setResultIterator(iteratorFactory().pointwiseInsertIterator(
				valuesIterator, fromIterator, placement)
				.withSourceEntity(entity));
	}

	@Override
	public void visit(Select entity) {
		Set<String> oldDeclaredNames = declaredNames;
		Set<String> namesToBound = declaredNames = new HashSet<String>();

		setResult(null);
		entity.getFromClause().accept(this);
		IEntityIterator<? extends IEntity> fromIterator = getResultIterator();

		setResultIterator(iteratorFactory().emptyIterator().withSourceEntity(entity));
		entity.getWhereClause().accept(this);
		IEntityIterator<? extends IEntity> whereIterator = getResultIterator();

		declaredNames = oldDeclaredNames;

		entity.getSelectClause().accept(this);
		IEntityIterator<? extends IEntity> selectIterator = getResultIterator();

		templateNames = Matcher.vars(entity.getSelectClause(), true);
		namesExp = declaredNames = namesToBound;
		useNamesComplement = false;
		entity.getClearClause().accept(this);

		IEntityIterator<?> si = iteratorFactory().selectIterator(selectIterator, fromIterator, whereIterator);
		((SelectIterator<?>) si.specificIterator()).withNamesToBind(namesExp).withNamesComplement(useNamesComplement);
		setResultIterator(si.withSourceEntity(entity));

		declaredNames = oldDeclaredNames;
	}


	@Override
	public void visit(AllNames entity) {
		namesExp = new HashSet<String>();
		useNamesComplement = true;
	}

	@Override
	public void visit(TemplateNames entity) {
		namesExp = templateNames;
	}

	@Override
	public void visit(AddNames entity) {
		entity.getExpression().accept(this);
		Set<String> names = namesExp;
		entity.getNames().accept(this);
		names.addAll(namesExp);
		namesExp = names;
	}

	@Override
	public void visit(RemoveNames entity) {
		entity.getExpression().accept(this);
		Set<String> names = namesExp;
		entity.getNames().accept(this);
		names.removeAll(namesExp);
		namesExp = names;
	}

	@Override
	public void visit(Names entity) {
		namesExp = new HashSet<String>();
		for (int i = 0; i < entity.size(); i++)
			namesExp.add(stringValue(entity.get(i)));
	}

	@Override
	public void visit(FreshNames entity) {
		namesExp = new HashSet<String>();
		for (int i = 0; i < entity.size(); i++)
			namesExp.add(stringValue(entity.get(i)));
	}
	@Override
	public void visit(ScopeNames entity) {
		namesExp = new HashSet<String>();
		for (int i = 0; i < entity.size(); i++)
			namesExp.add(stringValue(entity.get(i)));
	}

	@Override
	public void visit(Name entity) {
		setResult(BindingManagerFactory.instance.createValue(entity.getValue()));
	}

	@Override
	public void visit(For entity) {
		Set<String> oldDeclaredNames = declaredNames;
		Set<String> namesToBound = declaredNames = new HashSet<String>();

		entity.getFromClause().accept(this);
		IEntityIterator<? extends IEntity> fromIterator = getResultIterator();

		declaredNames = oldDeclaredNames;

		entity.getExpression().accept(this);
		IEntityIterator<? extends IEntity> selectIterator = getResultIterator();

		declaredNames = namesToBound;

		setResultIterator(iteratorFactory().forIterator(fromIterator, selectIterator).withSourceEntity(entity));

		declaredNames = oldDeclaredNames;
	}

	@Override
	public void visit(If entity) {
		Set<String> oldDeclaredNames = declaredNames;
		Set<String> namesToBound = declaredNames = new HashSet<String>();

		setResult(null);
		entity.getPredicate().accept(this);
		IEntityIterator<? extends IEntity> conditionIterator = getResultIterator();

		declaredNames = oldDeclaredNames;

		entity.getExpression().accept(this);
		
		if (!(conditionIterator.specificIterator() instanceof EmptyIterator)) {
			IEntityIterator<? extends IEntity> selectIterator = getResultIterator();
	
			declaredNames = namesToBound;
	
			setResultIterator(iteratorFactory().ifIterator(conditionIterator, selectIterator).withSourceEntity(entity));
		}
		declaredNames = oldDeclaredNames;
	}

	@Deprecated
	@Override
	public void visit(Do entity) {
		Set<String> oldDeclaredNames = declaredNames;
		entity.getExpression().accept(this);
		declaredNames = oldDeclaredNames;
	}

	@Override
	public void visit(Tuple entity) {
		IEntityIterator<?>[] tupleIterators = new IEntityIterator<?>[entity.wSize()];
		for (int i = 0; i < entity.wSize(); i++) {
			entity.get(i).accept(this);
			tupleIterators[i] = getResultIterator();
		}
		setResultIterator(iteratorFactory().tupleFactoryIterator(tupleIterators).withSourceEntity(entity));
	}

	@Override
	public void visit(One entity) {
		entity.getFromClause().accept(this);
		IEntityIterator<IEntity> fromClause = getResultIterator();
		entity.getWhereClause().accept(this);

		IEntityIterator<IEntity> satisfiesClause = getResultIterator();
		setResultIterator(iteratorFactory().oneIterator(fromClause, satisfiesClause).withSourceEntity(entity));
	}

	@Override
	public void visit(Some entity) {
		entity.getFromClause().accept(this);
		IEntityIterator<IEntity> fromClause = getResultIterator();
		entity.getWhereClause().accept(this);

		IEntityIterator<IEntity> satisfiesClause = getResultIterator();
		if (satisfiesClause.specificIterator() instanceof EmptyIterator)
			setResultIterator(iteratorFactory().someIterator(fromClause).withSourceEntity(entity));			
		else
			setResultIterator(iteratorFactory().someIterator(fromClause, satisfiesClause).withSourceEntity(entity));
	}

	@Override
	public void visit(Every entity) {
		entity.getFromClause().accept(this);
		IEntityIterator<IEntity> fromClause = getResultIterator();
		entity.getWhereClause().accept(this);

		IEntityIterator<IEntity> satisfiesClause = getResultIterator();
		setResultIterator(iteratorFactory().everyIterator(fromClause, satisfiesClause).withSourceEntity(entity));
	}

	@Override
	public void visit(KindTest entity) {
		Value kind = entity.getValue();
		switch (kind.getOrdinal()) {
		case KindTestEnum.IMPL_ord:
			setResultIterator(iteratorFactory().isImplIterator().withSourceEntity(entity));
			break;
		case KindTestEnum.FRAGMENT_ord:
			setResultIterator(iteratorFactory().isFragmentIterator().withSourceEntity(entity));
			break;
		case KindTestEnum.VARIABLE_ord:
			setResultIterator(iteratorFactory().isVariableIterator().withSourceEntity(entity));
			break;
		case KindTestEnum.RESOLVER_ord:
			setResultIterator(iteratorFactory().isResolverIterator().withSourceEntity(entity));
			break;
		default:
			EntityKinds ekind = EntityKinds.valueOf(kind.getName());
			setResultIterator(iteratorFactory().hasKindIterator(ekind).withSourceEntity(entity));
		}
	}
	@Override
	public void visit(CompositeKindTest entity) {
		CompositeKindTestEnum.Value kind = entity.getValue();
		setResultIterator(iteratorFactory().hasCompositeKindIterator(CompositeKinds.valueOf(kind.getName())));
	}
	@Override
	public void visit(DataKindTest entity) {
		DataKindTestEnum.Value kind = entity.getValue();
		setResultIterator(iteratorFactory().hasDataKindIterator(DataKinds.valueOf(kind.getName())));
	}

	@Override
	public void visit(StageTest entity) {
		StageTestEnum.Value stage = entity.getValue();
		switch (stage.getOrdinal()) {
		case StageTestEnum.HOST_STAGE_ord:
			setResultIterator(iteratorFactory().atHostStageIterator().withSourceEntity(entity));
			break;
		case StageTestEnum.HOST_STAGE_0_ord:
			setResultIterator(iteratorFactory().atStageIterator(0).withSourceEntity(entity));
			break;
		case StageTestEnum.TEMPLATE_STAGE_1_ord:
			setResultIterator(iteratorFactory().atStageIterator(1).withSourceEntity(entity));
			break;
		case StageTestEnum.TEMPLATE_STAGE_ord:
			setResultIterator(iteratorFactory().atTemplateStageIterator().withSourceEntity(entity));
			break;
		}
	}

	@Override
	public void visit(StageVariableTest entity) {
		setResultIterator(iteratorFactory().atStageVariableIterator(entity.getValue()).withSourceEntity(entity));
	}

	@Override
	public void visit(LanguageVariableTest entity) {
		setResultIterator(iteratorFactory().languageVariableIterator(entity.getValue()).withSourceEntity(entity));
	}

	@Override
	public void visit(TypeVariableTest entity) {
		setResultIterator(iteratorFactory().typeVariableIterator(entity.getValue()).withSourceEntity(entity));
	}

	@Override
	public void visit(SubtypeVariableTest entity) {
		setResultIterator(iteratorFactory().languageSubtypeOfVariableIterator(entity.getValue()).withSourceEntity(entity));
	}

	@Override
	public void visit(SupertypeVariableTest entity) {
		setResultIterator(iteratorFactory().languageSupertypeOfVariableIterator(entity.getValue()).withSourceEntity(entity));
	}

	@Override
	public void visit(ExtendedSubtypeVariableTest entity) {
		setResultIterator(iteratorFactory().extendedLanguageSubtypeOfVariableIterator(entity.getValue()).withSourceEntity(entity));
	}

	@Override
	public void visit(ExtendedSupertypeVariableTest entity) {
		setResultIterator(iteratorFactory().extendedLanguageSupertypeOfVariableIterator(entity.getValue()).withSourceEntity(entity));
	}

	@Override
	public void visit(LanguageTest entity) {
		setResultIterator(iteratorFactory().isLanguageIterator(entity.getValue()).withSourceEntity(entity));
	}

	@Override
	public void visit(TypeTest entity) {
		setResultIterator(iteratorFactory().hasTypeIterator(entity.getValue()).withSourceEntity(entity));
	}

	@Override
	public void visit(SubtypeTest entity) {
		setResultIterator(iteratorFactory().isLanguageSubtypeOfIterator(entity.getValue()).withSourceEntity(entity));
	}

	@Override
	public void visit(SupertypeTest entity) {
		setResultIterator(iteratorFactory().isLanguageSupertypeOfIterator(entity.getValue()).withSourceEntity(entity));
	}

	@Override
	public void visit(ExtendedSubtypeTest entity) {
		setResultIterator(iteratorFactory().isExtendedLanguageSubtypeOfIterator(entity.getValue()).withSourceEntity(entity));
	}

	@Override
	public void visit(ExtendedSupertypeTest entity) {
		setResultIterator(iteratorFactory().isExtendedLanguageSupertypeOfIterator(entity.getValue()).withSourceEntity(entity));
	}

	@Override
	public void visit(MatchTest entity) {
		Expression e = entity.getExpression();
		e.accept(this);
		setResultIterator(iteratorFactory().matchInScopeIterator(getResultIterator()).withSourceEntity(entity));
	}

	@Override
	public void visit(PointwiseEquals entity) {
		entity.getPexp1().accept(this);
		IEntityIterator<IEntity> exp1Iterator = getResultIterator();
		entity.getPexp2().accept(this);
		
		setResultIterator(iteratorFactory().pointwiseEqualsIterator(exp1Iterator, getResultIterator()).withSourceEntity(entity));
	}

	@Override
	public void visit(AtTypeTest entity) {
		setResultIterator(iteratorFactory().atTypeIterator(entity.getValue()).withSourceEntity(entity));
	}

	@Override
	public void visit(AtFeatureTest entity) {
		setResultIterator(iteratorFactory().atFeatureIterator(entity.getValue()).withSourceEntity(entity));
	}

	@Override
	public void visit(AtIndexTest entity) {
		int index = entity.getIndex().getValue();

		setResultIterator(iteratorFactory().atIndexIterator(index).withSourceEntity(entity));
	}

	@Override
	public void visit(IndexVariableTest entity) {
		String varName = entity.getValue();
		declaredNames.add(varName);

		if (filterByIndexIterator == null) {
			filterByIndexIterator = iteratorFactory().filterByIndexRangeIterator();
			filterByIndexIterator.withSourceEntity(entity);
		}

		setResultIterator(iteratorFactory().iterationIndexVariableIterator(filterByIndexIterator, varName).withSourceEntity(entity));

		updateIndexRange(0, Integer.MAX_VALUE);
	}

	@Override
	public void visit(IndexTest entity) {
		if (filterByIndexIterator == null) {
			filterByIndexIterator = iteratorFactory().filterByIndexRangeIterator();
			filterByIndexIterator.withSourceEntity(entity);
		}

		int index = entity.getIndex().getValue();
		setResultIterator(iteratorFactory().iterationIndexIterator(filterByIndexIterator, index).withSourceEntity(entity));

		updateIndexRange(index, index);
	}

	@Override
	public void visit(IndexRangeTest entity) {
		if (filterByIndexIterator == null) {
			filterByIndexIterator = iteratorFactory().filterByIndexRangeIterator();
			filterByIndexIterator.withSourceEntity(entity);
		}

		int startIndexValue = entity.getStartIndex().getValue();
		int endIndexValue;
		IntLiteral endIndex = entity.getEndIndex();
		if (Matcher.matchImpl(QueriesEntityDescriptorEnum.IntLiteral, endIndex))
			endIndexValue = endIndex.getValue();
		else
			endIndexValue = Integer.MAX_VALUE;

		setResultIterator(iteratorFactory().iterationIndexRangeIterator(filterByIndexIterator, startIndexValue, endIndexValue).withSourceEntity(entity));

		updateIndexRange(startIndexValue, endIndexValue);
	}

	protected void updateIndexRange(int startIndex, int endIndex) {
		if (startIndex < this.startIndex)
			this.startIndex = startIndex;
		if (endIndex > this.endIndex)
			this.endIndex = endIndex;
		canFilterByIndex = true;
	}

	@Override
	public void visit(VisitorTest entity) {
		setResultIterator(new PredicateWrapperIterator(entity.getValue().withSourceEntity(entity)));
	}
	public static class PredicateWrapperIterator extends AbstractSingleValuedRunnableIterator<IEntity> {
		protected IVisitor queryPredicate;

		public PredicateWrapperIterator(IVisitor queryPredicate) {
			this.queryPredicate = queryPredicate;
		}

		@Override
		public IEntityIterator<IEntity> clone(ICloneContext cc) {
			PredicateWrapperIterator clone = (PredicateWrapperIterator) super.clone(cc);
			clone.queryPredicate = cc.clone(queryPredicate);
			return clone;
		}

		protected void setArgumentsBindings(IBindingManager bindings) {
			super.setArgumentsBindings(bindings);
			queryPredicate.setBindings(bindings);
		}

		protected void run(IEntity selfEntity, IBindingManager bm) {
			queryPredicate.setBindings(bm);
			bm.setResult(BindingManagerFactory.instance.createValue(Matcher.match(queryPredicate, selfEntity)));
		}

		@Override
		public void toString(StringBuilder sb) {
			sb.append("{I{");
			queryPredicate.toString(sb);
			sb.append("}I}");
		}
	}

	@Override
	public void visit(DistinctTest entity) {
		IEntityComparator<IEntity> oldComparator = comparator;
		comparator = BusinessIdentityComparator.instance;
		entity.getComparator().accept(this);

		if (distinctScope == null)
			distinctScope = iteratorFactory().distinctScope();

		distinctScope.withComparator(comparator);
		setResultIterator(distinctScope.distinctIterator().withSourceEntity(entity));
		comparator = oldComparator;
	}

	@Override
	public void visit(And entity) {
		visitFrom(entity, 0);
	}

	private void visitFrom(And entity, int from) {
		int size = entity.wSize() - from;
		IEntityIterator<?>[] argsIterators = new IEntityIterator[size];
		for (int i = from; i < size; i++) {
			entity.get(i).accept(this);
			argsIterators[i] = getResultIterator();
		}

		setResultIterator(iteratorFactory().andIterator(argsIterators).withSourceEntity(entity));
	}

	@Override
	public void visit(Or entity) {
		boolean canFilterByIndexResult = canFilterByIndex;

		int size = entity.wSize();
		IEntityIterator<?>[] argsIterators = new IEntityIterator[size];
		for (int i = 0; i < size; i++) {
			canFilterByIndex = false;
			entity.get(i).accept(this);
			argsIterators[i] = getResultIterator();
			canFilterByIndexResult &= !canFilterByIndex;
		}

		setResultIterator(iteratorFactory().orIterator(argsIterators).withSourceEntity(entity));

		canFilterByIndex = canFilterByIndexResult;
	}

	@Override
	public void visit(Not entity) {
		entity.getPredicate().accept(this);
		setResultIterator(iteratorFactory().notIterator(getResultIterator()).withSourceEntity(entity));
	}

	@Override
	public void visit(IdentityComparator entity) {
		entity.getIdentity().accept(this);
		comparator = new IdentityIteratorComparator<IEntity>(getResultIterator());
	}

	protected IEntityComparator<IEntity> comparator;

	@Override
	public void visit(Expressions entity) {
		IEntityIterator<?>[] iteratorChain = new IEntityIterator<?>[entity.wSize()];
		for (int i = 0; i < entity.wSize(); i++) {
			entity.get(i).accept(this);
			iteratorChain[i] = getResultIterator();
		}
		this.iteratorChain = iteratorChain;
	}

	protected IEntityIterator<?>[] iteratorChain;

	@Override
	public void visit(UnionAll entity) {
		entity.getExpressions().accept(this);
		setResultIterator(iteratorFactory().unionAllIterator(iteratorChain).withSourceEntity(entity));
	}

	public void visitCollectByExpression(CollectByExpression entity) {
		entity.getComparator().accept(this);
		entity.getExpressions().accept(this);
	}

	@Override
	public void visit(Union entity) {
		IEntityComparator<IEntity> oldComparator = comparator;
		comparator = BusinessIdentityComparator.instance;
		visitCollectByExpression(entity);
		IEntityIterator<?> ri = iteratorFactory().unionIterator(iteratorChain);
		((AbstractCollectIterator) ri.specificIterator()).withComparator(comparator);
		setResultIterator(ri.withSourceEntity(entity));
		comparator = oldComparator;
	}

	@Override
	public void visit(Intersect entity) {
		IEntityComparator<IEntity> oldComparator = comparator;
		comparator = BusinessIdentityComparator.instance;
		visitCollectByExpression(entity);
		IEntityIterator<?> ri = iteratorFactory().intersectIterator(iteratorChain);
		((AbstractCollectIterator) ri.specificIterator()).withComparator(comparator);
		setResultIterator(ri.withSourceEntity(entity));
		comparator = oldComparator;
	}

	@Override
	public void visit(Except entity) {
		IEntityComparator<IEntity> oldComparator = comparator;
		comparator = BusinessIdentityComparator.instance;
		visitCollectByExpression(entity);
		IEntityIterator<?> ri = iteratorFactory().exceptIterator(iteratorChain);
		((AbstractCollectIterator) ri.specificIterator()).withComparator(comparator);
		setResultIterator(ri.withSourceEntity(entity));
		comparator = oldComparator;
	}

	protected void setLiteral(IEntity entity) {
		setResultIterator(
				iteratorFactory().constantIterator(BindingManagerFactory.instance.createSpecificValue(entity), true)
						.withSourceEntity(entity));
	}

	public void visit(BooleanLiteral entity) {
		setLiteral(entity);
	}

	public void visit(ByteLiteral entity) {
		setLiteral(entity);
	}

	public void visit(CharLiteral entity) {
		setLiteral(entity);
	}

	public void visit(DoubleLiteral entity) {
		setLiteral(entity);
	}

	public void visit(FloatLiteral entity) {
		setLiteral(entity);
	}

	public void visit(IntLiteral entity) {
		setLiteral(entity);
	}

	public void visit(LongLiteral entity) {
		setLiteral(entity);
	}

	public void visit(ShortLiteral entity) {
		setLiteral(entity);
	}

	public void visit(DateLiteral entity) {
		setLiteral(entity);
	}

	public void visit(StringLiteral entity) {
		setLiteral(entity);
	}

	public void visit(VoidLiteral entity) {
		setResultIterator(iteratorFactory().constantIterator(BindingManagerFactory.instance.createVoid(), true)
				.withSourceEntity(entity));
	}

	public void visitExpression(Expression entity) {
		setResultIterator(iteratorFactory().templateInterpreterIterator(entity).withSourceEntity(entity));
	}

	protected IEntityIterator<?> compile(Expression entity) {
		entity.accept(this);
		return getResultIterator();
	}

	@Override
	public void visit(AdditionStep entity) {
		setResultIterator(MathUtils.additionStepIterator(compile(entity.getExpression())).withSourceEntity(entity));
	}

	@Override
	public void visit(SubtractionStep entity) {
		setResultIterator(MathUtils.subtractionStepIterator(compile(entity.getExpression())).withSourceEntity(entity));
	}

	@Override
	public void visit(MultiplicationStep entity) {
		setResultIterator(
				MathUtils.multiplicationStepIterator(compile(entity.getExpression())).withSourceEntity(entity));
	}

	@Override
	public void visit(DivisionStep entity) {
		setResultIterator(MathUtils.divisionStepIterator(compile(entity.getExpression())).withSourceEntity(entity));
	}

	@Override
	public void visit(RemainderStep entity) {
		setResultIterator(MathUtils.remainderStepIterator(compile(entity.getExpression())).withSourceEntity(entity));
	}

	@Override
	public void visit(EqualsStep entity) {
		setResultIterator(MathUtils.equalsStepIterator(compile(entity.getExpression())).withSourceEntity(entity));
	}

	@Override
	public void visit(NotEqualsStep entity) {
		setResultIterator(MathUtils.notEqualsStepIterator(compile(entity.getExpression())).withSourceEntity(entity));
	}

	@Override
	public void visit(LessThanStep entity) {
		setResultIterator(MathUtils.lessThanStepIterator(compile(entity.getExpression())).withSourceEntity(entity));
	}

	@Override
	public void visit(LessOrEqualsStep entity) {
		setResultIterator(MathUtils.lessOrEqualsStepIterator(compile(entity.getExpression())).withSourceEntity(entity));
	}

	@Override
	public void visit(GreaterThanStep entity) {
		setResultIterator(MathUtils.greaterThanStepIterator(compile(entity.getExpression())).withSourceEntity(entity));
	}

	@Override
	public void visit(GreaterOrEqualsStep entity) {
		setResultIterator(
				MathUtils.greaterOrEqualsStepIterator(compile(entity.getExpression())).withSourceEntity(entity));
	}

	@Override
	public void visit(Addition entity) {
		setResultIterator(MathUtils.additionIterator(compile(entity.getExp1()), compile(entity.getExp2()))
				.withSourceEntity(entity));
	}

	@Override
	public void visit(Subtraction entity) {
		setResultIterator(MathUtils.subtractionIterator(compile(entity.getExp1()), compile(entity.getExp2()))
				.withSourceEntity(entity));
	}

	@Override
	public void visit(Multiplication entity) {
		setResultIterator(MathUtils.multiplicationIterator(compile(entity.getExp1()), compile(entity.getExp2()))
				.withSourceEntity(entity));
	}

	@Override
	public void visit(Division entity) {
		setResultIterator(MathUtils.divisionIterator(compile(entity.getExp1()), compile(entity.getExp2()))
				.withSourceEntity(entity));
	}

	@Override
	public void visit(Remainder entity) {
		setResultIterator(MathUtils.remainderIterator(compile(entity.getExp1()), compile(entity.getExp2()))
				.withSourceEntity(entity));
	}

	@Override
	public void visit(Equals entity) {
		setResultIterator(MathUtils.equalsIterator(compile(entity.getExp1()), compile(entity.getExp2()))
				.withSourceEntity(entity));
	}

	@Override
	public void visit(NotEquals entity) {
		setResultIterator(MathUtils.notEqualsIterator(compile(entity.getExp1()), compile(entity.getExp2()))
				.withSourceEntity(entity));
	}

	@Override
	public void visit(LessThan entity) {
		setResultIterator(MathUtils.lessThanIterator(compile(entity.getExp1()), compile(entity.getExp2()))
				.withSourceEntity(entity));
	}

	@Override
	public void visit(LessOrEquals entity) {
		setResultIterator(MathUtils.lessOrEqualsIterator(compile(entity.getExp1()), compile(entity.getExp2()))
				.withSourceEntity(entity));
	}

	@Override
	public void visit(GreaterThan entity) {
		setResultIterator(MathUtils.greaterThanIterator(compile(entity.getExp1()), compile(entity.getExp2()))
				.withSourceEntity(entity));
	}

	@Override
	public void visit(GreaterOrEquals entity) {
		setResultIterator(MathUtils.greaterOrEqualsIterator(compile(entity.getExp1()), compile(entity.getExp2()))
				.withSourceEntity(entity));
	}

	@Override
	public void visit(Singleton entity) {
		entity.getExpression().accept(this);
	}
}