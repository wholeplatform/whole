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
package org.whole.lang.executables;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.iterators.IEntityIterator;
import org.whole.lang.iterators.IteratorFactory;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.steppers.IDataFlowConsumer;

/**
 * @author Riccardo Solmi
 */
public class ExecutableFactoryTest {
	protected static IteratorFactory f;
	protected static BindingManagerFactory bmf;
	protected static IEntity[] values;

    @BeforeClass
    public static void deployWholePlatform() {
    	ReflectionFactory.deployWholePlatform();

//TODO switch comment to test a specific factory
//    	f = IteratorFactory.instance;
    	f = new RegularExecutableFactory();

    	bmf = BindingManagerFactory.instance;
    	values = new IEntity[] {
    			bmf.createValue(0), bmf.createValue(1), bmf.createValue(2), bmf.createValue(3), bmf.createValue(4),
    			bmf.createValue(5), bmf.createValue(6), bmf.createValue(7), bmf.createValue(8), bmf.createValue(9)
    	};
    }

	public static enum Event {
		BEGIN, NEXT, END
	}

    public static class TesterDataFlowConsumer implements IDataFlowConsumer {
    	public List<Event> events = new ArrayList<>();
    	public List<IEntity> values = new ArrayList<>();
    	protected Event[] expectedEvents;
    	protected IEntity[] expectedValues;

    	public void clear() {
    		events.clear();
    		values.clear();
    	}

    	public void setExpectedEvents(Event... events) {
			this.expectedEvents = events;
		}

    	public void setExpectedValues(IEntity... values) {
			this.expectedValues = values;
		}

