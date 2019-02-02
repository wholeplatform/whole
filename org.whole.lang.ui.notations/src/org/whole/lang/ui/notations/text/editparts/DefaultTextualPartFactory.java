/**
 * Copyright 2004-2019 Riccardo Solmi. All rights reserved.
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
package org.whole.lang.ui.notations.text.editparts;

import org.eclipse.gef.EditPart;
import org.whole.lang.commons.reflect.CommonsEntityDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.ui.editparts.CompositeColumnPart;
import org.whole.lang.ui.editparts.IEditPartFactory;
import org.whole.lang.ui.editparts.LiteralDataEntityPart;
import org.whole.lang.ui.editparts.LiteralTextualEntityPart;
import org.whole.lang.ui.editparts.PlaceHolderPart;
import org.whole.lang.ui.notations.table.editparts.CompositeEntityReferenceColumnPart;

/** 
 * @author Riccardo Solmi
 */
public class DefaultTextualPartFactory implements IEditPartFactory {
	private static class SingletonHolder {
		private static final DefaultTextualPartFactory instance = new DefaultTextualPartFactory();
	}
	public static DefaultTextualPartFactory instance() {
		return SingletonHolder.instance;
	}
	protected DefaultTextualPartFactory() {
	}

	public EditPart createEditPart(EditPart context, Object modelEntity) {
		IEntity entity = (IEntity) modelEntity;
		EntityDescriptor<?> ed = entity.wGetEntityDescriptor();

		if (!ed.equals(CommonsEntityDescriptorEnum.Resolver))
			switch (entity.wGetEntityKind()) {
			case DATA:
				switch (ed.getDataKind()) {
				case STRING:
					return new LiteralTextualEntityPart();
				default:
					return new LiteralDataEntityPart();
				}
			case COMPOSITE:
				if (ed.getEntityFeatureDescriptor(0).isReference())
					return new CompositeEntityReferenceColumnPart(ed);
				else
					return new CompositeColumnPart();
			case SIMPLE:
				return new SimpleEntityTextPart(ed);
			}
		return new PlaceHolderPart();
	}
}
