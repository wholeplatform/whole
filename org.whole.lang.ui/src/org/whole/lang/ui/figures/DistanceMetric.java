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

import org.eclipse.draw2d.geometry.Point;

/**
 * @author Riccardo Solmi
 */
public enum DistanceMetric {
	Orizontal() {
		public long calculate(Point p1, Point p2) {
			return Math.abs(p1.x - p2.x);
		}
	},
	Vertical() {
		public long calculate(Point p1, Point p2) {
			return Math.abs(p1.y - p2.y);
		}
	},
	Orthogonal() {
		public long calculate(Point p1, Point p2) {
			return p1.getDistanceOrthogonal(p2);
		}
	},
	Diagonal() {
		public long calculate(Point p1, Point p2) {
			return (long) p1.getDistance(p2);
		}
	},
	Diagonal2() {
		public long calculate(Point p1, Point p2) {
			return p1.getDistance2(p2);
		}
	};
	
	public abstract long calculate(Point p1, Point p2);
}