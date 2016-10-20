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
package org.whole.lang.features.ui.editparts;

import java.beans.PropertyChangeEvent;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.ActionEvent;
import org.eclipse.draw2d.ActionListener;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Toggle;
import org.whole.lang.features.ui.figures.VariableFeatureDownFigure;
import org.whole.lang.frames.factories.FramesEntityFactory;
import org.whole.lang.frames.model.VariableFeature;
import org.whole.lang.frames.model.VariableValue;
import org.whole.lang.frames.model.VariableValueEnum;
import org.whole.lang.frames.reflect.FramesFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.ui.commands.ModelTransactionCommand;
import org.whole.lang.ui.editparts.AbstractContentPanePart;
import org.whole.lang.util.DataTypeUtils;

/**
 * @author Riccardo Solmi
 */
public class VariableFeatureDownPart extends AbstractContentPanePart {
	protected IFigure createFigure() {
		return new VariableFeatureDownFigure(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				VariableFeature entity = getModelEntity();
				ModelTransactionCommand command = new ModelTransactionCommand(entity);
				try {
					command.begin();
					entity.setValue(FramesEntityFactory.instance.createVariableValue(
							((Toggle) event.getSource()).isSelected() ?
									VariableValueEnum.SELECTED : VariableValueEnum.NOT_SELECTED));
					command.commit();
					getViewer().getEditDomain().getCommandStack().execute(command);
				} catch (Exception e) {
					command.rollbackIfNeeded();
				}
			}
		});
	}

	@Override
	protected void propertyChangeUI(PropertyChangeEvent evt) {
		if (evt.getPropertyName().equals(FramesFeatureDescriptorEnum.value.getName()))
			refreshVisuals();
		else
			super.propertyChangeUI(evt);
	}

	protected List<IEntity> getModelSpecificChildren() {
		VariableFeature entity = getModelEntity();
		List<IEntity> list = new ArrayList<IEntity>(1);
		list.add(entity.getFeature());
		return list;
	}


	@Override
	protected void refreshVisuals() {
		VariableFeature entity = getModelEntity();
		VariableValue value = entity.getValue();
		((VariableFeatureDownFigure) getFigure()).setVariableValue(
				DataTypeUtils.getDataKind(value).isEnumValue() && value.wEnumValue().equals(VariableValueEnum.SELECTED));
	}
}
