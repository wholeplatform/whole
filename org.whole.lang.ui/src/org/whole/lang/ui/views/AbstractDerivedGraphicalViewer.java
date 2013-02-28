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
package org.whole.lang.ui.views;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.commons.model.RootFragment;
import org.whole.lang.commons.model.impl.LazyContainmentRootFragmentImpl;
import org.whole.lang.commons.reflect.CommonsEntityDescriptorEnum;
import org.whole.lang.commons.reflect.CommonsFeatureDescriptorEnum;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.OperationCanceledException;
import org.whole.lang.operations.OperationProgressMonitorAdapter;
import org.whole.lang.ui.WholeUIPlugin;
import org.whole.lang.ui.editors.WholeGraphicalEditor;
import org.whole.lang.ui.editparts.IEntityPart;
import org.whole.lang.ui.util.ResourceUtils;
import org.whole.lang.ui.util.UIUtils;
import org.whole.lang.util.EntityUtils;

/**
 * @author Riccardo Solmi, Enrico Persiani
 */
public abstract class AbstractDerivedGraphicalViewer extends WholeGraphicalViewer {
	protected AbstractDerivedGraphicalView view;

	public AbstractDerivedGraphicalViewer(Composite parent, WholeEditDomain editDomain, AbstractDerivedGraphicalView view) {
		super(parent, editDomain, view);
		this.view = view;
	}

	public void selectionChanged(final IWorkbenchPart part, final ISelection selection) {
		super.selectionChanged(part, selection);
		
		if (!WholeUIPlugin.isViewVisible(view)) {
			view.setContents(null);//FIXME workaround for missing recalculate on reveal
			return;
		}
		if (!(part instanceof WholeGraphicalEditor) ||
				view.getLinkType().isNotLinked() ||
				(view.getLinkType().isLinkedToFixedEditor() && view.getLinkedEditor() != part) ||
				selection.isEmpty() || !(selection instanceof IStructuredSelection))
			return;

		final IStructuredSelection structuredSelection = (IStructuredSelection) selection;
		final Object firstSelectedElement = structuredSelection.getFirstElement();
		if (!(firstSelectedElement instanceof IEntityPart))
			return;

		final IEntityPart firstSelectedPart = (IEntityPart) firstSelectedElement;
		IEntity firstSelectedEntity0 = firstSelectedPart.getModelEntity();
		final IEntity model = EntityUtils.getCompoundRoot(firstSelectedEntity0);
		
		if (view.getLinkType().isLinkedToFixedEditorSelection()) {
			IEntity linkedFirstSelectedEntity = view.getLinkedFirstSelectedEntity();
			if (linkedFirstSelectedEntity != null && EntityUtils.getCompoundRoot(linkedFirstSelectedEntity) == model)
				firstSelectedEntity0 = linkedFirstSelectedEntity;
		}
		final IEntity firstSelectedEntity = firstSelectedEntity0;

		final WholeGraphicalViewer sourceViewer = (WholeGraphicalViewer) part.getAdapter(GraphicalViewer.class);
		final WholeEditDomain editDomain = sourceViewer.getEditDomain();
		if (editDomain != getEditDomain())
			setEditDomain(editDomain);

		Job job = new Job("Deriving...") {
			@Override
			protected IStatus run(IProgressMonitor monitor) {
				IEntity derivedModel = null; 
				try {
					derivedModel = deriveModel(model, firstSelectedEntity, editDomain, structuredSelection, monitor);
				} catch (OperationCanceledException e) {
				} catch (Throwable e) {
					//test only
					//e.printStackTrace();
				} finally {
					monitor.done();

					final IEntity contents = derivedModel;
					PlatformUI.getWorkbench().getDisplay().syncExec(new Runnable() {
						public void run() {
							view.setContents(part, contents);
						}
					});
				}

				return Status.OK_STATUS;
			}

			@Override
			public boolean belongsTo(Object family) {
				return family == view;
			}
		};
		job.setUser(false);
		job.setPriority(Job.DECORATE);
		job.setRule(view);
		Job.getJobManager().cancel(view);
		job.schedule();
	}

	protected IBindingManager defineBindings(IEntity selfEntity, WholeEditDomain editDomain, IStructuredSelection structuredSelection, IProgressMonitor monitor) {
		IBindingManager bm = BindingManagerFactory.instance.createBindingManager();
		ResourceUtils.defineResourceBindings(bm, editDomain.getEditorPart().getEditorInput());
		UIUtils.defSelectedEntities(bm, UIUtils.getSelectedEntityParts(structuredSelection));
		bm.wDef("self", selfEntity);
		if (monitor != null)
			bm.wDefValue("progressMonitor", new OperationProgressMonitorAdapter(monitor));
		bm.wEnterScope();
		return bm;
	}

	protected abstract IEntity deriveModel(IEntity model, IEntity firstSelectedEntity, WholeEditDomain editDomain, IStructuredSelection structuredSelection, IProgressMonitor monitor);

	public static class GetContentsRunnable implements Runnable {
		protected String viewId;
		protected WholeGraphicalView view;
		public IEntity contextModel;

		public GetContentsRunnable(String viewId) {
			this.viewId = viewId;
		}
		public GetContentsRunnable(WholeGraphicalView view) {
			this.view = view;
		}

		public void run() {
			if (view == null)
				view = (WholeGraphicalView) WholeUIPlugin.revealView(viewId);
			contextModel = view.getContents();
		}
	}

	@Override
	protected RootFragment wrapContents(IEntity entity) {
		if (Matcher.match(CommonsEntityDescriptorEnum.RootFragment, entity))
			entity = entity.wGet(CommonsFeatureDescriptorEnum.rootEntity);
		return new LazyContainmentRootFragmentImpl(entity);
	}

}
