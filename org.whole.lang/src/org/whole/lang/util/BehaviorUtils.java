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
import org.whole.lang.executables.ExecutableFactory;
import org.whole.lang.executables.IExecutable;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.IEntity;
import org.whole.lang.model.NullEntity;
import org.whole.lang.operations.DynamicCompilerOperation;
import org.whole.lang.operations.IOperation;
import org.whole.lang.operations.InterpreterOperation;
import org.whole.lang.resources.FunctionLibraryRegistry;
import org.whole.lang.visitors.IVisitor;

/**
 * @author Riccardo Solmi
 */
public class BehaviorUtils {
	public static IEntity getSourceFunction(IEntity sourceEntity) {
		//TODO call getDeclaration
		return EntityUtils.getCompoundRoot(sourceEntity);
	}
	public static String getSourceFunctionUri(IEntity sourceFunction) {
		return FunctionLibraryRegistry.instance().getFunctionUri(sourceFunction);
	}

	public static IEntity apply(String functionUri, IEntity self) {
		return apply(functionUri, self, BindingManagerFactory.instance.createArguments());
	}
	public static IEntity apply(String functionUri, IEntity self, IBindingManager bm) {
		return ExecutableFactory.instance(bm).createFunctionApplication(functionUri).evaluate(self, bm);
	}

	public static IEntity applyFirstResult(String functionUri, IEntity self) {
		return applyFirstResult(functionUri, self, BindingManagerFactory.instance.createArguments());
	}
	public static IEntity applyFirstResult(String functionUri, IEntity self, IBindingManager bm) {
		return ExecutableFactory.instance(bm).createFunctionApplication(functionUri).evaluateFirst(self, bm);
	}

	public static IExecutable compileAndLazyEvaluate(IEntity behavior, IEntity self) {
		return compileAndLazyEvaluate(behavior, self, BindingManagerFactory.instance.createArguments());
	}
	public static IExecutable compileAndLazyEvaluate(IEntity behavior, IEntity self, IBindingManager bm) {
		IExecutable executable = DynamicCompilerOperation.compile(behavior, bm).getExecutableResult();
		executable.setBindings(bm);
		bm.enforceSelfBinding(self);
		executable.reset(self);
		return executable;
	}

	public static IExecutable lazyEvaluateOnSelfBinding(IEntity behavior, int relativeStage, IBindingManager bm) {
		InterpreterOperation.lazyInterpretOnSelfBinding(behavior, bm, relativeStage);
		return bm.getExecutableResult();
	}
	public static IEntity evaluate(IEntity behavior, int relativeStage, IBindingManager bm) {
		InterpreterOperation.lazyInterpret(behavior, bm, relativeStage);
		return evaluateResult(bm);
	}
	public static IEntity evaluateOnSelfBinding(IEntity behavior, int relativeStage, IBindingManager bm) {
		IEntity selfEntity = bm.wGet(IBindingManager.SELF);
		
		InterpreterOperation.lazyInterpretOnSelfBinding(behavior, bm, relativeStage);

		bm.enforceSelfBinding(selfEntity);
		return evaluateResult(bm);
	}
	public static final IEntity evaluate(IEntity behavior, int relativeStage, IOperation op) {
		op.stagedVisit(behavior, relativeStage);
		return evaluateResult(op.getOperationEnvironment());
	}
	public static final IEntity evaluateResult(IBindingManager bm) {
		if (bm.isExecutableResult()) {
			IExecutable executableResult = bm.getExecutableResult();
			bm.setExecutableResult(null);
			executableResult.setBindings(bm);
			IEntity selfEntity = bm.wGet(IBindingManager.SELF);

//			assert selfEntity != null;
//			if (selfEntity == null)
//				selfEntity = BindingManagerFactory.instance.createNull();

			executableResult.reset(selfEntity);

			IEntity result = executableResult.evaluateRemaining();
			bm.setResult(result);
			return result;
		} else
			return bm.getResult();
	}
	public static final IEntity evaluateSingletonResult(IBindingManager bm) {
		if (bm.isExecutableResult()) {
			IExecutable executableResult = bm.getExecutableResult();
			bm.setExecutableResult(null);
			IEntity selfEntity = bm.wGet(IBindingManager.SELF);

//			assert selfEntity != null;
//			if (selfEntity == null)
//				selfEntity = BindingManagerFactory.instance.createNull();

			executableResult.reset(selfEntity);
	
			IEntity result = executableResult.evaluateSingleton();
			bm.setResult(result);
			return result;
		} else {
			IEntity result = bm.getResult();
			if (result == null)
				throw new IllegalArgumentException("The result is not a singleton");
			return result;
		}
	}

	public static <E extends IEntity> E evaluateFirstResult(IEntity behavior, IEntity self) {
		return evaluateFirstResult(behavior, self, BindingManagerFactory.instance.createArguments());
	}
	@SuppressWarnings("unchecked")
	public static <E extends IEntity> E evaluateFirstResult(IEntity behavior, IEntity self, IBindingManager bm) {
		IExecutable executable = compileAndLazyEvaluate(behavior, self, bm);
		return (E) executable.evaluateNext();
	}

	//TODO ? fail on not boolean; != Queries predicate
	public static boolean evaluatePredicateOnSelfBinding(IEntity predicate, int relativeStage, IBindingManager bm) {
		IEntity selfEntity = bm.wIsSet(IBindingManager.SELF) ? bm.wGet(IBindingManager.SELF) : NullEntity.instance;
		IEntity result = evaluateOnSelfBinding(predicate, relativeStage, bm);
		if (result == null || !EntityUtils.isData(result))
			return false;
	
		Object resultValue = result.wGetValue();
		return IVisitor.class.isInstance(resultValue) ?
				Matcher.match((IVisitor) resultValue, selfEntity) :
					EntityUtils.safeBooleanValue(result, false);
	}
}
