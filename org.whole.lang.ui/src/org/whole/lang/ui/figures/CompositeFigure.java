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
package org.whole.lang.ui.figures;

import java.util.List;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LayoutAnimator;
import org.eclipse.draw2d.LayoutManager;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.whole.lang.ui.layout.ColumnLayout;
import org.whole.lang.ui.layout.ICompositeEntityLayout;
import org.whole.lang.ui.layout.RowLayout;

/**
 * @author Riccardo Solmi
 */
public class CompositeFigure extends EntityFigure {
	protected CompositeFigure() {
	}
	public CompositeFigure(boolean isHorizontal) {
		this(isHorizontal, true);
	}
	public CompositeFigure(boolean isHorizontal, boolean withPlaceholder) {
		setLayoutManager(createLayoutManager(isHorizontal));
		setOpaque(false);
		if (withPlaceholder)
			setBorder(CompositePlaceHolderBorder.OPTIONAL_COMPOSITE);
	}
	public CompositeFigure(ICompositeEntityLayout layout) {
		this(layout, true);
	}
	public CompositeFigure(ICompositeEntityLayout layout, boolean withPlaceholder) {
		setLayoutManager(layout);
		setOpaque(false);
		if (withPlaceholder)
			setBorder(CompositePlaceHolderBorder.OPTIONAL_COMPOSITE);
	}

	protected ICompositeEntityLayout createLayoutManager(boolean isHorizontal) {
		return isHorizontal ? 
				new RowLayout().withMarginLeft(4).withMarginRight(4).withSpacing(5) : 
				new ColumnLayout().withMarginTop(5).withMarginBottom(5).withSpacing(5);
	}

	@Override
	public void setLayoutManager(LayoutManager manager) {
		super.setLayoutManager(manager);
		addLayoutListener(LayoutAnimator.getDefault());
	}

	@Override
	public ICompositeEntityLayout getLayoutManager() {
		return (ICompositeEntityLayout) super.getLayoutManager();
	}

	public boolean isHorizontal() {
		return getLayoutManager().isHorizontal();
	}
	public void setHorizontal(boolean isHorizontal) {
		setLayoutManager(createLayoutManager(isHorizontal));
	}

	private static final int MINIMUM_WIDTH = 4;
	private static final int MINIMUM_HEIGHT = 4;
	public Dimension getPreferredSize(int wHint, int hHint) {
		Dimension d = super.getPreferredSize(wHint, hHint);
//FIXME move in the layout manager
		d.width = Math.max(d.width, MINIMUM_WIDTH);
		d.height = Math.max(d.height, MINIMUM_HEIGHT);
		return d;
	}

	public String toString() {
		return getChildren().toString()+"(visible="+isVisible()+")";
	}

	@Override
	public void remove(IFigure figure) {
		invalidate(); //FIXME workaround to support Animation (initial state capture)  
		super.remove(figure);
	}

	public void drawFixedSizeChildrenSeparators(Graphics g) {
		if (isHorizontal())
			drawFixedSizeColumnSeparators(g);
		else
			drawFixedSizeRowSeparators(g);
	}
	public void drawVariableSizeChildrenSeparators(Graphics g) {
		if (isHorizontal())
			drawVariableSizeColumnSeparators(g);
		else
			drawVariableSizeRowSeparators(g);
	}
	@SuppressWarnings("unchecked")
	public void drawFixedSizeRowSeparators(Graphics g) {
		List<IFigure> children = getChildren();
		if (children.isEmpty())
			return;

		int x0 = bounds.x;
		int x1 = bounds.right();
		int spacing = getLayoutManager().getSpacing()/2;
		for (int i=0; i<children.size()-1; i++) {
			Rectangle boundsBefore = children.get(i).getBounds();
			int y = boundsBefore.bottom() + spacing;
			g.drawLine(x0, y, x1, y);
		}
	}
	@SuppressWarnings("unchecked")
	public void drawFixedSizeColumnSeparators(Graphics g) {
		List<IFigure> children = getChildren();
		if (children.isEmpty())
			return;

		int y0 = bounds.y;
		int y1 = bounds.bottom();
		int spacing = getLayoutManager().getSpacing()/2;
		for (int i=0; i<children.size()-1; i++) {
			Rectangle boundsBefore = children.get(i).getBounds();
			int x = boundsBefore.right() + spacing;
			g.drawLine(x, y0, x, y1);
		}
	}
	@SuppressWarnings("unchecked")
	public void drawVariableSizeRowSeparators(Graphics g) {
		List<IFigure> children = getChildren();
		if (children.isEmpty())
			return;

		int spacing = getLayoutManager().getSpacing()/2;
		for (int i=0; i<children.size()-1; i++) {
			Rectangle boundsBefore = children.get(i).getBounds();
			Rectangle boundsAfter = children.get(i+1).getBounds();
			int x0 = Math.min(boundsBefore.x, boundsAfter.x);
			int x1 = boundsBefore.right() > boundsAfter.right() || boundsBefore.right() < boundsAfter.x ?
					boundsBefore.right() : boundsAfter.right();
			int y = boundsBefore.bottom() + spacing;
			g.drawLine(x0, y, x1, y);
		}
	}
	@SuppressWarnings("unchecked")
	public void drawVariableSizeColumnSeparators(Graphics g) {
		List<IFigure> children = getChildren();
		if (children.isEmpty())
			return;

		int spacing = getLayoutManager().getSpacing()/2;
		for (int i=0; i<children.size()-1; i++) {
			Rectangle boundsBefore = children.get(i).getBounds();
			Rectangle boundsAfter = children.get(i+1).getBounds();
			int y0 = Math.min(boundsBefore.y, boundsAfter.y);
			int y1 = boundsBefore.bottom() > boundsAfter.bottom() || boundsBefore.bottom() < boundsAfter.y ?
					boundsBefore.bottom() : boundsAfter.bottom();
			int x = boundsBefore.right() + spacing;
			g.drawLine(x, y0, x, y1);
		}
	}

	public void drawChildrenBorder(Graphics g) {
		if (isHorizontal())
			drawColumnsBorder(g);
		else
			drawRowsBorder(g);
	}
	public void drawRowsBorder(Graphics g) {
		int lw = g.getLineWidth()/2;
		int y = bounds.y+lw;
		int x0 = bounds.x;
		int x1 = bounds.right();
		g.drawLine(x0, y, x1, y);
		y = bounds.bottom()-lw;
		g.drawLine(x0, y, x1, y);
	}
	public void drawColumnsBorder(Graphics g) {
		int lw = g.getLineWidth()/2;
		int x = bounds.x+lw;
		int y0 = bounds.y;
		int y1 = bounds.bottom();
		g.drawLine(x, y0, x, y0);
		x = bounds.right()-lw;
		g.drawLine(x, y0, x, y1);
	}
}
