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
package org.whole.lang.ui.notations.tree.editparts;

import org.eclipse.gef.EditPart;
import org.whole.lang.commons.reflect.CommonsEntityDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.ui.editparts.IEditPartFactory;
import org.whole.lang.ui.editparts.PlaceHolderPart;

/** 
 * @author Riccardo Solmi
 */
public class TreeRightPartFactory implements IEditPartFactory {
	private static class SingletonHolder {
		private static final TreeRightPartFactory instance = new TreeRightPartFactory();
	}
	public static TreeRightPartFactory instance() {
		return SingletonHolder.instance;
	}

	private boolean isRightToLeft;

	protected TreeRightPartFactory() {
		this(false);
	}
	protected TreeRightPartFactory(boolean isRightToLeft) {
		this.isRightToLeft = isRightToLeft;
	}

	public boolean isRightToLeft() {
		return isRightToLeft;
	}

	public EditPart createEditPart(EditPart context, Object modelEntity) {
		IEntity entity = (IEntity) modelEntity;
		EntityDescriptor<?> ed = entity.wGetEntityDescriptor();

		if (!ed.equals(CommonsEntityDescriptorEnum.Resolver))
			switch (entity.wGetEntityKind()) {
			case DATA:
				return createDataEntityPart(context, entity);
			case COMPOSITE:
				return createCompositeEntityPart(context, entity);
			case SIMPLE:
				return createSimpleEntityPart(context, entity);
			}
		return createPlaceHolderPart(context, entity);
	}

	protected EditPart createDataEntityPart(EditPart context, IEntity entity) {
		return new DataEntityTreePart(isRightToLeft());
	}

	protected EditPart createCompositeEntityPart(EditPart context, IEntity entity) {
		EntityDescriptor<?> ed = entity.wGetEntityDescriptor();
		if (ed.getEntityFeatureDescriptor(0).isReference())
			return new CompositeEntityReferenceTreePart(ed, isRightToLeft());
		else
			return new CompositeEntityTreePart(isRightToLeft());
	}

	protected EditPart createSimpleEntityPart(EditPart context, IEntity entity) {
		return new SimpleEntityTreePart(isRightToLeft());
	}

	protected EditPart createPlaceHolderPart(EditPart context, IEntity entity) {
		return new PlaceHolderPart();
	}
}
