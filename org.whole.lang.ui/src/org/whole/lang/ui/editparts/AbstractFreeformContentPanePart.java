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

import java.beans.PropertyChangeEvent;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.GraphicalEditPart;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.FeatureDescriptorEnum;
import org.whole.lang.ui.editpolicies.WholeComponentEditPolicy;
import org.whole.lang.ui.editpolicies.WholeLayoutEditPolicy;

/**
 *  @author Riccardo Solmi
 */
public abstract class AbstractFreeformContentPanePart extends AbstractContentPanePart {
	protected void createEditPolicies() {
    	installEditPolicy(EditPolicy.COMPONENT_ROLE, new WholeComponentEditPolicy(getCommandFactory()));
		installEditPolicy(EditPolicy.LAYOUT_ROLE, new WholeLayoutEditPolicy(getCommandFactory()));
	}

	@Override
	protected void propertyChangeUI(PropertyChangeEvent evt) {
		refresh();
	}

	@Override
	protected void refreshVisuals() {
		IEntity e = getPresentationEntity();
		FeatureDescriptorEnum fe = e.wGetEntityDescriptor().getFeatureDescriptorEnum();
		int x = e.wGet(fe.valueOf("x")).wIntValue();
		int y = e.wGet(fe.valueOf("y")).wIntValue();
//		int width = e.wGet(fe.valueOf("width")).wIntValue();
//		int height = e.wGet(fe.valueOf("height")).wIntValue();

		Rectangle bounds = new Rectangle(x, y, -1, -1);//width, height);
		((GraphicalEditPart) getParent()).setLayoutConstraint(this, getFigure(), bounds);
	}
}
