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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Rectangle;
import org.whole.lang.ui.figures.IEntityFigure;


/**
 * @author Riccardo Solmi
 */
public abstract class AbstractCompositeEntityLayout extends AbstractEntityLayout implements ICompositeEntityLayout {
	private int spacing;
	private Alignment majorAlignment = Alignment.LEADING;
	private Alignment minorAlignment = Alignment.LEADING;
	private boolean reversed;

	public Alignment getMajorAlignment() {
		return majorAlignment;
	}
	public ICompositeEntityLayout withMajorAlignment(Alignment majorAlignment) {
		this.majorAlignment = majorAlignment;
		return this;
	}

	public Alignment getMinorAlignment() {
		return minorAlignment;
	}
	public ICompositeEntityLayout withMinorAlignment(Alignment minorAlignment) {
		this.minorAlignment = minorAlignment;
		return this;
	}

	public ICompositeEntityLayout withAutoresizeWeight(float weight) {
		super.withAutoresizeWeight(weight);
		return this;
	}

	public ICompositeEntityLayout withMargin(int margin) {
		super.withMargin(margin);
		return this;
	}
	public ICompositeEntityLayout withMargin(int marginTop, int marginLeft, int marginBottom, int marginRight) {
		super.withMargin(marginTop, marginLeft, marginBottom, marginRight);
		return this;
	}

	public ICompositeEntityLayout withMarginLeft(int marginLeft) {
		super.withMarginLeft(marginLeft);
		return this;
	}

	public ICompositeEntityLayout withMarginRight(int marginRight) {
		super.withMarginRight(marginRight);
		return this;
	}

	public ICompositeEntityLayout withMarginTop(int marginTop) {
		super.withMarginTop(marginTop);
		return this;
	}

	public ICompositeEntityLayout withMarginBottom(int marginBottom) {
		super.withMarginBottom(marginBottom);
		return this;
	}

	public boolean isOrdered() {
		return true;
	}

	public ICompositeEntityLayout withSpacing(int spacing) {
		this.spacing = spacing;
		return this;
	}
	public int getSpacing() {
		return spacing;
	}

	public boolean isReversed() {
		return reversed;
	}
	public ICompositeEntityLayout withReversedChildren(boolean reversed) {
		this.reversed = reversed;
		return this;
	}

	@SuppressWarnings("unchecked")
	@Override
	protected IEntityFigure[] getChildren(IFigure container) {
		if (isReversed()) {
			List<IEntityFigure> children = new ArrayList<IEntityFigure>(container.getChildren());
			Collections.reverse(children);
			return children.toArray(new IEntityFigure[children.size()]);
		} else
			return super.getChildren(container);
	}

	protected int calculateXLocation(Rectangle area, Alignment alignment) {
		int xi;
		switch (alignment) {
		case MATHLINE:
//			xi = area.x + getIndent();
//			break;
		default:
		case FILL:
		case LEADING:
			xi = area.x;
			break;
		case CENTER:
			xi = area.x + (area.width - figWidth)/2;
			break;
		case TRAILING:
			xi = area.right() - figWidth;
			break;
		}
		return xi;
	}
	protected int calculateYLocation(Rectangle area, Alignment alignment) {
		int yi;
		switch (alignment) {
		case MATHLINE:
//			yi = area.y + figAscent;
//			break;
		default:
		case FILL:
		case LEADING:
			yi = area.y;
			break;
		case CENTER:
			yi = area.y + (area.height - figAscent - figDescent)/2;
			break;
		case TRAILING:
			yi = area.bottom() - figAscent - figDescent;
			break;
		}
		return yi;
	}
}
