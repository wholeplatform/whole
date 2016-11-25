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
package org.whole.lang.events;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.util.EntityUtils;

/**
 * @author Riccardo Solmi
 */
public class DerivationContext extends IdentityEventHandler {
	private static final long serialVersionUID = 1L;

	public static enum State {
		IDLE, GET, SET, REQUEST, CHANGE
	}
	protected State state = State.IDLE;
	protected int stateNesting = 0;
	protected void pushRequest() {
		switch (state) {
		case IDLE:
			state = State.GET;
			break;
		case GET:
			state = State.REQUEST;
			break;
		default:
		}
	}
	protected void popRequest() {
		switch (state) {
		case REQUEST:
		case GET:
			state = State.IDLE;
			break;
		default:
		}
	}

	protected Map<EntityDescriptor<?>, IRequestEventHandler> requestRules = new HashMap<>();
	protected Map<EntityDescriptor<?>, IChangeEventHandler> changeRules = new HashMap<>();
	protected Set<IEntity> pendingRequests = new HashSet<IEntity>();
	protected Set<IEntity> derivedChanges = new HashSet<IEntity>();

	public IRequestEventHandler getRequestRules(EntityDescriptor<?> ed) {
		IRequestEventHandler rules = requestRules.get(ed);
		if (rules == null)
			requestRules.put(ed,  rules = IdentityRequestEventHandler.instance);
		return rules;
	}
	public IChangeEventHandler getChangeRules(EntityDescriptor<?> ed) {
		IChangeEventHandler rules = changeRules.get(ed);
		if (rules == null)
			changeRules.put(ed,  rules = IdentityChangeEventHandler.instance);
		return rules;
	}
	public void addDerivationRules(EntityDescriptor<?> ed, IEventHandler... rules) {
		IRequestEventHandler requestRules = getRequestRules(ed);
		IChangeEventHandler changeRules = getChangeRules(ed);

		for (IEventHandler rule : rules) {
			requestRules = requestRules.addRequestEventHandler(rule);
			changeRules = changeRules.addChangeEventHandler(rule);
		}

		this.requestRules.put(ed,  requestRules);
		this.changeRules.put(ed,  changeRules);
	}

    public <E extends IEntity> E notifyRequested(IEntity source, FeatureDescriptor fd, int index, E value) {
		if (EntityUtils.isResolver(value)) {
			if (!pendingRequests.add(value))
				throw new RequestException();

			E newValue = getRequestRules(source.wGetEntityDescriptor()).notifyRequested(source, fd, index, value);
			if (newValue != value) {
				pendingRequests.remove(value);
				return newValue;
			}
		}

		return value;
	}
	public <E extends IEntity> E notifyRequested(IEntity source, FeatureDescriptor fd, E value) {
		if (EntityUtils.isResolver(value)) {
			if (!pendingRequests.add(value))
				throw new RequestException();

			if (state.equals(State.IDLE))
				state = State.REQUEST;

			try {
				return getRequestRules(source.wGetEntityDescriptor()).notifyRequested(source, fd, value);
			} finally {
				if (state.equals(State.REQUEST))
					state = State.IDLE;
				
				pendingRequests.remove(value);
			}
		}

		return value;
	}

    public void notifyChanged(IEntity source, FeatureDescriptor fd, int index, IEntity oldValue, IEntity newValue) {
    	if (EntityUtils.isResolver(oldValue))
    		pendingRequests.remove(oldValue);

    	if (state.equals(State.SET))
    		derivedChanges.remove(oldValue);
    	else if (state.equals(State.CHANGE) || state.equals(State.REQUEST))
    		derivedChanges.add(newValue);

    	getChangeRules(source.wGetEntityDescriptor()).notifyChanged(source, fd, index, oldValue, newValue);
    }
    public void notifyChanged(IEntity source, FeatureDescriptor fd, IEntity oldValue, IEntity newValue) {
    	if (EntityUtils.isResolver(oldValue))
    		pendingRequests.remove(oldValue);

    	if (state.equals(State.SET))
    		derivedChanges.remove(oldValue);
    	else if (state.equals(State.CHANGE) || state.equals(State.REQUEST))
    		derivedChanges.add(newValue);

    	getChangeRules(source.wGetEntityDescriptor()).notifyChanged(source, fd, oldValue, newValue);
    }
}
