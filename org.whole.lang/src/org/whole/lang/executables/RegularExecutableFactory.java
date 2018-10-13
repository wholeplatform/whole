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

import java.util.Set;

import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.commons.parsers.CommonsDataTypePersistenceParser;
import org.whole.lang.comparators.IEntityComparator;
import org.whole.lang.comparators.ObjectIdentityComparator;
import org.whole.lang.evaluators.AbstractNestedSupplierEvaluator;
import org.whole.lang.evaluators.AbstractPureConditionalSupplierEvaluator;
import org.whole.lang.evaluators.AbstractTypeRelationEvaluator;
import org.whole.lang.evaluators.AbstractVariableTestOrBindEvaluator;
import org.whole.lang.evaluators.AdjacentEvaluator;
import org.whole.lang.evaluators.AncestorEvaluator;
import org.whole.lang.evaluators.AncestorOrSelfReverseEvaluator;
import org.whole.lang.evaluators.AncestorReverseEvaluator;
import org.whole.lang.evaluators.ChildEvaluator;
import org.whole.lang.evaluators.ChildOrAdjacentEvaluator;
import org.whole.lang.evaluators.ChildRangeEvaluator;
import org.whole.lang.evaluators.ChooseByOrderEvaluator;
import org.whole.lang.evaluators.CloneReplacingEvaluator;
import org.whole.lang.evaluators.CollectionEvaluator;
import org.whole.lang.evaluators.ComposeEvaluator;
import org.whole.lang.evaluators.ConstantChildEvaluator;
import org.whole.lang.evaluators.ConstantComposeEvaluator;
import org.whole.lang.evaluators.ConstantEvaluator;
import org.whole.lang.evaluators.DescendantEvaluator;
import org.whole.lang.evaluators.DescendantOrReachableEvaluator;
import org.whole.lang.evaluators.DescendantReverseEvaluator;
import org.whole.lang.evaluators.FeatureByIndexEvaluator;
import org.whole.lang.evaluators.FeatureByNameEvaluator;
import org.whole.lang.evaluators.FilterByDistinctEvaluator;
import org.whole.lang.evaluators.FollowingEvaluator;
import org.whole.lang.evaluators.FollowingSiblingEvaluator;
import org.whole.lang.evaluators.ForEvaluator;
import org.whole.lang.evaluators.IfEvaluator;
import org.whole.lang.evaluators.InverseAdjacentEvaluator;
import org.whole.lang.evaluators.InverseReachableEvaluator;
import org.whole.lang.evaluators.LocalScopeEvaluator;
import org.whole.lang.evaluators.LocalVariableEvaluator;
import org.whole.lang.evaluators.MultiValuedRunnableEvaluator;
import org.whole.lang.evaluators.OuterLocalVariableEvaluator;
import org.whole.lang.evaluators.OuterVariableEvaluator;
import org.whole.lang.evaluators.PrecedingEvaluator;
import org.whole.lang.evaluators.PrecedingSiblingEvaluator;
import org.whole.lang.evaluators.ReachableEvaluator;
import org.whole.lang.evaluators.SingleValuedRunnableEvaluator;
import org.whole.lang.evaluators.SingleValuedRunnableSupplierEvaluator;
import org.whole.lang.evaluators.SortEvaluator;
import org.whole.lang.evaluators.VariableEvaluator;
import org.whole.lang.iterators.AbstractIteratorBasedExecutableFactory;
import org.whole.lang.iterators.DistinctScope;
import org.whole.lang.iterators.MatcherIterator;
import org.whole.lang.iterators.ScannerIterator;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.CompositeKinds;
import org.whole.lang.reflect.DataKinds;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reflect.EntityKinds;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.util.BindingUtils;
import org.whole.lang.util.EntityUtils;
import org.whole.lang.util.IDataTypeWrapper;
import org.whole.lang.util.IRunnable;

/**
 * @author Riccardo Solmi
 */
public class RegularExecutableFactory extends AbstractIteratorBasedExecutableFactory {
	public <E extends IEntity> IExecutable<E> createEmpty() {
		return new EmptyExecutable<E>();
	}

	public <E extends IEntity> IExecutable<E> createFailure(Throwable failure) {
		return new FailureExecutable<E>(failure);
	}

	public <E extends IEntity> IExecutable<E> createVariable(String varName) {
		return BindingUtils.hasEnvironmentPart(varName) ? new VariableEvaluator<E>(varName) : new LocalVariableEvaluator<E>(varName);
	}
	public <E extends IEntity> IExecutable<E> createOuterVariable(String varName) {
		return BindingUtils.hasEnvironmentPart(varName) ? new OuterVariableEvaluator<E>(varName) : new OuterLocalVariableEvaluator<E>(varName);
	}

