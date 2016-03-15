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
package org.whole.lang.ui.layout;

import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Rectangle;
import org.whole.lang.ui.figures.EntityFigure;
import org.whole.lang.ui.figures.IEntityFigure;
import org.whole.lang.ui.figures.IViewportTrackingStrategy;

/**
 * @author Riccardo Solmi
 */
public abstract class AbstractEntityLayout implements IEntityLayout {
	protected int marginLeft, marginRight, marginTop, marginBottom;
	protected float majorAutoresizeWeight, minorAutoresizeWeight;

	protected IEntityFigure[] childFigure;
	protected BaselinedDimension[] childSize; //childSize[i] is null when the child i is not visible

	private Dimension cachedPreferredHint = new Dimension(-1, -1);
	private Dimension cachedMinimumHint = new Dimension(-1, -1);
	private BaselinedDimension preferredSize;
	private BaselinedDimension minimumSize;

	protected int figWidth;
	protected int figAscent;
	protected int figDescent;

	protected IViewportTrackingStrategy viewportTrackingStrategy = IViewportTrackingStrategy.IDENTITY;
	public AbstractEntityLayout withViewportTrackingStrategy(IViewportTrackingStrategy viewportTrackingStrategy) {
		this.viewportTrackingStrategy = viewportTrackingStrategy;
		return this;
	}
	public IViewportTrackingStrategy getViewportTrackingStrategy() {
		return viewportTrackingStrategy;
	}

	public Object getConstraint(IFigure child) {
		return null;
	}
	public void setConstraint(IFigure child, Object constraint) {
		invalidate(child);
	}

	public BaselinedDimension getMinimumSize(IFigure container, int w, int h) {
		boolean flush = cachedMinimumHint.width != w && isSensitiveHorizontally(container);
		flush |= cachedMinimumHint.height != h && isSensitiveVertically(container);
		if (flush) {
			if (minimumSize != null && minimumSize.hintsSensitive)
				minimumSize = null;
			cachedMinimumHint.width = w;
			cachedMinimumHint.height = h;
		}
		if (minimumSize == null)
			minimumSize = calculateMinimumSize(container, w, h);
		return minimumSize;
	}
	public BaselinedDimension getPreferredSize(IFigure container, int wHint, int hHint) {
		boolean flush = cachedPreferredHint.width != wHint && isSensitiveHorizontally(container);
		flush |= cachedPreferredHint.height != hHint && isSensitiveVertically(container);
		if (flush) {
			if (preferredSize != null && preferredSize.hintsSensitive)
				preferredSize = null;
			cachedPreferredHint.width = wHint;
			cachedPreferredHint.height = hHint;
		}
		if (preferredSize == null)
			preferredSize = calculatePreferredSize(container, wHint, hHint);
		return preferredSize;
	}
	protected boolean isSensitiveHorizontally(IFigure container) {
		return true;
	}
	protected boolean isSensitiveVertically(IFigure container) {
		return true;
	}

	public void invalidate() {
		minimumSize = null;
		preferredSize = null;
//		preferredCache.clear();
	}
	protected void invalidate(IFigure child) {
		invalidate();
	}
	public void remove(IFigure child) {
		invalidate();
	}

	protected Dimension getBorderPreferredSize(IFigure container) {
		if (container.getBorder() == null)
			return new Dimension();
		return container.getBorder().getPreferredSize(container);
	}

	public IEntityLayout withMargin(int margin) {
		return withMargin(margin, margin, margin, margin);
	}
	public IEntityLayout withMargin(int marginTop, int marginLeft, int marginBottom, int marginRight) {
		return withMarginTop(marginTop).withMarginLeft(marginLeft).withMarginBottom(marginBottom).withMarginRight(marginRight);
	}

	public int getMarginLeft() {
		return isHorizontal() && (getSpacedChild() == 0 || getSpacedChild() == SPACED_ALL) ?
				getSpacedSpacing(marginLeft) : marginLeft;
	}
	public IEntityLayout withMarginLeft(int marginLeft) {
		this.marginLeft = marginLeft;
		return this;
	}

