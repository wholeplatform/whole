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

public class InstrumentedIteratorFactory implements IteratorFactory {
	IteratorFactory factory = new GenericIteratorFactory();

	protected <E extends IEntity> IEntityIterator<E> instrument(IEntityIterator<E> iterator) {
		return new InstrumentingIterator<E>(iterator);
	}

	public <E extends IEntity> IEntityIterator<E> emptyIterator() {
		return instrument(factory.emptyIterator());
	}

	public <E extends IEntity> IEntityIterator<E> failureIterator(Throwable failure) {
		return instrument(factory.failureIterator(failure));
	}

	public <E extends IEntity> IEntityIterator<E> variableIterator(String varName) {
		return instrument(factory.variableIterator(varName));
	}

	public <E extends IEntity> IEntityIterator<E> outerVariableIterator(String varName) {
		return instrument(factory.outerVariableIterator(varName));
	}

	public <E extends IEntity> IEntityIterator<E> constantIterator(E constant, boolean useClone) {
		return instrument(factory.constantIterator(constant, useClone));
	}

	public <E extends IEntity> IEntityIterator<E> constantChildIterator(IEntity constant) {
		return instrument(factory.constantChildIterator(constant));
	}

	public <E extends IEntity> IEntityIterator<E> constantComposeIterator(IEntity constant, IEntityIterator<E> iterator) {
		return instrument(factory.constantComposeIterator(constant, iterator));
	}

	public <E extends IEntity> IEntityIterator<E> constantSubstituteIterator(E constant, boolean useClone) {
		return instrument(factory.constantSubstituteIterator(constant, useClone));
	}

	public <E extends IEntity> IEntityIterator<E> entityCollectionIterator(Iterable<E> entityCollectionIterable) {
		return instrument(factory.entityCollectionIterator(entityCollectionIterable));
	}

	public <E extends IEntity> IEntityIterator<E> javaCollectionIterator(Iterable<?> collectionIterable) {
		return instrument(factory.javaCollectionIterator(collectionIterable));
	}

	public <E extends IEntity> IEntityIterator<E> collectionIterator(Iterable<?> collectionIterable,
			IDataTypeWrapper elementWrapper) {
		return instrument(factory.collectionIterator(collectionIterable, elementWrapper));
	}

	public <E extends IEntity> IEntityIterator<E> singleValuedRunnableIterator(IRunnable runnable) {
		return instrument(factory.singleValuedRunnableIterator(runnable));
	}

	public <E extends IEntity> IEntityIterator<E> singleValuedRunnableIterator(IRunnable runnable,
			IEntityIterator<?>... argsIterators) {
		return instrument(factory.singleValuedRunnableIterator(runnable, argsIterators));
	}

	public <E extends IEntity> IEntityIterator<E> singleValuedRunnableIterator(IRunnable runnable,
			int[] optionalArgsIndexes, IEntityIterator<?>... argsIterators) {
		return instrument(factory.singleValuedRunnableIterator(runnable, optionalArgsIndexes, argsIterators));
	}

	public <E extends IEntity> IEntityIterator<E> multiValuedRunnableIterator(IRunnable runnable,
			IEntityIterator<?>... argsIterators) {
		return instrument(factory.multiValuedRunnableIterator(runnable, argsIterators));
	}

	public <E extends IEntity> IEntityIterator<E> multiValuedRunnableIterator(IRunnable runnable,
			int[] optionalArgsIndexes, IEntityIterator<?>... argsIterators) {
		return instrument(factory.multiValuedRunnableIterator(runnable, optionalArgsIndexes, argsIterators));
	}

	public IEntityIterator<IEntity> aspectIterator() {
		return instrument(factory.aspectIterator());
	}

	public <E extends IEntity> IEntityIterator<E> selfIterator() {
		return instrument(factory.selfIterator());
	}

	public <E extends IEntity> IEntityIterator<E> repeatedSelfIterator() {
		return instrument(factory.repeatedSelfIterator());
	}

	public IEntityIterator<IEntity> rootIterator() {
		return instrument(factory.rootIterator());
	}

	public IEntityIterator<IEntity> fragmentRootIterator() {
		return instrument(factory.fragmentRootIterator());
	}

	public <E extends IEntity> IEntityIterator<E> parentIterator() {
		return instrument(factory.parentIterator());
	}

