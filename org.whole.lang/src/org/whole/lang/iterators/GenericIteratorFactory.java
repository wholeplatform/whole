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
package org.whole.lang.iterators;

import java.util.Map;
import java.util.Set;

import org.whole.lang.bindings.AbstractFilterScope;
import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.bindings.IBindingScope;
import org.whole.lang.commons.factories.CommonsEntityFactory;
import org.whole.lang.commons.model.Variable;
import org.whole.lang.commons.parsers.CommonsDataTypePersistenceParser;
import org.whole.lang.commons.visitors.CommonsInterpreterVisitor;
import org.whole.lang.comparators.IEntityComparator;
import org.whole.lang.comparators.ObjectIdentityComparator;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.IEntity;
import org.whole.lang.model.InternalIEntity;
import org.whole.lang.operations.ICloneContext;
import org.whole.lang.reflect.CompositeKinds;
import org.whole.lang.reflect.DataKinds;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reflect.EntityKinds;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.reflect.ILanguageKit;
import org.whole.lang.util.BindingUtils;
import org.whole.lang.util.EntityUtils;
import org.whole.lang.util.IDataTypeWrapper;
import org.whole.lang.util.IRunnable;
import org.whole.lang.util.ResourceUtils;

/**
 * 
 * @author Riccardo Solmi
 */
public class GenericIteratorFactory implements IteratorFactory {
	public <E extends IEntity> IEntityIterator<E> emptyIterator() {
		return new EmptyIterator<E>();
	}

	public <E extends IEntity> IEntityIterator<E> failureIterator(Throwable failure) {
		return new FailureIterator<E>(failure);
	}

	public <E extends IEntity> IEntityIterator<E> variableIterator(String varName) {
		return BindingUtils.hasEnvironmentPart(varName) ? new VariableIterator<E>(varName) : new LocalVariableIterator<E>(varName);
	}
	public <E extends IEntity> IEntityIterator<E> outerVariableIterator(String varName) {
		return BindingUtils.hasEnvironmentPart(varName) ? new OuterVariableIterator<E>(varName) : new OuterLocalVariableIterator<E>(varName);
	}

	public <E extends IEntity> IEntityIterator<E> constantIterator(E constant, boolean useClone) {
		return new ConstantIterator<E>(constant, useClone);
	}
	public <E extends IEntity> IEntityIterator<E> constantChildIterator(IEntity constant) {
		return new ConstantChildIterator<E>(true, constant);
	}
	public <E extends IEntity> IEntityIterator<E> constantComposeIterator(IEntity constant, IEntityIterator<E> iterator) {
		return new ConstantComposeIterator<E>(constant, iterator);
	}
	public <E extends IEntity> IEntityIterator<E> constantSubstituteIterator(E constant, boolean useClone) {
		return new ConstantIterator<E>(constant, useClone) {
			@Override
			public E next() {
				E pattern = super.next();
				Matcher.substitute(pattern, getBindings(), true);
				return pattern;
			}
		};
	}

	public <E extends IEntity> IEntityIterator<E> entityCollectionIterator(Iterable<E> entityCollectionIterable) {
		return collectionIterator(entityCollectionIterable, IDataTypeWrapper.identity);
	}
	public <E extends IEntity> IEntityIterator<E> javaCollectionIterator(Iterable<?> collectionIterable) {
		return collectionIterator(collectionIterable, IDataTypeWrapper.envSpecificValue);
	}
	public <E extends IEntity> IEntityIterator<E> collectionIterator(Iterable<?> collectionIterable, IDataTypeWrapper elementWrapper) {
		return new CollectionIterator<E>(elementWrapper, collectionIterable);
	}

	public <E extends IEntity> IEntityIterator<E> singleValuedRunnableIterator(IRunnable runnable) {
		return new SingleValuedRunnableIterator<E>(runnable);
	}
	public <E extends IEntity> IEntityIterator<E> singleValuedRunnableIterator(IRunnable runnable, IEntityIterator<?>... argsIterators) {
		return new SingleValuedRunnableIterator<E>(runnable, argsIterators);
	}
	public <E extends IEntity> IEntityIterator<E> singleValuedRunnableIterator(IRunnable runnable, int[] optionalArgsIndexes, IEntityIterator<?>... argsIterators) {
		return new SingleValuedRunnableIterator<E>(runnable, optionalArgsIndexes, argsIterators);
	}
	public <E extends IEntity> IEntityIterator<E> multiValuedRunnableIterator(IRunnable runnable, IEntityIterator<?>... argsIterators) {
		return new MultiValuedRunnableIterator<E>(runnable, argsIterators);
	}
	public <E extends IEntity> IEntityIterator<E> multiValuedRunnableIterator(IRunnable runnable, int[] optionalArgsIndexes, IEntityIterator<?>... argsIterators) {
		return new MultiValuedRunnableIterator<E>(runnable, optionalArgsIndexes, argsIterators);
	}

	public IEntityIterator<IEntity> aspectIterator() {
		return new AspectIterator();
	}

	public <E extends IEntity> IEntityIterator<E> selfIterator() {
		return new SelfIterator<E>();
	}

	public <E extends IEntity> IEntityIterator<E> repeatedSelfIterator() {
		return new SelfIterator<E>() {
			@Override
			public E next() {
				return entity = super.next();
			}
		};
	}

	public IEntityIterator<IEntity> rootIterator() {
		return new RootIterator();
	}
	public IEntityIterator<IEntity> fragmentRootIterator() {
		return new FragmentRootIterator();
	}

	public <E extends IEntity> IEntityIterator<E> parentIterator() {
		return new ParentIterator<E>();
	}

	public <E extends IEntity> IEntityIterator<E> ancestorIterator() {
		return new AncestorIterator<E>(false);
	}
	public <E extends IEntity> IEntityIterator<E> ancestorOrSelfIterator() {
		return new AncestorIterator<E>(true);
	}

	public IEntityIterator<IEntity> ancestorReverseIterator() {
		return new AncestorReverseIterator();
	}
	public IEntityIterator<IEntity> ancestorOrSelfReverseIterator() {
		return new AncestorOrSelfReverseIterator();
	}

	public IEntityIterator<IEntity> inverseAdjacentIterator() {
		return new InverseAdjacentIterator();
	}
	public IEntityIterator<IEntity> inverseReachableIterator(boolean includeSelf) {
		DistinctScope<IEntity> distinctScope = distinctScope(ObjectIdentityComparator.instance);
		return distinctScope.withIterator(inverseReachableIterator(includeSelf, distinctScope));
	}
	public IEntityIterator<IEntity> inverseReachableIterator(boolean includeSelf, DistinctScope<IEntity> distinctScope) {
		return new InverseReachableIterator(includeSelf, distinctScope);
	}

	public IEntityIterator<IEntity> featureByNameIterator(String fdUri) {
		return new FeatureByNameIterator(fdUri);
	}
	public IEntityIterator<IEntity> featureByNameIterator(FeatureDescriptor fd) {
		return new FeatureByNameIterator(fd);
	}

	public IEntityIterator<IEntity> featureByIndexIterator(int relativeIndex) {
		return new FeatureByIndexIterator(relativeIndex);
	}

	public <E extends IEntity> IEntityIterator<E> childIterator() {
		return new ChildIterator<E>(true);
	}
	public <E extends IEntity> IEntityIterator<E> childIterator(int relativeFirstIndex) {
		return new ChildIterator<E>(true, relativeFirstIndex);
	}

