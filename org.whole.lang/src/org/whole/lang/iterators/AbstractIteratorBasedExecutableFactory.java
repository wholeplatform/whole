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
public abstract class AbstractIteratorBasedExecutableFactory implements ExecutableFactory {

	public static <E extends IEntity> IEntityIterator<E>[] toIterators(@SuppressWarnings("unchecked") IExecutable<E>... executables) {
		@SuppressWarnings("unchecked")
		IEntityIterator<E>[] iterators = new IEntityIterator[executables.length];
		for (int i=0; i<executables.length; i++)
			iterators[i] = executables[i].iterator();

		return iterators;
	}
	
	
	public IExecutable<IEntity> createAspect() {
		return new AspectIterator();
	}

	public <E extends IEntity> ScannerIterator<E> createScanner(IExecutable<E> executable) {
		return new ScannerIterator<E>(executable.iterator());
	}
	public <E extends IEntity> MatcherIterator<E> createMatcher(IExecutable<E> executable) {
		return new MatcherIterator<E>(executable.iterator());
	}

	public <E extends IEntity> IExecutable<E> createFilter(IExecutable<E> executable, IExecutable<? extends IEntity> filterExecutable) {
		return new FilterIterator<E>(executable.iterator(), filterExecutable.iterator());
	}

	public static class FilterIterator<E extends IEntity> extends MatcherIterator<E> {
		protected IExecutable<? extends IEntity> filterIterator;

