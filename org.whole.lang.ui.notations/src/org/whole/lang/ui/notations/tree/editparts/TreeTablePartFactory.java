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
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.ui.notations.table.editparts.SimpleEntityTableRowPart;
import org.whole.lang.ui.notations.table.editparts.TablePartFactory;


/** 
 * @author Riccardo Solmi
 */
public class TreeTablePartFactory extends TreeRightPartFactory {
	protected IEmbeddingStrategy embeddingStrategy = GenericEmbeddingStrategy.instance;

	private static class SingletonHolder {
		private static final TreeTablePartFactory instance = new TreeTablePartFactory();
	}
	public static TreeTablePartFactory instance() {
		return SingletonHolder.instance;
	}
	protected TreeTablePartFactory() {
		super(false);
	}

	@Override
	protected EditPart createSimpleEntityPart(EditPart context, IEntity entity) {
		if (embeddingStrategy.isEmbedded(entity))
			return new SimpleEntityTableRowPart(entity.wGetEntityDescriptor());
		else
			return new SimpleEntityTreeTablePart(isRightToLeft(), embeddingStrategy);
	}

	@Override
	protected EditPart createCompositeEntityPart(EditPart context, IEntity entity) {
		EntityDescriptor<?> ed = entity.wGetEntityDescriptor();
		if (ed.getEntityFeatureDescriptor(0).isReference()) {
			return new CompositeEntityReferenceTreePart(ed, isRightToLeft());
			//FIXME table style
		} else {
			if (embeddingStrategy.embedChildren(entity))
				return new CompositeEntityTreeTablePart(isRightToLeft());
			else
				return new CompositeEntityTreeTableNoEmbeddingPart(isRightToLeft());
		}
	}

	@Override
	protected EditPart createDataEntityPart(EditPart context, IEntity entity) {
		if (embeddingStrategy.isEmbedded(entity))
			return TablePartFactory.instance().createEditPart(context, entity);
		else
			return new DataEntityTreeTablePart(isRightToLeft());
	}
}
