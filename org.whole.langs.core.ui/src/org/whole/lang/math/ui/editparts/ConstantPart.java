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
package org.whole.lang.math.ui.editparts;

import org.eclipse.draw2d.IFigure;
import org.whole.lang.math.model.ConstantEnum;
import org.whole.lang.ui.editparts.AbstractDataEntityPart;
import org.whole.lang.ui.figures.LabelFactory;

/**
 * @author Riccardo Solmi
 */
public class ConstantPart extends AbstractDataEntityPart {
	public IFigure createFigure() {
		return LabelFactory.createSymbolRegularContent("");
	}

	@Override
	protected void refreshVisuals() {
		String text;
		switch (getModelEntity().wEnumValue().getOrdinal()) {
		case ConstantEnum.pi_ord:
			text = "\u03c0";
			break;
		case ConstantEnum.e_ord:
			text = "e";
			break;
		case ConstantEnum.i_ord:
			text = "i";
			break;
		case ConstantEnum.gamma_ord:
			text = "\u03b3";
			break;
		case ConstantEnum.infinity_ord:
			text = "\u221e";
			break;		
		default:
			throw new IllegalStateException();
		}
		getLabel().setText(text);
	}
}
