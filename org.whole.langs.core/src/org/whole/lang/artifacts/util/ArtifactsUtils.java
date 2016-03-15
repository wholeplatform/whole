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

import static org.whole.lang.artifacts.reflect.ArtifactsEntityDescriptorEnum.FileArtifact;
import static org.whole.lang.artifacts.reflect.ArtifactsFeatureDescriptorEnum.artifacts;
import static org.whole.lang.artifacts.reflect.ArtifactsFeatureDescriptorEnum.metadata;
import static org.whole.lang.artifacts.reflect.ArtifactsFeatureDescriptorEnum.name;
import static org.whole.lang.artifacts.reflect.ArtifactsFeatureDescriptorEnum.projects;

import java.io.File;

import org.whole.lang.artifacts.model.Artifact;
import org.whole.lang.artifacts.model.Artifacts;
import org.whole.lang.artifacts.model.FileArtifact;
import org.whole.lang.artifacts.model.FileName;
import org.whole.lang.artifacts.model.FolderArtifact;
import org.whole.lang.artifacts.model.Metadata;
import org.whole.lang.artifacts.model.NameWithExtension;
import org.whole.lang.artifacts.model.PackageArtifact;
import org.whole.lang.artifacts.model.PersistenceKitId;
import org.whole.lang.artifacts.model.Project;
import org.whole.lang.artifacts.model.Projects;
import org.whole.lang.artifacts.model.Workspace;
import org.whole.lang.artifacts.reflect.ArtifactsEntityDescriptorEnum;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.codebase.IPersistenceKit;
import org.whole.lang.commons.factories.CommonsEntityAdapterFactory;
import org.whole.lang.factories.GenericEntityFactory;
import org.whole.lang.factories.IEntityFactory;
import org.whole.lang.factories.RegistryConfigurations;
import org.whole.lang.iterators.IEntityIterator;
import org.whole.lang.iterators.IteratorFactory;
import org.whole.lang.matchers.GenericMatcherFactory;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reflect.EntityKinds;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.util.DataTypeUtils;
import org.whole.lang.util.EntityUtils;
import org.whole.lang.visitors.GenericTraversalFactory;

/**
 * @author Enrico Persiani
 */
public class ArtifactsUtils {
	private static final String WORKSPACEROOT_NAME = "";
	public static final String FILE_NAME_SEPARATOR = ".";
	
	public static String getName(IEntity artifact) {
		switch (artifact.wGetEntityOrd()) {
		case ArtifactsEntityDescriptorEnum.FileArtifact_ord:
			FileName filename = ((FileArtifact)artifact).getName();
			if (DataTypeUtils.getDataKind(filename).isString())
				return filename.wStringValue();
			else {
				NameWithExtension nameWithExtension = (NameWithExtension) filename;
				return nameWithExtension.getName().wStringValue() + FILE_NAME_SEPARATOR +
					nameWithExtension.getExtension().wStringValue();
			}
		case ArtifactsEntityDescriptorEnum.FolderArtifact_ord:
			return ((FolderArtifact)artifact).getName().wStringValue();
		case ArtifactsEntityDescriptorEnum.Project_ord:
			return ((Project)artifact).getName().wStringValue();
		case ArtifactsEntityDescriptorEnum.PackageArtifact_ord:
			return ((PackageArtifact)artifact).getName().wStringValue();
		case ArtifactsEntityDescriptorEnum.Workspace_ord:
			return WORKSPACEROOT_NAME;
		default:
			throw new IllegalArgumentException("No name feature in \""+artifact.toString()+"\" entity.");
		}
	}

	public static String getPersistenceKitId(IEntity artifact) {
		IEntity metaData = artifact.wGet(metadata);
		if (!EntityUtils.isNotResolver(metaData))
			return null;
		PersistenceKitId persistenceKitId = ((Metadata) metaData).getPersistenceKitId();
		return DataTypeUtils.getDataKind(persistenceKitId).isString() ? persistenceKitId.getValue() : null;
	}
	
	public static boolean deleteTree(File path) {
		if (!path.exists())
			return false;
	
		if (path.isDirectory())
			for(File file : path.listFiles())
				deleteTree(file);
		return path.delete();
	}

