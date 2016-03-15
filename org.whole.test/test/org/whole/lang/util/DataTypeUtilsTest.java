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
package org.whole.lang.util;

import static org.whole.lang.environment.reflect.EnvironmentEntityDescriptorEnum.BooleanData;
import static org.whole.lang.environment.reflect.EnvironmentEntityDescriptorEnum.ContainmentTuple;
import static org.whole.lang.environment.reflect.EnvironmentEntityDescriptorEnum.DoubleData;
import static org.whole.lang.environment.reflect.EnvironmentEntityDescriptorEnum.IntData;
import static org.whole.lang.environment.reflect.EnvironmentEntityDescriptorEnum.ObjectData;
import static org.whole.lang.environment.reflect.EnvironmentEntityDescriptorEnum.StringData;
import static org.whole.lang.models.reflect.ModelsEntityDescriptorEnum.Model;
import static org.whole.lang.models.reflect.ModelsEntityDescriptorEnum.ModelDeclaration;
import static org.whole.lang.util.DataTypeUtils.box;
import static org.whole.lang.util.DataTypeUtils.unbox;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.commons.model.Resolver;
import org.whole.lang.commons.reflect.CommonsEntityDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.models.factories.ModelsEntityFactory;
import org.whole.lang.models.model.IModelsEntity;
import org.whole.lang.models.model.Model;
import org.whole.lang.models.reflect.ModelsTemplateManager;
import org.whole.lang.parsers.DataTypeParsers;
import org.whole.lang.parsers.IDataTypeParser;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.testentities.factories.TestEntitiesEntityFactory;
import org.whole.lang.testentities.model.EnumTestEntityEnum;
import org.whole.lang.testentities.reflect.TestEntitiesEntityDescriptorEnum;
import org.whole.lang.testentities.reflect.TestEntitiesLanguageDeployer;

/**
 * @author Riccardo Solmi
 */
public class DataTypeUtilsTest {
    @BeforeClass
    public static void deployWholePlatform() {
    	ReflectionFactory.deployWholePlatform();
		ReflectionFactory.deploy(TestEntitiesLanguageDeployer.class);
	}

	private void assertGenericParseUnparseRoundtrip(IEntity e, String value) {
		EntityDescriptor<?> ed = e.wGetEntityDescriptor();
		IDataTypeParser parser = DataTypeUtils.getDataTypeParser(ed, DataTypeParsers.PERSISTENCE);
		assertEquals(value, parser.unparse(ed, parser.parse(ed, value)));
	}
	
	@Test
	public void testNonDataEntityFailure() {
		TestEntitiesEntityFactory ef = TestEntitiesEntityFactory.instance;
		IEntity e = ef.createSimpleTestEntity();
		
		try {
			DataTypeUtils.getAsString(e, null); //any DataTypeParsers
			fail();
		} catch (IllegalArgumentException iae) {
		}

		try {
			DataTypeUtils.setFromString(e, "any", null); //any DataTypeParsers
			fail();
		} catch (IllegalArgumentException iae) {
		}
		
		try {
			DataTypeUtils.createFromPresentationString(
					TestEntitiesEntityDescriptorEnum.SimpleTestEntity,
					"any");
			fail();
		} catch (IllegalArgumentException iae) {
		}
	}

