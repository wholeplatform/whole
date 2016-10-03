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
package org.whole.lang.ui.layout;

import java.util.Arrays;

import org.eclipse.draw2d.geometry.Rectangle;
import org.whole.lang.util.CompositeUtils;

/**
 * @author Riccardo Solmi
 */
public class GridLayout extends AbstractCompositeEntityLayout {
	int figIndent;

	{
		withMajorAlignment(Alignment.MATHLINE);
		withMinorAlignment(Alignment.LEADING);
	}

	private int maxRows = -1;
	private int maxColumns = -1;
	private int[] cellX;
	private int[] cellY;
	private int[] columnIndent;
	private int[] columnRightIndent;
	private int[] rowAscent;
	private int[] rowDescent;
	private Alignment[] rowAlignment = new Alignment[0];
	private Alignment[] columnAlignment = new Alignment[0];
	private int[] rowSpacing = new int[0];
	private int[] columnSpacing = new int[0];
	private int defaultColumnSpacing;

	public GridLayout withMaxRows(int maxRows) {
		this.maxRows = maxRows;
		return this;
	}
	public GridLayout withMaxColumns(int maxColumns) {
		this.maxColumns = maxColumns;
		return this;
	}

	public GridLayout withRowAlignment(int rowIndex, Alignment alignment) {
		rowAlignment = CompositeUtils.grow(rowAlignment, rowIndex+1, null);
		rowAlignment[rowIndex] = alignment;
		return this;
	}
	public GridLayout withRowAlignment(Alignment defaultAlignment) {
		withMajorAlignment(defaultAlignment);
		return this;
	}
	public Alignment getRowAlignment(int rowIndex) {
		return rowIndex < rowAlignment.length && rowAlignment[rowIndex] != null ?
				rowAlignment[rowIndex] : getRowAlignment();
	}
	public Alignment getRowAlignment() {
		return getMajorAlignment();
	}

	public GridLayout withColumnAlignment(int columnIndex, Alignment alignment) {
		columnAlignment = CompositeUtils.grow(columnAlignment, columnIndex+1, null);
		columnAlignment[columnIndex] = alignment;
		return this;
	}
	public GridLayout withColumnAlignment(Alignment defaultAlignment) {
		withMinorAlignment(defaultAlignment);
		return this;
	}
	public Alignment getColumnAlignment(int columnIndex) {
		return columnIndex < columnAlignment.length && columnAlignment[columnIndex] != null ?
				columnAlignment[columnIndex] : getColumnAlignment();
	}
	public Alignment getColumnAlignment() {
		return getMinorAlignment();
	}

	public GridLayout withRowSpacingAfter(int rowIndex, int spacing) {
		rowSpacing = CompositeUtils.grow(rowSpacing, rowIndex+1, -1);
		rowSpacing[rowIndex] = spacing;
		return this;
	}
	public GridLayout withRowSpacing(int spacing) {
		withSpacing(spacing);
		return this;
	}
	public int getRowSpacingAfter(int rowIndex) {
		return rowIndex < rowSpacing.length && rowSpacing[rowIndex] != -1 ?
				rowSpacing[rowIndex] : getRowSpacing();
	}
	public int getRowSpacing() {
		return getSpacing();
	}

	public GridLayout withColumnSpacingAfter(int columnIndex, int spacing) {
		columnSpacing = CompositeUtils.grow(columnSpacing, columnIndex+1, -1);
		columnSpacing[columnIndex] = spacing;
		return this;
	}
	public GridLayout withColumnSpacing(int spacing) {
		this.defaultColumnSpacing = spacing;
		return this;
	}
	public int getColumnSpacingAfter(int columnIndex) {
		return columnIndex < columnSpacing.length && columnSpacing[columnIndex] != -1 ?
				columnSpacing[columnIndex] : getColumnSpacing();
	}
	public int getColumnSpacing() {
		return defaultColumnSpacing;
	}

	public int rows() {
		return rowAscent != null ? rowAscent.length : 0;
	}
	public int columns() {
		return columnIndent != null ? columnIndent.length : 0;
	}

	public Rectangle cellBounds(int c, int r) {
		Rectangle rectangle = Rectangle.SINGLETON;
		rectangle.setLocation(cellX[c], cellY[r]);
		rectangle.setSize(
				columnIndent[c]+columnRightIndent[c],
				rowAscent[r]+rowDescent[r]);
		return rectangle;
	}
	public Rectangle columnBounds(int c) {
		Rectangle rectangle = Rectangle.SINGLETON;
		rectangle.setLocation(cellX[c], cellY[0]);
		rectangle.setSize(
				columnIndent[c]+columnRightIndent[c],
				figAscent+figDescent);
		return rectangle;
	}
	public Rectangle rowBounds(int r) {
		Rectangle rectangle = Rectangle.SINGLETON;
		rectangle.setLocation(cellX[0], cellY[r]);
		rectangle.setSize(
				figWidth,//TODO figIndent + figRightIndent
				rowAscent[r]+rowDescent[r]);
		return rectangle;
	}

