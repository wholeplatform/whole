/**
 * Copyright 2004-2013 Riccardo Solmi. All rights reserved.
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
import org.eclipse.e4.ui.di.UISynchronize;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.e4.ui.viewers.IEntityPartViewer;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.IOperationProgressMonitor;
import org.whole.lang.operations.OperationCanceledException;
import org.whole.lang.util.BehaviorUtils;

/**
 * @author Enrico Persiani
 */
public class DeriveModelRunnable extends AbstractRunnableWithProgress {
	protected String functionUri;

	public DeriveModelRunnable(IEclipseContext context, IBindingManager bm, String label, String functionUri) {
		super(context, bm, label, false);
		this.functionUri = functionUri;
	}

	@Override
	public void run(IOperationProgressMonitor pm) throws InvocationTargetException, InterruptedException {
		pm.beginTask("Deriving...", IOperationProgressMonitor.TOTAL_WORK);
		try {
			final IEntity result = BehaviorUtils.apply(functionUri, bm.wGet("self"), bm);
			if (result != null) {
				context.get(UISynchronize.class).asyncExec(new Runnable() {
					public void run() {
						updateUI(result);
					}
				});
			}
		} catch (OperationCanceledException e) {
			// gracefully terminate execution
		} finally {
			pm.endTask();
		}
	}
	
	protected void updateUI(IEntity result) {
		context.get(IEntityPartViewer.class).setContents(result);
	}
}
