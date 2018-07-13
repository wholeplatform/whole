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
public interface IteratorFactory {
	public static IteratorFactory instance =
//			new InstrumentedIteratorFactory();
			new GenericIteratorFactory();


	<E extends IEntity> IEntityIterator<E> emptyIterator();

	<E extends IEntity> IEntityIterator<E> failureIterator(Throwable failure);

	<E extends IEntity> IEntityIterator<E> variableIterator(String varName);

	<E extends IEntity> IEntityIterator<E> outerVariableIterator(String varName);

	<E extends IEntity> IEntityIterator<E> constantIterator(E constant, boolean useClone);

	<E extends IEntity> IEntityIterator<E> constantChildIterator(IEntity constant);

	<E extends IEntity> IEntityIterator<E> constantComposeIterator(IEntity constant, IEntityIterator<E> iterator);

	<E extends IEntity> IEntityIterator<E> constantSubstituteIterator(E constant, boolean useClone);

	<E extends IEntity> IEntityIterator<E> entityCollectionIterator(Iterable<E> entityCollectionIterable);

	<E extends IEntity> IEntityIterator<E> javaCollectionIterator(Iterable<?> collectionIterable);

	<E extends IEntity> IEntityIterator<E> collectionIterator(Iterable<?> collectionIterable, IDataTypeWrapper elementWrapper);

	<E extends IEntity> IEntityIterator<E> singleValuedRunnableIterator(IRunnable runnable);

	<E extends IEntity> IEntityIterator<E> singleValuedRunnableIterator(IRunnable runnable, IEntityIterator<?>... argsIterators);

	<E extends IEntity> IEntityIterator<E> singleValuedRunnableIterator(IRunnable runnable, int[] optionalArgsIndexes, IEntityIterator<?>... argsIterators);

	<E extends IEntity> IEntityIterator<E> multiValuedRunnableIterator(IRunnable runnable, IEntityIterator<?>... argsIterators);

	<E extends IEntity> IEntityIterator<E> multiValuedRunnableIterator(IRunnable runnable, int[] optionalArgsIndexes, IEntityIterator<?>... argsIterators);

	IEntityIterator<IEntity> aspectIterator();

	<E extends IEntity> IEntityIterator<E> selfIterator();

	<E extends IEntity> IEntityIterator<E> repeatedSelfIterator();

	IEntityIterator<IEntity> rootIterator();

	IEntityIterator<IEntity> fragmentRootIterator();

	<E extends IEntity> IEntityIterator<E> parentIterator();

	<E extends IEntity> IEntityIterator<E> ancestorIterator();

	<E extends IEntity> IEntityIterator<E> ancestorOrSelfIterator();

	IEntityIterator<IEntity> ancestorReverseIterator();

	IEntityIterator<IEntity> ancestorOrSelfReverseIterator();

	IEntityIterator<IEntity> inverseAdjacentIterator();

	IEntityIterator<IEntity> inverseReachableIterator(boolean includeSelf);

	IEntityIterator<IEntity> inverseReachableIterator(boolean includeSelf, DistinctScope<IEntity> distinctScope);

	IEntityIterator<IEntity> featureByNameIterator(String fdUri);

	IEntityIterator<IEntity> featureByNameIterator(FeatureDescriptor fd);

	IEntityIterator<IEntity> featureByIndexIterator(int relativeIndex);

	<E extends IEntity> IEntityIterator<E> childIterator();

	<E extends IEntity> IEntityIterator<E> childIterator(int relativeFirstIndex);

	<E extends IEntity> IEntityIterator<E> childReverseIterator();

	<E extends IEntity> IEntityIterator<E> childReverseIterator(int relativeFirstIndex);

	<E extends IEntity> IEntityIterator<E> childRangeIterator(int relativeStartIndex, int relativeEndIndex);

	<E extends IEntity> IEntityIterator<E> descendantIterator();

	<E extends IEntity> IEntityIterator<E> descendantReverseIterator();

