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
package org.whole.lang.e4.ui.jobs;

import java.util.function.Supplier;

/**
 * @author Enrico Persiani
 */
public class RunnableWithResult<T> implements Runnable, Supplier<T> {
	private Supplier<T> supplier;
	protected T value;

	protected RunnableWithResult(Supplier<T> supplier) {
		this.supplier = supplier;
		this.value = null;
	}

	@Override
	public T get() {
		return value;
	}

	@Override
	public void run() {
		value = supplier.get();
	}
	
	public static <T> RunnableWithResult<T> create(Supplier<T> supplier) {
		return new RunnableWithResult<>(supplier);
	}
}
