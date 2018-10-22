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

import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.comparators.IEntityComparator;
import org.whole.lang.executables.IExecutable;
import org.whole.lang.executables.InstrumentedExecutableFactory;
import org.whole.lang.executables.RegularExecutableFactory;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.CompositeKinds;
import org.whole.lang.reflect.DataKinds;
import org.whole.lang.reflect.EntityKinds;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.reflect.ILanguageKit;
import org.whole.lang.util.IDataTypeWrapper;
import org.whole.lang.util.IRunnable;

/**
 * @author Riccardo Solmi
 */
public interface ExecutableFactory {
//TODO switch comment to test a specific factory
//	public static ExecutableFactory regularInstance = new IteratorBasedExecutableFactory();
//	public static ExecutableFactory regularInstance = new StepperBasedExecutableFactory();
	public static ExecutableFactory regularInstance = new RegularExecutableFactory();
	public static ExecutableFactory instrumentedInstance = new InstrumentedExecutableFactory();

	public static ExecutableFactory instance = regularInstance;

	public static ExecutableFactory instance(IBindingManager bm) {
		return bm.wIsSet(IBindingManager.INSTRUMENTATION_ENABLED) && bm.wBooleanValue(IBindingManager.INSTRUMENTATION_ENABLED) ?
				instrumentedInstance : 
					regularInstance;
	}


	<E extends IEntity> IExecutable<E> createEmpty();

	<E extends IEntity> IExecutable<E> createFailure(Throwable failure);

	<E extends IEntity> IExecutable<E> createVariable(String varName);

	<E extends IEntity> IExecutable<E> createOuterVariable(String varName);

	<E extends IEntity> IExecutable<E> createConstant(IEntity constant, boolean useClone);

	<E extends IEntity> IExecutable<E> createConstantChild(IEntity constant);

	<E extends IEntity> IExecutable<E> createConstantCompose(IEntity constant, IExecutable<IEntity> executable);

	<E extends IEntity> IExecutable<E> createConstantSubstitute(E constant, boolean useClone);

	<E extends IEntity> IExecutable<E> createEntityCollection(Iterable<E> entityCollectionIterable);

	<E extends IEntity> IExecutable<E> createJavaCollection(Iterable<?> collectionIterable);

	<E extends IEntity> IExecutable<E> createCollection(Iterable<?> collectionIterable, IDataTypeWrapper elementWrapper);

	<E extends IEntity> IExecutable<E> createSingleValuedRunnable(IRunnable runnable);

	<E extends IEntity> IExecutable<E> createSingleValuedRunnable(IRunnable runnable, IExecutable<?>... argsExecutables);

	<E extends IEntity> IExecutable<E> createSingleValuedRunnable(IRunnable runnable, int[] optionalArgsIndexes, IExecutable<?>... argsExecutables);

	<E extends IEntity> IExecutable<E> createMultiValuedRunnable(IRunnable runnable, IExecutable<IEntity>... argsExecutables);

	<E extends IEntity> IExecutable<E> createMultiValuedRunnable(IRunnable runnable, int[] optionalArgsIndexes, IExecutable<IEntity>... argsExecutables);

	IExecutable<IEntity> createAspect();

	<E extends IEntity> IExecutable<E> createSelf();

	<E extends IEntity> IExecutable<E> createRepeatedSelf();

	IExecutable<IEntity> createRoot();

	IExecutable<IEntity> createFragmentRoot();

	<E extends IEntity> IExecutable<E> createParent();

	<E extends IEntity> IExecutable<E> createAncestor();

	<E extends IEntity> IExecutable<E> createAncestorOrSelf();

	IExecutable<IEntity> createAncestorReverse();

	IExecutable<IEntity> createAncestorOrSelfReverse();

	IExecutable<IEntity> createInverseAdjacent();

	IExecutable<IEntity> createInverseReachable(boolean includeSelf);

	IExecutable<IEntity> createInverseReachable(boolean includeSelf, DistinctScope<IEntity> distinctScope);

