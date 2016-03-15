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

import org.eclipse.draw2d.IFigure;
import org.whole.lang.ui.figures.ContentPaneFigure;
import org.whole.lang.ui.figures.EntityFigure;
import org.whole.lang.ui.layout.RowLayout;

/**
 *  @author Enrico Persiani
 */
public class TagElementFigure extends ContentPaneFigure {
	private EntityFigure tagName;
	private IFigure fragments;
	private IFigure leftCurly;
	private IFigure rithtCurly;

	public TagElementFigure() {
		super(new RowLayout().withSpacing(8));
		initContentPanes(2);
		
		leftCurly = addContentLighter("{");
		tagName = new EntityFigure(new RowLayout().withSpacing(1));
		tagName.addLiteral("@");
		tagName.add(createContentPane(0));
		add(tagName);

		fragments = createContentPane(1);
		add(fragments);

		rithtCurly = addContentLighter("}");
	}

	public void showTagName(boolean visible) {
		tagName.setVisible(visible);
	}

	public void showInline(boolean visible) {
		leftCurly.setVisible(visible);
		rithtCurly.setVisible(visible);
	}
}