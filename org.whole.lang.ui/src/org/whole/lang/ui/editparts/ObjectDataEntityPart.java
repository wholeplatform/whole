/**
 * Copyright 2004-2014 Riccardo Solmi. All rights reserved.
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

import org.eclipse.draw2d.IFigure;
import org.whole.lang.model.IEntity;
import org.whole.lang.ui.figures.LabelFactory;
import org.whole.lang.util.DataTypeUtils;

/**
 * @author Riccardo Solmi
 */
public class ObjectDataEntityPart extends AbstractDataEntityPart {
	public IFigure createFigure() {
		return LabelFactory.createContentLight();
	}

	protected void refreshVisuals() {
    	IEntity entity = getModelEntity();
    	String value = DataTypeUtils.getDataKind(entity).isObject() && entity.wGetValue() == null ?
    			"null" : DataTypeUtils.getAsPresentationString(entity);
    	int endIndex = value.indexOf("\n", value.indexOf("\n", value.indexOf("\n", value.indexOf("\n", value.indexOf("\n")+1)+1)+1)+1);
		getLabel().setText(endIndex == -1 ? value : value.substring(0, endIndex));
	}
}