/**
 * Copyright 2004-2014 Riccardo Solmi. All rights reserved.
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
package org.whole.lang.patterns.ui.figures;

import org.eclipse.draw2d.MarginBorder;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.whole.lang.ui.figures.ContentPaneFigure;
import org.whole.lang.ui.figures.EntityFigure;
import org.whole.lang.ui.figures.EntityLabel;
import org.whole.lang.ui.figures.FigurePrefs;
import org.whole.lang.ui.layout.RowLayout;
import org.whole.lang.ui.layout.TableRowLayout;
import org.whole.lang.ui.util.UIUtils;

/**
 * @author Riccardo Solmi
 */
public class RepetitionFigure extends ContentPaneFigure {
	public RepetitionFigure() {
		super(new TableRowLayout());
		initContentPanes(3);

		add(createContentPane(0));
		add(createContentPane(1, new MarginBorder(0,13,0,0)));

		EntityFigure row = new EntityFigure(new RowLayout());
		row.add(createContentPane(2));
		row.add(new EntityLabel("\u2026") {
			public Color getLocalForegroundColor() {
				return FigurePrefs.contentLighterColor;
			}	
			public Font getLocalFont() {
				return UIUtils.getOpenSymbolMediumFont();
			}
		});
		row.addContentLight(" ordered");
		add(row);
	}
}
