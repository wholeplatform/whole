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
package org.whole.lang.ui.notations.styledtree.figures;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Toggle;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.whole.lang.ui.WholeImages;
import org.whole.lang.ui.figures.AnchorFactory;
import org.whole.lang.ui.figures.EntityFigure;
import org.whole.lang.ui.figures.EntityToggle;
import org.whole.lang.ui.figures.FigureConstants;
import org.whole.lang.ui.figures.IEntityFigure;
import org.whole.lang.ui.figures.INodeFigure;
import org.whole.lang.ui.figures.NodeFigure;
import org.whole.lang.ui.layout.Alignment;
import org.whole.lang.ui.layout.MonoLayout;
import org.whole.lang.ui.layout.RowLayout;
import org.whole.lang.ui.layout.ViewportTracking;
import org.whole.lang.ui.notations.figures.DrawUtils;
import org.whole.lang.ui.notations.styledtree.styling.IEntityStyling;

/**
 * @author Riccardo Solmi
 */
public class NodeWithCompositeBranchFigure extends NodeFigure {
	protected EntityFigure typeFigure;
	protected Toggle mainToggle;

	public NodeWithCompositeBranchFigure(IEntityStyling entityStyling) {
		initContentPanes(getChildrenPaneIndex()+1);
		
		setLayoutManager(new RowLayout() {
			protected int getIndent() {
				return typeFigure.getBounds().width + 4+4 + DrawUtils.SPACING +
						(childSize[1] != null ? indent(1) : 0);
			};
		}.withMinorAlignment(Alignment.CENTER)
				.withSpacing(DrawUtils.SPACING));

		typeFigure = new EntityFigure(new RowLayout()
				.withSpacing(2).withMargin(2, 4, 2, 0)) {

			protected void paintFigure(Graphics g) {
				super.paintFigure(g);

				g.setLineWidth(1);
				g.setForegroundColor(FigureConstants.blueColor);
				g.setBackgroundColor(FigureConstants.blueColor);

				Rectangle bounds = getBounds();
				Rectangle nodeBounds = bounds.getResized(-1, -1);
				nodeBounds.resize(-mainToggle.getBounds().width/2, 0);

				g.drawRoundRectangle(nodeBounds, 8, 8);
				int oldAlpha = g.getAlpha();
				g.setAlpha(60);
				g.fillRoundRectangle(nodeBounds, 8, 8);
				g.setAlpha(oldAlpha);
			}			
		};
		typeFigure.add(createTypeLabelFigure());
		typeFigure.add(mainToggle = createFoldingToggle(
				new EntityToggle(WholeImages.ROUND_EXPAND, WholeImages.ROUND_COLLAPSE), getChildrenPaneIndex()));

		EntityFigure trackingFigure = new EntityFigure(
				new MonoLayout().withMajorAlignment(Alignment.CENTER).withMargin(0,4,0,4)
				.withAutoresizeWeight(1f)).withViewportTracking(ViewportTracking.VERTICAL);
		trackingFigure.add(typeFigure);
		add(trackingFigure);
		add(createChildrenFigure());
	}

	protected int getChildrenPaneIndex() {
		return 1;
	}
	protected IEntityFigure createTypeLabelFigure() {
		return createContentPane(0);
	}
	protected IEntityFigure createChildrenFigure() {
		return createContentPane(getChildrenPaneIndex());
	}

	@Override
	protected ConnectionAnchor[] createSourceAnchors() {
		return new ConnectionAnchor[] {
			AnchorFactory.createRightMiddleAnchor(mainToggle)
		};
	}

	@Override
	protected ConnectionAnchor[] createTargetAnchors() {
		return new ConnectionAnchor[] {
			AnchorFactory.createLeftMiddleAnchor(typeFigure)
		};
	}

	@Override
	public void paintClientArea(Graphics graphics) {
		super.paintClientArea(graphics);
		paintConnections(graphics);
		graphics.restoreState();
	}

	@SuppressWarnings("unchecked")
	protected void paintConnections(Graphics g) {
		IFigure contentPane = getContentPane(getChildrenPaneIndex());
		if (contentPane.isVisible()) {
			//TODO test if needed
			if (contentPane.getChildren().isEmpty())
				return;

			ConnectionAnchor[] srcAnchors = getSourceAnchors();
			Point sourceLocation = srcAnchors[0].getLocation(null);

			List<Point> targetLocations = new ArrayList<>();
			for (IFigure targetFigure : (List<IFigure>) contentPane.getChildren()) {
				if (targetFigure instanceof INodeFigure) {
					INodeFigure targetNode = (INodeFigure) targetFigure;
					for (int i=0; i<targetNode.getTargetAnchorsSize(); i++) {
						Point t = targetNode.getTargetAnchor(i).getLocation(sourceLocation);
						translateToRelative(t);
						targetLocations.add(t);
					}
				} else {
					Point t = targetFigure.getBounds().getLeft();
					targetFigure.translateToAbsolute(t);
					translateToRelative(t);
					targetLocations.add(t);
				}
			}
			translateToRelative(sourceLocation);

			g.setForegroundColor(FigureConstants.relationsColor);
			DrawUtils.drawHorizontalTree(g, sourceLocation, DrawUtils.SPACING/2+2, targetLocations.toArray(new Point[targetLocations.size()]));
		}
	}
}
