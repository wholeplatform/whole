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

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.bindings.IBindingScope;
import org.whole.lang.bindings.INestableScope;
import org.whole.lang.commons.parsers.CommonsDataTypePresentationParser;
import org.whole.lang.executables.instrumentation.AbstractInstrumentationData;
import org.whole.lang.executables.instrumentation.CompositeInstrumentation;
import org.whole.lang.executables.instrumentation.DiagnosticData;
import org.whole.lang.executables.instrumentation.DiagnosticInstrumentation;
import org.whole.lang.executables.instrumentation.IExecutableInstrumentation;
import org.whole.lang.iterators.IEntityIterator;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.ICloneContext;
import org.whole.lang.util.BehaviorUtils;

/**
 * @author Riccardo Solmi
 */
public class InstrumentingExecutable<E extends IEntity> extends AbstractExecutable<E> implements IEntityIterator<E> {
	public static IExecutableInstrumentation instrumentation = CompositeInstrumentation.instance;

	public static final IEntity MISSING_SOURCE_ENTITY = BindingManagerFactory.instance.createNull();

	protected IExecutable<E> executable;

	public InstrumentingExecutable(IExecutable<E> executable) {
		this.executable = executable;
	}

	public IExecutable<E> getExecutable() {
		return executable;
	}

	public IExecutable<E> getSourceCode() {
		return getExecutable();
	}

	public String getSourceCodeClassName() {
		return getExecutable().getClass().getSimpleName();
	}

	@Override
	public IExecutable<E> withSourceEntity(IEntity entity) {
		getExecutable().withSourceEntity(entity);
		return super.withSourceEntity(entity);
	}

	@Override
	public IEntity getSourceEntity() {
		IEntity sourceEntity = super.getSourceEntity();
		if (sourceEntity == null)
			sourceEntity = getExecutable().getSourceEntity();
		if (sourceEntity == null)
			sourceEntity = MISSING_SOURCE_ENTITY;
		return sourceEntity;
	}

	protected IEntity selfEntity;
	public IEntity getResetEntity() {
		return selfEntity;
	}
	protected IEntity nextResetEntity;
	public IEntity getNextResetEntity() {
		return nextResetEntity;
	}

	public INestableScope getDebugScope() {
		INestableScope scope = BindingManagerFactory.instance.createNestedDynamicSimpleScope();
		IEntity sourceEntity = getSourceEntity();
		IEntity sourceFunction = BehaviorUtils.getSourceFunction(sourceEntity);
		String sourceFunctionUri = BehaviorUtils.getSourceFunctionUri(sourceFunction);

		scope.wDefValue("debug#sourceCode", getSourceCode());
		scope.wDefValue("debug#sourceCodeClassName", getSourceCodeClassName());
		scope.wDef("debug#sourceEntity", sourceEntity);
		scope.wDef("debug#sourceFunction", sourceFunction);
		if (sourceFunctionUri != null)
			scope.wDefValue("debug#sourceFunctionUri", sourceFunctionUri);

		return scope;
	}

