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

import org.eclipse.draw2d.IFigure;
import org.whole.lang.ui.editparts.AbstractDataEntityPart;
import org.whole.lang.ui.figures.IEntityFigure;
import org.whole.lang.ui.figures.LabelFactory;
import org.whole.lang.ui.notations.styledtree.figures.DataNodeFigure;
import org.whole.lang.ui.notations.styledtree.styling.IEntityStyling;
import org.whole.lang.ui.notations.styledtree.styling.IStyledPart;
import org.whole.lang.ui.notations.styledtree.styling.IStylingFactory;

/**
 * @author Riccardo Solmi
 */
public class DataEntityStyledTreePart extends AbstractDataEntityPart implements IStyledPart {
	protected IStylingFactory stylingFactory;
	protected IEntityStyling entityStyling;

	public DataEntityStyledTreePart(IStylingFactory stylingFactory, IEntityStyling entityStyling) {
		this.stylingFactory = stylingFactory;
		this.entityStyling = entityStyling;
		setFlag(FLAG_REVERSED, false);
	}

	public IEntityStyling getEntityStyling() {
		return entityStyling;
	}

	public boolean isReversable() {
		return false;
	}

	protected IFigure createFigure() {
		return new DataNodeFigure(entityStyling) {
			@Override
			protected int getDataPaneIndex() {
				return 0;
			}
			@Override
			protected IEntityFigure createTypeLabelFigure() {
				String name = entityStyling.getTypeLabel();
				return LabelFactory.createDeclaration(name);
			}
			@Override
			protected IEntityFigure createDataFigure() {
				return createContentPane(0, LabelFactory.createLiteral());
			}
		};
	}
}
