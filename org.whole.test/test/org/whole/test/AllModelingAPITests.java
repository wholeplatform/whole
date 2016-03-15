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
import org.whole.lang.bindings.BindingManagerTest;
import org.whole.lang.bindings.JavaBeanBindingManagerTest;
import org.whole.lang.commands.HistoryInvariantsTest;
import org.whole.lang.events.DemandDrivenBehaviorTest;
import org.whole.lang.factories.FactoriesTest;
import org.whole.lang.lifecycle.LifecycleAPITest;
import org.whole.lang.model.AdaptersTest;
import org.whole.lang.model.AspectAPITest;
import org.whole.lang.model.ByChildAPITest;
import org.whole.lang.model.IsSetUnsetTest;
import org.whole.lang.model.ModelInvariantsTest;
import org.whole.lang.model.ResolversTest;
import org.whole.lang.reflect.DescriptorsTest;
import org.whole.lang.reflect.DynamicModelDefinitionTest;
import org.whole.lang.reflect.ReflectionFactoryTest;
import org.whole.lang.reflect.LanguageRequestHandlerTest;
import org.whole.lang.reflect.ReflectiveAPITest;

/**
 * Runs: 133
 * Errors: 2
 * Failures: 7
 *
 * @author Riccardo Solmi
 */
@RunWith(Suite.class)
@SuiteClasses( {
	ReflectiveAPITest.class,
	DescriptorsTest.class,
	DynamicModelDefinitionTest.class,
	ReflectionFactoryTest.class,
	LanguageRequestHandlerTest.class,
	ModelInvariantsTest.class,
	AdaptersTest.class,
	ResolversTest.class,
	AspectAPITest.class,
	ByChildAPITest.class,
	IsSetUnsetTest.class,
	FactoriesTest.class,
	HistoryInvariantsTest.class,
	DemandDrivenBehaviorTest.class,
	BindingManagerTest.class,
	JavaBeanBindingManagerTest.class,
	LifecycleAPITest.class
})
public class AllModelingAPITests {
}
