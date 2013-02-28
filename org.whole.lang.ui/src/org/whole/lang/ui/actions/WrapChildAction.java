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
import org.whole.lang.ui.commands.ReplaceChildCommand;
import org.whole.lang.ui.editparts.IEntityPart;
import org.whole.lang.util.IEntityTransformer;
import org.whole.lang.util.UniqueIdGenerator;


/**
 * @author Riccardo Solmi
 */
public class WrapChildAction extends AbstractLazySelectionAction {
	private static UniqueIdGenerator uidGen = UniqueIdGenerator.newUniqueIdGenerator("wrap");
	protected IEntityTransformer transformer;

	public WrapChildAction(IWorkbenchPart part, IEnablerPredicate enablerPredicate, IEntityTransformer transformer, IEntity prototype, String text) {
		super(part, enablerPredicate, prototype);
		this.transformer = transformer;

		setText(text);
	}
	public WrapChildAction(IWorkbenchPart part, IEnablerPredicate enablerPredicate, IEntityTransformer transformer, EntityDescriptor<?> type, String text) {
		super(part, enablerPredicate, type);
		this.transformer = transformer;
		setText(text);
	}

	protected void init() {
		setImageDescriptor(WRAP_ICON);
		setId(uidGen.next());
	}

	protected boolean calculateEnabled() {
		List<?> selectedObjects = getSelectedObjects();
		if (selectedObjects.size() == 1 && selectedObjects.get(0) instanceof IEntityPart) {
			IEntityPart selectedPart = (IEntityPart) selectedObjects.get(0);
			return enablerPredicate.evaluate(selectedPart, contextMenuRequest);
		}
		return false; 
	}

	public void run() {
		IEntityPart selectedPart = (IEntityPart) getSelectedObjects().get(0);
		IEntity e1 = selectedPart.getModelEntity();
		IEntity e2 = contextMenuRequest.cloneType();
		transformer.transform(e1, e2);
		
		ReplaceChildCommand replace = new ReplaceChildCommand();
		replace.setParent(selectedPart.getParentModelEntity());
		replace.setOldChild(e1);
		replace.setNewChild(e2);
		execute(replace);
	}
}
