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
package org.whole.lang.ui.editpolicies;

import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPartViewer;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.commons.reflect.CommonsEntityDescriptorEnum;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.IEntity;
import org.whole.lang.ui.editparts.IGraphicalEntityPart;
import org.whole.lang.ui.editparts.ITextualEntityPart;
import org.whole.lang.ui.editparts.ModelObserver;
import org.whole.lang.ui.figures.ITextualFigure;
import org.whole.lang.ui.tools.Tools;
import org.whole.lang.ui.util.CaretUpdater;
import org.whole.lang.ui.util.FigureUtils;
import org.whole.lang.ui.viewers.IEntityPartViewer;

/** 
 * @author Enrico Persiani
 */
public class TextualHilightEditPolicy extends WholeHilightEditPolicy {
	@Override
	protected void showFocus() {
		showCaret();
	}

	@Override
	protected void hideFocus() {
		hideCaret();
		super.hideFocus();
	}

	protected ITextualEntityPart getTextualHost() {
		return (ITextualEntityPart) getHost();
	}

	protected ITextualFigure getTextualHostFigure() {
		return (ITextualFigure) getHostFigure();
	}

	private void hideCaret() {
		getTextualHost().setCaretVisible(false);
	}

	private void showCaret() {
		if (isTextToolActive()) {
			IBindingManager bm = getCurrentViewer().getContextBindings();
			IEntity focusEntity = bm.wGet("focusEntity");
			ITextualEntityPart textualHost = getTextualHost();
			if (focusEntity != null && textualHost.getModelEntity() != focusEntity
					&& !Matcher.match(CommonsEntityDescriptorEnum.RootFragment, focusEntity)) { //FIXME workaround for focusEntity == RootFragment after a focus lost
				IGraphicalEntityPart focusPart = (IGraphicalEntityPart) ModelObserver.getObserver(focusEntity, getCurrentViewer().getEditPartRegistry());
				if (focusPart != null) {
					int position = FigureUtils.getPositionOf(textualHost.getFigure(), focusPart.getFigure());
					textualHost.setCaretPosition(position == PositionConstants.EAST ? 0 : textualHost.getCaretPositions());
				}
			}
			textualHost.setCaretVisible(true);
		}
	}

	private IEntityPartViewer getCurrentViewer() {
		return (IEntityPartViewer) getHost().getViewer();
	}

	private boolean isTextToolActive() {
		EditPartViewer viewer = getCurrentViewer();
		if (viewer == null)
			return false;

		return Tools.TEXTUAL.isActive(viewer);
	}

	public void updateHilight(Point location) {
		ITextualEntityPart textualHost = getTextualHost();
		if (textualHost.hasFocus())
			CaretUpdater.sheduleSyncUpdate(textualHost.getViewer(), textualHost.getModelEntity(), location, true);
	}

	public boolean moveCaretHorizontally(int positions) {
		ITextualEntityPart textualHost = getTextualHost();
		if (!textualHost.hasFocus())
			return false;

		int newPosition = textualHost.getCaretPosition() + positions;
		if (newPosition < 0 || newPosition > textualHost.getCaretPositions())
			return false;

		CaretUpdater.sheduleSyncUpdate(textualHost.getViewer(), textualHost.getModelEntity(), newPosition, true);
		return true;
	}

	public boolean moveCaretVertically(int lines) {
		ITextualEntityPart textualHost = getTextualHost();
		if (!textualHost.hasFocus())
			return false;

		ITextualFigure textualFigure = textualHost.getTextualFigure();
		int position = textualHost.getCaretPosition();
		int newLine = textualFigure.getLineFromPosition(position) + lines;
		if (newLine < 0 || newLine >= textualFigure.getCaretLines())
			return false;
		int dy = lines/Math.abs(lines);
		Rectangle translatedCaret = textualFigure.getCaretBounds().getCopy().translate(0, dy);
		Point newLocation = dy > 0 ? translatedCaret.getBottomLeft() : translatedCaret.getTopLeft();

		CaretUpdater.sheduleSyncUpdate(textualHost.getViewer(), textualHost.getModelEntity(), newLocation, true);
		return true;
	}

}
