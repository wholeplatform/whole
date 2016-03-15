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
package org.whole.lang.status.ui.editparts;

import org.eclipse.gef.EditPart;
import org.whole.lang.model.IEntity;
import org.whole.lang.ui.editparts.IEditPartFactory;
import org.whole.lang.ui.editparts.IEntityPart;
import org.whole.lang.ui.notations.text.editparts.DefaultTextualPartFactory;

/**
 * @author Enrico Persiani
 */
public class StatusPartFactory implements IEditPartFactory {
	private static class SingletonHolder {
		private static final StatusPartFactory instance = new StatusPartFactory();
	}
	public static StatusPartFactory instance() {
		return SingletonHolder.instance;
	}

	public EditPart createEditPart(EditPart context, Object model) {
		EditPart part;
		IEntity entity = (IEntity) model;

		if (entity.wIsAdapter())
			part = new org.whole.lang.ui.editparts.PlaceHolderPart();
		else
			part = createEntityPart(entity);

		return part != null ? part : DefaultTextualPartFactory.instance().createEditPart(context, entity);
	}

	protected IEntityPart createEntityPart(IEntity entity) {
		String typeName = entity.wGetEntityDescriptor().getName();
		if (typeName.equals("ErrorStatus")) {
			return new ErrorStatusPart();
		} if (typeName.equals("EmptyStatus")) {
			return new EmptyStatusPart();
		} else
			return null;
	}
}