	<E extends IEntity> IEntityIterator<E> descendantOrSelfIterator();

	<E extends IEntity> IEntityIterator<E> descendantOrSelfReverseIterator();

	<E extends IEntity> IEntityIterator<E> followingSiblingIterator();

	<E extends IEntity> IEntityIterator<E> followingSiblingReverseIterator();

	<E extends IEntity> IEntityIterator<E> precedingSiblingIterator();

	<E extends IEntity> IEntityIterator<E> precedingSiblingReverseIterator();

	<E extends IEntity> IEntityIterator<E> followingSiblingOrSelfIterator();

	<E extends IEntity> IEntityIterator<E> followingSiblingOrSelfReverseIterator();

	<E extends IEntity> IEntityIterator<E> precedingSiblingOrSelfIterator();

	<E extends IEntity> IEntityIterator<E> precedingSiblingOrSelfReverseIterator();

	<E extends IEntity> IEntityIterator<E> followingIterator();

	<E extends IEntity> IEntityIterator<E> precedingIterator();

	<E extends IEntity> IEntityIterator<E> followingOrSelfIterator();

	<E extends IEntity> IEntityIterator<E> precedingOrSelfIterator();

	<E extends IEntity> IEntityIterator<E> adjacentIterator();

	<E extends IEntity> IEntityIterator<E> adjacentIterator(int relativeFirstIndex);

	<E extends IEntity> IEntityIterator<E> adjacentReverseIterator();

	<E extends IEntity> IEntityIterator<E> reachableIterator(boolean includeSelf);

	<E extends IEntity> IEntityIterator<E> reachableIterator(boolean includeSelf, DistinctScope<E> distinctScope);

	<E extends IEntity> IEntityIterator<E> childOrAdjacentIterator();

	<E extends IEntity> IEntityIterator<E> childOrAdjacentIterator(int relativeFirstIndex);

	<E extends IEntity> IEntityIterator<E> descendantOrReachableIterator();

	<E extends IEntity> IEntityIterator<E> descendantOrReachableIterator(boolean includeSelf, DistinctScope<E> distinctScope);

	<E extends IEntity> ScannerIterator<E> scannerIterator(IEntityIterator<E> iterator);

	<E extends IEntity> MatcherIterator<E> matcherIterator(IEntityIterator<E> iterator);

	<E extends IEntity> IEntityIterator<E> filterIterator(IEntityIterator<E> iterator, IEntityIterator<? extends IEntity> filterIterator);

	IEntityIterator<IEntity> matchInScopeIterator(IEntityIterator<IEntity> patternIterator);

	<E extends IEntity> IEntityIterator<E> ifIterator(IEntityIterator<? extends IEntity> conditionIterator, IEntityIterator<E> doIterator);

	<E extends IEntity> IEntityIterator<E> forIterator(IEntityIterator<? extends IEntity> forIterator, IEntityIterator<E> doIterator);

	IEntityIterator<IEntity> functionApplicationIterator(String functionUri);

	IEntityIterator<IEntity> recursiveFunctionApplicationIterator();

	<E extends IEntity> IEntityIterator<E> templateInterpreterIterator(IEntity template);

	@SuppressWarnings("unchecked")
	<E extends IEntity> IEntityIterator<E> chooseIterator(IEntityIterator<? extends E>... iteratorChain);

	<E extends IEntity> IEntityIterator<E> chooseIterator(ILanguageKit languageKit);

	@SuppressWarnings("unchecked")
	<E extends IEntity> IEntityIterator<E> blockIterator(IEntityIterator<? extends E>... iteratorChain);

	@SuppressWarnings("unchecked")
	<E extends IEntity> IEntityIterator<E> sequenceIterator(IEntityIterator<? extends E>... iteratorChain);

	@SuppressWarnings("unchecked")
	<E extends IEntity> IEntityIterator<E> composeIterator(IEntityIterator<E> iterator, IEntityIterator<? extends IEntity>... nestedIterators);

