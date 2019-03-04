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
package org.whole.lang.java.ui.editparts;

import java.beans.PropertyChangeEvent;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.ActionEvent;
import org.eclipse.draw2d.ActionListener;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Toggle;
import org.whole.lang.java.factories.JavaEntityFactory;
import org.whole.lang.java.model.ModuleDeclaration;
import org.whole.lang.java.reflect.JavaFeatureDescriptorEnum;
import org.whole.lang.java.ui.figures.ModuleDeclarationFigure;
import org.whole.lang.model.IEntity;
import org.whole.lang.ui.commands.ModelTransactionCommand;
import org.whole.lang.ui.editparts.AbstractContentPanePart;
import org.whole.lang.util.EntityUtils;

/**
 * @author Enrico Persiani
 */
public class ModuleDeclarationPart extends AbstractContentPanePart {
	protected IFigure createFigure() {
		return new ModuleDeclarationFigure(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				ModuleDeclaration entity = getModelEntity();
				ModelTransactionCommand command = new ModelTransactionCommand(entity);
				try {
					command.begin();
					entity.setOpen(JavaEntityFactory.instance.createOpen((((Toggle) event.getSource()).isSelected())));
					command.commit();
					getViewer().getEditDomain().getCommandStack().execute(command);
				} catch (Exception e) {
					command.rollbackIfNeeded();
				}
			}
		});
	}

	public ModuleDeclarationFigure getFigure() {
		return (ModuleDeclarationFigure) super.getFigure();
	}
	
	protected void propertyChangeUI(PropertyChangeEvent evt) {
		if (evt.getPropertyName().equals(JavaFeatureDescriptorEnum.open.getName()))
			refreshVisuals();
		super.propertyChangeUI(evt);
	}
	protected void refreshVisuals() {
		ModuleDeclaration entity = getModelEntity();
		getFigure().setOpenModule(EntityUtils.safeBooleanValue(entity.getOpen(), false));
	}

	protected List<IEntity> getModelSpecificChildren() {
	    ModuleDeclaration moduleDeclaration = getModelEntity();
	    List<IEntity> list = new ArrayList<IEntity>(7);
		list.add(moduleDeclaration.getJavadoc());
		list.add(moduleDeclaration.getAnnotations());
		list.add(moduleDeclaration.getName());
		list.add(moduleDeclaration.getModuleDirectives());
		return list;
	}
}
