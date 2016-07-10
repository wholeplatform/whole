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
import org.whole.lang.ui.editparts.AbstractCompositePart;
import org.whole.lang.ui.figures.CompositeFigure;
import org.whole.lang.ui.figures.CompositePlaceHolderBorder;
import org.whole.lang.ui.figures.IEntityFigure;
import org.whole.lang.ui.figures.LabelFactory;
import org.whole.lang.ui.layout.Alignment;
import org.whole.lang.ui.notations.styledtree.figures.NodeWithCompositeBranchFigure;
import org.whole.lang.ui.notations.styledtree.styling.IEntityStyling;
import org.whole.lang.ui.notations.styledtree.styling.IStyledPart;

/**
 * @author Riccardo Solmi
 */
public class CompositeEntityStyledTreePart extends AbstractCompositePart implements IStyledPart {
	protected IEntityStyling entityStyling;

	public CompositeEntityStyledTreePart(IEntityStyling entityStyling) {
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
		return new NodeWithCompositeBranchFigure(entityStyling) {
			@Override
			protected int getChildrenPaneIndex() {
				return 0;
			}
			@Override
			protected IEntityFigure createTypeLabelFigure() {
				String name = entityStyling.getTypeLabel();
				return LabelFactory.createDeclaration(name);
			}
			@Override
			protected IEntityFigure createChildrenFigure() {
				CompositeFigure compositeFigure = new CompositeFigure(false);
				compositeFigure.setBorder(CompositePlaceHolderBorder.OPTIONAL_VERTICAL);
				compositeFigure.getLayoutManager().withSpacing(4)
					.withMarginLeft(0).withMarginRight(10)
						.withMinorAlignment(Alignment.LEADING);
				return createContentPane(0, compositeFigure);
			}
		};
	}
}
