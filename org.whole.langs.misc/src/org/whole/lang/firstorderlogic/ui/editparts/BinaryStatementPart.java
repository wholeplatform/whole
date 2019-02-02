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
package org.whole.lang.firstorderlogic.ui.editparts;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.whole.lang.firstorderlogic.reflect.FirstOrderLogicFeatureDescriptorEnum;
import org.whole.lang.firstorderlogic.reflect.StatementGroupEnum;
import org.whole.lang.firstorderlogic.ui.figures.BinaryStatementFigure;
import org.whole.lang.model.IEntity;
import org.whole.lang.ui.editparts.AbstractContentPanePart;


/**
 * @author Riccardo Solmi
 */
public class BinaryStatementPart extends AbstractContentPanePart {
	private final String opStr;
	
	public BinaryStatementPart(String opStr) {
		this.opStr = opStr;
	}
	
	protected IFigure createFigure() {
		return new BinaryStatementFigure(opStr);
	}
	
	protected List<IEntity> getModelSpecificChildren() {
		IEntity entity = getModelEntity();
		IEntity exp1 = entity.wGet(FirstOrderLogicFeatureDescriptorEnum.leftFormula);
		IEntity exp2 = entity.wGet(FirstOrderLogicFeatureDescriptorEnum.rightFormula);
		
		refreshPrecedence(entity, exp1, exp2);
		
		List<IEntity> list = new ArrayList<IEntity>(2);
		list.add(exp1);
		list.add(exp2);
		return list;
	}

	protected void refreshPrecedence(IEntity exp, IEntity exp1, IEntity exp2) {
		BinaryStatementFigure fig = (BinaryStatementFigure) getFigure();
		fig.showLeftParen(StatementGroupEnum.hasPrecedence(exp, exp1));
		fig.showRightParen(StatementGroupEnum.hasPrecedence(exp, exp2));
	}
}