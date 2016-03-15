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
package org.whole.lang.visitors;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.whole.lang.codebase.ClasspathPersistenceProvider;
import org.whole.lang.codebase.IPersistenceProvider;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.PrettyPrinterOperation;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.util.NullOutputStream;
import org.whole.lang.util.StringUtils;
import org.whole.lang.xml.codebase.XmlSourcePersistenceKit;

/**
 * @author Enrico Persiani
 */
public class XmlPrettyPrinterPerformanceTest {
	private static IEntity xmlModel;

	@BeforeClass
	public static void setUp() throws Exception {
		ReflectionFactory.deployWholePlatform();

		String packagePath = StringUtils.packagePath(XmlPrettyPrinterPerformanceTest.class.getPackage().getName());
		IPersistenceProvider pp = new ClasspathPersistenceProvider(packagePath + "/content.xml");
		xmlModel = XmlSourcePersistenceKit.instance().readModel(pp);
	}

	@AfterClass
	public static void tearDown() {
		ReflectionFactory.undeployWholePlatform();
	}

	@Test
	public void testPerformance() {
		long millis = System.currentTimeMillis();
		for (int i=0; i<1000; i++)
			PrettyPrinterOperation.prettyPrint(xmlModel, NullOutputStream.instance());
		double elapsed = (System.currentTimeMillis() - millis) / 1000.0;
		System.out.printf("Elapsed %fs\n", elapsed);
	}
}
