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
import org.whole.lang.ui.editparts.IVisibilityManager;
import org.whole.lang.ui.figures.EntityButton;
import org.whole.lang.ui.figures.EntityFigure;
import org.whole.lang.ui.figures.FigureConstants;
import org.whole.lang.ui.figures.ManagedContentPaneFigure;
import org.whole.lang.ui.figures.TableFigure;
import org.whole.lang.ui.layout.Alignment;
import org.whole.lang.ui.layout.ColumnLayout;
import org.whole.lang.ui.layout.RowLayout;
import org.whole.lang.ui.layout.TableLayout;
import org.whole.lang.ui.layout.TableRowLayout;

/**
 * @author Riccardo Solmi
 */
public class SimpleEntityTableFigure extends ManagedContentPaneFigure {
	protected EntityFigure typeRow;
	protected TableFigure childrenFigure;

	public SimpleEntityTableFigure(EntityDescriptor<?> ed, IVisibilityManager visibilityManager, ActionListener linkListener) {
		super(new ColumnLayout().withSpacing(2), visibilityManager);
		int childSize = ed.childFeatureSize();
		initContentPanes(childSize);

		typeRow = new EntityFigure(new RowLayout().withMargin(1, 3, 1, 3).withSpacing(4));
		if (childSize == 0) {
			typeRow.addDeclaration(ed.getName());
			add(typeRow);
			return;
		}
		typeRow.add(createFoldingToggle(getVisibilityPaneIndex()+1));
		typeRow.addDeclaration(ed.getName());
		typeRow.add(createVisibilityToggle());
		add(typeRow);

		childrenFigure = createTableFigure(2);
		childrenFigure.getLayoutManager().withColumnAlignment(0, Alignment.TRAILING);
		for (int i=0; i<childSize; i++) {
			EntityFigure featureRow = new EntityFigure(new TableRowLayout()
					.withMinorAlignment(Alignment.LEADING));
			featureRow.addLabel(ed.getEntityFeatureDescriptor(i).getName());
			featureRow.add(createContentPane(i));
			childrenFigure.add(featureRow);
			bindFoldingToggle(0, i);
		}
		for (int i=childSize, size=ed.featureSize(); i<size; i++) {
			EntityFigure featureRow = new EntityFigure(new TableRowLayout()
					.withMinorAlignment(Alignment.LEADING));
			featureRow.addLabel(ed.getEntityFeatureDescriptor(i).getName());
			featureRow.add(new EntityButton(linkListener, i));
			childrenFigure.add(featureRow);
		}
		add(childrenFigure);

		initVisibilityToggle();
	}

	protected IFigure getContentPaneContainer() {
		return childrenFigure;
	}

	@Override
	protected void toggleVisibility(int paneIndex) {
		if (paneIndex == getVisibilityPaneIndex()+1)
			childrenFigure.setVisible(!childrenFigure.isVisible());
		else
			super.toggleVisibility(paneIndex);
	}

	protected TableFigure createTableFigure(int columns) {
		return new TableFigure(new TableLayout(columns)
				.withColumnSpacing(10).withRowSpacing(2).withMargin(0, 16, 0, 0)) {
			protected void paintFigure(Graphics g) {
				super.paintFigure(g);

				TableLayout l = getLayoutManager();
				if (l.rows() == 0)
					return;

				g.setForegroundColor(ColorConstants.lightGray);
				drawColumnSeparators(g);
//				drawTableRowsBorder(g);
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
