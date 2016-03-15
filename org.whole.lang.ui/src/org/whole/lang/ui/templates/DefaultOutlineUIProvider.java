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

import org.eclipse.swt.graphics.Image;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.EntityKinds;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.util.DataTypeUtils;

/**
 * @author Riccardo Solmi
 */
public class DefaultOutlineUIProvider implements IOutlineUIProvider {
	public static final DefaultOutlineUIProvider instance = new DefaultOutlineUIProvider();
	protected DefaultOutlineUIProvider() {
	}

	public OutlineKinds getTemplateKind(IEntity entity) {
		return OutlineKinds.SIMPLE_NODE;
	}
	
	public boolean startOpened(IEntity entity) {
		return true;
	}

	public Image getImage(IEntity entity) {
		return null;
	}

	public String getText(IEntity entity) {
		EntityKinds entityKind = entity.wGetEntityKind();

		StringBuilder tb = new StringBuilder();
		tb.append(entity.wGetEntityDescriptor().getName());
		if (entityKind.isComposite()) {
			tb.append('(');
			tb.append(entity.wSize());
			tb.append(')');
		} else if (entityKind.isData()) {
			try {
				tb.append(": ");
				tb.append(DataTypeUtils.getAsPresentationString(entity));
			} catch (IllegalArgumentException e) {
			}
		}
		return tb.toString();			
	}

	public FeatureDescriptor[] getFeatures(IEntity entity) {
		return entity.wGetEntityDescriptor().getEntityFeatureDescriptors()
				.toArray(new FeatureDescriptor[0]);
	}
}
