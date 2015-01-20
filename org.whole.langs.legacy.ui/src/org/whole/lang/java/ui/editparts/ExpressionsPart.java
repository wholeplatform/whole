/**
 * Copyright 2004-2014 Riccardo Solmi. All rights reserved.
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
package org.whole.lang.java.ui.editparts;

import java.beans.PropertyChangeEvent;

import org.eclipse.draw2d.IFigure;
import org.whole.lang.java.model.Expressions;
import org.whole.lang.java.model.InfixOperatorEnum;
import org.whole.lang.java.reflect.JavaEntityDescriptorEnum;
import org.whole.lang.java.reflect.JavaFeatureDescriptorEnum;
import org.whole.lang.java.ui.figures.ExpressionsFigure;
import org.whole.lang.java.ui.figures.ExpressionsFigure.DecorationEnum;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.IEntity;
import org.whole.lang.ui.editparts.AbstractCompositePart;
import org.whole.lang.util.EntityUtils;

/**
 * @author Enrico Persiani
 */
public class ExpressionsPart extends AbstractCompositePart {
	protected IFigure createFigure() {
		return new ExpressionsFigure();
	}

	@Override
	public ExpressionsFigure getFigure() {
		return (ExpressionsFigure) super.getFigure();
	}
	
	@Override
	protected void propertyChangeUI(PropertyChangeEvent evt) {
		refreshVisuals();
		super.propertyChangeUI(evt);
	}


	public boolean isArrayCreation(IEntity entity) {
		IEntity parent = entity.wGetParent();
		if (EntityUtils.isNull(entity))
			return false;
		else if (Matcher.match(JavaEntityDescriptorEnum.ArrayType, parent))
			return isArrayCreation(parent);
		else
			return Matcher.match(JavaEntityDescriptorEnum.ArrayCreation, parent);
	}

	@Override
	protected void refreshVisuals() {
		Expressions entity = getModelEntity();
		IEntity parent = entity.wGetParent();
		if (EntityUtils.isNull(parent))
			getFigure().setDecoration(DecorationEnum.UNKNOWN);
		else
			switch (parent.wGetEntityDescriptor().getOrdinal()) {
			case JavaEntityDescriptorEnum.ArrayCreation_ord:
				getFigure().setDecoration(DecorationEnum.PARENTHESIS);
				break;
			case JavaEntityDescriptorEnum.ForStatement_ord:
				getFigure().setDecoration(DecorationEnum.SEPARATORS);
				break;
			case JavaEntityDescriptorEnum.InfixExpression_ord:
				IEntity operator = parent.wGet(JavaFeatureDescriptorEnum.operator);
				getFigure().setDecoration(
						Matcher.matchImpl(JavaEntityDescriptorEnum.InfixOperator, operator) &&
						operator.wEnumValue().equals(InfixOperatorEnum.plus) ?
								DecorationEnum.PLUS_OPERATORS : DecorationEnum.TIMES_OPERATORS);
				break;
			}
	}
}