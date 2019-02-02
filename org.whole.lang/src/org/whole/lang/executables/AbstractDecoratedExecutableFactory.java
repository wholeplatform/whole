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
public class AbstractDecoratedExecutableFactory implements ExecutableFactory {
	ExecutableFactory factory = ExecutableFactory.regularInstance;

	protected IExecutable decorate(IExecutable executable) {
		return new InstrumentingExecutable(executable);
	}

	public IExecutable createEmpty() {
		return decorate(factory.createEmpty());
	}

	public IExecutable createFailure(Throwable failure) {
		return decorate(factory.createFailure(failure));
	}

	public IExecutable createVariable(String varName) {
		return decorate(factory.createVariable(varName));
	}

	public IExecutable createOuterVariable(String varName) {
		return decorate(factory.createOuterVariable(varName));
	}

	public IExecutable createConstant(IEntity constant, boolean useClone) {
		return decorate(factory.createConstant(constant, useClone));
	}

	public IExecutable createConstantChild(IEntity constant) {
		return decorate(factory.createConstantChild(constant));
	}

	public IExecutable createConstantCompose(IEntity constant, IExecutable executable) {
		return decorate(factory.createConstantCompose(constant, executable));
	}

	public IExecutable createConstantSubstitute(IEntity constant, boolean useClone) {
		return decorate(factory.createConstantSubstitute(constant, useClone));
	}

	public IExecutable createEntityCollection(Iterable<? extends IEntity> entityCollectionIterable) {
		return decorate(factory.createEntityCollection(entityCollectionIterable));
	}

	public IExecutable createJavaCollection(Iterable<?> collectionIterable) {
		return decorate(factory.createJavaCollection(collectionIterable));
	}

	public IExecutable createCollection(Iterable<?> collectionIterable,
			IDataTypeWrapper elementWrapper) {
		return decorate(factory.createCollection(collectionIterable, elementWrapper));
	}

	public IExecutable createSingleValuedRunnable(IRunnable runnable) {
		return decorate(factory.createSingleValuedRunnable(runnable));
	}

	public IExecutable createSingleValuedRunnable(IRunnable runnable,
			IExecutable... argsExecutables) {
		return decorate(factory.createSingleValuedRunnable(runnable, argsExecutables));
	}

	public IExecutable createSingleValuedRunnable(IRunnable runnable,
			int[] optionalArgsIndexes, IExecutable... argsExecutables) {
		return decorate(factory.createSingleValuedRunnable(runnable, optionalArgsIndexes, argsExecutables));
	}

	public IExecutable createMultiValuedRunnable(IRunnable runnable, IExecutable... argsExecutables) {
		return decorate(factory.createMultiValuedRunnable(runnable, argsExecutables));
	}

	public IExecutable createMultiValuedRunnable(IRunnable runnable, int[] optionalArgsIndexes, IExecutable... argsExecutables) {
		return decorate(factory.createMultiValuedRunnable(runnable, optionalArgsIndexes, argsExecutables));
	}

	public IExecutable createAspect() {
		return decorate(factory.createAspect());
	}

	public IExecutable createSelf() {
		return decorate(factory.createSelf());
	}

	public IExecutable createRepeatedSelf() {
		return decorate(factory.createRepeatedSelf());
	}

	public IExecutable createRoot() {
		return decorate(factory.createRoot());
	}

	public IExecutable createFragmentRoot() {
		return decorate(factory.createFragmentRoot());
	}

	public IExecutable createParent() {
		return decorate(factory.createParent());
	}

	public IExecutable createAncestor() {
		return decorate(factory.createAncestor());
	}

	public IExecutable createAncestorOrSelf() {
		return decorate(factory.createAncestorOrSelf());
	}

	public IExecutable createAncestorReverse() {
		return decorate(factory.createAncestorReverse());
	}

	public IExecutable createAncestorOrSelfReverse() {
		return decorate(factory.createAncestorOrSelfReverse());
	}

