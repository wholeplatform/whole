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

import org.whole.lang.bindings.AbstractFilterScope;
import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.bindings.IBindingScope;
import org.whole.lang.commons.model.Variable;
import org.whole.lang.commons.parsers.CommonsDataTypePersistenceParser;
import org.whole.lang.commons.visitors.CommonsInterpreterVisitor;
import org.whole.lang.comparators.IEntityComparator;
import org.whole.lang.executables.IExecutable;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.ICloneContext;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.reflect.ILanguageKit;
import org.whole.lang.util.BindingUtils;
import org.whole.lang.util.EntityUtils;
import org.whole.lang.util.ResourceUtils;

/**
 * 
 * @author Riccardo Solmi
 */
public abstract class AbstractIteratorBasedExecutableFactory implements IteratorFactory {

	public static <E extends IEntity> IEntityIterator<E>[] toIterators(@SuppressWarnings("unchecked") IExecutable<E>... executables) {
		@SuppressWarnings("unchecked")
		IEntityIterator<E>[] iterators = new IEntityIterator[executables.length];
		for (int i=0; i<executables.length; i++)
			iterators[i] = executables[i].iterator();

		return iterators;
	}
	
	
	public IEntityIterator<IEntity> aspectIterator() {
		return new AspectIterator();
	}

	public <E extends IEntity> ScannerIterator<E> scannerIterator(IExecutable<E> iterator) {
		return new ScannerIterator<E>(iterator.iterator());
	}
	public <E extends IEntity> MatcherIterator<E> matcherIterator(IExecutable<E> iterator) {
		return new MatcherIterator<E>(iterator.iterator());
	}

	public <E extends IEntity> IEntityIterator<E> filterIterator(IExecutable<E> iterator, IExecutable<? extends IEntity> filterIterator) {
		return new FilterIterator<E>(iterator.iterator(), filterIterator.iterator());
	}

	public static class FilterIterator<E extends IEntity> extends MatcherIterator<E> {
		protected IEntityIterator<? extends IEntity> filterIterator;

		protected FilterIterator(IExecutable<E> iterator, IExecutable<? extends IEntity> filterIterator) {
			super(iterator.iterator());
			this.filterIterator = filterIterator.iterator();
		}

		@Override
		public IExecutable<E> clone(ICloneContext cc) {
			FilterIterator<E> iterator = (FilterIterator<E>) super.clone(cc);
			iterator.filterIterator = cc.clone(filterIterator);
			return iterator;
		}

		@Override
		protected E patternFilteredLookahead() {
			boolean found = false;
			E lookahead = null;
			while (iterator.hasNext() && !(found = filter(lookahead = iterator.lookahead()))) {
				lookaheadScope().wClear();
				iterator.next();
			}
			if (!found)
				lookahead = null;
			return lookahead;
		}

		protected boolean filter(IEntity selfEntity) {
			return filterIterator.evaluateAsBooleanOrFail(selfEntity, getBindings());
		}

	    @Override
		public void toString(StringBuilder sb) {
	    	iterator.toString(sb);
	    	sb.append("[");
	    	filterIterator.toString(sb);
	    	sb.append("]");
	    }
	}


	public <E extends IEntity> IEntityIterator<E> ifIterator(IExecutable<? extends IEntity> conditionIterator, IExecutable<E> doIterator) {
		return new IfIterator<E>(conditionIterator.iterator(), doIterator.iterator());
	}
	public <E extends IEntity> IEntityIterator<E> forIterator(IExecutable<? extends IEntity> forIterator, IExecutable<E> doIterator) {
		return new ForIterator<E>(forIterator.iterator(), doIterator.iterator());
	}

	public IEntityIterator<IEntity> functionApplicationIterator(String functionUri) {
		return new FunctionApplicationIterator(functionUri);
	}
	public IEntityIterator<IEntity> recursiveFunctionApplicationIterator() {
		return new RecursiveFunctionApplicationIterator();
	}
	public <E extends IEntity> IEntityIterator<E> templateInterpreterIterator(IEntity template) {
		return new TemplateInterpreterIterator<E>(template);
	}

	public <E extends IEntity> IEntityIterator<E> chooseIterator(IExecutable<? extends E>... iteratorChain) {
		return new ChooseByOrderIterator<E>(toIterators(iteratorChain));
	}

	public <E extends IEntity> IEntityIterator<E> chooseIterator(ILanguageKit languageKit) {
		return new ChooseByTypeIterator<E>(languageKit);
	}

	public <E extends IEntity> IEntityIterator<E> blockIterator(IExecutable<? extends E>... iteratorChain) {
		return new BlockIterator<E>(toIterators(iteratorChain));
	}

