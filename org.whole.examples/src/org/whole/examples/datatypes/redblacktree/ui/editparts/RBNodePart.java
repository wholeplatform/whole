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
package org.whole.examples.datatypes.redblacktree.ui.editparts;

import java.beans.PropertyChangeEvent;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.whole.examples.datatypes.redblacktree.model.Color;
import org.whole.examples.datatypes.redblacktree.model.ColorEnum;
import org.whole.examples.datatypes.redblacktree.model.RBNode;
import org.whole.examples.datatypes.redblacktree.ui.figures.RBNodeFigure;
import org.whole.lang.model.IEntity;
import org.whole.lang.ui.editparts.AbstractContentPanePart;
import org.whole.lang.util.DataTypeUtils;

/**
 * @author Riccardo Solmi
 */
public class RBNodePart extends AbstractContentPanePart {
	protected IFigure createFigure() {
		return new RBNodeFigure();
	}

	@Override
	public RBNodeFigure getFigure() {
		return (RBNodeFigure) super.getFigure();
	}

	@SuppressWarnings("unchecked")
	@Override
	public RBNode getModelEntity() {
		return (RBNode) super.getModelEntity();
	}

	@Override
	protected void propertyChangeUI(PropertyChangeEvent evt) {
		refreshVisuals();
		super.propertyChangeUI(evt);
	}

	@Override
	protected void refreshVisuals() {
		Color colorEntity = getModelEntity().getColor();
		boolean isBlack = DataTypeUtils.getDataKind(colorEntity).isEnumValue() && colorEntity.getValue().equals(ColorEnum.BLACK);
		getFigure().setBlackColor(isBlack);
	}

	protected List<IEntity> getModelSpecificChildren() {
		RBNode entity = getModelEntity();
		List<IEntity> children = new ArrayList<IEntity>(3);
		children.add(entity.getValue());
		children.add(entity.getLeft());
		children.add(entity.getRight());
		return children;
	}
}
