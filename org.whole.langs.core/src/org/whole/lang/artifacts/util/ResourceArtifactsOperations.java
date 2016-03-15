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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.whole.lang.artifacts.reflect.ArtifactsEntityDescriptorEnum;
import org.whole.lang.artifacts.templates.ResourceTemplate;
import org.whole.lang.builders.ModelBuilderOperation;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.IEntity;

/**
 * @author Enrico Persiani
 */
public class ResourceArtifactsOperations extends AbstractArtifactsOperations<File> {
	private File getChildFile(File resource, IEntity child) {
		String contextAbsolutePath = resource.getAbsolutePath();
		String name = ArtifactsUtils.getName(child);
		File member = new File(contextAbsolutePath+File.separator+name);
		// ensure artifact type
		if (member.exists() && Matcher.match(ArtifactsEntityDescriptorEnum.FileArtifact, child) != member.isFile())
			member = null;
		return member;
	}
	public File getParent(File resource) {
		return resource.getParentFile();
	}
	public File getChild(File resource, IEntity child) {
		return getChildFile(resource, child);
	}
	public void delete(File resource) {
		ArtifactsUtils.deleteTree(resource);
	}
	public IEntity toArtifactsModel(File resource) {
		ModelBuilderOperation mbo = new ModelBuilderOperation();
		ResourceTemplate resourceTemplate = new ResourceTemplate(resource);
		resourceTemplate.apply(mbo);
		return mbo.wGetResult();
	}
	public InputStream getContents(File resource) {
		try {
			return new FileInputStream(resource);
		} catch (FileNotFoundException e) {
			throw new IllegalArgumentException("cannot get contents");
		}
	}
}