	public <E extends IEntity> IEntityIterator<E> sequenceIterator(IExecutable<? extends E>... iteratorChain) {
		return new SequenceIterator<E>(toIterators(iteratorChain));
	}

	public <E extends IEntity> IEntityIterator<E> composeIterator(IExecutable<E> iterator, IExecutable<? extends IEntity>... nestedIterators) {
		return new ComposeIterator<E>(iterator.iterator(), toIterators(nestedIterators));
	}

	public <E extends IEntity> IEntityIterator<E> filterByIndexIterator(IExecutable<E> iterator, int index) {
		return new FilterByIndexRangeIterator<E>(iterator.iterator(), index, index);
	}
	public <E extends IEntity> IEntityIterator<E> filterByIndexRangeIterator(IExecutable<E> iterator, int startIndex, int endIndex) {
		return new FilterByIndexRangeIterator<E>(iterator.iterator(), startIndex, endIndex);
	}
	public <E extends IEntity> IEntityIterator<E> filterByIndexRangeIterator() {
		return new FilterByIndexRangeIterator<E>();
	}

	public <E extends IEntity> DistinctScope<E> distinctScope() {
		return new FilterByDistinctIterator<E>();
	}
	public <E extends IEntity> DistinctScope<E> distinctScope(IEntityComparator<IEntity> comparator) {
		return new FilterByDistinctIterator<E>(comparator);
	}

	@SuppressWarnings("unchecked")
	public IEntityIterator<IEntity> unionAllIterator(IExecutable<? extends IEntity>... iteratorChain) {
		return new UnionAllIterator(toIterators(iteratorChain));
	}
	@SuppressWarnings("unchecked")
	public IEntityIterator<IEntity> unionIterator(IExecutable<? extends IEntity>... iteratorChain) {
		return new UnionIterator(toIterators(iteratorChain));
	}
	@SuppressWarnings("unchecked")
	public IEntityIterator<IEntity> intersectIterator(IExecutable<? extends IEntity>... iteratorChain) {
		return new IntersectIterator(toIterators(iteratorChain));
	}
	@SuppressWarnings("unchecked")
	public IEntityIterator<IEntity> exceptIterator(IExecutable<? extends IEntity>... iteratorChain) {
		return new ExceptIterator(toIterators(iteratorChain));
	}


	public IEntityIterator<?> andIterator(IExecutable<?>... argsIterators) {
		return new AbstractSingleValuedRunnableIterator<IEntity>(toIterators(argsIterators)) {
			protected void run(IEntity selfEntity, IBindingManager bm) {
				for (int i=0; i<argsIterators.length; i++)
					if (!argsIterators[i].evaluateAsBooleanOrFail(selfEntity, bm)) {
						bm.setResult(BindingManagerFactory.instance.createValue(false));
						return;
					}

				bm.setResult(BindingManagerFactory.instance.createValue(true));
			}

			public void toString(StringBuilder sb) {
				sb.append("and");
				super.toString(sb);
			}
		};
	}

	public IEntityIterator<IEntity> oneIterator(IExecutable<IEntity> fromClause, IExecutable<IEntity> satisfiesClause) {
		return new AbstractSingleValuedRunnableIterator<IEntity>(fromClause.iterator(), satisfiesClause.iterator()) {
			protected void run(IEntity selfEntity, IBindingManager bm) {
				IBindingScope laScope = null;
				for (IEntity e : argsIterators[0]) {
					if (!argsIterators[1].evaluateAsBooleanOrFail(e, bm))
						continue;

					if (laScope != null) {
						bm.setResult(BindingManagerFactory.instance.createValue(false));
						return;
					} else {
						laScope = BindingManagerFactory.instance.createSimpleScope();
						laScope.wAddAll(argsIterators[0].lookaheadScope());
						laScope.wAddAll(argsIterators[1].lookaheadScope());
					}
				}

				if (laScope == null) {
					bm.setResult(BindingManagerFactory.instance.createValue(false));
					return;
				}
				
				bm.wAddAll(laScope);
				bm.setResult(BindingManagerFactory.instance.createValue(true));
			}

			public void toString(StringBuilder sb) {
				sb.append("one(");
				argsIterators[0].toString(sb);//TODO startOf
				sb.append(" satisfies ");
				argsIterators[1].toString(sb);//TODO startOf
				sb.append(")");
			}
		};
	}


	protected static final FeatureDescriptor getFeatureDescriptor(String fdUri, FeatureDescriptor selfFd, IBindingManager bm) {
		return ResourceUtils.hasFragmentPart(fdUri) ?
				CommonsDataTypePersistenceParser.getFeatureDescriptor(fdUri, true, bm) : selfFd.getFeatureDescriptorEnum().valueOf(fdUri);		
	}


