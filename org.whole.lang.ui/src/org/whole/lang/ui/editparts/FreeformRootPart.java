/**
 *  Copyright 2004-2016 Riccardo Solmi. All rights reserved.
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
package org.whole.lang.ui.editparts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.XYLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.SnapToGeometry;
import org.eclipse.gef.SnapToHelper;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.SnapFeedbackPolicy;
import org.eclipse.gef.requests.CreateRequest;
import org.whole.lang.model.IEntity;
import org.whole.lang.ui.editpolicies.WholeComponentEditPolicy;
import org.whole.lang.ui.editpolicies.WholeContainerEditPolicy;
import org.whole.lang.ui.editpolicies.WholeFreeformLayoutEditPolicy;
import org.whole.lang.ui.editpolicies.WholeNonResizableEditPolicy;
import org.whole.lang.ui.figures.EntityFigure;
import org.whole.lang.ui.layout.EntityXYLayout;

/**
 *  @generator Whole
 */
public class FreeformRootPart extends AbstractPart {

    protected IFigure createFigure() {
		return new EntityFigure() {
			{
				setLayoutManager(new EntityXYLayout());
				setOpaque(false);
			}
			
			//FIXME workaround
			public int getIndent() {
				return getInsets().left;
			}
			public int getAscent() {
				return getPreferredSize().height/2;
			}

			public static final int MINIMUM_SIZE = 600;
			public Dimension getPreferredSize(int wHint, int hHint) {
				Dimension size = super.getPreferredSize(wHint, hHint);
				size.width = Math.max(size.width, MINIMUM_SIZE);
				size.height = Math.max(size.height, MINIMUM_SIZE);
				return size;
			}
		};
    }

	protected void createEditPolicies() {
		installEditPolicy(EditPolicy.CONTAINER_ROLE, new WholeContainerEditPolicy(getCommandFactory()));
    	installEditPolicy(EditPolicy.COMPONENT_ROLE, new WholeComponentEditPolicy(getCommandFactory()));
		installEditPolicy(EditPolicy.LAYOUT_ROLE, new WholeFreeformLayoutEditPolicy((XYLayout) getContentPane().getLayoutManager(), getCommandFactory()) {
			@Override
			protected EditPolicy createChildEditPolicy(EditPart child) {
				return new WholeNonResizableEditPolicy();
			}

			@Override
			protected Command getCreateCommand(CreateRequest request) {
				//FIXME
				return super.getCreateCommand(request);
			}
		});
		installEditPolicy("Snap Feedback", new SnapFeedbackPolicy());
    }

	@SuppressWarnings("rawtypes")
	public Object getAdapter(Class key) {
		if (key == SnapToHelper.class)
			return new SnapToGeometry(this);
		else
			return super.getAdapter(key);
	}

	@Override
	protected List<IEntity> getModelChildren() {
		IEntity entity = getModelEntity();
		int size = entity.wSize();
		if (size == 0)
			return Collections.emptyList();

		List<IEntity> result = new ArrayList<IEntity>(size);
		for (int i=0; i<size; i++)
			result.add(entity.wGet(i));

		return result;
    }
}
