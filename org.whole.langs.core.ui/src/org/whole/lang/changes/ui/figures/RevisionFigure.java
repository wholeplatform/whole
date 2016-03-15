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
package org.whole.lang.changes.ui.figures;

import org.whole.lang.ui.figures.ContentPaneFigure;
import org.whole.lang.ui.figures.EntityLabel;
import org.whole.lang.ui.layout.TableRowLayout;

/**
 *  @author  Riccardo Solmi
 */
public class RevisionFigure extends ContentPaneFigure {
	protected EntityLabel indexLabel, additionsLabel, deletionsLabel; 

    public RevisionFigure() {
    	super(new TableRowLayout());
    	initContentPanes(1);
    	
    	indexLabel = addContentLight("#");
    	add(createContentPane(0));
    	additionsLabel = addContentLight("0");
    	deletionsLabel = addContentLight("0");
    }

    public void updateData(int index, int additions, int deletions) {
    	indexLabel.setText(String.valueOf(index));
    	additionsLabel.setText(String.valueOf(additions));
    	deletionsLabel.setText(String.valueOf(deletions));
    }
}
