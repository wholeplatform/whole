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

import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.bindings.INestableScope;
import org.whole.lang.commons.parsers.CommonsDataTypePresentationParser;
import org.whole.lang.iterators.instrumentation.CompositeInstrumentation;
import org.whole.lang.iterators.instrumentation.DiagnosticInstrumentation;
import org.whole.lang.iterators.instrumentation.DiagnosticInstrumentation.DiagnosticData;
import org.whole.lang.iterators.instrumentation.IEntityIteratorInstrumentation;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.ICloneContext;
import org.whole.lang.util.BehaviorUtils;

/**
 * @author Riccardo Solmi
 */
public class InstrumentingIterator<E extends IEntity> extends AbstractDelegatingIterator<E> {
	public static IEntityIteratorInstrumentation instrumentation =
			CompositeInstrumentation.instance;
//			IdentityInstrumentation.instance;

	public InstrumentingIterator(IEntityIterator<E> iterator) {
		super(iterator);
	}

	public IEntityIterator<E> getSourceCode() {
		return getIterator();
	}

	public String getSourceCodeClassName() {
		return getIterator().getClass().getSimpleName();
	}

	@Override
	public IEntity getSourceEntity() {
		IEntity sourceEntity = super.getSourceEntity();
		if (sourceEntity == null)
			sourceEntity = getIterator().getSourceEntity();
		if (sourceEntity == null)
			sourceEntity = BindingManagerFactory.instance.createNull();//Value("<No source available>");
		return sourceEntity;
	}

	public IEntity getResetEntity() {
		return resetEntity;
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

	@Override
	public IEntityIterator<E> clone(ICloneContext cc) {
		instrumentation.beforeClone(this);
		InstrumentingIterator<E> result = (InstrumentingIterator<E>) super.clone(cc);
		instrumentation.afterClone(this, result);
		return result;
	}

	@Override
	protected void setArgumentsBindings(IBindingManager bindings) {
		instrumentation.beforeSetBindings(this);
		super.setArgumentsBindings(bindings);
		instrumentation.afterSetBindings(this);
	}
	
	@Override
	public void reset(IEntity entity) {
		nextResetEntity = entity;
		instrumentation.beforeReset(this);
		super.reset(entity);
		instrumentation.afterReset(this);
	}

	@Override
	public boolean hasNext() {
		instrumentation.beforeHasNext(this);
		boolean result = super.hasNext();
		instrumentation.afterHasNext(this, result);
		return result;
	}

	@Override
	public E lookahead() {
		instrumentation.beforeLookahead(this);
		E result = super.lookahead();
		instrumentation.afterLookahead(this, result);
		return result;
	}

	@Override
	public E next() {
		instrumentation.beforeNext(this);
		E result = super.next();
		instrumentation.afterNext(this, result);
		return result;
	}

	@Override
	public IEntityIterator<E> withSourceEntity(IEntity entity) {
		getIterator().withSourceEntity(entity);
		return super.withSourceEntity(entity);
	}

	@Override
	public void toString(StringBuilder sb) {
		DiagnosticData dd = DiagnosticInstrumentation.diagnosticData(this);
		
		IEntity selfEntity = dd.selfEntity;
		String selfEntityName = selfEntity != null ?
				CommonsDataTypePresentationParser.unparseEntityDescriptor(
						selfEntity.wGetEntityDescriptor()) : "null";
		
		IEntity selfBinding = getBindings().wGet("self");		
		String selfBindingName = selfBinding != null ?
				CommonsDataTypePresentationParser.unparseEntityDescriptor(
						selfBinding.wGetEntityDescriptor()) : "null";

		String sourceFunctionUri = "???";
		String sourceEntityName = "???";

		IEntity sourceEntity = super.getSourceEntity();
		if (sourceEntity == null)
			sourceEntity = getIterator().getSourceEntity();
		if (sourceEntity != null) {
			sourceEntityName = CommonsDataTypePresentationParser.unparseEntityDescriptor(
					sourceEntity.wGetEntityDescriptor());

			IEntity sourceFunction = BehaviorUtils.getSourceFunction(sourceEntity);
			if (sourceFunction != null) {
				sourceFunctionUri = BehaviorUtils.getSourceFunctionUri(sourceFunction);
			}			
		}


		sb.append("[ ");
		sb.append("state: ");
		sb.append(dd.state);

		sb.append("   clones: ");
		int cloneSetSize = dd.cloneSetSize(); 
		sb.append(cloneSetSize);
		if (cloneSetSize > 0) {
			sb.append(" (isFirst: ");
			sb.append(dd.isFirstPrototype(this));
			sb.append("  atState: ");
			sb.append(dd.stateWhenCloned);
			sb.append("  unused: ");
			sb.append(dd.unusedCloneSet().size());
			sb.append(")");
		}

		sb.append("   callHistory: ");
		sb.append(dd.callHistory);

		sb.append("   self: ");
		sb.append(selfEntityName);
		sb.append(selfEntity == selfBinding ? " == " : " != ");
		sb.append(selfBindingName);
		sb.append(" ]\n");

		sb.append("[ ");
		sb.append("source: ");
		sb.append(sourceEntityName);
		sb.append("  in: ");
		sb.append(sourceFunctionUri);
		sb.append(" ]\n");

		super.toString(sb);
	}
}
