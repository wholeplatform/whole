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

import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.widgets.Caret;

/** 
 * @author Riccardo Solmi, Enrico Persiani
 */
public interface ITextualFigure extends ITextFigure {
	public int updateCaret(Point proximityPoint);
	public Rectangle getCaretBounds();
	public void activateCaret(Caret caret);
	public void deactivateCaret();
	public void revealCaret();

	public int getCaretPositions();
	public int getCaretPosition();
	public void setCaretPosition(int position);
	public void setSelectionRange(int start, int end);

	public int getCaretLines();
	public int getLineFromPosition(int position);

	public Label getEmbeddedLabel();
	public Font getEmbeddedLabelFont();
}
