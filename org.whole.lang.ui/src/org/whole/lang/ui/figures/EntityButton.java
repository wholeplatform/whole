/**
 * Copyright 2004-2012 Riccardo Solmi. All rights reserved.
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

import org.eclipse.draw2d.ActionListener;
import org.eclipse.draw2d.Clickable;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.TreeSearch;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.graphics.Image;
import org.whole.lang.ui.WholeImages;
import org.whole.lang.ui.layout.ITabularLayoutClient;
import org.whole.lang.ui.layout.ITabularLayoutServer;

/**
 * @author Riccardo Solmi
 */
public class EntityButton extends Clickable implements IEntityFigure {
	protected final IEntityFigure contents;
	
	public EntityButton(ActionListener action) {
		this(action, null);
	}
	public EntityButton(ActionListener action, Object data) {
		this(WholeImages.LINK, action, data);
	}
	public EntityButton(Image image, ActionListener action, Object data) {
		this(new EntityLabel(image), action, data);
	}
	public EntityButton(IEntityFigure contents, ActionListener action, Object data) {
		super(contents);
		this.contents = contents;

		setRequestFocusEnabled(false);
		setFocusTraversable(false);

		getModel().setUserData(data);

		if (action != null)
			/*getModel().*/addActionListener(action);
	}

//TODO begin code duplicated in EntityFigure, EntityButton, EntityToggle, EntityLabel
	//NB use Clickable.MAX_FLAG instead of Figure.MAX_FLAG
	public static final int
	FLAG_INTERACTIVE_EDIT = Clickable.MAX_FLAG << 1, //enables selection, dnD, delete
	FLAG_INTERACTIVE_BROWSE = Clickable.MAX_FLAG << 2, //enables text editing and clickables
	FLAG_INTERACTIVE_INHERITED = Clickable.MAX_FLAG << 3; //overrides both target and edit flags
	public static int MAX_FLAG = FLAG_INTERACTIVE_INHERITED;
//	FLAG_AUTORESIZE_CHILDREN = Figure.MAX_FLAG << 1,
//	FLAG_FLEXIBLE_WIDTH = Figure.MAX_FLAG << 2,
//	FLAG_FLEXIBLE_HEIGHT = Figure.MAX_FLAG << 3,
//	FLAG_FLEXIBLE_TOP = Figure.MAX_FLAG << 4,
//	FLAG_FLEXIBLE_LEFT = Figure.MAX_FLAG << 5,
//	FLAG_FLEXIBLE_BOTTOM = Figure.MAX_FLAG << 6,
//	FLAG_FLEXIBLE_RIGHT = Figure.MAX_FLAG << 7;

	{
		setInteractiveEdit(true);
		setInteractiveBrowse(true);
		setInteractiveInherited(true);
	}

	public boolean isInteractiveEdit() {
		return (flags & FLAG_INTERACTIVE_EDIT) != 0;
	}
	public void setInteractiveEdit(boolean interactiveEdit) {
		if (isInteractiveEdit() == interactiveEdit)
			return;
		setFlag(FLAG_INTERACTIVE_EDIT, interactiveEdit);
	}
	public boolean isInteractiveBrowse() {
		return (flags & FLAG_INTERACTIVE_BROWSE) != 0;
	}
	public void setInteractiveBrowse(boolean interactiveBrowse) {
		if (isInteractiveBrowse() == interactiveBrowse)
			return;
		setFlag(FLAG_INTERACTIVE_BROWSE, interactiveBrowse);
	}
	public boolean isInteractiveInherited() {
		return (flags & FLAG_INTERACTIVE_INHERITED) != 0;
	}
	public void setInteractiveInherited(boolean interactiveInherited) {
		if (isInteractiveInherited() == interactiveInherited)
			return;
		setFlag(FLAG_INTERACTIVE_INHERITED, interactiveInherited);
	}

