/**
 * Copyright 2004-2012 Riccardo Solmi. All rights reserved.
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
package org.whole.lang.ui.views.properties.tabbed;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.whole.lang.ui.editparts.IEntityPart;
import org.whole.lang.ui.templates.OutlineUIProvider;

/**
 * @author Enrico Persiani
 */
public class EntityLabelProvider extends LabelProvider {
	public EntityLabelProvider() {
		super();
	}
	
	public Image getImage(Object element) {
		Image result;
		if (element instanceof IStructuredSelection) {
			IStructuredSelection selection = (IStructuredSelection) element;
			return OutlineUIProvider.instance().getImage(((IEntityPart)selection.getFirstElement()).getModelEntity());
		} else {
			result = super.getImage(element);
		}
		return result;
	}

	public String getText(Object element) {
		String result;
		if (element instanceof IStructuredSelection) {
			IStructuredSelection selection = (IStructuredSelection) element;
			result = OutlineUIProvider.instance().getText(((IEntityPart)selection.getFirstElement()).getModelEntity());
		} else {
			result = super.getText(element);
		}
		return result;
	}
}
