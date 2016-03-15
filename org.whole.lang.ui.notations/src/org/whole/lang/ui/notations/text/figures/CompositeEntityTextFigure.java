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
package org.whole.lang.ui.notations.text.figures;

import org.eclipse.draw2d.IFigure;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.ui.figures.ContentPaneFigure;
import org.whole.lang.ui.figures.CompositeFigure;
import org.whole.lang.ui.figures.EntityFigure;
import org.whole.lang.ui.layout.ColumnLayout;
import org.whole.lang.ui.layout.RowLayout;

/**
 * @author Riccardo Solmi
 */
public class CompositeEntityTextFigure extends ContentPaneFigure {
	private IFigure delimiter1, delimiter2;

	public CompositeEntityTextFigure(EntityDescriptor<?> ed) {
		super(new ColumnLayout());
		initContentPanes(1);

		EntityFigure typeRow = new EntityFigure(new RowLayout().withSpacing(3));
		typeRow.add(createFoldingToggle(0));
		typeRow.addDeclaration(ed.getName());
		typeRow.addContentLight("[");
		typeRow.add(delimiter1 = addContentLight("]"));
		add(typeRow);

		CompositeFigure compositeFigure = new CompositeFigure(
				new ColumnLayout().withSpacing(5).withMarginLeft(24));
		compositeFigure.setBorder(null);
		add(createContentPane(0, compositeFigure));

		delimiter2 = addContentLight("]");
		
		delimiter1.setVisible(false);
	}

	@Override
	protected void toggleVisibility(int paneIndex) {
		if (paneIndex == 0) {
			IFigure contentPane = getContentPane(paneIndex);
			boolean visible = !contentPane.isVisible();
			delimiter1.setVisible(!visible);
			contentPane.setVisible(visible);
			delimiter2.setVisible(visible);
		} else
			super.toggleVisibility(paneIndex);
	}
}
