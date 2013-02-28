/**
 * Copyright 2004-2013 Riccardo Solmi. All rights reserved.
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
package org.whole.lang.visitors;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import junit.framework.TestCase;

import org.whole.lang.commons.factories.CommonsEntityFactory;
import org.whole.lang.commons.reflect.CommonsEntityDescriptorEnum;
import org.whole.lang.java.codebase.Factorial;
import org.whole.lang.java.reflect.JavaEntityDescriptorEnum;
import org.whole.lang.matchers.GenericMatcherFactory;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.EntityKinds;
import org.whole.lang.reflect.ReflectionFactory;

/**
 * @author Riccardo Solmi
 */
public class TraversalFactoryTest extends TestCase {
	private GenericTraversalFactory tf;
	private GenericMatcherFactory mf;
	
	protected void setUp() throws Exception {
		super.setUp();

		ReflectionFactory.deployWholePlatform();

		tf = GenericTraversalFactory.instance;
		mf = GenericMatcherFactory.instance;
	}

	public void testTraverseParent() {
		IEntity fact = new Factorial().create();
		CommonsEntityFactory.instance.createRootFragment(
				fact.wGetAdapter(CommonsEntityDescriptorEnum.Any));
		
		List<IEntity> c = new ArrayList<IEntity>();
		tf.spineTopDown(tf.collect(tf.identity(), c), false).visit(fact);
		
		assertTrue(c.size() > 1);
		IEntity leaf = (IEntity) c.get(c.size()-1);

		List<IEntity> c2 = new ArrayList<IEntity>();
		tf.ancestors(tf.collect(tf.identity(), c2)).visit(leaf);
		
		c.add(0, fact.wGetParent());
		Collections.reverse(c2);
		assertEquals(c, c2);
	}

	public void testMatchDescriptor() {
		IEntity fact = new Factorial().create();
				
		Set<IEntity> c = new HashSet<IEntity>();
		tf.collect(mf.hasTypeMatcher(JavaEntityDescriptorEnum.CompilationUnit), c).visit(fact);
		assertFalse(c.isEmpty());
	}

	public void testMatchKind() {
		IEntity fact = new Factorial().create();
				
		Set<IEntity> c = new HashSet<IEntity>();
		tf.collect(mf.hasKindMatcher(EntityKinds.SIMPLE), c).visit(fact);
		assertFalse(c.isEmpty());
	}
}
