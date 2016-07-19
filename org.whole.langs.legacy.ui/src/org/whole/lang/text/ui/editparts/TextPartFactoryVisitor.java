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
package org.whole.lang.text.ui.editparts;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.swt.SWT;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.IEntity;
import org.whole.lang.model.adapters.IEntityAdapter;
import org.whole.lang.text.model.Document;
import org.whole.lang.text.model.ITextEntity;
import org.whole.lang.text.model.Indent;
import org.whole.lang.text.model.Row;
import org.whole.lang.text.model.RowSeparator;
import org.whole.lang.text.model.Text;
import org.whole.lang.text.model.TextSeparator;
import org.whole.lang.text.reflect.TextEntityDescriptorEnum;
import org.whole.lang.text.visitors.TextIdentityDefaultVisitor;
import org.whole.lang.ui.editparts.AbstractCompositePart;
import org.whole.lang.ui.editparts.CompositeColumnWithPlaceholderPart;
import org.whole.lang.ui.editparts.CompositeRowWithPlaceholderPart;
import org.whole.lang.ui.editparts.ContentTextualEntityPart;
import org.whole.lang.ui.editparts.IEditPartFactory;
import org.whole.lang.ui.editparts.PlaceHolderPart;
import org.whole.lang.ui.figures.CompositeFigure;
import org.whole.lang.ui.notations.text.editparts.DefaultTextualPartFactory;
import org.whole.lang.util.EntityUtils;

/** 
 * @author Riccardo Solmi
 */
public class TextPartFactoryVisitor extends TextIdentityDefaultVisitor implements
		IEditPartFactory {
	protected EditPart part, context;

	public EditPart createEditPart(EditPart context, Object modelEntity) {
		this.context = context;
		((ITextEntity) modelEntity).accept(this);
		return part;
	}

	public boolean visitAdapter(IEntityAdapter entity) {
		part = new PlaceHolderPart();
		return super.visitAdapter(entity);
	}

	public void visit(ITextEntity entity) {
		part = DefaultTextualPartFactory.instance().createEditPart(context, entity);
	}

	public void visit(Text entity) {
		part = new ContentTextualEntityPart();
	}

	public void visit(Document entity) {
		if (EntityUtils.hasParent(entity)) {
			IEntity parent = entity.wGetParent();
			if (Matcher.match(TextEntityDescriptorEnum.Document, parent)) {
					part = new AbstractCompositePart() {
					    protected IFigure createFigure() {
					    	CompositeFigure f = new CompositeFigure(false) {
					        	protected void paintFigure(Graphics g) {
					        		super.paintFigure(g);

					        		Rectangle b = getBounds();
					        		
					        		g.setForegroundColor(ColorConstants.lightGray);
					        		g.setLineStyle(SWT.LINE_CUSTOM);

					        		g.setLineDash(new int[] {1,1});
					        		g.drawLine(b.x, b.y, b.x, b.bottom()-1);
					        		g.drawLine(b.right()-1, b.y, b.right()-1, b.bottom()-1);

					        		g.setLineDash(new int[] {1,3});
					        		g.drawLine(b.x, b.y, b.right()-1, b.y);
					        		g.drawLine(b.x, b.bottom()-1, b.right()-1, b.bottom()-1);

					        		g.setLineStyle(SWT.LINE_SOLID);
					        		g.setLineDash((int[]) null);
					        	}
					        };
					        f.getLayoutManager().withMargin(2);
					        return f;
					    }
					};
					return;
			}
		}
		part = new CompositeColumnWithPlaceholderPart();
	}

	public void visit(Indent entity) {
		part = new IndentPart();
	}

	public void visit(Row entity) {
		if (EntityUtils.hasParent(entity)) {
			IEntity parent = entity.wGetParent();
			if (Matcher.match(TextEntityDescriptorEnum.Row, parent)) {
					part = new AbstractCompositePart() {
					    protected IFigure createFigure() {
//					    	CompositeFigure f = new CompositeFigure(new FlowLayout().withMinorSpacing(7).withSpacing(5)) {
					    	CompositeFigure f = new CompositeFigure(true) {
					        	protected void paintFigure(Graphics g) {
					        		super.paintFigure(g);

					        		Rectangle b = getBounds();
					        		
					        		g.setForegroundColor(ColorConstants.lightGray);
					        		g.setLineStyle(SWT.LINE_CUSTOM);

					        		g.setLineDash(new int[] {1,1});
					        		g.drawLine(b.x, b.y, b.right()-1, b.y);
					        		g.drawLine(b.x, b.bottom()-1, b.right()-1, b.bottom()-1);

					        		g.setLineDash(new int[] {1,3});
					        		g.drawLine(b.x, b.y, b.x, b.bottom()-1);
					        		g.drawLine(b.right()-1, b.y, b.right()-1, b.bottom()-1);

					        		g.setLineStyle(SWT.LINE_SOLID);
					        		g.setLineDash((int[]) null);
					        	}
					        };
					        f.getLayoutManager().withMargin(2);
					        return f;
					    }
					};
					return;
			}
		}
//		part = new AbstractCompositePart() {
//		    protected IFigure createFigure() {
//		    	return new CompositeFigure(new FlowLayout().withMinorSpacing(7).withSpacing(5));
//		    }
//		};
		part = new CompositeRowWithPlaceholderPart();
	}

	public void visit(RowSeparator entity) {
		part = new SeparatorPart();
	}

	public void visit(TextSeparator entity) {
		part = new SeparatorPart();
	}
}