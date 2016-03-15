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
package org.whole.lang.ui.layout;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;

/**
 * @author Riccardo Solmi
 */
public class BaselinedDimension extends Dimension {
	private static final long serialVersionUID = 1;
	public static final BaselinedDimension SINGLETON = new BaselinedDimension();

	public int indent;
	public int ascent;
	public boolean hintsSensitive;

	public BaselinedDimension() {
		super();
	}
	public BaselinedDimension(Dimension d) {
		super(d);
		if (d instanceof BaselinedDimension) {
			BaselinedDimension bd = (BaselinedDimension) d;
			this.indent = bd.indent;
			this.ascent = bd.ascent;
			this.hintsSensitive = bd.hintsSensitive;
		}
	}
	public BaselinedDimension(int width, int height) {
		super(width, height);
	}
	public BaselinedDimension(Dimension dimension, int indent, int ascent, boolean hintsSensitive) {
		super(dimension);
		this.indent = indent;
		this.ascent = ascent;
		this.hintsSensitive = hintsSensitive;
	}
	public BaselinedDimension(int width, int height, int indent, int ascent, boolean hintsSensitive) {
		super(width, height);
		this.indent = indent;
		this.ascent = ascent;
		this.hintsSensitive = hintsSensitive;
	}

	public boolean equals(Object o) {
		if (this == o) return true;
		if (o instanceof BaselinedDimension) {
			BaselinedDimension d = (BaselinedDimension)o;
			return (indent == d.indent) && (ascent  == d.ascent) 
				&& (width == d.width) && (height == d.height);
		}
		return super.equals(o);
	}
	public int hashCode() {
		return (indent + height + 1) * (ascent + width + 1) ^ indent ^ ascent;
	}

	@Override
	public BaselinedDimension getCopy() {
		return new BaselinedDimension(this, indent, ascent, hintsSensitive);
	}
	@Override
	public BaselinedDimension getDifference(Dimension d) {
		return new BaselinedDimension(width - d.width, height - d.height, indent, ascent, hintsSensitive);
	}
	@Override
	public BaselinedDimension getExpanded(Dimension d) {
		return new BaselinedDimension(width + d.width, height + d.height, indent, ascent, hintsSensitive);
	}
	@Override
	public BaselinedDimension getExpanded(int w, int h) {
		return new BaselinedDimension(width + w, height + h, indent, ascent, hintsSensitive);
	}
	@Override
	public BaselinedDimension getIntersected(Dimension d) {
		return getCopy().intersect(d);
	}
	@Override
	public BaselinedDimension getScaled(double amount) {
		return getCopy().scale(amount);
	}
	@Override
	public BaselinedDimension getUnioned(Dimension d) {
		return getCopy().union(d);
	}
	@Override
	public BaselinedDimension getTransposed() {
		return getCopy().transpose();
	}
	@Override
	public BaselinedDimension getNegated() {
		return new BaselinedDimension(0 - width, 0 - height, indent, ascent, hintsSensitive);
	}

	@Override
	public BaselinedDimension intersect(Dimension d) {
		super.intersect(d);
		return this;
	}

	@Override
	public BaselinedDimension expand(Dimension d) {
		super.expand(d);
		return this;
	}
	@Override
	public BaselinedDimension expand(Point pt) {
		super.expand(pt);
		return this;
	}
	@Override
	public BaselinedDimension expand(int w, int h) {
		super.expand(w, h);
		return this;
	}

	@Override
	public BaselinedDimension union(Dimension d) {
		super.union(d);
		return this;
	}

	@Override
	public BaselinedDimension scale(double w, double h) {
		super.scale(w, h);
		return this;
	}
	@Override
	public BaselinedDimension scale(double amount) {
		return scale(amount, amount);
	}

	@Override
	public BaselinedDimension shrink(int w, int h) {
		return expand(-w, -h);
	}

	@Override
	public BaselinedDimension negate() {
		super.negate();
		indent = 0 - indent;
		ascent = 0 - ascent;
		return this;
	}

	@Override
	public BaselinedDimension transpose() {
		super.transpose();
		int temp = indent;
		indent = ascent;
		ascent = temp;
		return this;
	}

	public int getIndent() {
		return indent;
	}
	public int getAscent() {
		return ascent;
	}
	public int getDescent() {
		return height - ascent;
	}

	public String toString() {
		return "BaselinedDimension(" +  //$NON-NLS-1$
			width + ", " +  //$NON-NLS-1$
			height + ", " +  //$NON-NLS-1$
			indent + ", " +  //$NON-NLS-1$
			ascent + ", " +  //$NON-NLS-1$
			hintsSensitive + ")"; //$NON-NLS-1$
	}
}
