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
package org.whole.lang.ui.notations.tree.figures;

import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Toggle;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.ui.WholeImages;
import org.whole.lang.ui.figures.AnchorFactory;
import org.whole.lang.ui.figures.FigureConstants;
import org.whole.lang.ui.figures.INodeFigure;
import org.whole.lang.ui.figures.CompositeFigure;
import org.whole.lang.ui.figures.NodeFigure;
import org.whole.lang.ui.figures.EntityToggle;
import org.whole.lang.ui.layout.Alignment;
import org.whole.lang.ui.layout.RowLayout;
import org.whole.lang.ui.notations.figures.DrawUtils;
import org.whole.lang.ui.notations.tree.figures.RoundedTitleTabBorder.Style;

/**
 * @author Riccardo Solmi
 */
public class CompositeEntityTreeFigure extends NodeFigure {
	private boolean isRightToLeft;
	protected Toggle mainToggle; // used by createTargetAnchors
	protected CompositeFigure compositeFigure;

	public CompositeEntityTreeFigure(EntityDescriptor<?> ed, boolean isRightToLeft) {
		initContentPanes(1);
		this.isRightToLeft = isRightToLeft;

		int leftShrink, rightShrink;
		if (isRightToLeft()) {
			leftShrink = 0;
			rightShrink = 5;
		} else {
			leftShrink = 5;
			rightShrink = 0;
		}

		setLayoutManager(new RowLayout()
				.withMinorAlignment(Alignment.CENTER)
				.withMajorAlignment(isRightToLeft() ? Alignment.TRAILING : Alignment.LEADING));
		
		mainToggle = createFoldingToggle(new EntityToggle(WholeImages.ROUND_EXPAND, WholeImages.ROUND_COLLAPSE), 0);

		compositeFigure = new CompositeFigure(false);
		compositeFigure.setBorder(null);
		compositeFigure.getLayoutManager().withMargin(DrawUtils.SPACING).withSpacing(6)
				.withMinorAlignment(isRightToLeft() ? Alignment.TRAILING : Alignment.LEADING);

		if (isRightToLeft()) {
			add(createContentPane(0, compositeFigure));
			add(mainToggle);
		} else {
			add(mainToggle);
			add(createContentPane(0, compositeFigure));
		}

		setBorder(new RoundedTitleTabBorder(ed.getName(), new Insets(0, leftShrink, 0, rightShrink), Style.DASHED));
	}

	@Override
	public Dimension getPreferredSize(int wHint, int hHint) {
		Dimension size = super.getPreferredSize(wHint, hHint);
		//FIXME
		if (size.width < DrawUtils.SPACING + getBorder().getPreferredSize(this).width)
			size.width = Math.max(size.width, DrawUtils.SPACING + getBorder().getPreferredSize(this).width);
		return size;
	}

	@Override
	protected ConnectionAnchor[] createTargetAnchors() {
		return new ConnectionAnchor[] {
			AnchorFactory.createFixedAnchor(mainToggle, isRightToLeft() ? 1.0 : 0, 0.5)
		};
	}

	@Override
	protected void paintFigure(Graphics graphics) {
		super.paintBorder(graphics);
		super.paintFigure(graphics);
	}
	
	@Override
	protected void paintBorder(Graphics graphics) {
	}

	@Override
	protected void paintClientArea(Graphics graphics) {
		super.paintClientArea(graphics);
		paintConnections(graphics);
		graphics.restoreState();
	}

	protected void paintConnections(Graphics graphics) {
		// paint composite connections
		graphics.setForegroundColor(FigureConstants.relationsColor);
		IFigure compositeFigure = getContentPane(0);
		if (compositeFigure.isVisible()) {
			int compositeChildrenNumber = compositeFigure.getChildren().size();
			if (compositeChildrenNumber == 0)
				return;
			Point mainToggleLocation = isRightToLeft() ? mainToggle.getBounds().getLeft() : mainToggle.getBounds().getRight();
//			translateToRelative(mainToggleLocation);
			Point[] childs = new Point[compositeChildrenNumber];
			for (int i=0; i<compositeChildrenNumber; i++) {
				IFigure compositeChild = (IFigure) compositeFigure.getChildren().get(i);
			
				// calculate target point position
				Point targetLocation;
				if (compositeChild instanceof INodeFigure)
					targetLocation = ((INodeFigure) compositeChild).getTargetAnchor(0).getLocation(null);
				else {
					Rectangle compositeChildBounds = compositeChild.getBounds();
					targetLocation = isRightToLeft() ? compositeChildBounds.getRight() : compositeChildBounds.getLeft();
					compositeChild.translateToAbsolute(targetLocation);
				}
				translateToRelative(targetLocation);
				childs[i] = targetLocation;
			}
			DrawUtils.drawHorizontalTree(graphics, mainToggleLocation, DrawUtils.SPACING/2, childs);
		}
	}

	public boolean isRightToLeft() {
		return isRightToLeft;
	}
}
