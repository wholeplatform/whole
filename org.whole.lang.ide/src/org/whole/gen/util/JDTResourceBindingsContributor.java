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
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaCore;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.ui.util.IResourceBindingsContributor;
import org.whole.lang.ui.util.ResourceUtils;
import org.whole.lang.util.StringUtils;

/**
 * @author Enrico Persiani
 */
public class JDTResourceBindingsContributor implements IResourceBindingsContributor {
	public void addResourceBindings(final IBindingManager bm) {
		final IProject project = (IProject) bm.wGetValue("project");
		final IContainer folder = (IContainer) bm.wGetValue("folder");

		try {
			if (project.hasNature(JavaCore.NATURE_ID)) {
				IJavaProject javaProject = JavaCore.create(project);
				bm.wDefValue("javaProject", javaProject);
				ReflectionFactory.setClassLoader(bm, IDEUtils.createClassLoader(javaProject, true));

				IPackageFragment packageFragment = javaProject.findPackageFragment(folder.getFullPath());
				if (packageFragment != null) {
					String packageName = packageFragment.getElementName();
					if (packageName.length() > 0)
						bm.wDefValue("packageName", packageName);

					IFile file = (IFile) bm.wGetValue("file");
					String compilationUnitName = IDEUtils.getCompilationUnitName(file);
					bm.wDefValue("compilationUnitName", compilationUnitName);
					bm.wDefValue("className", StringUtils.toSimpleName(compilationUnitName));

					// perform an incremental build to ensure class files are generated
					project.build(IncrementalProjectBuilder.INCREMENTAL_BUILD, ResourceUtils.getProgressMonitor(bm));

					IResource correspondingResource = packageFragment.getParent().getCorrespondingResource();
					IPath sourcePath = correspondingResource.getProjectRelativePath();
					if (!sourcePath.isEmpty()) {
						String sourceFolderName = sourcePath.toString();
						bm.wDefValue("sourceFolderName", sourceFolderName);
						bm.wDefValue("contextURI", bm.wStringValue("contextURI")+"/"+sourceFolderName);
					}

					IPath sourceLocationPath = correspondingResource.getLocation();
					if (!sourceLocationPath.isEmpty())
						bm.wDefValue("sourceLocationName", sourceLocationPath.toString());
				} else {
					for (IPackageFragmentRoot packageFragmentRoot : javaProject.getAllPackageFragmentRoots()) {
						if (packageFragmentRoot.getKind() == IPackageFragmentRoot.K_SOURCE) {
							String sourceFolderName = packageFragmentRoot.getElementName();
							bm.wDefValue("sourceFolderName", sourceFolderName);
							bm.wDefValue("contextURI", bm.wStringValue("contextURI")+"/"+sourceFolderName);
							break;
						}
					}
				}
			}
		} catch (CoreException e) {
		}
	}
}
