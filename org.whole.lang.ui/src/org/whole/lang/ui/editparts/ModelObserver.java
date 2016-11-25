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

import java.beans.PropertyChangeEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.gef.LightweightEditDomain;
import org.whole.lang.events.IPropertyChangeObserver;
import org.whole.lang.model.ICompoundModel;
import org.whole.lang.model.IEntity;
import org.whole.lang.ui.viewers.IEntityPartViewer;
import org.whole.lang.util.EntityUtils;


/**
 * @author Riccardo Solmi, Enrico Persiani
 */
public class ModelObserver implements IPropertyChangeObserver {
	private ICompoundModel model;
	private IEntityPartViewer viewer;
	private boolean needsRebuildNotation;

	public ModelObserver(ICompoundModel model, IEntityPartViewer viewer) {
		this.model = model;
		this.viewer = viewer;
		model.addEventListener(this);
		viewer.getEditDomain().addPropertyChangeListener(this);
	}

	public void dispose() {
		model.removeEventListener(this);
	}

	public ICompoundModel getModel() {
		return model;
	}

	public boolean isObserving(IEntity entity) {
		return viewer.getEditPartRegistry().containsKey(entity);
	}

	public void propertyChange(PropertyChangeEvent event) {
		if (event.getSource() == this.viewer.getEditDomain()) {
			if (LightweightEditDomain.PROPERTY_DISABLED.equals(event.getPropertyName()) &&
					Boolean.FALSE.equals(event.getNewValue())) {
				if (this.needsRebuildNotation)
					this.viewer.getControl().getDisplay().asyncExec( () -> viewer.rebuildNotation());
				this.needsRebuildNotation = false;
			}
		} else { // event.getSource() == this.model
			if (this.viewer.getEditDomain().isDisabled()) {
				this.needsRebuildNotation = true;
				return;
			}

			//FIXME ? workaround
			if (!(event.getSource() instanceof IEntity))
				return;

	    	IEntity entity = (IEntity) event.getSource();
	    	IEntityPart entityPart = getObserver(entity, viewer.getEditPartRegistry());
	    	if (entityPart != null) {
	    		fireBeforeUpdateEvent(entityPart);
	    		entityPart.propertyChange(event);
	    		fireAfterUpdateEvent(entityPart);
	    	}
		}
	}

	public static IEntityPart getShowingObserver(IEntity entity, Map<IEntity, IEntityPart> mapping) {
		IEntityPart observer = mapping.get(entity);

		IEntity parentEntity = entity.wGetParent();
    	while ((observer == null || !(((IGraphicalEntityPart) observer).getFigure()).isShowing()) && !EntityUtils.isNull(parentEntity)) {
    		observer = mapping.get(parentEntity.wGet(entity));
    		entity = parentEntity;
    		parentEntity = entity.wGetParent();	
    	}
		return observer;
	}
	public static IEntityPart getObserver(IEntity entity, Map<IEntity, IEntityPart> mapping) {
		IEntityPart observer = mapping.get(entity);

    	IEntity parentEntity = entity.wGetParent();
    	while (observer == null && !EntityUtils.isNull(parentEntity)) {
    		observer = mapping.get(parentEntity.wGet(entity));
    		entity = parentEntity;
    		parentEntity = entity.wGetParent();	
    	}
		return observer;
	}
	public static IEntityPart getObserver(IEntity entity, IEntity ancestorEntity, Map<IEntity, IEntityPart> mapping) {
		IEntityPart observer;
	   	if (entity == ancestorEntity)
	   		observer = getObserver(entity, mapping);
	   	else {
	   	   	observer = getObserver(entity.wGetParent(), ancestorEntity, mapping);
		   	if (observer == null)
		   		observer = mapping.get(entity);
	   	}
	   	return observer;
	}

	private List<EntityPartListener> listenerList = new ArrayList<EntityPartListener>();
	public void addEntityPartListener(EntityPartListener listener) {
		listenerList.add(listener);
	}
	public void removeEntityPartListener(EntityPartListener listener) {
		listenerList.remove(listener);
	}
	private EntityPartEvent entityPartEvent;
	protected EntityPartEvent getEntityPartEvent(IEntityPart entityPart) {
		if (entityPartEvent == null)
			entityPartEvent = new EntityPartEvent(this, entityPart);
		else
			entityPartEvent.setEditPart(entityPart);
		return entityPartEvent;
	}
	protected void fireBeforeUpdateEvent(IEntityPart entityPart) {
		List<EntityPartListener> tmp = new ArrayList<EntityPartListener>(listenerList);
		for (EntityPartListener listener : tmp)
			listener.beforeUpdate(getEntityPartEvent(entityPart));
	}
	protected void fireAfterUpdateEvent(IEntityPart entityPart) {
		List<EntityPartListener> tmp = new ArrayList<EntityPartListener>(listenerList);
		for (EntityPartListener listener : tmp)
			listener.afterUpdate(getEntityPartEvent(entityPart));
	}
}
