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
package org.whole.lang.artifacts.templates;

import java.io.File;
import java.util.Stack;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.whole.lang.util.CompositeUtils;

/**
 * @author Enrico Persiani
 */
public class WorkspaceTemplate extends ResourceTemplate {
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
					buildArtifact(member.getLocation().toFile());
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
