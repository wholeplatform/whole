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

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.whole.lang.ui.figures.IEntityFigure;
import org.whole.lang.ui.figures.TableFigure;
import org.whole.lang.ui.layout.Alignment;
import org.whole.lang.ui.layout.BaselinedDimension;
import org.whole.lang.ui.layout.ITabularLayoutServer;
import org.whole.lang.ui.layout.TableLayout;

/**
 * @author Riccardo Solmi
 */
public class OrExpressionsTableFigure extends TableFigure {
	public OrExpressionsTableFigure() {
		super(new TableLayout() {
			protected BaselinedDimension calculateSize(IFigure container, int wHint, int hHint, boolean preferred) {
				updateTabularLayoutManager(container);
				return super.calculateSize(container, wHint, hHint, preferred);
			}
			private ITabularLayoutServer tabularLayoutServer;
			public void updateTabularLayoutManager(IFigure container) {
				IFigure parent = container.getParent();
				ITabularLayoutServer tlm = (parent instanceof IEntityFigure) ?
						((IEntityFigure) parent).getTabularLayoutServer() : null;
				if (tlm != null)
					tabularLayoutServer = tlm;
			}

			public int getColumnWidth(int columnIndex) {
				return tabularLayoutServer != null ?
						tabularLayoutServer.getColumnWidth(columnIndex) : super.getColumnWidth(columnIndex);
			};
			public int getColumnSpacingBefore(int columnIndex) {
				return tabularLayoutServer != null ?
						tabularLayoutServer.getColumnSpacingBefore(columnIndex) : super.getColumnSpacingBefore(columnIndex);
			};
			public Alignment getColumnAlignment(int columnIndex) {
				return tabularLayoutServer != null ?
						tabularLayoutServer.getColumnAlignment(columnIndex) : super.getColumnAlignment(columnIndex);
			};
		}.withColumnSpacing(6).withRowSpacing(10).withMarginTop(5).withMarginBottom(5));
		
		getLayoutManager().setStartingCellIndex(1);
	}

	public int getCells() {
		return ((TableLayout) getLayoutManager()).columns();
	}
	public Dimension getCellPreferredSize(int cellIndex, int wHint, int hHint) {
		Rectangle r = getCellBounds(cellIndex);
		return r.getSize();
		//return ((TableLayout) getLayoutManager()).;
	}
	public Rectangle getCellBounds(int cellIndex) {
		return ((TableLayout) getLayoutManager()).getColumnBounds(cellIndex);
	}
}
