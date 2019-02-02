/**
 * Copyright 2004-2019 Riccardo Solmi. All rights reserved.
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
package org.whole.lang.frames.ui.editparts;

import java.beans.PropertyChangeEvent;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.whole.lang.frames.model.ConditionPoint;
import org.whole.lang.frames.reflect.FramesEntityDescriptorEnum;
import org.whole.lang.frames.ui.figures.ConditionPointFigure;
import org.whole.lang.frames.util.FramesUtils;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.IEntity;
import org.whole.lang.ui.editparts.AbstractContentPanePart;

/**
 * @author Riccardo Solmi
 */
public class ConditionPointPart extends AbstractContentPanePart {
	protected IFigure createFigure() {
		return new ConditionPointFigure();
	}
	@Override
	public ConditionPointFigure getFigure() {
		return (ConditionPointFigure) super.getFigure();
	}

	@Override
	protected void propertyChangeUI(PropertyChangeEvent evt) {
		super.propertyChangeUI(evt);
		
		if (evt.getPropertyName().equals("enabler"))
			refreshVisuals();
	}

	@Override
	protected void refreshVisuals() {
		ConditionPoint entity = getModelEntity();
		IEntity enabler = entity.getEnabler();
		if (Matcher.matchImpl(FramesEntityDescriptorEnum.FeatureName, enabler))
			getFigure().setToolTip(new Label(enabler.wStringValue()));//FIXME multiple annotations
	}

	protected List<IEntity> getModelSpecificChildren() {
		ConditionPoint entity = getModelEntity();

		getFigure().showActive(FramesUtils.getActiveVariationPoint(entity) != null);

		List<IEntity> children = new ArrayList<IEntity>(2);
		children.add(entity.getEnabler());
		children.add(entity.getContent());
		return children;
	}
}
