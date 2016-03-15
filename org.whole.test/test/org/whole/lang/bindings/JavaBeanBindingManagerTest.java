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
package org.whole.lang.bindings;

import java.util.Date;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.whole.lang.model.EnumValue;
import org.whole.lang.model.IEntity;
import org.whole.lang.models.factories.ModelsEntityFactory;
import org.whole.lang.models.model.FeatureModifierEnum;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.xml.factories.XmlEntityFactory;
import org.whole.langs.test.TestLanguagesDeployer;

public class JavaBeanBindingManagerTest {
	private IBindingManager bm;
	private ModelsEntityFactory mlf;
	private XmlEntityFactory xlf;
	private SampleJavaBean bean;

    @BeforeClass
    public static void deployWholePlatform() {
    	ReflectionFactory.deployWholePlatform();
    }

    @Before
    public void setUp() {
		ReflectionFactory.deploy(TestLanguagesDeployer.class);
		
		bean = new SampleJavaBean();
		
		bm = BindingManagerFactory.instance.createEnvironmentManager().createEnvironment(
				"bm", BindingManagerFactory.instance.createJavaBeanScope(bean));
		mlf = ModelsEntityFactory.instance;
		xlf = XmlEntityFactory.instance;
	}

    @Test
    public void testScopeProtocol() {
		bm.wEnterScope();
		bm.wExitScope();

		bm.wEnterScope();
		bm.wEnterScope();
		bm.wExitScope();
		bm.wExitScope();		
	}

    @Test
    public void testScopeProtocolError1() {
		try {
			bm.wExitScope();
			fail();
		} catch (Exception e) {
		}
	}
    @Test
    public void testScopeProtocolError2() {
		try {
			bm.wEnterScope();
			bm.wEnterScope();
			bm.wExitScope();
			bm.wExitScope();
			bm.wExitScope();
			fail();
		} catch (Exception e) {
		}
	}

    @Test
    public void testBindProtocolError() {
		try {
			bm.wSet("undefName", mlf.createSimpleName("aName"));
			fail();
		} catch (Exception e) {
		}

		try {
			bm.wSetValue("undefName", "a value");
			fail();
		} catch (Exception e) {
		}
	}

    @Test
    public void testBindEntities() {
		IEntity e1 = mlf.createSimpleName("aName");
		IEntity e2 = mlf.createSimpleName("aName");

		bm.wDef("id1", e1);
		bm.wDef("id2", e2);
		assertEquals(e1, bm.wGet("id1"));
		assertEquals(e2, bm.wGet("id2"));

		bm.wSet("id1", e2);
		assertEquals(e2, bm.wGet("id1"));
		assertEquals(e2, bm.wGet("id2"));
		
		assertNull(bm.wGet("unregistered"));
	}

    @Test
    public void testBindInScope() {
		IEntity e1 = mlf.createSimpleName("aName");
		IEntity e2 = mlf.createSimpleName("aName");
		IEntity e3 = xlf.createCharData("data");
		IEntity e4 = xlf.createName("aName");

		bm.wDef("id1", e1);
		bm.wDef("id2", e2);
		bm.wEnterScope();
		bm.wDef("id2", e3);
		bm.wDef("id3", e4);
		assertEquals(e1, bm.wGet("id1"));
		assertEquals(e3, bm.wGet("id2"));
		assertEquals(e4, bm.wGet("id3"));
		bm.wExitScope();
		assertEquals(e1, bm.wGet("id1"));
		assertEquals(e2, bm.wGet("id2"));
		assertNull(bm.wGet("id3"));
	}
    @Test
    public void testBindInStaticScope() {
		IEntity e1 = mlf.createSimpleName("aName");
		IEntity e2 = mlf.createSimpleName("aName");
		IEntity e3 = xlf.createCharData("data");
		IEntity e4 = xlf.createName("aName");

		IBindingManager sbm = BindingManagerFactory.instance.createBindingManager();
		sbm.wDef("id2", e3);
		sbm.wDef("id3", e4);
		sbm.wEnterScope();
		sbm.wDef("id4", e3);

		bm.wDef("id1", e1);
		bm.wDef("id2", e2);
		bm.wEnterScope(sbm, false);
		assertNull(bm.wGet("id1"));
		assertEquals(e3, bm.wGet("id2"));
		assertEquals(e4, bm.wGet("id3"));
		assertEquals(e3, bm.wGet("id4"));
		bm.wExitScope();
		assertEquals(e1, bm.wGet("id1"));
		assertEquals(e2, bm.wGet("id2"));
		assertNull(bm.wGet("id3"));
		assertNull(bm.wGet("id4"));
	}

