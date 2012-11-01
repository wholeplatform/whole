/**
 * Copyright 2004-2012 Riccardo Solmi. All rights reserved.
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
package org.whole.lang.events;

import junit.framework.TestCase;

import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.testevents.events.DerivedBehaviorFactory;
import org.whole.lang.testevents.factories.TestEventsEntityFactory;
import org.whole.lang.testevents.model.Labels;
import org.whole.lang.testevents.model.Rectangle;
import org.whole.lang.testevents.model.Shape;
import org.whole.lang.testevents.model.TestEvents;
import org.whole.lang.testevents.reflect.TestEventsLanguageDeployer;

/**
 * @author Riccardo Solmi
 */
public class DemandDrivenBehaviorTest extends TestCase {
	private TestEvents model;
	private Shape rootShape;
	private Rectangle rect;
	private Labels labels;

	protected void setUp() throws Exception {
		super.setUp();

        ReflectionFactory.deployWholePlatform();
        ReflectionFactory.deploy(TestEventsLanguageDeployer.class);

		TestEventsEntityFactory tef = TestEventsEntityFactory.instance;
		model = tef.createTestEvents();
        rootShape = tef.createCompositeShape(
        		rect = tef.createRectangle(),
        		labels = tef.createLabels());
        	
        model.setShape(rootShape);

		DerivedBehaviorFactory.deploy(model);
	}

	public void testDerivedFeatures() {
		labels.getSimple().wSetValue("aSimpleName");
		assertEquals(
				"aSimpleName.suffix",
				labels.getSimpleDerived().wStringValue());
		assertEquals(
				"prefix.aSimpleName.suffix",
				labels.getSimpleDerivedDerived().wStringValue());

		labels.getSimpleDerived().wSetValue("aDerivedName");
		assertEquals(
				"aDerivedName",
				labels.getSimpleDerived().wStringValue());

		labels.getSimpleDerived().wUnset();
		assertEquals(
				"aSimpleName.suffix",
				labels.getSimpleDerived().wStringValue());
	}

	public void testRederivedFeatures() {
		labels.getSimple().wSetValue("aSimpleName");
		assertEquals(
				"aSimpleName.suffix",
				labels.getSimpleDerived().wStringValue());

		labels.getSimple().wSetValue("anotherName");
		assertEquals(
				"anotherName.suffix",
				labels.getSimpleDerived().wStringValue());
	}

	//FIXME
	public void testSetDerivedFeatures() {
		labels.getSimple().wSetValue("aSimpleName");
		assertEquals(
				"aSimpleName.suffix",
				labels.getSimpleDerived().wStringValue());

		labels.getSimpleDerived().wSetValue("aDerivedName");
		assertEquals(
				"aDerivedName",
				labels.getSimpleDerived().wStringValue());

		labels.getSimple().wSetValue("anotherName");//FIXME also unset simpleDerived
		assertEquals(
				"aDerivedName",
				labels.getSimpleDerived().wStringValue());
	}

	public void testCircularDerivation() {
		rect.getBase().wSetValue(5);
		rect.getHeight().wSetValue(7);
		assertEquals(35, rect.getArea().wIntValue());
		assertEquals(24, rect.getPerimeter().wIntValue());		
	}
}
