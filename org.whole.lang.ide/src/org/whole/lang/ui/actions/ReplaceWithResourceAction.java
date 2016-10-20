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
package org.whole.lang.ui.actions;

import java.io.File;
import java.net.URL;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;
import org.eclipse.gef.commands.CommandStack;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ElementTreeSelectionDialog;
import org.eclipse.ui.model.WorkbenchContentProvider;
import org.eclipse.ui.model.WorkbenchLabelProvider;
import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.e4.ui.actions.AbstractE4Action;
import org.whole.lang.e4.ui.handler.HandlersBehavior;
import org.whole.lang.factories.GenericEntityFactory;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.ui.commands.ModelTransactionCommand;
import org.whole.lang.ui.dialogs.SelectResourceAsDialog;
import org.whole.lang.ui.util.ResourceUtils;
import org.whole.lang.ui.util.UIUtils;
import org.whole.lang.ui.viewers.IEntityPartViewer;
import org.whole.lang.util.StringUtils;

/**
 * @author Enrico Persiani, Riccardo Solmi
 */
public abstract class ReplaceWithResourceAction extends AbstractE4Action {
	protected static final String SELECT_RESOURCE_MSG = "Select a resource";
	protected static final ImageDescriptor SELECT_RESOURCE_ICON = UIUtils.getImageDescriptor("icons/actions/select_persistence.gif");

	public static enum ResourceKind {
		WORKSPACE, FILE_SYSTEM, CLASSPATH, URL
	}

	protected EntityDescriptor<?> ed;
	protected String path;

	public ReplaceWithResourceAction(IEclipseContext context, EntityDescriptor<?> ed, String path, String text) {
		super(context, text, SELECT_RESOURCE_ICON);
		this.ed = ed;
		this.path = path;
	}

	@Override
	public void update() {
		ESelectionService selectionService = getContext().get(ESelectionService.class);
		if (selectionService.getSelection() instanceof IBindingManager) {
			IBindingManager bm = (IBindingManager) selectionService.getSelection();
			setEnabled(HandlersBehavior.isValidFocusEntityPart(bm));
		} else
			setEnabled(false);
	}

	protected abstract boolean isLoading(IEntity selectedEntity);
	protected abstract ResourceKind getResourceKind(IEntity selectedEntity);

	@Override
	public void run() {
		ESelectionService selectionService = getContext().get(ESelectionService.class);
		IBindingManager bm = (IBindingManager) selectionService.getSelection();
		IEntity focusEntity = bm.wGet("focusEntity");

		ResourceKind resourceKind = getResourceKind(focusEntity);
		Shell shell = (Shell) getContext().get(IServiceConstants.ACTIVE_SHELL);

		boolean selectionPerformed = false;
		switch (resourceKind) {
		case WORKSPACE:
			selectionPerformed = performWorkspaceResourceSelection(shell, focusEntity);
			break;
		case CLASSPATH:
			selectionPerformed = performClasspathResourceSelection(shell, focusEntity);
			break;
		case FILE_SYSTEM:
		case URL:
			selectionPerformed = performFilesystemSelection(shell, focusEntity,  resourceKind == ResourceKind.URL);
			break;
		}

		if (!selectionPerformed)
			return;

		IEntity replacement = GenericEntityFactory.instance.create(ed, path);

		ModelTransactionCommand mtc = new ModelTransactionCommand(focusEntity);
		try {
			mtc.setLabel("replace with class name");
			mtc.begin();
			performReplace(focusEntity, replacement);
			mtc.commit();
			if (mtc.canUndo()) {
				IEntityPartViewer viewer = (IEntityPartViewer) bm.wGetValue("viewer");
				CommandStack commandStack = viewer.getEditDomain().getCommandStack();
				commandStack.execute(mtc);
			}
		} catch (RuntimeException e) {
			mtc.rollbackIfNeeded();
			throw e;
		}
	}

	protected void performReplace(IEntity primarySelectedEntity, IEntity replacement) {
		primarySelectedEntity.wGetParent().wSet(primarySelectedEntity, replacement);
	}

	protected boolean performFilesystemSelection(Shell shell, IEntity entity, boolean isURL) {
		int style = isLoading(entity) ?  SWT.OPEN : SWT.SAVE;
		FileDialog dialog = new FileDialog(shell, style);
		dialog.setText(SELECT_RESOURCE_MSG);

		File file = isURL ? URLToFile(path) : new File(path);

		if (file.exists() && file.isFile()) {
			dialog.setFilterPath(file.getParent());
			dialog.setFileName(file.getName());
		}

		if ((path = dialog.open()) == null)
			return false;

		if (isURL)
			path = FileToURL(new File(path));

		return true;
	}

	protected boolean performWorkspaceResourceSelection(Shell shell, IEntity entity) {
		IPath filePath = Path.fromPortableString(path);
		IResource resource = filePath.isAbsolute() ?
				ResourcesPlugin.getWorkspace().getRoot().findMember(filePath) : null;

		ElementTreeSelectionDialog dialog = new ElementTreeSelectionDialog(shell, new WorkbenchLabelProvider(), new WorkbenchContentProvider());
		dialog.setInput(ResourcesPlugin.getWorkspace());
		dialog.setTitle(SELECT_RESOURCE_MSG);
		dialog.setMessage("Choose a resource");
		dialog.setInitialSelection(resource);

		if (dialog.open() != IDialogConstants.OK_ID)
			return false;

		Object[] selection = dialog.getResult();
		path = selection.length == 0 ? "/" : ((IResource) selection[0]).getFullPath().toPortableString();
		return true;
	}

	protected boolean performClasspathResourceSelection(Shell shell, IEntity entity) {
		String fileName = Path.fromPortableString(path).lastSegment();
		if (fileName != null && StringUtils.getFileExtension(fileName)
				.equals(StringUtils.CLASS_FILE_EXTENSION))
			fileName = StringUtils.appendFileExtension(
					StringUtils.stripFileExtension(fileName),
					StringUtils.JAVA_FILE_EXTENSION);

		IWorkspaceRoot workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
		SelectResourceAsDialog dialog = new SelectResourceAsDialog(shell, workspaceRoot, IResource.FILE);
		if (fileName != null)
			dialog.setInitialPattern(fileName);

		if (dialog.open() != IDialogConstants.OK_ID)
			return false;

		Object[] selection = dialog.getResult();
		IBindingManager bm = BindingManagerFactory.instance.createBindingManager();
		IFile file = workspaceRoot.getFile(((IResource) selection[0]).getFullPath());
		ResourceUtils.defineResourceBindings(bm, file);

		if (bm.wStringValue("fileExtension").equals(StringUtils.JAVA_FILE_EXTENSION))
			path = StringUtils.toResourceClasspath(bm.wStringValue("compilationUnitName"));
		else
			path = StringUtils.packagePath(bm.wStringValue("packageName"))+File.separator+
					bm.wStringValue("fileNameWithExtension");
		return true;
	}

	public static File URLToFile(String url) {
		try {
			return new File(new URL(url).toURI().getPath());
		} catch (Exception e) {
			return new File(url);
		}
	}
	public static String FileToURL(File file) {
		try {
			return file.toURI().toURL().toExternalForm();
		} catch (Exception e) {
			return file.getAbsolutePath();
		}
	}
	
	public void transform(IEntity oldEntity, IEntity newEntity) {
		newEntity.wSetValue(path);
	}
}