	public IExecutable createInverseAdjacent() {
		return decorate(factory.createInverseAdjacent());
	}

	public IExecutable createInverseReachable(boolean includeSelf) {
		return decorate(factory.createInverseReachable(includeSelf));
	}

	public IExecutable createInverseReachable(boolean includeSelf,
			DistinctScope distinctScope) {
		return decorate(factory.createInverseReachable(includeSelf, distinctScope));
	}

	public IExecutable createFeatureByName(String fdUri) {
		return decorate(factory.createFeatureByName(fdUri));
	}

	public IExecutable createFeatureByName(FeatureDescriptor fd) {
		return decorate(factory.createFeatureByName(fd));
	}

	public IExecutable createFeatureByIndex(int relativeIndex) {
		return decorate(factory.createFeatureByIndex(relativeIndex));
	}

	public IExecutable createChild() {
		return decorate(factory.createChild());
	}

	public IExecutable createChild(int relativeFirstIndex) {
		return decorate(factory.createChild(relativeFirstIndex));
	}

	public IExecutable createChildReverse() {
		return decorate(factory.createChildReverse());
	}

	public IExecutable createChildReverse(int relativeFirstIndex) {
		return decorate(factory.createChildReverse(relativeFirstIndex));
	}

	public IExecutable createChildRange(int relativeStartIndex, int relativeEndIndex) {
		return decorate(factory.createChildRange(relativeStartIndex, relativeEndIndex));
	}

	public IExecutable createDescendant() {
		return decorate(factory.createDescendant());
	}

	public IExecutable createDescendantReverse() {
		return decorate(factory.createDescendantReverse());
	}

	public IExecutable createDescendantOrSelf() {
		return decorate(factory.createDescendantOrSelf());
	}

	public IExecutable createDescendantOrSelfReverse() {
		return decorate(factory.createDescendantOrSelfReverse());
	}

	public IExecutable createFollowingSibling() {
		return decorate(factory.createFollowingSibling());
	}

	public IExecutable createFollowingSiblingReverse() {
		return decorate(factory.createFollowingSiblingReverse());
	}

	public IExecutable createPrecedingSibling() {
		return decorate(factory.createPrecedingSibling());
	}

	public IExecutable createPrecedingSiblingReverse() {
		return decorate(factory.createPrecedingSiblingReverse());
	}

	public IExecutable createFollowingSiblingOrSelf() {
		return decorate(factory.createFollowingSiblingOrSelf());
	}

	public IExecutable createFollowingSiblingOrSelfReverse() {
		return decorate(factory.createFollowingSiblingOrSelfReverse());
	}

	public IExecutable createPrecedingSiblingOrSelf() {
		return decorate(factory.createPrecedingSiblingOrSelf());
	}

	public IExecutable createPrecedingSiblingOrSelfReverse() {
		return decorate(factory.createPrecedingSiblingOrSelfReverse());
	}

	public IExecutable createFollowing() {
		return decorate(factory.createFollowing());
	}

	public IExecutable createPreceding() {
		return decorate(factory.createPreceding());
	}

	public IExecutable createFollowingOrSelf() {
		return decorate(factory.createFollowingOrSelf());
	}

	public IExecutable createPrecedingOrSelf() {
		return decorate(factory.createPrecedingOrSelf());
	}

	public IExecutable createAdjacent() {
		return decorate(factory.createAdjacent());
	}

	public IExecutable createAdjacent(int relativeFirstIndex) {
		return decorate(factory.createAdjacent(relativeFirstIndex));
	}

	public IExecutable createAdjacentReverse() {
		return decorate(factory.createAdjacentReverse());
	}

	public IExecutable createReachable(boolean includeSelf) {
		return decorate(factory.createReachable(includeSelf));
	}

