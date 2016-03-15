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

/**
 * @author Enrico Persiani
 */
public class CompositeEntityLayoutDelegator<D extends ICompositeEntityLayout> extends EntityLayoutDelegator<D> implements ICompositeEntityLayout {

	public CompositeEntityLayoutDelegator(D delegate) {
		super(delegate);
	}

	public ICompositeEntityLayout withAutoresizeWeight(float weight) {
		return getDelegate().withAutoresizeWeight(weight);
	}

	public Alignment getMajorAlignment() {
		return getDelegate().getMajorAlignment();
	}

	public ICompositeEntityLayout withMajorAlignment(Alignment majorAlignment) {
		return getDelegate().withMajorAlignment(majorAlignment);
	}

	public Alignment getMinorAlignment() {
		return getDelegate().getMinorAlignment();
	}

	public ICompositeEntityLayout withMinorAlignment(Alignment minorAlignment) {
		return getDelegate().withMinorAlignment(minorAlignment);
	}

	public ICompositeEntityLayout withMargin(int margin) {
		return getDelegate().withMargin(margin);
	}

	public ICompositeEntityLayout withMargin(int marginTop, int marginLeft,
			int marginBottom, int marginRight) {
		return getDelegate().withMargin(marginTop, marginLeft, marginBottom,
				marginRight);
	}

	public ICompositeEntityLayout withMarginLeft(int marginLeft) {
		return getDelegate().withMarginLeft(marginLeft);
	}

	public ICompositeEntityLayout withMarginRight(int marginRight) {
		return getDelegate().withMarginRight(marginRight);
	}

	public ICompositeEntityLayout withMarginTop(int marginTop) {
		return getDelegate().withMarginTop(marginTop);
	}

	public ICompositeEntityLayout withMarginBottom(int marginBottom) {
		return getDelegate().withMarginBottom(marginBottom);
	}

	public ICompositeEntityLayout withSpacing(int spacing) {
		return getDelegate().withSpacing(spacing);
	}

	public boolean isReversed() {
		return getDelegate().isReversed();
	}

	public ICompositeEntityLayout withReversedChildren(boolean reversed) {
		return getDelegate().withReversedChildren(reversed);
	}
}
