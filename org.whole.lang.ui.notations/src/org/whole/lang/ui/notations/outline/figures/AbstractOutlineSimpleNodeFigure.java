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
package org.whole.lang.ui.notations.outline.figures;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.whole.lang.ui.figures.AnchorFactory;
import org.whole.lang.ui.figures.CompositeFigure;
import org.whole.lang.ui.figures.EntityFigure;
import org.whole.lang.ui.figures.IEntityFigure;
import org.whole.lang.ui.figures.INodeFigure;
import org.whole.lang.ui.figures.NodeFigure;
import org.whole.lang.ui.figures.PlaceHolderFigure;
import org.whole.lang.ui.layout.Alignment;
import org.whole.lang.ui.layout.RowLayout;
import org.whole.lang.ui.layout.UnderColumnLayout;
import org.whole.lang.ui.notations.figures.DrawUtils;

/**
 * @author Enrico Persiani, Riccardo Solmi
 */
public abstract class AbstractOutlineSimpleNodeFigure extends NodeFigure {
	private EntityFigure labelFigure;

	public AbstractOutlineSimpleNodeFigure(boolean startOpened, int contentPanes) {
		super(new UnderColumnLayout().withMinorAlignment(Alignment.LEADING));
		initContentPanes(contentPanes);

		labelFigure = new EntityFigure(new RowLayout().withSpacing(4));
		labelFigure.add(createFoldingToggle(0));
		add(labelFigure);

		if (!startOpened)
	    	clickFoldingToggle(0);
	}

	protected EntityFigure getLabelFigure() {
		return labelFigure;
	}

	@Override
	protected ConnectionAnchor[] createTargetAnchors() {
		return new ConnectionAnchor[] {
			AnchorFactory.createFixedAnchor(getFoldingToggle(0), 0, 0.5)
		};
	}

	@Override
	protected ConnectionAnchor[] createSourceAnchors() {
		return new ConnectionAnchor[] {
				AnchorFactory.createFixedAnchor(getFoldingToggle(0), 0.5, 1.0)
			};
	}

	@Override
	public void paintClientArea(Graphics graphics) {
		super.paintClientArea(graphics);
		paintConnections(graphics);
		graphics.restoreState();
	}

	@SuppressWarnings("unchecked")
	protected void paintConnections(Graphics graphics) {
		if (isContentVisible()) {
			List<IFigure> contents = getContents();
			int featureNumber = contents.size();
			if (featureNumber == 0)
				return;
			Point start = getSourceAnchor(0).getLocation(null);
			List<Point> childrenLocations = new ArrayList<Point>(featureNumber);
			for (int i=0; i<featureNumber; i++) {
				IFigure childfigure = contents.get(i);
				List<IFigure> children = childfigure.getChildren();
				if (!childfigure.isVisible() || children.isEmpty())
					continue;
				IFigure featureChild = (IFigure) children.get(0);

				// calculate target point position
				if (featureChild instanceof PlaceHolderFigure)
					addChildrenLocations(start, childrenLocations, featureChild);
				else if (featureChild instanceof CompositeFigure) {
					for (Object child : ((IFigure) featureChild).getChildren())
						addChildrenLocations(start, childrenLocations, (IFigure) child);
				} else
					addChildrenLocations(start, childrenLocations, featureChild);
			}
			if (childrenLocations.isEmpty())
				return;
			translateToRelative(start);
			graphics.setForegroundColor(ColorConstants.lightGray);
			graphics.setLineDash(new int[] {1,1});
			DrawUtils.drawOutline(graphics, start, childrenLocations.toArray(new Point[0]));
		}
	}

	protected void addChildrenLocations(Point reference, List<Point> childrenLocations, IFigure featureChild) {
		if (featureChild instanceof INodeFigure) {
			for (Point targetLocation : ((INodeFigure) featureChild).getTargetAnchorLocations(reference)) {
				translateToRelative(targetLocation);
				childrenLocations.add(targetLocation);
			}
		} else {
			Rectangle featureChildBounds = featureChild.getBounds();
			Point targetLocation = featureChildBounds.getLeft();
			if (featureChild instanceof IEntityFigure)
				targetLocation.y = featureChildBounds.y + ((IEntityFigure) featureChild).getAscent();
			featureChild.translateToAbsolute(targetLocation);
			translateToRelative(targetLocation);
			childrenLocations.add(targetLocation);
		}
	}

	protected abstract void toggleVisibility(int paneIndex);
	protected abstract boolean isContentVisible();
	protected abstract List<IFigure> getContents();
}
