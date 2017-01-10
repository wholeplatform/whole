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

import org.eclipse.draw2d.Ellipse;
import org.eclipse.draw2d.PolygonDecoration;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;

/**
 * @author Riccardo Solmi
 */
public class ArrowFactory {
	public static enum Direction {
		NORTH(-Math.PI/2), WEST(Math.PI), SOUTH(Math.PI/2), EAST(0);
	
		private double rotation;
		Direction(double rotation) {
			this.rotation = rotation;
		}
		
		public double getRotation() {
			return rotation;
		}
	};
	public static enum ArrowKind {
		NONE(ArrowFactory.NONE_TIP), BAR(ArrowFactory.BAR_TIP),
		TRIANGLE(PolygonDecoration.TRIANGLE_TIP), INVERTED_TRIANGLE(PolygonDecoration.INVERTED_TRIANGLE_TIP),
		TRIANGLE_TO_BAR(TRIANGLE_TO_BAR_TIP), OPEN_TRIANGLE(OPEN_TRIANGLE_TIP),
		RECTANGLE(ArrowFactory.RECTANGLE_TIP), RHOMB(ArrowFactory.RHOMB_TIP), ELLIPSE(null);
		
		private PointList pointlist;
		ArrowKind(PointList pointlist) {
			this.pointlist = pointlist;
		}

		public PointList getPointlist() {
			return pointlist;
		}
	};
	public static final int DEFAULT_BASE = 6, DEFAULT_HEIGHT = 4;
	private ArrowFactory(){}

	public static Shape createArrow(Direction direction, ArrowKind kind, boolean filled) {
		return createArrow(direction, kind, filled, DEFAULT_BASE, DEFAULT_HEIGHT);
	}

	public static Shape createArrow(Direction direction, ArrowKind kind, boolean filled, int base, int height) {
		if (kind.equals(ArrowKind.ELLIPSE)) {
			Ellipse e = new Ellipse();
			e.setFill(filled);
			e.setOutline(true);
			e.setSize(base, height);
			return e;
		}

		PolygonDecoration p = new PolygonDecoration();
		p.setTemplate(kind.getPointlist());
		p.setScale(base, height);
		p.setRotation(direction.getRotation());
		p.setFill(filled);
		p.setOutline(true);
		return p;
	}

	public static Shape createSouthArrow(Point headLocation) {
		Shape s = createArrow(Direction.SOUTH, ArrowKind.TRIANGLE, true);
		s.setLocation(headLocation);
		s.setBackgroundColor(FigureConstants.relationsColor);
		return s;
	}
	public static Shape createNorthArrow(Point headLocation) {
		Shape s = createArrow(Direction.NORTH, ArrowKind.TRIANGLE, true);
		s.setLocation(headLocation);
		s.setBackgroundColor(FigureConstants.relationsColor);
		return s;
	}
	public static Shape createEastArrow(Point headLocation) {
		Shape s = createArrow(Direction.EAST, ArrowKind.TRIANGLE, true);
		s.setLocation(headLocation);
		s.setBackgroundColor(FigureConstants.relationsColor);
		return s;
	}
	public static Shape createWestArrow(Point headLocation) {
		Shape s = createArrow(Direction.WEST, ArrowKind.TRIANGLE, true);
		s.setLocation(headLocation);
		s.setBackgroundColor(FigureConstants.relationsColor);
		return s;
	}

	public static final PointList NONE_TIP = new PointList();
	public static final PointList BAR_TIP = new PointList();
	public static final PointList RHOMB_TIP = new PointList();
	public static final PointList RECTANGLE_TIP = new PointList();
	public static final PointList TRIANGLE_TO_BAR_TIP = new PointList();
	public static final PointList OPEN_TRIANGLE_TIP = new PointList();
	static {
		NONE_TIP.addPoint(0,0);
		NONE_TIP.addPoint(-1,0);

		BAR_TIP.addPoint(0,0);
		BAR_TIP.addPoint(-1,0);
		BAR_TIP.addPoint(0,0);
		BAR_TIP.addPoint(0,-1);
		BAR_TIP.addPoint(0,1);

		RHOMB_TIP.addPoint(-1, 1);
		RHOMB_TIP.addPoint(0, 0);
		RHOMB_TIP.addPoint(-1, -1);
		RHOMB_TIP.addPoint(-2, 0);

		RECTANGLE_TIP.addPoint(0, 1);
		RECTANGLE_TIP.addPoint(-1, 1);
		RECTANGLE_TIP.addPoint(-1, -1);
		RECTANGLE_TIP.addPoint(0, -1);
		
		TRIANGLE_TO_BAR_TIP.addPoint(0, -1);
		TRIANGLE_TO_BAR_TIP.addPoint(0, 0);
		TRIANGLE_TO_BAR_TIP.addPoint(-1, 1);
		TRIANGLE_TO_BAR_TIP.addPoint(-1, -1);
		TRIANGLE_TO_BAR_TIP.addPoint(0, 0);
		TRIANGLE_TO_BAR_TIP.addPoint(0, 1);

		OPEN_TRIANGLE_TIP.addPoint(0,0);
		OPEN_TRIANGLE_TIP.addPoint(-1, 0);
		OPEN_TRIANGLE_TIP.addPoint(0, 0);
		OPEN_TRIANGLE_TIP.addPoint(-1, -1);
		OPEN_TRIANGLE_TIP.addPoint(0, 0);
		OPEN_TRIANGLE_TIP.addPoint(-1, 1);
	}
}