	IExecutable<IEntity> createFeatureByName(String fdUri);

	IExecutable<IEntity> createFeatureByName(FeatureDescriptor fd);

	IExecutable<IEntity> createFeatureByIndex(int relativeIndex);

	<E extends IEntity> IExecutable<E> createChild();

	<E extends IEntity> IExecutable<E> createChild(int relativeFirstIndex);

	<E extends IEntity> IExecutable<E> createChildReverse();

	<E extends IEntity> IExecutable<E> createChildReverse(int relativeFirstIndex);

	<E extends IEntity> IExecutable<E> createChildRange(int relativeStartIndex, int relativeEndIndex);

	<E extends IEntity> IExecutable<E> createDescendant();

	<E extends IEntity> IExecutable<E> createDescendantReverse();

	<E extends IEntity> IExecutable<E> createDescendantOrSelf();

	<E extends IEntity> IExecutable<E> createDescendantOrSelfReverse();

	<E extends IEntity> IExecutable<E> createFollowingSibling();

	<E extends IEntity> IExecutable<E> createFollowingSiblingReverse();

	<E extends IEntity> IExecutable<E> createPrecedingSibling();

	<E extends IEntity> IExecutable<E> createPrecedingSiblingReverse();

	<E extends IEntity> IExecutable<E> createFollowingSiblingOrSelf();

	<E extends IEntity> IExecutable<E> createFollowingSiblingOrSelfReverse();

	<E extends IEntity> IExecutable<E> createPrecedingSiblingOrSelf();

	<E extends IEntity> IExecutable<E> createPrecedingSiblingOrSelfReverse();

	<E extends IEntity> IExecutable<E> createFollowing();

	<E extends IEntity> IExecutable<E> createPreceding();

	<E extends IEntity> IExecutable<E> createFollowingOrSelf();

	<E extends IEntity> IExecutable<E> createPrecedingOrSelf();

	<E extends IEntity> IExecutable<E> createAdjacent();

	<E extends IEntity> IExecutable<E> createAdjacent(int relativeFirstIndex);

	<E extends IEntity> IExecutable<E> createAdjacentReverse();

	<E extends IEntity> IExecutable<E> createReachable(boolean includeSelf);

	<E extends IEntity> IExecutable<E> createReachable(boolean includeSelf, DistinctScope<E> distinctScope);

	<E extends IEntity> IExecutable<E> createChildOrAdjacent();

	<E extends IEntity> IExecutable<E> createChildOrAdjacent(int relativeFirstIndex);

	<E extends IEntity> IExecutable<E> createDescendantOrReachable();

	<E extends IEntity> IExecutable<E> createDescendantOrReachable(boolean includeSelf, DistinctScope<E> distinctScope);

	<E extends IEntity> ScannerIterator<E> createScanner(IExecutable<E> executable);

	<E extends IEntity> MatcherIterator<E> createMatcher(IExecutable<E> executable);

	<E extends IEntity> IExecutable<E> createFilter(IExecutable<E> executable, IExecutable<? extends IEntity> filterExecutable);

	IExecutable<IEntity> createMatchInScope(IExecutable<IEntity> patternExecutable);

	<E extends IEntity> IExecutable<E> createIf(IExecutable<? extends IEntity> conditionExecutable, IExecutable<E> doExecutable);

	<E extends IEntity> IExecutable<E> createFor(IExecutable<? extends IEntity> forExecutable, IExecutable<E> doExecutable);

	IExecutable<IEntity> createFunctionApplication(String functionUri);

	IExecutable<IEntity> createRecursiveFunctionApplication();

	<E extends IEntity> IExecutable<E> createTemplateInterpreter(IEntity template);

	@SuppressWarnings("unchecked")
	<E extends IEntity> IExecutable<E> createChoose(IExecutable<? extends E>... executableChain);

	<E extends IEntity> IExecutable<E> createChoose(ILanguageKit languageKit);

