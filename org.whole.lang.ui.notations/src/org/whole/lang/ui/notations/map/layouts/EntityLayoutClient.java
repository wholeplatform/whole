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
package org.whole.lang.ui.notations.map.layouts;

import org.eclipse.draw2d.AbstractLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.whole.lang.ui.figures.IViewportTrackingStrategy;
import org.whole.lang.ui.layout.BaselinedDimension;
import org.whole.lang.ui.layout.ColumnLayout;
import org.whole.lang.ui.layout.ICompositeEntityLayout;
import org.whole.lang.ui.layout.IEntityLayout;
import org.whole.lang.ui.layout.ITabularLayoutClient;
import org.whole.lang.ui.layout.ITabularLayoutServer;

/**
 * @author Riccardo Solmi
 */
public class EntityLayoutClient extends AbstractLayout implements IEntityLayout, ILayoutManagerServer {
	private ILayoutManagerServer layoutManagerServer;

	public IEntityLayout getTargetLayoutManager() {
		assert layoutManagerServer != null;
		return layoutManagerServer.getChildrenLayoutManager();
	}
	public IEntityLayout getTargetLayoutManager(IFigure container) {
		if (layoutManagerServer == null) {
			IFigure parent = container.getParent();
			if (parent != null)
				parent = parent.getParent();

			layoutManagerServer = parent instanceof ILayoutManagerServer ? 
					(ILayoutManagerServer) parent : this;
		}
		return layoutManagerServer.getChildrenLayoutManager();
	}
	private IEntityLayout childrenLayoutManager;
	public IEntityLayout getChildrenLayoutManager() {
		if (childrenLayoutManager == null)
			childrenLayoutManager = createChildrenLayoutManager();
		return childrenLayoutManager;
	}
	protected ICompositeEntityLayout createChildrenLayoutManager() {
		return new ColumnLayout().withMarginTop(5).withMarginBottom(5).withSpacing(5);
	}

	public void invalidate() {
		if (layoutManagerServer != null)
			layoutManagerServer.getChildrenLayoutManager().invalidate();
	}

	public Object getConstraint(IFigure child) {
		return getTargetLayoutManager().getConstraint(child);
	}
	public void setConstraint(IFigure child, Object constraint) {
		if (layoutManagerServer != null)
			layoutManagerServer.getChildrenLayoutManager().setConstraint(child, constraint);
	}

	public BaselinedDimension getMinimumSize(IFigure container, int hint, int hint2) {
		return getTargetLayoutManager(container).getMinimumSize(container, hint, hint2);
	}
	public BaselinedDimension getPreferredSize(IFigure container, int hint, int hint2) {
		return getTargetLayoutManager(container).getPreferredSize(container, hint, hint2);
	}
	protected Dimension calculatePreferredSize(IFigure container, int hint, int hint2) {
		throw new IllegalStateException();
	}

	protected IViewportTrackingStrategy viewportTrackingStrategy = IViewportTrackingStrategy.IDENTITY;
	public EntityLayoutClient withViewportTrackingStrategy(IViewportTrackingStrategy viewportTrackingStrategy) {
		this.viewportTrackingStrategy = viewportTrackingStrategy;
		return this;
	}
	public IViewportTrackingStrategy getViewportTrackingStrategy() {
		return viewportTrackingStrategy;
	}

	public boolean isHorizontal() {
		return getTargetLayoutManager().isHorizontal();
	}

	public void layout(IFigure container) {
		getTargetLayoutManager(container).layout(container);
	}

	public void remove(IFigure child) {
		getTargetLayoutManager().remove(child);
	}

	public int getIndent(IFigure container) {
		return getTargetLayoutManager().getIndent(container);
	}
	public int getAscent(IFigure container) {
		return getTargetLayoutManager().getAscent(container);
	}
	public int getBaseline(int childIndex) {
		return getTargetLayoutManager().getBaseline(childIndex);
	}

	public Rectangle getBounds(int childIndex) {
		return getTargetLayoutManager().getBounds(childIndex);
	}

	public float getMajorAutoresizeWeight() {
		return getTargetLayoutManager().getMajorAutoresizeWeight();
	}
	public float getMinorAutoresizeWeight() {
		return getTargetLayoutManager().getMinorAutoresizeWeight();
	}

	public int getMarginLeft() {
		return getTargetLayoutManager().getMarginLeft();
	}
	public int getMarginRight() {
		return getTargetLayoutManager().getMarginRight();
	}
	public int getMarginTop() {
		return getTargetLayoutManager().getMarginTop();
	}
	public int getMarginBottom() {
		return getTargetLayoutManager().getMarginBottom();
	}

	public IEntityLayout withAutoresizeWeight(float weight) {
		return getTargetLayoutManager().withAutoresizeWeight(weight);
	}
	public IEntityLayout withMajorAutoresizeWeight(float weight) {
		return getTargetLayoutManager().withMajorAutoresizeWeight(weight);
	}
	public IEntityLayout withMinorAutoresizeWeight(float weight) {
		return getTargetLayoutManager().withMinorAutoresizeWeight(weight);
	}

	public IEntityLayout withMarginLeft(int marginLeft) {
		return getTargetLayoutManager().withMarginLeft(marginLeft);
	}
	public IEntityLayout withMarginRight(int marginRight) {
		return getTargetLayoutManager().withMarginRight(marginRight);
	}
	public IEntityLayout withMarginTop(int marginTop) {
		return getTargetLayoutManager().withMarginTop(marginTop);
	}
	public IEntityLayout withMarginBottom(int marginBottom) {
		return getTargetLayoutManager().withMarginBottom(marginBottom);
	}

	public IEntityLayout withMargin(int margin) {
		return getTargetLayoutManager().withMargin(margin);
	}
	public IEntityLayout withMargin(int marginTop, int marginLeft, int marginBottom, int marginRight) {
		return getTargetLayoutManager().withMargin(marginTop, marginLeft, marginBottom, marginRight);
	}

	public boolean isOrdered() {
		return getTargetLayoutManager().isOrdered();
	}

	public int getSpacedChild() {
		return getTargetLayoutManager().getSpacedChild();
	}
	public void setSpacedChild(int childIndex) {
		getTargetLayoutManager().setSpacedChild(childIndex);
	}

	public IEntityLayout withSpacing(int spacing) {
		getTargetLayoutManager().withSpacing(spacing);
		return this;
	}
	public int getSpacing() {
		return getTargetLayoutManager().getSpacing();
	}
	public int getSpacingBefore(int childIndex) {
		return getTargetLayoutManager().getSpacingBefore(childIndex);
	}

	public ITabularLayoutServer getTabularLayoutServer() {
		return getTargetLayoutManager().getTabularLayoutServer();
	}
	public ITabularLayoutClient getTabularLayoutClient() {
		return getTargetLayoutManager().getTabularLayoutClient();
	}
}
