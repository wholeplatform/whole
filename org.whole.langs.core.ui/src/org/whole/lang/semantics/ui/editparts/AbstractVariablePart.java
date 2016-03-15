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

import org.whole.lang.semantics.model.AbstractVariable;
import org.whole.lang.semantics.ui.figures.AbstractVariableFigure;
import org.whole.lang.ui.editparts.AbstractContentPanePart;
import org.whole.lang.util.EntityUtils;

/**
 * @author Riccardo Solmi
 */
public abstract class AbstractVariablePart extends AbstractContentPanePart {
	@Override
	public AbstractVariableFigure getFigure() {
		return (AbstractVariableFigure) super.getFigure();
	}

	@Override
	protected void propertyChangeUI(PropertyChangeEvent evt) {
		if (evt.getPropertyName().equals("index") ||
				evt.getPropertyName().equals("time"))
			refreshVisuals();
		super.propertyChangeUI(evt);
	}

	@Override
	protected void refreshVisuals() {
		AbstractVariable entity = getModelEntity();
		getFigure().showSub(!EntityUtils.isResolver(entity.getIndex()));
		getFigure().showSup(!EntityUtils.isResolver(entity.getTime()));
	}
}
