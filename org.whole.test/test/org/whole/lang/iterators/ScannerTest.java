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
package org.whole.lang.iterators;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.whole.lang.java.codebase.Factorial;
import org.whole.lang.java.model.MethodDeclaration;
import org.whole.lang.java.reflect.JavaEntityDescriptorEnum;
import org.whole.lang.matchers.GenericMatcherFactory;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.test.KnownFailingTests;

/**
 * @author Riccardo Solmi
 */
public class ScannerTest {
	private GenericMatcherFactory mf;
	
    @BeforeClass
    public static void deployWholePlatform() {
    	ReflectionFactory.deployWholePlatform();
    }

	@Before
    public void setUp() {
		mf = GenericMatcherFactory.instance;
	}

	@Test
	public void testNext() {
		IEntity fact = new Factorial().create();

		ScannerIterator<IEntity> s = IteratorFactory.descendantOrSelfScannerIterator();
		s.reset(fact);
		try {
			IEntity e1 = s.next(JavaEntityDescriptorEnum.CompilationUnit);
			IEntity e2 = s.next();
			s.next();
			s.next();
			s.next();
			s.next();
			String str = s.nextString();
			Assert.assertEquals(JavaEntityDescriptorEnum.CompilationUnit, e1.wGetEntityDescriptor());
			Assert.assertEquals(JavaEntityDescriptorEnum.PackageDeclaration, e2.wGetEntityDescriptor());
			Assert.assertEquals("Copyright 2004-2016 Riccardo Solmi.", str);
		} catch (Exception e) {
			Assert.fail();
		}
	}

	@Test
	public void testSkip() {
		IEntity fact = new Factorial().create();

		ScannerIterator<IEntity> s = IteratorFactory.descendantOrSelfScannerIterator();
		s.reset(fact);
		try {
			s.skipTo(JavaEntityDescriptorEnum.SingleVariableDeclaration);
			s.next();
			String str1 = s.nextString();
			String str2 = s.nextString();
			Assert.assertEquals("int", str1);
			Assert.assertEquals("false", str2);
		} catch (Exception e) {
			Assert.fail();
		}
	}

	@Test
	public void testFindFirst() {
		IEntity fact = new Factorial().create();
		
		IEntity var = Matcher.find(mf.hasTypeMatcher(JavaEntityDescriptorEnum.Block), fact, false);
		Assert.assertNotNull(var);
	}

	@Test
	public void testFindAll() {
		IEntity fact = new Factorial().create();
		
		List<IEntity> c = new ArrayList<IEntity>();
		Matcher.findAll(mf.hasTypeMatcher(JavaEntityDescriptorEnum.Assignment), fact, c, false);
		Matcher.findAll(mf.hasTypeMatcher(JavaEntityDescriptorEnum.SingleVariableDeclaration), fact, c, false);
		Assert.assertEquals(3+2, c.size());
	}

	@Test
	public void testPatternIterator() {
		IEntity fact = new Factorial().create();
		
		IEntityIterator<IEntity> i = IteratorFactory.childMatcherIterator()
			.withPattern(JavaEntityDescriptorEnum.MethodDeclaration);
		i.reset(fact);
		
		while (i.hasNext()) {
			MethodDeclaration md = (MethodDeclaration) i.next();
			md.getName();
		}
	}

	@Category(KnownFailingTests.class)
	@Test
	public void testFilterReferencesIterator() {
		if (true)
			throw new IllegalStateException("endless loop regression"); //FIXME

//		FlowchartEntityFactory ef = FlowchartEntityFactory.instance;
//		Entry entry = ef.createEntry();
//		Block block = ef.createBlock();
//		Exit exit = ef.createExit();
//		SimpleTransition t1 = ef.createSimpleTransition(entry, block);
//		entry.setSourceTransition(t1);
//		block.setTargetTransition(t1);
//		SimpleTransition t2 = ef.createSimpleTransition(block, exit);
//		block.setSourceTransition(t2);
//		exit.setTargetTransition(t2);
//		
//		Flowchart flowchart = ef.createFlowchart(
//				ef.createNodes(entry, block, exit),
//				ef.createTransitions(t1, t2));
//				
//		IEntityIterator<?> i = IteratorFactory.topDownScannerIterator(flowchart)
//			.usePattern(new AbstractVisitor() {
//				public void visit(IEntity entity) {
//					//FIXME return when entity is in a reference iterator path
//					throw new VisitException();
//				}
//			});
//
//		int count=0;
//		for (IEntity e : i) {
//			count++;
//		}
	}
}
