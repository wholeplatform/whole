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
package org.whole.lang.executables.instrumentation;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.WeakHashMap;

import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.executables.InstrumentingExecutable;
import org.whole.lang.model.IEntity;

/**
 * @author Riccardo Solmi
 */
public class DiagnosticInstrumentation implements IExecutableInstrumentation {
	public static final IExecutableInstrumentation instance = new DiagnosticInstrumentation();

	public static String ID = DiagnosticInstrumentation.class.getName();
	public static DiagnosticData diagnosticData(InstrumentingExecutable<?> ii) {
		return ii.instrumentationData(ID, i -> new DiagnosticData());
	}

	public static enum State {
		NOT_INITIALIZED, WITHOUT_SELF, READY, USED
	}
	public static enum InstrumentedMethod {
		CLONE, SET_BINDINGS, RESET, EVALUATE_NEXT, EVALUATE_REMAINING, CALL_NEXT, CALL_REMAINING, DO_NEXT, DO_END, HAS_NEXT, LOOKAHEAD, NEXT
	}
	public static enum Severity {
		INFO, WARNING, ERROR
	}

	public void performDiagnostics(InstrumentingExecutable<?> ii, InstrumentedMethod method, boolean before) {
		performDiagnostics(ii, method, before, diagnosticData(ii));
	}
	public void performDiagnostics(InstrumentingExecutable<?> ii, InstrumentedMethod method, boolean before, DiagnosticData data) {
		if (before) {
			if (data.callHistory.size() >= DiagnosticData.HISTORY_SIZE)
				data.callHistory.removeFirst();
			data.callHistory.addLast(method);

			if (method == InstrumentedMethod.NEXT) {
				if (data.state == State.READY)
					data.steps = 0;
				if (data.state == State.USED)
					data.steps++;
			}

			data.message = null;
			data.severity = null;
		}

		testLifecycle(ii, method, before, data);
		testSelf(ii, method, before, data);
	}

	public void testLifecycle(InstrumentingExecutable<?> ii, InstrumentedMethod method, boolean before, DiagnosticData data) {
		if (!before)
			return;

		switch (data.state) {
		case NOT_INITIALIZED:
			switch (method) {
			case SET_BINDINGS:
				data.state = State.WITHOUT_SELF;
				break;
			case RESET:
				if (ii.getNextResetEntity() != null)
					data.state = State.READY;
				break;
			default:
				illegalState(ii, method, data);
				break;
			case CLONE:
				break;
			}
			break;
		case WITHOUT_SELF:
			switch (method) {
			case RESET:
				if (ii.getNextResetEntity() != null)
					data.state = State.READY;
				break;
			default:
				illegalState(ii, method, data);
				break;
			case SET_BINDINGS:
				//TODO warning duplicate setBindings or ok after a clone
			case CLONE:
				break;
			}
			break;
		case READY:
		case USED:
			switch (method) {
			case SET_BINDINGS:
//FIXME ?				data.state = State.initSelf;
				break;
			case RESET:
				if (ii.getNextResetEntity() != null)
					data.state = State.READY;
				break;
			case EVALUATE_NEXT:
			case EVALUATE_REMAINING:
			case CALL_NEXT:
			case CALL_REMAINING:
			case LOOKAHEAD:
			case NEXT:
				data.state = State.USED;
				break;
			case CLONE:
				break;
			default:
			}
		}
	}

	private static Set<String> readyIterators;
	private static Set<String> readyIterators() {
		if (readyIterators == null) {
			readyIterators = new HashSet<String>();
			readyIterators.addAll(Arrays.<String>asList(new String[] {
					"ConstantEvaluator", "ConstantChildStepper", "EmptyExecutable",
					"CollectionEvaluator", "FailureExecutable",
					"ConstantIterator", "ConstantChildIterator", "EmptyIterator",
					"CollectionIterator", "FailureIterator"
			}));
		}
		return readyIterators;
	}
	public static boolean isReadyIterator(String iteratorClassName) {
		return readyIterators().contains(iteratorClassName);
	}