	public <E extends IEntity> IEntityIterator<E> ancestorIterator() {
		return instrument(factory.ancestorIterator());
	}

	public <E extends IEntity> IEntityIterator<E> ancestorOrSelfIterator() {
		return instrument(factory.ancestorOrSelfIterator());
	}

	public IEntityIterator<IEntity> ancestorReverseIterator() {
		return instrument(factory.ancestorReverseIterator());
	}

	public IEntityIterator<IEntity> ancestorOrSelfReverseIterator() {
		return instrument(factory.ancestorOrSelfReverseIterator());
	}

	public IEntityIterator<IEntity> inverseAdjacentIterator() {
		return instrument(factory.inverseAdjacentIterator());
	}

	public IEntityIterator<IEntity> inverseReachableIterator(boolean includeSelf) {
		return instrument(factory.inverseReachableIterator(includeSelf));
	}

	public IEntityIterator<IEntity> inverseReachableIterator(boolean includeSelf,
			DistinctScope<IEntity> distinctScope) {
		return instrument(factory.inverseReachableIterator(includeSelf, distinctScope));
	}

	public IEntityIterator<IEntity> featureByNameIterator(String fdUri) {
		return instrument(factory.featureByNameIterator(fdUri));
	}

	public IEntityIterator<IEntity> featureByNameIterator(FeatureDescriptor fd) {
		return instrument(factory.featureByNameIterator(fd));
	}

	public IEntityIterator<IEntity> featureByIndexIterator(int relativeIndex) {
		return instrument(factory.featureByIndexIterator(relativeIndex));
	}

	public <E extends IEntity> IEntityIterator<E> childIterator() {
		return instrument(factory.childIterator());
	}

	public <E extends IEntity> IEntityIterator<E> childIterator(int relativeFirstIndex) {
		return instrument(factory.childIterator(relativeFirstIndex));
	}

	public <E extends IEntity> IEntityIterator<E> childReverseIterator() {
		return instrument(factory.childReverseIterator());
	}

	public <E extends IEntity> IEntityIterator<E> childReverseIterator(int relativeFirstIndex) {
		return instrument(factory.childReverseIterator(relativeFirstIndex));
	}

	public <E extends IEntity> IEntityIterator<E> childRangeIterator(int relativeStartIndex, int relativeEndIndex) {
		return instrument(factory.childRangeIterator(relativeStartIndex, relativeEndIndex));
	}

	public <E extends IEntity> IEntityIterator<E> descendantIterator() {
		return instrument(factory.descendantIterator());
	}

	public <E extends IEntity> IEntityIterator<E> descendantReverseIterator() {
		return instrument(factory.descendantReverseIterator());
	}

	public <E extends IEntity> IEntityIterator<E> descendantOrSelfIterator() {
		return instrument(factory.descendantOrSelfIterator());
	}

	public <E extends IEntity> IEntityIterator<E> descendantOrSelfReverseIterator() {
		return instrument(factory.descendantOrSelfReverseIterator());
	}

	public <E extends IEntity> IEntityIterator<E> followingSiblingIterator() {
		return instrument(factory.followingSiblingIterator());
	}

	public <E extends IEntity> IEntityIterator<E> followingSiblingReverseIterator() {
		return instrument(factory.followingSiblingReverseIterator());
	}

	public <E extends IEntity> IEntityIterator<E> precedingSiblingIterator() {
		return instrument(factory.precedingSiblingIterator());
	}

	public <E extends IEntity> IEntityIterator<E> precedingSiblingReverseIterator() {
		return instrument(factory.precedingSiblingReverseIterator());
	}

	public <E extends IEntity> IEntityIterator<E> followingSiblingOrSelfIterator() {
		return instrument(factory.followingSiblingOrSelfIterator());
	}

	public <E extends IEntity> IEntityIterator<E> followingSiblingOrSelfReverseIterator() {
		return instrument(factory.followingSiblingOrSelfReverseIterator());
	}

	public <E extends IEntity> IEntityIterator<E> precedingSiblingOrSelfIterator() {
		return instrument(factory.precedingSiblingOrSelfIterator());
	}

	public <E extends IEntity> IEntityIterator<E> precedingSiblingOrSelfReverseIterator() {
		return instrument(factory.precedingSiblingOrSelfReverseIterator());
	}

