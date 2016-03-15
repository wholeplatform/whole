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
package org.whole.lang.ui.controls;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.whole.lang.model.IEntity;

/**
 * @author Riccardo Solmi
 */
public class ModelContentProvider implements ITreeContentProvider {

	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
	}

	public void dispose() {
	}

	public Object getParent(Object element) {
		return ((IEntity) element).wGetParent();
	}

	public Object[] getElements(Object inputElement) {
		return getChildren(inputElement);
	}

	public boolean hasChildren(Object element) {
		return ((IEntity) element).wSize() > 0;
	}
	@SuppressWarnings("deprecation")
	public Object[] getChildren(Object parentElement) {
		return ((IEntity) parentElement).wFeatures().toArray();
	}
}
