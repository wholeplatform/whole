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
package org.whole.lang.firstorderlogic.ui.editparts;


import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.whole.lang.firstorderlogic.reflect.FirstOrderLogicFeatureDescriptorEnum;
import org.whole.lang.firstorderlogic.reflect.StatementGroupEnum;
import org.whole.lang.firstorderlogic.ui.figures.QuantifierFigure;
import org.whole.lang.model.IEntity;
import org.whole.lang.ui.editparts.AbstractContentPanePart;

/**
 * @author Riccardo Solmi
 */
public class QuantifierPart extends AbstractContentPanePart{
	private final String opStr;
	
	public QuantifierPart(String opStr) {
		this.opStr = opStr;
	}
    protected IFigure createFigure() {
        return new QuantifierFigure(opStr);
    }

    protected List<IEntity> getModelSpecificChildren() {
    	IEntity entity = getModelEntity();
    	IEntity exp1 = entity.wGet(FirstOrderLogicFeatureDescriptorEnum.formula);
    	
		refreshPrecedence(entity, exp1);
    	
    	List<IEntity> children = new ArrayList<IEntity>(2);
    	children.add(entity.wGet(FirstOrderLogicFeatureDescriptorEnum.parameters));
    	children.add(exp1);
    	return children;
    }

	protected void refreshPrecedence(IEntity exp, IEntity exp1) {
		QuantifierFigure fig = (QuantifierFigure) getFigure();
		fig.showParen(StatementGroupEnum.hasPrecedence(exp, exp1));
	}
	
}
