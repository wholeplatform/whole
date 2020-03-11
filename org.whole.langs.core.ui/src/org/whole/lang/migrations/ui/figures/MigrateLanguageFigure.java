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
package org.whole.lang.migrations.ui.figures;

import org.eclipse.draw2d.MarginBorder;
import org.whole.lang.ui.figures.ContentPaneFigure;
import org.whole.lang.ui.figures.EntityFigure;
import org.whole.lang.ui.figures.IEntityFigure;
import org.whole.lang.ui.layout.Alignment;
import org.whole.lang.ui.layout.TableRowLayout;
import org.whole.lang.ui.layout.UnderColumnLayout;

/**
 *  @generator Whole
 */
public class MigrateLanguageFigure extends ContentPaneFigure {

    public MigrateLanguageFigure() {
        initContentPanes(4);
        setLayoutManager(new TableRowLayout().withSpacing(16).withMinorAlignment(Alignment.LEADING));
        add(createContentPane(0));
        
        IEntityFigure figure = new EntityFigure(new UnderColumnLayout()
				.withMinorAlignment(Alignment.LEADING));
		figure.add(createContentPane(1, new MarginBorder(0,4,0,0)));
		figure.add(createContentPane(2));
		add(figure);

		add(createContentPane(3));
    }
}
