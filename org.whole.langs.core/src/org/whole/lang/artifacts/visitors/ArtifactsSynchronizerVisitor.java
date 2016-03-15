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

import static org.whole.lang.artifacts.util.ArtifactsUtils.*;

import java.util.Stack;

import org.whole.lang.artifacts.model.FileArtifact;
import org.whole.lang.artifacts.model.IArtifactsEntity;
import org.whole.lang.artifacts.reflect.ArtifactsFeatureDescriptorEnum;
import org.whole.lang.artifacts.util.IArtifactsOperations;
import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.codebase.IPersistenceKit;
import org.whole.lang.commons.factories.CommonsEntityAdapterFactory;
import org.whole.lang.commons.model.QuantifierEnum;
import org.whole.lang.iterators.IEntityIterator;
import org.whole.lang.iterators.IteratorFactory;
import org.whole.lang.matchers.GenericMatcherFactory;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.ArtifactsGeneratorOperation;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reflect.EntityKinds;
import org.whole.lang.util.EntityUtils;
import org.whole.lang.visitors.GenericTraversalFactory;
import org.whole.lang.visitors.VisitException;

/**
 * @author Enrico Persiani
 */
public class ArtifactsSynchronizerVisitor<T> extends ArtifactsResourceVisitor<T> {
	private static final String SUB_TREE_ROOT = "subTreeRoot";

	private Traverse traverse;
	private Synchronize synchronize;
	private Stack<IEntity> compareToEntityStack;
	private boolean isLoading;
	private boolean firstPass;

	public ArtifactsSynchronizerVisitor(IArtifactsOperations<T> artifactsOperations,
			T rootResource, Traverse traverse, Synchronize synchronize,
			boolean isLoading) {

		super(artifactsOperations, rootResource);
		this.traverse = traverse;
		this.synchronize = synchronize;
		this.compareToEntityStack = new Stack<IEntity>();
		this.isLoading = isLoading;
		this.firstPass = !traverse.isDirectoryStructure();
	}

	private IEntity createFilesystemModel(IArtifactsEntity model, IEntity basePath, boolean append) {
		T parentContext = getResource();
		IEntity artifact = basePath;

		if (basePath != null) {
			parentContext = getArtifactsOperations().getParent(parentContext);
	
			if (getArtifactsOperations().getChild(parentContext, basePath) == null)
				throw new IllegalArgumentException("invalid root resource");
	
			while (artifact != null && EntityUtils.isNotResolver(artifact) && !EntityUtils.isVariable(artifact)) {
				parentContext = getArtifactsOperations().getChild(parentContext, artifact);
				if (parentContext == null)
					break;
				IEntity children = getChildren(artifact);
				artifact = children.wIsEmpty() ? null : children.wGet(0);
			}
		}

		if (parentContext == null) {
			// cannot find path on file system
			if (artifact == basePath)
				// no file system root at all
				getChildren(basePath).wRemove(0);
			else
				// partial file system path
				artifact.wGetParent().wRemove(artifact);
		} else {
			// empty path or exists on file system 
			IEntity fsModel = getArtifactsOperations().toArtifactsModel(parentContext);
			if (append && artifact != basePath) {
				IBindingManager bindings = BindingManagerFactory.instance.createBindingManager();
				IEntityIterator<IEntity> iterator = IteratorFactory.childIterator();
				iterator.reset(getChildren(fsModel));
				for (IEntity child : iterator) {
					bindings.wDef(SUB_TREE_ROOT, child);
					iterator.remove();
					Matcher.substitute(basePath, bindings, false);
				}
				Matcher.removeVars(basePath, true);
			} else
				basePath = fsModel;
		}
		return basePath;
	}

	private IEntity createBasePath(IArtifactsEntity entity) {
		IEntityIterator<IEntity> iterator = IteratorFactory.scannerIterator(
					IteratorFactory.ancestorIterator())
							.withPattern(GenericTraversalFactory.instance.one(
									GenericMatcherFactory.instance.isFragmentMatcher(),
									GenericMatcherFactory.instance.hasKindMatcher(EntityKinds.COMPOSITE)));

		iterator.reset(entity);

		// build the ancestors path
		IEntity patternPath = null;
		if (iterator.hasNext()) {
			EntityDescriptor<?> ed = getChildren(entity).wGetEntityDescriptor(0);
			patternPath = cloneArtifact(entity, CommonsEntityAdapterFactory.createVariable(
					ed, SUB_TREE_ROOT, ed, QuantifierEnum.ONE_OR_MORE_GREEDY));
		}
		while (iterator.hasNext())
			patternPath = cloneArtifact(iterator.next(), patternPath);

		return patternPath;
	}
	private IArtifactsEntity initialize(IArtifactsEntity entity) {
		IEntity model;

		if (isLoading) {
			if (entity == null) {
				// build from scratch
				model = createFilesystemModel(entity, null, false);
				this.compareToEntityStack.push(cloneArtifact(model));
			} else {
				IEntity basePath = createBasePath(entity);
				model = createFilesystemModel(entity, basePath, false);
				this.compareToEntityStack.push(EntityUtils.clone(entity));
			}
		} else {
			IEntity basePath = createBasePath(entity);
			if (basePath != null) {
				IBindingManager bindings = BindingManagerFactory.instance.createBindingManager();
				model = EntityUtils.clone(basePath);
				IEntityIterator<IEntity> i = IteratorFactory.childIterator();
				i.reset(getChildren(entity));
				for (IEntity child : i) {
					bindings.wDef(SUB_TREE_ROOT, EntityUtils.clone(child));
					Matcher.substitute(model, bindings, false);
				}
				Matcher.removeVars(model, true);
			} else
				model = EntityUtils.clone(entity);

			// initialize the synchronization model
			IEntity filesystemModel = createFilesystemModel(entity, basePath, true);
			this.compareToEntityStack.push(filesystemModel);
	
		}
		return (IArtifactsEntity) model;
	}

