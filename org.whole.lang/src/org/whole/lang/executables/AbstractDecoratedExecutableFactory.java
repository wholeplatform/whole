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
import org.whole.lang.iterators.IEntityIterator;
import org.whole.lang.iterators.InstrumentingIterator;
import org.whole.lang.iterators.IteratorFactory;
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
public class AbstractDecoratedExecutableFactory implements IteratorFactory {
	IteratorFactory factory = IteratorFactory.regularInstance;

	protected <E extends IEntity> IEntityIterator<E> decorate(IExecutable<E> iterator) {
		return new InstrumentingIterator<E>(iterator.iterator());
	}

	public <E extends IEntity> IEntityIterator<E> emptyIterator() {
		return decorate(factory.emptyIterator());
	}

	public <E extends IEntity> IEntityIterator<E> failureIterator(Throwable failure) {
		return decorate(factory.failureIterator(failure));
	}

	public <E extends IEntity> IEntityIterator<E> variableIterator(String varName) {
		return decorate(factory.variableIterator(varName));
	}

	public <E extends IEntity> IEntityIterator<E> outerVariableIterator(String varName) {
		return decorate(factory.outerVariableIterator(varName));
	}

	public <E extends IEntity> IEntityIterator<E> constantIterator(E constant, boolean useClone) {
		return decorate(factory.constantIterator(constant, useClone));
	}

	public <E extends IEntity> IEntityIterator<E> constantChildIterator(IEntity constant) {
		return decorate(factory.constantChildIterator(constant));
	}

	public <E extends IEntity> IEntityIterator<E> constantComposeIterator(IEntity constant, IExecutable<E> iterator) {
		return decorate(factory.constantComposeIterator(constant, iterator));
	}

	public <E extends IEntity> IEntityIterator<E> constantSubstituteIterator(E constant, boolean useClone) {
		return decorate(factory.constantSubstituteIterator(constant, useClone));
	}

	public <E extends IEntity> IEntityIterator<E> entityCollectionIterator(Iterable<E> entityCollectionIterable) {
		return decorate(factory.entityCollectionIterator(entityCollectionIterable));
	}

	public <E extends IEntity> IEntityIterator<E> javaCollectionIterator(Iterable<?> collectionIterable) {
		return decorate(factory.javaCollectionIterator(collectionIterable));
	}

	public <E extends IEntity> IEntityIterator<E> collectionIterator(Iterable<?> collectionIterable,
			IDataTypeWrapper elementWrapper) {
		return decorate(factory.collectionIterator(collectionIterable, elementWrapper));
	}

	public <E extends IEntity> IEntityIterator<E> singleValuedRunnableIterator(IRunnable runnable) {
		return decorate(factory.singleValuedRunnableIterator(runnable));
	}

	public <E extends IEntity> IEntityIterator<E> singleValuedRunnableIterator(IRunnable runnable,
			IExecutable<?>... argsIterators) {
		return decorate(factory.singleValuedRunnableIterator(runnable, argsIterators));
	}

	public <E extends IEntity> IEntityIterator<E> singleValuedRunnableIterator(IRunnable runnable,
			int[] optionalArgsIndexes, IExecutable<?>... argsIterators) {
		return decorate(factory.singleValuedRunnableIterator(runnable, optionalArgsIndexes, argsIterators));
	}

	public <E extends IEntity> IEntityIterator<E> multiValuedRunnableIterator(IRunnable runnable,
			IExecutable<?>... argsIterators) {
		return decorate(factory.multiValuedRunnableIterator(runnable, argsIterators));
	}

	public <E extends IEntity> IEntityIterator<E> multiValuedRunnableIterator(IRunnable runnable,
			int[] optionalArgsIndexes, IExecutable<?>... argsIterators) {
		return decorate(factory.multiValuedRunnableIterator(runnable, optionalArgsIndexes, argsIterators));
	}

