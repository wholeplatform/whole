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
package org.whole.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.whole.gen.JavaGeneratorTest;
import org.whole.gen.util.JDTUtilsTest;
import org.whole.lang.builders.GenericForwardSpecificBuilderTest;
import org.whole.lang.builders.ModelFragmentsBuilderTest;
import org.whole.lang.codebase.PersistenceTest;
import org.whole.lang.codebase.PushPullOperationsTest;
import org.whole.lang.iterators.IteratorFactoryTest;
import org.whole.lang.iterators.ScannerTest;
import org.whole.lang.java.JDTJavaSourcePersistenceTest;
import org.whole.lang.java.codebase.JavaClassTemplateFactoryTest;
import org.whole.lang.java.util.JavaReflectUtilsTest;
import org.whole.lang.json.JSONPersistencesTest;
import org.whole.lang.matchers.MatcherTest;
import org.whole.lang.matchers.tests.GenericMatcherTestSuite;
import org.whole.lang.operations.CloneModelOperationTest;
import org.whole.lang.operations.NormalizerOperationTest;
import org.whole.lang.operations.ResourceArtifactsGeneratorTest;
import org.whole.lang.templates.ResourceTemplateTest;
import org.whole.lang.util.DataTypeUtilsTest;
import org.whole.lang.util.StreamAdapterTest;
import org.whole.lang.util.StreamEncodingTest;
import org.whole.lang.util.StringUtilsTest;
import org.whole.lang.visitors.TraversalFactoryTest;

/**
 * Runs: 123
 * Errors: 1
 * Failures: 0
 * 
 * @author Riccardo Solmi
 */
@RunWith(Suite.class)
@SuiteClasses( {
	StreamAdapterTest.class,
	StreamEncodingTest.class,
	StringUtilsTest.class,
	DataTypeUtilsTest.class,
	JavaReflectUtilsTest.class,

	TraversalFactoryTest.class,
	ModelFragmentsBuilderTest.class,
	GenericForwardSpecificBuilderTest.class,
	CloneModelOperationTest.class,
	NormalizerOperationTest.class,
	MatcherTest.class,
	GenericMatcherTestSuite.class,
	IteratorFactoryTest.class,
	ScannerTest.class,
	ResourceTemplateTest.class,

	ResourceArtifactsGeneratorTest.class,
	JavaGeneratorTest.class,
	JavaClassTemplateFactoryTest.class,
	JDTUtilsTest.class,
	JDTJavaSourcePersistenceTest.class,
	PersistenceTest.class,
	JSONPersistencesTest.class,
	PushPullOperationsTest.class
})
public class AllBehaviorAPITests {
}
