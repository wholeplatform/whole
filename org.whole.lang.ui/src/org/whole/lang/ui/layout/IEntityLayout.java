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
import org.eclipse.draw2d.LayoutManager;
import org.eclipse.draw2d.geometry.Rectangle;
import org.whole.lang.ui.figures.IViewportTrackingStrategy;

/**
 * @author Riccardo Solmi
 */
public interface IEntityLayout extends LayoutManager {
	public BaselinedDimension getMinimumSize(IFigure container, int wHint, int hHint);
	public BaselinedDimension getPreferredSize(IFigure container, int wHint, int hHint);

	public boolean isHorizontal();

	public int getIndent(IFigure container);
	public int getAscent(IFigure container);
	
	public int getBaseline(int childIndex);
	public Rectangle getBounds(int childIndex);

	public IEntityLayout withViewportTrackingStrategy(IViewportTrackingStrategy viewportTrackingStrategy);
	public IViewportTrackingStrategy getViewportTrackingStrategy();
	
	public IEntityLayout withAutoresizeWeight(float weight); //TODO del
	public IEntityLayout withMajorAutoresizeWeight(float weight);
	public IEntityLayout withMinorAutoresizeWeight(float weight);
	public float getMajorAutoresizeWeight();
	public float getMinorAutoresizeWeight();

	public IEntityLayout withMargin(int margin);
	public IEntityLayout withMargin(int marginTop, int marginLeft, int marginBottom, int marginRight);
	public IEntityLayout withMarginLeft(int marginLeft);
	public IEntityLayout withMarginRight(int marginRight);
	public IEntityLayout withMarginTop(int marginTop);
	public IEntityLayout withMarginBottom(int marginBottom);
	public int getMarginLeft();
	public int getMarginRight();
	public int getMarginTop();
	public int getMarginBottom();

	public boolean isOrdered();

	public IEntityLayout withSpacing(int spacing);
	public int getSpacing();
	public int getSpacingBefore(int childIndex);

	public static final int SPACED_ALL = Integer.MAX_VALUE;
	public static final int SPACED_NONE = Integer.MIN_VALUE;
	public static final int SPACED_SPACING = 5; //WAS 10;
	public int getSpacedChild();
	public void setSpacedChild(int childIndex);

	public ITabularLayoutServer getTabularLayoutServer();
	public ITabularLayoutClient getTabularLayoutClient();
}
