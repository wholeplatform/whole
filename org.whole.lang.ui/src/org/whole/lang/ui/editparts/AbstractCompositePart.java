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
package org.whole.lang.ui.editparts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.EditPolicy;
import org.whole.lang.model.IEntity;
import org.whole.lang.ui.editpolicies.IHilightable;
import org.whole.lang.ui.editpolicies.WholeFlowHilightEditPolicy;
import org.whole.lang.ui.editpolicies.WholeFlowLayoutEditPolicy;
import org.whole.lang.ui.figures.IEntityFigure;
import org.whole.lang.ui.layout.IEntityLayout;
import org.whole.lang.ui.util.AnimableRunnable;



/**
 * @author Riccardo Solmi
 */
public abstract class AbstractCompositePart extends AbstractPart implements IHilightable {
	int hilightPosition = -1;

	@Override
	@SuppressWarnings("rawtypes")
	public Object getAdapter(Class key) {
		if (key == IHilightable.class)
			return this;
		return super.getAdapter(key);
	}

	protected List<IEntity> getModelChildren() {
		IEntity entity = getModelEntity();
		int size = entity.wSize();
		if (size == 0)
			return Collections.emptyList();

		List<IEntity> result = new ArrayList<IEntity>(size);
		if (isModelChildrenReversed())
			for (int i=size-1; i>=0; i--)
				result.add(entity.wGet(i));
		else
			for (int i=0; i<size; i++)
				result.add(entity.wGet(i));

		return result;
    }

    protected void createEditPolicies() {
		super.createEditPolicies();
       	installEditPolicy(EditPolicy.LAYOUT_ROLE, new WholeFlowLayoutEditPolicy(getCommandFactory()));
    	installEditPolicy(EditPolicy.SELECTION_FEEDBACK_ROLE, new WholeFlowHilightEditPolicy());
    }

	public int getHilightPosition() {
		return hilightPosition;
	}

	public void setHilightPosition(int hilightPosition) {
		this.hilightPosition = hilightPosition;
	}

	public IEntityFigure getContentPaneFigure() {
		return (IEntityFigure) getFigure();
	}

	public IFigure getContentPane(int index) {
		return getContentPaneFigure().getContentPane(index);
	}
	public IFigure getContentPane() {
		return getContentPaneFigure().getContentPane(0);
	}

	@Override
	public void setDetailed(boolean value, IEntityPart childPart) {
		if (isDetailed() == value)
			return;

		super.setDetailed(value, childPart);

		IEntityLayout lm = (IEntityLayout) getFigure().getLayoutManager();
		int childIndex = getChildren().indexOf(childPart);
		
		lm.setSpacedChild(value ? (childIndex != -1 ? childIndex : IEntityLayout.SPACED_ALL) : IEntityLayout.SPACED_NONE);

		new AnimableRunnable() {
			public void doRun() {
				getFigure().revalidate();
				getFigure().repaint();
			}
		}.syncExec();
	}
}
