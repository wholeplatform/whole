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
package org.whole.lang.workflows.ui.editparts;

import java.beans.PropertyChangeEvent;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.IEntity;
import org.whole.lang.ui.editparts.AbstractContentPanePart;
import org.whole.lang.workflows.model.CreateJavaClassInstance;
import org.whole.lang.workflows.model.Expression;
import org.whole.lang.workflows.reflect.WorkflowsEntityDescriptorEnum;
import org.whole.lang.workflows.ui.figures.CreateJavaClassInstanceFigure;

/**
 * @author Riccardo Solmi
 */
public class CreateJavaClassInstancePart extends AbstractContentPanePart {
	protected IFigure createFigure() {
		return new CreateJavaClassInstanceFigure();
	}
	@Override
	public CreateJavaClassInstanceFigure getFigure() {
		return (CreateJavaClassInstanceFigure) super.getFigure();
	}

	protected List<IEntity> getModelSpecificChildren() {
		CreateJavaClassInstance entity = getModelEntity();
		List<IEntity> children = new ArrayList<IEntity>(6);
		children.add(entity.getLabel());
		children.add(entity.getClassName());
		children.add(entity.getConstructor());
//		children.add(entity.getTypeArguments());
		children.add(entity.getArguments());
		children.add(entity.getResult());
		return children;
	}

	@Override
	protected void propertyChangeUI(PropertyChangeEvent evt) {
		refresh();
	}
	@Override
	protected void refreshVisuals() {
		CreateJavaClassInstance entity = getModelEntity();
		Expression e = entity.getConstructor();
		String name = Matcher.matchImpl(WorkflowsEntityDescriptorEnum.StringLiteral, e) ?
				e.wStringValue() : "?";
				int endIndex = name.indexOf('(');
				if (endIndex > 0)
					name = name.substring(0, endIndex);
		getFigure().setConstructorName(name);
		super.refreshVisuals();
	}
}
