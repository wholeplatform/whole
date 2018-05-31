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

import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.bindings.IBindingScope;
import org.whole.lang.commons.parsers.CommonsDataTypePersistenceParser;
import org.whole.lang.comparators.IEntityComparator;
import org.whole.lang.comparators.ObjectIdentityComparator;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.IEntity;
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
public class IteratorFactory {
	public static <E extends IEntity> IEntityIterator<E> emptyIterator() {
		return new EmptyIterator<E>();
	}

	public static <E extends IEntity> IEntityIterator<E> failureIterator(Throwable failure) {
		return new FailureIterator<E>(failure);
	}

	public static <E extends IEntity> IEntityIterator<E> variableIterator(String varName) {
		return BindingUtils.hasEnvironmentPart(varName) ? new VariableIterator<E>(varName) : new LocalVariableIterator<E>(varName);
	}
	public static <E extends IEntity> IEntityIterator<E> outerVariableIterator(String varName) {
		return BindingUtils.hasEnvironmentPart(varName) ? new OuterVariableIterator<E>(varName) : new OuterLocalVariableIterator<E>(varName);
	}

	public static <E extends IEntity> IEntityIterator<E> constantIterator(E constant, boolean useClone) {
		return new ConstantIterator<E>(constant, useClone);
	}
	public static <E extends IEntity> ConstantChildIterator<E> constantChildIterator(IEntity constant) {
		return new ConstantChildIterator<E>(true, constant);
	}
	public static <E extends IEntity> ConstantComposeIterator<E> constantComposeIterator(IEntity constant, IEntityIterator<E> iterator) {
		return new ConstantComposeIterator<E>(constant, iterator);
	}

	public static <E extends IEntity> IEntityIterator<E> entityCollectionIterator(Iterable<E> entityCollectionIterable) {
		return collectionIterator(entityCollectionIterable, IDataTypeWrapper.identity);
	}
	public static <E extends IEntity> IEntityIterator<E> javaCollectionIterator(Iterable<?> collectionIterable) {
		return collectionIterator(collectionIterable, IDataTypeWrapper.envSpecificValue);
	}
	public static <E extends IEntity> IEntityIterator<E> collectionIterator(Iterable<?> collectionIterable, IDataTypeWrapper elementWrapper) {
		return new CollectionIterator<E>(elementWrapper, collectionIterable);
	}

	public static <E extends IEntity> IEntityIterator<E> singleValuedRunnableIterator(IRunnable runnable) {
		return new SingleValuedRunnableIterator<E>(runnable);
	}
	public static <E extends IEntity> IEntityIterator<E> singleValuedRunnableIterator(IRunnable runnable, IEntityIterator<?>... argsIterators) {
		return new SingleValuedRunnableIterator<E>(runnable, argsIterators);
	}
	public static <E extends IEntity> IEntityIterator<E> singleValuedRunnableIterator(IRunnable runnable, int[] optionalArgsIndexes, IEntityIterator<?>... argsIterators) {
		return new SingleValuedRunnableIterator<E>(runnable, optionalArgsIndexes, argsIterators);
	}
	public static <E extends IEntity> IEntityIterator<E> multiValuedRunnableIterator(IRunnable runnable, IEntityIterator<?>... argsIterators) {
		return new MultiValuedRunnableIterator<E>(runnable, argsIterators);
	}
	public static <E extends IEntity> IEntityIterator<E> multiValuedRunnableIterator(IRunnable runnable, int[] optionalArgsIndexes, IEntityIterator<?>... argsIterators) {
		return new MultiValuedRunnableIterator<E>(runnable, optionalArgsIndexes, argsIterators);
	}

	public static IEntityIterator<IEntity> aspectIterator() {
		return new AspectIterator();
	}

	public static <E extends IEntity> IEntityIterator<E> selfIterator() {
		return new SelfIterator<E>();
	}

	public static <E extends IEntity> IEntityIterator<E> repeatedSelfIterator() {
		return new SelfIterator<E>() {
			@Override
			public E next() {
				return entity = super.next();
			}
		};
	}

