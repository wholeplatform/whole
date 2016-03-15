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
 * @author Riccardo Solmi
 */
public interface ICompositeEntityLayout extends IEntityLayout {
	public ICompositeEntityLayout withAutoresizeWeight(float weight);

	public Alignment getMajorAlignment();
	public ICompositeEntityLayout withMajorAlignment(Alignment majorAlignment);
	public Alignment getMinorAlignment();
	public ICompositeEntityLayout withMinorAlignment(Alignment minorAlignment);

	public ICompositeEntityLayout withMargin(int margin);
	public ICompositeEntityLayout withMargin(int marginTop, int marginLeft, int marginBottom, int marginRight);
	public ICompositeEntityLayout withMarginLeft(int marginLeft);
	public ICompositeEntityLayout withMarginRight(int marginRight);
	public ICompositeEntityLayout withMarginTop(int marginTop);
	public ICompositeEntityLayout withMarginBottom(int marginBottom);

	public ICompositeEntityLayout withSpacing(int spacing);

	public boolean isReversed();
	public ICompositeEntityLayout withReversedChildren(boolean reversed);
}
