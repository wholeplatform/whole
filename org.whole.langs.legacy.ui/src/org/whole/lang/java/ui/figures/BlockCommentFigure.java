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

import org.eclipse.draw2d.MarginBorder;
import org.whole.lang.ui.figures.ContentPaneFigure;
import org.whole.lang.ui.figures.EntityFigure;
import org.whole.lang.ui.figures.EntityLabel;
import org.whole.lang.ui.figures.LabelFactory;
import org.whole.lang.ui.layout.ColumnLayout;
import org.whole.lang.ui.layout.RowLayout;

/**
 *  @author Enrico Persiani
 */
public class BlockCommentFigure extends ContentPaneFigure {
	private EntityLabel closeComment;

	public BlockCommentFigure(boolean collapsed) {
		this(false, collapsed);
	}
	public BlockCommentFigure(boolean javadocStyle, boolean collapsed) {
		super(new ColumnLayout());
		initContentPanes(1);
		EntityFigure row;

		add(row = new EntityFigure(new RowLayout().withSpacing(4)));
		row.add(createFoldingToggle(0));
		row.addContentLighter(javadocStyle ? "/**" : "/*");

		add(createContentPane(0, new MarginBorder(0,16,0,0)));
		add(closeComment = LabelFactory.createContentLighter("*/"));

		if (collapsed)
			clickFoldingToggle(0);
	}

	protected void toggleVisibility(int paneIndex) {
		if (paneIndex == 0)
			closeComment.setVisible(!closeComment.isVisible());
		super.toggleVisibility(paneIndex);
	}
}
