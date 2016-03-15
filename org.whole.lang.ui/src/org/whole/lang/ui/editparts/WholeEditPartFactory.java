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
package org.whole.lang.ui.editparts;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.gef.EditPart;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.IEditorKit;
import org.whole.lang.ui.editor.IGEFEditorKit;

/**
 * @author Riccardo Solmi
 */
public class WholeEditPartFactory implements IEditPartFactory {
	private IGEFEditorKit currentEditorKit;
	private IEditPartFactory currentPartFactory;
	private Map<IEditorKit, IEditPartFactory> partFactoryMap = new HashMap<IEditorKit, IEditPartFactory>();

	public EditPart createEditPart(EditPart context, Object object) {
		try {
			IEntity entity = (IEntity) object;
			IEntity modelEntity = entity.wGetAdaptee(false);

	        IEditorKit editorKit = modelEntity.wGetEditorKit();
			if (currentEditorKit != editorKit) {
				currentEditorKit = (IGEFEditorKit) editorKit;
				currentPartFactory = partFactoryMap.get(currentEditorKit);
				if (currentPartFactory == null)
					partFactoryMap.put(currentEditorKit, currentPartFactory = currentEditorKit.getPartFactory());
			}

			EditPart part = currentPartFactory.createEditPart(context, modelEntity);
	        part.setModel(entity);
	        return part;
		} catch (Exception e) {
			throw new IllegalArgumentException("Illegal model entity: "+object+" in context: "+context, e);
		}
	}	
}