	public int getMarginRight() {
		return isHorizontal() && (getSpacedChild() == childFigure.length-1 || getSpacedChild() == SPACED_ALL) ?
				getSpacedSpacing(marginRight) : marginRight;
	}
	public IEntityLayout withMarginRight(int marginRight) {
		this.marginRight = marginRight;
		return this;
	}

	public int getMarginTop() {
		return !isHorizontal() && (getSpacedChild() == 0 || getSpacedChild() == SPACED_ALL) ?
				getSpacedSpacing(marginTop) : marginTop;
	}
	public IEntityLayout withMarginTop(int marginTop) {
		this.marginTop = marginTop;
		return this;
	}

	public int getMarginBottom() {
		return !isHorizontal() && (getSpacedChild() == childFigure.length-1 || getSpacedChild() == SPACED_ALL) ?
				getSpacedSpacing(marginBottom) : marginBottom;
	}
	public IEntityLayout withMarginBottom(int marginBottom) {
		this.marginBottom = marginBottom;
		return this;
	}

	protected BaselinedDimension calculateMinimumSize(IFigure container, int wHint, int hHint) {
		return getPreferredSize(container, wHint, hHint);
//		return calculateSize(container, wHint, hHint, false); //FIXME ?
	}

//	private SizeKey preferredSizeKey = new SizeKey(null, -1, -1);
//	private Map<SizeKey, BaselinedDimension> preferredCache = new WeakHashMap<AbstractEntityLayout.SizeKey, BaselinedDimension>();
	protected BaselinedDimension calculatePreferredSize(IFigure container, int wHint, int hHint) {
//FIXME faster code with minor problems
//		BaselinedDimension dimension = preferredCache.get(preferredSizeKey.setProperties(container, wHint, hHint));
//		if (dimension == null)
//			preferredCache.put(preferredSizeKey, dimension = calculateSize(container, wHint, hHint, true));
////TODO result diff
////		else if (!dimension.equals(calculateSize(container, wHint, hHint, true)))
////			return dimension;
//		return dimension;
//TODO safe code
		return calculateSize(container, wHint, hHint, true);
	}
	protected BaselinedDimension calculateSize(IFigure container, int wHint, int hHint, boolean preferred) {
		childFigure = getChildren(container);

		Insets insets = container.getInsets();
		if (wHint > -1)
			wHint = Math.max(0, wHint - insets.getWidth() - getMarginLeft() - getMarginRight());
		if (hHint > -1)
			hHint = Math.max(0, hHint - insets.getHeight() - getMarginTop() - getMarginBottom());

		boolean hintsSensitive = calculateChildrenSize(wHint, hHint, preferred);

		return new BaselinedDimension(figWidth, figAscent + figDescent,
				getIndent() + insets.left + getMarginLeft(), figAscent + insets.top + getMarginTop(),
				hintsSensitive)
				.expand(insets.getWidth(), insets.getHeight())
				.union(getBorderPreferredSize(container))
				.expand(getMarginLeft()+getMarginRight(), getMarginTop()+getMarginBottom());
	}

	protected boolean calculateChildrenSize(int wHint, int hHint, boolean preferred) {
		boolean hintsSensitive = false;
		int size = childFigure.length;
		childSize = new BaselinedDimension[size];
		for (int i=0; i<size; i++)
			if (childFigure[i].isVisible()) {
				childSize[i] = getChildSize(childFigure[i], wHint, hHint, preferred);
				hintsSensitive |= childSize[i].hintsSensitive;
			}

		setAscentDescentWidth(wHint, hHint);

		return hintsSensitive;
	}
	protected abstract void setAscentDescentWidth(int wHint, int hHint);

	protected IEntityFigure[] getChildren(IFigure container) {
		List<?> children = container.getChildren();
		return children.toArray(new IEntityFigure[children.size()]);
	}