	public <E extends IEntity> IEntityIterator<E> followingIterator() {
		return instrument(factory.followingIterator());
	}

	public <E extends IEntity> IEntityIterator<E> precedingIterator() {
		return instrument(factory.precedingIterator());
	}

	public <E extends IEntity> IEntityIterator<E> followingOrSelfIterator() {
		return instrument(factory.followingOrSelfIterator());
	}

	public <E extends IEntity> IEntityIterator<E> precedingOrSelfIterator() {
		return instrument(factory.precedingOrSelfIterator());
	}

	public <E extends IEntity> IEntityIterator<E> adjacentIterator() {
		return instrument(factory.adjacentIterator());
	}

	public <E extends IEntity> IEntityIterator<E> adjacentIterator(int relativeFirstIndex) {
		return instrument(factory.adjacentIterator(relativeFirstIndex));
	}

	public <E extends IEntity> IEntityIterator<E> adjacentReverseIterator() {
		return instrument(factory.adjacentReverseIterator());
	}

	public <E extends IEntity> IEntityIterator<E> reachableIterator(boolean includeSelf) {
		return instrument(factory.reachableIterator(includeSelf));
	}

	public <E extends IEntity> IEntityIterator<E> reachableIterator(boolean includeSelf,
			DistinctScope<E> distinctScope) {
		return instrument(factory.reachableIterator(includeSelf, distinctScope));
	}

	public <E extends IEntity> IEntityIterator<E> childOrAdjacentIterator() {
		return instrument(factory.childOrAdjacentIterator());
	}

	public <E extends IEntity> IEntityIterator<E> childOrAdjacentIterator(int relativeFirstIndex) {
		return instrument(factory.childOrAdjacentIterator(relativeFirstIndex));
	}

	public <E extends IEntity> IEntityIterator<E> descendantOrReachableIterator() {
		return instrument(factory.descendantOrReachableIterator());
	}

	public <E extends IEntity> IEntityIterator<E> descendantOrReachableIterator(boolean includeSelf,
			DistinctScope<E> distinctScope) {
		return instrument(factory.descendantOrReachableIterator(includeSelf, distinctScope));
	}

	public <E extends IEntity> ScannerIterator<E> scannerIterator(IEntityIterator<E> iterator) {
		return factory .scannerIterator(iterator);
	}

	public <E extends IEntity> MatcherIterator<E> matcherIterator(IEntityIterator<E> iterator) {
		return factory .matcherIterator(iterator);
	}

	public <E extends IEntity> IEntityIterator<E> filterIterator(IEntityIterator<E> iterator, IEntityIterator<? extends IEntity> filterIterator) {
		return instrument(factory.filterIterator(iterator, filterIterator));
	}

	public IEntityIterator<IEntity> matchInScopeIterator(IEntityIterator<IEntity> patternIterator) {
		return instrument(factory.matchInScopeIterator(patternIterator));
	}

	public <E extends IEntity> IEntityIterator<E> ifIterator(IEntityIterator<? extends IEntity> conditionIterator,
			IEntityIterator<E> doIterator) {
		return instrument(factory.ifIterator(conditionIterator, doIterator));
	}

	public <E extends IEntity> IEntityIterator<E> forIterator(IEntityIterator<? extends IEntity> forIterator,
			IEntityIterator<E> doIterator) {
		return instrument(factory.forIterator(forIterator, doIterator));
	}

	public IEntityIterator<IEntity> functionApplicationIterator(String functionUri) {
		return instrument(factory.functionApplicationIterator(functionUri));
	}

	public IEntityIterator<IEntity> recursiveFunctionApplicationIterator() {
		return instrument(factory.recursiveFunctionApplicationIterator());
	}

	public <E extends IEntity> IEntityIterator<E> templateInterpreterIterator(IEntity template) {
		return instrument(factory.templateInterpreterIterator(template));
	}

	public <E extends IEntity> IEntityIterator<E> chooseIterator(IEntityIterator<? extends E>... iteratorChain) {
		return instrument(factory.chooseIterator(iteratorChain));
	}

	public <E extends IEntity> IEntityIterator<E> chooseIterator(ILanguageKit languageKit) {
		return instrument(factory.chooseIterator(languageKit));
	}

