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
	public <E extends IEntity> IEntityIterator<E> createEmpty() {
		return new EmptyExecutable<E>();
	}

	public <E extends IEntity> IEntityIterator<E> createFailure(Throwable failure) {
		return new FailureExecutable<E>(failure);
	}

	public <E extends IEntity> IEntityIterator<E> createVariable(String varName) {
		return BindingUtils.hasEnvironmentPart(varName) ? new VariableIterator<E>(varName) : new LocalVariableIterator<E>(varName);
	}
	public <E extends IEntity> IEntityIterator<E> createOuterVariable(String varName) {
		return BindingUtils.hasEnvironmentPart(varName) ? new OuterVariableIterator<E>(varName) : new OuterLocalVariableIterator<E>(varName);
	}

	public <E extends IEntity> IEntityIterator<E> createConstant(E constant, boolean useClone) {
		return new ConstantIterator<E>(constant, useClone);
	}
	public <E extends IEntity> IEntityIterator<E> createConstantSubstitute(E constant, boolean useClone) {
		return new ConstantIterator<E>(constant, useClone) {
			@Override
			public E next() {
				E pattern = super.next();
				Matcher.substitute(pattern, getBindings(), true);
				return pattern;
			}
		};
	}
	public <E extends IEntity> IEntityIterator<E> createConstantChild(IEntity constant) {
		return new ConstantChildIterator<E>(true, constant);
	}
	public <E extends IEntity> IEntityIterator<E> createConstantCompose(IEntity constant, IExecutable<E> executable) {
		return new ConstantComposeIterator<E>(constant, executable.iterator());
	}

	public <E extends IEntity> IEntityIterator<E> createEntityCollection(Iterable<E> entityCollectionIterable) {
		return createCollection(entityCollectionIterable, IDataTypeWrapper.identity);
	}
	public <E extends IEntity> IEntityIterator<E> createJavaCollection(Iterable<?> collectionIterable) {
		return createCollection(collectionIterable, IDataTypeWrapper.envSpecificValue);
	}
	public <E extends IEntity> IEntityIterator<E> createCollection(Iterable<?> collectionIterable, IDataTypeWrapper elementWrapper) {
		return new CollectionIterator<E>(elementWrapper, collectionIterable);
	}

	public <E extends IEntity> IEntityIterator<E> createSingleValuedRunnable(IRunnable runnable) {
		return new SingleValuedRunnableIterator<E>(runnable);
	}
	public <E extends IEntity> IEntityIterator<E> createSingleValuedRunnable(IRunnable runnable, IExecutable<?>... argsExecutables) {
		return new SingleValuedRunnableIterator<E>(runnable, toIterators(argsExecutables));
	}
	public <E extends IEntity> IEntityIterator<E> createSingleValuedRunnable(IRunnable runnable, int[] optionalArgsIndexes, IExecutable<?>... argsExecutables) {
		return new SingleValuedRunnableIterator<E>(runnable, optionalArgsIndexes, toIterators(argsExecutables));
	}
	public <E extends IEntity> IEntityIterator<E> createMultiValuedRunnable(IRunnable runnable, IExecutable<?>... argsExecutables) {
		return new MultiValuedRunnableIterator<E>(runnable, toIterators(argsExecutables));
	}
	public <E extends IEntity> IEntityIterator<E> createMultiValuedRunnable(IRunnable runnable, int[] optionalArgsIndexes, IExecutable<?>... argsExecutables) {
		return new MultiValuedRunnableIterator<E>(runnable, optionalArgsIndexes, toIterators(argsExecutables));
	}

	public IEntityIterator<IEntity> createAspect() {
		return new AspectIterator();
	}

	public <E extends IEntity> IEntityIterator<E> createSelf() {
		return new SelfIterator<E>();
	}

	public <E extends IEntity> IEntityIterator<E> createRepeatedSelf() {
		return new SelfIterator<E>() {
			@Override
			public E next() {
				return entity = super.next();
			}
		};
	}

	public IEntityIterator<IEntity> createRoot() {
		return new RootIterator();
	}
	public IEntityIterator<IEntity> createFragmentRoot() {
		return new FragmentRootIterator();
	}

	public <E extends IEntity> IEntityIterator<E> createParent() {
		return new ParentIterator<E>();
	}

	public <E extends IEntity> IEntityIterator<E> createAncestor() {
		return new AncestorIterator<E>(false);
	}
	public <E extends IEntity> IEntityIterator<E> createAncestorOrSelf() {
		return new AncestorIterator<E>(true);
	}

	public IEntityIterator<IEntity> createAncestorReverse() {
		return new AncestorReverseIterator();
	}
	public IEntityIterator<IEntity> createAncestorOrSelfReverse() {
		return new AncestorOrSelfReverseIterator();
	}

	public IEntityIterator<IEntity> createInverseAdjacent() {
		return new InverseAdjacentIterator();
	}
	public IEntityIterator<IEntity> createInverseReachable(boolean includeSelf) {
		DistinctScope<IEntity> distinctScope = createDistinctScope(ObjectIdentityComparator.instance);
		return distinctScope.withIterator(createInverseReachable(includeSelf, distinctScope));
	}
	public IEntityIterator<IEntity> createInverseReachable(boolean includeSelf, DistinctScope<IEntity> distinctScope) {
		return new InverseReachableIterator(includeSelf, distinctScope);
	}

	public IEntityIterator<IEntity> createFeatureByName(String fdUri) {
		return new FeatureByNameIterator(fdUri);
	}
	public IEntityIterator<IEntity> createFeatureByName(FeatureDescriptor fd) {
		return new FeatureByNameIterator(fd);
	}

	public IEntityIterator<IEntity> createFeatureByIndex(int relativeIndex) {
		return new FeatureByIndexIterator(relativeIndex);
	}

	public <E extends IEntity> IEntityIterator<E> createChild() {
		return new ChildIterator<E>(true);
	}
	public <E extends IEntity> IEntityIterator<E> createChild(int relativeFirstIndex) {
		return new ChildIterator<E>(true, relativeFirstIndex);
	}
	public <E extends IEntity> IEntityIterator<E> createChildReverse() {
		return new ChildIterator<E>(false);
	}
	public <E extends IEntity> IEntityIterator<E> createChildReverse(int relativeFirstIndex) {
		return new ChildIterator<E>(false, relativeFirstIndex);
	}
	public <E extends IEntity> IEntityIterator<E> createChildRange(int relativeStartIndex, int relativeEndIndex) {
		return new ChildRangeIterator<E>(true, relativeStartIndex, relativeEndIndex);
	}

	public <E extends IEntity> IEntityIterator<E> createDescendant() {
		return new DescendantIterator<E>(false);
	}
	public <E extends IEntity> IEntityIterator<E> createDescendantOrSelf() {
		return new DescendantIterator<E>(true);
	}
	public <E extends IEntity> IEntityIterator<E> createDescendantReverse() {
		return new DescendantReverseIterator<E>(false);
	}
	public <E extends IEntity> IEntityIterator<E> createDescendantOrSelfReverse() {
		return new DescendantReverseIterator<E>(true);
	}

	public <E extends IEntity> IEntityIterator<E> createFollowingSibling() {
		return new FollowingSiblingIterator<E>(true, false);
	}
	public <E extends IEntity> IEntityIterator<E> createFollowingSiblingReverse() {
		return new FollowingSiblingIterator<E>(false, false);
	}
	public <E extends IEntity> IEntityIterator<E> createPrecedingSibling() {
		return new PrecedingSiblingIterator<E>(false, false);
	}
	public <E extends IEntity> IEntityIterator<E> createPrecedingSiblingReverse() {
		return new PrecedingSiblingIterator<E>(true, false);
	}

	public <E extends IEntity> IEntityIterator<E> createFollowingSiblingOrSelf() {
		return new FollowingSiblingIterator<E>(true, true);
	}
	public <E extends IEntity> IEntityIterator<E> createFollowingSiblingOrSelfReverse() {
		return new FollowingSiblingIterator<E>(false, true);
	}
	public <E extends IEntity> IEntityIterator<E> createPrecedingSiblingOrSelf() {
		return new PrecedingSiblingIterator<E>(false, true);
	}
	public <E extends IEntity> IEntityIterator<E> createPrecedingSiblingOrSelfReverse() {
		return new PrecedingSiblingIterator<E>(true, true);
	}

	public <E extends IEntity> IEntityIterator<E> createFollowing() {
		return new FollowingIterator<E>(false);
	}
	public <E extends IEntity> IEntityIterator<E> createFollowingOrSelf() {
		return new FollowingIterator<E>(true);
	}
	public <E extends IEntity> IEntityIterator<E> createPreceding() {
		return new PrecedingIterator<E>(false);
	}
	public <E extends IEntity> IEntityIterator<E> createPrecedingOrSelf() {
		return new PrecedingIterator<E>(true);
	}

	public <E extends IEntity> IEntityIterator<E> createAdjacent() {
		return new AdjacentIterator<E>(true);
	}
	public <E extends IEntity> IEntityIterator<E> createAdjacent(int relativeFirstIndex) {
		return new AdjacentIterator<E>(true, relativeFirstIndex);
	}
	public <E extends IEntity> IEntityIterator<E> createAdjacentReverse() {
		return new AdjacentIterator<E>(false);
	}

	public <E extends IEntity> IEntityIterator<E> createChildOrAdjacent() {
		return new ChildOrAdjacentIterator<E>(true);
	}
	public <E extends IEntity> IEntityIterator<E> createChildOrAdjacent(int relativeFirstIndex) {
		return new ChildOrAdjacentIterator<E>(true, relativeFirstIndex);
	}

	public <E extends IEntity> IEntityIterator<E> createReachable(boolean includeSelf) {
		DistinctScope<E> distinctScope = createDistinctScope(ObjectIdentityComparator.instance);
		return distinctScope.withIterator(createReachable(includeSelf, distinctScope));
	}
	public <E extends IEntity> IEntityIterator<E> createReachable(boolean includeSelf, DistinctScope<E> distinctScope) {
		return new ReachableIterator<E>(includeSelf, distinctScope);
	}

	public <E extends IEntity> IEntityIterator<E> createDescendantOrReachable() {
		DistinctScope<E> distinctScope = createDistinctScope(ObjectIdentityComparator.instance);
		return distinctScope.withIterator(createDescendantOrReachable(false, distinctScope));
	}
	public <E extends IEntity> IEntityIterator<E> createDescendantOrReachable(boolean includeSelf, DistinctScope<E> distinctScope) {
		return new DescendantOrReachableIterator<E>(includeSelf, distinctScope);
	}

	public <E extends IEntity> ScannerIterator<E> createScanner(IExecutable<E> executable) {
		return new ScannerIterator<E>(executable.iterator());
	}
	public <E extends IEntity> MatcherIterator<E> createMatcher(IExecutable<E> executable) {
		return new MatcherIterator<E>(executable.iterator());
	}

	public <E extends IEntity> IEntityIterator<E> createFilter(IExecutable<E> executable, IExecutable<? extends IEntity> filterExecutable) {
		return new FilterIterator<E>(executable.iterator(), filterExecutable.iterator());
	}


	public IEntityIterator<IEntity> createMatchInScope(IExecutable<IEntity> patternExecutable) {
		return new AbstractSingleValuedRunnableIterator<IEntity>(patternExecutable.iterator()) {
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


	public <E extends IEntity> IEntityIterator<E> createIf(IExecutable<? extends IEntity> conditionExecutable, IExecutable<E> doExecutable) {
		return new IfIterator<E>(conditionExecutable.iterator(), doExecutable.iterator());
	}
	public <E extends IEntity> IEntityIterator<E> createFor(IExecutable<? extends IEntity> forExecutable, IExecutable<E> doExecutable) {
		return new ForIterator<E>(forExecutable.iterator(), doExecutable.iterator());
	}

	public IEntityIterator<IEntity> createFunctionApplication(String functionUri) {
		return new FunctionApplicationIterator(functionUri);
	}
	public IEntityIterator<IEntity> createRecursiveFunctionApplication() {
		return new RecursiveFunctionApplicationIterator();
	}
	public <E extends IEntity> IEntityIterator<E> createTemplateInterpreter(IEntity template) {
		return new TemplateInterpreterIterator<E>(template);
	}

	public <E extends IEntity> IEntityIterator<E> createChoose(IExecutable<? extends E>... executableChain) {
		return new ChooseByOrderIterator<E>(toIterators(executableChain));
	}

	public <E extends IEntity> IEntityIterator<E> createChoose(ILanguageKit languageKit) {
		return new ChooseByTypeIterator<E>(languageKit);
	}

	public <E extends IEntity> IEntityIterator<E> createBlock(IExecutable<? extends E>... executableChain) {
		return new BlockIterator<E>(toIterators(executableChain));
	}

	public <E extends IEntity> IEntityIterator<E> createSequence(IExecutable<? extends E>... executableChain) {
		return new SequenceIterator<E>(toIterators(executableChain));
	}

	public <E extends IEntity> IEntityIterator<E> createCompose(IExecutable<E> executable, IExecutable<? extends IEntity>... nestedExecutables) {
		return new ComposeIterator<E>(executable.iterator(), toIterators(nestedExecutables));
	}

	public <E extends IEntity> IEntityIterator<E> createFilterByIndex(IExecutable<E> executable, int index) {
		return new FilterByIndexRangeIterator<E>(executable.iterator(), index, index);
	}
	public <E extends IEntity> IEntityIterator<E> createFilterByIndexRange(IExecutable<E> executable, int startIndex, int endIndex) {
		return new FilterByIndexRangeIterator<E>(executable.iterator(), startIndex, endIndex);
	}
	public <E extends IEntity> IEntityIterator<E> createFilterByIndexRange() {
		return new FilterByIndexRangeIterator<E>();
	}

	public <E extends IEntity> DistinctScope<E> createDistinctScope() {
		return new FilterByDistinctIterator<E>();
	}
	public <E extends IEntity> DistinctScope<E> createDistinctScope(IEntityComparator<IEntity> comparator) {
		return new FilterByDistinctIterator<E>(comparator);
	}

	public <E extends IEntity> IEntityIterator<E> createSort(IExecutable<E> executable) {
		return new SortIterator<E>(executable.iterator());
	}
	public <E extends IEntity> IEntityIterator<E> createSort(IExecutable<E> executable, IEntityComparator<E> comparator) {
		return new SortIterator<E>(executable.iterator(), comparator);
	}

	@SuppressWarnings("unchecked")
	public IEntityIterator<IEntity> createUnionAll(IExecutable<? extends IEntity>... executableChain) {
		return new UnionAllIterator(toIterators(executableChain));
	}
	@SuppressWarnings("unchecked")
	public IEntityIterator<IEntity> createUnion(IExecutable<? extends IEntity>... executableChain) {
		return new UnionIterator(toIterators(executableChain));
	}
	@SuppressWarnings("unchecked")
	public IEntityIterator<IEntity> createIntersect(IExecutable<? extends IEntity>... executableChain) {
		return new IntersectIterator(toIterators(executableChain));
	}
	@SuppressWarnings("unchecked")
	public IEntityIterator<IEntity> createExcept(IExecutable<? extends IEntity>... executableChain) {
		return new ExceptIterator(toIterators(executableChain));
	}


	public <E extends IEntity> IEntityIterator<E> createAncestorScanner() {
		return createScanner(createAncestor());
	}
	public <E extends IEntity> ScannerIterator<E> createChildScanner() {
		return createScanner(createChild());
	}
	public <E extends IEntity> ScannerIterator<E> createChildReverseScanner() {
		return createScanner(createChildReverse());
	}
	public <E extends IEntity> ScannerIterator<E> createDescendantOrSelfScanner() {
		return createScanner(createDescendantOrSelf());
	}
	public <E extends IEntity> ScannerIterator<E> createDescendantOrSelfReverseScanner() {
		return createScanner(createDescendantOrSelfReverse());
	}

	public <E extends IEntity> MatcherIterator<E> createAncestorMatcher() {
		return createMatcher(createAncestor());
	}
	public <E extends IEntity> MatcherIterator<E> createAncestorOrSelfMatcher() {
		return createMatcher(createAncestorOrSelf());
	}
	public <E extends IEntity> MatcherIterator<E> createChildMatcher() {
		return createMatcher(createChild());
	}
	public <E extends IEntity> MatcherIterator<E> createChildReverseMatcher() {
		return createMatcher(createChildReverse());
	}
	public <E extends IEntity> MatcherIterator<E> createDescendantOrSelfMatcher() {
		return createMatcher(createDescendantOrSelf());
	}
	public <E extends IEntity> MatcherIterator<E> createDescendantOrSelfReverseMatcher() {
		return createMatcher(createDescendantOrSelfReverse());
	}

	public IEntityIterator<IEntity> createAtStage(int stage) {
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
	public IEntityIterator<IEntity> createAtHostStage() {
		return new AbstractSingleValuedRunnableIterator<IEntity>() {
			protected void run(IEntity selfEntity, IBindingManager bm) {
				bm.setResult(BindingManagerFactory.instance.createValue(bm.wGetEnvironmentManager().getCurrentOperation().getStage() <= 0));
			}

			public void toString(StringBuilder sb) {
				sb.append("atHostStage()");
			}
		};
	}
	public IEntityIterator<IEntity> createAtTemplateStage() {
		return new AbstractSingleValuedRunnableIterator<IEntity>() {
			protected void run(IEntity selfEntity, IBindingManager bm) {
				bm.setResult(BindingManagerFactory.instance.createValue(bm.wGetEnvironmentManager().getCurrentOperation().getStage() > 0));
			}

			public void toString(StringBuilder sb) {
				sb.append("atTemplateStage()");
			}
		};
	}

	public IEntityIterator<IEntity> createHasKind(EntityKinds kind) {
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
	public IEntityIterator<IEntity> createHasCompositeKind(CompositeKinds kind) {
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
	public IEntityIterator<IEntity> createHasDataKind(DataKinds kind) {
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
	public IEntityIterator<IEntity> createIsFragment() {
		return new AbstractSingleValuedRunnableIterator<IEntity>() {
			protected void run(IEntity selfEntity, IBindingManager bm) {
				bm.setResult(BindingManagerFactory.instance.createValue(EntityUtils.isFragment(selfEntity)));
			}

			public void toString(StringBuilder sb) {
				sb.append("isFragment()");
			}
		};
	}
	public IEntityIterator<IEntity> createIsVariable() {
		return new AbstractSingleValuedRunnableIterator<IEntity>() {
			protected void run(IEntity selfEntity, IBindingManager bm) {
				bm.setResult(BindingManagerFactory.instance.createValue(EntityUtils.isVariable(selfEntity)));
			}

			public void toString(StringBuilder sb) {
				sb.append("isVariable()");
			}
		};
	}
	public IEntityIterator<IEntity> createIsResolver() {
		return new AbstractSingleValuedRunnableIterator<IEntity>() {
			protected void run(IEntity selfEntity, IBindingManager bm) {
				bm.setResult(BindingManagerFactory.instance.createValue(EntityUtils.isResolver(selfEntity)));
			}

			public void toString(StringBuilder sb) {
				sb.append("isResolver()");
			}
		};
	}
	public IEntityIterator<IEntity> createIsImpl() {
		return new AbstractSingleValuedRunnableIterator<IEntity>() {
			protected void run(IEntity selfEntity, IBindingManager bm) {
				bm.setResult(BindingManagerFactory.instance.createValue(EntityUtils.isNotResolver(selfEntity)));
			}

			public void toString(StringBuilder sb) {
				sb.append("isImpl()");
			}
		};
	}

	public IEntityIterator<?> createAnd(IExecutable<?>... argsExecutables) {
		return new AbstractSingleValuedRunnableIterator<IEntity>(toIterators(argsExecutables)) {
			protected void run(IEntity selfEntity, IBindingManager bm) {
				for (int i=0; i<argsExecutables.length; i++)
					if (!argsExecutables[i].evaluateAsBooleanOrFail(selfEntity, bm)) {
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
	public IEntityIterator<?> createOr(IExecutable<?>... argsExecutables) {
		return new AbstractSingleValuedRunnableIterator<IEntity>(toIterators(argsExecutables)) {
			protected void run(IEntity selfEntity, IBindingManager bm) {
				for (int i=0; i<argsExecutables.length; i++)
					if (argsExecutables[i].evaluateAsBooleanOrFail(selfEntity, bm)) {
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
	public IEntityIterator<?> createNot(IExecutable<?> argExecutable) {
		return new AbstractSingleValuedRunnableIterator<IEntity>(argExecutable.iterator()) {
			protected void run(IEntity selfEntity, IBindingManager bm) {
				bm.setResult(BindingManagerFactory.instance.createValue(!argsIterators[0].evaluateAsBooleanOrFail(selfEntity, bm)));
			}

			public void toString(StringBuilder sb) {
				sb.append("not");
				super.toString(sb);
			}
		};
	}

	public IEntityIterator<IEntity> createOne(IExecutable<IEntity> fromClause, IExecutable<IEntity> satisfiesClause) {
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
	public IEntityIterator<IEntity> createSome(IExecutable<IEntity> fromClause) {
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
	public IEntityIterator<IEntity> createSome(IExecutable<IEntity> fromClause, IExecutable<IEntity> satisfiesClause) {
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
	public IEntityIterator<IEntity> createEvery(IExecutable<IEntity> fromClause, IExecutable<IEntity> satisfiesClause) {
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

	public IEntityIterator<IEntity> createIsLanguage(String languageURI) {
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

	public IEntityIterator<IEntity> createHasType(String typeUri) {
		return new TypeRelationIterator(typeUri) {
			protected boolean test(EntityDescriptor<?> typeEd, EntityDescriptor<?> selfEd) {
				return typeEd != null && selfEd.equals(typeEd);
			}
			protected String predicateName() {
				return "hasType";
			}
		};
	}
	public IEntityIterator<IEntity> createIsLanguageSubtypeOf(String typeUri) {
		return new TypeRelationIterator(typeUri) {
			protected boolean test(EntityDescriptor<?> typeEd, EntityDescriptor<?> selfEd) {
				return typeEd != null && typeEd.isLanguageSupertypeOf(selfEd);
			}
			protected String predicateName() {
				return "isLanguageSubtypeOf";
			}
		};
	}
	public IEntityIterator<IEntity> createIsLanguageSupertypeOf(String typeUri) {
		return new TypeRelationIterator(typeUri) {
			protected boolean test(EntityDescriptor<?> typeEd, EntityDescriptor<?> selfEd) {
				return typeEd != null && selfEd.isLanguageSupertypeOf(typeEd);
			}
			protected String predicateName() {
				return "isLanguageSupertypeOf";
			}
		};
	}
	public IEntityIterator<IEntity> createIsExtendedLanguageSubtypeOf(String typeUri) {
		return new TypeRelationIterator(typeUri) {
			protected boolean test(EntityDescriptor<?> typeEd, EntityDescriptor<?> selfEd) {
				return typeEd != null && typeEd.isExtendedLanguageSupertypeOf(selfEd);
			}
			protected String predicateName() {
				return "isExtendedLanguageSubtypeOf";
			}
		};
	}
	public IEntityIterator<IEntity> createIsExtendedLanguageSupertypeOf(String typeUri) {
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

	public IEntityIterator<IEntity> createAtType(String edUri) {
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

	public IEntityIterator<IEntity> createAtFeature(String fdUri) {
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

	public IEntityIterator<IEntity> createAtIndex(int index) {
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

	public IEntityIterator<IEntity> createAsVariable(String name) {
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
	public IEntityIterator<IEntity> createAtStageVariable(String name) {
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
	public IEntityIterator<IEntity> createLanguageVariable(String name) {
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
	public IEntityIterator<IEntity> createTypeVariable(String name) {
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
	public IEntityIterator<IEntity> createLanguageSubtypeOfVariable(String name) {
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
	public IEntityIterator<IEntity> createLanguageSupertypeOfVariable(String name) {
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
	public IEntityIterator<IEntity> createExtendedLanguageSubtypeOfVariable(String name) {
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
	public IEntityIterator<IEntity> createExtendedLanguageSupertypeOfVariable(String name) {
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

	public IEntityIterator<IEntity> createIterationIndexVariable(IExecutable<?> indexExecutable, String name) {
		final boolean hasEnvironmentPart = BindingUtils.hasEnvironmentPart(name);
		final int index = name.indexOf('#');
		final String envName = hasEnvironmentPart ? name.substring(BindingUtils.ENVIRONMENT_URI_PREFIX.length(), index) : null;
		final String varName = hasEnvironmentPart ? name.substring(index+1) : name;

		return new AbstractSingleValuedRunnableIterator<IEntity>(indexExecutable.iterator()) {
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
				int iterationIndex = ((FilterByIndexRangeIterator<?>) argsIterators[0].undecoratedExecutable()).predicateIndex(this);
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

	public IEntityIterator<IEntity> createIterationIndex(IExecutable<?> indexExecutable, int index) {
		return new AbstractSingleValuedRunnableIterator<IEntity>(indexExecutable.iterator()) {
			@Override
			protected void resetArguments(IEntity entity) {
			}
			@Override
			protected void setProducersBindings(IBindingManager bindings) {
			}

			protected void run(IEntity selfEntity, IBindingManager bm) {
				int iterationIndex = ((FilterByIndexRangeIterator<?>) argsIterators[0].undecoratedExecutable()).predicateIndex(this);
				bm.setResult(BindingManagerFactory.instance.createValue(iterationIndex == index));
			}

			public void toString(StringBuilder sb) {
				sb.append("iteration(");
				sb.append(index);
				sb.append(")");
			}
		};
	}
	public IEntityIterator<IEntity> createIterationIndexRange(IExecutable<?> indexExecutable, int startIndex, int endIndex) {
		return new AbstractSingleValuedRunnableIterator<IEntity>(indexExecutable.iterator()) {
			@Override
			protected void resetArguments(IEntity entity) {
			}
			@Override
			protected void setProducersBindings(IBindingManager bindings) {
			}

			protected void run(IEntity selfEntity, IBindingManager bm) {
				int iterationIndex = ((FilterByIndexRangeIterator<?>) argsIterators[0].undecoratedExecutable()).predicateIndex(this);
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

	public IEntityIterator<IEntity> createPointwiseEquals(IExecutable<IEntity> leftOperand, IExecutable<IEntity> rightOperand) {
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

	public <E extends IEntity> IEntityIterator<E> createScope(IExecutable<E> scopeExecutable, String environmentName, Set<String> localNames, boolean withFreshNames) {
    	return withFreshNames ? new LocalScopeIterator<E>(scopeExecutable.iterator(), localNames) :
    		new LocalScopeIterator<E>(scopeExecutable.iterator(), localNames) {
    			@Override
    			protected AbstractFilterScope createScopeFilter(Set<String> localNames) {
    				return BindingManagerFactory.instance.createIncludeFilterScope(localNames);
    			}
    		};
    }

	public IEntityIterator<?> createTupleFactory(IExecutable<?>... tupleExecutables) {
		return new TupleFactoryIterator(toIterators(tupleExecutables));
	}

	public <E extends IEntity> IEntityIterator<E> createSelect(IExecutable<E> selectExecutable, IExecutable<? extends IEntity> fromExecutable, IExecutable<? extends IEntity> whereExecutable) {
		return new SelectIterator<E>(selectExecutable.iterator(), fromExecutable.iterator(), whereExecutable.iterator());
	}

	@SuppressWarnings("unchecked")
	public IEntityIterator<IEntity> createCartesianProduct(IExecutable<? extends IEntity>... executables) {
		return new CartesianProductIterator(toIterators(executables));
	}

	@SuppressWarnings("unchecked")
	public IEntityIterator<IEntity> createPointwiseProduct(IExecutable<? extends IEntity>... executables) {
		return new PointwiseProductIterator(toIterators(executables));
	}

	public <E extends IEntity> IEntityIterator<E> createCartesianUpdate(IExecutable<? extends E> valuesExecutable, IExecutable<E> toExecutable) {
		return new CartesianUpdateIterator<E>(valuesExecutable.iterator(), toExecutable.iterator());
	}

	public <E extends IEntity> IEntityIterator<E> createPointwiseUpdate(IExecutable<E> valuesExecutable, IExecutable<? super E> toExecutable) {
		return new PointwiseUpdateIterator<E>(valuesExecutable.iterator(), toExecutable.iterator());
	}

	public <E extends IEntity> IEntityIterator<E> createCartesianInsert(IExecutable<? extends E> valuesExecutable, IExecutable<E> toExecutable, Placement placement) {
		return new CartesianInsertIterator<E>(valuesExecutable.iterator(), toExecutable.iterator(), placement);
	}

	public <E extends IEntity> IEntityIterator<E> createPointwiseInsert(IExecutable<E> valuesExecutable, IExecutable<? super E> toExecutable, Placement placement) {
		return new PointwiseInsertIterator<E>(valuesExecutable.iterator(), toExecutable.iterator(), placement);
	}

	public <E extends IEntity> IEntityIterator<E> createDelete(IExecutable<E> valuesExecutable) {
		return new DeleteIterator<E>(valuesExecutable.iterator());
	}

	@SuppressWarnings("unchecked")
	public <E extends IEntity> IEntityIterator<E> createCall(String name, IExecutable<? extends E>... argsExecutables) {
    	return new CallIterator<E>(name, toIterators(argsExecutables));
    }

	public IEntityIterator<?> createNestedVariable() {
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

	public IEntityIterator<?> createNestedFragment(Map<IEntity, IExecutable<?>> fragmentExecutableMap) {
		return new AbstractMultiValuedRunnableIterator<IEntity>() {
			@Override
			protected void run(IEntity selfEntity, IBindingManager bm) {
				IExecutable<?> fragmentExecutable = fragmentExecutableMap.getOrDefault(selfEntity, createEmpty());
				
				//TODO clone iterator

//				IEntity outerSelfEntity = bm.wGet(OUTER_SELF_NAME);
//				bm.wDef(IBindingManager.SELF, outerSelfEntity);
//				fragmentExecutable.setBindings(bm);
//				fragmentExecutable.reset(outerSelfEntity);
				bm.setExecutableResult(fragmentExecutable);
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

	public IEntityIterator<?> createCloneReplacing(IExecutable<?> childMappingExecutable) {
		return createCloneReplacing(childMappingExecutable.iterator(), null);
	}
	public IEntityIterator<?> createCloneReplacing(IExecutable<?> childMappingExecutable, Set<String> shallowUriSet) {
		if (childMappingExecutable.undecoratedExecutable() instanceof EmptyExecutable) {
			return new AbstractSingleValuedRunnableIterator<IEntity>() {
				protected void run(IEntity selfEntity, IBindingManager bm) {
					bm.setResult(EntityUtils.clone(selfEntity));
				}
			};
		} else
			return new CloneReplacingIterator(shallowUriSet, childMappingExecutable.iterator());
	}
}
