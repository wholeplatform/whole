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
package org.whole.lang.sql.ui.editparts;

import java.beans.PropertyChangeEvent;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.whole.lang.model.IEntity;
import org.whole.lang.sql.reflect.OperatorGroupEnum;
import org.whole.lang.sql.reflect.SQLFeatureDescriptorEnum;
import org.whole.lang.sql.ui.figures.BinaryExpressionFigure;
import org.whole.lang.ui.editparts.AbstractContentPanePart;

/**
 * @author Riccardo Solmi
 */
public class BinaryExpressionPart extends AbstractContentPanePart {
    protected IFigure createFigure() {
    	return new BinaryExpressionFigure();
    }

	protected void propertyChangeUI(PropertyChangeEvent evt) {
		if (evt.getPropertyName().equals(SQLFeatureDescriptorEnum.operator.getName()))
			getParent().refresh();
		refresh();
	}

	protected void refreshVisuals() {
		IEntity entity = getModelEntity();
		IEntity exp1 = entity.wGet(SQLFeatureDescriptorEnum.leftExpr);
		IEntity exp2 = entity.wGet(SQLFeatureDescriptorEnum.rightExpr);

		refreshPrecedence(entity, exp1, exp2);
	}
	protected void refreshPrecedence(IEntity exp, IEntity exp1, IEntity exp2) {
		BinaryExpressionFigure fig = (BinaryExpressionFigure) getFigure();
		fig.showLeftParen(OperatorGroupEnum.hasPrecedence(exp, exp1));
		fig.showRightParen(OperatorGroupEnum.hasPrecedence(exp, exp2));
	}

	protected List<IEntity> getModelSpecificChildren() {
		IEntity entity = getModelEntity();
		List<IEntity> list = new ArrayList<IEntity>(3);
		list.add(entity.wGet(SQLFeatureDescriptorEnum.leftExpr));
		list.add(entity.wGet(SQLFeatureDescriptorEnum.operator));
		list.add(entity.wGet(SQLFeatureDescriptorEnum.rightExpr));
		return list;
	}
}

