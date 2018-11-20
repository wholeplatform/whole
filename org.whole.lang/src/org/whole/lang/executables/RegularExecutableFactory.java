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

import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.bindings.IBindingScope;
import org.whole.lang.commons.model.Variable;
import org.whole.lang.commons.parsers.CommonsDataTypePersistenceParser;
import org.whole.lang.commons.visitors.CommonsInterpreterVisitor;
import org.whole.lang.comparators.IEntityComparator;
import org.whole.lang.comparators.ObjectIdentityComparator;
import org.whole.lang.evaluators.AbstractDelegatingNestedSupplierEvaluator;
import org.whole.lang.evaluators.AbstractNestedSupplierEvaluator;
import org.whole.lang.evaluators.AbstractPureConditionalSupplierEvaluator;
import org.whole.lang.evaluators.AbstractTypeRelationEvaluator;
import org.whole.lang.evaluators.AbstractVariableTestOrBindEvaluator;
import org.whole.lang.evaluators.AdjacentEvaluator;
import org.whole.lang.evaluators.AncestorEvaluator;
import org.whole.lang.evaluators.AncestorOrSelfReverseEvaluator;
import org.whole.lang.evaluators.AncestorReverseEvaluator;
import org.whole.lang.evaluators.AspectEvaluator;
import org.whole.lang.evaluators.BlockEvaluator;
import org.whole.lang.evaluators.CallEvaluator;
import org.whole.lang.evaluators.CartesianInsertEvaluator;
import org.whole.lang.evaluators.CartesianProductEvaluator;
import org.whole.lang.evaluators.CartesianUpdateEvaluator;
import org.whole.lang.evaluators.ChildEvaluator;
import org.whole.lang.evaluators.ChildOrAdjacentEvaluator;
import org.whole.lang.evaluators.ChildRangeEvaluator;
import org.whole.lang.evaluators.ChooseByOrderEvaluator;
import org.whole.lang.evaluators.ChooseByTypeEvaluator;
import org.whole.lang.evaluators.CloneReplacingEvaluator;
import org.whole.lang.evaluators.CollectionEvaluator;
import org.whole.lang.evaluators.ConstantChildEvaluator;
import org.whole.lang.evaluators.ConstantComposeEvaluator;
import org.whole.lang.evaluators.ConstantEvaluator;
import org.whole.lang.evaluators.DeleteEvaluator;
import org.whole.lang.evaluators.DescendantEvaluator;
import org.whole.lang.evaluators.DescendantOrReachableEvaluator;
import org.whole.lang.evaluators.DescendantReverseEvaluator;
import org.whole.lang.evaluators.ExceptEvaluator;
import org.whole.lang.evaluators.FeatureByIndexEvaluator;
import org.whole.lang.evaluators.FeatureByNameEvaluator;
import org.whole.lang.evaluators.FilterByDistinctEvaluator;
import org.whole.lang.evaluators.FilterByIndexRangeEvaluator;
import org.whole.lang.evaluators.FilterEvaluator;
import org.whole.lang.evaluators.FollowingEvaluator;
import org.whole.lang.evaluators.FollowingSiblingEvaluator;
import org.whole.lang.evaluators.ForEvaluator;
import org.whole.lang.evaluators.FunctionApplicationEvaluator;
import org.whole.lang.evaluators.IfEvaluator;
import org.whole.lang.evaluators.IntersectEvaluator;
import org.whole.lang.evaluators.InverseAdjacentEvaluator;
import org.whole.lang.evaluators.InverseReachableEvaluator;
import org.whole.lang.evaluators.LocalScopeEvaluator;
import org.whole.lang.evaluators.LocalVariableEvaluator;
import org.whole.lang.evaluators.MultiValuedRunnableEvaluator;
import org.whole.lang.evaluators.OuterLocalVariableEvaluator;
import org.whole.lang.evaluators.OuterVariableEvaluator;
import org.whole.lang.evaluators.PathEvaluator;
import org.whole.lang.evaluators.PointwiseInsertEvaluator;
import org.whole.lang.evaluators.PointwiseProductEvaluator;
import org.whole.lang.evaluators.PointwiseUpdateEvaluator;
import org.whole.lang.evaluators.PrecedingEvaluator;
import org.whole.lang.evaluators.PrecedingSiblingEvaluator;
import org.whole.lang.evaluators.ReachableEvaluator;
import org.whole.lang.evaluators.RecursiveFunctionApplicationEvaluator;
import org.whole.lang.evaluators.SelectEvaluator;
import org.whole.lang.evaluators.SelfEvaluator;
import org.whole.lang.evaluators.SequenceEvaluator;
import org.whole.lang.evaluators.SingleValuedRunnableEvaluator;
import org.whole.lang.evaluators.SingleValuedRunnableSupplierEvaluator;
import org.whole.lang.evaluators.SortEvaluator;
import org.whole.lang.evaluators.TemplateInterpreterEvaluator;
import org.whole.lang.evaluators.TupleFactoryEvaluator;
import org.whole.lang.evaluators.UnionAllEvaluator;
import org.whole.lang.evaluators.UnionEvaluator;
import org.whole.lang.evaluators.VariableEvaluator;
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
 * @author Riccardo Solmi
 */
