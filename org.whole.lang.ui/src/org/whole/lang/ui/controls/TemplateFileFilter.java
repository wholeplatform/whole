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
package org.whole.lang.ui.controls;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;

public class TemplateFileFilter extends ViewerFilter {
	public boolean select(Viewer viewer, Object parent, Object element) {
		if (element instanceof IFolder) {
		    IFolder folder = (IFolder) element;
			IPath path = folder.getFullPath();
			if (path.lastSegment().equals("bin"))
			    return false;
			return true;
		}

	    if (element instanceof IFile) {
			IFile file = (IFile) element;
			String ext = file.getFileExtension();
//			if (StringUtils.inList(ext, "java,xml"))
			    return true;
//			else
//			    return false;
	    }
		return true;
	}
}

