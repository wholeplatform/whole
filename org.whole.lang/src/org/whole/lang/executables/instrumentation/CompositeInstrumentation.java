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
import java.util.List;

import org.whole.lang.executables.InstrumentingExecutable;
import org.whole.lang.model.IEntity;

/**
 * @author Riccardo Solmi
 */
public class CompositeInstrumentation implements IExecutableInstrumentation {
	public static final IExecutableInstrumentation instance = new CompositeInstrumentation(
			DiagnosticInstrumentation.instance,
//			ProfilerInstrumentation.instance,
//			LoggerInstrumentation.instance,
			DebuggerInstrumentation.instance
	);

	public final List<IExecutableInstrumentation> instrumentations;

	public CompositeInstrumentation(IExecutableInstrumentation... instrumentations) {
		this.instrumentations = Arrays.asList(instrumentations);
	}

	@Override
	public void beforeClone(InstrumentingExecutable ii) {
		instrumentations.forEach((i) -> i.beforeClone(ii));
	}
	@Override
	public void afterClone(InstrumentingExecutable ii, InstrumentingExecutable result) {
		instrumentations.forEach((i) -> i.afterClone(ii, result));
	}

	@Override
	public void beforeSetBindings(InstrumentingExecutable ii) {
		instrumentations.forEach((i) -> i.beforeSetBindings(ii));
	}
	@Override
	public void afterSetBindings(InstrumentingExecutable ii) {
		instrumentations.forEach((i) -> i.afterSetBindings(ii));
	}

	@Override
	public void beforeReset(InstrumentingExecutable ii) {
		instrumentations.forEach((i) -> i.beforeReset(ii));
	}
	@Override
	public void afterReset(InstrumentingExecutable ii) {
		instrumentations.forEach((i) -> i.afterReset(ii));
	}

	public void beforeEvaluateNext(InstrumentingExecutable ii) {
		instrumentations.forEach((i) -> i.beforeEvaluateNext(ii));
	}
	public void afterEvaluateNext(InstrumentingExecutable ii, IEntity result) {
		instrumentations.forEach((i) -> i.afterEvaluateNext(ii, result));
	}

	public void beforeEvaluateRemaining(InstrumentingExecutable ii) {
		instrumentations.forEach((i) -> i.beforeEvaluateRemaining(ii));
	}
	public void afterEvaluateRemaining(InstrumentingExecutable ii, IEntity result) {
		instrumentations.forEach((i) -> i.afterEvaluateRemaining(ii, result));
	}

	public void beforeCallNext(InstrumentingExecutable ii) {
		instrumentations.forEach((i) -> i.beforeCallNext(ii));
	}
	public void afterCallNext(InstrumentingExecutable ii) {
		instrumentations.forEach((i) -> i.afterCallNext(ii));
	}

	public void beforeCallRemaining(InstrumentingExecutable ii) {
		instrumentations.forEach((i) -> i.beforeCallRemaining(ii));
	}
	public void afterCallRemaining(InstrumentingExecutable ii) {
		instrumentations.forEach((i) -> i.afterCallRemaining(ii));
	}

	public void beforeDoNext(InstrumentingExecutable ii, IEntity result) {
		instrumentations.forEach((i) -> i.beforeDoNext(ii, result));
	}
	public void afterDoNext(InstrumentingExecutable ii) {
		instrumentations.forEach((i) -> i.afterDoNext(ii));
	}

	public void beforeDoEnd(InstrumentingExecutable ii) {
		instrumentations.forEach((i) -> i.beforeDoEnd(ii));
	}
	public void afterDoEnd(InstrumentingExecutable ii) {
		instrumentations.forEach((i) -> i.afterDoEnd(ii));
	}


	@Override
	public void beforeHasNext(InstrumentingExecutable ii) {
		instrumentations.forEach((i) -> i.beforeHasNext(ii));
	}
	@Override
	public void afterHasNext(InstrumentingExecutable ii, boolean result) {
		instrumentations.forEach((i) -> i.afterHasNext(ii, result));
	}

	@Override
	public void beforeLookahead(InstrumentingExecutable ii) {
		instrumentations.forEach((i) -> i.beforeLookahead(ii));
	}
	@Override
	public void afterLookahead(InstrumentingExecutable ii, IEntity result) {
		instrumentations.forEach((i) -> i.afterLookahead(ii, result));
	}

	@Override
	public void beforeNext(InstrumentingExecutable ii) {
		instrumentations.forEach((i) -> i.beforeNext(ii));
	}
	@Override
	public void afterNext(InstrumentingExecutable ii, IEntity result) {
		instrumentations.forEach((i) -> i.afterNext(ii, result));
	}
}
