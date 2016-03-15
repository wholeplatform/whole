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
package org.whole.lang.ui.notations.figures;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.SWT;

/**
 * @author Riccardo Solmi, Enrico Persiani
 */
public class DrawUtils {
	public static final int EDGE_SPACING = 3;
	public static final int SPACING = 5;
	public static enum DrawStyle {
		ORTHOGONAL, DIAGONAL, ROUNDED
	}

	public static final int SHADOW_SIZE = 3;
	public static void drawShadowBorder(Graphics g, Rectangle bounds, boolean filled) {
		Rectangle r = new Rectangle(bounds);
		r.resize(-SHADOW_SIZE,-SHADOW_SIZE).translate(+SHADOW_SIZE*2,+SHADOW_SIZE*2);
		Rectangle cr = Rectangle.SINGLETON.setBounds(r);
		
		g.setBackgroundColor(ColorConstants.buttonDarkest);
		g.setAlpha(90);
		cr.setSize(SHADOW_SIZE, r.height-SHADOW_SIZE*2);
		g.setClip(cr.setLocation(r.x+r.width-SHADOW_SIZE*2, r.y));
		g.fillRectangle(r);
		cr.setSize(r.width-SHADOW_SIZE, SHADOW_SIZE);
		g.setClip(cr.setLocation(r.x, r.y+r.height-SHADOW_SIZE*2));
		g.fillRectangle(r);
		g.setClip(bounds);
		g.setAlpha(255);

		r.translate(-SHADOW_SIZE*2,-SHADOW_SIZE*2);
		
		g.setBackgroundColor(ColorConstants.listBackground);
		if (filled)
			g.fillRectangle(r);
		g.setForegroundColor(ColorConstants.buttonDarker);

		g.drawLine(r.x, r.y, r.x, r.y+r.height-1);
		g.drawLine(r.x+r.width-1, r.y, r.x+r.width-1, r.y+r.height-1);

		g.setLineStyle(SWT.LINE_CUSTOM);
		g.setLineDash(new int[] {1,1});			
		g.drawLine(r.x, r.y, r.x+r.width-1, r.y);
		g.drawLine(r.x, r.y+r.height-1, r.x+r.width-1, r.y+r.height-1);
		g.setLineStyle(SWT.LINE_SOLID);
		g.setLineDash((int[]) null);
	}

	public static void drawRadialMap(Graphics graphics, DrawStyle style, Rectangle center, Point... children) {
		Rectangle r = Rectangle.SINGLETON;
		r.setBounds(center);
		r.translate(-1, -1);
		r.resize(1, 1);
		for (int i=0; i<children.length; i++) {
			float centerX = r.x + 0.5f * r.width;
			float centerY = r.y + 0.5f * r.height;
			
			Point reference = children[i];
			if (reference.x == (int) centerX && reference.y == (int) centerY)
				graphics.drawLine((int) centerX, (int) centerY, children[i].x, children[i].y);
			else {
				float dx = reference.x - centerX;
				float dy = reference.y - centerY;
				
				float scale = 0.5f / Math.max(Math.abs(dx) / r.width, Math.abs(dy) / r.height);
	
				dx *= scale;
				dy *= scale;
				centerX += dx;
				centerY += dy;
	
				graphics.drawLine(Math.round(centerX), Math.round(centerY), children[i].x, children[i].y);
			}
		}
	}

	public static void drawHorizontalFishbone(Graphics graphics, DrawStyle style, int styleSize, Point start, Point... children) {
//		boolean isDiagonal = DrawStyle.DIAGONAL.equals(style);
		
		assert children.length != 0;
		
//		int yDelta = children.length > 1 ? children[0].y - children[1].y :
//				start.y - children[0].y;
//		yDelta = yDelta<0 ? -spineHeight : +spineHeight;
		int xDelta = DrawStyle.ORTHOGONAL.equals(style) ? 0 :styleSize;
		int xmin = Integer.MAX_VALUE;

		Point source = Point.SINGLETON;
		// draw segments
		source.y = start.y;
		for (int i=0; i<children.length; i++) {
			xmin = Math.min(xmin, source.x = children[i].x + xDelta);
//			if (isDiagonal)
				graphics.drawLine(source, children[i]);
//			else //FIXME
//				graphics.drawArc(source.x, source.y,
//						children[i].x-source.x, 
//						children[i].y-source.y,
//						-90, 90);
		}
		// draw line
		graphics.drawLine(start, source);
		source.x = xmin;
		graphics.drawLine(start, source);
	}

