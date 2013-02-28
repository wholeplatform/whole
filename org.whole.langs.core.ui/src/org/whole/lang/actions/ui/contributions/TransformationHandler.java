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
package org.whole.lang.actions.ui.contributions;

import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.common.NotDefinedException;
import org.eclipse.core.expressions.IEvaluationContext;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.commands.CommandStack;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.ISources;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.console.IOConsole;
import org.eclipse.ui.console.IOConsoleOutputStream;
import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.codebase.IFilePersistenceProvider;
import org.whole.lang.codebase.IPersistenceKit;
import org.whole.lang.commons.factories.CommonsEntityFactory;
import org.whole.lang.commons.reflect.CommonsEntityDescriptorEnum;
import org.whole.lang.factories.GenericEntityFactory;
import org.whole.lang.iterators.IEntityIterator;
import org.whole.lang.misc.factories.MiscEntityFactory;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.IOperationProgressMonitor;
import org.whole.lang.operations.OperationCanceledException;
import org.whole.lang.operations.OperationProgressMonitorAdapter;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.ui.WholeUIPlugin;
import org.whole.lang.ui.commands.ModelTransactionCommand;
import org.whole.lang.ui.console.WholeConsoleFactory;
import org.whole.lang.ui.editparts.IEntityPart;
import org.whole.lang.ui.menu.WholeMenu;
import org.whole.lang.ui.util.AnimableRunnable;
import org.whole.lang.ui.util.ResourceUtils;
import org.whole.lang.ui.util.UIUtils;
import org.whole.lang.ui.views.ResultsView;
import org.whole.lang.ui.views.WholeGraphicalViewer;
import org.whole.lang.util.BehaviorUtils;
import org.whole.lang.util.EntityUtils;

/**
 * @author Enrico Persiani, Riccardo Solmi
 */
public class TransformationHandler extends AbstractHandler implements IRunnableWithProgress {
	protected WholeMenu menu;
	protected IEntity predicate;
	protected IEntity transformation;
	protected IWorkbenchWindow workbenchWindow;
	protected ISelection selection;
	protected IEditorPart editorPart;
	protected String actionName;

	public TransformationHandler(IEntity mappingQuery) {
		this(null, mappingQuery);
	}
	public TransformationHandler(IEntity predicate, IEntity mappingQuery) {
		this(WholeMenu.TRANSLATE, predicate, mappingQuery);
	}
	public TransformationHandler(WholeMenu menu, IEntity predicate, IEntity transformation) {
		this.menu = menu;
		this.predicate = predicate;
		this.transformation = transformation;
	}

	public Object execute(ExecutionEvent event) throws ExecutionException {

		Object appContextObj = event.getApplicationContext();
		if (appContextObj instanceof IEvaluationContext) {
			IEvaluationContext appContext = (IEvaluationContext) appContextObj;
			workbenchWindow = (IWorkbenchWindow) appContext.getVariable(ISources.ACTIVE_WORKBENCH_WINDOW_NAME);
			selection = (ISelection) appContext.getVariable(ISources.ACTIVE_CURRENT_SELECTION_NAME);
			editorPart = (IEditorPart) appContext.getVariable(ISources.ACTIVE_EDITOR_NAME);
			try {
				actionName = event.getCommand().getDescription();
			} catch (NotDefinedException e) {
				// should be always defined
				actionName = "";
			}
		}

		TransformationJob job = createTransformationJob();
		job.setUser(true);
		job.setPriority(Job.INTERACTIVE);
		job.schedule();
		return null;
	}

	protected TransformationJob createTransformationJob() {
		return new TransformationJob("Executing "+actionName+" action...");
	}

