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
package org.whole.lang.java.util;

import java.lang.reflect.Method;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.commons.factories.CommonsEntityAdapterFactory;
import org.whole.lang.models.model.IModelsEntity;
import org.whole.lang.operations.PrettyPrinterOperation;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.util.CompositeUtils;
import org.whole.lang.util.DataTypeUtils;

/**
 * @author Enrico Persiani
 */
public class JavaReflectUtilsTest {
    @BeforeClass
    public static void deployWholePlatform() {
    	ReflectionFactory.deployWholePlatform();
    }

    @Test
    public void testGetMethodDescriptor() throws Throwable {
		assertEquals("append(org.whole.lang.models.model.IModelsEntity)",
				JavaReflectUtils.getSignature(Sample.class.getMethod("append",
						new Class<?>[] { IModelsEntity.class })));

		assertEquals("append(java.lang.String)", JavaReflectUtils
				.getSignature(Sample.class.getMethod("append",
						new Class<?>[] { String.class })));

		assertEquals("append(java.lang.String...)", JavaReflectUtils
				.getSignature(Sample.class.getMethod("append",
						new Class<?>[] { String[].class })));

		assertEquals("append(long)", JavaReflectUtils.getSignature(Sample.class
				.getMethod("append", new Class<?>[] { long.class })));

		assertEquals("append(java.lang.Long)", JavaReflectUtils
				.getSignature(Sample.class.getMethod("append",
						new Class<?>[] { Long.class })));

		assertEquals(
				"append(java.lang.String, org.whole.lang.models.model.IModelsEntity...)",
				JavaReflectUtils.getSignature(Sample.class
						.getMethod("append", new Class<?>[] { String.class,
								IModelsEntity[].class })));

		assertEquals("stringAt(int)", JavaReflectUtils
				.getSignature(Sample.class.getMethod("stringAt",
						new Class<?>[] { int.class })));

		assertEquals("toString()", JavaReflectUtils
				.getSignature(Sample.class.getMethod("toString",
						new Class<?>[0])));

		assertEquals("toString(int, int)", JavaReflectUtils
				.getSignature(Sample.class.getMethod("toString",
						new Class<?>[] { int.class, int.class })));

		assertEquals("createSample(java.lang.String, org.whole.lang.models.model.IModelsEntity...)", 
				JavaReflectUtils.getSignature(Sample.class
						.getMethod("createSample", new Class<?>[] { String.class,
								IModelsEntity[].class })));
	}

    @Test
    public void testGetConstructorDescriptor() throws Throwable {
		assertEquals("Sample()",
				JavaReflectUtils.getSignature(Sample.class.getConstructor(
						new Class<?>[0])));

		assertEquals("Sample(java.lang.String, org.whole.lang.models.model.IModelsEntity...)",
				JavaReflectUtils.getSignature(Sample.class.getConstructor(
						new Class<?>[] { String.class, IModelsEntity[].class })));

		assertEquals("Sample(java.lang.String, java.lang.String...)", JavaReflectUtils
				.getSignature(Sample.class.getConstructor(
						new Class<?>[] { String.class, String[].class })));

		assertEquals("Sample(java.lang.String[])", JavaReflectUtils
				.getSignature(Sample.class.getConstructor(
						new Class<?>[] { String[].class })));

	}

