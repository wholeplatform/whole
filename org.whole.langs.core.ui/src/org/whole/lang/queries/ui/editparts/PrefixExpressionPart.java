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
package org.whole.lang.queries.ui.editparts;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.whole.lang.model.IEntity;
import org.whole.lang.queries.reflect.OperatorGroupEnum;
import org.whole.lang.queries.reflect.QueriesFeatureDescriptorEnum;
import org.whole.lang.queries.ui.figures.PrefixExpressionFigure;
import org.whole.lang.ui.editparts.AbstractContentPanePart;

/**
 * @author Riccardo Solmi
 */
public class PrefixExpressionPart extends AbstractContentPanePart {
	private final String opStr;
	
	public PrefixExpressionPart(String opStr) {
		this.opStr = opStr;
	}
	
	protected IFigure createFigure() {
		return new PrefixExpressionFigure(opStr);
	}
	
	protected List<IEntity> getModelSpecificChildren() {
		IEntity entity = getModelEntity();
		IEntity expression = entity.wGet(QueriesFeatureDescriptorEnum.expression);
		
		refreshPrecedence(entity, expression);
		
		List<IEntity> list = new ArrayList<IEntity>(1);
		list.add(expression);
		return list;
	}

	protected void refreshPrecedence(IEntity exp, IEntity expression) {
		PrefixExpressionFigure fig = (PrefixExpressionFigure) getFigure();
		fig.showRightParen(OperatorGroupEnum.hasPrecedence(exp, expression));
	}
}
