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
package org.whole.lang.executables;

import java.util.Map;
import java.util.Set;

import org.whole.lang.comparators.IEntityComparator;
import org.whole.lang.iterators.DistinctScope;
import org.whole.lang.iterators.ExecutableFactory;
import org.whole.lang.iterators.MatcherIterator;
import org.whole.lang.iterators.Placement;
import org.whole.lang.iterators.ScannerIterator;
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

	protected <E extends IEntity> IExecutable<E> decorate(IExecutable<E> executable) {
		return new InstrumentingExecutable<E>(executable);
	}

	public <E extends IEntity> IExecutable<E> createEmpty() {
		return decorate(factory.createEmpty());
	}

	public <E extends IEntity> IExecutable<E> createFailure(Throwable failure) {
		return decorate(factory.createFailure(failure));
	}

	public <E extends IEntity> IExecutable<E> createVariable(String varName) {
		return decorate(factory.createVariable(varName));
	}

	public <E extends IEntity> IExecutable<E> createOuterVariable(String varName) {
		return decorate(factory.createOuterVariable(varName));
	}

	public <E extends IEntity> IExecutable<E> createConstant(IEntity constant, boolean useClone) {
		return decorate(factory.createConstant(constant, useClone));
	}

	public <E extends IEntity> IExecutable<E> createConstantChild(IEntity constant) {
		return decorate(factory.createConstantChild(constant));
	}

	public <E extends IEntity> IExecutable<E> createConstantCompose(IEntity constant, IExecutable<IEntity> executable) {
		return decorate(factory.createConstantCompose(constant, executable));
	}

	public <E extends IEntity> IExecutable<E> createConstantSubstitute(E constant, boolean useClone) {
		return decorate(factory.createConstantSubstitute(constant, useClone));
	}

	public <E extends IEntity> IExecutable<E> createEntityCollection(Iterable<E> entityCollectionIterable) {
		return decorate(factory.createEntityCollection(entityCollectionIterable));
	}

	public <E extends IEntity> IExecutable<E> createJavaCollection(Iterable<?> collectionIterable) {
		return decorate(factory.createJavaCollection(collectionIterable));
	}

	public <E extends IEntity> IExecutable<E> createCollection(Iterable<?> collectionIterable,
			IDataTypeWrapper elementWrapper) {
		return decorate(factory.createCollection(collectionIterable, elementWrapper));
	}

	public <E extends IEntity> IExecutable<E> createSingleValuedRunnable(IRunnable runnable) {
		return decorate(factory.createSingleValuedRunnable(runnable));
	}

	public <E extends IEntity> IExecutable<E> createSingleValuedRunnable(IRunnable runnable,
			IExecutable<?>... argsExecutables) {
		return decorate(factory.createSingleValuedRunnable(runnable, argsExecutables));
	}

	public <E extends IEntity> IExecutable<E> createSingleValuedRunnable(IRunnable runnable,
			int[] optionalArgsIndexes, IExecutable<?>... argsExecutables) {
		return decorate(factory.createSingleValuedRunnable(runnable, optionalArgsIndexes, argsExecutables));
	}

	public <E extends IEntity> IExecutable<E> createMultiValuedRunnable(IRunnable runnable, IExecutable<IEntity>... argsExecutables) {
		return decorate(factory.createMultiValuedRunnable(runnable, argsExecutables));
	}

	public <E extends IEntity> IExecutable<E> createMultiValuedRunnable(IRunnable runnable, int[] optionalArgsIndexes, IExecutable<IEntity>... argsExecutables) {
		return decorate(factory.createMultiValuedRunnable(runnable, optionalArgsIndexes, argsExecutables));
	}

	public IExecutable<IEntity> createAspect() {
		return decorate(factory.createAspect());
	}

	public <E extends IEntity> IExecutable<E> createSelf() {
		return decorate(factory.createSelf());
	}

	public <E extends IEntity> IExecutable<E> createRepeatedSelf() {
		return decorate(factory.createRepeatedSelf());
	}

	public IExecutable<IEntity> createRoot() {
		return decorate(factory.createRoot());
	}

	public IExecutable<IEntity> createFragmentRoot() {
		return decorate(factory.createFragmentRoot());
	}

	public <E extends IEntity> IExecutable<E> createParent() {
		return decorate(factory.createParent());
	}

	public <E extends IEntity> IExecutable<E> createAncestor() {
		return decorate(factory.createAncestor());
	}

	public <E extends IEntity> IExecutable<E> createAncestorOrSelf() {
		return decorate(factory.createAncestorOrSelf());
	}

	public IExecutable<IEntity> createAncestorReverse() {
		return decorate(factory.createAncestorReverse());
	}

	public IExecutable<IEntity> createAncestorOrSelfReverse() {
		return decorate(factory.createAncestorOrSelfReverse());
	}

	public IExecutable<IEntity> createInverseAdjacent() {
		return decorate(factory.createInverseAdjacent());
	}

	public IExecutable<IEntity> createInverseReachable(boolean includeSelf) {
		return decorate(factory.createInverseReachable(includeSelf));
	}

	public IExecutable<IEntity> createInverseReachable(boolean includeSelf,
			DistinctScope<IEntity> distinctScope) {
		return decorate(factory.createInverseReachable(includeSelf, distinctScope));
	}

	public IExecutable<IEntity> createFeatureByName(String fdUri) {
		return decorate(factory.createFeatureByName(fdUri));
	}

	public IExecutable<IEntity> createFeatureByName(FeatureDescriptor fd) {
		return decorate(factory.createFeatureByName(fd));
	}

	public IExecutable<IEntity> createFeatureByIndex(int relativeIndex) {
		return decorate(factory.createFeatureByIndex(relativeIndex));
	}

	public <E extends IEntity> IExecutable<E> createChild() {
		return decorate(factory.createChild());
	}

	public <E extends IEntity> IExecutable<E> createChild(int relativeFirstIndex) {
		return decorate(factory.createChild(relativeFirstIndex));
	}

	public <E extends IEntity> IExecutable<E> createChildReverse() {
		return decorate(factory.createChildReverse());
	}

	public <E extends IEntity> IExecutable<E> createChildReverse(int relativeFirstIndex) {
		return decorate(factory.createChildReverse(relativeFirstIndex));
	}

	public <E extends IEntity> IExecutable<E> createChildRange(int relativeStartIndex, int relativeEndIndex) {
		return decorate(factory.createChildRange(relativeStartIndex, relativeEndIndex));
	}

	public <E extends IEntity> IExecutable<E> createDescendant() {
		return decorate(factory.createDescendant());
	}

	public <E extends IEntity> IExecutable<E> createDescendantReverse() {
		return decorate(factory.createDescendantReverse());
	}

	public <E extends IEntity> IExecutable<E> createDescendantOrSelf() {
		return decorate(factory.createDescendantOrSelf());
	}

	public <E extends IEntity> IExecutable<E> createDescendantOrSelfReverse() {
		return decorate(factory.createDescendantOrSelfReverse());
	}

	public <E extends IEntity> IExecutable<E> createFollowingSibling() {
		return decorate(factory.createFollowingSibling());
	}

	public <E extends IEntity> IExecutable<E> createFollowingSiblingReverse() {
		return decorate(factory.createFollowingSiblingReverse());
	}

	public <E extends IEntity> IExecutable<E> createPrecedingSibling() {
		return decorate(factory.createPrecedingSibling());
	}

	public <E extends IEntity> IExecutable<E> createPrecedingSiblingReverse() {
		return decorate(factory.createPrecedingSiblingReverse());
	}

	public <E extends IEntity> IExecutable<E> createFollowingSiblingOrSelf() {
		return decorate(factory.createFollowingSiblingOrSelf());
	}

	public <E extends IEntity> IExecutable<E> createFollowingSiblingOrSelfReverse() {
		return decorate(factory.createFollowingSiblingOrSelfReverse());
	}

	public <E extends IEntity> IExecutable<E> createPrecedingSiblingOrSelf() {
		return decorate(factory.createPrecedingSiblingOrSelf());
	}

	public <E extends IEntity> IExecutable<E> createPrecedingSiblingOrSelfReverse() {
		return decorate(factory.createPrecedingSiblingOrSelfReverse());
	}

	public <E extends IEntity> IExecutable<E> createFollowing() {
		return decorate(factory.createFollowing());
	}

	public <E extends IEntity> IExecutable<E> createPreceding() {
		return decorate(factory.createPreceding());
	}

	public <E extends IEntity> IExecutable<E> createFollowingOrSelf() {
		return decorate(factory.createFollowingOrSelf());
	}

	public <E extends IEntity> IExecutable<E> createPrecedingOrSelf() {
		return decorate(factory.createPrecedingOrSelf());
	}

	public <E extends IEntity> IExecutable<E> createAdjacent() {
		return decorate(factory.createAdjacent());
	}

	public <E extends IEntity> IExecutable<E> createAdjacent(int relativeFirstIndex) {
		return decorate(factory.createAdjacent(relativeFirstIndex));
	}

	public <E extends IEntity> IExecutable<E> createAdjacentReverse() {
		return decorate(factory.createAdjacentReverse());
	}

	public <E extends IEntity> IExecutable<E> createReachable(boolean includeSelf) {
		return decorate(factory.createReachable(includeSelf));
	}

	public <E extends IEntity> IExecutable<E> createReachable(boolean includeSelf,
			DistinctScope<E> distinctScope) {
		return decorate(factory.createReachable(includeSelf, distinctScope));
	}

	public <E extends IEntity> IExecutable<E> createChildOrAdjacent() {
		return decorate(factory.createChildOrAdjacent());
	}

	public <E extends IEntity> IExecutable<E> createChildOrAdjacent(int relativeFirstIndex) {
		return decorate(factory.createChildOrAdjacent(relativeFirstIndex));
	}

	public <E extends IEntity> IExecutable<E> createDescendantOrReachable() {
		return decorate(factory.createDescendantOrReachable());
	}

	public <E extends IEntity> IExecutable<E> createDescendantOrReachable(boolean includeSelf,
			DistinctScope<E> distinctScope) {
		return decorate(factory.createDescendantOrReachable(includeSelf, distinctScope));
	}

	public <E extends IEntity> ScannerIterator<E> createScanner(IExecutable<E> executable) {
		return factory .createScanner(executable);
	}

	public <E extends IEntity> MatcherIterator<E> createMatcher(IExecutable<E> executable) {
		return factory .createMatcher(executable);
	}

	public <E extends IEntity> IExecutable<E> createFilter(IExecutable<E> executable, IExecutable<? extends IEntity> filterExecutable) {
		return decorate(factory.createFilter(executable, filterExecutable));
	}

	public IExecutable<IEntity> createMatchInScope(IExecutable<IEntity> patternExecutable) {
		return decorate(factory.createMatchInScope(patternExecutable));
	}

	public <E extends IEntity> IExecutable<E> createIf(IExecutable<? extends IEntity> conditionExecutable, IExecutable<E> doExecutable) {
		return decorate(factory.createIf(conditionExecutable, doExecutable));
	}

	public <E extends IEntity> IExecutable<E> createFor(IExecutable<? extends IEntity> forExecutable, IExecutable<E> doExecutable) {
		return decorate(factory.createFor(forExecutable, doExecutable));
	}

	public IExecutable<IEntity> createFunctionApplication(String functionUri) {
		return decorate(factory.createFunctionApplication(functionUri));
	}

	public IExecutable<IEntity> createRecursiveFunctionApplication() {
		return decorate(factory.createRecursiveFunctionApplication());
	}

	public <E extends IEntity> IExecutable<E> createTemplateInterpreter(IEntity template) {
		return decorate(factory.createTemplateInterpreter(template));
	}

	public <E extends IEntity> IExecutable<E> createChoose(IExecutable<? extends E>... executableChain) {
		return decorate(factory.createChoose(executableChain));
	}

	public <E extends IEntity> IExecutable<E> createChoose(ILanguageKit languageKit) {
		return decorate(factory.createChoose(languageKit));
	}

	public <E extends IEntity> IExecutable<E> createBlock(IExecutable<? extends E>... executableChain) {
		return decorate(factory.createBlock(executableChain));
	}

	public <E extends IEntity> IExecutable<E> createSequence(IExecutable<? extends E>... executableChain) {
		return decorate(factory.createSequence(executableChain));
	}

	public <E extends IEntity> IExecutable<E> createCompose(IExecutable<IEntity> executable, IExecutable<IEntity>... nestedExecutables) {
		return decorate(factory.createCompose(executable, nestedExecutables));
	}

	public <E extends IEntity> IExecutable<E> createFilterByIndex(IExecutable<IEntity> executable, int index) {
		return decorate(factory.createFilterByIndex(executable, index));
	}

	public <E extends IEntity> IExecutable<E> createFilterByIndexRange(IExecutable<IEntity> executable, int startIndex, int endIndex) {
		return decorate(factory.createFilterByIndexRange(executable, startIndex, endIndex));
	}

	public <E extends IEntity> IExecutable<E> createFilterByIndexRange() {
		return decorate(factory.createFilterByIndexRange());
	}

	public <E extends IEntity> DistinctScope<E> createDistinctScope() {
		return factory .createDistinctScope();
	}

	public <E extends IEntity> DistinctScope<E> createDistinctScope(IEntityComparator<IEntity> comparator) {
		return factory .createDistinctScope(comparator);
	}

	public <E extends IEntity> IExecutable<E> createSort(IExecutable<E> executable) {
		return decorate(factory.createSort(executable));
	}

	public <E extends IEntity> IExecutable<E> createSort(IExecutable<E> executable, IEntityComparator<E> comparator) {
		return decorate(factory.createSort(executable, comparator));
	}

	@SuppressWarnings("unchecked")
	public IExecutable<IEntity> createUnionAll(IExecutable<? extends IEntity>... executableChain) {
		return decorate(factory.createUnionAll(executableChain));
	}

	@SuppressWarnings("unchecked")
	public IExecutable<IEntity> createUnion(IExecutable<? extends IEntity>... executableChain) {
		return decorate(factory.createUnion(executableChain));
	}

	@SuppressWarnings("unchecked")
	public IExecutable<IEntity> createIntersect(IExecutable<? extends IEntity>... executableChain) {
		return decorate(factory.createIntersect(executableChain));
	}

	@SuppressWarnings("unchecked")
	public IExecutable<IEntity> createExcept(IExecutable<? extends IEntity>... executableChain) {
		return decorate(factory.createExcept(executableChain));
	}

	public <E extends IEntity> IExecutable<E> createAncestorScanner() {
		return decorate(factory.createAncestorScanner());
	}

	public <E extends IEntity> ScannerIterator<E> createChildScanner() {
		return factory .createChildScanner();
	}

	public <E extends IEntity> ScannerIterator<E> createChildReverseScanner() {
		return factory .createChildReverseScanner();
	}

	public <E extends IEntity> ScannerIterator<E> createDescendantOrSelfScanner() {
		return factory .createDescendantOrSelfScanner();
	}

	public <E extends IEntity> ScannerIterator<E> createDescendantOrSelfReverseScanner() {
		return factory .createDescendantOrSelfReverseScanner();
	}

	public <E extends IEntity> MatcherIterator<E> createAncestorMatcher() {
		return factory .createAncestorMatcher();
	}

	public <E extends IEntity> MatcherIterator<E> createAncestorOrSelfMatcher() {
		return factory .createAncestorOrSelfMatcher();
	}

	public <E extends IEntity> MatcherIterator<E> createChildMatcher() {
		return factory .createChildMatcher();
	}

	public <E extends IEntity> MatcherIterator<E> createChildReverseMatcher() {
		return factory .createChildReverseMatcher();
	}

	public <E extends IEntity> MatcherIterator<E> createDescendantOrSelfMatcher() {
		return factory .createDescendantOrSelfMatcher();
	}

	public <E extends IEntity> MatcherIterator<E> createDescendantOrSelfReverseMatcher() {
		return factory .createDescendantOrSelfReverseMatcher();
	}

	public IExecutable<IEntity> createAtStage(int stage) {
		return decorate(factory.createAtStage(stage));
	}

	public IExecutable<IEntity> createAtHostStage() {
		return decorate(factory.createAtHostStage());
	}

	public IExecutable<IEntity> createAtTemplateStage() {
		return decorate(factory.createAtTemplateStage());
	}

	public IExecutable<IEntity> createHasKind(EntityKinds kind) {
		return decorate(factory.createHasKind(kind));
	}

	public IExecutable<IEntity> createHasCompositeKind(CompositeKinds kind) {
		return decorate(factory.createHasCompositeKind(kind));
	}

	public IExecutable<IEntity> createHasDataKind(DataKinds kind) {
		return decorate(factory.createHasDataKind(kind));
	}

	public IExecutable<IEntity> createIsFragment() {
		return decorate(factory.createIsFragment());
	}

	public IExecutable<IEntity> createIsVariable() {
		return decorate(factory.createIsVariable());
	}

	public IExecutable<IEntity> createIsResolver() {
		return decorate(factory.createIsResolver());
	}

	public IExecutable<IEntity> createIsImpl() {
		return decorate(factory.createIsImpl());
	}

	public IExecutable<IEntity> createAnd(IExecutable<IEntity>... argsExecutables) {
		return decorate(factory.createAnd(argsExecutables));
	}

	public IExecutable<IEntity> createOr(IExecutable<IEntity>... argsExecutables) {
		return decorate(factory.createOr(argsExecutables));
	}

	public IExecutable<IEntity> createNot(IExecutable<IEntity> argExecutable) {
		return decorate(factory.createNot(argExecutable));
	}

	public IExecutable<IEntity> createOne(IExecutable<IEntity> fromClause, IExecutable<IEntity> satisfiesClause) {
		return decorate(factory.createOne(fromClause, satisfiesClause));
	}

	public IExecutable<IEntity> createSome(IExecutable<IEntity> fromClause) {
		return decorate(factory.createSome(fromClause));
	}

	public IExecutable<IEntity> createSome(IExecutable<IEntity> fromClause, IExecutable<IEntity> satisfiesClause) {
		return decorate(factory.createSome(fromClause, satisfiesClause));
	}

	public IExecutable<IEntity> createEvery(IExecutable<IEntity> fromClause, IExecutable<IEntity> satisfiesClause) {
		return decorate(factory.createEvery(fromClause, satisfiesClause));
	}

	public IExecutable<IEntity> createIsLanguage(String languageURI) {
		return decorate(factory.createIsLanguage(languageURI));
	}

	public IExecutable<IEntity> createHasType(String typeUri) {
		return decorate(factory.createHasType(typeUri));
	}

	public IExecutable<IEntity> createIsLanguageSubtypeOf(String typeUri) {
		return decorate(factory.createIsLanguageSubtypeOf(typeUri));
	}

	public IExecutable<IEntity> createIsLanguageSupertypeOf(String typeUri) {
		return decorate(factory.createIsLanguageSupertypeOf(typeUri));
	}

	public IExecutable<IEntity> createIsExtendedLanguageSubtypeOf(String typeUri) {
		return decorate(factory.createIsExtendedLanguageSubtypeOf(typeUri));
	}

	public IExecutable<IEntity> createIsExtendedLanguageSupertypeOf(String typeUri) {
		return decorate(factory.createIsExtendedLanguageSupertypeOf(typeUri));
	}

	public IExecutable<IEntity> createAtType(String edUri) {
		return decorate(factory.createAtType(edUri));
	}

	public IExecutable<IEntity> createAtFeature(String fdUri) {
		return decorate(factory.createAtFeature(fdUri));
	}

	public IExecutable<IEntity> createAtIndex(int index) {
		return decorate(factory.createAtIndex(index));
	}

	public IExecutable<IEntity> createAsVariable(String name) {
		return decorate(factory.createAsVariable(name));
	}

	public IExecutable<IEntity> createAtStageVariable(String name) {
		return decorate(factory.createAtStageVariable(name));
	}

	public IExecutable<IEntity> createLanguageVariable(String name) {
		return decorate(factory.createLanguageVariable(name));
	}

	public IExecutable<IEntity> createTypeVariable(String name) {
		return decorate(factory.createTypeVariable(name));
	}

	public IExecutable<IEntity> createLanguageSubtypeOfVariable(String name) {
		return decorate(factory.createLanguageSubtypeOfVariable(name));
	}

	public IExecutable<IEntity> createLanguageSupertypeOfVariable(String name) {
		return decorate(factory.createLanguageSupertypeOfVariable(name));
	}

	public IExecutable<IEntity> createExtendedLanguageSubtypeOfVariable(String name) {
		return decorate(factory.createExtendedLanguageSubtypeOfVariable(name));
	}

	public IExecutable<IEntity> createExtendedLanguageSupertypeOfVariable(String name) {
		return decorate(factory.createExtendedLanguageSupertypeOfVariable(name));
	}

	public IExecutable<IEntity> createIterationIndexVariable(IExecutable<?> indexExecutable, String name) {
		return decorate(factory.createIterationIndexVariable(indexExecutable, name));
	}

	public IExecutable<IEntity> createIterationIndex(IExecutable<?> indexExecutable, int index) {
		return decorate(factory.createIterationIndex(indexExecutable, index));
	}

	public IExecutable<IEntity> createIterationIndexRange(IExecutable<?> indexExecutable, int startIndex, int endIndex) {
		return decorate(factory.createIterationIndexRange(indexExecutable, startIndex, endIndex));
	}

	public IExecutable<IEntity> createPointwiseEquals(IExecutable<IEntity> leftOperand, IExecutable<IEntity> rightOperand) {
		return decorate(factory.createPointwiseEquals(leftOperand, rightOperand));
	}

	public <E extends IEntity> IExecutable<E> createScope(IExecutable<E> scopeExecutable,
			String environmentName, Set<String> localNames, boolean withFreshNames) {
		return decorate(factory.createScope(scopeExecutable, environmentName, localNames, withFreshNames));
	}

	public IExecutable<?> createTupleFactory(IExecutable<?>... tupleExecutables) {
		return decorate(factory.createTupleFactory(tupleExecutables));
	}

	public <E extends IEntity> IExecutable<E> createSelect(IExecutable<E> selectExecutable, IExecutable<? extends IEntity> fromExecutable, IExecutable<? extends IEntity> whereExecutable) {
		return decorate(factory.createSelect(selectExecutable, fromExecutable, whereExecutable));
	}

	@SuppressWarnings("unchecked")
	public IExecutable<IEntity> createCartesianProduct(IExecutable<? extends IEntity>... executables) {
		return decorate(factory.createCartesianProduct(executables));
	}

	@SuppressWarnings("unchecked")
	public IExecutable<IEntity> createPointwiseProduct(IExecutable<? extends IEntity>... executables) {
		return decorate(factory.createPointwiseProduct(executables));
	}

	public <E extends IEntity> IExecutable<E> createCartesianUpdate(IExecutable<? extends E> valuesExecutable, IExecutable<E> toExecutable) {
		return decorate(factory.createCartesianUpdate(valuesExecutable, toExecutable));
	}

	public <E extends IEntity> IExecutable<E> createPointwiseUpdate(IExecutable<E> valuesExecutable, IExecutable<? super E> toExecutable) {
		return decorate(factory.createPointwiseUpdate(valuesExecutable, toExecutable));
	}

	public <E extends IEntity> IExecutable<E> createCartesianInsert(IExecutable<? extends E> valuesExecutable, IExecutable<E> toExecutable, Placement placement) {
		return decorate(factory.createCartesianInsert(valuesExecutable, toExecutable, placement));
	}

	public <E extends IEntity> IExecutable<E> createPointwiseInsert(IExecutable<E> valuesExecutable, IExecutable<? super E> toExecutable, Placement placement) {
		return decorate(factory.createPointwiseInsert(valuesExecutable, toExecutable, placement));
	}

	public <E extends IEntity> IExecutable<E> createDelete(IExecutable<IEntity> valuesExecutable) {
		return decorate(factory.createDelete(valuesExecutable));
	}

	@SuppressWarnings("unchecked")
	public <E extends IEntity> IExecutable<E> createCall(String name, IExecutable<? extends E>... argsExecutables) {
		return decorate(factory.createCall(name, argsExecutables));
	}

	public IExecutable<?> createNestedVariable() {
		return decorate(factory.createNestedVariable());
	}

	public IExecutable<?> createNestedFragment(Map<IEntity, IExecutable<?>> fragmentExecutableMap) {
		return decorate(factory.createNestedFragment(fragmentExecutableMap));
	}

	public IExecutable<?> createCloneReplacing(IExecutable<?> childMappingExecutable) {
		return decorate(factory.createCloneReplacing(childMappingExecutable));
	}

	public IExecutable<?> createCloneReplacing(IExecutable<?> childMappingExecutable, Set<String> shallowUriSet) {
		return decorate(factory.createCloneReplacing(childMappingExecutable, shallowUriSet));
	}
}