	<E extends IEntity> IEntityIterator<E> filterByIndexIterator(IEntityIterator<E> iterator, int index);

	<E extends IEntity> IEntityIterator<E> filterByIndexRangeIterator(IEntityIterator<E> iterator, int startIndex, int endIndex);

	<E extends IEntity> IEntityIterator<E> filterByIndexRangeIterator();

	<E extends IEntity> DistinctScope<E> distinctScope();

	<E extends IEntity> DistinctScope<E> distinctScope(IEntityComparator<IEntity> comparator);

	<E extends IEntity> IEntityIterator<E> sort(IEntityIterator<E> iterator);

	<E extends IEntity> IEntityIterator<E> sort(IEntityIterator<E> iterator, IEntityComparator<E> comparator);

	@SuppressWarnings("unchecked")
	IEntityIterator<IEntity> unionAllIterator(IEntityIterator<? extends IEntity>... iteratorChain);

	@SuppressWarnings("unchecked")
	IEntityIterator<IEntity> unionIterator(IEntityIterator<? extends IEntity>... iteratorChain);

	@SuppressWarnings("unchecked")
	IEntityIterator<IEntity> intersectIterator(IEntityIterator<? extends IEntity>... iteratorChain);

	@SuppressWarnings("unchecked")
	IEntityIterator<IEntity> exceptIterator(IEntityIterator<? extends IEntity>... iteratorChain);

	<E extends IEntity> IEntityIterator<E> ancestorScannerIterator();

	<E extends IEntity> ScannerIterator<E> childScannerIterator();

	<E extends IEntity> ScannerIterator<E> childReverseScannerIterator();

	<E extends IEntity> ScannerIterator<E> descendantOrSelfScannerIterator();

	<E extends IEntity> ScannerIterator<E> descendantOrSelfReverseScannerIterator();

	<E extends IEntity> MatcherIterator<E> ancestorMatcherIterator();

	<E extends IEntity> MatcherIterator<E> ancestorOrSelfMatcherIterator();

	<E extends IEntity> MatcherIterator<E> childMatcherIterator();

	<E extends IEntity> MatcherIterator<E> childReverseMatcherIterator();

	<E extends IEntity> MatcherIterator<E> descendantOrSelfMatcherIterator();

	<E extends IEntity> MatcherIterator<E> descendantOrSelfReverseMatcherIterator();

	IEntityIterator<IEntity> atStageIterator(int stage);

	IEntityIterator<IEntity> atHostStageIterator();

	IEntityIterator<IEntity> atTemplateStageIterator();

	IEntityIterator<IEntity> hasKindIterator(EntityKinds kind);

	IEntityIterator<IEntity> hasCompositeKindIterator(CompositeKinds kind);

	IEntityIterator<IEntity> hasDataKindIterator(DataKinds kind);

	IEntityIterator<IEntity> isFragmentIterator();

	IEntityIterator<IEntity> isVariableIterator();

	IEntityIterator<IEntity> isResolverIterator();

	IEntityIterator<IEntity> isImplIterator();

	IEntityIterator<?> andIterator(IEntityIterator<?>... argsIterators);

	IEntityIterator<?> orIterator(IEntityIterator<?>... argsIterators);

	IEntityIterator<?> notIterator(IEntityIterator<?> argIterator);

	IEntityIterator<IEntity> oneIterator(IEntityIterator<IEntity> fromClause, IEntityIterator<IEntity> satisfiesClause);

	IEntityIterator<IEntity> someIterator(IEntityIterator<IEntity> fromClause);

	IEntityIterator<IEntity> someIterator(IEntityIterator<IEntity> fromClause, IEntityIterator<IEntity> satisfiesClause);

	IEntityIterator<IEntity> everyIterator(IEntityIterator<IEntity> fromClause, IEntityIterator<IEntity> satisfiesClause);

	IEntityIterator<IEntity> isLanguageIterator(String languageURI);

	IEntityIterator<IEntity> hasTypeIterator(String typeUri);

	IEntityIterator<IEntity> isLanguageSubtypeOfIterator(String typeUri);

