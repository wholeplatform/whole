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
package org.whole.lang.artifacts.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaCore;
import org.whole.lang.artifacts.factories.ArtifactsEntityFactory;
import org.whole.lang.artifacts.model.Artifact;
import org.whole.lang.artifacts.model.AttributeEnum;
import org.whole.lang.artifacts.model.Content;
import org.whole.lang.artifacts.model.FileArtifact;
import org.whole.lang.artifacts.model.FileName;
import org.whole.lang.artifacts.model.FolderArtifact;
import org.whole.lang.artifacts.model.Metadata;
import org.whole.lang.artifacts.model.NameWithExtension;
import org.whole.lang.artifacts.model.PackageArtifact;
import org.whole.lang.artifacts.model.PersistenceKitId;
import org.whole.lang.artifacts.model.Project;
import org.whole.lang.artifacts.model.Workspace;
import org.whole.lang.artifacts.reflect.ArtifactsEntityDescriptorEnum;
import org.whole.lang.artifacts.reflect.ArtifactsFeatureDescriptorEnum;
import org.whole.lang.artifacts.visitors.LoadContentsVisitor;
import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.codebase.IFilePersistenceProvider;
import org.whole.lang.codebase.IPersistenceKit;
import org.whole.lang.codebase.IPersistenceProvider;
import org.whole.lang.commons.factories.CommonsEntityAdapterFactory;
import org.whole.lang.commons.factories.CommonsEntityFactory;
import org.whole.lang.commons.model.Resolver;
import org.whole.lang.commons.reflect.CommonsEntityDescriptorEnum;
import org.whole.lang.factories.RegistryConfigurations;
import org.whole.lang.iterators.CollectionIterator;
import org.whole.lang.iterators.IEntityIterator;
import org.whole.lang.iterators.IteratorFactory;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.IEntity;
import org.whole.lang.model.NullEntity;
import org.whole.lang.reflect.ILanguageKit;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.util.EntityUtils;
import org.whole.lang.util.StringUtils;

/**
 * @author Riccardo Solmi, Enrico Persiani
 */
public class ArtifactsWorkspaceUtils {

	public static boolean existsPath(IEntity artifact) {
		return existsPath(artifact, null);
	}

