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
package org.whole.lang.java.ui.figures;

import org.eclipse.draw2d.ActionListener;
import org.whole.lang.ui.figures.ContentPaneFigure;
import org.whole.lang.ui.figures.EntityFigure;
import org.whole.lang.ui.figures.EntityLabel;
import org.whole.lang.ui.figures.EntityToggle;
import org.whole.lang.ui.figures.LabelFactory;
import org.whole.lang.ui.layout.ColumnLayout;
import org.whole.lang.ui.layout.RowLayout;

/**
 *  @author Riccardo Solmi
 */
public class ModuleDeclarationFigure extends ContentPaneFigure {
	public ModuleDeclarationFigure(ActionListener a) {
		super(new ColumnLayout());
		initContentPanes(4);
		EntityFigure row;
		add(createContentPane(0));
		add(row = new EntityFigure(new RowLayout().withSpacing(4)));
		row.add(createFoldingToggle(3));
		row.add(createContentPane(1));
		row.add(createActionableFoldingToggle(new EntityToggle(" ", "open", a) {
			protected EntityLabel createLabel(String text) {
				return LabelFactory.createKeyword(text);
			}
		}));
		row.addKeyword("module");
		row.add(createContentPane(2));
		row.addContentLighter("{");
		add(row = new EntityFigure(new RowLayout().withSpacing(4)));
		row.add(new EntityLabel("    "));
		row.add(createContentPane(3));
		addContentLighter("}");
	}


	public void setOpenModule(boolean value) {
		getFoldingToggle(1).setSelected(value);
	}
}
