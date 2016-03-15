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
package org.whole.lang.semantics.ui.editparts;

import java.beans.PropertyChangeEvent;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.whole.lang.model.IEntity;
import org.whole.lang.semantics.model.ExecutionRule;
import org.whole.lang.semantics.ui.figures.RuleFigure;
import org.whole.lang.ui.editparts.AbstractContentPanePart;
import org.whole.lang.util.EntityUtils;

/**
 * @author Riccardo Solmi
 */
public class ExecutionRulePart extends AbstractContentPanePart {
	protected IFigure createFigure() {
		return new RuleFigure("=");
	}

	protected List<IEntity> getModelSpecificChildren() {
		ExecutionRule entity = getModelEntity();
		List<IEntity> list = new ArrayList<IEntity>(3);
		list.add(entity.getName());
		list.add(entity.getCondition());
		list.add(entity.getMeaning());
		return list;
	}

	@Override
	protected void propertyChangeUI(PropertyChangeEvent evt) {
		super.propertyChangeUI(evt);
		if (evt.getPropertyName().equals("name"))
			refreshVisuals();
	}

	@Override
	protected void refreshVisuals() {
		ExecutionRule entity = getModelEntity();
		((RuleFigure) getFigure()).showName(!EntityUtils.isResolver(entity.getName()));
	}
}