	@Test
	public void testBooleanData() {
		TestEntitiesEntityFactory ef = TestEntitiesEntityFactory.instance;
		IEntity e = ef.createBooleanTestEntity(true);

		assertGenericParseUnparseRoundtrip(e, "false");
		
		assertEquals("true", DataTypeUtils.getAsPresentationString(e));
		assertEquals("true", DataTypeUtils.getAsPersistenceString(e));
		
		DataTypeUtils.setFromPresentationString(e, "FALSE");
		assertFalse(e.wBooleanValue());
		DataTypeUtils.setFromPersistenceString(e, "True");
		assertTrue(e.wBooleanValue());

		e = DataTypeUtils.createFromPresentationString(
				TestEntitiesEntityDescriptorEnum.BooleanTestEntity,
				"true");
		assertTrue(e.wBooleanValue());
		e = DataTypeUtils.createFromPersistenceString(
				TestEntitiesEntityDescriptorEnum.BooleanTestEntity,
				"true");
		assertTrue(e.wBooleanValue());
		
		final EntityDescriptor<?> ed = e.wGetEntityDescriptor();
		IDataTypeParser parser = DataTypeUtils.getDataTypeParser(ed, DataTypeParsers.PRESENTATION);
		try {
			parser.parseBoolean(ed, "string");
			fail();
		} catch (IllegalArgumentException iae) {
		}
		try {
			parser.parseBoolean(ed, "0");
			fail();
		} catch (IllegalArgumentException iae) {
		}
	}

	@Test
	public void testByteData() {
		TestEntitiesEntityFactory ef = TestEntitiesEntityFactory.instance;
		IEntity e = ef.createByteTestEntity((byte) 27);

		assertGenericParseUnparseRoundtrip(e, "32");

		assertEquals("27", DataTypeUtils.getAsPresentationString(e));
		assertEquals("27", DataTypeUtils.getAsPersistenceString(e));
		
		DataTypeUtils.setFromPresentationString(e, "35");
		assertEquals((byte) 35, e.wByteValue());
		DataTypeUtils.setFromPersistenceString(e, "56");
		assertEquals((byte) 56, e.wByteValue());

		DataTypeUtils.setFromPresentationString(e, String.valueOf(Byte.MIN_VALUE));
		assertEquals(Byte.MIN_VALUE, e.wByteValue());
		DataTypeUtils.setFromPresentationString(e, String.valueOf(Byte.MAX_VALUE));
		assertEquals(Byte.MAX_VALUE, e.wByteValue());

		e = DataTypeUtils.createFromPresentationString(
				TestEntitiesEntityDescriptorEnum.ByteTestEntity,
				"18");
		assertEquals((byte) 18, e.wByteValue());
		e = DataTypeUtils.createFromPersistenceString(
				TestEntitiesEntityDescriptorEnum.ByteTestEntity,
				"76");
		assertEquals((byte) 76, e.wByteValue());
		
		final EntityDescriptor<?> ed = e.wGetEntityDescriptor();
		IDataTypeParser parser = DataTypeUtils.getDataTypeParser(ed, DataTypeParsers.PRESENTATION);
		try {
			parser.parseByte(ed, "string");
			fail();
		} catch (IllegalArgumentException iae) {
		}
		try {
			parser.parseByte(ed, "200");
			fail();
		} catch (IllegalArgumentException iae) {
		}
		try {
			parser.parseByte(ed, "2.5f");
			fail();
		} catch (IllegalArgumentException iae) {
		}
	}

	@Test
	public void testCharData() {
		TestEntitiesEntityFactory ef = TestEntitiesEntityFactory.instance;
		IEntity e = ef.createCharTestEntity('a');

		assertGenericParseUnparseRoundtrip(e, "x");

		assertEquals("a", DataTypeUtils.getAsPresentationString(e));
		assertEquals("a", DataTypeUtils.getAsPersistenceString(e));
		
		DataTypeUtils.setFromPresentationString(e, "b");
		assertEquals('b', e.wCharValue());
		DataTypeUtils.setFromPersistenceString(e, "c");
		assertEquals('c', e.wCharValue());

		DataTypeUtils.setFromPresentationString(e, String.valueOf(Character.MIN_VALUE));
		assertEquals(Character.MIN_VALUE, e.wCharValue());
		DataTypeUtils.setFromPresentationString(e, String.valueOf(Character.MAX_VALUE));
		assertEquals(Character.MAX_VALUE, e.wCharValue());

		e = DataTypeUtils.createFromPresentationString(
				TestEntitiesEntityDescriptorEnum.CharTestEntity,
				"d");
		assertEquals('d', e.wCharValue());
		e = DataTypeUtils.createFromPersistenceString(
				TestEntitiesEntityDescriptorEnum.CharTestEntity,
				"e");
		assertEquals('e', e.wCharValue());
		
		final EntityDescriptor<?> ed = e.wGetEntityDescriptor();
		IDataTypeParser parser = DataTypeUtils.getDataTypeParser(ed, DataTypeParsers.PRESENTATION);
		try {
			parser.parseChar(ed, "string");
			fail();
		} catch (IllegalArgumentException iae) {
		}
		try {
			parser.parseChar(ed, "200");
			fail();
		} catch (IllegalArgumentException iae) {
		}
	}