	IEntityIterator<IEntity> isLanguageSupertypeOfIterator(String typeUri);

	IEntityIterator<IEntity> isExtendedLanguageSubtypeOfIterator(String typeUri);

	IEntityIterator<IEntity> isExtendedLanguageSupertypeOfIterator(String typeUri);

	IEntityIterator<IEntity> atTypeIterator(String edUri);

	IEntityIterator<IEntity> atFeatureIterator(String fdUri);

	IEntityIterator<IEntity> atIndexIterator(int index);

	IEntityIterator<IEntity> asVariableIterator(String name);

	IEntityIterator<IEntity> atStageVariableIterator(String name);

	IEntityIterator<IEntity> languageVariableIterator(String name);

	IEntityIterator<IEntity> typeVariableIterator(String name);

	IEntityIterator<IEntity> languageSubtypeOfVariableIterator(String name);

	IEntityIterator<IEntity> languageSupertypeOfVariableIterator(String name);

	IEntityIterator<IEntity> extendedLanguageSubtypeOfVariableIterator(String name);

	IEntityIterator<IEntity> extendedLanguageSupertypeOfVariableIterator(String name);

	IEntityIterator<IEntity> iterationIndexVariableIterator(IEntityIterator<?> indexIterator, String name);

	IEntityIterator<IEntity> iterationIndexIterator(IEntityIterator<?> indexIterator, int index);

	IEntityIterator<IEntity> iterationIndexRangeIterator(IEntityIterator<?> indexIterator, int startIndex, int endIndex);

	IEntityIterator<IEntity> pointwiseEqualsIterator(IEntityIterator<IEntity> leftOperand, IEntityIterator<IEntity> rightOperand);

	<E extends IEntity> IEntityIterator<E> scopeIterator(IEntityIterator<E> scopeIterator, String environmentName, Set<String> localNames, boolean withFreshNames);

	IEntityIterator<?> tupleFactoryIterator(IEntityIterator<?>... tupleIterators);

	<E extends IEntity> IEntityIterator<E> selectIterator(IEntityIterator<E> selectIterator, IEntityIterator<? extends IEntity> fromIterator, IEntityIterator<? extends IEntity> whereIterator);

	@SuppressWarnings("unchecked")
	IEntityIterator<IEntity> cartesianProductIterator(IEntityIterator<? extends IEntity>... iterators);

	@SuppressWarnings("unchecked")
	IEntityIterator<IEntity> pointwiseProductIterator(IEntityIterator<? extends IEntity>... iterators);

	<E extends IEntity> IEntityIterator<E> cartesianUpdateIterator(IEntityIterator<? extends E> valuesIterator, IEntityIterator<E> toIterator);

	<E extends IEntity> IEntityIterator<E> pointwiseUpdateIterator(IEntityIterator<E> valuesIterator, IEntityIterator<? super E> toIterator);

	<E extends IEntity> IEntityIterator<E> cartesianInsertIterator(IEntityIterator<? extends E> valuesIterator, IEntityIterator<E> toIterator, Placement placement);

	<E extends IEntity> IEntityIterator<E> pointwiseInsertIterator(IEntityIterator<E> valuesIterator, IEntityIterator<? super E> toIterator, Placement placement);

	<E extends IEntity> IEntityIterator<E> deleteIterator(IEntityIterator<E> valuesIterator);

	@SuppressWarnings("unchecked")
	public <E extends IEntity> IEntityIterator<E> callIterator(String name, IEntityIterator<? extends E>... argsIterators);

	IEntityIterator<?> nestedVariableIterator();

	IEntityIterator<?> nestedFragmentIterator(Map<IEntity, IEntityIterator<?>> fragmentIteratorMap);

	IEntityIterator<?> cloneReplacingIterator(IEntityIterator<?> childMappingIterator);

	IEntityIterator<?> cloneReplacingIterator(IEntityIterator<?> childMappingIterator, Set<String> shallowUriSet);
}