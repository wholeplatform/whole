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

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.iterators.ExecutableFactory;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.steppers.IDataFlowConsumer;

/**
 * @author Riccardo Solmi
 */
public class ExecutableFactoryTest {
	protected static ExecutableFactory f;
	protected static BindingManagerFactory bmf;
	protected static IEntity[] VALUES;
	protected static IEntity TRUE_VALUE;
	protected static IEntity FALSE_VALUE;

    @BeforeClass
    public static void deployWholePlatform() {
    	ReflectionFactory.deployWholePlatform();

//TODO switch comment to test a specific factory
//  	f = IteratorFactory.instance;
    	f = new RegularExecutableFactory();

    	bmf = BindingManagerFactory.instance;
    	VALUES = new IEntity[] {
    			bmf.createValue(0), bmf.createValue(1), bmf.createValue(2), bmf.createValue(3), bmf.createValue(4),
    			bmf.createValue(5), bmf.createValue(6), bmf.createValue(7), bmf.createValue(8), bmf.createValue(9)
    	};
    	TRUE_VALUE = bmf.createValue(true);
    	FALSE_VALUE = bmf.createValue(false);
    }

	public static enum Event {
		NEXT, DONE
	}

    public static class TesterDataFlowConsumer implements IDataFlowConsumer {
    	public List<Event> events = new ArrayList<>();
    	public List<IEntity> values = new ArrayList<>();
    	protected Event[] expectedEvents;
    	protected IEntity[] expectedValues;
       	protected boolean same;

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

		public void accept(IEntity entity) {
			addEvent(Event.NEXT);
			addValue(entity);
		}

		public void done() {
			addEvent(Event.DONE);
		}
    }

    @Test
    public void testEmptyStepper() {
    	TesterDataFlowConsumer c = new TesterDataFlowConsumer();
    	IExecutable<?> p = f.createEmpty();
		p.withConsumer(c);
    	p.setBindings(bmf.createBindingManager());
    	p.reset(VALUES[0]);

    	c.setExpectedEvents(Event.DONE);
    	p.callNext();

    	c.clear();
    	c.setExpectedEvents(Event.DONE, Event.DONE);
    	p.callNext();
    	p.callNext();
    }

    @Test
    public void testConstantStepper() {
    	TesterDataFlowConsumer c = new TesterDataFlowConsumer();
    	IExecutable<?> p = f.createConstant(VALUES[0], false);
		p.withConsumer(c);
    	p.setBindings(bmf.createBindingManager());

    	c.useSameComparator(true);
    	c.setExpectedValues(VALUES[0]);
    	c.setExpectedEvents(Event.NEXT, Event.DONE);
    	p.reset(VALUES[1]);
    	p.callNext();
    	p.callRemaining();

    	c.clear();
     	p.reset(VALUES[1]);
    	p.callRemaining();

    	c.clear();
    	p.reset(VALUES[1]);
    	p.callNext();
    	p.callNext();

    	c.setExpectedEvents(Event.NEXT, Event.DONE, Event.DONE, Event.DONE);
    	c.clear();
    	p.reset(VALUES[1]);
    	p.callNext();
    	p.callNext();
    	p.callNext();
    	p.callNext();
 
    	c.clear();
    	p.reset(VALUES[1]);
    	p.callRemaining();
    	p.callRemaining();
    	p.callRemaining();
    }

    @Test
    public void testAsVariableStepper() {
    	IBindingManager bm = bmf.createBindingManager();
    	TesterDataFlowConsumer c = new TesterDataFlowConsumer();
    	IExecutable<?> p = f.createAsVariable("v0");
		p.withConsumer(c);
    	p.setBindings(bm);

    	c.setExpectedValues(TRUE_VALUE);
    	c.setExpectedEvents(Event.NEXT, Event.DONE, Event.DONE);
    	p.reset(VALUES[0]);
    	assertFalse(bm.wIsSet("v0"));
    	p.callNext();
    	assertSame(VALUES[0], bm.wGet("v0"));
    	p.callNext();
    	p.callNext();
    	assertSame(VALUES[0], bm.wGet("v0"));    	

    	c.clear();
    	c.setExpectedValues(TRUE_VALUE);
    	p.reset(VALUES[0]); //same value
    	assertSame(VALUES[0], bm.wGet("v0"));
    	p.callRemaining();
    	assertSame(VALUES[0], bm.wGet("v0"));
    	p.callNext();
    	assertSame(VALUES[0], bm.wGet("v0"));

    	c.clear();
    	c.setExpectedValues(FALSE_VALUE);
    	p.reset(VALUES[1]); //different value
    	assertSame(VALUES[0], bm.wGet("v0"));
    	p.callRemaining();
    	assertSame(VALUES[0], bm.wGet("v0"));
    	p.callNext();
    	assertSame(VALUES[0], bm.wGet("v0"));
    }

