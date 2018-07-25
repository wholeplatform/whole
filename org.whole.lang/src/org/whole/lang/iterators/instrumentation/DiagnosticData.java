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
import java.util.Deque;
import java.util.Set;
import java.util.stream.Collectors;

import org.whole.lang.commons.parsers.CommonsDataTypePresentationParser;
import org.whole.lang.iterators.InstrumentingIterator;
import org.whole.lang.iterators.instrumentation.DiagnosticInstrumentation.InstrumentedMethod;
import org.whole.lang.iterators.instrumentation.DiagnosticInstrumentation.Severity;
import org.whole.lang.iterators.instrumentation.DiagnosticInstrumentation.State;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.ICloneContext;

/**
 * @author Riccardo Solmi
 */
public class DiagnosticData extends AbstractInstrumentationData {
	public static int HISTORY_SIZE = 4;
	public Deque<InstrumentedMethod> callHistory = new ArrayDeque<>(HISTORY_SIZE);

	public IEntity selfEntity = null;
	public State state = State.NOT_INITIALIZED;
	public int steps = 0;

	public String message;
	public Severity severity;

	public State stateWhenCloned = null;
	public InstrumentingIterator<?> firstPrototype = null;
	public Set<InstrumentingIterator<?>> cloneSet = null;

	@Override
	public DiagnosticData clone(ICloneContext cc) {
		DiagnosticData data = (DiagnosticData) super.clone(cc);
		data.callHistory = new ArrayDeque<>(callHistory);
		data.message = message;
		return data;
	}

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
		return cloneSet.stream().filter((i) -> DiagnosticInstrumentation.diagnosticData(i).state != State.USED).collect(Collectors.toSet());
	}

	@Override
	public String toString() {
		String selfEntityName = selfEntity != null ?
				CommonsDataTypePresentationParser.unparseEntityDescriptor(
						selfEntity.wGetEntityDescriptor()) : "null";

		StringBuilder sb = new StringBuilder();
		sb.append("state: ");
		sb.append(state);

		sb.append("   steps: ");
		sb.append(steps);

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

		sb.append("   self: ");
		sb.append(selfEntityName);

		if (severity != null) {
			sb.append("   ");
			sb.append(severity);
			sb.append(": ");
			sb.append(message);
		}

		return sb.toString();
	}
}