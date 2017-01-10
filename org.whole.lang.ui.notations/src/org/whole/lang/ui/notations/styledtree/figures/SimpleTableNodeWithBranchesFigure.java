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

import org.eclipse.draw2d.ColorConstants;
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
import org.whole.lang.ui.figures.LabelFactory;
import org.whole.lang.ui.figures.NodeFigure;
import org.whole.lang.ui.figures.TableFigure;
import org.whole.lang.ui.figures.TableRowFigure;
import org.whole.lang.ui.layout.Alignment;
import org.whole.lang.ui.layout.ColumnLayout;
import org.whole.lang.ui.layout.MonoLayout;
import org.whole.lang.ui.layout.RowLayout;
import org.whole.lang.ui.layout.TableLayout;
import org.whole.lang.ui.layout.ViewportTracking;
import org.whole.lang.ui.notations.figures.DrawUtils;
import org.whole.lang.ui.notations.styledtree.styling.IEntityStyling;
import org.whole.lang.ui.notations.styledtree.styling.IFeatureStyling;

/**
 * @author Riccardo Solmi
 */
public class SimpleTableNodeWithBranchesFigure extends NodeFigure {
	protected IEntityFigure nodeFigure;
	protected IEntityFigure titleFigure;
	protected TableFigure tableFigure;
	protected IEntityFigure contentsFigure;
	protected Toggle[] featureToggles;
	protected IFeatureStyling[] featuresStyling;
	protected int typePaneShift;

	public SimpleTableNodeWithBranchesFigure(boolean isAdaptive, IEntityStyling entityStyling) {
		typePaneShift = isAdaptive ? 1 : 0;
		featuresStyling = entityStyling.getFeaturesStyling();

		initContentPanes(typePaneShift+featuresStyling.length);

		tableFigure = new TableFigure(new TableLayout(3).withColumnAlignment(0, Alignment.TRAILING)
				.withColumnSpacing(8).withMarginTop(2).withMarginBottom(2)) {
			protected void paintFigure(Graphics g) {
				super.paintFigure(g);

				Rectangle b = getBounds();
				if (entityStyling.getEmbeddedFeaturesSize() < featuresStyling.length)
					b = b.getResized(-WholeImages.ROUND_EXPAND.getBounds().width/2, 0);
				g.setClip(b);

				g.setBackgroundColor(ColorConstants.lightGray);
				drawColumnBackground(g, 0);

				g.setForegroundColor(FigureConstants.blueColor);
				drawHeadersRowSeparator(g);


				g.setForegroundColor(ColorConstants.lightGray);
				drawColumnSeparatorBefore(g, 1);
				int oldAlpha = g.getAlpha();
				g.setAlpha(80);
				drawRowSeparators(g);
				g.setAlpha(oldAlpha);
			}
		};

		if (isAdaptive) {
			titleFigure = createContentPane(0, ViewportTracking.HORIZONTAL);
			titleFigure.getLayoutManager().withMargin(2, 4, 2, 8);
		} else {
			titleFigure = new EntityFigure(new MonoLayout().withMargin(2, 4, 2, 8).withAutoresizeWeight(1.0f))
					.withViewportTracking(ViewportTracking.HORIZONTAL);
			titleFigure.add(LabelFactory.createDeclaration(entityStyling.getTypeLabel()));
		}

		nodeFigure = new EntityFigure(new ColumnLayout()
				.withMinorAlignment(Alignment.TRAILING)) {
			protected void paintFigure(Graphics g) {
				super.paintFigure(g);
				
				Rectangle b = getBounds();
				int gap = 0;
				if (entityStyling.getEmbeddedFeaturesSize() < featuresStyling.length)
					b = b.getResized(gap = -WholeImages.ROUND_EXPAND.getBounds().width/2, 0);

				int oldAlpha = g.getAlpha();
				g.setBackgroundColor(ColorConstants.lightGray);
				Rectangle bf = b.getResized(-tableFigure.getBounds().width -gap+2, -titleFigure.getBounds().height);
				bf.y += titleFigure.getBounds().height;
				if (bf.width > 1) {
					Rectangle oldClip = g.getClip(new Rectangle());
					g.setAlpha(60);
					g.setClip(bf);
					g.fillRoundRectangle(bf, 8, 8);
					g.setClip(oldClip);
					g.setAlpha(oldAlpha);
					g.setForegroundColor(FigureConstants.blueColor);
					g.drawLine(bf.x, bf.y, bf.right()-1, bf.y);
				}
				g.setForegroundColor(FigureConstants.blueColor);
				g.drawRoundRectangle(b.getResized(-1, -1), 8, 8);

//				int oldAlpha = g.getAlpha();
				g.setAlpha(60);

				Rectangle b2 = b.getCopy();
				b2.height = titleFigure.getBounds().height;
				g.setBackgroundColor(FigureConstants.blueColor);
				g.setClip(b2);
				g.fillRoundRectangle(b2.getResized(0, 4), 8, 8);

				g.setAlpha(oldAlpha);
			}
		};
		nodeFigure.add(titleFigure);
		nodeFigure.add(tableFigure);

		contentsFigure = new EntityFigure(new ColumnLayout().withSpacing(8).withMarginLeft(2));

		featureToggles = new Toggle[featuresStyling.length-entityStyling.getEmbeddedFeaturesSize()];
		for (int i=0, ti=0; i<featuresStyling.length; i++) {
			TableRowFigure row = new TableRowFigure();
			row.getLayoutManager().withMarginLeft(4);
			
			String name = featuresStyling[i].getName();
			if (name.matches("\\d+"))
				row.addContentLight(name);
			else
				row.addLabel(name);
			if (featuresStyling[i].isEmbedded()) {
				row.add(createContentPane(typePaneShift+i));
				row.addEmptyLabel();
			} else {
				if (entityStyling.getEmbeddedFeaturesSize() > 0)
					row.addEmptyLabel();
				row.add(featureToggles[ti++] = createFoldingToggle(new EntityToggle(WholeImages.ROUND_EXPAND, WholeImages.ROUND_COLLAPSE), typePaneShift+i));
				contentsFigure.add(createContentPane(typePaneShift+i));
			}
			tableFigure.add(row);
		}

		EntityFigure trackingFigure = new EntityFigure(new MonoLayout().withAutoresizeWeight(1f)).withViewportTracking(ViewportTracking.VERTICAL);
		trackingFigure.add(nodeFigure);
		add(trackingFigure);
		add(contentsFigure);

		setLayoutManager(new RowLayout().withMargin(2, 4, 2, 0).withSpacing(
				contentsFigure.getChildren().size()*4));
	}

