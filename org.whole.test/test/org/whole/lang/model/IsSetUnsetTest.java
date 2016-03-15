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
package org.whole.lang.model;

import java.util.Date;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.whole.lang.events.DefaultValueFactory;
import org.whole.lang.factories.GenericEntityFactory;
import org.whole.lang.factories.IEntityFactory;
import org.whole.lang.factories.RegistryConfigurations;
import org.whole.lang.lifecycle.IHistoryManager;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.testentities.model.EnumTestEntityEnum;
import org.whole.lang.testentities.reflect.TestEntitiesEntityDescriptorEnum;
import org.whole.lang.testentities.reflect.TestEntitiesFeatureDescriptorEnum;
import org.whole.lang.testentities.reflect.TestEntitiesLanguageDeployer;
import org.whole.lang.util.EntityUtils;

/**
 * @author Riccardo Solmi
 */
public class IsSetUnsetTest {
	private IEntityFactory ef;
	private IEntity e;

    @BeforeClass
    public static void deployWholePlatform() {
    	ReflectionFactory.deployWholePlatform();
    }

    @Before
    public void setUp() {
		ReflectionFactory.deploy(TestEntitiesLanguageDeployer.class);
        ef = GenericEntityFactory.instance(RegistryConfigurations.RESOLVER);
	}

    @Test
    public void testSimpleEntity() {
		e = GenericEntityFactory.instance(RegistryConfigurations.DEFAULT).create(TestEntitiesEntityDescriptorEnum.SimpleTestEntity);
		testFeature(e, TestEntitiesFeatureDescriptorEnum.anyEntityValue, ef.create(TestEntitiesEntityDescriptorEnum.SimpleTestEntity));
		testFeature(e, TestEntitiesFeatureDescriptorEnum.structuralEntityValue, ef.create(TestEntitiesEntityDescriptorEnum.SimpleTestEntity));
		testFeature(e, TestEntitiesFeatureDescriptorEnum.compositeEntityValue, ef.create(TestEntitiesEntityDescriptorEnum.ListTestEntity,
				ef.create(TestEntitiesEntityDescriptorEnum.BooleanTestEntity, true)));
		testFeature(e, TestEntitiesFeatureDescriptorEnum.dataEntityValue, ef.create(TestEntitiesEntityDescriptorEnum.BooleanTestEntity));
		
		testFeature(e, TestEntitiesFeatureDescriptorEnum.booleanValue, ef.create(TestEntitiesEntityDescriptorEnum.BooleanTestEntity, true));
		testFeature(e, TestEntitiesFeatureDescriptorEnum.byteValue, ef.create(TestEntitiesEntityDescriptorEnum.ByteTestEntity, (byte) 1));
		testFeature(e, TestEntitiesFeatureDescriptorEnum.charValue, ef.create(TestEntitiesEntityDescriptorEnum.CharTestEntity, 'z'));
		testFeature(e, TestEntitiesFeatureDescriptorEnum.doubleValue, ef.create(TestEntitiesEntityDescriptorEnum.DoubleTestEntity, 1d));
		testFeature(e, TestEntitiesFeatureDescriptorEnum.floatValue, ef.create(TestEntitiesEntityDescriptorEnum.FloatTestEntity, 1f));
		testFeature(e, TestEntitiesFeatureDescriptorEnum.intValue, ef.create(TestEntitiesEntityDescriptorEnum.IntTestEntity, 1));
		testFeature(e, TestEntitiesFeatureDescriptorEnum.longValue, ef.create(TestEntitiesEntityDescriptorEnum.LongTestEntity, 1l));
		testFeature(e, TestEntitiesFeatureDescriptorEnum.shortValue, ef.create(TestEntitiesEntityDescriptorEnum.ShortTestEntity, (short) 1));
		testFeature(e, TestEntitiesFeatureDescriptorEnum.stringValue, ef.create(TestEntitiesEntityDescriptorEnum.StringTestEntity, "a"));
		testFeature(e, TestEntitiesFeatureDescriptorEnum.dateValue, ef.create(TestEntitiesEntityDescriptorEnum.DateTestEntity, new Date(1)));
		testFeature(e, TestEntitiesFeatureDescriptorEnum.enumValue, ef.create(TestEntitiesEntityDescriptorEnum.EnumTestEntity, EnumTestEntityEnum.one));
		testFeature(e, TestEntitiesFeatureDescriptorEnum.objectValue, ef.create(TestEntitiesEntityDescriptorEnum.ObjectTestEntity, new Object()));
	}
	private void testFeature(IEntity e, FeatureDescriptor feature, IEntity newValue) {
		assertFalse(e.wIsSet(feature));
		e.wSet(feature, newValue);
		assertTrue(e.wIsSet(feature));
		e.wUnset(feature);
		assertFalse(e.wIsSet(feature));		
		e.wSet(feature, newValue);
		assertTrue(e.wIsSet(feature));
	}
	
