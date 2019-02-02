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

import org.whole.lang.executables.InstrumentingExecutable;
import org.whole.lang.model.IEntity;

/**
 * @author Riccardo Solmi
 */
public interface IExecutableInstrumentation {
	public void beforeClone(InstrumentingExecutable ii);
	public void afterClone(InstrumentingExecutable ii, InstrumentingExecutable result);

	public void beforeSetBindings(InstrumentingExecutable ii);
	public void afterSetBindings(InstrumentingExecutable ii);

	public void beforeReset(InstrumentingExecutable ii);
	public void afterReset(InstrumentingExecutable ii);

	public void beforeEvaluateNext(InstrumentingExecutable ii);
	public void afterEvaluateNext(InstrumentingExecutable ii, IEntity result);

	public void beforeEvaluateRemaining(InstrumentingExecutable ii);
	public void afterEvaluateRemaining(InstrumentingExecutable ii, IEntity result);

	public void beforeCallNext(InstrumentingExecutable ii);
	public void afterCallNext(InstrumentingExecutable ii);

	public void beforeCallRemaining(InstrumentingExecutable ii);
	public void afterCallRemaining(InstrumentingExecutable ii);

	public void beforeDoNext(InstrumentingExecutable ii, IEntity result);
	public void afterDoNext(InstrumentingExecutable ii);

	public void beforeDoEnd(InstrumentingExecutable ii);
	public void afterDoEnd(InstrumentingExecutable ii);
}
