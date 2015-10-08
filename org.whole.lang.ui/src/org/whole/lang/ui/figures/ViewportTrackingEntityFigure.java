/**
 * Copyright 2004-2015 Riccardo Solmi. All rights reserved.
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
import org.eclipse.draw2d.LayoutManager;
import org.eclipse.draw2d.Viewport;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.whole.lang.util.CompositeUtils;

/**
 * @author Enrico Persiani
 */
public class ViewportTrackingEntityFigure extends EntityFigure {
	protected boolean trackHorizontally;
	protected boolean trackVertically;

	public ViewportTrackingEntityFigure() {
		this(true, true);
	}
	public ViewportTrackingEntityFigure(boolean trackHorizontally, boolean trackVertically) {
		this.trackHorizontally = trackHorizontally;
		this.trackVertically = trackVertically;
	}
	public ViewportTrackingEntityFigure(LayoutManager layout) {
		this(layout, true, true);
	}
	public ViewportTrackingEntityFigure(LayoutManager layout, boolean trackHorizontally, boolean trackVertically) {
		super(layout);
		this.trackHorizontally = trackHorizontally;
		this.trackVertically = trackVertically;
	}

	protected Viewport viewport;
	public Viewport getViewport() {
		IFigure parent = getParent();
		while (viewport == null && parent != null) {
			if (parent instanceof Viewport)
				viewport = (Viewport) parent;
			else
				parent = parent.getParent();
		}
		return viewport;
	}

	protected Rectangle[] childrenBounds;
	protected Rectangle compositeBounds = null;
	@Override
	public void invalidate() {
		if (childrenBounds == null)
			childrenBounds = new Rectangle[0];
		
		int size = getChildren().size();
		if (childrenBounds.length != size)
			childrenBounds = CompositeUtils.resize(childrenBounds, size, () -> new Rectangle());
		compositeBounds = null;

		super.invalidate();
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void paintChildren(Graphics graphics) {
		if (getChildren().isEmpty())
			return;

		Point amount = calculateTranslateAmount();
		List<IFigure> children = getChildren();
		for (int i = 0; i < childrenBounds.length; i++) {
			Rectangle.SINGLETON.setBounds(childrenBounds[i]);
			Rectangle.SINGLETON.translate(amount);
			children.get(i).setBounds(Rectangle.SINGLETON);
		}
		getViewport().validate();
		super.paintChildren(graphics);
	}

	protected Point translateAmount = new Point();
	@SuppressWarnings("unchecked")
	protected Point calculateTranslateAmount() {
		translateAmount.setLocation(0, 0);
		
		if (childrenBounds.length == 0)
			return translateAmount;

		Viewport viewport = getViewport();
		Rectangle clientArea = viewport.getClientArea();

		Rectangle bounds = getBounds();
		if (!bounds.intersects(clientArea))
			return translateAmount;

		if (compositeBounds == null) {
			List<IFigure> children = getChildren();
			compositeBounds = new Rectangle(children.get(0).getBounds());
			for (int i = 0; i < childrenBounds.length; i++) {
				childrenBounds[i].setBounds(children.get(i).getBounds());
				compositeBounds.union(childrenBounds[i]);
			}
		}

		int minDX = bounds.x - compositeBounds.x;
		int minDY = bounds.y - compositeBounds.y;
		int maxDX = bounds.right() - compositeBounds.right();
		int maxDY = bounds.bottom() - compositeBounds.bottom();

		if (clientArea.height < compositeBounds.height &&
				clientArea.width < compositeBounds.width)
			return translateAmount;

		if (trackHorizontally)
			translateAmount.setX(Math.max(minDX, Math.min(maxDX, clientArea.x > compositeBounds.x ? 
					clientArea.x - compositeBounds.x : (compositeBounds.right() > clientArea.right() ?
							clientArea.right() - compositeBounds.right() : 0))));

		if (trackVertically)
			translateAmount.setY(Math.max(minDY, Math.min(maxDY, clientArea.y > compositeBounds.y ? 
					clientArea.y - compositeBounds.y : (compositeBounds.bottom() > clientArea.bottom() ?
							clientArea.bottom() - compositeBounds.bottom() : 0))));

		return translateAmount;
	}
}
