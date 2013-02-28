/**
 * Copyright 2004-2013 Riccardo Solmi. All rights reserved.
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
package org.whole.lang.ui.actions;

import java.util.List;

import org.eclipse.ui.IWorkbenchPart;
import org.whole.lang.factories.GenericEntityFactory;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.ui.commands.ReplaceChildCommand;
import org.whole.lang.ui.editparts.IEntityPart;


public class ReplaceDefaultAction extends AbstractLazySelectionAction {
	public ReplaceDefaultAction(IWorkbenchPart part, String text) {
		super(part);

		setImageDescriptor(REPLACE_ICON);
		setId(ReplaceDefaultAction.class.getName());
		setText(text);
	}

	protected boolean calculateEnabled() {
		List<?> selectedObjects = getSelectedObjects();
		return selectedObjects.size() == 1 && selectedObjects.get(0) instanceof IEntityPart;
	}

	public void run() {
		IEntityPart selectedPart = (IEntityPart)getSelectedObjects().get(0);
		IEntity selectedEntity = selectedPart.getModelEntity();
		IEntity selectedEntityParent = selectedPart.getParentModelEntity();
		int selectedIndex = selectedEntityParent.wIndexOf(selectedEntity);
		EntityDescriptor<?> ed = selectedEntityParent.wGetEntityDescriptor();
		IEntity newEntity = GenericEntityFactory.instance.cloneFeature(ed, selectedIndex);

		ReplaceChildCommand replace = new ReplaceChildCommand();
		replace.setParent(selectedEntityParent);
		replace.setOldChild(selectedEntity);
		replace.setNewChild(newEntity);
		execute(replace);
	}
}