	public <E extends IEntity> IEntityIterator<E> childReverseIterator() {
		return new ChildIterator<E>(false);
	}
	public <E extends IEntity> IEntityIterator<E> childReverseIterator(int relativeFirstIndex) {
		return new ChildIterator<E>(false, relativeFirstIndex);
	}
	public <E extends IEntity> IEntityIterator<E> childRangeIterator(int relativeStartIndex, int relativeEndIndex) {
		return new ChildRangeIterator<E>(true, relativeStartIndex, relativeEndIndex);
	}

	public <E extends IEntity> IEntityIterator<E> descendantIterator() {
		return new DescendantIterator<E>(false);
	}
	public <E extends IEntity> IEntityIterator<E> descendantReverseIterator() {
		return new DescendantReverseIterator<E>(false);
	}
	public <E extends IEntity> IEntityIterator<E> descendantOrSelfIterator() {
		return new DescendantIterator<E>(true);
	}
	public <E extends IEntity> IEntityIterator<E> descendantOrSelfReverseIterator() {
		return new DescendantReverseIterator<E>(true);
	}

	public <E extends IEntity> IEntityIterator<E> followingSiblingIterator() {
		return new FollowingSiblingIterator<E>(true, false);
	}
	public <E extends IEntity> IEntityIterator<E> followingSiblingReverseIterator() {
		return new FollowingSiblingIterator<E>(false, false);
	}
	public <E extends IEntity> IEntityIterator<E> precedingSiblingIterator() {
		return new PrecedingSiblingIterator<E>(false, false);
	}
	public <E extends IEntity> IEntityIterator<E> precedingSiblingReverseIterator() {
		return new PrecedingSiblingIterator<E>(true, false);
	}

	public <E extends IEntity> IEntityIterator<E> followingSiblingOrSelfIterator() {
		return new FollowingSiblingIterator<E>(true, true);
	}
	public <E extends IEntity> IEntityIterator<E> followingSiblingOrSelfReverseIterator() {
		return new FollowingSiblingIterator<E>(false, true);
	}
	public <E extends IEntity> IEntityIterator<E> precedingSiblingOrSelfIterator() {
		return new PrecedingSiblingIterator<E>(false, true);
	}
	public <E extends IEntity> IEntityIterator<E> precedingSiblingOrSelfReverseIterator() {
		return new PrecedingSiblingIterator<E>(true, true);
	}

	public <E extends IEntity> IEntityIterator<E> followingIterator() {
		return new FollowingIterator<E>(false);
	}
	public <E extends IEntity> IEntityIterator<E> precedingIterator() {
		return new PrecedingIterator<E>(false);
	}

	public <E extends IEntity> IEntityIterator<E> followingOrSelfIterator() {
		return new FollowingIterator<E>(true);
	}
	public <E extends IEntity> IEntityIterator<E> precedingOrSelfIterator() {
		return new PrecedingIterator<E>(true);
	}

	public <E extends IEntity> IEntityIterator<E> adjacentIterator() {
		return new AdjacentIterator<E>(true);
	}
	public <E extends IEntity> IEntityIterator<E> adjacentIterator(int relativeFirstIndex) {
		return new AdjacentIterator<E>(true, relativeFirstIndex);
	}
	public <E extends IEntity> IEntityIterator<E> adjacentReverseIterator() {
		return new AdjacentIterator<E>(false);
	}

	public <E extends IEntity> IEntityIterator<E> reachableIterator(boolean includeSelf) {
		DistinctScope<E> distinctScope = distinctScope(ObjectIdentityComparator.instance);
		return distinctScope.withIterator(reachableIterator(includeSelf, distinctScope));
	}
	public <E extends IEntity> IEntityIterator<E> reachableIterator(boolean includeSelf, DistinctScope<E> distinctScope) {
		return new ReachableIterator<E>(includeSelf, distinctScope);
	}

	public <E extends IEntity> IEntityIterator<E> childOrAdjacentIterator() {
		return new ChildOrAdjacentIterator<E>(true);
	}
	public <E extends IEntity> IEntityIterator<E> childOrAdjacentIterator(int relativeFirstIndex) {
		return new ChildOrAdjacentIterator<E>(true, relativeFirstIndex);
	}

	public <E extends IEntity> IEntityIterator<E> descendantOrReachableIterator() {
		DistinctScope<E> distinctScope = distinctScope(ObjectIdentityComparator.instance);
		return distinctScope.withIterator(descendantOrReachableIterator(false, distinctScope));
	}
	public <E extends IEntity> IEntityIterator<E> descendantOrReachableIterator(boolean includeSelf, DistinctScope<E> distinctScope) {
		return new DescendantOrReachableIterator<E>(includeSelf, distinctScope);
	}

	public <E extends IEntity> ScannerIterator<E> scannerIterator(IEntityIterator<E> iterator) {
		return new ScannerIterator<E>(iterator);
	}
	public <E extends IEntity> MatcherIterator<E> matcherIterator(IEntityIterator<E> iterator) {
		return new MatcherIterator<E>(iterator);
	}

	public <E extends IEntity> IEntityIterator<E> filterIterator(IEntityIterator<E> iterator, IEntityIterator<? extends IEntity> filterIterator) {
		return new FilterIterator<E>(iterator, filterIterator);
	}

	public static class FilterIterator<E extends IEntity> extends MatcherIterator<E> {
		protected IEntityIterator<? extends IEntity> filterIterator;

		protected FilterIterator(IEntityIterator<E> iterator, IEntityIterator<? extends IEntity> filterIterator) {
			super(iterator);
			this.filterIterator = filterIterator;
		}

		@Override
		public IEntityIterator<E> clone(ICloneContext cc) {
			FilterIterator<E> iterator = (FilterIterator<E>) super.clone(cc);
			iterator.filterIterator = cc.clone(filterIterator);
			return iterator;
		}

		@Override
		protected E patternFilteredLookahead() {
			boolean found = false;
			E lookahead = null;
			while (iterator.hasNext() && !(found = filter(lookahead = iterator.lookahead()))) {
				lookaheadScope().wClear();
				iterator.next();
			}
			if (!found)
				lookahead = null;
			return lookahead;
		}

		protected boolean filter(IEntity selfEntity) {
			return filterIterator.tryEvaluateAsBoolean(selfEntity, getBindings());
		}

	    @Override
		public void toString(StringBuilder sb) {
	    	iterator.toString(sb);
	    	sb.append("[");
	    	filterIterator.toString(sb);
	    	sb.append("]");
	    }
	}

	public IEntityIterator<IEntity> matchInScopeIterator(IEntityIterator<IEntity> patternIterator) {
		return new AbstractSingleValuedRunnableIterator<IEntity>(patternIterator) {
			protected void run(IEntity selfEntity, IBindingManager bm) {
				IEntity pattern = argsIterators[0].evaluateNext();
				bm.setResult(BindingManagerFactory.instance.createValue(pattern != null && Matcher.match(pattern, selfEntity, bm)));
			}

			public void toString(StringBuilder sb) {
				sb.append("matchInScope(");
				argsIterators[0].toString(sb);//TODO startOf
				sb.append(")");
			}
		};
	}


	public <E extends IEntity> IEntityIterator<E> ifIterator(IEntityIterator<? extends IEntity> conditionIterator, IEntityIterator<E> doIterator) {
		return new IfIterator<E>(conditionIterator, doIterator);
	}
	public <E extends IEntity> IEntityIterator<E> forIterator(IEntityIterator<? extends IEntity> forIterator, IEntityIterator<E> doIterator) {
		return new ForIterator<E>(forIterator, doIterator);
	}

	public IEntityIterator<IEntity> functionApplicationIterator(String functionUri) {
		return new FunctionApplicationIterator(functionUri);
	}
	public IEntityIterator<IEntity> recursiveFunctionApplicationIterator() {
		return new RecursiveFunctionApplicationIterator();
	}
	public <E extends IEntity> IEntityIterator<E> templateInterpreterIterator(IEntity template) {
		return new TemplateInterpreterIterator<E>(template);
	}

