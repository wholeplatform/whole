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

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Rectangle;
import org.whole.lang.ui.layout.ICompositeEntityLayout;
import org.whole.lang.ui.layout.TableLayout;

/**
 * @author Riccardo Solmi
 */
public class TableFigure extends ContentPaneFigure {
	protected TableFigure() {
	}
	public TableFigure(int columns) {
		this(new TableLayout(columns).withRowSpacing(4).withColumnSpacing(8).withMargin(5));
	}
	public TableFigure(ICompositeEntityLayout layout) {
		super(layout);
	}

	@Override
	public TableLayout getLayoutManager() {
		return (TableLayout) super.getLayoutManager();
	}

	public Rectangle getTableBounds() {
		return getClientArea().shrink(getBorderLineWidth()/2, getBorderLineWidth()/2);
	}

	protected int getBorderLineWidth() {
		return 0;
	}
	protected int getBackgroundAlpha() {
		return 40;
	}

	protected void drawColumnSeparators(Graphics g) {
		TableLayout l = getLayoutManager();
		if (l.rows() > 0) {
			Rectangle ca = getTableBounds();
			for (int c=1; c<l.columns(); c++) {
				Rectangle r = l.getColumnBounds(c);
				g.drawLine(r.x, ca.y, r.x, ca.bottom()-1);
			}
		}
	}
	protected void drawColumnSeparatorBefore(Graphics g, int columnIndex) {
		TableLayout l = getLayoutManager();
		if (l.rows() > 0 && columnIndex < l.columns()) {
			Rectangle ca = getTableBounds();
			Rectangle r = l.getColumnBounds(columnIndex);
			g.drawLine(r.x, ca.y, r.x, ca.bottom()-1);
		}
	}
	protected void drawHeadersRowSeparator(Graphics g) {
		TableLayout l = getLayoutManager();
		Rectangle ca = getTableBounds();
		if (l.hasHeaderRow() && l.rows() > 1) {

			Rectangle r = l.getRowBounds(1);
			g.drawLine(ca.x, r.y, ca.right()-1, r.y);			
		} else if (l.rows() > 0)
			g.drawLine(ca.x, ca.y, ca.right()-1, ca.y);
	}
	protected void drawRowSeparators(Graphics g) {
		TableLayout l = getLayoutManager();
		int columns = l.columns();
		if (columns > 0) {
			Rectangle ca = getTableBounds();
			int firstRow = l.hasHeaderRow() ? 2 : 1;
			for (int i=firstRow; i<l.rows(); i++) {
				Rectangle r = l.getRowBounds(i);
				g.drawLine(ca.x, r.y, ca.right()-1, r.y);
			}
		}
	}
	protected void drawRowSeparatorBefore(Graphics g, int rowIndex) {
		TableLayout l = getLayoutManager();
		int columns = l.columns();
		if (rowIndex < columns) {
			Rectangle ca = getTableBounds();
			Rectangle r = l.getRowBounds(rowIndex + (l.hasHeaderRow() ? 1 : 0));
			g.drawLine(ca.x, r.y, ca.right()-1, r.y);
		}
	}

	protected void drawTableBorder(Graphics g) {
		drawTableColumnsBorder(g);
		drawTableRowsBorder(g);
	}
	protected void drawTableColumnsBorder(Graphics g) {
		Rectangle r = getTableBounds();
		g.drawLine(r.x, r.y, r.x, r.bottom()-1);
		g.drawLine(r.right()-1, r.y, r.right()-1, r.bottom()-1);
	}
	protected void drawTableRowsBorder(Graphics g) {
		Rectangle r = getTableBounds();
		g.drawLine(r.x, r.y, r.right()-1, r.y);
		g.drawLine(r.x, r.bottom()-1, r.right()-1, r.bottom()-1);
	}
	protected void drawTableBottomBorder(Graphics g) {
		Rectangle r = getTableBounds();
		g.drawLine(r.x, r.bottom()-1, r.right()-1, r.bottom()-1);
	}

	protected void drawColumnBackground(Graphics g, int index) {
		drawColumnBackground(g, index, getBackgroundAlpha());
	}
	protected void drawColumnBackground(Graphics g, int index, int alpha) {
		TableLayout l = getLayoutManager();
		if (l.rows()>0) {
			int oldAlpha = g.getAlpha();
			g.setAlpha(alpha);
			Rectangle tb = getTableBounds();
			Rectangle cb = l.getColumnBounds(index);
			g.fillRectangle(cb.x, tb.y, cb.width, tb.height);
			g.setAlpha(oldAlpha);
		}
	}
	protected void drawAlternateColumnsBackground(Graphics g, int startIndex) {
		drawAlternateColumnsBackground(g, startIndex, getBackgroundAlpha());
	}
	protected void drawAlternateColumnsBackground(Graphics g, int startIndex, int alpha) {
		TableLayout l = getLayoutManager();
		if (l.rows()>0) {
			int oldAlpha = g.getAlpha();
			g.setAlpha(alpha);
			Rectangle tb = getTableBounds();
			for (int r=startIndex; r<l.columns(); r+=2) {
				Rectangle cb = l.getColumnBounds(r);
				g.fillRectangle(cb.x, tb.y, cb.width, tb.height);
			}
			g.setAlpha(oldAlpha);
		}
	}
	protected void drawHeadersRowBackground(Graphics g) {
		drawHeadersRowBackground(g, getBackgroundAlpha());
	}
	protected void drawHeadersRowBackground(Graphics g, int alpha) {
		TableLayout l = getLayoutManager();
		if (l.hasHeaderRow() && l.rows() > 0)
			drawAlternateRowsBackground(g, -1, alpha);
	}
	protected void drawAlternateRowsBackground(Graphics g, int startIndex) {
		drawAlternateRowsBackground(g, startIndex, getBackgroundAlpha());
	}
	protected void drawAlternateRowsBackground(Graphics g, int startIndex, int alpha) {
		TableLayout l = getLayoutManager();
		int rows = startIndex == -1 ? 1 : l.rows();
		
		int oldAlpha = g.getAlpha();
		g.setAlpha(alpha);
		if (l.hasHeaderRow())
			startIndex++;
		Rectangle tb = getTableBounds();
		for (int r=startIndex; r<rows; r+=2)
			if (l.isRowVisible(r)) {
				Rectangle rb = l.getRowBounds(r);
				int fh = rb.height+1;
				int fy;
				if (r == 0) {
					fh += rb.y - tb.y;
					fy = tb.y;
				} else if (r == rows-1) {
					fy = rb.y;
					fh = tb.bottom() - fy;
				} else
					fy = rb.y;
				g.fillRectangle(tb.x, fy, tb.width, fh);
			} else
				r-=1;
		g.setAlpha(oldAlpha);
	}
}
