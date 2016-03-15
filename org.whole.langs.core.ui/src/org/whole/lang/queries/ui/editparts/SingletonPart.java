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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.whole.lang.model.IEntity;
import org.whole.lang.queries.model.Singleton;
import org.whole.lang.queries.ui.figures.SingletonFigure;
import org.whole.lang.ui.editparts.AbstractContentPanePart;
import org.whole.lang.ui.editparts.IEntityPart;
import org.whole.lang.ui.layout.IEntityLayout;
import org.whole.lang.ui.util.AnimableRunnable;

/**
 * @author Riccardo Solmi
 */
public class SingletonPart extends AbstractContentPanePart {
	protected IFigure createFigure() {
		return new SingletonFigure();
	}

	protected List<IEntity> getModelSpecificChildren() {
		Singleton entity = getModelEntity();
		List<IEntity> list = new ArrayList<IEntity>(1);
		list.add(entity.getExpression());
		return list;
	}

	@Override
	public void setDetailed(boolean value, IEntityPart childPart) {
		if (isDetailed() == value)
			return;

		super.setDetailed(value, childPart);

		IEntityLayout lm = (IEntityLayout) getFigure().getLayoutManager();
		lm.setSpacedChild(value ? IEntityLayout.SPACED_ALL : IEntityLayout.SPACED_NONE);
	
		new AnimableRunnable() {
			public void doRun() {
				getFigure().revalidate();
				getFigure().repaint();
			}
		}.syncExec();
	}
}