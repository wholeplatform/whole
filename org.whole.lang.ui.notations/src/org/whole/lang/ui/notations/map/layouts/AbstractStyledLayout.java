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

import java.util.List;

import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.whole.lang.ui.figures.AnchorFactory;
import org.whole.lang.ui.figures.DistanceMetric;
import org.whole.lang.ui.figures.IEntityFigure;
import org.whole.lang.ui.figures.INodeFigure;
import org.whole.lang.ui.layout.AbstractEntityLayout;
import org.whole.lang.ui.layout.Alignment;
import org.whole.lang.ui.layout.ColumnLayout;
import org.whole.lang.ui.layout.ICompositeEntityLayout;
import org.whole.lang.ui.layout.IEntityLayout;
import org.whole.lang.ui.layout.RowLayout;
import org.whole.lang.ui.notations.map.borders.UnderlineStyledBorder;
import org.whole.lang.ui.notations.map.figures.IStyledFigure;

/**
 * @author Riccardo Solmi
 */
public abstract class AbstractStyledLayout extends AbstractEntityLayout implements IStyledLayout {
	public int TOGGLE_INDENT = 16;
	public int CHILDREN_GAP = 10;
	public int CHILDREN_INDENT = 22;
	public int CHILDREN_SPACING = 5;
	public int CHILD_LINE_GAP = 1;

	private IEntityLayout childrenLayoutManager;
	public IEntityLayout getChildrenLayoutManager() {
		if (childrenLayoutManager == null)
			childrenLayoutManager = createChildrenLayoutManager();
		return childrenLayoutManager;
	}
	protected IEntityLayout createChildrenLayoutManager() {
		ICompositeEntityLayout layout = isHorizontal() ? 
				new RowLayout().withMarginLeft(4).withMarginRight(4) : 
				new ColumnLayout().withMarginTop(5).withMarginBottom(5);
		return layout.withSpacing(CHILDREN_SPACING).withMinorAlignment(getMinorAlignment());
	}
	public boolean isHorizontal() {
		return false;
	}
	protected Alignment getMinorAlignment() {
		return Alignment.LEADING;
	}

	private ConnectionAnchor[] targetAnchors;
	public ConnectionAnchor[] getTargetAnchors(IStyledFigure styledFigure) {
		if (targetAnchors == null)
			targetAnchors = createRootTargetAnchors(styledFigure);
		return targetAnchors;
	}
	protected ConnectionAnchor[] createRootTargetAnchors(IStyledFigure styledFigure) {
		if (styledFigure.getShape() instanceof UnderlineStyledBorder)
			return new ConnectionAnchor[] {
				AnchorFactory.createLeftOrRightBottomAnchor(childFigure[0]),
				AnchorFactory.createBottomMiddleAnchor(childFigure[0])
			};
		else
			return new ConnectionAnchor[] {
					AnchorFactory.createLeftOrRightMiddleAnchor(childFigure[0]),
					AnchorFactory.createTopOrBottomMiddleAnchor(childFigure[0])
			};
	}
	public void invalidateTargetAnchors() {
		targetAnchors = null;
	}
	
	@Override
	public void invalidate() {
		super.invalidate();
		
		if (childFigure != null)
			for (IEntityFigure child : childFigure)
				child.invalidate();
	}

	@SuppressWarnings("unchecked")
	public void paintConnections(Graphics graphics) {
		IFigure childrenFigure = (IFigure) childFigure[1].getChildren().get(0);
		Point[] childrenPoints = null;
		List<IFigure> children = childrenFigure.getChildren();
		int childrenSize = children.size();
		if (childrenSize == 0) {
			childrenPoints = new Point[1];
			childrenPoints[0] = getChildPoint(0, childrenFigure);
		} else {
			childrenPoints = new Point[childrenSize];
			for (int i=0; i<childrenSize; i++)
				childrenPoints[i] = getChildPoint(i, children.get(i));
		}

		paintConnections(graphics, childrenPoints);
	}
	protected abstract void paintConnections(Graphics graphics, Point... childrenPoints);

	protected abstract Point getRootPoint();

	protected Point getChildPoint(int index, IFigure childFigure) {
		if (childFigure instanceof INodeFigure) {			
			Point absoluteRootPoint = new Point(getRootPoint());
			childFigure.translateToAbsolute(absoluteRootPoint);
			ConnectionAnchor targetAnchor = ((INodeFigure) childFigure).getClosestTargetAnchor(
					absoluteRootPoint, getDistanceMetric());
			if (targetAnchor != null) {
				Point childPoint = targetAnchor.getLocation(absoluteRootPoint);
				childFigure.translateToRelative(childPoint);
				return childPoint;
			}
		}
		return getChildPoint2(index, childFigure);
		
	}
	protected DistanceMetric getDistanceMetric() {
		return DistanceMetric.Orizontal;
	}
	protected abstract Point getChildPoint2(int index, IFigure childFigure);

	protected Point getChildUpPoint(IFigure childFigure) {
		return childFigure.getBounds().getTop().translate(0, -CHILD_LINE_GAP);
	}
	protected Point getChildDownPoint(IFigure childFigure) {
		return childFigure.getBounds().getBottom().translate(0, +CHILD_LINE_GAP);
	}
	protected Point getChildLeftPoint(IFigure childFigure) {
		if (childFigure instanceof IEntityFigure)
			return childFigure.getBounds().getTopLeft().translate(-CHILD_LINE_GAP,
					((IEntityFigure) childFigure).getAscent());
		else
			return childFigure.getBounds().getLeft().translate(-CHILD_LINE_GAP, 0);
	}
	protected Point getChildRightPoint(IFigure childFigure) {
		if (childFigure instanceof IEntityFigure)
			return childFigure.getBounds().getTopRight().translate(+CHILD_LINE_GAP,
					((IEntityFigure) childFigure).getAscent());
		else
			return childFigure.getBounds().getRight().translate(+CHILD_LINE_GAP, 0);
	}
}
