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
package org.whole.lang.ui.util;

import java.util.Iterator;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.operations.IOperationProgressMonitor;
import org.whole.lang.ui.ResourceBindingsContributorExtensions;
import org.whole.lang.util.StringUtils;

/**
 * @author Riccardo Solmi
 */
public class ResourceUtils {
	public static void defineResourceBindings(IBindingManager bm, IFile file) {
		IProject project = file.getProject();
		bm.wDefValue("project", project);
		bm.wDefValue("projectName", project.getName());
		bm.wDefValue("file", file);
		String name = file.getName();
		bm.wDefValue("fileNameWithExtension", name);
		bm.wDefValue("fileName", StringUtils.stripFileExtension(name));
		bm.wDefValue("fileExtension", file.getFileExtension());
		IContainer container = file.getParent();
		bm.wDefValue("folder", container);
		IPath folderPath = container.getProjectRelativePath();
		if (!folderPath.isEmpty())
			bm.wDefValue("folderName", folderPath.toString()); // project relative path
		bm.wDefValue("folderLocation", container.getLocation().toString()); // absolute path
		bm.wDefValue("folderFullPath", container.getFullPath().toString()); // workspace relative path
		bm.wDefValue("fileLocation", name = file.getLocation().toString());
		bm.wDefValue("fileLocationName", StringUtils.stripFileExtension(name));
		bm.wDefValue("fileLocationURI", file.getLocationURI().toASCIIString());//FIXME
		bm.wDefValue("fileFullPath", name = file.getFullPath().toString());
		bm.wDefValue("fileFullPathName", StringUtils.stripFileExtension(name));

		bm.wDefValue("workspaceLocation", container.getWorkspace().getRoot().getLocation().toString());
		bm.wDefValue("contextURI", "platform:/resource/"+project.getName());

		bm.wDefValue("debug#reportModeEnabled", true);
		bm.wDefValue("debug#debugModeEnabled", true);
		bm.wDefValue("debug#breakpointsEnabled", true);

		for (IResourceBindingsContributor contributor : ResourceBindingsContributorExtensions.instance().getContributors())
			try {
				contributor.addResourceBindings(bm);
			} catch (Exception e) {
				throw new IllegalStateException(e);
			}
	}

	public static IProgressMonitor getProgressMonitor(IBindingManager bm) {
		return bm.wIsSet("progressMonitor") ?
				((IOperationProgressMonitor) bm.wGetValue("progressMonitor")).getAdapter(IProgressMonitor.class) : null;
	}

	public static boolean isAdaptableToFile(Object element) {
		return adaptToFile(element) != null;
	}
	public static IFile adaptToFile(Object element) {
		if (element instanceof IFile)
			return (IFile) element;
		
		if (element instanceof IAdaptable) {
			IResource resource = (IResource) Platform.getAdapterManager().getAdapter((IAdaptable) element, IResource.class);
			if (resource instanceof IFile)
				return (IFile) resource;
		}
		return null;
	}

	public static boolean isFileSelection(ISelection selection) {
		if (!(selection instanceof IStructuredSelection) || selection.isEmpty())
			return false;
		Iterator<?> iterator = (((IStructuredSelection) selection)).iterator();
		while (iterator.hasNext()) {
			Object element = iterator.next();
			if (!isAdaptableToFile(element))
				return false;
		}
		return true;
	}

	public static String className(IPath path) {
		if (path.segmentCount() > 1)
			path = path.removeFirstSegments(1);
		IPath path2 = path.removeFileExtension();
	    String[] segments = path2.segments();
	    String className = segments[0];
	    for (int i=1; i<segments.length; i++)
	        className += '.'+segments[i];
	    return className;
	}
}