	public <E extends IEntity> IEntityIterator<E> chooseIterator(IEntityIterator<? extends E>... iteratorChain) {
		return new ChooseByOrderIterator<E>(iteratorChain);
	}

	public <E extends IEntity> IEntityIterator<E> chooseIterator(ILanguageKit languageKit) {
		return new ChooseByTypeIterator<E>(languageKit);
	}

	public <E extends IEntity> IEntityIterator<E> blockIterator(IEntityIterator<? extends E>... iteratorChain) {
		return new BlockIterator<E>(iteratorChain);
	}

	public <E extends IEntity> IEntityIterator<E> sequenceIterator(IEntityIterator<? extends E>... iteratorChain) {
		return new SequenceIterator<E>(iteratorChain);
	}

	public <E extends IEntity> IEntityIterator<E> composeIterator(IEntityIterator<E> iterator, IEntityIterator<? extends IEntity>... nestedIterators) {
		return new ComposeIterator<E>(iterator, nestedIterators);
	}

	public <E extends IEntity> IEntityIterator<E> filterByIndexIterator(IEntityIterator<E> iterator, int index) {
		return new FilterByIndexRangeIterator<E>(iterator, index, index);
	}
	public <E extends IEntity> IEntityIterator<E> filterByIndexRangeIterator(IEntityIterator<E> iterator, int startIndex, int endIndex) {
		return new FilterByIndexRangeIterator<E>(iterator, startIndex, endIndex);
	}
	public <E extends IEntity> IEntityIterator<E> filterByIndexRangeIterator() {
		return new FilterByIndexRangeIterator<E>();
	}

	public <E extends IEntity> DistinctScope<E> distinctScope() {
		return new FilterByDistinctIterator<E>();
	}
	public <E extends IEntity> DistinctScope<E> distinctScope(IEntityComparator<IEntity> comparator) {
		return new FilterByDistinctIterator<E>(comparator);
	}

	public <E extends IEntity> IEntityIterator<E> sort(IEntityIterator<E> iterator) {
		return new SortIterator<E>(iterator);
	}
	public <E extends IEntity> IEntityIterator<E> sort(IEntityIterator<E> iterator, IEntityComparator<E> comparator) {
		return new SortIterator<E>(iterator, comparator);
	}

	@SuppressWarnings("unchecked")
	public IEntityIterator<IEntity> unionAllIterator(IEntityIterator<? extends IEntity>... iteratorChain) {
		return new UnionAllIterator(iteratorChain);
	}
	@SuppressWarnings("unchecked")
	public IEntityIterator<IEntity> unionIterator(IEntityIterator<? extends IEntity>... iteratorChain) {
		return new UnionIterator(iteratorChain);
	}
	@SuppressWarnings("unchecked")
	public IEntityIterator<IEntity> intersectIterator(IEntityIterator<? extends IEntity>... iteratorChain) {
		return new IntersectIterator(iteratorChain);
	}
	@SuppressWarnings("unchecked")
	public IEntityIterator<IEntity> exceptIterator(IEntityIterator<? extends IEntity>... iteratorChain) {
		return new ExceptIterator(iteratorChain);
	}


	public <E extends IEntity> IEntityIterator<E> ancestorScannerIterator() {
		return scannerIterator(IteratorFactory.instance.<E>ancestorIterator());
	}
	public <E extends IEntity> ScannerIterator<E> childScannerIterator() {
		return scannerIterator(IteratorFactory.instance.<E>childIterator());
	}
	public <E extends IEntity> ScannerIterator<E> childReverseScannerIterator() {
		return scannerIterator(IteratorFactory.instance.<E>childReverseIterator());
	}
	public <E extends IEntity> ScannerIterator<E> descendantOrSelfScannerIterator() {
		return scannerIterator(IteratorFactory.instance.<E>descendantOrSelfIterator());
	}
	public <E extends IEntity> ScannerIterator<E> descendantOrSelfReverseScannerIterator() {
		return scannerIterator(IteratorFactory.instance.<E>descendantOrSelfReverseIterator());
	}

	public <E extends IEntity> MatcherIterator<E> ancestorMatcherIterator() {
		return matcherIterator(IteratorFactory.instance.<E>ancestorIterator());
	}
	public <E extends IEntity> MatcherIterator<E> ancestorOrSelfMatcherIterator() {
		return matcherIterator(IteratorFactory.instance.<E>ancestorOrSelfIterator());
	}
	public <E extends IEntity> MatcherIterator<E> childMatcherIterator() {
		return matcherIterator(IteratorFactory.instance.<E>childIterator());
	}
	public <E extends IEntity> MatcherIterator<E> childReverseMatcherIterator() {
		return matcherIterator(IteratorFactory.instance.<E>childReverseIterator());
	}
	public <E extends IEntity> MatcherIterator<E> descendantOrSelfMatcherIterator() {
		return matcherIterator(IteratorFactory.instance.<E>descendantOrSelfIterator());
	}
	public <E extends IEntity> MatcherIterator<E> descendantOrSelfReverseMatcherIterator() {
		return matcherIterator(IteratorFactory.instance.<E>descendantOrSelfReverseIterator());
	}

	public IEntityIterator<IEntity> atStageIterator(int stage) {
		return new AbstractSingleValuedRunnableIterator<IEntity>() {
			protected void run(IEntity selfEntity, IBindingManager bm) {
				bm.setResult(BindingManagerFactory.instance.createValue(bm.wGetEnvironmentManager().getCurrentOperation().getStage() == stage));
			}

			public void toString(StringBuilder sb) {
				sb.append("atStage(");
				sb.append(stage);
				sb.append(")");
			}
		};
	}
	public IEntityIterator<IEntity> atHostStageIterator() {
		return new AbstractSingleValuedRunnableIterator<IEntity>() {
			protected void run(IEntity selfEntity, IBindingManager bm) {
				bm.setResult(BindingManagerFactory.instance.createValue(bm.wGetEnvironmentManager().getCurrentOperation().getStage() <= 0));
			}

			public void toString(StringBuilder sb) {
				sb.append("atHostStage()");
			}
		};
	}
	public IEntityIterator<IEntity> atTemplateStageIterator() {
		return new AbstractSingleValuedRunnableIterator<IEntity>() {
			protected void run(IEntity selfEntity, IBindingManager bm) {
				bm.setResult(BindingManagerFactory.instance.createValue(bm.wGetEnvironmentManager().getCurrentOperation().getStage() > 0));
			}

			public void toString(StringBuilder sb) {
				sb.append("atTemplateStage()");
			}
		};
	}

