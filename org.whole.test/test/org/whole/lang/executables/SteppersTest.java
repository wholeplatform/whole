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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import org.junit.BeforeClass;
import org.junit.Test;
import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.CloneContext;
import org.whole.lang.operations.IdentityCloneContext;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.steppers.EntityGetter.EntityScope;
import org.whole.lang.steppers.AbstractStepper;
import org.whole.lang.steppers.AbstractStepper.StepperState;
import org.whole.lang.steppers.IDifferentiationContext;
import org.whole.lang.steppers.TesterDataFlowConsumer;
import org.whole.lang.steppers.TesterDataFlowConsumer.Event;

/**
 * @author Riccardo Solmi
 */
public class SteppersTest {
	protected static ExecutableFactory f;
	protected static BindingManagerFactory bmf;
	protected static IEntity[] VALUES;
	protected static IEntity TRUE_VALUE;
	protected static IEntity FALSE_VALUE;

	@BeforeClass
    public static void deployWholePlatform() {
    	ReflectionFactory.deployWholePlatform();

    	f = new RegularExecutableFactory();

    	bmf = BindingManagerFactory.instance;
    	VALUES = new IEntity[] {
    			bmf.createValue(0), bmf.createValue(1), bmf.createValue(2), bmf.createValue(3), bmf.createValue(4),
    			bmf.createValue(5), bmf.createValue(6), bmf.createValue(7), bmf.createValue(8), bmf.createValue(9)
    	};
    	TRUE_VALUE = bmf.createValue(true);
    	FALSE_VALUE = bmf.createValue(false);
    }

	public static class TesterStepper extends AbstractStepper {
		public TesterStepper(IExecutable... producers) {
			super(producers);
		}

		public IEntity doEvaluateNext() {
			return VALUES[0];
		}
	}


	@Test
	public void testStepperWithoutArguments() {
		TesterDataFlowConsumer c = new TesterDataFlowConsumer();
    	TesterStepper s0 = new TesterStepper();
		s0.addAction(c);

    	s0.setBindings(bmf.createBindingManager());
		s0.reset(VALUES[0]);
		
		assertSame(StepperState.IDLE, s0.getState());

		c.setExpectedEvents(Event.NEXT);
    	s0.callNext();
		assertSame(StepperState.ACTION, s0.getState());

		c.clear();
		c.setExpectedEvents(Event.NEXT);
		assertSame(VALUES[0], s0.evaluateNext());
	}

	@Test
	public void testStepperWithArguments() {
		TesterDataFlowConsumer c = new TesterDataFlowConsumer();
 		
		AbstractStepper arg0Stepper = new AbstractStepper() {
			public IEntity doEvaluateNext() {
				return VALUES[1];
			}
		};
		AbstractStepper arg1Stepper = new AbstractStepper() {
			public IEntity doEvaluateNext() {
				return VALUES[2];
			}
		};
		AbstractStepper addStepper = new AbstractStepper(arg0Stepper, arg1Stepper) {
			public IEntity doEvaluateNext() {
				return bmf.createValue(getArgument(0).wIntValue() + getArgument(1).wIntValue());
			}
		};
		addStepper.addAction(c);
		addStepper.setBindings(bmf.createBindingManager());
		addStepper.reset(VALUES[0]);

		c.setExpectedValues(VALUES[3]);
    	c.setExpectedEvents(Event.NEXT);
    	addStepper.callNext();
		assertSame(StepperState.ACTION, addStepper.getState());
	}

