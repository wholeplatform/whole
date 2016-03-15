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
package org.whole.lang.java;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.whole.lang.codebase.StreamPersistenceProvider;
import org.whole.lang.java.codebase.JDTJavaSourcePersistenceKit;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.ReflectionFactory;

/**
 *
 * @author Enrico Persiani
 */
public class JDTJavaSourcePersistenceTest {
    @BeforeClass
    public static void deployWholePlatform() {
    	ReflectionFactory.deployWholePlatform();
    }

    @Test
    public void testReadModel() throws Exception {
		IEntity fromSource = JDTJavaSourcePersistenceKit.instance().readModel(
				new StreamPersistenceProvider(getClass().getResourceAsStream("TestSuite.txt")));
		IEntity fromTemplate = new TestSuiteTemplate().create();
		Assert.assertTrue(Matcher.match(fromSource, fromTemplate));
	}
}
