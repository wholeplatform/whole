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
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.ui.commands.CompositeAddCommand;
import org.whole.lang.ui.editparts.IEntityPart;
import org.whole.lang.ui.editpolicies.IHilightable;
import org.whole.lang.util.UniqueIdGenerator;


/**
 * @author Riccardo Solmi
 */
public class CompositeAddAction extends AbstractLazySelectionAction {
	private static UniqueIdGenerator uidGen = UniqueIdGenerator.newUniqueIdGenerator("add");
	protected int lastPosition;

	public CompositeAddAction(IWorkbenchPart part, IEnablerPredicate enablerPredicate, IEntity prototype, String text) {
		super(part, enablerPredicate, prototype);

		setText(text);
	}
	public CompositeAddAction(IWorkbenchPart part, IEnablerPredicate enablerPredicate, EntityDescriptor<?> type, String text) {
		super(part, enablerPredicate, type);

		setText(text);
	}

	protected void init() {
		setImageDescriptor(INSERT_ICON);
		setId(uidGen.next());
	}

	protected boolean calculateEnabled() {
		List<?> selectedObjects = getSelectedObjects();
		if (selectedObjects.size() == 1 && selectedObjects.get(0) instanceof IHilightable) {
			IEntityPart selectedPart = (IEntityPart) selectedObjects.get(0);
			lastPosition = getHilightPosition(selectedPart);
			return enablerPredicate.evaluate(selectedPart, contextMenuRequest);
		}
		return false;
	}

	public void run() {
		IEntityPart selectedPart = (IEntityPart) getSelectedObjects().get(0);
		IEntity selectedEntity = selectedPart.getModelEntity();
		
		CompositeAddCommand add = new CompositeAddCommand();
		add.setComposite(selectedEntity);
		add.setNewChild(configureNewChild(selectedEntity, contextMenuRequest.cloneType()));
		add.setIndex(lastPosition);
		execute(add);
	}
	protected IEntity configureNewChild(IEntity selectedEntity, IEntity newChild) {
		return newChild;
	}
}
