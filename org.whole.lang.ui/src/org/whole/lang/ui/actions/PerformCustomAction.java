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
import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.model.IEntity;
import org.whole.lang.ui.commands.ModelTransactionCommand;
import org.whole.lang.ui.editparts.IEntityPart;
import org.whole.lang.ui.util.UIUtils;
import org.whole.lang.util.BehaviorUtils;


public class PerformCustomAction extends AbstractLazySelectionAction {
	private IEntity behavior;

	public PerformCustomAction(IWorkbenchPart part, IEntity behavior, String text) {
		super(part);

		this.behavior = behavior;
		setImageDescriptor(WRAP_ICON);
		setText(text);
	}
	protected boolean calculateEnabled() {
		List<?> selectedObjects = getSelectedObjects();
		return selectedObjects.size() == 1 && selectedObjects.get(0) instanceof IEntityPart;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void run() {
		IBindingManager bm = BindingManagerFactory.instance.createBindingManager();
		UIUtils.defSelectedEntities(bm, getSelectedObjects());

		IEntityPart selectedPart = (IEntityPart) getSelectedObjects().get(0);
		IEntity selectedEntity = selectedPart.getModelEntity();
		ModelTransactionCommand mtc = new ModelTransactionCommand(selectedEntity);
		try {
			mtc.setLabel("add Artifacts");
			mtc.begin();
			BehaviorUtils.evaluate(behavior, 0, bm);
			mtc.commit();
			if (mtc.canUndo())
				execute(mtc);
		} catch (RuntimeException e) {
			mtc.rollback();
			throw e;
		}
	}

	protected IEntityPart getSelectedPart() {
	    return (IEntityPart) getSelectedObjects().get(0);
	}
}