	public IEntityIterator<IEntity> aspectIterator() {
		return decorate(factory.aspectIterator());
	}

	public <E extends IEntity> IEntityIterator<E> selfIterator() {
		return decorate(factory.selfIterator());
	}

	public <E extends IEntity> IEntityIterator<E> repeatedSelfIterator() {
		return decorate(factory.repeatedSelfIterator());
	}

	public IEntityIterator<IEntity> rootIterator() {
		return decorate(factory.rootIterator());
	}

	public IEntityIterator<IEntity> fragmentRootIterator() {
		return decorate(factory.fragmentRootIterator());
	}

	public <E extends IEntity> IEntityIterator<E> parentIterator() {
		return decorate(factory.parentIterator());
	}

	public <E extends IEntity> IEntityIterator<E> ancestorIterator() {
		return decorate(factory.ancestorIterator());
	}

	public <E extends IEntity> IEntityIterator<E> ancestorOrSelfIterator() {
		return decorate(factory.ancestorOrSelfIterator());
	}

	public IEntityIterator<IEntity> ancestorReverseIterator() {
		return decorate(factory.ancestorReverseIterator());
	}

	public IEntityIterator<IEntity> ancestorOrSelfReverseIterator() {
		return decorate(factory.ancestorOrSelfReverseIterator());
	}

	public IEntityIterator<IEntity> inverseAdjacentIterator() {
		return decorate(factory.inverseAdjacentIterator());
	}

	public IEntityIterator<IEntity> inverseReachableIterator(boolean includeSelf) {
		return decorate(factory.inverseReachableIterator(includeSelf));
	}

	public IEntityIterator<IEntity> inverseReachableIterator(boolean includeSelf,
			DistinctScope<IEntity> distinctScope) {
		return decorate(factory.inverseReachableIterator(includeSelf, distinctScope));
	}

	public IEntityIterator<IEntity> featureByNameIterator(String fdUri) {
		return decorate(factory.featureByNameIterator(fdUri));
	}

	public IEntityIterator<IEntity> featureByNameIterator(FeatureDescriptor fd) {
		return decorate(factory.featureByNameIterator(fd));
	}

	public IEntityIterator<IEntity> featureByIndexIterator(int relativeIndex) {
		return decorate(factory.featureByIndexIterator(relativeIndex));
	}

	public <E extends IEntity> IEntityIterator<E> childIterator() {
		return decorate(factory.childIterator());
	}

	public <E extends IEntity> IEntityIterator<E> childIterator(int relativeFirstIndex) {
		return decorate(factory.childIterator(relativeFirstIndex));
	}

	public <E extends IEntity> IEntityIterator<E> childReverseIterator() {
		return decorate(factory.childReverseIterator());
	}

	public <E extends IEntity> IEntityIterator<E> childReverseIterator(int relativeFirstIndex) {
		return decorate(factory.childReverseIterator(relativeFirstIndex));
	}

	public <E extends IEntity> IEntityIterator<E> childRangeIterator(int relativeStartIndex, int relativeEndIndex) {
		return decorate(factory.childRangeIterator(relativeStartIndex, relativeEndIndex));
	}

	public <E extends IEntity> IEntityIterator<E> descendantIterator() {
		return decorate(factory.descendantIterator());
	}

	public <E extends IEntity> IEntityIterator<E> descendantReverseIterator() {
		return decorate(factory.descendantReverseIterator());
	}

	public <E extends IEntity> IEntityIterator<E> descendantOrSelfIterator() {
		return decorate(factory.descendantOrSelfIterator());
	}

	public <E extends IEntity> IEntityIterator<E> descendantOrSelfReverseIterator() {
		return decorate(factory.descendantOrSelfReverseIterator());
	}

	public <E extends IEntity> IEntityIterator<E> followingSiblingIterator() {
		return decorate(factory.followingSiblingIterator());
	}

