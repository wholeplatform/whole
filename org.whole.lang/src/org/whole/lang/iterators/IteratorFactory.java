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

import org.whole.lang.comparators.IEntityComparator;
import org.whole.lang.comparators.ObjectIdentityComparator;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.reflect.ILanguageKit;
import org.whole.lang.util.BindingUtils;
import org.whole.lang.util.IDataTypeWrapper;
import org.whole.lang.util.IRunnable;
import org.whole.lang.visitors.IVisitor;

/**
 * 
 * @author Riccardo Solmi
 */
public class IteratorFactory {
	public static <E extends IEntity> IEntityIterator<E> emptyIterator() {
		return EmptyIterator.<E>instance();
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
		return new ConstantChildIterator<E>(constant);
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

    public static <E extends IEntity> IEntityIterator<E> singleValuedRunnableIterator(IRunnable runnable, IEntityIterator<?>... argsIterators) {
    	return new SingleValuedRunnableIterator<E>(runnable, argsIterators);
    }
    public static <E extends IEntity> IEntityIterator<E> multiValuedRunnableIterator(IRunnable runnable, IEntityIterator<?>... argsIterators) {
    	return new MultiValuedRunnableIterator<E>(runnable, argsIterators);
    }
    
	public static IEntityIterator<IEntity> aspectIterator() {
		return new AspectIterator();
	}

    public static <E extends IEntity> IEntityIterator<E> selfIterator() {
		return new SelfIterator<E>();
	}

	public static IEntityIterator<IEntity> rootIterator() {
		return new RootIterator();
	}
	public static IEntityIterator<IEntity> fragmentRootIterator() {
		return new FragmentRootIterator();
	}

    public static IEntityIterator<IEntity> parentIterator() {
    	return new ParentIterator();
    }

    public static <E extends IEntity> IEntityIterator<E> ancestorIterator() {
    	return new AncestorIterator<E>();
    }
    @SuppressWarnings("unchecked")
	public static <E extends IEntity> IEntityIterator<E> ancestorOrSelfIterator() {
    	return sequenceIterator(selfIterator(), IteratorFactory.<E>ancestorIterator());
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

	public static IEntityIterator<IEntity> featureByIndexIterator(int index) {
		return new FeatureByIndexIterator(index);
	}

	public static <E extends IEntity> IEntityIterator<E> childIterator() {
		return new ChildIterator<E>();
    }
	public static <E extends IEntity> IEntityIterator<E> childIterator(int firstIndex) {
   		return new ChildIterator<E>(firstIndex);
    }

    public static <E extends IEntity> IEntityIterator<E> childReverseIterator() {
   		return new ChildReverseIterator<E>();
    }
	public static <E extends IEntity> IEntityIterator<E> childReverseIterator(int firstIndex) {
   		return new ChildReverseIterator<E>(firstIndex);
    }

    public static <E extends IEntity> IEntityIterator<E> descendantIterator() {
    	return new DescendantIterator<E>(false);
    }
    public static <E extends IEntity> IEntityIterator<E> descendantOrSelfIterator() {
    	return new DescendantIterator<E>(true);
    }
    public static <E extends IEntity> IEntityIterator<E> descendantOrSelfReverseIterator() {
    	return new DescendantReverseIterator<E>(true);
    }

	public static <E extends IEntity> IEntityIterator<E> followingSiblingIterator() {
   		return new FollowingSiblingIterator<E>();
    }
	public static <E extends IEntity> IEntityIterator<E> precedingSiblingIterator() {
   		return new PrecedingSiblingIterator<E>();
    }

    public static <E extends IEntity> IEntityIterator<E> followingIterator() {
    	return new FollowingIterator<E>();
    }
    public static <E extends IEntity> IEntityIterator<E> precedingIterator() {
    	return new PrecedingIterator<E>();
    }


	public static <E extends IEntity> IEntityIterator<E> adjacentIterator() {
		return new AdjacentIterator<E>();
    }
	public static <E extends IEntity> IEntityIterator<E> adjacentIterator(int firstIndex) {
   		return new AdjacentIterator<E>(firstIndex);
    }

    public static <E extends IEntity> IEntityIterator<E> reachableIterator(boolean includeSelf) {
    	DistinctScope<E> distinctScope = distinctScope(ObjectIdentityComparator.instance);
    	return distinctScope.withIterator(reachableIterator(includeSelf, distinctScope));
    }
    public static <E extends IEntity> IEntityIterator<E> reachableIterator(boolean includeSelf, DistinctScope<E> distinctScope) {
    	return new ReachableIterator<E>(includeSelf, distinctScope);
    }

	public static <E extends IEntity> IEntityIterator<E> childOrAdjacentIterator() {
		return new ChildOrAdjacentIterator<E>();
    }
	public static <E extends IEntity> IEntityIterator<E> childOrAdjacentIterator(int firstIndex) {
   		return new ChildOrAdjacentIterator<E>(firstIndex);
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
    public static <E extends IEntity> AbstractPatternFilterIterator<E> filterIterator(IEntityIterator<E> iterator, IVisitor filterPredicate) {
    	return matcherIterator(iterator).withPattern(filterPredicate);
    }
    public static <E extends IEntity> AbstractPatternFilterIterator<E> filterIterator(IEntityIterator<E> iterator, IEntity filterPattern) {
    	return matcherIterator(iterator).withPattern(filterPattern);
    }
	public static AbstractPatternFilterIterator<IEntity> patternMatcherIterator(IEntity pattern) {
		return filterIterator(selfIterator(), pattern);
	}

	public static <E extends IEntity> IfIterator<E> ifIterator(IVisitor predicate, IEntityIterator<E> doIterator) {
		return new IfIterator<E>(filterIterator(selfIterator(), predicate), doIterator);
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

    public static <E extends IEntity> ChooseByOrderIterator<E> chooseIterator(IEntityIterator<? extends E>... iteratorChain) {
    	return new ChooseByOrderIterator<E>(iteratorChain);
    }

    public static <E extends IEntity> ChooseByTypeIterator<E> chooseIterator(ILanguageKit languageKit) {
    	return new ChooseByTypeIterator<E>(languageKit);
    }

    public static <E extends IEntity> SequenceIterator<E> blockIterator(IEntityIterator<? extends E>... iteratorChain) {
    	return new BlockIterator<E>(iteratorChain);
    }

    public static <E extends IEntity> SequenceIterator<E> sequenceIterator(IEntityIterator<? extends E>... iteratorChain) {
    	return new SequenceIterator<E>(iteratorChain);
    }

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

    public static IEntityIterator<IEntity> unionAllIterator(IEntityIterator<? extends IEntity>... iteratorChain) {
    	return new UnionAllIterator(iteratorChain);
    }
    public static AbstractCollectIterator unionIterator(IEntityIterator<? extends IEntity>... iteratorChain) {
    	return new UnionIterator(iteratorChain);
    }
    public static AbstractCollectIterator intersectIterator(IEntityIterator<? extends IEntity>... iteratorChain) {
    	return new IntersectIterator(iteratorChain);
    }
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
}
