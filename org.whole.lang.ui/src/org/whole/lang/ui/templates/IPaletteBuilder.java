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
package org.whole.lang.ui.templates;

import org.eclipse.jface.resource.ImageDescriptor;
import org.whole.lang.reflect.EntityDescriptor;

/**
 * @author Riccardo Solmi
 */
public interface IPaletteBuilder {
	public static final int INITIAL_STATE_OPEN = 0;
	public static final int INITIAL_STATE_CLOSED = 1;
	public static final int INITIAL_STATE_PINNED_OPEN = 2;

	public void Group_(String label);
	public void Group_(String label, String shortDesc,
			ImageDescriptor iconSmall, ImageDescriptor iconLarge);
	public void _Group();

	public void Drawer_(String label);
	public void Drawer_(String label, int initialState);
	public void Drawer_(String label, int initialState, String shortDesc,
			ImageDescriptor iconSmall, ImageDescriptor iconLarge);
	public void _Drawer();

	public void Stack_();
	public void Stack_(String name, String shortDesc, ImageDescriptor icon);
	public void _Stack();

	public void Connection(EntityDescriptor<?> ed);
	public void Connection(EntityDescriptor<?> ed, String label, String shortDesc,
			ImageDescriptor iconSmall, ImageDescriptor iconLarge);
	public void Template(EntityDescriptor<?> ed);
	public void Template(EntityDescriptor<?> ed, String label, String shortDesc,
			ImageDescriptor iconSmall, ImageDescriptor iconLarge);
	public void Separator();
	public void Separator(String id);
}
