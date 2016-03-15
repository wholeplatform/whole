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

import java.util.Comparator;

import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.whole.lang.resources.IResource;
import org.whole.lang.resources.IResourceRegistry;
import org.whole.lang.util.ResourceUtils;

/**
 * @author Riccardo Solmi
 */
public class ResourceRegistryContentProvider implements IStructuredContentProvider {
	protected boolean includeHidden;
	protected Comparator<IResource> comparator;
	protected Object[] resourceArray = new Object[0];

	public ResourceRegistryContentProvider() {
		this(false, ResourceUtils.SIMPLE_COMPARATOR);
	}
	public ResourceRegistryContentProvider(boolean includeHidden, Comparator<IResource> comparator) {
		this.includeHidden = includeHidden;
		this.comparator = comparator;
	}

	public Object[] getElements(Object inputElement) {
		return resourceArray;
	}

	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		if (newInput != null)
			resourceArray = ((IResourceRegistry<?>) newInput).getResources(includeHidden, comparator).toArray();
	}

	public void dispose() { }
}