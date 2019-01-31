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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import org.junit.BeforeClass;
import org.junit.Test;
import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.IdentityCloneContext;
import org.whole.lang.reflect.ReflectionFactory;
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
		s0.withConsumer(c);

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
		addStepper.withConsumer(c);
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
		addStepper.withConsumer(c);
		addStepper.setBindings(bmf.createBindingManager());
		addStepper.reset(VALUES[0]);

		c.setExpectedValues(VALUES[3]);
    	c.setExpectedEvents(Event.NEXT);
    	addStepper.callNext();
		assertSame(StepperState.CALL, addStepper.getState());

		arg1Stepper.getArgumentConsumer(0).accept(VALUES[2]);
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
		addStepper.withConsumer(c);
		addStepper.setBindings(bmf.createBindingManager());
		addStepper.reset(VALUES[0]);
		
		c.setExpectedValues(VALUES[3]);
    	c.setExpectedEvents(Event.NEXT);

		ExecutorService executorService = Executors.newFixedThreadPool(2);
		Future<IEntity> nextEntity = executorService.submit(() -> {
			return addStepper.evaluateNext();
		});
		Future<?> dataInput = executorService.submit(() -> {
			arg1Stepper.getArgumentConsumer(0).accept(VALUES[2]);
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

		areaStepper.withConsumer(c);
		areaStepper.setBindings(bmf.createBindingManager());
		areaStepper.reset(VALUES[0]);

		c.setExpectedValues(VALUES[6]);
    	c.setExpectedEvents(Event.NEXT);

		ExecutorService executorService = Executors.newFixedThreadPool(3);
		Future<IEntity> nextEntity = executorService.submit(() -> {
			return areaStepper.evaluateNext();
		});
		Future<?> dataInput0 = executorService.submit(() -> {
			baseStepper.getConsumer().accept(VALUES[2]);
		});
		Future<?> dataInput1 = executorService.submit(() -> {
			heightStepper.getConsumer().accept(VALUES[3]);
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

		addStepper1.withConsumer(c);
		addStepper1.setBindings(bmf.createBindingManager());
		addStepper1.reset(VALUES[0]);

		c.setExpectedValues(VALUES[3]);
    	c.setExpectedEvents(Event.NEXT);
    	addStepper1.callNext();
		assertSame(StepperState.CALL, addStepper1.getState());

		arg1Stepper1.getArgumentConsumer(0).accept(VALUES[2]);
		assertSame(StepperState.ACTION, addStepper1.getState());
	}

	@Test
	public void testDataEntityStepper() {
		EntityContext ec = new EntityContext(VALUES[3]);
		AbstractStepper cg = ec.createConstantGetter();
		AbstractStepper vg = ec.createVariableGetter();
		AbstractStepper cs = ec.createConstantSetter();
		AbstractStepper vs = ec.createVariableSetter();

		assertSame(VALUES[3], cg.evaluateNext());
		assertSame(VALUES[3], vg.evaluateNext());
		
		vs.getArgumentConsumer(0).accept(VALUES[2]);
		assertSame(VALUES[2], vs.evaluateNext());

		assertSame(VALUES[2], vg.evaluateNext());
		assertSame(VALUES[3], cg.evaluateNext());
	}

	public abstract static class AbstractEntityStepper extends AbstractStepper {
		public EntityContext context;

		public AbstractEntityStepper(EntityContext context, int argumentsSize, IExecutable... producers) {
			super(argumentsSize);
			withProducers(producers);
			this.context = context;
		}

		@Override
		public IEntity doEvaluateNext() {
			return context.entity;
		}
	}
	
	public abstract static class AbstractEntityGetter extends AbstractEntityStepper {
		public AbstractEntityGetter(EntityContext context, IExecutable... producers) {
			super(context, 0, producers);
		}
	}
	public static class ConstantEntityGetter extends AbstractEntityGetter {
		public ConstantEntityGetter(EntityContext context, IExecutable... producers) {
			super(context, producers);
		}

	}
	public static class VariableEntityGetter extends AbstractEntityGetter {
		public VariableEntityGetter(EntityContext context, IExecutable... producers) {
			super(context, producers);
		}
	}

	public abstract static class AbstractEntitySetter extends AbstractEntityStepper {
		public AbstractEntitySetter(EntityContext context, IExecutable... producers) {
			super(context, 1, producers);
		}
	}
	public static class ConstantEntitySetter extends AbstractEntitySetter {
		public ConstantEntitySetter(EntityContext context, IExecutable... producers) {
			super(context, producers);
		}

		@Override
		public IEntity doEvaluateNext() {
			//TODO differentiate context before
			context.entity = getArgument(0);
			return context.entity;
		}
	}
	public static class VariableEntitySetter extends AbstractEntitySetter {
		public VariableEntitySetter(EntityContext context, IExecutable... producers) {
			super(context, producers);
		}

		@Override
		public IEntity doEvaluateNext() {
			return context.setEntity(getArgument(0));
		}
	}

	public static class EntityContext {
		protected IEntity entity;
		protected Set<AbstractEntityStepper> stepperSet = new HashSet<>();

		public EntityContext(IEntity entity) {
			this.entity = entity;
		}

		public IEntity setEntity(IEntity entity) {
			EntityContext oldContext = new EntityContext(this.entity);
			oldContext.stepperSet = new HashSet<>(stepperSet);
			stepperSet.forEach((stepper) -> {
				stepper.context = oldContext;
			});
			this.entity = entity;
			return entity;
		}

		public AbstractStepper createConstantGetter() {
			AbstractEntityStepper stepper = new ConstantEntityGetter(this);
			stepperSet.add(stepper);
			return stepper;
		}
		public AbstractStepper createConstantSetter() {
			AbstractEntityStepper stepper = new ConstantEntitySetter(this);
			stepperSet.add(stepper);
			return stepper;
		}
		public AbstractStepper createVariableGetter() {
			return new VariableEntityGetter(this);
		}
		public AbstractStepper createVariableSetter() {
			return new VariableEntitySetter(this);
		}
	}
}