	public <E extends IEntity> IEntityIterator<E> followingSiblingReverseIterator() {
		return decorate(factory.followingSiblingReverseIterator());
	}

	public <E extends IEntity> IEntityIterator<E> precedingSiblingIterator() {
		return decorate(factory.precedingSiblingIterator());
	}

	public <E extends IEntity> IEntityIterator<E> precedingSiblingReverseIterator() {
		return decorate(factory.precedingSiblingReverseIterator());
	}

	public <E extends IEntity> IEntityIterator<E> followingSiblingOrSelfIterator() {
		return decorate(factory.followingSiblingOrSelfIterator());
	}

	public <E extends IEntity> IEntityIterator<E> followingSiblingOrSelfReverseIterator() {
		return decorate(factory.followingSiblingOrSelfReverseIterator());
	}

	public <E extends IEntity> IEntityIterator<E> precedingSiblingOrSelfIterator() {
		return decorate(factory.precedingSiblingOrSelfIterator());
	}

	public <E extends IEntity> IEntityIterator<E> precedingSiblingOrSelfReverseIterator() {
		return decorate(factory.precedingSiblingOrSelfReverseIterator());
	}

	public <E extends IEntity> IEntityIterator<E> followingIterator() {
		return decorate(factory.followingIterator());
	}

	public <E extends IEntity> IEntityIterator<E> precedingIterator() {
		return decorate(factory.precedingIterator());
	}

	public <E extends IEntity> IEntityIterator<E> followingOrSelfIterator() {
		return decorate(factory.followingOrSelfIterator());
	}

	public <E extends IEntity> IEntityIterator<E> precedingOrSelfIterator() {
		return decorate(factory.precedingOrSelfIterator());
	}

	public <E extends IEntity> IEntityIterator<E> adjacentIterator() {
		return decorate(factory.adjacentIterator());
	}

	public <E extends IEntity> IEntityIterator<E> adjacentIterator(int relativeFirstIndex) {
		return decorate(factory.adjacentIterator(relativeFirstIndex));
	}

	public <E extends IEntity> IEntityIterator<E> adjacentReverseIterator() {
		return decorate(factory.adjacentReverseIterator());
	}

	public <E extends IEntity> IEntityIterator<E> reachableIterator(boolean includeSelf) {
		return decorate(factory.reachableIterator(includeSelf));
	}

	public <E extends IEntity> IEntityIterator<E> reachableIterator(boolean includeSelf,
			DistinctScope<E> distinctScope) {
		return decorate(factory.reachableIterator(includeSelf, distinctScope));
	}

	public <E extends IEntity> IEntityIterator<E> childOrAdjacentIterator() {
		return decorate(factory.childOrAdjacentIterator());
	}

	public <E extends IEntity> IEntityIterator<E> childOrAdjacentIterator(int relativeFirstIndex) {
		return decorate(factory.childOrAdjacentIterator(relativeFirstIndex));
	}

	public <E extends IEntity> IEntityIterator<E> descendantOrReachableIterator() {
		return decorate(factory.descendantOrReachableIterator());
	}

	public <E extends IEntity> IEntityIterator<E> descendantOrReachableIterator(boolean includeSelf,
			DistinctScope<E> distinctScope) {
		return decorate(factory.descendantOrReachableIterator(includeSelf, distinctScope));
	}

	public <E extends IEntity> ScannerIterator<E> scannerIterator(IExecutable<E> iterator) {
		return factory .scannerIterator(iterator);
	}

	public <E extends IEntity> MatcherIterator<E> matcherIterator(IExecutable<E> iterator) {
		return factory .matcherIterator(iterator);
	}

	public <E extends IEntity> IEntityIterator<E> filterIterator(IExecutable<E> iterator, IExecutable<? extends IEntity> filterIterator) {
		return decorate(factory.filterIterator(iterator, filterIterator));
	}

