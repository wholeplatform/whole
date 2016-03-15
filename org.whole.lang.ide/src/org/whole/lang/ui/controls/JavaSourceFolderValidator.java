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

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.ui.dialogs.ISelectionStatusValidator;
import org.whole.lang.e4.ui.E4CompatibilityPlugin;

/**
 * @author Enrico Persiani
 */
public class JavaSourceFolderValidator implements ISelectionStatusValidator {
	private IStatus errorStatus= new Status(IStatus.ERROR, E4CompatibilityPlugin.PLUGIN_ID, IStatus.ERROR, "", null);
	private IStatus okStatus= Status.OK_STATUS;

	public IStatus validate(Object[] selection) {
		if (isValid(selection)) {
			return okStatus;
		}
		return errorStatus;
	}

	private boolean isValid(Object[] selection) {
		if (selection.length == 0)
			return false;

		for (int i= 0; i < selection.length; i++) {
			Object element = selection[i];	
			if (!isJavaSourceFolder(element)) {
				return false;
			}
		}

		return true;
	}

	private boolean isJavaSourceFolder(Object element) {
		if (!(element instanceof IContainer))
			return false;

		IContainer container = (IContainer) element;
		IProject proj = container.getProject();

		try {
			if (!proj.hasNature(JavaCore.NATURE_ID))
				return false;
			
			IJavaProject jProject= JavaCore.create(container.getProject());
			if (jProject == null || !jProject.exists())
				return false;

			IPackageFragmentRoot sourceLocation = jProject.getPackageFragmentRoot(container);
			IClasspathEntry cpentry = sourceLocation.getRawClasspathEntry();
	
			if(cpentry != null && cpentry.getEntryKind() == IClasspathEntry.CPE_SOURCE) {
				return true;
			} else {
				return false;
			}
		} catch (CoreException ex) {
			return false;
		}
	}
}
