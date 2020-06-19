/**
 * Copyright 2004-2019 Riccardo Solmi. All rights reserved.
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

import java.util.Date;

import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.commons.factories.CommonsEntityFactory;
import org.whole.lang.factories.GenericEntityFactory;
import org.whole.lang.model.EnumValue;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.EntityDescriptorEnum;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.util.EntityUtils;

/**
 * @author Riccardo Solmi
 */
public class EventSourceManager extends IdentityChangeEventHandler implements IEventSourceManager {
	private static final long serialVersionUID = 1L;

	protected IEntity eventSource = createPatchEvent();
	
	public IEntity getEventSource() {
		return EntityUtils.clone(eventSource);
	} 

	public void addEvent(IEntity event) {
		eventSource.wGet(2).wAdd(event);
	}

	private static EntityDescriptorEnum eventsEdEnum;
	protected static EntityDescriptorEnum getEventsEdEnum() {
		if (eventsEdEnum == null)
			eventsEdEnum = ReflectionFactory.getLanguageKit("whole:org.whole.lang.events:EventsModel", false, null).getEntityDescriptorEnum();
		return eventsEdEnum;
	}

	public static IEntity createExecutionTime() {
		return BindingManagerFactory.instance.createValue(System.currentTimeMillis());
	}

	public static IEntity createEntityPath(IEntity entity) {
		return createEntityPath(EntityUtils.getLocation(entity, true));
	}
	public static IEntity createEntityPath(String location) {
		return GenericEntityFactory.instance.create(getEventsEdEnum().valueOf("EntityPath"), location);
	}

	public static IEntity createPatchEvent() {
		return GenericEntityFactory.instance.create(getEventsEdEnum().valueOf("Patch"),
				CommonsEntityFactory.instance.createResolver(), CommonsEntityFactory.instance.createResolver(),
				GenericEntityFactory.instance.create(getEventsEdEnum().valueOf("ModelEvents")));
	}
	public static IEntity createDeleteEvent(IEntity source, int index) {
		return GenericEntityFactory.instance.create(getEventsEdEnum().valueOf("Delete"),
				CommonsEntityFactory.instance.createResolver(), CommonsEntityFactory.instance.createResolver(),
				createEntityPath(EntityUtils.getLocation(source, true)+"/"+index));
	}
	public static IEntity createInsertEvent(IEntity newValue) {
		return GenericEntityFactory.instance.create(getEventsEdEnum().valueOf("Insert"),
				CommonsEntityFactory.instance.createResolver(), CommonsEntityFactory.instance.createResolver(),
				createEntityPath(newValue), EntityUtils.clone(newValue));
	}
	public static IEntity createReplaceEvent(IEntity newValue) {
		return GenericEntityFactory.instance.create(getEventsEdEnum().valueOf("Replace"),
				CommonsEntityFactory.instance.createResolver(), CommonsEntityFactory.instance.createResolver(),
				createEntityPath(newValue), EntityUtils.clone(newValue));
	}

	public void notifyAdded(IEntity source, FeatureDescriptor fd, int index, IEntity newValue) {
		addEvent(createInsertEvent(newValue));
    }
    public void notifyRemoved(IEntity source, FeatureDescriptor fd, int index, IEntity oldValue) {
		addEvent(createDeleteEvent(source, index));
    }
    public void notifyChanged(IEntity source, FeatureDescriptor fd, int index, IEntity oldValue, IEntity newValue) {
    	addEvent(createReplaceEvent(source));
    }
    public void notifyChanged(IEntity source, FeatureDescriptor fd, IEntity oldValue, IEntity newValue) {
    	addEvent(createReplaceEvent(source));
    }

    public void notifyChanged(IEntity source, FeatureDescriptor fd, boolean oldValue, boolean newValue) {
		addEvent(createReplaceEvent(source));
    }
    public void notifyChanged(IEntity source, FeatureDescriptor fd, byte oldValue, byte newValue) {
    	addEvent(createReplaceEvent(source));
    }
    public void notifyChanged(IEntity source, FeatureDescriptor fd, char oldValue, char newValue) {
    	addEvent(createReplaceEvent(source));
    }
    public void notifyChanged(IEntity source, FeatureDescriptor fd, double oldValue, double newValue) {
    	addEvent(createReplaceEvent(source));
    }
    public void notifyChanged(IEntity source, FeatureDescriptor fd, float oldValue, float newValue) {
    	addEvent(createReplaceEvent(source));
    }
    public void notifyChanged(IEntity source, FeatureDescriptor fd, int oldValue, int newValue) {
    	addEvent(createReplaceEvent(source));
    }
    public void notifyChanged(IEntity source, FeatureDescriptor fd, long oldValue, long newValue) {
    	addEvent(createReplaceEvent(source));
    }
    public void notifyChanged(IEntity source, FeatureDescriptor fd, short oldValue, short newValue) {
    	addEvent(createReplaceEvent(source));
    }
    public void notifyChanged(IEntity source, FeatureDescriptor fd, String oldValue, String newValue) {
    	addEvent(createReplaceEvent(source));
    }
    public void notifyChanged(IEntity source, FeatureDescriptor fd, Date oldValue, Date newValue) {
    	addEvent(createReplaceEvent(source));
    }
    public void notifyChanged(IEntity source, FeatureDescriptor fd, EnumValue oldValue, EnumValue newValue) {
    	addEvent(createReplaceEvent(source));
    }
    public void notifyChanged(IEntity source, FeatureDescriptor fd, Object oldValue, Object newValue) {
    	addEvent(createReplaceEvent(source));
    }

	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Event Source Manager (size=");
		builder.append(eventSource.wGet(2).wSize());
		builder.append(")\n[");
		builder.append(eventSource.wGet(2).toString());
		builder.append("\n]");

		return builder.toString();
	}
}
