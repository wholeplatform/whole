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

import java.util.Iterator;

import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reflect.EntityDescriptorEnum;
import org.whole.lang.reflect.ILanguageKit;

/**
 * @author Riccardo Solmi
 */
public class DefaultUITemplate extends AbstractUITemplate {
	private ILanguageKit languageKit;
	private EntityDescriptor<?>[] connectionDescriptors;
	
	public DefaultUITemplate(ILanguageKit languageKit, EntityDescriptor<?>... connectionDescriptors) {
		this.languageKit = languageKit;
		this.connectionDescriptors = connectionDescriptors;
	}

	public String getId() {
		return languageKit.getURI();
	}
	public void applyPalette(IPaletteBuilder builder) {
		builder.Drawer_(languageKit.getName());

		EntityDescriptorEnum entityTypes = languageKit.getEntityDescriptorEnum();
		for (Iterator i = entityTypes.values().iterator(); i.hasNext();) {
			EntityDescriptor<?> ed = (EntityDescriptor<?>) i.next();
			if (ed.isAbstract())
				continue;
			if (contains(connectionDescriptors, ed))
				builder.Connection(ed);
			else
				builder.Template(ed);
		}
		
		builder._Drawer();
	}

	public static boolean contains(EntityDescriptor<?>[] connectionDescriptors, EntityDescriptor<?> descriptor) {
		for (int i = 0; i < connectionDescriptors.length; i++) {
			if (connectionDescriptors[i].equals(descriptor))
				return true;
		}
		return false;
	}
}
