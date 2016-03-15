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
package org.whole.lang.ui.controls;

import org.eclipse.core.resources.IFile;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.dialogs.SelectionDialog;
import org.whole.lang.codebase.IPersistenceKit;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.ui.dialogs.OpenAsModelDialog;

/**
 * @author Enrico Persiani
 */
public class WholeModelBrowseChooser extends AbstractBrowseChooser {

	protected IPackageFragment lastSelectedFragment;
	IPersistenceKit defaultPersistenceKit;

	public WholeModelBrowseChooser(Composite parent, int style, int buttonWidthHint) {
		super(parent, style, "File:", buttonWidthHint);
	}

	protected SelectionDialog createDialog() {
		defaultPersistenceKit = ReflectionFactory.getDefaultPersistenceKit();
		OpenAsModelDialog dialog = new OpenAsModelDialog(getShell(), defaultPersistenceKit);
		dialog.setTitle("Select a target model"); 
		return dialog;
	}

	public IFile getFile() {
		if (selectedElements == null)
			return null;
		else
			return (IFile) selectedElements[0];
	}

	public IPersistenceKit getPersistenceKit() {
		if (selectedElements == null)
			return null;
		else
			return (IPersistenceKit) selectedElements[1];
	}

	@Override
	protected String resultToString(Object[] selectedElements) {
		return getFile().getFullPath().toPortableString();
	}

	@Override
	protected Object[] getResult(Dialog dialog) {
		OpenAsModelDialog openDialog = (OpenAsModelDialog) dialog;
		return new Object[] { openDialog.getResult()[0], openDialog.getPersistenceKit()};
	}
}
