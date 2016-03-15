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
package org.whole.lang.status.ui.figures;

import org.eclipse.draw2d.ActionListener;
import org.whole.lang.ui.figures.ContentPaneFigure;
import org.whole.lang.ui.figures.EntityButton;
import org.whole.lang.ui.figures.EntityFigure;
import org.whole.lang.ui.figures.LabelFactory;
import org.whole.lang.ui.layout.ColumnLayout;
import org.whole.lang.ui.layout.RowLayout;

/**
 * @author Enrico Persiani
 */
public class ErrorStatusFigure extends ContentPaneFigure {
	public ErrorStatusFigure(ActionListener linkListener) {
		super(new ColumnLayout().withMargin(10).withSpacing(5));
		initContentPanes(2);
		setInteractiveEdit(false);
		setInteractiveBrowse(true);
		setInteractiveInherited(false);

		EntityFigure row = new EntityFigure(new RowLayout().withSpacing(5));
		row.addContentLight("Error:");
		row.add(createContentPane(0));
		add(row);

		row = new EntityFigure(new RowLayout().withSpacing(5));
		row.addContentLight("Cause:");
		row.add(createContentPane(1));
		add(row);

		row = new EntityFigure(new RowLayout().withSpacing(5));
		row.add(new EntityButton(LabelFactory.createContentLight("reload"), linkListener, null));
		add(row);
	}
}