	public IEntityIterator<IEntity> matchInScopeIterator(IExecutable<IEntity> patternIterator) {
		return decorate(factory.matchInScopeIterator(patternIterator));
	}

	public <E extends IEntity> IEntityIterator<E> ifIterator(IExecutable<? extends IEntity> conditionIterator, IExecutable<E> doIterator) {
		return decorate(factory.ifIterator(conditionIterator, doIterator));
	}

	public <E extends IEntity> IEntityIterator<E> forIterator(IExecutable<? extends IEntity> forIterator, IExecutable<E> doIterator) {
		return decorate(factory.forIterator(forIterator, doIterator));
	}

	public IEntityIterator<IEntity> functionApplicationIterator(String functionUri) {
		return decorate(factory.functionApplicationIterator(functionUri));
	}

	public IEntityIterator<IEntity> recursiveFunctionApplicationIterator() {
		return decorate(factory.recursiveFunctionApplicationIterator());
	}

	public <E extends IEntity> IEntityIterator<E> templateInterpreterIterator(IEntity template) {
		return decorate(factory.templateInterpreterIterator(template));
	}

	public <E extends IEntity> IEntityIterator<E> chooseIterator(IExecutable<? extends E>... iteratorChain) {
		return decorate(factory.chooseIterator(iteratorChain));
	}

	public <E extends IEntity> IEntityIterator<E> chooseIterator(ILanguageKit languageKit) {
		return decorate(factory.chooseIterator(languageKit));
	}

	public <E extends IEntity> IEntityIterator<E> blockIterator(IExecutable<? extends E>... iteratorChain) {
		return decorate(factory.blockIterator(iteratorChain));
	}

	public <E extends IEntity> IEntityIterator<E> sequenceIterator(IExecutable<? extends E>... iteratorChain) {
		return decorate(factory.sequenceIterator(iteratorChain));
	}

	public <E extends IEntity> IEntityIterator<E> composeIterator(IExecutable<E> iterator, IExecutable<? extends IEntity>... nestedIterators) {
		return decorate(factory.composeIterator(iterator, nestedIterators));
	}

	public <E extends IEntity> IEntityIterator<E> filterByIndexIterator(IExecutable<E> iterator, int index) {
		return decorate(factory.filterByIndexIterator(iterator, index));
	}

	public <E extends IEntity> IEntityIterator<E> filterByIndexRangeIterator(IExecutable<E> iterator, int startIndex, int endIndex) {
		return decorate(factory.filterByIndexRangeIterator(iterator, startIndex, endIndex));
	}

	public <E extends IEntity> IEntityIterator<E> filterByIndexRangeIterator() {
		return decorate(factory.filterByIndexRangeIterator());
	}

	public <E extends IEntity> DistinctScope<E> distinctScope() {
		return factory .distinctScope();
	}

	public <E extends IEntity> DistinctScope<E> distinctScope(IEntityComparator<IEntity> comparator) {
		return factory .distinctScope(comparator);
	}

	public <E extends IEntity> IEntityIterator<E> sort(IExecutable<E> iterator) {
		return decorate(factory.sort(iterator));
	}

	public <E extends IEntity> IEntityIterator<E> sort(IExecutable<E> iterator, IEntityComparator<E> comparator) {
		return decorate(factory.sort(iterator, comparator));
	}

	@SuppressWarnings("unchecked")
	public IEntityIterator<IEntity> unionAllIterator(IExecutable<? extends IEntity>... iteratorChain) {
		return decorate(factory.unionAllIterator(iteratorChain));
	}

	@SuppressWarnings("unchecked")
	public IEntityIterator<IEntity> unionIterator(IExecutable<? extends IEntity>... iteratorChain) {
		return decorate(factory.unionIterator(iteratorChain));
	}

	@SuppressWarnings("unchecked")
	public IEntityIterator<IEntity> intersectIterator(IExecutable<? extends IEntity>... iteratorChain) {
		return decorate(factory.intersectIterator(iteratorChain));
	}

