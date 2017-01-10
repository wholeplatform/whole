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

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Rectangle;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.ui.figures.ContentPaneFigure;
import org.whole.lang.ui.figures.EntityFigure;
import org.whole.lang.ui.figures.FigureConstants;
import org.whole.lang.ui.figures.TableFigure;
import org.whole.lang.ui.figures.TableRowFigure;
import org.whole.lang.ui.layout.Alignment;
import org.whole.lang.ui.layout.ColumnLayout;
import org.whole.lang.ui.layout.RowLayout;
import org.whole.lang.ui.layout.TableLayout;

/**
 * @author Riccardo Solmi
 */
public class CompositeEntityTableFigure extends ContentPaneFigure {
	protected EntityFigure typeRow;
	protected TableFigure tableFigure;

	public CompositeEntityTableFigure(EntityDescriptor<?> ed) {
		super(new ColumnLayout());
		initContentPanes(1);

		typeRow = new EntityFigure(new RowLayout().withMargin(1, 3, 1, 3).withSpacing(4));
		typeRow.add(createFoldingToggle(0));
		typeRow.addDeclaration(ed.getName());
		add(typeRow);

		EntityDescriptor<?> eed = ed.getEntityDescriptor(0);
		//max is a workaround for data and composite entities
		tableFigure = createTableFigure(Math.max(1, eed.featureSize()));
		if (eed.getEntityKind().isSimple())
			tableFigure.add(createTableHeadersRow(eed), TableLayout.Placement.HEADER);
		initColumnAlignments(tableFigure.getLayoutManager(), eed);
		add(createContentPane(0, tableFigure));
	}

	protected TableFigure createTableFigure(int columns) {
		return new TableFigure(columns) {
			protected void paintFigure(Graphics g) {
				super.paintFigure(g);

				g.setBackgroundColor(ColorConstants.lightGray);
				drawHeadersRowBackground(g);

				g.setForegroundColor(ColorConstants.lightGray);
				drawColumnSeparators(g);
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
	protected TableRowFigure createTableHeadersRow(EntityDescriptor<?> elementEntityDescriptor) {
		TableRowFigure tableHeaderFigure = new TableRowFigure();
		for (FeatureDescriptor fd : elementEntityDescriptor.getEntityFeatureDescriptors())
			tableHeaderFigure.addLabel(fd.getName());
		return tableHeaderFigure;
	}
	protected void initColumnAlignments(TableLayout tableLayout, EntityDescriptor<?> elementEntityDescriptor) {
		if (elementEntityDescriptor.getEntityKind().isData())
			initColumnAlignment(tableLayout, 0, elementEntityDescriptor);
		else if (elementEntityDescriptor.featureSize() == 0)
			return;
		else
			for (int i=0; i<tableLayout.columns(); i++) {
				EntityDescriptor<?> columnEntityDescriptor = elementEntityDescriptor.getEntityDescriptor(i);
				if (columnEntityDescriptor.getEntityKind().isData()) {
					initColumnAlignment(tableLayout, i, columnEntityDescriptor);
				}
			}
	}
	protected void initColumnAlignment(TableLayout tableLayout, int i, EntityDescriptor<?> columnEntityDescriptor) {
		switch (columnEntityDescriptor.getDataKind()) {
		case BOOLEAN:
		case BYTE:
		case CHAR:
		case DOUBLE:
		case FLOAT:
		case INT:
		case LONG:
		case SHORT:
			tableLayout.withColumnAlignment(i, Alignment.TRAILING);
			break;
		default:
		}
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