public class RegularExecutableFactory implements ExecutableFactory {
	public IExecutable createEmpty() {
		return new EmptyExecutable();
	}

	public IExecutable createFailure(Throwable failure) {
		return new FailureExecutable(failure);
	}

	public IExecutable createVariable(String varName) {
		return BindingUtils.hasEnvironmentPart(varName) ? new VariableEvaluator(varName) : new LocalVariableEvaluator(varName);
	}
	public IExecutable createOuterVariable(String varName) {
		return BindingUtils.hasEnvironmentPart(varName) ? new OuterVariableEvaluator(varName) : new OuterLocalVariableEvaluator(varName);
	}

	public IExecutable createConstant(IEntity constant, boolean useClone) {
		return new ConstantEvaluator(constant, useClone);
	}
	public IExecutable createConstantSubstitute(IEntity constant, boolean useClone) {
		return new ConstantEvaluator(constant, useClone) {
			@Override
			public IEntity evaluateNext() {
				IEntity pattern = super.evaluateNext();
				if (pattern != null)
					Matcher.substitute(pattern, getBindings(), true);
				return pattern;
			}
		};
	}
	public IExecutable createConstantChild(IEntity constant) {
		return new ConstantChildEvaluator(true, constant);
	}
	public IExecutable createConstantCompose(IEntity constant, IExecutable executable) {
		return (IExecutable) new ConstantComposeEvaluator(constant, executable);
	}

	public IExecutable createEntityCollection(Iterable<? extends IEntity> entityCollectionIterable) {
		return createCollection(entityCollectionIterable, IDataTypeWrapper.identity);
	}
	public IExecutable createJavaCollection(Iterable<?> collectionIterable) {
		return createCollection(collectionIterable, IDataTypeWrapper.envSpecificValue);
	}
	public IExecutable createCollection(Iterable<?> collectionIterable, IDataTypeWrapper elementWrapper) {
		return new CollectionEvaluator(elementWrapper, collectionIterable);
	}

	public IExecutable createSingleValuedRunnable(IRunnable runnable) {
		return new SingleValuedRunnableSupplierEvaluator(runnable);
	}
	public IExecutable createSingleValuedRunnable(IRunnable runnable, IExecutable... argsExecutables) {
		return new SingleValuedRunnableEvaluator(runnable, argsExecutables);
	}
	public IExecutable createSingleValuedRunnable(IRunnable runnable, int[] optionalArgsIndexes, IExecutable... argsExecutables) {
		return new SingleValuedRunnableEvaluator(runnable, optionalArgsIndexes, argsExecutables);
	}
	public IExecutable createMultiValuedRunnable(IRunnable runnable, IExecutable... argsExecutables) {
		return new MultiValuedRunnableEvaluator(runnable, argsExecutables);
	}
	public IExecutable createMultiValuedRunnable(IRunnable runnable, int[] optionalArgsIndexes, IExecutable... argsExecutables) {
		return new MultiValuedRunnableEvaluator(runnable, optionalArgsIndexes, argsExecutables);
	}

	public IExecutable createSelf() {
		return new SelfEvaluator();
	}

	public IExecutable createRepeatedSelf() {
		return new AbstractPureConditionalSupplierEvaluator() {
			public IEntity get() {
				isEvaluated = false;
				return selfEntity;
			}

		    @Override
			public void toString(StringBuilder sb) {
				sb.append("repeatedSelf()");
		    }
		};
	}

	public IExecutable createRoot() {
		return new AbstractPureConditionalSupplierEvaluator() {
			public IEntity get() {
				return EntityUtils.getCompoundRoot(selfEntity);
			}

		    @Override
			public void toString(StringBuilder sb) {
				sb.append("root()");
		    }
		};
	}
	public IExecutable createFragmentRoot() {
		return new AbstractPureConditionalSupplierEvaluator() {
			public IEntity get() {
				return EntityUtils.getFragmentRoot(selfEntity);
			}

		    @Override
			public void toString(StringBuilder sb) {
				sb.append("fragment-root()");
		    }
		};
	}

	public IExecutable createParent() {
		return new AbstractPureConditionalSupplierEvaluator() {
		    @Override
		    public boolean hasNext() {
		    	return super.hasNext() && EntityUtils.hasParent(selfEntity);
		    }
			public IEntity get() {
				return selfEntity.wGetParent();
			}

		    @Override
			public void toString(StringBuilder sb) {
				sb.append("parent()");
		    }
		};
	}

