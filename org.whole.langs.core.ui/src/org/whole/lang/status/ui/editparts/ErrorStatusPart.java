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
package org.whole.lang.status.ui.editparts;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.ActionEvent;
import org.eclipse.draw2d.ActionListener;
import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.EditPartViewer;
import org.whole.lang.model.IEntity;
import org.whole.lang.status.ui.figures.ErrorStatusFigure;
import org.whole.lang.ui.editparts.AbstractContentPanePart;

/**
 * @author Enrico Persiani
 */
public class ErrorStatusPart extends AbstractContentPanePart {

	public ErrorStatusPart() {
	}

	@Override
	protected IFigure createFigure() {
		return new ErrorStatusFigure(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				EditPartViewer viewer = getViewer();
				try {
					//FIXME workaround due to dependency cycles
					// when E4 migration is complete getViewer() should
					// return an IEntityPartViewer instance
					viewer.getClass().getMethod("reloadContents").invoke(viewer);
				} catch (Exception e) {
				}
			}
		});
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