	public <E extends IEntity> IEntityIterator<E> blockIterator(IEntityIterator<? extends E>... iteratorChain) {
		return instrument(factory.blockIterator(iteratorChain));
	}

	public <E extends IEntity> IEntityIterator<E> sequenceIterator(IEntityIterator<? extends E>... iteratorChain) {
		return instrument(factory.sequenceIterator(iteratorChain));
	}

	public <E extends IEntity> IEntityIterator<E> composeIterator(IEntityIterator<E> iterator, IEntityIterator<? extends IEntity>... nestedIterators) {
		return instrument(factory.composeIterator(iterator, nestedIterators));
	}

	public <E extends IEntity> IEntityIterator<E> filterByIndexIterator(IEntityIterator<E> iterator, int index) {
		return instrument(factory.filterByIndexIterator(iterator, index));
	}

	public <E extends IEntity> IEntityIterator<E> filterByIndexRangeIterator(IEntityIterator<E> iterator, int startIndex, int endIndex) {
		return instrument(factory.filterByIndexRangeIterator(iterator, startIndex, endIndex));
	}

	public <E extends IEntity> IEntityIterator<E> filterByIndexRangeIterator() {
		return instrument(factory.filterByIndexRangeIterator());
	}

	public <E extends IEntity> DistinctScope<E> distinctScope() {
		return factory .distinctScope();
	}

	public <E extends IEntity> DistinctScope<E> distinctScope(IEntityComparator<IEntity> comparator) {
		return factory .distinctScope(comparator);
	}

	public <E extends IEntity> IEntityIterator<E> sort(IEntityIterator<E> iterator) {
		return instrument(factory.sort(iterator));
	}

	public <E extends IEntity> IEntityIterator<E> sort(IEntityIterator<E> iterator, IEntityComparator<E> comparator) {
		return instrument(factory.sort(iterator, comparator));
	}

	@SuppressWarnings("unchecked")
	public IEntityIterator<IEntity> unionAllIterator(IEntityIterator<? extends IEntity>... iteratorChain) {
		return instrument(factory.unionAllIterator(iteratorChain));
	}

	@SuppressWarnings("unchecked")
	public IEntityIterator<IEntity> unionIterator(IEntityIterator<? extends IEntity>... iteratorChain) {
		return instrument(factory.unionIterator(iteratorChain));
	}

	@SuppressWarnings("unchecked")
	public IEntityIterator<IEntity> intersectIterator(IEntityIterator<? extends IEntity>... iteratorChain) {
		return instrument(factory.intersectIterator(iteratorChain));
	}

	@SuppressWarnings("unchecked")
	public IEntityIterator<IEntity> exceptIterator(IEntityIterator<? extends IEntity>... iteratorChain) {
		return instrument(factory.exceptIterator(iteratorChain));
	}

	public <E extends IEntity> IEntityIterator<E> ancestorScannerIterator() {
		return instrument(factory.ancestorScannerIterator());
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
		return instrument(factory.atStageIterator(stage));
	}

	public IEntityIterator<IEntity> atHostStageIterator() {
		return instrument(factory.atHostStageIterator());
	}

	public IEntityIterator<IEntity> atTemplateStageIterator() {
		return instrument(factory.atTemplateStageIterator());
	}

	public IEntityIterator<IEntity> hasKindIterator(EntityKinds kind) {
		return instrument(factory.hasKindIterator(kind));
	}

	public IEntityIterator<IEntity> hasCompositeKindIterator(CompositeKinds kind) {
		return instrument(factory.hasCompositeKindIterator(kind));
	}

	public IEntityIterator<IEntity> hasDataKindIterator(DataKinds kind) {
		return instrument(factory.hasDataKindIterator(kind));
	}

	public IEntityIterator<IEntity> isFragmentIterator() {
		return instrument(factory.isFragmentIterator());
	}

	public IEntityIterator<IEntity> isVariableIterator() {
		return instrument(factory.isVariableIterator());
	}

	public IEntityIterator<IEntity> isResolverIterator() {
		return instrument(factory.isResolverIterator());
	}

	public IEntityIterator<IEntity> isImplIterator() {
		return instrument(factory.isImplIterator());
	}

