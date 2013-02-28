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

import org.eclipse.gef.GraphicalViewer;
import org.eclipse.ui.IWorkbenchPart;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.ui.editparts.IEntityPart;

/**
 * @author Enrico Persiani
 */
public abstract class AbstractClipboardAction extends AbstractLazySelectionAction {

	public AbstractClipboardAction(IWorkbenchPart part, IEnablerPredicate enablerPredicate, IEntity prototype) {
		super(part, enablerPredicate, prototype);
	}

	public AbstractClipboardAction(IWorkbenchPart part, IEnablerPredicate enablerPredicate, EntityDescriptor<?> type) {
		super(part, enablerPredicate, type);
	}

	public AbstractClipboardAction(IWorkbenchPart part) {
		super(part);
	}

	protected boolean calculateEnabled() {
		List<?> selectedObjects = getSelectedObjects();

		// selectedObjects is never empty: when any element appears to be selected
		// it contains the compound root

		for (Object selectedObject : selectedObjects)
			if (!(selectedObject instanceof IEntityPart))
				return false;

		return true;
	}

	protected GraphicalViewer getViewer() {
		return (GraphicalViewer) getWorkbenchPart().getAdapter(GraphicalViewer.class);
	}

	@SuppressWarnings("unchecked")
	protected List<IEntityPart> getSelectedEntityParts() {
		return (List<IEntityPart>) getSelectedObjects();
	}
}