		protected FilterIterator(IExecutable<E> executable, IExecutable<? extends IEntity> filterIterator) {
			super(executable.iterator());
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


	public <E extends IEntity> IExecutable<E> createIf(IExecutable<? extends IEntity> conditionExecutable, IExecutable<E> doExecutable) {
		return new IfIterator<E>(conditionExecutable.iterator(), doExecutable.iterator());
	}
	public <E extends IEntity> IExecutable<E> createFor(IExecutable<? extends IEntity> forExecutable, IExecutable<E> doExecutable) {
		return new ForIterator<E>(forExecutable.iterator(), doExecutable.iterator());
	}

	public IExecutable<IEntity> createFunctionApplication(String functionUri) {
		return new FunctionApplicationIterator(functionUri);
	}
	public IExecutable<IEntity> createRecursiveFunctionApplication() {
		return new RecursiveFunctionApplicationIterator();
	}
	public <E extends IEntity> IExecutable<E> createTemplateInterpreter(IEntity template) {
		return new TemplateInterpreterIterator<E>(template);
	}

	public <E extends IEntity> IExecutable<E> createChoose(IExecutable<? extends E>... executableChain) {
		return new ChooseByOrderIterator<E>(toIterators(executableChain));
	}

	public <E extends IEntity> IExecutable<E> createChoose(ILanguageKit languageKit) {
		return new ChooseByTypeIterator<E>(languageKit);
	}

	public <E extends IEntity> IExecutable<E> createBlock(IExecutable<? extends E>... executableChain) {
		return new BlockIterator<E>(toIterators(executableChain));
	}

	public <E extends IEntity> IExecutable<E> createSequence(IExecutable<? extends E>... executableChain) {
		return new SequenceIterator<E>(toIterators(executableChain));
	}

	public <E extends IEntity> IExecutable<E> createCompose(IExecutable<E> executable, IExecutable<? extends IEntity>... nestedExecutables) {
		return new ComposeIterator<E>(executable.iterator(), toIterators(nestedExecutables));
	}

	public <E extends IEntity> IExecutable<E> createFilterByIndex(IExecutable<E> executable, int index) {
		return new FilterByIndexRangeIterator<E>(executable.iterator(), index, index);
	}
	public <E extends IEntity> IExecutable<E> createFilterByIndexRange(IExecutable<E> executable, int startIndex, int endIndex) {
		return new FilterByIndexRangeIterator<E>(executable.iterator(), startIndex, endIndex);
	}
	public <E extends IEntity> IExecutable<E> createFilterByIndexRange() {
		return new FilterByIndexRangeIterator<E>();
	}

	public <E extends IEntity> DistinctScope<E> createDistinctScope() {
		return new FilterByDistinctIterator<E>();
	}
	public <E extends IEntity> DistinctScope<E> createDistinctScope(IEntityComparator<IEntity> comparator) {
		return new FilterByDistinctIterator<E>(comparator);
	}

	@SuppressWarnings("unchecked")
	public IExecutable<IEntity> createUnionAll(IExecutable<? extends IEntity>... executableChain) {
		return new UnionAllIterator(toIterators(executableChain));
	}
	@SuppressWarnings("unchecked")
	public IExecutable<IEntity> createUnion(IExecutable<? extends IEntity>... executableChain) {
		return new UnionIterator(toIterators(executableChain));
	}
	@SuppressWarnings("unchecked")
	public IExecutable<IEntity> createIntersect(IExecutable<? extends IEntity>... executableChain) {
		return new IntersectIterator(toIterators(executableChain));
	}
	@SuppressWarnings("unchecked")
	public IExecutable<IEntity> createExcept(IExecutable<? extends IEntity>... executableChain) {
		return new ExceptIterator(toIterators(executableChain));
	}


	public IExecutable<?> createAnd(IExecutable<?>... argsExecutables) {
		return new AbstractSingleValuedRunnableIterator<IEntity>(toIterators(argsExecutables)) {
			protected void run(IEntity selfEntity, IBindingManager bm) {
				for (int i=0; i<argsExecutables.length; i++)
					if (!argsExecutables[i].evaluateAsBooleanOrFail(selfEntity, bm)) {
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

	public IExecutable<IEntity> createOne(IExecutable<IEntity> fromClause, IExecutable<IEntity> satisfiesClause) {
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


	public IExecutable<IEntity> createIterationIndexVariable(IExecutable<?> indexExecutable, String name) {
		final boolean hasEnvironmentPart = BindingUtils.hasEnvironmentPart(name);
		final int index = name.indexOf('#');
		final String envName = hasEnvironmentPart ? name.substring(BindingUtils.ENVIRONMENT_URI_PREFIX.length(), index) : null;
		final String varName = hasEnvironmentPart ? name.substring(index+1) : name;

		return new AbstractSingleValuedRunnableIterator<IEntity>(indexExecutable.iterator()) {
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
				int iterationIndex = ((FilterByIndexRangeIterator<?>) argsIterators[0].undecoratedExecutable()).predicateIndex(this);
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

	public IExecutable<IEntity> createIterationIndex(IExecutable<?> indexExecutable, int index) {
		return new AbstractSingleValuedRunnableIterator<IEntity>(indexExecutable.iterator()) {
			@Override
			protected void resetArguments(IEntity entity) {
			}
			@Override
			protected void setProducersBindings(IBindingManager bindings) {
			}

			protected void run(IEntity selfEntity, IBindingManager bm) {
				int iterationIndex = ((FilterByIndexRangeIterator<?>) argsIterators[0].undecoratedExecutable()).predicateIndex(this);
				bm.setResult(BindingManagerFactory.instance.createValue(iterationIndex == index));
			}

			public void toString(StringBuilder sb) {
				sb.append("iteration(");
				sb.append(index);
				sb.append(")");
			}
		};
	}
	public IExecutable<IEntity> createIterationIndexRange(IExecutable<?> indexExecutable, int startIndex, int endIndex) {
		return new AbstractSingleValuedRunnableIterator<IEntity>(indexExecutable.iterator()) {
			@Override
			protected void resetArguments(IEntity entity) {
			}
			@Override
			protected void setProducersBindings(IBindingManager bindings) {
			}

			protected void run(IEntity selfEntity, IBindingManager bm) {
				int iterationIndex = ((FilterByIndexRangeIterator<?>) argsIterators[0].undecoratedExecutable()).predicateIndex(this);
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

	public IExecutable<IEntity> createPointwiseEquals(IExecutable<IEntity> leftOperand, IExecutable<IEntity> rightOperand) {
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

	public <E extends IEntity> IExecutable<E> createScope(IExecutable<E> scopeExecutable, String environmentName, Set<String> localNames, boolean withFreshNames) {
    	return withFreshNames ? new LocalScopeIterator<E>(scopeExecutable.iterator(), localNames) :
    		new LocalScopeIterator<E>(scopeExecutable.iterator(), localNames) {
    			@Override
    			protected AbstractFilterScope createScopeFilter(Set<String> localNames) {
    				return BindingManagerFactory.instance.createIncludeFilterScope(localNames);
    			}
    		};
    }

	public IExecutable<?> createTupleFactory(IExecutable<?>... tupleExecutables) {
		return new TupleFactoryIterator(toIterators(tupleExecutables));
	}

	public <E extends IEntity> IExecutable<E> createSelect(IExecutable<E> selectExecutable, IExecutable<? extends IEntity> fromExecutable, IExecutable<? extends IEntity> whereExecutable) {
		return new SelectIterator<E>(selectExecutable.iterator(), fromExecutable.iterator(), whereExecutable.iterator());
	}

	@SuppressWarnings("unchecked")
	public IExecutable<IEntity> createCartesianProduct(IExecutable<? extends IEntity>... executables) {
		return new CartesianProductIterator(toIterators(executables));
	}

	@SuppressWarnings("unchecked")
	public IExecutable<IEntity> createPointwiseProduct(IExecutable<? extends IEntity>... executables) {
		return new PointwiseProductIterator(toIterators(executables));
	}

	public <E extends IEntity> IExecutable<E> createCartesianUpdate(IExecutable<? extends E> valuesExecutable, IExecutable<E> toExecutable) {
		return new CartesianUpdateIterator<E>(valuesExecutable.iterator(), toExecutable.iterator());
	}

	public <E extends IEntity> IExecutable<E> createPointwiseUpdate(IExecutable<E> valuesExecutable, IExecutable<? super E> toExecutable) {
		return new PointwiseUpdateIterator<E>(valuesExecutable.iterator(), toExecutable.iterator());
	}

	public <E extends IEntity> IExecutable<E> createCartesianInsert(IExecutable<? extends E> valuesExecutable, IExecutable<E> toExecutable, Placement placement) {
		return new CartesianInsertIterator<E>(valuesExecutable.iterator(), toExecutable.iterator(), placement);
	}

	public <E extends IEntity> IExecutable<E> createPointwiseInsert(IExecutable<E> valuesExecutable, IExecutable<? super E> toExecutable, Placement placement) {
		return new PointwiseInsertIterator<E>(valuesExecutable.iterator(), toExecutable.iterator(), placement);
	}

	public <E extends IEntity> IExecutable<E> createDelete(IExecutable<E> valuesExecutable) {
		return new DeleteIterator<E>(valuesExecutable.iterator());
	}

	@SuppressWarnings("unchecked")
	public <E extends IEntity> IExecutable<E> createCall(String name, IExecutable<? extends E>... argsExecutables) {
    	return new CallIterator<E>(name, toIterators(argsExecutables));
    }

	public IExecutable<?> createNestedVariable() {
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

	public IExecutable<?> createNestedFragment(Map<IEntity, IExecutable<?>> fragmentExecutableMap) {
		return new AbstractMultiValuedRunnableIterator<IEntity>() {
			@Override
			protected void run(IEntity selfEntity, IBindingManager bm) {
				IExecutable<?> fragmentExecutable = fragmentExecutableMap.getOrDefault(selfEntity, createEmpty());
				
				//TODO clone iterator

//				IEntity outerSelfEntity = bm.wGet(OUTER_SELF_NAME);
//				bm.wDef(IBindingManager.SELF, outerSelfEntity);
//				fragmentExecutable.setBindings(bm);
//				fragmentExecutable.reset(outerSelfEntity);
				bm.setExecutableResult(fragmentExecutable);
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
