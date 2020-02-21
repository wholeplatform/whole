/**
 * Copyright 2004-2019 Riccardo Solmi. All rights reserved.
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
package org.whole.lang.queries.ui.figures;

import java.util.List;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
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
public class CreateFigure extends ContentPaneFigure {
	protected IEntityFigure typeRow;
	protected IEntityFigure registry;
	protected boolean showEntityType;
	protected boolean showRegistry;
	protected boolean showOutline;

	public CreateFigure() {
		super(new RowLayout().withMargin(2, 4, 2, 2).withSpacing(4));
		initContentPanes(3);

		add(createFoldingToggle(2));

		EntityFigure col = new EntityFigure(new UnderColumnLayout().withMinorAlignment(Alignment.LEADING).withSpacing(5));
		
		typeRow = new EntityFigure(new RowLayout().withSpacing(4));
		typeRow.add(createContentPane(0));
		typeRow.add(createContentPane(1));
		col.add(typeRow);
		col.add(createContentPane(2));
		add(col);
	}

	protected void paintFigure(Graphics g) {
		super.paintFigure(g);

		int oldAlpha = g.getAlpha();
		g.setAlpha(FigureConstants.templateLanguageAlpha);
		g.setBackgroundColor(FigureConstants.templateLanguageColor);

		Rectangle b = getBounds();
		Rectangle trb = typeRow.getBounds();
		Rectangle tb = getContentPane(0).getBounds();
		Rectangle rb = getContentPane(1).getBounds();
		Rectangle cb = getContentPane(2).getBounds();
		int height = getContentPane(2).isVisible() ? trb.bottom()-b.y : b.height;

		g.fillRectangle(b.x, b.y, trb.x - b.x, b.height);
		if (showEntityType)
			g.fillRectangle(trb.x, b.y, tb.right()+2 - trb.x, height);
		if (showRegistry)
			g.fillRectangle(rb.x-2, b.y, b.right() - (rb.x-2), height);
		if (getContentPane(2).isVisible()) {
			g.fillRectangle(cb.x, cb.y-(4+1), b.width - cb.x + b.x, 4);
			g.fillRectangle(cb.right(), cb.y -1, b.right() - cb.right(), b.height - cb.y + b.y);
		}

		g.setForegroundColor(ColorConstants.lightGray);
		g.setAlpha(oldAlpha);
		g.drawRectangle(b.x, b.y, b.width-1, b.height-1);
	}

	@Override
	public void paintClientArea(Graphics graphics) {
		super.paintClientArea(graphics);
		paintConnections(graphics);
		graphics.restoreState();
	}

	@SuppressWarnings("unchecked")
	protected void paintConnections(Graphics graphics) {
		if (!getContentPane(2).isVisible())
			return;

		Point rootPoint = getFoldingToggle(0).getBounds().getBottom();

		Object childrenFigure = getContentPane(2).getChildren().get(0);
		Point[] childrenPoints = null;

		if (!showOutline) {
			childrenPoints = new Point[3];
			childrenPoints[0] = ((IFigure) childrenFigure).getBounds().getLeft().translate(-4, -4);
			childrenPoints[1] = childrenPoints[0].getTranslated(0, +3);
			childrenPoints[2] = childrenPoints[1].getTranslated(0, +4);
		} else if (childrenFigure instanceof TableFigure) {
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
			
		graphics.setForegroundColor(FigureConstants.relationsColor);
		graphics.setLineStyle(SWT.LINE_CUSTOM);
		graphics.setLineDash(new int[] {1,1});
		DrawUtils.drawOutline(graphics, rootPoint, childrenPoints);
		graphics.setLineStyle(SWT.LINE_SOLID);
		graphics.setLineDash((int[]) null);
	}

	public void showEntityType(boolean value) {
		showEntityType = value;
	}
	public void showRegistry(boolean value) {
		showRegistry = value;
	}
	public void showOutline(boolean value) {
		showOutline = value;
	}
}