    @Test
    public void testVariableStepper() {
    	IBindingManager bm = bmf.createBindingManager();
    	bm.wDef("v0", VALUES[0]);
    	TesterDataFlowConsumer c = new TesterDataFlowConsumer();
    	IExecutable<?> p = f.createVariable("v0");
		p.withConsumer(c);
    	p.setBindings(bm);

    	p.reset(VALUES[1]);
    	c.setExpectedEvents(Event.NEXT);
    	c.setExpectedValues(VALUES[0]);
    	c.useSameComparator(true);
    	p.callNext();
    	assertSame(VALUES[0], bm.wGet("v0"));

    	bm.wUnset("v0");
    	c.clear();
    	p.reset(VALUES[1]);
    	c.setExpectedEvents(Event.DONE);
    	assertFalse(bm.wIsSet("v0"));
    	p.callNext();
    	assertFalse(bm.wIsSet("v0"));
    }

    @Test
    public void testBindVariableStepper() {
    	IBindingManager bm = bmf.createBindingManager();
    	TesterDataFlowConsumer c = new TesterDataFlowConsumer();
    	IExecutable<?> p = f.createFilter(f.createConstant(VALUES[0], false), f.createAsVariable("v0"));
		p.withConsumer(c);
    	p.setBindings(bm);

    	p.reset(VALUES[1]);
    	c.setExpectedEvents(Event.NEXT, Event.DONE);
    	c.setExpectedValues(VALUES[0]);
    	c.useSameComparator(true);
    	assertFalse(bm.wIsSet("v0"));
    	p.callNext();
    	assertSame(VALUES[0], bm.wGet("v0"));
    	p.callNext();
    	assertFalse(bm.wIsSet("v0")); // predicate effects are cleared before each expression step

    	bm.wDef("v0", VALUES[2]);
    	c.clear();
    	c.setExpectedEvents(Event.DONE);
    	p.reset(VALUES[1]);
    	assertSame(VALUES[2], bm.wGet("v0"));
    	p.callRemaining();
    	assertSame(VALUES[2], bm.wGet("v0"));
    }

    @Test
    public void testSequenceStepper() {
    	TesterDataFlowConsumer c = new TesterDataFlowConsumer();
    	@SuppressWarnings("unchecked")
		IExecutable<?> p = f.createSequence(
    			f.createConstant(VALUES[0], false),
    			f.createConstant(VALUES[1], false),
    			f.createConstant(VALUES[2], false),
    			f.createSequence(
    	    			f.createConstant(VALUES[3], false),
    	    			f.createConstant(VALUES[4], false)),
    			f.createSequence(
    	    			f.createConstant(VALUES[5], false),
    	    			f.createConstant(VALUES[6], false),
    	    			f.createConstant(VALUES[7], false))
    	);
		p.withConsumer(c);
    	p.setBindings(bmf.createBindingManager());

		c.setExpectedValues(
    			VALUES[0], VALUES[1], VALUES[2], VALUES[3], VALUES[4], VALUES[5], VALUES[6], VALUES[7]);
    	c.setExpectedEvents(
    			Event.NEXT, Event.NEXT, Event.NEXT, Event.NEXT, Event.NEXT, Event.NEXT, Event.NEXT, Event.NEXT, Event.DONE);

    	p.reset(VALUES[0]);
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
    	p.reset(VALUES[0]);
    	p.callRemaining();
    }


