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
import org.eclipse.draw2d.XYLayout;
import org.eclipse.draw2d.geometry.Rectangle;
import org.whole.lang.ui.figures.IViewportTrackingStrategy;

/**
 * @author Riccardo Solmi
 */
public class EntityXYLayout extends XYLayout implements IEntityLayout {
	protected IViewportTrackingStrategy viewportTrackingStrategy = IViewportTrackingStrategy.IDENTITY;
	public EntityXYLayout withViewportTrackingStrategy(IViewportTrackingStrategy viewportTrackingStrategy) {
		this.viewportTrackingStrategy = viewportTrackingStrategy;
		return this;
	}
	public IViewportTrackingStrategy getViewportTrackingStrategy() {
		return viewportTrackingStrategy;
	}

	private BaselinedDimension preferredSize;
	
	public int getIndent(IFigure container) {
		return preferredSize == null ? 0 : preferredSize.getIndent();
	}
	public int getAscent(IFigure container) {
		return preferredSize == null ? 0 : preferredSize.getAscent();
	}

	public BaselinedDimension getMinimumSize(IFigure container, int wHint, int hHint) {
		return new BaselinedDimension(super.getMinimumSize(container, wHint, hHint));
	}

	public BaselinedDimension getPreferredSize(IFigure container, int wHint, int hHint) {
		return preferredSize = new BaselinedDimension(super.getPreferredSize(container, wHint, hHint));
	}

	public int getBaseline(int childIndex) {
		throw new UnsupportedOperationException();
	}
	public Rectangle getBounds(int childIndex) {
		throw new UnsupportedOperationException();
	}

	public float getMajorAutoresizeWeight() {
		return 0f;
	}
	public float getMinorAutoresizeWeight() {
		return 0f;
	}

	public boolean isHorizontal() {
		return false;
	}

	public int getMarginLeft() {
		return 0;
	}
	public int getMarginRight() {
		return 0;
	}
	public int getMarginTop() {
		return 0;
	}
	public int getMarginBottom() {
		return 0;
	}

	public IEntityLayout withAutoresizeWeight(float weight) {
		throw new UnsupportedOperationException();
	}
	public IEntityLayout withMajorAutoresizeWeight(float weight) {
		throw new UnsupportedOperationException();
	}
	public IEntityLayout withMinorAutoresizeWeight(float weight) {
		throw new UnsupportedOperationException();
	}

	public IEntityLayout withMargin(int margin) {
		throw new UnsupportedOperationException();
	}
	public IEntityLayout withMargin(int marginTop, int marginLeft, int marginBottom, int marginRight) {
		throw new UnsupportedOperationException();
	}
	public IEntityLayout withMarginLeft(int marginLeft) {
		throw new UnsupportedOperationException();
	}
	public IEntityLayout withMarginRight(int marginRight) {
		throw new UnsupportedOperationException();
	}
	public IEntityLayout withMarginTop(int marginTop) {
		throw new UnsupportedOperationException();
	}
	public IEntityLayout withMarginBottom(int marginBottom) {
		throw new UnsupportedOperationException();
	}

	public boolean isOrdered() {
		return false;
	}

	public int getSpacedChild() {
		return SPACED_NONE;
	}
	public void setSpacedChild(int childIndex) {
	}

	public IEntityLayout withSpacing(int spacing) {
		return this;
	}
	public int getSpacing() {
		return 0;
	}
	public int getSpacingBefore(int childIndex) {
		return childIndex == 0 ?
				0 : childIndex == getSpacedChild() || childIndex == getSpacedChild()+1 || getSpacedChild() == SPACED_ALL ?
						getSpacedSpacing(getSpacing()) : getSpacing();
	}
	protected int getSpacedSpacing(int spacing) {
		return AbstractEntityLayout.defaultGetSpacedSpacing(spacing);
	}

	public ITabularLayoutServer getTabularLayoutServer() {
		return null;
	}
	public ITabularLayoutClient getTabularLayoutClient() {
		return ITabularLayoutClient.NULL_TABULAR_LAYOUT_CLIENT;
	}
}
