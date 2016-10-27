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

	public void invalidateEntityStyling(String entityId) {
		entityStylingMap.remove(entityId);
	}

	public EmbeddingStyle getEmbeddingStyle(IStylingFactory stylingFactory, IEntityPart contextPart, IEntity entity) {
		if (!(contextPart instanceof IStyledPart))
			return EmbeddingStyle.NONE;

		IEntity parentEntity = stylingFactory.getParentEntity(entity);
		IEntityPart parentContextPart = stylingFactory.getParentPart(contextPart);

		IEntityStyling parentEntityStyling = getEntityStyling(stylingFactory, parentContextPart, parentEntity);
		boolean embedChild = parentEntityStyling.embedChild(entity.wGetParent().wIndexOf(entity));
		if (embedChild) {
			switch (parentEntityStyling.getLayoutStyle()) {
			case SIMPLE_TABLE:
				return EmbeddingStyle.TABLE_CELL;
			case COMPOSITE_TABLE:
				return EmbeddingStyle.TABLE_ROW;
			default:
				return EmbeddingStyle.NONE;
			}
		} else
			return EmbeddingStyle.NONE;
	}

	public boolean isEmbedded(IStylingFactory stylingFactory, IEntityPart contextPart, IEntity entity) {
		if (!(contextPart instanceof IStyledPart))
			return false;

		IEntityStyling entityStyling = getEntityStyling(stylingFactory, contextPart, entity);
		LayoutStyle layoutStyle = entityStyling.getLayoutStyle();
		
		IEntity parentEntity = stylingFactory.getParentEntity(entity);
		IEntityPart parentContextPart = stylingFactory.getParentPart(contextPart);

		IEntityStyling parentEntityStyling = getEntityStyling(stylingFactory, parentContextPart, parentEntity);
		boolean embedChild = parentEntityStyling.embedChild(entity.wGetParent().wIndexOf(entity));
		if (embedChild)
			return true;
		else {
			LayoutStyle parentLayoutStyle = parentEntityStyling.getLayoutStyle();
			switch (parentLayoutStyle) {
			case COLUMN:
			case COMPOSITE_TABLE:
				return embedChild;
			case TABLE_CELL:
			case TABLE_ROW:
				return true;
			case TREE:
				return false;
			case SIMPLE_TABLE:
			default:
				return isEmbedded(stylingFactory, parentContextPart, parentEntity);
			}
		}
	}

	public LayoutStyle getLayoutStyle(IStylingFactory stylingFactory, IEntityPart contextPart, IEntity entity) {
		IEntityStyling entityStyling = getEntityStyling(stylingFactory, contextPart, entity);
		LayoutStyle layoutStyle = entityStyling.getLayoutStyle();
		switch (layoutStyle) {
		case SIMPLE_TABLE:
		case COMPOSITE_TABLE:
			EmbeddingStyle embeddingStyle = getEmbeddingStyle(stylingFactory, contextPart, entity);
			return embeddingStyle.equals(EmbeddingStyle.NONE) ? layoutStyle :
				embeddingStyle.equals(EmbeddingStyle.TABLE_CELL) ? LayoutStyle.TABLE_CELL : LayoutStyle.TABLE_ROW;
		default:
			return layoutStyle;
		}
	}
}
