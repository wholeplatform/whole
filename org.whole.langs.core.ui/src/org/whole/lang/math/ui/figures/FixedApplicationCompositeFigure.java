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
package org.whole.lang.math.ui.figures;

import org.eclipse.draw2d.Border;
import org.whole.lang.ui.figures.ContentPaneFigure;
import org.whole.lang.ui.figures.IEntityFigure;
import org.whole.lang.ui.figures.OverQualifiedFigure;
import org.whole.lang.ui.figures.RoundBracketsBorder;
import org.whole.lang.ui.figures.StringSeparatedCompositeRowFigure;
import org.whole.lang.ui.layout.FlowLayout;
import org.whole.lang.ui.layout.RowLayout;

/**
 * @author Riccardo Solmi
 */
public class FixedApplicationCompositeFigure extends ContentPaneFigure {
	public FixedApplicationCompositeFigure(String name) {
		this(name, ",", new RoundBracketsBorder());
	}
	public FixedApplicationCompositeFigure(String name, String separator, Border border) {
		initContentPanes(1);

		setLayoutManager(new RowLayout().withSpacing(border != null ? 1 : 8));
		add(new OverQualifiedFigure("Math", name));
		IEntityFigure compositeFigure = new StringSeparatedCompositeRowFigure(
				separator, new FlowLayout().withMarginLeft(5).withMarginRight(5).withSpacing(8));
		if (border != null)
			compositeFigure.setBorder(border);
		add(createContentPane(0, compositeFigure));
	}
}
