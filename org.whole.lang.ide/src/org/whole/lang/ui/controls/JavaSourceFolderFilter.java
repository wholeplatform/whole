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
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;

/**
 * @author Enrico Persiani
 */
public class JavaSourceFolderFilter extends ViewerFilter {
	public boolean select(Viewer viewer, Object parent, Object element) {
		// filter any non container resource
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

			// get any project container
			if(container == proj)
				return true;

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

