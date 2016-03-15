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

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.widgets.Shell;
import org.whole.lang.codebase.IPersistenceKit;
import org.whole.lang.e4.ui.E4CompatibilityPlugin;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.ui.dialogs.OpenAsModelDialog;
import org.whole.lang.ui.dialogs.SaveAsModelDialog;

/**
 * @author Enrico Persiani, Riccardo Solmi
 */
public abstract class ReplaceWithResourceAndPersistenceAction extends ReplaceWithResourceAction {
	protected IPersistenceKit defaultPersistenceKit;
	protected IPersistenceKit persistenceKit;

	public ReplaceWithResourceAndPersistenceAction(IEclipseContext context, EntityDescriptor<?> type,
			String path, IPersistenceKit defaultPersistenceKit, String text) {
		super(context, type, path, text);
		this.defaultPersistenceKit = defaultPersistenceKit;
	}

	@Override
	protected boolean performWorkspaceResourceSelection(Shell shell, IEntity entity) {
		IPath filePath = Path.fromPortableString(path);
		IFile file = filePath.isAbsolute() ?
				ResourcesPlugin.getWorkspace().getRoot().getFile(filePath) : null;
		if (isLoading(entity)) {
			OpenAsModelDialog dialog = new OpenAsModelDialog(shell, defaultPersistenceKit) {
				@Override
				protected IStatus createWrongPersistenceStatus() {
					return new Status(IStatus.WARNING, E4CompatibilityPlugin.PLUGIN_ID, IStatus.WARNING,
							"Can't open model with selected persistence", null);
				}
			};
			if (file != null)
				dialog.setInitialSelection(file);
			dialog.setTitle(SELECT_RESOURCE_MSG);
			if (dialog.open() != IDialogConstants.OK_ID)
				return false;

			path = ((IFile) dialog.getResult()[0]).getFullPath().toPortableString();
			persistenceKit = dialog.getPersistenceKit();
		} else {
			SaveAsModelDialog dialog = new SaveAsModelDialog(shell, defaultPersistenceKit);
			if (file != null)
				dialog.setOriginalFile(file);
			dialog.setTitle(SELECT_RESOURCE_MSG);
			if (dialog.open() != IDialogConstants.OK_ID)
				return false;

			path = dialog.getResult().toPortableString();
			persistenceKit = dialog.getPersistenceKit();
		}
		return true;
	}

	@Override
	protected void performReplace(IEntity primarySelectedEntity, IEntity replacement) {
		super.performReplace(primarySelectedEntity, replacement);

		if (persistenceKit != null && persistenceKit != defaultPersistenceKit)
			performReplacePersistence(primarySelectedEntity.wGetParent());
	}

	protected abstract void performReplacePersistence(IEntity parent);
}