	// TODO ? unset = NullMemento
	private void testDataEntity(IEntity entity) {
		assertTrue(entity.wIsSet());
		try {
			entity.wUnset();
			fail();
		} catch(Exception e) {}
		assertTrue(entity.wIsSet());
		
	}
	@Test
    public void testDataEntity() {
		testDataEntity(ef.create(TestEntitiesEntityDescriptorEnum.BooleanTestEntity));
		testDataEntity(ef.create(TestEntitiesEntityDescriptorEnum.ByteTestEntity));
		testDataEntity(ef.create(TestEntitiesEntityDescriptorEnum.CharTestEntity));
		testDataEntity(ef.create(TestEntitiesEntityDescriptorEnum.DoubleTestEntity));
		testDataEntity(ef.create(TestEntitiesEntityDescriptorEnum.FloatTestEntity));
		testDataEntity(ef.create(TestEntitiesEntityDescriptorEnum.IntTestEntity));
		testDataEntity(ef.create(TestEntitiesEntityDescriptorEnum.LongTestEntity));
		testDataEntity(ef.create(TestEntitiesEntityDescriptorEnum.ShortTestEntity));
		testDataEntity(ef.create(TestEntitiesEntityDescriptorEnum.StringTestEntity));
		testDataEntity(ef.create(TestEntitiesEntityDescriptorEnum.DateTestEntity));
		testDataEntity(ef.create(TestEntitiesEntityDescriptorEnum.EnumTestEntity));
		testDataEntity(ef.create(TestEntitiesEntityDescriptorEnum.ObjectTestEntity));
	}
	
	@Test
    public void testDataDefaultResolver() {
		IEntity e1, e2;

		e = GenericEntityFactory.instance(RegistryConfigurations.DEFAULT).create(TestEntitiesEntityDescriptorEnum.SimpleTestEntity);

		assertFalse(e.wIsSet(TestEntitiesFeatureDescriptorEnum.intValue));
		DefaultValueFactory.bindDefaultValueLazy(e, TestEntitiesFeatureDescriptorEnum.intValue,
				ef.create(TestEntitiesEntityDescriptorEnum.IntTestEntity, 5));
		assertTrue(e.wIsSet(TestEntitiesFeatureDescriptorEnum.intValue));
		e1 = e.wGet(TestEntitiesFeatureDescriptorEnum.intValue);
		assertEquals(5, e1.wIntValue());

		e1.wSetValue(3);
		assertEquals(3, e1.wIntValue());
		assertSame(e1, e.wGet(TestEntitiesFeatureDescriptorEnum.intValue));

		e.wSet(TestEntitiesFeatureDescriptorEnum.intValue,
				e2 = ef.create(TestEntitiesEntityDescriptorEnum.IntTestEntity, 4));
		assertSame(e2, e.wGet(TestEntitiesFeatureDescriptorEnum.intValue));

		e.wUnset(TestEntitiesFeatureDescriptorEnum.intValue);
		assertTrue(e.wIsSet(TestEntitiesFeatureDescriptorEnum.intValue));
		e2 = e.wGet(TestEntitiesFeatureDescriptorEnum.intValue);
		assertEquals(5, e2.wIntValue());
		assertNotSame(e1, e2);

		e.wRemove(TestEntitiesFeatureDescriptorEnum.intValue);
		assertTrue(e.wIsSet(TestEntitiesFeatureDescriptorEnum.intValue));
		e2 = e.wGet(TestEntitiesFeatureDescriptorEnum.intValue);
		assertTrue(EntityUtils.isResolver(e2));
	}

