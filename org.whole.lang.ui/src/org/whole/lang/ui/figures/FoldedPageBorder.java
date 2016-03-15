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

import org.eclipse.draw2d.AbstractBorder;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.graphics.Color;

/**
 * @author Riccardo Solmi
 */
public class FoldedPageBorder extends AbstractBorder {
    static final int CORNER_SIZE = 10;
    static final Color corner1 = new Color(null, 200, 208, 223);
    static final Color corner2 = new Color(null, 160, 172, 200);
    static final Color blue = new Color(null, 152,168,200);
    static final Color shadow = new Color(null, 202,202,202);

    static final PointList CORNER_ERASE;
    static final PointList CORNER_PAINT;
    static {
        CORNER_ERASE = new PointList(3);
        CORNER_ERASE.addPoint(1,0);
        CORNER_ERASE.addPoint(1, CORNER_SIZE + 1);
        CORNER_ERASE.addPoint(-CORNER_SIZE, 0);
        CORNER_PAINT = new PointList(3);
        CORNER_PAINT.addPoint(-CORNER_SIZE, 0);
        CORNER_PAINT.addPoint(0, CORNER_SIZE);
        CORNER_PAINT.addPoint(-CORNER_SIZE, CORNER_SIZE);
    }
    
    static final Insets insets = new Insets(CORNER_SIZE,2,4,4);
    
    public Insets getInsets(IFigure figure) {
        return insets;
    }
    
    public void paint(IFigure figure, Graphics g, Insets insets) {
        Rectangle r = getPaintRectangle(figure, insets);
        
        g.setLineWidth(4);
        r.resize(-2, -2);
        g.setForegroundColor(shadow);
        g.drawLine(r.x+3, r.bottom(), r.right() - 1, r.bottom());
        g.drawLine(r.right(), r.y + 3 + CORNER_SIZE, r.right(), r.bottom() - 1);
        
        g.restoreState();
        r.resize(-1, -1);
        g.drawRectangle(r);
        g.setForegroundColor(blue);
        g.drawRectangle(r.x + 1, r.y+1, r.width - 2, r.height - 2);
        g.translate(r.getTopRight());
        g.fillPolygon(CORNER_ERASE);
        g.setBackgroundColor(corner1);
        g.fillPolygon(CORNER_PAINT);
        g.setForegroundColor(figure.getForegroundColor());
        g.drawPolygon(CORNER_PAINT);
        g.restoreState();
        g.setForegroundColor(corner2);
        g.drawLine(
                r.right() - CORNER_SIZE + 1,
                r.y + 2,
                r.right() - 2,
                r.y + CORNER_SIZE-1);
    }
}