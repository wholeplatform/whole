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

import java.io.InputStream;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.whole.lang.artifacts.reflect.ArtifactsEntityDescriptorEnum;
import org.whole.lang.artifacts.templates.WorkspaceTemplate;
import org.whole.lang.builders.ModelBuilderOperation;
import org.whole.lang.model.IEntity;

/**
 * @author Enrico Persiani
 */
public class WorkspaceResourceOperations extends AbstractArtifactsOperations<IResource> {
	private IResource getChildResource(IResource resource, IEntity child) {
		String name = ArtifactsUtils.getName(child);
		if (child.wGetEntityDescriptor().getOrdinal() == ArtifactsEntityDescriptorEnum.PackageArtifact_ord) {
			IJavaElement javaElement = JavaCore.create(resource);
			try {
				return ((IPackageFragmentRoot) javaElement).getPackageFragment(name).getCorrespondingResource();
			} catch (JavaModelException e) {
				throw new IllegalStateException(e);
			}
		} else {
			IResource member = ((IContainer) resource).findMember(name);
			// ensure artifact type
			if (member != null) {
				int ensureType;
				switch (child.wGetEntityDescriptor().getOrdinal()) {
				case ArtifactsEntityDescriptorEnum.FileArtifact_ord:
					ensureType = IResource.FILE;
					break;
				case ArtifactsEntityDescriptorEnum.FolderArtifact_ord:
					ensureType = IResource.FOLDER;
					break;
				case ArtifactsEntityDescriptorEnum.Project_ord:
					ensureType = IResource.PROJECT;
					break;
				case ArtifactsEntityDescriptorEnum.Workspace_ord:
					ensureType = IResource.ROOT;
					break;
				default:
					throw new IllegalArgumentException("unsupported artifact type");
				}
				if (ensureType != member.getType())
					member = null;
			}
			return member;
		}
	}
	public IResource getParent(IResource resource) {
		return resource.getParent();
	}
	public IResource getChild(IResource resource, IEntity child) {
		return getChildResource(resource, child);
	}
	public void delete(IResource resource) {
		try {
			resource.delete(true, null);
		} catch (CoreException e) {
			throw new IllegalStateException(e);
		}
	}
	public IEntity toArtifactsModel(IResource resource) {
		ModelBuilderOperation mbo = new ModelBuilderOperation();
		WorkspaceTemplate resourceTemplate = new WorkspaceTemplate(resource, false);
		resourceTemplate.apply(mbo);
		return mbo.wGetResult();
	}
	public InputStream getContents(IResource resource) {
		try {
			return ((IFile) resource).getContents();
		} catch (CoreException e) {
			throw new IllegalArgumentException("cannot get contents");
		}
	}
}
