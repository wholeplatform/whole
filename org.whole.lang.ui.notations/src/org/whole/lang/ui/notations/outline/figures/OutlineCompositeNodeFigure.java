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

import java.util.List;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.graphics.Image;
import org.whole.lang.ui.figures.AnchorFactory;
import org.whole.lang.ui.figures.CompositeFigure;
import org.whole.lang.ui.figures.EntityFigure;
import org.whole.lang.ui.figures.IEntityFigure;
import org.whole.lang.ui.figures.INodeFigure;
import org.whole.lang.ui.figures.NodeFigure;
import org.whole.lang.ui.layout.Alignment;
import org.whole.lang.ui.layout.RowLayout;
import org.whole.lang.ui.layout.UnderColumnLayout;
import org.whole.lang.ui.notations.figures.DrawUtils;

/**
 * @author Riccardo Solmi, Enrico Persiani
 */
public class OutlineCompositeNodeFigure extends NodeFigure {
	protected OutlineCompositeNodeFigure() {
	}
	public OutlineCompositeNodeFigure(boolean startOpened, Image image) {
		this(startOpened, image, null);
	}
	public OutlineCompositeNodeFigure(boolean startOpened, Image image, String label) {
		super(new UnderColumnLayout().withMinorAlignment(Alignment.LEADING));
		initContentPanes(label == null ? 2 : 1);

		EntityFigure topFigure = new EntityFigure(new RowLayout().withSpacing(4));
		topFigure.add(createFoldingToggle(label == null ? 1 : 0));

		if (label == null) {
			topFigure.addLabel(image);
			topFigure.add(createContentPane(0));
		} else
			topFigure.addLabel(label, image);

		add(topFigure);
		add(createContentPane(label == null ? 1 : 0, new MarginBorder(0,16,0,0)));

		if (!startOpened)
	    	clickFoldingToggle(0);
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
	protected void paintFigure(Graphics graphics) {
		super.paintFigure(graphics);
		paintConnections(graphics);
	}

	protected void paintConnections(Graphics graphics) {
		IFigure contentPane = getContentPane(getContentPanesSize()-1);
		List<?> list = contentPane.getChildren();
		if (contentPane.isVisible() && !list.isEmpty()) {
			IFigure contentsFigure = (IFigure) list.get(0);
			Point[] children;
			if (contentsFigure instanceof CompositeFigure) {
				int compositeChildrenNumber = contentsFigure.getChildren().size();
				if (compositeChildrenNumber == 0)
					return;
				children = new Point[compositeChildrenNumber];
				for (int i=0; i<compositeChildrenNumber; i++) {
					IFigure compositeChild = (IFigure) contentsFigure.getChildren().get(i);
				
					// calculate target point position
					Point targetLocation;
					if (compositeChild instanceof INodeFigure)
						targetLocation = ((INodeFigure) compositeChild).getTargetAnchor(0).getLocation(null);
					else {
						Rectangle compositeChildBounds = compositeChild.getBounds();
						targetLocation = compositeChildBounds.getLeft();
						if (compositeChild instanceof IEntityFigure)
							targetLocation.y = compositeChildBounds.y + ((IEntityFigure) compositeChild).getAscent();
						compositeChild.translateToAbsolute(targetLocation);
					}
					translateToRelative(targetLocation);
					children[i] = targetLocation;
				}
			} else {
				children = new Point[1];
				// calculate target point position
				Point targetLocation;
				if (contentsFigure instanceof INodeFigure)
					targetLocation = ((INodeFigure) contentsFigure).getTargetAnchor(0).getLocation(null);
				else {
					Rectangle compositeChildBounds = contentsFigure.getBounds();
					targetLocation = compositeChildBounds.getLeft();
					if (contentsFigure instanceof IEntityFigure)
						targetLocation.y = compositeChildBounds.y + ((IEntityFigure) contentsFigure).getAscent();
					contentsFigure.translateToAbsolute(targetLocation);
				}
				translateToRelative(targetLocation);
				children[0] = targetLocation;
			}
			
			Point start = getSourceAnchor(0).getLocation(null);
			translateToRelative(start);
			graphics.setForegroundColor(ColorConstants.lightGray);
			graphics.setLineDash(new int[] {1,1});
			DrawUtils.drawOutline(graphics, start, children);
		}
	}
}
