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
package org.whole.lang.artifacts.visitors;

import java.io.InputStream;

import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.whole.lang.artifacts.model.Attribute;
import org.whole.lang.artifacts.model.Extension;
import org.whole.lang.artifacts.model.FileArtifact;
import org.whole.lang.artifacts.model.FolderArtifact;
import org.whole.lang.artifacts.model.Name;
import org.whole.lang.artifacts.model.NameWithExtension;
import org.whole.lang.artifacts.model.PersistenceKitId;
import org.whole.lang.artifacts.model.Project;
import org.whole.lang.artifacts.reflect.ArtifactsEntityDescriptorEnum;
import org.whole.lang.artifacts.util.ArtifactsWorkspaceUtils;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.codebase.IPersistenceKit;
import org.whole.lang.codebase.IPersistenceProvider;
import org.whole.lang.codebase.StreamPersistenceProvider;
import org.whole.lang.commons.factories.CommonsEntityAdapterFactory;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.OperationCanceledException;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.util.StringUtils;

/**
 * @author Riccardo Solmi, Enrico Persiani
 */
public class LoadContentsVisitor extends ArtifactsTraverseAllVisitor {
	private IBindingManager bindings;

	public LoadContentsVisitor(IBindingManager bindings) {
		this.bindings = bindings;
	}

	public final IBindingManager env() {
		return bindings;
	}

	//FIXME progress setup
	private IProgressMonitor progressMonitor;
	public final IProgressMonitor progressMonitor() {
		if (progressMonitor == null) {
//			progressMonitor = wGetOperation().getProgressMonitor().getAdapter(IProgressMonitor.class);		
//			if (progressMonitor == null)
			progressMonitor = new NullProgressMonitor();
		}
		return progressMonitor;
	}

	@Override
	public void visit(FileArtifact file) {
		env().wEnterScope();
		file.getName().accept(this);
		file.getMetadata().accept(this);
		String fileName = env().wStringValue("name");
		IWorkspaceRoot workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
		IPath filePath = ArtifactsWorkspaceUtils.getParentPath(bindings).append(fileName);
		InputStream in;
		try {
			in = workspaceRoot.getFile(filePath).getContents(true);
		} catch (CoreException e) {
			throw new OperationCanceledException(e);
		}
		env().wDefValue("className", StringUtils.stripFileExtension(fileName));
		env().wDefValue("persistenceProvider", new StreamPersistenceProvider(in, null, env()));//TODO use IFile

		file.setContent(CommonsEntityAdapterFactory.createStageUpFragment(
				ArtifactsEntityDescriptorEnum.Content, readContents()));
		env().wExitScope();
	}
	private IEntity readContents() {
		IPersistenceProvider pp = (IPersistenceProvider) env().wGetValue("persistenceProvider");
		try {
			IPersistenceKit pk = ReflectionFactory.getPersistenceKit(env().wStringValue("persistenceKitId"));
			return pk.readModel(pp);
		} catch (Exception e) {
			throw new OperationCanceledException(e);
		}
	}

	@Override
	public void visit(Project project) {
		env().wEnterScope();
		project.getName().accept(this);
		project.getMetadata().accept(this);
		String projectName = env().wStringValue("name");
		IWorkspaceRoot workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
		env().wDefValue("projectName", projectName);
		env().wDefValue("project", workspaceRoot.getProject(projectName));
		project.getArtifacts().accept(this);
		env().wExitScope();
	}

	@Override
	public void visit(FolderArtifact folder) {
		env().wEnterScope();
		folder.getName().accept(this);
		folder.getMetadata().accept(this);
		String folderName = env().wStringValue("name");
		IWorkspaceRoot workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
		IPath folderPath = ArtifactsWorkspaceUtils.getParentPath(bindings).append(folderName);
		env().wDefValue("folderName", folderName);
		env().wDefValue("folder", workspaceRoot.getFolder(folderPath));
		folder.getArtifacts().accept(this);
		env().wExitScope();
	}

	//TODO add visit(PackageArtifact)


	public void visit(Name entity) {
		env().wDef("name", entity);
	}
	public void visit(Extension entity) {
		env().wDef("extension", entity);
	}
	public void visit(NameWithExtension entity) {
		super.visit(entity);
		env().wSetValue("name", env().wStringValue("name")+"."+env().wStringValue("extension"));
	}
	public void visit(Attribute entity) {
		env().wDefValue(entity.getValue().getName(), true);
	}
	public void visit(PersistenceKitId entity) {
		env().wDefValue("persistenceKitId", entity.wStringValue());
	}
}
