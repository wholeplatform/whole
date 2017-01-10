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
package org.whole.lang.workflows.ui.figures;

import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.whole.lang.ui.figures.AnchorFactory;
import org.whole.lang.ui.figures.EntityFigure;
import org.whole.lang.ui.figures.FigureConstants;
import org.whole.lang.ui.figures.NodeFigure;
import org.whole.lang.ui.layout.Alignment;
import org.whole.lang.ui.layout.ColumnLayout;
import org.whole.lang.ui.layout.ICompositeEntityLayout;
import org.whole.lang.ui.layout.RowLayout;
import org.whole.lang.ui.layout.TableLayout;

/**
 * @author Riccardo Solmi
 */
public abstract class AbstractActivityFigure extends NodeFigure {
	protected IFigure contentFigure;

	public AbstractActivityFigure(int contentPanes, Image image) {
		setLayoutManager(new ColumnLayout().withMinorAlignment(Alignment.CENTER));
		setBorder(new MarginBorder(4));
		initContentPanes(contentPanes);

		EntityFigure header = new EntityFigure(new RowLayout()
			.withSpacing(2).withMarginLeft(2).withMarginRight(2));
		header.addLabel(image);
		header.add(createContentPane(0));
		header.add(createFoldingToggle(contentPanes));

		add(header);
		add(contentFigure = createContentFigure());

		for (int i=1; i<contentPanes; i++)
			bindFoldingToggle(0, i);
	
		clickFoldingToggle(0);
	}

	protected abstract IFigure createContentFigure();

	protected ICompositeEntityLayout createTableLayout(int columns) {
		return new TableLayout(columns).withColumnSpacing(8).withMargin(4, 5, 5, 5);
	}

	@Override
	protected void toggleVisibility(int paneIndex) {
		if (paneIndex == getContentPanesSize()) {
			boolean visible = !contentFigure.isVisible();
			contentFigure.setVisible(visible);
		} else
			super.toggleVisibility(paneIndex);
	}

	protected ConnectionAnchor[] createSourceAnchors() {
		return new ConnectionAnchor[] {
				AnchorFactory.createBottomMiddleAnchor(this)};
	}
	protected ConnectionAnchor[] createTargetAnchors() {
		return new ConnectionAnchor[] {
				AnchorFactory.createTopMiddleAnchor(this)};
	}

	@Override
	public Color getLocalForegroundColor() {
		return FigureConstants.contentColor;
	}
}
