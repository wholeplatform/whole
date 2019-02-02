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
package org.whole.lang.grammarbased.ui.editparts;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.whole.lang.grammarbased.ui.figures.SimpleEntityFigure;
import org.whole.lang.model.IEntity;
import org.whole.lang.ui.editparts.AbstractContentPanePart;

/**
 * @author Enrico Persiani
 */
public class SimpleEntityPart extends AbstractContentPanePart {
	protected IEntity configuration;

	public SimpleEntityPart(IEntity configuration) {
		this.configuration = configuration;
	}

	@Override
	protected IFigure createFigure() {
		return new SimpleEntityFigure(configuration);
	}

	@Override
	protected List<IEntity> getModelSpecificChildren() {
		IEntity entity = getModelEntity();
		int size = entity.wSize();
		List<IEntity> list = new ArrayList<IEntity>(size);
		for (int i=0; i<size; i++)
			list.add(entity.wGet(i));
		return list;
	}
}