	public IExecutable createAncestor() {
		return new AncestorEvaluator(false);
	}
	public IExecutable createAncestorOrSelf() {
		return new AncestorEvaluator(true);
	}
	public IExecutable createAncestorReverse() {
		return new AncestorReverseEvaluator();
	}
	public IExecutable createAncestorOrSelfReverse() {
		return new AncestorOrSelfReverseEvaluator();
	}

	public IExecutable createInverseAdjacent() {
		return new InverseAdjacentEvaluator();
	}
	public IExecutable createInverseReachable(boolean includeSelf) {
		DistinctScope distinctScope = createDistinctScope(ObjectIdentityComparator.instance);
		return distinctScope.withExecutable(createInverseReachable(includeSelf, distinctScope));
	}
	public IExecutable createInverseReachable(boolean includeSelf, DistinctScope distinctScope) {
		return new InverseReachableEvaluator(includeSelf, distinctScope);
	}

	public IExecutable createFeatureByName(String fdUri) {
		return new FeatureByNameEvaluator(fdUri);
	}
	public IExecutable createFeatureByName(FeatureDescriptor fd) {
		return new FeatureByNameEvaluator(fd);
	}

	public IExecutable createFeatureByIndex(int relativeIndex) {
		return new FeatureByIndexEvaluator(relativeIndex);
	}

	public IExecutable createAspect() {
		return new AspectEvaluator();
	}

	public IExecutable createChild() {
		return new ChildEvaluator(true);
	}
	public IExecutable createChild(int relativeFirstIndex) {
		return new ChildEvaluator(true, relativeFirstIndex);
	}
	public IExecutable createChildReverse() {
		return new ChildEvaluator(false);
	}
	public IExecutable createChildReverse(int relativeFirstIndex) {
		return new ChildEvaluator(false, relativeFirstIndex);
	}
	public IExecutable createChildRange(int relativeStartIndex, int relativeEndIndex) {
		return new ChildRangeEvaluator(true, relativeStartIndex, relativeEndIndex);
	}

	public IExecutable createDescendant() {
		return new DescendantEvaluator(false);
	}
	public IExecutable createDescendantOrSelf() {
		return new DescendantEvaluator(true);
	}
	public IExecutable createDescendantReverse() {
		return new DescendantReverseEvaluator(false);
	}
	public IExecutable createDescendantOrSelfReverse() {
		return new DescendantReverseEvaluator(true);
	}

	public IExecutable createFollowingSibling() {
		return new FollowingSiblingEvaluator(true, false);
	}
	public IExecutable createFollowingSiblingReverse() {
		return new FollowingSiblingEvaluator(false, false);
	}
	public IExecutable createPrecedingSibling() {
		return new PrecedingSiblingEvaluator(false, false);
	}
	public IExecutable createPrecedingSiblingReverse() {
		return new PrecedingSiblingEvaluator(true, false);
	}

	public IExecutable createFollowingSiblingOrSelf() {
		return new FollowingSiblingEvaluator(true, true);
	}
	public IExecutable createFollowingSiblingOrSelfReverse() {
		return new FollowingSiblingEvaluator(false, true);
	}
	public IExecutable createPrecedingSiblingOrSelf() {
		return new PrecedingSiblingEvaluator(false, true);
	}
	public IExecutable createPrecedingSiblingOrSelfReverse() {
		return new PrecedingSiblingEvaluator(true, true);
	}

	public IExecutable createFollowing() {
		return new FollowingEvaluator(false);
	}
	public IExecutable createFollowingOrSelf() {
		return new FollowingEvaluator(true);
	}
	public IExecutable createPreceding() {
		return new PrecedingEvaluator(false);
	}
	public IExecutable createPrecedingOrSelf() {
		return new PrecedingEvaluator(true);
	}

	public IExecutable createAdjacent() {
		return new AdjacentEvaluator(true);
	}
	public IExecutable createAdjacent(int relativeFirstIndex) {
		return new AdjacentEvaluator(true, relativeFirstIndex);
	}
	public IExecutable createAdjacentReverse() {
		return new AdjacentEvaluator(false);
	}

	public IExecutable createChildOrAdjacent() {
		return new ChildOrAdjacentEvaluator(true);
	}
	public IExecutable createChildOrAdjacent(int relativeFirstIndex) {
		return new ChildOrAdjacentEvaluator(true, relativeFirstIndex);
	}

	public IExecutable createReachable(boolean includeSelf) {
		DistinctScope distinctScope = createDistinctScope(ObjectIdentityComparator.instance);
		return distinctScope.withExecutable(createReachable(includeSelf, distinctScope));
	}
	public IExecutable createReachable(boolean includeSelf, DistinctScope distinctScope) {
		return new ReachableEvaluator(includeSelf, distinctScope);
	}

