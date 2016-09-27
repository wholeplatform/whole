/**
 * Copyright 2004-2016 Riccardo Solmi. All rights reserved.
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
package org.whole.lang.flowchart.ui.editparts;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.ConnectionRouter;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.ManhattanConnectionRouter;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.whole.lang.flowchart.model.Flowchart;
import org.whole.lang.flowchart.model.Nodes;
import org.whole.lang.model.IEntity;
import org.whole.lang.ui.editparts.AbstractConnectedFreeformRootPart;

/**
 * @author Riccardo Solmi
 */
public class FlowchartFreeformPart extends AbstractConnectedFreeformRootPart {
	@SuppressWarnings("unchecked")
	public Flowchart getModelEntity() {
		return (Flowchart) getModel();
	}
	
	@Override
	protected List<IEntity> getModelSpecificChildren() {
		Nodes nodes = getModelEntity().getNodes();
		List<IEntity> children = new ArrayList<IEntity>(nodes.wSize());
		for (int i=0,size=nodes.wSize(); i<size; i++)
			children.add(nodes.wGet(i));
		return children;
	}

	protected ConnectionRouter createConnectionRouter(IFigure figure) {
//		return super.createConnectionRouter(figure);
		return new ManhattanConnectionRouter();
	}
}
