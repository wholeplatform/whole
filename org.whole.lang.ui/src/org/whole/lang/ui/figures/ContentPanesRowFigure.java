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
package org.whole.lang.ui.figures;

import org.eclipse.draw2d.IFigure;
import org.whole.lang.ui.layout.RowLayout;


/**
 * @author Riccardo Solmi
 */
public class ContentPanesRowFigure extends ContentPaneFigure {
	public ContentPanesRowFigure(String prefix, int contentPanes) {
		this(LabelFactory.createDeclaration(prefix), contentPanes);
	}
	public ContentPanesRowFigure(IFigure prefix, int contentPanes) {
		this(prefix, contentPanes, "(", ")", ", ");
	}
	public ContentPanesRowFigure(IFigure prefix, int contentPanes, String lparen, String rparen, String separator) {
		super(new RowLayout());
		initContentPanes(contentPanes);

		add(prefix);
		addContentLighter(lparen);
		add(createContentPane(0));
		for (int i=1; i<contentPanes; i++) {
			addContentLighter(separator);
			add(createContentPane(i));
		}
		addContentLighter(rparen);
	}

	@Override
	public RowLayout getLayoutManager() {
		return (RowLayout) super.getLayoutManager();
	}
}
