/**
 *  Copyright 2004-2015 Riccardo Solmi. All rights reserved.
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

import org.whole.lang.ui.figures.ContentPaneFigure;
import org.whole.lang.ui.figures.EntityFigure;
import org.whole.lang.ui.figures.ViewportTrackingEntityFigure;
import org.whole.lang.ui.layout.Alignment;
import org.whole.lang.ui.layout.RowLayout;
import org.whole.lang.ui.layout.TableRowLayout;

/**
 *  @author  Riccardo Solmi
 */
public class FunctionDeclarationFigure extends ContentPaneFigure {
    public FunctionDeclarationFigure() {
        super(new TableRowLayout().withMinorAlignment(Alignment.LEADING));
        initContentPanes(3);

        add(createContentPane(0));
        EntityFigure nameFigure = new ViewportTrackingEntityFigure(
        		new RowLayout().withSpacing(4).withAutoresizeWeight(1f));
        nameFigure.add(createFoldingToggle(2));
        nameFigure.add(createContentPane(1));
        add(nameFigure);
        add(createContentPane(2));

        clickFoldingToggle(0);
    }
}
