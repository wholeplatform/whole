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
package org.whole.lang.ui.notations.table.editparts;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.ActionEvent;
import org.eclipse.draw2d.ActionListener;
import org.eclipse.draw2d.Clickable;
import org.eclipse.draw2d.IFigure;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.ui.editparts.AbstractContentPanePart;
import org.whole.lang.ui.notations.table.figures.SimpleEntityTableRowFigure;

/**
 * @author Riccardo Solmi
 */
public class SimpleEntityTableRowPart extends AbstractContentPanePart {
	protected EntityDescriptor<?> ed;

	public SimpleEntityTableRowPart(EntityDescriptor<?> ed) {
		this.ed = ed;
	}

	protected IFigure createFigure() {
		return new SimpleEntityTableRowFigure(ed, new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				Clickable linkButton = (Clickable) event.getSource();
				int index = (Integer) linkButton.getModel().getUserData();

				getViewer().selectAndReveal(getModelEntity().wGet(index));
			}
		});
	}

	protected List<IEntity> getModelSpecificChildren() {
		IEntity entity = getModelEntity();
		int size = entity.wSize();
		List<IEntity> children = new ArrayList<IEntity>(size);
		for (int i=0; i<size; i++)
			children.add(entity.wGet(i));
		return children;
	}
}
