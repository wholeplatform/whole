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
package org.whole.lang.steppers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.whole.lang.executables.IExecutable;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.ICloneContext;

/**
 * @author Riccardo Solmi
 */
public class TesterDataFlowConsumer extends AbstractDataFlowConsumer {
	public List<Event> events = new ArrayList<>();
	public List<IEntity> values = new ArrayList<>();
	protected Event[] expectedEvents;
	protected IEntity[] expectedValues;
   	protected boolean same;

   	@Override
   	public IDataFlowConsumer clone(ICloneContext cc) {
   		//FIXME clone state
   		return super.clone(cc);
   	}

	public void clear() {
		events.clear();
		values.clear();
	}

	public static enum Event {
		ACCEPT
	}

	public void setExpectedEvents(Event... events) {
		this.expectedEvents = events;
	}

	public void setExpectedValues(IEntity... values) {
		this.expectedValues = values;
	}
	public void useSameComparator(boolean value) {
		this.same = value;
	}

	protected void addValue(IEntity e) {
		values.add(e);

		if (expectedValues != null) {
			if (expectedValues.length < values.size())
				throw new IllegalStateException("Received extra: "+e);
			if ((same && expectedValues[values.size()-1] != e) || (!same && !expectedValues[values.size()-1].wEquals(e)))
				throw new IllegalStateException(values.size()+"th value expected: "+expectedValues[values.size()-1]+"\n\nReceived: "+e);
		}
	}

	protected void addEvent(Event e) {
		events.add(e);

		if (expectedEvents != null) {
			if (expectedEvents.length < events.size())
				throw new IllegalStateException("Received extra: "+e);
			if (expectedEvents[events.size()-1] != e)
				throw new IllegalStateException(events.size()+"th event expected: "+expectedEvents[events.size()-1]+" received: "+e);
		}
	}

	public void checkExpectations() {
		boolean missingValues = expectedValues != null && values.size() < expectedValues.length;
		boolean missingEvents = expectedEvents != null && events.size() < expectedEvents.length;
		if (missingValues || missingEvents) {
			StringBuilder msg = new StringBuilder("Expecting additional"); 
			if (missingValues)
				msg.append(" values: "+Arrays.toString(Arrays.copyOfRange(expectedValues, values.size(), expectedValues.length)));
			if (missingEvents)
				msg.append(" events: "+Arrays.toString(Arrays.copyOfRange(expectedEvents, events.size(), expectedEvents.length)));
			throw new IllegalStateException(msg.toString());
		}
	}

	public void accept(IExecutable executable) {
		addEvent(Event.ACCEPT);
		executable.forEach(e -> addValue(e));
	}
}
