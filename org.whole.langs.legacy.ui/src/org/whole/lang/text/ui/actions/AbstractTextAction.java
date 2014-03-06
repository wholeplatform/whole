/**
 * Copyright 2004-2014 Riccardo Solmi. All rights reserved.
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
package org.whole.lang.text.ui.actions;

import java.net.URL;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;
import org.eclipse.jface.resource.ImageDescriptor;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.e4.ui.actions.AbstractE4Action;
import org.whole.lang.e4.ui.actions.IUIConstants;

/**
 * @author Enrico Persiani
 */
public abstract class AbstractTextAction extends AbstractE4Action {
	public AbstractTextAction(IEclipseContext context, String label) {
		super(context, label);
		try {
			setImageDescriptor(ImageDescriptor.createFromURL(new URL(IUIConstants.TEXT_ICON_URI)));
		} catch (Exception e) {
		}

	}

	@Override
	public void update() {
		setEnabled(false);

		ESelectionService selectionService = getContext().get(ESelectionService.class);
		if (selectionService.getSelection() instanceof IBindingManager) {
			IBindingManager bm = (IBindingManager) selectionService.getSelection();
			setEnabled(calculateEnabled(bm));
		}
	}

	protected abstract boolean calculateEnabled(IBindingManager bm);
}
