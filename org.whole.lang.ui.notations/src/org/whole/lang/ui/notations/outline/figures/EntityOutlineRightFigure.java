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
package org.whole.lang.ui.notations.outline.figures;

import java.util.List;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.swt.SWT;
import org.whole.lang.ui.figures.ContentPaneFigure;
import org.whole.lang.ui.figures.EntityFigure;
import org.whole.lang.ui.figures.FigureConstants;
import org.whole.lang.ui.figures.IEntityFigure;
import org.whole.lang.ui.figures.ITextFigure;
import org.whole.lang.ui.figures.TableFigure;
import org.whole.lang.ui.figures.TableRowFigure;
import org.whole.lang.ui.layout.Alignment;
import org.whole.lang.ui.layout.RowLayout;
import org.whole.lang.ui.layout.TableLayout;
import org.whole.lang.ui.layout.TableRowLayout;
import org.whole.lang.ui.layout.UnderColumnLayout;
import org.whole.lang.ui.notations.figures.DrawUtils;

/**
 * @author Riccardo Solmi
 */
public class EntityOutlineRightFigure extends ContentPaneFigure {
	public EntityOutlineRightFigure() {
		super(new UnderColumnLayout().withMinorAlignment(Alignment.LEADING));
		initContentPanes(2);

		EntityFigure typeRow = new EntityFigure(new RowLayout().withSpacing(4));
		typeRow.add(createFoldingToggle(1));
		typeRow.add(createContentPane(0));
		add(typeRow);

		add(createContentPane(1, new MarginBorder(5, 20, 0, 0)));
	}

	@Override
	public void paintClientArea(Graphics graphics) {
		super.paintClientArea(graphics);
		paintConnections(graphics);
		graphics.restoreState();
	}

	@SuppressWarnings("unchecked")
	protected void paintConnections(Graphics graphics) {
		graphics.setForegroundColor(FigureConstants.contentLighterColor);
		
		Point rootPoint = getFoldingToggle(0).getBounds().getBottom();

		Object childrenFigure = getContentPane(1).getChildren().get(0);
		Point[] childrenPoints = null;
		if (childrenFigure instanceof TableFigure) {
			TableFigure tableFigure = (TableFigure) childrenFigure;
			TableLayout layoutManager = tableFigure.getLayoutManager();
			
			int childrenSize = layoutManager.rows();
			childrenPoints = new Point[childrenSize];
			if (childrenSize == 0)
				return;

			for (int i=0; i<childrenSize; i++) {
				IFigure row = layoutManager.getRow(i);
				List<IFigure> rowChildren = row.getChildren();
				if (row instanceof TableRowFigure && !rowChildren.isEmpty()) {
					childrenPoints[i] = row.getBounds().getLeft().translate(-8, 0);
					childrenPoints[i].y = ((TableRowLayout) row.getLayoutManager()).getBaseline(0);
				} else if (row instanceof IEntityFigure) {
					childrenPoints[i] = row.getBounds().getTopLeft().translate(-4, 
							((IEntityFigure) row).getAscent());
				} else
					childrenPoints[i] = row.getBounds().getLeft().translate(-4, 0);
			}
		} else {
			IFigure childFigure = (IFigure) childrenFigure;
			List<IFigure> children = childFigure.getChildren();
			int childrenSize = children.size();
			if (childrenSize == 0 || childFigure instanceof ITextFigure) {
				childrenPoints = new Point[1];
				if (childFigure instanceof IEntityFigure)
					childrenPoints[0] = childFigure.getBounds().getTopLeft().translate(-4,
							((IEntityFigure) childFigure).getAscent());
				else
					childrenPoints[0] = childFigure.getBounds().getLeft().translate(-4, 0);
			} else {
				childrenPoints = new Point[childrenSize];
				for (int i=0; i<childrenSize; i++) {
					childFigure = children.get(i);
					if (childFigure instanceof IEntityFigure)
						childrenPoints[i] = childFigure.getBounds().getTopLeft().translate(-6,
								((IEntityFigure) childFigure).getAscent());
					else
						childrenPoints[i] = childFigure.getBounds().getLeft().translate(-6, 0);
				}
			}
		}
			
		graphics.setForegroundColor(ColorConstants.lightGray);
		graphics.setLineStyle(SWT.LINE_CUSTOM);
		graphics.setLineDash(new int[] {1,1});
		DrawUtils.drawOutline(graphics, rootPoint, childrenPoints);
		graphics.setLineStyle(SWT.LINE_SOLID);
		graphics.setLineDash((int[]) null);
	}
}
