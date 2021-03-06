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
package org.whole.lang.executables;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.util.Set;

import org.junit.BeforeClass;
import org.junit.Test;
import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.evaluators.AbstractEvaluator;
import org.whole.lang.math.factories.MathEntityFactory;
import org.whole.lang.math.model.Identifier;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.steppers.TesterDataFlowConsumer;
import org.whole.lang.steppers.TesterDataFlowConsumer.Event;

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
//  	f = ExecutableFactory.instance;
    	f = new RegularExecutableFactory();

    	bmf = BindingManagerFactory.instance;
    	VALUES = new IEntity[] {
    			bmf.createValue(0), bmf.createValue(1), bmf.createValue(2), bmf.createValue(3), bmf.createValue(4),
    			bmf.createValue(5), bmf.createValue(6), bmf.createValue(7), bmf.createValue(8), bmf.createValue(9)
    	};
    	TRUE_VALUE = bmf.createValue(true);
    	FALSE_VALUE = bmf.createValue(false);
    }


    @Test
    public void testEmptyStepper() {
    	TesterDataFlowConsumer c = new TesterDataFlowConsumer();
    	IExecutable p = f.createEmpty();
		p.addFirstAction(c);
    	p.setBindings(bmf.createBindingManager());
    	p.reset(VALUES[0]);

    	c.setExpectedEvents(Event.ACCEPT);
    	p.call();

    	c.clear();
    	c.setExpectedEvents(Event.ACCEPT, Event.ACCEPT);
    	p.call();
    	p.call();
    }

    @Test
    public void testConstantStepper() {
    	TesterDataFlowConsumer c = new TesterDataFlowConsumer();
    	IExecutable p = f.createConstant(VALUES[0], false);
		p.addFirstAction(c);
    	p.setBindings(bmf.createBindingManager());

    	c.useSameComparator(true);
    	c.setExpectedValues(VALUES[0]);
    	c.setExpectedEvents(Event.ACCEPT, Event.ACCEPT);
    	p.reset(VALUES[1]);
    	p.call();
    	p.call();

    	c.clear();
     	p.reset(VALUES[1]);
    	p.call();

    	c.clear();
    	p.reset(VALUES[1]);
    	p.call();
    	p.call();

    	c.setExpectedEvents(Event.ACCEPT, Event.ACCEPT, Event.ACCEPT, Event.ACCEPT);
    	c.clear();
    	p.reset(VALUES[1]);
    	p.call();
    	p.call();
    	p.call();
    	p.call();
 
    	c.clear();
    	p.reset(VALUES[1]);
    	p.call();
    	p.call();
    	p.call();
    }

    @Test
    public void testAsVariableStepper() {
    	IBindingManager bm = bmf.createBindingManager();
    	TesterDataFlowConsumer c = new TesterDataFlowConsumer();
    	IExecutable p = f.createAsVariable("v0");
		p.addFirstAction(c);
    	p.setBindings(bm);

    	c.setExpectedValues(TRUE_VALUE);
    	c.setExpectedEvents(Event.ACCEPT, Event.ACCEPT, Event.ACCEPT);
    	p.reset(VALUES[0]);
    	assertFalse(bm.wIsSet("v0"));
    	p.call();
    	assertSame(VALUES[0], bm.wGet("v0"));
    	p.call();
    	p.call();
    	assertSame(VALUES[0], bm.wGet("v0"));    	

    	c.clear();
    	c.setExpectedValues(TRUE_VALUE);
    	p.reset(VALUES[0]); //same value
    	assertSame(VALUES[0], bm.wGet("v0"));
    	p.call();
    	assertSame(VALUES[0], bm.wGet("v0"));
    	p.call();
    	assertSame(VALUES[0], bm.wGet("v0"));

    	c.clear();
    	c.setExpectedValues(FALSE_VALUE);
    	p.reset(VALUES[1]); //different value
    	assertSame(VALUES[0], bm.wGet("v0"));
    	p.call();
    	assertSame(VALUES[0], bm.wGet("v0"));
    	p.call();
    	assertSame(VALUES[0], bm.wGet("v0"));
    }

    @Test
    public void testVariableStepper() {
    	IBindingManager bm = bmf.createBindingManager();
    	bm.wDef("v0", VALUES[0]);
    	TesterDataFlowConsumer c = new TesterDataFlowConsumer();
    	IExecutable p = f.createVariable("v0");
		p.addFirstAction(c);
    	p.setBindings(bm);

    	p.reset(VALUES[1]);
    	c.setExpectedEvents(Event.ACCEPT);
    	c.setExpectedValues(VALUES[0]);
    	c.useSameComparator(true);
    	p.call();
    	assertSame(VALUES[0], bm.wGet("v0"));

    	bm.wUnset("v0");
    	c.clear();
    	p.reset(VALUES[1]);
    	c.setExpectedEvents(Event.ACCEPT);
    	assertFalse(bm.wIsSet("v0"));
    	p.call();
    	assertFalse(bm.wIsSet("v0"));
    }

    @Test
    public void testBindVariableStepper() {
//    	f = new RegularExecutableFactory();
 
    	IBindingManager bm = bmf.createBindingManager();
    	TesterDataFlowConsumer c = new TesterDataFlowConsumer();
    	IExecutable p = f.createFilter(f.createConstant(VALUES[0], false), f.createAsVariable("v0"));
		p.addFirstAction(c);
    	p.setBindings(bm);

    	p.reset(VALUES[1]);
    	c.setExpectedEvents(Event.ACCEPT, Event.ACCEPT);
    	c.setExpectedValues(VALUES[0]);
    	c.useSameComparator(true);
    	assertFalse(bm.wIsSet("v0"));
    	p.call();
    	assertSame(VALUES[0], bm.wGet("v0"));
    	p.call();
    	assertSame(VALUES[0], bm.wGet("v0"));

    	bm.wDef("v0", VALUES[2]);
    	c.clear();
    	c.setExpectedEvents(Event.ACCEPT);
    	p.reset(VALUES[1]);
    	assertSame(VALUES[2], bm.wGet("v0"));
    	p.call();
    	assertSame(VALUES[2], bm.wGet("v0"));
    }

    @Test
    public void testSequenceStepper() {
    	TesterDataFlowConsumer c = new TesterDataFlowConsumer();
    	IExecutable p = f.createSequence(
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
		p.addFirstAction(c);
    	p.setBindings(bmf.createBindingManager());

		c.setExpectedValues(
    			VALUES[0], VALUES[1], VALUES[2], VALUES[3], VALUES[4], VALUES[5], VALUES[6], VALUES[7]);
    	c.setExpectedEvents(
    			Event.ACCEPT, Event.ACCEPT, Event.ACCEPT, Event.ACCEPT, Event.ACCEPT, Event.ACCEPT, Event.ACCEPT, Event.ACCEPT, Event.ACCEPT);

    	p.reset(VALUES[0]);
    	p.call();
    	p.call();
    	p.call();
    	p.call();
    	p.call();
    	p.call();
    	p.call();
    	p.call();
    	p.call();
 
    	c.clear();
    	p.reset(VALUES[0]);
    	p.call();
    }

    @Test
    public void testEmptyEvaluator() {
    	IExecutable i = f.createEmpty();
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
    	IExecutable i = f.createConstant(VALUES[0], false);
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
    	IExecutable i = f.createSequence(
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
    	IExecutable i = f.createChoose(
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

    @Test
    public void testOneEvaluator() {
    	IBindingManager bm = bmf.createBindingManager();
    	IExecutable i = f.createOne(f.createChild(), f.createAnd(f.createHasType("Identifier"), f.createAsVariable("exp")));

    	MathEntityFactory mf = MathEntityFactory.instance;
       	Identifier id = mf.createIdentifier("v");
    	IEntity addition = mf.createAddition(mf.createInteger(0), id, mf.createInteger(1), mf.createInteger(2));

    	i.setBindings(bm);
     	i.reset(addition);
    	assertTrue(i.evaluateNext().wBooleanValue());
    	assertSame(id, bm.wGet("exp"));

    	bm.wClear();
    	i.reset(addition);
    	assertTrue(i.evaluateNext().wBooleanValue());
    	assertSame(id, bm.wGet("exp"));

    	addition = mf.createAddition(mf.createInteger(0), mf.createIdentifier("v1"), mf.createInteger(1), mf.createIdentifier("v2"), mf.createInteger(2));

    	bm.wClear();
     	i.reset(addition);
    	assertFalse(i.evaluateNext().wBooleanValue());
    	assertFalse(bm.wIsSet("exp"));

    	bm.wClear();
    	i.reset(addition);
    	assertFalse(i.evaluateNext().wBooleanValue());
    	assertFalse(bm.wIsSet("exp"));
    }

    @Test
    public void testFilterEvaluator() {
    	IBindingManager bm = bmf.createBindingManager();
    	bm.wDef("v0", VALUES[0]);
    	bm.wDef("v1", VALUES[1]);

		IExecutable i = f.createFilter(
				new TestEvaluator((index, bm0) -> {
					switch (index) {
					case 0:
						return VALUES[0];
					case 1:
						return VALUES[1];
					case 2:
						return VALUES[2];
					}
					return null;
				}),
				new TestEvaluator((index, bm0) -> {
					switch (index) {
					case 0:
						return TRUE_VALUE;
					default:
						return null;
					}
				}));

    	i.setBindings(bm);
    	i.reset(VALUES[0]);

    	assertSame(VALUES[0], i.evaluateNext());   	
    	assertSame(VALUES[1], i.evaluateNext());   	
    	assertSame(VALUES[2], i.evaluateNext());   	
    	assertNull(i.evaluateNext());   	
    }

    @Test
    public void testScopeEvaluator() {
   	IBindingManager bm = bmf.createBindingManager();
    	bm.wDef("v0", VALUES[0]);
    	bm.wDef("v1", VALUES[1]);

    	IExecutable i = f.createScope(
//				new TestEvaluator((index, bm0) -> {
//					switch (index) {
//					case 0:
//						assertTrue(bm0.wIsSet("v0"));
//						assertFalse(bm0.wIsSet("v1"));
//						assertFalse(bm0.wIsSet("v2"));
//						bm0.wDef("v1", bm0.wGet("v0"));
//						return bm0.wGet("v1");
//					case 1:
//						assertTrue(bm0.wIsSet("v1"));
//						assertFalse(bm0.wIsSet("v2"));
//						bm0.wDef("v2", bm0.wGet("v1"));
//						return bm0.wGet("v2");
//					case 2:
//						assertTrue(bm0.wIsSet("v1"));
//						assertTrue(bm0.wIsSet("v2"));
//						bm0.wDef("v3", VALUES[2]);
//						return bm0.wGet("v3");
//					}
//					return null;
//				}),
    			f.createSequence(
    					f.createFilter(f.createVariable("v1"), f.createAsVariable("v2")),
    					f.createFilter(f.createVariable("v0"), f.createAsVariable("v1")),
    					f.createFilter(f.createVariable("v1"), f.createAsVariable("v2")),
    					f.createFilter(f.createConstant(VALUES[2], false), f.createAsVariable("v3"))),
    			null, Set.of("v1", "v2"), true);

    	i.setBindings(bm);
    	i.reset(VALUES[0]);

    	assertSame(VALUES[0], i.evaluateNext());
    	assertSame(VALUES[0], bm.wGet("v0"));
       	assertFalse(bm.wIsSet("v2"));
       	assertSame(VALUES[0], i.evaluateNext());
    	assertSame(VALUES[0], bm.wGet("v0"));
    	assertSame(VALUES[2], i.evaluateNext());
    	assertSame(VALUES[0], bm.wGet("v0"));
    	assertSame(VALUES[2], bm.wGet("v3"));
    	assertNull(i.evaluateNext());
    	assertSame(VALUES[0], bm.wGet("v0"));
    	assertSame(VALUES[1], bm.wGet("v1"));
       	assertFalse(bm.wIsSet("v2"));
    }

    @FunctionalInterface
    public static interface NextEvaluator {
    	public IEntity evaluateNext(int index, IBindingManager bm);
    }
    //FIXME add executor scope?
    public static class TestEvaluator extends AbstractEvaluator {
    	protected int resultIndex = 0;
    	protected NextEvaluator nextEvaluator;

    	public TestEvaluator(NextEvaluator nextEvaluator) {
    		this.nextEvaluator = nextEvaluator;
    	}

    	@Override
    	public void reset(IEntity entity) {
    		super.reset(entity);
    		resultIndex = 0;
    	}
    	
		@Override
		public IEntity evaluateNext() {
			IEntity result = null;
			try {
				clearProducerScope();
				getBindings().wEnterScope(executorScope(), true);
				return result = nextEvaluator.evaluateNext(resultIndex++, getBindings());
			} finally {
				getBindings().wExitScope(result != null);
			}
		}

    	public void prune() {
    	}

        public void set(IEntity entity) {
        	if (lastEntity == null)
        		throw new IllegalStateException();

        	lastEntity.wGetParent().wSet(lastEntity, entity);
        	lastEntity = entity;
        }
    	public void add(IEntity value) {
        	if (lastEntity == null)
        		throw new IllegalStateException();

    		IEntity parentEntity = lastEntity.wGetParent();
    		parentEntity.wAdd(parentEntity.wIndexOf(lastEntity), value);        
    	}
    	public void remove() {
        	if (lastEntity == null)
        		throw new IllegalStateException();

        	lastEntity.wGetParent().wRemove(lastEntity);
        	lastEntity = null;
    	}
    }
}

