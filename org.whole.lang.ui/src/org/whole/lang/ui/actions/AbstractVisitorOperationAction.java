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
package org.whole.lang.ui.actions;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorActionDelegate;
import org.eclipse.ui.IEditorPart;
import org.whole.lang.operations.OperationCanceledException;
import org.whole.lang.ui.WholeUIPlugin;
import org.whole.lang.ui.editors.WholeGraphicalEditor;

/**
 * @author Enrico Persiani
 */
public abstract class AbstractVisitorOperationAction implements IEditorActionDelegate, IRunnableWithProgress {
	private WholeGraphicalEditor editor;
	private String operationId;

	public AbstractVisitorOperationAction(String operationId) {
		this.operationId = operationId;
	}

	public String getOperationId() {
		return operationId;
	}

	public WholeGraphicalEditor getActiveEditor() {
		return editor;
	}
	public void setActiveEditor(IAction action, IEditorPart targetEditor) {
		if (targetEditor instanceof WholeGraphicalEditor)
			editor = (WholeGraphicalEditor) targetEditor;
		else
			editor = null;
	}

	public GraphicalViewer getGraphicalViewer() {
		return (GraphicalViewer) getActiveEditor().getAdapter(GraphicalViewer.class);
	}

	public void selectionChanged(IAction action, ISelection selection) {
		action.setEnabled(calculateEnabled());
	}

	protected boolean calculateEnabled() {
		return editor != null ? editor.getRootLanguageKit().hasVisitor(operationId) : false;
	}

	public void run(IAction action) {
		OperationJob job = createOperationJob();
		job.setUser(true);
		job.setPriority(Job.INTERACTIVE);
		job.schedule();
	}

	protected OperationJob createOperationJob() {
		return new OperationJob(operationId);
	}

	protected void showInformationDialog(final String title, final String message) {
		final Shell shell = getActiveEditor().getSite().getShell();
		shell.getDisplay().syncExec(new Runnable() {
			public void run() {
				MessageDialog.openInformation(shell, title, message);
			}
		});
	}

	public class OperationJob extends Job {

		public OperationJob(String name) {
			super(name);
		}

		@Override
		public IStatus run(IProgressMonitor monitor) {
			try {
				AbstractVisitorOperationAction.this.run(monitor);
			} catch (OperationCanceledException e) {
				// do nothing
			} catch (Throwable e) {
				return new Status(Status.ERROR, WholeUIPlugin.PLUGIN_ID, 0, "An exception occurred while executing the action "+getName(), e);
			} finally {
				monitor.done();
			}
			return Status.OK_STATUS;
		}
	}
}
