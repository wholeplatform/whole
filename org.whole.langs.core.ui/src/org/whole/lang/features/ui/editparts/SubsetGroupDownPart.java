/**
 * Copyright 2004-2015 Riccardo Solmi. All rights reserved.
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
package org.whole.lang.features.ui.editparts;

import java.beans.PropertyChangeEvent;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.gef.EditPart;
import org.whole.lang.events.IChangeEventHandler;
import org.whole.lang.events.IdentityDefaultChangeEventHandler;
import org.whole.lang.features.ui.figures.FeatureGroupFigure;
import org.whole.lang.features.ui.layouts.SubsetGroupTreeDownLayout;
import org.whole.lang.frames.model.Cardinality;
import org.whole.lang.frames.model.IntValue;
import org.whole.lang.frames.model.SubsetGroup;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.ui.editparts.AbstractContentPanePart;
import org.whole.lang.util.DataTypeUtils;
import org.whole.lang.util.EntityUtils;

/**
 * @author Riccardo Solmi
 */
public class SubsetGroupDownPart extends AbstractContentPanePart {
	protected IFigure createFigure() {
		return new FeatureGroupFigure(new SubsetGroupTreeDownLayout(), new Insets(16,0,0,0));
	}
	@Override
	public FeatureGroupFigure getFigure() {
		return (FeatureGroupFigure) super.getFigure();
	}

	protected List<IEntity> getModelSpecificChildren() {
		SubsetGroup entity = getModelEntity();
		List<IEntity> list = new ArrayList<IEntity>(2);
		list.add(entity.getCardinality());
		list.add(entity.getFeatures());
		return list;
	}

	@Override
	protected void propertyChangeUI(PropertyChangeEvent evt) {
		if (evt.getPropertyName().equals("cardinality"))
			refreshVisuals();
		super.propertyChangeUI(evt);
	}

	protected IChangeEventHandler childObserver;
	
//	private EditPartListener childListener;
	@Override
	protected void addChildVisual(EditPart childEditPart, int index) {
		super.addChildVisual(childEditPart, index);

		if (childObserver == null) {
			//TODO implement all methods
			childObserver = new IdentityDefaultChangeEventHandler() {
				private static final long serialVersionUID = 1L;
			    public void notifyChanged(IEntity source, FeatureDescriptor featureDesc, Object oldValue, Object newValue) {
					getViewer().getControl().getDisplay().asyncExec(new Runnable() {
						public void run() {
					    	refreshVisuals();
						}
					});
			    }
			};
		}
		((IEntity) childEditPart.getModel()).wAddChangeEventHandler(childObserver);
		
//		childEditPart.addEditPartListener(childListener = new EditPartListener.Stub() {
//			public void childAdded(EditPart child, int index) {
//				refreshVisuals();
//			}
//		});
	}
	@Override
	protected void removeChildVisual(EditPart childEditPart) {
		((IEntity) childEditPart.getModel()).wRemoveChangeEventHandler(childObserver);

//		childEditPart.removeEditPartListener(childListener);
		super.removeChildVisual(childEditPart);
	}

	@Override
	protected void refreshVisuals() {
		SubsetGroup entity = getModelEntity();
		Cardinality c = entity.getCardinality();
		boolean useDefaultLayout = true;
		if (!EntityUtils.isResolver(c)) {
			IntValue min = c.getMin();
			IntValue max = c.getMax();
			useDefaultLayout = DataTypeUtils.getDataKind(min).isInt() && min.wIntValue() == 1 &&
					DataTypeUtils.getDataKind(max).isInt() && max.wIntValue() == 1;
		}
		getFigure().showDefaultLayout(useDefaultLayout);
	}
}
