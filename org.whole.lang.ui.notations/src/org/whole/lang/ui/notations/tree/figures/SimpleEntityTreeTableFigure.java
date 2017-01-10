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

import java.util.List;

import org.eclipse.draw2d.ActionListener;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Toggle;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.ui.figures.AnchorFactory;
import org.whole.lang.ui.figures.EntityButton;
import org.whole.lang.ui.figures.EntityFigure;
import org.whole.lang.ui.figures.FigureConstants;
import org.whole.lang.ui.figures.INodeFigure;
import org.whole.lang.ui.figures.NodeFigure;
import org.whole.lang.ui.figures.TableFigure;
import org.whole.lang.ui.figures.TableRowFigure;
import org.whole.lang.ui.layout.Alignment;
import org.whole.lang.ui.layout.ColumnLayout;
import org.whole.lang.ui.layout.MonoLayout;
import org.whole.lang.ui.layout.RowLayout;
import org.whole.lang.ui.layout.TableLayout;
import org.whole.lang.ui.layout.ViewportTracking;
import org.whole.lang.ui.notations.figures.DrawUtils;
import org.whole.lang.ui.notations.tree.editparts.IEmbeddingStrategy;

/**
 * @author Riccardo Solmi
 */
public class SimpleEntityTreeTableFigure extends NodeFigure {
	protected boolean isRightToLeft;
	protected EntityFigure nodeFigure;
	protected final EntityFigure titleFigure;
	protected final TableFigure tableFigure;
	protected EntityFigure contentsFigure;

	public SimpleEntityTreeTableFigure(EntityDescriptor<?> ed, boolean isRightToLeft, IEmbeddingStrategy embeddingStrategy, ActionListener linkListener) {
		this.isRightToLeft = isRightToLeft;
		int childSize = ed.childFeatureSize();

		initContentPanes(childSize);

		titleFigure = TreeNotationUtils.createTitleFigure(
				ed.getName(), createFoldingToggle(255));

		tableFigure = createTableFigure(2);
		tableFigure.getLayoutManager().withColumnAlignment(0, Alignment.TRAILING)
		.withMarginTop(2).withMarginBottom(2).withMajorAutoresizeWeight(1);

		nodeFigure = new EntityFigure(new ColumnLayout()) {
			protected void paintFigure(Graphics g) {
				super.paintFigure(g);
				
				Rectangle b = nodeFigure.getBounds();
				g.setForegroundColor(FigureConstants.blueColor);
				g.drawRoundRectangle(b.getResized(-1, -1), 8, 8);

				int oldAlpha = g.getAlpha();
				g.setAlpha(60);

				b = b.getCopy();
				b.height = titleFigure.getBounds().height;
				g.setBackgroundColor(FigureConstants.blueColor);
				if (tableFigure.isVisible()) {
					g.setClip(b);
					g.fillRoundRectangle(b.getResized(0, 4), 8, 8);
				} else
					g.fillRoundRectangle(b, 8, 8);

				g.setAlpha(oldAlpha);
			}
		};
		nodeFigure.add(titleFigure);
		nodeFigure.add(tableFigure);

		contentsFigure = new EntityFigure(new ColumnLayout().withSpacing(8).withMarginLeft(2));

		for (int i=0; i<childSize; i++) {
			TableRowFigure row = new TableRowFigure();
			row.getLayoutManager().withMarginLeft(4).withMarginRight(4);
			row.addLabel(ed.getEntityFeatureDescriptor(i).getName());

			if (embeddingStrategy.embedChild(ed, i))
				row.add(createContentPane(i));
			else {
				row.add(createFoldingToggle(i));
				contentsFigure.add(createContentPane(i));
			}
			tableFigure.add(row);
		}

		for (int i=childSize, size=ed.featureSize(); i<size; i++) {
			TableRowFigure row = new TableRowFigure();
			row.getLayoutManager().withMarginLeft(4).withMarginRight(4);
			row.addLabel(ed.getEntityFeatureDescriptor(i).getName());
			row.add(new EntityButton(linkListener, i));
			tableFigure.add(row);
		}

		EntityFigure trackingFigure = new EntityFigure(new MonoLayout().withAutoresizeWeight(1f)).withViewportTracking(ViewportTracking.VERTICAL);
		trackingFigure.add(nodeFigure);
		add(trackingFigure);
		add(contentsFigure);

		setLayoutManager(new RowLayout().withMargin(2, 4, 2, 0).withSpacing(
				contentsFigure.getChildren().size()*4));
	}

	protected TableFigure createTableFigure(int columns) {
		return new TableFigure(new TableLayout(columns)
				.withColumnSpacing(10).withMarginTop(0).withMarginBottom(0)) {
			protected void paintFigure(Graphics g) {
				super.paintFigure(g);

				g.setBackgroundColor(ColorConstants.lightGray);
				drawAlternateColumnsBackground(g, 0);

				g.setForegroundColor(FigureConstants.blueColor);
				drawHeadersRowSeparator(g);

				g.setForegroundColor(ColorConstants.lightGray);
				drawColumnSeparators(g);
				int oldAlpha = g.getAlpha();
				g.setAlpha(80);
				drawRowSeparators(g);
				g.setAlpha(oldAlpha);
			}
		};
	}

	public boolean isRightToLeft() {
		return isRightToLeft;
	}

	@Override
	public List<Toggle> getFoldingToggles(IFigure figure) {
		List<Toggle> toggles = super.getFoldingToggles(figure);
		toggles.add(getFoldingToggle(0));
		return toggles;
	}

	@Override
	protected void toggleVisibility(int paneIndex) {
		if (paneIndex == 255) {
			boolean isVisible = !tableFigure.isVisible();
			tableFigure.setVisible(isVisible);
			contentsFigure.setVisible(isVisible);
		} else
			super.toggleVisibility(paneIndex);
	}

	@Override
	protected ConnectionAnchor[] createSourceAnchors() {
		// TODO
		return super.createSourceAnchors();
	}

	@Override
	protected ConnectionAnchor[] createTargetAnchors() {
		return new ConnectionAnchor[] {
			AnchorFactory.createFixedAnchor(nodeFigure, isRightToLeft() ? 1.0 : 0, 0.5)
		};
	}

	@Override
	public void paintClientArea(Graphics graphics) {
		super.paintClientArea(graphics);
		paintConnections(graphics);
		graphics.restoreState();
	}

	@SuppressWarnings("unchecked")
	protected void paintConnections(Graphics g) {
		g.setForegroundColor(FigureConstants.relationsColor);

		List<IFigure> contentPanes = contentsFigure.getChildren();
		int contentPanesSize = contentPanes.size();
		Point[] start = new Point[contentPanesSize];
		Point[] end = new Point[contentPanesSize];
		int nodeRight = nodeFigure.getBounds().right();
		int size = 0;
		for (int i=0; i<contentPanesSize; i++) {
			IFigure contentPane = contentPanes.get(i);
			if (contentPane.isVisible()) {
				start[size] = getFoldingToggle(i+1).getBounds().getRight();
				start[size].x = nodeRight;
				List<IFigure> children = contentPane.getChildren();
				IFigure targetFigure = children.isEmpty() ? null : (IFigure) children.get(0);
				if (targetFigure instanceof INodeFigure) {
					end[size] = ((INodeFigure) targetFigure).getTargetAnchor(0).getLocation(null);
					translateToRelative(end[size]);
				} else
					end[size] = targetFigure == null ? start[size] : targetFigure.getBounds().getLeft();
				size++;
			}
		}

		DrawUtils.drawRightEdges(g, start, end, size);
	}
}