	protected void initData(int childrenSize) {
		int rows = 0;
		int columns = 0;

		//FIXME visibility of rows and columns
		if (childrenSize > 0) {
			if (maxRows > 0) {
				rows = Math.min(maxRows, childrenSize);
				columns = childrenSize / rows + (childrenSize % rows == 0 ? 0 : 1);
			} else if (maxColumns > 0) {
				columns = Math.min(maxColumns, childrenSize);
				rows = childrenSize / columns + (childrenSize % columns == 0 ? 0 : 1);
			} else {
				rows = (int) Math.sqrt(childrenSize);
				columns = childrenSize / rows + (childrenSize % rows == 0 ? 0 : 1);
			}
		}

		cellX = new int[columns];
		cellY = new int[rows];
		columnIndent = new int[columns];
		columnRightIndent = new int[columns];
		rowAscent = new int[rows];
		rowDescent = new int[rows];
	}

	public boolean isHorizontal() {
		return false;
	}

	@Override
	protected int getIndent() {
		return figIndent;
	}

	@Override
	protected boolean calculateChildrenSize(int wHint, int hHint, boolean preferred) {
		int figHeight = 0;

		boolean hintsSensitive = false;
		int size = childFigure.length;
		
		initData(size);
		
		childSize = new BaselinedDimension[size];
		for (int i=0,c=0,r=0; i<size; i++)
			if (childFigure[i].isVisible()) {
				c = i / rows();
				r = i % rows();

				childSize[i] = getChildSize(childFigure[i], wHint,
						hHint < 0 ? hHint : Math.max(0, hHint-figHeight), preferred);

				hintsSensitive |= childSize[i].hintsSensitive;
				int ci = childSize[i].getIndent();
				//FIXME f(alignment)
				columnIndent[c] = Math.max(columnIndent[c], ci);
				columnRightIndent[c] = Math.max(columnRightIndent[c], childSize[i].width-ci);
				rowAscent[r] = Math.max(rowAscent[r], childSize[i].getAscent());
				rowDescent[r] = Math.max(rowDescent[r], childSize[i].getDescent());
			}

		figWidth =
				Arrays.stream(columnIndent).sum() +
				Arrays.stream(columnRightIndent).sum() +
				getColumnSpacing()*(columns()-1);//FIXME
		figHeight =
				Arrays.stream(rowAscent).sum() +
				Arrays.stream(rowDescent).sum() + 
				getRowSpacing()*(rows()-1);//FIXME

		//TODO add withAscentAlignment, withAscentTarget and withIndentAlignment
		figAscent = figHeight / 2;
		figDescent = figHeight - figAscent;
		figIndent = figWidth / 2;

//FIXME hints
//		if (hHint >= 0 && figHeight > hHint)
//			calculateChildrenSize(wHint, figHeight, preferred);		

		return hintsSensitive;
	}
	@Override
	protected void setAscentDescentWidth(int wHint, int hHint) {}

	protected void setLocation(Rectangle area, int[] x, int[] y) {
		int children = childSize.length;

		for (int i=0,c=0,r=0; i<children; i++)
			if (isChildVisible(i)) {
				c = i / rows();
				r = i % rows();

				int columnIndentSum=0;
				int columnRightIndentSum=0;
				int columnSpacingSum=0;
				int rowAscentSum=0;
				int rowDescentSum=0;
				int rowSpacingSum=0;

				//FIXME visibility row/column
				for (int j=0; j<c; j++) {
					columnIndentSum += columnIndent[j];
					columnRightIndentSum += columnRightIndent[j];
					columnSpacingSum += getColumnSpacingAfter(j);
				}
				for (int j=0; j<r; j++) {
					rowAscentSum += rowAscent[j];
					rowDescentSum += rowDescent[j];
					rowSpacingSum += getRowSpacingAfter(j);
				}

				cellX[c] = area.x + columnIndentSum + columnRightIndentSum + columnSpacingSum;
//						Arrays.stream(columnIndent).limit(c).sum() +
//						Arrays.stream(columnRightIndent).limit(c).sum() +
//						getSpacing()*c;
				cellY[r] = area.y + rowAscentSum + rowDescentSum + rowSpacingSum;
//						Arrays.stream(rowAscent).limit(r).sum() +
//						Arrays.stream(rowDescent).limit(r).sum() +
//						getSpacing()*r;

				switch (getColumnAlignment(c)) {
				case FILL:
					childSize[i].width = columnIndent[c]+columnRightIndent[c];
				case LEADING:
					x[i] = cellX[c];
					break;
				case MATHLINE:
					x[i] = cellX[c] + columnIndent[c]-indent(i);
					break;
				case CENTER:
					x[i] = cellX[c] + (columnIndent[c]+columnRightIndent[c] - childSize[i].width)/2;
					break;
				case TRAILING:
					x[i] = cellX[c] + columnIndent[c]+columnRightIndent[c] - childSize[i].width;
					break;
				}

				switch (getRowAlignment(r)) {
				case FILL:
					childSize[i].height = rowAscent[r]+rowDescent[r];
				case LEADING:
					y[i] = cellY[r];
					break;
				case MATHLINE:
					y[i] = cellY[r] + rowAscent[r]-ascent(i);
					break;
				case CENTER:
					y[i] = cellY[r] + (rowAscent[r]+rowDescent[r] - childSize[i].height)/2;
					break;
				case TRAILING:
					y[i] = cellY[r] + rowAscent[r]+rowDescent[r] -ascent(i)-descent(i);
					break;
				}
			}
	}
}
