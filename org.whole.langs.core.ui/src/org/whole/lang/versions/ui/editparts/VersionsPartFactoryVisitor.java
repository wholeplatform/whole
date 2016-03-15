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
package org.whole.lang.versions.ui.editparts;

import org.eclipse.gef.EditPart;
import org.whole.lang.model.adapters.IEntityAdapter;
import org.whole.lang.ui.editparts.CompositeColumnPart;
import org.whole.lang.ui.editparts.IEditPartFactory;
import org.whole.lang.ui.editparts.PlaceHolderPart;
import org.whole.lang.ui.notations.text.editparts.DefaultTextualPartFactory;
import org.whole.lang.versions.model.History;
import org.whole.lang.versions.model.IVersionsEntity;
import org.whole.lang.versions.model.Version;
import org.whole.lang.versions.model.Versionable;
import org.whole.lang.versions.model.Versions;
import org.whole.lang.versions.visitors.VersionsIdentityDefaultVisitor;

/** 
 * @author Riccardo Solmi
 */
public class VersionsPartFactoryVisitor extends VersionsIdentityDefaultVisitor implements IEditPartFactory {
	private EditPart part, context;

	public EditPart createEditPart(EditPart context, Object modelEntity) {
		this.context = context;
		((IVersionsEntity) modelEntity).accept(this);
		return part;
	}

	public boolean visitAdapter(IEntityAdapter entity) {
		part = new PlaceHolderPart();
		return super.visitAdapter(entity);
	}

	public void visit(IVersionsEntity entity) {
		part = DefaultTextualPartFactory.instance().createEditPart(context, entity);
	}

	public void visit(Versions entity) {
		part = new CompositeColumnPart();
	}

	public void visit(History entity) {
		part = new HistoryPart();
	}

	public void visit(Version entity) {
		part = new VersionPart();
	}

	public void visit(Versionable entity) {
		part = new VersionablePart();
	}
}