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
package org.whole.lang.ui.editparts;

import org.eclipse.draw2d.geometry.Point;
import org.whole.lang.model.IEntity;
import org.whole.lang.ui.figures.ITextualFigure;

/** 
 * @author Riccardo Solmi, Enrico Persiani
 */
public interface ITextualEntityPart extends IGraphicalEntityPart {
	public IEntity getModelTextEntity();
	public ITextualFigure getTextualFigure();

	// caret positioning methods
	public void setCaretVisible(boolean visible);
	public void updateCaret(Point location);
	public int getCaretPositions();
	public int getCaretPosition();
	public void setCaretPosition(int position);

	// selection range methods
	public void setSelectionRange(int start, int end);
	public void clearSelectionRange();
	public boolean hasSelectionRange();
	public int getSelectionStart();
	public int getSelectionEnd();
}