	public static IEntityIterator<IEntity> rootIterator() {
		return new RootIterator();
	}
	public static IEntityIterator<IEntity> fragmentRootIterator() {
		return new FragmentRootIterator();
	}

	public static <E extends IEntity> IEntityIterator<E> parentIterator() {
		return new ParentIterator<E>();
	}

	public static <E extends IEntity> IEntityIterator<E> ancestorIterator() {
		return new AncestorIterator<E>(false);
	}
	public static <E extends IEntity> IEntityIterator<E> ancestorOrSelfIterator() {
		return new AncestorIterator<E>(true);
	}

	public static IEntityIterator<IEntity> ancestorReverseIterator() {
		return new AncestorReverseIterator();
	}
	public static IEntityIterator<IEntity> ancestorOrSelfReverseIterator() {
		return new AncestorOrSelfReverseIterator();
	}

	public static IEntityIterator<IEntity> inverseAdjacentIterator() {
		return new InverseAdjacentIterator();
	}
	public static IEntityIterator<IEntity> inverseReachableIterator(boolean includeSelf) {
		DistinctScope<IEntity> distinctScope = distinctScope(ObjectIdentityComparator.instance);
		return distinctScope.withIterator(inverseReachableIterator(includeSelf, distinctScope));
	}
	public static IEntityIterator<IEntity> inverseReachableIterator(boolean includeSelf, DistinctScope<IEntity> distinctScope) {
		return new InverseReachableIterator(includeSelf, distinctScope);
	}

	public static IEntityIterator<IEntity> featureByNameIterator(String fdUri) {
		return new FeatureByNameIterator(fdUri);
	}
	public static IEntityIterator<IEntity> featureByNameIterator(FeatureDescriptor fd) {
		return new FeatureByNameIterator(fd);
	}

	public static IEntityIterator<IEntity> featureByIndexIterator(int relativeIndex) {
		return new FeatureByIndexIterator(relativeIndex);
	}

	public static <E extends IEntity> IEntityIterator<E> childIterator() {
		return new ChildIterator<E>(true);
	}
	public static <E extends IEntity> IEntityIterator<E> childIterator(int relativeFirstIndex) {
		return new ChildIterator<E>(true, relativeFirstIndex);
	}

	public static <E extends IEntity> IEntityIterator<E> childReverseIterator() {
		return new ChildIterator<E>(false);
	}
	public static <E extends IEntity> IEntityIterator<E> childReverseIterator(int relativeFirstIndex) {
		return new ChildIterator<E>(false, relativeFirstIndex);
	}
	public static <E extends IEntity> IEntityIterator<E> childRangeIterator(int relativeStartIndex, int relativeEndIndex) {
		return new ChildRangeIterator<E>(true, relativeStartIndex, relativeEndIndex);
	}

	public static <E extends IEntity> IEntityIterator<E> descendantIterator() {
		return new DescendantIterator<E>(false);
	}
	public static <E extends IEntity> IEntityIterator<E> descendantReverseIterator() {
		return new DescendantReverseIterator<E>(false);
	}
	public static <E extends IEntity> IEntityIterator<E> descendantOrSelfIterator() {
		return new DescendantIterator<E>(true);
	}
	public static <E extends IEntity> IEntityIterator<E> descendantOrSelfReverseIterator() {
		return new DescendantReverseIterator<E>(true);
	}

	public static <E extends IEntity> IEntityIterator<E> followingSiblingIterator() {
		return new FollowingSiblingIterator<E>(true, false);
	}
	public static <E extends IEntity> IEntityIterator<E> followingSiblingReverseIterator() {
		return new FollowingSiblingIterator<E>(false, false);
	}
	public static <E extends IEntity> IEntityIterator<E> precedingSiblingIterator() {
		return new PrecedingSiblingIterator<E>(false, false);
	}
	public static <E extends IEntity> IEntityIterator<E> precedingSiblingReverseIterator() {
		return new PrecedingSiblingIterator<E>(true, false);
	}

