/**
 * Copyright 2004-2019 Riccardo Solmi. All rights reserved.
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
import org.whole.lang.comparators.IdentityExecutableComparator;
import org.whole.lang.evaluators.AbstractDelegatingNestedTrySupplierEvaluator;
import org.whole.lang.evaluators.ChooseByTypeEvaluator;
import org.whole.lang.evaluators.FilterByIndexRangeEvaluator;
import org.whole.lang.evaluators.FilterEvaluator;
import org.whole.lang.evaluators.SelectEvaluator;
import org.whole.lang.exceptions.WholeIllegalArgumentException;
import org.whole.lang.executables.DistinctScope;
import org.whole.lang.executables.EmptyExecutable;
import org.whole.lang.executables.IExecutable;
import org.whole.lang.executables.Placement;
import org.whole.lang.factories.GenericEntityFactory;
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
	private DistinctScope distinctScope;
	private IExecutable filterByIndexExecutable;
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
				setExecutableResult(executableFactory().createEmpty().withSourceEntity(adaptee));
				return false;
			case CommonsEntityDescriptorEnum.StageDownFragment_ord:
				setExecutableResult(executableFactory().createTemplateInterpreter(
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

		setExecutableResult(
				executableFactory().createFilter(
						executableFactory().createConstant(entity, true).withSourceEntity(entity),
								executableFactory().createAsVariable(queryName))
						.withSourceEntity(entity));
	}

	@Override
	public void visit(Call entity) {
		Expressions arguments = entity.getArguments();

		IExecutable[] argsExecutables = new IExecutable[arguments.wSize()];
		for (int i = 0, size = arguments.wSize(); i < size; i++) {
			arguments.get(i).accept(this);
			argsExecutables[i] = getExecutableResult();
		}

		setExecutableResult(executableFactory().createCall(stringValue(entity.getName()), argsExecutables).withSourceEntity(entity));
	}

	@Override
	public void visit(Scope entity) {
		namesExp = Collections.emptySet();
		entity.getLocalNames().accept(this);
		Set<String> localNames = namesExp;

		entity.getExpression().accept(this);

		boolean withFreshNames = !(entity.getLocalNames() instanceof ScopeNames);
		if (!withFreshNames || !localNames.isEmpty())
			setExecutableResult(executableFactory().createScope(getExecutableResult(), null, localNames, withFreshNames).withSourceEntity(entity));
	}

	@Override
	public void visit(Path entity) {
		DistinctScope oldDistinctScope = distinctScope;
		distinctScope = null;

		int nestedIndex = entity.wSize() - 1;
		IExecutable[] nestedExecutables = new IExecutable[nestedIndex >= 0 ? nestedIndex : 0];
		nestedIndex--;
		for (int i = 0; i < entity.wSize() - 1; i++) {
			entity.get(i).accept(this);
			nestedExecutables[nestedIndex - i] = getExecutableResult();
		}
		entity.get(entity.wSize() - 1).accept(this);

		setExecutableResult(
				executableFactory().createCompose(getExecutableResult(), nestedExecutables).withSourceEntity(entity));

		if (distinctScope != null)
			setExecutableResult(distinctScope.withExecutable(getExecutableResult()));

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
				IExecutable ri = executableFactory().createChoose(languageKit);
				ChooseByTypeEvaluator chooseEvaluator = (ChooseByTypeEvaluator) ri.undecoratedExecutable();

				for (Entry<EntityDescriptor<?>, Expression> entry : typeMap.entrySet()) {
					Set<String> oldDeclaredNames = declaredNames;

					entry.getValue().accept(this);
					chooseEvaluator.setCase(entry.getKey(), getExecutableResult());

					declaredNames = oldDeclaredNames;
				}

				setExecutableResult(ri.withSourceEntity(entity));

			} else {
				IExecutable[] executableChain = new IExecutable[size];

				for (int i = 0; i < size; i++) {
					entity.get(i).accept(this);
					executableChain[i] = getExecutableResult();
				}

				setExecutableResult(executableFactory().createChoose(executableChain).withSourceEntity(entity));
			}
		}
	}

	@Override
	public void visit(Block entity) {
		int size = entity.wSize();
		if (size == 1)
			entity.get(0).accept(this);
		else {
			IExecutable[] executableChain = new IExecutable[size];

			for (int i = 0; i < size; i++) {
				entity.get(i).accept(this);
				executableChain[i] = getExecutableResult();
			}

			setExecutableResult(executableFactory().createBlock(executableChain).withSourceEntity(entity));
		}
	}

	@Override
	public void visit(Sequence entity) {
		int size = entity.wSize();
		if (size == 1)
			entity.get(0).accept(this);// FIXME nested scope is exposed
		else {
			IExecutable[] executableChain = new IExecutable[size];

			for (int i = 0; i < size; i++) {
				entity.get(i).accept(this);
				executableChain[i] = getExecutableResult();
			}

			setExecutableResult(executableFactory().createSequence(executableChain).withSourceEntity(entity));
		}
	}

	@Override
	public void visit(Prune entity) {
		entity.getPredicate().accept(this);
	}

	@Override
	public void visit(Filter entity) {
		IExecutable oldFilterByIndexExecutable = filterByIndexExecutable;
		filterByIndexExecutable = null;
		DistinctScope oldDistinctScope = distinctScope;
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
				setExecutableResult(executableFactory().createFeatureByIndex(relativeIndex).withSourceEntity(entity));
				optimizeIndexTest = true;
			} else if (Matcher.matchImpl(QueriesEntityDescriptorEnum.AtIndexTest, predicate)) {
				int index = predicate.wIntValue();
				setExecutableResult(executableFactory().createFeatureByIndex(index).withSourceEntity(entity));
				optimizeIndexTest = true;
			} else if (Matcher.matchImpl(QueriesEntityDescriptorEnum.IndexRangeTest, predicate)) {
				int relativeStartIndex = ((IndexRangeTest) predicate).getStartIndex().getValue();
				IntLiteral relativeEndIndexEntity = ((IndexRangeTest) predicate).getEndIndex();
				int relativeEndIndex = EntityUtils.isResolver(relativeEndIndexEntity) ? -1
						: relativeEndIndexEntity.getValue();
				setExecutableResult(executableFactory().createChildRange(relativeStartIndex, relativeEndIndex)
						.withSourceEntity(entity));
				optimizeIndexTest = true;
			}
		}

		if (!optimizeIndexTest) {
			setResult(null);
			predicate.accept(this);
			IExecutable queryPredicateExecutable = getExecutableResult();

			expression.accept(this);
			if (getExecutableResult().undecoratedExecutable() instanceof EmptyExecutable)
				setExecutableResult(executableFactory().createSelf().withSourceEntity(entity));

			if (filterByIndexExecutable != null) {
				IExecutable fiUndecorated = filterByIndexExecutable.undecoratedExecutable();

				((FilterByIndexRangeEvaluator) fiUndecorated).withExecutable(getExecutableResult());
				setExecutableResult(filterByIndexExecutable);

				if (canFilterByIndex) {
					// ((FilterByIndexRangeEvaluator) fiUndecorated).withStartIndex(startIndex);
					((FilterByIndexRangeEvaluator) fiUndecorated).withEndIndex(endIndex);
				}
			}

			if (distinctScope != null && !(EntityUtils.hasParent(entity)
					&& Matcher.match(QueriesEntityDescriptorEnum.Path, entity.wGetParent())))
				setExecutableResult(distinctScope.withExecutable(getExecutableResult()));

			if (!(queryPredicateExecutable.undecoratedExecutable() instanceof EmptyExecutable)) {
				IExecutable ri = executableFactory().createFilter(getExecutableResult(), queryPredicateExecutable);
				if (usePruneFilter) {
					IExecutable riUndecorated = ri.undecoratedExecutable();
					((FilterEvaluator) riUndecorated).withAutoPrune(usePruneFilter);
				}
				setExecutableResult(ri.withSourceEntity(entity));
			}
		}

		startIndex = oldStartIndex;
		endIndex = oldEndIndex;
		canFilterByIndex = oldCanFilterByIndex;
		filterByIndexExecutable = oldFilterByIndexExecutable;
		distinctScope = oldDistinctScope;
	}

	@Override
	public void visit(AspectStep entity) {
		setExecutableResult(executableFactory().createAspect().withSourceEntity(entity));
	}

	@Override
	public void visit(AdjacentStep entity) {
		setExecutableResult(executableFactory().createAdjacent().withSourceEntity(entity));
	}

	@Override
	public void visit(ReachableStep entity) {
		setExecutableResult(executableFactory().createReachable(false).withSourceEntity(entity));
	}

	@Override
	public void visit(ReachableOrSelfStep entity) {
		setExecutableResult(executableFactory().createReachable(true).withSourceEntity(entity));
	}

	@Override
	public void visit(InverseAdjacentStep entity) {
		setExecutableResult(executableFactory().createInverseAdjacent().withSourceEntity(entity));
	}

	@Override
	public void visit(InverseReachableStep entity) {
		setExecutableResult(executableFactory().createInverseReachable(false).withSourceEntity(entity));
	}

	@Override
	public void visit(InverseReachableOrSelfStep entity) {
		setExecutableResult(executableFactory().createInverseReachable(true).withSourceEntity(entity));
	}

	@Override
	public void visit(RootStep entity) {
		setExecutableResult(executableFactory().createRoot().withSourceEntity(entity));
	}

	@Override
	public void visit(FragmentRootStep entity) {
		setExecutableResult(executableFactory().createFragmentRoot().withSourceEntity(entity));
	}

	@Override
	public void visit(SelfStep entity) {
		setExecutableResult(executableFactory().createSelf().withSourceEntity(entity));
	}

	@Override
	public void visit(FeatureStep entity) {
		setExecutableResult(executableFactory().createFeatureByName(entity.getValue()).withSourceEntity(entity));
	}

	@Override
	public void visit(ChildStep entity) {
		setExecutableResult(executableFactory().createChild().withSourceEntity(entity));
	}

	@Override
	public void visit(DescendantStep entity) {
		setExecutableResult(executableFactory().createDescendant().withSourceEntity(entity));
	}

	@Override
	public void visit(DescendantOrSelfStep entity) {
		setExecutableResult(executableFactory().createDescendantOrSelf().withSourceEntity(entity));
	}

	@Override
	public void visit(FollowingSiblingStep entity) {
		setExecutableResult(executableFactory().createFollowingSibling().withSourceEntity(entity));
	}

	@Override
	public void visit(FollowingSiblingOrSelfStep entity) {
		setExecutableResult(executableFactory().createFollowingSiblingOrSelf().withSourceEntity(entity));
	}

	@Override
	public void visit(FollowingStep entity) {
		setExecutableResult(executableFactory().createFollowing().withSourceEntity(entity));
	}

	@Override
	public void visit(FollowingOrSelfStep entity) {
		setExecutableResult(executableFactory().createFollowingOrSelf().withSourceEntity(entity));
	}

	@Override
	public void visit(ParentStep entity) {
		setExecutableResult(executableFactory().createParent().withSourceEntity(entity));
	}

	@Override
	public void visit(AncestorStep entity) {
		setExecutableResult(executableFactory().createAncestor().withSourceEntity(entity));
	}

	@Override
	public void visit(AncestorOrSelfStep entity) {
		setExecutableResult(executableFactory().createAncestorOrSelf().withSourceEntity(entity));
	}

	@Override
	public void visit(PrecedingSiblingStep entity) {
		setExecutableResult(executableFactory().createPrecedingSibling().withSourceEntity(entity));
	}

	@Override
	public void visit(PrecedingSiblingOrSelfStep entity) {
		setExecutableResult(executableFactory().createPrecedingSiblingOrSelf().withSourceEntity(entity));
	}

	@Override
	public void visit(PrecedingStep entity) {
		setExecutableResult(executableFactory().createPreceding().withSourceEntity(entity));
	}

	@Override
	public void visit(PrecedingOrSelfStep entity) {
		setExecutableResult(executableFactory().createPrecedingOrSelf().withSourceEntity(entity));
	}

	@Override
	public void visit(Reverse entity) {
		ReversibleStep step = entity.getExpression();

		IExecutable executable = null;

		if (step.wGetLanguageKit().getURI().equals(QueriesLanguageKit.URI)) {
			switch (step.wGetEntityOrd()) {
			case QueriesEntityDescriptorEnum.ChildStep_ord:
				executable = executableFactory().createChildReverse();
				break;
			case QueriesEntityDescriptorEnum.AdjacentStep_ord:
				executable = executableFactory().createAdjacentReverse();
				break;
			case QueriesEntityDescriptorEnum.DescendantStep_ord:
				executable = executableFactory().createDescendantReverse();
				break;
			case QueriesEntityDescriptorEnum.DescendantOrSelfStep_ord:
				executable = executableFactory().createDescendantOrSelfReverse();
				break;
			case QueriesEntityDescriptorEnum.FollowingSiblingStep_ord:
				executable = executableFactory().createFollowingSiblingReverse();
				break;
			case QueriesEntityDescriptorEnum.FollowingSiblingOrSelfStep_ord:
				executable = executableFactory().createFollowingSiblingOrSelfReverse();
				break;
			case QueriesEntityDescriptorEnum.PrecedingSiblingStep_ord:
				executable = executableFactory().createPrecedingSiblingReverse();
				break;
			case QueriesEntityDescriptorEnum.PrecedingSiblingOrSelfStep_ord:
				executable = executableFactory().createPrecedingSiblingOrSelfReverse();
				break;
			case QueriesEntityDescriptorEnum.AncestorStep_ord:
				executable = executableFactory().createAncestorReverse();
				break;
			case QueriesEntityDescriptorEnum.AncestorOrSelfStep_ord:
				executable = executableFactory().createAncestorOrSelfReverse();
				break;
			}
		}

		if (executable != null)
			setExecutableResult(executable.withSourceEntity(entity));
		else
			throw new WholeIllegalArgumentException("Non reversible step").withSourceEntity(entity);
	}

	@Override
	public void visit(VariableRefStep entity) {
		String varName = entity.getValue();
    	setExecutableResult((varName.equals(IBindingManager.SELF) ?
    			executableFactory().createSelf() : executableFactory().createVariable(varName)).withSourceEntity(entity));
	}

	@Override
	public void visit(VariableTest entity) {
		String name = entity.getValue();
		declaredNames.add(name);

		setExecutableResult(executableFactory().createAsVariable(name).withSourceEntity(entity));
	}

	@Override
	public void visit(CartesianProduct entity) {
		IExecutable[] executables = new IExecutable[entity.wSize()];
		for (int i = 0; i < entity.wSize(); i++) {
			entity.get(i).accept(this);
			executables[i] = getExecutableResult();
		}

		setExecutableResult(executableFactory().createCartesianProduct(executables).withSourceEntity(entity));
	}

	@Override
	public void visit(PointwiseProduct entity) {
		IExecutable[] executables = new IExecutable[entity.wSize()];

		for (int i = 0; i < entity.wSize(); i++) {
			entity.get(i).accept(this);
			executables[i] = getExecutableResult();
		}

		setExecutableResult(executableFactory().createPointwiseProduct(executables).withSourceEntity(entity));
	}

	@Override
	public void visit(Clone entity) {
		entity.getFromClause().accept(this);
		IExecutable fromExecutable = getExecutableResult();

		setExecutableResult(executableFactory().createCloneReplacing(fromExecutable).withSourceEntity(entity));
	}

	@Override
	public void visit(Delete entity) {
		entity.getFromClause().accept(this);
		IExecutable fromExecutable = getExecutableResult();

		setExecutableResult(executableFactory().createDelete(fromExecutable).withSourceEntity(entity));
	}

	@Override
	public void visit(Update entity) {
		entity.getFromClause().accept(this);
		IExecutable fromExecutable = getExecutableResult();

		setExecutableResult(executableFactory().createPointwiseUpdate(
				fromExecutable, executableFactory().createRepeatedSelf().withSourceEntity(entity))
				.withSourceEntity(entity));
	}

	@Override
	public void visit(CartesianUpdate entity) {
		entity.getFromClause().accept(this);
		IExecutable fromExecutable = getExecutableResult();

		setExecutableResult(executableFactory().createEmpty().withSourceEntity(entity));
		entity.getValuesClause().accept(this);
		IExecutable valuesExecutable = getExecutableResult();

		setExecutableResult(executableFactory().createCartesianUpdate(
				fromExecutable, valuesExecutable).withSourceEntity(entity));
	}

	@Override
	public void visit(PointwiseUpdate entity) {
		entity.getFromClause().accept(this);
		IExecutable fromExecutable = getExecutableResult();

		setExecutableResult(executableFactory().createEmpty().withSourceEntity(entity));
		entity.getValuesClause().accept(this);
		IExecutable valuesExecutable = getExecutableResult();

		setExecutableResult(executableFactory().createPointwiseUpdate(
				fromExecutable, valuesExecutable).withSourceEntity(entity));
	}

	@Override
	public void visit(Insert entity) {
		entity.getFromClause().accept(this);
		IExecutable fromExecutable = getExecutableResult();

		Placement placement = Placement.valueOf(entity.getPlacement().getValue().getName());
		setExecutableResult(executableFactory().createPointwiseInsert(
				fromExecutable,
				executableFactory().createRepeatedSelf().withSourceEntity(entity), placement)
				.withSourceEntity(entity));
	}

	@Override
	public void visit(CartesianInsert entity) {
		entity.getFromClause().accept(this);
		IExecutable fromExecutable = getExecutableResult();

		setExecutableResult(executableFactory().createEmpty().withSourceEntity(entity));
		entity.getValuesClause().accept(this);
		IExecutable valuesExecutable = getExecutableResult();

		Placement placement = Placement.valueOf(entity.getPlacement().getValue().getName());
		setExecutableResult(executableFactory().createCartesianInsert(
				fromExecutable, valuesExecutable, placement)
				.withSourceEntity(entity));
	}

	@Override
	public void visit(PointwiseInsert entity) {
		entity.getFromClause().accept(this);
		IExecutable fromExecutable = getExecutableResult();

		setExecutableResult(executableFactory().createEmpty().withSourceEntity(entity));
		entity.getValuesClause().accept(this);
		IExecutable valuesExecutable = getExecutableResult();

		Placement placement = Placement.valueOf(entity.getPlacement().getValue().getName());
		setExecutableResult(executableFactory().createPointwiseInsert(
				fromExecutable, valuesExecutable, placement)
				.withSourceEntity(entity));
	}

	@Override
	public void visit(Select entity) {
		Set<String> oldDeclaredNames = declaredNames;
		Set<String> namesToBound = declaredNames = new HashSet<String>();

		setResult(null);
		entity.getFromClause().accept(this);
		IExecutable fromExecutable = getExecutableResult();

		setExecutableResult(executableFactory().createEmpty().withSourceEntity(entity));
		entity.getWhereClause().accept(this);
		IExecutable whereExecutable = getExecutableResult();

		declaredNames = oldDeclaredNames;

		entity.getSelectClause().accept(this);
		IExecutable selectExecutable = getExecutableResult();

		templateNames = Matcher.vars(entity.getSelectClause(), true);
		namesExp = declaredNames = namesToBound;
		useNamesComplement = false;
		entity.getClearClause().accept(this);

		IExecutable si = executableFactory().createSelect(selectExecutable, fromExecutable, whereExecutable);
		((SelectEvaluator) si.undecoratedExecutable()).withNamesToBind(namesExp).withNamesComplement(useNamesComplement);
		setExecutableResult(si.withSourceEntity(entity));

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
		IExecutable fromExecutable = getExecutableResult();

		declaredNames = oldDeclaredNames;

		entity.getExpression().accept(this);
		IExecutable selectExecutable = getExecutableResult();

		declaredNames = namesToBound;

		setExecutableResult(executableFactory().createFor(fromExecutable, selectExecutable).withSourceEntity(entity));

		declaredNames = oldDeclaredNames;
	}

	@Override
	public void visit(If entity) {
		Set<String> oldDeclaredNames = declaredNames;
		Set<String> namesToBound = declaredNames = new HashSet<String>();

		setResult(null);
		entity.getPredicate().accept(this);
		IExecutable conditionExecutable = getExecutableResult();

		declaredNames = oldDeclaredNames;

		entity.getExpression().accept(this);
		
		if (!(conditionExecutable.undecoratedExecutable() instanceof EmptyExecutable)) {
			IExecutable selectExecutable = getExecutableResult();
	
			declaredNames = namesToBound;
	
			setExecutableResult(executableFactory().createIf(conditionExecutable, selectExecutable).withSourceEntity(entity));
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
		IExecutable[] tupleExecutables = new IExecutable[entity.wSize()];
		for (int i = 0; i < entity.wSize(); i++) {
			entity.get(i).accept(this);
			tupleExecutables[i] = getExecutableResult();
		}
		setExecutableResult(executableFactory().createTupleFactory(tupleExecutables).withSourceEntity(entity));
	}

	@Override
	public void visit(One entity) {
		entity.getFromClause().accept(this);
		IExecutable fromClause = getExecutableResult();
		entity.getWhereClause().accept(this);

		IExecutable satisfiesClause = getExecutableResult();
		if (satisfiesClause.undecoratedExecutable() instanceof EmptyExecutable)
			satisfiesClause = executableFactory().createConstant(BindingManagerFactory.instance.createValue(true), false);

		setExecutableResult(executableFactory().createOne(fromClause, satisfiesClause).withSourceEntity(entity));
	}

	@Override
	public void visit(Some entity) {
		entity.getFromClause().accept(this);
		IExecutable fromClause = getExecutableResult();
		entity.getWhereClause().accept(this);

		IExecutable satisfiesClause = getExecutableResult();
		if (satisfiesClause.undecoratedExecutable() instanceof EmptyExecutable)
			setExecutableResult(executableFactory().createSome(fromClause).withSourceEntity(entity));			
		else
			setExecutableResult(executableFactory().createSome(fromClause, satisfiesClause).withSourceEntity(entity));
	}

	@Override
	public void visit(Every entity) {
		entity.getFromClause().accept(this);
		IExecutable fromClause = getExecutableResult();
		entity.getWhereClause().accept(this);

		IExecutable satisfiesClause = getExecutableResult();
		setExecutableResult(executableFactory().createEvery(fromClause, satisfiesClause).withSourceEntity(entity));
	}

	@Override
	public void visit(KindTest entity) {
		Value kind = entity.getValue();
		switch (kind.getOrdinal()) {
		case KindTestEnum.IMPL_ord:
			setExecutableResult(executableFactory().createIsImpl().withSourceEntity(entity));
			break;
		case KindTestEnum.FRAGMENT_ord:
			setExecutableResult(executableFactory().createIsFragment().withSourceEntity(entity));
			break;
		case KindTestEnum.VARIABLE_ord:
			setExecutableResult(executableFactory().createIsVariable().withSourceEntity(entity));
			break;
		case KindTestEnum.RESOLVER_ord:
			setExecutableResult(executableFactory().createIsResolver().withSourceEntity(entity));
			break;
		default:
			EntityKinds ekind = EntityKinds.valueOf(kind.getName());
			setExecutableResult(executableFactory().createHasKind(ekind).withSourceEntity(entity));
		}
	}
	@Override
	public void visit(CompositeKindTest entity) {
		CompositeKindTestEnum.Value kind = entity.getValue();
		setExecutableResult(executableFactory().createHasCompositeKind(CompositeKinds.valueOf(kind.getName())));
	}
	@Override
	public void visit(DataKindTest entity) {
		DataKindTestEnum.Value kind = entity.getValue();
		setExecutableResult(executableFactory().createHasDataKind(DataKinds.valueOf(kind.getName())));
	}

	@Override
	public void visit(StageTest entity) {
		StageTestEnum.Value stage = entity.getValue();
		switch (stage.getOrdinal()) {
		case StageTestEnum.HOST_STAGE_ord:
			setExecutableResult(executableFactory().createAtHostStage().withSourceEntity(entity));
			break;
		case StageTestEnum.HOST_STAGE_0_ord:
			setExecutableResult(executableFactory().createAtStage(0).withSourceEntity(entity));
			break;
		case StageTestEnum.TEMPLATE_STAGE_1_ord:
			setExecutableResult(executableFactory().createAtStage(1).withSourceEntity(entity));
			break;
		case StageTestEnum.TEMPLATE_STAGE_ord:
			setExecutableResult(executableFactory().createAtTemplateStage().withSourceEntity(entity));
			break;
		}
	}

	@Override
	public void visit(StageVariableTest entity) {
		setExecutableResult(executableFactory().createAtStageVariable(entity.getValue()).withSourceEntity(entity));
	}

	@Override
	public void visit(LanguageVariableTest entity) {
		setExecutableResult(executableFactory().createLanguageVariable(entity.getValue()).withSourceEntity(entity));
	}

	@Override
	public void visit(TypeVariableTest entity) {
		setExecutableResult(executableFactory().createTypeVariable(entity.getValue()).withSourceEntity(entity));
	}

	@Override
	public void visit(SubtypeVariableTest entity) {
		setExecutableResult(executableFactory().createLanguageSubtypeOfVariable(entity.getValue()).withSourceEntity(entity));
	}

	@Override
	public void visit(SupertypeVariableTest entity) {
		setExecutableResult(executableFactory().createLanguageSupertypeOfVariable(entity.getValue()).withSourceEntity(entity));
	}

	@Override
	public void visit(ExtendedSubtypeVariableTest entity) {
		setExecutableResult(executableFactory().createExtendedLanguageSubtypeOfVariable(entity.getValue()).withSourceEntity(entity));
	}

	@Override
	public void visit(ExtendedSupertypeVariableTest entity) {
		setExecutableResult(executableFactory().createExtendedLanguageSupertypeOfVariable(entity.getValue()).withSourceEntity(entity));
	}

	@Override
	public void visit(LanguageTest entity) {
		setExecutableResult(executableFactory().createIsLanguage(entity.getValue()).withSourceEntity(entity));
	}

	@Override
	public void visit(TypeTest entity) {
		setExecutableResult(executableFactory().createHasType(entity.getValue()).withSourceEntity(entity));
	}

	@Override
	public void visit(SubtypeTest entity) {
		setExecutableResult(executableFactory().createIsLanguageSubtypeOf(entity.getValue()).withSourceEntity(entity));
	}

	@Override
	public void visit(SupertypeTest entity) {
		setExecutableResult(executableFactory().createIsLanguageSupertypeOf(entity.getValue()).withSourceEntity(entity));
	}

	@Override
	public void visit(ExtendedSubtypeTest entity) {
		setExecutableResult(executableFactory().createIsExtendedLanguageSubtypeOf(entity.getValue()).withSourceEntity(entity));
	}

	@Override
	public void visit(ExtendedSupertypeTest entity) {
		setExecutableResult(executableFactory().createIsExtendedLanguageSupertypeOf(entity.getValue()).withSourceEntity(entity));
	}

	@Override
	public void visit(MatchTest entity) {
		Expression e = entity.getExpression();
		e.accept(this);
		setExecutableResult(executableFactory().createMatchInScope(getExecutableResult()).withSourceEntity(entity));
	}

	@Override
	public void visit(PointwiseEquals entity) {
		entity.getPexp1().accept(this);
		IExecutable exp1Executable = getExecutableResult();
		entity.getPexp2().accept(this);
		
		setExecutableResult(executableFactory().createPointwiseEquals(exp1Executable, getExecutableResult()).withSourceEntity(entity));
	}

	@Override
	public void visit(AtTypeTest entity) {
		setExecutableResult(executableFactory().createAtType(entity.getValue()).withSourceEntity(entity));
	}

	@Override
	public void visit(AtFeatureTest entity) {
		setExecutableResult(executableFactory().createAtFeature(entity.getValue()).withSourceEntity(entity));
	}

	@Override
	public void visit(AtIndexTest entity) {
		int index = entity.getIndex().getValue();

		setExecutableResult(executableFactory().createAtIndex(index).withSourceEntity(entity));
	}

	@Override
	public void visit(IndexVariableTest entity) {
		String varName = entity.getValue();
		declaredNames.add(varName);

		if (filterByIndexExecutable == null) {
			filterByIndexExecutable = executableFactory().createFilterByIndexRange();
			filterByIndexExecutable.withSourceEntity(entity);
		}

		setExecutableResult(executableFactory().createIterationIndexVariable(filterByIndexExecutable, varName).withSourceEntity(entity));

		updateIndexRange(0, Integer.MAX_VALUE);
	}

	@Override
	public void visit(IndexTest entity) {
		if (filterByIndexExecutable == null) {
			filterByIndexExecutable = executableFactory().createFilterByIndexRange();
			filterByIndexExecutable.withSourceEntity(entity);
		}

		int index = entity.getIndex().getValue();
		setExecutableResult(executableFactory().createIterationIndex(filterByIndexExecutable, index).withSourceEntity(entity));

		updateIndexRange(index, index);
	}

	@Override
	public void visit(IndexRangeTest entity) {
		if (filterByIndexExecutable == null) {
			filterByIndexExecutable = executableFactory().createFilterByIndexRange();
			filterByIndexExecutable.withSourceEntity(entity);
		}

		int startIndexValue = entity.getStartIndex().getValue();
		int endIndexValue;
		IntLiteral endIndex = entity.getEndIndex();
		if (Matcher.matchImpl(QueriesEntityDescriptorEnum.IntLiteral, endIndex))
			endIndexValue = endIndex.getValue();
		else
			endIndexValue = Integer.MAX_VALUE;

		setExecutableResult(executableFactory().createIterationIndexRange(filterByIndexExecutable, startIndexValue, endIndexValue).withSourceEntity(entity));

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
		setExecutableResult(new PredicateWrapperEvaluator(entity.getValue().withSourceEntity(entity)));
	}
	public static class PredicateWrapperEvaluator extends AbstractDelegatingNestedTrySupplierEvaluator {
		protected IVisitor queryPredicate;

		public PredicateWrapperEvaluator(IVisitor queryPredicate) {
			super();
			this.queryPredicate = queryPredicate;
		}

		@Override
		public IExecutable clone(ICloneContext cc) {
			PredicateWrapperEvaluator clone = (PredicateWrapperEvaluator) super.clone(cc);
			clone.queryPredicate = cc.differentiate(queryPredicate);
			return clone;
		}

		protected void setProducersBindings(IBindingManager bindings) {
			super.setProducersBindings(bindings);
			queryPredicate.setBindings(bindings);
		}

		public IEntity get() {
			queryPredicate.setBindings(getBindings());
			return BindingManagerFactory.instance.createValue(Matcher.match(queryPredicate, selfEntity));
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
			distinctScope = executableFactory().createDistinctScope();

		distinctScope.withComparator(comparator);
		setExecutableResult(distinctScope.distinctExecutable().withSourceEntity(entity));
		comparator = oldComparator;
	}

	@Override
	public void visit(And entity) {
		visitFrom(entity, 0);
	}

	private void visitFrom(And entity, int from) {
		int size = entity.wSize() - from;
		IExecutable[] argsExecutables = new IExecutable[size];
		for (int i = from; i < size; i++) {
			entity.get(i).accept(this);
			argsExecutables[i] = getExecutableResult();
		}

		setExecutableResult(executableFactory().createAnd(argsExecutables).withSourceEntity(entity));
	}

	@Override
	public void visit(Or entity) {
		boolean canFilterByIndexResult = canFilterByIndex;

		int size = entity.wSize();
		IExecutable[] argsExecutables = new IExecutable[size];
		for (int i = 0; i < size; i++) {
			canFilterByIndex = false;
			entity.get(i).accept(this);
			argsExecutables[i] = getExecutableResult();
			canFilterByIndexResult &= !canFilterByIndex;
		}

		setExecutableResult(executableFactory().createOr(argsExecutables).withSourceEntity(entity));

		canFilterByIndex = canFilterByIndexResult;
	}

	@Override
	public void visit(Not entity) {
		entity.getPredicate().accept(this);
		setExecutableResult(executableFactory().createNot(getExecutableResult()).withSourceEntity(entity));
	}

	@Override
	public void visit(IdentityComparator entity) {
		entity.getIdentity().accept(this);
		comparator = new IdentityExecutableComparator<IEntity>(getExecutableResult());
	}

	protected IEntityComparator<IEntity> comparator;

	@Override
	public void visit(Expressions entity) {
		IExecutable[] executableChain = new IExecutable[entity.wSize()];
		for (int i = 0; i < entity.wSize(); i++) {
			entity.get(i).accept(this);
			executableChain[i] = getExecutableResult();
		}
		this.executableChain = executableChain;
	}

	protected IExecutable[] executableChain;

	@Override
	public void visit(UnionAll entity) {
		entity.getExpressions().accept(this);
		setExecutableResult(executableFactory().createUnionAll(executableChain).withSourceEntity(entity));
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
		IExecutable ri = executableFactory().createUnion(comparator, executableChain);
		setExecutableResult(ri.withSourceEntity(entity));
		comparator = oldComparator;
	}

	@Override
	public void visit(Intersect entity) {
		IEntityComparator<IEntity> oldComparator = comparator;
		comparator = BusinessIdentityComparator.instance;
		visitCollectByExpression(entity);
		IExecutable ri = executableFactory().createIntersect(comparator, executableChain);
		setExecutableResult(ri.withSourceEntity(entity));
		comparator = oldComparator;
	}

	@Override
	public void visit(Except entity) {
		IEntityComparator<IEntity> oldComparator = comparator;
		comparator = BusinessIdentityComparator.instance;
		visitCollectByExpression(entity);
		IExecutable ri = executableFactory().createExcept(comparator, executableChain);
		setExecutableResult(ri.withSourceEntity(entity));
		comparator = oldComparator;
	}

	protected void setLiteral(IEntity entity) {
		setExecutableResult(
				executableFactory().createConstant(BindingManagerFactory.instance.createSpecificValue(entity), true)
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
		setExecutableResult(executableFactory().createConstant(BindingManagerFactory.instance.createVoid(), true)
				.withSourceEntity(entity));
	}

	protected IExecutable compile(Expression entity) {
		entity.accept(this);
		return getExecutableResult();
	}

	@Override
	public void visit(AdditionStep entity) {
		setExecutableResult(MathUtils.createAdditionStep(compile(entity.getExpression())).withSourceEntity(entity));
	}

	@Override
	public void visit(SubtractionStep entity) {
		setExecutableResult(MathUtils.createSubtractionStep(compile(entity.getExpression())).withSourceEntity(entity));
	}

	@Override
	public void visit(MultiplicationStep entity) {
		setExecutableResult(
				MathUtils.createMultiplicationStep(compile(entity.getExpression())).withSourceEntity(entity));
	}

	@Override
	public void visit(DivisionStep entity) {
		setExecutableResult(MathUtils.createDivisionStep(compile(entity.getExpression())).withSourceEntity(entity));
	}

	@Override
	public void visit(RemainderStep entity) {
		setExecutableResult(MathUtils.createRemainderStep(compile(entity.getExpression())).withSourceEntity(entity));
	}

	@Override
	public void visit(EqualsStep entity) {
		setExecutableResult(MathUtils.createEqualsStep(compile(entity.getExpression())).withSourceEntity(entity));
	}

	@Override
	public void visit(NotEqualsStep entity) {
		setExecutableResult(MathUtils.createNotEqualsStep(compile(entity.getExpression())).withSourceEntity(entity));
	}

	@Override
	public void visit(LessThanStep entity) {
		setExecutableResult(MathUtils.createLessThanStep(compile(entity.getExpression())).withSourceEntity(entity));
	}

	@Override
	public void visit(LessOrEqualsStep entity) {
		setExecutableResult(MathUtils.createLessOrEqualsStep(compile(entity.getExpression())).withSourceEntity(entity));
	}

	@Override
	public void visit(GreaterThanStep entity) {
		setExecutableResult(MathUtils.createGreaterThanStep(compile(entity.getExpression())).withSourceEntity(entity));
	}

	@Override
	public void visit(GreaterOrEqualsStep entity) {
		setExecutableResult(
				MathUtils.createGreaterOrEqualsStep(compile(entity.getExpression())).withSourceEntity(entity));
	}

	@Override
	public void visit(Addition entity) {
		setExecutableResult(MathUtils.createAddition(compile(entity.getExp1()), compile(entity.getExp2()))
				.withSourceEntity(entity));
	}

	@Override
	public void visit(Subtraction entity) {
		setExecutableResult(MathUtils.createSubtraction(compile(entity.getExp1()), compile(entity.getExp2()))
				.withSourceEntity(entity));
	}

	@Override
	public void visit(Multiplication entity) {
		setExecutableResult(MathUtils.createMultiplication(compile(entity.getExp1()), compile(entity.getExp2()))
				.withSourceEntity(entity));
	}

	@Override
	public void visit(Division entity) {
		setExecutableResult(MathUtils.createDivision(compile(entity.getExp1()), compile(entity.getExp2()))
				.withSourceEntity(entity));
	}

	@Override
	public void visit(Remainder entity) {
		setExecutableResult(MathUtils.createRemainder(compile(entity.getExp1()), compile(entity.getExp2()))
				.withSourceEntity(entity));
	}

	@Override
	public void visit(Equals entity) {
		setExecutableResult(MathUtils.createEquals(compile(entity.getExp1()), compile(entity.getExp2()))
				.withSourceEntity(entity));
	}

	@Override
	public void visit(NotEquals entity) {
		setExecutableResult(MathUtils.createNotEquals(compile(entity.getExp1()), compile(entity.getExp2()))
				.withSourceEntity(entity));
	}

	@Override
	public void visit(LessThan entity) {
		setExecutableResult(MathUtils.createLessThan(compile(entity.getExp1()), compile(entity.getExp2()))
				.withSourceEntity(entity));
	}

	@Override
	public void visit(LessOrEquals entity) {
		setExecutableResult(MathUtils.createLessOrEquals(compile(entity.getExp1()), compile(entity.getExp2()))
				.withSourceEntity(entity));
	}

	@Override
	public void visit(GreaterThan entity) {
		setExecutableResult(MathUtils.createGreaterThan(compile(entity.getExp1()), compile(entity.getExp2()))
				.withSourceEntity(entity));
	}

	@Override
	public void visit(GreaterOrEquals entity) {
		setExecutableResult(MathUtils.createGreaterOrEquals(compile(entity.getExp1()), compile(entity.getExp2()))
				.withSourceEntity(entity));
	}

	@Override
	public void visit(Singleton entity) {
		entity.getExpression().accept(this);
	}
}