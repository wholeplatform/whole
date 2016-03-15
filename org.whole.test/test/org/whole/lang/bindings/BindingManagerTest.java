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

import java.util.Arrays;
import java.util.Date;
import java.util.Set;

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

/**
 * @author Riccardo Solmi
 */
public class BindingManagerTest {
	private IBindingManager bm;
	private ModelsEntityFactory mlf;
	private XmlEntityFactory xlf;

    @BeforeClass
    public static void deployWholePlatform() {
    	ReflectionFactory.deployWholePlatform();
    }

    @Before
    public void setUp() {
		ReflectionFactory.deploy(TestLanguagesDeployer.class);
		
		bm = BindingManagerFactory.instance.createBindingManager();
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
		 bm.wDefValue("bool", false);
		 assertTrue(bm.wBooleanValue("bool") == false);

		 bm.wDefValue("byte", (byte) 4);
		 assertTrue(bm.wByteValue("byte") == 4);
		 
		 bm.wDefValue("char", 'c');
		 assertTrue(bm.wCharValue("char") == 'c');
		 
		 bm.wDefValue("double", 3.5d);
		 assertTrue(bm.wDoubleValue("double") == 3.5d);
		 
		 bm.wDefValue("float", 1.25f);
		 assertTrue(bm.wFloatValue("float") == 1.25f);
		 
		 bm.wDefValue("int", 12);
		 assertTrue(bm.wIntValue("int") == 12);
		 
		 bm.wDefValue("long", 324l);
		 assertTrue(bm.wLongValue("long") == 324l);
		 
		 bm.wDefValue("short", (short) 34);
		 assertTrue(bm.wShortValue("short") == 34);
		 
		 bm.wDefValue("string", "abc");
		 assertEquals("abc", bm.wStringValue("string"));
		 
		 Date d = new Date();
		 bm.wDefValue("date", d);
		 assertSame(d, bm.wDateValue("date"));

		 EnumValue e = FeatureModifierEnum.optional;
		 bm.wDefValue("enum", e);
		 assertEquals(e, bm.wEnumValue("enum"));

		 Object o = new Object();
		 bm.wDefValue("object", o);
		 assertSame(o, bm.wGetValue("object"));
	}

    @Test
    public void testBindDataErrors() {
		 bm.wDefValue("bool", false);
		 try {
			 bm.wByteValue("bool");
			 fail();
		 } catch (IllegalArgumentException e) {
		 }
	}

    @Test
    public void testIsSetUnset() {
		assertFalse(bm.wIsSet("a"));
		bm.wDefValue("a", 10);
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
    public void testSetUnsetInScope() {
		bm.wDefValue("a", 10);
		bm.wDefValue("c", 140);
		bm.wEnterScope();
		bm.wDefValue("b", false);
		assertTrue(bm.wIsSet("a"));
		assertTrue(bm.wIsSet("c"));
		assertTrue(bm.wIsSet("b"));
		bm.wDefValue("a", 20);
		bm.wUnset("a");
		assertTrue(bm.wIsSet("a"));
		bm.wUnset("c");
		assertFalse(bm.wIsSet("c"));
		bm.wExitScope();
		assertTrue(bm.wIsSet("a"));
		assertFalse(bm.wIsSet("c"));
		assertFalse(bm.wIsSet("b"));
	}
	
    @Test
    public void testClone() {
		bm.wDefValue("a", 10);
		bm.wDefValue("b", 140l);
		bm.wEnterScope();
		bm.wDefValue("c", false);

		IBindingManager bm2 = bm.clone();
		assertEquals(bm.wIntValue("a"), bm2.wIntValue("a"));
		assertEquals(bm.wLongValue("b"), bm2.wLongValue("b"));
		assertEquals(bm.wStringValue("c"), bm2.wStringValue("c"));
	}

    @Test
    public void testNames() {
		IBindingManager bm1 = BindingManagerFactory.instance.createBindingManager();
		Set<String> localNames, names;
		
		bm1.wDefValue("a", 1);
		bm1.wDefValue("b", 2);
		bm1.wDefValue("c", 3);
		
		localNames = bm1.wLocalNames();
		names = bm1.wNames();
		assertEquals(localNames, names);
		assertEquals(3, localNames.size());

		bm1.wEnterScope();
		bm1.wDefValue("d", 4);
		bm1.wDefValue("e", 5);

		localNames = bm1.wLocalNames();
		names = bm1.wNames();
		assertEquals(2, localNames.size());
		assertEquals(5, names.size());
		assertTrue(names.containsAll(Arrays.asList(new String[] {
				"a", "b", "c", "d", "e"})));

		IBindingManager bm2 = BindingManagerFactory.instance.createBindingManager();
		
		bm2.wDefValue("f", 6);
		bm2.wDefValue("g", 7);
		bm2.wDefValue("h", 8);
		bm2.wDefValue("i", 9);

		bm2.wEnterScope(bm1, true);

		localNames = bm2.wLocalNames();
		names = bm2.wNames();
		assertEquals(bm1.wLocalNames().size(), localNames.size());
		assertTrue(localNames.containsAll(bm1.wLocalNames()));
		assertEquals(4+bm1.wNames().size(), names.size());

		bm2.wExitScope();

		localNames = bm2.wLocalNames();
		names = bm2.wNames();
		assertEquals(localNames, names);
		assertEquals(4, localNames.size());

		bm2.wEnterScope(bm1, false);

		localNames = bm2.wLocalNames();
		names = bm2.wNames();
		assertEquals(bm1.wLocalNames().size(), localNames.size());
		assertTrue(localNames.containsAll(bm1.wLocalNames()));
		assertEquals(bm1.wNames().size(), names.size());
		assertTrue(names.containsAll(bm1.wNames()));
	}
	
    @Test
    public void testResettableScope() throws Exception {
		IBindingManager bm = BindingManagerFactory.instance.createBindingManager();
		
		bm.wDefValue("initialA", "A");

		ITransactionScope rs = BindingManagerFactory.instance.createTransactionScope();
		bm.wEnterScope(rs);

		bm.wDefValue("initialA", "a");
		bm.wDefValue("nestedB", "B");
		rs.commit();

		bm.wDefValue("nestedC", "C");
		bm.wSetValue("initialA", "ax");
		bm.wSetValue("nestedB", "bx");

		rs.rollback();
		bm.wExitScope();

		assertEquals("a", bm.wGetValue("initialA"));
		assertTrue(bm.wIsSet("nestedB"));
		assertFalse(bm.wIsSet("nestedC"));

		rs.wClear();
		bm.wEnterScope(rs);
		bm.wEnterScope();
		
		bm.wDefValue("freshName", "value");
		
		bm.wExitScope(true);
		rs.rollback();
		bm.wExitScope();

		assertFalse(bm.wIsSet("freshName"));

		assertEquals("a", bm.wGetValue("initialA"));
		assertTrue(bm.wIsSet("nestedB"));
		assertFalse(bm.wIsSet("nestedC"));
	}
}
