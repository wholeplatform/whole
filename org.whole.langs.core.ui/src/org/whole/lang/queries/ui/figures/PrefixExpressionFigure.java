/**
 * Copyright 2004-2019 Riccardo Solmi. All rights reserved.
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
package org.whole.lang.queries.ui.figures;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MarginBorder;
import org.whole.lang.ui.figures.ContentPaneFigure;
import org.whole.lang.ui.layout.RowLayout;

/**
 * @author Riccardo Solmi
 */
public class PrefixExpressionFigure extends ContentPaneFigure {
	private IFigure p1,p2;
	
	public PrefixExpressionFigure(String operatorSymbol) {
		super(new RowLayout());
		initContentPanes(1);

		addContentLight(operatorSymbol).setBorder(new MarginBorder(0,1,0,1));
		p1 = addContentLighter("(");
		add(createContentPane(0));
		p2 = addContentLighter(")");

    	showRightParen(false);
	}

    public void showRightParen(boolean val) {
    	p1.setVisible(val);
    	p2.setVisible(val);
    }
}