	public static <E extends IEntity> IEntityIterator<E> followingSiblingOrSelfIterator() {
		return new FollowingSiblingIterator<E>(true, true);
	}
	public static <E extends IEntity> IEntityIterator<E> followingSiblingOrSelfReverseIterator() {
		return new FollowingSiblingIterator<E>(false, true);
	}
	public static <E extends IEntity> IEntityIterator<E> precedingSiblingOrSelfIterator() {
		return new PrecedingSiblingIterator<E>(false, true);
	}
	public static <E extends IEntity> IEntityIterator<E> precedingSiblingOrSelfReverseIterator() {
		return new PrecedingSiblingIterator<E>(true, true);
	}

	public static <E extends IEntity> IEntityIterator<E> followingIterator() {
		return new FollowingIterator<E>(false);
	}
	public static <E extends IEntity> IEntityIterator<E> precedingIterator() {
		return new PrecedingIterator<E>(false);
	}

	public static <E extends IEntity> IEntityIterator<E> followingOrSelfIterator() {
		return new FollowingIterator<E>(true);
	}
	public static <E extends IEntity> IEntityIterator<E> precedingOrSelfIterator() {
		return new PrecedingIterator<E>(true);
	}

	public static <E extends IEntity> IEntityIterator<E> adjacentIterator() {
		return new AdjacentIterator<E>(true);
	}
	public static <E extends IEntity> IEntityIterator<E> adjacentIterator(int relativeFirstIndex) {
		return new AdjacentIterator<E>(true, relativeFirstIndex);
	}
	public static <E extends IEntity> IEntityIterator<E> adjacentReverseIterator() {
		return new AdjacentIterator<E>(false);
	}

	public static <E extends IEntity> IEntityIterator<E> reachableIterator(boolean includeSelf) {
		DistinctScope<E> distinctScope = distinctScope(ObjectIdentityComparator.instance);
		return distinctScope.withIterator(reachableIterator(includeSelf, distinctScope));
	}
	public static <E extends IEntity> IEntityIterator<E> reachableIterator(boolean includeSelf, DistinctScope<E> distinctScope) {
		return new ReachableIterator<E>(includeSelf, distinctScope);
	}

	public static <E extends IEntity> IEntityIterator<E> childOrAdjacentIterator() {
		return new ChildOrAdjacentIterator<E>(true);
	}
	public static <E extends IEntity> IEntityIterator<E> childOrAdjacentIterator(int relativeFirstIndex) {
		return new ChildOrAdjacentIterator<E>(true, relativeFirstIndex);
	}

	public static <E extends IEntity> IEntityIterator<E> descendantOrReachableIterator() {
		DistinctScope<E> distinctScope = distinctScope(ObjectIdentityComparator.instance);
		return distinctScope.withIterator(descendantOrReachableIterator(false, distinctScope));
	}
	public static <E extends IEntity> IEntityIterator<E> descendantOrReachableIterator(boolean includeSelf, DistinctScope<E> distinctScope) {
		return new DescendantOrReachableIterator<E>(includeSelf, distinctScope);
	}

	public static <E extends IEntity> ScannerIterator<E> scannerIterator(IEntityIterator<E> iterator) {
		return new ScannerIterator<E>(iterator);
	}
	public static <E extends IEntity> MatcherIterator<E> matcherIterator(IEntityIterator<E> iterator) {
		return new MatcherIterator<E>(iterator);
	}

	public static <E extends IEntity> FilterIterator<E> filterIterator(IEntityIterator<E> iterator, IEntityIterator<? extends IEntity> filterIterator) {
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
			return filterIterator.evaluate(selfEntity, getBindings()).wBooleanValue();
		}

