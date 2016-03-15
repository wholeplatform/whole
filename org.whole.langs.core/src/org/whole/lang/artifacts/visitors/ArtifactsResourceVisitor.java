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

import java.util.Stack;

import org.whole.lang.artifacts.model.FolderArtifact;
import org.whole.lang.artifacts.model.IArtifactsEntity;
import org.whole.lang.artifacts.model.PackageArtifact;
import org.whole.lang.artifacts.model.Project;
import org.whole.lang.artifacts.model.Workspace;
import org.whole.lang.artifacts.util.IArtifactsOperations;
import org.whole.lang.iterators.IEntityIterator;
import org.whole.lang.iterators.IteratorFactory;
import org.whole.lang.model.IEntity;
import org.whole.lang.visitors.VisitException;

/**
 * @author Enrico Persiani
 */
public class ArtifactsResourceVisitor<T> extends ArtifactsIdentityDefaultVisitor {
	private Stack<T> resourceStack;
	private IArtifactsOperations<T> artifactsOperations;

	public ArtifactsResourceVisitor(IArtifactsOperations<T> artifactsOperations, T rootResource) {
		this.artifactsOperations = artifactsOperations;
		this.resourceStack = new Stack<T>();
		this.resourceStack.push(rootResource);
	}

	protected void acceptChildren(IEntity entity) {
		IEntityIterator<IEntity> i = IteratorFactory.childIterator();
		i.reset(getChildren(entity));
		for (IEntity child : i)
			acceptChild(child, getArtifactsOperations().getChild(
			getResource(), child));
	}

	protected void acceptChild(IEntity child, T childResource) {
		resourceStack.push(childResource);
		((IArtifactsEntity) child).accept(this);
		resourceStack.pop();
	}

	@Override
	public void visit(IArtifactsEntity entity) {
		throw new VisitException("unsupported entity");
	}

	@Override
	public void visit(FolderArtifact entity) {
		acceptChildren(entity);
	}

	@Override
	public void visit(PackageArtifact entity) {
		acceptChildren(entity);
	}

	@Override
	public void visit(Project entity) {
		acceptChildren(entity);
	}

	@Override
	public void visit(Workspace entity) {
		acceptChildren(entity);
	}

	protected T getResource() {
		return resourceStack.peek();
	}
	protected IArtifactsOperations<T> getArtifactsOperations() {
		return artifactsOperations;
	}
}