	@Test
	public void testStepperWithExternalInputArgument() {
		TesterDataFlowConsumer c = new TesterDataFlowConsumer();
 		
		AbstractStepper arg0Stepper = new AbstractStepper() {
			public IEntity doEvaluateNext() {
				return VALUES[1];
			}
		};
		AbstractStepper arg1Stepper = new AbstractStepper(1) {
			public IEntity doEvaluateNext() {
				return getArgument(0);
			}
		};
		AbstractStepper addStepper = new AbstractStepper(arg0Stepper, arg1Stepper) {
			public IEntity doEvaluateNext() {
				return bmf.createValue(getArgument(0).wIntValue() + getArgument(1).wIntValue());
			}
		};
		addStepper.addAction(c);
		addStepper.setBindings(bmf.createBindingManager());
		addStepper.reset(VALUES[0]);

		c.setExpectedValues(VALUES[3]);
    	c.setExpectedEvents(Event.NEXT);
    	addStepper.callNext();
		assertSame(StepperState.CALL, addStepper.getState());

		arg1Stepper.setArgument(0, VALUES[2]);
		assertSame(StepperState.ACTION, addStepper.getState());
	}

	@Test
	public void testStepperWithExternalInputArgumentAsync() {
		TesterDataFlowConsumer c = new TesterDataFlowConsumer();
 		
		AbstractStepper arg0Stepper = new AbstractStepper() {
			public IEntity doEvaluateNext() {
				return VALUES[1];
			}
		};
		AbstractStepper arg1Stepper = new AbstractStepper(1) {
			public IEntity doEvaluateNext() {
				return getArgument(0);
			}
		};
		AbstractStepper addStepper = new AbstractStepper(arg0Stepper, arg1Stepper) {
			public IEntity doEvaluateNext() {
				return bmf.createValue(getArgument(0).wIntValue() + getArgument(1).wIntValue());
			}
		};
		addStepper.addAction(c);
		addStepper.setBindings(bmf.createBindingManager());
		addStepper.reset(VALUES[0]);
		
		c.setExpectedValues(VALUES[3]);
    	c.setExpectedEvents(Event.NEXT);

		ExecutorService executorService = Executors.newFixedThreadPool(2);
		Future<IEntity> nextEntity = executorService.submit(() -> {
			return addStepper.evaluateNext();
		});
		Future<?> dataInput = executorService.submit(() -> {
			arg1Stepper.setArgument(0, VALUES[2]);
		});

		try {
			assertEquals(3, nextEntity.get().wIntValue());
			assertTrue(dataInput.isDone());
		} catch (InterruptedException | ExecutionException e) {
			fail();
		}

		executorService.shutdown();
		try {
		    if (!executorService.awaitTermination(800, TimeUnit.MILLISECONDS)) {
		        executorService.shutdownNow();
		    }
		} catch (InterruptedException e) {
		    executorService.shutdownNow();
		}
	}

	@Test
	public void testStepperWithCircularArgumentsAsync() {
		TesterDataFlowConsumer c = new TesterDataFlowConsumer();

		AbstractStepper baseStepper = new AbstractStepper(2) {
			public IEntity doEvaluateNext() {
				return bmf.createValue(getArgument(0).wIntValue() / getArgument(1).wIntValue());
			}
		};
		AbstractStepper heightStepper = new AbstractStepper(2) {
			public IEntity doEvaluateNext() {
				return bmf.createValue(getArgument(0).wIntValue() / getArgument(1).wIntValue());
			}
		};
		AbstractStepper areaStepper = new AbstractStepper(baseStepper, heightStepper) {
			public IEntity doEvaluateNext() {
				return bmf.createValue(getArgument(0).wIntValue() * getArgument(1).wIntValue());
			}
		};
		baseStepper.withArgumentProducers(areaStepper, heightStepper);
		heightStepper.withArgumentProducers(areaStepper, baseStepper);

		areaStepper.addAction(c);
		areaStepper.setBindings(bmf.createBindingManager());
		areaStepper.reset(VALUES[0]);

		c.setExpectedValues(VALUES[6]);
    	c.setExpectedEvents(Event.NEXT);

		ExecutorService executorService = Executors.newFixedThreadPool(3);
		Future<IEntity> nextEntity = executorService.submit(() -> {
			return areaStepper.evaluateNext();
		});
		Future<?> dataInput0 = executorService.submit(() -> {
			baseStepper.getAction().accept(VALUES[2]);
		});
		Future<?> dataInput1 = executorService.submit(() -> {
			heightStepper.getAction().accept(VALUES[3]);
		});

		try {
			assertEquals(6, nextEntity.get().wIntValue());
			assertTrue(dataInput0.isDone() && dataInput1.isDone());
		} catch (InterruptedException | ExecutionException e) {
			fail();
		}

		executorService.shutdown();
		try {
		    if (!executorService.awaitTermination(800, TimeUnit.MILLISECONDS)) {
		        executorService.shutdownNow();
		    }
		} catch (InterruptedException e) {
		    executorService.shutdownNow();
		}
	}

