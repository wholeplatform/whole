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

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.whole.lang.ui.figures.IEntityFigure;

/**
 * @author Riccardo Solmi
 */
public interface ITabularLayoutClient {
	public static final ITabularLayoutClient NULL_TABULAR_LAYOUT_CLIENT = new ITabularLayoutClient() {
		public int getStartingCellIndex() {
			return 0;
		}
		public void setStartingCellIndex(int cellIndex) {
		}
		public int getCells() {
			return 0;
		}
		public void invalidateCells() {
		}
		public Dimension getPreferredCellSize(int cellIndex, int wHint, int hHint) {
			return IEntityFigure.PLACE_HOLDER_DIMENSION;
		}
		public Rectangle getCellBounds(int cellIndex) {
			return IEntityFigure.PLACE_HOLDER_BOUNDS;
		}
		public int getCellSpacingBefore(int cellIndex) {
			return 0;
		}
		public int getPreferredCellSpacingBefore(int cellIndex) {
			return 0;
		}
	};

	public int getStartingCellIndex();
	public void setStartingCellIndex(int cellIndex);
	public int getCells();
	public void invalidateCells();
	public Dimension getPreferredCellSize(int cellIndex, int wHint, int hHint);
	public Rectangle getCellBounds(int cellIndex);
	public int getCellSpacingBefore(int cellIndex);
	public int getPreferredCellSpacingBefore(int cellIndex);
}