	public IEntityIterator<IEntity> hasKindIterator(EntityKinds kind) {
		return new AbstractSingleValuedRunnableIterator<IEntity>() {
			protected void run(IEntity selfEntity, IBindingManager bm) {
				bm.setResult(BindingManagerFactory.instance.createValue(kind.equals(selfEntity.wGetEntityKind())));
			}

			public void toString(StringBuilder sb) {
				sb.append("hasKind(");
				sb.append(kind);
				sb.append(")");
			}
		};
	}
	public IEntityIterator<IEntity> hasCompositeKindIterator(CompositeKinds kind) {
		return new AbstractSingleValuedRunnableIterator<IEntity>() {
			protected void run(IEntity selfEntity, IBindingManager bm) {
				bm.setResult(BindingManagerFactory.instance.createValue(kind.equals(selfEntity.wGetEntityDescriptor().getCompositeKind())));
			}

			public void toString(StringBuilder sb) {
				sb.append("hasCompositeKind(");
				sb.append(kind);
				sb.append(")");
			}
		};
	}
	public IEntityIterator<IEntity> hasDataKindIterator(DataKinds kind) {
		return new AbstractSingleValuedRunnableIterator<IEntity>() {
			protected void run(IEntity selfEntity, IBindingManager bm) {
				bm.setResult(BindingManagerFactory.instance.createValue(kind.equals(selfEntity.wGetEntityDescriptor().getDataKind())));
			}

			public void toString(StringBuilder sb) {
				sb.append("hasDataKind(");
				sb.append(kind);
				sb.append(")");
			}
		};
	}
	public IEntityIterator<IEntity> isFragmentIterator() {
		return new AbstractSingleValuedRunnableIterator<IEntity>() {
			protected void run(IEntity selfEntity, IBindingManager bm) {
				bm.setResult(BindingManagerFactory.instance.createValue(EntityUtils.isFragment(selfEntity)));
			}

			public void toString(StringBuilder sb) {
				sb.append("isFragment()");
			}
		};
	}
	public IEntityIterator<IEntity> isVariableIterator() {
		return new AbstractSingleValuedRunnableIterator<IEntity>() {
			protected void run(IEntity selfEntity, IBindingManager bm) {
				bm.setResult(BindingManagerFactory.instance.createValue(EntityUtils.isVariable(selfEntity)));
			}

			public void toString(StringBuilder sb) {
				sb.append("isVariable()");
			}
		};
	}
	public IEntityIterator<IEntity> isResolverIterator() {
		return new AbstractSingleValuedRunnableIterator<IEntity>() {
			protected void run(IEntity selfEntity, IBindingManager bm) {
				bm.setResult(BindingManagerFactory.instance.createValue(EntityUtils.isResolver(selfEntity)));
			}

			public void toString(StringBuilder sb) {
				sb.append("isResolver()");
			}
		};
	}
	public IEntityIterator<IEntity> isImplIterator() {
		return new AbstractSingleValuedRunnableIterator<IEntity>() {
			protected void run(IEntity selfEntity, IBindingManager bm) {
				bm.setResult(BindingManagerFactory.instance.createValue(EntityUtils.isNotResolver(selfEntity)));
			}

			public void toString(StringBuilder sb) {
				sb.append("isImpl()");
			}
		};
	}

	public IEntityIterator<?> andIterator(IEntityIterator<?>... argsIterators) {
		return new AbstractSingleValuedRunnableIterator<IEntity>(argsIterators) {
			protected void run(IEntity selfEntity, IBindingManager bm) {
				for (int i=0; i<argsIterators.length; i++)
					if (!argsIterators[i].tryEvaluateAsBoolean(selfEntity, bm)) {
						bm.setResult(BindingManagerFactory.instance.createValue(false));
						return;
					}

				bm.setResult(BindingManagerFactory.instance.createValue(true));
			}

			public void toString(StringBuilder sb) {
				sb.append("and");
				super.toString(sb);
			}
		};
	}
	public IEntityIterator<?> orIterator(IEntityIterator<?>... argsIterators) {
		return new AbstractSingleValuedRunnableIterator<IEntity>(argsIterators) {
			protected void run(IEntity selfEntity, IBindingManager bm) {
				for (int i=0; i<argsIterators.length; i++)
					if (argsIterators[i].tryEvaluateAsBoolean(selfEntity, bm)) {
						bm.setResult(BindingManagerFactory.instance.createValue(true));
						return;
					}

				bm.setResult(BindingManagerFactory.instance.createValue(false));
			}

			public void toString(StringBuilder sb) {
				sb.append("or");
				super.toString(sb);
			}
		};
	}
	public IEntityIterator<?> notIterator(IEntityIterator<?> argIterator) {
		return new AbstractSingleValuedRunnableIterator<IEntity>(argIterator) {
			protected void run(IEntity selfEntity, IBindingManager bm) {
				bm.setResult(BindingManagerFactory.instance.createValue(!argsIterators[0].tryEvaluateAsBoolean(selfEntity, bm)));
			}

			public void toString(StringBuilder sb) {
				sb.append("not");
				super.toString(sb);
			}
		};
	}

	public IEntityIterator<IEntity> oneIterator(IEntityIterator<IEntity> fromClause, IEntityIterator<IEntity> satisfiesClause) {
		return new AbstractSingleValuedRunnableIterator<IEntity>(fromClause, satisfiesClause) {
			protected void run(IEntity selfEntity, IBindingManager bm) {
				IBindingScope laScope = null;
				for (IEntity e : argsIterators[0]) {
					if (!argsIterators[1].tryEvaluateAsBoolean(e, bm))
						continue;

					if (laScope != null) {
						bm.setResult(BindingManagerFactory.instance.createValue(false));
						return;
					} else {
						laScope = BindingManagerFactory.instance.createSimpleScope();
						laScope.wAddAll(argsIterators[0].lookaheadScope());
						laScope.wAddAll(argsIterators[1].lookaheadScope());
					}
				}

				if (laScope == null) {
					bm.setResult(BindingManagerFactory.instance.createValue(false));
					return;
				}
				
				bm.wAddAll(laScope);
				bm.setResult(BindingManagerFactory.instance.createValue(true));
			}

			public void toString(StringBuilder sb) {
				sb.append("one(");
				argsIterators[0].toString(sb);//TODO startOf
				sb.append(" satisfies ");
				argsIterators[1].toString(sb);//TODO startOf
				sb.append(")");
			}
		};
	}
	public IEntityIterator<IEntity> someIterator(IEntityIterator<IEntity> fromClause) {
		return new AbstractSingleValuedRunnableIterator<IEntity>(fromClause) {
			protected void run(IEntity selfEntity, IBindingManager bm) {
				if (argsIterators[0].hasNext()) {
					argsIterators[0].next();
					bm.setResult(BindingManagerFactory.instance.createValue(true));
					return;
				}

				bm.setResult(BindingManagerFactory.instance.createValue(false));
			}

			public void toString(StringBuilder sb) {
				sb.append("exists(");
				argsIterators[0].toString(sb);//TODO startOf
				sb.append(")");
			}
		};
	}
	public IEntityIterator<IEntity> someIterator(IEntityIterator<IEntity> fromClause, IEntityIterator<IEntity> satisfiesClause) {
		return new AbstractSingleValuedRunnableIterator<IEntity>(fromClause, satisfiesClause) {
			protected void run(IEntity selfEntity, IBindingManager bm) {
				for (IEntity e : argsIterators[0]) {
					argsIterators[1].reset(e);

					if (argsIterators[1].next().wBooleanValue()) {
						bm.setResult(BindingManagerFactory.instance.createValue(true));
						return;
					}
				}

				bm.setResult(BindingManagerFactory.instance.createValue(false));
			}

			public void toString(StringBuilder sb) {
				sb.append("some(");
				argsIterators[0].toString(sb);//TODO startOf
				sb.append(" satisfies ");
				argsIterators[1].toString(sb);//TODO startOf
				sb.append(")");
			}
		};
	}
	public IEntityIterator<IEntity> everyIterator(IEntityIterator<IEntity> fromClause, IEntityIterator<IEntity> satisfiesClause) {
		return new AbstractSingleValuedRunnableIterator<IEntity>(fromClause, satisfiesClause) {
			protected void run(IEntity selfEntity, IBindingManager bm) {
				for (IEntity e : argsIterators[0])
					if (!argsIterators[1].tryEvaluateAsBoolean(e, bm)) {
						bm.setResult(BindingManagerFactory.instance.createValue(false));
						return;
					}

				bm.setResult(BindingManagerFactory.instance.createValue(true));
			}

			public void toString(StringBuilder sb) {
				sb.append("every(");
				argsIterators[0].toString(sb);//TODO startOf
				sb.append(" satisfies ");
				argsIterators[1].toString(sb);//TODO startOf
				sb.append(")");
			}
		};
	}

