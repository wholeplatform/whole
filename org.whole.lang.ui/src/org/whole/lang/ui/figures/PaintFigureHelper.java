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

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.graphics.Color;

/**
 * @author Riccardo Solmi
 */
public class PaintFigureHelper {
	public static final void drawFilledRectangle(Graphics g, Rectangle bounds, Color fgc, Color bgc) {
        Rectangle r = Rectangle.SINGLETON;
        r.setLocation(bounds.x, bounds.y);
        r.setSize(bounds.width, bounds.height);
        
    	g.setBackgroundColor(bgc);
    	g.setForegroundColor(fgc);
        g.fillRectangle(r);
		g.setAlpha(255);
        g.drawRectangle(r.resize(-1, -1));
	}
	
	public static final void drawGradientRectangle(Graphics g, Rectangle bounds, Color gc1, Color gc2, Color bc, boolean vertical) {
        Rectangle r = Rectangle.SINGLETON;
        r.setLocation(bounds.x, bounds.y);
        r.setSize(bounds.width, bounds.height);
        
    	g.setBackgroundColor(gc2);
    	g.setForegroundColor(gc1);
    	g.fillGradient(r, vertical);
		g.setAlpha(255);
    	g.setForegroundColor(bc);
        g.drawRectangle(r.resize(-1, -1));
	}

	public static final void drawRoundRectangle(Graphics g, Rectangle bounds, Color fgc, Color bgc) {
		drawRoundRectangle(g, bounds, fgc, bgc, 8, 8);
	}
	public static final void drawRoundRectangle(Graphics g, Rectangle bounds, Color fgc, Color bgc, int arcWidth, int arcHeight) {
        Rectangle r = Rectangle.SINGLETON;
        r.setLocation(bounds.x, bounds.y);
        r.setSize(bounds.width, bounds.height);
        
    	g.setBackgroundColor(bgc);
    	g.setForegroundColor(fgc);
        g.drawRoundRectangle(r.resize(-1, -1), arcWidth, arcHeight);
	}

	public static final void drawFilledRoundRectangle(Graphics g, Rectangle bounds, Color fgc, Color bgc) {
		drawFilledRoundRectangle(g, bounds, fgc, bgc, 8, 8);
	}
	public static final void drawFilledRoundRectangle(Graphics g, Rectangle bounds, Color fgc, Color bgc, int arcWidth, int arcHeight) {
        Rectangle r = Rectangle.SINGLETON;
        r.setLocation(bounds.x, bounds.y);
        r.setSize(bounds.width, bounds.height);
        
    	g.setBackgroundColor(bgc);
    	g.setForegroundColor(fgc);
        g.fillRoundRectangle(r, arcWidth, arcHeight);
        g.drawRoundRectangle(r.resize(-1, -1), arcWidth, arcHeight);
	}

	public static final void drawFilledPolygon(Graphics g, PointList pList, Color fgc, Color bgc) {
		g.setBackgroundColor(bgc);
		g.setForegroundColor(fgc);
		g.fillPolygon(pList);
		g.drawPolygon(pList);
	}

	public static final void drawFilledOval(Graphics g, Rectangle bounds, Color fgc, Color bgc) {
    	g.setBackgroundColor(bgc);
    	g.setForegroundColor(fgc);
        g.fillOval(bounds);
        g.drawOval(bounds);
	}

	public static final void drawGradientRoundRectangle(Graphics g, Rectangle bounds, Color gc1, Color gc2, boolean vertical) {
		drawGradientRoundRectangle(g, bounds, gc1, gc2, gc1, vertical);
	}
	public static final void drawGradientRoundRectangle(Graphics g, Rectangle bounds, Color gc1, Color gc2, Color bc, boolean vertical) {
		drawGradientRoundRectangle(g, bounds, gc1, gc2, bc, 8, 8, vertical);
	}
	public static final void drawGradientRoundRectangle(Graphics g, Rectangle bounds, Color gc1, Color gc2, int arcWidth, int arcHeight, boolean vertical) {
		drawGradientRoundRectangle(g, bounds, gc1, gc2, gc1, arcWidth, arcHeight, vertical);
	}
	public static final void drawGradientRoundRectangle(Graphics g, Rectangle bounds, Color gc1, Color gc2, Color bc, int arcWidth, int arcHeight, boolean vertical) {
    	fillGradientRoundRectangle(g, gc1, gc2, bounds, arcWidth, arcHeight, vertical);
    	g.setForegroundColor(bc);
        g.drawRoundRectangle(new Rectangle(bounds).resize(-1, -1), arcWidth, arcHeight);
	}

