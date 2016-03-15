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
package org.whole.lang.util;

import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.bindings.ITransactionScope;
import org.whole.lang.iterators.IEntityIterator;
import org.whole.lang.iterators.IteratorFactory;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.IEntity;
import org.whole.lang.model.NullEntity;
import org.whole.lang.operations.DynamicCompilerOperation;
import org.whole.lang.operations.IOperation;
import org.whole.lang.operations.InterpreterOperation;
import org.whole.lang.visitors.IVisitor;

/**
 * @author Riccardo Solmi
 */
public class BehaviorUtils {
	public static IEntity apply(String functionUri, IEntity self) {
		return apply(functionUri, self, BindingManagerFactory.instance.createArguments());
	}
	public static IEntity apply(String functionUri, IEntity self, IBindingManager bm) {
		return evaluate(IteratorFactory.functionApplicationIterator(functionUri), self, bm);
	}

	public static IEntity applyFirstResult(String functionUri, IEntity self) {
		return applyFirstResult(functionUri, self, BindingManagerFactory.instance.createArguments());
	}
	public static IEntity applyFirstResult(String functionUri, IEntity self, IBindingManager bm) {
		return evaluateFirstResult(IteratorFactory.functionApplicationIterator(functionUri), self, bm);
	}

	public static <E extends IEntity> IEntityIterator<E> compileAndLazyEvaluate(IEntity behavior, IEntity self) {
		return compileAndLazyEvaluate(behavior, self, BindingManagerFactory.instance.createArguments());
	}
	public static <E extends IEntity> IEntityIterator<E> compileAndLazyEvaluate(IEntity behavior, IEntity self, IBindingManager bm) {
		IEntityIterator<E> iterator = DynamicCompilerOperation.compile(behavior, bm).getResultIterator();
		iterator.reset(self);
		return iterator;
	}

	public static IEntityIterator<?> lazyEvaluate(IEntity behavior, int relativeStage, IBindingManager bm) {
		InterpreterOperation.interpret(behavior, bm, relativeStage);
		return bm.getResultIterator();
	}
	public static IEntity evaluate(IEntity behavior, int relativeStage, IBindingManager bm) {
		InterpreterOperation.interpret(behavior, bm, relativeStage);
		return evaluateResult(bm);
	}
	public static final IEntity evaluate(IEntity behavior, int relativeStage, IOperation op) {
		op.stagedVisit(behavior, relativeStage);
		return evaluateResult(op.getOperationEnvironment());
	}
	public static final IEntity evaluate(IEntityIterator<?> iterator, IEntity self, IBindingManager bm) {
		bm.wDef("self", self);
		iterator.setBindings(bm);
		iterator.reset(self);
	
		IEntity result = null;
		ITransactionScope resettableScope = BindingManagerFactory.instance.createTransactionScope();
		bm.wEnterScope(resettableScope);
		try {
			while (iterator.hasNext()) {
				bm.setResult(result = iterator.next());
				resettableScope.commit();
			}
		} finally {
			resettableScope.rollback();
			bm.wExitScope();
		}
		return result;
	}

	public static final IEntity evaluateResult(IBindingManager bm) {
		if (bm.hasResultIterator()) {
			IEntityIterator<?> resultIterator = bm.getResultIterator();
			bm.setResultIterator(null);
			IEntity selfEntity = bm.wGet("self");
			if (selfEntity != null)
				resultIterator.reset(selfEntity);
	
			IEntity result = null;
			ITransactionScope resettableScope = BindingManagerFactory.instance.createTransactionScope();
			bm.wEnterScope(resettableScope);
			try {
				while (resultIterator.hasNext()) {
					bm.setResult(result = resultIterator.next());
					resettableScope.commit();
				}
			} finally {
				resettableScope.rollback();
				bm.wExitScope();
			}
			return result;
		} else
			return bm.getResult();
	}
	public static final IEntity evaluateSingletonResult(IBindingManager bm) {
		IEntity result = null;
		if (bm.hasResultIterator()) {
			IEntityIterator<?> resultIterator = bm.getResultIterator();
			bm.setResultIterator(null);
			IEntity selfEntity = bm.wGet("self");
			if (selfEntity != null)
				resultIterator.reset(selfEntity);
	
			ITransactionScope resettableScope = BindingManagerFactory.instance.createTransactionScope();
			bm.wEnterScope(resettableScope);	
			try {
				if (resultIterator.hasNext()) {
					bm.setResult(result = resultIterator.next());
					resettableScope.commit();
				}

				if (result == null || resultIterator.hasNext())
					throw new IllegalArgumentException("The result is not a singleton");
			} finally {
				resettableScope.rollback();
				bm.wExitScope();
			}
		} else {
			result = bm.getResult();
			if (result == null)
				throw new IllegalArgumentException("The result is not a singleton");
		}
		return result;
	}

	public static <E extends IEntity> E evaluateFirstResult(IEntity behavior, IEntity self) {
		return evaluateFirstResult(behavior, self, BindingManagerFactory.instance.createArguments());
	}
	public static <E extends IEntity> E evaluateFirstResult(IEntity behavior, IEntity self, IBindingManager bm) {
		IEntityIterator<E> iterator = compileAndLazyEvaluate(behavior, self, bm);
		return iterator.hasNext() ? iterator.next() : null;
	}

	public static IEntity evaluateFirstResult(IEntityIterator<?> iterator, IEntity self, IBindingManager bm) {
		bm.wDef("self", self);
		iterator.setBindings(bm);
		iterator.reset(self);

		return iterator.hasNext() ? iterator.next() : null;
	}

	//TODO ? fail on not boolean; != Queries predicate
	public static boolean evaluatePredicate(IEntity predicate, int relativeStage, IBindingManager bm) {
		IEntity selfEntity = bm.wIsSet("self") ? bm.wGet("self") : NullEntity.instance;
		IEntity result = evaluate(predicate, relativeStage, bm);
		if (result == null || !EntityUtils.isData(result))
			return false;
	
		Object resultValue = result.wGetValue();
		return IVisitor.class.isInstance(resultValue) ?
				Matcher.match((IVisitor) resultValue, selfEntity) :
					EntityUtils.safeBooleanValue(result, false);
	}
}
