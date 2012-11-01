/**
 * Copyright 2004-2012 Riccardo Solmi. All rights reserved.
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
package org.whole.lang.events;

import java.util.HashMap;
import java.util.Map;

import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.FeatureDescriptor;

/**
 * @author Riccardo Solmi
 */
public abstract class MappingChangeEventHandler extends DelegatingChangeEventHandler {
	private static final long serialVersionUID = 1L;
    private Map<Object, IChangeEventHandler> eventHandlerMap = new HashMap<Object, IChangeEventHandler>();

    protected final IChangeEventHandler getEventHandler(IEntity source, FeatureDescriptor featureDesc) {
        IChangeEventHandler eventHandler = eventHandlerMap.get(getKey(source, featureDesc));
        if (eventHandler == null)
            eventHandler = IdentityChangeEventHandler.instance;
        return eventHandler;
    }

    protected abstract Object getKey(IEntity source, FeatureDescriptor featureDesc);

    public void put(Object key, IChangeEventHandler eventHandler) {
        eventHandlerMap.put(key, eventHandler);
    }

    public static class EntityInstance extends MappingChangeEventHandler {
    	private static final long serialVersionUID = 1L;
        protected final Object getKey(IEntity source, FeatureDescriptor featureDesc) {
            return source;
        }
    };
    public static class EntityClass extends MappingChangeEventHandler {
    	private static final long serialVersionUID = 1L;
        protected final Object getKey(IEntity source, FeatureDescriptor featureDesc) {
            return source.getClass();
        }
    };
    public static final MappingChangeEventHandler newEntityTypesEventHandler() {
        return new MappingChangeEventHandler() {
        	private static final long serialVersionUID = 1L;
	        protected final Object getKey(IEntity source, FeatureDescriptor featureDesc) {
	            return source.getClass().getInterfaces()[0];
	        }
	    };
    };
    public static final MappingChangeEventHandler newFeatureNameEventHandler() {
        return new MappingChangeEventHandler() {
        	private static final long serialVersionUID = 1L;
	        protected final Object getKey(IEntity source, FeatureDescriptor featureDesc) {
	            return featureDesc.getName();
	        }
	    };
    };

}
