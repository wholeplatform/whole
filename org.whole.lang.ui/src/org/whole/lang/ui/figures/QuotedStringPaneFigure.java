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
package org.whole.lang.ui.figures;

import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.whole.lang.ui.layout.RowLayout;

/**
 * @author Riccardo Solmi
 */
public class QuotedStringPaneFigure extends ContentPaneFigure {
	public QuotedStringPaneFigure() {
		this(LabelFactory.createLiteral());
	}
	public QuotedStringPaneFigure(IEntityFigure label) {
		this(label, LabelFactory.createContentLighter("\""), LabelFactory.createContentLighter("\""));
	}
	public QuotedStringPaneFigure(IEntityFigure label, IFigure lquote, IFigure rquote) {
		super(new RowLayout());
		initContentPanes(1);

	    add(lquote);
		add(createContentPane(0, label));
	    add(rquote);
	}

	public void showQuotes(boolean visible) {
		List<? extends IFigure> children = getChildren();
		if (children.size() < 3)
			return;

		children.get(0).setVisible(visible);
		children.get(2).setVisible(visible);
	}
}