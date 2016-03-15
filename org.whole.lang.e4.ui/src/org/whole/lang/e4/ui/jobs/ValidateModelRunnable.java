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

import org.eclipse.core.resources.IResource;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.ui.di.UISynchronize;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.e4.ui.handler.HandlersBehavior;
import org.whole.lang.e4.ui.operations.E4UIDecorationManager;
import org.whole.lang.e4.ui.util.E4Utils;
import org.whole.lang.operations.IOperationProgressMonitor;
import org.whole.lang.operations.OperationCanceledException;
import org.whole.lang.ui.util.MarkerUtils;

/**
 * @author Enrico Persiani
 */
public class ValidateModelRunnable extends AbstractRunnableWithProgress {

	public ValidateModelRunnable(IEclipseContext context, IBindingManager bm, String label) {
		super(context, bm, label);
	}

	@Override
	protected boolean isTransactional() {
		return false;
	}

	@Override
	public void run(IOperationProgressMonitor pm) throws InvocationTargetException, InterruptedException {
		pm.beginTask("Validating...", IOperationProgressMonitor.TOTAL_WORK);
		try {
			UISynchronize synchronize = context.get(UISynchronize.class);
			bm.wDefValue("decorationManager", new E4UIDecorationManager(synchronize, bm));
			HandlersBehavior.validateModel(bm);
			if (MarkerUtils.findMarkers((IResource) bm.wGetValue("file"), true).length > 0)
				E4Utils.revealPart(context, "org.eclipse.ui.views.ProblemView");
		} catch (OperationCanceledException e) {
			// gracefully terminate execution
		} finally {
			pm.endTask();
		}
	}
}
