/**
 * Copyright 2004-2013 Riccardo Solmi. All rights reserved.
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

import org.eclipse.draw2d.Border;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LayoutManager;
import org.eclipse.draw2d.TreeSearch;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.graphics.Image;
import org.whole.lang.ui.layout.EntityLayoutAdapter;
import org.whole.lang.ui.layout.IEntityLayout;
import org.whole.lang.ui.layout.ITabularLayoutClient;
import org.whole.lang.ui.layout.ITabularLayoutServer;


/**
 * @author Riccardo Solmi
 */
public class EntityFigure extends Figure implements IEntityFigure {
	protected EntityFigure() {
	}
	public EntityFigure(LayoutManager layout) {
		this();
		setLayoutManager(layout);
	}

//TODO begin code duplicated in EntityFigure, EntityButton, EntityToggle, EntityLabel
	public static final int
	FLAG_INTERACTIVE_EDIT = Figure.MAX_FLAG << 1, //enables selection, dnD, delete
	FLAG_INTERACTIVE_BROWSE = Figure.MAX_FLAG << 2, //enables text editing and clickables
	FLAG_INTERACTIVE_INHERITED = Figure.MAX_FLAG << 3; //overrides both target and edit flags
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
	public IEntityLayout getLayoutManager() {
		return (IEntityLayout) super.getLayoutManager();
	}
	@Override
	public void setLayoutManager(LayoutManager manager) {
		if (!(manager instanceof IEntityLayout))
			manager = new EntityLayoutAdapter(manager) {
				public int getIndent(IFigure container) {
					return getInsets().left;
				}
				public int getAscent(IFigure container) {
					return EntityFigure.this.getPreferredSize().height/2;
				}
			};

		super.setLayoutManager(manager);
	}

	public int getIndent() {
		return getLayoutManager().getIndent(this);
	}
	public int getAscent() {
		return getLayoutManager().getAscent(this);
	}

	public float getMajorAutoresizeWeight() {
		return getLayoutManager().getMajorAutoresizeWeight();
	}
	public float getMinorAutoresizeWeight() {
		return getLayoutManager().getMinorAutoresizeWeight();
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


		public IEntityFigure add(IEntityFigure child) {
			super.add(child);
			return child;
		}
		public EntityLabel add(EntityLabel child) {
			super.add(child);
			return child;
		}
		public EntityLabel addModule(String text) {
			return add(LabelFactory.createModule(text));
		}
		public EntityLabel addDeclaration(String text) {
			return add(LabelFactory.createDeclaration(text));
		}
		public EntityLabel addKeyword(String text) {
			return add(LabelFactory.createKeyword(text));
		}
		public EntityLabel addRelation(String text) {
			return add(LabelFactory.createRelation(text));
		}
		public EntityLabel addIdentifier(String text) {
			return add(LabelFactory.createIdentifier(text));
		}
		public EntityLabel addLiteral(String text) {
			return add(LabelFactory.createLiteral(text));
		}
		public EntityLabel addContent(String text) {
			return add(LabelFactory.createContent(text));
		}
		public EntityLabel addContentDark(String text) {
			return add(LabelFactory.createContentDark(text));
		}
		public EntityLabel addContentLight(String text) {
			return add(LabelFactory.createContentLight(text));
		}
		public EntityLabel addContentLighter(String text) {
			return add(LabelFactory.createContentLighter(text));
		}
		public EntityLabel addSmallMath(String text) {
			return add(LabelFactory.createContentSmallMath(text));
		}
		public EntityLabel addMath(String text) {
			return add(LabelFactory.createContentMath(text));
		}
		public EntityLabel addMediumMath(String text) {
			return add(LabelFactory.createContentMediumMath(text));
		}
		public EntityLabel addLargeMath(String text) {
			return add(LabelFactory.createContentLargeMath(text));
		}
		public EntityLabel addLabel(String text) {
			return add(LabelFactory.createContentLabel(text));
		}
		public EntityLabel addLabel(String text, Image image) {
			return add(LabelFactory.createContentLabel(text, image));
		}
		public EntityLabel addLabel(Image image) {
			return add(new EntityLabel(image));
		}

		public ITabularLayoutServer getTabularLayoutServer() {
			return getLayoutManager().getTabularLayoutServer();
		}
		public ITabularLayoutClient getTabularLayoutClient() {
			return getLayoutManager().getTabularLayoutClient();
		}

		@Override
		public void setBorder(Border border) {
			if (getBorder() != border)
				super.setBorder(border);
		}
}
