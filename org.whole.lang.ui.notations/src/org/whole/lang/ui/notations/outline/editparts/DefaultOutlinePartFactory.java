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
package org.whole.lang.ui.notations.outline.editparts;

import org.eclipse.gef.EditPart;
import org.whole.lang.model.IEntity;
import org.whole.lang.ui.editparts.PlaceHolderPart;
import org.whole.lang.ui.editparts.IEditPartFactory;
import org.whole.lang.ui.notations.text.editparts.DefaultTextualPartFactory;
import org.whole.lang.ui.templates.OutlineUIProvider;

/**
 * @author Riccardo Solmi
 */
public class DefaultOutlinePartFactory implements IEditPartFactory {
	private static class SingletonHolder {
		private static final DefaultOutlinePartFactory instance = new DefaultOutlinePartFactory();
	}
	public static DefaultOutlinePartFactory instance() {
		return SingletonHolder.instance;
	}

	protected EditPart part, context;

	public EditPart createEditPart(EditPart context, Object modelEntity) {
		this.context = context;
		IEntity entity = (IEntity) modelEntity;

		if (entity.wIsAdapter())
			return part = new PlaceHolderPart();
	
		switch (entity.wGetEntityKind()) {
		case SIMPLE:
			return part = new OutlinePart(
					OutlineUIProvider.instance().getPartDataProvider(entity));
		default:
			return part = DefaultTextualPartFactory.instance().createEditPart(context, modelEntity);
		}
	}
}