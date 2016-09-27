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
package org.whole.lang.ui.editparts;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.ConnectionLayer;
import org.eclipse.draw2d.ConnectionRouter;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.ShortestPathConnectionRouter;
import org.eclipse.draw2d.XYLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.gef.CompoundSnapToHelper;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.LayerConstants;
import org.eclipse.gef.SnapToGeometry;
import org.eclipse.gef.SnapToGrid;
import org.eclipse.gef.SnapToGuides;
import org.eclipse.gef.SnapToHelper;
import org.eclipse.gef.editpolicies.SnapFeedbackPolicy;
import org.eclipse.gef.rulers.RulerProvider;
import org.whole.lang.model.IEntity;
import org.whole.lang.ui.editpolicies.WholeComponentEditPolicy;
import org.whole.lang.ui.editpolicies.WholeContainerEditPolicy;
import org.whole.lang.ui.editpolicies.WholeFreeformLayoutEditPolicy;
import org.whole.lang.ui.figures.EntityFigure;
import org.whole.lang.ui.figures.IEntityFigure;
import org.whole.lang.ui.layout.EntityXYLayout;
import org.whole.lang.ui.requests.DnDOverCompositeRequest;
import org.whole.lang.ui.requests.PartRequest;

/**
 * @author Riccardo Solmi
 */
public abstract class AbstractConnectedFreeformRootPart extends AbstractPart {
	IFigure pane;
	protected IFigure createFigure() {
//		Figure figure = new FreeformLayer();
		IEntityFigure figure = new EntityFigure() {
			{
				setLayoutManager(new EntityXYLayout());
				setOpaque(false);
			}
			
			//FIXME workaround
			public int getIndent() {
				return getInsets().left;
			}
			public int getAscent() {
				return getPreferredSize().height/2;
			}

			public static final int MINIMUM_SIZE = 50;
			public Dimension getPreferredSize(int wHint, int hHint) {
				Dimension size = super.getPreferredSize(wHint, hHint);
				size.width = Math.max(size.width, MINIMUM_SIZE);
				size.height = Math.max(size.height, MINIMUM_SIZE);
				return size;
			}
		};
//		figure.setLayoutManager(new EntityXYLayout());
//		figure.setOpaque(false);

		setConnectionRouter(createConnectionRouter(figure));

		return figure;
	}
	// override to change the connection router strategy
	protected ConnectionRouter createConnectionRouter(IFigure figure) {
		return new ShortestPathConnectionRouter(figure);
	}
	public void setConnectionRouter(ConnectionRouter router) {
		ConnectionLayer connLayer = (ConnectionLayer) getLayer(LayerConstants.CONNECTION_LAYER);
		connLayer.setConnectionRouter(router);
	}

//	public IFigure getContentPane() {
//		return pane;
//	}

	protected void createEditPolicies() {
		installEditPolicy(EditPolicy.CONTAINER_ROLE, new WholeContainerEditPolicy(getCommandFactory()));
    	installEditPolicy(EditPolicy.COMPONENT_ROLE, new WholeComponentEditPolicy(getCommandFactory()));
		installEditPolicy(EditPolicy.LAYOUT_ROLE, new WholeFreeformLayoutEditPolicy((XYLayout) getContentPane().getLayoutManager(), getCommandFactory()) {
			protected DnDOverCompositeRequest createDnDOverCompositeRequest(IEntity entity) {
				return new DnDOverCompositeRequest(PartRequest.MOVE_ADD_CHILD, (IEntityPart) getHost(), entity, null) {
					@Override
					public IEntity getModelEntity() {
						IEntity modelEntity = super.getModelEntity().wGet(0); //FIXME workaround to get nodes composite
						return modelEntity;
					}
				};
			}
		});
    	installEditPolicy("Snap Feedback", new SnapFeedbackPolicy());
    }

	@SuppressWarnings("rawtypes")
	public Object getAdapter(Class key) {
		if (key == SnapToHelper.class) {
			EditPartViewer viewer = getViewer();
			List<SnapToHelper> snapStrategies = new ArrayList<SnapToHelper>();
			
			Boolean val = (Boolean) viewer.getProperty(RulerProvider.PROPERTY_RULER_VISIBILITY);
			if (val != null && val.booleanValue())
				snapStrategies.add(new SnapToGuides(this));
			
			val = (Boolean) viewer.getProperty(SnapToGeometry.PROPERTY_SNAP_ENABLED);
			if (val != null && val.booleanValue())
				snapStrategies.add(new SnapToGeometry(this));
			
			val = (Boolean) viewer.getProperty(SnapToGrid.PROPERTY_GRID_ENABLED);
			if (val != null && val.booleanValue())
				snapStrategies.add(new SnapToGrid(this));
			
			if (snapStrategies.size() == 0)
				return null;
			if (snapStrategies.size() == 1)
				return snapStrategies.get(0);

			SnapToHelper ss[] = new SnapToHelper[snapStrategies.size()];
			for (int i = 0; i < snapStrategies.size(); i++)
				ss[i] = snapStrategies.get(i);
			return new CompoundSnapToHelper(ss);
		}
		return super.getAdapter(key);
	}


	public IEntity getParentModelEntity() {
		return super.getParentPartModelEntity();
	}
}
