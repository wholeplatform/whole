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
package org.whole.lang.ui.notations.map.figures;

import java.util.List;

import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LayoutManager;
import org.eclipse.draw2d.Toggle;
import org.eclipse.draw2d.TreeSearch;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.whole.lang.ui.figures.EntityFigure;
import org.whole.lang.ui.figures.FigureConstants;
import org.whole.lang.ui.figures.NodeFigure;
import org.whole.lang.ui.layout.IEntityLayout;
import org.whole.lang.ui.layout.RowLayout;
import org.whole.lang.ui.notations.map.layouts.IStyledLayout;

/**
 * @author Riccardo Solmi
 */
public abstract class AbstractStyledFigure extends NodeFigure implements IStyledFigure {
	protected IFigure shapeFigure;
	private Color lineColor;
	private int lineStyle = SWT.LINE_SOLID;
	private int lineWidth = 1;

	public AbstractStyledFigure(IStyledLayout layout) {
		setLayoutManager(layout);
		initFigure();
	}
	
	protected void initFigure() {
		initContentPanes(2);

		shapeFigure = new EntityFigure(new RowLayout().withSpacing(4));
		shapeFigure.add(createContentPane(0));
		shapeFigure.add(createFoldingToggle(1));
		add(shapeFigure);
		add(createContentPane(1));		
	}

	protected IFigure getShapeFigure() {
		return shapeFigure;
	}

	@Override
	protected ConnectionAnchor[] getTargetAnchors() {
		return getLayoutManager().getTargetAnchors(this);
	}
	@Override
	protected void invalidateTargetAnchors() {
		getLayoutManager().invalidateTargetAnchors();
	}

	public IEntityLayout getChildrenLayoutManager() {
		return getLayoutManager().getChildrenLayoutManager();
	}
	@Override
	public IStyledLayout getLayoutManager() {
		return (IStyledLayout) super.getLayoutManager();
	}
	@Override
	public void setLayoutManager(LayoutManager manager) {
		assert manager instanceof IStyledLayout;
		super.setLayoutManager(manager);
	}

	public Font getTextFont() {
		return getContentPane(0).getFont();
	}
	public void setTextFont(Font font) {
		getContentPane(0).setFont(font);
		invalidateTree();
		revalidate();
		repaint();
	}

	public Color getLineColor() {
		return lineColor != null ? lineColor : FigureConstants.relationsColor;
	}
	public void setLineColor(Color lineColor) {
		this.lineColor = lineColor;
		revalidate();
		repaint();
	}

	public int getLineStyle() {
		return lineStyle;
	}
	public void setLineStyle(int lineStyle) {
		this.lineStyle = lineStyle;
		revalidate();
		repaint();
	}

	public int getLineWidth() {
		return lineWidth;
	}
	public void setLineWidth(int lineWidth) {
		this.lineWidth = lineWidth;
		revalidate();
		repaint();
	}

	@Override
	public IFigure findFigureAt(int x, int y, TreeSearch search) {
		IFigure f = getShapeFigure().findFigureAt(x, y, search);
		if (f != null)
			return f;

		return super.findFigureAt(x, y, search);
	}

	@Override
	public IFigure findMouseEventTargetAt(int x, int y) {
		IFigure f = getShapeFigure().findMouseEventTargetAt(x, y);
		if (f != null)
			return f;

		return super.findMouseEventTargetAt(x, y);
	}

	@Override
	public void paintClientArea(Graphics graphics) {
		paintConnections(graphics);
		graphics.restoreState();
		super.paintClientArea(graphics);
	}

	protected boolean hasVisibleConnections() {
		List<Toggle> toggles = getFoldingToggles();
		return toggles.isEmpty() || !toggles.get(0).isSelected();
	}
	protected void paintConnections(Graphics graphics) {
		if (!hasVisibleConnections())
			return;

		graphics.setForegroundColor(getLineColor());
		graphics.setLineStyle(getLineStyle());
		graphics.setLineWidth(getLineWidth());

		getLayoutManager().paintConnections(graphics);
	}
}
