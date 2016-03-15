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
import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;
import org.whole.lang.ui.actions.IUpdatableAction;

/**
 * @author Enrico Persiani
 */
public abstract class AbstractE4Action extends Action implements IUpdatableAction {
	private IEclipseContext context;

	public IEclipseContext getContext() {
		return context;
	}
	
	public AbstractE4Action(IEclipseContext context) {
		this.context = context;
	}
	public AbstractE4Action(IEclipseContext context, String text, int style) {
		super(text, style);
		this.context = context;
	}
	public AbstractE4Action(IEclipseContext context, String text, ImageDescriptor image) {
		super(text, image);
		this.context = context;
	}
	public AbstractE4Action(IEclipseContext context, String text) {
		super(text);
		this.context = context;
	}
}