	    @Override
		public void toString(StringBuilder sb) {
	    	iterator.toString(sb);
	    	sb.append("[");
	    	filterIterator.toString(sb);
	    	sb.append("]");
	    }
	}

	public static IEntityIterator<IEntity> matchInScopeIterator(IEntityIterator<IEntity> patternIterator) {
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


	public static <E extends IEntity> IfIterator<E> ifIterator(IEntityIterator<? extends IEntity> conditionIterator, IEntityIterator<E> doIterator) {
		return new IfIterator<E>(conditionIterator, doIterator);
	}
	public static <E extends IEntity> ForIterator<E> forIterator(IEntityIterator<? extends IEntity> forIterator, IEntityIterator<E> doIterator) {
		return new ForIterator<E>(forIterator, doIterator);
	}

	public static IEntityIterator<IEntity> functionApplicationIterator(String functionUri) {
		return new FunctionApplicationIterator(functionUri);
	}
	public static IEntityIterator<IEntity> recursiveFunctionApplicationIterator() {
		return new RecursiveFunctionApplicationIterator();
	}
	public static <E extends IEntity> IEntityIterator<E> templateInterpreterIterator(IEntity template) {
		return new TemplateInterpreterIterator<E>(template);
	}

	@SafeVarargs
	public static <E extends IEntity> ChooseByOrderIterator<E> chooseIterator(IEntityIterator<? extends E>... iteratorChain) {
		return new ChooseByOrderIterator<E>(iteratorChain);
	}

	public static <E extends IEntity> ChooseByTypeIterator<E> chooseIterator(ILanguageKit languageKit) {
		return new ChooseByTypeIterator<E>(languageKit);
	}

	@SafeVarargs
	public static <E extends IEntity> SequenceIterator<E> blockIterator(IEntityIterator<? extends E>... iteratorChain) {
		return new BlockIterator<E>(iteratorChain);
	}

	@SafeVarargs
	public static <E extends IEntity> SequenceIterator<E> sequenceIterator(IEntityIterator<? extends E>... iteratorChain) {
		return new SequenceIterator<E>(iteratorChain);
	}

	@SafeVarargs
	public static <E extends IEntity> ComposeIterator<E> composeIterator(IEntityIterator<E> iterator, IEntityIterator<? extends IEntity>... nestedIterators) {
		return new ComposeIterator<E>(iterator, nestedIterators);
	}

	public static <E extends IEntity> FilterByIndexRangeIterator<E> filterByIndexIterator(IEntityIterator<E> iterator, int index) {
		return new FilterByIndexRangeIterator<E>(iterator, index, index);
	}
	public static <E extends IEntity> FilterByIndexRangeIterator<E> filterByIndexRangeIterator(IEntityIterator<E> iterator, int startIndex, int endIndex) {
		return new FilterByIndexRangeIterator<E>(iterator, startIndex, endIndex);
	}
	public static <E extends IEntity> FilterByIndexRangeIterator<E> filterByIndexRangeIterator() {
		return new FilterByIndexRangeIterator<E>();
	}

	public static <E extends IEntity> DistinctScope<E> distinctScope() {
		return new FilterByDistinctIterator<E>();
	}
	public static <E extends IEntity> DistinctScope<E> distinctScope(IEntityComparator<IEntity> comparator) {
		return new FilterByDistinctIterator<E>(comparator);
	}

	public static <E extends IEntity> IEntityIterator<E> sort(IEntityIterator<E> iterator) {
		return new SortIterator<E>(iterator);
	}
	public static <E extends IEntity> IEntityIterator<E> sort(IEntityIterator<E> iterator, IEntityComparator<E> comparator) {
		return new SortIterator<E>(iterator, comparator);
	}

	@SafeVarargs
	public static IEntityIterator<IEntity> unionAllIterator(IEntityIterator<? extends IEntity>... iteratorChain) {
		return new UnionAllIterator(iteratorChain);
	}
	@SafeVarargs
	public static AbstractCollectIterator unionIterator(IEntityIterator<? extends IEntity>... iteratorChain) {
		return new UnionIterator(iteratorChain);
	}
	@SafeVarargs
	public static AbstractCollectIterator intersectIterator(IEntityIterator<? extends IEntity>... iteratorChain) {
		return new IntersectIterator(iteratorChain);
	}
	@SafeVarargs
	public static AbstractCollectIterator exceptIterator(IEntityIterator<? extends IEntity>... iteratorChain) {
		return new ExceptIterator(iteratorChain);
	}


	public static <E extends IEntity> ScannerIterator<E> ancestorScannerIterator() {
		return scannerIterator(IteratorFactory.<E>ancestorIterator());
	}
	public static <E extends IEntity> ScannerIterator<E> childScannerIterator() {
		return scannerIterator(IteratorFactory.<E>childIterator());
	}
	public static <E extends IEntity> ScannerIterator<E> childReverseScannerIterator() {
		return scannerIterator(IteratorFactory.<E>childReverseIterator());
	}
	public static <E extends IEntity> ScannerIterator<E> descendantOrSelfScannerIterator() {
		return scannerIterator(IteratorFactory.<E>descendantOrSelfIterator());
	}
	public static <E extends IEntity> ScannerIterator<E> descendantOrSelfReverseScannerIterator() {
		return scannerIterator(IteratorFactory.<E>descendantOrSelfReverseIterator());
	}

	public static <E extends IEntity> MatcherIterator<E> ancestorMatcherIterator() {
		return matcherIterator(IteratorFactory.<E>ancestorIterator());
	}
	public static <E extends IEntity> MatcherIterator<E> ancestorOrSelfMatcherIterator() {
		return matcherIterator(IteratorFactory.<E>ancestorOrSelfIterator());
	}
	public static <E extends IEntity> MatcherIterator<E> childMatcherIterator() {
		return matcherIterator(IteratorFactory.<E>childIterator());
	}
	public static <E extends IEntity> MatcherIterator<E> childReverseMatcherIterator() {
		return matcherIterator(IteratorFactory.<E>childReverseIterator());
	}
	public static <E extends IEntity> MatcherIterator<E> descendantOrSelfMatcherIterator() {
		return matcherIterator(IteratorFactory.<E>descendantOrSelfIterator());
	}
	public static <E extends IEntity> MatcherIterator<E> descendantOrSelfReverseMatcherIterator() {
		return matcherIterator(IteratorFactory.<E>descendantOrSelfReverseIterator());
	}

	public static IEntityIterator<IEntity> atStageIterator(int stage) {
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
	public static IEntityIterator<IEntity> atHostStageIterator() {
		return new AbstractSingleValuedRunnableIterator<IEntity>() {
			protected void run(IEntity selfEntity, IBindingManager bm) {
				bm.setResult(BindingManagerFactory.instance.createValue(bm.wGetEnvironmentManager().getCurrentOperation().getStage() <= 0));
			}

			public void toString(StringBuilder sb) {
				sb.append("atHostStage()");
			}
		};
	}
	public static IEntityIterator<IEntity> atTemplateStageIterator() {
		return new AbstractSingleValuedRunnableIterator<IEntity>() {
			protected void run(IEntity selfEntity, IBindingManager bm) {
				bm.setResult(BindingManagerFactory.instance.createValue(bm.wGetEnvironmentManager().getCurrentOperation().getStage() > 0));
			}

			public void toString(StringBuilder sb) {
				sb.append("atTemplateStage()");
			}
		};
	}

	public static IEntityIterator<IEntity> hasKindIterator(EntityKinds kind) {
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
	public static IEntityIterator<IEntity> hasCompositeKindIterator(CompositeKinds kind) {
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
	public static IEntityIterator<IEntity> hasDataKindIterator(DataKinds kind) {
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
	public static IEntityIterator<IEntity> isFragmentIterator() {
		return new AbstractSingleValuedRunnableIterator<IEntity>() {
			protected void run(IEntity selfEntity, IBindingManager bm) {
				bm.setResult(BindingManagerFactory.instance.createValue(EntityUtils.isFragment(selfEntity)));
			}

			public void toString(StringBuilder sb) {
				sb.append("isFragment()");
			}
		};
	}
	public static IEntityIterator<IEntity> isVariableIterator() {
		return new AbstractSingleValuedRunnableIterator<IEntity>() {
			protected void run(IEntity selfEntity, IBindingManager bm) {
				bm.setResult(BindingManagerFactory.instance.createValue(EntityUtils.isVariable(selfEntity)));
			}

			public void toString(StringBuilder sb) {
				sb.append("isVariable()");
			}
		};
	}
	public static IEntityIterator<IEntity> isResolverIterator() {
		return new AbstractSingleValuedRunnableIterator<IEntity>() {
			protected void run(IEntity selfEntity, IBindingManager bm) {
				bm.setResult(BindingManagerFactory.instance.createValue(EntityUtils.isResolver(selfEntity)));
			}

			public void toString(StringBuilder sb) {
				sb.append("isResolver()");
			}
		};
	}
	public static IEntityIterator<IEntity> isImplIterator() {
		return new AbstractSingleValuedRunnableIterator<IEntity>() {
			protected void run(IEntity selfEntity, IBindingManager bm) {
				bm.setResult(BindingManagerFactory.instance.createValue(EntityUtils.isNotResolver(selfEntity)));
			}

			public void toString(StringBuilder sb) {
				sb.append("isImpl()");
			}
		};
	}

	public static IEntityIterator<?> andIterator(IEntityIterator<?>... argsIterators) {
		return new AbstractSingleValuedRunnableIterator<IEntity>(argsIterators) {
			protected void run(IEntity selfEntity, IBindingManager bm) {
				for (int i=0; i<argsIterators.length; i++)
					if (!argsIterators[i].evaluate(selfEntity, bm).wBooleanValue()) {
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
	public static IEntityIterator<?> orIterator(IEntityIterator<?>... argsIterators) {
		return new AbstractSingleValuedRunnableIterator<IEntity>(argsIterators) {
			protected void run(IEntity selfEntity, IBindingManager bm) {
				for (int i=0; i<argsIterators.length; i++)
					if (argsIterators[i].evaluate(selfEntity, bm).wBooleanValue()) {
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
	public static IEntityIterator<?> notIterator(IEntityIterator<?> argIterator) {
		return new AbstractSingleValuedRunnableIterator<IEntity>(argIterator) {
			protected void run(IEntity selfEntity, IBindingManager bm) {
				bm.setResult(BindingManagerFactory.instance.createValue(!argsIterators[0].evaluate(selfEntity, bm).wBooleanValue()));
			}

			public void toString(StringBuilder sb) {
				sb.append("not");
				super.toString(sb);
			}
		};
	}

	public static IEntityIterator<IEntity> oneIterator(IEntityIterator<IEntity> fromClause, IEntityIterator<IEntity> satisfiesClause) {
		return new AbstractSingleValuedRunnableIterator<IEntity>(fromClause, satisfiesClause) {
			protected void run(IEntity selfEntity, IBindingManager bm) {
				IBindingScope laScope = null;
				for (IEntity e : argsIterators[0]) {
					if (!argsIterators[1].evaluate(e, bm).wBooleanValue())
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
	public static IEntityIterator<IEntity> someIterator(IEntityIterator<IEntity> fromClause) {
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
	public static IEntityIterator<IEntity> someIterator(IEntityIterator<IEntity> fromClause, IEntityIterator<IEntity> satisfiesClause) {
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
	public static IEntityIterator<IEntity> everyIterator(IEntityIterator<IEntity> fromClause, IEntityIterator<IEntity> satisfiesClause) {
		return new AbstractSingleValuedRunnableIterator<IEntity>(fromClause, satisfiesClause) {
			protected void run(IEntity selfEntity, IBindingManager bm) {
				for (IEntity e : argsIterators[0])
					if (!argsIterators[1].evaluate(e, bm).wBooleanValue()) {
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

	public static IEntityIterator<IEntity> isLanguageIterator(String languageURI) {
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

	public static IEntityIterator<IEntity> hasTypeIterator(String typeUri) {
		return new TypeRelationIterator(typeUri) {
			protected boolean test(EntityDescriptor<?> typeEd, EntityDescriptor<?> selfEd) {
				return typeEd != null && selfEd.equals(typeEd);
			}
			protected String predicateName() {
				return "hasType";
			}
		};
	}
	public static IEntityIterator<IEntity> isLanguageSubtypeOfIterator(String typeUri) {
		return new TypeRelationIterator(typeUri) {
			protected boolean test(EntityDescriptor<?> typeEd, EntityDescriptor<?> selfEd) {
				return typeEd != null && typeEd.isLanguageSupertypeOf(selfEd);
			}
			protected String predicateName() {
				return "isLanguageSubtypeOf";
			}
		};
	}
	public static IEntityIterator<IEntity> isLanguageSupertypeOfIterator(String typeUri) {
		return new TypeRelationIterator(typeUri) {
			protected boolean test(EntityDescriptor<?> typeEd, EntityDescriptor<?> selfEd) {
				return typeEd != null && selfEd.isLanguageSupertypeOf(typeEd);
			}
			protected String predicateName() {
				return "isLanguageSupertypeOf";
			}
		};
	}
	public static IEntityIterator<IEntity> isExtendedLanguageSubtypeOfIterator(String typeUri) {
		return new TypeRelationIterator(typeUri) {
			protected boolean test(EntityDescriptor<?> typeEd, EntityDescriptor<?> selfEd) {
				return typeEd != null && typeEd.isExtendedLanguageSupertypeOf(selfEd);
			}
			protected String predicateName() {
				return "isExtendedLanguageSubtypeOf";
			}
		};
	}
	public static IEntityIterator<IEntity> isExtendedLanguageSupertypeOfIterator(String typeUri) {
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

	public static IEntityIterator<IEntity> atTypeIterator(String edUri) {
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

	public static IEntityIterator<IEntity> atFeatureIterator(String fdUri) {
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

	public static IEntityIterator<IEntity> atIndexIterator(int index) {
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

	public static IEntityIterator<IEntity> asVariableIterator(String name) {
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
	public static IEntityIterator<IEntity> atStageVariableIterator(String name) {
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
	public static IEntityIterator<IEntity> languageVariableIterator(String name) {
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
	public static IEntityIterator<IEntity> typeVariableIterator(String name) {
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
	public static IEntityIterator<IEntity> languageSubtypeOfVariableIterator(String name) {
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
	public static IEntityIterator<IEntity> languageSupertypeOfVariableIterator(String name) {
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
	public static IEntityIterator<IEntity> extendedLanguageSubtypeOfVariableIterator(String name) {
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
	public static IEntityIterator<IEntity> extendedLanguageSupertypeOfVariableIterator(String name) {
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
	public static IEntityIterator<IEntity> iterationIndexVariableIterator(FilterByIndexRangeIterator<?> indexIterator, String name) {
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
				int iterationIndex = ((FilterByIndexRangeIterator<?>) argsIterators[0]).predicateIndex(this);
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

	public static IEntityIterator<IEntity> iterationIndexIterator(FilterByIndexRangeIterator<?> indexIterator, int index) {
		return new AbstractSingleValuedRunnableIterator<IEntity>(indexIterator) {
			@Override
			protected void resetArguments(IEntity entity) {
			}
			@Override
			protected void setArgumentsBindings(IBindingManager bindings) {
			}

			protected void run(IEntity selfEntity, IBindingManager bm) {
				int iterationIndex = ((FilterByIndexRangeIterator<?>) argsIterators[0]).predicateIndex(this);
				bm.setResult(BindingManagerFactory.instance.createValue(iterationIndex == index));
			}

			public void toString(StringBuilder sb) {
				sb.append("iteration(");
				sb.append(index);
				sb.append(")");
			}
		};
	}
	public static IEntityIterator<IEntity> iterationIndexRangeIterator(FilterByIndexRangeIterator<?> indexIterator, int startIndex, int endIndex) {
		return new AbstractSingleValuedRunnableIterator<IEntity>(indexIterator) {
			@Override
			protected void resetArguments(IEntity entity) {
			}
			@Override
			protected void setArgumentsBindings(IBindingManager bindings) {
			}

			protected void run(IEntity selfEntity, IBindingManager bm) {
				int iterationIndex = ((FilterByIndexRangeIterator<?>) argsIterators[0]).predicateIndex(this);
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

	public static IEntityIterator<IEntity> pointwiseEqualsIterator(IEntityIterator<IEntity> leftOperand, IEntityIterator<IEntity> rightOperand) {
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
}
