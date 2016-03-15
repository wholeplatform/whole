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

import org.eclipse.jface.viewers.LabelProvider;
import org.whole.lang.resources.IResource;
import org.whole.lang.resources.IResourceNameProvider;
import org.whole.lang.resources.IResourceRegistry;
import org.whole.lang.util.ResourceUtils;

/**
 * @author Riccardo Solmi
 */
public class ResourceLabelProvider<T extends IResource> extends LabelProvider {
	protected IResourceRegistry<T> registry;
	protected IResourceNameProvider nameProvider;

	public ResourceLabelProvider(IResourceRegistry<T> registry) {
		this(registry, ResourceUtils.SIMPLE_NAME_PROVIDER);
	}
	public ResourceLabelProvider(IResourceRegistry<T> registry, IResourceNameProvider nameProvider) {
		this.registry = registry;
		this.nameProvider = nameProvider;
	}

	@SuppressWarnings("unchecked")
	public String getText(Object element) {
		return element == null ? super.getText(element) : nameProvider.toString(registry, ((T) element));
	}
}