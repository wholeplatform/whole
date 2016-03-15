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
import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.ActionEvent;
import org.eclipse.draw2d.ActionListener;
import org.eclipse.draw2d.Clickable;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.ui.figures.IEntityFigure;

/**
 * @author Riccardo Solmi
 */
public abstract class AbstractContentPaneManagerPart extends AbstractContentPanePart implements IVisibilityManager {
	public boolean isChildrenVisibilityInitiallyEnabled() {
		return getModelEntity().wGetEntityDescriptor().childFeatureSize() > 4;
	}

	public boolean isChildVisible(int index) {
		IEntity entity = getModelEntity();
		return index < entity.wSize() && entity.wIsSet(index);
	}

	@Override
	protected void propertyChangeUI(PropertyChangeEvent evt) {
		IEntity entity = getModelEntity();
		FeatureDescriptor fd = entity.wGetEntityDescriptor().getFeatureDescriptorEnum().valueOf(evt.getPropertyName());
		int index = entity.wGetEntityDescriptor().indexOf(fd);
		((IEntityFigure) getFigure()).setContentPaneVisible(index, true);
		super.propertyChangeUI(evt);
	}

	@Override
	protected List<IEntity> getModelSpecificChildren() {
		IEntity entity = getModelEntity();
		int size = entity.wSize();
		List<IEntity> list = new ArrayList<IEntity>(size);
		for (int i=0; i<size; i++)
			list.add(entity.wGet(i));
		return list;
	}

	public ActionListener newLinkAction() {
		return new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				Clickable linkButton = (Clickable) event.getSource();
				int index = (Integer) linkButton.getModel().getUserData();

				getViewer().selectAndReveal(getModelEntity().wGet(index));
			}
		};
	}
}