	public IEntityIterator<?> andIterator(IEntityIterator<?>... argsIterators) {
		return instrument(factory.andIterator(argsIterators));
	}

	public IEntityIterator<?> orIterator(IEntityIterator<?>... argsIterators) {
		return instrument(factory.orIterator(argsIterators));
	}

	public IEntityIterator<?> notIterator(IEntityIterator<?> argIterator) {
		return instrument(factory.notIterator(argIterator));
	}

	public IEntityIterator<IEntity> oneIterator(IEntityIterator<IEntity> fromClause,
			IEntityIterator<IEntity> satisfiesClause) {
		return instrument(factory.oneIterator(fromClause, satisfiesClause));
	}

	public IEntityIterator<IEntity> someIterator(IEntityIterator<IEntity> fromClause) {
		return instrument(factory.someIterator(fromClause));
	}

	public IEntityIterator<IEntity> someIterator(IEntityIterator<IEntity> fromClause,
			IEntityIterator<IEntity> satisfiesClause) {
		return instrument(factory.someIterator(fromClause, satisfiesClause));
	}

	public IEntityIterator<IEntity> everyIterator(IEntityIterator<IEntity> fromClause,
			IEntityIterator<IEntity> satisfiesClause) {
		return instrument(factory.everyIterator(fromClause, satisfiesClause));
	}

	public IEntityIterator<IEntity> isLanguageIterator(String languageURI) {
		return instrument(factory.isLanguageIterator(languageURI));
	}

	public IEntityIterator<IEntity> hasTypeIterator(String typeUri) {
		return instrument(factory.hasTypeIterator(typeUri));
	}

	public IEntityIterator<IEntity> isLanguageSubtypeOfIterator(String typeUri) {
		return instrument(factory.isLanguageSubtypeOfIterator(typeUri));
	}

	public IEntityIterator<IEntity> isLanguageSupertypeOfIterator(String typeUri) {
		return instrument(factory.isLanguageSupertypeOfIterator(typeUri));
	}

	public IEntityIterator<IEntity> isExtendedLanguageSubtypeOfIterator(String typeUri) {
		return instrument(factory.isExtendedLanguageSubtypeOfIterator(typeUri));
	}

	public IEntityIterator<IEntity> isExtendedLanguageSupertypeOfIterator(String typeUri) {
		return instrument(factory.isExtendedLanguageSupertypeOfIterator(typeUri));
	}

	public IEntityIterator<IEntity> atTypeIterator(String edUri) {
		return instrument(factory.atTypeIterator(edUri));
	}

	public IEntityIterator<IEntity> atFeatureIterator(String fdUri) {
		return instrument(factory.atFeatureIterator(fdUri));
	}

	public IEntityIterator<IEntity> atIndexIterator(int index) {
		return instrument(factory.atIndexIterator(index));
	}

	public IEntityIterator<IEntity> asVariableIterator(String name) {
		return instrument(factory.asVariableIterator(name));
	}

	public IEntityIterator<IEntity> atStageVariableIterator(String name) {
		return instrument(factory.atStageVariableIterator(name));
	}

	public IEntityIterator<IEntity> languageVariableIterator(String name) {
		return instrument(factory.languageVariableIterator(name));
	}

	public IEntityIterator<IEntity> typeVariableIterator(String name) {
		return instrument(factory.typeVariableIterator(name));
	}

	public IEntityIterator<IEntity> languageSubtypeOfVariableIterator(String name) {
		return instrument(factory.languageSubtypeOfVariableIterator(name));
	}

	public IEntityIterator<IEntity> languageSupertypeOfVariableIterator(String name) {
		return instrument(factory.languageSupertypeOfVariableIterator(name));
	}

	public IEntityIterator<IEntity> extendedLanguageSubtypeOfVariableIterator(String name) {
		return instrument(factory.extendedLanguageSubtypeOfVariableIterator(name));
	}

	public IEntityIterator<IEntity> extendedLanguageSupertypeOfVariableIterator(String name) {
		return instrument(factory.extendedLanguageSupertypeOfVariableIterator(name));
	}

	public IEntityIterator<IEntity> iterationIndexVariableIterator(IEntityIterator<?> indexIterator, String name) {
		return instrument(factory.iterationIndexVariableIterator(indexIterator, name));
	}

