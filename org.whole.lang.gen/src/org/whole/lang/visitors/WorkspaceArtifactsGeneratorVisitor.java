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
package org.whole.lang.visitors;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.resources.ResourceAttributes;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.jobs.ISchedulingRule;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.whole.lang.artifacts.model.FileArtifact;
import org.whole.lang.artifacts.model.FolderArtifact;
import org.whole.lang.artifacts.model.LocationURI;
import org.whole.lang.artifacts.model.Nature;
import org.whole.lang.artifacts.model.Natures;
import org.whole.lang.artifacts.model.PackageArtifact;
import org.whole.lang.artifacts.model.Project;
import org.whole.lang.artifacts.model.Workspace;
import org.whole.lang.artifacts.reflect.ArtifactsEntityDescriptorEnum;
import org.whole.lang.artifacts.visitors.AbstractArtifactsGeneratorVisitor;
import org.whole.lang.codebase.IFilePersistenceProvider;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.InterpreterOperation;
import org.whole.lang.util.DataTypeUtils;
import org.whole.lang.util.EntityUtils;
import org.whole.lang.util.StringUtils;

/**
 * @author Riccardo Solmi
 */
public class WorkspaceArtifactsGeneratorVisitor extends AbstractArtifactsGeneratorVisitor {
	private IProgressMonitor progressMonitor;
	public final IProgressMonitor progressMonitor() {
		if (progressMonitor == null) {
			progressMonitor = getOperation().getProgressMonitor().getAdapter(IProgressMonitor.class);		
			if (progressMonitor == null)
				progressMonitor = new NullProgressMonitor();
		}
		return progressMonitor;
	}
	
	protected ISchedulingRule getSchedulingRule() {
		ISchedulingRule rule = (ISchedulingRule) env().wGetValue(env().wIsSet("folder") ? "folder" : "project");
		return rule;
	}

	protected boolean inWorkspaceRunnable;
	public void visit(final Workspace entity) {
		if (inWorkspaceRunnable)
			visitWorkspace(entity);
		else
			try {
				inWorkspaceRunnable = true;
				IWorkspace workspace = ResourcesPlugin.getWorkspace();
				
				IWorkspaceRunnable operation = new IWorkspaceRunnable() {
					public void run(IProgressMonitor monitor) throws CoreException {
						visitWorkspace(entity);
					}
				};
				ISchedulingRule rule = workspace.getRoot();
				env().wDefValue("schedulingRule", rule);
				workspace.run(operation, rule, IWorkspace.AVOID_UPDATE, progressMonitor());
			} catch (CoreException e) {
				throw new VisitException(e);
			} finally {
				inWorkspaceRunnable = false;
			}
	}
	public void visit(final Project entity) {
		if (inWorkspaceRunnable)
			visitProject(entity);
		else
			try {
				inWorkspaceRunnable = true;
				IWorkspace workspace = ResourcesPlugin.getWorkspace();
				
				IWorkspaceRoot workspaceRoot = workspace.getRoot();
				IProject project = workspaceRoot.getProject(env().wStringValue("projectName"));
				
				IWorkspaceRunnable operation = new IWorkspaceRunnable() {
					public void run(IProgressMonitor monitor) throws CoreException {
						visitProject(entity);
					}
				};
				ISchedulingRule rule = project.exists() ? project : workspaceRoot;
				env().wDefValue("schedulingRule", rule);
				workspace.run(operation, rule, IWorkspace.AVOID_UPDATE, progressMonitor());
			} catch (CoreException e) {
				throw new VisitException(e);
			} finally {
				inWorkspaceRunnable = false;
			}
	}
	public void visit(final PackageArtifact entity) {
		if (inWorkspaceRunnable)
			visitPackageArtifact(entity);
		else
			try {
				inWorkspaceRunnable = true;
				IWorkspace workspace = ResourcesPlugin.getWorkspace();
				
				IWorkspaceRunnable operation = new IWorkspaceRunnable() {
					public void run(IProgressMonitor monitor) throws CoreException {
						visitPackageArtifact(entity);
					}
				};
				ISchedulingRule rule = getSchedulingRule();
				env().wDefValue("schedulingRule", rule);
				workspace.run(operation, rule, IWorkspace.AVOID_UPDATE, progressMonitor());
			} catch (CoreException e) {
				throw new VisitException(e);
			} finally {
				inWorkspaceRunnable = false;
			}
	}
	public void visit(final FolderArtifact entity) {
		if (inWorkspaceRunnable)
			visitFolderArtifact(entity);
		else
			try {
				inWorkspaceRunnable = true;
				IWorkspace workspace = ResourcesPlugin.getWorkspace();
				
				IWorkspaceRunnable operation = new IWorkspaceRunnable() {
					public void run(IProgressMonitor monitor) throws CoreException {
						visitFolderArtifact(entity);
					}
				};
				ISchedulingRule rule = getSchedulingRule();
				env().wDefValue("schedulingRule", rule);
				workspace.run(operation, rule, IWorkspace.AVOID_UPDATE, progressMonitor());
			} catch (CoreException e) {
				throw new VisitException(e);
			} finally {
				inWorkspaceRunnable = false;
			}
	}
	public void visit(final FileArtifact entity) {
		if (inWorkspaceRunnable)
			visitFileArtifact(entity);
		else
			try {
				inWorkspaceRunnable = true;
				IWorkspace workspace = ResourcesPlugin.getWorkspace();
				
				IWorkspaceRunnable operation = new IWorkspaceRunnable() {
					public void run(IProgressMonitor monitor) throws CoreException {
						visitFileArtifact(entity);
					}
				};
				ISchedulingRule rule = getSchedulingRule();
				env().wDefValue("schedulingRule", rule);
				workspace.run(operation, rule, IWorkspace.AVOID_UPDATE, progressMonitor());
			} catch (CoreException e) {
				throw new VisitException(e);
			} finally {
				inWorkspaceRunnable = false;
			}
	}

