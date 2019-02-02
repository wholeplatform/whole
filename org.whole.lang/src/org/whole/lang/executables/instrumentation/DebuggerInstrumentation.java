/**
 * Copyright 2004-2019 Riccardo Solmi. All rights reserved.
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

import java.util.function.Consumer;
import java.util.function.Predicate;

import org.whole.lang.executables.InstrumentingExecutable;
import org.whole.lang.model.IEntity;

/**
 * @author Riccardo Solmi
 */
public class DebuggerInstrumentation extends IdentityInstrumentation {
	public static final IExecutableInstrumentation instance = new DebuggerInstrumentation();

	public static boolean evaluatingPredicate = false;
	public static Predicate<InstrumentingExecutable> breakpointPredicate = (ii) -> {
		//TODO replace with a framework level predicate
		return false;
	};
	public static Consumer<InstrumentingExecutable> breakpointConsumer = (ii) -> {
		//TODO place a breakpoint here to stop at the framework level
		return;
	};

	protected static IEntity lastSourceEntity;
	public static boolean sourceEntityChanged;

	protected void beforeBehavior(InstrumentingExecutable ii) {
		IEntity sourceEntity = ii.getSourceEntity();
		sourceEntityChanged = sourceEntity != lastSourceEntity && lastSourceEntity != InstrumentingExecutable.MISSING_SOURCE_ENTITY;
		lastSourceEntity = sourceEntity;

//		if (!evaluatingPredicate && (sourceEntityChanged || breakpointPredicate.test(ii)))
		if (!evaluatingPredicate && breakpointPredicate.test(ii))
			breakpointConsumer.accept(ii);
	}

	@Override
	public void beforeEvaluateNext(InstrumentingExecutable ii) {
		beforeBehavior(ii);
	}
	@Override
	public void beforeEvaluateRemaining(InstrumentingExecutable ii) {
		beforeBehavior(ii);
	}

	@Override
	public void beforeCallNext(InstrumentingExecutable ii) {
		beforeBehavior(ii);
	}
	@Override
	public void beforeCallRemaining(InstrumentingExecutable ii) {
		beforeBehavior(ii);
	}
}
