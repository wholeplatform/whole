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
package org.whole.lang.ui.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.draw2d.FigureCanvas;
import org.eclipse.draw2d.FigureUtilities;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.Viewport;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontMetrics;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Caret;
import org.whole.lang.model.IEntity;
import org.whole.lang.ui.editparts.IEntityPart;
import org.whole.lang.ui.editparts.ITextualEntityPart;
import org.whole.lang.ui.figures.ITextualFigure;
import org.whole.lang.ui.viewers.IEntityPartViewer;

/** 
 * @author Enrico Persiani
 */
public class CaretUtils {
	private static final int REAVEAL_SIZE = 50;
	private static final int CARET_WIDTH = 2;

	public static Caret getCaret(EditPartViewer viewer) {
		Caret caret = null;
		if (viewer != null) {
			Canvas canvas = (Canvas)viewer.getControl();
			if (canvas != null) {
				caret = canvas.getCaret();
				if (caret == null)
					caret = new Caret(canvas, 0);
			}
		}
		return caret;
	}
	
	public static org.eclipse.draw2d.geometry.Rectangle getAbsoluteCaretBounds(EditPartViewer viewer) {
		return new org.eclipse.draw2d.geometry.Rectangle(CaretUtils.getCaret(viewer).getBounds());
	}
	
	public static Rectangle getAbsoluteCaretBounds(IFigure figure, org.eclipse.draw2d.geometry.Rectangle draw2dRect) {
		Rectangle rect = new Rectangle(0, 0, 0, 0);
		figure.translateToAbsolute(draw2dRect);
		rect.x = draw2dRect.x;
		rect.y = draw2dRect.y;
		rect.width = draw2dRect.width;
		rect.height = draw2dRect.height;
		return rect;
	}

	public static org.eclipse.draw2d.geometry.Rectangle getRelativeCaretBounds(IFigure figure, Rectangle rect) {
		org.eclipse.draw2d.geometry.Rectangle draw2dRect = new org.eclipse.draw2d.geometry.Rectangle();
		draw2dRect.x = rect.x;
		draw2dRect.y = rect.y;
		draw2dRect.width = rect.width;
		draw2dRect.height = rect.height;
		figure.translateToRelative(draw2dRect);
		return draw2dRect;
	}

	public static void revealCaret(Caret caret) {
		if (caret == null || !caret.isVisible() || !(caret.getParent() instanceof FigureCanvas))
			return;
		
		FigureCanvas figureCanvas = (FigureCanvas) caret.getParent();
		Viewport viewport = figureCanvas.getViewport();
		org.eclipse.draw2d.geometry.Rectangle viewableArea =
			viewport.getClientArea().getCopy().setLocation(viewport.getViewLocation());

		org.eclipse.draw2d.geometry.Rectangle caretBounds =
			new org.eclipse.draw2d.geometry.Rectangle(caret.getBounds());
		viewport.getContents().translateToRelative(caretBounds);
		if (!viewableArea.contains(caretBounds)) {
			Point scrollTo = viewableArea.getLocation();

			if (caretBounds.x <= viewableArea.x)
				scrollTo.x = caretBounds.x - REAVEAL_SIZE;
			else if (caretBounds.right() >= viewableArea.right())
				scrollTo.x = viewableArea.x + caretBounds.right() - viewableArea.right() + REAVEAL_SIZE;

			if (caretBounds.y < viewableArea.y)
				scrollTo.y = caretBounds.y - REAVEAL_SIZE;
			else if (caretBounds.bottom() > viewableArea.bottom())
				scrollTo.y = viewableArea.y + caretBounds.bottom() - viewableArea.bottom() + REAVEAL_SIZE;
			figureCanvas.scrollTo(scrollTo.x, scrollTo.y);
		}
	}

	public static Dimension getCaretSize(Font font) {
		FontMetrics fontMetrics = FigureUtilities.getFontMetrics(font);
		return new Dimension(CARET_WIDTH, fontMetrics.getHeight());
	}

	// begin of multiline positioning methods
	private static final Pattern lt = Pattern.compile("[\\n\\r]|\\r\\n");
	public static int getCaretLines(String text) {
		Matcher matcher = lt.matcher(text);
		int lines = 1;
		while (matcher.find()) {
			lines++;
		}
		return lines;
	}

	public static int getCaretPositions(IEntityPartViewer viewer, IEntity entity) {
		IEntityPart entityPart = viewer.getEditPartRegistry().get(entity);
		if (!(entityPart instanceof ITextualEntityPart))
			throw new IllegalArgumentException("the entity part is not textual");
		ITextualEntityPart targetPart = (ITextualEntityPart) entityPart;
		return targetPart.getCaretPositions();
	}
	public static int getCaretLine(Point proximityPoint, org.eclipse.draw2d.geometry.Rectangle labelBounds, Dimension caretSize) {
		return  (proximityPoint.y - labelBounds.y) / caretSize.height;
	}

	public static int getStartingLinePosition(String text, int line) {
		return line == 0 ? 0 : getEndingLinePosition(text, line-1)+1;
	}

	public static int getEndingLinePosition(String text, int line) {
		int labelLines = getCaretLines(text);
		if (line >= labelLines)
			return -1;

		if (line == labelLines-1)
			return text.length();

		Matcher matcher = lt.matcher(text);
		int index = -1;
		while (matcher.find() && line >= 0) {
			index = matcher.start();
			line--;
		}
		return index;
	}

	public static String getLine(String text, int line) {
		try {
			return text.substring(getStartingLinePosition(text, line), getEndingLinePosition(text, line));
		} catch (StringIndexOutOfBoundsException e) {
			return text;//FIXME workaround
		}
	}

	public static int getLineFromPosition(String text, int position) {
		int lines = getCaretLines(text);
		int index = -1;
		for (int i=0; i<lines; i++) {
			index = getEndingLinePosition(text, i);
			if (position <= index)
				return i;
		}
		return -1;
	}
	// end of multiline positioning methods

	//FIXME alternative methods  added for backward compatibility
	public static org.eclipse.draw2d.geometry.Rectangle getAbsoluteCaretBounds(IEntityPartViewer viewer, ITextualEntityPart targetPart) {
		ITextualFigure textualFigure = targetPart.getTextualFigure();
		Viewport viewport = ((FigureCanvas) viewer.getControl()).getViewport();
		org.eclipse.draw2d.geometry.Rectangle caretBounds = textualFigure.getCaretBounds().getCopy();
		viewport.getContents().translateToRelative(caretBounds);
		return caretBounds;
	}

	public static int calculateCaretPosition(ITextualEntityPart targetPart, int horizontalLocation) {
		ITextualFigure textualFigure = targetPart.getTextualFigure();
		Point.SINGLETON.x = horizontalLocation;
		textualFigure.translateToRelative(Point.SINGLETON);
		horizontalLocation = Point.SINGLETON.x;
		Label label = textualFigure.getEmbeddedLabel();
		String text = textualFigure.getText();
		Font font = textualFigure.getEmbeddedLabelFont();
		int availableWidth = horizontalLocation - textualFigure.getTextBounds().x;
		int length = label.getTextUtilities().getLargestSubstringConfinedTo(text, font, availableWidth+3);
		return CaretUtils.getStartingLinePosition(text, getCaretLines(text)-1)+length;
	}
}
