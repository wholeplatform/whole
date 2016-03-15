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
package org.whole.lang.frames.ui.editparts;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.whole.lang.frames.factories.FramesEntityFactory;
import org.whole.lang.frames.model.ReusePoint;
import org.whole.lang.frames.ui.figures.ReusePointFigure;
import org.whole.lang.frames.util.FramesUtils;
import org.whole.lang.model.IEntity;
import org.whole.lang.ui.editparts.AbstractContentPanePart;

/**
 * @author Riccardo Solmi
 */
public class ReusePointPart extends AbstractContentPanePart {
	protected IFigure createFigure() {
		return new ReusePointFigure();
	}

	protected List<IEntity> getModelSpecificChildren() {
		ReusePoint entity = getModelEntity();

		IEntity frame = null;
		try {
			frame = FramesUtils.getActiveVariant(entity, getViewer().getContextBindings());
		} catch(Exception e) {
		}
		if (frame == null)//FIXME or VoidImpl
			frame = FramesEntityFactory.instance.createEmpty();

		List<IEntity> children = new ArrayList<IEntity>(5);
		children.add(entity.getFrame());
		children.add(entity.getConfiguration());
		children.add(entity.getRelations());
		children.add(entity.getAdvices());
		children.add(frame);
		return children;
	}
}
