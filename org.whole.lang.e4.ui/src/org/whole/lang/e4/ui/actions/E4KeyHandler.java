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
package org.whole.lang.e4.ui.actions;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;
import org.whole.lang.ui.keys.AbstractKeyHandler;
import org.whole.lang.ui.viewers.IEntityPartViewer;

/**
 * @author Enrico Persiani
 */
public class E4KeyHandler extends AbstractKeyHandler {
	protected IEclipseContext context;
	
	public E4KeyHandler(IEclipseContext context) {
		this.context = context;
	}
	
	protected IEntityPartViewer getViewer() {
		return context.get(IEntityPartViewer.class);
	}
	protected Object getSelection() {
		ESelectionService selectionService = context.get(ESelectionService.class);
		return selectionService.getSelection();
	}
}
