/**
 * Copyright 2004-2012 Riccardo Solmi. All rights reserved.
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
package org.whole.lang.ui.actions;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.swt.widgets.Shell;
import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.GraphicalDecorationManager;
import org.whole.lang.operations.IOperationProgressMonitor;
import org.whole.lang.operations.OperationCanceledException;
import org.whole.lang.operations.OperationProgressMonitorAdapter;
import org.whole.lang.operations.ValidatorOperation;
import org.whole.lang.ui.WholeUIPlugin;
import org.whole.lang.ui.util.MarkerUtils;
import org.whole.lang.ui.util.ResourceUtils;

/**
 * @author Riccardo Solmi, Enrico Persiani
 */
public class ValidatorAction extends AbstractVisitorOperationAction {
	public ValidatorAction() {
		super(ValidatorOperation.ID);
	}

	public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
		monitor.beginTask("Validating...", IOperationProgressMonitor.TOTAL_WORK);
		
		IBindingManager args = BindingManagerFactory.instance.createArguments();
		args.wDefValue("progressMonitor", new OperationProgressMonitorAdapter(monitor));
		ResourceUtils.defineResourceBindings(args, getActiveEditor().getEditorInput());

		GraphicalViewer viewer = getGraphicalViewer();
		IEntity rootFragment = (IEntity) viewer.getContents().getModel();
		IEntity entity = rootFragment.wGetRoot();

		try {
			ValidatorOperation.validate(entity, args, new GraphicalDecorationManager(getActiveEditor(), viewer, monitor));
		} catch (OperationCanceledException e) {
			showInformationDialog("Validator", "Execution cancelled");
		} finally {
			monitor.done();
		}

		if (MarkerUtils.findMarkers(ResourceUtils.getFile(getActiveEditor().getEditorInput()), true).length > 0) {
			final Shell shell = getActiveEditor().getSite().getShell();
			shell.getDisplay().syncExec(new Runnable() {
				public void run() {
					WholeUIPlugin.revealView("org.eclipse.ui.views.ProblemView");
				}
			});
		}
	}
}
