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
package org.whole.lang.ide;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.whole.lang.ui.util.PlatformLibraryClasspathContainer;
import org.whole.lang.util.CompositeUtils;

public class WholeIDEPlugin extends AbstractUIPlugin {
	private static WholeIDEPlugin instance;

	public static WholeIDEPlugin getInstance() {
		return instance;
	}
	public WholeIDEPlugin() {
		instance = this;
	}

	public static final String PLUGIN_ID = "org.whole.lang.ide";

	public static void removeWholeRuntimeFromBuildPath(IProject project) {
		IJavaProject javaProject = JavaCore.create(project);
		try {
			IClasspathEntry[] classpath = javaProject.getRawClasspath();
			List<IClasspathEntry> list = new ArrayList<IClasspathEntry>(Arrays.asList(classpath));
			
	
			for(IClasspathEntry entry : classpath)
				if (PlatformLibraryClasspathContainer.sameKind(entry))
					list.remove(entry);
	
			if(classpath.length > list.size())
				javaProject.setRawClasspath(list.toArray(classpath), new NullProgressMonitor());
		} catch (JavaModelException e) {
		}
	}

	public static void addWholeRuntimeToBuildPath(IProject project) {
		IJavaProject javaProject = JavaCore.create(project);
		try {
			IClasspathEntry[] classpath = javaProject.getRawClasspath();

			IClasspathEntry[] newClasspath = CompositeUtils.grow(classpath, classpath.length+1,
					JavaCore.newContainerEntry(PlatformLibraryClasspathContainer.getBasePath(), false));

			javaProject.setRawClasspath(newClasspath, new NullProgressMonitor());
		} catch (JavaModelException e) {
		}
	}

	/**
	 * Returns a <code>org.eclipse.jface.resource.ImageDescriptor</code> representing
	 * the image loaded using the relative path.
	 *  
	 * @param relativePath plugin's relative path to the image resource
	 * @return
	 */
	public static ImageDescriptor getImageDescriptor(String relativePath) {
		return imageDescriptorFromPlugin(PLUGIN_ID, relativePath);
	}
}