	public IEntityIterator<IEntity> isLanguageIterator(String languageURI) {
		return new AbstractSingleValuedRunnableIterator<IEntity>() {
			protected void run(IEntity selfEntity, IBindingManager bm) {
				bm.setResult(BindingManagerFactory.instance.createValue(languageURI.equals(selfEntity.wGetLanguageKit().getURI())));
			}

			public void toString(StringBuilder sb) {
				sb.append("isLanguage(\"");
				sb.append(languageURI);
				sb.append("\")");
			}
		};
	}

	public IEntityIterator<IEntity> hasTypeIterator(String typeUri) {
		return new TypeRelationIterator(typeUri) {
			protected boolean test(EntityDescriptor<?> typeEd, EntityDescriptor<?> selfEd) {
				return typeEd != null && selfEd.equals(typeEd);
			}
			protected String predicateName() {
				return "hasType";
			}
		};
	}
	public IEntityIterator<IEntity> isLanguageSubtypeOfIterator(String typeUri) {
		return new TypeRelationIterator(typeUri) {
			protected boolean test(EntityDescriptor<?> typeEd, EntityDescriptor<?> selfEd) {
				return typeEd != null && typeEd.isLanguageSupertypeOf(selfEd);
			}
			protected String predicateName() {
				return "isLanguageSubtypeOf";
			}
		};
	}
	public IEntityIterator<IEntity> isLanguageSupertypeOfIterator(String typeUri) {
		return new TypeRelationIterator(typeUri) {
			protected boolean test(EntityDescriptor<?> typeEd, EntityDescriptor<?> selfEd) {
				return typeEd != null && selfEd.isLanguageSupertypeOf(typeEd);
			}
			protected String predicateName() {
				return "isLanguageSupertypeOf";
			}
		};
	}
	public IEntityIterator<IEntity> isExtendedLanguageSubtypeOfIterator(String typeUri) {
		return new TypeRelationIterator(typeUri) {
			protected boolean test(EntityDescriptor<?> typeEd, EntityDescriptor<?> selfEd) {
				return typeEd != null && typeEd.isExtendedLanguageSupertypeOf(selfEd);
			}
			protected String predicateName() {
				return "isExtendedLanguageSubtypeOf";
			}
		};
	}
	public IEntityIterator<IEntity> isExtendedLanguageSupertypeOfIterator(String typeUri) {
		return new TypeRelationIterator(typeUri) {
			protected boolean test(EntityDescriptor<?> typeEd, EntityDescriptor<?> selfEd) {
				return typeEd != null && selfEd.isExtendedLanguageSupertypeOf(typeEd);
			}
			protected String predicateName() {
				return "isExtendedLanguageSupertypeOf";
			}
		};
	}
	public abstract static class TypeRelationIterator extends AbstractSingleValuedRunnableIterator<IEntity> {
		protected final String typeUri;
		public TypeRelationIterator(String typeUri) {
			this.typeUri = typeUri;
		}
		public void run(IEntity selfEntity, IBindingManager bm) {
			EntityDescriptor<?> selfEd = selfEntity.wGetEntityDescriptor();
			EntityDescriptor<?> typeEd = getEntityDescriptor(typeUri, selfEd, bm);
			bm.setResult(BindingManagerFactory.instance.createValue(test(typeEd, selfEd)));
		}
		protected abstract boolean test(EntityDescriptor<?> typeEd, EntityDescriptor<?> selfEd);

		public void toString(StringBuilder sb) {
			sb.append(predicateName());
			sb.append("(\"");
			sb.append(typeUri);
			sb.append("\")");
		}
		protected abstract String predicateName(); 
	}

	public IEntityIterator<IEntity> atTypeIterator(String edUri) {
		return new AbstractSingleValuedRunnableIterator<IEntity>() {
			protected void run(IEntity selfEntity, IBindingManager bm) {
				EntityDescriptor<?> selfEd = selfEntity.wGetParent().wGetEntityDescriptor(selfEntity);
				EntityDescriptor<?> ed = getEntityDescriptor(edUri, selfEd, bm);
				bm.setResult(BindingManagerFactory.instance.createValue(ed != null && ed.equals(selfEd)));
			}

			public void toString(StringBuilder sb) {
				sb.append("atType(\"");
				sb.append(edUri);
				sb.append("\")");
			}
		};
	}
	protected static final EntityDescriptor<?> getEntityDescriptor(String edUri, EntityDescriptor<?> selfEd, IBindingManager bm) {
		return ResourceUtils.hasFragmentPart(edUri) ?
				CommonsDataTypePersistenceParser.getEntityDescriptor(edUri, true, bm) : selfEd.getEntityDescriptorEnum().valueOf(edUri);		
	}

	public IEntityIterator<IEntity> atFeatureIterator(String fdUri) {
		return new AbstractSingleValuedRunnableIterator<IEntity>() {
			protected void run(IEntity selfEntity, IBindingManager bm) {
				FeatureDescriptor selfFd = selfEntity.wGetParent().wGetFeatureDescriptor(selfEntity);
				FeatureDescriptor fd = getFeatureDescriptor(fdUri, selfFd, bm);
				bm.setResult(BindingManagerFactory.instance.createValue(fd != null && fd.equals(selfFd)));
			}

			public void toString(StringBuilder sb) {
				sb.append("atFeature(\"");
				sb.append(fdUri);
				sb.append("\")");
			}
		};
	}
	protected static final FeatureDescriptor getFeatureDescriptor(String fdUri, FeatureDescriptor selfFd, IBindingManager bm) {
		return ResourceUtils.hasFragmentPart(fdUri) ?
				CommonsDataTypePersistenceParser.getFeatureDescriptor(fdUri, true, bm) : selfFd.getFeatureDescriptorEnum().valueOf(fdUri);		
	}

	public IEntityIterator<IEntity> atIndexIterator(int index) {
		return new AbstractSingleValuedRunnableIterator<IEntity>() {
			protected void run(IEntity selfEntity, IBindingManager bm) {
				IEntity parent = selfEntity.wGetParent();
				int selfIndex = parent.wIndexOf(selfEntity);
				if (index < 0)
					selfIndex -= parent.wSize();
				bm.setResult(BindingManagerFactory.instance.createValue(selfIndex == index));
			}

			public void toString(StringBuilder sb) {
				sb.append("atIndex(");
				if (index < 0)
					sb.append("size");
				sb.append(index);
				sb.append(")");
			}
		};
	}

