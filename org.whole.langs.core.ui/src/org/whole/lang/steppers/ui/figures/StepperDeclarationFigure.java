/**
 *  Copyright 2004-2019 Riccardo Solmi. All rights reserved.
 *  This file is part of the Whole Platform.
 *  
 *  The Whole Platform is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU Lesser General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *  
 *  The Whole Platform is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 *  GNU Lesser General Public License for more details.
 *  
 *  You should have received a copy of the GNU Lesser General Public License
 *  along with the Whole Platform. If not, see <http://www.gnu.org/licenses/>.
 */
package org.whole.lang.steppers.ui.figures;

import org.whole.lang.ui.figures.ContentPaneFigure;
import org.whole.lang.ui.layout.ColumnLayout;
import org.whole.lang.ui.layout.RowLayout;
import org.whole.lang.ui.figures.EntityFigure;

/**
 *  @generator Whole
 */
public class StepperDeclarationFigure extends ContentPaneFigure {

    public StepperDeclarationFigure() {
        initContentPanes(6);
        setLayoutManager(new ColumnLayout());
        EntityFigure row = new EntityFigure(new RowLayout().withSpacing(4));
        row.addKeyword("StepperDeclaration");
        row.addContentLighter("{");
        add(row);
        EntityFigure row1 = new EntityFigure(new RowLayout().withSpacing(4));
        row1.addContent("name");
        row1.addContentLight(":");
        row1.add(createContentPane(0));
        add(row1);
        EntityFigure row2 = new EntityFigure(new RowLayout().withSpacing(4));
        row2.addContent("goals");
        row2.addContentLight(":");
        row2.add(createContentPane(1));
        add(row2);
        EntityFigure row3 = new EntityFigure(new RowLayout().withSpacing(4));
        row3.addContent("calls");
        row3.addContentLight(":");
        row3.add(createContentPane(2));
        add(row3);
        EntityFigure row4 = new EntityFigure(new RowLayout().withSpacing(4));
        row4.addContent("arguments");
        row4.addContentLight(":");
        row4.add(createContentPane(3));
        add(row4);
        EntityFigure row5 = new EntityFigure(new RowLayout().withSpacing(4));
        row5.addContent("actions");
        row5.addContentLight(":");
        row5.add(createContentPane(4));
        add(row5);
        EntityFigure row6 = new EntityFigure(new RowLayout().withSpacing(4));
        row6.addContent("expression");
        row6.addContentLight(":");
        row6.add(createContentPane(5));
        add(row6);
        addContentLighter("}");
    }
}