	@Test
	public void testDoubleData() {
		TestEntitiesEntityFactory ef = TestEntitiesEntityFactory.instance;
		IEntity e = ef.createDoubleTestEntity(1.2d);

		assertGenericParseUnparseRoundtrip(e, "54.35");

		assertEquals("1.2", DataTypeUtils.getAsPresentationString(e));
		assertEquals("1.2", DataTypeUtils.getAsPersistenceString(e));
		
		DataTypeUtils.setFromPresentationString(e, "12.3d");
		assertEquals(12.3d, e.wDoubleValue(), .01d);
		DataTypeUtils.setFromPresentationString(e, "37.32");
		assertEquals(37.32d, e.wDoubleValue(), .01d);
		DataTypeUtils.setFromPersistenceString(e, "23.4d");
		assertEquals(23.4d, e.wDoubleValue(), .01d);

		DataTypeUtils.setFromPresentationString(e, "200");
		assertEquals(200d, e.wDoubleValue(), .01d);
		DataTypeUtils.setFromPresentationString(e, "2.5f");
		assertEquals(2.5d, e.wDoubleValue(), .01d);
		DataTypeUtils.setFromPresentationString(e, String.valueOf(Double.NaN));
		assertEquals(Double.NaN, e.wDoubleValue(), .01d);
		DataTypeUtils.setFromPresentationString(e, String.valueOf(Double.NEGATIVE_INFINITY));
		assertEquals(Double.NEGATIVE_INFINITY, e.wDoubleValue(), .01d);
		DataTypeUtils.setFromPresentationString(e, String.valueOf(Double.POSITIVE_INFINITY));
		assertEquals(Double.POSITIVE_INFINITY, e.wDoubleValue(), .01d);
		DataTypeUtils.setFromPresentationString(e, String.valueOf(Double.MIN_VALUE));
		assertEquals(Double.MIN_VALUE, e.wDoubleValue(), .01d);
		DataTypeUtils.setFromPresentationString(e, String.valueOf(Double.MAX_VALUE));
		assertEquals(Double.MAX_VALUE, e.wDoubleValue(), .01d);

		e = DataTypeUtils.createFromPresentationString(
				TestEntitiesEntityDescriptorEnum.DoubleTestEntity,
				"12.3d");
		assertEquals(12.3d, e.wDoubleValue(), .01d);
		e = DataTypeUtils.createFromPersistenceString(
				TestEntitiesEntityDescriptorEnum.DoubleTestEntity,
				"23.4d");
		assertEquals(23.4d, e.wDoubleValue(), .01d);
		
		final EntityDescriptor<?> ed = e.wGetEntityDescriptor();
		IDataTypeParser parser = DataTypeUtils.getDataTypeParser(ed, DataTypeParsers.PRESENTATION);
		try {
			parser.parseDouble(ed, "string");
			fail();
		} catch (IllegalArgumentException iae) {
		}
	}