    @Test
    public void testSequenceWithBindingsStepper() {
    	IBindingManager bm = bmf.createBindingManager();
    	TesterDataFlowConsumer c = new TesterDataFlowConsumer();
		@SuppressWarnings("unchecked")
		IExecutable<?> p = f.createSequence(
				f.createFilter(f.createConstant(VALUES[0], false), f.createAsVariable("v0")),
				f.createFilter(f.createConstant(VALUES[1], false), f.createAsVariable("v1")),
				f.createFilter(f.createVariable("v0"), f.createAsVariable("v2")),
    			f.createSequence(
    					f.createFilter(f.createConstant(VALUES[2], false), f.createAsVariable("v0")), //not bound
    					f.createFilter(f.createConstant(VALUES[3], false), f.createAsVariable("v3")),
    					f.createFilter(f.createVariable("v1"), f.createAsVariable("v4"))),
				f.createFilter(f.createVariable("v0"), f.createAsVariable("v5")),
				f.createFilter(f.createVariable("v3"), f.createAsVariable("v6")), //not bound: missing v3
    			f.createFilter(f.createConstant(VALUES[4], false), f.createAsVariable("v3"))
    	);
		p.withConsumer(c);
    	p.setBindings(bm);

    	c.setExpectedEvents(
    			Event.NEXT, Event.NEXT, Event.NEXT, Event.NEXT, Event.NEXT, Event.NEXT, Event.NEXT, Event.DONE);
		c.setExpectedValues(
    			VALUES[0], VALUES[1], VALUES[0], VALUES[3], VALUES[1], VALUES[0], VALUES[4]);
    	c.useSameComparator(true);
    	p.reset(VALUES[5]);
    	p.callNext();
    	assertSame(VALUES[0], bm.wGet("v0"));
    	p.callNext();
    	assertFalse(bm.wIsSet("v0"));
    	assertSame(VALUES[1], bm.wGet("v1"));
    	p.callNext();
    	assertFalse(bm.wIsSet("v0") || bm.wIsSet("v1"));
    	assertSame(VALUES[0], bm.wGet("v2"));
    	p.callNext();
    	assertFalse(bm.wIsSet("v0") || bm.wIsSet("v1") || bm.wIsSet("v2"));
    	assertSame(VALUES[3], bm.wGet("v3"));
    	p.callNext();
    	assertFalse(bm.wIsSet("v0") || bm.wIsSet("v1") || bm.wIsSet("v2") || bm.wIsSet("v3"));
    	assertSame(VALUES[1], bm.wGet("v4"));    	
    	p.callNext();
    	assertFalse(bm.wIsSet("v0") || bm.wIsSet("v1") || bm.wIsSet("v2") || bm.wIsSet("v3") || bm.wIsSet("v4"));
    	assertSame(VALUES[0], bm.wGet("v5"));    	
    	p.callNext();
    	assertFalse(bm.wIsSet("v0") || bm.wIsSet("v1") || bm.wIsSet("v2") || bm.wIsSet("v4") || bm.wIsSet("v5"));
    	assertSame(VALUES[4], bm.wGet("v3"));    	
    	p.callNext();
    	assertFalse(bm.wIsSet("v0") || bm.wIsSet("v1") || bm.wIsSet("v2") || bm.wIsSet("v3") || bm.wIsSet("v4") || bm.wIsSet("v5"));

    	//TODO
//    	c.clear();
//    	p.reset(values[0]);
//    	p.callRemaining();
    }

    @Test
    public void testIfWithBindingsStepper() {
    	IBindingManager bm = bmf.createBindingManager();
    	TesterDataFlowConsumer c = new TesterDataFlowConsumer();
		@SuppressWarnings("unchecked")
		IExecutable<?> p = f.createSequence(
				f.createFilter(f.createConstant(VALUES[0], false), f.createAsVariable("v0")),
    			f.createIf(
    					f.createFilter(f.createConstant(TRUE_VALUE, false), f.createAsVariable("v1")),
    	    			f.createSequence(
    	    					f.createFilter(f.createVariable("v1"), f.createAsVariable("v2")),
    	    					f.createFilter(f.createConstant(VALUES[3], false), f.createAsVariable("v3")))),
				f.createFilter(f.createVariable("v0"), f.createAsVariable("v4")),
				f.createFilter(f.createVariable("v1"), f.createAsVariable("v5")),
				f.createFilter(f.createVariable("v2"), f.createAsVariable("v6")) //not bound
    	);
		p.withConsumer(c);
    	p.setBindings(bm);

    	c.setExpectedEvents(
    			Event.NEXT, Event.NEXT, Event.NEXT, Event.NEXT, Event.NEXT, Event.DONE);
		c.setExpectedValues(
    			VALUES[0], TRUE_VALUE, VALUES[3], VALUES[0], TRUE_VALUE);
    	p.reset(VALUES[5]);
    	p.callNext();
    	assertSame(VALUES[0], bm.wGet("v0"));
    	p.callNext();
    	assertFalse(bm.wIsSet("v0"));
    	assertSame(TRUE_VALUE, bm.wGet("v1"));
    	assertSame(TRUE_VALUE, bm.wGet("v2"));
    	p.callNext();
    	assertFalse(bm.wIsSet("v0") || bm.wIsSet("v2"));
    	assertSame(TRUE_VALUE, bm.wGet("v1"));
    	assertSame(VALUES[3], bm.wGet("v3"));
    	p.callNext();
    	assertFalse(bm.wIsSet("v0") || bm.wIsSet("v2") || bm.wIsSet("v3"));
    	assertSame(TRUE_VALUE, bm.wGet("v1")); //TODO unset condition semantics
    	assertSame(VALUES[0], bm.wGet("v4"));
    	p.callNext();
    	assertFalse(bm.wIsSet("v0") || bm.wIsSet("v2") || bm.wIsSet("v3") || bm.wIsSet("v4"));
    	assertSame(TRUE_VALUE, bm.wGet("v1")); //TODO unset condition semantics
    	assertSame(TRUE_VALUE, bm.wGet("v5"));
    	p.callNext();
    	assertFalse(bm.wIsSet("v0") || bm.wIsSet("v2") || bm.wIsSet("v3") || bm.wIsSet("v4") || bm.wIsSet("v5"));
    	assertSame(TRUE_VALUE, bm.wGet("v1")); //TODO unset condition semantics
    }