	public static boolean existsPath(IEntity artifact, IEntity childArtifact) {
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

	public static void bindPath(IEntity artifact, IBindingManager bindings, boolean force) {
		if (!ArtifactsEntityDescriptorEnum.Artifact.isLanguageSupertypeOf(artifact.wGetEntityDescriptor()) &&
				!Matcher.match(ArtifactsEntityDescriptorEnum.Workspace, artifact) &&
				!Matcher.match(ArtifactsEntityDescriptorEnum.Project, artifact))
			throw new IllegalArgumentException("Wrong path ending with: "+artifact.toString());

		IEntityIterator<IEntity> pathIterator = new AncestorOrSelfInSameLanguageReverseIterator();
		pathIterator.reset(artifact);

		if (!pathIterator.hasNext())
			throw new IllegalArgumentException("Empty model");

		if (CommonsEntityDescriptorEnum.RootFragment.equals(pathIterator.lookahead().wGetEntityDescriptor()))
			pathIterator.next();

		IEntity rootEntity = pathIterator.next();
		if (!Matcher.matchImpl(ArtifactsEntityDescriptorEnum.Workspace, rootEntity))
			throw new IllegalArgumentException("Missing Workspace root entity");

		bindMetadata(((Workspace) rootEntity).getMetadata(), bindings);

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
				case ArtifactsEntityDescriptorEnum.PackageArtifact_ord:
					bindPackage((PackageArtifact) pathFragment, bindings, force);
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
		bindMetadata(projectEntity.getMetadata(), bindings);
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
		bindMetadata(folderEntity.getMetadata(), bindings);
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

	private static void bindPackage(PackageArtifact packageEntity, IBindingManager bindings, boolean force) {
		bindings.wEnterScope();
		if (!Matcher.matchImplAndBind(ArtifactsEntityDescriptorEnum.Name, packageEntity.getName(), bindings, "packageName"))
			throw new IllegalArgumentException("No Folder name");
		bindMetadata(packageEntity.getMetadata(), bindings);
		IWorkspaceRoot workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
		IFolder folder = workspaceRoot.getFolder(getParentPath(bindings).append(StringUtils.packagePath(bindings.wStringValue("packageName"))));
		bindings.wDefValue("folder", folder);
		if (!folder.exists()) {
			if(!force)
				throw new IllegalArgumentException("Missing Package: "+bindings.wStringValue("packageName"));
			else {
				try {
					folder.create(true, true, (IProgressMonitor) bindings.wGetValue("progressMonitor"));
				} catch (Exception e) {
					throw new IllegalArgumentException("Cannot create Package: "+bindings.wStringValue("packageName"));
				}
			}
		}
		bindings.wExitScope(true);
	}

	private static void bindFile(FileArtifact fileEntity, IBindingManager bindings, boolean force) {
		bindings.wEnterScope();
		if (!Matcher.matchImplAndBind(ArtifactsEntityDescriptorEnum.Name, fileEntity.getName(), bindings, "fileName")) {
			NameWithExtension name = (NameWithExtension) fileEntity.getName();
			if (!Matcher.matchImplAndBind(ArtifactsEntityDescriptorEnum.Name, name.getName(), bindings, "fileName"))
				throw new IllegalArgumentException("No File name");
			if (!Matcher.matchImplAndBind(ArtifactsEntityDescriptorEnum.Extension, name.getExtension(), bindings, "extension"))
				throw new IllegalArgumentException("No File name");
		}
		bindMetadata(fileEntity.getMetadata(), bindings);
		IWorkspaceRoot workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
		IFile file = workspaceRoot.getFile(getParentPath(bindings).append(bindings.wIsSet("extension") ?
				bindings.wStringValue("fileName")+'.'+bindings.wStringValue("extension") : bindings.wStringValue("fileName")));
		bindings.wDefValue("file", file);
		if (!file.exists() && !force)
			throw new IllegalArgumentException("Missing File: "+bindings.wStringValue("fileName"));
		bindings.wExitScope(true);
	}

	private static void bindMetadata(Metadata metadata, IBindingManager bindings) {
		if (!EntityUtils.isImpl(metadata))
			return;
		
		PersistenceKitId persistenceKitId = metadata.getPersistenceKitId();
		if (EntityUtils.isImpl(persistenceKitId))
			bindings.wDef("persistenceKitId", persistenceKitId);
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

	public static IEntity toArtifactsPath(IResource fromResource, IResource toResource) {
		return toArtifactsPath(fromResource, toResource, NullEntity.instance);
	}
	public static IEntity toArtifactsPath(IResource fromResource, IResource toResource, IEntity child) {
		ArtifactsEntityFactory aef = ArtifactsEntityFactory.instance(RegistryConfigurations.RESOLVER);

		IEntity entity;
		String name = toResource.getName();
		switch (toResource.getType()) {
		case IResource.FILE:
			FileArtifact fileArtifact = aef.createFileArtifact();
			fileArtifact.setName(createFileName(name));
			entity = fileArtifact;
			break;
		case IResource.FOLDER:
			FolderArtifact folderArtifact = aef.createFolderArtifact();
			folderArtifact.setName(aef.createName(name));
			folderArtifact.setArtifacts(aef.createArtifacts(0));
			entity = folderArtifact;
			break;
		case IResource.PROJECT:
			Project project = aef.createProject();
			project.setName(aef.createName(name));
			project.setArtifacts(aef.createArtifacts(0));
			entity = project;
			break;
		default:
		case IResource.ROOT:
			Workspace workspace = aef.createWorkspace();
			workspace.setProjects(aef.createProjects(0));
			entity = workspace;
			break;
		}
		boolean isWorkspace = Matcher.match(ArtifactsEntityDescriptorEnum.Workspace, entity);
		if (!EntityUtils.isNull(child))
			entity.wGet(isWorkspace ? ArtifactsFeatureDescriptorEnum.projects :
				ArtifactsFeatureDescriptorEnum.artifacts).wAdd(child);

		return fromResource.equals(toResource) ? entity : toArtifactsPath(fromResource, toResource.getParent(), entity);
	}
	public static IEntity toArtifactsPath(IJavaElement fromJavaElement, IJavaElement toJavaElement) {
		return toArtifactsPath(fromJavaElement, toJavaElement, NullEntity.instance);
	}
	public static IEntity toArtifactsPath(IJavaElement fromJavaElement, IJavaElement toJavaElement, IEntity child) {
		ArtifactsEntityFactory aef = ArtifactsEntityFactory.instance(RegistryConfigurations.RESOLVER);

		IEntity entity;
		String name = toJavaElement.getElementName();
		switch (toJavaElement.getElementType()) {
		case IJavaElement.COMPILATION_UNIT:
			FileArtifact fileArtifact = aef.createFileArtifact();
			fileArtifact.setName(createFileName(name));
			entity = fileArtifact;
			break;
		case IJavaElement.PACKAGE_FRAGMENT:
			if (name == IPackageFragment.DEFAULT_PACKAGE_NAME)
				return fromJavaElement.equals(toJavaElement) ?
						child : toArtifactsPath(fromJavaElement, toJavaElement.getParent(), child);

			PackageArtifact packageArtifact = aef.createPackageArtifact();
			packageArtifact.setName(aef.createName(name));
			entity = packageArtifact;
			break;
		case IJavaElement.PACKAGE_FRAGMENT_ROOT:
			FolderArtifact folderArtifact = aef.createFolderArtifact();
			Metadata metadata = aef.createMetadata();
			metadata.setAttributes(aef.createAttributes(aef.createAttribute(AttributeEnum.source)));
			folderArtifact.setMetadata(metadata);
			folderArtifact.setName(aef.createName(name));
			entity = folderArtifact;
			break;
		case IJavaElement.JAVA_PROJECT:
			Project project = aef.createProject();
			project.setName(aef.createName(name));
			project.setNatures(aef.createNatures(aef.createNature("org.eclipse.jdt.core.javanature")));
			project.setArtifacts(aef.createArtifacts(0));
			entity = project;
			break;
		default:
		case IJavaElement.JAVA_MODEL:
			Workspace workspace = aef.createWorkspace();
			workspace.setProjects(aef.createProjects(0));
			entity = workspace;
			break;
		}
		boolean isWorkspace = Matcher.match(ArtifactsEntityDescriptorEnum.Workspace, entity);
		if (!EntityUtils.isNull(child))
			entity.wGet(isWorkspace ? ArtifactsFeatureDescriptorEnum.projects :
				ArtifactsFeatureDescriptorEnum.artifacts).wAdd(child);

		return fromJavaElement.equals(toJavaElement) ? entity : toArtifactsPath(fromJavaElement, toJavaElement.getParent(), entity);
	}
	public static IEntity toArtifactsPath(IJavaElement fromJavaElement, IResource toResource) {
		ArtifactsEntityFactory aef = ArtifactsEntityFactory.instance(RegistryConfigurations.RESOLVER);

		Artifact child;
		if (toResource.getType() == IResource.FILE) {
			FileArtifact fileArtifact = aef.createFileArtifact();
			fileArtifact.setName(createFileName(toResource.getName()));
			child = fileArtifact;
		} else {
			FolderArtifact folderArtifact = aef.createFolderArtifact();
			folderArtifact.setName(aef.createName(toResource.getName()));
			child = folderArtifact;
		}

		return toArtifactsPath(fromJavaElement, JavaCore.create(toResource.getParent()), child);
	}

	public static IEntity getArtifacts(IEntity artifact) {
		ArtifactsEntityFactory aef = ArtifactsEntityFactory.instance(RegistryConfigurations.RESOLVER);
		IEntity children = BindingManagerFactory.instance.createTuple();
		
		if (Matcher.match(ArtifactsEntityDescriptorEnum.Workspace, artifact)) {
			IWorkspaceRoot workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
			for (IProject project : workspaceRoot.getProjects()) {
				Project projectArtifact = aef.createProject();
				projectArtifact.setName(aef.createName(project.getName()));
				projectArtifact.setArtifacts(aef.createArtifacts(0));
				children.wAdd(projectArtifact);
			}
		} else {
			try {
				IBindingManager bindings = BindingManagerFactory.instance.createBindingManager();
				bindPath(artifact, bindings, false);
				IContainer container = (IContainer) (bindings.wIsSet("folder") ?
						bindings.wGetValue("folder") : bindings.wGetValue("project"));
				IJavaElement javaContainer = JavaCore.create(container);
				if (javaContainer == null || javaContainer.getElementType() == IJavaElement.JAVA_PROJECT) {
					for (IResource resource : container.members()) {
						if (resource.getType() == IResource.FILE) {
							appendFileArtifact(((IFile) resource).getName(), children);
						} else {
							FolderArtifact folderArtifact = aef.createFolderArtifact();
							Metadata metadata = aef.createMetadata();
							metadata.setAttributes(aef.createAttributes(aef.createAttribute(AttributeEnum.source)));
							folderArtifact.setMetadata(metadata);
							folderArtifact.setName(aef.createName(StringUtils.getFileName(resource.getName())));
							folderArtifact.setArtifacts(aef.createArtifacts(0));
							children.wAdd(folderArtifact);
						}
					}
				} else {
					if (javaContainer.getElementType() == IJavaElement.PACKAGE_FRAGMENT_ROOT) {
						IPackageFragmentRoot fragmentRoot = (IPackageFragmentRoot) javaContainer;
						if (fragmentRoot.getKind() == IPackageFragmentRoot.K_SOURCE) {
							for (IJavaElement element : fragmentRoot.getChildren()) {
								if (element.getElementType() == IJavaElement.PACKAGE_FRAGMENT) {
									if (element.getElementName() == IPackageFragment.DEFAULT_PACKAGE_NAME) {
										appendPackageFragmentChildren((IPackageFragment) element, children);
									} else {
										PackageArtifact packageArtifact = aef.createPackageArtifact();
										packageArtifact.setName(aef.createName(StringUtils.getFileName(element.getElementName())));
										packageArtifact.setArtifacts(aef.createArtifacts(0));
										children.wAdd(packageArtifact);
									}
								}
							}
						}
					} else // IJavaElement.PACKAGE_FRAGMENT
						appendPackageFragmentChildren((IPackageFragment) javaContainer, children);

				}
			} catch (Exception e) {
			}
		}

		return children;
	}
	
	protected static void appendPackageFragmentChildren(IPackageFragment packageFragment, IEntity children) throws Exception {
		for (ICompilationUnit cu : packageFragment.getCompilationUnits())
			appendFileArtifact(cu.getElementName(), children);
		
		for (Object resource : packageFragment.getNonJavaResources())
			if (resource instanceof IFile)
				appendFileArtifact(((IFile) resource).getName(), children);
	}

	protected static void appendFileArtifact(String nameWithExtension, IEntity children) {
		ArtifactsEntityFactory aef = ArtifactsEntityFactory.instance(RegistryConfigurations.RESOLVER);

		FileArtifact fileArtifact = aef.createFileArtifact();
		fileArtifact.setName(createFileName(nameWithExtension));
		children.wAdd(fileArtifact);
	}

	protected static FileName createFileName(String nameWithExtension) {
		ArtifactsEntityFactory aef = ArtifactsEntityFactory.instance(RegistryConfigurations.RESOLVER);

		String fileName = StringUtils.stripFileExtension(nameWithExtension);
		String extension = StringUtils.getFileExtension(nameWithExtension);
		if (fileName.length() > 0)
			return aef.createNameWithExtension(
					aef.createName(fileName),
					aef.createExtension(extension));
		else
			return aef.createName('.'+extension);
	}

	public static IEntity getPersistenceKits() {
		IEntity persistenceKitIds = BindingManagerFactory.instance.createTuple();
		for (IPersistenceKit persistenceKit : ReflectionFactory.getPersistenceKits())
			persistenceKitIds.wAdd(BindingManagerFactory.instance.createSpecificValue(
					ReflectionFactory.getPersistenceKit(persistenceKit.getId())));
		return persistenceKitIds;
	}

	public static IEntity getPersistenceKits(FileArtifact fileArtifact) {
		IEntity persistenceKitIds = BindingManagerFactory.instance.createTuple();
		IBindingManager bindings = BindingManagerFactory.instance.createBindingManager();
		bindPath(fileArtifact, bindings, false);
		if (bindings.wIsSet("persistenceKitId")) {
			persistenceKitIds.wAdd(
					BindingManagerFactory.instance.createSpecificValue(
							ReflectionFactory.getPersistenceKit(bindings.wStringValue("persistenceKitId"))));
			return persistenceKitIds;
		} else
			return getPersistenceKits();
	}
	public static IEntity getContents(FileArtifact fileArtifact, String persistenceKitId) {
		IBindingManager bindings = BindingManagerFactory.instance.createBindingManager();
		bindPath(fileArtifact, bindings, false);
		IFile file = (IFile) bindings.wGetValue("file");
		
		final IPersistenceProvider pp = new IFilePersistenceProvider(file);
		final Resolver resolver = CommonsEntityFactory.instance.createResolver();
		final Content fragment = CommonsEntityAdapterFactory.createStageUpFragment(
				ArtifactsEntityDescriptorEnum.Content, resolver);

		try {
			fragment.wSet(0, ReflectionFactory.getPersistenceKit(persistenceKitId).readModel(pp));
		} catch (Exception e) {
		}
		return fragment;
	}

	public static void loadContents(IEntity rootArtifact, IBindingManager bindings) {
		try {
			if (!Matcher.match(ArtifactsEntityDescriptorEnum.Project, rootArtifact) &&
				!Matcher.match(ArtifactsEntityDescriptorEnum.Workspace, rootArtifact))
				rootArtifact = (IEntity) rootArtifact.wGetParent().wGetParent();
			bindPath(rootArtifact, bindings, false);
		} catch(ClassCastException e) {
		}
		LoadContentsVisitor visitor = new LoadContentsVisitor(bindings);
		visitor.visit(rootArtifact);
	}

	public static class AncestorOrSelfInSameLanguageReverseIterator extends CollectionIterator<IEntity> {
		@Override
		protected Iterable<?> getCollectionIterable(IEntity entity) {
			List<IEntity> ancestors = new ArrayList<IEntity>();
			ILanguageKit languageKit = entity.wGetLanguageKit();

	        IEntityIterator<IEntity> iterator = IteratorFactory.ancestorOrSelfIterator();
	        iterator.reset(entity);
			for (IEntity parent : iterator) {
	        	if (languageKit.equals(parent.wGetLanguageKit()))
	        		ancestors.add(parent);
	        	else
	        		break;
			}
			Collections.reverse(ancestors);
			return ancestors;
		}
	}
}