	@Test
    public void testUndoRedo() {
		e = ef.create(TestEntitiesEntityDescriptorEnum.SimpleTestEntity);
		IHistoryManager history = ReflectionFactory.getHistoryManager(e);
		history.setHistoryEnabled(true);

		FeatureDescriptor feature = TestEntitiesFeatureDescriptorEnum.anyEntityValue;
		IEntity newValue = ef.create(TestEntitiesEntityDescriptorEnum.SimpleTestEntity);
		e.wSet(feature, newValue);
		assertTrue(e.wIsSet(feature));
		history.undo();
		assertFalse(e.wIsSet(feature));		
		history.redo();
		assertTrue(e.wIsSet(feature));
	}
	
	@Test
    public void testClone() {
		e = GenericEntityFactory.instance(RegistryConfigurations.DEFAULT).create(TestEntitiesEntityDescriptorEnum.SimpleTestEntity);
		IEntity e1 = EntityUtils.clone(e);
		assertFalse(e1.wIsSet(TestEntitiesFeatureDescriptorEnum.anyEntityValue));		
		assertFalse(e1.wIsSet(TestEntitiesFeatureDescriptorEnum.structuralEntityValue));		
		assertFalse(e1.wIsSet(TestEntitiesFeatureDescriptorEnum.compositeEntityValue));		
		assertFalse(e1.wIsSet(TestEntitiesFeatureDescriptorEnum.dataEntityValue));		
		assertFalse(e1.wIsSet(TestEntitiesFeatureDescriptorEnum.booleanValue));		
		assertFalse(e1.wIsSet(TestEntitiesFeatureDescriptorEnum.byteValue));		
		assertFalse(e1.wIsSet(TestEntitiesFeatureDescriptorEnum.charValue));		
		assertFalse(e1.wIsSet(TestEntitiesFeatureDescriptorEnum.doubleValue));		
		assertFalse(e1.wIsSet(TestEntitiesFeatureDescriptorEnum.floatValue));		
		assertFalse(e1.wIsSet(TestEntitiesFeatureDescriptorEnum.intValue));		
		assertFalse(e1.wIsSet(TestEntitiesFeatureDescriptorEnum.longValue));		
		assertFalse(e1.wIsSet(TestEntitiesFeatureDescriptorEnum.shortValue));		
		assertFalse(e1.wIsSet(TestEntitiesFeatureDescriptorEnum.stringValue));		
		assertFalse(e1.wIsSet(TestEntitiesFeatureDescriptorEnum.dateValue));		
		assertFalse(e1.wIsSet(TestEntitiesFeatureDescriptorEnum.enumValue));		
		assertFalse(e1.wIsSet(TestEntitiesFeatureDescriptorEnum.objectValue));		
		
		e.wSet(TestEntitiesFeatureDescriptorEnum.anyEntityValue, ef.create(TestEntitiesEntityDescriptorEnum.SimpleTestEntity));
		e.wSet(TestEntitiesFeatureDescriptorEnum.structuralEntityValue, ef.create(TestEntitiesEntityDescriptorEnum.SimpleTestEntity));
		e.wSet(TestEntitiesFeatureDescriptorEnum.compositeEntityValue, ef.create(TestEntitiesEntityDescriptorEnum.ListTestEntity,
				ef.create(TestEntitiesEntityDescriptorEnum.BooleanTestEntity, true)));
		e.wSet(TestEntitiesFeatureDescriptorEnum.dataEntityValue, ef.create(TestEntitiesEntityDescriptorEnum.BooleanTestEntity));
		e.wSet(TestEntitiesFeatureDescriptorEnum.booleanValue, ef.create(TestEntitiesEntityDescriptorEnum.BooleanTestEntity, true));
		e.wSet(TestEntitiesFeatureDescriptorEnum.byteValue, ef.create(TestEntitiesEntityDescriptorEnum.ByteTestEntity, (byte) 1));
		e.wSet(TestEntitiesFeatureDescriptorEnum.charValue, ef.create(TestEntitiesEntityDescriptorEnum.CharTestEntity, 'z'));
		e.wSet(TestEntitiesFeatureDescriptorEnum.doubleValue, ef.create(TestEntitiesEntityDescriptorEnum.DoubleTestEntity, 1d));
		e.wSet(TestEntitiesFeatureDescriptorEnum.floatValue, ef.create(TestEntitiesEntityDescriptorEnum.FloatTestEntity, 1f));
		e.wSet(TestEntitiesFeatureDescriptorEnum.intValue, ef.create(TestEntitiesEntityDescriptorEnum.IntTestEntity, 1));
		e.wSet(TestEntitiesFeatureDescriptorEnum.longValue, ef.create(TestEntitiesEntityDescriptorEnum.LongTestEntity, 1l));
		e.wSet(TestEntitiesFeatureDescriptorEnum.shortValue, ef.create(TestEntitiesEntityDescriptorEnum.ShortTestEntity, (short) 1));
		e.wSet(TestEntitiesFeatureDescriptorEnum.stringValue, ef.create(TestEntitiesEntityDescriptorEnum.StringTestEntity, "a"));
		e.wSet(TestEntitiesFeatureDescriptorEnum.dateValue, ef.create(TestEntitiesEntityDescriptorEnum.DateTestEntity, new Date(1)));
		e.wSet(TestEntitiesFeatureDescriptorEnum.enumValue, ef.create(TestEntitiesEntityDescriptorEnum.EnumTestEntity, EnumTestEntityEnum.one));
		e.wSet(TestEntitiesFeatureDescriptorEnum.objectValue, ef.create(TestEntitiesEntityDescriptorEnum.ObjectTestEntity, new Object()));

		e1 = EntityUtils.clone(e);
		assertTrue(e1.wIsSet(TestEntitiesFeatureDescriptorEnum.anyEntityValue));		
		assertTrue(e1.wIsSet(TestEntitiesFeatureDescriptorEnum.structuralEntityValue));		
		assertTrue(e1.wIsSet(TestEntitiesFeatureDescriptorEnum.compositeEntityValue));		
		assertTrue(e1.wIsSet(TestEntitiesFeatureDescriptorEnum.dataEntityValue));		
		assertTrue(e1.wIsSet(TestEntitiesFeatureDescriptorEnum.booleanValue));		
		assertTrue(e1.wIsSet(TestEntitiesFeatureDescriptorEnum.byteValue));		
		assertTrue(e1.wIsSet(TestEntitiesFeatureDescriptorEnum.charValue));		
		assertTrue(e1.wIsSet(TestEntitiesFeatureDescriptorEnum.doubleValue));		
		assertTrue(e1.wIsSet(TestEntitiesFeatureDescriptorEnum.floatValue));		
		assertTrue(e1.wIsSet(TestEntitiesFeatureDescriptorEnum.intValue));		
		assertTrue(e1.wIsSet(TestEntitiesFeatureDescriptorEnum.longValue));		
		assertTrue(e1.wIsSet(TestEntitiesFeatureDescriptorEnum.shortValue));		
		assertTrue(e1.wIsSet(TestEntitiesFeatureDescriptorEnum.stringValue));		
		assertTrue(e1.wIsSet(TestEntitiesFeatureDescriptorEnum.dateValue));		
		assertTrue(e1.wIsSet(TestEntitiesFeatureDescriptorEnum.enumValue));		
		assertTrue(e1.wIsSet(TestEntitiesFeatureDescriptorEnum.objectValue));		
	}
}
