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
package org.whole.lang.reflect;

import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.whole.lang.testentities.reflect.TestEntitiesLanguageDeployer;
import org.whole.lang.testentities.reflect.TestEntitiesLanguageKit;
import org.whole.test.KnownFailingTests;

/**
 * @author Riccardo Solmi
 */
public class LanguageRequestHandlerTest {
	@Category(KnownFailingTests.class)
	@Test
	public void testAddLanguageRequestHandler() {
		ILanguageRequestHandler handler = ReflectionFactory.getLanguageRequestHandler();
		ReflectionFactory.addLanguageRequestHandler(handler);
		Assert.assertSame(handler, ReflectionFactory.getLanguageRequestHandler());

		ILanguageRequestHandler handler0 = new AbstractLanguageRequestHandler() {
			public int getPriority() {
				return 0;
			}
		};
		ILanguageRequestHandler handler0a = new AbstractLanguageRequestHandler() {
			public int getPriority() {
				return 0;
			}
		};
		ILanguageRequestHandler handler10 = new AbstractLanguageRequestHandler() {
			public int getPriority() {
				return 10;
			}
		};
		
		ReflectionFactory.addLanguageRequestHandler(handler0);
		Assert.assertSame(handler0, ReflectionFactory.getLanguageRequestHandler());

		ReflectionFactory.addLanguageRequestHandler(handler0a);
		Assert.assertSame(handler0, ReflectionFactory.getLanguageRequestHandler());

		ReflectionFactory.addLanguageRequestHandler(handler10);
		Assert.assertSame(handler10, ReflectionFactory.getLanguageRequestHandler());

		ReflectionFactory.addLanguageRequestHandler(handler0);
		Assert.assertSame(handler10, ReflectionFactory.getLanguageRequestHandler());

		ReflectionFactory.addLanguageRequestHandler(
				LoggerLanguageRequestHandler.instance());
		Assert.assertSame(LoggerLanguageRequestHandler.instance(), ReflectionFactory.getLanguageRequestHandler());
	}

	@Test
	public void testRemoveLanguageRequestHandler() {
		//TODO
	}

	@Test
	public void testDeployLanguage() {
		ILanguageRequestHandler fakeHandler = new AbstractLanguageRequestHandler() {
			public boolean deployLanguage(String languageURI) {
				return languageURI.equals("fakeLanguage") || super.deployLanguage(languageURI);
			}
		};
		ILanguageRequestHandler testHandler = new AbstractLanguageRequestHandler() {
			public boolean deployLanguage(String languageURI) {
				if (languageURI.equals(TestEntitiesLanguageKit.URI)) {
					ReflectionFactory.deploy(TestEntitiesLanguageDeployer.class);
					return true;
				} else
					return false;
			}
		};

		try {
			ReflectionFactory.getLanguageKit("notExistantURI");
			Assert.fail();
		} catch (IllegalArgumentException e) {
		}

		ReflectionFactory.addLanguageRequestHandler(fakeHandler);
		try {
			ReflectionFactory.getLanguageKit("fakeLanguage");
			Assert.fail();
		} catch (IllegalArgumentException e) {
		}

		ReflectionFactory.undeploy(TestEntitiesLanguageDeployer.class);
		ReflectionFactory.addLanguageRequestHandler(testHandler);
		Assert.assertNotNull(ReflectionFactory.getLanguageKit(TestEntitiesLanguageKit.URI));
		ReflectionFactory.removeLanguageRequestHandler(testHandler);

		ReflectionFactory.undeploy(TestEntitiesLanguageDeployer.class);
		ReflectionFactory.deploy(new LazyLanguageDeployer(
				new TestEntitiesLanguageDeployer(),
				"http://lang.whole.org/TestEntities",
				"TestEntities"));
		Assert.assertNotNull(ReflectionFactory.getLanguageKit("http://lang.whole.org/TestEntities"));
	}
}