	@Test
	public void testCloneContextInit() {
		AbstractStepper arg0Stepper = new AbstractStepper() {
			public IEntity doEvaluateNext() {
				return VALUES[1];
			}
		};
		AbstractStepper arg1Stepper = new AbstractStepper(1) {
			public IEntity doEvaluateNext() {
				return getArgument(0);
			}
		};
		AbstractStepper addStepper = new AbstractStepper(arg0Stepper, arg1Stepper) {
			public IEntity doEvaluateNext() {
				return bmf.createValue(getArgument(0).wIntValue() + getArgument(1).wIntValue());
			}
		};

		assertNotSame(addStepper.getDifferentiationContext(), IdentityCloneContext.instance);
		assertSame(addStepper.getDifferentiationContext(), arg0Stepper.getDifferentiationContext());
		assertSame(addStepper.getDifferentiationContext(), arg1Stepper.getDifferentiationContext());
		//TODO arguments
	}

	@Test
	public void testCloneAndApplyFunctionWithArguments() {
		TesterDataFlowConsumer c = new TesterDataFlowConsumer();

		AbstractStepper arg0Stepper = new AbstractStepper() {
			public IEntity doEvaluateNext() {
				return VALUES[1];
			}
		};
		AbstractStepper arg1Stepper = new AbstractStepper(1) {
			public IEntity doEvaluateNext() {
				return getArgument(0);
			}
		};
		AbstractStepper addStepper = new AbstractStepper(arg0Stepper, arg1Stepper) {
			public IEntity doEvaluateNext() {
				return bmf.createValue(getArgument(0).wIntValue() + getArgument(1).wIntValue());
			}
		};

		AbstractStepper addStepper1 = (AbstractStepper) addStepper.clone();
		IDifferentiationContext dc = addStepper1.getDifferentiationContext();
		AbstractStepper arg1Stepper1 = dc.differentiate(arg1Stepper);
//		arg1Stepper1.getArgumentConsumer(0).accept(VALUES[2]);

		addStepper1.addAction(c);
		addStepper1.setBindings(bmf.createBindingManager());
		addStepper1.reset(VALUES[0]);

		c.setExpectedValues(VALUES[3]);
    	c.setExpectedEvents(Event.NEXT);
    	addStepper1.callNext();
		assertSame(StepperState.CALL, addStepper1.getState());

		arg1Stepper1.setArgument(0, VALUES[2]);
		assertSame(StepperState.ACTION, addStepper1.getState());
	}

	@Test
	public void testEntityStepper() {
		EntityScope ec = new EntityScope(VALUES[3]);
		AbstractStepper cg = ec.createConstantPassiveGetter();
		AbstractStepper vg = ec.createVariablePassiveGetter();
		AbstractStepper cs = ec.createConstantActiveGetter();
		AbstractStepper vs = ec.createVariableActiveGetter();

		ec.callNext();

		assertSame(VALUES[3], cg.evaluateNext());
		assertSame(VALUES[3], vg.evaluateNext());

		vs.setArgument(0, VALUES[2]);
		assertSame(VALUES[2], vs.evaluateNext());

		assertSame(VALUES[2], vg.evaluateNext());
		assertSame(VALUES[3], cg.evaluateNext());

		cs.setArgument(0, VALUES[4]);
		assertSame(VALUES[3], cs.evaluateNext());

		assertSame(VALUES[3], cg.evaluateNext());
		assertSame(VALUES[2], vg.evaluateNext());
		
		//TODO clone getter and setters and reapply the test
		
	}

