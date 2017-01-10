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
package org.whole.lang.actions.ui.figures;

import java.util.List;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.SWT;
import org.whole.lang.ui.WholeImages;
import org.whole.lang.ui.figures.EntityFigure;
import org.whole.lang.ui.figures.FigureConstants;
import org.whole.lang.ui.figures.ContentPaneFigure;
import org.whole.lang.ui.figures.IEntityFigure;
import org.whole.lang.ui.layout.ColumnLayout;
import org.whole.lang.ui.layout.DiagRightBottomLayout;
import org.whole.lang.ui.layout.RowLayout;
import org.whole.lang.ui.notations.figures.DrawUtils;

/**
 * @author Riccardo Solmi
 */
public class ToolbarActionsFigure extends ContentPaneFigure {
	protected static final int TOOLS = 5; 
	protected EntityFigure toolbarFigure;
	protected IFigure[] toolFigure, actionFigure;

	public ToolbarActionsFigure() {
		super(new DiagRightBottomLayout());
		initContentPanes(TOOLS);
		toolFigure = new IFigure[TOOLS];
		actionFigure = new IFigure[TOOLS];

		toolbarFigure = new EntityFigure(new RowLayout().withSpacing(4).withMargin(6, 5, 4, 5)) {
			protected void paintFigure(Graphics g) {
				Rectangle r = getBounds();
				g.setBackgroundColor(ColorConstants.button);
				g.fillRectangle(r);
				g.setForegroundColor(ColorConstants.buttonLightest);
				g.drawLine(r.x, r.y, r.x+r.width, r.y);
				g.setForegroundColor(ColorConstants.buttonDarker);
				g.drawLine(r.x, r.y+r.height-1, r.x+r.width, r.y+r.height-1);
	
				super.paintFigure(g);
			}
		};
		toolFigure[0] = toolbarFigure.addLabel(WholeImages.VALIDATOR);
		toolFigure[1] = toolbarFigure.addLabel(WholeImages.NORMALIZER);
		toolFigure[2] = toolbarFigure.addLabel(WholeImages.PRETTY_PRINTER);
		toolFigure[3] = toolbarFigure.addLabel(WholeImages.INTERPRETER);
		toolFigure[4] = toolbarFigure.addLabel(WholeImages.GENERATOR);

		toolFigure[0].setToolTip(new Label("Validator"));
		toolFigure[1].setToolTip(new Label("Normalizer"));
		toolFigure[2].setToolTip(new Label("Pretty printer"));
		toolFigure[3].setToolTip(new Label("Interpreter"));
		toolFigure[4].setToolTip(new Label("Generator"));
		
		EntityFigure col = new EntityFigure(new ColumnLayout().withSpacing(8));
		for (int i=0; i<TOOLS; i++)
			actionFigure[i] = col.add((IEntityFigure) createContentPane(i));

		add(toolbarFigure);
		add(col);
	}

	//TODO remove
	protected EntityFigure createActionRow(int paneIndex) {
		EntityFigure row = new EntityFigure(new RowLayout().withSpacing(4));
		row.add(createFoldingToggle(paneIndex));
		row.add(createContentPane(paneIndex));
		return row;
	}

	protected void paintFigure(Graphics g) {
		super.paintFigure(g);
		
		g.setForegroundColor(FigureConstants.contentLighterColor);
		g.setLineStyle(SWT.LINE_CUSTOM);
		g.setLineDash(new int[] {1,1});

		for (int i=0; i<TOOLS; i++) {
			@SuppressWarnings("unchecked")
			List<IFigure> children = actionFigure[i].getChildren();
			if (children.isEmpty())
				continue;
			IFigure f = children.get(0);
			//TODO rewrite
			if (f instanceof ContentPaneFigure) {
				ContentPaneFigure contentPaneFigure = (ContentPaneFigure) f;
				if (!contentPaneFigure.getFoldingToggles().isEmpty())
					f = contentPaneFigure.getFoldingToggle(0);
			}

			DrawUtils.drawOutline(g,
					toolFigure[i].getBounds().getBottom().translate(0, 4),
					f.getBounds().getLeft().translate(-1, -1));
		}
	}
}
