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
import org.whole.gen.ArtifactsGeneratorTest;
import org.whole.lang.java.JavaImportExportTests;
import org.whole.lang.ui.image.ImagesGeneratorTest;

/**
 * Run as -> JUnit Plug-in Test in an Eclipse with the Whole Platform installed
 * 
 * To reduce execution time modify the generated launcher to run the test as an headless application:
 * 1. Run -> Debug...
 * 2. Select the generated launcher on the left tree pane
 * 3. Go to the Main tab on the right pane
 * 4. Under Program to Run select Run as application -> [No Application] - Headless Mode
 * 
 * Runs: 3
 * Errors: ?
 * Failures: ?
 *
 * @author Riccardo Solmi
 */
@RunWith(Suite.class)
@SuiteClasses( {
	ArtifactsGeneratorTest.class,
	JavaImportExportTests.class,
	ImagesGeneratorTest.class,
})
public class AllIDETests {
}
