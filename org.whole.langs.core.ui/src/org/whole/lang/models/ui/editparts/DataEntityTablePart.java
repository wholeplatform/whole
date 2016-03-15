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
package org.whole.lang.models.ui.editparts;

import java.beans.PropertyChangeEvent;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.whole.lang.model.IEntity;
import org.whole.lang.models.model.DataEntity;
import org.whole.lang.models.ui.figures.DataEntityTableFigure;
import org.whole.lang.ui.editparts.AbstractContentPanePart;
import org.whole.lang.util.EntityUtils;


/**
 * @author Riccardo Solmi
 */
public class DataEntityTablePart extends AbstractContentPanePart {
    protected IFigure createFigure() {
    	return new DataEntityTableFigure();
    }
    @Override
    public DataEntityTableFigure getFigure() {
    	return (DataEntityTableFigure) super.getFigure();
    }

	protected List<IEntity> getModelSpecificChildren() {
		DataEntity entity = getModelEntity();
		List<IEntity> list = new ArrayList<IEntity>(4);
		list.add(entity.getModifiers());
		list.add(entity.getName());
		list.add(entity.getTypes());
		list.add(entity.getDataType());
		return list;
	}

	@Override
	protected void propertyChangeUI(PropertyChangeEvent evt) {
		refreshVisuals();
		super.propertyChangeUI(evt);
	}

	@Override
	protected void refreshVisuals() {
		DataEntity entity = getModelEntity();
		getFigure().showKeyword(!EntityUtils.isNotResolver(entity.getDataType()));
	}
}