	@SuppressWarnings("unchecked")
	public IEntityIterator<IEntity> exceptIterator(IExecutable<? extends IEntity>... iteratorChain) {
		return decorate(factory.exceptIterator(iteratorChain));
	}

	public <E extends IEntity> IEntityIterator<E> ancestorScannerIterator() {
		return decorate(factory.ancestorScannerIterator());
	}

	public <E extends IEntity> ScannerIterator<E> childScannerIterator() {
		return factory .childScannerIterator();
	}

	public <E extends IEntity> ScannerIterator<E> childReverseScannerIterator() {
		return factory .childReverseScannerIterator();
	}

	public <E extends IEntity> ScannerIterator<E> descendantOrSelfScannerIterator() {
		return factory .descendantOrSelfScannerIterator();
	}

	public <E extends IEntity> ScannerIterator<E> descendantOrSelfReverseScannerIterator() {
		return factory .descendantOrSelfReverseScannerIterator();
	}

	public <E extends IEntity> MatcherIterator<E> ancestorMatcherIterator() {
		return factory .ancestorMatcherIterator();
	}

	public <E extends IEntity> MatcherIterator<E> ancestorOrSelfMatcherIterator() {
		return factory .ancestorOrSelfMatcherIterator();
	}

	public <E extends IEntity> MatcherIterator<E> childMatcherIterator() {
		return factory .childMatcherIterator();
	}

	public <E extends IEntity> MatcherIterator<E> childReverseMatcherIterator() {
		return factory .childReverseMatcherIterator();
	}

	public <E extends IEntity> MatcherIterator<E> descendantOrSelfMatcherIterator() {
		return factory .descendantOrSelfMatcherIterator();
	}

	public <E extends IEntity> MatcherIterator<E> descendantOrSelfReverseMatcherIterator() {
		return factory .descendantOrSelfReverseMatcherIterator();
	}

	public IEntityIterator<IEntity> atStageIterator(int stage) {
		return decorate(factory.atStageIterator(stage));
	}

	public IEntityIterator<IEntity> atHostStageIterator() {
		return decorate(factory.atHostStageIterator());
	}

	public IEntityIterator<IEntity> atTemplateStageIterator() {
		return decorate(factory.atTemplateStageIterator());
	}

	public IEntityIterator<IEntity> hasKindIterator(EntityKinds kind) {
		return decorate(factory.hasKindIterator(kind));
	}

	public IEntityIterator<IEntity> hasCompositeKindIterator(CompositeKinds kind) {
		return decorate(factory.hasCompositeKindIterator(kind));
	}

	public IEntityIterator<IEntity> hasDataKindIterator(DataKinds kind) {
		return decorate(factory.hasDataKindIterator(kind));
	}

	public IEntityIterator<IEntity> isFragmentIterator() {
		return decorate(factory.isFragmentIterator());
	}

	public IEntityIterator<IEntity> isVariableIterator() {
		return decorate(factory.isVariableIterator());
	}

	public IEntityIterator<IEntity> isResolverIterator() {
		return decorate(factory.isResolverIterator());
	}

	public IEntityIterator<IEntity> isImplIterator() {
		return decorate(factory.isImplIterator());
	}

	public IEntityIterator<?> andIterator(IExecutable<?>... argsIterators) {
		return decorate(factory.andIterator(argsIterators));
	}

	public IEntityIterator<?> orIterator(IExecutable<?>... argsIterators) {
		return decorate(factory.orIterator(argsIterators));
	}

	public IEntityIterator<?> notIterator(IExecutable<?> argIterator) {
		return decorate(factory.notIterator(argIterator));
	}

	public IEntityIterator<IEntity> oneIterator(IExecutable<IEntity> fromClause, IExecutable<IEntity> satisfiesClause) {
		return decorate(factory.oneIterator(fromClause, satisfiesClause));
	}