	public Map<String, AbstractInstrumentationData> instrumentationDataMap = new HashMap<>();
	@SuppressWarnings("unchecked")
	public <V extends AbstractInstrumentationData> V instrumentationData(String dataId, Function<? super String, ? extends V> factoryMethod) {
		instrumentationDataMap.computeIfAbsent(dataId, factoryMethod);
		return (V) instrumentationDataMap.get(dataId);
	}

	
	@Override
	public IExecutable<E> clone(ICloneContext cc) {
		instrumentation.beforeClone(this);
		InstrumentingExecutable<E> result = (InstrumentingExecutable<E>) super.clone(cc);
		result.executable = executable.clone(cc);
		result.instrumentationDataMap = instrumentationDataMap.entrySet().stream()
				.collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue().clone(cc)));
		instrumentation.afterClone(this, result);
		return result;
	}

	@Override
	protected void setProducersBindings(IBindingManager bindings) {
		instrumentation.beforeSetBindings(this);
		super.setProducersBindings(bindings);
		getExecutable().setBindings(bindings);
		instrumentation.afterSetBindings(this);
	}

	@Override
	public void reset(IEntity entity) {
		nextResetEntity = entity;
		instrumentation.beforeReset(this);
		selfEntity = entity;
		getExecutable().reset(entity);
		instrumentation.afterReset(this);
	}

	@Override
	public E evaluateNext() {
		instrumentation.beforeEvaluateNext(this);
		E result = getExecutable().evaluateNext();
		instrumentation.afterEvaluateNext(this, result);
		return result;
	}
	@Override
	public E evaluateRemaining() {
		instrumentation.beforeEvaluateRemaining(this);
		E result = getExecutable().evaluateRemaining();
		instrumentation.afterEvaluateRemaining(this, result);
		return result;
	}

	@Override
	public void callNext() {
		instrumentation.beforeCallNext(this);
		getExecutable().callNext();
		instrumentation.afterCallNext(this);
	}
	@Override
	public void callRemaining() {
		instrumentation.beforeCallRemaining(this);
		getExecutable().callRemaining();
		instrumentation.afterCallRemaining(this);
	}

	@Override
	public void accept(IEntity entity) {
		instrumentation.beforeDoNext(this, entity);
		getExecutable().accept(entity);
		instrumentation.afterDoNext(this);
	}
	@Override
	public void done() {
		instrumentation.beforeDoEnd(this);
		getExecutable().done();
		instrumentation.afterDoEnd(this);
	}

	@Override
	public IEntityIterator<E> iterator() {
		return this;
	}

	@Override
	public boolean hasNext() {
		instrumentation.beforeHasNext(this);
		boolean result = getExecutable().iterator().hasNext();
		instrumentation.afterHasNext(this, result);
		return result;
	}
	@Override
	public E lookahead() {
		instrumentation.beforeLookahead(this);
		E result = getExecutable().iterator().lookahead();
		instrumentation.afterLookahead(this, result);
		return result;
	}
	@Override
	public IBindingScope lookaheadScope() {
		return getExecutable().iterator().lookaheadScope();
	}
	@Override
	public E next() {
		instrumentation.beforeNext(this);
		E result = getExecutable().iterator().next();
		instrumentation.afterNext(this, result);
		return result;
	}

	@Override
	public void prune() {
		getExecutable().prune();
	}

	@Override
	public void set(E entity) {
		getExecutable().set(entity);
	}

	@Override
	public void add(E entity) {
		getExecutable().add(entity);
	}

	@Override
	public void remove() {
		getExecutable().remove();
	}

	@Override
	public void toString(StringBuilder sb) {
		getExecutable().toString(sb);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		toInstrumentedString(sb);
		return sb.toString();
	}

	public void toInstrumentedString(StringBuilder sb) {
		DiagnosticData dd = DiagnosticInstrumentation.diagnosticData(this);
		
		IEntity selfEntity = dd.selfEntity;
		String selfEntityName = selfEntity != null ?
				CommonsDataTypePresentationParser.unparseEntityDescriptor(
						selfEntity.wGetEntityDescriptor()) : "null";
		
		IEntity selfBinding = hasBindings() ? getBindings().wGet(IBindingManager.SELF) : null;		
		String selfBindingName = selfBinding != null ?
				CommonsDataTypePresentationParser.unparseEntityDescriptor(
						selfBinding.wGetEntityDescriptor()) : "null";

		String sourceFunctionUri = null;
		String sourceEntityName = "???";

		IEntity sourceEntity = super.getSourceEntity();
		if (sourceEntity == null)
			sourceEntity = getExecutable().getSourceEntity();
		if (sourceEntity != null) {
			sourceEntityName = CommonsDataTypePresentationParser.unparseEntityDescriptor(
					sourceEntity.wGetEntityDescriptor());

			IEntity sourceFunction = BehaviorUtils.getSourceFunction(sourceEntity);
			if (sourceFunction != null) {
				sourceFunctionUri = BehaviorUtils.getSourceFunctionUri(sourceFunction);
			}			
		}


		if (dd.severity != null) {
			sb.append("// ");
			sb.append(dd.severity);
			sb.append(": ");
			sb.append(dd.message);
			sb.append("\n");
		}

		sb.append("// ");
		sb.append("clones: ");
		int cloneSetSize = dd.cloneSetSize(); 
		sb.append(cloneSetSize);
		if (cloneSetSize > 0) {
			sb.append("   isFirstPrototype: ");
			sb.append(dd.isFirstPrototype(this));
			sb.append("   stateWhenCloned: ");
			sb.append(dd.stateWhenCloned);
			sb.append("   unusedClones: ");
			sb.append(dd.unusedCloneSet().size());
		}
		sb.append("\n");

		sb.append("// ");
		sb.append("state: ");
		sb.append(dd.state);

		sb.append("   steps: ");
		sb.append(dd.steps);

		sb.append("   callHistory: ");
		sb.append(dd.callHistory);

		sb.append("   self: ");
		sb.append(selfEntityName);
		if (selfEntity != selfBinding) {
			sb.append(" != ");
			sb.append(selfBindingName);
		}
		sb.append("\n");

		sb.append("// ");
		sb.append("code: ");
		sb.append(getSourceCodeClassName());
		sb.append("   source: ");
		sb.append(sourceEntityName);
		if (sourceFunctionUri != null) {
			sb.append("   function: ");
			sb.append(sourceFunctionUri);
		}
		sb.append("\n\n");

		getExecutable().toString(sb);
	}
}
