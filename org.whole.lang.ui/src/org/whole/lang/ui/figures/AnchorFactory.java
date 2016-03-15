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

import org.eclipse.draw2d.AbstractConnectionAnchor;
import org.eclipse.draw2d.ChopboxAnchor;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.EllipseAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PrecisionPoint;
import org.eclipse.draw2d.geometry.Rectangle;

/**
 * @author Riccardo Solmi
 */
public class AnchorFactory {
	public static ConnectionAnchor createFixedAnchor(IFigure owner, int xOffset, int yOffset) {
		return new OffsetFixedAnchor(owner, xOffset, yOffset, true, true);
	}
	public static ConnectionAnchor createFixedAnchor(IFigure owner, double xPerc, double yPerc) {
		return new PercFixedAnchor(owner, xPerc, yPerc, true, true);
	}
	public static ConnectionAnchor createFixedAnchor(IFigure owner, int xOffset, int yOffset, boolean leftToRight, boolean topDown) {
		return new OffsetFixedAnchor(owner, xOffset, yOffset, leftToRight, topDown);
	}
	public static ConnectionAnchor createFixedAnchor(IFigure owner, double xPerc, double yPerc, boolean leftToRight, boolean topDown) {
		return new PercFixedAnchor(owner, xPerc, yPerc, leftToRight, topDown);
	}
	public static ConnectionAnchor createTopFixedAnchor(IFigure owner, int xOffset) {
		return new TopFixedAnchor(owner, xOffset);
	}
	public static ConnectionAnchor createTopFixedAnchor(IFigure owner, double xPerc) {
		return new TopPercFixedAnchor(owner, xPerc);
	}
	public static ConnectionAnchor createBottomFixedAnchor(IFigure owner, int xOffset) {
		return new BottomFixedAnchor(owner, xOffset);
	}
	public static ConnectionAnchor createLeftFixedAnchor(IFigure owner, int yOffset) {
		return null; //TODO
	}
	public static ConnectionAnchor createRightFixedAnchor(IFigure owner, int yOffset) {
		return null; //TODO
	}
	public static ConnectionAnchor createTopMiddleAnchor(IFigure owner) {
		return new TopFixedAnchor(owner, -1);
	}
	public static ConnectionAnchor createBottomMiddleAnchor(IFigure owner) {
		return new BottomFixedAnchor(owner, -1);
	}
	public static ConnectionAnchor createTopOrBottomMiddleAnchor(IFigure owner) {
		return new TopOrBottomMiddleAnchor(owner);
	}
	public static ConnectionAnchor createLeftMiddleAnchor(IFigure owner) {
		return new LeftMiddleAnchor(owner);
	}
	public static ConnectionAnchor createRightMiddleAnchor(IFigure owner) {
		return new RightMiddleAnchor(owner);
	}
	public static ConnectionAnchor createLeftOrRightMiddleAnchor(IFigure owner) {
		return new LeftOrRightMiddleAnchor(owner);
	}
	public static ConnectionAnchor createLeftOrRightBottomAnchor(IFigure owner) {
		return new LeftOrRightBottomAnchor(owner);
	}
	public static ConnectionAnchor createChopboxAnchor(IFigure owner) {
		return new ChopboxAnchor(owner);
	}
	public static ConnectionAnchor createEllipseAnchor(IFigure owner) {
		return new EllipseAnchor(owner);
	}

	public static class OffsetFixedAnchor extends AbstractConnectionAnchor {
		private int xOffset;
		private int yOffset;
		private boolean leftToRight;
		private boolean topDown;

		public OffsetFixedAnchor(IFigure owner, int xOffset, int yOffset, boolean leftToRight, boolean topDown) {
			super(owner);
			this.xOffset = xOffset;
			this.yOffset = yOffset;
			this.leftToRight = leftToRight;
			this.topDown = topDown;
		}

		public Point getLocation(Point reference) {
			Rectangle r = getOwner().getBounds();
			int x = leftToRight ? r.x + xOffset : r.right()-1 - xOffset;
			int y = topDown ? r.y + yOffset : r.bottom()-1 - yOffset;

			Point p = new PrecisionPoint(x, y);
			getOwner().translateToAbsolute(p);
			return p;
		}
		public Point getReferencePoint() {
			return getLocation(null);
		}
	}
	public static class PercFixedAnchor extends AbstractConnectionAnchor {
		private double xPerc;
		private double yPerc;
		private boolean leftToRight;
		private boolean topDown;

		public PercFixedAnchor(IFigure owner, double xPerc, double yPerc, boolean leftToRight, boolean topDown) {
			super(owner);
			this.xPerc = xPerc;
			this.yPerc = yPerc;
			this.leftToRight = leftToRight;
			this.topDown = topDown;
		}