    @Test
    public void testDefUse() {
		IEntity e1 = mlf.createSimpleName("aName1");
		IEntity e2 = mlf.createSimpleName("aName2");
		IEntity e3 = mlf.createSimpleName("aName3");
		IEntity e4 = mlf.createSimpleName("aName4");

		bm.wDef("id1", e1);
		bm.wDef("id2", e2);

		bm.wDef("id1", e2);
		assertEquals(e2, bm.wGet("id1"));
		bm.wSet("id1", e1);
		assertEquals(e1, bm.wGet("id1"));

		bm.wEnterScope();
		bm.wDef("id1", e3);

		bm.wSet("id1", e4);
		assertEquals(e4, bm.wGet("id1"));
		bm.wSet("id2", e4);
		assertEquals(e4, bm.wGet("id2"));

		bm.wExitScope();
		assertEquals(e1, bm.wGet("id1"));
		assertEquals(e4, bm.wGet("id2"));
	}

    @Test
    public void testBindData() {
		 bm.wDefValue("boolF", false);
		 assertTrue(bm.wBooleanValue("boolF") == false);

		 bm.wDefValue("byteF", (byte) 4);
		 assertTrue(bm.wByteValue("byteF") == 4);
		 
		 bm.wDefValue("charF", 'c');
		 assertTrue(bm.wCharValue("charF") == 'c');
		 
		 bm.wDefValue("doubleF", 3.5d);
		 assertTrue(bm.wDoubleValue("doubleF") == 3.5d);
		 
		 bm.wDefValue("floatF", 1.25f);
		 assertTrue(bm.wFloatValue("floatF") == 1.25f);
		 
		 bm.wDefValue("intF", 12);
		 assertTrue(bm.wIntValue("intF") == 12);
		 
		 bm.wDefValue("longF", 324l);
		 assertTrue(bm.wLongValue("longF") == 324l);
		 
		 bm.wDefValue("shortF", (short) 34);
		 assertTrue(bm.wShortValue("shortF") == 34);
		 
		 bm.wDefValue("stringF", "abc");
		 assertEquals("abc", bm.wStringValue("stringF"));
		 
		 Date d = new Date();
		 bm.wDefValue("dateF", d);
		 assertSame(d, bm.wDateValue("dateF"));

		 EnumValue e = FeatureModifierEnum.optional;
		 bm.wDefValue("enumF", e);
		 assertEquals(e, bm.wEnumValue("enumF"));

		 Object o = new Object();
		 bm.wDefValue("objectF", o);
		 assertSame(o, bm.wGetValue("objectF"));
	}

    @Test
    public void testBindDataErrors() {
		 bm.wDefValue("boolF", false);
		 try {
			 bm.wByteValue("boolF");
			 fail();
		 } catch (IllegalArgumentException e) {
		 }
	}

    @Test
    public void testIsSetUnset() {
		assertFalse(bm.wIsSet("a"));
		bm.wDefValue("a", "10");
		assertTrue(bm.wIsSet("a"));
		bm.wUnset("a");
		assertFalse(bm.wIsSet("a"));
	}

    @Test
    public void testIsSetUnsetUndefined() {
		bm.wUnset("a");
		assertFalse(bm.wIsSet("a"));
	}

    @Test
    public void testsSetUnsetInScope() {
		bm.wDefValue("a", "10");
		bm.wEnterScope();
		bm.wDefValue("b", "false");
		assertTrue(bm.wIsSet("a"));
		assertTrue(bm.wIsSet("b"));
		bm.wExitScope();
		assertTrue(bm.wIsSet("a"));
		assertFalse(bm.wIsSet("b"));
	}

	@Test
    public void testIsSetUnsetPrimitive() {
		assertTrue(bm.wIsSet("c"));
		bm.wDefValue("c", 10);
		assertTrue(bm.wIsSet("c"));
		bm.wUnset("c");
		assertTrue(bm.wIsSet("c"));
	}

	@Test
    public void testIsSetUnsetUndefinedPrimitive() {
		bm.wUnset("c");
		assertTrue(bm.wIsSet("c"));
	}

	@Test
    public void testsSetUnsetInScopePrimitive() {
		bm.wDefValue("c", 10);
		bm.wEnterScope();
		bm.wDefValue("d", false);
		assertTrue(bm.wIsSet("c"));
		assertTrue(bm.wIsSet("d"));
		bm.wExitScope();
		assertTrue(bm.wIsSet("c"));
		assertTrue(bm.wIsSet("d"));
	}
}