	public IExecutable createReachable(boolean includeSelf,
			DistinctScope distinctScope) {
		return decorate(factory.createReachable(includeSelf, distinctScope));
	}

	public IExecutable createChildOrAdjacent() {
		return decorate(factory.createChildOrAdjacent());
	}

	public IExecutable createChildOrAdjacent(int relativeFirstIndex) {
		return decorate(factory.createChildOrAdjacent(relativeFirstIndex));
	}

	public IExecutable createDescendantOrReachable() {
		return decorate(factory.createDescendantOrReachable());
	}

	public IExecutable createDescendantOrReachable(boolean includeSelf,
			DistinctScope distinctScope) {
		return decorate(factory.createDescendantOrReachable(includeSelf, distinctScope));
	}

	public IExecutable createFilter(IExecutable executable, IExecutable filterExecutable) {
		return decorate(factory.createFilter(executable, filterExecutable));
	}

	public IExecutable createMatchInScope(IExecutable patternExecutable) {
		return decorate(factory.createMatchInScope(patternExecutable));
	}

	public IExecutable createIf(IExecutable conditionExecutable, IExecutable doExecutable) {
		return decorate(factory.createIf(conditionExecutable, doExecutable));
	}

	public IExecutable createFor(IExecutable forExecutable, IExecutable doExecutable) {
		return decorate(factory.createFor(forExecutable, doExecutable));
	}

	public IExecutable createCompose(IExecutable executable, IExecutable... nestedExecutables) {
		return decorate(factory.createCompose(executable, nestedExecutables));
	}

	public IExecutable createFunctionApplication(String functionUri) {
		return decorate(factory.createFunctionApplication(functionUri));
	}

	public IExecutable createRecursiveFunctionApplication() {
		return decorate(factory.createRecursiveFunctionApplication());
	}

	public IExecutable createTemplateInterpreter(IEntity template) {
		return decorate(factory.createTemplateInterpreter(template));
	}

	public IExecutable createChoose(IExecutable... executableChain) {
		return decorate(factory.createChoose(executableChain));
	}

	public IExecutable createChoose(ILanguageKit languageKit) {
		return decorate(factory.createChoose(languageKit));
	}

	public IExecutable createBlock(IExecutable... executableChain) {
		return decorate(factory.createBlock(executableChain));
	}

	public IExecutable createSequence(IExecutable... executableChain) {
		return decorate(factory.createSequence(executableChain));
	}

	public IExecutable createFilterByIndex(IExecutable executable, int index) {
		return decorate(factory.createFilterByIndex(executable, index));
	}

	public IExecutable createFilterByIndexRange(IExecutable executable, int startIndex, int endIndex) {
		return decorate(factory.createFilterByIndexRange(executable, startIndex, endIndex));
	}

	public IExecutable createFilterByIndexRange() {
		return decorate(factory.createFilterByIndexRange());
	}

	public DistinctScope createDistinctScope() {
		return factory.createDistinctScope();
	}

	public DistinctScope createDistinctScope(IEntityComparator<? super IEntity> comparator) {
		return factory.createDistinctScope(comparator);
	}

	public IExecutable createSort(IExecutable executable) {
		return decorate(factory.createSort(executable));
	}

	public IExecutable createSort(IExecutable executable, IEntityComparator<? super IEntity> comparator) {
		return decorate(factory.createSort(executable, comparator));
	}

	public IExecutable createUnionAll(IExecutable... executables) {
		return decorate(factory.createUnionAll(executables));
	}

	public IExecutable createUnion(IEntityComparator<IEntity> comparator, IExecutable... executables) {
		return decorate(factory.createUnion(comparator, executables));
	}

	public IExecutable createIntersect(IEntityComparator<IEntity> comparator, IExecutable... executables) {
		return decorate(factory.createIntersect(comparator, executables));
	}

	public IExecutable createExcept(IEntityComparator<IEntity> comparator, IExecutable... executables) {
		return decorate(factory.createExcept(comparator, executables));
	}