	public <E extends IEntity> IExecutable<E> createConstant(E constant, boolean useClone) {
		return new ConstantEvaluator<E>(constant, useClone);
	}
	public <E extends IEntity> IExecutable<E> createConstantSubstitute(E constant, boolean useClone) {
		return new ConstantEvaluator<E>(constant, useClone) {
			@Override
			public E evaluateNext() {
				E pattern = super.evaluateNext();
				if (pattern != null)
					Matcher.substitute(pattern, getBindings(), true);
				return pattern;
			}
		};
	}
	public <E extends IEntity> IExecutable<E> createConstantChild(IEntity constant) {
		return new ConstantChildEvaluator<E>(true, constant);
	}
	public <E extends IEntity> IExecutable<E> createConstantCompose(IEntity constant, IExecutable<E> executable) {
		return (IExecutable<E>) new ConstantComposeEvaluator(constant, executable);
	}

	public <E extends IEntity> IExecutable<E> createEntityCollection(Iterable<E> entityCollectionIterable) {
		return createCollection(entityCollectionIterable, IDataTypeWrapper.identity);
	}
	public <E extends IEntity> IExecutable<E> createJavaCollection(Iterable<?> collectionIterable) {
		return createCollection(collectionIterable, IDataTypeWrapper.envSpecificValue);
	}
	public <E extends IEntity> IExecutable<E> createCollection(Iterable<?> collectionIterable, IDataTypeWrapper elementWrapper) {
		return new CollectionEvaluator<E>(elementWrapper, collectionIterable);
	}

	public <E extends IEntity> IExecutable<E> createSingleValuedRunnable(IRunnable runnable) {
		return new SingleValuedRunnableSupplierEvaluator<E>(runnable);
	}
	public <E extends IEntity> IExecutable<E> createSingleValuedRunnable(IRunnable runnable, IExecutable<?>... argsExecutables) {
		return new SingleValuedRunnableEvaluator<E>(runnable, argsExecutables);
	}
	public <E extends IEntity> IExecutable<E> createSingleValuedRunnable(IRunnable runnable, int[] optionalArgsIndexes, IExecutable<?>... argsExecutables) {
		return new SingleValuedRunnableEvaluator<E>(runnable, optionalArgsIndexes, argsExecutables);
	}
	public <E extends IEntity> IExecutable<E> createMultiValuedRunnable(IRunnable runnable, IExecutable<?>... argsExecutables) {
		return new MultiValuedRunnableEvaluator<E>(runnable, argsExecutables);
	}
	public <E extends IEntity> IExecutable<E> createMultiValuedRunnable(IRunnable runnable, int[] optionalArgsIndexes, IExecutable<?>... argsExecutables) {
		return new MultiValuedRunnableEvaluator<E>(runnable, optionalArgsIndexes, argsExecutables);
	}

	public <E extends IEntity> IExecutable<E> createSelf() {
		return new AbstractPureConditionalSupplierEvaluator<E>() {
			@SuppressWarnings("unchecked")
			public E get() {
				return (E) selfEntity;
			}

		    @Override
			public void toString(StringBuilder sb) {
				sb.append("self()");
		    }
		};
	}

	public <E extends IEntity> IExecutable<E> createRepeatedSelf() {
		return new AbstractPureConditionalSupplierEvaluator<E>() {
			@SuppressWarnings("unchecked")
			public E get() {
				isEvaluated = false;
				return (E) selfEntity;
			}

		    @Override
			public void toString(StringBuilder sb) {
				sb.append("repeatedSelf()");
		    }
		};
	}

	public IExecutable<IEntity> createRoot() {
		return new AbstractPureConditionalSupplierEvaluator<IEntity>() {
			public IEntity get() {
				return EntityUtils.getCompoundRoot(selfEntity);
			}

		    @Override
			public void toString(StringBuilder sb) {
				sb.append("root()");
		    }
		};
	}
	public IExecutable<IEntity> createFragmentRoot() {
		return new AbstractPureConditionalSupplierEvaluator<IEntity>() {
			public IEntity get() {
				return EntityUtils.getFragmentRoot(selfEntity);
			}

		    @Override
			public void toString(StringBuilder sb) {
				sb.append("fragment-root()");
		    }
		};
	}

	public <E extends IEntity> IExecutable<E> createParent() {
		return new AbstractPureConditionalSupplierEvaluator<E>() {
		    @Override
		    public boolean hasNext() {
		    	return super.hasNext() && EntityUtils.hasParent(selfEntity);
		    }
			@SuppressWarnings("unchecked")
			public E get() {
				return (E) selfEntity.wGetParent();
			}

		    @Override
			public void toString(StringBuilder sb) {
				sb.append("parent()");
		    }
		};
	}

	public <E extends IEntity> IExecutable<E> createAncestor() {
		return new AncestorEvaluator<E>(false);
	}
	public <E extends IEntity> IExecutable<E> createAncestorOrSelf() {
		return new AncestorEvaluator<E>(true);
	}
	public IExecutable<IEntity> createAncestorReverse() {
		return new AncestorReverseEvaluator();
	}
	public IExecutable<IEntity> createAncestorOrSelfReverse() {
		return new AncestorOrSelfReverseEvaluator();
	}