    	protected void addValue(IEntity e) {
    		values.add(e);

    		if (expectedValues != null) {
    			if (expectedValues.length < values.size())
    				throw new IllegalStateException("Received extra: "+e);
    			if (expectedValues[values.size()-1] != e)
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

		public void doBegin(int size) {
			addEvent(Event.BEGIN);
		}

		public void doNext(IEntity entity) {
			addEvent(Event.NEXT);
			addValue(entity);
		}

		public void doEnd() {
			addEvent(Event.END);
		}
    }

    @Test
    public void testEmptyStepper() {
    	IEntityIterator<?> p = f.emptyIterator();
    	p.setBindings(bmf.createBindingManager());
    	p.reset(values[0]);

    	
    	TesterDataFlowConsumer c = new TesterDataFlowConsumer();
		p.withConsumer(c);

    	c.setExpectedEvents(Event.END);
    	p.callNext();

    	c.clear();
    	c.setExpectedEvents(Event.END, Event.END);
    	p.callNext();
    	p.callNext();
    }

    @Test
    public void testConstantStepper() {
    	IEntityIterator<?> p = f.constantIterator(values[0], false);
    	p.setBindings(bmf.createBindingManager());
    	p.reset(values[1]);

    	TesterDataFlowConsumer c = new TesterDataFlowConsumer();
		p.withConsumer(c);

    	c.setExpectedValues(values[0]);
    	c.setExpectedEvents(Event.NEXT, Event.END);
    	p.reset(values[1]);
    	p.callNext();
    	p.callRemaining();
    	 
    	c.clear();
     	p.reset(values[1]);
    	p.callRemaining();

    	c.clear();
    	p.reset(values[1]);
    	p.callNext();
    	p.callNext();

    	c.setExpectedEvents(Event.NEXT, Event.END, Event.END, Event.END);
    	c.clear();
    	p.reset(values[1]);
    	p.callNext();
    	p.callNext();
    	p.callNext();
    	p.callNext();
 
    	c.clear();
    	p.reset(values[1]);
    	p.callRemaining();
    	p.callRemaining();
    	p.callRemaining();
    }

    @Test
    public void testSequenceStepper() {
    	@SuppressWarnings("unchecked")
		IEntityIterator<?> p = f.sequenceIterator(
    			f.constantIterator(values[0], false),
    			f.constantIterator(values[1], false),
    			f.constantIterator(values[2], false),
    			f.sequenceIterator(
    	    			f.constantIterator(values[3], false),
    	    			f.constantIterator(values[4], false)),
    			f.sequenceIterator(
    	    			f.constantIterator(values[5], false),
    	    			f.constantIterator(values[6], false),
    	    			f.constantIterator(values[7], false))
    	);
    	p.setBindings(bmf.createBindingManager());

    	TesterDataFlowConsumer c = new TesterDataFlowConsumer();
		p.withConsumer(c);
		c.setExpectedValues(
    			values[0], values[1], values[2], values[3], values[4], values[5], values[6], values[7]);
    	c.setExpectedEvents(
    			Event.NEXT, Event.NEXT, Event.NEXT, Event.NEXT, Event.NEXT, Event.NEXT, Event.NEXT, Event.NEXT, Event.END);

    	p.reset(values[0]);
    	p.callNext();
    	p.callNext();
    	p.callNext();
    	p.callNext();
    	p.callNext();
    	p.callNext();
    	p.callNext();
    	p.callNext();
    	p.callNext();
 
    	c.clear();
    	p.reset(values[0]);
    	p.callRemaining();
    }

    @Test
    public void testEmptyEvaluator() {
    	IEntityIterator<?> i = f.emptyIterator();
    	i.setBindings(bmf.createBindingManager());
    	i.reset(values[0]);

    	assertNull(i.evaluateNext());
    	assertNull(i.evaluateNext());
    	assertNull(i.evaluateNext());
 
    	i.reset(values[0]);
    	assertNull(i.evaluateNext());
    	assertNull(i.evaluateRemaining());
    	 
    	i.reset(values[0]);
    	assertNull(i.evaluateRemaining());
    	assertNull(i.evaluateRemaining());
    }

    @Test
    public void testConstantEvaluator() {
    	IEntityIterator<?> i = f.constantIterator(values[0], false);
    	i.setBindings(bmf.createBindingManager());
    	i.reset(values[1]);

    	assertSame(values[0], i.evaluateNext());
    	assertNull(i.evaluateNext());
    	assertNull(i.evaluateNext());
    	assertNull(i.evaluateNext());
 
    	i.reset(values[1]);
    	assertSame(values[0], i.evaluateNext());
    	assertNull(i.evaluateNext());
    	assertNull(i.evaluateRemaining());
    	 
    	i.reset(values[1]);
    	assertSame(values[0], i.evaluateRemaining());
    	assertNull(i.evaluateRemaining());
    	assertNull(i.evaluateRemaining());
    }

    @Test
    public void testSequenceEvaluator() {
    	@SuppressWarnings("unchecked")
		IEntityIterator<?> i = f.sequenceIterator(
    			f.constantIterator(values[0], false),
    			f.constantIterator(values[1], false),
    			f.constantIterator(values[2], false),
    			f.sequenceIterator(
    	    			f.constantIterator(values[3], false),
    	    			f.constantIterator(values[4], false)),
    			f.sequenceIterator(
    	    			f.constantIterator(values[5], false),
    	    			f.constantIterator(values[6], false),
    	    			f.constantIterator(values[7], false))
    	);
    	i.setBindings(bmf.createBindingManager());
    	i.reset(values[0]);

    	for (int at=0; at<8; at++)
    		assertSame(values[at], i.evaluateNext());
    	assertNull(i.evaluateNext());
    	assertNull(i.evaluateNext());
    	assertNull(i.evaluateNext());
 
    	i.reset(values[0]);
    	for (int at=0; at<8; at++)
    		assertSame(values[at], i.evaluateNext());
    	assertNull(i.evaluateNext());
    	assertNull(i.evaluateRemaining());
    	 
    	i.reset(values[0]);
    	assertSame(values[7], i.evaluateRemaining());
    	assertNull(i.evaluateRemaining());
    	assertNull(i.evaluateRemaining());
    }

    @Test
    public void testChooseByOrderEvaluator() {
    	@SuppressWarnings("unchecked")
		IEntityIterator<?> i = f.chooseIterator(
    			f.emptyIterator(),
    			f.emptyIterator(),
    			f.sequenceIterator(
    	    			f.constantIterator(values[0], false),
    	    			f.constantIterator(values[1], false),
    	    			f.constantIterator(values[2], false)),
    			f.constantIterator(values[3], false),
    			f.constantIterator(values[4], false)
    	);
    	i.setBindings(bmf.createBindingManager());
    	i.reset(values[0]);

    	for (int at=0; at<3; at++)
    		assertSame(values[at], i.evaluateNext());
    	assertNull(i.evaluateNext());
    	assertNull(i.evaluateNext());
    	assertNull(i.evaluateNext());
 
    	i.reset(values[0]);
    	for (int at=0; at<3; at++)
    		assertSame(values[at], i.evaluateNext());
    	assertNull(i.evaluateNext());
    	assertNull(i.evaluateRemaining());
    	 
    	i.reset(values[0]);
    	assertSame(values[2], i.evaluateRemaining());
    	assertNull(i.evaluateRemaining());
    	assertNull(i.evaluateRemaining());
    }
}

