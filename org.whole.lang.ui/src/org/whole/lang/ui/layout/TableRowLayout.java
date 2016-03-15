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

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Rectangle;
import org.whole.lang.ui.figures.IEntityFigure;

/**
 * @author Riccardo Solmi
 */
public class TableRowLayout extends AbstractCompositeEntityLayout implements ITabularLayoutServer, ITabularLayoutClient {
	{
		withMinorAlignment(Alignment.MATHLINE);
	}

	private boolean rowInlining;
	public TableRowLayout withRowInlining(boolean value) {
		rowInlining = value;
		return this;
	}

	@Override
	public ITabularLayoutClient getTabularLayoutClient() {
		return this;
	}

	@Override
	public ITabularLayoutServer getTabularLayoutServer() {
		return rowInlining ? this : null;
	}

	private ITabularLayoutServer myTabularLayoutServer;
	public ITabularLayoutServer getMyTabularLayoutServer() {
		if (myTabularLayoutServer == null) {
			myTabularLayoutServer = new ITabularLayoutServer() {
				public void invalidateTable() {
				}

				public int getColumnWidth(int columnIndex) {
					return getPreferredColumnWith(columnIndex-getStartingCellIndex());
				}
				public int getColumnSpacingBefore(int columnIndex) {
					return getPreferredColumnSpacingBefore(columnIndex-getStartingCellIndex());
				}
				public Alignment getColumnAlignment(int columnIndex) {
					return Alignment.LEADING;
				}
			};
		}
		return myTabularLayoutServer;
	}
	public void updateMyTabularLayoutServer(IFigure container) {
		IFigure parent = container.getParent();
		ITabularLayoutServer tls = (parent instanceof IEntityFigure) ? ((IEntityFigure) parent).getTabularLayoutServer() : null;
		if (tls != null)
			myTabularLayoutServer = tls;
	}

	private int startingCellIndex;
	public int getStartingCellIndex() {
		return startingCellIndex;
	}
	public void setStartingCellIndex(int cellIndex) {
		startingCellIndex = cellIndex;
	}

	public int getCells() {
		return childFigure != null ? childFigure.length : 0;
	}

	public boolean isHorizontal() {
		return true;
	}

	public void invalidateTable() {
		invalidate();
		getMyTabularLayoutServer().invalidateTable();
	}
	public int getColumnWidth(int columnIndex) {
		return Math.max(getPreferredColumnWith(columnIndex), getMyTabularLayoutServer().getColumnWidth(getStartingCellIndex()+columnIndex));
	}
	public int getColumnSpacingBefore(int columnIndex) {
		return Math.max(getPreferredColumnSpacingBefore(columnIndex), getMyTabularLayoutServer().getColumnSpacingBefore(getStartingCellIndex()+columnIndex));
	}
	public Alignment getColumnAlignment(int columnIndex) {
		return getMyTabularLayoutServer().getColumnAlignment(getStartingCellIndex()+columnIndex);
	}

	protected int getPreferredColumnWith(int columnIndex) {
		if (childSize == null || columnIndex >= childSize.length || childSize[columnIndex] == null)
			return 0;
		return childSize[columnIndex].width;
	}
	protected int getPreferredColumnSpacingBefore(int columnIndex) {
		return super.getSpacingBefore(columnIndex);
	}

	@Override
	public int getSpacingBefore(int childIndex) {
		return getColumnSpacingBefore(childIndex);
	}

	protected BaselinedDimension calculateSize(IFigure container, int wHint, int hHint, boolean preferred) {
		updateMyTabularLayoutServer(container);
		return super.calculateSize(container, wHint, hHint, preferred);
	}

	protected void setAscentDescentWidth(int wHint, int hHint) {
		figAscent = 0;
		figDescent = 0;
		figWidth = 0;
		boolean isFirst = true;
		for (int i=0; i<childSize.length; i++)
			if (isChildVisible(i)) {
				figAscent = Math.max(figAscent, ascent(i));
				figDescent = Math.max(figDescent, descent(i));
				figWidth += (isFirst ? 0 : getColumnSpacingBefore(i)) + getColumnWidth(i);
				isFirst = false;
			}

		int figHeight = figAscent+figDescent;
		switch (getMinorAlignment()) {
		case FILL:
		case LEADING:
			figAscent = 0;
			figDescent = figHeight;
			break;
		case CENTER:
			figAscent = figHeight/2;
			figDescent = figHeight - figAscent;
			break;
		case TRAILING:
			figAscent = figHeight;
			figDescent = 0;
			break;
		case MATHLINE:
		}
	}

	protected void setLocation(Rectangle area, int[] x, int[] y) {
		int children = childSize.length;

		int xi = calculateXLocation(area, getMajorAlignment());
		for (int i=0; i<children; i++)
			if (isChildVisible(i)) {
				int columnWidth = getColumnWidth(i);
				int widthStretching = (int) ((columnWidth - childSize[i].width) * getMajorAutoresizeWeight(i));
				int heightStretching = (int) ((figAscent+figDescent - childSize[i].height) * getMinorAutoresizeWeight(i));

				switch (getColumnAlignment(i)) {
				case FILL:
				case LEADING:
					x[i] = xi;
					break;
				case TRAILING:
					x[i] = xi + columnWidth - getPreferredColumnWith(i) - widthStretching;
					break;
				case CENTER:
					x[i] = xi + (columnWidth - getPreferredColumnWith(i) - widthStretching)/2;
					break;
				case MATHLINE:
				}
				if (widthStretching > 0) {
					childFigure[i].getLayoutManager().getViewportTrackingStrategy().setIndent(
							getColumnAlignment(i).equals(Alignment.MATHLINE) ? x[i] - xi : 0);
					x[i] = xi;
				} else if (childFigure[i].getLayoutManager() != null)
					childFigure[i].getLayoutManager().getViewportTrackingStrategy().setIndent(0);

				switch (getMinorAlignment()) {
				case FILL:
				case LEADING:
					y[i] = area.y;
					break;
				case CENTER:
					y[i] = area.y + figAscent-childSize[i].height/2-heightStretching/2;
					break;
				case MATHLINE:
					y[i] = area.y + figAscent-ascent(i);//-heightStretching/2;//TODO ??
					break;
				case TRAILING:
					y[i] = area.y + figAscent-ascent(i)-descent(i)-heightStretching;
					break;
				}
				if (heightStretching > 0) {
					childFigure[i].getLayoutManager().getViewportTrackingStrategy().setAscent(
							getMinorAlignment().equals(Alignment.MATHLINE) ? y[i] - area.y : 0);
					y[i] = area.y;
				} else if (childFigure[i].getLayoutManager() != null)
					childFigure[i].getLayoutManager().getViewportTrackingStrategy().setAscent(0);

				childSize[i].width += widthStretching;
				childSize[i].height += heightStretching;

				xi += columnWidth + getColumnSpacingBefore(i+1);
			}
	}

	public void invalidate() {
		super.invalidate();
//		getMyTabularLayoutServer().invalidateTable();

		if (childFigure != null)
			for (IEntityFigure cf : childFigure) 
				if (cf != null && cf.isShowing()) {
					IEntityLayout el = cf.getLayoutManager();
					if (el != null && (el.getMajorAutoresizeWeight() != 0.0f || el.getMinorAutoresizeWeight() != 0.0f))
						cf.invalidate();
				}
	}
}