	@SuppressWarnings("unchecked")
	<E extends IEntity> IExecutable<E> createBlock(IExecutable<? extends E>... executableChain);

	@SuppressWarnings("unchecked")
	<E extends IEntity> IExecutable<E> createSequence(IExecutable<? extends E>... executableChain);

	@SuppressWarnings("unchecked")
	<E extends IEntity> IExecutable<E> createCompose(IExecutable<IEntity> executable, IExecutable<IEntity>... nestedExecutables);

	<E extends IEntity> IExecutable<E> createFilterByIndex(IExecutable<IEntity> executable, int index);

	<E extends IEntity> IExecutable<E> createFilterByIndexRange(IExecutable<IEntity> executable, int startIndex, int endIndex);

	<E extends IEntity> IExecutable<E> createFilterByIndexRange();

	<E extends IEntity> DistinctScope<E> createDistinctScope();

	<E extends IEntity> DistinctScope<E> createDistinctScope(IEntityComparator<IEntity> comparator);

	<E extends IEntity> IExecutable<E> createSort(IExecutable<E> executable);

	<E extends IEntity> IExecutable<E> createSort(IExecutable<E> executable, IEntityComparator<E> comparator);

	@SuppressWarnings("unchecked")
	IExecutable<IEntity> createUnionAll(IExecutable<? extends IEntity>... executableChain);

	@SuppressWarnings("unchecked")
	IExecutable<IEntity> createUnion(IExecutable<? extends IEntity>... executableChain);

	@SuppressWarnings("unchecked")
	IExecutable<IEntity> createIntersect(IExecutable<? extends IEntity>... executableChain);

	@SuppressWarnings("unchecked")
	IExecutable<IEntity> createExcept(IExecutable<? extends IEntity>... executableChain);

	<E extends IEntity> IExecutable<E> createAncestorScanner();

	<E extends IEntity> ScannerIterator<E> createChildScanner();

	<E extends IEntity> ScannerIterator<E> createChildReverseScanner();

	<E extends IEntity> ScannerIterator<E> createDescendantOrSelfScanner();

	<E extends IEntity> ScannerIterator<E> createDescendantOrSelfReverseScanner();

	<E extends IEntity> MatcherIterator<E> createAncestorMatcher();

	<E extends IEntity> MatcherIterator<E> createAncestorOrSelfMatcher();

	<E extends IEntity> MatcherIterator<E> createChildMatcher();

	<E extends IEntity> MatcherIterator<E> createChildReverseMatcher();

	<E extends IEntity> MatcherIterator<E> createDescendantOrSelfMatcher();

	<E extends IEntity> MatcherIterator<E> createDescendantOrSelfReverseMatcher();

	IExecutable<IEntity> createAtStage(int stage);

	IExecutable<IEntity> createAtHostStage();

	IExecutable<IEntity> createAtTemplateStage();

	IExecutable<IEntity> createHasKind(EntityKinds kind);

	IExecutable<IEntity> createHasCompositeKind(CompositeKinds kind);

	IExecutable<IEntity> createHasDataKind(DataKinds kind);

	IExecutable<IEntity> createIsFragment();

	IExecutable<IEntity> createIsVariable();

	IExecutable<IEntity> createIsResolver();

	IExecutable<IEntity> createIsImpl();

	@SuppressWarnings("unchecked")
	IExecutable<IEntity> createAnd(IExecutable<IEntity>... argsExecutables);

	@SuppressWarnings("unchecked")
	IExecutable<IEntity> createOr(IExecutable<IEntity>... argsExecutables);

	IExecutable<IEntity> createNot(IExecutable<IEntity> argExecutable);

	IExecutable<IEntity> createOne(IExecutable<IEntity> fromClause, IExecutable<IEntity> satisfiesClause);

	IExecutable<IEntity> createSome(IExecutable<IEntity> fromClause);

	IExecutable<IEntity> createSome(IExecutable<IEntity> fromClause, IExecutable<IEntity> satisfiesClause);

