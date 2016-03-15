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
package org.whole.lang.java.ui.editparts;

import java.beans.PropertyChangeEvent;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.whole.lang.java.model.ArrayType;
import org.whole.lang.java.reflect.JavaEntityDescriptorEnum;
import org.whole.lang.java.ui.figures.ArrayTypeFigure;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.IEntity;
import org.whole.lang.ui.editparts.AbstractContentPanePart;
import org.whole.lang.util.EntityUtils;

/**
 * @author Enrico Persiani
 */
public class ArrayTypePart extends AbstractContentPanePart {
	protected IFigure createFigure() {
		return new ArrayTypeFigure();
	}

	protected List<IEntity> getModelSpecificChildren() {
		ArrayType entity = getModelEntity();
		List<IEntity> list = new ArrayList<IEntity>(1);
		list.add(entity.getComponentType());
		return list;
	}

	@Override
	public ArrayTypeFigure getFigure() {
		return (ArrayTypeFigure) super.getFigure();
	}

	
	@Override
	protected void propertyChangeUI(PropertyChangeEvent evt) {
		refreshVisuals();
		super.propertyChangeUI(evt);
	}


	public boolean isArrayCreation(IEntity entity) {
		IEntity parent = entity.wGetParent();
		if (EntityUtils.isNull(entity))
			return false;
		else if (Matcher.match(JavaEntityDescriptorEnum.ArrayType, parent))
			return isArrayCreation(parent);
		else
			return Matcher.match(JavaEntityDescriptorEnum.ArrayCreation, parent);
	}

	@Override
	protected void refreshVisuals() {
		ArrayType entity = getModelEntity();
		
		getFigure().showAsInternal(!isArrayCreation(entity));
	}
}