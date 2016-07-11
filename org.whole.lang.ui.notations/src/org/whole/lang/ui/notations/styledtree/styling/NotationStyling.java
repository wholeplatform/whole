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
package org.whole.lang.ui.notations.styledtree.styling;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.whole.lang.model.IEntity;
import org.whole.lang.ui.editparts.IEntityPart;
import org.whole.lang.ui.notations.styledtree.styling.EntityStyling.LayoutStyle;

/**
 * @author Riccardo Solmi
 */
public class NotationStyling implements INotationStyling {
	protected Map<String, IEntityStyling> entityStylingMap = new HashMap<>();

	public IEntityStyling getEntityStyling(IStylingFactory stylingFactory, IEntityPart contextPart, IEntity entity) {
		IEntityStyling entityStyling = entityStylingMap.get(stylingFactory.getTypeIdentifier(entity));
		if (entityStyling == null)
			addEntityStyling(entityStyling = stylingFactory.createEntityStyling(contextPart, entity));
		return entityStyling;
	}

	public IEntityStyling addEntityStyling(IEntityStyling styling) {
		return addEntityStyling(styling.getTypeIdentifier(), styling);
	}
	public IEntityStyling addEntityStyling(String typeIdentifier, IEntityStyling styling) {
		((EntityStyling) styling).setNotationStyling(this);
		return entityStylingMap.put(typeIdentifier, styling);
	}

	public boolean isEmbedded(IStylingFactory stylingFactory, IEntityPart contextPart, IEntity entity) {
		return getEmbeddingLayoutStyle(stylingFactory, contextPart, entity).isPresent();
	}
	public Optional<LayoutStyle> getEmbeddingLayoutStyle(IStylingFactory stylingFactory, IEntityPart contextPart, IEntity entity) {
		//FIXME contextPart is not properly virtualized
		try {
		if (!(contextPart instanceof IStyledPart))
			return Optional.empty();

		IEntity parentEntity = stylingFactory.getParentEntity(entity);
		IEntityPart parentContextPart = stylingFactory.getParentPart(contextPart);
		if (parentContextPart.getModelEntity() != parentEntity)
			return Optional.empty();

		IEntityStyling parentEntityStyling = getEntityStyling(stylingFactory, parentContextPart, parentEntity);
		boolean embedChild = parentEntityStyling.embedChild(entity.wGetParent().wIndexOf(entity));
		return embedChild ? Optional.of(parentEntityStyling.getLayoutStyle()) : Optional.empty();
		} catch (Exception e) {
			//FIXME
			return Optional.empty();
		}
	}

}
