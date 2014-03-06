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
package org.whole.lang.ui.figures;

import java.util.List;

import org.eclipse.draw2d.FigureUtilities;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.graphics.Color;
import org.whole.lang.ui.layout.ICompositeEntityLayout;
import org.whole.lang.ui.layout.RowLayout;

/**
 * @author Riccardo Solmi
 */
public class StringSeparatedCompositeRowFigure extends CompositeFigure {
	protected String separator;

	public StringSeparatedCompositeRowFigure() {
		this(",", 8);
	}
	public StringSeparatedCompositeRowFigure(String separator, ICompositeEntityLayout layout) {
		super(layout);
		setSeparator(separator);
	}
	public StringSeparatedCompositeRowFigure(String separator, int spacing) {
		super(new RowLayout().withMarginLeft(5).withMarginRight(5).withSpacing(spacing));
		setSeparator(separator);
	}

	public void setSeparator(String separator) {
		this.separator = separator;
	}

	@SuppressWarnings("unchecked")
	protected void paintFigure(Graphics g) {
		super.paintFigure(g);

        int spacing = Math.max(1, getLayoutManager().getSpacing() / 5);
        int separatorAscent = getSeparatorAscent();

        if (getLocalFont() != null)
        	g.setFont(getLocalFont());

        List<IEntityFigure> children = (List<IEntityFigure>) getChildren();
        for (int i=0; i<children.size()-1; i++) {
        	IEntityFigure childFigure = children.get(i);
        	Rectangle childBounds = childFigure.getBounds();
        	g.drawString(separator, childBounds.right() + spacing, childBounds.y + childFigure.getAscent() - separatorAscent);
        }
	}
	protected int getSeparatorAscent() {
		return FigureUtilities.getFontMetrics(getFont()).getHeight()/2;
	}

	@Override
	public Color getLocalForegroundColor() {
		return FigurePrefs.contentLighterColor;
	}
}
