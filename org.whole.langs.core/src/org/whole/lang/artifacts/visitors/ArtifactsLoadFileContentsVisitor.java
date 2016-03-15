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

import static org.whole.lang.artifacts.util.ArtifactsUtils.getPersistenceKitId;

import java.io.InputStream;
import java.util.Stack;

import org.whole.lang.artifacts.model.FileArtifact;
import org.whole.lang.artifacts.model.IArtifactsEntity;
import org.whole.lang.artifacts.reflect.ArtifactsEntityDescriptorEnum;
import org.whole.lang.artifacts.util.IArtifactsOperations;
import org.whole.lang.codebase.IPersistenceKit;
import org.whole.lang.codebase.StreamPersistenceProvider;
import org.whole.lang.commons.factories.CommonsEntityAdapterFactory;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.util.EntityUtils;

/**
 * @author Enrico Persiani
 */
public class ArtifactsLoadFileContentsVisitor<T> extends ArtifactsResourceVisitor<T> {
	private Stack<IPersistenceKit> persistenceKitStack;
	private boolean force;

	public ArtifactsLoadFileContentsVisitor(IArtifactsOperations<T> artifactsOperations,
			T rootResource, IPersistenceKit defaultPersistenceKit) {
		this(artifactsOperations, rootResource, defaultPersistenceKit, false);
	}
	public ArtifactsLoadFileContentsVisitor(IArtifactsOperations<T> artifactsOperations,
			T rootResource, IPersistenceKit defaultPersistenceKit, boolean force) {
		super(artifactsOperations, rootResource);
		this.persistenceKitStack = new Stack<IPersistenceKit>();
		this.persistenceKitStack.push(defaultPersistenceKit);
		this.force = force;
	}

	@Override
	protected void acceptChild(IEntity child, T childResource) {
		IPersistenceKit persistenceKit = getPersistenceKit(child);
		persistenceKitStack.push(persistenceKit);
		super.acceptChild(child, childResource);
		persistenceKitStack.pop();
	}

	@Override
	public void visit(FileArtifact entity) {
		if (force || EntityUtils.isResolver(entity.getContent())) {
			InputStream is = getArtifactsOperations().getContents(getResource());
			IPersistenceKit persistenceKit = persistenceKitStack.peek();
			try {
				IEntity model = persistenceKit.readModel(
						new StreamPersistenceProvider(is));
				entity.setContent(CommonsEntityAdapterFactory
						.createStageUpFragment(
								ArtifactsEntityDescriptorEnum.Content, model));
			} catch (Exception e) {
//TODO parameterize 	throw new IllegalStateException(e);
			}
		}
	}

	private IPersistenceKit getPersistenceKit(IEntity entity) {
		String persistenceKitId = getPersistenceKitId(entity);
		IPersistenceKit persistenceKit = persistenceKitId != null ? 
				ReflectionFactory.getPersistenceKit(persistenceKitId) :
					persistenceKitStack.peek();
		if (persistenceKit == null)
			throw new IllegalStateException("default persistence undefined");
		return persistenceKit;
	}

	public static IArtifactsEntity loadContents(IArtifactsEntity model,
			IArtifactsOperations<Object> artifactsOperations, Object rootResource,
			IPersistenceKit defaultPersistenceKit) {
		return loadContents(model, artifactsOperations, rootResource,
				defaultPersistenceKit, false);
	}

	@SuppressWarnings("unchecked")
	public static IArtifactsEntity loadContents(IArtifactsEntity model,
			IArtifactsOperations<Object> artifactsOperations, Object rootResource,
			IPersistenceKit defaultPersistenceKit, boolean force) {
		model.accept(new ArtifactsLoadFileContentsVisitor(artifactsOperations, rootResource,
				defaultPersistenceKit, force));
		return model;
	}
}
