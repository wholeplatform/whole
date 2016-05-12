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

import java.util.logging.Logger;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.whole.lang.codebase.ClasspathPersistenceProvider;
import org.whole.lang.iterators.IEntityIterator;
import org.whole.lang.iterators.IteratorFactory;
import org.whole.lang.models.codebase.XmlModel;
import org.whole.lang.models.factories.ModelsEntityFactory;
import org.whole.lang.models.model.Model;
import org.whole.lang.models.model.SimpleEntity;
import org.whole.lang.models.model.SimpleName;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.util.EntityUtils;
import org.whole.lang.util.StringUtils;
import org.whole.lang.xml.codebase.XmlBuilderPersistenceKit;
import org.whole.test.SlowTests;

/**
 * @author Riccardo Solmi
 */
public class ModelInvariantsTest {
	private Model model;

    @BeforeClass
    public static void deployWholePlatform() {
    	ReflectionFactory.deployWholePlatform();
    }
    @Before
    public void setUp() {
		model = new XmlModel().create();
	}

    @Category(SlowTests.class)
    @Test
	public void testLanguageKitOrd() {
		IEntityIterator<IEntity> i = IteratorFactory.descendantOrSelfIterator();
		i.reset(model);
		for (IEntity e : i)
			Assert.assertEquals(e.wGetLanguageKit(), e.wGetEntityDescriptor().getLanguageKit());
	}

    @Test
	public void testUniqueCompoundModel() {
		ICompoundModel compoundModel = model.wGetModel().getCompoundModel();

		IEntityIterator<IEntity> i = IteratorFactory.descendantOrSelfIterator();
		i.reset(model);
		for (IEntity e : i)
			Assert.assertEquals(compoundModel, e.wGetModel().getCompoundModel());
	}

    @Test
	public void testUniqueFragmentModel() throws Exception {
		IEntityIterator<IEntity> i = IteratorFactory.descendantOrSelfIterator();
		i.reset(XmlBuilderPersistenceKit.instance().readModel(
				new ClasspathPersistenceProvider("org/whole/lang/grammars/GrammarsActions.xwl")));
		for (IEntity e : i) {
			Logger.getLogger("org.whole.test").info(StringUtils.transientId(e));
			
			IEntity fragmentRoot = EntityUtils.getLanguageFragmentRoot(e);
			if (fragmentRoot != e && EntityUtils.isFragment(fragmentRoot))
				fragmentRoot = fragmentRoot.wGetRoot();

			Assert.assertEquals(fragmentRoot.wGetModel(), e.wGetModel());
		}
	}

    @Test
	public void testParent() {
		Assert.assertTrue(CheckPaternityVisitor.check(model));
	}

    @Test
	public void testSetOrphanByName() {
		SimpleName oldName = model.getName();
		SimpleName newName = ModelsEntityFactory.instance.createSimpleName("name");

		Assert.assertTrue(model.wContains(oldName));
		Assert.assertSame(model, oldName.wGetParent());
		Assert.assertTrue(EntityUtils.hasParent(oldName));
		Assert.assertSame(NullEntity.instance, newName.wGetParent());
		Assert.assertTrue(!EntityUtils.hasParent(newName));

		model.setName(newName);
		Assert.assertFalse(model.wContains(oldName));
		Assert.assertSame(NullEntity.instance, oldName.wGetParent());
		Assert.assertTrue(!EntityUtils.hasParent(oldName));
		Assert.assertSame(model, newName.wGetParent());
		Assert.assertTrue(EntityUtils.hasParent(newName));

		model.setName(oldName);
		Assert.assertSame(model, oldName.wGetParent());
		Assert.assertTrue(EntityUtils.hasParent(oldName));
		Assert.assertSame(NullEntity.instance, newName.wGetParent());
		Assert.assertTrue(!EntityUtils.hasParent(newName));
	}

