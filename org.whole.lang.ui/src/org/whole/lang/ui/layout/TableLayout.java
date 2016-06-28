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

import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.whole.lang.ui.figures.IEntityFigure;
import org.whole.lang.util.CompositeUtils;

/**
 * @author Riccardo Solmi
 */
public class TableLayout extends AbstractCompositeEntityLayout implements ITabularLayoutServer, ITabularLayoutClient {
	public static enum Placement {HEADER}

	{
		withMinorAlignment(Alignment.LEADING);
	}

	private IEntityFigure headerRowFigure;
	private int columnSpacing;
	private int columns;
	private int[] columnWidth;
	private int[] columnSpacingBefore;
	private Alignment[] columnAlignment;
	private Alignment defaultColumnAlignment = Alignment.LEADING;
	
	public TableLayout() {
		this(2);
	}
	public TableLayout(int initialColumns) {
		columnAlignment = new Alignment[initialColumns];
	}

	@Override
	public void remove(IFigure child) {
		if (headerRowFigure == child)
			headerRowFigure = null;
		super.remove(child);
	}

	@Override
	public void setConstraint(IFigure child, Object constraint) {
		remove(child);
		super.setConstraint(child, constraint);
		if (constraint == null)
			return;
		
		switch ((Placement) constraint) {
		case HEADER:
			headerRowFigure = (IEntityFigure) child;
			break;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	protected IEntityFigure[] getChildren(IFigure container) {
		if (headerRowFigure == null)
			return super.getChildren(container);
		else {
			List<IEntityFigure> children = container.getChildren();
			int size = children.size();
			if (size == 1)
				return new IEntityFigure[0];

			IEntityFigure[] figures = new IEntityFigure[size];
			figures[0] = headerRowFigure;

			for (int i=0,j=1; i<size; i++)
				if (headerRowFigure != children.get(i))
					figures[j++] = children.get(i);

			return figures;
		}
	}

	public boolean hasHeaderRow() {
		return headerRowFigure != null;
	}

	@Override
	public int getMarginTop() {
		return marginTop;
	}
	@Override
	public int getMarginLeft() {
		return marginLeft;
	}
	@Override
	public int getMarginBottom() {
		return !isHorizontal() && (getSpacedChild() == childFigure.length-(hasHeaderRow() ? 2 : 1) || getSpacedChild() == SPACED_ALL) ?
				getSpacedSpacing(marginBottom) : marginBottom;
	}
	@Override
	public int getMarginRight() {
		return marginRight;
	}

	private int startingCellIndex;
	public int getStartingCellIndex() {
		return startingCellIndex;
	}
	public void setStartingCellIndex(int cellIndex) {
		startingCellIndex = cellIndex;
	}
	public int getCells() {
		return columns();
	}
	public void invalidateCells() {
		invalidate();
	}
	public Dimension getPreferredCellSize(int cellIndex, int wHint, int hHint) {
		Rectangle r = getCellBounds(cellIndex);
		int columnIndex = cellIndex - getStartingCellIndex();
		return columnIndex < getCells() && childFigure[columnIndex].isVisible() ? new Dimension(r.width, r.height): IEntityFigure.PLACE_HOLDER_DIMENSION;
	}
	public Rectangle getCellBounds(int cellIndex) {
		int columnIndex = cellIndex - getStartingCellIndex();
		return columnIndex < getCells() && childFigure[columnIndex].isVisible() ? getColumnBounds(columnIndex) : IEntityFigure.PLACE_HOLDER_BOUNDS;
	}
	public int getCellSpacingBefore(int cellIndex) {
		int columnIndex = cellIndex - getStartingCellIndex();
		return getColumnSpacingBefore(columnIndex);
	}
	public int getPreferredCellSpacingBefore(int cellIndex) {
		int columnIndex = cellIndex - getStartingCellIndex();
		return getPreferredColumnSpacingBefore(columnIndex);
	}

	public TableLayout withColumnAlignment(int columnIndex, Alignment alignment) {
		columnAlignment = CompositeUtils.grow(columnAlignment, columnIndex+1, null);
		columnAlignment[columnIndex] = alignment;
		return this;
	}
	public TableLayout withColumnAlignment(Alignment defaultAlignment) {
		defaultColumnAlignment = defaultAlignment;
		return this;
	}

	public boolean isHorizontal() {
		return false;
	}

	public int getRowSpacingBefore(int rowIndex) {
		int childIndex = hasHeaderRow() ? rowIndex-1 : rowIndex;
		return getSpacingBefore(childIndex);
	}
	public TableLayout withRowSpacing(int spacing) {
		withSpacing(spacing);
		return this;
	}

	public TableLayout withColumnSpacing(int spacing) {
		this.columnSpacing = spacing;
		return this;
	}

	public void updateColumns() {
		int columns = 0;
		for (int rowIndex=0; rowIndex<rows(); rowIndex++)
			columns = Math.max(columns, getRowColumns(rowIndex));
		this.columns = columns;
	}
	public int columns() {
		return columns;
	}
	public int rows() {
		return childFigure.length;
	}

	public boolean isRowVisible(int rowIndex) {
		return getRow(rowIndex).isVisible();
	}
	public int firstRowVisible() {
		for (int i=0, size=rows(); i<size; i++)
			if (isRowVisible(i))
				return i;
		return 0;
	}
	public int lastRowVisible() {
		for (int i=rows()-1; i>=0; i--)
			if (isRowVisible(i))
				return i;
		return rows()-1;
	}

	private boolean tableInlining;
	public TableLayout withTableInlining(boolean value) {
		tableInlining = value;
		return this;
	}

	@Override
	public ITabularLayoutClient getTabularLayoutClient() {
		return tableInlining ? this : ITabularLayoutClient.NULL_TABULAR_LAYOUT_CLIENT;
	}

	@Override
	public ITabularLayoutServer getTabularLayoutServer() {
		return this;
	}

	private ITabularLayoutServer myTabularLayoutServer;
	public ITabularLayoutServer getMyTabularLayoutServer() {
		if (myTabularLayoutServer == null) {
			myTabularLayoutServer = new ITabularLayoutServer() {
				public void invalidateTable() {
				}

				public int getColumnWidth(int columnIndex) {
					return getPreferredColumnWidth(columnIndex - getStartingCellIndex());
				}
				public int getColumnSpacingBefore(int columnIndex) {
					return getPreferredColumnSpacingBefore(columnIndex - getStartingCellIndex());
				}
				public Alignment getColumnAlignment(int columnIndex) {
					int childIndex = columnIndex - getStartingCellIndex();
					return childIndex < columnAlignment.length && columnAlignment[childIndex] != null ? columnAlignment[childIndex] : defaultColumnAlignment;
				}
			};
		}
		return myTabularLayoutServer;
	}
	public void updateMyTabularLayoutServer(IFigure container) {
		if (tableInlining) {
			IFigure parent = container.getParent();
			ITabularLayoutServer tls = (parent instanceof IEntityFigure) ? ((IEntityFigure) parent).getTabularLayoutServer() : null;
			if (tls != null)
				myTabularLayoutServer = tls;
		}
	}

	public void invalidateTable() {
		invalidate();
		getMyTabularLayoutServer().invalidateTable();
	}
	public int getColumnWidth(int columnIndex) {
		return Math.max(getMyTabularLayoutServer().getColumnWidth(getStartingCellIndex()+columnIndex), getPreferredColumnWidth(columnIndex));
	}
	public int getColumnSpacingBefore(int columnIndex) {
		return Math.max(getMyTabularLayoutServer().getColumnSpacingBefore(getStartingCellIndex()+columnIndex), getPreferredColumnSpacingBefore(columnIndex));
	}
	public Alignment getColumnAlignment(int columnIndex) {
		return getMyTabularLayoutServer().getColumnAlignment(getStartingCellIndex()+columnIndex);
	}

	public int getPreferredColumnWidth(int columnIndex) {
		return columnWidth == null || columnIndex >= columnWidth.length ? 0 : columnWidth[columnIndex];
	}
	public int getPreferredColumnSpacingBefore(int columnIndex) {
		int sp = columnSpacingBefore != null && columnIndex < columnSpacingBefore.length ? columnSpacingBefore[columnIndex] : 0;
		return sp != 0 ? sp : columnSpacing;
	}

	public IEntityFigure getRow(int rowIndex) {
		return (IEntityFigure) childFigure[rowIndex];
	}
	public int getRowColumns(int rowIndex) {
		return Math.max(getRow(rowIndex).getTabularLayoutClient().getCells(), 1);
	}


	public Rectangle getCellBounds(int columnIndex, int rowIndex) {
		Rectangle bounds = getRow(rowIndex).getTabularLayoutClient().getCellBounds(columnIndex);
		return bounds == IEntityFigure.PLACE_HOLDER_BOUNDS ? bounds : bounds.getTranslated(-getColumnSpacingBefore(columnIndex)/2, -getRowSpacingBefore(rowIndex)/2).resize((getColumnSpacingBefore(columnIndex)+getColumnSpacingBefore(columnIndex+1))/2, (getRowSpacingBefore(rowIndex)+getRowSpacingBefore(rowIndex+1))/2);
	}
	public Rectangle getColumnBounds(int columnIndex) {
		Rectangle columnBounds = new Rectangle();
		columnBounds.x = Integer.MAX_VALUE;
		columnBounds.y = getRowBounds(firstRowVisible()).y;
		columnBounds.height = getRowBounds(lastRowVisible()).bottom()-columnBounds.y;
		for (int rowIndex=0; rowIndex<rows(); rowIndex++)
			if (isRowVisible(rowIndex)) {
				Rectangle cellBounds = getCellBounds(columnIndex, rowIndex);
				if (cellBounds.width > 0) {
					columnBounds.x = Math.min(columnBounds.x, cellBounds.x); 
					columnBounds.width = Math.max(columnBounds.width, cellBounds.width);
				}
			}
		return columnBounds;
	}
	public Rectangle getRowBounds(int rowIndex) {
		if (columns() == 1) {
			Rectangle r = getRow(rowIndex).getBounds().getCopy();
			for (int i=0; i<rows(); i++) {
				Rectangle cellBounds = getCellBounds(0, i);
				r.width = Math.max(r.width, cellBounds.width);
			}
			return r.translate(-getColumnSpacingBefore(1)/2, -getRowSpacingBefore(rowIndex)/2).resize(getColumnSpacingBefore(1), (getRowSpacingBefore(rowIndex)+getRowSpacingBefore(rowIndex+1))/2);
		} else
			return getRow(rowIndex).getBounds()
				.getTranslated(-getColumnSpacingBefore(1)/2, -getRowSpacingBefore(rowIndex)/2).resize(getColumnSpacingBefore(1), (getRowSpacingBefore(rowIndex)+getRowSpacingBefore(rowIndex+1))/2);
	}

	protected void setPrefSize(int wHint, int hHint) {
		updateColumns();

		boolean isInvalid = false;
		columnWidth = new int[columns()];
		columnSpacingBefore = new int[columns()+1];
		for (int rowIndex=0; rowIndex<rows(); rowIndex++) {
			IEntityFigure row = getRow(rowIndex);
			if (row.isVisible()) {
				ITabularLayoutClient tabularLayoutClient = row.getTabularLayoutClient();
				for (int columnIndex=0; columnIndex<columns(); columnIndex++) {
					int width = tabularLayoutClient.getPreferredCellSize(columnIndex, wHint, hHint).width;
					if (width > columnWidth[columnIndex]) {
						columnWidth[columnIndex] = width;
						if (rowIndex>0)
							isInvalid = true;
					}
					int sp = tabularLayoutClient.getPreferredCellSpacingBefore(columnIndex);
					if (sp > columnSpacingBefore[columnIndex]) {
						columnSpacingBefore[columnIndex] = sp;
						if (rowIndex>0)
							isInvalid = true;
					}
				}
				int sp = tabularLayoutClient.getPreferredCellSpacingBefore(columns());
				if (sp > columnSpacingBefore[columns()]) {
					columnSpacingBefore[columns()] = sp;
					isInvalid = true;
				}
			}
		}
		for (int rowIndex=0; rowIndex<rows(); rowIndex++) {
			IEntityFigure row = getRow(rowIndex);
			if (row.isVisible()) {
				ITabularLayoutClient tabularLayoutClient = row.getTabularLayoutClient();
				tabularLayoutClient.invalidateCells();
			}
		}
	}

	protected BaselinedDimension calculateSize(IFigure container, int wHint, int hHint, boolean preferred) {
		updateMyTabularLayoutServer(container);
		return super.calculateSize(container, wHint, hHint, preferred);
	}
	@Override
	protected boolean calculateChildrenSize(int wHint, int hHint, boolean preferred) {
		super.calculateChildrenSize(wHint, hHint, preferred);

		setPrefSize(wHint, hHint);
		
		return super.calculateChildrenSize(wHint, hHint, preferred);
	}

	protected void setAscentDescentWidth(int wHint, int hHint) {
		figWidth = 0;
		boolean isFirst = true;
		int figHeight = 0;
		for (int i=0; i<rows(); i++)
			if (isRowVisible(i)) {
				figWidth = Math.max(figWidth, childSize[i].width);
				figHeight += (isFirst ? 0 : getRowSpacingBefore(i)) + childSize[i].height;
				isFirst = false;
			}
		figAscent = getAscent(figHeight);
		figDescent = figHeight-figAscent;
	}
	protected int getAscent(int height) {
		return height/2;
	}

	protected void setLocation(Rectangle area, int[] x, int[] y) {
		int xi = calculateXLocation(area, getMinorAlignment());
		int yi = calculateYLocation(area, getMajorAlignment());
		for (int i=0; i<rows(); i++) {
			x[i] = xi + (getMinorAlignment() == Alignment.CENTER ? -childSize[i].width/2 : 0);
			y[i] = yi;
			if (isRowVisible(i))
				yi += childSize[i].height + getRowSpacingBefore(i+1);
		}
	}
}
