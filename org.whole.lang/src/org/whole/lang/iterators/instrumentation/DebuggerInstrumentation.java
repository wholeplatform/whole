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

import java.util.function.Consumer;
import java.util.function.Predicate;

import org.whole.lang.iterators.InstrumentingIterator;

/**
 * @author Riccardo Solmi
 */
public class DebuggerInstrumentation extends IdentityInstrumentation {
	public static final IEntityIteratorInstrumentation instance = new DebuggerInstrumentation();

	public static boolean evaluatingPredicate = false;
	public static Predicate<InstrumentingIterator<?>> breakpointPredicate = (ii) -> {
		//TODO replace with a framework level predicate
		return false;
	};
	public static Consumer<InstrumentingIterator<?>> breakpointConsumer = (ii) -> {
		//TODO place a breakpoint here to stop at the framework level
		return;
	};

	@Override
	public void afterClone(InstrumentingIterator<?> ii, InstrumentingIterator<?> result) {
	}

	@Override
	public void beforeHasNext(InstrumentingIterator<?> ii) {
//		if (breakpointPredicate.test(ii))
//			breakpointConsumer.accept(ii);
	}

	@Override
	public void beforeLookahead(InstrumentingIterator<?> ii) {
//		if (breakpointPredicate.test(ii))
//			breakpointConsumer.accept(ii);
	}

	@Override
	public void beforeNext(InstrumentingIterator<?> ii) {
		if (!evaluatingPredicate && breakpointPredicate.test(ii))
			breakpointConsumer.accept(ii);
	}
}