    @Test
	public void testSetOrphanByIndexInSimpleEntity() {
		SimpleName oldName = model.getName();
		SimpleName newName = ModelsEntityFactory.instance.createSimpleName("name");
		int index = model.wIndexOf(oldName);
		
		Assert.assertTrue(model.wContains(oldName));
		Assert.assertSame(model, oldName.wGetParent());
		Assert.assertTrue(EntityUtils.hasParent(oldName));
		Assert.assertSame(NullEntity.instance, newName.wGetParent());
		Assert.assertTrue(!EntityUtils.hasParent(newName));

		model.wSet(index, newName);
		Assert.assertFalse(model.wContains(oldName));
		Assert.assertSame(NullEntity.instance, oldName.wGetParent());
		Assert.assertTrue(!EntityUtils.hasParent(oldName));
		Assert.assertSame(model, newName.wGetParent());
		Assert.assertTrue(EntityUtils.hasParent(newName));

		model.wSet(index, oldName);
		Assert.assertSame(model, oldName.wGetParent());
		Assert.assertTrue(EntityUtils.hasParent(oldName));
		Assert.assertSame(NullEntity.instance, newName.wGetParent());
		Assert.assertTrue(!EntityUtils.hasParent(newName));
	}

    @Test
	public void testSetOrphanByIndexInComposite() {
		IEntity parent = model.getDeclarations();
		int index = 0;
		IEntity oldChild = parent.wGet(index);
		SimpleEntity newChild = ModelsEntityFactory.instance.createSimpleEntity();

		Assert.assertTrue(parent.wContains(oldChild));
		Assert.assertSame(parent, oldChild.wGetParent());
		Assert.assertTrue(EntityUtils.hasParent(oldChild));
		Assert.assertSame(NullEntity.instance, newChild.wGetParent());
		Assert.assertTrue(!EntityUtils.hasParent(newChild));

		parent.wSet(index, newChild);
		Assert.assertFalse(parent.wContains(oldChild));
		Assert.assertSame(NullEntity.instance, oldChild.wGetParent());
		Assert.assertTrue(!EntityUtils.hasParent(oldChild));
		Assert.assertSame(parent, newChild.wGetParent());
		Assert.assertTrue(EntityUtils.hasParent(newChild));

		parent.wSet(index, oldChild);
		Assert.assertSame(parent, oldChild.wGetParent());
		Assert.assertTrue(EntityUtils.hasParent(oldChild));
		Assert.assertSame(NullEntity.instance, newChild.wGetParent());
		Assert.assertTrue(!EntityUtils.hasParent(newChild));
	}

    @Test
	public void testAddOrphan() {
		IEntity parent = model.getDeclarations();
		SimpleEntity newChild1 = ModelsEntityFactory.instance.createSimpleEntity();
		SimpleEntity newChild2 = ModelsEntityFactory.instance.createSimpleEntity();
		
		parent.wAdd(0, newChild1);
		Assert.assertTrue(parent.wContains(newChild1));
		Assert.assertSame(parent, newChild1.wGetParent());
		Assert.assertTrue(EntityUtils.hasParent(newChild1));

		parent.wAdd(newChild2);
		Assert.assertTrue(parent.wContains(newChild2));
		Assert.assertSame(parent, newChild2.wGetParent());
		Assert.assertTrue(EntityUtils.hasParent(newChild2));
	}

    @Test
	public void testRemoveOrphan() {
		IEntity parent = model.getDeclarations();
		
		IEntity oldChild = parent.wGet(0);
		
		parent.wRemove(oldChild);
		Assert.assertFalse(parent.wContains(oldChild));
		Assert.assertSame(NullEntity.instance, oldChild.wGetParent());
		Assert.assertTrue(!EntityUtils.hasParent(oldChild));

		oldChild = parent.wGet(0);
		
		parent.wRemove(0);
		Assert.assertFalse(parent.wContains(oldChild));
		Assert.assertSame(NullEntity.instance, oldChild.wGetParent());
		Assert.assertTrue(!EntityUtils.hasParent(oldChild));
	}

    @Test
	public void testParentedFailures() {
		SimpleName name = model.getName();
		SimpleEntity simpleEntity = ModelsEntityFactory.instance.createSimpleEntity();

		try {
			simpleEntity.setName(name);
			Assert.fail();
		} catch (IllegalArgumentException e) {
			simpleEntity.wUnset(name);
		}

		try {
			simpleEntity.getTypes().wAdd(name);
			Assert.fail();
		} catch (IllegalArgumentException e) {
			simpleEntity.getTypes().wRemove(name);
		}		

		try {
			simpleEntity.getTypes().wSet(0, name);
			Assert.fail();
		} catch (IllegalArgumentException e) {
			simpleEntity.getTypes().wRemove(0);
		}		

		try {
			simpleEntity.getTypes().wAdd(0, name);
			Assert.fail();
		} catch (IllegalArgumentException e) {
			simpleEntity.getTypes().wRemove(0);
		}		
	}
}
