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
package org.whole.lang.iterators.instrumentation;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.stream.Collectors;

import org.whole.lang.commons.parsers.CommonsDataTypePresentationParser;
import org.whole.lang.iterators.IEntityIterator;
import org.whole.lang.iterators.InstrumentingIterator;
import org.whole.lang.model.IEntity;

/**
 * @author Riccardo Solmi
 */
public class DiagnosticInstrumentation implements IEntityIteratorInstrumentation {
	public static final IEntityIteratorInstrumentation instance = new DiagnosticInstrumentation();

	//TODO move aspectual state responsibility to InstrumentingIterator
	public static Map<IEntityIterator<?>, DiagnosticData> iteratorDiagnosticDataMap = new HashMap<>();
	public static DiagnosticData diagnosticData(InstrumentingIterator<?> ii) {
		iteratorDiagnosticDataMap.computeIfAbsent(ii, i -> new DiagnosticData());
		return iteratorDiagnosticDataMap.get(ii);
	}

	public static enum State {
		NEED_BINDINGS, NEED_SELF, READY, USED
	}
	public static enum InstrumentedMethod {
		CLONE, SET_BINDINGS, RESET, HAS_NEXT, LOOKAHEAD, NEXT 
	}

	public static class DiagnosticData {
		public static int HISTORY_SIZE = 4;
		public Deque<InstrumentedMethod> callHistory = new ArrayDeque<>(HISTORY_SIZE);

		public IEntity selfEntity = null;
		public State state = State.NEED_BINDINGS;

		public State stateWhenCloned = null;
		public InstrumentingIterator<?> firstPrototype = null;
		public Set<InstrumentingIterator<?>> cloneSet = null;
		public final int cloneSetSize() {
			return cloneSet != null ? cloneSet.size() : 0;
		}
		public final boolean isFirstPrototype(InstrumentingIterator<?> ii) {
			return firstPrototype == ii;
		}
		public final boolean usedWhenCloned() {
			return stateWhenCloned == State.USED;
		}
		public final Set<InstrumentingIterator<?>> unusedCloneSet() {
			return cloneSet.stream().filter((i) -> diagnosticData(i).state != State.USED).collect(Collectors.toSet());
		}

		@Override
		public String toString() {
			String selfEntityName = selfEntity != null ?
					CommonsDataTypePresentationParser.unparseEntityDescriptor(
							selfEntity.wGetEntityDescriptor()) : "null";

			StringBuilder sb = new StringBuilder();
			sb.append("state: ");
			sb.append(state);

			sb.append("   clones: ");
			int cloneSetSize = cloneSetSize(); 
			sb.append(cloneSetSize);
			if (cloneSetSize > 0) {
				sb.append("   stateWhenCloned: ");
				sb.append(stateWhenCloned);
				sb.append("   unusedClones: ");
				sb.append(unusedCloneSet().size());
			}

			sb.append("   callHistory: ");
			sb.append(callHistory);

			sb.append("  self: ");
			sb.append(selfEntityName);
			return sb.toString();
		}
	}

	public void performDiagnostics(InstrumentingIterator<?> ii, InstrumentedMethod method, boolean before) {
		performDiagnostics(ii, method, before, diagnosticData(ii));
	}
	public void performDiagnostics(InstrumentingIterator<?> ii, InstrumentedMethod method, boolean before, DiagnosticData data) {
		if (before) {
			if (data.callHistory.size() >= DiagnosticData.HISTORY_SIZE)
				data.callHistory.removeFirst();
			data.callHistory.addLast(method);
		}

		testLifecycle(ii, method, before, data);
		testSelf(ii, method, before, data);
	}

	public void testLifecycle(InstrumentingIterator<?> ii, InstrumentedMethod method, boolean before, DiagnosticData data) {
		if (!before)
			return;

		switch (data.state) {
		case NEED_BINDINGS:
			switch (method) {
			case SET_BINDINGS:
				data.state = State.NEED_SELF;
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
		case NEED_SELF:
			switch (method) {
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
			case HAS_NEXT:
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

	public void illegalState(InstrumentingIterator<?> ii, InstrumentedMethod method, DiagnosticData data) {
		DebuggerInstrumentation.breakpointConsumer.accept(ii);
	}

	public void testSelf(InstrumentingIterator<?> ii, InstrumentedMethod method, boolean before, DiagnosticData data) {
		if (!before)
			return;

		switch (method) {
		case HAS_NEXT:
		case LOOKAHEAD:
		case NEXT:
			if (data.state == State.READY || data.state == State.USED) {
				IEntity selfBinding = ii.getBindings().wGet("self");
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

	public void nullSelfEntityAndBinding(InstrumentingIterator<?> ii, InstrumentedMethod method, DiagnosticData data) {
		DebuggerInstrumentation.breakpointConsumer.accept(ii);
	}
	public void nullSelfEntity(InstrumentingIterator<?> ii, InstrumentedMethod method, DiagnosticData data) {
		DebuggerInstrumentation.breakpointConsumer.accept(ii);
	}
	public void nullSelfBinding(InstrumentingIterator<?> ii, InstrumentedMethod method, DiagnosticData data) {
//		DebuggerInstrumentation.breakpointConsumer.accept(ii);
	}
	public void notEqualsSelfEntityAndBinding(InstrumentingIterator<?> ii, InstrumentedMethod method, DiagnosticData data) {
//		DebuggerInstrumentation.breakpointConsumer.accept(ii);
	}

	@Override
	public void beforeClone(InstrumentingIterator<?> ii) {
		performDiagnostics(ii, InstrumentedMethod.CLONE, true);
	}
	@Override
	public void afterClone(InstrumentingIterator<?> ii, InstrumentingIterator<?> clone) {
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
	public void beforeSetBindings(InstrumentingIterator<?> ii) {
		performDiagnostics(ii, InstrumentedMethod.SET_BINDINGS, true);
	}
	@Override
	public void afterSetBindings(InstrumentingIterator<?> ii) {
		performDiagnostics(ii, InstrumentedMethod.SET_BINDINGS, false);
	}

	@Override
	public void beforeReset(InstrumentingIterator<?> ii) {
		performDiagnostics(ii, InstrumentedMethod.RESET, true);
	}
	@Override
	public void afterReset(InstrumentingIterator<?> ii) {
		DiagnosticData data = diagnosticData(ii);
		data.selfEntity = ii.getResetEntity();
		performDiagnostics(ii, InstrumentedMethod.RESET, false, data);
	}

	@Override
	public void beforeHasNext(InstrumentingIterator<?> ii) {
		performDiagnostics(ii, InstrumentedMethod.HAS_NEXT, true);
	}
	@Override
	public void afterHasNext(InstrumentingIterator<?> ii, boolean result) {
		performDiagnostics(ii, InstrumentedMethod.HAS_NEXT, false);
	}

	@Override
	public void beforeLookahead(InstrumentingIterator<?> ii) {
		performDiagnostics(ii, InstrumentedMethod.LOOKAHEAD, true);
	}
	@Override
	public void afterLookahead(InstrumentingIterator<?> ii, IEntity result) {
		performDiagnostics(ii, InstrumentedMethod.LOOKAHEAD, false);
	}

	@Override
	public void beforeNext(InstrumentingIterator<?> ii) {
		performDiagnostics(ii, InstrumentedMethod.NEXT, true);
	}
	@Override
	public void afterNext(InstrumentingIterator<?> ii, IEntity result) {
		performDiagnostics(ii, InstrumentedMethod.NEXT, false);
	}
}
