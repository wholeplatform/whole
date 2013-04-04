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

import java.util.List;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.ui.JavaElementLabelProvider;
import org.eclipse.jdt.ui.StandardJavaElementContentProvider;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ElementTreeSelectionDialog;
import org.eclipse.ui.model.WorkbenchContentProvider;
import org.eclipse.ui.model.WorkbenchLabelProvider;
import org.whole.lang.artifacts.model.IArtifactsEntity;
import org.whole.lang.artifacts.reflect.ArtifactsEntityDescriptorEnum;
import org.whole.lang.artifacts.reflect.ArtifactsFeatureDescriptorEnum;
import org.whole.lang.artifacts.util.ArtifactsWorkspaceUtils;
import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.comparators.IdentityIteratorComparator;
import org.whole.lang.iterators.IteratorFactory;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.IEntity;
import org.whole.lang.model.NullEntity;
import org.whole.lang.ui.WholeUIPlugin;
import org.whole.lang.ui.commands.ModelTransactionCommand;
import org.whole.lang.ui.editparts.IEntityPart;
import org.whole.lang.ui.util.UIUtils;
import org.whole.lang.util.EntityUtils;
import org.whole.lang.util.IEntityTransformer;

/**
 * @author Enrico Persiani
 */
public class MergeResourcesAction extends AbstractLazySelectionAction  implements IEntityTransformer {
	protected static final String SELECT_RESOURCE_MSG = "Select a resource";
	protected static final ImageDescriptor SELECT_RESOURCE_ICON = WholeUIPlugin.getImageDescriptor("icons/actions/select_persistence.gif");
	protected static final IEnablerPredicate TRUE = EnablerPredicateFactory.instance.alwaysTrue();

	protected IArtifactsEntity entity;

	public MergeResourcesAction() {
		super(UIUtils.getActivePart());
		setText("Add Artifacts...");
		setImageDescriptor(SELECT_RESOURCE_ICON);
	}

	@Override
	protected boolean calculateEnabled() {
		List<?> selectedObjects = getSelectedObjects();
		return selectedObjects.size() == 1 && selectedObjects.get(0) instanceof IEntityPart;
	}

	@Override
	public void run() {
		IEntityPart selectedPart = (IEntityPart) getSelectedObjects().get(0);
		IEntity selectedEntity = selectedPart.getModelEntity();

		Shell shell = getWorkbenchPart().getSite().getShell();
		IEntity result = performWorkspaceResourceSelection(shell, selectedEntity);
		if (!EntityUtils.isNull(result)) {
			ModelTransactionCommand mtc = new ModelTransactionCommand(selectedEntity);
			try {
				mtc.setLabel("add Artifacts");
				mtc.begin();
				EntityUtils.merge(selectedEntity, result, createEntityComparator(), false);
				mtc.commit();
				if (mtc.canUndo())
					execute(mtc);
			} catch (RuntimeException e) {
				mtc.rollback();
				throw e;
			}
			
		}
	}

	protected IEntity performWorkspaceResourceSelection(Shell shell, IEntity entity) {
		IResource input;
		if (Matcher.matchImpl(ArtifactsEntityDescriptorEnum.Workspace, entity.wGetParent()))
			input = ResourcesPlugin.getWorkspace().getRoot();
		else {
			IBindingManager bm = BindingManagerFactory.instance.createBindingManager();
			ArtifactsWorkspaceUtils.bindPath(entity.wGetParent(), bm, false);
			input = (IResource) (bm.wIsSet("folder") ? bm.wGetValue("folder") : bm.wGetValue("project"));
		}
		IJavaElement javaInput = JavaCore.create(input);

		LabelProvider labelProvider = javaInput != null ? new JavaElementLabelProvider() : new WorkbenchLabelProvider();
		ITreeContentProvider contentProvider = javaInput != null ? new StandardJavaElementContentProvider() : new WorkbenchContentProvider();

		ElementTreeSelectionDialog dialog = new ElementTreeSelectionDialog(shell, labelProvider, contentProvider);
		dialog.setInput(javaInput != null ? javaInput : input);
		dialog.setTitle(SELECT_RESOURCE_MSG);
		dialog.setMessage("Choose a resource");

		if (javaInput != null)
			dialog.addFilter(new ViewerFilter() {
				public boolean select(Viewer viewer, Object parentElement, Object element) {
					try {
						return !(element instanceof IPackageFragmentRoot) ||
								((IPackageFragmentRoot) element).getKind() == IPackageFragmentRoot.K_SOURCE;
					} catch (Exception e) {
						return false;
					}
				}
			});

		if (dialog.open() != IDialogConstants.OK_ID)
			return NullEntity.instance;

		IEntity result = null;
		for (Object resource : dialog.getResult()) {
			IEntity artifactsPath;
			if (resource instanceof IJavaElement) {
				IJavaElement toJavaElement = (IJavaElement) resource;
				artifactsPath = ArtifactsWorkspaceUtils.toArtifactsPath(javaInput, toJavaElement);
			} else {
				IResource toResource = (IResource) resource;
				IJavaElement parentJavaElement = JavaCore.create(toResource.getParent());
				if (javaInput == null || parentJavaElement == null)
					artifactsPath = ArtifactsWorkspaceUtils.toArtifactsPath(input, toResource);
				else
					artifactsPath = ArtifactsWorkspaceUtils.toArtifactsPath(javaInput, toResource);
			}
			result = result == null ? artifactsPath : EntityUtils.merge(result, artifactsPath, createEntityComparator(), false); 
		}
		int index = Matcher.match(ArtifactsEntityDescriptorEnum.Workspace, result) ?
				result.wIndexOf(ArtifactsFeatureDescriptorEnum.projects) : result.wIndexOf(ArtifactsFeatureDescriptorEnum.artifacts);

		IEntity tree = result.wGet(index);
		result.wRemove(index);
		return tree;
	}

	protected IdentityIteratorComparator<IEntity> createEntityComparator() {
		return new IdentityIteratorComparator<IEntity>(
				IteratorFactory.featureByNameIterator(ArtifactsFeatureDescriptorEnum.name));
	}

	@Override
	public void transform(IEntity oldEntity, IEntity newEntity) {
	}
}
