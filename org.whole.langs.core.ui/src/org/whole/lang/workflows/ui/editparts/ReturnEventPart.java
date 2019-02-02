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
package org.whole.lang.workflows.ui.editparts;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.whole.lang.ui.editparts.AbstractContentPanePart;
import org.whole.lang.ui.notations.NotationImages;
import org.whole.lang.ui.notations.flowchart.figures.EndEventFigure;
import org.whole.lang.workflows.model.ReturnEvent;

/**
 * @author Riccardo Solmi
 */
public class ReturnEventPart extends AbstractContentPanePart {
	protected IFigure createFigure() {
		return new EndEventFigure(NotationImages.EXIT16);
	}

	protected List getModelSpecificChildren() {
		ReturnEvent entity = getModelEntity();
		List children = new ArrayList(1);
//		children.add(entity.getLabel());
		return children;
	}
}
