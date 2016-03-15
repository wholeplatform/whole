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

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.whole.lang.artifacts.model.FileArtifact;
import org.whole.lang.artifacts.model.FolderArtifact;
import org.whole.lang.artifacts.model.LocationURI;
import org.whole.lang.artifacts.model.Natures;
import org.whole.lang.artifacts.model.PackageArtifact;
import org.whole.lang.artifacts.model.Project;
import org.whole.lang.artifacts.model.Workspace;
import org.whole.lang.artifacts.reflect.ArtifactsEntityDescriptorEnum;
import org.whole.lang.codebase.FilePersistenceProvider;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.IOperationProgressMonitor;
import org.whole.lang.operations.InterpreterOperation;
import org.whole.lang.util.DataTypeUtils;
import org.whole.lang.util.StringUtils;
import org.whole.lang.visitors.VisitException;

/**
 * @author Riccardo Solmi, Enrico Persiani
 */
public class ResourceArtifactsGeneratorVisitor extends AbstractArtifactsGeneratorVisitor {
	private IOperationProgressMonitor progressMonitor;
	public final IOperationProgressMonitor progressMonitor() {
		if (progressMonitor == null)
			progressMonitor = getOperation().getProgressMonitor();		
		return progressMonitor;
	}

	//TODO rename ? build, ensure
	protected File getParentFolder() {
		if (env().wIsSet("folder"))
			return (File) env().wGetValue("folder");
		else if (env().wIsSet("folderLocation")) {
			File folder = new File(env().wStringValue("folderLocation"));
			if (!folder.exists())
				folder.mkdirs();

			return folder;
		} else
			throw new IllegalArgumentException("Missing parent folder or location");
	}

	public void visit(Workspace entity) {
		if (env().wIsSet("folderLocation")) {
			env().wEnterScope();

			entity.getMetadata().accept(this);
			entity.getProjects().accept(this);

			env().wExitScope();
		} else if (!entity.getProjects().isEmpty())
			throw new IllegalStateException("Workspace generation not supported yet");
	}

	public void visit(Project entity) {
		LocationURI locationURI = entity.getLocationURI();
		if (DataTypeUtils.getDataKind(locationURI).isString() || env().wIsSet("folder") || env().wIsSet("folderLocation")) {
			env().wEnterScope();
			if (!Matcher.matchImplAndBind(ArtifactsEntityDescriptorEnum.Name,
					entity.getName(), env(), "projectName"))
				throw new VisitException("No project name");

			entity.getMetadata().accept(this);

			File folder;
			if (DataTypeUtils.getDataKind(locationURI).isString()) {
				try {
					folder = new File(new URI(locationURI.getValue()));
				} catch (URISyntaxException e) {
					throw new IllegalArgumentException("Invalid project location URI specified", e);
				}
			} else {
				File parentFolder = getParentFolder();
				String path = parentFolder.getAbsolutePath();
				String projectPath = path + File.separatorChar + env().wStringValue("projectName");
				folder = new File(projectPath);
			}
			if (!folder.exists())
				folder.mkdirs();

			env().wDefValue("folder", folder);
			
			entity.getNatures().accept(this);
			entity.getArtifacts().accept(this);

			env().wExitScope();
		} else
			throw new IllegalStateException("Project generation not supported yet");
	}

	public void visit(Natures entity) {
		//TODO add natures
	}

	public void visit(PackageArtifact entity) {
		env().wEnterScope();
		if (!Matcher.matchImplAndBind(ArtifactsEntityDescriptorEnum.Name,
				entity.getName(), env(), "packageName"))
			throw new VisitException("No Package name");

		entity.getMetadata().accept(this);

		File parentFolder = getParentFolder();
		String path = parentFolder.getAbsolutePath();

		String packagePath = path + File.separatorChar + env().wStringValue("packageName").replace('.', File.separatorChar);
		File folder = new File(packagePath);
		if (!folder.exists())
			folder.mkdirs();

		env().wDefValue("folder", folder);

		if (env().wIsSet("derived"))
			; // not implemented yet

		if (env().wIsSet("readonly")) 
			folder.setReadOnly();

		entity.getArtifacts().accept(this);
		env().wExitScope();
	}

	public void visit(FolderArtifact entity) {
		env().wEnterScope();
		if (!Matcher.matchImplAndBind(ArtifactsEntityDescriptorEnum.Name,
				entity.getName(), env(), "folderName"))
			throw new VisitException("No Folder name");

		entity.getMetadata().accept(this);

		File parentFolder = getParentFolder();
		String path = parentFolder.getAbsolutePath();

		String folderPath = path + File.separatorChar + env().wStringValue("folderName").replace('/', File.separatorChar);
		File folder = new File(folderPath);
		if (!folder.exists())
			folder.mkdirs();

		env().wDefValue("folder", folder);

		if (env().wIsSet("derived"))
			; // not implemented yet

		if (env().wIsSet("readonly") && folder.canWrite()) {
			folder.setReadOnly();
		}

		if (env().wLocalNames().contains("source") && env().wIsSet("javaProject"))
			; // not implemented yet

		entity.getArtifacts().accept(this);
		env().wExitScope();
	}

	public void visit(FileArtifact entity) {
		env().wEnterScope();

		entity.getName().accept(this);
		if (!env().wIsSet("name"))
			throw new VisitException("No File name");

		String fileNameWithExtension = env().wStringValue("name");
		env().wDefValue("fileNameWithExtension", fileNameWithExtension);
		env().wDefValue("fileName", StringUtils.stripFileExtension(fileNameWithExtension));
		env().wDefValue("fileExtension", StringUtils.getFileExtension(fileNameWithExtension));

		if (fileNameWithExtension.indexOf(File.separatorChar) != -1
				|| fileNameWithExtension.indexOf('/') != -1)
			throw new VisitException("Invalid File name");

		entity.getMetadata().accept(this);

		File parentFolder = getParentFolder();
		File file = new File(parentFolder.getAbsolutePath()+File.separatorChar+fileNameWithExtension);

		try {
			if (!file.exists())
				file.createNewFile();

			env().wDefValue("persistenceProvider", new FilePersistenceProvider(file, env()));

			IEntity result = InterpreterOperation.interpret(entity.getContent(), env()).getResult();
			if (result != null)
				writeContents(result);

		} catch (IOException e) {
			throw new VisitException(e);
		}

		if (env().wIsSet("derived"))
			; // not implemented yet

		if (env().wIsSet("readonly") && file.canWrite())
			file.setReadOnly();

		env().wExitScope();
	}
}
