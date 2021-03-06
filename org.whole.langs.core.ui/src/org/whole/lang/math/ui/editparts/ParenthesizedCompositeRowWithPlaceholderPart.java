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
package org.whole.lang.math.ui.editparts;

import java.beans.PropertyChangeEvent;
import java.util.BitSet;

import org.eclipse.draw2d.IFigure;
import org.whole.lang.math.reflect.OperatorGroupEnum;
import org.whole.lang.math.ui.figures.ParenthesizedMathCompositeRowFigure;
import org.whole.lang.model.IEntity;
import org.whole.lang.ui.editparts.CompositeRowWithPlaceholderPart;

/**
 * @author Riccardo Solmi
 */
public class ParenthesizedCompositeRowWithPlaceholderPart extends CompositeRowWithPlaceholderPart {
    protected IFigure createFigure() {
        return new ParenthesizedMathCompositeRowFigure("\u2022", 9);
    }

	@Override
	public ParenthesizedMathCompositeRowFigure getFigure() {
		return (ParenthesizedMathCompositeRowFigure) super.getFigure();
	}

	@Override
	protected void propertyChangeUI(PropertyChangeEvent evt) {
		refreshVisuals();
		super.propertyChangeUI(evt);
	}

	@Override
	protected void refreshVisuals() {
		IEntity entity = getModelEntity();
		BitSet showParentheses = new BitSet(entity.wSize());
		for (int i = 0; i < entity.wSize(); i++)
			showParentheses.set(i, OperatorGroupEnum.hasPrecedence(entity, entity.wGet(i)));
		getFigure().setShowParentheses(showParentheses);
	}
}
