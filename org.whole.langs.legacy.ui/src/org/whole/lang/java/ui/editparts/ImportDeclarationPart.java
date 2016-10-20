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
package org.whole.lang.java.ui.editparts;

import java.beans.PropertyChangeEvent;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.ActionEvent;
import org.eclipse.draw2d.ActionListener;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Toggle;
import org.whole.lang.java.factories.JavaEntityFactory;
import org.whole.lang.java.model.ImportDeclaration;
import org.whole.lang.java.model.ImportModifier;
import org.whole.lang.java.reflect.JavaFeatureDescriptorEnum;
import org.whole.lang.java.ui.figures.ImportDeclarationFigure;
import org.whole.lang.model.IEntity;
import org.whole.lang.ui.commands.ModelTransactionCommand;
import org.whole.lang.ui.editparts.AbstractContentPanePart;
import org.whole.lang.util.DataTypeUtils;

/**
 * @author Riccardo Solmi
 */
public class ImportDeclarationPart extends AbstractContentPanePart {
	protected IFigure createFigure() {
		return new ImportDeclarationFigure(
				new ActionListener() {
					public void actionPerformed(ActionEvent event) {
						ImportDeclaration entity = getModelEntity();
						ModelTransactionCommand command = new ModelTransactionCommand(entity);
						try {
							command.begin();
							entity.setStatic(JavaEntityFactory.instance.createImportModifier(((Toggle) event.getSource()).isSelected()));
							command.commit();
							getViewer().getEditDomain().getCommandStack().execute(command);
						} catch (Exception e) {
							command.rollbackIfNeeded();
						}
					}
				},
				new ActionListener() {
					public void actionPerformed(ActionEvent event) {
						ImportDeclaration entity = getModelEntity();
						ModelTransactionCommand command = new ModelTransactionCommand(entity);
						try {
							command.begin();
							entity.setOnDemand(JavaEntityFactory.instance.createImportModifier(((Toggle) event.getSource()).isSelected()));
							command.commit();
							getViewer().getEditDomain().getCommandStack().execute(command);
						} catch (Exception e) {
							command.rollbackIfNeeded();
						}
					}
				});
	}

	protected ImportDeclarationFigure getImportDeclarationFigure() {
		return (ImportDeclarationFigure) getFigure();
	}

	protected void propertyChangeUI(PropertyChangeEvent evt) {
		if (evt.getPropertyName().equals(JavaFeatureDescriptorEnum._static.getName()) ||
				evt.getPropertyName().equals(JavaFeatureDescriptorEnum.onDemand.getName())) {
			refreshVisuals();
		} else {
			super.propertyChangeUI(evt);
		}
	}
	protected void refreshVisuals() {
		ImportDeclaration entity = getModelEntity();
		ImportModifier m1 = entity.getStatic();
		if (DataTypeUtils.getDataKind(m1).isBoolean())
			getImportDeclarationFigure().setStaticModifier(m1.wBooleanValue());
		else
			getImportDeclarationFigure().setStaticModifier(false);

		ImportModifier m2 = entity.getOnDemand();
		if (DataTypeUtils.getDataKind(m2).isBoolean())
			getImportDeclarationFigure().setOnDemandModifier(m2.wBooleanValue());
		else
			getImportDeclarationFigure().setOnDemandModifier(false);
	}

	protected List<IEntity> getModelSpecificChildren() {
		List<IEntity> list = new ArrayList<IEntity>(1);
		ImportDeclaration entity = getModelEntity();
		list.add(entity.getName());
		return list;
	}
}