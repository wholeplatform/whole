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

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.IWorkbenchPart;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.ui.editparts.ITextualEntityPart;
import org.whole.lang.ui.tools.Tools;

/**
 * @author Riccardo Solmi
 */
public class EnsurePanningToolActiveAction extends SelectionAction {
	public static final String ID = EnsurePanningToolActiveAction.class.getName();
	private Collection<EntityDescriptor<?>> excludedDescriptors;

	public EnsurePanningToolActiveAction(IWorkbenchPart part, EntityDescriptor<?>... excludedDescriptors) {
		this(part, Arrays.asList(excludedDescriptors));
	}
	public EnsurePanningToolActiveAction(IWorkbenchPart part, Collection<EntityDescriptor<?>> excludedDescriptors) {
		super(part);
		setId(ID);
		this.excludedDescriptors = excludedDescriptors;
	}

	@Override
	protected boolean calculateEnabled() {
		GraphicalViewer viewer = (GraphicalViewer) getWorkbenchPart().getAdapter(GraphicalViewer.class);
		if (Tools.PANNING.isActive(viewer))
			return false;

		List<?> selectedObjects = getSelectedObjects();
		if (selectedObjects.size() == 1 && selectedObjects.get(0) instanceof ITextualEntityPart)
			return !excludedDescriptors.contains(((ITextualEntityPart) selectedObjects.get(0)).getModelTextEntity().wGetEntityDescriptor());
		else
			return false; 
	}

	@Override
	public void run() {
		GraphicalViewer viewer = (GraphicalViewer) getWorkbenchPart().getAdapter(GraphicalViewer.class);
		if (Tools.PANNING.ensureActive(viewer)) {
			ITextualEntityPart part = (ITextualEntityPart) getSelectedObjects().get(0);
			part.setCaretVisible(false);
			viewer.setSelection(new StructuredSelection(part));
		}
	}
}