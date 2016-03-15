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

import static org.whole.lang.artifacts.util.ArtifactsUtils.getChildren;

import org.whole.lang.artifacts.model.FileArtifact;
import org.whole.lang.artifacts.model.IArtifactsEntity;
import org.whole.lang.artifacts.util.IArtifactsOperations;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.model.IEntity;

/**
 * @author Enrico Persiani
 */
public class ArtifactsDeleteVisitor<T> extends ArtifactsResourceVisitor<T> {

	public ArtifactsDeleteVisitor(IArtifactsOperations<T> artifactsOperations,
			T rootResource) {
		super(artifactsOperations, rootResource);
	}

	@Override
	protected void acceptChildren(IEntity entity) {
		if (!getChildren(entity).wIsEmpty())
			super.acceptChildren(entity);
		else
			getArtifactsOperations().delete(getResource());
	}

	@Override
	public void visit(FileArtifact entity) {
		getArtifactsOperations().delete(getResource());
	}

	@SuppressWarnings("unchecked")
	public static void delete(IArtifactsEntity model, IBindingManager bindings) {
		IArtifactsOperations<Object> artifactsOperations = 
			(IArtifactsOperations<Object>) bindings.wGetValue("artifactsOperations");
		Object rootResource = bindings.wGetValue("rootResource");
		model.accept(new ArtifactsDeleteVisitor(artifactsOperations, rootResource));
	}
}
