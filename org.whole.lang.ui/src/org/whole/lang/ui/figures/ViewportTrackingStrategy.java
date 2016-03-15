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
package org.whole.lang.ui.figures;

import java.util.List;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LayeredPane;
import org.eclipse.draw2d.ScalableFigure;
import org.eclipse.draw2d.Viewport;
import org.eclipse.draw2d.ViewportUtilities;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.LayerConstants;
import org.whole.lang.ui.layout.ViewportTracking;
import org.whole.lang.util.CompositeUtils;

/**
 * @author Enrico Persiani
 */
public class ViewportTrackingStrategy implements IViewportTrackingStrategy {
	protected IEntityFigure hostFigure;
	protected ViewportTracking viewportTracking;
	protected int ascent;
	protected int indent;

	public ViewportTrackingStrategy(IEntityFigure hostFigure) {
		this(hostFigure, ViewportTracking.BOTH);
	}
	public ViewportTrackingStrategy(IEntityFigure hostFigure, ViewportTracking viewportTracking) {
		this.hostFigure = hostFigure;
		this.viewportTracking = viewportTracking;
	}

	public int getIndent() {
		return indent;
	}
	public void setIndent(int indent) {
		this.indent = indent;
	}
	public int getAscent() {
		return ascent;
	}
	public void setAscent(int ascent) {
		this.ascent = ascent;
	}

	protected Viewport viewport;
	protected Viewport getViewport() {
		if (viewport == null)
			viewport = ViewportUtilities.getNearestEnclosingViewport(hostFigure);
		return viewport;
	}

	protected Rectangle[] childrenBounds;
	protected Rectangle compositeBounds = null;
	@Override
	public void onInvalidate() {
		if (childrenBounds == null)
			childrenBounds = new Rectangle[0];
		else if (compositeBounds != null) {
			@SuppressWarnings("unchecked")
			List<IFigure> children = hostFigure.getChildren();
			for (int i = 0; i < childrenBounds.length; i++) {
				Rectangle.SINGLETON.setBounds(childrenBounds[i]);
				Rectangle.SINGLETON.translate(hostFigure.getBounds().x, hostFigure.getBounds().y);
				children.get(i).setBounds(Rectangle.SINGLETON);
			}
		}

		int size = hostFigure.getChildren().size();
		if (childrenBounds.length != size)
			childrenBounds = CompositeUtils.resize(childrenBounds, size, () -> new Rectangle());
		compositeBounds = null;
	}

	@Override
	public void onPaintChildren(Graphics graphics) {
		if (hostFigure.getChildren().isEmpty())
			return;

		Point amount = calculateTranslateAmount();
		@SuppressWarnings("unchecked")
		List<IFigure> children = hostFigure.getChildren();
		for (int i = 0; i < childrenBounds.length; i++) {
			Rectangle.SINGLETON.setBounds(childrenBounds[i]);
			Rectangle.SINGLETON.translate(amount);
			Rectangle.SINGLETON.translate(hostFigure.getBounds().x, hostFigure.getBounds().y);
			children.get(i).setBounds(Rectangle.SINGLETON);
		}
		getViewport().validate();
	}

	protected Point translateAmount = new Point();
	@SuppressWarnings("unchecked")
	protected Point calculateTranslateAmount() {
		translateAmount.setLocation(0, 0);
		
		if (childrenBounds.length == 0)
			return translateAmount;

		Viewport viewport = getViewport();
		LayeredPane layeredPane = (LayeredPane) viewport.getContents();
		ScalableFigure scalableLayeredPane = (ScalableFigure) layeredPane.getLayer(LayerConstants.SCALABLE_LAYERS);
		Rectangle clientArea = viewport.getClientArea().scale(1/scalableLayeredPane.getScale());

		Rectangle bounds = hostFigure.getBounds();
		if (!bounds.intersects(clientArea))
			return translateAmount;

		if (compositeBounds == null) {
			List<IFigure> children = hostFigure.getChildren();
			compositeBounds = new Rectangle(children.get(0).getBounds());
			compositeBounds.translate(-bounds.x, -bounds.y);
			for (int i = 0; i < childrenBounds.length; i++) {
				childrenBounds[i].setBounds(children.get(i).getBounds());
				childrenBounds[i].translate(-bounds.x, -bounds.y);
				compositeBounds.union(childrenBounds[i]);
			}
		}

		Rectangle compositeBounds = Rectangle.SINGLETON.setBounds(this.compositeBounds);
		compositeBounds.translate(hostFigure.getBounds().x, hostFigure.getBounds().y);
		int minDX = bounds.x - compositeBounds.x;
		int minDY = bounds.y - compositeBounds.y;
		int maxDX = bounds.right() - compositeBounds.right();
		int maxDY = bounds.bottom() - compositeBounds.bottom();

		if (clientArea.height < compositeBounds.height &&
				clientArea.width < compositeBounds.width)
			return translateAmount;

		if (viewportTracking.isHorizontal())
			translateAmount.setX(Math.max(minDX, Math.min(maxDX, clientArea.x > compositeBounds.x ? 
					clientArea.x - compositeBounds.x : (compositeBounds.right() > clientArea.right() ?
							clientArea.right() - compositeBounds.right() : 0))));

		if (viewportTracking.isVertical())
			translateAmount.setY(Math.max(minDY, Math.min(maxDY, clientArea.y > compositeBounds.y ? 
					clientArea.y - compositeBounds.y : (compositeBounds.bottom() > clientArea.bottom() ?
							clientArea.bottom() - compositeBounds.bottom() : 0))));

		return translateAmount;
	}
}
