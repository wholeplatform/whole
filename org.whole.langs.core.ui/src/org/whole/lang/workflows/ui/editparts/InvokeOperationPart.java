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
package org.whole.lang.workflows.ui.editparts;

import java.beans.PropertyChangeEvent;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.whole.lang.model.IEntity;
import org.whole.lang.ui.editparts.AbstractContentPanePart;
import org.whole.lang.workflows.model.InvokeOperation;
import org.whole.lang.workflows.ui.figures.InvokeOperationFigure;

/**
 * @author Enrico Persiani
 */
public class InvokeOperationPart extends AbstractContentPanePart {
	protected IFigure createFigure() {
		return new InvokeOperationFigure();
	}
	@Override
	public InvokeOperationFigure getFigure() {
		return (InvokeOperationFigure) super.getFigure();
	}

	protected List<IEntity> getModelSpecificChildren() {
		InvokeOperation entity = getModelEntity();
		List<IEntity> children = new ArrayList<IEntity>(4);
		children.add(entity.getLabel());
		children.add(entity.getModel());
		children.add(entity.getOperation());
		children.add(entity.getBindings());
		return children;
	}

	@Override
	protected void propertyChangeUI(PropertyChangeEvent evt) {
		refresh();
	}
}
