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
package org.whole.lang.events;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.whole.lang.factories.RegistryConfigurations;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.testevents.events.DerivedBehaviorFactory;
import org.whole.lang.testevents.factories.TestEventsEntityFactory;
import org.whole.lang.testevents.model.Labels;
import org.whole.lang.testevents.model.Rectangle;
import org.whole.lang.testevents.model.Shape;
import org.whole.lang.testevents.model.TestEvents;
import org.whole.lang.testevents.reflect.TestEventsFeatureDescriptorEnum;
import org.whole.lang.testevents.reflect.TestEventsLanguageDeployer;
import org.whole.test.KnownFailingTests;

/**
 * @author Riccardo Solmi
 */
public class DemandDrivenBehaviorTest {
	private TestEvents model;
	private Shape rootShape;
	private Rectangle rect;
	private Labels labels;

    @BeforeClass
    public static void deployWholePlatform() {
    	ReflectionFactory.deployWholePlatform();
        ReflectionFactory.deploy(TestEventsLanguageDeployer.class);
//        ReflectionFactory.deploy(DerivedBehaviorFactory.class);
    }

	@Before
    public void setUp() {
		TestEventsEntityFactory tef = TestEventsEntityFactory.instance;
		TestEventsEntityFactory tef2 = TestEventsEntityFactory.instance(RegistryConfigurations.RESOLVER);
		
		model = tef.createTestEvents();
        rootShape = tef.createCompositeShape(
        		rect = tef2.createRectangle(),
        		labels = tef2.createLabels());
        	
        model.setShape(rootShape);

		DerivedBehaviorFactory.deploy(model);
	}

	@Test
	public void testDerivedFeatures() {
		TestEventsEntityFactory tef = TestEventsEntityFactory.instance;

		labels.setSimple(tef.createLabel("aSimpleName"));
		Assert.assertEquals(
				"aSimpleName.suffix",
				labels.getSimpleDerived().wStringValue());
		Assert.assertEquals(
				"prefix.aSimpleName.suffix",
				labels.getSimpleDerivedDerived().wStringValue());

		labels.setSimpleDerived(tef.createLabel("aDerivedName"));
		Assert.assertEquals(
				"aDerivedName",
				labels.getSimpleDerived().wStringValue());

		labels.wRemove(TestEventsFeatureDescriptorEnum.simpleDerived);
		Assert.assertEquals(
				"aSimpleName.suffix",
				labels.getSimpleDerived().wStringValue());
	}

	@Test
	public void testRederivedFeatures() {
		TestEventsEntityFactory tef = TestEventsEntityFactory.instance;

		labels.setSimple(tef.createLabel("aSimpleName"));
		Assert.assertEquals(
				"aSimpleName.suffix",
				labels.getSimpleDerived().wStringValue());

		labels.setSimple(tef.createLabel("anotherName"));
		Assert.assertEquals(
				"anotherName.suffix",
				labels.getSimpleDerived().wStringValue());
	}

	@Category(KnownFailingTests.class)
	@Test
	public void testSetDerivedFeatures() {
		TestEventsEntityFactory tef = TestEventsEntityFactory.instance;

		labels.setSimple(tef.createLabel("aSimpleName"));
		Assert.assertEquals(
				"aSimpleName.suffix",
				labels.getSimpleDerived().wStringValue());

		labels.setSimpleDerived(tef.createLabel("aDerivedName"));
		Assert.assertEquals(
				"aDerivedName",
				labels.getSimpleDerived().wStringValue());

		//FIXME also unset simpleDerived
		labels.setSimple(tef.createLabel("anotherName"));
		Assert.assertEquals(
				"aDerivedName",
				labels.getSimpleDerived().wStringValue());
	}

	@Test
	public void testCircularDerivation() {
		TestEventsEntityFactory tef = TestEventsEntityFactory.instance;

		rect.setBase(tef.createVal(5));
		rect.setHeight(tef.createVal(7));
		Assert.assertEquals(35, rect.getArea().wIntValue());
		Assert.assertEquals(24, rect.getPerimeter().wIntValue());

		rect.wRemove(TestEventsFeatureDescriptorEnum.base);	
		Assert.assertEquals(5, rect.getBase().wIntValue());

		rect.wRemove(TestEventsFeatureDescriptorEnum.height);	
		Assert.assertEquals(7, rect.getHeight().wIntValue());

		rect.wRemove(TestEventsFeatureDescriptorEnum.area);	
		Assert.assertEquals(35, rect.getArea().wIntValue());

		rect.wRemove(TestEventsFeatureDescriptorEnum.perimeter);	
		Assert.assertEquals(24, rect.getPerimeter().wIntValue());

		rect.setPerimeter(tef.createVal(10));
		rect.setHeight(tef.createVal(2));
		rect.wRemove(TestEventsFeatureDescriptorEnum.base);	
		rect.wRemove(TestEventsFeatureDescriptorEnum.area);	
		Assert.assertEquals(6, rect.getArea().wIntValue());

		try {
			rect.wRemove(TestEventsFeatureDescriptorEnum.base);	
			rect.wRemove(TestEventsFeatureDescriptorEnum.height);	
			rect.wRemove(TestEventsFeatureDescriptorEnum.area);	
			rect.wRemove(TestEventsFeatureDescriptorEnum.perimeter);	
			rect.getBase();
		} catch (Exception e) {			
			return;
		}
		Assert.fail();
	}
}
