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
package org.whole.lang.artifacts.templates;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourceAttributes;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.whole.lang.util.CompositeUtils;

/**
 * @author Enrico Persiani
 */
public class WorkspaceTemplate extends ResourceTemplate {
	public static class ResourceComparator implements Comparator<IResource> {
		public int compare(IResource first, IResource second) {
			boolean isFirstDirectory = first.getType() == IResource.FOLDER;
			boolean isSecondDirectory = second.getType() == IResource.FOLDER;
			if (isFirstDirectory && !isSecondDirectory)
				return 1;
			else if (!isFirstDirectory && isSecondDirectory)
				return -1;
			else
				return first.getName().compareTo(second.getName());
		}
	}

	public static class JavaElementComparator implements
			Comparator<IJavaElement> {
		public int compare(IJavaElement first, IJavaElement second) {
			boolean isFirstDirectory = first.getElementType() == IJavaElement.PACKAGE_FRAGMENT;
			boolean isSecondDirectory = second.getElementType() == IJavaElement.PACKAGE_FRAGMENT;
			if (isFirstDirectory && !isSecondDirectory)
				return 1;
			else if (!isFirstDirectory && isSecondDirectory)
				return -1;
			else
				return first.getElementName().compareTo(second.getElementName());
		}
	}

	protected IResource rootResource;
	protected boolean bindReversePath;

	public WorkspaceTemplate(IResource rootResource) {
		this(rootResource, true);
	}
	public WorkspaceTemplate(IResource rootResource, boolean bindReversePath) {
		this.rootResource = rootResource;
		this.bindReversePath = bindReversePath;
	}

	private void buildNatures(IProject project) {
			IJavaProject javaProject = JavaCore.create(project);
			if (javaProject != null) { 
				getBindings().wDefValue("javaProject", javaProject);
				ab.Natures_(1);
				ab.Nature(JavaCore.NATURE_ID);
				ab._Natures();
			} else
				ab.Natures();
	}

	protected void buildMetadata(String... attributes) {
		File file = (File) getBindings().wGetValue("file");
		if (file.isDirectory() && getBindings().wIsSet("javaProject")) {
			// check for source folders
			IJavaProject project = (IJavaProject) getBindings().wGetValue("javaProject");
			boolean isSourceFolder = false;
			try {
				IWorkspaceRoot workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
				IContainer[] containers = workspaceRoot.findContainersForLocationURI(file.toURI());
				if (containers.length == 1)
				for (IClasspathEntry entry : project.getRawClasspath())
					if (entry.getPath().equals(containers[0].getFullPath())) {
						isSourceFolder = true;
						break;
					}
			} catch (JavaModelException e) {
				// do nothing
			}
			if (isSourceFolder)
				attributes = CompositeUtils.grow(attributes, attributes.length+1, "source");
		} 
		super.buildMetadata(attributes);
	}

	protected void buildPackage(IPackageFragment packageFragment) {
		try {
			if (!packageFragment.hasChildren() && packageFragment.getNonJavaResources().length == 0)
				return;
		} catch (JavaModelException e1) {
		}

		getBindings().wEnterScope();
		ab.PackageArtifact_();
		String directoryName = packageFragment.getElementName();
		ab.Name(directoryName);
		super.buildMetadata();
		if (!testAndClearPurge()) {
			IResource[] artifacts = null;
			try {
				artifacts = ((IFolder) packageFragment.getCorrespondingResource()).members();
			} catch (CoreException e) {
			}
			if (artifacts != null && artifacts.length > 0) {
				Arrays.sort(artifacts, new ResourceComparator());
				ab.Artifacts_(artifacts.length);
				for (IResource artifact : artifacts)
					if (artifact.getType() == IResource.FILE)
						buildArtifact(artifact);
				ab._Artifacts();
			} else
				ab.Artifacts();
		} else
			ab.Artifacts();
		ab._PackageArtifact();
		getBindings().wExitScope();
	}

	protected void buildDirectory(IFolder directory) {
		getBindings().wEnterScope();
		ab.FolderArtifact_();
		String directoryName = directory.getName();
		ab.Name(directoryName);
		getBindings().wDefValue("file", directory.getLocation().toFile());
		getBindings().wDefValue("fileName", directoryName);
		ResourceAttributes resourceAttributes = directory.getResourceAttributes();
		if (resourceAttributes != null && resourceAttributes.isReadOnly())
			buildMetadata("readonly");
		else
			buildMetadata();
		if (!testAndClearPurge()) {
			IJavaElement javaElement = JavaCore.create(directory);
			if (javaElement != null && javaElement.getElementType() == IJavaElement.PACKAGE_FRAGMENT_ROOT) {
				IJavaElement[] children = null;
				try {
					children = ((IPackageFragmentRoot) javaElement).getChildren();
				} catch (JavaModelException e) {
				}
				if (children != null && children.length > 0) {
					Arrays.sort(children, new JavaElementComparator());
					ab.Artifacts_(children.length);
					for (IJavaElement artifact : children)
						buildPackage((IPackageFragment) artifact);
					ab._Artifacts();
				} else
					ab.Artifacts();

			} else {
				IResource[] artifacts = null;
				try {
					artifacts = directory.members();
				} catch (CoreException e) {
				}
				if (artifacts != null && artifacts.length > 0) {
					Arrays.sort(artifacts, new ResourceComparator());
					ab.Artifacts_(artifacts.length);
					for (IResource artifact : artifacts)
						buildArtifact(artifact);
					ab._Artifacts();
				} else
					ab.Artifacts();
			}
		} else
			ab.Artifacts();
		ab._FolderArtifact();
		getBindings().wExitScope();
	}

