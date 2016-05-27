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
package org.whole.lang.commons.ui.editparts;

import java.beans.PropertyChangeEvent;
import java.util.ArrayList;
import java.util.List;

import org.whole.lang.commons.reflect.CommonsFeatureDescriptorEnum;
import org.whole.lang.commons.ui.figures.PhasedFragmentFigure;
import org.whole.lang.model.IEntity;
import org.whole.lang.ui.editparts.AbstractContentPanePart;
import org.whole.lang.ui.editparts.IFragmentPart;
import org.whole.lang.util.EntityUtils;

/**
 * @author Riccardo Solmi
 */
public abstract class AbstractPhasedFragmentPart extends AbstractContentPanePart implements IFragmentPart {
	@Override
    public PhasedFragmentFigure getFigure() {
    	return (PhasedFragmentFigure) super.getFigure();
    }

    protected List<IEntity> getModelSpecificChildren() {
    	IEntity entity = getModelEntity();
		List<IEntity> children = new ArrayList<IEntity>(2);
    	children.add(entity.wGet(CommonsFeatureDescriptorEnum.rootEntity));
    	children.add(entity.wGet(CommonsFeatureDescriptorEnum.phase));
    	return children;
    }

	protected void propertyChangeUI(PropertyChangeEvent evt) {
		refreshVisuals();
		super.propertyChangeUI(evt);
	}
	protected void refreshVisuals() {
		IEntity entity = getModelEntity();
		getFigure().showPhase(!EntityUtils.isResolver(entity.wGet(CommonsFeatureDescriptorEnum.phase)));
	}
}
