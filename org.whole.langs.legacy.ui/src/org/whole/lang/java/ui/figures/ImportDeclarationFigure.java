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
package org.whole.lang.java.ui.figures;

import org.eclipse.draw2d.ActionListener;
import org.whole.lang.ui.figures.ContentPaneFigure;
import org.whole.lang.ui.figures.EntityLabel;
import org.whole.lang.ui.figures.EntityToggle;
import org.whole.lang.ui.figures.LabelFactory;
import org.whole.lang.ui.layout.RowLayout;

/**
 *  @author Riccardo Solmi
 */
public class ImportDeclarationFigure extends ContentPaneFigure {
	public ImportDeclarationFigure(ActionListener a1, ActionListener a2) {
		super(new RowLayout().withSpacing(0));
		initContentPanes(1);
		addKeyword("import");
		add(createActionableFoldingToggle(new EntityToggle(" ", " static ", a1) {
			protected EntityLabel createLabel(String text) {
				return LabelFactory.createKeyword(text);
			}
		}));
		add(createContentPane(0));
		add(createActionableFoldingToggle(new EntityToggle(" ", ".*", a2) {
			protected EntityLabel createLabel(String text) {
				return LabelFactory.createIdentifier(text);
			}
		}));
		addContentLighter(";");
	}

	public void setStaticModifier(boolean value) {
		getFoldingToggle(0).setSelected(value);
	}

	public void setOnDemandModifier(boolean value) {
		getFoldingToggle(1).setSelected(value);
	}
}