    @Test
    public void testEmptyEvaluator() {
    	IExecutable<?> i = f.createEmpty();
    	i.setBindings(bmf.createBindingManager());
    	i.reset(VALUES[0]);

    	assertNull(i.evaluateNext());
    	assertNull(i.evaluateNext());
    	assertNull(i.evaluateNext());
 
    	i.reset(VALUES[0]);
    	assertNull(i.evaluateNext());
    	assertNull(i.evaluateRemaining());
    	 
    	i.reset(VALUES[0]);
    	assertNull(i.evaluateRemaining());
    	assertNull(i.evaluateRemaining());
    }

    @Test
    public void testConstantEvaluator() {
    	IExecutable<?> i = f.createConstant(VALUES[0], false);
    	i.setBindings(bmf.createBindingManager());
    	i.reset(VALUES[1]);

    	assertSame(VALUES[0], i.evaluateNext());
    	assertNull(i.evaluateNext());
    	assertNull(i.evaluateNext());
    	assertNull(i.evaluateNext());
 
    	i.reset(VALUES[1]);
    	assertSame(VALUES[0], i.evaluateNext());
    	assertNull(i.evaluateNext());
    	assertNull(i.evaluateRemaining());
    	 
    	i.reset(VALUES[1]);
    	assertSame(VALUES[0], i.evaluateRemaining());
    	assertNull(i.evaluateRemaining());
    	assertNull(i.evaluateRemaining());
    }

    @Test
    public void testSequenceEvaluator() {
    	@SuppressWarnings("unchecked")
		IExecutable<?> i = f.createSequence(
    			f.createConstant(VALUES[0], false),
    			f.createConstant(VALUES[1], false),
    			f.createConstant(VALUES[2], false),
    			f.createSequence(
    	    			f.createConstant(VALUES[3], false),
    	    			f.createConstant(VALUES[4], false)),
    			f.createSequence(
    	    			f.createConstant(VALUES[5], false),
    	    			f.createConstant(VALUES[6], false),
    	    			f.createConstant(VALUES[7], false))
    	);
    	i.setBindings(bmf.createBindingManager());
    	i.reset(VALUES[0]);

    	for (int at=0; at<8; at++)
    		assertSame(VALUES[at], i.evaluateNext());
    	assertNull(i.evaluateNext());
    	assertNull(i.evaluateNext());
    	assertNull(i.evaluateNext());
 
    	i.reset(VALUES[0]);
    	for (int at=0; at<8; at++)
    		assertSame(VALUES[at], i.evaluateNext());
    	assertNull(i.evaluateNext());
    	assertNull(i.evaluateRemaining());
    	 
    	i.reset(VALUES[0]);
    	assertSame(VALUES[7], i.evaluateRemaining());
    	assertNull(i.evaluateRemaining());
    	assertNull(i.evaluateRemaining());
    }

    @Test
    public void testChooseByOrderEvaluator() {
    	@SuppressWarnings("unchecked")
		IExecutable<?> i = f.createChoose(
    			f.createEmpty(),
    			f.createEmpty(),
    			f.createSequence(
    	    			f.createConstant(VALUES[0], false),
    	    			f.createConstant(VALUES[1], false),
    	    			f.createConstant(VALUES[2], false)),
    			f.createConstant(VALUES[3], false),
    			f.createConstant(VALUES[4], false)
    	);
    	i.setBindings(bmf.createBindingManager());
    	i.reset(VALUES[0]);

    	for (int at=0; at<3; at++)
    		assertSame(VALUES[at], i.evaluateNext());
    	assertNull(i.evaluateNext());
    	assertNull(i.evaluateNext());
    	assertNull(i.evaluateNext());
 
    	i.reset(VALUES[0]);
    	for (int at=0; at<3; at++)
    		assertSame(VALUES[at], i.evaluateNext());
    	assertNull(i.evaluateNext());
    	assertNull(i.evaluateRemaining());
    	 
    	i.reset(VALUES[0]);
    	assertSame(VALUES[2], i.evaluateRemaining());
    	assertNull(i.evaluateRemaining());
    	assertNull(i.evaluateRemaining());
    }
}