	IExecutable<IEntity> createEvery(IExecutable<IEntity> fromClause, IExecutable<IEntity> satisfiesClause);

	IExecutable<IEntity> createIsLanguage(String languageURI);

	IExecutable<IEntity> createHasType(String typeUri);

	IExecutable<IEntity> createIsLanguageSubtypeOf(String typeUri);

	IExecutable<IEntity> createIsLanguageSupertypeOf(String typeUri);

	IExecutable<IEntity> createIsExtendedLanguageSubtypeOf(String typeUri);

	IExecutable<IEntity> createIsExtendedLanguageSupertypeOf(String typeUri);

	IExecutable<IEntity> createAtType(String edUri);

	IExecutable<IEntity> createAtFeature(String fdUri);

	IExecutable<IEntity> createAtIndex(int index);

	IExecutable<IEntity> createAsVariable(String name);

	IExecutable<IEntity> createAtStageVariable(String name);

	IExecutable<IEntity> createLanguageVariable(String name);

	IExecutable<IEntity> createTypeVariable(String name);

	IExecutable<IEntity> createLanguageSubtypeOfVariable(String name);

	IExecutable<IEntity> createLanguageSupertypeOfVariable(String name);

	IExecutable<IEntity> createExtendedLanguageSubtypeOfVariable(String name);

	IExecutable<IEntity> createExtendedLanguageSupertypeOfVariable(String name);

	IExecutable<IEntity> createIterationIndexVariable(IExecutable<?> indexExecutable, String name);

	IExecutable<IEntity> createIterationIndex(IExecutable<?> indexExecutable, int index);

	IExecutable<IEntity> createIterationIndexRange(IExecutable<?> indexExecutable, int startIndex, int endIndex);

	IExecutable<IEntity> createPointwiseEquals(IExecutable<IEntity> leftOperand, IExecutable<IEntity> rightOperand);

	<E extends IEntity> IExecutable<E> createScope(IExecutable<E> scopeExecutable, String environmentName, Set<String> names, boolean asFreshNames);

	IExecutable<?> createTupleFactory(IExecutable<?>... tupleExecutables);

	<E extends IEntity> IExecutable<E> createSelect(IExecutable<E> selectExecutable, IExecutable<? extends IEntity> fromExecutable, IExecutable<? extends IEntity> whereExecutable);

	@SuppressWarnings("unchecked")
	IExecutable<IEntity> createCartesianProduct(IExecutable<? extends IEntity>... executables);

	@SuppressWarnings("unchecked")
	IExecutable<IEntity> createPointwiseProduct(IExecutable<? extends IEntity>... executables);

	<E extends IEntity> IExecutable<E> createCartesianUpdate(IExecutable<? extends E> valuesExecutable, IExecutable<E> toExecutable);

	<E extends IEntity> IExecutable<E> createPointwiseUpdate(IExecutable<E> valuesExecutable, IExecutable<? super E> toExecutable);

	<E extends IEntity> IExecutable<E> createCartesianInsert(IExecutable<? extends E> valuesExecutable, IExecutable<E> toExecutable, Placement placement);

	<E extends IEntity> IExecutable<E> createPointwiseInsert(IExecutable<E> valuesExecutable, IExecutable<? super E> toExecutable, Placement placement);

	<E extends IEntity> IExecutable<E> createDelete(IExecutable<IEntity> valuesExecutable);

	@SuppressWarnings("unchecked")
	public <E extends IEntity> IExecutable<E> createCall(String name, IExecutable<? extends E>... argsExecutables);

	IExecutable<?> createNestedVariable();

	IExecutable<?> createNestedFragment(Map<IEntity, IExecutable<?>> fragmentExecutableMap);

	IExecutable<?> createCloneReplacing(IExecutable<?> childMappingExecutable);

	IExecutable<?> createCloneReplacing(IExecutable<?> childMappingExecutable, Set<String> shallowUriSet);
}