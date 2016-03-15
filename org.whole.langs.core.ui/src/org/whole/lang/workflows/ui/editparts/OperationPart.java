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

import org.eclipse.draw2d.IFigure;
import org.eclipse.swt.graphics.Image;
import org.whole.lang.ui.editparts.IdentifierDataEntityPart;
import org.whole.lang.ui.figures.EntityLabel;
import org.whole.lang.ui.notations.NotationImages;
import org.whole.lang.workflows.model.Operation;
import org.whole.lang.workflows.model.OperationEnum;

/**
 * @author Enrico Persiani
 */
public class OperationPart extends IdentifierDataEntityPart {
	@Override
	public IFigure createFigure() {
		EntityLabel label = (EntityLabel) super.createFigure();
		Operation operation = getModelEntity();
		Image operationIcon = null;
		switch (operation.getValue().getOrdinal()) {
		case OperationEnum.VALIDATOR_ord:
			operationIcon = NotationImages.VALIDATE16;
			break;
		case OperationEnum.NORMALIZER_ord:
			operationIcon = NotationImages.NORMALIZE16;
			break;
		case OperationEnum.PRETTY_PRINTER_ord:
			operationIcon = NotationImages.PRETTY_PRINT16;
			break;
		case OperationEnum.INTERPRETER_ord:
			operationIcon = NotationImages.INTERPRET16;
			break;
		case OperationEnum.ARTIFACTS_GENERATOR_ord:
			operationIcon = NotationImages.GENERATE_ARTIFACTS16;
			break;
		case OperationEnum.JAVA_COMPILER_ord:
			operationIcon = NotationImages.GENERATE_JAVA16;
			break;
		}
		label.setIcon(operationIcon);
		return label;
	}
}
