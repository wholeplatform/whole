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

import org.whole.lang.iterators.InstrumentingIterator;
import org.whole.lang.model.IEntity;

/**
 * @author Riccardo Solmi
 */
public class IdentityInstrumentation implements IEntityIteratorInstrumentation {
	public static final IEntityIteratorInstrumentation instance = new IdentityInstrumentation();

	@Override
	public void beforeClone(InstrumentingIterator<?> ii) {
	}
	@Override
	public void afterClone(InstrumentingIterator<?> ii, InstrumentingIterator<?> result) {
	}

	@Override
	public void beforeSetBindings(InstrumentingIterator<?> ii) {
	}
	@Override
	public void afterSetBindings(InstrumentingIterator<?> ii) {
	}

	@Override
	public void beforeReset(InstrumentingIterator<?> ii) {
	}
	@Override
	public void afterReset(InstrumentingIterator<?> ii) {
	}

	@Override
	public void beforeHasNext(InstrumentingIterator<?> ii) {
	}
	@Override
	public void afterHasNext(InstrumentingIterator<?> ii, boolean result) {
	}

	@Override
	public void beforeLookahead(InstrumentingIterator<?> ii) {
	}
	@Override
	public void afterLookahead(InstrumentingIterator<?> ii, IEntity result) {
	}

	@Override
	public void beforeNext(InstrumentingIterator<?> ii) {
	}
	@Override
	public void afterNext(InstrumentingIterator<?> ii, IEntity result) {
	}
}
