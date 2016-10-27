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

import java.beans.PropertyChangeEvent;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.whole.lang.commons.factories.CommonsEntityFactory;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.ui.editparts.AbstractContentPanePart;
import org.whole.lang.ui.editparts.IEntityPart;
import org.whole.lang.ui.notations.styledtree.figures.CompositeTableFigure;
import org.whole.lang.ui.notations.styledtree.figures.DataNodeFigure;
import org.whole.lang.ui.notations.styledtree.figures.NodeWithCompositeBranchFigure;
import org.whole.lang.ui.notations.styledtree.figures.SimpleTableNodeWithBranchesFigure;
import org.whole.lang.ui.notations.styledtree.styling.IEntityStyling;
import org.whole.lang.ui.notations.styledtree.styling.INotationStyling;
import org.whole.lang.ui.notations.styledtree.styling.IStyledPart;
import org.whole.lang.ui.notations.styledtree.styling.IStylingFactory;
import org.whole.lang.ui.notations.styledtree.styling.EntityStyling.LayoutStyle;


/**
 * @author Riccardo Solmi
 */
public class AdaptiveEntityPart extends AbstractContentPanePart implements IStyledPart {
	protected IStylingFactory stylingFactory;
	protected IEntityStyling entityStyling;
	protected FeatureDescriptor typeFeature;
	protected FeatureDescriptor childrenFeature;

	public AdaptiveEntityPart(IStylingFactory stylingFactory, FeatureDescriptor typeFeature, FeatureDescriptor childrenFeature) {
		this.stylingFactory = stylingFactory;
		this.typeFeature = typeFeature;
		this.childrenFeature = childrenFeature;
	}

	public IEntityStyling getEntityStyling() {
		if (entityStyling == null)
			entityStyling = stylingFactory.getNotationStyling().getEntityStyling(
					stylingFactory, (IEntityPart) getParent(), getModelEntity());
		return entityStyling;
	}

	@Override
	protected void propertyChangeUI(PropertyChangeEvent evt) {
		if (evt.getPropertyName().equals("notation#rebuild")) {
			rebuild();
			return;
		}
		FeatureDescriptor fd = getModelEntity().wGetEntityDescriptor().getFeatureDescriptorEnum().valueOf(evt.getPropertyName());
		if (typeFeature.equals(fd)) {
			entityStyling = null;
			rebuild();
			return;
		}

		super.propertyChangeUI(evt);
	}

	protected IFigure createFigure() {
		IEntityStyling entityStyling = getEntityStyling();
		INotationStyling notationStyling = entityStyling.getNotationStyling();
		
		switch (entityStyling.getKind()) {
		case DATA:
			switch (notationStyling.getEmbeddingStyle(stylingFactory, (IEntityPart) getParent(), getModelEntity())) {
			case TABLE_CELL:
				//TODO
			case NONE:
			default:
				return new DataNodeFigure(entityStyling);
			}
		case SIMPLE:
			return new SimpleTableNodeWithBranchesFigure(true, entityStyling);
		case COMPOSITE:
		default:
			if (entityStyling.getLayoutStyle().equals(LayoutStyle.COMPOSITE_TABLE))
				return new CompositeTableFigure(entityStyling);
			else
				return new NodeWithCompositeBranchFigure(entityStyling);
		}
	}

	protected List<IEntity> getModelSpecificChildren() {
		IEntity entity = getModelEntity();
		List<IEntity> list = new ArrayList<IEntity>(2);
		list.add(entity.wGet(typeFeature));
		IEntity childrenEntity = entity.wGet(childrenFeature);
		if (entityStyling.getKind().isSimple()) {
			int childrenSize = childrenEntity.wSize();
			int featuresSize = entityStyling.getFeaturesStyling().length;
			for (int i=0; i<Math.min(childrenSize, featuresSize); i++)
				list.add(childrenEntity.wGet(i));
			//TODO test
			if (childrenSize != featuresSize)
			if (childrenSize < featuresSize)
				for (int i=0; i<featuresSize-childrenSize; i++)
					list.add(CommonsEntityFactory.instance.createResolver());
		} else
			list.add(entity.wGet(childrenEntity));
		return list;
	}
}