	protected void buildArtifact(IResource resource) {
		IJavaElement javaElement = JavaCore.create(resource);
		if (javaElement != null && javaElement.getElementType() == IJavaElement.PACKAGE_FRAGMENT)
			buildPackage((IPackageFragment) javaElement);
		else if (resource.getType() == IResource.FOLDER) {
			buildDirectory((IFolder) resource);
		} else
			buildFile(resource.getLocation().toFile());
	}

	protected void buildProject(IProject project) {
		if (!project.isAccessible())
			return;
		getBindings().wEnterScope();
		ab.Project_();
		String projectName = project.getName();
		ab.Name(projectName);
		getBindings().wDefValue("file", project.getLocation().toFile());
		getBindings().wDefValue("fileName", projectName);
		buildNatures(project);
		if (project.getResourceAttributes().isReadOnly())
			buildMetadata("readonly");
		else
			buildMetadata();
		try {
			if(!testAndClearPurge()) {
				IResource[] members = project.members();
				ab.Artifacts_(members.length);
				for (IResource member : members)
					buildArtifact(member);
				ab._Artifacts();
			}
		} catch (CoreException e) {
			// do nothing
		}
		ab._Project();
		getBindings().wExitScope();
	}

	protected void buildWorkspace(IResource resource) {
		ab.Workspace_();
		cb.Resolver();
		if(!testAndClearPurge()) {
			IProject[] projects = ((IWorkspaceRoot) resource).getProjects();
			ab.Projects_(projects.length);
			for (IProject project : projects)
				buildProject(project);
			ab._Projects();
		}
		ab._Workspace();
	}

	private void buildResourceStack(Stack<IResource> resourceStack) {
		if (!resourceStack.isEmpty()) {
			File resourceFile = resourceStack.pop().getLocation().toFile();
			if (!resourceStack.isEmpty()) {
				getBindings().wEnterScope();
				ab.FolderArtifact_();
				String directoryName = resourceFile.getName();
				ab.Name(directoryName);
				getBindings().wDefValue("file", resourceFile);
				getBindings().wDefValue("fileName", directoryName);
				if (!resourceFile.canWrite())
					buildMetadata("readonly");
				else
					buildMetadata();
				ab.Artifacts_(1);
				buildResourceStack(resourceStack);
				ab._Artifacts();
				ab._FolderArtifact();
				getBindings().wExitScope();
			} else
				buildArtifact(resourceFile);
		}
	}

	private void buildReversePathModel(IResource resource) {
		ab.Workspace_();
		cb.Resolver();
		ab.Projects_(1);
		if (resource.getType() == IResource.PROJECT)
			buildProject((IProject) resource);
		else {
			Stack<IResource> resourceStack = new Stack<IResource>();
			while (resource.getType() != IResource.PROJECT) {
				resourceStack.push(resource);
				resource = resource.getParent();
			}
			getBindings().wEnterScope();
			IProject project = (IProject) resource;
			ab.Project_();
			String projectName = project.getName();
			ab.Name(projectName);
			getBindings().wDefValue("file", project.getLocation().toFile());
			getBindings().wDefValue("fileName", projectName);
			buildNatures(project);
			if (project.getResourceAttributes().isReadOnly() || !project.isAccessible())
				buildMetadata("readonly");
			else
				buildMetadata();
			ab.Artifacts_(1);
			buildResourceStack(resourceStack);
			ab._Artifacts();
			ab._Project();
			getBindings().wExitScope();
		}
		ab._Projects();
		ab._Workspace();
	}

	protected void buildWorkspaceModel(IResource resource) {
		if (bindReversePath)
			buildReversePathModel(resource); 
		else
			switch(resource.getType()) {
			case IResource.ROOT:
				buildWorkspace(resource);
				break;
			case IResource.PROJECT:
				buildProject((IProject) resource);
				break;
			case IResource.FOLDER:
			case IResource.FILE:
			default:
				buildArtifact(resource.getLocation().toFile());
				break;
			}
	}

	protected void buildArtifactsModel() {
		testAndClearPurge();
		buildWorkspaceModel(rootResource);
	}
}