	public static void drawVerticalFishbone(Graphics graphics, DrawStyle style, int styleSize, Point start, Point... children) {
//		boolean isDiagonal = DrawStyle.DIAGONAL.equals(style);
		
		assert children.length != 0;
		
//		int yDelta = children.length > 1 ? children[0].y - children[1].y :
//				start.y - children[0].y;
//		yDelta = yDelta<0 ? -spineHeight : +spineHeight;
		int yDelta = styleSize;
		int ymin = Integer.MAX_VALUE;

		Point source = Point.SINGLETON;
		// draw segments
		source.x = start.x;
		for (int i=0; i<children.length; i++) {
			ymin = Math.min(ymin, source.y = children[i].y + yDelta);
//			if (isDiagonal)
				graphics.drawLine(source, children[i]);
//			else //FIXME
//				graphics.drawArc(source.x, source.y,
//						children[i].x-source.x, 
//						children[i].y-source.y,
//						-90, 90);
		}
		// draw line
		graphics.drawLine(start, source);
		source.y = ymin;
		graphics.drawLine(start, source);
	}

	/*
	 * |
	 * |-
	 * |-
	 * |_
	 */
	public static void drawOutline(Graphics graphics, Point start, Point... children) {
		assert children.length != 0;
		Point source = Point.SINGLETON;
		// draw segments
		source.x = start.x;
		for (int i=0; i<children.length; i++) {
			source.y = children[i].y;
			graphics.drawLine(source, children[i]);
		}
		// draw line
		graphics.drawLine(start, source);
		source.y = children[0].y;
		graphics.drawLine(start, source);
	}

	/*
	 *   _
	 *  |
	 * _|-
	 *  |-
	 *  |_
	 */
	public static void drawHorizontalTree(Graphics graphics, Point start, int length, Point... children) {
		assert children.length != 0;
		Point source = Point.SINGLETON;
		// draw segments
		source.x = start.x + (start.x<children[0].x ? +length : -length);
		source.y = start.y;
		Point end = new Point(source);
		graphics.drawLine(start, end);
		for (int i=0; i<children.length; i++) {
			source.y = children[i].y;
			graphics.drawLine(source, children[i]);
		}
		// draw line
		graphics.drawLine(end, source);
		source.y = children[0].y;
		graphics.drawLine(end, source);
	}
	/*
	 *  ____|_____
	 * | |  |   | |
	 */
	public static void drawVerticalTree(Graphics graphics, Point start, int length, Point... children) {
		assert children.length != 0;
		Point source = Point.SINGLETON;
		// draw segments
		source.x = start.x;
		source.y = start.y + (start.y<children[0].y ? +length : -length);
		Point end = new Point(source);
		graphics.drawLine(start, end);
		for (int i=0; i<children.length; i++) {
			source.x = children[i].x;
			graphics.drawLine(source, children[i]);
		}
		// draw line
		graphics.drawLine(end, source);
		source.x = children[0].x;
		graphics.drawLine(end, source);
	}

	/*
	 * -
	 *  |
	 *   -
	 */
	public static void drawHorizontalEdge(Graphics graphics, Point start, Point end, int startDistance) {
		int delta = start.x < end.x ? startDistance : -startDistance;
		int middleX = start.x + delta;
		graphics.drawLine(start.x, start.y, middleX, start.y);
		graphics.drawLine(middleX, start.y, middleX, end.y);
		graphics.drawLine(middleX, end.y, end.x, end.y);
	}
	
	/*
	 * |
	 *  -
	 *   |
	 */
	public static void drawVerticalEdge(Graphics graphics, Point start, Point end, int startDistance) {
		int delta = start.y < end.y ? startDistance : -startDistance;
		int middleY = start.y + delta;
		graphics.drawLine(start.x, start.y, start.x, middleY);
		graphics.drawLine(start.x, middleY, end.x, middleY);
		graphics.drawLine(end.x, middleY, end.x, end.y);
	}

	/*
	 *   --
	 *  |
	 * -
	 * --
	 *   |
	 * -  -
	 *  |
	 *   --
	 */
	public static void drawRightEdges(Graphics g, Point[] start, Point[] end, int size) {
		int i;
		int prevYSourceLocation = Integer.MAX_VALUE;
		int egdeXOffset = DrawUtils.SPACING - DrawUtils.EDGE_SPACING;
		for (i = 0; i < size && end[i].y <= start[i].y; i++) {
			if (prevYSourceLocation >= end[i].y - 1)
				egdeXOffset += DrawUtils.EDGE_SPACING;
			prevYSourceLocation = start[i].y;
			
			drawHorizontalEdge(g, start[i], end[i], egdeXOffset);
		}

		prevYSourceLocation = Integer.MIN_VALUE;
		egdeXOffset = DrawUtils.SPACING - DrawUtils.EDGE_SPACING;
		for (int j = size-1; j >= i; j--) {
			if (prevYSourceLocation <= end[j].y + 1)
				egdeXOffset +=  DrawUtils.EDGE_SPACING;
			prevYSourceLocation = start[j].y;

			drawHorizontalEdge(g, start[j], end[j], egdeXOffset);
		}
	}
}
