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
package org.whole.lang.ui.notations.flowchart.figures;

import java.util.List;

import org.eclipse.draw2d.AbstractBorder;
import org.eclipse.draw2d.ActionListener;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.SWT;
import org.whole.lang.ui.figures.AnchorFactory;
import org.whole.lang.ui.figures.CompositeFigure;
import org.whole.lang.ui.figures.EntityFigure;
import org.whole.lang.ui.figures.EntityLabel;
import org.whole.lang.ui.figures.EntityToggle;
import org.whole.lang.ui.figures.FigureConstants;
import org.whole.lang.ui.figures.LabelFactory;
import org.whole.lang.ui.figures.NodeFigure;
import org.whole.lang.ui.layout.Alignment;
import org.whole.lang.ui.layout.ColumnLayout;
import org.whole.lang.ui.layout.RowLayout;
import org.whole.lang.ui.notations.NotationImages;

/**
 * @author Riccardo Solmi
 */
public class SwitchControlFigure extends NodeFigure {
	protected IFigure bodyFigure;

	public SwitchControlFigure(ActionListener a1) {
		initContentPanes(3);

		ColumnLayout l = new ColumnLayout();
		l.withMinorAlignment(Alignment.CENTER);
		l.withSpacing(2);
		setLayoutManager(l);

		CompositeFigure topFigure = new CompositeFigure(true);
		topFigure.addLabel(NotationImages.SWITCH16);
		topFigure.add(createContentPane(0));
		topFigure.add(createFoldingToggle(12, 1, 2));

		EntityFigure casesFigure = new EntityFigure(
				new RowLayout().withMinorAlignment(Alignment.LEADING).withSpacing(3));
		casesFigure.add(createContentPane(1));
		casesFigure.add(createContentPane(2));

		bodyFigure = new EntityFigure(new ColumnLayout().withMinorAlignment(Alignment.CENTER).withSpacing(2));
		bodyFigure.add(createActionableFoldingToggle(new EntityToggle("\u00d7", "+", a1) {
			protected EntityLabel createLabel(String text) {
				return LabelFactory.createSymbolMedium(text, FigureConstants.contentLightColor);
			}
		}));
		bodyFigure.add(casesFigure);

		add(topFigure);
		add(bodyFigure);
		setBorder(createBorder(true));
	}

	public void setSwitchType(boolean isInclusive) {
		getFoldingToggle(1).setSelected(isInclusive);
	}

	protected void toggleVisibility(int paneIndex) {
		bodyFigure.setVisible(!bodyFigure.isVisible());
	}

	protected ConnectionAnchor[] createAnchors() {
		return new ConnectionAnchor[] {
				AnchorFactory.createTopOrBottomMiddleAnchor(this)};
	}

	protected AbstractBorder createBorder(final boolean isHorizontal) {
		return new AbstractBorder() {
			private /*static*/ final Insets INSETS = new Insets(10,10,10,10);
			public Insets getInsets(IFigure figure) {
				return INSETS;
			}
			public void paint(IFigure figure, Graphics graphics, Insets insets) {
				Rectangle rect = getPaintRectangle(figure, insets).resize(-1, -1);
				graphics.setForegroundColor(ColorConstants.lightGray);
//				graphics.setLineStyle(SWT.LINE_CUSTOM);
//				graphics.setLineDash(new int[] {8,3});
				graphics.drawRoundRectangle(rect,10,10);
			}
		};
	}

	@SuppressWarnings("unchecked")
	public void paintFigure(Graphics g) {
        super.paintFigure(g);
        Rectangle r = getBounds();
        Rectangle rc = getContentPane(1).getBounds();
        Rectangle dc = getContentPane(2).getBounds();
        List<IFigure> contentPaneChildren = getContentPane(1).getChildren();
        
        List<IFigure> children = contentPaneChildren.isEmpty() ? contentPaneChildren : contentPaneChildren.get(0).getChildren();

    	int xm = r.x + r.width/2;
        int y0 = rc.y -12;
        if (bodyFigure.isVisible()) {
        	int y1 = rc.y + Math.max(rc.height, dc.height)-1 +5;

        	g.drawLine(xm, r.y, xm, y0);
            g.drawLine(xm, y1, xm, r.y+r.height-1);

        	int x1;
            if (children.size() >= 2) {
            	Rectangle r0 = children.get(0).getBounds();
            	Rectangle r1 = children.get(children.size()-1).getBounds();
            	int x0 = r0.x + r0.width/2;
            	x1 = r1.x + r1.width/2;

                g.drawLine(x0, y0, x1, y0);
                g.drawLine(x0, y1, x1, y1);
            } else
            	x1 = rc.x+rc.width/2;
            
            for (int i=0; i<children.size(); i++) {
            	Rectangle ri = children.get(i).getBounds();
            	int xi = ri.x + ri.width/2;
                int yi = ri.y + ri.height;
            	
                g.drawLine(xi, y0, xi, ri.y);
                g.drawLine(xi, yi, xi, y1);
            }

            int x2 = dc.x + dc.width/2;

            g.pushState();
            g.setLineStyle(SWT.LINE_CUSTOM);
			g.setLineDash(new int[] {8,3});
            g.drawLine(x1, y0, x2, y0);
            g.drawLine(x1, y1, x2, y1);
            g.drawLine(x2, y0, x2, dc.y);
            g.drawLine(x2, dc.y+dc.height, x2, y1);
            g.setLineDash((int[]) null);
            g.popState();
            
            int JOIN_SIZE = 16;
            g.setForegroundColor(ColorConstants.darkGray);
			g.setBackgroundColor(FigureConstants.lightGray);
            g.fillOval(xm-JOIN_SIZE/2, y0-JOIN_SIZE/2, JOIN_SIZE, JOIN_SIZE);
            g.drawOval(xm-JOIN_SIZE/2, y0-JOIN_SIZE/2, JOIN_SIZE, JOIN_SIZE);
        }
	}
}
