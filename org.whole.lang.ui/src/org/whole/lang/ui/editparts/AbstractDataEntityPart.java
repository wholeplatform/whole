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

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.editpolicies.DirectEditPolicy;
import org.eclipse.gef.requests.LocationRequest;
import org.eclipse.gef.tools.DirectEditManager;
import org.whole.lang.model.IEntity;
import org.whole.lang.ui.actions.IActionRedirection;
import org.whole.lang.ui.editors.MultilineTextCellEditor;
import org.whole.lang.ui.editpolicies.DataEntityDirectEditPolicy;
import org.whole.lang.ui.figures.IEntityFigure;
import org.whole.lang.util.DataTypeUtils;

/**
 * @author Riccardo Solmi
 */
public abstract class AbstractDataEntityPart extends AbstractPart {
	private DirectEditManager manager;
	private DirectEditPolicy directEditPolicy;

	protected Label getLabel() {
		IFigure f = getFigure();
		if (f instanceof Label)
			return (Label) f;
		else
			return (Label) (((IEntityFigure) f).getContentPane(0));
	}

	protected void propertyChangeUI(PropertyChangeEvent event) {
		refreshVisuals();
	}
	protected void refreshVisuals() {
    	IEntity entity = getModelEntity();
    	getLabel().setText(DataTypeUtils.getDataKind(entity).isObject() && entity.wGetValue() == null ?
    			"null" : DataTypeUtils.getAsPresentationString(entity));
	}

	protected void performDirectEdit(LocationRequest request) {
		if (directEditPolicy != null) {
			Label label = getLabel();
			Point location = request.getLocation();
			if (location != null) {
				label.translateToRelative(location);
				Rectangle labelBounds = label.getBounds();
				if (labelBounds.width > 0 && !labelBounds.contains(location.x, location.y))
					return;
			}
			if (label.isVisible())
				showDirectEdit();
		}
	}
	protected void showDirectEdit() {
		if (manager == null) {
			Label label = getLabel();
			manager = new LabelDirectEditManager(this, MultilineTextCellEditor.class,
					new LabelCellEditorLocator(label), label);
		}
		manager.show();
	}

	protected void createEditPolicies() {
		super.createEditPolicies();
		installEditPolicy(EditPolicy.DIRECT_EDIT_ROLE,
				directEditPolicy = new DataEntityDirectEditPolicy());
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Object getAdapter(Class key) {
		if (key == IActionRedirection.class)
			return manager;
		return super.getAdapter(key);
	}
}