	public IEntityIterator<IEntity> asVariableIterator(String name) {
		final boolean hasEnvironmentPart = BindingUtils.hasEnvironmentPart(name);
		final int index = name.indexOf('#');
		final String envName = hasEnvironmentPart ? name.substring(BindingUtils.ENVIRONMENT_URI_PREFIX.length(), index) : null;
		final String varName = hasEnvironmentPart ? name.substring(index+1) : name;

		return new AbstractSingleValuedRunnableIterator<IEntity>() {
			protected void run(IEntity selfEntity, IBindingManager bm) {
				run(selfEntity, hasEnvironmentPart ? bm.wGetEnvironmentManager().getEnvironment(envName) : bm, varName);
			};
			protected final void run(IEntity selfEntity, IBindingManager bm, String name) {
				if (bm.wIsSet(name))
					bm.setResult(BindingManagerFactory.instance.createValue(Matcher.match(bm.wGet(name), selfEntity)));
				else {
					bm.wDef(name, selfEntity);
					bm.setResult(BindingManagerFactory.instance.createValue(true));
				}
			}

			public void toString(StringBuilder sb) {
				sb.append("as($");
				sb.append(name);
				sb.append(")");
			}
		};
	}
	public IEntityIterator<IEntity> atStageVariableIterator(String name) {
		final boolean hasEnvironmentPart = BindingUtils.hasEnvironmentPart(name);
		final int index = name.indexOf('#');
		final String envName = hasEnvironmentPart ? name.substring(BindingUtils.ENVIRONMENT_URI_PREFIX.length(), index) : null;
		final String varName = hasEnvironmentPart ? name.substring(index+1) : name;

		return new AbstractSingleValuedRunnableIterator<IEntity>() {
			protected void run(IEntity selfEntity, IBindingManager bm) {
				run(selfEntity, hasEnvironmentPart ? bm.wGetEnvironmentManager().getEnvironment(envName) : bm, varName);
			};
			protected final void run(IEntity selfEntity, IBindingManager bm, String name) {
				int selfStage = bm.wGetEnvironmentManager().getCurrentOperation().getStage();
				if (bm.wIsSet(name)) {
					bm.setResult(BindingManagerFactory.instance.createValue(bm.wIntValue(name) == selfStage));
				} else {
					bm.wDefValue(name, selfStage);
					bm.setResult(BindingManagerFactory.instance.createValue(true));
				}
			}

			public void toString(StringBuilder sb) {
				sb.append("atStageAs($");
				sb.append(name);
				sb.append(")");
			}
		};
	}
	public IEntityIterator<IEntity> languageVariableIterator(String name) {
		final boolean hasEnvironmentPart = BindingUtils.hasEnvironmentPart(name);
		final int index = name.indexOf('#');
		final String envName = hasEnvironmentPart ? name.substring(BindingUtils.ENVIRONMENT_URI_PREFIX.length(), index) : null;
		final String varName = hasEnvironmentPart ? name.substring(index+1) : name;

		return new AbstractSingleValuedRunnableIterator<IEntity>() {
			protected void run(IEntity selfEntity, IBindingManager bm) {
				run(selfEntity, hasEnvironmentPart ? bm.wGetEnvironmentManager().getEnvironment(envName) : bm, varName);
			};
			protected final void run(IEntity selfEntity, IBindingManager bm, String name) {
				String languageUri = selfEntity.wGetLanguageKit().getURI();
				if (bm.wIsSet(name)) {
					bm.setResult(BindingManagerFactory.instance.createValue(bm.wStringValue(name).equals(languageUri)));
				} else {
					bm.wDefValue(name, languageUri);
					bm.setResult(BindingManagerFactory.instance.createValue(true));
				}
			}

			public void toString(StringBuilder sb) {
				sb.append("languageAs($");
				sb.append(name);
				sb.append(")");
			}
		};
	}
	public IEntityIterator<IEntity> typeVariableIterator(String name) {
		final boolean hasEnvironmentPart = BindingUtils.hasEnvironmentPart(name);
		final int index = name.indexOf('#');
		final String envName = hasEnvironmentPart ? name.substring(BindingUtils.ENVIRONMENT_URI_PREFIX.length(), index) : null;
		final String varName = hasEnvironmentPart ? name.substring(index+1) : name;

		return new AbstractSingleValuedRunnableIterator<IEntity>() {
			protected void run(IEntity selfEntity, IBindingManager bm) {
				run(selfEntity, hasEnvironmentPart ? bm.wGetEnvironmentManager().getEnvironment(envName) : bm, varName);
			};
			protected final void run(IEntity selfEntity, IBindingManager bm, String name) {
				String entityUri = selfEntity.wGetEntityDescriptor().getURI();
				if (bm.wIsSet(name)) {
					bm.setResult(BindingManagerFactory.instance.createValue(bm.wStringValue(name).equals(entityUri)));
				} else {
					bm.wDefValue(name, entityUri);
					bm.setResult(BindingManagerFactory.instance.createValue(true));
				}
			}

			public void toString(StringBuilder sb) {
				sb.append("typeAs($");
				sb.append(name);
				sb.append(")");
			}
		};
	}
	public IEntityIterator<IEntity> languageSubtypeOfVariableIterator(String name) {
		final boolean hasEnvironmentPart = BindingUtils.hasEnvironmentPart(name);
		final int index = name.indexOf('#');
		final String envName = hasEnvironmentPart ? name.substring(BindingUtils.ENVIRONMENT_URI_PREFIX.length(), index) : null;
		final String varName = hasEnvironmentPart ? name.substring(index+1) : name;

		return new AbstractSingleValuedRunnableIterator<IEntity>() {
			protected void run(IEntity selfEntity, IBindingManager bm) {
				run(selfEntity, hasEnvironmentPart ? bm.wGetEnvironmentManager().getEnvironment(envName) : bm, varName);
			};
			protected final void run(IEntity selfEntity, IBindingManager bm, String name) {
				EntityDescriptor<?> selfEd = selfEntity.wGetEntityDescriptor();
				if (bm.wIsSet(name)) {
					EntityDescriptor<?> ed = CommonsDataTypePersistenceParser.getEntityDescriptor(bm.wStringValue(name), true, bm);
					bm.setResult(BindingManagerFactory.instance.createValue(ed != null && ed.isLanguageSupertypeOf(selfEd)));
				} else {
					bm.wDefValue(name, selfEd.getURI());
					bm.setResult(BindingManagerFactory.instance.createValue(true));
				}
			}

			public void toString(StringBuilder sb) {
				sb.append("languageSubtypeAs($");
				sb.append(name);
				sb.append(")");
			}
		};
	}
	public IEntityIterator<IEntity> languageSupertypeOfVariableIterator(String name) {
		final boolean hasEnvironmentPart = BindingUtils.hasEnvironmentPart(name);
		final int index = name.indexOf('#');
		final String envName = hasEnvironmentPart ? name.substring(BindingUtils.ENVIRONMENT_URI_PREFIX.length(), index) : null;
		final String varName = hasEnvironmentPart ? name.substring(index+1) : name;

		return new AbstractSingleValuedRunnableIterator<IEntity>() {
			protected void run(IEntity selfEntity, IBindingManager bm) {
				run(selfEntity, hasEnvironmentPart ? bm.wGetEnvironmentManager().getEnvironment(envName) : bm, varName);
			};
			protected final void run(IEntity selfEntity, IBindingManager bm, String name) {
				EntityDescriptor<?> selfEd = selfEntity.wGetEntityDescriptor();
				if (bm.wIsSet(name)) {
					EntityDescriptor<?> ed = CommonsDataTypePersistenceParser.getEntityDescriptor(bm.wStringValue(name), true, bm);
					bm.setResult(BindingManagerFactory.instance.createValue(ed != null && selfEd.isLanguageSupertypeOf(ed)));
				} else {
					bm.wDefValue(name, selfEd.getURI());
					bm.setResult(BindingManagerFactory.instance.createValue(true));
				}
			}

			public void toString(StringBuilder sb) {
				sb.append("languageSupertypeAs($");
				sb.append(name);
				sb.append(")");
			}
		};
	}
	public IEntityIterator<IEntity> extendedLanguageSubtypeOfVariableIterator(String name) {
		final boolean hasEnvironmentPart = BindingUtils.hasEnvironmentPart(name);
		final int index = name.indexOf('#');
		final String envName = hasEnvironmentPart ? name.substring(BindingUtils.ENVIRONMENT_URI_PREFIX.length(), index) : null;
		final String varName = hasEnvironmentPart ? name.substring(index+1) : name;

		return new AbstractSingleValuedRunnableIterator<IEntity>() {
			protected void run(IEntity selfEntity, IBindingManager bm) {
				run(selfEntity, hasEnvironmentPart ? bm.wGetEnvironmentManager().getEnvironment(envName) : bm, varName);
			};
			protected final void run(IEntity selfEntity, IBindingManager bm, String name) {
				EntityDescriptor<?> selfEd = selfEntity.wGetEntityDescriptor();
				if (bm.wIsSet(name)) {
					EntityDescriptor<?> ed = CommonsDataTypePersistenceParser.getEntityDescriptor(bm.wStringValue(name), true, bm);
					bm.setResult(BindingManagerFactory.instance.createValue(ed != null && ed.isExtendedLanguageSupertypeOf(selfEd)));
				} else {
					bm.wDefValue(name, selfEd.getURI());
					bm.setResult(BindingManagerFactory.instance.createValue(true));
				}
			}

			public void toString(StringBuilder sb) {
				sb.append("extendedLanguageSubtypeAs($");
				sb.append(name);
				sb.append(")");
			}
		};
	}
	public IEntityIterator<IEntity> extendedLanguageSupertypeOfVariableIterator(String name) {
		final boolean hasEnvironmentPart = BindingUtils.hasEnvironmentPart(name);
		final int index = name.indexOf('#');
		final String envName = hasEnvironmentPart ? name.substring(BindingUtils.ENVIRONMENT_URI_PREFIX.length(), index) : null;
		final String varName = hasEnvironmentPart ? name.substring(index+1) : name;

		return new AbstractSingleValuedRunnableIterator<IEntity>() {
			protected void run(IEntity selfEntity, IBindingManager bm) {
				run(selfEntity, hasEnvironmentPart ? bm.wGetEnvironmentManager().getEnvironment(envName) : bm, varName);
			};
			protected final void run(IEntity selfEntity, IBindingManager bm, String name) {
				EntityDescriptor<?> selfEd = selfEntity.wGetEntityDescriptor();
				if (bm.wIsSet(name)) {
					EntityDescriptor<?> ed = CommonsDataTypePersistenceParser.getEntityDescriptor(bm.wStringValue(name), true, bm);
					bm.setResult(BindingManagerFactory.instance.createValue(ed != null && selfEd.isExtendedLanguageSupertypeOf(ed)));
				} else {
					bm.wDefValue(name, selfEd.getURI());
					bm.setResult(BindingManagerFactory.instance.createValue(true));
				}
			}

			public void toString(StringBuilder sb) {
				sb.append("extendedLanguageSupertypeAs($");
				sb.append(name);
				sb.append(")");
			}
		};
	}
	public IEntityIterator<IEntity> iterationIndexVariableIterator(IEntityIterator<?> indexIterator, String name) {
		final boolean hasEnvironmentPart = BindingUtils.hasEnvironmentPart(name);
		final int index = name.indexOf('#');
		final String envName = hasEnvironmentPart ? name.substring(BindingUtils.ENVIRONMENT_URI_PREFIX.length(), index) : null;
		final String varName = hasEnvironmentPart ? name.substring(index+1) : name;

		return new AbstractSingleValuedRunnableIterator<IEntity>(indexIterator) {
			@Override
			protected void resetArguments(IEntity entity) {
			}
			@Override
			protected void setArgumentsBindings(IBindingManager bindings) {
			}

			protected void run(IEntity selfEntity, IBindingManager bm) {
				run(selfEntity, hasEnvironmentPart ? bm.wGetEnvironmentManager().getEnvironment(envName) : bm, varName);
			};
			protected final void run(IEntity selfEntity, IBindingManager bm, String name) {
				int iterationIndex = ((FilterByIndexRangeIterator<?>) argsIterators[0].specificIterator()).predicateIndex(this);
				if (bm.wIsSet(name)) {
					bm.setResult(BindingManagerFactory.instance.createValue(iterationIndex == bm.wIntValue(name)));
				} else {
					bm.wDefValue(name, iterationIndex);
					bm.setResult(BindingManagerFactory.instance.createValue(true));
				}
			}

			public void toString(StringBuilder sb) {
				sb.append("iterationAs($");
				sb.append(name);
				sb.append(")");
			}
		};
	}