	//TODO rename internal source anchors
	@Override
	protected ConnectionAnchor[] createSourceAnchors() {
		ConnectionAnchor[] connectionAnchors = new ConnectionAnchor[featureToggles.length];
		for(int i=0; i<featureToggles.length; i++)
			connectionAnchors[i] = AnchorFactory.createRightMiddleAnchor(featureToggles[i]);
		return connectionAnchors;
	}

	@Override
	protected ConnectionAnchor[] createTargetAnchors() {
		return new ConnectionAnchor[] {
			AnchorFactory.createLeftMiddleAnchor(nodeFigure)
		};
	}

	@Override
	public void paintClientArea(Graphics graphics) {
		super.paintClientArea(graphics);
		paintConnections(graphics);
		graphics.restoreState();
	}

	protected void paintConnections(Graphics g) {
		g.setForegroundColor(FigureConstants.relationsColor);

		int egdeXOffset = DrawUtils.SPACING - DrawUtils.EDGE_SPACING;
		ConnectionAnchor[] srcAnchors = getSourceAnchors();
		int i, j, pi=0;
		int prevYSourceLocation = Integer.MAX_VALUE;
		for (i=0, pi=0; i<srcAnchors.length; i++, pi++) {
			while (featuresStyling[pi].isEmbedded())
				pi++;

			IFigure contentPane = getContentPane(typePaneShift+pi);
			if (contentPane.isVisible()) {
				//TODO test if needed
				if (contentPane.getChildren().isEmpty())
					return;

				Point sourceLocation = srcAnchors[i].getLocation(null);

				int yMax = 0;
				IFigure targetFigure = (IFigure) contentPane.getChildren().get(0);
				List<Point> targetLocations = new ArrayList<>();
				if (targetFigure instanceof INodeFigure) {
					INodeFigure targetNode = (INodeFigure) targetFigure;
					for (int ti=0; ti<targetNode.getTargetAnchorsSize(); ti++) {
						Point t = targetNode.getTargetAnchor(ti).getLocation(sourceLocation);
						translateToRelative(t);
						targetLocations.add(t);
						yMax = Math.max(yMax, t.y);
					}
				} else {
					Point t = targetFigure.getBounds().getLeft();
					targetFigure.translateToAbsolute(t);
					translateToRelative(t);
					targetLocations.add(t);
					yMax = Math.max(yMax, t.y);
				}
				translateToRelative(sourceLocation);

				if (yMax > sourceLocation.y)
					break;
			
				if (prevYSourceLocation >= yMax - 1)
					egdeXOffset += DrawUtils.EDGE_SPACING;
				prevYSourceLocation = sourceLocation.y;
				
				DrawUtils.drawHorizontalTree(g, sourceLocation, egdeXOffset, targetLocations.toArray(new Point[targetLocations.size()]));
			}
		}

		egdeXOffset =  DrawUtils.SPACING - DrawUtils.EDGE_SPACING;
		prevYSourceLocation = Integer.MIN_VALUE;
		for (j=srcAnchors.length-1, pi=featuresStyling.length-1; j >= i; j--, pi--) {
			while (featuresStyling[pi].isEmbedded())
				pi--;

			IFigure contentPane = getContentPane(typePaneShift+pi);
			if (contentPane.isVisible()) {
				//TODO test if needed
				if (contentPane.getChildren().isEmpty())
					return;

				Point sourceLocation = srcAnchors[j].getLocation(null);

				int yMax = 0;
				IFigure targetFigure = (IFigure) contentPane.getChildren().get(0);
				List<Point> targetLocations = new ArrayList<>();
				if (targetFigure instanceof INodeFigure) {
					INodeFigure targetNode = (INodeFigure) targetFigure;
					for (int ti=0; ti<targetNode.getTargetAnchorsSize(); ti++) {
						Point t = targetNode.getTargetAnchor(ti).getLocation(sourceLocation);
						translateToRelative(t);
						targetLocations.add(t);
						yMax = Math.max(yMax, t.y);
					}
				} else {
					Point t = targetFigure.getBounds().getLeft();
					targetFigure.translateToAbsolute(t);
					translateToRelative(t);
					targetLocations.add(t);
					yMax = Math.max(yMax, t.y);
				}
				translateToRelative(sourceLocation);

				if (prevYSourceLocation <= yMax + 1)
					egdeXOffset += DrawUtils.EDGE_SPACING;
				prevYSourceLocation = sourceLocation.y;

				DrawUtils.drawHorizontalTree(g, sourceLocation, egdeXOffset, targetLocations.toArray(new Point[targetLocations.size()]));
			}
		}
	}
}
