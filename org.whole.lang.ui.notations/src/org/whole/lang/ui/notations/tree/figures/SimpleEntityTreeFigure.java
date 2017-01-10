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
package org.whole.lang.ui.notations.tree.figures;

import java.util.List;

import org.eclipse.draw2d.ActionListener;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.Toggle;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.graphics.Color;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.ui.WholeImages;
import org.whole.lang.ui.editparts.IVisibilityManager;
import org.whole.lang.ui.figures.AnchorFactory;
import org.whole.lang.ui.figures.EntityButton;
import org.whole.lang.ui.figures.EntityFigure;
import org.whole.lang.ui.figures.EntityLabel;
import org.whole.lang.ui.figures.EntityToggle;
import org.whole.lang.ui.figures.FigureConstants;
import org.whole.lang.ui.figures.INodeFigure;
import org.whole.lang.ui.figures.NodeFigure;
import org.whole.lang.ui.layout.Alignment;
import org.whole.lang.ui.layout.ColumnLayout;
import org.whole.lang.ui.layout.ICompositeEntityLayout;
import org.whole.lang.ui.layout.MonoLayout;
import org.whole.lang.ui.layout.RoundedTitleTabLayout;
import org.whole.lang.ui.layout.RowLayout;
import org.whole.lang.ui.layout.ViewportTracking;
import org.whole.lang.ui.notations.figures.DrawUtils;

public class SimpleEntityTreeFigure extends NodeFigure {
	protected boolean isRightToLeft;
	protected IFigure contents;
	protected IFigure features;
	protected Toggle mainToggle; // used by createTargetAnchors
	protected Toggle[] featureToggles; // used by createSourceAnchors
	protected IVisibilityManager visibilityManager;

	public SimpleEntityTreeFigure(EntityDescriptor<?> ed, boolean isRightToLeft, IVisibilityManager visibilityManager, ActionListener linkListener) {
		this.isRightToLeft = isRightToLeft;
		int featureNum = ed.childFeatureSize();
		initContentPanes(featureNum);
		this.visibilityManager = visibilityManager;

		setLayoutManager(new RowLayout().withMinorAlignment(Alignment.CENTER)
				.withSpacing(DrawUtils.SPACING + DrawUtils.EDGE_SPACING * featureNum)
				.withReversedChildren(isRightToLeft()));

		mainToggle = createFoldingToggle(new EntityToggle(WholeImages.ROUND_EXPAND, WholeImages.ROUND_COLLAPSE), featureNum);
		
		IFigure outline = new EntityFigure(new RoundedTitleTabLayout().withRightToLeft(isRightToLeft())) {
			@Override
			protected void paintFigure(Graphics graphics) {
				super.paintFigure(graphics);

				Rectangle bounds = getBounds();
				Rectangle labelBounds = ((IFigure) getChildren().get(0)).getBounds();
				int labelHeight = labelBounds.height;
				final int LINE_WIDTH = 1;
				Insets shrink = new Insets(0, 4, 0, 4);
				Color borderColor = FigureConstants.blueColor;

				Rectangle tempRect = new Rectangle();
				tempRect.setBounds(bounds);
				tempRect.resize(-1, -labelHeight -1);
				tempRect.translate(shrink.left, labelHeight + shrink.top);
				tempRect.resize(-shrink.left -shrink.right, -shrink.top -shrink.bottom);
				graphics.setLineWidth(1);
				graphics.setForegroundColor(borderColor);
				graphics.setBackgroundColor(ColorConstants.lightGray);

				// part of the round border outside the tab
				int titleWidth = labelBounds.width;// + labelHeight +1;
				Rectangle rect = tempRect.getResized(-titleWidth, 0);
				graphics.setClip(rect.translate(titleWidth, 0).expand(LINE_WIDTH, LINE_WIDTH));
				graphics.drawRoundRectangle(tempRect, 8, 8);
				
				// part of the round border under the tab
				rect = tempRect.getCopy();
				rect.width = titleWidth;
				rect.height = 8;
				graphics.setClip(rect);
				graphics.drawRectangle(tempRect);
				rect.height = tempRect.height-8;
				graphics.setClip(rect.translate(0, 8).expand(LINE_WIDTH, LINE_WIDTH));
				graphics.drawRoundRectangle(tempRect, 8, 8);

				// draw tab
				tempRect.setBounds(bounds);
				tempRect.setSize(labelBounds.getSize());
				tempRect.resize(1, 0);//labelHeight + shrink.top);
				tempRect.translate(shrink.left, 0);
				graphics.setForegroundColor(borderColor);
				graphics.setBackgroundColor(borderColor);
				graphics.setClip(tempRect);
				graphics.drawRoundRectangle(tempRect.getResized(-1,+4), 8, 8);
				int oldAlpha = graphics.getAlpha();
				graphics.setAlpha(60);
				graphics.fillRoundRectangle(tempRect.getResized(0,+4), 8, 8);
				graphics.setAlpha(oldAlpha);
			}
		};

		EntityFigure outlineHeader = new EntityFigure(new RowLayout().withMargin(0,2,0,7));
		outlineHeader.addDeclaration(ed.getName());
		outlineHeader.add(createVisibilityToggle(featureNum+1));

		outline.add(outlineHeader);
		outline.add(mainToggle);
		outline.add(features = createFeaturesOutline(ed, linkListener));			

		contents = new EntityFigure(new ColumnLayout().withSpacing(3)
				.withMinorAlignment(isRightToLeft() ? Alignment.TRAILING : Alignment.LEADING)) {
			@SuppressWarnings("unchecked")
			@Override
			public boolean isVisible() {
				List<IFigure> children = getChildren();
				// (contents figure visible iff all children visible)
				boolean hasChildrenVisible = false;
				for (IFigure child : children)
					hasChildrenVisible |= child.isVisible();
				return super.isVisible() && hasChildrenVisible;
			}
		};
		for(int i=0; i<featureNum; i++)
			contents.add(createContentPane(i));

		EntityFigure trackingFigure = new EntityFigure(new MonoLayout().withMajorAlignment(Alignment.CENTER).withAutoresizeWeight(1f)).withViewportTracking(ViewportTracking.VERTICAL);
		trackingFigure.add(outline);
		add(trackingFigure);
		add(contents);

		initVisibilityToggle();
	}