	public void visitWorkspace(Workspace entity) {
		env().wEnterScope();

		entity.getMetadata().accept(this);
		entity.getProjects().accept(this);

		env().wExitScope();
	}

	public void visitProject(final Project entity) {
		env().wUnset("folder"); // unset the default folder

		env().wEnterScope();
		if (!Matcher.matchImplAndBind(ArtifactsEntityDescriptorEnum.Name,
				entity.getName(), env(), "projectName"))
			throw new VisitException("No Project name");

		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		IWorkspaceRoot workspaceRoot = workspace.getRoot();

		String projectName = env().wStringValue("projectName");
		IProject project = workspaceRoot.getProject(projectName);
		try {
			if (!project.exists()) {
				LocationURI locationURI = entity.getLocationURI();
				if (DataTypeUtils.getDataKind(locationURI).isString()) {
					try {
						IProjectDescription description =
								workspace.newProjectDescription(projectName);
						description.setLocationURI(new URI(locationURI.getValue()));
						project.create(description, progressMonitor());
					} catch (Exception e) {
						throw new VisitException(e);
					}
				} else
					project.create(progressMonitor());
			}
			project.open(progressMonitor());
			env().wDefValue("project", project);

			entity.getNatures().accept(this);
			entity.getMetadata().accept(this);
			
			if (project.hasNature(JavaCore.NATURE_ID))
				env().wDefValue("javaProject", JavaCore.create(project));

			entity.getArtifacts().accept(this);

		} catch (CoreException e) {
			throw new VisitException(e);
		}
		env().wExitScope();
	}

	public void visit(Natures entity) {
		int size = entity.wSize();
		if (size == 0)
			return;

		String[] natures = new String[size];
		for (int i = 0; i < size; i++) {
			IEntity nature = entity.wGet(i);
			if (!EntityUtils.isResolver(nature)) {
				((Nature) nature).accept(this);
				natures[i] = env().wStringValue("nature");
			}
		}

		IProject project = (IProject) env().wGetValue("project");
		IProjectDescription desc = null;
		String[] oldNatures = null;
		try {
			desc = project.getDescription();

			oldNatures = desc.getNatureIds();			
			desc.setNatureIds(natures);

			project.setDescription(desc, progressMonitor());
		} catch (CoreException e) {
			if (desc != null && oldNatures != null) {
				desc.setNatureIds(natures);
				try {
					project.setDescription(desc, progressMonitor());
				} catch (CoreException e1) {
				}
			}
			//TODO show error nature not available
		}
	}
	public void visit(Nature entity) {
		env().wDefValue("nature", entity.wStringValue());
	}

	public void visitPackageArtifact(PackageArtifact entity) {
		env().wEnterScope();
		if (!Matcher.matchImplAndBind(ArtifactsEntityDescriptorEnum.Name,
				entity.getName(), env(), "packageName"))
			throw new VisitException("No Package name");

		entity.getMetadata().accept(this);

		try {
			IPath path;
			if (env().wIsSet("folder")) {
				IFolder parentFolder = (IFolder) env().wGetValue("folder");
				path = parentFolder.getFullPath();
			} else {
				IProject project = (IProject) env().wGetValue("project");
				path = project.getFullPath();
			}

			IWorkspaceRoot workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
			IFolder folder = null;
			String[] packagePath = env().wStringValue("packageName").split("\\.");
			for (int i = 0; i < packagePath.length; i++) {
				path = path.append(packagePath[i]);

				folder = workspaceRoot.getFolder(path);
				
				if (!folder.exists())
					folder.create(true, true, progressMonitor());				
			}
			
			env().wDefValue("folder", folder);
			
			if (env().wIsSet("derived"))
				folder.setDerived(true, progressMonitor());
			if (env().wIsSet("readonly")) {
				ResourceAttributes attributes = folder.getResourceAttributes();
				if (attributes != null) {
					attributes.setReadOnly(true);
					folder.setResourceAttributes(attributes);
				}
			}
		} catch (CoreException e) {
			throw new VisitException(e);
//		} catch (NullPointerException e) {
//			throw new VisitException("No Project");
		}

		entity.getArtifacts().accept(this);
		env().wExitScope();
	}

