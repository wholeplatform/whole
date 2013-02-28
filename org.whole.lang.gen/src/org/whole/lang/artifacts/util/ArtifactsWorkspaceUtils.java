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
package org.whole.lang.artifacts.util;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jdt.core.JavaCore;
import org.whole.lang.artifacts.model.FileArtifact;
import org.whole.lang.artifacts.model.FolderArtifact;
import org.whole.lang.artifacts.model.IArtifactsEntity;
import org.whole.lang.artifacts.model.Project;
import org.whole.lang.artifacts.reflect.ArtifactsEntityDescriptorEnum;
import org.whole.lang.artifacts.visitors.LoadContentsVisitor;
import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.commons.reflect.CommonsEntityDescriptorEnum;
import org.whole.lang.iterators.IEntityIterator;
import org.whole.lang.iterators.IteratorFactory;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.IEntity;
import org.whole.lang.util.EntityUtils;

/**
 * @author Riccardo Solmi, Enrico Persiani
 */
public class ArtifactsWorkspaceUtils {

	public static boolean existsPath(IArtifactsEntity artifact) {
		return existsPath(artifact, null);
	}

	public static boolean existsPath(IArtifactsEntity artifact, IArtifactsEntity childArtifact) {
		try {
			IBindingManager bindings = BindingManagerFactory.instance.createBindingManager();
			bindPath(artifact, bindings, false);
			if (childArtifact != null) {
				IFolder parentFolder = (IFolder) bindings.wGetValue("folder");
				return parentFolder.exists(parentFolder.getFullPath().append(ArtifactsUtils.getName(childArtifact)));
			} else
				return true;
		} catch (IllegalArgumentException e) {
			return false;
		}
	}

	public static void bindPath(IArtifactsEntity artifact, IBindingManager bindings, boolean force) {
		if (!ArtifactsEntityDescriptorEnum.Artifact.isLanguageSupertypeOf(artifact.wGetEntityDescriptor()) &&
				!Matcher.match(ArtifactsEntityDescriptorEnum.Workspace, artifact) &&
				!Matcher.match(ArtifactsEntityDescriptorEnum.Project, artifact))
			throw new IllegalArgumentException("Wrong path ending with: "+artifact.toString());

		IEntityIterator<IEntity> pathIterator = IteratorFactory.ancestorOrSelfReverseIterator();
		pathIterator.reset(artifact);

		if (!pathIterator.hasNext())
			throw new IllegalArgumentException("Empty model");

		if (CommonsEntityDescriptorEnum.RootFragment.equals(pathIterator.lookahead().wGetEntityDescriptor()))
			pathIterator.next();

		IEntity rootEntity = pathIterator.next();
		if (!Matcher.matchImpl(ArtifactsEntityDescriptorEnum.Workspace, rootEntity))
			throw new IllegalArgumentException("Missing Workspace root entity");

		while (pathIterator.hasNext()) {
			IEntity pathFragment = pathIterator.next();
			if (EntityUtils.isNotResolver(pathFragment) && !EntityUtils.isComposite(pathFragment)) {
				switch (pathFragment.wGetEntityOrd()) {
				case ArtifactsEntityDescriptorEnum.Project_ord:
					bindProject((Project) pathFragment, bindings, force);
					break;
				case ArtifactsEntityDescriptorEnum.FolderArtifact_ord:
					bindFolder((FolderArtifact) pathFragment, bindings, force);
					break;
				case ArtifactsEntityDescriptorEnum.FileArtifact_ord:
					bindFile((FileArtifact) pathFragment, bindings, force);
					break;
				default:
					throw new IllegalArgumentException("Unsupported entity in path: "+pathFragment.toString());
				}
			}
		}
	}

	private static void bindProject(Project projectEntity, IBindingManager bindings, boolean force) {
		bindings.wEnterScope();
		IWorkspaceRoot workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
		if (!Matcher.matchImplAndBind(ArtifactsEntityDescriptorEnum.Name, projectEntity.getName(), bindings, "projectName"))
			throw new IllegalArgumentException("No Project name");
		IProject project = workspaceRoot.getProject(bindings.wStringValue("projectName"));
		bindings.wDefValue("project", project);
		if (!project.exists()) {
			if (!force)
				throw new IllegalArgumentException("Missing Project: "+bindings.wStringValue("projectName"));
			else {
				try {
					project.create((IProgressMonitor) bindings.wGetValue("progressMonitor"));
					if (project.hasNature(JavaCore.NATURE_ID)) 
						bindings.wDefValue("javaProject", JavaCore.create(project));
				} catch (CoreException e) {
					throw new IllegalArgumentException("Cannot create Project: "+bindings.wStringValue("projectName"));
				}
			}
		}
		bindings.wExitScope(true);
	}

	private static void bindFolder(FolderArtifact folderEntity, IBindingManager bindings, boolean force) {
		bindings.wEnterScope();
		if (!Matcher.matchImplAndBind(ArtifactsEntityDescriptorEnum.Name, folderEntity.getName(), bindings, "folderName"))
			throw new IllegalArgumentException("No Folder name");
		IWorkspaceRoot workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
		IFolder folder = workspaceRoot.getFolder(getParentPath(bindings).append(bindings.wStringValue("folderName")));
		bindings.wDefValue("folder", folder);
		if (!folder.exists()) {
			if(!force)
				throw new IllegalArgumentException("Missing Folder: "+bindings.wStringValue("folderName"));
			else {
				try {
					folder.create(true, true, (IProgressMonitor) bindings.wGetValue("progressMonitor"));
				} catch (Exception e) {
					throw new IllegalArgumentException("Cannot create Folder: "+bindings.wStringValue("folderName"));
				}
			}
		}
		bindings.wExitScope(true);
	}

	private static void bindFile(FileArtifact fileEntity, IBindingManager bindings, boolean force) {
		bindings.wEnterScope();
		if (!Matcher.matchImplAndBind(ArtifactsEntityDescriptorEnum.Name, fileEntity.getName(), bindings, "fileName"))
			throw new IllegalArgumentException("No File name");
		IWorkspaceRoot workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
		IFile file = workspaceRoot.getFile(getParentPath(bindings).append(bindings.wStringValue("fileName")));
		bindings.wDefValue("file", file);
		if (!file.exists() && !force)
			throw new IllegalArgumentException("Missing File: "+bindings.wStringValue("fileName"));
		bindings.wExitScope(true);
	}

	public static IPath getParentPath(IBindingManager bindings) {
		IPath parentPath;
		if (bindings.wIsSet("folder")) {
			IFolder parentFolder = (IFolder) bindings.wGetValue("folder");
			parentPath = parentFolder.getFullPath();
		} else {
			IProject project = (IProject) bindings.wGetValue("project");
			parentPath = project.getFullPath();
		}
		return parentPath;
	}

	//TODO markSourceFolder(FolderArtifact)
	// topDown replace FolderArtifact with PackageArtifact

	public static void loadContents(IArtifactsEntity rootArtifact, IBindingManager bindings) {
		try {
			if (!Matcher.match(ArtifactsEntityDescriptorEnum.Project, rootArtifact) &&
				!Matcher.match(ArtifactsEntityDescriptorEnum.Workspace, rootArtifact))
				rootArtifact = (IArtifactsEntity) rootArtifact.wGetParent().wGetParent();
			bindPath(rootArtifact, bindings, false);
		} catch(ClassCastException e) {
		}
		LoadContentsVisitor visitor = new LoadContentsVisitor(bindings);
		visitor.visit(rootArtifact);
	}
}
