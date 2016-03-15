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
package org.whole.lang.templates.ui.editparts;

import org.eclipse.gef.EditPart;
import org.whole.lang.model.adapters.IEntityAdapter;
import org.whole.lang.templates.model.ITemplatesEntity;
import org.whole.lang.templates.model.Name;
import org.whole.lang.templates.model.QualifiedName;
import org.whole.lang.templates.model.SimpleName;
import org.whole.lang.templates.model.TemplateFactory;
import org.whole.lang.templates.model.TemplateManager;
import org.whole.lang.templates.model.Templates;
import org.whole.lang.templates.visitors.TemplatesIdentityDefaultVisitor;
import org.whole.lang.ui.editparts.CompositeColumnPart;
import org.whole.lang.ui.editparts.ContentTextualEntityPart;
import org.whole.lang.ui.editparts.PlaceHolderPart;
import org.whole.lang.ui.editparts.IEditPartFactory;
import org.whole.lang.ui.notations.text.editparts.DefaultTextualPartFactory;

/** 
 * @author Riccardo Solmi
 */
public class TemplatesTextualPartFactoryVisitor extends TemplatesIdentityDefaultVisitor implements IEditPartFactory {
	protected EditPart part, context;

	public EditPart createEditPart(EditPart context, Object modelEntity) {
		this.context = context;
		((ITemplatesEntity) modelEntity).accept(this);
		return part;
	}

	public boolean visitAdapter(IEntityAdapter entity) {
		part = new PlaceHolderPart();
		return super.visitAdapter(entity);
	}

	public void visit(ITemplatesEntity entity) {
		part = DefaultTextualPartFactory.instance().createEditPart(context, entity);
	}

	public void visit(TemplateManager entity) {
		part = new TemplateManagerPart();
	}

	public void visit(TemplateFactory entity) {
		part = new TemplateFactoryPart();
	}

	public void visit(Templates entity) {
		part = new CompositeColumnPart();
	}

	public void visit(QualifiedName entity) {
		part = new QualifiedNamePart();
	}

	public void visit(Name entity) {
		part = new ContentTextualEntityPart();
	}

	public void visit(SimpleName entity) {
		part = new ContentTextualEntityPart();
	}
}