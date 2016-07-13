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
package org.whole.lang.ui.notations.styledtree.editparts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reflect.FeatureDescriptorEnum;
import org.whole.lang.ui.editparts.AbstractContentPanePart;
import org.whole.lang.ui.editparts.IEntityPart;
import org.whole.lang.ui.notations.styledtree.figures.SimpleTableNodeWithBranchesFigure;
import org.whole.lang.ui.notations.styledtree.figures.SimpleTableRowFigure;
import org.whole.lang.ui.notations.styledtree.styling.IEntityStyling;
import org.whole.lang.ui.notations.styledtree.styling.IFeatureStyling;
import org.whole.lang.ui.notations.styledtree.styling.IStyledPart;
import org.whole.lang.ui.notations.styledtree.styling.IStylingFactory;


/**
 * @author Riccardo Solmi
 */
public class SimpleEntityStyledTreePart extends AbstractContentPanePart implements IStyledPart {
	protected IStylingFactory stylingFactory;
	protected IEntityStyling entityStyling;

	public SimpleEntityStyledTreePart(IStylingFactory stylingFactory, IEntityStyling entityStyling) {
		this.stylingFactory = stylingFactory;
		this.entityStyling = entityStyling;
	}

	public IEntityStyling getEntityStyling() {
		return entityStyling;
	}

	protected IFigure createFigure() {
		switch (entityStyling.getNotationStyling().getEmbeddingStyle(stylingFactory, (IEntityPart) getParent(), getModelEntity())) {
		case TABLE_ROW:
			return new SimpleTableRowFigure(entityStyling);
		case NONE:
		default:
			return new SimpleTableNodeWithBranchesFigure(false, entityStyling);
		}
	}

	protected List<IEntity> getModelSpecificChildren() {
		IFeatureStyling[] featuresStyling = entityStyling.getFeaturesStyling();
		int size = featuresStyling.length;

		if (size == 0)
			return Collections.emptyList();
		else {
			IEntity entity = getModelEntity();
			EntityDescriptor<?> ed = entity.wGetEntityDescriptor();
			FeatureDescriptorEnum fdEnum = ed.getFeatureDescriptorEnum();
			List<IEntity> list = new ArrayList<IEntity>(size);
			for (int i=0; i<size; i++)
				list.add(entity.wGet(ed.getEntityFeatureDescriptor(fdEnum.valueOf(featuresStyling[i].getName()))));
			return list;
		}
	}
}
