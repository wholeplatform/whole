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

import org.whole.lang.artifacts.builders.IArtifactsBuilder;
import org.whole.lang.artifacts.reflect.ArtifactsLanguageKit;
import org.whole.lang.artifacts.util.ArtifactsUtils;
import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.builders.IBuilderOperation;
import org.whole.lang.commons.builders.ICommonsBuilder;
import org.whole.lang.commons.reflect.CommonsLanguageKit;
import org.whole.lang.templates.ITemplate;

/**
 * @author Enrico Persiani
 */
public class ResourceTemplate implements ITemplate {
	protected IArtifactsBuilder ab;
	protected ICommonsBuilder cb;
	protected IBindingManager bindings;
	private File filesystemRoot;

	public ResourceTemplate(File filesystemRoot) {
		this.bindings = BindingManagerFactory.instance.createBindingManager();
		this.bindings.wDefValue("purge", false);
		setFilesystemRoot(filesystemRoot);
	}

	public ResourceTemplate() {
		this(null);
	}

	public IBindingManager getBindings() {
		return bindings;
	}

	public void setFilesystemRoot(File filesystemRoot) {
		this.filesystemRoot = filesystemRoot;
	}

	protected File getFilesystemRoot() {
		return filesystemRoot;
	}

	protected boolean testAndClearPurge() {
		if (getBindings().wBooleanValue("purge")) {
			getBindings().wSetValue("purge", false);
			return true;
		} else
			return false;
	}

	public void apply(IBuilderOperation op) {
		ab = (IArtifactsBuilder) op.wGetBuilder(ArtifactsLanguageKit.URI);
		cb = (ICommonsBuilder) op.wGetBuilder(CommonsLanguageKit.URI);
		buildArtifactsModel();
	}

	protected void buildArtifactsModel() {
		testAndClearPurge();
		buildArtifact(getFilesystemRoot());
	}

	protected void buildArtifact(File artifact) {
		if (artifact.isDirectory())
			buildDirectory(artifact);
		else if (artifact.isFile())
			buildFile(artifact);
	}

	protected void buildMetadata(String... attributes) {
		if (attributes.length > 0) {
			ab.Metadata_();
			cb.Resolver();
			cb.Resolver();
			cb.Resolver();
			ab.Attributes_(attributes.length);
			for (String attribute : attributes)
				ab.Attribute(attribute);
			ab._Attributes();
			cb.Resolver();
			ab._Metadata();
		} else
			cb.Resolver();
	}

	protected void buildFile(File file) {
		getBindings().wEnterScope();
		ab.FileArtifact_();
		String fileName = file.getName();
		int dotOffset = fileName.lastIndexOf(ArtifactsUtils.FILE_NAME_SEPARATOR);
		if (dotOffset >= 0) {
			ab.NameWithExtension_();
			ab.Name(fileName.substring(0, dotOffset));
			ab.Extension(fileName.substring(dotOffset + ArtifactsUtils.FILE_NAME_SEPARATOR.length()));
			ab._NameWithExtension();
		} else
			ab.Name(fileName);
		getBindings().wDefValue("file", file);
		getBindings().wDefValue("fileName", fileName);
		if (!file.canWrite())
			buildMetadata("readonly");
		else
			buildMetadata();
		cb.Resolver();
		ab._FileArtifact();
		getBindings().wExitScope();
	}

	protected void buildDirectory(File directory) {
		getBindings().wEnterScope();
		ab.FolderArtifact_();
		String directoryName = directory.getName();
		ab.Name(directoryName);
		getBindings().wDefValue("file", directory);
		getBindings().wDefValue("fileName", directoryName);
		if (!directory.canWrite())
			buildMetadata("readonly");
		else
			buildMetadata();
		if (!testAndClearPurge()) {
			File[] artifacts = directory.listFiles();
			if (artifacts.length > 0) {
				Arrays.sort(artifacts, new Comparator<File>() {
					public int compare(File first, File second) {
						boolean isFirstDirectory = first.isDirectory();
						boolean isSecondDirectory = second.isDirectory();
						if (isFirstDirectory && !isSecondDirectory)
							return 1;
						else if (!isFirstDirectory && isSecondDirectory)
							return -1;
						else
							return first.getName().compareTo(second.getName());
					}
				});
				ab.Artifacts_(artifacts.length);
				for (File artifact : artifacts)
					buildArtifact(artifact);
				ab._Artifacts();
			} else
				ab.Artifacts();
		} else
			ab.Artifacts();
		ab._FolderArtifact();
		getBindings().wExitScope();
	}
}
