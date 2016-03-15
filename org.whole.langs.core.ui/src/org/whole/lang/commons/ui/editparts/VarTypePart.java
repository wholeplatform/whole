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
package org.whole.lang.commons.ui.editparts;

import java.beans.PropertyChangeEvent;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.requests.LocationRequest;
import org.eclipse.gef.tools.DirectEditManager;
import org.whole.lang.commons.ui.editpolicies.VarTypeDirectEditPolicy;
import org.whole.lang.ui.actions.IActionRedirection;
import org.whole.lang.ui.editors.MultilineTextCellEditor;
import org.whole.lang.ui.editparts.AbstractPart;
import org.whole.lang.ui.editparts.LabelCellEditorLocator;
import org.whole.lang.ui.editparts.LabelDirectEditManager;
import org.whole.lang.ui.figures.EntityLabel;
import org.whole.lang.ui.figures.LabelFactory;

/** 
 * @author Riccardo Solmi
 */
public class VarTypePart extends AbstractPart {
	private DirectEditManager manager;

	public IFigure createFigure() {
		return LabelFactory.createContent();
	}

	protected void refreshVisuals() {
		((EntityLabel) getFigure()).setText(getModelEntity().wEnumValue().getName());
	}

	protected void createEditPolicies() {
		super.createEditPolicies();
		installEditPolicy(EditPolicy.DIRECT_EDIT_ROLE,
				new VarTypeDirectEditPolicy());
	}

	protected void propertyChangeUI(PropertyChangeEvent event) {
		refreshVisuals();
	}

	protected void performDirectEdit(LocationRequest request) {
		if (manager == null) {
			Label label = (Label) getFigure();
			manager = new LabelDirectEditManager(this, MultilineTextCellEditor.class,
					new LabelCellEditorLocator(label), label);
		}
		manager.show();
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Object getAdapter(Class key) {
		if (key == IActionRedirection.class)
			return manager;
		return super.getAdapter(key);
	}
}