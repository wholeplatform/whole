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
package org.whole.lang.ui.notations.table.figures;

import org.eclipse.draw2d.ActionListener;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Rectangle;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.ui.figures.ContentPaneFigure;
import org.whole.lang.ui.figures.EntityButton;
import org.whole.lang.ui.figures.EntityFigure;
import org.whole.lang.ui.figures.FigureConstants;
import org.whole.lang.ui.figures.TableFigure;
import org.whole.lang.ui.layout.Alignment;
import org.whole.lang.ui.layout.ColumnLayout;
import org.whole.lang.ui.layout.RowLayout;
import org.whole.lang.ui.layout.TableRowLayout;

/**
 * @author Riccardo Solmi
 */
public class CompositeEntityReferenceColumnFigure extends ContentPaneFigure {
	protected ActionListener linkListener;
	protected EntityFigure typeRow;
	protected TableFigure tableFigure;

	public CompositeEntityReferenceColumnFigure(EntityDescriptor<?> ed, ActionListener linkListener) {
		super(new ColumnLayout());
		initContentPanes(1);
		this.linkListener = linkListener;

		typeRow = new EntityFigure(new RowLayout().withMargin(1, 3, 1, 3).withSpacing(4));
		typeRow.add(createFoldingToggle(0));
		typeRow.addDeclaration(ed.getName());
		add(typeRow);

		tableFigure = createTableFigure(1);
		tableFigure.getLayoutManager().withColumnAlignment(0, Alignment.LEADING);
		add(createContentPane(0, tableFigure));
	}

	public void setAdjacentSize(int size) {
		for (int i=tableFigure.getChildren().size(); i<size; i++) {
			EntityFigure featureRow = new EntityFigure(new TableRowLayout()
					.withMinorAlignment(Alignment.LEADING));
			featureRow.add(new EntityButton(linkListener, i));
			tableFigure.add(featureRow);
		}

		while (tableFigure.getChildren().size() > size)
			tableFigure.remove((IFigure) tableFigure.getChildren().get(size));

		revalidate();
		repaint();
	}

	@Override
	protected void toggleVisibility(int paneIndex) {
		if (paneIndex == 0) {
			IFigure contentPane = getContentPane(paneIndex);
			boolean visible = !contentPane.isVisible();
			contentPane.setVisible(visible);
		} else
			super.toggleVisibility(paneIndex);
	}

	protected TableFigure createTableFigure(int columns) {
		return new TableFigure(columns) {
			protected void paintFigure(Graphics g) {
				super.paintFigure(g);

				g.setBackgroundColor(ColorConstants.lightGray);
				drawHeadersRowBackground(g);

				g.setForegroundColor(ColorConstants.lightGray);
//				drawColumnSeparators(g);
				drawHeadersRowSeparator(g);
				
				int oldAlpha = g.getAlpha();
				g.setAlpha(80);
				drawRowSeparators(g);
				drawTableColumnsBorder(g);
				drawTableRowsBorder(g);
				g.setAlpha(oldAlpha);
			}
		};
	}

	@Override
	protected void paintFigure(Graphics g) {
		super.paintFigure(g);
		
		int oldAlpha = g.getAlpha();
		g.setAlpha(60);
		Rectangle b = getBounds();
		g.setBackgroundColor(FigureConstants.blueColor);
		g.fillRectangle(b.x, b.y, b.width, typeRow.getBounds().height);
		g.setAlpha(oldAlpha);

	}
}
