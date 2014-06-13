/**
 * Copyright 2004-2014 Riccardo Solmi. All rights reserved.
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
package org.whole.gen.util;

import org.eclipse.core.resources.IContainer;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ElementTreeSelectionDialog;
import org.eclipse.ui.model.WorkbenchContentProvider;
import org.eclipse.ui.model.WorkbenchLabelProvider;
import org.eclipse.ui.views.navigator.ResourceComparator;
import org.whole.lang.ui.controls.JavaSourceFolderFilter;
import org.whole.lang.ui.controls.JavaSourceFolderValidator;

/**
 * @author Riccardo Solmi, Enrico Persiani
 */
public class IDEUtils {
	public static IPackageFragmentRoot getPackageFragmentRoot(Shell shell) {
		IContainer[] containers = openJavaSourceFoldersDialog(shell, false);
		if (containers.length == 0)
			return null;
		return JDTUtils.getPackageFragmentRoot(containers[0]);
	}
	public static IContainer[] openJavaSourceFoldersDialog(Shell shell, boolean allowMultipleSelection) {
		ElementTreeSelectionDialog dialog = new ElementTreeSelectionDialog(
				shell, new WorkbenchLabelProvider(), new WorkbenchContentProvider());
		dialog.setValidator(new JavaSourceFolderValidator());
		dialog.setTitle("Java Source Folder Selection");
		dialog.setMessage("Choose a destination folder for generated code");
		dialog.addFilter(new JavaSourceFolderFilter());
		dialog.setInput(JDTUtils.getWorkspaceRoot());
		dialog.setComparator(new ResourceComparator(ResourceComparator.NAME));
		dialog.setAllowMultiple(allowMultipleSelection);

		if (dialog.open() == Window.OK) {
			Object[] elements = dialog.getResult();
			IContainer[] containers = new IContainer[elements.length];
			for (int i=0; i<containers.length; i++)
				containers[i]= (IContainer) elements[i];
			return containers;
		}
		return new IContainer[0];
	}
}
