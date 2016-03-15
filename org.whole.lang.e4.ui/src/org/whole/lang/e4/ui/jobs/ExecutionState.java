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

import java.util.Set;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.OperationCanceledException;
import org.whole.lang.ui.util.SuspensionKind;

/**
 * @author Enrico Persiani
 */
public class ExecutionState {
	protected SuspensionKind suspensionKind;
	protected Throwable throwable;
	protected IEntity sourceEntity;
	protected IBindingManager bindings;
	protected Set<String> includeNames;
	protected CyclicBarrier barrier;

	public ExecutionState(SuspensionKind suspensionKind, Throwable throwable, 
			IEntity sourceEntity, IBindingManager bindings, Set<String> includeNames) {
		this.suspensionKind = suspensionKind;
		this.throwable = throwable;
		this.sourceEntity = sourceEntity;
		this.bindings = bindings;
		this.includeNames = includeNames;
		this.barrier = new CyclicBarrier(2);
	}

	public SuspensionKind getSuspensionKind() {
		return suspensionKind;
	}

	public IEntity getSourceEntity() {
		return sourceEntity;
	}

	public Throwable getThrowable() {
		return throwable;
	}
	
	public ExecutionState pause() {
		try {
			barrier.await();
		} catch (InterruptedException e) {
			throw new IllegalStateException(e);
		} catch (BrokenBarrierException e) {	
			// execution terminated
			if (getSuspensionKind().isBreak())
				throw new OperationCanceledException();
		}
		return this;
	}

	public ExecutionState resume() {
		try {
			barrier.await();
		} catch (Exception e) { 
		}
		return this;
	}

	public ExecutionState terminate() {
		barrier.reset();
		return this;
	}

	protected IEntity variablesModel;
	public IEntity getVariablesModel() {
		if (variablesModel == null)
			variablesModel = BindingManagerFactory.instance.createVariablesViewModel(bindings, includeNames);
		return variablesModel;
	}
}