	public IEntityIterator<IEntity> iterationIndexVariableIterator(IExecutable<?> indexIterator, String name) {
		final boolean hasEnvironmentPart = BindingUtils.hasEnvironmentPart(name);
		final int index = name.indexOf('#');
		final String envName = hasEnvironmentPart ? name.substring(BindingUtils.ENVIRONMENT_URI_PREFIX.length(), index) : null;
		final String varName = hasEnvironmentPart ? name.substring(index+1) : name;

		return new AbstractSingleValuedRunnableIterator<IEntity>(indexIterator.iterator()) {
			@Override
			protected void resetArguments(IEntity entity) {
			}
			@Override
			protected void setProducersBindings(IBindingManager bindings) {
			}

			protected void run(IEntity selfEntity, IBindingManager bm) {
				run(selfEntity, hasEnvironmentPart ? bm.wGetEnvironmentManager().getEnvironment(envName) : bm, varName);
			};
			protected final void run(IEntity selfEntity, IBindingManager bm, String name) {
				int iterationIndex = ((FilterByIndexRangeIterator<?>) argsIterators[0].undecoratedIterator()).predicateIndex(this);
				if (bm.wIsSet(name)) {
					bm.setResult(BindingManagerFactory.instance.createValue(iterationIndex == bm.wIntValue(name)));
				} else {
					bm.wDefValue(name, iterationIndex);
					bm.setResult(BindingManagerFactory.instance.createValue(true));
				}
			}

			public void toString(StringBuilder sb) {
				sb.append("iterationAs($");
				sb.append(name);
				sb.append(")");
			}
		};
	}