	@Test
	public void testFloatData() {
		TestEntitiesEntityFactory ef = TestEntitiesEntityFactory.instance;
		IEntity e = ef.createFloatTestEntity(1.2f);

		assertGenericParseUnparseRoundtrip(e, "36.3");

		assertEquals("1.2", DataTypeUtils.getAsPresentationString(e));
		assertEquals("1.2", DataTypeUtils.getAsPersistenceString(e));
		
		DataTypeUtils.setFromPresentationString(e, "12.3f");
		assertEquals(12.3f, e.wFloatValue(), .01d);
		DataTypeUtils.setFromPresentationString(e, "37.32");
		assertEquals(37.32f, e.wFloatValue(), .01d);
		DataTypeUtils.setFromPersistenceString(e, "23.4f");
		assertEquals(23.4f, e.wFloatValue(), .01d);

		DataTypeUtils.setFromPresentationString(e, "200");
		assertEquals(200f, e.wFloatValue(), .01d);
		DataTypeUtils.setFromPresentationString(e, "2.5d");
		assertEquals(2.5f, e.wFloatValue(), .01d);
		DataTypeUtils.setFromPresentationString(e, String.valueOf(Float.NaN));
		assertEquals(Float.NaN, e.wFloatValue(), .01d);
		DataTypeUtils.setFromPresentationString(e, String.valueOf(Float.NEGATIVE_INFINITY));
		assertEquals(Float.NEGATIVE_INFINITY, e.wFloatValue(), .01d);
		DataTypeUtils.setFromPresentationString(e, String.valueOf(Float.POSITIVE_INFINITY));
		assertEquals(Float.POSITIVE_INFINITY, e.wFloatValue(), .01d);
		DataTypeUtils.setFromPresentationString(e, String.valueOf(Float.MIN_VALUE));
		assertEquals(Float.MIN_VALUE, e.wFloatValue(), .01d);
		DataTypeUtils.setFromPresentationString(e, String.valueOf(Float.MAX_VALUE));
		assertEquals(Float.MAX_VALUE, e.wFloatValue(), .01d);

		e = DataTypeUtils.createFromPresentationString(
				TestEntitiesEntityDescriptorEnum.FloatTestEntity,
				"12.3f");
		assertEquals(12.3f, e.wFloatValue(), .01d);
		e = DataTypeUtils.createFromPersistenceString(
				TestEntitiesEntityDescriptorEnum.FloatTestEntity,
				"23.4f");
		assertEquals(23.4f, e.wFloatValue(), .01d);
		
		final EntityDescriptor<?> ed = e.wGetEntityDescriptor();
		IDataTypeParser parser = DataTypeUtils.getDataTypeParser(ed, DataTypeParsers.PRESENTATION);
		try {
			parser.parseFloat(ed, "string");
			fail();
		} catch (IllegalArgumentException iae) {
		}
	}

	@Test
	public void testIntData() {
		TestEntitiesEntityFactory ef = TestEntitiesEntityFactory.instance;
		IEntity e = ef.createIntTestEntity(123);

		assertGenericParseUnparseRoundtrip(e, "4231");

		assertEquals("123", DataTypeUtils.getAsPresentationString(e));
		assertEquals("123", DataTypeUtils.getAsPersistenceString(e));
		
		DataTypeUtils.setFromPresentationString(e, "3324");
		assertEquals(3324, e.wIntValue());
		DataTypeUtils.setFromPersistenceString(e, "532");
		assertEquals(532, e.wIntValue());

		DataTypeUtils.setFromPresentationString(e, String.valueOf(Integer.MIN_VALUE));
		assertEquals(Integer.MIN_VALUE, e.wIntValue());
		DataTypeUtils.setFromPresentationString(e, String.valueOf(Integer.MAX_VALUE));
		assertEquals(Integer.MAX_VALUE, e.wIntValue());

		e = DataTypeUtils.createFromPresentationString(
				TestEntitiesEntityDescriptorEnum.IntTestEntity,
				"3324");
		assertEquals(3324, e.wIntValue());
		e = DataTypeUtils.createFromPersistenceString(
				TestEntitiesEntityDescriptorEnum.IntTestEntity,
				"983");
		assertEquals(983, e.wIntValue());
		
		final EntityDescriptor<?> ed = e.wGetEntityDescriptor();
		IDataTypeParser parser = DataTypeUtils.getDataTypeParser(ed, DataTypeParsers.PRESENTATION);
		try {
			parser.parseInt(ed, "string");
			fail();
		} catch (IllegalArgumentException iae) {
		}
		try {
			parser.parseInt(ed, "-3000000000");
			fail();
		} catch (IllegalArgumentException iae) {
		}
	}

