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
package org.whole.lang.features.ui.figures;

import org.eclipse.draw2d.ActionListener;
import org.whole.lang.ui.WholeImages;
import org.whole.lang.ui.figures.ContentPaneFigure;
import org.whole.lang.ui.figures.EntityToggle;
import org.whole.lang.ui.layout.RowLayout;

/**
 * @author Riccardo Solmi
 */
public class VariableFeatureRightFigure extends ContentPaneFigure {
	public VariableFeatureRightFigure(ActionListener toggleListener) {
		super(new RowLayout() {
			@Override
			protected int getIndent() {
				return childSize[0].width + getSpacingBefore(1);
			}
		}.withMarginLeft(-2).withMarginRight(6));
		initContentPanes(1);

		add(createActionableFoldingToggle(new EntityToggle(
				WholeImages.CHOICE_NOT_SELECTED, WholeImages.CHOICE_SELECTED, toggleListener)));
		add(createContentPane(0));
	}

	public void setVariableValue(boolean value) {
		getFoldingToggle(0).setSelected(value);
	}
}