	public void illegalState(InstrumentingExecutable<?> ii, InstrumentedMethod method, DiagnosticData data) {
		data.message = "Illegal state: <"+data.state+", "+method+">";

		if (isReadyIterator(ii.getSourceCodeClassName()))
			data.severity = Severity.INFO;
		else {
			data.severity = Severity.ERROR;
			DebuggerInstrumentation.breakpointConsumer.accept(ii);
		}
	}

	public void testSelf(InstrumentingExecutable<?> ii, InstrumentedMethod method, boolean before, DiagnosticData data) {
		if (!before)
			return;

		switch (method) {
		case EVALUATE_NEXT:
		case EVALUATE_REMAINING:
		case CALL_NEXT:
		case CALL_REMAINING:
		case HAS_NEXT:
		case LOOKAHEAD:
		case NEXT:
			if (data.state == State.READY || data.state == State.USED) {
				IEntity selfBinding = ii.getBindings().wGet(IBindingManager.SELF);
				IEntity selfEntity = data.selfEntity;

				if (selfEntity == null && selfBinding == null)
					nullSelfEntityAndBinding(ii, method, data);
				else if (selfEntity == null)
					nullSelfEntity(ii, method, data);
				else if (selfBinding == null)
					nullSelfBinding(ii, method, data);
				else if (selfEntity != selfBinding)
					notEqualsSelfEntityAndBinding(ii, method, data);
			}			
			break;
		default:
		}
	}

	public void nullSelfEntityAndBinding(InstrumentingExecutable<?> ii, InstrumentedMethod method, DiagnosticData data) {
		data.message = "null SelfEntity and self binding";
		data.severity = Severity.ERROR;
		DebuggerInstrumentation.breakpointConsumer.accept(ii);
	}
	public void nullSelfEntity(InstrumentingExecutable<?> ii, InstrumentedMethod method, DiagnosticData data) {
		data.message = "null SelfEntity";
		data.severity = Severity.ERROR;
		DebuggerInstrumentation.breakpointConsumer.accept(ii);
	}
	public void nullSelfBinding(InstrumentingExecutable<?> ii, InstrumentedMethod method, DiagnosticData data) {
		data.message = "null self binding";
		data.severity = Severity.INFO;
//		DebuggerInstrumentation.breakpointConsumer.accept(ii);
	}
	public void notEqualsSelfEntityAndBinding(InstrumentingExecutable<?> ii, InstrumentedMethod method, DiagnosticData data) {
		data.message = "SelfEntity not equals self binding";
		data.severity = Severity.INFO;
//		DebuggerInstrumentation.breakpointConsumer.accept(ii);
	}

	@Override
	public void beforeClone(InstrumentingExecutable<?> ii) {
		performDiagnostics(ii, InstrumentedMethod.CLONE, true);
	}
	@Override
	public void afterClone(InstrumentingExecutable<?> ii, InstrumentingExecutable<?> clone) {
		DiagnosticData data = diagnosticData(ii);
		data.stateWhenCloned = data.state;

		if (data.cloneSet == null) {
			data.cloneSet = Collections.newSetFromMap(new WeakHashMap<>());
			data.cloneSet.add(ii);
			data.firstPrototype = ii;
		}

		DiagnosticData cloneData = diagnosticData(clone);
		cloneData.stateWhenCloned = data.state;
		cloneData.cloneSet = data.cloneSet;
		cloneData.cloneSet.add(clone);
		cloneData.firstPrototype = data.firstPrototype;

		performDiagnostics(ii, InstrumentedMethod.CLONE, false, data);
	}

	@Override
	public void beforeSetBindings(InstrumentingExecutable<?> ii) {
		performDiagnostics(ii, InstrumentedMethod.SET_BINDINGS, true);
	}
	@Override
	public void afterSetBindings(InstrumentingExecutable<?> ii) {
		performDiagnostics(ii, InstrumentedMethod.SET_BINDINGS, false);
	}

