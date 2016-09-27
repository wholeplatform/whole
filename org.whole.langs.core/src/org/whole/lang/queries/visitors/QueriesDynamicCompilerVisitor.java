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
import org.whole.lang.bindings.ITransactionScope;
import org.whole.lang.commons.model.Variable;
import org.whole.lang.commons.parsers.CommonsDataTypePersistenceParser;
import org.whole.lang.commons.reflect.CommonsEntityDescriptorEnum;
import org.whole.lang.commons.reflect.CommonsLanguageKit;
import org.whole.lang.commons.visitors.CommonsInterpreterVisitor;
import org.whole.lang.comparators.BusinessIdentityComparator;
import org.whole.lang.comparators.IEntityComparator;
import org.whole.lang.comparators.IdentityIteratorComparator;
import org.whole.lang.factories.GenericEntityFactory;
import org.whole.lang.iterators.ChooseByTypeIterator;
import org.whole.lang.iterators.DistinctScope;
import org.whole.lang.iterators.FilterByIndexRangeIterator;
import org.whole.lang.iterators.IEntityIterator;
import org.whole.lang.iterators.IteratorFactory;
import org.whole.lang.matchers.GenericMatcherFactory;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.IEntity;
import org.whole.lang.model.adapters.IEntityAdapter;
import org.whole.lang.queries.codebase.IfWithTemplate;
import org.whole.lang.queries.codebase.IfWithTypeTest;
import org.whole.lang.queries.iterators.Placement;
import org.whole.lang.queries.iterators.QueriesIteratorFactory;
import org.whole.lang.queries.matchers.QueriesMatcherFactory;
import org.whole.lang.queries.model.*;
import org.whole.lang.queries.model.KindTestEnum.Value;
import org.whole.lang.queries.reflect.QueriesEntityDescriptorEnum;
import org.whole.lang.queries.reflect.QueriesLanguageKit;
import org.whole.lang.queries.util.MathUtils;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reflect.EntityKinds;
import org.whole.lang.reflect.ILanguageKit;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.util.EntityUtils;
import org.whole.lang.visitors.GenericTraversalFactory;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.visitors.MissingVariableException;

/**
 * @author Riccardo Solmi
 */
public class QueriesDynamicCompilerVisitor extends QueriesIdentityDefaultVisitor {
	private boolean useInheritedSemantics;
	private boolean useTemplateFactorySemantics = true;
	private Set<String> declaredNames = new HashSet<String>();
	private Set<String> templateNames = new HashSet<String>();
	private Set<String> namesExp = new HashSet<String>();
	private boolean useNamesComplement;
	private DistinctScope<IEntity> distinctScope;
	private FilterByIndexRangeIterator<IEntity> filterByIndexIterator;
	private boolean canFilterByIndex;
	private int startIndex;
	private int endIndex;

	public <E extends IEntity> IEntityIterator<E> getResultIterator() {
		return super.getResultIterator();
	}

	private void setResultPredicate(IVisitor queryPredicate) {
		setResult(BindingManagerFactory.instance.createValue(queryPredicate));
	}

	//TODO work in progress to support elimination of ExpressiontTest
	private IVisitor compilePredicate(Predicate predicate) {
		predicate.accept(this);
		
		if (isResultIterator()) {
			boolean hasMatchSemantics = true;

			return hasMatchSemantics ?
					GenericMatcherFactory.instance.match(getResultIterator()) :
						GenericMatcherFactory.evalTrue(predicate);
				
		} else
			return getResultPredicate();
	}
	private IVisitor getResultPredicate() {
		IEntity result = getResult();
		return result != null ? (IVisitor) result.wGetValue() : GenericTraversalFactory.instance.identity();
	}


	protected boolean useInheritedSemantics() {
		return useInheritedSemantics;
	}
	protected boolean useInheritedSemantics(boolean value) {
		boolean oldValue = useInheritedSemantics;
		useInheritedSemantics = value;
		return oldValue;
	}
	protected boolean useTemplateFactorySemantics() {
		return useTemplateFactorySemantics;
	}
	protected boolean useTemplateFactorySemantics(boolean value) {
		boolean oldValue = useTemplateFactorySemantics;
		if (!useInheritedSemantics())
			useTemplateFactorySemantics = value;
		return oldValue;
	}
	protected boolean useFactorySemantics(IEntity entity) {
		if (Matcher.match(QueriesEntityDescriptorEnum.Filter, entity)) {
			Filter filter = (Filter) entity;
			StepExpression exp = filter.getExpression();

			if (Matcher.match(QueriesEntityDescriptorEnum.VariableRefStep, exp) &&
					Matcher.match(QueriesEntityDescriptorEnum.VariableTest, filter.getPredicate()))
				return true;
			else
				return useFactorySemantics(exp);
		} else if (Matcher.match(QueriesEntityDescriptorEnum.Path, entity))
			return entity.wSize() == 0 ? false : useFactorySemantics(((Path) entity).get(0));
		else
			return EntityUtils.isStageUpFragment(entity) || EntityUtils.isSameStageFragment(entity) ||
				!entity.wGetLanguageKit().equals(ReflectionFactory.getLanguageKit(QueriesLanguageKit.URI, false, null)) ||
				Matcher.match(QueriesEntityDescriptorEnum.Tuple, entity);
	}