	private int visibilityTag;
	protected int getVisibilityTag() {
		return visibilityTag;
	}
	protected Toggle createVisibilityToggle(int tag) {
		return createFoldingToggle(
				new EntityToggle(WholeImages.ARROW_COLLAPSE, WholeImages.ARROW_EXPAND), visibilityTag = tag);
	}
	protected void initVisibilityToggle() {
		if (visibilityManager!=null && visibilityManager.isChildrenVisibilityInitiallyEnabled())
			clickFoldingToggle(toggleIndexOf(getVisibilityTag()));
	}
	public void setContentPaneVisible(int paneIndex, boolean visible) {
		((IFigure) features.getChildren().get(paneIndex)).setVisible(visible);
		if (((IFigure) getContentPaneContainer().getChildren().get(paneIndex)).isVisible() ^ visible)
			clickFoldingToggle(toggleIndexOf(paneIndex));
	}
	protected IFigure getContentPaneContainer() {
		return contents;
	}

	@Override
	public List<Toggle> getFoldingToggles(IFigure figure) {
		List<Toggle> toggles = super.getFoldingToggles(figure);
		toggles.add(getFoldingToggle(0));

		int paneIndex = ancestorOrSelfContentPaneIndexOf(figure);
		if (paneIndex > 0 && !visibilityManager.isChildVisible(paneIndex))
			toggles.add(getFoldingToggle(1));

		return toggles;
	}

	@Override
	protected void toggleVisibility(int paneIndex) {
		if (paneIndex == getVisibilityTag()) {
			int visibleSize = contentPanes.length;
			if (getFoldingToggle(1).isSelected())
				for (int i=0, size=contentPanes.length; i<size; i++) {
					boolean childVisible = visibilityManager.isChildVisible(i);
					if (!childVisible)
						visibleSize--;
					setContentPaneVisible(i, childVisible);
				}
			else
				for (int i=0, size=contentPanes.length; i<size; i++) 
					setContentPaneVisible(i, true);

			((ICompositeEntityLayout) getLayoutManager()).withSpacing(DrawUtils.SPACING + DrawUtils.EDGE_SPACING * visibleSize);
		} else if (paneIndex == getContentPanesSize()) {
			boolean visible = getFeaturesFigure().isVisible();
			getContentsFigure().setVisible(!visible);
			getFeaturesFigure().setVisible(!visible);			
		} else
			super.toggleVisibility(paneIndex);
	}


	protected IFigure createFeaturesOutline(EntityDescriptor<?> ed, ActionListener linkListener) {
		int featureNum = ed.childFeatureSize();
		IFigure featuresOutline = new EntityFigure(new ColumnLayout()
				.withAutoresizeWeight(1.0f).withMarginBottom(2)
				.withMinorAlignment(isRightToLeft() ? Alignment.LEADING : Alignment.TRAILING));

		featureToggles = new Toggle[featureNum];
		for(int i=0; i<featureNum; i++) {
			FeatureDescriptor fd = ed.getEntityFeatureDescriptor(i);
			EntityFigure feature = new EntityFigure(new RowLayout().withSpacing(3)
					.withMajorAlignment(isRightToLeft() ? Alignment.LEADING : Alignment.TRAILING)
					.withReversedChildren(isRightToLeft()));
			
			feature.addLabel(fd.getName());

			featureToggles[i] = createFoldingToggle(new EntityToggle(WholeImages.ROUND_EXPAND, WholeImages.ROUND_COLLAPSE), i);
			feature.add(featureToggles[i]);
			featuresOutline.add(feature);
		}
		for (int i=featureNum, size=ed.featureSize(); i<size; i++) {
			FeatureDescriptor fd = ed.getEntityFeatureDescriptor(i);
			EntityFigure feature = new EntityFigure(new RowLayout()
					.withMarginLeft(3).withMarginRight(3)
					.withMajorAlignment(isRightToLeft() ? Alignment.LEADING : Alignment.TRAILING)
					.withReversedChildren(isRightToLeft()));
			EntityLabel createLabel = feature.addLabel(fd.getName(), WholeImages.LINK);
			createLabel.setTextPlacement(isRightToLeft() ? PositionConstants.EAST : PositionConstants.WEST);
			createLabel.setBorder(new MarginBorder(3));
			
			feature.add(new EntityButton(createLabel, linkListener, i));
			featuresOutline.add(feature);
		}

		return featuresOutline;
	}

