/**
 * Copyright 2004-2013 Riccardo Solmi. All rights reserved.
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
package org.whole.lang.tests;

import junit.framework.TestCase;

import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.iterators.IEntityIterator;
import org.whole.lang.iterators.IteratorFactory;
import org.whole.lang.java.reflect.JavaEntityDescriptorEnum;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.InterpreterOperation;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.tests.model.TestSuite;

/**
 * @author Enrico Persiani
 */
public class TestsInterpreterVisitorTest extends TestCase {
	@Override
	protected void setUp() throws Exception {
		ReflectionFactory.deployWholePlatform();
	}

	public void testInterpreter() throws Exception {
		TestSuite testSuite = new TestSuiteCompleted().create();
		assertTrue(InterpreterOperation.interpret(testSuite).getResult().wBooleanValue());
	}

	public void testLearningInterpreter() throws Exception {
		TestSuite testSuiteToComplete = new TestSuiteToComplete().create();
		TestSuite testSuiteCompleted = new TestSuiteCompleted().create();

		IBindingManager bm = BindingManagerFactory.instance.createArguments();
		bm.wDefValue("learnMode", true);
		bm.wDefValue("learnCycles", 2);
		assertTrue(InterpreterOperation.interpret(testSuiteToComplete, bm).getResult().wBooleanValue());

		// remove timestamps from both the models
		IEntityIterator<IEntity> iterator = IteratorFactory.descendantOrSelfMatcherIterator()
				.withPattern(JavaEntityDescriptorEnum.LongLiteral);
		iterator.reset(testSuiteToComplete);
		while (iterator.hasNext()) {
			iterator.next();
			iterator.remove();
		}
		iterator = IteratorFactory.descendantOrSelfMatcherIterator()
				.withPattern(JavaEntityDescriptorEnum.LongLiteral);
		iterator.reset(testSuiteCompleted);
		while (iterator.hasNext()) {
			iterator.next();
			iterator.remove();
		}

		assertTrue(Matcher.match(testSuiteCompleted, testSuiteToComplete));
	}
}
