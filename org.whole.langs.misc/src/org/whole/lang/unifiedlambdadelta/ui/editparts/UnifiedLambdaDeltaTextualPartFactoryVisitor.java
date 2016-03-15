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
package org.whole.lang.unifiedlambdadelta.ui.editparts;

import org.eclipse.gef.EditPart;
import org.whole.lang.model.adapters.IEntityAdapter;
import org.whole.lang.ui.editparts.IEditPartFactory;
import org.whole.lang.ui.editparts.PlaceHolderPart;
import org.whole.lang.ui.notations.text.editparts.DefaultTextualPartFactory;
import org.whole.lang.unifiedlambdadelta.model.Abbreviation;
import org.whole.lang.unifiedlambdadelta.model.Abstraction;
import org.whole.lang.unifiedlambdadelta.model.Application;
import org.whole.lang.unifiedlambdadelta.model.Cast;
import org.whole.lang.unifiedlambdadelta.model.Declaration;
import org.whole.lang.unifiedlambdadelta.model.Definition;
import org.whole.lang.unifiedlambdadelta.model.IUnifiedLambdaDeltaEntity;
import org.whole.lang.unifiedlambdadelta.model.Local;
import org.whole.lang.unifiedlambdadelta.model.Name;
import org.whole.lang.unifiedlambdadelta.model.Sort;
import org.whole.lang.unifiedlambdadelta.model.Top;
import org.whole.lang.unifiedlambdadelta.visitors.UnifiedLambdaDeltaIdentityDefaultVisitor;

/** 
 * @author Riccardo Solmi
 */
public class UnifiedLambdaDeltaTextualPartFactoryVisitor extends
		UnifiedLambdaDeltaIdentityDefaultVisitor implements IEditPartFactory {
	protected EditPart part, context;

	public EditPart createEditPart(EditPart context, Object modelEntity) {
		this.context = context;
		((IUnifiedLambdaDeltaEntity) modelEntity).accept(this);
		return part;
	}

	public boolean visitAdapter(IEntityAdapter entity) {
		part = new PlaceHolderPart();
		return super.visitAdapter(entity);
	}

	public void visit(IUnifiedLambdaDeltaEntity entity) {
		part = DefaultTextualPartFactory.instance().createEditPart(context, entity);
	}

	public void visit(Declaration entity) {
		part = new DeclarationPart();
	}

	public void visit(Definition entity) {
		part = new DefinitionPart();
	}

	public void visit(Top entity) {
		part = new TopPart();
	}

	public void visit(Abstraction entity) {
		part = new AbstractionPart();
	}

	public void visit(Abbreviation entity) {
		part = new AbbreviationPart();
	}

	public void visit(Application entity) {
		part = new ApplicationPart();
	}

	public void visit(Cast entity) {
		part = new CastPart();
	}

	public void visit(Local entity) {
		part = new LocalPart();
	}

	public void visit(Sort entity) {
		part = new SortPart();
	}

	public void visit(Name entity) {
		part = new NamePart();
	}
}