	@Override
	public IFigure findFigureAt(int x, int y, TreeSearch search) {
		//FIXME inherit from ancestors
		return findFigureAt(x, y, search, isInteractiveEdit());
	}
	public IFigure findFigureAt(int x, int y, TreeSearch search, boolean inheritedEdit) {
		boolean isInteractiveEdit = isInteractiveInherited() ? inheritedEdit : isInteractiveEdit();

		if (!containsPoint(x, y))
			return null;
		if (search.prune(this))
			return null;
		IFigure child = findDescendantAtExcluding(x, y, search, isInteractiveEdit);
		if (child != null)
			return child;
		if (isInteractiveEdit && search.accept(this))
			return this;
		return null;
	}
	private static final Point PRIVATE_POINT = new Point();
	protected IFigure findDescendantAtExcluding(int x, int y, TreeSearch search, boolean inheritedEdit) {
		PRIVATE_POINT.setLocation(x, y);
		translateFromParent(PRIVATE_POINT);
		if (!getClientArea(Rectangle.SINGLETON).contains(PRIVATE_POINT))
			return null;

		x = PRIVATE_POINT.x;
		y = PRIVATE_POINT.y;
		IFigure fig;
		for (int i = getChildren().size(); i > 0;) {
			i--;
			fig = (IFigure) getChildren().get(i);
			if (fig.isVisible()) {
				if (fig instanceof IEntityFigure)
					fig = ((IEntityFigure) fig).findFigureAt(x, y, search, inheritedEdit);
				else
					fig = null;//fig.findFigureAt(x, y, search);

				if (fig != null)
					return fig;
			}
		}
		// No descendants were found
		return null;
	}

	@Override
	public IFigure findMouseEventTargetAt(int x, int y) {
		//FIXME inherit from ancestors
		return findMouseEventTargetAt(x, y, isInteractiveBrowse());
	}
	public IFigure findMouseEventTargetAt(int x, int y, boolean inheritedBrowse) {
		boolean isInteractiveBrowse = isInteractiveInherited() ? inheritedBrowse : isInteractiveBrowse();

		if (!containsPoint(x, y))
			return null;
		IFigure f = findMouseEventTargetInDescendantsAt(x, y, isInteractiveBrowse);
		if (f != null)
			return f;
		if (isInteractiveBrowse && isMouseEventTarget())
			return this;
		return null;
	}
	@Override
	protected IFigure findMouseEventTargetInDescendantsAt(int x, int y) {
		//FIXME inherit from ancestors
		return findMouseEventTargetInDescendantsAt(x, y, isInteractiveBrowse());
	}
	protected IFigure findMouseEventTargetInDescendantsAt(int x, int y, boolean inheritedBrowse) {
		PRIVATE_POINT.setLocation(x, y);
		translateFromParent(PRIVATE_POINT);

		if (!getClientArea(Rectangle.SINGLETON).contains(PRIVATE_POINT))
			return null;

		IFigure fig;
		for (int i = getChildren().size(); i > 0;) {
			i--;
			fig = (IFigure) getChildren().get(i);
			if (fig.isVisible() && fig.isEnabled()) {
				if (fig.containsPoint(PRIVATE_POINT.x, PRIVATE_POINT.y)) {
					if (fig instanceof IEntityFigure)
						fig = ((IEntityFigure) fig).findMouseEventTargetAt(
								PRIVATE_POINT.x, PRIVATE_POINT.y, inheritedBrowse);
					else
						fig = null;//fig.findMouseEventTargetAt(PRIVATE_POINT.x, PRIVATE_POINT.y);
					return fig;
				}
			}
		}
		return null;
	}
//TODO end

	@Override
	public boolean isStyle(int style) {
		return style == STYLE_BUTTON || super.isStyle(style);
	}

	public int getIndent() {
		return contents.getIndent();
	}
	public int getAscent() {
		return contents.getAscent();
	}

	public ITabularLayoutServer getTabularLayoutServer() {
		return null;
	}
	public ITabularLayoutClient getTabularLayoutClient() {
		return ITabularLayoutClient.NULL_TABULAR_LAYOUT_CLIENT;
	}

//TODO begin AbstractContentPaneFigure
	public int getContentPanesSize() {
		return 1;
	}
	public IFigure getContentPane(int paneIndex) {
		return paneIndex == 0 ? this : null;
	}
	public void setContentPaneVisible(int paneIndex, boolean visible) {
		getContentPane(paneIndex).setVisible(visible);
	}
//TODO end
}
