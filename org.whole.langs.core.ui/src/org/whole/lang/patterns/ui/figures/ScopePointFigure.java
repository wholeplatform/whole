/**
 *  Copyright 2004-2016 Riccardo Solmi. All rights reserved.
 *  This file is part of the Whole Platform.
 *  The Whole Platform is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU Lesser General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *  The Whole Platform is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 *  GNU Lesser General Public License for more details.
 *  You should have received a copy of the GNU Lesser General Public License
 *  along with the Whole Platform. If not, see <http://www.gnu.org/licenses/>.
 */
package org.whole.lang.patterns.ui.figures;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.swt.graphics.Color;
import org.whole.lang.queries.ui.figures.ScopeBracketsBorder;
import org.whole.lang.ui.figures.ContentPaneFigure;
import org.whole.lang.ui.layout.Alignment;
import org.whole.lang.ui.layout.ColumnLayout;

/**
 *  @author  Riccardo Solmi
 */
public class ScopePointFigure extends ContentPaneFigure {

    public ScopePointFigure() {
        super(//FIXME new OverLayout(false, true));
        		new ColumnLayout() {

            @Override
            protected int getAscent(int height) {
                return childSize[0].height + ascent(1);
            }
        }.withMinorAlignment(Alignment.LEADING));
        initContentPanes(2);
        add(createContentPane(0));
        add(createContentPane(1, new MarginBorder(4, 0, 4, 0)));
        setBorder(new ScopeBracketsBorder(1, 1, 2, 1) {
        	protected Color getDelimiterColor() {
        		return ColorConstants.gray;
        	}
        });
    }
}