	public static final void fillGradientRoundRectangle(Graphics g, Color gc1, Color gc2, Rectangle bounds, int arcWidth, int arcHeight, boolean vertical) {
        Rectangle temp = Rectangle.SINGLETON;
        temp.setLocation(bounds.x, bounds.y);

        if (vertical)
            temp.setSize(bounds.width, arcHeight);
        else
        	temp.setSize(arcWidth, bounds.height);
    	g.setBackgroundColor(gc1);
        g.fillRoundRectangle(temp, arcWidth, arcHeight);
    	g.setBackgroundColor(gc2);
    	g.setForegroundColor(gc1);
    	if (vertical)
    		temp.y = bounds.bottom()-arcHeight;
    	else
    		temp.x = bounds.right()-arcWidth;
        g.fillRoundRectangle(temp, arcWidth, arcHeight);

    	if (vertical) {
    		temp.y = bounds.y+(arcHeight/3);
    		temp.height = bounds.height - arcHeight/2;
    	} else {
    		temp.x = bounds.x+(arcWidth/2);
    		temp.width = bounds.width - arcWidth;    		
    	}
    	g.fillGradient(temp, vertical);
	}

	public static final void drawGradientRoundRectangle(Graphics g, Rectangle bounds, Color gc1, Color gc2, float gx1Perc, float gx2Perc) {
		drawGradientRoundRectangle(g, bounds, gc1, gc2, gc1, gx1Perc, gx2Perc);
	}
	public static final void drawGradientRoundRectangle(Graphics g, Rectangle bounds, Color gc1, Color gc2, Color bc, float gx1Perc, float gx2Perc) {
		drawGradientRoundRectangle(g, bounds, gc1, gc2, bc, gx1Perc, gx2Perc, 8, 8);
	}
	public static final void drawGradientRoundRectangle(Graphics g, Rectangle bounds, Color gc1, Color gc2, float gx1Perc, float gx2Perc, int arcWidth, int arcHeight) {
		drawGradientRoundRectangle(g, bounds, gc1, gc2, gc1, gx1Perc, gx2Perc, arcWidth, arcHeight);		
	}
	public static final void drawGradientRoundRectangle(Graphics g, Rectangle bounds, Color gc1, Color gc2, Color bc, float gx1Perc, float gx2Perc, int arcWidth, int arcHeight) {
        Rectangle temp = Rectangle.SINGLETON;
        temp.setLocation(bounds.x, bounds.y);
        int gWidth = (int) (bounds.width*gx1Perc);
        temp.setSize(gWidth, bounds.height);
        
    	g.setBackgroundColor(gc1);
        g.fillRoundRectangle(temp, arcWidth, arcHeight);
    	g.setBackgroundColor(gc2);
    	g.setForegroundColor(gc1);

        int gWidth2 = (int) (bounds.width*gx2Perc);
    	temp.x = bounds.right()-gWidth2;
    	temp.width = gWidth2;
        g.fillRoundRectangle(temp, arcWidth, arcHeight);
        temp.x = bounds.x+Math.max(0, gWidth - (arcWidth/2));
        temp.width = bounds.width - Math.max(0, gWidth + gWidth2 - arcWidth);
        g.fillGradient(temp, false);
    	g.setForegroundColor(bc);
        g.drawRoundRectangle( new Rectangle(bounds).resize(-1, -1), arcWidth, arcHeight);
	}
}
