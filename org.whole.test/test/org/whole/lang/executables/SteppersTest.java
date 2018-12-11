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

import static org.junit.Assert.assertSame;

import org.junit.BeforeClass;
import org.junit.Test;
import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.steppers.AbstractStepper;
import org.whole.lang.steppers.AbstractStepper.StepperState;
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

		c.clear();
		c.setExpectedValues(VALUES[3]);
    	c.setExpectedEvents(Event.NEXT);
    	addStepper.callNext();
		assertSame(StepperState.CALL, addStepper.getState());

		arg1Stepper.getArgumentConsumer(0).accept(VALUES[2]);
		assertSame(StepperState.ACTION, addStepper.getState());

//TODO run asynch
//		c.clear();
//		c.setExpectedValues(VALUES[3]);
//    	c.setExpectedEvents(Event.NEXT);
//    	addStepper.evaluateNext();
	}

}