		public Point getLocation(Point reference) {
			Rectangle r = getOwner().getBounds();
			double x = leftToRight ? r.x + r.width*xPerc : r.right()-1 - r.width*xPerc;
			double y = topDown ? r.y + r.height*yPerc : r.bottom()-1 - r.height*yPerc;

			Point p = new PrecisionPoint(x, y);
			getOwner().translateToAbsolute(p);
			return p;
		}
		public Point getReferencePoint() {
			return getLocation(null);
		}
	}

	public static class TopPercFixedAnchor extends AbstractConnectionAnchor {
		private double perc;

		public TopPercFixedAnchor(IFigure owner, double perc) {
			super(owner);
			this.perc = perc;
		}

		public Point getLocation(Point reference) {
			Rectangle r = getOwner().getBounds().getCopy();
			getOwner().translateToAbsolute(r);
			int off = (int) perc*r.width;
			if (r.contains(reference) || r.y < reference.y)
				return r.getBottomLeft().translate(off, -1);
			else
				return r.getTopLeft().translate(off, 0);
		}
	}
	public static class TopFixedAnchor extends AbstractConnectionAnchor {
		private int offset;

		public TopFixedAnchor(IFigure owner, int offset) {
			super(owner);
			this.offset = offset;
		}

		public Point getLocation(Point reference) {
			Rectangle r = getOwner().getBounds().getCopy();
			getOwner().translateToAbsolute(r);
			int off = offset;
			if (off == -1)
				off = r.width / 2;
//			if (r.contains(reference) || r.y < reference.y)
//				return r.getBottomLeft().translate(off, -1);
//			else
				return r.getTopLeft().translate(off, 0);
		}
	}

	public static class BottomFixedAnchor extends AbstractConnectionAnchor {
		private int offset;

		public BottomFixedAnchor(IFigure owner, int offset) {
			super(owner);
			this.offset = offset;
		}

		public Point getLocation(Point reference) {
			Rectangle r = getOwner().getBounds().getCopy();
			getOwner().translateToAbsolute(r);
			int off = offset;
			if (off == -1)
				off = r.width / 2;
//			if (r.contains(reference) || r.bottom() > reference.y)
//				return r.getTopLeft().translate(off, 0);
//			else
				return r.getBottomLeft().translate(off, -1);
		}
	}

	public static class TopOrBottomMiddleAnchor extends ChopboxAnchor {
		public TopOrBottomMiddleAnchor(IFigure owner) {
			super(owner);
		}

		public Point getLocation(Point reference) {
			Point p = getOwner().getBounds().getCenter();
			getOwner().translateToAbsolute(p);
			if (reference.y < p.y)
				p = getOwner().getBounds().getTop();
			else
				p = getOwner().getBounds().getBottom();
			getOwner().translateToAbsolute(p);
			return p;
		}
	}

	public static class LeftOrRightMiddleAnchor extends ChopboxAnchor {
		public LeftOrRightMiddleAnchor(IFigure owner) {
			super(owner);
		}

		public Point getLocation(Point reference) {
			Point p = getOwner().getBounds().getCenter();
			getOwner().translateToAbsolute(p);
			if (reference.x < p.x)
				p = getOwner().getBounds().getLeft();
			else
				p = getOwner().getBounds().getRight();
			getOwner().translateToAbsolute(p);
			return p;
		}
	}

	public static class LeftOrRightBottomAnchor extends ChopboxAnchor {
		public LeftOrRightBottomAnchor(IFigure owner) {
			super(owner);
		}

		public Point getLocation(Point reference) {
			Point p = getOwner().getBounds().getCenter();
			getOwner().translateToAbsolute(p);
			if (reference.x < p.x)
				p = getOwner().getBounds().getBottomLeft();
			else
				p = getOwner().getBounds().getBottomRight();
			getOwner().translateToAbsolute(p);
			return p;
		}
	}

	public static class LeftMiddleAnchor extends ChopboxAnchor {
		public LeftMiddleAnchor(IFigure owner) {
			super(owner);
		}

		public Point getLocation(Point reference) {
			Point p = getOwner().getBounds().getLeft();
			getOwner().translateToAbsolute(p);
			return p;
		}
	}

	public static class RightMiddleAnchor extends ChopboxAnchor {
		public RightMiddleAnchor(IFigure owner) {
			super(owner);
		}

		public Point getLocation(Point reference) {
			Point p = getOwner().getBounds().getRight();
			getOwner().translateToAbsolute(p);
			return p;
		}
	}
}
