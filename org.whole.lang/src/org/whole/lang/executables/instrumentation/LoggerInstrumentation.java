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

import org.whole.lang.executables.IExecutable;
import org.whole.lang.executables.InstrumentingExecutable;
import org.whole.lang.model.IEntity;

/**
 * @author Riccardo Solmi
 */
public class LoggerInstrumentation extends IdentityInstrumentation {
	public static Predicate<InstrumentingExecutable> loggerPredicate = (ii) -> {
		//TODO framework level logger enabler
		return false;
	};
	public static Consumer<InstrumentingExecutable> loggerConsumer = (ii) -> {
		//TODO framework level logger
		return;
	};

	@Override
	public void beforeClone(InstrumentingExecutable ii) {
		if (loggerPredicate.test(ii))
			loggerConsumer.accept(ii);
	}
	@Override
	public void afterClone(InstrumentingExecutable ii, InstrumentingExecutable result) {
		if (loggerPredicate.test(ii))
			loggerConsumer.accept(ii);
	}

	@Override
	public void beforeSetBindings(InstrumentingExecutable ii) {
		if (loggerPredicate.test(ii))
			loggerConsumer.accept(ii);
	}
	@Override
	public void afterSetBindings(InstrumentingExecutable ii) {
		if (loggerPredicate.test(ii))
			loggerConsumer.accept(ii);
	}

	@Override
	public void beforeReset(InstrumentingExecutable ii) {
		if (loggerPredicate.test(ii))
			loggerConsumer.accept(ii);
	}
	@Override
	public void afterReset(InstrumentingExecutable ii) {
		if (loggerPredicate.test(ii))
			loggerConsumer.accept(ii);
	}


	@Override
	public void beforeEvaluateNext(InstrumentingExecutable ii) {
		if (loggerPredicate.test(ii))
			loggerConsumer.accept(ii);
	}
	@Override
	public void afterEvaluateNext(InstrumentingExecutable ii, IEntity result) {
		if (loggerPredicate.test(ii))
			loggerConsumer.accept(ii);
	}

	@Override
	public void beforeEvaluateRemaining(InstrumentingExecutable ii) {
		if (loggerPredicate.test(ii))
			loggerConsumer.accept(ii);
	}
	@Override
	public void afterEvaluateRemaining(InstrumentingExecutable ii, IEntity result) {
		if (loggerPredicate.test(ii))
			loggerConsumer.accept(ii);
	}

	@Override
	public void beforeCall(InstrumentingExecutable ii) {
		if (loggerPredicate.test(ii))
			loggerConsumer.accept(ii);
	}
	@Override
	public void afterCall(InstrumentingExecutable ii) {
		if (loggerPredicate.test(ii))
			loggerConsumer.accept(ii);
	}

	@Override
	public void beforeAccept(InstrumentingExecutable ii, IExecutable executable) {
		if (loggerPredicate.test(ii))
			loggerConsumer.accept(ii);
	}
	@Override
	public void afterAccept(InstrumentingExecutable ii) {
		if (loggerPredicate.test(ii))
			loggerConsumer.accept(ii);
	}
}
