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

import org.eclipse.jface.viewers.IColorProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Color;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.EntityKinds;

/**
 * @author Riccardo Solmi
 */
public class ModelLabelProvider extends LabelProvider implements IColorProvider {

	public String getText(Object element) {
		if (element instanceof IEntity) {
			IEntity entity = (IEntity) element;
			StringBuilder sb = new StringBuilder(entity.wGetEntityDescriptor().getName());
			EntityKinds kind = entity.wGetEntityKind();
			if (kind.isComposite()) {
				sb.append('[');
				sb.append(entity.wSize());
				sb.append(']');
			} else if (kind.isData()) {
				sb.append(": ");
				sb.append(entity.wGetValue());			
			}
			return sb.toString();
		} else
			return super.getText(element);
	}

	public Color getForeground(Object element) {
		// TODO Auto-generated method stub
		return null;
	}

	public Color getBackground(Object element) {
		// TODO Auto-generated method stub
		return null;
	}

}