	public void run(IProgressMonitor progressMonitor) throws InvocationTargetException, InterruptedException {
		progressMonitor.beginTask("Generating...", IOperationProgressMonitor.TOTAL_WORK);

		final boolean isAnalyzing = WholeMenu.ANALYZE.equals(menu);
		final IBindingManager bm = createBindings();

		IEntity model;
		try {
			model = isAnalyzing ? EntityUtils.clone(getModel()) : getModel();
		} catch (Exception e) {
			throw new InvocationTargetException(e);
		}

		if (isAnalyzing) {
			CommonsEntityFactory.instance.createRootFragment(
					model.wGetAdapter(CommonsEntityDescriptorEnum.Any));
			ReflectionFactory.getHistoryManager(model).setHistoryEnabled(true);
		}

		final IOperationProgressMonitor operationProgressMonitor = new OperationProgressMonitorAdapter(progressMonitor);
		bm.wDefValue("progressMonitor", operationProgressMonitor);

		operationProgressMonitor.beginTask("test predicate", 10, IOperationProgressMonitor.TOTAL_WORK);
		bm.wDef("self", model);
		if (predicate != null && !BehaviorUtils.evaluatePredicate(predicate, 0, bm))
			throw new IllegalArgumentException("The action cannot be applied to the current selection");
		operationProgressMonitor.endTask();

		if (isAnalyzing) {
			IEntity tuple = bm.wGet("selectedEntities");
			int size = tuple.wSize();
			for (int i = 0; i < size; i++)
				tuple.wSet(i, EntityUtils.mapEntity(tuple.wGet(i), model));
			bm.wSet("primarySelectedEntity", EntityUtils.mapEntity(bm.wGet("primarySelectedEntity"), model));
		}

		final ModelTransactionCommand transformCommand = new ModelTransactionCommand();
		final boolean enableAnimation = AnimableRunnable.enableAnimation(false);
		final IEntity resultsModel = MiscEntityFactory.instance.createMisc();
		try {
			if (!isAnalyzing && isOpened())
				((GraphicalViewer) editorPart.getAdapter(GraphicalViewer.class)).setProperty(WholeGraphicalViewer.PROPERTY_DELAY_UPDATES, true);

			operationProgressMonitor.beginTask("executing action", 90, IOperationProgressMonitor.TOTAL_WORK);
			transformCommand.setModel(model);
			transformCommand.begin();
			if (bm.wGet("self") != model)//TODO test
        		bm.wDef("self", model);

			IEntityIterator<?> iterator = BehaviorUtils.lazyEvaluate(transformation, 0, bm);
			if (bm.wGet("self") != model)
				bm.wDef("self", model);
			iterator.reset(model);
			for (IEntity result : iterator) {
				if (isAnalyzing)
					resultsModel.wAdd(GenericEntityFactory.instance.create(
							CommonsEntityDescriptorEnum.StageUpFragment,
							//CommonsEntityFactory.instance.createStageUpFragment(
							EntityUtils.clone(result)));//TODO substitute with a no containment fragment
				operationProgressMonitor.worked(1);
			}
			transformCommand.commit();
		} catch (OperationCanceledException e) {
			transformCommand.rollback();
		} catch (RuntimeException e) {
			transformCommand.rollback();
			throw e;
		} finally {
			operationProgressMonitor.endTask();
			if (!isAnalyzing && isOpened())
				((GraphicalViewer) editorPart.getAdapter(GraphicalViewer.class)).setProperty(WholeGraphicalViewer.PROPERTY_DELAY_UPDATES, false);
			AnimableRunnable.enableAnimation(enableAnimation);

			progressMonitor.done();
		}

		PlatformUI.getWorkbench().getDisplay().asyncExec(new Runnable() {
			public void run() {
				if (isAnalyzing) {										
					ResultsView resultsView = (ResultsView) WholeUIPlugin.revealView(ResultsView.class.getName());
					resultsView.setContents(resultsModel);
				} else if (isOpened() && transformCommand.canUndo()) {
					CommandStack commandStack = (CommandStack) editorPart.getAdapter(CommandStack.class);
					commandStack.execute(transformCommand);
				}
			}
		});
	}

	protected boolean isOpened() {
		return getFirstSelectedEntityPart() != null;
	}

	protected IEntity getModel() throws Exception {
		IEntityPart entityPart = getFirstSelectedEntityPart();
		if (entityPart != null)
			return EntityUtils.getCompoundRoot(entityPart.getModelEntity());
		else
			return readModel(getFile());
	}

	protected IEntityPart getFirstSelectedEntityPart() {
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection structuredSelection = (IStructuredSelection) selection;
			Object firstElement = structuredSelection.getFirstElement();
			if (firstElement instanceof IEntityPart)
				return (IEntityPart) firstElement;
		}
		return null;
	}

	protected IBindingManager createBindings() {
		final IBindingManager bm = BindingManagerFactory.instance.createArguments();
		
		IOConsole ioConsole = WholeConsoleFactory.getIOConsole();
		IOConsoleOutputStream out = ioConsole.newOutputStream();
		out.setActivateOnWrite(true);
		bm.wDefValue("writer", new OutputStreamWriter(out));
		bm.wDefValue("reader",new InputStreamReader(ioConsole.getInputStream()));

		if (isOpened())
			ResourceUtils.defineResourceBindings(bm, editorPart.getEditorInput());
		else
			ResourceUtils.defineResourceBindings(bm, getFile());
		UIUtils.defSelectedEntities(bm, selection);
		return bm;
	}

	protected IFile getFile() {
		IFile file = null;
		if (selection instanceof IStructuredSelection && !selection.isEmpty())
			file = ResourceUtils.adaptToFile(((IStructuredSelection) selection).getFirstElement());
		if (file == null)
			file = ResourceUtils.getFile(editorPart.getEditorInput());
		return file;
	}

	protected IEntity readModel(IFile file) throws Exception {
		IPersistenceKit pk;
		try {
			pk = ReflectionFactory.getPersistenceKit("org.whole.lang.java.codebase.JavaSourcePersistenceKit");
			return pk.readModel(new IFilePersistenceProvider(file));
		} catch (Exception e1) {
			try {
				pk = ReflectionFactory.getPersistenceKit("org.whole.lang.text.codebase.TextSourcePersistenceKit");
				return pk.readModel(new IFilePersistenceProvider(file));
			} catch (Exception e2) {
				return CommonsEntityFactory.instance.createResolver();
			}
		}
	}

	public class TransformationJob extends Job {

		public TransformationJob(String name) {
			super(name);
		}

		@Override
		public IStatus run(IProgressMonitor monitor) {
			try {
				TransformationHandler.this.run(monitor);
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