	@Override
	public boolean visitAdapter(IEntityAdapter entity) {
		IEntity adaptee = entity.wGetAdaptee(false);
		EntityDescriptor<?> adapteeEd = adaptee.wGetEntityDescriptor();
		if (adapteeEd.getLanguageKit().getURI().equals(CommonsLanguageKit.URI)) {
			switch (adapteeEd.getOrdinal()) {
			case CommonsEntityDescriptorEnum.Resolver_ord:
				setResultIterator(IteratorFactory.emptyIterator().withSourceEntity(adaptee));
				return false;
			case CommonsEntityDescriptorEnum.Variable_ord:
			case CommonsEntityDescriptorEnum.InlineVariable_ord:
				throw new MissingVariableException(((Variable) adaptee).getVarName().toString()).withSourceEntity(adaptee).withBindings(getBindings());
			case CommonsEntityDescriptorEnum.SameStageFragment_ord:
				setResultIterator(QueriesIteratorFactory.templateInterpreterIterator(adaptee).withSourceEntity(adaptee));
				return false;
			case CommonsEntityDescriptorEnum.RootFragment_ord:
			case CommonsEntityDescriptorEnum.StageDownFragment_ord:
				setResultIterator(QueriesIteratorFactory.templateInterpreterIterator(
						GenericEntityFactory.instance.create(
								CommonsEntityDescriptorEnum.StageDownFragment,
								EntityUtils.clone(entity))).withSourceEntity(adaptee));
				return false;
			case CommonsEntityDescriptorEnum.StageUpFragment_ord:
				if (useTemplateFactorySemantics())
					setResultIterator(QueriesIteratorFactory.templateInterpreterIterator(adaptee).withSourceEntity(adaptee));
				else {
					CommonsInterpreterVisitor.evaluateAdapter(entity, getOperation());//TODO test
					setResultIterator(QueriesIteratorFactory.patternMatcherIterator(
							getResult()).withSourceEntity(adaptee));
				}
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
		String queryName = entity.getName().getValue();
    	declaredNames.add(queryName);

		setResultIterator(IteratorFactory.filterIterator(
    			QueriesIteratorFactory.constantIterator(entity, true).withSourceEntity(entity),
    			GenericMatcherFactory.instance.defineVariableMatcher(queryName)).withSourceEntity(entity));
	}

	@Override
	public void visit(Call entity) {
		Expressions arguments = entity.getArguments();
	
    	boolean inheritedSemantics = useInheritedSemantics(false);
		boolean templateFactorySemantics = useTemplateFactorySemantics(true);
    	IEntityIterator<? extends IEntity>[] argsIterators = new IEntityIterator<?>[arguments.wSize()];
    	for (int i=0, size=arguments.wSize(); i<size; i++) {
			arguments.get(i).accept(this);
			argsIterators[i] = getResultIterator();
		}
    	useTemplateFactorySemantics(templateFactorySemantics);
		useInheritedSemantics(inheritedSemantics);

		setResultIterator(QueriesIteratorFactory.callIterator(
				entity.getName().getValue(), argsIterators).withSourceEntity(entity));
	}

	@Override
	public void visit(Scope entity) {
		namesExp = Collections.emptySet();
		entity.getLocalNames().accept(this);
		Set<String> localNames = namesExp;
		
		entity.getExpression().accept(this);
		
		setResultIterator(QueriesIteratorFactory.scopeIterator(getResultIterator(), null, localNames).withSourceEntity(entity));
	}

    @Override
    public void visit(Path entity) {
    	boolean useFactorySemantics = useFactorySemantics(entity);
    	boolean templateSemantics = useTemplateFactorySemantics(useFactorySemantics);//TODO test true);
    	boolean inheritedSemantics = useInheritedSemantics(true);
    	DistinctScope<IEntity> oldDistinctScope = distinctScope;
    	distinctScope = null;

    	int nestedIndex = entity.wSize()-1;
    	IEntityIterator<?>[] nestedIterators = new IEntityIterator<?>[nestedIndex>=0 ? nestedIndex : 0];
    	nestedIndex--;
    	for (int i = 0; i < entity.wSize()-1; i++) {
			entity.get(i).accept(this);
			nestedIterators[nestedIndex-i] = getResultIterator();
		}
		entity.get(entity.wSize()-1).accept(this);

		setResultIterator(IteratorFactory.composeIterator(getResultIterator(), nestedIterators).withSourceEntity(entity));

		if (distinctScope != null)
			setResultIterator(distinctScope.withIterator(getResultIterator()));

		distinctScope = oldDistinctScope;
		useInheritedSemantics(false);
		useTemplateFactorySemantics(templateSemantics);
		useInheritedSemantics(inheritedSemantics);
    }

    @Override
    public void visit(Choose entity) {
    	int size = entity.wSize();
    	if (size == 1)
    		entity.get(0).accept(this);
    	else {
    		boolean canOptimize = true;
    		ILanguageKit languageKit = null;
    		Map<EntityDescriptor<?>, PathExpression> typeMap = new HashMap<EntityDescriptor<?>, PathExpression>();
    		
    		If ifWithTemplate = new IfWithTemplate().create();
    		If ifWithTypeTest = new IfWithTypeTest().create();

    		ITransactionScope ts = BindingManagerFactory.instance.createTransactionScope();
    		getBindings().wEnterScope(ts);
    		for (int i=0; i<size; i++) {
    			PathExpression child = entity.get(i);
    			try {
    				if (!Matcher.match(ifWithTemplate, child, getBindings()) &&
    						!Matcher.match(ifWithTypeTest, child, getBindings())) {
    					canOptimize = false;
    					break;
    				}

    				EntityDescriptor<?> ed = getBindings().wIsSet("typeTest") && getBindings().wGet("typeTest").wGetEntityDescriptor().getDataKind().isString() ?
							CommonsDataTypePersistenceParser.getEntityDescriptor(getBindings().wStringValue("typeTest")) :
								getBindings().wIsSet("pattern") ? getBindings().wGet("pattern").wGetEntityDescriptor() : null;

					if (ed == null) {
    					canOptimize = false;
    					break;
    				}

    				if (typeMap.containsKey(ed)) {
    					PathExpression behavior = typeMap.get(ed);
    					boolean isPattern = behavior.wGetParent() == entity;
        				if (isPattern) {
        					canOptimize = false;
        					break;
        				}
    				} else {
	        			if (languageKit == null)
	        				languageKit = ed.getLanguageKit();
	        			else if (!languageKit.equals(ed.getLanguageKit())) {// || !languageKit.getURI().equals("whole:org.whole.lang.javascript:JavaScript")) {
	        				canOptimize = false;
	        				break;
	        			}
	        			typeMap.put(ed, getBindings().wIsSet("pattern") ? child :
	        				getBindings().wGet("expression").wGetAdapter(QueriesEntityDescriptorEnum.PathExpression));
    				}
    			} finally {
    				ts.rollback();
    			}
    		}
    		getBindings().wExitScope();

    		if (canOptimize) {
    			ChooseByTypeIterator<IEntity> chooseIterator = IteratorFactory.chooseIterator(languageKit);

    			for (Entry<EntityDescriptor<?>, PathExpression> entry : typeMap.entrySet()) {
    		    	boolean inheritedSemantics = useInheritedSemantics(false);
    		    	boolean templateSemantics = useTemplateFactorySemantics(false);


    		    	useInheritedSemantics(false);
    		    	useTemplateFactorySemantics(true);

    		    	Set<String> oldDeclaredNames = declaredNames;

    		    	entry.getValue().accept(this);
    		    	chooseIterator.setCase(entry.getKey(), getResultIterator());

    		    	declaredNames = oldDeclaredNames;

    				useInheritedSemantics(false);
    				useTemplateFactorySemantics(templateSemantics);
    				useInheritedSemantics(inheritedSemantics);
    			}

    			setResultIterator(chooseIterator.withSourceEntity(entity));

    		} else {
    			IEntityIterator<? extends IEntity>[] iteratorChain = new IEntityIterator<?>[size];

    			for (int i=0; i<size; i++) {
    				entity.get(i).accept(this);
    				iteratorChain[i] = getResultIterator();
    			}

    			setResultIterator(IteratorFactory.chooseIterator(iteratorChain).withSourceEntity(entity));
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
			
	    	for (int i=0; i<size; i++) {
				entity.get(i).accept(this);
				iteratorChain[i] = getResultIterator();
			}
	
	    	setResultIterator(IteratorFactory.blockIterator(iteratorChain).withSourceEntity(entity));
    	}
    }

    @Override
    public void visit(Sequence entity) {
    	int size = entity.wSize();
    	if (size == 1)
    		entity.get(0).accept(this);//FIXME nested scope is exposed
    	else {
			IEntityIterator<? extends IEntity>[] iteratorChain = new IEntityIterator<?>[size];
			
	    	for (int i=0; i<size; i++) {
				entity.get(i).accept(this);
				iteratorChain[i] = getResultIterator();
			}

	    	setResultIterator(IteratorFactory.sequenceIterator(iteratorChain).withSourceEntity(entity));
    	}
    }

    @Override
    public void visit(Prune entity) {
		entity.getPredicate().accept(this);
    }

    @Override
    public void visit(Filter entity) {
    	boolean useFactorySemantics = useFactorySemantics(entity);
    	boolean templateSemantics = useTemplateFactorySemantics(useFactorySemantics);
    	boolean inheritedSemantics = useInheritedSemantics(true);
    	FilterByIndexRangeIterator<IEntity> oldFilterByIndexIterator = filterByIndexIterator;
    	filterByIndexIterator = null;
    	DistinctScope<IEntity> oldDistinctScope = distinctScope;
    	distinctScope = null;

    	PruneOrPredicate predicate = entity.getPredicate();
    	StepExpression expression = entity.getExpression();
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
    			int index = predicate.wGet(0).wIntValue();
    			setResultIterator(IteratorFactory.featureByIndexIterator(index).withSourceEntity(entity));
    			optimizeIndexTest = true;
    		} else if (Matcher.matchImpl(QueriesEntityDescriptorEnum.AtIndexTest, predicate)) {
    			int index = predicate.wIntValue();
    			setResultIterator(IteratorFactory.featureByIndexIterator(index).withSourceEntity(entity));
    			optimizeIndexTest = true;
    		}
    	}

    	if (!optimizeIndexTest) {
    		setResultPredicate(null);
			predicate.accept(this);
			IVisitor queryPredicate = getResultPredicate();

			expression.accept(this);

			if (filterByIndexIterator != null) {
				filterByIndexIterator.withIterator(getResultIterator());
		    	setResultIterator(filterByIndexIterator);
	    	
		    	if (canFilterByIndex) {
	//	    		filterByIndexIterator.withStartIndex(startIndex);
		    		filterByIndexIterator.withEndIndex(endIndex);
		    	}
			}

			if (distinctScope != null &&
					!(EntityUtils.hasParent(entity) &&
					Matcher.match(QueriesEntityDescriptorEnum.Path, entity.wGetParent())))
		    	setResultIterator(distinctScope.withIterator(getResultIterator()));

			if (queryPredicate != null)
				setResultIterator(IteratorFactory.filterIterator(
						getResultIterator(), queryPredicate).withAutoPrune(usePruneFilter).withSourceEntity(entity));
    	}

		startIndex = oldStartIndex;
		endIndex = oldEndIndex;
		canFilterByIndex = oldCanFilterByIndex;
		filterByIndexIterator = oldFilterByIndexIterator;
		distinctScope = oldDistinctScope;

		useInheritedSemantics(false);
		useTemplateFactorySemantics(templateSemantics);
		useInheritedSemantics(inheritedSemantics);
    }

    @Override
	public void visit(AspectStep entity) {
    	setResultIterator(IteratorFactory.aspectIterator().withSourceEntity(entity));
	}

    @Override
	public void visit(AdjacentStep entity) {
    	setResultIterator(IteratorFactory.adjacentIterator().withSourceEntity(entity));
	}

    @Override
	public void visit(ReachableStep entity) {
    	setResultIterator(IteratorFactory.reachableIterator(false).withSourceEntity(entity));
	}

    @Override
	public void visit(ReachableOrSelfStep entity) {
    	setResultIterator(IteratorFactory.reachableIterator(true).withSourceEntity(entity));
	}

    @Override
	public void visit(InverseAdjacentStep entity) {
    	setResultIterator(IteratorFactory.inverseAdjacentIterator().withSourceEntity(entity));
	}

    @Override
	public void visit(InverseReachableStep entity) {
    	setResultIterator(IteratorFactory.inverseReachableIterator(false).withSourceEntity(entity));
	}

    @Override
	public void visit(InverseReachableOrSelfStep entity) {
    	setResultIterator(IteratorFactory.inverseReachableIterator(true).withSourceEntity(entity));
	}

    @Override
    public void visit(RootStep entity) {
    	setResultIterator(IteratorFactory.rootIterator().withSourceEntity(entity));
    }

	@Override
	public void visit(FragmentRootStep entity) {
    	setResultIterator(IteratorFactory.fragmentRootIterator().withSourceEntity(entity));
	}

    @Override
    public void visit(SelfStep entity) {
    	setResultIterator(IteratorFactory.selfIterator().withSourceEntity(entity));
    }

    @Override
    public void visit(FeatureStep entity) {
    	setResultIterator(IteratorFactory.featureByNameIterator(entity.getValue()).withSourceEntity(entity));
    }

    @Override
    public void visit(ChildStep entity) {
    	setResultIterator(IteratorFactory.childIterator().withSourceEntity(entity));
    }
    @Override
    public void visit(DescendantStep entity) {
    	setResultIterator(IteratorFactory.descendantIterator().withSourceEntity(entity));
    }
    @Override
    public void visit(DescendantOrSelfStep entity) {
    	setResultIterator(IteratorFactory.descendantOrSelfIterator().withSourceEntity(entity));
    }
    @Override
    public void visit(FollowingSiblingStep entity) {
    	setResultIterator(IteratorFactory.followingSiblingIterator().withSourceEntity(entity));
    }
    @Override
    public void visit(FollowingStep entity) {
    	setResultIterator(IteratorFactory.followingIterator().withSourceEntity(entity));
    }

    @Override
    public void visit(ParentStep entity) {
    	setResultIterator(IteratorFactory.parentIterator().withSourceEntity(entity));
    }
    @Override
    public void visit(AncestorStep entity) {
    	setResultIterator(IteratorFactory.ancestorIterator().withSourceEntity(entity));
    }
    @Override
    public void visit(AncestorOrSelfStep entity) {
    	setResultIterator(IteratorFactory.ancestorOrSelfIterator().withSourceEntity(entity));
    }
    @Override
    public void visit(PrecedingSiblingStep entity) {
    	setResultIterator(IteratorFactory.precedingSiblingIterator().withSourceEntity(entity));
    }
    @Override
    public void visit(PrecedingStep entity) {
    	setResultIterator(IteratorFactory.precedingIterator().withSourceEntity(entity));
    }

    @Override
    public void visit(VariableRefStep entity) {
    	setResultIterator(IteratorFactory.variableIterator(entity.getValue()).withSourceEntity(entity).withSourceEntity(entity));
    }

    @Override
    public void visit(VariableTest entity) {
    	String varName = entity.getValue();
		declaredNames.add(varName);

    	setResultPredicate(GenericMatcherFactory.instance.asVariableMatcher(varName).withSourceEntity(entity));
    }

    @Override
    public void visit(CartesianProduct entity) {
    	IEntityIterator<?>[] iterators = new IEntityIterator<?>[entity.wSize()];
    	for (int i = 0; i < entity.wSize(); i++) {
			entity.get(i).accept(this);
			iterators[i] = getResultIterator();
		}

    	setResultIterator(QueriesIteratorFactory.cartesianProductIterator(iterators).withSourceEntity(entity));
    }

    @Override
    public void visit(PointwiseProduct entity) {
    	IEntityIterator<?>[] iterators = new IEntityIterator<?>[entity.wSize()];
		
    	for (int i = 0; i < entity.wSize(); i++) {
			entity.get(i).accept(this);
			iterators[i] = getResultIterator();
		}

    	setResultIterator(QueriesIteratorFactory.pointwiseProductIterator(iterators).withSourceEntity(entity));
    }

    @Override
    public void visit(Delete entity) {
    	boolean inheritedSemantics = useInheritedSemantics(false);
    	boolean templateSemantics = useTemplateFactorySemantics(false);
    	useInheritedSemantics(true);

    	entity.getFromClause().accept(this);
    	IEntityIterator<? extends IEntity> fromIterator = getResultIterator();

    	setResultIterator(QueriesIteratorFactory.deleteIterator(fromIterator).withSourceEntity(entity));

		useInheritedSemantics(false);
		useTemplateFactorySemantics(templateSemantics);
		useInheritedSemantics(inheritedSemantics);
    }

	@Override
    public void visit(CartesianUpdate entity) {
    	boolean inheritedSemantics = useInheritedSemantics(false);
    	boolean templateSemantics = useTemplateFactorySemantics(false);
    	useInheritedSemantics(true);

     	entity.getFromClause().accept(this);
    	IEntityIterator<IEntity> fromIterator = getResultIterator();

    	useInheritedSemantics(false);
    	useTemplateFactorySemantics(true);

    	setResultIterator(IteratorFactory.emptyIterator().withSourceEntity(entity));
    	entity.getValuesClause().accept(this);
    	IEntityIterator<? extends IEntity> valuesIterator = getResultIterator();

    	setResultIterator(QueriesIteratorFactory.cartesianUpdateIterator(valuesIterator, fromIterator).withSourceEntity(entity));

		useInheritedSemantics(false);
		useTemplateFactorySemantics(templateSemantics);
		useInheritedSemantics(inheritedSemantics);
    }

	@Override
    public void visit(PointwiseUpdate entity) {
    	boolean inheritedSemantics = useInheritedSemantics(false);
    	boolean templateSemantics = useTemplateFactorySemantics(false);
    	useInheritedSemantics(true);

     	entity.getFromClause().accept(this);
    	IEntityIterator<IEntity> fromIterator = getResultIterator();

    	useInheritedSemantics(false);
    	useTemplateFactorySemantics(true);

    	setResultIterator(IteratorFactory.emptyIterator().withSourceEntity(entity));
    	entity.getValuesClause().accept(this);
    	IEntityIterator<? extends IEntity> valuesIterator = getResultIterator();

    	setResultIterator(QueriesIteratorFactory.pointwiseUpdateIterator(
    			valuesIterator, fromIterator).withSourceEntity(entity));

		useInheritedSemantics(false);
		useTemplateFactorySemantics(templateSemantics);
		useInheritedSemantics(inheritedSemantics);
    }

	@Override
    public void visit(CartesianInsert entity) {
    	boolean inheritedSemantics = useInheritedSemantics(false);
    	boolean templateSemantics = useTemplateFactorySemantics(false);
    	useInheritedSemantics(true);

    	entity.getFromClause().accept(this);
    	IEntityIterator<IEntity> fromIterator = getResultIterator();

    	useInheritedSemantics(false);
    	useTemplateFactorySemantics(true);

    	setResultIterator(IteratorFactory.emptyIterator().withSourceEntity(entity));
    	entity.getValuesClause().accept(this);
    	IEntityIterator<? extends IEntity> valuesIterator = getResultIterator();

    	Placement placement = Placement.valueOf(entity.getPlacement().getValue().getName());
    	setResultIterator(QueriesIteratorFactory.cartesianInsertIterator(
    			valuesIterator, fromIterator, placement).withSourceEntity(entity));

		useInheritedSemantics(false);
		useTemplateFactorySemantics(templateSemantics);
		useInheritedSemantics(inheritedSemantics);
    }

	@Override
    public void visit(PointwiseInsert entity) {
    	boolean inheritedSemantics = useInheritedSemantics(false);
    	boolean templateSemantics = useTemplateFactorySemantics(false);
    	useInheritedSemantics(true);

    	entity.getFromClause().accept(this);
    	IEntityIterator<IEntity> fromIterator = getResultIterator();

    	useInheritedSemantics(false);
    	useTemplateFactorySemantics(true);

    	setResultIterator(IteratorFactory.emptyIterator().withSourceEntity(entity));
    	entity.getValuesClause().accept(this);
    	IEntityIterator<? extends IEntity> valuesIterator = getResultIterator();

    	Placement placement = Placement.valueOf(entity.getPlacement().getValue().getName());
    	setResultIterator(QueriesIteratorFactory.pointwiseInsertIterator(
    			valuesIterator, fromIterator, placement).withSourceEntity(entity));

		useInheritedSemantics(false);
		useTemplateFactorySemantics(templateSemantics);
		useInheritedSemantics(inheritedSemantics);
    }

    @Override
    public void visit(Select entity) {
    	boolean inheritedSemantics = useInheritedSemantics(false);
    	boolean templateSemantics = useTemplateFactorySemantics(false);
    	useInheritedSemantics(true);

    	Set<String> oldDeclaredNames = declaredNames;
    	Set<String> namesToBound = declaredNames = new HashSet<String>();

		setResultPredicate(null);
    	PathExpressionOrPredicate fromClause = entity.getFromClause();
		fromClause.accept(this);
		IEntityIterator<? extends IEntity> fromIterator = isResultIterator() ?
				getResultIterator() :
				IteratorFactory.filterIterator(IteratorFactory.selfIterator().withSourceEntity(entity), getResultPredicate()).withSourceEntity(entity);

    	useInheritedSemantics(false);
    	useTemplateFactorySemantics(true);

    	setResultIterator(IteratorFactory.emptyIterator().withSourceEntity(entity));
    	entity.getWhereClause().accept(this);
    	IEntityIterator<? extends IEntity> whereIterator = getResultIterator();

    	useInheritedSemantics(false);
    	useTemplateFactorySemantics(true);

    	declaredNames = oldDeclaredNames;

    	entity.getSelectClause().accept(this);
    	IEntityIterator<? extends IEntity> selectIterator = getResultIterator();

       	templateNames = Matcher.vars(entity.getSelectClause(), true);
        namesExp = declaredNames = namesToBound;
        useNamesComplement = false;
    	entity.getClearClause().accept(this);

    	setResultIterator(QueriesIteratorFactory.selectIterator(
       			selectIterator, fromIterator, whereIterator)
       			.withNamesToBind(namesExp)
       			.withNamesComplement(useNamesComplement).withSourceEntity(entity));   		

    	declaredNames = oldDeclaredNames;

		useInheritedSemantics(false);
		useTemplateFactorySemantics(templateSemantics);
		useInheritedSemantics(inheritedSemantics);
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
			entity.get(i).accept(this);
    }
    @Override
    public void visit(Name entity) {
    	namesExp.add(entity.getValue());
    }

    @Override
    public void visit(For entity) {
    	boolean inheritedSemantics = useInheritedSemantics(false);
    	boolean templateSemantics = useTemplateFactorySemantics(false);
    	useInheritedSemantics(true);

    	Set<String> oldDeclaredNames = declaredNames;
    	Set<String> namesToBound = declaredNames = new HashSet<String>();

    	entity.getFromClause().accept(this);
    	IEntityIterator<? extends IEntity> fromIterator = getResultIterator();

    	useInheritedSemantics(false);
    	useTemplateFactorySemantics(true);

    	declaredNames = oldDeclaredNames;

    	entity.getExpression().accept(this);
    	IEntityIterator<? extends IEntity> selectIterator = getResultIterator();

    	declaredNames = namesToBound;

    	setResultIterator(IteratorFactory.forIterator(
    			fromIterator, selectIterator).withSourceEntity(entity));

    	declaredNames = oldDeclaredNames;

		useInheritedSemantics(false);
		useTemplateFactorySemantics(templateSemantics);
		useInheritedSemantics(inheritedSemantics);
    }

    @Override
    public void visit(If entity) {
    	boolean inheritedSemantics = useInheritedSemantics(false);
    	boolean templateSemantics = useTemplateFactorySemantics(false);
    	useInheritedSemantics(true);

    	Set<String> oldDeclaredNames = declaredNames;
    	Set<String> namesToBound = declaredNames = new HashSet<String>();

		setResultPredicate(null);
		entity.getPredicate().accept(this);
		IVisitor predicate = getResultPredicate();

    	useInheritedSemantics(false);
    	useTemplateFactorySemantics(true);

    	declaredNames = oldDeclaredNames;

    	entity.getExpression().accept(this);
    	IEntityIterator<? extends IEntity> selectIterator = getResultIterator();

    	declaredNames = namesToBound;

    	setResultIterator(IteratorFactory.ifIterator(
    			predicate, selectIterator).withSourceEntity(entity));

    	declaredNames = oldDeclaredNames;

		useInheritedSemantics(false);
		useTemplateFactorySemantics(templateSemantics);
		useInheritedSemantics(inheritedSemantics);
    }

    @Override
    public void visit(Do entity) {
    	boolean inheritedSemantics = useInheritedSemantics(false);
    	boolean templateSemantics = useTemplateFactorySemantics(false);
    	useInheritedSemantics(true);

    	Set<String> oldDeclaredNames = declaredNames;
//    	Set<String> namesToBound = 
    		declaredNames = new HashSet<String>();

    	useInheritedSemantics(false);
    	useTemplateFactorySemantics(true);

    	declaredNames = oldDeclaredNames;

    	entity.getExpression().accept(this);
//    	IEntityIterator<? extends IEntity> selectIterator = getQueryIterator();
//
//    	declaredNames = namesToBound;
//
//    	setQueryIterator(QueriesIteratorFactory.doIterator(selectIterator)
//       			.useNamesToBound(namesToBound).withDomainEntity(entity));   		

    	declaredNames = oldDeclaredNames;

		useInheritedSemantics(false);
		useTemplateFactorySemantics(templateSemantics);
		useInheritedSemantics(inheritedSemantics);
    }

    @Override
    public void visit(Tuple entity) {
    	IEntityIterator<?>[] tupleIterators = new IEntityIterator<?>[entity.wSize()];
    	for (int i=0; i<entity.wSize(); i++) {
			entity.get(i).accept(this);
			tupleIterators[i] = getResultIterator();
		}
		setResultIterator(QueriesIteratorFactory.tupleFactoryIterator(tupleIterators).withSourceEntity(entity));
    }

    @Override
    public void visit(One entity) {
    	entity.getFromClause().accept(this);
    	IEntityIterator<? extends IEntity> fromClause = getResultIterator();
    	entity.getWhereClause().accept(this);
		setResultPredicate(QueriesMatcherFactory.one(fromClause, getResultPredicate()).withSourceEntity(entity));
    }
    @Override
    public void visit(Some entity) {
    	entity.getFromClause().accept(this);
    	IEntityIterator<? extends IEntity> fromClause = getResultIterator();
    	entity.getWhereClause().accept(this);
		setResultPredicate(QueriesMatcherFactory.some(fromClause, getResultPredicate()).withSourceEntity(entity));
    }
    @Override
    public void visit(Every entity) {
    	entity.getFromClause().accept(this);
    	IEntityIterator<? extends IEntity> fromClause = getResultIterator();
    	entity.getWhereClause().accept(this);
		setResultPredicate(QueriesMatcherFactory.all(fromClause, getResultPredicate()).withSourceEntity(entity));
    }

    @Override
    public void visit(KindTest entity) {
    	Value kind = entity.getValue();
		switch (kind.getOrdinal()) {
		case KindTestEnum.IMPL_ord:
			setResultPredicate(GenericMatcherFactory.instance.isImplMatcher().withSourceEntity(entity));
			break;
		case KindTestEnum.FRAGMENT_ord:
			setResultPredicate(GenericMatcherFactory.instance.isFragmentMatcher().withSourceEntity(entity));
			break;
		case KindTestEnum.VARIABLE_ord:
			setResultPredicate(GenericMatcherFactory.instance.isVariableMatcher().withSourceEntity(entity));
			break;
		case KindTestEnum.RESOLVER_ord:
			setResultPredicate(GenericMatcherFactory.instance.isResolverMatcher().withSourceEntity(entity));
			break;
			//TODO test only remove
		case KindTestEnum.ADAPTER_ord:
		case KindTestEnum.PROXY_ord:
		case KindTestEnum.SAME_STAGE_FRAGMENT_ord:
		case KindTestEnum.STAGE_UP_FRAGMENT_ord:
		case KindTestEnum.STAGE_DOWN_FRAGMENT_ord:
			throw new IllegalArgumentException();
		default:
			EntityKinds ekind = EntityKinds.valueOf(kind.getName());
			setResultPredicate(GenericMatcherFactory.instance.hasKindMatcher(ekind).withSourceEntity(entity));
		}
    }

    @Override
    public void visit(StageTest entity) {
    StageTestEnum.Value stage = entity.getValue();
		switch (stage.getOrdinal()) {
		case StageTestEnum.HOST_STAGE_ord:
			setResultPredicate(GenericMatcherFactory.instance.atHostStageMatcher().withSourceEntity(entity));
			break;
		case StageTestEnum.HOST_STAGE_0_ord:
			setResultPredicate(GenericMatcherFactory.instance.atStageMatcher(0).withSourceEntity(entity));
			break;
		case StageTestEnum.TEMPLATE_STAGE_1_ord:
			setResultPredicate(GenericMatcherFactory.instance.atStageMatcher(1).withSourceEntity(entity));
			break;
		case StageTestEnum.TEMPLATE_STAGE_ord:
			setResultPredicate(GenericMatcherFactory.instance.atTemplateStageMatcher().withSourceEntity(entity));
			break;
		}
    }
    @Override
    public void visit(StageVariableTest entity) {
		setResultPredicate(GenericMatcherFactory.instance.atStageVariableMatcher(entity.getValue()).withSourceEntity(entity));
	}

    @Override
    public void visit(LanguageTest entity) {
    	String languageURI = entity.getValue();
    	setResultPredicate(GenericMatcherFactory.instance.isLanguageMatcher(languageURI).withSourceEntity(entity));
    }

    @Override
    public void visit(TypeTest entity) {
    	setResultPredicate(GenericMatcherFactory.instance.hasTypeMatcher(entity.getValue()).withSourceEntity(entity));
    }
    @Override
    public void visit(SubtypeTest entity) {
    	setResultPredicate(GenericMatcherFactory.instance.isLanguageSubtypeOfMatcher(entity.getValue()).withSourceEntity(entity));
    }
    @Override
    public void visit(SupertypeTest entity) {
    	setResultPredicate(GenericMatcherFactory.instance.isLanguageSupertypeOfMatcher(entity.getValue()).withSourceEntity(entity));
    }
    @Override
    public void visit(ExtendedSubtypeTest entity) {
    	setResultPredicate(GenericMatcherFactory.instance.isExtendedLanguageSubtypeOfMatcher(entity.getValue()).withSourceEntity(entity));
    }
    @Override
    public void visit(ExtendedSupertypeTest entity) {
    	setResultPredicate(GenericMatcherFactory.instance.isExtendedLanguageSupertypeOfMatcher(entity.getValue()).withSourceEntity(entity));
    }

    @Override
    public void visit(ExpressionTest entity) {
    	PathExpression e = entity.getExpression();

		if (EntityUtils.isStageUpFragment(e)) {
			CommonsInterpreterVisitor.evaluateAdapter((IEntityAdapter) e, getOperation());

			IEntity pe = getResult();
	    	setResultPredicate(GenericMatcherFactory.instance.matchInScope(pe).withSourceEntity(entity));

			IEntityIterator<IEntity> variableIterator = IteratorFactory.descendantOrSelfMatcherIterator()
					.withPattern(GenericMatcherFactory.instance.isVariableMatcher()).withSourceEntity(entity);
			variableIterator.reset(pe);
			for (IEntity variableAdapter : variableIterator) {
				Variable variable = (Variable) variableAdapter.wGetAdaptee(false);
				declaredNames.add(variable.getVarName().getValue());
			}
		} else if (EntityUtils.isSameStageFragment(e)) {
			setResultPredicate(GenericMatcherFactory.evalTrue(e.wGetAdaptee(false).wGetRoot()).withSourceEntity(entity));
		} else if (!e.wGetLanguageKit().getURI().equals(QueriesLanguageKit.URI)) {
			setResultPredicate(GenericMatcherFactory.evalTrue(e.wGetAdaptee(false)).withSourceEntity(entity));
		} else if (Matcher.matchImpl(QueriesEntityDescriptorEnum.PointwiseEquals, e))
			e.accept(this);
		else if (QueriesEntityDescriptorEnum.Expression.isLanguageSupertypeOf(e.wGetEntityDescriptor())
				|| QueriesEntityDescriptorEnum.MathStep.isLanguageSupertypeOf(e.wGetEntityDescriptor()))
			setResultPredicate(GenericMatcherFactory.evalTrue(e).withSourceEntity(entity));
		else {
			e.accept(this);
			setResultPredicate(GenericMatcherFactory.instance.match(getResultIterator()).withSourceEntity(entity));
		}
    }

    @Override
    public void visit(PointwiseEquals entity) {
    	entity.getPexp1().accept(this);
    	IEntityIterator<? extends IEntity> exp1Iterator = getResultIterator();
    	entity.getPexp2().accept(this);
    	setResultPredicate(QueriesMatcherFactory.pointwiseEquals(exp1Iterator, getResultIterator()).withSourceEntity(entity));
    }

	@Override
	public void visit(AtTypeTest entity) {
    	setResultPredicate(GenericMatcherFactory.instance.atTypeMatcher(entity.getValue()).withSourceEntity(entity));
	}
	@Override
	public void visit(AtFeatureTest entity) {
		setResultPredicate(GenericMatcherFactory.instance.atFeatureMatcher(entity.getValue()).withSourceEntity(entity));
	}
	@Override
	public void visit(AtIndexTest entity) {
		setResultPredicate(GenericMatcherFactory.instance.atIndexMatcher(entity.getValue()).withSourceEntity(entity).withSourceEntity(entity));
	}

    @Override
    public void visit(IndexVariableTest entity) {
    	String varName = entity.getValue();
		declaredNames.add(varName);

		if (filterByIndexIterator == null) {
			filterByIndexIterator = IteratorFactory.filterByIndexRangeIterator();
			filterByIndexIterator.withSourceEntity(entity);
		}
		
    	setResultPredicate(GenericMatcherFactory.instance.matchIteratorIndexVariable(
    			filterByIndexIterator, varName).withSourceEntity(entity));

		updateIndexRange(0, Integer.MAX_VALUE);
    }


	@Override
	public void visit(IndexTest entity) {
		if (filterByIndexIterator == null) {
			filterByIndexIterator = IteratorFactory.filterByIndexRangeIterator();
			filterByIndexIterator.withSourceEntity(entity);
		}
		
		int index = entity.getIndex().getValue();
		setResultPredicate(GenericMatcherFactory.instance.matchIteratorIndex(
				filterByIndexIterator, index).withSourceEntity(entity));
		
		updateIndexRange(index, index);
	}
	@Override
	public void visit(IndexRangeTest entity) {
		if (filterByIndexIterator == null) {
			filterByIndexIterator = IteratorFactory.filterByIndexRangeIterator();
			filterByIndexIterator.withSourceEntity(entity);
		}
		
		int startIndexValue = entity.getStartIndex().getValue();
		int endIndexValue;
		IntLiteral endIndex = entity.getEndIndex();
		if (Matcher.matchImpl(QueriesEntityDescriptorEnum.IntLiteral, endIndex))
			endIndexValue = endIndex.getValue();
		else
			endIndexValue = Integer.MAX_VALUE;

		setResultPredicate(GenericMatcherFactory.instance.matchIteratorIndexRange(
				filterByIndexIterator, startIndexValue, endIndexValue).withSourceEntity(entity));

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
		setResultPredicate(entity.getValue().withSourceEntity(entity));
	}

	@Override
	public void visit(DistinctTest entity) {
    	IEntityComparator<IEntity> oldComparator = comparator;
    	comparator = BusinessIdentityComparator.instance;
		entity.getComparator().accept(this);
		
		if (distinctScope == null)
			distinctScope = IteratorFactory.distinctScope();
		
		distinctScope.withComparator(comparator);
		setResultPredicate(distinctScope.distinctMatcher().withSourceEntity(entity));
    	comparator = oldComparator;
	}

	@Override
    public void visit(And entity) {
    	visitFrom(entity, 0);
    }
	private void visitFrom(And entity, int from) {
		int size = entity.wSize()-from;
    	IVisitor[] visitors = new IVisitor[size];
		for (int i = from; i < size; i++) {
			entity.get(i).accept(this);
	    	visitors[i] = getResultPredicate();
		}
    	setResultPredicate(GenericTraversalFactory.instance.all(visitors).withSourceEntity(entity));
	}
    @Override
    public void visit(Or entity) {
    	boolean canFilterByIndexResult = canFilterByIndex;

    	int size = entity.wSize();
    	IVisitor[] visitors = new IVisitor[size];
		for (int i = 0; i < size; i++) {
			canFilterByIndex = false;
			entity.get(i).accept(this);
			visitors[i] = getResultPredicate();
			canFilterByIndexResult &= !canFilterByIndex;
		}
    	setResultPredicate(GenericTraversalFactory.instance.one(visitors).withSourceEntity(entity));
    	canFilterByIndex = canFilterByIndexResult;
    }
    @Override
    public void visit(Not entity) {
    	entity.getPredicate().accept(this);
    	setResultPredicate(GenericTraversalFactory.instance.not(getResultPredicate()).withSourceEntity(entity));
    }

    @Override
    public void visit(ParenthesizedPredicate entity) {
    	entity.getPredicate().accept(this);
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
    	for (int i=0; i<entity.wSize(); i++) {
			entity.get(i).accept(this);
			iteratorChain[i] = getResultIterator();
		}
    	this.iteratorChain = iteratorChain;
    }
    protected IEntityIterator<?>[] iteratorChain;

    @Override
    public void visit(UnionAll entity) {
    	entity.getExpressions().accept(this);
    	setResultIterator(IteratorFactory.unionAllIterator(iteratorChain).withSourceEntity(entity));
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
    	setResultIterator(IteratorFactory.unionIterator(iteratorChain)
    			.withComparator(comparator).withSourceEntity(entity));
    	comparator = oldComparator;
    }

    @Override
    public void visit(Intersect entity) {
    	IEntityComparator<IEntity> oldComparator = comparator;
    	comparator = BusinessIdentityComparator.instance;
    	visitCollectByExpression(entity);
    	setResultIterator(IteratorFactory.intersectIterator(iteratorChain)
    			.withComparator(comparator).withSourceEntity(entity));
    	comparator = oldComparator;
    }

    @Override
    public void visit(Except entity) {
    	IEntityComparator<IEntity> oldComparator = comparator;
    	comparator = BusinessIdentityComparator.instance;
    	visitCollectByExpression(entity);
    	setResultIterator(IteratorFactory.exceptIterator(iteratorChain)
    			.withComparator(comparator).withSourceEntity(entity));
    	comparator = oldComparator;
    }

	protected void setLiteral(IEntity entity) {
		setResultIterator(IteratorFactory.constantIterator(
				BindingManagerFactory.instance.createSpecificValue(entity), true).withSourceEntity(entity));
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
		setResultIterator(IteratorFactory.constantIterator(
				BindingManagerFactory.instance.createVoid(), true).withSourceEntity(entity));
	}

	public void visitExpression(Expression entity) {
		setResultIterator(QueriesIteratorFactory.templateInterpreterIterator(entity).withSourceEntity(entity));
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
		setResultIterator(MathUtils.multiplicationStepIterator(compile(entity.getExpression())).withSourceEntity(entity));
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
		setResultIterator(MathUtils.greaterOrEqualsStepIterator(compile(entity.getExpression())).withSourceEntity(entity));
	}

	@Override
	public void visit(Addition entity) {
		setResultIterator(MathUtils.additionIterator(compile(entity.getExp1()), compile(entity.getExp2())).withSourceEntity(entity));
	}
	@Override
	public void visit(Subtraction entity) {
		setResultIterator(MathUtils.subtractionIterator(compile(entity.getExp1()), compile(entity.getExp2())).withSourceEntity(entity));
	}
	@Override
	public void visit(Multiplication entity) {
		setResultIterator(MathUtils.multiplicationIterator(compile(entity.getExp1()), compile(entity.getExp2())).withSourceEntity(entity));
	}
	@Override
	public void visit(Division entity) {
		setResultIterator(MathUtils.divisionIterator(compile(entity.getExp1()), compile(entity.getExp2())).withSourceEntity(entity));
	}
	@Override
	public void visit(Remainder entity) {
		setResultIterator(MathUtils.remainderIterator(compile(entity.getExp1()), compile(entity.getExp2())).withSourceEntity(entity));
	}

	@Override
	public void visit(Equals entity) {
		setResultIterator(MathUtils.equalsIterator(compile(entity.getExp1()), compile(entity.getExp2())).withSourceEntity(entity));
	}
	@Override
	public void visit(NotEquals entity) {
		setResultIterator(MathUtils.notEqualsIterator(compile(entity.getExp1()), compile(entity.getExp2())).withSourceEntity(entity));
	}
	@Override
	public void visit(LessThan entity) {
		setResultIterator(MathUtils.lessThanIterator(compile(entity.getExp1()), compile(entity.getExp2())).withSourceEntity(entity));
	}
	@Override
	public void visit(LessOrEquals entity) {
		setResultIterator(MathUtils.lessOrEqualsIterator(compile(entity.getExp1()), compile(entity.getExp2())).withSourceEntity(entity));
	}
	@Override
	public void visit(GreaterThan entity) {
		setResultIterator(MathUtils.greaterThanIterator(compile(entity.getExp1()), compile(entity.getExp2())).withSourceEntity(entity));
	}
	@Override
	public void visit(GreaterOrEquals entity) {
		setResultIterator(MathUtils.greaterOrEqualsIterator(compile(entity.getExp1()), compile(entity.getExp2())).withSourceEntity(entity));
	}

	@Override
	public void visit(Singleton entity) {
		entity.getExpression().accept(this);
	}
}