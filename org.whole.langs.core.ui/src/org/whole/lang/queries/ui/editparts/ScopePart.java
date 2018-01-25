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
package org.whole.lang.queries.ui.editparts;

import java.beans.PropertyChangeEvent;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.IEntity;
import org.whole.lang.queries.model.Scope;
import org.whole.lang.queries.reflect.QueriesEntityDescriptorEnum;
import org.whole.lang.queries.ui.figures.ScopeFigure;
import org.whole.lang.ui.editparts.AbstractContentPanePart;

/**
 * @author Riccardo Solmi
 */
public class ScopePart extends AbstractContentPanePart {
	protected IFigure createFigure() {
		return new ScopeFigure();
	}
	@Override
	public ScopeFigure getFigure() {
		return (ScopeFigure) super.getFigure();
	}

	protected List<IEntity> getModelSpecificChildren() {
		Scope entity = getModelEntity();
		List<IEntity> list = new ArrayList<IEntity>(2);
		list.add(entity.getLocalNames());
		list.add(entity.getExpression());
		return list;
	}

	@Override
	protected void propertyChangeUI(PropertyChangeEvent evt) {
		refreshVisuals();
		super.propertyChangeUI(evt);
	}

	@Override
	protected void refreshVisuals() {
		Scope entity = getModelEntity();
		boolean dashedBorder = Matcher.matchImpl(QueriesEntityDescriptorEnum.ScopeNames, entity.getLocalNames());
		getFigure().showDashedBorder(dashedBorder);
	}
}