	public IFigure getContentsFigure() {
		return contents;
	}

	public IFigure getFeaturesFigure() {
		return features;
	}

	@Override
	protected ConnectionAnchor[] createSourceAnchors() {
		ConnectionAnchor[] connectionAnchors = new ConnectionAnchor[featureToggles.length];
		for(int i=0; i<featureToggles.length; i++)
			connectionAnchors[i] = AnchorFactory.createFixedAnchor(featureToggles[i], 
					isRightToLeft() ? 0 : 1.0, 0.5);
		return connectionAnchors;
	}

	@Override
	protected ConnectionAnchor[] createTargetAnchors() {
		return new ConnectionAnchor[] {
			AnchorFactory.createFixedAnchor(mainToggle, isRightToLeft() ? 1.0 : 0, 0.5)
		};
	}

	@Override
	public void paintClientArea(Graphics graphics) {
		super.paintClientArea(graphics);
		paintConnections(graphics);
		graphics.restoreState();
	}

	protected void paintConnections(Graphics graphics) {
		if (contents.isVisible()) {
			graphics.setForegroundColor(FigureConstants.relationsColor);

			int egdeXOffset = DrawUtils.SPACING - DrawUtils.EDGE_SPACING;
			ConnectionAnchor[] srcAnchors = getSourceAnchors();
			int i;
			int prevYSourceLocation = Integer.MAX_VALUE;
			for (i = 0; i < srcAnchors.length; i++) {
				IFigure contentPane = getContentPane(i);
				if (contentPane.isVisible()) {
					IFigure targetFigure = (IFigure) contentPane.getChildren().get(0);
					Point sourceLocation = srcAnchors[i].getLocation(null);
					Point targetLocation = null;
					if (targetFigure instanceof INodeFigure)
						targetLocation = ((INodeFigure) targetFigure).getTargetAnchor(0).getLocation(null);
					else {
						targetLocation = isRightToLeft() ? targetFigure.getBounds().getRight() :
							targetFigure.getBounds().getLeft();
						targetFigure.translateToAbsolute(targetLocation);
					}
					translateToRelative(targetLocation);
					translateToRelative(sourceLocation);
					if (targetLocation.y > sourceLocation.y)
						break;
					
					if (prevYSourceLocation >= targetLocation.y - 1)
						egdeXOffset += DrawUtils.EDGE_SPACING;
					prevYSourceLocation = sourceLocation.y;
					
					DrawUtils.drawHorizontalEdge(graphics, sourceLocation, targetLocation, egdeXOffset);
				}
			}
			egdeXOffset =  DrawUtils.SPACING - DrawUtils.EDGE_SPACING;
			prevYSourceLocation = Integer.MIN_VALUE;
			for (int j = srcAnchors.length-1; j >= i; j--) {
				IFigure contentPane = getContentPane(j);
				if (contentPane.isVisible()) {
					IFigure targetFigure = (IFigure) contentPane.getChildren().get(0);
					Point sourceLocation = srcAnchors[j].getLocation(null);
					Point targetLocation = null;
					if (targetFigure instanceof INodeFigure)
						targetLocation = ((INodeFigure) targetFigure).getTargetAnchor(0).getLocation(null);
					else {
						targetLocation = isRightToLeft() ? targetFigure.getBounds().getRight() :
							targetFigure.getBounds().getLeft();
						targetFigure.translateToAbsolute(targetLocation);
					}
					translateToRelative(targetLocation);
					translateToRelative(sourceLocation);

					if (prevYSourceLocation <= targetLocation.y + 1)
						egdeXOffset +=  DrawUtils.EDGE_SPACING;
					prevYSourceLocation = sourceLocation.y;

					DrawUtils.drawHorizontalEdge(graphics, sourceLocation, targetLocation, egdeXOffset);
				}
			}
		}
	}

	public boolean isRightToLeft() {
		return isRightToLeft;
	}
}
