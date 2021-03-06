/**
 * Copyright 2004-2019 Riccardo Solmi. All rights reserved.
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
package org.whole.lang.ui.handles;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.CompoundBorder;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LineBorder;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.DragTracker;
import org.eclipse.gef.handles.AbstractHandle;
import org.eclipse.gef.handles.MoveHandleLocator;
import org.whole.lang.ui.WholeImages;
import org.whole.lang.ui.editparts.IGraphicalEntityPart;
import org.whole.lang.ui.util.SuspensionKind;

/**
 * @author Enrico Persiani
 */
public class DebugHandle extends AbstractHandle {
	public DebugHandle(IGraphicalEntityPart owner, SuspensionKind suspensionKind) {
		super(owner, new MoveHandleLocator(owner.getFigure()));
		LineBorder line = new LineBorder(suspensionKind.isBreak() ? ColorConstants.darkGreen : ColorConstants.red, 3) {
			@Override
			public Insets getInsets(IFigure figure) {
				return new Insets(getWidth()+2);
			}
		};
		MarginBorder margin = new MarginBorder(7, 13, 0, 0) {
			@Override
			public void paint(IFigure figure, Graphics graphics, Insets insets) {
				super.paint(figure, graphics, insets);
				Rectangle bounds = figure.getBounds();
				graphics.drawImage(suspensionKind.isBreak() ? WholeImages.INTERPRETER : WholeImages.ERROR_OVR, bounds.x, bounds.y > 0 ? bounds.y : 0);
			}
		};
		CompoundBorder border = new CompoundBorder(margin, line) {
			public void paint(IFigure figure, Graphics g, Insets insets) {
				g.pushState();
				inner.paint(figure, g, insets.getAdded(outer.getInsets(figure)));
				g.popState();

				outer.paint(figure, g, insets);
			}
		};
		setBorder(border);
		setOpaque(false);
	}

	protected DragTracker createDragTracker() {
		return null;
	}
}
