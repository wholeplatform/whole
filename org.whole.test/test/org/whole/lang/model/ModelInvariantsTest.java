/**
 * Copyright 2004-2014 Riccardo Solmi. All rights reserved.
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

import junit.framework.TestCase;

import org.whole.lang.grammars.GrammarsActions;
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

/**
 * @author Riccardo Solmi
 */
public class ModelInvariantsTest extends TestCase {
	private Model model;

	protected void setUp() throws Exception {
		super.setUp();

		ReflectionFactory.deployWholePlatform();
		model = new XmlModel().create();
	}

	public void testLanguageKitOrd() {
		IEntityIterator<IEntity> i = IteratorFactory.descendantOrSelfIterator();
		i.reset(model);
		for (IEntity e : i)
			assertEquals(e.wGetLanguageKit(), e.wGetEntityDescriptor().getLanguageKit());
	}

	public void testUniqueCompoundModel() {
		ICompoundModel compoundModel = model.wGetModel().getCompoundModel();

		IEntityIterator<IEntity> i = IteratorFactory.descendantOrSelfIterator();
		i.reset(model);
		for (IEntity e : i)
			assertEquals(compoundModel, e.wGetModel().getCompoundModel());
	}

	public void testUniqueFragmentModel() {
		IEntityIterator<IEntity> i = IteratorFactory.descendantOrSelfIterator();
		i.reset(new GrammarsActions().create());
		for (IEntity e : i) {
			Logger.getLogger("org.whole.test").info(StringUtils.transientId(e));
			
			IEntity fragmentRoot = EntityUtils.getLanguageFragmentRoot(e);
			if (fragmentRoot != e && EntityUtils.isFragment(fragmentRoot))
				fragmentRoot = fragmentRoot.wGetRoot();

			assertEquals(fragmentRoot.wGetModel(), e.wGetModel());
		}
	}

	public void testParent() {
		assertTrue(CheckPaternityVisitor.check(model));
	}

	public void testSetOrphanByName() {
		SimpleName oldName = model.getName();
		SimpleName newName = ModelsEntityFactory.instance.createSimpleName("name");

		assertTrue(model.wContains(oldName));
		assertSame(model, oldName.wGetParent());
		assertTrue(EntityUtils.hasParent(oldName));
		assertSame(NullEntity.instance, newName.wGetParent());
		assertTrue(!EntityUtils.hasParent(newName));

		model.setName(newName);
		assertFalse(model.wContains(oldName));
		assertSame(NullEntity.instance, oldName.wGetParent());
		assertTrue(!EntityUtils.hasParent(oldName));
		assertSame(model, newName.wGetParent());
		assertTrue(EntityUtils.hasParent(newName));

		model.setName(oldName);
		assertSame(model, oldName.wGetParent());
		assertTrue(EntityUtils.hasParent(oldName));
		assertSame(NullEntity.instance, newName.wGetParent());
		assertTrue(!EntityUtils.hasParent(newName));
	}

	public void testSetOrphanByIndexInSimpleEntity() {
		SimpleName oldName = model.getName();
		SimpleName newName = ModelsEntityFactory.instance.createSimpleName("name");
		int index = model.wIndexOf(oldName);
		
		assertTrue(model.wContains(oldName));
		assertSame(model, oldName.wGetParent());
		assertTrue(EntityUtils.hasParent(oldName));
		assertSame(NullEntity.instance, newName.wGetParent());
		assertTrue(!EntityUtils.hasParent(newName));

		model.wSet(index, newName);
		assertFalse(model.wContains(oldName));
		assertSame(NullEntity.instance, oldName.wGetParent());
		assertTrue(!EntityUtils.hasParent(oldName));
		assertSame(model, newName.wGetParent());
		assertTrue(EntityUtils.hasParent(newName));

		model.wSet(index, oldName);
		assertSame(model, oldName.wGetParent());
		assertTrue(EntityUtils.hasParent(oldName));
		assertSame(NullEntity.instance, newName.wGetParent());
		assertTrue(!EntityUtils.hasParent(newName));
	}

	public void testSetOrphanByIndexInComposite() {
		IEntity parent = model.getDeclarations();
		int index = 0;
		IEntity oldChild = parent.wGet(index);
		SimpleEntity newChild = ModelsEntityFactory.instance.createSimpleEntity();

		assertTrue(parent.wContains(oldChild));
		assertSame(parent, oldChild.wGetParent());
		assertTrue(EntityUtils.hasParent(oldChild));
		assertSame(NullEntity.instance, newChild.wGetParent());
		assertTrue(!EntityUtils.hasParent(newChild));

		parent.wSet(index, newChild);
		assertFalse(parent.wContains(oldChild));
		assertSame(NullEntity.instance, oldChild.wGetParent());
		assertTrue(!EntityUtils.hasParent(oldChild));
		assertSame(parent, newChild.wGetParent());
		assertTrue(EntityUtils.hasParent(newChild));

		parent.wSet(index, oldChild);
		assertSame(parent, oldChild.wGetParent());
		assertTrue(EntityUtils.hasParent(oldChild));
		assertSame(NullEntity.instance, newChild.wGetParent());
		assertTrue(!EntityUtils.hasParent(newChild));
	}

	public void testAddOrphan() {
		IEntity parent = model.getDeclarations();
		SimpleEntity newChild1 = ModelsEntityFactory.instance.createSimpleEntity();
		SimpleEntity newChild2 = ModelsEntityFactory.instance.createSimpleEntity();
		
		parent.wAdd(0, newChild1);
		assertTrue(parent.wContains(newChild1));
		assertSame(parent, newChild1.wGetParent());
		assertTrue(EntityUtils.hasParent(newChild1));

		parent.wAdd(newChild2);
		assertTrue(parent.wContains(newChild2));
		assertSame(parent, newChild2.wGetParent());
		assertTrue(EntityUtils.hasParent(newChild2));
	}

	public void testRemoveOrphan() {
		IEntity parent = model.getDeclarations();
		
		IEntity oldChild = parent.wGet(0);
		
		parent.wRemove(oldChild);
		assertFalse(parent.wContains(oldChild));
		assertSame(NullEntity.instance, oldChild.wGetParent());
		assertTrue(!EntityUtils.hasParent(oldChild));

		oldChild = parent.wGet(0);
		
		parent.wRemove(0);
		assertFalse(parent.wContains(oldChild));
		assertSame(NullEntity.instance, oldChild.wGetParent());
		assertTrue(!EntityUtils.hasParent(oldChild));
	}

	public void testParentedFailures() {
		SimpleName name = model.getName();
		SimpleEntity simpleEntity = ModelsEntityFactory.instance.createSimpleEntity();

		try {
			simpleEntity.setName(name);
			fail();
		} catch (IllegalArgumentException e) {
			simpleEntity.wUnset(name);
		}

		try {
			simpleEntity.getTypes().wAdd(name);
			fail();
		} catch (IllegalArgumentException e) {
			simpleEntity.getTypes().wRemove(name);
		}		

		try {
			simpleEntity.getTypes().wSet(0, name);
			fail();
		} catch (IllegalArgumentException e) {
			simpleEntity.getTypes().wRemove(0);
		}		

		try {
			simpleEntity.getTypes().wAdd(0, name);
			fail();
		} catch (IllegalArgumentException e) {
			simpleEntity.getTypes().wRemove(0);
		}		
	}
}