	public IEntityIterator<IEntity> someIterator(IExecutable<IEntity> fromClause) {
		return decorate(factory.someIterator(fromClause));
	}

	public IEntityIterator<IEntity> someIterator(IExecutable<IEntity> fromClause, IExecutable<IEntity> satisfiesClause) {
		return decorate(factory.someIterator(fromClause, satisfiesClause));
	}

	public IEntityIterator<IEntity> everyIterator(IExecutable<IEntity> fromClause, IExecutable<IEntity> satisfiesClause) {
		return decorate(factory.everyIterator(fromClause, satisfiesClause));
	}

	public IEntityIterator<IEntity> isLanguageIterator(String languageURI) {
		return decorate(factory.isLanguageIterator(languageURI));
	}

	public IEntityIterator<IEntity> hasTypeIterator(String typeUri) {
		return decorate(factory.hasTypeIterator(typeUri));
	}

	public IEntityIterator<IEntity> isLanguageSubtypeOfIterator(String typeUri) {
		return decorate(factory.isLanguageSubtypeOfIterator(typeUri));
	}

	public IEntityIterator<IEntity> isLanguageSupertypeOfIterator(String typeUri) {
		return decorate(factory.isLanguageSupertypeOfIterator(typeUri));
	}

	public IEntityIterator<IEntity> isExtendedLanguageSubtypeOfIterator(String typeUri) {
		return decorate(factory.isExtendedLanguageSubtypeOfIterator(typeUri));
	}

	public IEntityIterator<IEntity> isExtendedLanguageSupertypeOfIterator(String typeUri) {
		return decorate(factory.isExtendedLanguageSupertypeOfIterator(typeUri));
	}

	public IEntityIterator<IEntity> atTypeIterator(String edUri) {
		return decorate(factory.atTypeIterator(edUri));
	}

	public IEntityIterator<IEntity> atFeatureIterator(String fdUri) {
		return decorate(factory.atFeatureIterator(fdUri));
	}

	public IEntityIterator<IEntity> atIndexIterator(int index) {
		return decorate(factory.atIndexIterator(index));
	}

	public IEntityIterator<IEntity> asVariableIterator(String name) {
		return decorate(factory.asVariableIterator(name));
	}

	public IEntityIterator<IEntity> atStageVariableIterator(String name) {
		return decorate(factory.atStageVariableIterator(name));
	}

	public IEntityIterator<IEntity> languageVariableIterator(String name) {
		return decorate(factory.languageVariableIterator(name));
	}

	public IEntityIterator<IEntity> typeVariableIterator(String name) {
		return decorate(factory.typeVariableIterator(name));
	}

	public IEntityIterator<IEntity> languageSubtypeOfVariableIterator(String name) {
		return decorate(factory.languageSubtypeOfVariableIterator(name));
	}

	public IEntityIterator<IEntity> languageSupertypeOfVariableIterator(String name) {
		return decorate(factory.languageSupertypeOfVariableIterator(name));
	}

	public IEntityIterator<IEntity> extendedLanguageSubtypeOfVariableIterator(String name) {
		return decorate(factory.extendedLanguageSubtypeOfVariableIterator(name));
	}

	public IEntityIterator<IEntity> extendedLanguageSupertypeOfVariableIterator(String name) {
		return decorate(factory.extendedLanguageSupertypeOfVariableIterator(name));
	}

	public IEntityIterator<IEntity> iterationIndexVariableIterator(IExecutable<?> indexIterator, String name) {
		return decorate(factory.iterationIndexVariableIterator(indexIterator, name));
	}

	public IEntityIterator<IEntity> iterationIndexIterator(IExecutable<?> indexIterator, int index) {
		return decorate(factory.iterationIndexIterator(indexIterator, index));
	}

