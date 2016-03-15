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

import org.eclipse.draw2d.IFigure;
import org.whole.lang.ui.layout.RowLayout;

/**
 * @author Riccardo Solmi
 */
public class SuffixContentPaneFigure extends ContentPaneFigure {
	public SuffixContentPaneFigure(String suffix) {
		this(suffix, 0);
	}
	public SuffixContentPaneFigure(String suffix, int spacing) {
		this(LabelFactory.createContentLight(suffix), spacing);
	}
	public SuffixContentPaneFigure(IFigure suffix, int spacing) {
		super(new RowLayout().withSpacing(spacing));
		initContentPanes(1);
		
		add(createContentPane(0));
		add(suffix);

		showParen(false);
	}

    public void showParen(boolean val) {
    	getContentPane(0).setBorder(
    			val ? RoundBracketsBorder.PARENTHESIS : CompositePlaceHolderBorder.OPTIONAL_HORIZONTAL);
    }

	@Override
	public RowLayout getLayoutManager() {
		return (RowLayout) super.getLayoutManager();
	}
}
