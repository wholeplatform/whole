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
package org.whole.lang.grammars.ui.figures;

import org.eclipse.draw2d.ColorConstants;
import org.whole.lang.ui.figures.LabelFactory;
import org.whole.lang.ui.layout.FractionLayout;

/**
 * @author Riccardo Solmi
 */
public class NewLineFigure extends RuleFractionFigure {
	public NewLineFigure() {
		super(new FractionLayout() {
			protected int getDividendIndex() {
				return 1;
			}
			protected int getDivisorIndex() {
				return 2;
			}
			protected int getFractionIndex() {
				return 0;
			}
		});
		addEmptyLabel();
		add(LabelFactory.createSymbolMedium("\u21a9", ColorConstants.lightGray));
	}
}