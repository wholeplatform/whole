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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.ActionListener;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.swt.SWT;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.ui.editparts.IVisibilityManager;
import org.whole.lang.ui.figures.EntityButton;
import org.whole.lang.ui.figures.EntityFigure;
import org.whole.lang.ui.figures.FigureConstants;
import org.whole.lang.ui.figures.ManagedContentPaneFigure;
import org.whole.lang.ui.figures.TableFigure;
import org.whole.lang.ui.layout.Alignment;
import org.whole.lang.ui.layout.RowLayout;
import org.whole.lang.ui.layout.TableLayout;
import org.whole.lang.ui.layout.TableRowLayout;
import org.whole.lang.ui.layout.UnderColumnLayout;
import org.whole.lang.ui.notations.figures.DrawUtils;

/**
 * @author Riccardo Solmi
 */
public class SimpleEntityOutlineFigure extends ManagedContentPaneFigure {
	private TableFigure childrenFigure;

	public SimpleEntityOutlineFigure(EntityDescriptor<?> ed, IVisibilityManager visibilityManager, ActionListener linkListener) {
		super(new UnderColumnLayout().withMinorAlignment(Alignment.LEADING).withSpacing(1), visibilityManager);
		int childSize = ed.childFeatureSize();
		initContentPanes(childSize);

		EntityFigure typeRow = new EntityFigure(new RowLayout().withSpacing(4));
		typeRow.add(createFoldingToggle(getVisibilityPaneIndex()+1));
		typeRow.addDeclaration(ed.getName());
		typeRow.add(createVisibilityToggle());
		add(typeRow);

		childrenFigure = createTableFigure(2);

		for (int i=0; i<childSize; i++) {
			EntityFigure featureRow = new EntityFigure(
					new TableRowLayout().withMinorAlignment(Alignment.LEADING));
			featureRow.addContent(ed.getEntityFeatureDescriptor(i).getName());
			featureRow.add(createContentPane(i));
			childrenFigure.add(featureRow);
			bindFoldingToggle(0, i);
		}
		for (int i=childSize, size=ed.featureSize(); i<size; i++) {
			EntityFigure featureRow = new EntityFigure(
					new TableRowLayout().withMinorAlignment(Alignment.LEADING));
			featureRow.addContent(ed.getEntityFeatureDescriptor(i).getName());
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
				.withColumnSpacing(10).withRowSpacing(2).withMargin(0, 24, 0, 0)) {
			protected void paintFigure(Graphics g) {
				super.paintFigure(g);

				TableLayout l = getLayoutManager();
				if (l.rows() == 0)
					return;

				g.setBackgroundColor(ColorConstants.lightGray);
				drawAlternateColumnsBackground(g, 0);
				g.setForegroundColor(ColorConstants.lightGray);
				drawColumnSeparators(g);
			}
		};
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

		List<IFigure> children = childrenFigure.getChildren();
		int childrenSize = children.size();
		if (childrenSize == 0)
			return;

		List<Point> pointList = new ArrayList<Point>(childrenSize);
		for (int i=0; i<childrenSize; i++)
			if (children.get(i).isVisible())
				pointList.add(((IFigure) children.get(i).getChildren().get(0)).getBounds().getLeft().translate(-8, 0));

		if (!pointList.isEmpty()) {
			graphics.setForegroundColor(ColorConstants.lightGray);
			graphics.setLineStyle(SWT.LINE_CUSTOM);
			graphics.setLineDash(new int[] {1,1});
			DrawUtils.drawOutline(graphics, rootPoint, pointList.toArray(new Point[pointList.size()]));//childrenPoints);
			graphics.setLineStyle(SWT.LINE_SOLID);
			graphics.setLineDash((int[]) null);
		}
	}
}
