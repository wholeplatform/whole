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
package org.whole.lang.java.ui.figures;

import org.eclipse.draw2d.IFigure;
import org.whole.lang.ui.figures.ContentPaneFigure;
import org.whole.lang.ui.figures.EntityLabel;
import org.whole.lang.ui.layout.RowLayout;

/**
 *  @author Riccardo Solmi
 */
public class VariableDeclarationFragmentFigure extends ContentPaneFigure {
    private EntityLabel f1;
    private IFigure f2;

    public VariableDeclarationFragmentFigure() {
        super(new RowLayout().withSpacing(4));
        initContentPanes(2);
        add(createContentPane(0));
        f1 = (EntityLabel) addLiteral("");
        f2 = addContentLight("=");
        add(createContentPane(1));
    }

    public void setExtraDimensions(int size) {
        if (size == 0)
            f1.setVisible(false);
        else {
            StringBuffer text = new StringBuffer(size * 2);
            for (int i = 0; i < size; i++)
                text.append("[]");
            f1.setText(text.toString());
            f1.setVisible(true);
        }
    }

    public void hideOperator(boolean value) {
        f2.setVisible(!value);
    }
}