	@Test
	public void testLongData() {
		TestEntitiesEntityFactory ef = TestEntitiesEntityFactory.instance;
		IEntity e = ef.createLongTestEntity(123l);

		assertGenericParseUnparseRoundtrip(e, "486432");

		assertEquals("123", DataTypeUtils.getAsPresentationString(e));
		assertEquals("123", DataTypeUtils.getAsPersistenceString(e));
		
		DataTypeUtils.setFromPresentationString(e, "3324");
		assertEquals(3324l, e.wLongValue());
		DataTypeUtils.setFromPersistenceString(e, "532");
		assertEquals(532l, e.wLongValue());

		DataTypeUtils.setFromPresentationString(e, String.valueOf(Long.MIN_VALUE));
		assertEquals(Long.MIN_VALUE, e.wLongValue());
		DataTypeUtils.setFromPresentationString(e, String.valueOf(Long.MAX_VALUE));
		assertEquals(Long.MAX_VALUE, e.wLongValue());

		e = DataTypeUtils.createFromPresentationString(
				TestEntitiesEntityDescriptorEnum.LongTestEntity,
				"3324");
		assertEquals(3324l, e.wLongValue());
		e = DataTypeUtils.createFromPersistenceString(
				TestEntitiesEntityDescriptorEnum.LongTestEntity,
				"983");
		assertEquals(983l, e.wLongValue());
		
		final EntityDescriptor<?> ed = e.wGetEntityDescriptor();
		IDataTypeParser parser = DataTypeUtils.getDataTypeParser(ed, DataTypeParsers.PRESENTATION);
		try {
			parser.parseLong(ed, "string");
			fail();
		} catch (IllegalArgumentException iae) {
		}
		try {
			parser.parseLong(ed, "2.0f");
			fail();
		} catch (IllegalArgumentException iae) {
		}
		try {
			parser.parseLong(ed, "-10000000000000000000");
			fail();
		} catch (IllegalArgumentException iae) {
		}
	}

	@Test
	public void testShortData() {
		TestEntitiesEntityFactory ef = TestEntitiesEntityFactory.instance;
		IEntity e = ef.createShortTestEntity((short) 123);

		assertGenericParseUnparseRoundtrip(e, "4132");

		assertEquals("123", DataTypeUtils.getAsPresentationString(e));
		assertEquals("123", DataTypeUtils.getAsPersistenceString(e));
		
		DataTypeUtils.setFromPresentationString(e, "123");
		assertEquals((short) 123, e.wShortValue());
		DataTypeUtils.setFromPersistenceString(e, "532");
		assertEquals((short) 532, e.wShortValue());

		DataTypeUtils.setFromPresentationString(e, String.valueOf(Short.MIN_VALUE));
		assertEquals(Short.MIN_VALUE, e.wShortValue());
		DataTypeUtils.setFromPresentationString(e, String.valueOf(Short.MAX_VALUE));
		assertEquals(Short.MAX_VALUE, e.wShortValue());

		e = DataTypeUtils.createFromPresentationString(
				TestEntitiesEntityDescriptorEnum.ShortTestEntity,
				"3324");
		assertEquals((short) 3324, e.wShortValue());
		e = DataTypeUtils.createFromPersistenceString(
				TestEntitiesEntityDescriptorEnum.ShortTestEntity,
				"983");
		assertEquals((short) 983, e.wShortValue());
		
		final EntityDescriptor<?> ed = e.wGetEntityDescriptor();
		IDataTypeParser parser = DataTypeUtils.getDataTypeParser(ed, DataTypeParsers.PRESENTATION);
		try {
			parser.parseShort(ed, "string");
			fail();
		} catch (IllegalArgumentException iae) {
		}
		try {
			parser.parseShort(ed, "-38000");
			fail();
		} catch (IllegalArgumentException iae) {
		}
	}