	protected BaselinedDimension getChildSize(IFigure child, int wHint, int hHint, boolean preferred) {
		Dimension d = preferred ? child.getPreferredSize(wHint, hHint) : child.getMinimumSize(wHint, hHint);
		BaselinedDimension bd;
		if (d instanceof BaselinedDimension)
			bd = (BaselinedDimension) d;
		else {
			bd = new BaselinedDimension(d);
			if (child instanceof IEntityFigure) {
				bd.indent = ((IEntityFigure) child).getIndent();
				bd.ascent = ((IEntityFigure) child).getAscent();
			} else
				bd.ascent = bd.height/2;
			}
		return bd;
	}

	protected int getIndent() {
		return 0;
	}

	protected int indent(int i) {
		return childSize[i].getIndent();
	}
	protected int ascent(int i) {
		return childSize[i].getAscent();
	}
	protected int descent(int i) {
		return childSize[i].getDescent();
	}

	public boolean isHorizontal() {
		return false;
	}

	protected boolean isChildVisible(int i) {
		return childSize[i] != null;// && childFigure[i].isShowing();//FIXME
	}

	public void layout(IFigure container) {
		//FIXME workaround
		if (childSize == null)
			calculatePreferredSize(container, -1, -1);
		
		Rectangle area = container.getClientArea();
		area.x += getMarginLeft() + getViewportTrackingStrategy().getIndent();
		area.y += getMarginTop() + getViewportTrackingStrategy().getAscent();
		area.width -= (getMarginLeft()+getViewportTrackingStrategy().getIndent()+getMarginRight());
		area.height -= (getMarginTop()+getViewportTrackingStrategy().getAscent()+getMarginBottom());

		int size = childFigure.length;
		int[] x = new int[size];
		int[] y = new int[size];
		
		setLocation(area, x, y);

		Rectangle bounds = Rectangle.SINGLETON;
		for (int i=0; i<childFigure.length; i++)
			if (isChildVisible(i)) {
				bounds.setLocation(x[i], y[i]);
				bounds.setSize(childSize[i].width, childSize[i].height);
				childFigure[i].setBounds(bounds);
			}
	}
	protected abstract void setLocation(Rectangle area, int[] x, int[] y);

	public int getIndent(IFigure container) {
		//FIXME workaround
		if (preferredSize == null)
			return 0;
//			preferredSize = calculatePreferredSize(container, -1, -1);
		return preferredSize.getIndent();
	}
	public int getAscent(IFigure container) {
		//FIXME workaround
		if (preferredSize == null)
			return figAscent;
//			preferredSize = calculatePreferredSize(container, -1, -1);
		return preferredSize.getAscent();
	}

	public Rectangle getBounds(int childIndex) {
		return childFigure[childIndex].getBounds();
	}
	public int getBaseline(int childIndex) {
		return getBounds(childIndex).y + ascent(childIndex) -1; //FIXME -1 y[childIndex]
	}

	public IEntityLayout withAutoresizeWeight(float weight) {
		withMajorAutoresizeWeight(weight);
		withMinorAutoresizeWeight(weight);
		return this;
	}
	public IEntityLayout withMajorAutoresizeWeight(float weight) {
		majorAutoresizeWeight = weight;
		return this;
	}
	public IEntityLayout withMinorAutoresizeWeight(float weight) {
		minorAutoresizeWeight = weight;
		return this;
	}
	public float getMajorAutoresizeWeight() {
		return majorAutoresizeWeight;
	}
	public float getMinorAutoresizeWeight() {
		return minorAutoresizeWeight;
	}
	public float getMajorAutoresizeWeight(int childIndex) {
		if (childFigure[childIndex] instanceof EntityFigure) {
			EntityFigure childEntityFigure = (EntityFigure) childFigure[childIndex];
			return isHorizontal() && childEntityFigure.getLayoutManager().isHorizontal() ?
					childEntityFigure.getMajorAutoresizeWeight() :
						childEntityFigure.getMinorAutoresizeWeight();
		}
		return 0f;
	}
	public float getMinorAutoresizeWeight(int childIndex) {
		if (childFigure[childIndex] instanceof EntityFigure) {
			EntityFigure childEntityFigure = (EntityFigure) childFigure[childIndex];
			return isHorizontal() && childEntityFigure.getLayoutManager().isHorizontal() ?
					childEntityFigure.getMinorAutoresizeWeight() :
						childEntityFigure.getMajorAutoresizeWeight();
		}
		return 0f;
	}

