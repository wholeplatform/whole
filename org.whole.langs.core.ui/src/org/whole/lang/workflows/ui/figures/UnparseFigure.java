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
import org.whole.lang.ui.figures.LabelFactory;
import org.whole.lang.ui.figures.PaintFigureHelper;
import org.whole.lang.ui.figures.TableFigure;
import org.whole.lang.ui.figures.TableRowFigure;
import org.whole.lang.ui.layout.ICompositeEntityLayout;
import org.whole.lang.ui.layout.TableLayout;
import org.whole.lang.ui.notations.NotationImages;

/**
 * @author Riccardo Solmi
 */
public class UnparseFigure extends AbstractActivityWithTableFigure {
	public UnparseFigure() {
		super(5, NotationImages.OPERATION16);
		
		TableRowFigure headers = new TableRowFigure();
		headers.addLabel("model");
		headers.addEmptyLabel();
		headers.addLabel("text");
		headers.addLabel("grammar");
		headers.addLabel("nt");
		
		contentFigure.add(headers, TableLayout.Placement.HEADER);
	
		TableRowFigure row2 = new TableRowFigure();
		row2.add(createContentPane(1));
		row2.add(LabelFactory.createSymbolRegularContent("\u2192"));
		row2.add(createContentPane(2));
		row2.add(createContentPane(3));
		row2.add(createContentPane(4));
		contentFigure.add(row2);
	}

	@Override
	protected ICompositeEntityLayout createTableLayout(int columns) {
		return super.createTableLayout(5);
	}
	protected TableFigure createTableFigure(ICompositeEntityLayout layout) {
		return new TopHeadersTableFigure(layout);
	}

	public void paintFigure(Graphics g) {
        super.paintFigure(g);
        PaintFigureHelper.drawGradientRoundRectangle(g, getBounds(),
        		FigureUtilities.lighter(ColorConstants.lightBlue), ColorConstants.white, ColorConstants.darkBlue, false);
	}
}