	@Test
	public void testVariableScope() {
		EntityScope aScope = new EntityScope(VALUES[3]);
		AbstractStepper aGetter = aScope.createConstantPassiveGetter();
		AbstractStepper bAdder = new AbstractStepper(aGetter) {
			public IEntity doEvaluateNext() {
				return bmf.createValue(getArgument(0).wIntValue() + 1);
			}
		};
		EntityScope a1Scope = aScope.getNestedScope();
		a1Scope.setArgument(0, VALUES[5]);
		AbstractStepper a1Getter = a1Scope.createConstantPassiveGetter();
		AbstractStepper cAdder = new AbstractStepper(a1Getter) {
			public IEntity doEvaluateNext() {
				return bmf.createValue(getArgument(0).wIntValue() + 1);
			}
		};
		AbstractStepper aGetter2 = aScope.createConstantPassiveGetter();
		AbstractStepper eAdder = new AbstractStepper(aGetter2) {
			public IEntity doEvaluateNext() {
				return bmf.createValue(getArgument(0).wIntValue() + 1);
			}
		};

		AbstractStepper caller = new AbstractStepper(bAdder, cAdder, eAdder, aScope, a1Scope) {//FIXME scopes are not nested
			public IEntity doEvaluateNext() {
				return bmf.createTuple(getArgument(0), getArgument(1), getArgument(2));
			}
		};

		IEntity tuple = caller.evaluateNext();
		assertEquals(4, tuple.wGet(0).wIntValue());
		assertEquals(6, tuple.wGet(1).wIntValue());
		assertEquals(4, tuple.wGet(2).wIntValue());
	}

	@Test
	public void testStepperSequence() {
		TesterDataFlowConsumer c = new TesterDataFlowConsumer();

		AbstractStepper step0 = new AbstractStepper() {
			public IEntity doEvaluateNext() {
				return VALUES[0];
			}
		};
		AbstractStepper step1 = new AbstractStepper() {
			public IEntity doEvaluateNext() {
				return VALUES[1];
			}
		};
		step0.addAction(step1);

		step0.addAction(c);
		step1.addAction(c);

		c.setExpectedValues(VALUES[0], VALUES[1]);
		c.setExpectedEvents(Event.NEXT, Event.DONE, Event.NEXT, Event.DONE);
		step0.evaluateRemaining();
		c.checkExpectations();
	}

