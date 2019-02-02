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
package org.whole.lang.editors.ui.editparts;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.whole.lang.editors.model.FoldableTextualFigure;
import org.whole.lang.model.IEntity;
import org.whole.lang.ui.editparts.AbstractContentPanePart;
import org.whole.lang.ui.figures.InfixContentPaneFigure;
import org.whole.lang.ui.figures.LabelFactory;


/**
 * @author Riccardo Solmi
 */
public class FoldableTextualPart extends AbstractContentPanePart {
    protected IFigure createFigure() {
    	return new InfixContentPaneFigure(LabelFactory.createLiteral("+/-"), 8);
    }

	protected List<IEntity> getModelSpecificChildren() {
		FoldableTextualFigure entity = getModelEntity();
		List<IEntity> list = new ArrayList<IEntity>(2);
		list.add(entity.getExpandedFigure());
		list.add(entity.getCollapsedFigure());
		return list;
	}
}
