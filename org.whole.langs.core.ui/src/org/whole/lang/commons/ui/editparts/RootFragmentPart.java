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
package org.whole.lang.commons.ui.editparts;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.FigureUtilities;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LayoutAnimator;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.DragTracker;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.LayerConstants;
import org.eclipse.gef.Request;
import org.eclipse.gef.RootEditPart;
import org.eclipse.gef.editpolicies.RootComponentEditPolicy;
import org.eclipse.gef.requests.SelectionRequest;
import org.eclipse.gef.tools.DeselectAllTracker;
import org.eclipse.gef.tools.MarqueeDragTracker;
import org.eclipse.swt.SWT;
import org.whole.lang.commons.model.RootFragment;
import org.whole.lang.model.IEntity;
import org.whole.lang.ui.figures.EntityFigure;
import org.whole.lang.ui.figures.FigureConstants;
import org.whole.lang.ui.figures.IEntityFigure;
import org.whole.lang.ui.layout.Alignment;
import org.whole.lang.ui.layout.StackLayout;


/*
 * Main EditPart responsible for the background figure of the view
 *  
 * @author Riccardo Solmi
 */
public class RootFragmentPart extends AbstractFragmentPart implements LayerConstants {
	public RootFragmentPart() {
		setDraggable(false);
	}

	protected void createEditPolicies(){
		super.createEditPolicies();
		installEditPolicy(EditPolicy.COMPONENT_ROLE, new RootComponentEditPolicy());
//    	installEditPolicy(EditPolicy.LAYOUT_ROLE, null);
		installEditPolicy(EditPolicy.SELECTION_FEEDBACK_ROLE, null);
		installEditPolicy(EditPolicy.NODE_ROLE, null);
		installEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE, null);
	}
	
	public DragTracker getDragTracker(Request req){
		if (req instanceof SelectionRequest && ((SelectionRequest)req).getLastButtonPressed() == 3)
			return new DeselectAllTracker(this);
		return new MarqueeDragTracker();
	}

	protected IFigure createFigure() {
//		Figure f = new FreeformLayer() {
		IEntityFigure f = new EntityFigure() {
			{
				setOpaque(false);
			}

			@Override
			public void paint(Graphics graphics) {
				graphics.setAdvanced(true);
				graphics.setAntialias(SWT.ON);

				super.paint(graphics);
			}

			protected void paintFigure(Graphics graphics) {
				super.paintFigure(graphics);

				Rectangle r2 = ((IFigure) getChildren().get(0)).getBounds();
				translateToParent(r2 = r2.getCopy());
				Rectangle clipArea = graphics.getClip(new Rectangle()).expand(1,1);

				graphics.fillRectangle(clipArea);
				graphics.setBackgroundColor(FigureConstants.hostLanguageColor);
				graphics.fillRectangle(clipArea.intersect(r2));

				graphics.setLineWidth(1);
				graphics.setLineStyle(Graphics.LINE_SOLID);
				graphics.setXORMode(false);

				IEntity rootEntity = ((RootFragment) getModelEntity()).getRootEntity().wGetAdaptee(false);
				if (rootEntity.wGetParent() instanceof RootFragment) {	
					clipArea = graphics.getClip(new Rectangle()).expand(1,1);
					int oldAlpha = graphics.getAlpha();
					graphics.setAlpha(60);
					graphics.setForegroundColor(ColorConstants.darkGray);
					graphics.setLineWidth(1);
					graphics.drawRectangle(r2.getTranslated(-1, -1).resize(1, 1));
					graphics.setForegroundColor(ColorConstants.lightGray);
					graphics.setLineWidth(5);
					graphics.drawRoundRectangle(r2.getTranslated(-4, -4).resize(7, 7), 10, 10);
					graphics.setAlpha(oldAlpha);
				} else {
					graphics.setForegroundColor(ColorConstants.lightGray);
					graphics.drawRectangle(r2.x-1, r2.y-1, r2.width+1, r2.height+1);
				}
			}

			public void validate() {
				super.validate();
				repaint();
			}
		};
		
		f.setLayoutManager(new StackLayout().withMargin(5).withMinorAlignment(Alignment.CENTER));
		f.setBackgroundColor(FigureUtilities.lighter(ColorConstants.gray));
		f.setOpaque(false);
		f.addLayoutListener(LayoutAnimator.getDefault());
		return f;
	}

	protected List<IEntity> getModelSpecificChildren() {
		List<IEntity> children = new ArrayList<IEntity>(1);
		children.add(getFragment().wGetRoot());
	    return children;
	}

	public RootEditPart getRoot() {
		// workaround for AbstractGraphicalViewer that 
		// doesn't attach this part to the RootEditPart
		if (getParent() == null)
			return null;
		return super.getRoot();
	}

	@Override
	public void rebuild() {
    	rebuildChild((EditPart) getChildren().get(0));
	}
}