	@Test
	public void testSetter() {
		AbstractStepper setter = new AbstractStepper() {
			public IEntity doEvaluateNext() {
				return VALUES[0];
			}
		};

		EntityScope aScope = new EntityScope();
		AbstractStepper aGetter0 = aScope.createConstantActiveGetter();
		AbstractStepper aGetter1 = aScope.createConstantActiveGetter();
		aScope.addSetter(setter);
		AbstractStepper aGetter2 = aScope.createConstantActiveGetter();
//		aScope.addSetter(setter2);
//		AbstractStepper aGetter2 = aScope.createConstantActiveGetter();
		
		assertSame(VALUES[0], aGetter0.evaluateNext());
	}

	
	@Test
	public void testScopeSequence() {
		EntityScope aScope = new EntityScope();
		aScope.setArgument(0, VALUES[0]);
		AbstractStepper aSetter = aScope.createConstantActiveGetter();
		AbstractStepper aGetter = aScope.createConstantPassiveGetter();
		AbstractStepper bAdder = new AbstractStepper(aGetter) {
			public IEntity doEvaluateNext() {
				return bmf.createValue(getArgument(0).wIntValue() + 1);
			}
		};
//		EntityScopeStepper aNestedScope = aScope.getNestedScope();
//		aNestedScope.setArgument(0, VALUES[5]);
//		AbstractStepper a1Getter = aNestedScope.createConstantGetter();
//		AbstractStepper cAdder = new AbstractStepper(a1Getter) {
//			public IEntity doEvaluateNext() {
//				return bmf.createValue(getArgument(0).wIntValue() + 1);
//			}
//		};
//		AbstractStepper aGetter2 = aScope.createConstantGetter();
//		AbstractStepper eAdder = new AbstractStepper(aGetter2) {
//			public IEntity doEvaluateNext() {
//				return bmf.createValue(getArgument(0).wIntValue() + 1);
//			}
//		};

//		AbstractStepper caller = new AbstractStepper(bAdder, cAdder, eAdder, aSetter, aScope, aNestedScope) {
		AbstractStepper caller = new AbstractStepper(bAdder, aSetter, aScope) {
			public IEntity doEvaluateNext() {
				return bmf.createTuple(getArgument(0));//, getArgument(1), getArgument(2));
			}
		};
		aSetter.setArgument(0, VALUES[3]);

		IEntity tuple = caller.evaluateNext();
		assertEquals(1, tuple.wGet(0).wIntValue());
//		assertEquals(6, tuple.wGet(1).wIntValue());
//		assertEquals(1, tuple.wGet(2).wIntValue());

		IEntity tuple1 = ((CloneContext) caller.getDifferentiationContext()).getParentContext().getLastDifferentiationContext()
				.differentiate(caller).evaluateNext();
		assertEquals(4, tuple1.wGet(0).wIntValue());
//		assertEquals(6, tuple1.wGet(1).wIntValue());
//		assertEquals(4, tuple1.wGet(2).wIntValue());
	}

	@Test
	public void testDifferentiatingScope() {
		EntityScope aScope = new EntityScope();
		aScope.setArgument(0, VALUES[0]);
		AbstractStepper aSetter = aScope.createConstantActiveGetter();
		AbstractStepper aGetter = aScope.createConstantPassiveGetter();
		AbstractStepper bAdder = new AbstractStepper(aGetter) {
			public IEntity doEvaluateNext() {
				return bmf.createValue(getArgument(0).wIntValue() + 1);
			}
		};
//		EntityScopeStepper aNestedScope = aScope.getNestedScope();
//		aNestedScope.setArgument(0, VALUES[5]);
//		AbstractStepper a1Getter = aNestedScope.createConstantGetter();
//		AbstractStepper cAdder = new AbstractStepper(a1Getter) {
//			public IEntity doEvaluateNext() {
//				return bmf.createValue(getArgument(0).wIntValue() + 1);
//			}
//		};
//		AbstractStepper aGetter2 = aScope.createConstantGetter();
//		AbstractStepper eAdder = new AbstractStepper(aGetter2) {
//			public IEntity doEvaluateNext() {
//				return bmf.createValue(getArgument(0).wIntValue() + 1);
//			}
//		};

//		AbstractStepper caller = new AbstractStepper(bAdder, cAdder, eAdder, aSetter, aScope, aNestedScope) {
		AbstractStepper caller = new AbstractStepper(bAdder, aSetter, aScope) {
			public IEntity doEvaluateNext() {
				return bmf.createTuple(getArgument(0));//, getArgument(1), getArgument(2));
			}
		};
		aSetter.setArgument(0, VALUES[3]);

		IEntity tuple = caller.evaluateNext();
		assertEquals(1, tuple.wGet(0).wIntValue());
//		assertEquals(6, tuple.wGet(1).wIntValue());
//		assertEquals(1, tuple.wGet(2).wIntValue());

		IEntity tuple1 = ((CloneContext) caller.getDifferentiationContext()).getParentContext().getLastDifferentiationContext()
				.differentiate(caller).evaluateNext();
		assertEquals(4, tuple1.wGet(0).wIntValue());
//		assertEquals(6, tuple1.wGet(1).wIntValue());
//		assertEquals(4, tuple1.wGet(2).wIntValue());
	}
}

