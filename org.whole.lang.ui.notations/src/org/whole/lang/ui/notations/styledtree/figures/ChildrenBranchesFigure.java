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
package org.whole.lang.ui.notations.styledtree.figures;

import java.util.List;

import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.SWT;
import org.whole.lang.ui.figures.AnchorFactory;
import org.whole.lang.ui.figures.CompositeFigure;
import org.whole.lang.ui.figures.CompositePlaceHolderBorder;
import org.whole.lang.ui.figures.FigureConstants;
import org.whole.lang.ui.figures.IEntityFigure;
import org.whole.lang.ui.figures.INodeFigure;
import org.whole.lang.ui.figures.NodeFigure;
import org.whole.lang.ui.layout.MonoLayout;

/**
 * @author Riccardo Solmi
 */
public class ChildrenBranchesFigure extends NodeFigure {
	public ChildrenBranchesFigure() {
		setLayoutManager(new MonoLayout());
		initContentPanes(1);

		add(createContentPane(0, createCompositeFigure()));
	}

	protected IEntityFigure createCompositeFigure() {
		CompositeFigure figure = new CompositeFigure(false);
//		{
//			protected void paintFigure(Graphics g) {
//				super.paintFigure(g);
//
//				if (getChildren().isEmpty()) {
//					Rectangle b = getBounds().getResized(-1, -1);
//
//					g.setForegroundColor(FigureConstants.blueColor);
//					g.setLineStyle(SWT.LINE_CUSTOM);
//					g.setLineDash(new int[] {4,2});
//					g.drawRoundRectangle(b, 8, 8);
//					g.setLineStyle(SWT.LINE_SOLID);
//					g.setLineDash((int[]) null);
//				}
//			}
//		};
		figure.getLayoutManager().withSpacing(4)//.withMinorAlignment(Alignment.MATHLINE)
				.withMarginLeft(0).withMarginRight(10);
		figure.setBorder(CompositePlaceHolderBorder.OPTIONAL_VERTICAL);
		return figure;
	}

	@Override
	protected ConnectionAnchor[] createTargetAnchors() {
		@SuppressWarnings("unchecked")
		List<IFigure> children = getContentPane(0).getChildren();
		int childrenSize = children.size();

		if (childrenSize == 0)
			return NO_ANCHORS;
		else {
			ConnectionAnchor[] anchors = new ConnectionAnchor[childrenSize];
			for (int i=0; i<childrenSize; i++) {
				IFigure child = children.get(i);
				if (child instanceof INodeFigure) {
					anchors[i] = ((INodeFigure) child).getTargetAnchor(0);//TODO x size
				} else
					anchors[i] = AnchorFactory.createLeftMiddleAnchor(child);
			}
	
			return anchors;
		}
	}

}