	public IExecutable<IEntity> createInverseAdjacent() {
		return new InverseAdjacentEvaluator();
	}
	public IExecutable<IEntity> createInverseReachable(boolean includeSelf) {
		DistinctScope<IEntity> distinctScope = createDistinctScope(ObjectIdentityComparator.instance);
		return distinctScope.withExecutable(createInverseReachable(includeSelf, distinctScope));
	}
	public IExecutable<IEntity> createInverseReachable(boolean includeSelf, DistinctScope<IEntity> distinctScope) {
		return new InverseReachableEvaluator(includeSelf, distinctScope);
	}

	public IExecutable<IEntity> createFeatureByName(String fdUri) {
		return new FeatureByNameEvaluator(fdUri);
	}
	public IExecutable<IEntity> createFeatureByName(FeatureDescriptor fd) {
		return new FeatureByNameEvaluator(fd);
	}

	public IExecutable<IEntity> createFeatureByIndex(int relativeIndex) {
		return new FeatureByIndexEvaluator(relativeIndex);
	}

	public <E extends IEntity> IExecutable<E> createChild() {
		return new ChildEvaluator<E>(true);
	}
	public <E extends IEntity> IExecutable<E> createChild(int relativeFirstIndex) {
		return new ChildEvaluator<E>(true, relativeFirstIndex);
	}
	public <E extends IEntity> IExecutable<E> createChildReverse() {
		return new ChildEvaluator<E>(false);
	}
	public <E extends IEntity> IExecutable<E> createChildReverse(int relativeFirstIndex) {
		return new ChildEvaluator<E>(false, relativeFirstIndex);
	}
	public <E extends IEntity> IExecutable<E> createChildRange(int relativeStartIndex, int relativeEndIndex) {
		return new ChildRangeEvaluator<E>(true, relativeStartIndex, relativeEndIndex);
	}

	public <E extends IEntity> IExecutable<E> createDescendant() {
		return new DescendantEvaluator<E>(false);
	}
	public <E extends IEntity> IExecutable<E> createDescendantOrSelf() {
		return new DescendantEvaluator<E>(true);
	}
	public <E extends IEntity> IExecutable<E> createDescendantReverse() {
		return new DescendantReverseEvaluator<E>(false);
	}
	public <E extends IEntity> IExecutable<E> createDescendantOrSelfReverse() {
		return new DescendantReverseEvaluator<E>(true);
	}

	public <E extends IEntity> IExecutable<E> createFollowingSibling() {
		return new FollowingSiblingEvaluator<E>(true, false);
	}
	public <E extends IEntity> IExecutable<E> createFollowingSiblingReverse() {
		return new FollowingSiblingEvaluator<E>(false, false);
	}
	public <E extends IEntity> IExecutable<E> createPrecedingSibling() {
		return new PrecedingSiblingEvaluator<E>(false, false);
	}
	public <E extends IEntity> IExecutable<E> createPrecedingSiblingReverse() {
		return new PrecedingSiblingEvaluator<E>(true, false);
	}

	public <E extends IEntity> IExecutable<E> createFollowingSiblingOrSelf() {
		return new FollowingSiblingEvaluator<E>(true, true);
	}
	public <E extends IEntity> IExecutable<E> createFollowingSiblingOrSelfReverse() {
		return new FollowingSiblingEvaluator<E>(false, true);
	}
	public <E extends IEntity> IExecutable<E> createPrecedingSiblingOrSelf() {
		return new PrecedingSiblingEvaluator<E>(false, true);
	}
	public <E extends IEntity> IExecutable<E> createPrecedingSiblingOrSelfReverse() {
		return new PrecedingSiblingEvaluator<E>(true, true);
	}

	public <E extends IEntity> IExecutable<E> createFollowing() {
		return new FollowingEvaluator<E>(false);
	}
	public <E extends IEntity> IExecutable<E> createFollowingOrSelf() {
		return new FollowingEvaluator<E>(true);
	}
	public <E extends IEntity> IExecutable<E> createPreceding() {
		return new PrecedingEvaluator<E>(false);
	}
	public <E extends IEntity> IExecutable<E> createPrecedingOrSelf() {
		return new PrecedingEvaluator<E>(true);
	}

	public <E extends IEntity> IExecutable<E> createAdjacent() {
		return new AdjacentEvaluator<E>(true);
	}
	public <E extends IEntity> IExecutable<E> createAdjacent(int relativeFirstIndex) {
		return new AdjacentEvaluator<E>(true, relativeFirstIndex);
	}
	public <E extends IEntity> IExecutable<E> createAdjacentReverse() {
		return new AdjacentEvaluator<E>(false);
	}

	public <E extends IEntity> IExecutable<E> createChildOrAdjacent() {
		return new ChildOrAdjacentEvaluator<E>(true);
	}
	public <E extends IEntity> IExecutable<E> createChildOrAdjacent(int relativeFirstIndex) {
		return new ChildOrAdjacentEvaluator<E>(true, relativeFirstIndex);
	}