	public IExecutable createAtStage(int stage) {
		return decorate(factory.createAtStage(stage));
	}

	public IExecutable createAtHostStage() {
		return decorate(factory.createAtHostStage());
	}

	public IExecutable createAtTemplateStage() {
		return decorate(factory.createAtTemplateStage());
	}

	public IExecutable createHasKind(EntityKinds kind) {
		return decorate(factory.createHasKind(kind));
	}

	public IExecutable createHasCompositeKind(CompositeKinds kind) {
		return decorate(factory.createHasCompositeKind(kind));
	}

	public IExecutable createHasDataKind(DataKinds kind) {
		return decorate(factory.createHasDataKind(kind));
	}

	public IExecutable createIsFragment() {
		return decorate(factory.createIsFragment());
	}

	public IExecutable createIsVariable() {
		return decorate(factory.createIsVariable());
	}

	public IExecutable createIsResolver() {
		return decorate(factory.createIsResolver());
	}

	public IExecutable createIsImpl() {
		return decorate(factory.createIsImpl());
	}

	public IExecutable createAnd(IExecutable... argsExecutables) {
		return decorate(factory.createAnd(argsExecutables));
	}

	public IExecutable createOr(IExecutable... argsExecutables) {
		return decorate(factory.createOr(argsExecutables));
	}

	public IExecutable createNot(IExecutable argExecutable) {
		return decorate(factory.createNot(argExecutable));
	}

	public IExecutable createOne(IExecutable fromClause, IExecutable satisfiesClause) {
		return decorate(factory.createOne(fromClause, satisfiesClause));
	}

	public IExecutable createSome(IExecutable fromClause) {
		return decorate(factory.createSome(fromClause));
	}

	public IExecutable createSome(IExecutable fromClause, IExecutable satisfiesClause) {
		return decorate(factory.createSome(fromClause, satisfiesClause));
	}

	public IExecutable createEvery(IExecutable fromClause, IExecutable satisfiesClause) {
		return decorate(factory.createEvery(fromClause, satisfiesClause));
	}

	public IExecutable createIsLanguage(String languageURI) {
		return decorate(factory.createIsLanguage(languageURI));
	}

	public IExecutable createHasType(String typeUri) {
		return decorate(factory.createHasType(typeUri));
	}

	public IExecutable createIsLanguageSubtypeOf(String typeUri) {
		return decorate(factory.createIsLanguageSubtypeOf(typeUri));
	}

	public IExecutable createIsLanguageSupertypeOf(String typeUri) {
		return decorate(factory.createIsLanguageSupertypeOf(typeUri));
	}

	public IExecutable createIsExtendedLanguageSubtypeOf(String typeUri) {
		return decorate(factory.createIsExtendedLanguageSubtypeOf(typeUri));
	}

	public IExecutable createIsExtendedLanguageSupertypeOf(String typeUri) {
		return decorate(factory.createIsExtendedLanguageSupertypeOf(typeUri));
	}

	public IExecutable createAtType(String edUri) {
		return decorate(factory.createAtType(edUri));
	}

	public IExecutable createAtFeature(String fdUri) {
		return decorate(factory.createAtFeature(fdUri));
	}

	public IExecutable createAtIndex(int index) {
		return decorate(factory.createAtIndex(index));
	}

	public IExecutable createAsVariable(String name) {
		return decorate(factory.createAsVariable(name));
	}

	public IExecutable createAtStageVariable(String name) {
		return decorate(factory.createAtStageVariable(name));
	}

	public IExecutable createLanguageVariable(String name) {
		return decorate(factory.createLanguageVariable(name));
	}

	public IExecutable createTypeVariable(String name) {
		return decorate(factory.createTypeVariable(name));
	}

	public IExecutable createLanguageSubtypeOfVariable(String name) {
		return decorate(factory.createLanguageSubtypeOfVariable(name));
	}