	public void visitFolderArtifact(FolderArtifact entity) {
		env().wEnterScope();
		if (!Matcher.matchImplAndBind(ArtifactsEntityDescriptorEnum.Name,
				entity.getName(), env(), "folderName"))
			throw new VisitException("No Folder name");

		entity.getMetadata().accept(this);

		try {
			IPath path;
			if (env().wIsSet("folder")) {
				IFolder parentFolder = (IFolder) env().wGetValue("folder");
				path = parentFolder.getFullPath();
			} else {
				IProject project = (IProject) env().wGetValue("project");
				path = project.getFullPath();
			}

			IWorkspaceRoot workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
			IFolder folder = null;
			String[] folderPath = env().wStringValue("folderName").split("/");
			for (int i = 0; i < folderPath.length; i++) {
				path = path.append(folderPath[i]);

				folder = workspaceRoot.getFolder(path);
				
				if (!folder.exists())
					folder.create(true, true, progressMonitor());				
			}
			
			env().wDefValue("folder", folder);
			
			if (env().wIsSet("derived"))
				folder.setDerived(true, progressMonitor());
			if (env().wIsSet("readonly")) {
				ResourceAttributes attributes = folder.getResourceAttributes();
				if (attributes != null) {
					attributes.setReadOnly(true);
					folder.setResourceAttributes(attributes);
				}
			}
			
			if (env().wLocalNames().contains("source") && env().wIsSet("javaProject")) {
				List<IClasspathEntry> classpathEntries = new ArrayList<IClasspathEntry>();

				IJavaProject javaProject = (IJavaProject) env().wGetValue("javaProject");
				classpathEntries.addAll(Arrays.asList(javaProject.getRawClasspath()));
				
				IClasspathEntry sourceEntry = JavaCore.newSourceEntry(folder.getFullPath());
				if (classpathEntries.size() == 1 && ((IClasspathEntry) classpathEntries.get(0)).getPath().equals(javaProject.getPath()))
					classpathEntries.remove(0);
				else
					for (Iterator<IClasspathEntry> i = classpathEntries.iterator(); i.hasNext();) {
						IClasspathEntry entry = i.next();
						if (entry.getPath().equals(sourceEntry.getPath()))
							i.remove();
					}
				classpathEntries.add(0, sourceEntry);
				
				javaProject.setRawClasspath(
						(IClasspathEntry[]) classpathEntries
						.toArray(new IClasspathEntry[classpathEntries.size()]),
						progressMonitor());
			}
		} catch (CoreException e) {
			throw new VisitException(e);
//		} catch (NullPointerException e) {
//			throw new VisitException("No Project");
		}

		entity.getArtifacts().accept(this);
		env().wExitScope();
	}

	public void visitFileArtifact(FileArtifact entity) {
		env().wEnterScope();

		entity.getName().accept(this);
		if (!env().wIsSet("name"))
			throw new VisitException("No File name");

		String fileNameWithExtension = env().wStringValue("name");
		if (!ResourcesPlugin.getWorkspace().validateName(fileNameWithExtension, IResource.FILE).isOK())
			throw new VisitException("Invalid File name");
		env().wDefValue("fileNameWithExtension", fileNameWithExtension);
		env().wDefValue("fileName", StringUtils.stripFileExtension(fileNameWithExtension));
		env().wDefValue("fileExtension", StringUtils.getFileExtension(fileNameWithExtension));

		entity.getMetadata().accept(this);

		IFile file;
		if (env().wIsSet("folder")) {
			IFolder folder = (IFolder) env().wGetValue("folder");
			file = folder.getFile(fileNameWithExtension);
		} else {
			IProject project = (IProject) env().wGetValue("project");
			file = project.getFile(fileNameWithExtension);
		}

		env().wDefValue("persistenceProvider", new IFilePersistenceProvider(file, env()));
		IEntity result = InterpreterOperation.interpret(entity.getContent(), env()).getResult();
		try {
			if (result != null)
				writeContents(result);
		} catch (Exception e) {
			throw new VisitException(e);
		}

		env().wExitScope();
	}
}
