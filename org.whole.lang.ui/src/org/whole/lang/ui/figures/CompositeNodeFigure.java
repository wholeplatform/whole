/**
 * Copyright 2004-2019 Riccardo Solmi. All rights reserved.
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

import java.util.List;

import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.geometry.Point;
import org.whole.lang.ui.layout.ICompositeEntityLayout;

/**
 * @author Riccardo Solmi
 * 
 * TODO Keep in sync with NodeFigure
 */
public class CompositeNodeFigure extends CompositeFigure implements INodeFigure {
	protected static final ConnectionAnchor[] NO_ANCHORS = new ConnectionAnchor[0];
	private ConnectionAnchor[] sourceAnchors;
	private ConnectionAnchor[] targetAnchors;

	protected CompositeNodeFigure() {
	}
	public CompositeNodeFigure(boolean isHorizontal) {
		super(isHorizontal);
	}
	public CompositeNodeFigure(boolean isHorizontal, boolean withPlaceholder) {
		super(isHorizontal, withPlaceholder);
	}
	public CompositeNodeFigure(ICompositeEntityLayout layout) {
		super(layout);
	}
	public CompositeNodeFigure(ICompositeEntityLayout layout, boolean withPlaceholder) {
		super(layout, withPlaceholder);
	}

	protected ConnectionAnchor[] getSourceAnchors() {
		if (sourceAnchors == null)
			initAnchors();
		return sourceAnchors;
	}
	protected ConnectionAnchor[] getTargetAnchors() {
		if (targetAnchors == null)
			initAnchors();
		return targetAnchors;
	}

	@Override
	public void invalidate() {
		invalidateAnchors();

		super.invalidate();
	}

	protected void invalidateAnchors() {
		invalidateSourceAnchors();
		invalidateTargetAnchors();
	}
	protected void invalidateSourceAnchors() {
		sourceAnchors = null;
	}
	protected void invalidateTargetAnchors() {
		targetAnchors = null;
	}
	protected void initAnchors() {
		if (sourceAnchors == null)
			sourceAnchors = createSourceAnchors();
		if (targetAnchors == null)
			targetAnchors = createTargetAnchors();
		if (sourceAnchors == NO_ANCHORS && targetAnchors == NO_ANCHORS)
			sourceAnchors = targetAnchors = createAnchors();
	}

	protected ConnectionAnchor[] createAnchors() {
		return new ConnectionAnchor[] {
				AnchorFactory.createChopboxAnchor(this)};
	}
	protected ConnectionAnchor[] createSourceAnchors() {
		return NO_ANCHORS;
	}
	protected ConnectionAnchor[] createTargetAnchors() {
		return NO_ANCHORS;
	}

	public int getSourceAnchorsSize() {
		return getSourceAnchors().length;
	}
	public int getTargetAnchorsSize() {
		return getTargetAnchors().length;
	}
	
	public ConnectionAnchor getSourceAnchor(int index) {
		return getSourceAnchors()[index];
	}
	public ConnectionAnchor getTargetAnchor(int index) {
		return getTargetAnchors()[index];
	}

	public ConnectionAnchor getClosestSourceAnchor(Point p, DistanceMetric metric) {
        return NodeFigure.getClosestDistanceAnchor(p, getSourceAnchors(), metric);
    }
	public ConnectionAnchor getClosestTargetAnchor(Point p, DistanceMetric metric) {
        return NodeFigure.getClosestDistanceAnchor(p, getTargetAnchors(), metric);
    }

	public ConnectionAnchor getSourceAnchorAt(Point p) {
        return NodeFigure.getClosestDistanceAnchor(p, getSourceAnchors());
    }
	public ConnectionAnchor getTargetAnchorAt(Point p) {
        return NodeFigure.getClosestDistanceAnchor(p, getTargetAnchors());
    }

    public int getSourceAnchorIndexAt(Point p) {
        return NodeFigure.getClosestDistanceAnchorIndex(p, getSourceAnchors());
    }
	public int getTargetAnchorIndexAt(Point p) {
        return NodeFigure.getClosestDistanceAnchorIndex(p, getTargetAnchors());
    }

	public List<Point> getSourceAnchorLocations(Point reference) {
        return NodeFigure.getAnchorLocations(getSourceAnchors(), reference);
	}
	public List<Point> getTargetAnchorLocations(Point reference) {
        return NodeFigure.getAnchorLocations(getTargetAnchors(), reference);
	}
}
