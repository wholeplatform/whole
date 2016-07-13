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
package org.whole.lang.ui.notations.styledtree.editparts;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.whole.lang.ui.editparts.AbstractCompositePart;
import org.whole.lang.ui.figures.CompositeFigure;
import org.whole.lang.ui.figures.CompositePlaceHolderBorder;
import org.whole.lang.ui.figures.EntityFigure;
import org.whole.lang.ui.figures.IEntityFigure;
import org.whole.lang.ui.figures.LabelFactory;
import org.whole.lang.ui.figures.TableFigure;
import org.whole.lang.ui.figures.TableRowFigure;
import org.whole.lang.ui.layout.Alignment;
import org.whole.lang.ui.layout.MonoLayout;
import org.whole.lang.ui.layout.TableLayout;
import org.whole.lang.ui.layout.ViewportTracking;
import org.whole.lang.ui.notations.styledtree.figures.CompositeTableFigure;
import org.whole.lang.ui.notations.styledtree.figures.NodeWithCompositeBranchFigure;
import org.whole.lang.ui.notations.styledtree.styling.IEntityStyling;
import org.whole.lang.ui.notations.styledtree.styling.IFeatureStyling;
import org.whole.lang.ui.notations.styledtree.styling.IStyledPart;
import org.whole.lang.ui.notations.styledtree.styling.IStylingFactory;
import org.whole.lang.ui.notations.styledtree.styling.EntityStyling.LayoutStyle;

/**
 * @author Riccardo Solmi
 */
public class CompositeEntityStyledTreePart extends AbstractCompositePart implements IStyledPart {
	protected IStylingFactory stylingFactory;
	protected IEntityStyling entityStyling;

	public CompositeEntityStyledTreePart(IStylingFactory stylingFactory, IEntityStyling entityStyling) {
		this.stylingFactory = stylingFactory;
		this.entityStyling = entityStyling;
		setFlag(FLAG_REVERSED, false);
	}

	public IEntityStyling getEntityStyling() {
		return entityStyling;
	}

	public boolean isReversable() {
		return false;
	}

	protected IFigure createFigure() {
		if (entityStyling.getLayoutStyle().equals(LayoutStyle.COMPOSITE_TABLE)) {
			return new CompositeTableFigure(entityStyling) {
				protected int getChildrenPaneIndex() {
					return 0;
				}
				protected IEntityFigure createTypeLabelFigure() {
					IEntityFigure typeFigure = new EntityFigure(new MonoLayout().withMargin(2, 4, 2, 8).withAutoresizeWeight(1.0f))
							.withViewportTracking(ViewportTracking.HORIZONTAL);
					typeFigure.add(LabelFactory.createDeclaration(entityStyling.getTypeLabel()));
					return typeFigure;
				}
				protected IEntityFigure createChildrenFigure() {
					TableFigure tableFigure = new TableFigure(Math.max(1, featuresStyling.length)) {
						protected void paintFigure(Graphics g) {
							super.paintFigure(g);

							
							g.setBackgroundColor(ColorConstants.lightGray);
							g.setForegroundColor(ColorConstants.lightGray);

							if (getLayoutManager().hasHeaderRow()) {
								drawHeadersRowBackground(g);
								drawHeadersRowSeparator(g);								
							}
							drawColumnSeparators(g);
							
							int oldAlpha = g.getAlpha();
							g.setAlpha(80);
							drawRowSeparators(g);
							drawTableColumnsBorder(g);
							drawTableRowsBorder(g);
							g.setAlpha(oldAlpha);
						}
					};

					if (featuresStyling.length > 0) {
						TableRowFigure tableHeaderFigure = new TableRowFigure();
						TableLayout tableLayout = tableFigure.getLayoutManager();		
						int i=0;
						for (IFeatureStyling fs : featuresStyling) {
							tableHeaderFigure.addLabel(fs.getName());
							tableLayout.withColumnAlignment(i++, fs.getAlignment());
						}
						tableFigure.add(tableHeaderFigure, TableLayout.Placement.HEADER);
					}
					return createContentPane(getChildrenPaneIndex(), tableFigure);
				}				
			};
		} else
			return new NodeWithCompositeBranchFigure(entityStyling) {
				@Override
				protected int getChildrenPaneIndex() {
					return 0;
				}
				@Override
				protected IEntityFigure createTypeLabelFigure() {
					String name = entityStyling.getTypeLabel();
					return LabelFactory.createDeclaration(name);
				}
				@Override
				protected IEntityFigure createChildrenFigure() {
					CompositeFigure compositeFigure = new CompositeFigure(false);
					compositeFigure.setBorder(CompositePlaceHolderBorder.OPTIONAL_VERTICAL);
					compositeFigure.getLayoutManager().withSpacing(4)
						.withMarginLeft(0).withMarginRight(10)
							.withMinorAlignment(Alignment.LEADING);
					return createContentPane(getChildrenPaneIndex(), compositeFigure);
				}
			};
	}
}
