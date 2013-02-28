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
package org.whole.gen.util;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.whole.lang.ui.search.WholeSearchScope.ISearchScopeFilter;

public class JDTOutputFolderSearchScopeFilter implements ISearchScopeFilter {

	/**
	 * @see org.eclipse.jdt.internal.ui.filters.OutputFolderFilter#select(org.eclipse.jface.viewers.Viewer, Object, Object)
	 */ 
	@SuppressWarnings("restriction")
	public boolean encloses(IResource resource) {
		if(resource instanceof IFolder) {
			IFolder folder= (IFolder)resource;
			IProject proj= folder.getProject();
			try {
				if (!proj.hasNature(JavaCore.NATURE_ID))
					return true;
				
				IJavaProject jProject= JavaCore.create(folder.getProject());
				if (jProject == null || !jProject.exists())
					return true;
				
				// Check default output location
				IPath defaultOutputLocation= jProject.getOutputLocation();
				IPath folderPath= folder.getFullPath();
				if (defaultOutputLocation != null && defaultOutputLocation.equals(folderPath))
					return false;
				
				// Check output location for each class path entry
				IClasspathEntry[] cpEntries= jProject.getRawClasspath();
				for (int i= 0, length= cpEntries.length; i < length; i++) {
					IPath outputLocation= cpEntries[i].getOutputLocation();
					if (outputLocation != null && outputLocation.equals(folderPath))
						return false;
				}
			} catch (CoreException ex) {
				return true;
			}
		}
		return true;
	}
}
