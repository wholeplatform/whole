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
import java.util.Collection;
import java.util.List;

import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.AccessibleAnchorProvider;
import org.eclipse.gef.AccessibleEditPart;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.requests.DropRequest;
import org.eclipse.swt.accessibility.AccessibleEvent;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.ui.figures.INodeFigure;
import org.whole.lang.util.EntityUtils;

/**
 * @author Riccardo Solmi
 */
public abstract class AbstractNodePart extends AbstractContentPanePart implements INodeEntityPart {
	protected FeatureDescriptor[] sourceFeatures;
	protected FeatureDescriptor[] targetFeatures;

	public AbstractNodePart() {
		sourceFeatures = initSourceFeatures();
		targetFeatures = initTargetFeatures();
	}
	// returns the model features to be presented as source connections
	protected FeatureDescriptor[] initSourceFeatures() {
		return new FeatureDescriptor[0];
	}
	// returns the model features to be presented as target connections
	protected FeatureDescriptor[] initTargetFeatures() {
		return new FeatureDescriptor[0];
	}
	
	public INodeFigure getNodeFigure() {
		return (INodeFigure) getFigure();
	}

	protected List<IEntity> getModelSourceConnections() {
		return getModelConnections(sourceFeatures);
	}
	protected List<IEntity> getModelTargetConnections() {
		return getModelConnections(targetFeatures);
	}
	@SuppressWarnings({ "unchecked" })
	protected List<IEntity> getModelConnections(FeatureDescriptor[] features) {
		IEntity e = getModelEntity(); 
		List<IEntity> result = new ArrayList<IEntity>(features.length);
		for (int i=0; i<features.length; i++) {
			IEntity c = e.wGet(features[i]);
			if (EntityUtils.isResolver(c))
				continue;
			switch (c.wGetEntityKind()) {
			case COMPOSITE:
				result.addAll((Collection<? extends IEntity>) c);
				break;
			case SIMPLE:
				result.add(c);
				break;
			case DATA:
				throw new IllegalStateException("unsupported entity kind");
			}
		}
		return result;
	}

	public ConnectionAnchor getSourceConnectionAnchor(ConnectionEditPart connection) {
		IEntity e = getModelEntity(); 
		IEntity c = (IEntity) connection.getModel();
		for (int i=0; i<sourceFeatures.length; i++) {
			IEntity ec = e.wGet(sourceFeatures[i]);
			switch (ec.wGetEntityKind()) {
			case COMPOSITE:
				if (ec.wContains(c))
					return getNodeFigure().getSourceAnchor(i);
				break;
			case SIMPLE:
				if (ec == c)
					return getNodeFigure().getSourceAnchor(i);
				break;
			case DATA:
				throw new IllegalStateException("unsupported entity kind");
			}
		}
		return null;
	}
	public ConnectionAnchor getTargetConnectionAnchor(ConnectionEditPart connection) {
		IEntity e = getModelEntity(); 
		IEntity c = (IEntity) connection.getModel();
		for (int i=0; i<targetFeatures.length; i++) {
			IEntity ec = e.wGet(targetFeatures[i]);
			switch (ec.wGetEntityKind()) {
			case COMPOSITE:
				if (ec.wContains(c))
					return getNodeFigure().getTargetAnchor(i);
				break;
			case SIMPLE:
				if (ec == c)
					return getNodeFigure().getTargetAnchor(i);
				break;
			case DATA:
				throw new IllegalStateException("unsupported entity kind");
			}
		}
		return null;
	}
	public ConnectionAnchor getSourceConnectionAnchor(Request request) {
		return getNodeFigure().getSourceAnchorAt(
				new Point(((DropRequest) request).getLocation()));
	}
	public ConnectionAnchor getTargetConnectionAnchor(Request request) {
		return getNodeFigure().getTargetAnchorAt(
				new Point(((DropRequest) request).getLocation()));
	}
	public FeatureDescriptor getSourceConnectionFeature(Request request) {
		int index = getNodeFigure().getSourceAnchorIndexAt(
				new Point(((DropRequest) request).getLocation()));
		if (index == -1)
			return null;
		return sourceFeatures[index];
	}
	public FeatureDescriptor getTargetConnectionFeature(Request request) {
		int index = getNodeFigure().getTargetAnchorIndexAt(
				new Point(((DropRequest) request).getLocation()));
		if (index == -1)
			return null;
		return targetFeatures[index];
	}

	
	@SuppressWarnings("rawtypes")
	public Object getAdapter(Class key) {
		if (key == AccessibleAnchorProvider.class)
			return new DefaultAccessibleAnchorProvider() {
				public List<Point> getSourceAnchorLocations() {
					INodeFigure nodeFigure = getNodeFigure();
					return nodeFigure.getSourceAnchorLocations(nodeFigure.getBounds().getLeft());
				}

				public List<Point> getTargetAnchorLocations() {
					INodeFigure nodeFigure = getNodeFigure();
					return nodeFigure.getTargetAnchorLocations(nodeFigure.getBounds().getLeft());
				}
			};
		return super.getAdapter(key);
	}

	private AccessibleEditPart acc;

	protected AccessibleEditPart getAccessibleEditPart() {
		if (acc == null)
			acc = createAccessible();
		return acc;
	}
	protected AccessibleEditPart createAccessible() {
		return new AccessibleGraphicalEditPart() {
			public void getName(AccessibleEvent e) {
				e.result = getModel().toString();
			}
		};
	}
}
