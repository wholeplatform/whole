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

import org.eclipse.gef.EditPart;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.StructuredSelection;

/**
 * @author Enrico Persiani
 */
public class ImmutableSelectionProvider implements ISelectionProvider {
	ISelection selection;

	public ImmutableSelectionProvider(EditPart part) {
		this(new StructuredSelection(part));
	}
	public ImmutableSelectionProvider(ISelection selection) {
		this.selection = selection;
	}

	public void addSelectionChangedListener(
		ISelectionChangedListener listener) {
	}
	public ISelection getSelection() {
		return selection;
	}
	public void removeSelectionChangedListener(
		ISelectionChangedListener listener) {
	}
	public void setSelection(ISelection selection) {
	};
}