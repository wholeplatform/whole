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
import org.whole.lang.ui.figures.IViewportTrackingStrategy;

/**
 * @author Enrico Persiani
 */
public class EntityLayoutDelegator<D extends IEntityLayout> implements IEntityLayout {
	protected D delegate;
	
	public EntityLayoutDelegator(D delegate) {
		this.delegate = delegate;
	}
	
	protected D getDelegate() {
		return delegate;
	}

	protected IViewportTrackingStrategy viewportTrackingStrategy = IViewportTrackingStrategy.IDENTITY;
	public EntityLayoutDelegator<D> withViewportTrackingStrategy(IViewportTrackingStrategy viewportTrackingStrategy) {
		this.viewportTrackingStrategy = viewportTrackingStrategy;
		return this;
	}
	public IViewportTrackingStrategy getViewportTrackingStrategy() {
		return viewportTrackingStrategy;
	}

	public Object getConstraint(IFigure child) {
		return getDelegate().getConstraint(child);
	}

	public BaselinedDimension getMinimumSize(IFigure container, int wHint,
			int hHint) {
		return getDelegate().getMinimumSize(container, wHint, hHint);
	}

	public BaselinedDimension getPreferredSize(IFigure container, int wHint,
			int hHint) {
		return getDelegate().getPreferredSize(container, wHint, hHint);
	}

	public boolean isHorizontal() {
		return getDelegate().isHorizontal();
	}

	public int getIndent(IFigure container) {
		return getDelegate().getIndent(container);
	}

	public int getAscent(IFigure container) {
		return getDelegate().getAscent(container);
	}

	public int getBaseline(int childIndex) {
		return getDelegate().getBaseline(childIndex);
	}

	public Rectangle getBounds(int childIndex) {
		return getDelegate().getBounds(childIndex);
	}

	public IEntityLayout withAutoresizeWeight(float weight) {
		return getDelegate().withAutoresizeWeight(weight);
	}

	public IEntityLayout withMajorAutoresizeWeight(float weight) {
		return getDelegate().withMajorAutoresizeWeight(weight);
	}

	public void invalidate() {
		getDelegate().invalidate();
	}

	public IEntityLayout withMinorAutoresizeWeight(float weight) {
		return getDelegate().withMinorAutoresizeWeight(weight);
	}

	public float getMajorAutoresizeWeight() {
		return getDelegate().getMajorAutoresizeWeight();
	}

	public float getMinorAutoresizeWeight() {
		return getDelegate().getMinorAutoresizeWeight();
	}

	public IEntityLayout withMargin(int margin) {
		return getDelegate().withMargin(margin);
	}

	public IEntityLayout withMargin(int marginTop, int marginLeft,
			int marginBottom, int marginRight) {
		return getDelegate().withMargin(marginTop, marginLeft, marginBottom,
				marginRight);
	}

	public void layout(IFigure container) {
		getDelegate().layout(container);
	}

	public IEntityLayout withMarginLeft(int marginLeft) {
		return getDelegate().withMarginLeft(marginLeft);
	}

	public void remove(IFigure child) {
		getDelegate().remove(child);
	}

	public IEntityLayout withMarginRight(int marginRight) {
		return getDelegate().withMarginRight(marginRight);
	}

	public IEntityLayout withMarginTop(int marginTop) {
		return getDelegate().withMarginTop(marginTop);
	}

	public IEntityLayout withMarginBottom(int marginBottom) {
		return getDelegate().withMarginBottom(marginBottom);
	}

	public void setConstraint(IFigure child, Object constraint) {
		getDelegate().setConstraint(child, constraint);
	}

	public int getMarginLeft() {
		return getDelegate().getMarginLeft();
	}

	public int getMarginRight() {
		return getDelegate().getMarginRight();
	}

	public int getMarginTop() {
		return getDelegate().getMarginTop();
	}

	public int getMarginBottom() {
		return getDelegate().getMarginBottom();
	}

	public boolean isOrdered() {
		return getDelegate().isOrdered();
	}

	public IEntityLayout withSpacing(int spacing) {
		return getDelegate().withSpacing(spacing);
	}

	public int getSpacing() {
		return getDelegate().getSpacing();
	}

	public int getSpacingBefore(int childIndex) {
		return getDelegate().getSpacingBefore(childIndex);
	}

	public int getSpacedChild() {
		return getDelegate().getSpacedChild();
	}

	public void setSpacedChild(int childIndex) {
		getDelegate().setSpacedChild(childIndex);
	}

	public ITabularLayoutServer getTabularLayoutServer() {
		return getDelegate().getTabularLayoutServer();
	}

	public ITabularLayoutClient getTabularLayoutClient() {
		return getDelegate().getTabularLayoutClient();
	}
}
