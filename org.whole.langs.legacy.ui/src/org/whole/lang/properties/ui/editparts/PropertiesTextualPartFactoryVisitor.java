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
package org.whole.lang.properties.ui.editparts;

import org.eclipse.gef.EditPart;
import org.whole.lang.model.adapters.IEntityAdapter;
import org.whole.lang.properties.model.Comment;
import org.whole.lang.properties.model.Entries;
import org.whole.lang.properties.model.IPropertiesEntity;
import org.whole.lang.properties.model.Properties;
import org.whole.lang.properties.model.Property;
import org.whole.lang.properties.model.PropertyName;
import org.whole.lang.properties.model.PropertyValue;
import org.whole.lang.properties.visitors.PropertiesIdentityDefaultVisitor;
import org.whole.lang.ui.editparts.IEditPartFactory;
import org.whole.lang.ui.editparts.IdentifierTextualEntityPart;
import org.whole.lang.ui.editparts.ContentTextualEntityPart;
import org.whole.lang.ui.editparts.CompositeColumnWithPlaceholderPart;
import org.whole.lang.ui.editparts.PlaceHolderPart;
import org.whole.lang.ui.notations.text.editparts.DefaultTextualPartFactory;

/** 
 * @author Riccardo Solmi
 */
public class PropertiesTextualPartFactoryVisitor extends PropertiesIdentityDefaultVisitor implements IEditPartFactory {
	protected EditPart part, context;

	public EditPart createEditPart(EditPart context, Object modelEntity) {
		this.context = context;
		((IPropertiesEntity) modelEntity).accept(this);
		return part;
	}

	@Override
	public boolean visitAdapter(IEntityAdapter entity) {
		part = new PlaceHolderPart();
		return super.visitAdapter(entity);
	}

	@Override
	public void visit(IPropertiesEntity entity) {
		part = DefaultTextualPartFactory.instance().createEditPart(context, entity);
	}

	public void visit(Properties entity) {
		part = new PropertiesPart();
	}

	public void visit(Property entity) {
		part = new PropertyPart();
	}

	public void visit(Entries entity) {
		part = new CompositeColumnWithPlaceholderPart();
	}

	public void visit(Comment entity) {
		part = new ContentTextualEntityPart();
	}

	public void visit(PropertyName entity) {
		part = new IdentifierTextualEntityPart();
	}

	public void visit(PropertyValue entity) {
		part = new ContentTextualEntityPart();
	}
}