	public IExecutable createDescendantOrReachable() {
		DistinctScope distinctScope = createDistinctScope(ObjectIdentityComparator.instance);
		return distinctScope.withExecutable(createDescendantOrReachable(false, distinctScope));
	}
	public IExecutable createDescendantOrReachable(boolean includeSelf, DistinctScope distinctScope) {
		return new DescendantOrReachableEvaluator(includeSelf, distinctScope);
	}

	public IExecutable createFilter(IExecutable executable, IExecutable filterExecutable) {
		return (IExecutable) new FilterEvaluator((IExecutable) executable, (IExecutable) filterExecutable);
	}

	public IExecutable createMatchInScope(IExecutable patternExecutable) {
		return new AbstractNestedSupplierEvaluator(patternExecutable) {
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

	public IExecutable createIf(IExecutable conditionExecutable, IExecutable doExecutable) {
		return (IExecutable) new IfEvaluator((IExecutable) conditionExecutable, (IExecutable) doExecutable);
	}

	public IExecutable createFor(IExecutable forExecutable, IExecutable doExecutable) {
		return (IExecutable) new ForEvaluator((IExecutable) forExecutable, (IExecutable) doExecutable);
	}

	public IExecutable createCompose(IExecutable innerExecutable, IExecutable... outerExecutables) {
		int index = outerExecutables.length;
		IExecutable[] nestedExecutables = new IExecutable[outerExecutables.length+1];
		nestedExecutables[index--] = innerExecutable;
		for (IExecutable e : outerExecutables)
			nestedExecutables[index--] = e;

		return (IExecutable) new PathEvaluator(nestedExecutables);
	}

	public IExecutable createChoose(IExecutable... executableChain) {
		return (IExecutable) new ChooseByOrderEvaluator((IExecutable[]) executableChain);
	}
	public IExecutable createChoose(ILanguageKit languageKit) {
		return (IExecutable) new ChooseByTypeEvaluator(languageKit);
	}

	public IExecutable createSequence(IExecutable... executableChain) {
		return new SequenceEvaluator((IExecutable[]) executableChain);
	}

	public IExecutable createBlock(IExecutable... executableChain) {
		return new BlockEvaluator((IExecutable[]) executableChain);
	}

	public IExecutable createFilterByIndex(IExecutable executable, int index) {
		return new FilterByIndexRangeEvaluator(executable, index, index);
	}
	public IExecutable createFilterByIndexRange(IExecutable executable, int startIndex, int endIndex) {
		return new FilterByIndexRangeEvaluator(executable, startIndex, endIndex);
	}
	public IExecutable createFilterByIndexRange() {
		return new FilterByIndexRangeEvaluator();
	}

	public IExecutable createIterationIndexVariable(IExecutable indexExecutable, String name) {
		final boolean hasEnvironmentPart = BindingUtils.hasEnvironmentPart(name);
		final int index = name.indexOf('#');
		final String envName = hasEnvironmentPart ? name.substring(BindingUtils.ENVIRONMENT_URI_PREFIX.length(), index) : null;
		final String varName = hasEnvironmentPart ? name.substring(index+1) : name;

		return new AbstractNestedSupplierEvaluator(indexExecutable) {
			@Override
			protected void resetProducers(IEntity entity) {
			}
			@Override
			protected void setProducersBindings(IBindingManager bindings) {
			}

			public IEntity get() {
				IBindingManager bm = hasEnvironmentPart ? getBindings().wGetEnvironmentManager().getEnvironment(envName) : getBindings();
				int iterationIndex = ((FilterByIndexRangeEvaluator) getProducer(0).undecoratedExecutable()).predicateIndex(this);

				if (bm.wIsSet(varName)) {
					return BindingManagerFactory.instance.createValue(iterationIndex == bm.wIntValue(varName));
				} else {
					bm.wDefValue(varName, iterationIndex);
					return BindingManagerFactory.instance.createValue(true);
				}
			}

			public void toString(StringBuilder sb) {
				sb.append("iterationAs($");
				sb.append(name);
				sb.append(")");
			}
		};
	}
	public IExecutable createIterationIndex(IExecutable indexExecutable, int index) {
		return new AbstractNestedSupplierEvaluator(indexExecutable) {
			@Override
			protected void resetProducers(IEntity entity) {
			}
			@Override
			protected void setProducersBindings(IBindingManager bindings) {
			}

			public IEntity get() {
				int iterationIndex = ((FilterByIndexRangeEvaluator) getProducer(0).undecoratedExecutable()).predicateIndex(this);

				return BindingManagerFactory.instance.createValue(iterationIndex == index);
			}

			public void toString(StringBuilder sb) {
				sb.append("iteration(");
				sb.append(index);
				sb.append(")");
			}
		};
	}
	public IExecutable createIterationIndexRange(IExecutable indexExecutable, int startIndex, int endIndex) {
		return new AbstractNestedSupplierEvaluator(indexExecutable) {
			@Override
			protected void resetProducers(IEntity entity) {
			}
			@Override
			protected void setProducersBindings(IBindingManager bindings) {
			}

			public IEntity get() {
				int iterationIndex = ((FilterByIndexRangeEvaluator) getProducer(0).undecoratedExecutable()).predicateIndex(this);

				return BindingManagerFactory.instance.createValue(startIndex <= iterationIndex && iterationIndex <= endIndex);
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

	public IExecutable createPointwiseEquals(IExecutable leftOperand, IExecutable rightOperand) {
		return new AbstractDelegatingNestedSupplierEvaluator(leftOperand, rightOperand) {
			public IEntity get() {
				getBindings().wEnterScope(executorScope(), true);

				IEntity le, re;
				do {
					le = getProducer(0).evaluateNext();
					re = getProducer(1).evaluateNext();
				} while (le != null && re != null && le.wEquals(re));

				getBindings().wExitScope();

				boolean result = (le == null && re == null);
				if (result)
					getBindings().wAddAll(executorScope());
				else
					executorScope().wClear();

				return BindingManagerFactory.instance.createValue(result);
			}

			public void toString(StringBuilder sb) {
				sb.append("pointwiseEquals(");
				getProducer(0).toString(sb);//TODO startOf
				sb.append(", ");
				getProducer(1).toString(sb);//TODO startOf
				sb.append(")");
			}
		};
	}

	public IExecutable createScope(IExecutable scopeExecutable, String environmentName, Set<String> names, boolean asFreshNames) {
		return new LocalScopeEvaluator(scopeExecutable, names, asFreshNames);
    }

	
	public IExecutable createSort(IExecutable executable) {
		return new SortEvaluator(executable);
	}
	public IExecutable createSort(IExecutable executable, IEntityComparator<? super IEntity> comparator) {
		return new SortEvaluator(executable, comparator);
	}

	public IExecutable createAtStage(int stage) {
		return new AbstractPureConditionalSupplierEvaluator() {
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
	public IExecutable createAtHostStage() {
		return new AbstractPureConditionalSupplierEvaluator() {
			public IEntity get() {
				return BindingManagerFactory.instance.createValue(
						getBindings().wGetEnvironmentManager().getCurrentOperation().getStage() <= 0);
			}

			public void toString(StringBuilder sb) {
				sb.append("atHostStage()");
			}
		};
	}
	public IExecutable createAtTemplateStage() {
		return new AbstractPureConditionalSupplierEvaluator() {
			public IEntity get() {
				return BindingManagerFactory.instance.createValue(
						getBindings().wGetEnvironmentManager().getCurrentOperation().getStage() > 0);
			}

			public void toString(StringBuilder sb) {
				sb.append("atTemplateStage()");
			}
		};
	}

	public IExecutable createHasKind(EntityKinds kind) {
		return new AbstractPureConditionalSupplierEvaluator() {
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
	public IExecutable createHasCompositeKind(CompositeKinds kind) {
		return new AbstractPureConditionalSupplierEvaluator() {
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
	public IExecutable createHasDataKind(DataKinds kind) {
		return new AbstractPureConditionalSupplierEvaluator() {
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
	public IExecutable createIsFragment() {
		return new AbstractPureConditionalSupplierEvaluator() {
			public IEntity get() {
				return BindingManagerFactory.instance.createValue(
						EntityUtils.isFragment(selfEntity));
			}

			public void toString(StringBuilder sb) {
				sb.append("isFragment()");
			}
		};
	}
	public IExecutable createIsVariable() {
		return new AbstractPureConditionalSupplierEvaluator() {
			public IEntity get() {
				return BindingManagerFactory.instance.createValue(
						EntityUtils.isVariable(selfEntity));
			}

			public void toString(StringBuilder sb) {
				sb.append("isVariable()");
			}
		};
	}
	public IExecutable createIsResolver() {
		return new AbstractPureConditionalSupplierEvaluator() {
			public IEntity get() {
				return BindingManagerFactory.instance.createValue(
						EntityUtils.isResolver(selfEntity));
			}

			public void toString(StringBuilder sb) {
				sb.append("isResolver()");
			}
		};
	}
	public IExecutable createIsImpl() {
		return new AbstractPureConditionalSupplierEvaluator() {
			public IEntity get() {
				return BindingManagerFactory.instance.createValue(
						EntityUtils.isNotResolver(selfEntity));
			}

			public void toString(StringBuilder sb) {
				sb.append("isImpl()");
			}
		};
	}

	public DistinctScope createDistinctScope() {
		return new FilterByDistinctEvaluator();
	}
	public DistinctScope createDistinctScope(IEntityComparator<? super IEntity> comparator) {
		return new FilterByDistinctEvaluator(comparator);
	}

	public IExecutable createUnionAll(IExecutable... executables) {
		return new UnionAllEvaluator(executables);
	}
	public IExecutable createUnion(IEntityComparator<IEntity> comparator, IExecutable... executables) {
		return new UnionEvaluator(comparator, executables);
	}
	public IExecutable createIntersect(IEntityComparator<IEntity> comparator, IExecutable... executables) {
		return new IntersectEvaluator(comparator, executables);
	}
	public IExecutable createExcept(IEntityComparator<IEntity> comparator, IExecutable... executables) {
		return new ExceptEvaluator(comparator, executables);
	}


	public IExecutable createAnd(IExecutable... argsExecutables) {
		return new AbstractDelegatingNestedSupplierEvaluator(argsExecutables) {
			public IEntity get() {
				for (int i=0; i<producersSize(); i++)
					if (!scopedEvaluateAsBooleanOrFail(i)) {
						executorScope().wClear();
						return BindingManagerFactory.instance.createValue(false);
					}

				getBindings().wAddAll(executorScope());
				return BindingManagerFactory.instance.createValue(true);
			}

			public void toString(StringBuilder sb) {
				sb.append("and");
				super.toString(sb);
			}
		};
	}
	public IExecutable createOr(IExecutable... argsExecutables) {
		return new AbstractNestedSupplierEvaluator(argsExecutables) {
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
	public IExecutable createNot(IExecutable argExecutable) {
		return new AbstractNestedSupplierEvaluator(argExecutable) {
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

	public IExecutable createOne(IExecutable fromClause, IExecutable satisfiesClause) {
		return new AbstractDelegatingNestedSupplierEvaluator(fromClause, satisfiesClause) {
			@Override
			protected void initProducer(IExecutable p, int index) {
				p.setBindings(getBindings());
				if (index == 0)
					p.reset(selfEntity);
			}

			public IEntity get() {
				IBindingScope oneScope = null;
				IBindingScope fromScope = BindingManagerFactory.instance.createSimpleScope();
				IEntity fromEntity;

				while ((fromEntity = scopedEvaluateNext(0, fromScope)) != null) {
					getProducer(1).reset(fromEntity);
					if (scopedEvaluateAsBooleanOrFail(1, fromScope)) {
						if (oneScope == null) {
							oneScope = fromScope.clone();
						} else
							return BindingManagerFactory.instance.createValue(false);
					}
					fromScope.wClear();
				}

				if (oneScope == null)
					return BindingManagerFactory.instance.createValue(false);
				else {
					executorScope = oneScope;
					getBindings().wAddAll(executorScope());
					return BindingManagerFactory.instance.createValue(true);
				}
			}

			protected String toStringPrefix() {
				return "one(";
			}
			protected String toStringSeparator() {
				return " satisfies ";
			}
		};
	}
	public IExecutable createSome(IExecutable fromClause) {
		return new AbstractNestedSupplierEvaluator(fromClause) {
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
	public IExecutable createSome(IExecutable fromClause, IExecutable satisfiesClause) {
		return new AbstractDelegatingNestedSupplierEvaluator(fromClause, satisfiesClause) {
			@Override
			protected void initProducer(IExecutable p, int index) {
				p.setBindings(getBindings());
				if (index == 0)
					p.reset(selfEntity);
			}

			public IEntity get() {
				IEntity fromEntity;

				while ((fromEntity = scopedEvaluateNext(0, executorScope())) != null) {
					getProducer(1).reset(fromEntity);
					if (scopedEvaluateAsBooleanOrFail(1, executorScope())) {
						getBindings().wAddAll(executorScope());
						return BindingManagerFactory.instance.createValue(true);
					}
					executorScope().wClear();
				}

				return BindingManagerFactory.instance.createValue(false);
			}

			protected String toStringPrefix() {
				return "some(";
			}
			protected String toStringSeparator() {
				return " satisfies ";
			}
		};
	}
	public IExecutable createEvery(IExecutable fromClause, IExecutable satisfiesClause) {
		return new AbstractDelegatingNestedSupplierEvaluator(fromClause, satisfiesClause) {
			@Override
			protected void initProducer(IExecutable p, int index) {
				p.setBindings(getBindings());
				if (index == 0)
					p.reset(selfEntity);
			}

			public IEntity get() {
				IBindingScope everyScope = null;
				IBindingScope fromScope = BindingManagerFactory.instance.createSimpleScope();
				IEntity fromEntity;

				while ((fromEntity = scopedEvaluateNext(0, fromScope)) != null) {
					getProducer(1).reset(fromEntity);
					if (!scopedEvaluateAsBooleanOrFail(1, fromScope))
						return BindingManagerFactory.instance.createValue(false);
					everyScope = fromScope.clone();
					fromScope.wClear();
				}

				if (everyScope == null)
					return BindingManagerFactory.instance.createValue(false);
				else {
					executorScope = everyScope;
					getBindings().wAddAll(executorScope());
					return BindingManagerFactory.instance.createValue(true);
				}
			}

			protected String toStringPrefix() {
				return "every(";
			}
			protected String toStringSeparator() {
				return " satisfies ";
			}
		};
	}

	public IExecutable createIsLanguage(String languageURI) {
		return new AbstractPureConditionalSupplierEvaluator() {
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

	public IExecutable createHasType(String typeUri) {
		return new AbstractTypeRelationEvaluator(typeUri) {
			protected boolean test(EntityDescriptor<?> typeEd, EntityDescriptor<?> selfEd) {
				return typeEd != null && selfEd.equals(typeEd);
			}
			protected String predicateName() {
				return "hasType";
			}
		};
	}
	public IExecutable createIsLanguageSubtypeOf(String typeUri) {
		return new AbstractTypeRelationEvaluator(typeUri) {
			protected boolean test(EntityDescriptor<?> typeEd, EntityDescriptor<?> selfEd) {
				return typeEd != null && typeEd.isLanguageSupertypeOf(selfEd);
			}
			protected String predicateName() {
				return "isLanguageSubtypeOf";
			}
		};
	}
	public IExecutable createIsLanguageSupertypeOf(String typeUri) {
		return new AbstractTypeRelationEvaluator(typeUri) {
			protected boolean test(EntityDescriptor<?> typeEd, EntityDescriptor<?> selfEd) {
				return typeEd != null && selfEd.isLanguageSupertypeOf(typeEd);
			}
			protected String predicateName() {
				return "isLanguageSupertypeOf";
			}
		};
	}
	public IExecutable createIsExtendedLanguageSubtypeOf(String typeUri) {
		return new AbstractTypeRelationEvaluator(typeUri) {
			protected boolean test(EntityDescriptor<?> typeEd, EntityDescriptor<?> selfEd) {
				return typeEd != null && typeEd.isExtendedLanguageSupertypeOf(selfEd);
			}
			protected String predicateName() {
				return "isExtendedLanguageSubtypeOf";
			}
		};
	}
	public IExecutable createIsExtendedLanguageSupertypeOf(String typeUri) {
		return new AbstractTypeRelationEvaluator(typeUri) {
			protected boolean test(EntityDescriptor<?> typeEd, EntityDescriptor<?> selfEd) {
				return typeEd != null && selfEd.isExtendedLanguageSupertypeOf(typeEd);
			}
			protected String predicateName() {
				return "isExtendedLanguageSupertypeOf";
			}
		};
	}
	public IExecutable createAtType(String edUri) {
		return new AbstractPureConditionalSupplierEvaluator() {
			public IEntity get() {
				IEntity parent = selfEntity.wGetParent();
				if (EntityUtils.isNull(parent))
					return BindingManagerFactory.instance.createValue(false);
				EntityDescriptor<?> selfEd = parent.wGetEntityDescriptor(selfEntity);
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

	public IExecutable createAtFeature(String fdUri) {
		return new AbstractPureConditionalSupplierEvaluator() {
			public IEntity get() {
				IEntity parent = selfEntity.wGetParent();
				if (EntityUtils.isNull(parent))
					return BindingManagerFactory.instance.createValue(false);
				FeatureDescriptor selfFd = parent.wGetFeatureDescriptor(selfEntity);
				FeatureDescriptor fd = ResourceUtils.hasFragmentPart(fdUri) ?
						CommonsDataTypePersistenceParser.getFeatureDescriptor(fdUri, true, getBindings())
						: selfFd.getFeatureDescriptorEnum().valueOf(fdUri);
				return BindingManagerFactory.instance.createValue(fd != null && fd.equals(selfFd));
			}

			public void toString(StringBuilder sb) {
				sb.append("atFeature(\"");
				sb.append(fdUri);
				sb.append("\")");
			}
		};
	}

	public IExecutable createAtIndex(int index) {
		return new AbstractPureConditionalSupplierEvaluator() {
			public IEntity get() {
				IEntity parent = selfEntity.wGetParent();
				if (EntityUtils.isNull(parent))
					return BindingManagerFactory.instance.createValue(false);
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

	public IExecutable createAsVariable(String name) {
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
	public IExecutable createAtStageVariable(String name) {
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
	public IExecutable createLanguageVariable(String name) {
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
	public IExecutable createTypeVariable(String name) {
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
	public IExecutable createLanguageSubtypeOfVariable(String name) {
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
	public IExecutable createLanguageSupertypeOfVariable(String name) {
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
	public IExecutable createExtendedLanguageSubtypeOfVariable(String name) {
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
	public IExecutable createExtendedLanguageSupertypeOfVariable(String name) {
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

	public IExecutable createSelect(IExecutable selectExecutable, IExecutable fromExecutable, IExecutable whereExecutable) {
		return (IExecutable) new SelectEvaluator((IExecutable) selectExecutable, (IExecutable) fromExecutable, (IExecutable) whereExecutable);
	}

	public IExecutable createTupleFactory(IExecutable... executables) {
		return (IExecutable) new TupleFactoryEvaluator((IExecutable[]) executables);
	}
	public IExecutable createPointwiseProduct(IExecutable... executables) {
		return new PointwiseProductEvaluator((IExecutable[]) executables);
	}
	public IExecutable createCartesianProduct(IExecutable... executables) {
		return new CartesianProductEvaluator((IExecutable[]) executables);
	}

	public IExecutable createPointwiseUpdate(IExecutable toExecutable, IExecutable valuesExecutable) {
		return (IExecutable) new PointwiseUpdateEvaluator((IExecutable) toExecutable, (IExecutable) valuesExecutable);
	}
	public IExecutable createCartesianUpdate(IExecutable toExecutable, IExecutable valuesExecutable) {
		return (IExecutable) new CartesianUpdateEvaluator((IExecutable) toExecutable, (IExecutable) valuesExecutable);
	}

	public IExecutable createPointwiseInsert(IExecutable toExecutable, IExecutable valuesExecutable, Placement placement) {
		return (IExecutable) new PointwiseInsertEvaluator((IExecutable) toExecutable, (IExecutable) valuesExecutable, placement);
	}
	public IExecutable createCartesianInsert(IExecutable toExecutable, IExecutable valuesExecutable, Placement placement) {
		return (IExecutable) new CartesianInsertEvaluator((IExecutable) toExecutable, (IExecutable) valuesExecutable, placement);
	}

	public IExecutable createDelete(IExecutable valuesExecutable) {
		return new DeleteEvaluator(valuesExecutable);
	}

	public IExecutable createFunctionApplication(String functionUri) {
		return new FunctionApplicationEvaluator(functionUri);
	}
	public IExecutable createRecursiveFunctionApplication() {
		return new RecursiveFunctionApplicationEvaluator();
	}

	public IExecutable createCall(String name, IExecutable... argsExecutables) {
    	return (IExecutable) new CallEvaluator(name, (IExecutable[]) argsExecutables);
    }

	public IExecutable createTemplateInterpreter(IEntity template) {
		return (IExecutable) new TemplateInterpreterEvaluator(template);
	}

	public IExecutable createNestedVariable() {
		return new MultiValuedRunnableEvaluator( (selfEntity, bm, args) -> {
					IEntity outerSelfEntity = bm.wGet(IBindingManager.OUTER_SELF);
					bm.wDef(IBindingManager.SELF, outerSelfEntity);
					Variable variable = (Variable) selfEntity;
					String varName = variable.getVarName().getValue();
		        	IEntity value = BindingUtils.wGet(bm, varName);
					if (value != null) {
						CommonsInterpreterVisitor.setVariableValueResult(bm, variable, value);
					} else
						bm.setResult(EntityUtils.cloneIfParented(selfEntity));					
			}) {

			public void toString(StringBuilder sb) {
				sb.append("nestedVariable");
				super.toString(sb);
			}
		};
	}

	public IExecutable createNestedFragment(Map<IEntity, IExecutable> fragmentExecutableMap) {
		return new MultiValuedRunnableEvaluator( (selfEntity, bm, args) -> {
				IExecutable fragmentExecutable = fragmentExecutableMap.getOrDefault(selfEntity, createEmpty());
				
				//TODO clone executable

//				IEntity outerSelfEntity = bm.wGet(OUTER_SELF_NAME);
//				bm.wDef(IBindingManager.SELF, outerSelfEntity);
//				fragmentExecutable.setBindings(bm);
//				fragmentExecutable.reset(outerSelfEntity);
				bm.setExecutableResult(fragmentExecutable);
		}) {
			@Override
			protected void resetExecutableResult(IExecutable executableResult, IEntity selfEntity, IBindingManager bm) {
				IEntity outerSelfEntity = bm.wGet(IBindingManager.OUTER_SELF);
				bm.wDef(IBindingManager.SELF, outerSelfEntity);
				executableResult.setBindings(bm);
				executableResult.reset(outerSelfEntity);
			}

			public void toString(StringBuilder sb) {
				sb.append("nestedFragment");
				super.toString(sb);
			}
		};
	}

	public IExecutable createCloneReplacing(IExecutable childMappingExecutable) {
		return createCloneReplacing(childMappingExecutable, null);
	}
	public IExecutable createCloneReplacing(IExecutable childMappingExecutable, Set<String> shallowUriSet) {
		if (childMappingExecutable.undecoratedExecutable() instanceof EmptyExecutable) {
			return new AbstractPureConditionalSupplierEvaluator() {
				public IEntity get() {
					return EntityUtils.clone(selfEntity);
				}
			};
		} else
			return new CloneReplacingEvaluator(shallowUriSet, childMappingExecutable);
	}
}
