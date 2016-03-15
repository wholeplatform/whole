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
package org.whole.lang.types.ui.figures;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.whole.lang.ui.figures.ContentPaneFigure;
import org.whole.lang.ui.figures.IEntityFigure;
import org.whole.lang.ui.layout.Alignment;
import org.whole.lang.ui.layout.ITabularLayoutClient;
import org.whole.lang.ui.layout.ITabularLayoutServer;
import org.whole.lang.ui.layout.TableRowLayout;

/**
 * @author Riccardo Solmi
 */
public class CaseTableRowFigure extends ContentPaneFigure implements ITabularLayoutClient, ITabularLayoutServer {
	public CaseTableRowFigure() {
		super(new TableRowLayout());
		initContentPanes(2);

		add(createContentPane(0));
		add(createContentPane(1));
	}

	@Override
	public TableRowLayout getLayoutManager() {
		return (TableRowLayout) super.getLayoutManager();
	}

	public ITabularLayoutServer getMyTabularLayoutServer() {
		return getParent() instanceof IEntityFigure ? ((IEntityFigure) getParent()).getTabularLayoutServer() : null;
	}
	public ITabularLayoutServer getTabularLayoutServer() {
		return this;
	}
	public ITabularLayoutClient getTabularLayoutClient() {
		return this;
	}
	public int getStartingCellIndex() {
		return getLayoutManager().getStartingCellIndex();
	}
	public void setStartingCellIndex(int cellIndex) {
		getLayoutManager().setStartingCellIndex(cellIndex);
	}
	public int getCells() {
		 return 1 + ((IEntityFigure) getContentPane(1)).getTabularLayoutClient().getCells();
	}
	public void invalidateCells() {
		invalidateTree();
	}
	public Dimension getPreferredCellSize(int cellIndex, int wHint, int hHint) {
		int childIndex = cellIndex - getStartingCellIndex();
		if (childIndex >= getCells())
			return IEntityFigure.PLACE_HOLDER_DIMENSION;
		else if (childIndex == 0)
			return getContentPane(0).getPreferredSize(wHint, hHint);
		else
			return ((IEntityFigure) getContentPane(1)).getTabularLayoutClient().getPreferredCellSize(childIndex, wHint, hHint);
	}
	public Rectangle getCellBounds(int cellIndex) {
		int childIndex = cellIndex - getStartingCellIndex();
		if (childIndex >= getCells())
			return IEntityFigure.PLACE_HOLDER_BOUNDS;
		else if (childIndex == 0)
			return getContentPane(0).getBounds();
		else
			return ((IEntityFigure) getContentPane(1)).getTabularLayoutClient().getCellBounds(childIndex);
	}
	public int getCellSpacingBefore(int cellIndex) {
		int childIndex = cellIndex - getStartingCellIndex();
		if (childIndex > getCells())
			return 0;
		else if (childIndex == 0)
			return ((IEntityFigure) getContentPane(0)).getTabularLayoutClient().getPreferredCellSpacingBefore(childIndex);
		else if (childIndex == 1)
			return ((IEntityFigure) getContentPane(0)).getTabularLayoutClient().getPreferredCellSpacingBefore(childIndex)+
					((IEntityFigure) getContentPane(1)).getTabularLayoutClient().getPreferredCellSpacingBefore(childIndex);
		else
			return ((IEntityFigure) getContentPane(1)).getTabularLayoutClient().getPreferredCellSpacingBefore(childIndex);
	}
	public int getPreferredCellSpacingBefore(int cellIndex) {
		int childIndex = cellIndex - getStartingCellIndex();
		int cells = getCells();
		if (childIndex > cells)
			return 0;
		else if (childIndex == 0)
			return getLayoutManager().isHorizontal() ? getLayoutManager().getMarginLeft() : getLayoutManager().getMarginTop();
		else if (childIndex == cells)
			return getLayoutManager().isHorizontal() ? getLayoutManager().getMarginRight() : getLayoutManager().getMarginBottom();
		else
			return getLayoutManager().getSpacingBefore(childIndex);
	}

	public void invalidateTable() {
		invalidate();
		ITabularLayoutServer tls = getMyTabularLayoutServer();
		if (tls != null)
			tls.invalidateTable();
	}
	public int getColumnWidth(int columnIndex) {
		ITabularLayoutServer tls = getMyTabularLayoutServer();
		return Math.max(tls != null ? tls.getColumnWidth(getStartingCellIndex()+columnIndex) : 0, getCellBounds(columnIndex).width);
	}
	public int getColumnSpacingBefore(int columnIndex) {
		ITabularLayoutServer tls = getMyTabularLayoutServer();
		return Math.max(tls != null ? tls.getColumnSpacingBefore(getStartingCellIndex()+columnIndex) : 0, getPreferredCellSpacingBefore(columnIndex));
	}
	public Alignment getColumnAlignment(int columnIndex) {
		ITabularLayoutServer tls = getMyTabularLayoutServer();
		return tls != null ? tls.getColumnAlignment(getStartingCellIndex()+columnIndex) : Alignment.LEADING;
	}

}
