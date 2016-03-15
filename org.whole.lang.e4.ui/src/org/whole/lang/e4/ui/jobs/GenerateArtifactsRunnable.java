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

import java.lang.reflect.InvocationTargetException;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.e4.ui.handler.HandlersBehavior;
import org.whole.lang.operations.IOperationProgressMonitor;
import org.whole.lang.operations.OperationCanceledException;

/**
 * @author Enrico Persiani
 */
public class GenerateArtifactsRunnable extends AbstractRunnableWithProgress {

	public GenerateArtifactsRunnable(IEclipseContext context, IBindingManager bm, String label) {
		super(context, bm, label);
	}

	@Override
	protected boolean isTransactional() {
		return false;
	}

	@Override
	public void run(IOperationProgressMonitor pm) throws InvocationTargetException, InterruptedException {
		pm.beginTask("Generating...", IOperationProgressMonitor.TOTAL_WORK);
		try {
			HandlersBehavior.generateArtifacts(bm);
		} catch (OperationCanceledException e) {
			// gracefully terminate execution
		} finally {
			pm.endTask();
		}
	}
}