	public IEntityIterator<IEntity> iterationIndexIterator(IEntityIterator<?> indexIterator, int index) {
		return new AbstractSingleValuedRunnableIterator<IEntity>(indexIterator) {
			@Override
			protected void resetArguments(IEntity entity) {
			}
			@Override
			protected void setArgumentsBindings(IBindingManager bindings) {
			}

			protected void run(IEntity selfEntity, IBindingManager bm) {
				int iterationIndex = ((FilterByIndexRangeIterator<?>) argsIterators[0].specificIterator()).predicateIndex(this);
				bm.setResult(BindingManagerFactory.instance.createValue(iterationIndex == index));
			}

			public void toString(StringBuilder sb) {
				sb.append("iteration(");
				sb.append(index);
				sb.append(")");
			}
		};
	}
	public IEntityIterator<IEntity> iterationIndexRangeIterator(IEntityIterator<?> indexIterator, int startIndex, int endIndex) {
		return new AbstractSingleValuedRunnableIterator<IEntity>(indexIterator) {
			@Override
			protected void resetArguments(IEntity entity) {
			}
			@Override
			protected void setArgumentsBindings(IBindingManager bindings) {
			}

			protected void run(IEntity selfEntity, IBindingManager bm) {
				int iterationIndex = ((FilterByIndexRangeIterator<?>) argsIterators[0].specificIterator()).predicateIndex(this);
				bm.setResult(BindingManagerFactory.instance.createValue(startIndex <= iterationIndex && iterationIndex <= endIndex));
			}

			public void toString(StringBuilder sb) {
				sb.append("iterationRange(");
				sb.append(startIndex);
				sb.append("..");
				sb.append(endIndex == Integer.MAX_VALUE ? "*" : String.valueOf(endIndex));
				sb.append(")");
			}
		};
	}

	public IEntityIterator<IEntity> pointwiseEqualsIterator(IEntityIterator<IEntity> leftOperand, IEntityIterator<IEntity> rightOperand) {
		return new AbstractSingleValuedRunnableIterator<IEntity>(leftOperand, rightOperand) {
			protected void run(IEntity selfEntity, IBindingManager bm) {
				for (IEntity e : argsIterators[0])
					if (!argsIterators[1].hasNext() || !e.wEquals(argsIterators[1].next())) {
						bm.setResult(BindingManagerFactory.instance.createValue(false));
						return;
					}

				bm.setResult(BindingManagerFactory.instance.createValue(true));
			}

			public void toString(StringBuilder sb) {
				sb.append("pointwiseEquals(");
				argsIterators[0].toString(sb);//TODO startOf
				sb.append(", ");
				argsIterators[1].toString(sb);//TODO startOf
				sb.append(")");
			}
		};
	}

	public <E extends IEntity> IEntityIterator<E> scopeIterator(IEntityIterator<E> scopeIterator, String environmentName, Set<String> localNames, boolean withFreshNames) {
    	return withFreshNames ? new LocalScopeIterator<E>(scopeIterator, localNames) :
    		new LocalScopeIterator<E>(scopeIterator, localNames) {
    			@Override
    			protected AbstractFilterScope createScopeFilter(Set<String> localNames) {
    				return BindingManagerFactory.instance.createIncludeFilterScope(localNames);
    			}
    		};
    }

	public IEntityIterator<?> tupleFactoryIterator(IEntityIterator<?>... tupleIterators) {
		return new TupleFactoryIterator(tupleIterators);
	}