	@Test
	public void testStringData() {
		TestEntitiesEntityFactory ef = TestEntitiesEntityFactory.instance;
		IEntity e = ef.createStringTestEntity("abc");

		assertGenericParseUnparseRoundtrip(e, "blabla");

		assertEquals("abc", DataTypeUtils.getAsPresentationString(e));
		assertEquals("abc", DataTypeUtils.getAsPersistenceString(e));
		
		DataTypeUtils.setFromPresentationString(e, "def");
		assertEquals("def", e.wStringValue());
		DataTypeUtils.setFromPersistenceString(e, "ghi");
		assertEquals("ghi", e.wStringValue());

		e = DataTypeUtils.createFromPresentationString(
				TestEntitiesEntityDescriptorEnum.StringTestEntity,
				"def");
		assertEquals("def", e.wStringValue());
		e = DataTypeUtils.createFromPersistenceString(
				TestEntitiesEntityDescriptorEnum.StringTestEntity,
				"ghi");
		assertEquals("ghi", e.wStringValue());
	}

	@Test
	public void testDateData() {
		TestEntitiesEntityFactory ef = TestEntitiesEntityFactory.instance;
		Calendar c = Calendar.getInstance();
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		Date date = c.getTime();
		String eDate = DateFormat.getDateInstance(DateFormat.SHORT).format(date);
		String eDate2 = DateFormat.getDateInstance(DateFormat.LONG).format(date);
		String eDate3 = DateFormat.getDateInstance(DateFormat.MEDIUM).format(date);
		String pDate = StringUtils.toExtendedISO8601DateTime(date);

		IEntity e = ef.createDateTestEntity(date);

		assertGenericParseUnparseRoundtrip(e, pDate);

		assertEquals(eDate, DataTypeUtils.getAsPresentationString(e));
		assertEquals(pDate, DataTypeUtils.getAsPersistenceString(e));
		
		DataTypeUtils.setFromPresentationString(e, eDate2);
		assertEquals(date, e.wDateValue());
		DataTypeUtils.setFromPresentationString(e, eDate3);
		assertEquals(date, e.wDateValue());
		DataTypeUtils.setFromPresentationString(e, eDate);
		assertEquals(date, e.wDateValue());
		DataTypeUtils.setFromPersistenceString(e, pDate);
		assertEquals(date, e.wDateValue());

		e = DataTypeUtils.createFromPresentationString(
				TestEntitiesEntityDescriptorEnum.DateTestEntity,
				eDate);
		assertEquals(date, e.wDateValue());
		e = DataTypeUtils.createFromPersistenceString(
				TestEntitiesEntityDescriptorEnum.DateTestEntity,
				pDate);
		assertEquals(date, e.wDateValue());
		
		final EntityDescriptor<?> ed = e.wGetEntityDescriptor();
		IDataTypeParser parser = DataTypeUtils.getDataTypeParser(ed, DataTypeParsers.PRESENTATION);
		try {
			parser.parseDate(ed, "string");
			fail();
		} catch (IllegalArgumentException iae) {
		}
	}