	public <E extends IEntity> IExecutable<E> createReachable(boolean includeSelf) {
		DistinctScope<E> distinctScope = createDistinctScope(ObjectIdentityComparator.instance);
		return distinctScope.withExecutable(createReachable(includeSelf, distinctScope));
	}
	public <E extends IEntity> IExecutable<E> createReachable(boolean includeSelf, DistinctScope<E> distinctScope) {
		return new ReachableEvaluator<E>(includeSelf, distinctScope);
	}

	public <E extends IEntity> IExecutable<E> createDescendantOrReachable() {
		DistinctScope<E> distinctScope = createDistinctScope(ObjectIdentityComparator.instance);
		return distinctScope.withExecutable(createDescendantOrReachable(false, distinctScope));
	}
	public <E extends IEntity> IExecutable<E> createDescendantOrReachable(boolean includeSelf, DistinctScope<E> distinctScope) {
		return new DescendantOrReachableEvaluator<E>(includeSelf, distinctScope);
	}

	public <E extends IEntity> IExecutable<E> createFilter(IExecutable<E> executable, IExecutable<? extends IEntity> filterExecutable) {
		return super.createFilter(executable, filterExecutable);
		//FIXME
//		return (IExecutable<E>) new FilterEvaluator((IExecutable<IEntity>) executable, (IExecutable<IEntity>) filterExecutable);
	}

	public IExecutable<IEntity> createMatchInScope(IExecutable<IEntity> patternExecutable) {
		return new AbstractNestedSupplierEvaluator<IEntity>(patternExecutable) {
			public IEntity get() {
				IEntity pattern = getProducer(0).evaluateNext();
				return BindingManagerFactory.instance.createValue(
						pattern != null && Matcher.match(pattern, selfEntity, getBindings()));
			}

			public void toString(StringBuilder sb) {
				sb.append("matchInScope(");
				producers[0].toString(sb);//TODO startOf
				sb.append(")");
			}
		};
	}

	@SuppressWarnings("unchecked")
	public <E extends IEntity> IExecutable<E> createIf(IExecutable<? extends IEntity> conditionExecutable, IExecutable<E> doExecutable) {
		return (IExecutable<E>) new IfEvaluator((IExecutable<IEntity>) conditionExecutable, (IExecutable<IEntity>) doExecutable);
	}

	@SuppressWarnings("unchecked")
	public <E extends IEntity> IExecutable<E> createFor(IExecutable<? extends IEntity> forExecutable, IExecutable<E> doExecutable) {
		return (IExecutable<E>) new ForEvaluator((IExecutable<IEntity>) forExecutable, (IExecutable<IEntity>) doExecutable);
	}

	@SuppressWarnings("unchecked")
	public <E extends IEntity> IExecutable<E> createChoose(IExecutable<? extends E>... executableChain) {
		return (IExecutable<E>) new ChooseByOrderEvaluator((IExecutable<IEntity>[]) executableChain);
	}

	public <E extends IEntity> IExecutable<E> createSequence(IExecutable<? extends E>... executableChain) {
		return super.createSequence(executableChain);
//FIXME
//		return new SequenceEvaluator<>(executableChain);
	}

	@SuppressWarnings("unchecked")
	public <E extends IEntity> IExecutable<E> createCompose(IExecutable<E> innerExecutable, IExecutable<? extends IEntity>... outerExecutables) {
		int index = outerExecutables.length;
		IExecutable<?>[] nestedExecutables = new IExecutable<?>[outerExecutables.length+1];
		nestedExecutables[index--] = innerExecutable;
		for (IExecutable<?> e : outerExecutables) {
			nestedExecutables[index--] = e;
		}

		return (IExecutable<E>) new ComposeEvaluator(nestedExecutables);
	}

	@SuppressWarnings("unchecked")
	public <E extends IEntity> IExecutable<E> createScope(IExecutable<E> scopeExecutable, String environmentName, Set<String> names, boolean asFreshNames) {
		return (IExecutable<E>) new LocalScopeEvaluator((IExecutable<IEntity>) scopeExecutable, names, asFreshNames);
    }

	
	public <E extends IEntity> IExecutable<E> createSort(IExecutable<E> executable) {
		return new SortEvaluator<E>(executable);
	}
	public <E extends IEntity> IExecutable<E> createSort(IExecutable<E> executable, IEntityComparator<E> comparator) {
		return new SortEvaluator<E>(executable, comparator);
	}