	public boolean isOrdered() {
		return false;
	}

	protected int spacedChild = SPACED_NONE;
	public int getSpacedChild() {
		return spacedChild;
	}
	public void setSpacedChild(int childIndex) {
		this.spacedChild = childIndex;
	}

	public IEntityLayout withSpacing(int spacing) {
		return this;
	}
	public int getSpacing() {
		return 0;
	}
	public int getSpacingBefore(int childIndex) {
		return childIndex == getSpacedChild() || childIndex == getSpacedChild()+1 || getSpacedChild() == SPACED_ALL ?
						getSpacedSpacing(getSpacing()) : getSpacing();
	}
	protected int getSpacedSpacing(int spacing) {
		return defaultGetSpacedSpacing(spacing);
	}
	public static int defaultGetSpacedSpacing(int spacing) {
		return Math.max(SPACED_SPACING, (int) (spacing));//WAS *1.2));
	}

	public ITabularLayoutServer getTabularLayoutServer() {
		return this instanceof ITabularLayoutServer ? (ITabularLayoutServer) this : null;
	}
	public ITabularLayoutClient getTabularLayoutClient() {
		return this instanceof ITabularLayoutClient ? (ITabularLayoutClient) this : ITabularLayoutClient.NULL_TABULAR_LAYOUT_CLIENT;
	}
	public void setStartingCellIndex(int cellIndex) {
	}
	public int getStartingCellIndex() {
		return 0;
	}
	public int getCells() {
		return 0;
	}
	public void invalidateCells() {
		invalidate();
	}
	public Dimension getPreferredCellSize(int cellIndex, int wHint, int hHint) {
		int childIndex = cellIndex - getStartingCellIndex();
		return childIndex < getCells() && childFigure[childIndex].isVisible() ? childFigure[childIndex].getPreferredSize(wHint, hHint) : IEntityFigure.PLACE_HOLDER_DIMENSION;
	}
	public Rectangle getCellBounds(int cellIndex) {
		int childIndex = cellIndex - getStartingCellIndex();
		return childIndex < getCells() && childFigure[childIndex].isVisible() ? childFigure[childIndex].getBounds() : IEntityFigure.PLACE_HOLDER_BOUNDS;
	}
	public int getCellSpacingBefore(int cellIndex) {
		return getPreferredCellSpacingBefore(cellIndex);
	}
	public int getPreferredCellSpacingBefore(int cellIndex) {
		int childIndex = cellIndex - getStartingCellIndex();
		int cells = getCells();
		if (childIndex > cells)
			return 0;
		else if (childIndex == 0)
			return isHorizontal() ? getMarginLeft() : getMarginTop();
		else if (childIndex == cells)
			return isHorizontal() ? getMarginRight() : getMarginBottom();
		else
			return getSpacingBefore(childIndex);
	}

	protected static class SizeKey {
		protected IFigure container;
		protected int wHint;
		protected int hHint;
		public SizeKey(IFigure container, int wHint, int hHint) {
			setProperties(container, wHint, hHint);
		}
		public SizeKey setProperties(IFigure container, int wHint, int hHint) {
			this.container = container;
			this.wHint = wHint;
			this.hHint = hHint;
			return this;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((container == null) ? 0 : container.hashCode());
			result = prime * result + hHint;
			result = prime * result + wHint;
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			SizeKey other = (SizeKey) obj;
			if (container == null) {
				if (other.container != null)
					return false;
			} else if (!container.equals(other.container))
				return false;
			if (hHint != other.hHint)
				return false;
			if (wHint != other.wHint)
				return false;
			return true;
		}
		public IFigure getContainer() {
			return container;
		}
		public void setContainer(IFigure container) {
			this.container = container;
		}
		public int getwHint() {
			return wHint;
		}
		public void setwHint(int wHint) {
			this.wHint = wHint;
		}
		public int gethHint() {
			return hHint;
		}
		public void sethHint(int hHint) {
			this.hHint = hHint;
		}
	}
}