	public IExecutable createLanguageSupertypeOfVariable(String name) {
		return decorate(factory.createLanguageSupertypeOfVariable(name));
	}

	public IExecutable createExtendedLanguageSubtypeOfVariable(String name) {
		return decorate(factory.createExtendedLanguageSubtypeOfVariable(name));
	}

	public IExecutable createExtendedLanguageSupertypeOfVariable(String name) {
		return decorate(factory.createExtendedLanguageSupertypeOfVariable(name));
	}

	public IExecutable createIterationIndexVariable(IExecutable indexExecutable, String name) {
		return decorate(factory.createIterationIndexVariable(indexExecutable, name));
	}

	public IExecutable createIterationIndex(IExecutable indexExecutable, int index) {
		return decorate(factory.createIterationIndex(indexExecutable, index));
	}

	public IExecutable createIterationIndexRange(IExecutable indexExecutable, int startIndex, int endIndex) {
		return decorate(factory.createIterationIndexRange(indexExecutable, startIndex, endIndex));
	}

	public IExecutable createPointwiseEquals(IExecutable leftOperand, IExecutable rightOperand) {
		return decorate(factory.createPointwiseEquals(leftOperand, rightOperand));
	}

	public IExecutable createScope(IExecutable scopeExecutable,
			String environmentName, Set<String> localNames, boolean withFreshNames) {
		return decorate(factory.createScope(scopeExecutable, environmentName, localNames, withFreshNames));
	}

	public IExecutable createTupleFactory(IExecutable... tupleExecutables) {
		return decorate(factory.createTupleFactory(tupleExecutables));
	}

	public IExecutable createSelect(IExecutable selectExecutable, IExecutable fromExecutable, IExecutable whereExecutable) {
		return decorate(factory.createSelect(selectExecutable, fromExecutable, whereExecutable));
	}

	public IExecutable createCartesianProduct(IExecutable... executables) {
		return decorate(factory.createCartesianProduct(executables));
	}

	public IExecutable createPointwiseProduct(IExecutable... executables) {
		return decorate(factory.createPointwiseProduct(executables));
	}

	public IExecutable createCartesianUpdate(IExecutable toExecutable, IExecutable valuesExecutable) {
		return decorate(factory.createCartesianUpdate(toExecutable, valuesExecutable));
	}

	public IExecutable createPointwiseUpdate(IExecutable toExecutable, IExecutable valuesExecutable) {
		return decorate(factory.createPointwiseUpdate(toExecutable, valuesExecutable));
	}

	public IExecutable createCartesianInsert(IExecutable toExecutable, IExecutable valuesExecutable, Placement placement) {
		return decorate(factory.createCartesianInsert(toExecutable, valuesExecutable, placement));
	}

	public IExecutable createPointwiseInsert(IExecutable toExecutable, IExecutable valuesExecutable, Placement placement) {
		return decorate(factory.createPointwiseInsert(toExecutable, valuesExecutable, placement));
	}

	public IExecutable createDelete(IExecutable valuesExecutable) {
		return decorate(factory.createDelete(valuesExecutable));
	}

	public IExecutable createCall(String name, IExecutable... argsExecutables) {
		return decorate(factory.createCall(name, argsExecutables));
	}

	public IExecutable createNestedVariable() {
		return decorate(factory.createNestedVariable());
	}

	public IExecutable createNestedFragment(Map<IEntity, IExecutable> fragmentExecutableMap) {
		return decorate(factory.createNestedFragment(fragmentExecutableMap));
	}

	public IExecutable createCloneReplacing(IExecutable childMappingExecutable) {
		return decorate(factory.createCloneReplacing(childMappingExecutable));
	}

	public IExecutable createCloneReplacing(IExecutable childMappingExecutable, Set<String> shallowUriSet) {
		return decorate(factory.createCloneReplacing(childMappingExecutable, shallowUriSet));
	}
}

