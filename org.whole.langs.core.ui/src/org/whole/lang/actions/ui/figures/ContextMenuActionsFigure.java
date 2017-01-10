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
package org.whole.lang.actions.ui.figures;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.SWT;
import org.whole.lang.ui.figures.ContentPaneFigure;
import org.whole.lang.ui.figures.EntityFigure;
import org.whole.lang.ui.figures.FigureConstants;
import org.whole.lang.ui.figures.IEntityFigure;
import org.whole.lang.ui.figures.TableRowFigure;
import org.whole.lang.ui.layout.Alignment;
import org.whole.lang.ui.layout.ColumnLayout;
import org.whole.lang.ui.layout.IEntityLayout;
import org.whole.lang.ui.layout.RowLayout;
import org.whole.lang.ui.layout.TableLayout;
import org.whole.lang.ui.notations.figures.DrawUtils;

/**
 * @author Riccardo Solmi
 */
public class ContextMenuActionsFigure extends ContentPaneFigure {
	protected EntityFigure menuFigure;
	protected IEntityFigure[] itemFigure, actionFigure;

	private static final int MENU_SEPARATOR_SIZE = 7;
	private static final String[] MENU_NAMES = {
		"Value Assist", "Source", "Refactor",
		"Translate", "Analyze", "Migrate"
	};
	
	public ContextMenuActionsFigure() {
		super(new RowLayout().withSpacing(26));
		final int MENUS = MENU_NAMES.length; //should be the same as WholeMenu.values().length;
		initContentPanes(MENUS);
		itemFigure = new IEntityFigure[MENUS];
		actionFigure = new IEntityFigure[MENUS];

		menuFigure = new EntityFigure(new TableLayout(2).withColumnSpacing(24).withMargin(6, 20, 9, 0)) {
			protected void paintFigure(Graphics g) {
				super.paintFigure(g);

				Rectangle bounds = getBounds().getResized(-6, 0);
				DrawUtils.drawShadowBorder(g, bounds, true);
				IEntityLayout layout = getLayoutManager();
				int y = (layout.getBounds(0).bottom() -MENU_SEPARATOR_SIZE  + layout.getBounds(1).y) / 2;
				g.setLineStyle(SWT.LINE_CUSTOM);
				g.setLineDash(new int[] {1,1});			
				g.drawLine(bounds.x, y, bounds.right(), y);
				g.setLineStyle(SWT.LINE_SOLID);
				g.setLineDash((int[]) null);
			}
		};
		EntityFigure actionsFigure = new EntityFigure(new ColumnLayout().withSpacing(8));

		for (int i=0; i<MENUS; i++) {
			menuFigure.add(itemFigure[i] = createMenuRow(MENU_NAMES[i], i));
			actionsFigure.add(actionFigure[i] = createContentPane(i));
			if (i == 0) {
				itemFigure[i].getLayoutManager().withMarginBottom(MENU_SEPARATOR_SIZE);
				actionFigure[i].setBorder(new MarginBorder(6, 10, 9, 20) {
					public void paint(IFigure f, Graphics g, Insets i) {
						g.pushState();
						Rectangle r = getPaintRectangle(f, i);
						DrawUtils.drawShadowBorder(g, r, false);
						g.popState();
					}
		    	});
			}
		}

		add(menuFigure);
		add(actionsFigure);
	}

	protected EntityFigure createMenuRow(String text, int paneIndex) {
		TableRowFigure row = new TableRowFigure();
		row.getLayoutManager().withMajorAlignment(Alignment.TRAILING);
		row.addLabel(text);
		row.add(createFoldingToggle(paneIndex));
		return row;
	}

	protected void paintFigure(Graphics g) {
		super.paintFigure(g);

		g.setForegroundColor(FigureConstants.contentLighterColor);
		g.setLineStyle(SWT.LINE_CUSTOM);
		g.setLineDash(new int[] {1,1});

		Point[] start = new Point[itemFigure.length];
		Point[] end = new Point[itemFigure.length];
		int menuRight = menuFigure.getBounds().right();
		int size = 0;
		for (int i = 0; i < itemFigure.length; i++) {
			if (getContentPane(i).isVisible()) {
				start[size] = getFoldingToggle(i).getBounds().getRight();
				start[size].x = menuRight;
				end[size] = actionFigure[i].getBounds().getLeft();
				size++;
			}
		}
		
		DrawUtils.drawRightEdges(g, start, end, size);
	}
}