	public IEntityIterator<IEntity> iterationIndexRangeIterator(IExecutable<?> indexIterator, int startIndex, int endIndex) {
		return decorate(factory.iterationIndexRangeIterator(indexIterator, startIndex, endIndex));
	}

	public IEntityIterator<IEntity> pointwiseEqualsIterator(IExecutable<IEntity> leftOperand, IExecutable<IEntity> rightOperand) {
		return decorate(factory.pointwiseEqualsIterator(leftOperand, rightOperand));
	}

	public <E extends IEntity> IEntityIterator<E> scopeIterator(IExecutable<E> scopeIterator,
			String environmentName, Set<String> localNames, boolean withFreshNames) {
		return decorate(factory.scopeIterator(scopeIterator, environmentName, localNames, withFreshNames));
	}

	public IEntityIterator<?> tupleFactoryIterator(IExecutable<?>... tupleIterators) {
		return decorate(factory.tupleFactoryIterator(tupleIterators));
	}

	public <E extends IEntity> IEntityIterator<E> selectIterator(IExecutable<E> selectIterator, IExecutable<? extends IEntity> fromIterator, IExecutable<? extends IEntity> whereIterator) {
		return decorate(factory.selectIterator(selectIterator, fromIterator, whereIterator));
	}

	@SuppressWarnings("unchecked")
	public IEntityIterator<IEntity> cartesianProductIterator(IExecutable<? extends IEntity>... iterators) {
		return decorate(factory.cartesianProductIterator(iterators));
	}

	@SuppressWarnings("unchecked")
	public IEntityIterator<IEntity> pointwiseProductIterator(IExecutable<? extends IEntity>... iterators) {
		return decorate(factory.pointwiseProductIterator(iterators));
	}

	public <E extends IEntity> IEntityIterator<E> cartesianUpdateIterator(IExecutable<? extends E> valuesIterator, IExecutable<E> toIterator) {
		return decorate(factory.cartesianUpdateIterator(valuesIterator, toIterator));
	}

	public <E extends IEntity> IEntityIterator<E> pointwiseUpdateIterator(IExecutable<E> valuesIterator, IExecutable<? super E> toIterator) {
		return decorate(factory.pointwiseUpdateIterator(valuesIterator, toIterator));
	}

	public <E extends IEntity> IEntityIterator<E> cartesianInsertIterator(IExecutable<? extends E> valuesIterator, IExecutable<E> toIterator, Placement placement) {
		return decorate(factory.cartesianInsertIterator(valuesIterator, toIterator, placement));
	}

	public <E extends IEntity> IEntityIterator<E> pointwiseInsertIterator(IExecutable<E> valuesIterator, IExecutable<? super E> toIterator, Placement placement) {
		return decorate(factory.pointwiseInsertIterator(valuesIterator, toIterator, placement));
	}

	public <E extends IEntity> IEntityIterator<E> deleteIterator(IExecutable<E> valuesIterator) {
		return decorate(factory.deleteIterator(valuesIterator));
	}

	@SuppressWarnings("unchecked")
	public <E extends IEntity> IEntityIterator<E> callIterator(String name, IExecutable<? extends E>... argsIterators) {
		return decorate(factory.callIterator(name, argsIterators));
	}

	public IEntityIterator<?> nestedVariableIterator() {
		return decorate(factory.nestedVariableIterator());
	}

	public IEntityIterator<?> nestedFragmentIterator(Map<IEntity, IEntityIterator<?>> fragmentIteratorMap) {
		return decorate(factory.nestedFragmentIterator(fragmentIteratorMap));
	}

	public IEntityIterator<?> cloneReplacingIterator(IExecutable<?> childMappingIterator) {
		return decorate(factory.cloneReplacingIterator(childMappingIterator));
	}

	public IEntityIterator<?> cloneReplacingIterator(IExecutable<?> childMappingIterator, Set<String> shallowUriSet) {
		return decorate(factory.cloneReplacingIterator(childMappingIterator, shallowUriSet));
	}
}

