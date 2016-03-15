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
package org.whole.lang.ui.notations.table.editparts;

import org.eclipse.gef.EditPart;
import org.whole.lang.commons.reflect.CommonsEntityDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.ui.editparts.CompositeColumnWithPlaceholderPart;
import org.whole.lang.ui.editparts.IEditPartFactory;
import org.whole.lang.ui.editparts.LiteralDataEntityPart;
import org.whole.lang.ui.editparts.LiteralTextualEntityPart;
import org.whole.lang.ui.editparts.PlaceHolderPart;
import org.whole.lang.util.EntityUtils;

/** 
 * @author Riccardo Solmi
 */
public class TablePartFactory implements IEditPartFactory {
	private static class SingletonHolder {
		private static final TablePartFactory instance = new TablePartFactory();
	}
	public static TablePartFactory instance() {
		return SingletonHolder.instance;
	}
	protected TablePartFactory() {
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
				else if (embedChildren(entity))
					return new CompositeEntityTablePart(ed);
				else
					return new CompositeColumnWithPlaceholderPart();
			case SIMPLE:
				if (isEmbedded(entity))
					return new SimpleEntityTableRowPart(ed);
				else
					return new SimpleEntityTablePart(ed);
			}
		return new PlaceHolderPart();
	}

	protected boolean embedChildren(IEntity entity) {
		if (entity.wGetEntityDescriptor().getEntityFeatureDescriptor(0).isReference())
			return false;
		EntityDescriptor<?> eed = entity.wGetEntityDescriptor().getEntityDescriptor(0);
		return EntityUtils.isComposite(entity) && !eed.isPolymorphic() &&
				EntityUtils.isSimple(eed);// && eed.featuresDescriptors().length > 1;
	}
	protected boolean isEmbedded(IEntity entity) {
		return EntityUtils.hasParent(entity) && EntityUtils.isSimple(entity) &&
				entity.wGetLanguageKit().equals(entity.wGetParent().wGetLanguageKit()) &&
				embedChildren(entity.wGetParent());
	}
}