    @Test
    public void testGetMethodUsingClassName() throws Throwable {
		ClassLoader cl = ReflectionFactory.getPlatformClassLoader();
		String className = Sample.class.getName();

		assertEquals(
				Sample.class.getMethod("append",
								new Class<?>[] { IModelsEntity.class }),
				JavaReflectUtils.getMethod(className, "append(org.whole.lang.models.model.IModelsEntity)", cl));

		assertEquals(
				Sample.class.getMethod("append",
						new Class<?>[] { String.class }),
				JavaReflectUtils.getMethod(className, "append(java.lang.String)", cl));

		assertEquals(
				Sample.class.getMethod("append",
						new Class<?>[] { String[].class }),
				JavaReflectUtils.getMethod(className, "append(java.lang.String...)", cl));

		assertEquals(
				Sample.class.getMethod("append", new Class<?>[] { long.class }),
				JavaReflectUtils.getMethod(className, "append(long)", cl));

		assertEquals(
				Sample.class.getMethod("append", new Class<?>[] { Long.class }),
				JavaReflectUtils.getMethod(className, "append(java.lang.Long)", cl));

		assertEquals(
				Sample.class.getMethod("append", new Class<?>[] { String.class,
						IModelsEntity[].class }),
				JavaReflectUtils.getMethod(className, "append(java.lang.String, org.whole.lang.models.model.IModelsEntity[])", cl));

		assertEquals(
				Sample.class.getMethod("stringAt", new Class<?>[] { int.class }),
				JavaReflectUtils.getMethod(className, "stringAt(int)", cl));

		assertEquals(
				Sample.class.getMethod("toString", new Class<?>[0]),
				JavaReflectUtils.getMethod(className, "toString()", cl));

		assertEquals(
				Sample.class.getMethod("toString",
						new Class<?>[] { int.class, int.class }),
				JavaReflectUtils.getMethod(className, "toString(int, int)", cl));

		assertEquals(
				Sample.class.getMethod("createSample", new Class<?>[] { String.class, IModelsEntity[].class }),
				JavaReflectUtils.getMethod(className, "createSample(java.lang.String, org.whole.lang.models.model.IModelsEntity[])", cl));
	}

    @Test
    public void testSignatureWithInnerClassName() throws Throwable {
		ClassLoader cl = ReflectionFactory.getPlatformClassLoader();
		String className = CommonsEntityAdapterFactory.class.getName();

		assertEquals(
				CommonsEntityAdapterFactory.class.getMethod("createVariable", new Class<?>[] { EntityDescriptor.class, String.class,
						EntityDescriptor.class, org.whole.lang.commons.model.QuantifierEnum.Value.class }),
				JavaReflectUtils.getMethod(className, "createVariable(org.whole.lang.reflect.EntityDescriptor, " +
						"java.lang.String, org.whole.lang.reflect.EntityDescriptor, " +
						"org.whole.lang.commons.model.QuantifierEnum.Value)", cl));
	}

    @Test
    public void testGetConstructorUsingClassName() throws Throwable {
		ClassLoader cl = ReflectionFactory.getPlatformClassLoader();
		String className = Sample.class.getName();

		assertEquals(
				Sample.class.getConstructor(new Class<?>[0]),
				JavaReflectUtils.getConstructor(className, "Sample()", cl));

		assertEquals(
				Sample.class.getConstructor(new Class<?>[] { String.class, IModelsEntity[].class }),
				JavaReflectUtils.getConstructor(className, "Sample(java.lang.String, org.whole.lang.models.model.IModelsEntity[])", cl));

		assertEquals(
				Sample.class.getConstructor(new Class<?>[] { String.class, String[].class }),
				JavaReflectUtils.getConstructor(className, "Sample(java.lang.String, java.lang.String[])", cl));

		assertEquals(
				Sample.class.getConstructor(new Class<?>[] { String[].class }),
				JavaReflectUtils.getConstructor(className, "Sample(java.lang.String[])", cl));
	}


	private static class Sample {
		private String[] strings;
		
		public Sample() {
			this(new String[0]);
		}
		public Sample(String[] strings) {
			this.strings = strings;
		}
		public Sample(String first, String... following) {
			strings = new String[following.length+1];
			System.arraycopy(following, 0, strings, 1, following.length);
			strings[0] = first;
		}
		public Sample(String first,  IModelsEntity... entities) {
			strings = new String[entities.length+1];
			for (int i = 0; i < entities.length; i++) {
				strings[i+1] = 
					PrettyPrinterOperation
							.toPrettyPrintString(entities[i]);
			}
			strings[0] = first;
		}

		public void append(String string) {
			strings = CompositeUtils.grow(strings, strings.length+1, string);
		}
		public void append(String... strings) {
			for (String string : strings)
				append(string);
		}
		public void append(long value) {
			append(Long.toString(value));
		}
		public void append(Long value) {
			append(Long.toString(value));
		}
		public void append(IModelsEntity entity) {
			append(PrettyPrinterOperation.toPrettyPrintString(entity));
		}
		public void append(String string, IModelsEntity... entities) {
			append(string);
			for (IModelsEntity entity : entities)
				append(entity);
		}

