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
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.Toggle;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Insets;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.ui.WholeImages;
import org.whole.lang.ui.figures.AnchorFactory;
import org.whole.lang.ui.figures.NodeFigure;
import org.whole.lang.ui.figures.LabelFactory;
import org.whole.lang.ui.figures.EntityToggle;
import org.whole.lang.ui.layout.Alignment;
import org.whole.lang.ui.layout.RowLayout;
import org.whole.lang.ui.notations.tree.figures.RoundedTitleTabBorder.Style;

public class DataEntityTreeFigure extends NodeFigure {
	private static final int SPACING = 5;
	private boolean isRightToLeft;
	protected Toggle mainToggle; // used by createTargetAnchors

	public DataEntityTreeFigure(EntityDescriptor<?> ed, boolean isRightToLeft) {
		this.isRightToLeft = isRightToLeft;
		initContentPanes(1);
		mainToggle = createFoldingToggle(new EntityToggle(WholeImages.ROUND_EXPAND, WholeImages.ROUND_COLLAPSE), 0);
		
		IFigure contentPane = createContentPane(0, LabelFactory.createLiteral());
		contentPane.setBorder(new MarginBorder(0, SPACING, 0, SPACING));


		if (isRightToLeft) {
			setLayoutManager(new RowLayout().withMajorAlignment(Alignment.TRAILING).withMarginLeft(SPACING)
					.withSpacing(SPACING));
			add(contentPane);
			add(mainToggle);
		} else {
			setLayoutManager(new RowLayout().withMajorAlignment(Alignment.LEADING).withMarginRight(SPACING));
			add(mainToggle);
			add(contentPane);			
		}
		setBorder(new RoundedTitleTabBorder(ed.getName(), new Insets(0, 5, 0, 5), Style.SOLID));
	}

	@Override
	public Dimension getPreferredSize(int wHint, int hHint) {
		Dimension size = super.getPreferredSize(wHint, hHint);
		size.width = Math.max(size.width, SPACING*2 + getBorder().getPreferredSize(this).width);
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

	public boolean isRightToLeft() {
		return isRightToLeft;
	}
}