	public IEntityIterator<IEntity> iterationIndexIterator(IExecutable<?> indexIterator, int index) {
		return new AbstractSingleValuedRunnableIterator<IEntity>(indexIterator.iterator()) {
			@Override
			protected void resetArguments(IEntity entity) {
			}
			@Override
			protected void setProducersBindings(IBindingManager bindings) {
			}

			protected void run(IEntity selfEntity, IBindingManager bm) {
				int iterationIndex = ((FilterByIndexRangeIterator<?>) argsIterators[0].undecoratedIterator()).predicateIndex(this);
				bm.setResult(BindingManagerFactory.instance.createValue(iterationIndex == index));
			}

			public void toString(StringBuilder sb) {
				sb.append("iteration(");
				sb.append(index);
				sb.append(")");
			}
		};
	}
	public IEntityIterator<IEntity> iterationIndexRangeIterator(IExecutable<?> indexIterator, int startIndex, int endIndex) {
		return new AbstractSingleValuedRunnableIterator<IEntity>(indexIterator.iterator()) {
			@Override
			protected void resetArguments(IEntity entity) {
			}
			@Override
			protected void setProducersBindings(IBindingManager bindings) {
			}

			protected void run(IEntity selfEntity, IBindingManager bm) {
				int iterationIndex = ((FilterByIndexRangeIterator<?>) argsIterators[0].undecoratedIterator()).predicateIndex(this);
				bm.setResult(BindingManagerFactory.instance.createValue(startIndex <= iterationIndex && iterationIndex <= endIndex));
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

	public IEntityIterator<IEntity> pointwiseEqualsIterator(IExecutable<IEntity> leftOperand, IExecutable<IEntity> rightOperand) {
		return new AbstractSingleValuedRunnableIterator<IEntity>(leftOperand.iterator(), rightOperand.iterator()) {
			protected void run(IEntity selfEntity, IBindingManager bm) {
				for (IEntity e : argsIterators[0])
					if (!argsIterators[1].hasNext() || !e.wEquals(argsIterators[1].next())) {
						bm.setResult(BindingManagerFactory.instance.createValue(false));
						return;
					}

				bm.setResult(BindingManagerFactory.instance.createValue(true));
			}

			public void toString(StringBuilder sb) {
				sb.append("pointwiseEquals(");
				argsIterators[0].toString(sb);//TODO startOf
				sb.append(", ");
				argsIterators[1].toString(sb);//TODO startOf
				sb.append(")");
			}
		};
	}

	public <E extends IEntity> IEntityIterator<E> scopeIterator(IExecutable<E> scopeIterator, String environmentName, Set<String> localNames, boolean withFreshNames) {
    	return withFreshNames ? new LocalScopeIterator<E>(scopeIterator.iterator(), localNames) :
    		new LocalScopeIterator<E>(scopeIterator.iterator(), localNames) {
    			@Override
    			protected AbstractFilterScope createScopeFilter(Set<String> localNames) {
    				return BindingManagerFactory.instance.createIncludeFilterScope(localNames);
    			}
    		};
    }

	public IEntityIterator<?> tupleFactoryIterator(IExecutable<?>... tupleIterators) {
		return new TupleFactoryIterator(toIterators(tupleIterators));
	}

	public <E extends IEntity> IEntityIterator<E> selectIterator(IExecutable<E> selectIterator, IExecutable<? extends IEntity> fromIterator, IExecutable<? extends IEntity> whereIterator) {
		return new SelectIterator<E>(selectIterator.iterator(), fromIterator.iterator(), whereIterator.iterator());
	}

	@SuppressWarnings("unchecked")
	public IEntityIterator<IEntity> cartesianProductIterator(IExecutable<? extends IEntity>... iterators) {
		return new CartesianProductIterator(toIterators(iterators));
	}

	@SuppressWarnings("unchecked")
	public IEntityIterator<IEntity> pointwiseProductIterator(IExecutable<? extends IEntity>... iterators) {
		return new PointwiseProductIterator(toIterators(iterators));
	}

	public <E extends IEntity> IEntityIterator<E> cartesianUpdateIterator(IExecutable<? extends E> valuesIterator, IExecutable<E> toIterator) {
		return new CartesianUpdateIterator<E>(valuesIterator.iterator(), toIterator.iterator());
	}

	public <E extends IEntity> IEntityIterator<E> pointwiseUpdateIterator(IExecutable<E> valuesIterator, IExecutable<? super E> toIterator) {
		return new PointwiseUpdateIterator<E>(valuesIterator.iterator(), toIterator.iterator());
	}

	public <E extends IEntity> IEntityIterator<E> cartesianInsertIterator(IExecutable<? extends E> valuesIterator, IExecutable<E> toIterator, Placement placement) {
		return new CartesianInsertIterator<E>(valuesIterator.iterator(), toIterator.iterator(), placement);
	}

	public <E extends IEntity> IEntityIterator<E> pointwiseInsertIterator(IExecutable<E> valuesIterator, IExecutable<? super E> toIterator, Placement placement) {
		return new PointwiseInsertIterator<E>(valuesIterator.iterator(), toIterator.iterator(), placement);
	}

	public <E extends IEntity> IEntityIterator<E> deleteIterator(IExecutable<E> valuesIterator) {
		return new DeleteIterator<E>(valuesIterator.iterator());
	}

	@SuppressWarnings("unchecked")
	public <E extends IEntity> IEntityIterator<E> callIterator(String name, IExecutable<? extends E>... argsIterators) {
    	return new CallIterator<E>(name, toIterators(argsIterators));
    }

	public IEntityIterator<?> nestedVariableIterator() {
		return new AbstractMultiValuedRunnableIterator<IEntity>() {
			@Override
			protected void run(IEntity selfEntity, IBindingManager bm) {
					IEntity outerSelfEntity = bm.wGet(IBindingManager.OUTER_SELF);
					bm.wDef(IBindingManager.SELF, outerSelfEntity);
					Variable variable = (Variable) selfEntity;
					String varName = variable.getVarName().getValue();
		        	IEntity value = BindingUtils.wGet(bm, varName);
					if (value != null) {
						CommonsInterpreterVisitor.setVariableValueResult(bm, variable, value);
					} else
						bm.setResult(EntityUtils.cloneIfParented(selfEntity));					
			}

			public void toString(StringBuilder sb) {
				sb.append("nestedVariable");
				super.toString(sb);
			}
		};
	}

	public IEntityIterator<?> nestedFragmentIterator(Map<IEntity, IEntityIterator<?>> fragmentIteratorMap) {
		return new AbstractMultiValuedRunnableIterator<IEntity>() {
			@Override
			protected void run(IEntity selfEntity, IBindingManager bm) {
				IEntityIterator<?> fragmentIterator = fragmentIteratorMap.getOrDefault(selfEntity, emptyIterator());
				
				//TODO clone iterator

//				IEntity outerSelfEntity = bm.wGet(OUTER_SELF_NAME);
//				bm.wDef(IBindingManager.SELF, outerSelfEntity);
//				fragmentIterator.setBindings(bm);
//				fragmentIterator.reset(outerSelfEntity);
				bm.setResultIterator(fragmentIterator);
			}
			@Override
			protected void resetResultIterator(IEntityIterator<IEntity> resultIterator, IEntity selfEntity, IBindingManager bm) {
				IEntity outerSelfEntity = bm.wGet(IBindingManager.OUTER_SELF);
				bm.wDef(IBindingManager.SELF, outerSelfEntity);
				resultIterator.setBindings(bm);
				resultIterator.reset(outerSelfEntity);
			}

			public void toString(StringBuilder sb) {
				sb.append("nestedFragment");
				super.toString(sb);
			}
		};
	}
}