	public static boolean isFileArtifact(IEntity entity) {
		return Matcher.match(FileArtifact, entity);
	}
	public static IEntity getChildren(IEntity entity) {
		return entity.wGet(entity.wContains(projects) ? projects : artifacts);
	}
	public static boolean hasChild(IEntity entity, IEntity child) {
		return getChild(entity, child) != null;
	}
	public static IEntity getChild(IEntity entity, IEntity child) {
		IEntityIterator<IEntity> iterator = IteratorFactory.childMatcherIterator().withPattern(createPattern(child));
		iterator.reset(entity);
		return iterator.hasNext() ? iterator.next() : null;
	}
	private static IEntity createPattern(IEntity child) {
		IEntity pattern = EntityUtils.clone(child);
		EntityDescriptor<?> ed = pattern.wGetEntityDescriptor();
		for (FeatureDescriptor fd : ed.getEntityFeatureDescriptors()) {
			if (!name.equals(fd))
				pattern.wSet(fd, CommonsEntityAdapterFactory
						.createVariable(fd.getEntityDescriptor(), fd.getName()));
		}
		return pattern;
	}

	public static IEntity cloneArtifact(IEntity artifact) {
		return cloneArtifact(artifact, null);
	}
	public static IEntity cloneArtifact(IEntity artifact, IEntity appendChild) {
		IEntityFactory ef = GenericEntityFactory.instance(RegistryConfigurations.RESOLVER);
		EntityDescriptor<?> ed = artifact.wGetEntityDescriptor();

		IEntity newArtifact = ef.create(ed);
		for (FeatureDescriptor fd : ed.getEntityFeatureDescriptors()) {
			if (artifacts.equals(fd) || projects.equals(fd)) {
				IEntity composite = newArtifact.wGet(fd);
				if (appendChild != null)
					composite.wAdd(appendChild);
				else
					composite.wResolveWith(fd.getEntityDescriptor());
			} else
				newArtifact.wSet(fd, EntityUtils.clone(artifact.wGet(fd)));
		}
		return newArtifact;
	}

	public static IPersistenceKit calculateInheritedPersistence(IEntity model, IPersistenceKit defaultPersistenceKit) {
		IEntityIterator<IEntity> iterator = IteratorFactory.scannerIterator(
					IteratorFactory.ancestorOrSelfIterator())
							.withPattern(GenericTraversalFactory.instance.one(
									GenericMatcherFactory.instance.isFragmentMatcher(),
									GenericMatcherFactory.instance.hasKindMatcher(EntityKinds.COMPOSITE)));

		iterator.reset(model);
		while (iterator.hasNext()) {
			String persistenceKitId = getPersistenceKitId(iterator.next());
			if (persistenceKitId != null)
				return ReflectionFactory.getPersistenceKit(persistenceKitId);
		}

		return defaultPersistenceKit;
	}

	public static void moveArtifactsIntoWorkspace(IEntity artifacts, IBindingManager bm) {
		switch (artifacts.wGetEntityDescriptor().getOrdinal()) {
		case ArtifactsEntityDescriptorEnum.Workspace_ord:
			Projects projectsPoint = (Projects) bm.wGet("projectsPoint");
			if (projectsPoint == null)
				throw new IllegalArgumentException("projectsPoint is undefined");

			IEntityIterator<Project> projectIterator = IteratorFactory.childIterator();
			projectIterator.reset(((Workspace) artifacts).getProjects());
			for (Project project : projectIterator) {
				projectIterator.remove();
				projectsPoint.add(project);
			}
			break;
		case ArtifactsEntityDescriptorEnum.Artifacts_ord:
			Artifacts packagesPoint = (Artifacts) bm.wGet("packagesPoint");
			if (packagesPoint == null)
				throw new IllegalArgumentException("packagesPoint is undefined");

			IEntityIterator<Artifact> artifactIterator = IteratorFactory.childIterator();
			artifactIterator.reset(artifacts);
			for (Artifact artifact : artifactIterator) {
				artifactIterator.remove();
				packagesPoint.add(artifact);
			}
			break;
		case ArtifactsEntityDescriptorEnum.PackageArtifact_ord:
		case ArtifactsEntityDescriptorEnum.FolderArtifact_ord:
			packagesPoint = (Artifacts) bm.wGet("packagesPoint");
			if (packagesPoint == null)
				throw new IllegalArgumentException("packagesPoint is undefined");

			packagesPoint.add((Artifact) artifacts);
			break;
		case ArtifactsEntityDescriptorEnum.FileArtifact_ord:
			Artifacts packageArtifactsPoint = (Artifacts) bm.wGet("packageArtifactsPoint");
			if (packageArtifactsPoint == null)
				throw new IllegalArgumentException("packageArtifactsPoint is undefined");

			packageArtifactsPoint.add((FileArtifact) artifacts);
			break;
		}
	}
}