	private void synchronize(IEntity children, IEntity compareToChildren) {
		// perform delete missing resources
		if (synchronize.isRemoving()) {
			IEntityIterator<IEntity> iterator = IteratorFactory.childIterator();
			iterator.reset(compareToChildren);
			while (iterator.hasNext()) {
				IEntity child = iterator.next();
				if (hasChild(children, child))
					continue;

				if (isLoading)
					iterator.remove();
				else
					getArtifactsOperations().deleteChild(getResource(), child);
			}
		}

		// perform remove additions
		if (synchronize.isUpdateOnly()) {
			IEntityIterator<IEntity> iterator = IteratorFactory.childIterator();
			iterator.reset(children);
			while (iterator.hasNext()) {
				IEntity child = iterator.next();
				if (!hasChild(compareToChildren, child))
					iterator.remove();
			}
		}
	}

	@Override
	protected void acceptChildren(IEntity entity) {
		IEntity compareToChildren = getChildren(compareToEntityStack.peek());
		IEntity children = getChildren(entity);

		// perform synchronization
		synchronize(children, compareToChildren);

		// traverse
		if (!firstPass && !traverse.isDirectoryStructure()) {
			while (!children.wIsEmpty())
				children.wRemove(0);
		} else {
			firstPass = false;

			IEntityIterator<IEntity> i = IteratorFactory.childIterator();
			i.reset(children);
			for (IEntity child : i) {
				// first pass, remove all descendants
				if (!traverse.isDirectoryStructure() && !isFileArtifact(child)) {
					IEntity descendants = getChildren(child);
					while (!descendants.wIsEmpty())
						descendants.wRemove(0);
				}
				if (!traverse.isFileContent() && isFileArtifact(child))
					child.wRemove(ArtifactsFeatureDescriptorEnum.content);

				// update stacks
				T childContext;
				IEntity compareToChild = getChild(compareToChildren, child);
				if (compareToChild == null ||
					(childContext = getArtifactsOperations().getChild(
								getResource(), compareToChild)) == null)
						continue;

				compareToEntityStack.push(compareToChild);
				acceptChild(child, childContext);
				compareToEntityStack.pop();
			}
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static IArtifactsEntity synchronize(IArtifactsEntity entity,
			Traverse traverse, Synchronize synchronize, IBindingManager bindings,
			IPersistenceKit defaultPersistenceKit, boolean isLoading) {

		Object rootResource = bindings.wGetValue("rootResource");
		IArtifactsOperations<Object> artifactsOperations = 
			(IArtifactsOperations<Object>) bindings.wGetValue("artifactsOperations");

		ArtifactsSynchronizerVisitor<?> visitor = 
			new ArtifactsSynchronizerVisitor(artifactsOperations, rootResource,
					traverse, synchronize, isLoading);
		IArtifactsEntity result = visitor.initialize(entity);
		result.accept(visitor);

		if (!isLoading)
			ArtifactsGeneratorOperation.generate(result, bindings);
		else if (traverse.isFileContent()) {
			Object context = artifactsOperations.getDescendant(rootResource, entity);
			defaultPersistenceKit = calculateInheritedPersistence(entity, defaultPersistenceKit);
			ArtifactsLoadFileContentsVisitor.loadContents(result, artifactsOperations, context, defaultPersistenceKit);
		}
		return result;
	}

	@Override
	public void visit(IArtifactsEntity entity) {
		throw new VisitException("unsupported entity");
	}

	@Override
	public void visit(FileArtifact entity) {
		IEntity parent = entity.wGetParent();
		if (!EntityUtils.isNull(parent) && !isLoading  && !traverse.isFileContent())
			parent.wRemove(entity);
	}

	public enum Traverse {
		SHALLOW, DEEP_DIRECTORY, DEEP_FILE, DEEP;

		public final boolean isDirectoryStructure() {
			return equals(DEEP_DIRECTORY) ||equals(Traverse.DEEP);
		}
		public final boolean isFileContent() {
			return equals(DEEP_FILE) || equals(DEEP);
		}
	}

	public enum Synchronize {
		REMOVE_ADD_UPDATE, ADD_UPDATE, UPDATE;

		public final boolean isUpdateOnly() {
			return equals(UPDATE);
		}
		public final boolean isRemoving() {
			return equals(REMOVE_ADD_UPDATE);
		}
	}
}
