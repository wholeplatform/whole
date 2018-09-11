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
import org.whole.lang.commons.model.Variable;
import org.whole.lang.commons.parsers.CommonsDataTypePersistenceParser;
import org.whole.lang.commons.visitors.CommonsInterpreterVisitor;
import org.whole.lang.comparators.IEntityComparator;
import org.whole.lang.comparators.ObjectIdentityComparator;
import org.whole.lang.executables.EmptyExecutable;
import org.whole.lang.executables.FailureExecutable;
import org.whole.lang.executables.IExecutable;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.IEntity;
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
public class IteratorBasedExecutableFactory extends AbstractIteratorBasedExecutableFactory {
	public <E extends IEntity> IEntityIterator<E> emptyIterator() {
		return new EmptyExecutable<E>();
	}

	public <E extends IEntity> IEntityIterator<E> failureIterator(Throwable failure) {
		return new FailureExecutable<E>(failure);
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
	public <E extends IEntity> IEntityIterator<E> constantChildIterator(IEntity constant) {
		return new ConstantChildIterator<E>(true, constant);
	}
	public <E extends IEntity> IEntityIterator<E> constantComposeIterator(IEntity constant, IExecutable<E> iterator) {
		return new ConstantComposeIterator<E>(constant, iterator.iterator());
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
	public <E extends IEntity> IEntityIterator<E> singleValuedRunnableIterator(IRunnable runnable, IExecutable<?>... argsIterators) {
		return new SingleValuedRunnableIterator<E>(runnable, toIterators(argsIterators));
	}
	public <E extends IEntity> IEntityIterator<E> singleValuedRunnableIterator(IRunnable runnable, int[] optionalArgsIndexes, IExecutable<?>... argsIterators) {
		return new SingleValuedRunnableIterator<E>(runnable, optionalArgsIndexes, toIterators(argsIterators));
	}
	public <E extends IEntity> IEntityIterator<E> multiValuedRunnableIterator(IRunnable runnable, IExecutable<?>... argsIterators) {
		return new MultiValuedRunnableIterator<E>(runnable, toIterators(argsIterators));
	}
	public <E extends IEntity> IEntityIterator<E> multiValuedRunnableIterator(IRunnable runnable, int[] optionalArgsIndexes, IExecutable<?>... argsIterators) {
		return new MultiValuedRunnableIterator<E>(runnable, optionalArgsIndexes, toIterators(argsIterators));
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
	public <E extends IEntity> IEntityIterator<E> descendantOrSelfIterator() {
		return new DescendantIterator<E>(true);
	}
	public <E extends IEntity> IEntityIterator<E> descendantReverseIterator() {
		return new DescendantReverseIterator<E>(false);
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
	public <E extends IEntity> IEntityIterator<E> followingOrSelfIterator() {
		return new FollowingIterator<E>(true);
	}
	public <E extends IEntity> IEntityIterator<E> precedingIterator() {
		return new PrecedingIterator<E>(false);
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

	public <E extends IEntity> IEntityIterator<E> childOrAdjacentIterator() {
		return new ChildOrAdjacentIterator<E>(true);
	}
	public <E extends IEntity> IEntityIterator<E> childOrAdjacentIterator(int relativeFirstIndex) {
		return new ChildOrAdjacentIterator<E>(true, relativeFirstIndex);
	}

	public <E extends IEntity> IEntityIterator<E> reachableIterator(boolean includeSelf) {
		DistinctScope<E> distinctScope = distinctScope(ObjectIdentityComparator.instance);
		return distinctScope.withIterator(reachableIterator(includeSelf, distinctScope));
	}
	public <E extends IEntity> IEntityIterator<E> reachableIterator(boolean includeSelf, DistinctScope<E> distinctScope) {
		return new ReachableIterator<E>(includeSelf, distinctScope);
	}

	public <E extends IEntity> IEntityIterator<E> descendantOrReachableIterator() {
		DistinctScope<E> distinctScope = distinctScope(ObjectIdentityComparator.instance);
		return distinctScope.withIterator(descendantOrReachableIterator(false, distinctScope));
	}
	public <E extends IEntity> IEntityIterator<E> descendantOrReachableIterator(boolean includeSelf, DistinctScope<E> distinctScope) {
		return new DescendantOrReachableIterator<E>(includeSelf, distinctScope);
	}

	public <E extends IEntity> ScannerIterator<E> scannerIterator(IExecutable<E> iterator) {
		return new ScannerIterator<E>(iterator.iterator());
	}
	public <E extends IEntity> MatcherIterator<E> matcherIterator(IExecutable<E> iterator) {
		return new MatcherIterator<E>(iterator.iterator());
	}

	public <E extends IEntity> IEntityIterator<E> filterIterator(IExecutable<E> iterator, IExecutable<? extends IEntity> filterIterator) {
		return new FilterIterator<E>(iterator.iterator(), filterIterator.iterator());
	}


	public IEntityIterator<IEntity> matchInScopeIterator(IExecutable<IEntity> patternIterator) {
		return new AbstractSingleValuedRunnableIterator<IEntity>(patternIterator.iterator()) {
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


	public <E extends IEntity> IEntityIterator<E> ifIterator(IExecutable<? extends IEntity> conditionIterator, IExecutable<E> doIterator) {
		return new IfIterator<E>(conditionIterator.iterator(), doIterator.iterator());
	}
	public <E extends IEntity> IEntityIterator<E> forIterator(IExecutable<? extends IEntity> forIterator, IExecutable<E> doIterator) {
		return new ForIterator<E>(forIterator.iterator(), doIterator.iterator());
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

	public <E extends IEntity> IEntityIterator<E> chooseIterator(IExecutable<? extends E>... iteratorChain) {
		return new ChooseByOrderIterator<E>(toIterators(iteratorChain));
	}

	public <E extends IEntity> IEntityIterator<E> chooseIterator(ILanguageKit languageKit) {
		return new ChooseByTypeIterator<E>(languageKit);
	}

	public <E extends IEntity> IEntityIterator<E> blockIterator(IExecutable<? extends E>... iteratorChain) {
		return new BlockIterator<E>(toIterators(iteratorChain));
	}

	public <E extends IEntity> IEntityIterator<E> sequenceIterator(IExecutable<? extends E>... iteratorChain) {
		return new SequenceIterator<E>(toIterators(iteratorChain));
	}

	public <E extends IEntity> IEntityIterator<E> composeIterator(IExecutable<E> iterator, IExecutable<? extends IEntity>... nestedIterators) {
		return new ComposeIterator<E>(iterator.iterator(), toIterators(nestedIterators));
	}

	public <E extends IEntity> IEntityIterator<E> filterByIndexIterator(IExecutable<E> iterator, int index) {
		return new FilterByIndexRangeIterator<E>(iterator.iterator(), index, index);
	}
	public <E extends IEntity> IEntityIterator<E> filterByIndexRangeIterator(IExecutable<E> iterator, int startIndex, int endIndex) {
		return new FilterByIndexRangeIterator<E>(iterator.iterator(), startIndex, endIndex);
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

	public <E extends IEntity> IEntityIterator<E> sort(IExecutable<E> iterator) {
		return new SortIterator<E>(iterator.iterator());
	}
	public <E extends IEntity> IEntityIterator<E> sort(IExecutable<E> iterator, IEntityComparator<E> comparator) {
		return new SortIterator<E>(iterator.iterator(), comparator);
	}

	@SuppressWarnings("unchecked")
	public IEntityIterator<IEntity> unionAllIterator(IExecutable<? extends IEntity>... iteratorChain) {
		return new UnionAllIterator(toIterators(iteratorChain));
	}
	@SuppressWarnings("unchecked")
	public IEntityIterator<IEntity> unionIterator(IExecutable<? extends IEntity>... iteratorChain) {
		return new UnionIterator(toIterators(iteratorChain));
	}
	@SuppressWarnings("unchecked")
	public IEntityIterator<IEntity> intersectIterator(IExecutable<? extends IEntity>... iteratorChain) {
		return new IntersectIterator(toIterators(iteratorChain));
	}
	@SuppressWarnings("unchecked")
	public IEntityIterator<IEntity> exceptIterator(IExecutable<? extends IEntity>... iteratorChain) {
		return new ExceptIterator(toIterators(iteratorChain));
	}


	public <E extends IEntity> IEntityIterator<E> ancestorScannerIterator() {
		return scannerIterator(ancestorIterator());
	}
	public <E extends IEntity> ScannerIterator<E> childScannerIterator() {
		return scannerIterator(childIterator());
	}
	public <E extends IEntity> ScannerIterator<E> childReverseScannerIterator() {
		return scannerIterator(childReverseIterator());
	}
	public <E extends IEntity> ScannerIterator<E> descendantOrSelfScannerIterator() {
		return scannerIterator(descendantOrSelfIterator());
	}
	public <E extends IEntity> ScannerIterator<E> descendantOrSelfReverseScannerIterator() {
		return scannerIterator(descendantOrSelfReverseIterator());
	}

	public <E extends IEntity> MatcherIterator<E> ancestorMatcherIterator() {
		return matcherIterator(ancestorIterator());
	}
	public <E extends IEntity> MatcherIterator<E> ancestorOrSelfMatcherIterator() {
		return matcherIterator(ancestorOrSelfIterator());
	}
	public <E extends IEntity> MatcherIterator<E> childMatcherIterator() {
		return matcherIterator(childIterator());
	}
	public <E extends IEntity> MatcherIterator<E> childReverseMatcherIterator() {
		return matcherIterator(childReverseIterator());
	}
	public <E extends IEntity> MatcherIterator<E> descendantOrSelfMatcherIterator() {
		return matcherIterator(descendantOrSelfIterator());
	}
	public <E extends IEntity> MatcherIterator<E> descendantOrSelfReverseMatcherIterator() {
		return matcherIterator(descendantOrSelfReverseIterator());
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

	public IEntityIterator<?> andIterator(IExecutable<?>... argsIterators) {
		return new AbstractSingleValuedRunnableIterator<IEntity>(toIterators(argsIterators)) {
			protected void run(IEntity selfEntity, IBindingManager bm) {
				for (int i=0; i<argsIterators.length; i++)
					if (!argsIterators[i].evaluateAsBooleanOrFail(selfEntity, bm)) {
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
	public IEntityIterator<?> orIterator(IExecutable<?>... argsIterators) {
		return new AbstractSingleValuedRunnableIterator<IEntity>(toIterators(argsIterators)) {
			protected void run(IEntity selfEntity, IBindingManager bm) {
				for (int i=0; i<argsIterators.length; i++)
					if (argsIterators[i].evaluateAsBooleanOrFail(selfEntity, bm)) {
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
	public IEntityIterator<?> notIterator(IExecutable<?> argIterator) {
		return new AbstractSingleValuedRunnableIterator<IEntity>(argIterator.iterator()) {
			protected void run(IEntity selfEntity, IBindingManager bm) {
				bm.setResult(BindingManagerFactory.instance.createValue(!argsIterators[0].evaluateAsBooleanOrFail(selfEntity, bm)));
			}

			public void toString(StringBuilder sb) {
				sb.append("not");
				super.toString(sb);
			}
		};
	}

	public IEntityIterator<IEntity> oneIterator(IExecutable<IEntity> fromClause, IExecutable<IEntity> satisfiesClause) {
		return new AbstractSingleValuedRunnableIterator<IEntity>(fromClause.iterator(), satisfiesClause.iterator()) {
			protected void run(IEntity selfEntity, IBindingManager bm) {
				IBindingScope laScope = null;
				for (IEntity e : argsIterators[0]) {
					if (!argsIterators[1].evaluateAsBooleanOrFail(e, bm))
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
	public IEntityIterator<IEntity> someIterator(IExecutable<IEntity> fromClause) {
		return new AbstractSingleValuedRunnableIterator<IEntity>(fromClause.iterator()) {
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
	public IEntityIterator<IEntity> someIterator(IExecutable<IEntity> fromClause, IExecutable<IEntity> satisfiesClause) {
		return new AbstractSingleValuedRunnableIterator<IEntity>(fromClause.iterator(), satisfiesClause.iterator()) {
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
	public IEntityIterator<IEntity> everyIterator(IExecutable<IEntity> fromClause, IExecutable<IEntity> satisfiesClause) {
		return new AbstractSingleValuedRunnableIterator<IEntity>(fromClause.iterator(), satisfiesClause.iterator()) {
			protected void run(IEntity selfEntity, IBindingManager bm) {
				for (IEntity e : argsIterators[0])
					if (!argsIterators[1].evaluateAsBooleanOrFail(e, bm)) {
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

	public IEntityIterator<IEntity> iterationIndexVariableIterator(IExecutable<?> indexIterator, String name) {
		final boolean hasEnvironmentPart = BindingUtils.hasEnvironmentPart(name);
		final int index = name.indexOf('#');
		final String envName = hasEnvironmentPart ? name.substring(BindingUtils.ENVIRONMENT_URI_PREFIX.length(), index) : null;
		final String varName = hasEnvironmentPart ? name.substring(index+1) : name;

		return new AbstractSingleValuedRunnableIterator<IEntity>(indexIterator.iterator()) {
			@Override
			protected void resetArguments(IEntity entity) {
			}
			@Override
			protected void setProducersBindings(IBindingManager bindings) {
			}

			protected void run(IEntity selfEntity, IBindingManager bm) {
				run(selfEntity, hasEnvironmentPart ? bm.wGetEnvironmentManager().getEnvironment(envName) : bm, varName);
			};
			protected final void run(IEntity selfEntity, IBindingManager bm, String name) {
				int iterationIndex = ((FilterByIndexRangeIterator<?>) argsIterators[0].undecoratedIterator()).predicateIndex(this);
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

	public IEntityIterator<IEntity> iterationIndexIterator(IExecutable<?> indexIterator, int index) {
		return new AbstractSingleValuedRunnableIterator<IEntity>(indexIterator.iterator()) {
			@Override
			protected void resetArguments(IEntity entity) {
			}
			@Override
			protected void setProducersBindings(IBindingManager bindings) {
			}

			protected void run(IEntity selfEntity, IBindingManager bm) {
				int iterationIndex = ((FilterByIndexRangeIterator<?>) argsIterators[0].undecoratedIterator()).predicateIndex(this);
				bm.setResult(BindingManagerFactory.instance.createValue(iterationIndex == index));
			}

			public void toString(StringBuilder sb) {
				sb.append("iteration(");
				sb.append(index);
				sb.append(")");
			}
		};
	}
	public IEntityIterator<IEntity> iterationIndexRangeIterator(IExecutable<?> indexIterator, int startIndex, int endIndex) {
		return new AbstractSingleValuedRunnableIterator<IEntity>(indexIterator.iterator()) {
			@Override
			protected void resetArguments(IEntity entity) {
			}
			@Override
			protected void setProducersBindings(IBindingManager bindings) {
			}

			protected void run(IEntity selfEntity, IBindingManager bm) {
				int iterationIndex = ((FilterByIndexRangeIterator<?>) argsIterators[0].undecoratedIterator()).predicateIndex(this);
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

	public IEntityIterator<IEntity> pointwiseEqualsIterator(IExecutable<IEntity> leftOperand, IExecutable<IEntity> rightOperand) {
		return new AbstractSingleValuedRunnableIterator<IEntity>(leftOperand.iterator(), rightOperand.iterator()) {
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

	public <E extends IEntity> IEntityIterator<E> scopeIterator(IExecutable<E> scopeIterator, String environmentName, Set<String> localNames, boolean withFreshNames) {
    	return withFreshNames ? new LocalScopeIterator<E>(scopeIterator.iterator(), localNames) :
    		new LocalScopeIterator<E>(scopeIterator.iterator(), localNames) {
    			@Override
    			protected AbstractFilterScope createScopeFilter(Set<String> localNames) {
    				return BindingManagerFactory.instance.createIncludeFilterScope(localNames);
    			}
    		};
    }

	public IEntityIterator<?> tupleFactoryIterator(IExecutable<?>... tupleIterators) {
		return new TupleFactoryIterator(toIterators(tupleIterators));
	}

	public <E extends IEntity> IEntityIterator<E> selectIterator(IExecutable<E> selectIterator, IExecutable<? extends IEntity> fromIterator, IExecutable<? extends IEntity> whereIterator) {
		return new SelectIterator<E>(selectIterator.iterator(), fromIterator.iterator(), whereIterator.iterator());
	}

	@SuppressWarnings("unchecked")
	public IEntityIterator<IEntity> cartesianProductIterator(IExecutable<? extends IEntity>... iterators) {
		return new CartesianProductIterator(toIterators(iterators));
	}

	@SuppressWarnings("unchecked")
	public IEntityIterator<IEntity> pointwiseProductIterator(IExecutable<? extends IEntity>... iterators) {
		return new PointwiseProductIterator(toIterators(iterators));
	}

	public <E extends IEntity> IEntityIterator<E> cartesianUpdateIterator(IExecutable<? extends E> valuesIterator, IExecutable<E> toIterator) {
		return new CartesianUpdateIterator<E>(valuesIterator.iterator(), toIterator.iterator());
	}

	public <E extends IEntity> IEntityIterator<E> pointwiseUpdateIterator(IExecutable<E> valuesIterator, IExecutable<? super E> toIterator) {
		return new PointwiseUpdateIterator<E>(valuesIterator.iterator(), toIterator.iterator());
	}

	public <E extends IEntity> IEntityIterator<E> cartesianInsertIterator(IExecutable<? extends E> valuesIterator, IExecutable<E> toIterator, Placement placement) {
		return new CartesianInsertIterator<E>(valuesIterator.iterator(), toIterator.iterator(), placement);
	}

	public <E extends IEntity> IEntityIterator<E> pointwiseInsertIterator(IExecutable<E> valuesIterator, IExecutable<? super E> toIterator, Placement placement) {
		return new PointwiseInsertIterator<E>(valuesIterator.iterator(), toIterator.iterator(), placement);
	}

	public <E extends IEntity> IEntityIterator<E> deleteIterator(IExecutable<E> valuesIterator) {
		return new DeleteIterator<E>(valuesIterator.iterator());
	}

	@SuppressWarnings("unchecked")
	public <E extends IEntity> IEntityIterator<E> callIterator(String name, IExecutable<? extends E>... argsIterators) {
    	return new CallIterator<E>(name, toIterators(argsIterators));
    }

	public IEntityIterator<?> nestedVariableIterator() {
		return new AbstractMultiValuedRunnableIterator<IEntity>() {
			@Override
			protected void run(IEntity selfEntity, IBindingManager bm) {
					IEntity outerSelfEntity = bm.wGet(IBindingManager.OUTER_SELF);
					bm.wDef(IBindingManager.SELF, outerSelfEntity);
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

	public IEntityIterator<?> nestedFragmentIterator(Map<IEntity, IExecutable<?>> fragmentIteratorMap) {
		return new AbstractMultiValuedRunnableIterator<IEntity>() {
			@Override
			protected void run(IEntity selfEntity, IBindingManager bm) {
				IExecutable<?> fragmentIterator = fragmentIteratorMap.getOrDefault(selfEntity, emptyIterator());
				
				//TODO clone iterator

//				IEntity outerSelfEntity = bm.wGet(OUTER_SELF_NAME);
//				bm.wDef(IBindingManager.SELF, outerSelfEntity);
//				fragmentIterator.setBindings(bm);
//				fragmentIterator.reset(outerSelfEntity);
				bm.setExecutableResult(fragmentIterator);
			}
			@Override
			protected void resetResultIterator(IEntityIterator<IEntity> resultIterator, IEntity selfEntity, IBindingManager bm) {
				IEntity outerSelfEntity = bm.wGet(IBindingManager.OUTER_SELF);
				bm.wDef(IBindingManager.SELF, outerSelfEntity);
				resultIterator.setBindings(bm);
				resultIterator.reset(outerSelfEntity);
			}

			public void toString(StringBuilder sb) {
				sb.append("nestedFragment");
				super.toString(sb);
			}
		};
	}

	public IEntityIterator<?> cloneReplacingIterator(IExecutable<?> childMappingIterator) {
		return cloneReplacingIterator(childMappingIterator.iterator(), null);
	}
	public IEntityIterator<?> cloneReplacingIterator(IExecutable<?> childMappingIterator, Set<String> shallowUriSet) {
		if (childMappingIterator.undecoratedIterator() instanceof EmptyExecutable) {
			return new AbstractSingleValuedRunnableIterator<IEntity>() {
				protected void run(IEntity selfEntity, IBindingManager bm) {
					bm.setResult(EntityUtils.clone(selfEntity));
				}
			};
		} else
			return new CloneReplacingIterator(shallowUriSet, childMappingIterator.iterator());
	}
}
