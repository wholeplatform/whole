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
package org.whole.lang.scheme.ui.editparts;

import org.eclipse.gef.EditPart;
import org.whole.lang.model.adapters.IEntityAdapter;
import org.whole.lang.scheme.model.AndExpression;
import org.whole.lang.scheme.model.ApplyExpression;
import org.whole.lang.scheme.model.Branch;
import org.whole.lang.scheme.model.Branches;
import org.whole.lang.scheme.model.CondExpression;
import org.whole.lang.scheme.model.Definition;
import org.whole.lang.scheme.model.Definitions;
import org.whole.lang.scheme.model.ISchemeEntity;
import org.whole.lang.scheme.model.LambdaExpression;
import org.whole.lang.scheme.model.LocalExpression;
import org.whole.lang.scheme.model.Names;
import org.whole.lang.scheme.model.OrExpression;
import org.whole.lang.scheme.model.SchemeExpressions;
import org.whole.lang.scheme.visitors.SchemeIdentityDefaultVisitor;
import org.whole.lang.ui.editparts.CompositeColumnPart;
import org.whole.lang.ui.editparts.CompositeRowWithPlaceholderPart;
import org.whole.lang.ui.editparts.IEditPartFactory;
import org.whole.lang.ui.editparts.PlaceHolderPart;
import org.whole.lang.ui.notations.text.editparts.DefaultTextualPartFactory;

/** 
 * @author Riccardo Solmi
 */
public class SchemeTextualPartFactoryVisitor extends SchemeIdentityDefaultVisitor implements IEditPartFactory {
	protected EditPart part, context;

	public EditPart createEditPart(EditPart context, Object modelEntity) {
		this.context = context;
		((ISchemeEntity) modelEntity).accept(this);
		return part;
	}

	public boolean visitAdapter(IEntityAdapter entity) {
		part = new PlaceHolderPart();
		return super.visitAdapter(entity);
	}

	public void visit(ISchemeEntity entity) {
		part = DefaultTextualPartFactory.instance().createEditPart(context, entity);
	}

	public void visit(Definitions entity) {
		part = new CompositeColumnPart();
	}

	public void visit(Definition entity) {
		part = new DefinitionPart();
	}

	public void visit(Branch entity) {
		part = new BranchPart();
	}

	public void visit(Branches entity) {
		part = new CompositeColumnPart();
	}

	public void visit(SchemeExpressions entity) {
		part = new CompositeRowWithPlaceholderPart();
	}

	public void visit(ApplyExpression entity) {
		part = new ApplyExpressionPart();
	}

	public void visit(LambdaExpression entity) {
		part = new LambdaExpressionPart();
	}

	public void visit(AndExpression entity) {
		part = new AndExpressionPart();
	}

	public void visit(OrExpression entity) {
		part = new OrExpressionPart();
	}

	public void visit(CondExpression entity) {
		part = new CondExpressionPart();
	}

	public void visit(LocalExpression entity) {
		part = new LocalExpressionPart();
	}

	public void visit(Names entity) {
		part = new CompositeRowWithPlaceholderPart();
	}
}