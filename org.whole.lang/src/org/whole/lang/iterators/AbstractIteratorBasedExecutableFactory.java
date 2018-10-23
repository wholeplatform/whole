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

import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.commons.model.Variable;
import org.whole.lang.commons.parsers.CommonsDataTypePersistenceParser;
import org.whole.lang.commons.visitors.CommonsInterpreterVisitor;
import org.whole.lang.executables.IExecutable;
import org.whole.lang.model.IEntity;
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

	public IExecutable<IEntity> createFunctionApplication(String functionUri) {
		return new FunctionApplicationIterator(functionUri);
	}
	public IExecutable<IEntity> createRecursiveFunctionApplication() {
		return new RecursiveFunctionApplicationIterator();
	}
	public <E extends IEntity> IExecutable<E> createTemplateInterpreter(IEntity template) {
		return new TemplateInterpreterIterator<E>(template);
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



	protected static final FeatureDescriptor getFeatureDescriptor(String fdUri, FeatureDescriptor selfFd, IBindingManager bm) {
		return ResourceUtils.hasFragmentPart(fdUri) ?
				CommonsDataTypePersistenceParser.getFeatureDescriptor(fdUri, true, bm) : selfFd.getFeatureDescriptorEnum().valueOf(fdUri);		
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

	public <E extends IEntity> IExecutable<E> createCartesianUpdate(IExecutable<? extends E> valuesExecutable, IExecutable<E> toExecutable) {
		return new CartesianUpdateIterator<E>(valuesExecutable.iterator(), toExecutable.iterator());
	}

	public <E extends IEntity> IExecutable<E> createCartesianInsert(IExecutable<? extends E> valuesExecutable, IExecutable<E> toExecutable, Placement placement) {
		return new CartesianInsertIterator<E>(valuesExecutable.iterator(), toExecutable.iterator(), placement);
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