	@Override
	public void beforeReset(InstrumentingExecutable<?> ii) {
		performDiagnostics(ii, InstrumentedMethod.RESET, true);
	}
	@Override
	public void afterReset(InstrumentingExecutable<?> ii) {
		DiagnosticData data = diagnosticData(ii);
		data.selfEntity = ii.getResetEntity();
		performDiagnostics(ii, InstrumentedMethod.RESET, false, data);
	}

	@Override
	public void beforeEvaluateNext(InstrumentingExecutable<?> ii) {
		performDiagnostics(ii, InstrumentedMethod.EVALUATE_NEXT, true);
	}
	@Override
	public void afterEvaluateNext(InstrumentingExecutable<?> ii, IEntity result) {
		performDiagnostics(ii, InstrumentedMethod.EVALUATE_NEXT, false);
	}

	@Override
	public void beforeEvaluateRemaining(InstrumentingExecutable<?> ii) {
		performDiagnostics(ii, InstrumentedMethod.EVALUATE_REMAINING, true);
	}
	@Override
	public void afterEvaluateRemaining(InstrumentingExecutable<?> ii, IEntity result) {
		performDiagnostics(ii, InstrumentedMethod.EVALUATE_REMAINING, false);
	}

	@Override
	public void beforeCallNext(InstrumentingExecutable<?> ii) {
		performDiagnostics(ii, InstrumentedMethod.CALL_NEXT, true);
	}
	@Override
	public void afterCallNext(InstrumentingExecutable<?> ii) {
		performDiagnostics(ii, InstrumentedMethod.CALL_NEXT, false);
	}

	@Override
	public void beforeCallRemaining(InstrumentingExecutable<?> ii) {
		performDiagnostics(ii, InstrumentedMethod.CALL_REMAINING, true);
	}
	@Override
	public void afterCallRemaining(InstrumentingExecutable<?> ii) {
		performDiagnostics(ii, InstrumentedMethod.CALL_REMAINING, false);
	}

	@Override
	public void beforeDoNext(InstrumentingExecutable<?> ii, IEntity result) {
		performDiagnostics(ii, InstrumentedMethod.DO_NEXT, true);
	}
	@Override
	public void afterDoNext(InstrumentingExecutable<?> ii) {
		performDiagnostics(ii, InstrumentedMethod.DO_NEXT, false);
	}

	@Override
	public void beforeDoEnd(InstrumentingExecutable<?> ii) {
		performDiagnostics(ii, InstrumentedMethod.DO_END, true);
	}
	@Override
	public void afterDoEnd(InstrumentingExecutable<?> ii) {
		performDiagnostics(ii, InstrumentedMethod.DO_END, false);
	}

	@Override
	public void beforeHasNext(InstrumentingExecutable<?> ii) {
		performDiagnostics(ii, InstrumentedMethod.HAS_NEXT, true);
	}
	@Override
	public void afterHasNext(InstrumentingExecutable<?> ii, boolean result) {
		performDiagnostics(ii, InstrumentedMethod.HAS_NEXT, false);
	}

	@Override
	public void beforeLookahead(InstrumentingExecutable<?> ii) {
		performDiagnostics(ii, InstrumentedMethod.LOOKAHEAD, true);
	}
	@Override
	public void afterLookahead(InstrumentingExecutable<?> ii, IEntity result) {
		performDiagnostics(ii, InstrumentedMethod.LOOKAHEAD, false);
	}

	@Override
	public void beforeNext(InstrumentingExecutable<?> ii) {
		performDiagnostics(ii, InstrumentedMethod.NEXT, true);
	}
	@Override
	public void afterNext(InstrumentingExecutable<?> ii, IEntity result) {
		performDiagnostics(ii, InstrumentedMethod.NEXT, false);
	}
}