		public String stringAt(int index) {
			return strings[index];
		}
		public String toString(int from, int to) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < to; i++)
				sb.append(strings[i]);
			return sb.toString();			
		}
		@Override
		public String toString() {
			return toString(0, strings.length);
		}

		public static Sample createSample(String string, IModelsEntity... entities) {
			Sample sample = new Sample();
			sample.append(string, entities);
			return sample;
		}
		@Override
		public boolean equals(Object obj) {
			if (obj == null)
				return false;
			Sample oherSample = (Sample) obj;
			if (strings.length != oherSample.strings.length)
				return false;
			for (int i = 0; i < strings.length; i++) 
				if (!strings[i].equals(oherSample.strings[i]))
					return false;
			return true;
		}
	}

	@Test
    public void testWideningNarrowing() throws Exception {
		String className = PrimitiveHelpers.class.getName();
		ClassLoader cl = ReflectionFactory.getPlatformClassLoader();

		Method identity = JavaReflectUtils.getMethod(className, "identity(double)", cl);
		// widening
		assertEquals(99.0, identity.invoke(null, DataTypeUtils.unbox(BindingManagerFactory.instance.createValue((byte) 99), double.class)));
		assertEquals(32.0, identity.invoke(null, DataTypeUtils.unbox(BindingManagerFactory.instance.createValue((char) ' '), double.class)));
		assertEquals(9999.0, identity.invoke(null, DataTypeUtils.unbox(BindingManagerFactory.instance.createValue((short) 9999), double.class)));
		assertEquals(999999.0, identity.invoke(null, DataTypeUtils.unbox(BindingManagerFactory.instance.createValue(999999), double.class)));
		assertEquals(9999999999.0, identity.invoke(null, DataTypeUtils.unbox(BindingManagerFactory.instance.createValue(9999999999L), double.class)));
		assertEquals(0.111111119389534, identity.invoke(null, DataTypeUtils.unbox(BindingManagerFactory.instance.createValue(0.11111112f), double.class)));
		assertEquals(0.111111119, identity.invoke(null, DataTypeUtils.unbox(BindingManagerFactory.instance.createValue(0.111111119), double.class)));

		identity = JavaReflectUtils.getMethod(className, "identity(float)", cl);
		// widening
		assertEquals(99f, identity.invoke(null, DataTypeUtils.unbox(BindingManagerFactory.instance.createValue((byte) 99), float.class)));
		assertEquals(32f, identity.invoke(null, DataTypeUtils.unbox(BindingManagerFactory.instance.createValue((char) ' '), float.class)));
		assertEquals(9999f, identity.invoke(null, DataTypeUtils.unbox(BindingManagerFactory.instance.createValue((short) 9999), float.class)));
		assertEquals(999999f, identity.invoke(null, DataTypeUtils.unbox(BindingManagerFactory.instance.createValue(999999), float.class)));
		assertEquals(9999999999f, identity.invoke(null, DataTypeUtils.unbox(BindingManagerFactory.instance.createValue(9999999999L), float.class)));
		assertEquals(0.11111112f, identity.invoke(null, DataTypeUtils.unbox(BindingManagerFactory.instance.createValue(0.11111112f), float.class)));
		// narrowing
		assertEquals(0.11111112f, identity.invoke(null, DataTypeUtils.unbox(BindingManagerFactory.instance.createValue(0.11111112), float.class)));
		// narrowing with truncation
		assertEquals(0.11111112f, identity.invoke(null, DataTypeUtils.unbox(BindingManagerFactory.instance.createValue(0.111111119), float.class)));

		identity = JavaReflectUtils.getMethod(className, "identity(long)", cl);
		// widening
		assertEquals(99L, identity.invoke(null, DataTypeUtils.unbox(BindingManagerFactory.instance.createValue((byte) 99), long.class)));
		assertEquals(0x2F83L, identity.invoke(null, DataTypeUtils.unbox(BindingManagerFactory.instance.createValue((char) '\u2F83'), long.class)));
		assertEquals(9999L, identity.invoke(null, DataTypeUtils.unbox(BindingManagerFactory.instance.createValue((short) 9999), long.class)));
		assertEquals(999999L, identity.invoke(null, DataTypeUtils.unbox(BindingManagerFactory.instance.createValue(999999), long.class)));
		assertEquals(999999999999L, identity.invoke(null, DataTypeUtils.unbox(BindingManagerFactory.instance.createValue(999999999999L), long.class)));
		// narrowing
		assertEquals(121246824L, identity.invoke(null, DataTypeUtils.unbox(BindingManagerFactory.instance.createValue(121246824.1456f), long.class)));
		assertEquals(121246824L, identity.invoke(null, DataTypeUtils.unbox(BindingManagerFactory.instance.createValue(121246824.1456), long.class)));
		// narrowing with truncation
		assertEquals(9000000512L, identity.invoke(null, DataTypeUtils.unbox(BindingManagerFactory.instance.createValue(9000000000.1f), long.class)));
		assertEquals(9000000000L, identity.invoke(null, DataTypeUtils.unbox(BindingManagerFactory.instance.createValue(9000000000.1), long.class)));

		identity = JavaReflectUtils.getMethod(className, "identity(int)", cl);
		// widening
		assertEquals(99, identity.invoke(null, DataTypeUtils.unbox(BindingManagerFactory.instance.createValue((byte) 99), int.class)));
		assertEquals(0x2F83, identity.invoke(null, DataTypeUtils.unbox(BindingManagerFactory.instance.createValue((char) '\u2F83'), int.class)));
		assertEquals(9999, identity.invoke(null, DataTypeUtils.unbox(BindingManagerFactory.instance.createValue((short) 9999), int.class)));
		assertEquals(999999, identity.invoke(null, DataTypeUtils.unbox(BindingManagerFactory.instance.createValue(999999), int.class)));
		// narrowing
		assertEquals(12345678, identity.invoke(null, DataTypeUtils.unbox(BindingManagerFactory.instance.createValue(12345678), int.class)));
		assertEquals(12345678, identity.invoke(null, DataTypeUtils.unbox(BindingManagerFactory.instance.createValue(12345678.1f), int.class)));
		assertEquals(12345678, identity.invoke(null, DataTypeUtils.unbox(BindingManagerFactory.instance.createValue(12345678.1), int.class)));
		// narrowing with overflow
		assertEquals(410065408, identity.invoke(null, DataTypeUtils.unbox(BindingManagerFactory.instance.createValue(9000000000L), int.class)));
		assertEquals(2147483647, identity.invoke(null, DataTypeUtils.unbox(BindingManagerFactory.instance.createValue(9000000000.1f), int.class)));
		assertEquals(2147483647, identity.invoke(null, DataTypeUtils.unbox(BindingManagerFactory.instance.createValue(9000000000.1), int.class)));

		identity = JavaReflectUtils.getMethod(className, "identity(short)", cl);
		// widening
		assertEquals((short) 99, identity.invoke(null, DataTypeUtils.unbox(BindingManagerFactory.instance.createValue((byte) 99), short.class)));
		assertEquals((short) 0x2F83, identity.invoke(null, DataTypeUtils.unbox(BindingManagerFactory.instance.createValue((char) '\u2F83'), short.class)));
		assertEquals((short) 9999, identity.invoke(null, DataTypeUtils.unbox(BindingManagerFactory.instance.createValue((short) 9999), short.class)));
		// narrowing
		assertEquals((short) 9999, identity.invoke(null, DataTypeUtils.unbox(BindingManagerFactory.instance.createValue(9999), short.class)));
		assertEquals((short) 9999, identity.invoke(null, DataTypeUtils.unbox(BindingManagerFactory.instance.createValue(9999), short.class)));
		assertEquals((short) 9999, identity.invoke(null, DataTypeUtils.unbox(BindingManagerFactory.instance.createValue(9999.1f), short.class)));
		assertEquals((short) 9999, identity.invoke(null, DataTypeUtils.unbox(BindingManagerFactory.instance.createValue(9999.1), short.class)));
		// narrowing with overflow
		assertEquals((short) 4464, identity.invoke(null, DataTypeUtils.unbox(BindingManagerFactory.instance.createValue(70000), short.class)));
		assertEquals((short) 4464, identity.invoke(null, DataTypeUtils.unbox(BindingManagerFactory.instance.createValue(70000L), short.class)));
		assertEquals((short) 4464, identity.invoke(null, DataTypeUtils.unbox(BindingManagerFactory.instance.createValue(70000.1f), short.class)));
		assertEquals((short) 4464, identity.invoke(null, DataTypeUtils.unbox(BindingManagerFactory.instance.createValue(70000.1), short.class)));

		identity = JavaReflectUtils.getMethod(className, "identity(byte)", cl);
		// widening
		assertEquals((byte) 99, identity.invoke(null, DataTypeUtils.unbox(BindingManagerFactory.instance.createValue((byte) 99), byte.class)));
		// narrowing
		assertEquals((byte) 125, identity.invoke(null, DataTypeUtils.unbox(BindingManagerFactory.instance.createValue((char) 125), byte.class)));
		assertEquals((byte) 125, identity.invoke(null, DataTypeUtils.unbox(BindingManagerFactory.instance.createValue((short) 125), byte.class)));
		assertEquals((byte) 125, identity.invoke(null, DataTypeUtils.unbox(BindingManagerFactory.instance.createValue(125), byte.class)));
		assertEquals((byte) 125, identity.invoke(null, DataTypeUtils.unbox(BindingManagerFactory.instance.createValue(125), byte.class)));
		assertEquals((byte) 125, identity.invoke(null, DataTypeUtils.unbox(BindingManagerFactory.instance.createValue(125.1f), byte.class)));
		assertEquals((byte) 125, identity.invoke(null, DataTypeUtils.unbox(BindingManagerFactory.instance.createValue(125.1), byte.class)));
		// narrowing with overflow
		assertEquals((byte) 44, identity.invoke(null, DataTypeUtils.unbox(BindingManagerFactory.instance.createValue((char) 300), byte.class)));
		assertEquals((byte) 44, identity.invoke(null, DataTypeUtils.unbox(BindingManagerFactory.instance.createValue((short) 300), byte.class)));
		assertEquals((byte) 44, identity.invoke(null, DataTypeUtils.unbox(BindingManagerFactory.instance.createValue(300), byte.class)));
		assertEquals((byte) 44, identity.invoke(null, DataTypeUtils.unbox(BindingManagerFactory.instance.createValue(300L), byte.class)));
		assertEquals((byte) 44, identity.invoke(null, DataTypeUtils.unbox(BindingManagerFactory.instance.createValue(300.1f), byte.class)));
		assertEquals((byte) 44, identity.invoke(null, DataTypeUtils.unbox(BindingManagerFactory.instance.createValue(300.1), byte.class)));
		
		identity = JavaReflectUtils.getMethod(className, "identity(char)", cl);
		// widening
		assertEquals((char) ' ', identity.invoke(null, DataTypeUtils.unbox(BindingManagerFactory.instance.createValue((byte) ' '), char.class)));
		assertEquals((char) '\u2F83', identity.invoke(null, DataTypeUtils.unbox(BindingManagerFactory.instance.createValue((char) '\u2F83'), char.class)));
		// narrowing with overflow
		assertEquals((char) 0, identity.invoke(null, DataTypeUtils.unbox(BindingManagerFactory.instance.createValue((short) 0), char.class)));
		assertEquals((char) 0, identity.invoke(null, DataTypeUtils.unbox(BindingManagerFactory.instance.createValue(0), char.class)));
		assertEquals((char) 0, identity.invoke(null, DataTypeUtils.unbox(BindingManagerFactory.instance.createValue(0L), char.class)));
		assertEquals((char) 0, identity.invoke(null, DataTypeUtils.unbox(BindingManagerFactory.instance.createValue(0.0f), char.class)));
		assertEquals((char) 0, identity.invoke(null, DataTypeUtils.unbox(BindingManagerFactory.instance.createValue(0.0), char.class)));
	}

	private static class PrimitiveHelpers {
		public static double identity(double value) {
			return value;
		}
		public static float identity(float value) {
			return value;
		}
		public static long identity(long value) {
			return value;
		}
		public static int identity(int value) {
			return value;
		}
		public static short identity(short value) {
			return value;
		}
		public static char identity(char value) {
			return value;
		}
		public static byte identity(byte value) {
			return value;
		}
	}
}
