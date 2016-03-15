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
package org.whole.lang.editors.visitors;

import org.whole.lang.artifacts.util.ArtifactsUtils;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.editors.model.Editor;
import org.whole.lang.editors.model.IEditorsEntity;
import org.whole.lang.editors.reflect.EditorsEntityDescriptorEnum;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.ArtifactsGeneratorOperation;
import org.whole.lang.queries.model.PathExpression;
import org.whole.lang.util.BehaviorUtils;
import org.whole.lang.visitors.VisitException;

/**
 * @author Riccardo Solmi
 */
public class EditorsArtifactsGeneratorVisitor extends EditorsIdentityDefaultVisitor {
	public EditorsArtifactsGeneratorVisitor(ArtifactsGeneratorOperation operation) {
		setOperation(operation);
	}

	public final IBindingManager env() {
		return ((ArtifactsGeneratorOperation) getOperation()).getArtifactsEnvironment();
	}

	@Override
	public void visit(IEditorsEntity entity) {
		Editor ed = Matcher.findAncestor(EditorsEntityDescriptorEnum.Editor, entity);
		if (ed != null)
			visit(ed);
		
		throw new VisitException();
	}

	@Override
	public void visit(Editor entity) {
		IEntity workspaceModel = generateWorkspaceModel(entity, env());
		ArtifactsUtils.moveArtifactsIntoWorkspace(workspaceModel, env());
	}

	protected IEntity generateWorkspaceModel(IEntity model, IBindingManager bm) {
		return BehaviorUtils.compileAndLazyEvaluate(createMappingQuery(), model, bm).next();
	}

	protected PathExpression createMappingQuery() {
		return new EditorsArtifactsGeneratorQuery().create();
	}
}
