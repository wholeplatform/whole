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
package org.whole.lang.tests;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.executables.ExecutableFactory;
import org.whole.lang.executables.IExecutable;
import org.whole.lang.java.reflect.JavaEntityDescriptorEnum;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.InterpreterOperation;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.tests.model.TestSuite;
import org.whole.test.SlowTests;

/**
 * @author Enrico Persiani
 */
@Category(SlowTests.class)
public class TestsInterpreterVisitorTest {
 
	@BeforeClass
    public static void deployWholePlatform() {
    	ReflectionFactory.deployWholePlatform();
    }

	@Test
	public void testInterpreter() throws Exception {
		TestSuite testSuite = new TestSuiteCompleted().create();
		IEntity result = InterpreterOperation.interpret(testSuite).getResult();
		Assert.assertEquals(1, result.wGet(0).wIntValue());
		Assert.assertEquals(0, result.wGet(1).wIntValue());
		Assert.assertEquals(0, result.wGet(2).wIntValue());
	}

	@Test
	public void testLearningInterpreter() throws Exception {
		TestSuite testSuiteToComplete = new TestSuiteToComplete().create();
		TestSuite testSuiteCompleted = new TestSuiteCompleted().create();

		IBindingManager bm = BindingManagerFactory.instance.createArguments();
		bm.wDefValue("learnMode", true);
		bm.wDefValue("learnCycles", 2);
		IEntity result = InterpreterOperation.interpret(testSuiteToComplete, bm).getResult();
		Assert.assertEquals(1, result.wGet(0).wIntValue());
		Assert.assertEquals(0, result.wGet(1).wIntValue());
		Assert.assertEquals(0, result.wGet(2).wIntValue());

		result = InterpreterOperation.interpret(testSuiteCompleted).getResult();
		Assert.assertEquals(1, result.wGet(0).wIntValue());
		Assert.assertEquals(0, result.wGet(1).wIntValue());
		Assert.assertEquals(0, result.wGet(2).wIntValue());

		// remove timestamps from both the models
		ExecutableFactory f = ExecutableFactory.instance;
		IExecutable<IEntity> iterator = f.createFilter(f.createDescendantOrSelf(), f.createHasType(JavaEntityDescriptorEnum.LongLiteral.getURI()));
		iterator.reset(testSuiteToComplete);
		while (iterator.evaluateNext() != null)
			iterator.remove();

		iterator = f.createFilter(f.createDescendantOrSelf(), f.createHasType(JavaEntityDescriptorEnum.LongLiteral.getURI()));
		iterator.reset(testSuiteCompleted);
		while (iterator.evaluateNext() != null)
			iterator.remove();

		Assert.assertTrue(Matcher.match(testSuiteCompleted, testSuiteToComplete));
	}
}
