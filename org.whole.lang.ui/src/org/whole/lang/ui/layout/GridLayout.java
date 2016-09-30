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

/**
 * @author Riccardo Solmi
 */
public class GridLayout extends AbstractCompositeEntityLayout {
	int figIndent;

	{
		withMinorAlignment(Alignment.LEADING);
	}

	private int maxRows;
	private int maxColumns;
	private int[] columnWidth;
	private int[] rowHeight;
	private Alignment[] rowAlignment;
	private Alignment[] columnAlignment;
	private Alignment defaultRowAlignment = Alignment.LEADING;
	private Alignment defaultColumnAlignment = Alignment.LEADING;

	public GridLayout() {
		this(-1, -1);
	}
	public GridLayout(int maxRows) {
		this(maxRows, -1);
	}
	public GridLayout(int maxRows, int maxColumns) {
		this.maxRows = maxRows;
		this.maxColumns = maxColumns;
	}

	protected void initData(int childrenSize) {
		int rows;
		int columns;

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

		columnWidth = new int[columns];
		columnAlignment = new Alignment[columns];
		rowHeight = new int[rows];
		rowAlignment = new Alignment[rows];
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
		boolean isFirst = true;
		int size = childFigure.length;
		
		initData(size);
		
		childSize = new BaselinedDimension[size];
		for (int i=0,c=0,r=0; i<size; i++)
			if (childFigure[i].isVisible()) {
				c = i / rowHeight.length;
				r = i % rowHeight.length;

				childSize[i] = getChildSize(childFigure[i], wHint,
						hHint < 0 ? hHint : Math.max(0, hHint-figHeight), preferred);

				hintsSensitive |= childSize[i].hintsSensitive;
				//FIXME mathline alignment
				columnWidth[c] = Math.max(columnWidth[c], childSize[i].width);
				rowHeight[r] = Math.max(rowHeight[r], childSize[i].height);
			}

		//FIXME add spacing and mathline alignment
		figWidth = Arrays.stream(columnWidth).sum();
		figHeight = Arrays.stream(rowHeight).sum();
		figAscent = getAscent(figHeight);
		figDescent = figHeight - figAscent;
		figIndent = figWidth / 2;

//FIXME hints
//		if (hHint >= 0 && figHeight > hHint)
//			calculateChildrenSize(wHint, figHeight, preferred);		

		return hintsSensitive;
	}
	@Override
	protected void setAscentDescentWidth(int wHint, int hHint) {}

	protected int getAscent(int height) {
		return height/2;
	}

	protected void setLocation(Rectangle area, int[] x, int[] y) {
		int children = childSize.length;

		for (int i=0,c=0,r=0; i<children; i++)
			if (isChildVisible(i)) {
				c = i / rowHeight.length;
				r = i % rowHeight.length;

				//FIXME add spacing and alignment
				x[i] = area.x + Arrays.stream(columnWidth).limit(c).sum();
				y[i] = area.y + Arrays.stream(rowHeight).limit(r).sum();
			}
	}
}
