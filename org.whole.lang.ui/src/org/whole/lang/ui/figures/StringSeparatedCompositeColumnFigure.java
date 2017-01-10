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

import java.util.List;

import org.eclipse.draw2d.FigureUtilities;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.swt.graphics.Color;
import org.whole.lang.ui.layout.Alignment;
import org.whole.lang.ui.layout.ColumnLayout;
import org.whole.lang.ui.layout.ICompositeEntityLayout;

/**
 * @author Riccardo Solmi
 */
public class StringSeparatedCompositeColumnFigure extends CompositeFigure {
	protected String separator;

	public StringSeparatedCompositeColumnFigure() {
		this(",", 10);
	}
	public StringSeparatedCompositeColumnFigure(String separator, ICompositeEntityLayout layout) {
		super(layout);
		setSeparator(separator);
	}
	public StringSeparatedCompositeColumnFigure(String separator, int spacing) {
		super(new ColumnLayout()
			.withMinorAlignment(Alignment.CENTER)
//			.setMarginLeft(5).setMarginRight(5)
			.withMarginTop(5).withMarginBottom(5)
			.withSpacing(spacing));
		setSeparator(separator);
	}

	public void setSeparator(String separator) {
		this.separator = separator;
	}

	@SuppressWarnings("unchecked")
	protected void paintFigure(Graphics g) {
		super.paintFigure(g);

        int spacing = getLayoutManager().getSpacing();
        int fontAscent = FigureUtilities.getFontMetrics(getFont()).getHeight()/2;

        int xOffset = FigureUtilities.getTextWidth(separator, getFont())/2;
        int yOffset = spacing/2 + fontAscent +1;
        int x = getClientArea().getCenter().x - xOffset; //TODO respect alignment

        List<IFigure> children = (List<IFigure>) getChildren();
        for (int i=1; i<children.size(); i++) {
        	int y = children.get(i).getBounds().y;
        	g.drawString(separator, x, y-yOffset);
        }
	}

	@Override
	public Color getLocalForegroundColor() {
		return FigureConstants.contentLightColor;
	}
}
