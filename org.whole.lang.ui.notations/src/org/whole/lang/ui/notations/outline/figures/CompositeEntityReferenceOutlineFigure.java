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

import org.eclipse.draw2d.ActionListener;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.swt.SWT;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.ui.figures.CompositeFigure;
import org.whole.lang.ui.figures.ContentPaneFigure;
import org.whole.lang.ui.figures.EntityButton;
import org.whole.lang.ui.figures.EntityFigure;
import org.whole.lang.ui.figures.FigureConstants;
import org.whole.lang.ui.layout.Alignment;
import org.whole.lang.ui.layout.ColumnLayout;
import org.whole.lang.ui.layout.ICompositeEntityLayout;
import org.whole.lang.ui.layout.RowLayout;
import org.whole.lang.ui.layout.UnderColumnLayout;
import org.whole.lang.ui.notations.figures.DrawUtils;

/**
 * @author Riccardo Solmi
 */
public class CompositeEntityReferenceOutlineFigure extends ContentPaneFigure {
	protected ActionListener linkListener;
	protected CompositeFigure compositeFigure;

	public CompositeEntityReferenceOutlineFigure(EntityDescriptor<?> ed, ActionListener linkListener) {
		super(new UnderColumnLayout().withMinorAlignment(Alignment.LEADING));
		initContentPanes(1);
		this.linkListener = linkListener;

		EntityFigure typeRow = new EntityFigure(new RowLayout().withSpacing(4));
		typeRow.add(createFoldingToggle(0));
		typeRow.addDeclaration(ed.getName());
		add(typeRow);

		compositeFigure = new CompositeFigure(new ColumnLayout().withMargin(5, 18, 5, 0).withSpacing(5));
		compositeFigure.setBorder(null);
		add(createContentPane(0, compositeFigure));
	}

	public void setAdjacentSize(int size) {
		for (int i=compositeFigure.getChildren().size(); i<size; i++)
			compositeFigure.add(new EntityButton(linkListener, i));

		while (compositeFigure.getChildren().size() > size)
			compositeFigure.remove((IFigure) compositeFigure.getChildren().get(size));

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

		List<IFigure> children = compositeFigure.getChildren();
		int childrenSize = children.size();
		if (childrenSize == 0)
			return;

		ICompositeEntityLayout layoutManager = compositeFigure.getLayoutManager();
		Point[] childrenPoints = new Point[childrenSize];
		for (int i=0; i<childrenSize; i++) {
			childrenPoints[i] = children.get(i).getBounds().getLeft();
			childrenPoints[i].y = layoutManager.getBaseline(i);
		}

		graphics.setForegroundColor(ColorConstants.lightGray);
		graphics.setLineStyle(SWT.LINE_CUSTOM);
		graphics.setLineDash(new int[] {1,1});
		DrawUtils.drawOutline(graphics, rootPoint, childrenPoints);
		graphics.setLineStyle(SWT.LINE_SOLID);
		graphics.setLineDash((int[]) null);
	}
}