	@Test
	public void testEnumData() {
		TestEntitiesEntityFactory ef = TestEntitiesEntityFactory.instance;
		IEntity e = ef.createEnumTestEntity(EnumTestEntityEnum.four);

		assertGenericParseUnparseRoundtrip(e, "three");

		assertEquals("four", DataTypeUtils.getAsPresentationString(e));
		assertEquals("four", DataTypeUtils.getAsPersistenceString(e));
		
		DataTypeUtils.setFromPresentationString(e, "One");
		assertEquals(EnumTestEntityEnum.one, e.wEnumValue());
		DataTypeUtils.setFromPersistenceString(e, "four");
		assertEquals(EnumTestEntityEnum.four, e.wEnumValue());

		e = DataTypeUtils.createFromPresentationString(
				TestEntitiesEntityDescriptorEnum.EnumTestEntity,
				"TWO");
		assertEquals(EnumTestEntityEnum.two, e.wEnumValue());
		e = DataTypeUtils.createFromPersistenceString(
				TestEntitiesEntityDescriptorEnum.EnumTestEntity,
				"five");
		assertEquals(EnumTestEntityEnum.five, e.wEnumValue());
		
		final EntityDescriptor<?> ed = e.wGetEntityDescriptor();
		IDataTypeParser parser = DataTypeUtils.getDataTypeParser(ed, DataTypeParsers.PRESENTATION);
		try {
			parser.parseEnumValue(ed, "string");
			fail();
		} catch (IllegalArgumentException iae) {
		}
	}

	@Test
	public void testNullBoxUnbox() throws Exception {
		assertNull(unbox(box(null, ObjectData), Object.class));
		assertNull(unbox(box(null, StringData), String.class));

		assertNotNull(unbox(box(null, CommonsEntityDescriptorEnum.Resolver), Resolver.class));
		assertNotNull(unbox(box(null, CommonsEntityDescriptorEnum.Any), List.class));

		assertNotNull(unbox(box(null, ContainmentTuple), List.class));
	}

	@Test
	public void testNullUnboxTpPrimitive() throws Exception {
		IEntity nullBoxed = box(null, IntData);
		try {
			unbox(nullBoxed, int.class);
			fail();
		} catch (IllegalArgumentException e) {
		}
	}

	@Test
	public void testDataBoxUnbox() throws Exception {
		assertEquals(10, unbox(box(10, IntData), int.class));
		assertEquals(10, ((Long) (unbox(box(10L, DoubleData), long.class))).intValue());
		assertEquals(true, unbox(box(true, BooleanData), Boolean.class));
		
		List<String> list = Collections.emptyList();
		assertEquals(list, unbox(box(list, ObjectData), Object.class));

		IEntity entity = ModelsTemplateManager.instance().create("Actions");
		assertEquals(entity, unbox(box(entity, ObjectData), IEntity.class));

		assertEquals(entity, unbox(box(entity, Model), Model.class));

		entity = ModelsEntityFactory.instance.createSimpleEntity();
		assertEquals(entity, unbox(box(entity, ModelDeclaration), IModelsEntity.class));
	}

	@Test
	public void testBoxToIncompatibleEntityType() throws Exception {
		try {
			box(true, DoubleData);
			fail();
		} catch (IllegalArgumentException e) {
		}

		try {
			box(Collections.<String>emptyList(), DoubleData);
			fail();
		} catch (IllegalArgumentException e) {
		}
		try {
			box(Collections.<String>emptyList(), Model);
			fail();
		} catch (IllegalArgumentException e) {
		}
		try {
			box(ModelsEntityFactory.instance.createSimpleEntity(), Model);
			fail();
		} catch (IllegalArgumentException e) {
		}
	}

	@Test
	public void testUnboxToIncompatibleDataType() throws Exception {
		try {
			unbox(BindingManagerFactory.instance.createValue(true), Double.class);
			fail();
		} catch (IllegalArgumentException e) {
		}
		try {
			unbox(BindingManagerFactory.instance.createValue(Collections.<String>emptyList()), Double.class);
			fail();
		} catch (IllegalArgumentException e) {
		}
		try {
			unbox(ModelsTemplateManager.instance().create("Actions"), Double.class);
			fail();
		} catch (IllegalArgumentException e) {
		}
		try {
			unbox(ModelsEntityFactory.instance.createSimpleEntity(), Model.class);
			fail();
		} catch (IllegalArgumentException e) {
		}
	}
}
