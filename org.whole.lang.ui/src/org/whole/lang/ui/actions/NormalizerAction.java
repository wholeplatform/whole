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
import org.eclipse.core.runtime.IStatus;
import org.eclipse.gef.commands.CommandStack;
import org.eclipse.ui.PlatformUI;
import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.IOperationProgressMonitor;
import org.whole.lang.operations.NormalizerOperation;
import org.whole.lang.operations.OperationCanceledException;
import org.whole.lang.operations.OperationProgressMonitorAdapter;
import org.whole.lang.ui.commands.ModelTransactionCommand;
import org.whole.lang.ui.editors.WholeGraphicalEditor;
import org.whole.lang.ui.util.AnimableRunnable;
import org.whole.lang.ui.util.ResourceUtils;
import org.whole.lang.ui.views.WholeGraphicalViewer;

/**
 * @author Enrico Persiani
 */
public class NormalizerAction extends AbstractVisitorOperationAction {
	protected ModelTransactionCommand normalizeCommand;

	public NormalizerAction() {
		super(NormalizerOperation.ID);
	}

	public void run(final IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
		monitor.beginTask("Normalizing...", IOperationProgressMonitor.TOTAL_WORK);
		
		final IBindingManager args = BindingManagerFactory.instance.createArguments();
		args.wDefValue("progressMonitor", new OperationProgressMonitorAdapter(monitor));
		ResourceUtils.defineResourceBindings(args, getActiveEditor().getEditorInput());

		IEntity rootFragment = (IEntity) getGraphicalViewer().getContents().getModel();
		final IEntity entity = rootFragment.wGetRoot();

		final boolean enableAnimation = AnimableRunnable.enableAnimation(false);
		getGraphicalViewer().setProperty(WholeGraphicalViewer.PROPERTY_DELAY_UPDATES, true);
		try {
			normalizeCommand.setModel(entity);
			normalizeCommand.begin();
			NormalizerOperation.normalize(entity, args);
			normalizeCommand.commit();
		} catch (OperationCanceledException e) {
			normalizeCommand.rollback();
		} catch (RuntimeException e) {
			normalizeCommand.rollback();
			throw e;
		} finally {
			getGraphicalViewer().setProperty(WholeGraphicalViewer.PROPERTY_DELAY_UPDATES, false);
			AnimableRunnable.enableAnimation(enableAnimation);
			monitor.done();
		}
	}

	@Override
	protected OperationJob createOperationJob() {
		return new OperationJob(getOperationId()) {
			@Override
			public IStatus run(IProgressMonitor monitor) {
				normalizeCommand = new ModelTransactionCommand();
				IStatus status = super.run(monitor);
				if (status.isOK() && normalizeCommand.canUndo()) {
					PlatformUI.getWorkbench().getDisplay().syncExec(new Runnable() {
						public void run() {
							WholeGraphicalEditor editorPart = getActiveEditor();
							CommandStack commandStack = (CommandStack) editorPart.getAdapter(CommandStack.class);
							commandStack.execute(normalizeCommand);
						}
					});
				}
				return status;
			}
		};
	}
}
