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
package org.whole.lang.patterns.ui.figures;

import org.eclipse.draw2d.Graphics;
import org.whole.lang.ui.figures.ContentPaneFigure;
import org.whole.lang.ui.figures.DoubleSquareBracketsBorder;
import org.whole.lang.ui.figures.EntityFigure;
import org.whole.lang.ui.figures.EntityLabel;
import org.whole.lang.ui.figures.FigureConstants;
import org.whole.lang.ui.figures.IQualifiedFigure;
import org.whole.lang.ui.figures.LabelFactory;
import org.whole.lang.ui.layout.OverLayout;
import org.whole.lang.ui.layout.RowLayout;

/**
 * @author Riccardo Solmi
 */
public class PointcutStepFigure extends ContentPaneFigure implements IQualifiedFigure {
	private EntityLabel namespaceLabel;

	public PointcutStepFigure() {
		super(new RowLayout().withSpacing(2));
		initContentPanes(1);

		EntityFigure nameFigure = new EntityFigure(new OverLayout());
		nameFigure.add(createContentPane(0, LabelFactory.createDeclaration()));
		nameFigure.add(namespaceLabel = LabelFactory.createModule());
		add(nameFigure);
		
		namespaceLabel.setVisible(false);
		
		EntityLabel braskets = LabelFactory.createDeclaration();
		braskets.setBorder(new DoubleSquareBracketsBorder());
		add(braskets);
	}

	public void setQualifierName(String name) {
		if (name != null) {
			namespaceLabel.setVisible(true);
			namespaceLabel.setText(name);
		} else
			namespaceLabel.setVisible(false);
	}
	public EntityLabel getNameLabel() {
		return (EntityLabel) getContentPane(0);
	}

	public void paintFigure(Graphics g) {
        super.paintFigure(g);

    	int oldAlpha = g.getAlpha();
		g.setAlpha(100);
    	g.setBackgroundColor(FigureConstants.relationsColor);
        g.fillRoundRectangle(getContentPane(0).getBounds(), 8, 6);
        g.setAlpha(oldAlpha);
	}
}