	public <E extends IEntity> IExecutable<E> createAncestorScanner() {
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

	public IExecutable<IEntity> createAtStage(int stage) {
		return new AbstractPureConditionalSupplierEvaluator<IEntity>() {
			public IEntity get() {
				return BindingManagerFactory.instance.createValue(
						getBindings().wGetEnvironmentManager().getCurrentOperation().getStage() == stage);
			}

			public void toString(StringBuilder sb) {
				sb.append("atStage(");
				sb.append(stage);
				sb.append(")");
			}
		};
	}
	public IExecutable<IEntity> createAtHostStage() {
		return new AbstractPureConditionalSupplierEvaluator<IEntity>() {
			public IEntity get() {
				return BindingManagerFactory.instance.createValue(
						getBindings().wGetEnvironmentManager().getCurrentOperation().getStage() <= 0);
			}

			public void toString(StringBuilder sb) {
				sb.append("atHostStage()");
			}
		};
	}
	public IExecutable<IEntity> createAtTemplateStage() {
		return new AbstractPureConditionalSupplierEvaluator<IEntity>() {
			public IEntity get() {
				return BindingManagerFactory.instance.createValue(
						getBindings().wGetEnvironmentManager().getCurrentOperation().getStage() > 0);
			}

			public void toString(StringBuilder sb) {
				sb.append("atTemplateStage()");
			}
		};
	}

	public IExecutable<IEntity> createHasKind(EntityKinds kind) {
		return new AbstractPureConditionalSupplierEvaluator<IEntity>() {
			public IEntity get() {
				return BindingManagerFactory.instance.createValue(
						kind.equals(selfEntity.wGetEntityKind()));
			}

			public void toString(StringBuilder sb) {
				sb.append("hasKind(");
				sb.append(kind);
				sb.append(")");
			}
		};
	}
	public IExecutable<IEntity> createHasCompositeKind(CompositeKinds kind) {
		return new AbstractPureConditionalSupplierEvaluator<IEntity>() {
			public IEntity get() {
				return BindingManagerFactory.instance.createValue(
						kind.equals(selfEntity.wGetEntityDescriptor().getCompositeKind()));
			}

			public void toString(StringBuilder sb) {
				sb.append("hasCompositeKind(");
				sb.append(kind);
				sb.append(")");
			}
		};
	}
	public IExecutable<IEntity> createHasDataKind(DataKinds kind) {
		return new AbstractPureConditionalSupplierEvaluator<IEntity>() {
			public IEntity get() {
				return BindingManagerFactory.instance.createValue(
						kind.equals(selfEntity.wGetEntityDescriptor().getDataKind()));
			}

			public void toString(StringBuilder sb) {
				sb.append("hasDataKind(");
				sb.append(kind);
				sb.append(")");
			}
		};
	}
	public IExecutable<IEntity> createIsFragment() {
		return new AbstractPureConditionalSupplierEvaluator<IEntity>() {
			public IEntity get() {
				return BindingManagerFactory.instance.createValue(
						EntityUtils.isFragment(selfEntity));
			}

			public void toString(StringBuilder sb) {
				sb.append("isFragment()");
			}
		};
	}
	public IExecutable<IEntity> createIsVariable() {
		return new AbstractPureConditionalSupplierEvaluator<IEntity>() {
			public IEntity get() {
				return BindingManagerFactory.instance.createValue(
						EntityUtils.isVariable(selfEntity));
			}

			public void toString(StringBuilder sb) {
				sb.append("isVariable()");
			}
		};
	}
	public IExecutable<IEntity> createIsResolver() {
		return new AbstractPureConditionalSupplierEvaluator<IEntity>() {
			public IEntity get() {
				return BindingManagerFactory.instance.createValue(
						EntityUtils.isResolver(selfEntity));
			}

			public void toString(StringBuilder sb) {
				sb.append("isResolver()");
			}
		};
	}
	public IExecutable<IEntity> createIsImpl() {
		return new AbstractPureConditionalSupplierEvaluator<IEntity>() {
			public IEntity get() {
				return BindingManagerFactory.instance.createValue(
						EntityUtils.isNotResolver(selfEntity));
			}

			public void toString(StringBuilder sb) {
				sb.append("isImpl()");
			}
		};
	}

	public <E extends IEntity> DistinctScope<E> createDistinctScope() {
		return new FilterByDistinctEvaluator<E>();
	}
	public <E extends IEntity> DistinctScope<E> createDistinctScope(IEntityComparator<IEntity> comparator) {
		return new FilterByDistinctEvaluator<E>(comparator);
	}


	public IExecutable<?> createAnd(IExecutable<?>... argsExecutables) {
		return super.createAnd(argsExecutables);
		//FIXME lookaheadScope
//		return new AbstractSingleValuedRunnableEvaluator<IEntity>(argsExecutables) {
//			protected void run(IEntity selfEntity, IBindingManager bm) {
//				for (int i=0; i<argsExecutables.length; i++)
//					if (!argsExecutables[i].tryEvaluateAsBoolean(selfEntity, bm)) {
//						bm.setResult(BindingManagerFactory.instance.createValue(false));
//						return;
//					}
//
//				bm.setResult(BindingManagerFactory.instance.createValue(true));
//			}
//
//			public void toString(StringBuilder sb) {
//				sb.append("and");
//				super.toString(sb);
//			}
//		};
	}
	public IExecutable<?> createOr(IExecutable<?>... argsExecutables) {
		return new AbstractNestedSupplierEvaluator<IEntity>(argsExecutables) {
			public IEntity get() {
				for (int i=0; i<producersSize(); i++)
					if (getProducer(i).evaluateAsBooleanOrFail())
						return BindingManagerFactory.instance.createValue(true);

				return BindingManagerFactory.instance.createValue(false);
			}

			public void toString(StringBuilder sb) {
				sb.append("or");
				super.toString(sb);
			}
		};
	}
	public IExecutable<?> createNot(IExecutable<?> argExecutable) {
		return new AbstractNestedSupplierEvaluator<IEntity>(argExecutable) {
			public IEntity get() {
				return BindingManagerFactory.instance.createValue(
						!getProducer(0).evaluateAsBooleanOrFail());
			}

			public void toString(StringBuilder sb) {
				sb.append("not");
				super.toString(sb);
			}
		};
	}

	public IExecutable<IEntity> createOne(IExecutable<IEntity> fromClause, IExecutable<IEntity> satisfiesClause) {
		return super.createOne(fromClause, satisfiesClause);
		//FIXME lookaheadScope
//		return new AbstractSingleValuedRunnableEvaluator<IEntity>(fromClause, satisfiesClause) {
//			protected void run(IEntity selfEntity, IBindingManager bm) {
//				IBindingScope laScope = null;
//				
//				IEntity e = null;
//				while ((e = argsExecutables[0].evaluateNext()) != null) {
//				//for (IEntity e : argsExecutables[0]) {
//					if (!argsExecutables[1].tryEvaluateAsBoolean(e, bm))
//						continue;
//
//					if (laScope != null) {
//						bm.setResult(BindingManagerFactory.instance.createValue(false));
//						return;
//					} else {
//						laScope = BindingManagerFactory.instance.createSimpleScope();
//						laScope.wAddAll(argsExecutables[0].lookaheadScope());
//						laScope.wAddAll(argsExecutables[1].lookaheadScope());
//					}
//				}
//
//				if (laScope == null) {
//					bm.setResult(BindingManagerFactory.instance.createValue(false));
//					return;
//				}
//				
//				bm.wAddAll(laScope);
//				bm.setResult(BindingManagerFactory.instance.createValue(true));
//			}
//
//			public void toString(StringBuilder sb) {
//				sb.append("one(");
//				argsExecutables[0].toString(sb);//TODO startOf
//				sb.append(" satisfies ");
//				argsExecutables[1].toString(sb);//TODO startOf
//				sb.append(")");
//			}
//		};
	}
	public IExecutable<IEntity> createSome(IExecutable<IEntity> fromClause) {
		return new AbstractNestedSupplierEvaluator<IEntity>(fromClause) {
			public IEntity get() {
				return BindingManagerFactory.instance.createValue(
							getProducer(0).evaluateNext() != null);
			}

			public void toString(StringBuilder sb) {
				sb.append("exists(");
				producers[0].toString(sb);//TODO startOf
				sb.append(")");
			}
		};
	}
	public IExecutable<IEntity> createSome(IExecutable<IEntity> fromClause, IExecutable<IEntity> satisfiesClause) {
		return new AbstractNestedSupplierEvaluator<IEntity>(fromClause, satisfiesClause) {
			public IEntity get() {
				IEntity e = null;
				while ((e = getProducer(0).evaluateNext()) != null) {
					getProducer(1).reset(e);

					if (getProducer(1).evaluateNext().wBooleanValue())
						return BindingManagerFactory.instance.createValue(true);
				}

				return BindingManagerFactory.instance.createValue(false);
			}

			public void toString(StringBuilder sb) {
				sb.append("some(");
				producers[0].toString(sb);//TODO startOf
				sb.append(" satisfies ");
				producers[1].toString(sb);//TODO startOf
				sb.append(")");
			}
		};
	}
	public IExecutable<IEntity> createEvery(IExecutable<IEntity> fromClause, IExecutable<IEntity> satisfiesClause) {
		return new AbstractNestedSupplierEvaluator<IEntity>(fromClause, satisfiesClause) {
			public IEntity get() {
				IEntity e = null;
				while ((e = getProducer(0).evaluateNext()) != null)
					if (!getProducer(1).evaluateAsBooleanOrFail(e, getBindings()))
						return BindingManagerFactory.instance.createValue(false);

				return BindingManagerFactory.instance.createValue(true);
			}

			public void toString(StringBuilder sb) {
				sb.append("every(");
				producers[0].toString(sb);//TODO startOf
				sb.append(" satisfies ");
				producers[1].toString(sb);//TODO startOf
				sb.append(")");
			}
		};
	}

	public IExecutable<IEntity> createIsLanguage(String languageURI) {
		return new AbstractPureConditionalSupplierEvaluator<IEntity>() {
			public IEntity get() {
				return BindingManagerFactory.instance.createValue(
						languageURI.equals(selfEntity.wGetLanguageKit().getURI()));
			}

			public void toString(StringBuilder sb) {
				sb.append("isLanguage(\"");
				sb.append(languageURI);
				sb.append("\")");
			}
		};
	}

	public IExecutable<IEntity> createHasType(String typeUri) {
		return new AbstractTypeRelationEvaluator(typeUri) {
			protected boolean test(EntityDescriptor<?> typeEd, EntityDescriptor<?> selfEd) {
				return typeEd != null && selfEd.equals(typeEd);
			}
			protected String predicateName() {
				return "hasType";
			}
		};
	}
	public IExecutable<IEntity> createIsLanguageSubtypeOf(String typeUri) {
		return new AbstractTypeRelationEvaluator(typeUri) {
			protected boolean test(EntityDescriptor<?> typeEd, EntityDescriptor<?> selfEd) {
				return typeEd != null && typeEd.isLanguageSupertypeOf(selfEd);
			}
			protected String predicateName() {
				return "isLanguageSubtypeOf";
			}
		};
	}
	public IExecutable<IEntity> createIsLanguageSupertypeOf(String typeUri) {
		return new AbstractTypeRelationEvaluator(typeUri) {
			protected boolean test(EntityDescriptor<?> typeEd, EntityDescriptor<?> selfEd) {
				return typeEd != null && selfEd.isLanguageSupertypeOf(typeEd);
			}
			protected String predicateName() {
				return "isLanguageSupertypeOf";
			}
		};
	}
	public IExecutable<IEntity> createIsExtendedLanguageSubtypeOf(String typeUri) {
		return new AbstractTypeRelationEvaluator(typeUri) {
			protected boolean test(EntityDescriptor<?> typeEd, EntityDescriptor<?> selfEd) {
				return typeEd != null && typeEd.isExtendedLanguageSupertypeOf(selfEd);
			}
			protected String predicateName() {
				return "isExtendedLanguageSubtypeOf";
			}
		};
	}
	public IExecutable<IEntity> createIsExtendedLanguageSupertypeOf(String typeUri) {
		return new AbstractTypeRelationEvaluator(typeUri) {
			protected boolean test(EntityDescriptor<?> typeEd, EntityDescriptor<?> selfEd) {
				return typeEd != null && selfEd.isExtendedLanguageSupertypeOf(typeEd);
			}
			protected String predicateName() {
				return "isExtendedLanguageSupertypeOf";
			}
		};
	}
	public IExecutable<IEntity> createAtType(String edUri) {
		return new AbstractPureConditionalSupplierEvaluator<IEntity>() {
			public IEntity get() {
				EntityDescriptor<?> selfEd = selfEntity.wGetParent().wGetEntityDescriptor(selfEntity);
				EntityDescriptor<?> ed = AbstractTypeRelationEvaluator.getEntityDescriptor(edUri, selfEd, getBindings());
				return BindingManagerFactory.instance.createValue(ed != null && ed.equals(selfEd));
			}

			public void toString(StringBuilder sb) {
				sb.append("atType(\"");
				sb.append(edUri);
				sb.append("\")");
			}
		};
	}

	public IExecutable<IEntity> createAtFeature(String fdUri) {
		return new AbstractPureConditionalSupplierEvaluator<IEntity>() {
			public IEntity get() {
				FeatureDescriptor selfFd = selfEntity.wGetParent().wGetFeatureDescriptor(selfEntity);
				FeatureDescriptor fd = getFeatureDescriptor(fdUri, selfFd, getBindings());
				return BindingManagerFactory.instance.createValue(fd != null && fd.equals(selfFd));
			}

			public void toString(StringBuilder sb) {
				sb.append("atFeature(\"");
				sb.append(fdUri);
				sb.append("\")");
			}
		};
	}

	public IExecutable<IEntity> createAtIndex(int index) {
		return new AbstractPureConditionalSupplierEvaluator<IEntity>() {
			public IEntity get() {
				IEntity parent = selfEntity.wGetParent();
				int selfIndex = parent.wIndexOf(selfEntity);
				if (index < 0)
					selfIndex -= parent.wSize();
				return BindingManagerFactory.instance.createValue(selfIndex == index);
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

	public IExecutable<IEntity> createAsVariable(String name) {
		return new AbstractVariableTestOrBindEvaluator(name) {
			public boolean test(IBindingManager bm, String name) {
				if (bm.wIsSet(name))
					return Matcher.match(bm.wGet(name), selfEntity);
				else {
					bm.wDef(name, selfEntity);
					return true;
				}
			}

			public void toString(StringBuilder sb) {
				sb.append("as($");
				sb.append(name);
				sb.append(")");
			}
		};
	}
	public IExecutable<IEntity> createAtStageVariable(String name) {
		return new AbstractVariableTestOrBindEvaluator(name) {
			public boolean test(IBindingManager bm, String name) {
				int selfStage = bm.wGetEnvironmentManager().getCurrentOperation().getStage();
				if (bm.wIsSet(name)) {
					return bm.wIntValue(name) == selfStage;
				} else {
					bm.wDefValue(name, selfStage);
					return true;
				}
			}

			public void toString(StringBuilder sb) {
				sb.append("atStageAs($");
				sb.append(name);
				sb.append(")");
			}
		};
	}
	public IExecutable<IEntity> createLanguageVariable(String name) {
		return new AbstractVariableTestOrBindEvaluator(name) {
			public boolean test(IBindingManager bm, String name) {
				String languageUri = selfEntity.wGetLanguageKit().getURI();
				if (bm.wIsSet(name)) {
					return bm.wStringValue(name).equals(languageUri);
				} else {
					bm.wDefValue(name, languageUri);
					return true;
				}
			}

			public void toString(StringBuilder sb) {
				sb.append("languageAs($");
				sb.append(name);
				sb.append(")");
			}
		};
	}
	public IExecutable<IEntity> createTypeVariable(String name) {
		return new AbstractVariableTestOrBindEvaluator(name) {
			public boolean test(IBindingManager bm, String name) {
				String entityUri = selfEntity.wGetEntityDescriptor().getURI();
				if (bm.wIsSet(name)) {
					return bm.wStringValue(name).equals(entityUri);
				} else {
					bm.wDefValue(name, entityUri);
					return true;
				}
			}

			public void toString(StringBuilder sb) {
				sb.append("typeAs($");
				sb.append(name);
				sb.append(")");
			}
		};
	}
	public IExecutable<IEntity> createLanguageSubtypeOfVariable(String name) {
		return new AbstractVariableTestOrBindEvaluator(name) {
			public boolean test(IBindingManager bm, String name) {
				EntityDescriptor<?> selfEd = selfEntity.wGetEntityDescriptor();
				if (bm.wIsSet(name)) {
					EntityDescriptor<?> ed = CommonsDataTypePersistenceParser.getEntityDescriptor(bm.wStringValue(name), true, bm);
					return ed != null && ed.isLanguageSupertypeOf(selfEd);
				} else {
					bm.wDefValue(name, selfEd.getURI());
					return true;
				}
			}

			public void toString(StringBuilder sb) {
				sb.append("languageSubtypeAs($");
				sb.append(name);
				sb.append(")");
			}
		};
	}
	public IExecutable<IEntity> createLanguageSupertypeOfVariable(String name) {
		return new AbstractVariableTestOrBindEvaluator(name) {
			public boolean test(IBindingManager bm, String name) {
				EntityDescriptor<?> selfEd = selfEntity.wGetEntityDescriptor();
				if (bm.wIsSet(name)) {
					EntityDescriptor<?> ed = CommonsDataTypePersistenceParser.getEntityDescriptor(bm.wStringValue(name), true, bm);
					return ed != null && selfEd.isLanguageSupertypeOf(ed);
				} else {
					bm.wDefValue(name, selfEd.getURI());
					return true;
				}
			}

			public void toString(StringBuilder sb) {
				sb.append("languageSupertypeAs($");
				sb.append(name);
				sb.append(")");
			}
		};
	}
	public IExecutable<IEntity> createExtendedLanguageSubtypeOfVariable(String name) {
		return new AbstractVariableTestOrBindEvaluator(name) {
			public boolean test(IBindingManager bm, String name) {
				EntityDescriptor<?> selfEd = selfEntity.wGetEntityDescriptor();
				if (bm.wIsSet(name)) {
					EntityDescriptor<?> ed = CommonsDataTypePersistenceParser.getEntityDescriptor(bm.wStringValue(name), true, bm);
					return ed != null && ed.isExtendedLanguageSupertypeOf(selfEd);
				} else {
					bm.wDefValue(name, selfEd.getURI());
					return true;
				}
			}

			public void toString(StringBuilder sb) {
				sb.append("extendedLanguageSubtypeAs($");
				sb.append(name);
				sb.append(")");
			}
		};
	}
	public IExecutable<IEntity> createExtendedLanguageSupertypeOfVariable(String name) {
		return new AbstractVariableTestOrBindEvaluator(name) {
			public boolean test(IBindingManager bm, String name) {
				EntityDescriptor<?> selfEd = selfEntity.wGetEntityDescriptor();
				if (bm.wIsSet(name)) {
					EntityDescriptor<?> ed = CommonsDataTypePersistenceParser.getEntityDescriptor(bm.wStringValue(name), true, bm);
					return ed != null && selfEd.isExtendedLanguageSupertypeOf(ed);
				} else {
					bm.wDefValue(name, selfEd.getURI());
					return true;
				}
			}

			public void toString(StringBuilder sb) {
				sb.append("extendedLanguageSupertypeAs($");
				sb.append(name);
				sb.append(")");
			}
		};
	}


	public IExecutable<?> createCloneReplacing(IExecutable<?> childMappingExecutable) {
		return createCloneReplacing(childMappingExecutable, null);
	}
	public IExecutable<?> createCloneReplacing(IExecutable<?> childMappingExecutable, Set<String> shallowUriSet) {
		if (childMappingExecutable.undecoratedExecutable() instanceof EmptyExecutable) {
			return new AbstractPureConditionalSupplierEvaluator<IEntity>() {
				public IEntity get() {
					return EntityUtils.clone(selfEntity);
				}
			};
		} else
			return new CloneReplacingEvaluator(shallowUriSet, childMappingExecutable);
	}
}
