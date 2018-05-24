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
package org.whole.lang.reusables.ui.figures;

import org.whole.lang.ui.figures.ContentPaneFigure;
import org.whole.lang.ui.figures.EntityFigure;
import org.whole.lang.ui.layout.Alignment;
import org.whole.lang.ui.layout.RowLayout;
import org.whole.lang.ui.layout.UnderColumnLayout;

/**
 *  @author Riccardo Solmi
 */
public class ResourceFigure extends ContentPaneFigure {

    public ResourceFigure(String kind) {
        initContentPanes(2);
        setLayoutManager(new RowLayout().withMargin(1,3,1,0).withSpacing(4));
        
        EntityFigure f = new EntityFigure(new UnderColumnLayout().withMinorAlignment(Alignment.TRAILING).withSpacing(4));
        f.addContentDark(kind);
        f.add(createContentPane(0));
        add(f);
        add(createContentPane(1));
    }

	public void showPersistence(boolean value) {
		getContentPane(0).setVisible(value);
	}
}
