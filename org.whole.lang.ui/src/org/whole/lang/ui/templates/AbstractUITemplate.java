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
public abstract class AbstractUITemplate implements IUITemplate {
	public String getId() {
		return getClass().getName();
	}

	public void applyOutline(final IOutlineBuilder builder) {
		applyPalette(new IdentityPaletteBuilder() {
			public void Template(EntityDescriptor<?> ed,
					String label, String shortDesc,
					ImageDescriptor iconSmall, ImageDescriptor iconLarge) {
				
				builder.Template(ed, label, iconSmall, OutlineKinds.SIMPLE_NODE, true);
			}
		});

		applyOutlineOnly(builder);
	}
	protected void applyOutlineOnly(IOutlineBuilder builder) {
	}
}
