/**
 * Copyright 2004-2012 Riccardo Solmi. All rights reserved.
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

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.TreeSearch;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.whole.lang.ui.layout.ITabularLayoutClient;
import org.whole.lang.ui.layout.ITabularLayoutServer;

/**
 * @author Riccardo Solmi
 */
public interface IEntityFigure extends IFigure {
	public static final Rectangle PLACE_HOLDER_BOUNDS = new Rectangle();
	public static final Dimension PLACE_HOLDER_DIMENSION = new Dimension();

//TODO
//	public BaselinedDimension getMinimumSize();
//	public BaselinedDimension getMinimumSize(int wHint, int hHint);
//	public BaselinedDimension getPreferredSize();
//	public BaselinedDimension getPreferredSize(int wHint, int hHint);

	public int getIndent();
	public int getAscent();

	public ITabularLayoutServer getTabularLayoutServer();
	public ITabularLayoutClient getTabularLayoutClient();

	public int getContentPanesSize();
	public IFigure getContentPane(int paneIndex);
	public void setContentPaneVisible(int paneIndex, boolean visible);

	public boolean isInteractiveEdit();
	public void setInteractiveEdit(boolean interactiveEdit);
	public boolean isInteractiveBrowse();
	public void setInteractiveBrowse(boolean interactiveBrowse);
	public boolean isInteractiveInherited();
	public void setInteractiveInherited(boolean interactiveInherited);

	public IFigure findFigureAt(int x, int y, TreeSearch search, boolean inheritedEdit);
	public IFigure findMouseEventTargetAt(int x, int y, boolean inheritedBrowse);
}
