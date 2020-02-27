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
package org.whole.lang.executables;

import java.util.Map;
import java.util.Set;

import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.comparators.IEntityComparator;
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
//	public static ExecutableFactory regularInstance = new StepperBasedExecutableFactory();
	public static ExecutableFactory regularInstance = new RegularExecutableFactory();
	public static ExecutableFactory instrumentedInstance = new InstrumentedExecutableFactory();

	public static ExecutableFactory instance = regularInstance;

	public static ExecutableFactory instance(IBindingManager bm) {
		return bm.wIsSet(IBindingManager.INSTRUMENTATION_ENABLED) && bm.wBooleanValue(IBindingManager.INSTRUMENTATION_ENABLED) ?
				instrumentedInstance : 
					regularInstance;
	}


	IExecutable createDone();

	IExecutable createEmpty();

	IExecutable createFailure(Throwable failure);

	IExecutable createVariable(String varName);

	IExecutable createOuterVariable(String varName);

	IExecutable createConstant(IEntity constant, boolean useClone);

	IExecutable createConstantChild(IEntity constant);

	IExecutable createConstantCompose(IEntity constant, IExecutable executable);

	IExecutable createConstantSubstitute(IEntity constant, boolean useClone);

	IExecutable createEntityCollection(Iterable<? extends IEntity> entityCollectionIterable);

	IExecutable createJavaCollection(Iterable<?> collectionIterable);

	IExecutable createCollection(Iterable<?> collectionIterable, IDataTypeWrapper elementWrapper);

	IExecutable createSingleValuedRunnable(IRunnable runnable);

	IExecutable createSingleValuedRunnable(IRunnable runnable, IExecutable... argsExecutables);

	IExecutable createSingleValuedRunnable(IRunnable runnable, int[] optionalArgsIndexes, IExecutable... argsExecutables);

	IExecutable createMultiValuedRunnable(IRunnable runnable, IExecutable... argsExecutables);

	IExecutable createMultiValuedRunnable(IRunnable runnable, int[] optionalArgsIndexes, IExecutable... argsExecutables);

	IExecutable createAspect();

	IExecutable createSelf();

	IExecutable createRepeatedSelf();

	IExecutable createRoot();

	IExecutable createFragmentRoot();

	IExecutable createParent();

	IExecutable createAncestor();

	IExecutable createAncestorOrSelf();

	IExecutable createAncestorReverse();

	IExecutable createAncestorOrSelfReverse();

	IExecutable createInverseAdjacent();

	IExecutable createInverseReachable(boolean includeSelf);

	IExecutable createInverseReachable(boolean includeSelf, DistinctScope distinctScope);

	IExecutable createFeatureByName(String fdUri);

	IExecutable createFeatureByName(FeatureDescriptor fd);

	IExecutable createFeatureByIndex(int relativeIndex);

	IExecutable createChild();

	IExecutable createChild(int relativeFirstIndex);

	IExecutable createChildReverse();

	IExecutable createChildReverse(int relativeFirstIndex);

	IExecutable createChildRange(int relativeStartIndex, int relativeEndIndex);

	IExecutable createDescendant();

	IExecutable createDescendantReverse();

	IExecutable createDescendantOrSelf();

	IExecutable createDescendantOrSelfReverse();

	IExecutable createFollowingSibling();

	IExecutable createFollowingSiblingReverse();

	IExecutable createPrecedingSibling();

	IExecutable createPrecedingSiblingReverse();

	IExecutable createFollowingSiblingOrSelf();

	IExecutable createFollowingSiblingOrSelfReverse();

	IExecutable createPrecedingSiblingOrSelf();

	IExecutable createPrecedingSiblingOrSelfReverse();

	IExecutable createFollowing();

	IExecutable createPreceding();

	IExecutable createFollowingOrSelf();

	IExecutable createPrecedingOrSelf();

	IExecutable createAdjacent();

	IExecutable createAdjacent(int relativeFirstIndex);

	IExecutable createAdjacentReverse();

	IExecutable createReachable(boolean includeSelf);

	IExecutable createReachable(boolean includeSelf, DistinctScope distinctScope);

	IExecutable createChildOrAdjacent();

	IExecutable createChildOrAdjacent(int relativeFirstIndex);

	IExecutable createDescendantOrReachable();

	IExecutable createDescendantOrReachable(boolean includeSelf, DistinctScope distinctScope);

	IExecutable createFilter(IExecutable executable, IExecutable filterExecutable);

	IExecutable createMatch(IExecutable patternExecutable);

	IExecutable createPatternMatch(IExecutable patternExecutable);

	IExecutable createIf(IExecutable conditionExecutable, IExecutable doExecutable);

	IExecutable createFor(IExecutable forExecutable, IExecutable doExecutable);

	IExecutable createCompose(IExecutable executable, IExecutable... nestedExecutables);

	IExecutable createFunctionApplication(String functionUri);

	IExecutable createRecursiveFunctionApplication();

	IExecutable createTemplateInterpreter(IEntity template);

	IExecutable createChoose(IExecutable... executableChain);

	IExecutable createChoose(int casesSize);

	IExecutable createChoose(ILanguageKit languageKit);

	IExecutable createBlock(IExecutable... executableChain);

	IExecutable createSequence(IExecutable... executableChain);

	IExecutable createFilterByIndex(IExecutable executable, int index);

	IExecutable createFilterByIndexRange(IExecutable executable, int startIndex, int endIndex);

	IExecutable createFilterByIndexRange();

	DistinctScope createDistinctScope();

	DistinctScope createDistinctScope(IEntityComparator<? super IEntity> comparator);

	IExecutable createSort(IExecutable executable);

	IExecutable createSort(IExecutable executable, IEntityComparator<? super IEntity> comparator);

	IExecutable createUnionAll(IExecutable... executables);

	IExecutable createUnion(IEntityComparator<IEntity> comparator, IExecutable... executables);

	IExecutable createIntersect(IEntityComparator<IEntity> comparator, IExecutable... executables);

	IExecutable createExcept(IEntityComparator<IEntity> comparator, IExecutable... executables);

	IExecutable createAtStage(int stage);

	IExecutable createAtHostStage();

	IExecutable createAtTemplateStage();

	IExecutable createHasKind(EntityKinds kind);

	IExecutable createHasCompositeKind(CompositeKinds kind);

	IExecutable createHasDataKind(DataKinds kind);

	IExecutable createIsFragment();

	IExecutable createIsVariable();

	IExecutable createIsResolver();

	IExecutable createIsImpl();

	IExecutable createAnd(IExecutable... argsExecutables);

	IExecutable createOr(IExecutable... argsExecutables);

	IExecutable createNot(IExecutable argExecutable);

	IExecutable createOne(IExecutable fromClause, IExecutable satisfiesClause);

	IExecutable createSome(IExecutable fromClause);

	IExecutable createSome(IExecutable fromClause, IExecutable satisfiesClause);

	IExecutable createEvery(IExecutable fromClause, IExecutable satisfiesClause);

	IExecutable createIsLanguage(String languageURI);

	IExecutable createHasType(String typeUri);

	IExecutable createIsLanguageSubtypeOf(String typeUri);

	IExecutable createIsLanguageSupertypeOf(String typeUri);

	IExecutable createIsExtendedLanguageSubtypeOf(String typeUri);

	IExecutable createIsExtendedLanguageSupertypeOf(String typeUri);

	IExecutable createAtType(String edUri);

	IExecutable createAtFeature(String fdUri);

	IExecutable createAtIndex(int index);

	IExecutable createAsVariable(String name);

	IExecutable createAtStageVariable(String name);

	IExecutable createLanguageVariable(String name);

	IExecutable createTypeVariable(String name);

	IExecutable createLanguageSubtypeOfVariable(String name);

	IExecutable createLanguageSupertypeOfVariable(String name);

	IExecutable createExtendedLanguageSubtypeOfVariable(String name);

	IExecutable createExtendedLanguageSupertypeOfVariable(String name);

	IExecutable createIterationIndexVariable(IExecutable indexExecutable, String name);

	IExecutable createIterationIndex(IExecutable indexExecutable, int index);

	IExecutable createIterationIndexRange(IExecutable indexExecutable, int startIndex, int endIndex);

	IExecutable createPointwiseEquals(IExecutable leftOperand, IExecutable rightOperand);

	IExecutable createScope(IExecutable scopeExecutable, String environmentName, Set<String> names, boolean asFreshNames);

	IExecutable createTupleFactory(IExecutable... tupleExecutables);

	IExecutable createSelect(IExecutable selectExecutable, IExecutable fromExecutable, IExecutable whereExecutable);

	IExecutable createCartesianProduct(IExecutable... executables);

	IExecutable createPointwiseProduct(IExecutable... executables);

	IExecutable createCartesianUpdate(IExecutable toExecutable, IExecutable valuesExecutable);

	IExecutable createPointwiseUpdate(IExecutable toExecutable, IExecutable valuesExecutable);

	IExecutable createCartesianInsert(IExecutable toExecutable, IExecutable valuesExecutable, Placement placement);

	IExecutable createPointwiseInsert(IExecutable toExecutable, IExecutable valuesExecutable, Placement placement);

	IExecutable createDelete(IExecutable valuesExecutable);

	IExecutable createCall(String name, IExecutable... argsExecutables);

	IExecutable createNestedVariable();

	IExecutable createNestedFragment(Map<IEntity, IExecutable> fragmentExecutableMap);

	IExecutable createCloneReplacing(IExecutable childMappingExecutable);

	IExecutable createCloneReplacing(IExecutable childMappingExecutable, Set<String> shallowUriSet);
}