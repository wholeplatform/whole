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

import java.util.BitSet;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.graphics.Color;
import org.whole.lang.ui.layout.CompositeEntityLayoutDelegator;
import org.whole.lang.ui.layout.ICompositeEntityLayout;

/**
 * @author Enrico Persiani
 */
public class ParenthesizedStringSeparatedCompositeRowFigure extends StringSeparatedCompositeRowFigure {
	protected BitSet showParentheses;

	public ParenthesizedStringSeparatedCompositeRowFigure() {
		this(",", 8);
	}
	public ParenthesizedStringSeparatedCompositeRowFigure(String separator, ICompositeEntityLayout layout) {
		super(separator, layout);
		setLayoutManager(new ExpandableSpacingLayout(getLayoutManager()));
		setShowParentheses(new BitSet(0));
	}
	public ParenthesizedStringSeparatedCompositeRowFigure(String separator, int spacing) {
		super(separator, spacing);
		setLayoutManager(new ExpandableSpacingLayout(getLayoutManager()));
		setShowParentheses(new BitSet(0));
	}

	public void setShowParentheses(BitSet showParentheses) {
		this.showParentheses = showParentheses;
		int spacingExpansion = showParentheses.cardinality() > 0 ? (RoundBracketsBorder.HMARGIN+2) * 2 : 0;
		((ExpandableSpacingLayout) getLayoutManager()).withSpacingExpansion(spacingExpansion);
	}

	@Override
	protected void paintChildDecorations(Graphics g, int index, Rectangle childBounds, int childAscent, int spacing) {
		super.paintChildDecorations(g, index, childBounds, childAscent, spacing);

		Color color = g.getForegroundColor();
		g.setForegroundColor(FigureConstants.contentLighterColor);

		if (showParentheses.get(index))
    		RoundBracketsBorder.paintRoundBrackets(g, childBounds.getExpanded(spacing/2-1, 0));

		g.setForegroundColor(color);
	}

	private class ExpandableSpacingLayout extends CompositeEntityLayoutDelegator<ICompositeEntityLayout> {
		private int spacing;
		private int spacingExpansion;

		public ExpandableSpacingLayout(ICompositeEntityLayout delegate) {
			super(delegate);
			this.spacing = getSpacing();
			this.spacingExpansion = 0;
		}

		private int calculateExpandedSpacing() {
			return this.spacing + this.spacingExpansion;
		}

		@Override
		public ICompositeEntityLayout withSpacing(int spacing) {
			this.spacing = spacing;
			return super.withSpacing(calculateExpandedSpacing());
		}

		public ICompositeEntityLayout withSpacingExpansion(int spacingExpansion) {
			this.spacingExpansion = spacingExpansion;
			return super.withSpacing(calculateExpandedSpacing());
		}
	}
}
