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
package org.whole.lang.ui.editparts;

import java.beans.PropertyChangeEvent;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.GraphicalEditPart;
import org.whole.lang.commons.reflect.CommonsFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.reflect.FeatureDescriptorEnum;
import org.whole.lang.ui.editpolicies.WholeComponentEditPolicy;
import org.whole.lang.ui.editpolicies.WholeNodeEditPolicy;
import org.whole.lang.util.EntityUtils;

/**
 * @author Riccardo Solmi, Enrico Persiani
 */
public abstract class AbstractFreeformNodePart extends AbstractNodePart {
	protected void createEditPolicies() {
    	installEditPolicy(EditPolicy.COMPONENT_ROLE, new WholeComponentEditPolicy(getCommandFactory()));
    	installEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE, new WholeNodeEditPolicy());
	}

	protected void propertyChangeUI(PropertyChangeEvent evt) {
		// TODO place in AbstractNodePart ?
		FeatureDescriptor fd = CommonsFeatureDescriptorEnum.composite_element.getName().equals(evt.getPropertyName()) ?
				getModelEntity().wGetFeatureDescriptor((IEntity)evt.getSource()) :
				getModelEntity().wGetEntityDescriptor().getFeatureDescriptorEnum().valueOf(evt.getPropertyName());
		if (sourceConnections != null && sourceConnections.contains(fd) && !EntityUtils.isNotResolver((IEntity) evt.getNewValue())) {
			Object connectioneditPart = getViewer().getEditPartRegistry().get(evt.getOldValue());
			if (connectioneditPart instanceof ConnectionEditPart)
				removeSourceConnection((ConnectionEditPart) connectioneditPart);
		}
		if (targetConnections != null && targetConnections.contains(fd) && !EntityUtils.isNotResolver((IEntity) evt.getNewValue())) {
			Object connectioneditPart = getViewer().getEditPartRegistry().get(evt.getOldValue());
			if (connectioneditPart instanceof ConnectionEditPart)
				removeTargetConnection((ConnectionEditPart) connectioneditPart);
		}
		refresh();
	}

	protected void refreshVisuals() {
		IEntity e = getPresentationEntity();
		FeatureDescriptorEnum fe = e.wGetEntityDescriptor().getFeatureDescriptorEnum();
		Rectangle bounds = new Rectangle(
				e.wGet(fe.valueOf("x")).wIntValue(), e.wGet(fe.valueOf("y")).wIntValue(),
				e.wGet(fe.valueOf("width")).wIntValue(), e.wGet(fe.valueOf("height")).wIntValue());
		((GraphicalEditPart) getParent()).setLayoutConstraint(this, getFigure(), bounds);
	}
}
