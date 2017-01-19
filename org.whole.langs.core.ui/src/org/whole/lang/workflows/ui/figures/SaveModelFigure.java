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

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.FigureUtilities;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.MarginBorder;
import org.whole.lang.ui.figures.EntityFigure;
import org.whole.lang.ui.figures.LabelFactory;
import org.whole.lang.ui.figures.PaintFigureHelper;
import org.whole.lang.ui.figures.TableFigure;
import org.whole.lang.ui.figures.TableRowFigure;
import org.whole.lang.ui.layout.ICompositeEntityLayout;
import org.whole.lang.ui.layout.RowLayout;
import org.whole.lang.ui.notations.NotationImages;

/**
 * @author Riccardo Solmi
 */
public class SaveModelFigure extends AbstractActivityWithTableFigure {
	public SaveModelFigure() {
		super(6, NotationImages.REPLY16);

		TableRowFigure row = new TableRowFigure();
		row.addLabel("model");
		row.add(createContentPane(1));
		contentFigure.add(row);

		row = new TableRowFigure();
		row.addEmptyLabel();
		row.add(LabelFactory.createSymbolRegularContent(" \u2193"));
		contentFigure.add(row);

		EntityFigure resourceFigure = new EntityFigure(new RowLayout().withSpacing(4));
		resourceFigure.add(createContentPane(3));
		resourceFigure.add(createContentPane(4));
		row = new TableRowFigure();
		row.addLabel("resource");
		row.add(resourceFigure);
		contentFigure.add(row);

		row = new TableRowFigure();
		row.addLabel("persistence");
		row.add(createContentPane(2));
		contentFigure.add(row);

		row = new TableRowFigure();
		row.addLabel("arguments");
		row.add(createContentPane(5, new MarginBorder(4,0,0,0)));
		contentFigure.add(row);
	}

	@Override
	protected ICompositeEntityLayout createTableLayout(int columns) {
		return super.createTableLayout(2);
	}
	protected TableFigure createTableFigure(ICompositeEntityLayout layout) {
		return new LeftHeadersTableFigure(layout);
	}

	public void paintFigure(Graphics g) {
		super.paintFigure(g);
        PaintFigureHelper.drawGradientRoundRectangle(g, getBounds(),
        		FigureUtilities.lighter(ColorConstants.lightGreen), ColorConstants.white, ColorConstants.darkGreen, false);
	}
}
