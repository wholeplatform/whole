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

import java.io.File;
import java.net.URL;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.gef.commands.Command;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ElementTreeSelectionDialog;
import org.eclipse.ui.internal.ide.dialogs.OpenResourceDialog;
import org.eclipse.ui.model.WorkbenchContentProvider;
import org.eclipse.ui.model.WorkbenchLabelProvider;
import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.ui.WholeUIPlugin;
import org.whole.lang.ui.commands.ReplaceChildCommand;
import org.whole.lang.ui.editparts.IEntityPart;
import org.whole.lang.ui.util.ResourceUtils;
import org.whole.lang.ui.util.UIUtils;
import org.whole.lang.util.IEntityTransformer;
import org.whole.lang.util.StringUtils;

/**
 * @author Enrico Persiani, Riccardo Solmi
 */
public abstract class ReplaceWithResourceAction extends ReplaceChildAction  implements IEntityTransformer {
	protected static final String SELECT_RESOURCE_MSG = "Select a resource";
	protected static final ImageDescriptor SELECT_RESOURCE_ICON = WholeUIPlugin.getImageDescriptor("icons/actions/select_persistence.gif");
	protected static final IEnablerPredicate TRUE = EnablerPredicateFactory.instance.alwaysTrue();
	public static enum ResourceKind {
		WORKSPACE, FILE_SYSTEM, CLASSPATH, URL
	}

	protected String path;

	public ReplaceWithResourceAction(EntityDescriptor<?> type, String path, String text) {
		super(UIUtils.getActiveEditor(), TRUE, type, text, null);
		this.transformer = this;
		this.path = path;
		setImageDescriptor(SELECT_RESOURCE_ICON);
	}

	protected abstract boolean isLoading(IEntity selectedEntity);
	protected abstract ResourceKind getResourceKind(IEntity selectedEntity);

	@Override
	public void run() {
		IEntityPart selectedPart = (IEntityPart) getSelectedObjects().get(0);
		IEntity selectedEntity = selectedPart.getModelEntity();
		IEntity parent = selectedPart.getParentModelEntity();

		ResourceKind resourceKind = getResourceKind(selectedEntity);
		Shell shell = getWorkbenchPart().getSite().getShell();

		boolean selectionPerformed = false;
		switch (resourceKind) {
		case WORKSPACE:
			selectionPerformed = performWorkspaceResourceSelection(shell, selectedEntity);
			break;
		case CLASSPATH:
			selectionPerformed = performClasspathResourceSelection(shell, selectedEntity);
			break;
		case FILE_SYSTEM:
		case URL:
			selectionPerformed = performFilesystemSelection(shell, selectedEntity,  resourceKind == ResourceKind.URL);
			break;
		}

		if (!selectionPerformed)
			return;

		IEntity newResource = contextMenuRequest.cloneType();
		transformer.transform(selectedEntity, newResource);

		execute(createReplaceResourceCommand(parent, selectedEntity, newResource));
	}

	protected Command createReplaceResourceCommand(IEntity parent, IEntity oldChild, IEntity newChild) {
		ReplaceChildCommand replaceResource = new ReplaceChildCommand();
		replaceResource.setParent(parent);
		replaceResource.setOldChild(oldChild);
		replaceResource.setNewChild(newChild);
		replaceResource.setLabel("set resource");
		return replaceResource;
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
		OpenResourceDialog dialog = new OpenResourceDialog(shell, workspaceRoot, IResource.FILE);
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