	public <E extends IEntity> IEntityIterator<E> selectIterator(IEntityIterator<E> selectIterator, IEntityIterator<? extends IEntity> fromIterator, IEntityIterator<? extends IEntity> whereIterator) {
		return new SelectIterator<E>(selectIterator, fromIterator, whereIterator);
	}

	@SuppressWarnings("unchecked")
	public IEntityIterator<IEntity> cartesianProductIterator(IEntityIterator<? extends IEntity>... iterators) {
		return new CartesianProductIterator(iterators);
	}

	@SuppressWarnings("unchecked")
	public IEntityIterator<IEntity> pointwiseProductIterator(IEntityIterator<? extends IEntity>... iterators) {
		return new PointwiseProductIterator(iterators);
	}

	public <E extends IEntity> IEntityIterator<E> cartesianUpdateIterator(IEntityIterator<? extends E> valuesIterator, IEntityIterator<E> toIterator) {
		return new CartesianUpdateIterator<E>(valuesIterator, toIterator);
	}

	public <E extends IEntity> IEntityIterator<E> pointwiseUpdateIterator(IEntityIterator<E> valuesIterator, IEntityIterator<? super E> toIterator) {
		return new PointwiseUpdateIterator<E>(valuesIterator, toIterator);
	}

	public <E extends IEntity> IEntityIterator<E> cartesianInsertIterator(IEntityIterator<? extends E> valuesIterator, IEntityIterator<E> toIterator, Placement placement) {
		return new CartesianInsertIterator<E>(valuesIterator, toIterator, placement);
	}

	public <E extends IEntity> IEntityIterator<E> pointwiseInsertIterator(IEntityIterator<E> valuesIterator, IEntityIterator<? super E> toIterator, Placement placement) {
		return new PointwiseInsertIterator<E>(valuesIterator, toIterator, placement);
	}

	public <E extends IEntity> IEntityIterator<E> deleteIterator(IEntityIterator<E> valuesIterator) {
		return new DeleteIterator<E>(valuesIterator);
	}

	@SuppressWarnings("unchecked")
	public <E extends IEntity> IEntityIterator<E> callIterator(String name, IEntityIterator<? extends E>... argsIterators) {
    	return new CallIterator<E>(name, argsIterators);
    }

	public static final String outerSelfName = "outerSelf";
	public IEntityIterator<?> nestedVariableIterator() {
		return new AbstractMultiValuedRunnableIterator<IEntity>() {
			@Override
			protected void run(IEntity selfEntity, IBindingManager bm) {
					IEntity outerSelfEntity = bm.wGet("outerSelf");
					bm.wDef("self", outerSelfEntity);
					Variable variable = (Variable) selfEntity;
					String varName = variable.getVarName().getValue();
		        	IEntity value = BindingUtils.wGet(bm, varName);
					if (value != null) {
						CommonsInterpreterVisitor.setVariableValueResult(bm, variable, value);
					} else
						bm.setResult(EntityUtils.cloneIfParented(selfEntity));					
			}

			public void toString(StringBuilder sb) {
				sb.append("nestedVariable");
				super.toString(sb);
			}
		};
	}

	public IEntityIterator<?> nestedFragmentIterator(Map<IEntity, IEntityIterator<?>> fragmentIteratorMap) {
		return new AbstractMultiValuedRunnableIterator<IEntity>() {
			@Override
			protected void run(IEntity selfEntity, IBindingManager bm) {
				IEntityIterator<?> fragmentIterator = fragmentIteratorMap.getOrDefault(selfEntity, IteratorFactory.instance.emptyIterator());
				
				//TODO clone iterator

//				IEntity outerSelfEntity = bm.wGet("outerSelf");
//				bm.wDef("self", outerSelfEntity);
//				fragmentIterator.setBindings(bm);
//				fragmentIterator.reset(outerSelfEntity);
				bm.setResultIterator(fragmentIterator);
			}
			@Override
			protected void resetResultIterator(IEntityIterator<IEntity> resultIterator, IEntity selfEntity, IBindingManager bm) {
				IEntity outerSelfEntity = bm.wGet("outerSelf");
				bm.wDef("self", outerSelfEntity);
				resultIterator.setBindings(bm);
				resultIterator.reset(outerSelfEntity);
			}

			public void toString(StringBuilder sb) {
				sb.append("nestedFragment");
				super.toString(sb);
			}
		};
	}

	public IEntityIterator<?> cloneReplacingIterator(IEntityIterator<?> childMappingIterator) {
		return cloneReplacingIterator(childMappingIterator, null);
	}
	public IEntityIterator<?> cloneReplacingIterator(IEntityIterator<?> childMappingIterator, Set<String> shallowUriSet) {
		if (childMappingIterator.specificIterator() instanceof EmptyIterator) {
			return new AbstractSingleValuedRunnableIterator<IEntity>() {
				protected void run(IEntity selfEntity, IBindingManager bm) {
					bm.setResult(EntityUtils.clone(selfEntity));
				}
			};
		} else
			return new CloneReplacingIterator(shallowUriSet, childMappingIterator);
	}

	public static class CloneReplacingIterator extends AbstractSingleValuedRunnableIterator<IEntity> {
		private final Set<String> shallowUriSet;

		private CloneReplacingIterator(Set<String> shallowUriSet, IEntityIterator<?>... argsIterators) {
			super(argsIterators);
			this.shallowUriSet = shallowUriSet;
		}

		protected void run(IEntity selfEntity, IBindingManager bm) {
			IEntity oldSelfEntity = bm.wGet("self");
			bm.setResult(deepClone(selfEntity, bm));
			if (bm.wGet("self") != oldSelfEntity)
				bm.wDef("self", oldSelfEntity);
		}

		protected IEntity deepClone(IEntity selfEntity, IBindingManager bm) {
			//TODO add scope with entityCloneMap

			EntityDescriptor<?> ed = selfEntity.wGetEntityDescriptor();
			boolean isComposite = ed.getEntityKind().isComposite();

			IEntity entityClone = ((InternalIEntity) selfEntity).wShallowClone();
			((InternalIEntity) entityClone).wShallowClean();

			for (int index=0, size=selfEntity.wSize(); index<size; index++) {
				IEntity childPrototype = selfEntity.wGet(index);

				if (keepCloning(childPrototype)) {
					IEntity childClone = deepClone(childPrototype, bm);
					if (isComposite)
						entityClone.wAdd(childClone);
					else
						entityClone.wSet(index, childClone);							
				} else {
					FeatureDescriptor childFeatureDescriptor = entityClone.wGetFeatureDescriptor(index);
					bm.wDef("self", childPrototype);
					argsIterators[0].reset(childPrototype);

					if (isComposite) {
						for (IEntity childClone : argsIterators[0])
							if (!BindingManagerFactory.instance.isVoid(childClone))
								entityClone.wAdd(EntityUtils.convertCloneIfReparenting(childClone, childFeatureDescriptor));
					} else {
						IEntity lastChildClone = null;
						for (IEntity childClone : argsIterators[0])
							if (!BindingManagerFactory.instance.isVoid(childClone))
								lastChildClone = childClone;
						entityClone.wSet(index, lastChildClone != null ?
								EntityUtils.convertCloneIfReparenting(lastChildClone, childFeatureDescriptor) :
								CommonsEntityFactory.instance.createResolver());
					}							
				}
			}
			//TODO clone references
			//TODO clone aspects

			return entityClone;
		}

		protected boolean keepCloning(IEntity childPrototype) {
			if (shallowUriSet == null)
				return false;
			else {
				String childUri = childPrototype.wGetEntityDescriptor().getURI();
				return !shallowUriSet.contains(childUri);
			}
		}

		public void toString(StringBuilder sb) {
			sb.append("clone");
			super.toString(sb);
		}
	}
}