	public IEntityIterator<IEntity> iterationIndexIterator(IEntityIterator<?> indexIterator, int index) {
		return instrument(factory.iterationIndexIterator(indexIterator, index));
	}

	public IEntityIterator<IEntity> iterationIndexRangeIterator(IEntityIterator<?> indexIterator, int startIndex, int endIndex) {
		return instrument(factory.iterationIndexRangeIterator(indexIterator, startIndex, endIndex));
	}

	public IEntityIterator<IEntity> pointwiseEqualsIterator(IEntityIterator<IEntity> leftOperand,
			IEntityIterator<IEntity> rightOperand) {
		return instrument(factory.pointwiseEqualsIterator(leftOperand, rightOperand));
	}

	public <E extends IEntity> IEntityIterator<E> scopeIterator(IEntityIterator<E> scopeIterator,
			String environmentName, Set<String> localNames, boolean withFreshNames) {
		return instrument(factory.scopeIterator(scopeIterator, environmentName, localNames, withFreshNames));
	}

	public IEntityIterator<?> tupleFactoryIterator(IEntityIterator<?>... tupleIterators) {
		return instrument(factory.tupleFactoryIterator(tupleIterators));
	}

	public <E extends IEntity> IEntityIterator<E> selectIterator(IEntityIterator<E> selectIterator,
			IEntityIterator<? extends IEntity> fromIterator, IEntityIterator<? extends IEntity> whereIterator) {
		return instrument(factory.selectIterator(selectIterator, fromIterator, whereIterator));
	}

	@SuppressWarnings("unchecked")
	public IEntityIterator<IEntity> cartesianProductIterator(IEntityIterator<? extends IEntity>... iterators) {
		return instrument(factory.cartesianProductIterator(iterators));
	}

	@SuppressWarnings("unchecked")
	public IEntityIterator<IEntity> pointwiseProductIterator(IEntityIterator<? extends IEntity>... iterators) {
		return instrument(factory.pointwiseProductIterator(iterators));
	}

	public <E extends IEntity> IEntityIterator<E> cartesianUpdateIterator(IEntityIterator<? extends E> valuesIterator, IEntityIterator<E> toIterator) {
		return instrument(factory.cartesianUpdateIterator(valuesIterator, toIterator));
	}

	public <E extends IEntity> IEntityIterator<E> pointwiseUpdateIterator(IEntityIterator<E> valuesIterator,IEntityIterator<? super E> toIterator) {
		return instrument(factory.pointwiseUpdateIterator(valuesIterator, toIterator));
	}

	public <E extends IEntity> IEntityIterator<E> cartesianInsertIterator(IEntityIterator<? extends E> valuesIterator, IEntityIterator<E> toIterator, Placement placement) {
		return instrument(factory.cartesianInsertIterator(valuesIterator, toIterator, placement));
	}

	public <E extends IEntity> IEntityIterator<E> pointwiseInsertIterator(IEntityIterator<E> valuesIterator,IEntityIterator<? super E> toIterator, Placement placement) {
		return instrument(factory.pointwiseInsertIterator(valuesIterator, toIterator, placement));
	}

	public <E extends IEntity> IEntityIterator<E> deleteIterator(IEntityIterator<E> valuesIterator) {
		return instrument(factory.deleteIterator(valuesIterator));
	}

	@SuppressWarnings("unchecked")
	public <E extends IEntity> IEntityIterator<E> callIterator(String name, IEntityIterator<? extends E>... argsIterators) {
		return instrument(factory.callIterator(name, argsIterators));
	}

	public IEntityIterator<?> nestedVariableIterator() {
		return instrument(factory.nestedVariableIterator());
	}

	public IEntityIterator<?> nestedFragmentIterator(Map<IEntity, IEntityIterator<?>> fragmentIteratorMap) {
		return instrument(factory.nestedFragmentIterator(fragmentIteratorMap));
	}

	public IEntityIterator<?> cloneReplacingIterator(IEntityIterator<?> childMappingIterator) {
		return instrument(factory.cloneReplacingIterator(childMappingIterator));
	}

	public IEntityIterator<?> cloneReplacingIterator(IEntityIterator<?> childMappingIterator,
			Set<String> shallowUriSet) {
		return instrument(factory.cloneReplacingIterator(childMappingIterator, shallowUriSet));
	}
}
