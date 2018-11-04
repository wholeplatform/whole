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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.junit.BeforeClass;
import org.junit.Test;
import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.codebase.ClasspathPersistenceProvider;
import org.whole.lang.commons.factories.CommonsEntityAdapterFactory;
import org.whole.lang.commons.factories.CommonsEntityFactory;
import org.whole.lang.commons.reflect.CommonsEntityDescriptorEnum;
import org.whole.lang.executables.IExecutable;
import org.whole.lang.executables.RegularExecutableFactory;
import org.whole.lang.factories.RegistryConfigurations;
import org.whole.lang.grammars.factories.GrammarsEntityFactory;
import org.whole.lang.grammars.model.Choose;
import org.whole.lang.grammars.model.Grammar;
import org.whole.lang.grammars.model.NonTerminal;
import org.whole.lang.grammars.model.Production;
import org.whole.lang.grammars.model.Productions;
import org.whole.lang.grammars.model.Rule;
import org.whole.lang.grammars.reflect.GrammarsEntityDescriptorEnum;
import org.whole.lang.grammars.util.TestXmlGrammar;
import org.whole.lang.java.model.CompilationUnit;
import org.whole.lang.java.model.ImportModifier;
import org.whole.lang.java.reflect.JavaEntityDescriptorEnum;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.misc.factories.MiscEntityFactory;
import org.whole.lang.misc.model.Any;
import org.whole.lang.misc.model.Misc;
import org.whole.lang.misc.reflect.MiscEntityDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.util.EntityUtils;
import org.whole.lang.visitors.GenericIdentityVisitor;
import org.whole.lang.visitors.GenericTraversalFactory;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.xml.codebase.XmlBuilderPersistenceKit;

/**
 * @author Riccardo Solmi
 */
public class IteratorFactoryTest {
	protected static ExecutableFactory f;

    @BeforeClass
    public static void deployWholePlatform() {
    	ReflectionFactory.deployWholePlatform();

//TODO switch comment to test a specific factory
//    	f = IteratorFactory.instance;
    	f = new RegularExecutableFactory();
    }

    @Test
    public void testChildByNameAndByIndexIterators() {
		Grammar g = new TestXmlGrammar().create();
	
		IEntityIterator<IEntity> i1 = f.createFeatureByName("phraseStructure").iterator();
		i1.reset(g);
		assertTrue(i1.hasNext());
		assertSame(g.getPhraseStructure(), i1.next());
		assertFalse(i1.hasNext());
		assertNull(i1.lookahead());

		IEntityIterator<IEntity> i2 = f.createFeatureByIndex(0).iterator();
		i2.reset(g);
		assertTrue(i2.hasNext());
		assertSame(g.wGet(0), i2.next());
		assertFalse(i2.hasNext());
		assertNull(i2.lookahead());
	}

    @Test
    public void testChildIterator() {
		Grammar g = new TestXmlGrammar().create();
		Productions productions = g.getPhraseStructure();

		int index = 0;
		IEntityIterator<Production> ci = f.<Production>createChild().iterator();
		ci.reset(productions);
		while (ci.hasNext()) {
			Production p = ci.next();
			assertSame(productions.wGet(index++), p);
		}
	}

    @Test
    public void testFollowingSiblingIterator() {
		Grammar g = new TestXmlGrammar().create();
		Productions productions = g.getPhraseStructure();

		int index = 0;
		IEntityIterator<Production> ci = f.<Production>createChild().iterator();
		ci.reset(productions);
		while (ci.hasNext()) {
			Production p = ci.next();
			IExecutable<Production> fi = f.<Production>createFollowingSibling().iterator();
			fi.reset(p);
			int findex = ++index;
			for (Production fp : fi)
				assertSame(productions.wGet(findex++), fp);
		}
		
		for (int i=0; i<g.wSize(); i++) {
			IEntityIterator<IEntity> fi = f.<IEntity>createFollowingSibling().iterator();
			fi.reset(g.wGet(i));
			for (int j=i+1; j<g.wSize(); j++)
				assertSame(g.wGet(j), fi.next());
		}

		for (int i=0; i<productions.wSize(); i++) {
			IEntityIterator<Production> fi = f.<Production>createFollowingSibling().iterator();
			fi.reset(productions.wGet(i));
			for (int j=i+1; j<productions.wSize(); j++)
				assertSame(productions.wGet(j), fi.next());
		}
	}

    @Test
    public void testPrecedingSiblingIterator() {
		Grammar g = new TestXmlGrammar().create();
		Productions productions = g.getPhraseStructure();

		int index = 0;
		IEntityIterator<Production> ci = f.<Production>createChild().iterator();
		ci.reset(productions);
		while (ci.hasNext()) {
			Production p = ci.next();
			IExecutable<Production> fi = f.<Production>createPrecedingSibling().iterator();
			fi.reset(p);
			int findex = index++;
			for (Production fp : fi)
				assertSame(productions.wGet(--findex), fp);
		}
		
		for (int i=g.wSize()-1; i>=0; i--) {
			IEntityIterator<IEntity> fi = f.<IEntity>createPrecedingSibling().iterator();
			fi.reset(g.wGet(i));
			for (int j=i-1; j>=0; j--)
				assertSame(g.wGet(j), fi.next());
		}

		for (int i=productions.wSize()-1; i>=0; i--) {
			IEntityIterator<Production> fi = f.<Production>createPrecedingSibling().iterator();
			fi.reset(productions.wGet(i));
			for (int j=i-1; j>=0; j--)
				assertSame(productions.wGet(j), fi.next());
		}
	}

    @Test
    public void testChildIteratorRemove() {
		Grammar g = new TestXmlGrammar().create();

		Productions productions = EntityUtils.clone(g.getPhraseStructure());
		IEntityIterator<Production> ci = f.<Production>createChild().iterator();
		ci.reset(productions);
		while (ci.hasNext()) {
			Production p = ci.next();
			assertSame(productions.wGet(0), p);
			ci.remove();
		}
		assertEquals(0, productions.wSize());
	}

    @Test
    public void testChildReverseIterator() {
		Grammar g = new TestXmlGrammar().create();
		Productions productions = g.getPhraseStructure();

		int index = productions.wSize();
		IEntityIterator<Production> ci = f.<Production>createChildReverse().iterator();
		ci.reset(productions);
		while (ci.hasNext()) {
			Production p = ci.next();
			assertSame(productions.wGet(--index), p);
		}
	}

    @Test
    public void testChildReverseIteratorRemove() {
		Grammar g = new TestXmlGrammar().create();

		Productions productions = EntityUtils.clone(g.getPhraseStructure());
		IEntityIterator<Production> ci = f.<Production>createChildReverse().iterator();
		ci.reset(productions);
		while (ci.hasNext()) {
			Production p = ci.next();
			assertSame(productions.wGet(productions.wSize()-1), p);
			ci.remove();
		}
		assertEquals(0, productions.wSize());
	}

    @Test
    public void testTopDownIterator() throws Exception {
		Grammar g = new TestXmlGrammar().create();
		final Productions productions = g.getPhraseStructure();

		final IEntityIterator<IEntity> ci = f.<IEntity>createDescendantOrSelf().iterator();
		ci.reset(productions);
		IVisitor v = GenericTraversalFactory.instance.topDown(new GenericIdentityVisitor() {
			public void visit(IEntity entity) {
				if (ci.hasNext())
					assertSame(entity, ci.next());
				else
					fail();
			}
		}, false);
		v.visit(productions);
	}

    @Test
    public void testDescendantAndDescendantOrSelfIterators() {
		Grammar g = new TestXmlGrammar().create();

		IEntityIterator<IEntity> dsi = f.<IEntity>createDescendantOrSelf().iterator();
		dsi.reset(g);
		IEntityIterator<IEntity> di = f.<IEntity>createDescendant().iterator();
		di.reset(g);

		assertSame(g, dsi.next());
		assertSame(dsi.hasNext(), di.hasNext());
		
		boolean hasNext;
		do {
			assertSame(dsi.lookahead(), di.lookahead());
			assertSame(dsi.next(), di.next());
			assertSame(hasNext = dsi.hasNext(), di.hasNext());
		} while (hasNext);
	}

    @Test
    public void testFragmentRootIterator() throws Exception {
		IEntity e = XmlBuilderPersistenceKit.instance().readModel(
				new ClasspathPersistenceProvider("org/whole/lang/templates/codebase/TemplateManagerArtifactsTemplates.xwl"));

		CompilationUnit cu = Matcher.find(JavaEntityDescriptorEnum.CompilationUnit, e, false);
		ImportModifier im = Matcher.find(JavaEntityDescriptorEnum.ImportModifier, e, false);

		IEntityIterator<IEntity> i1 = f.createRoot().iterator();
		i1.reset(im);
		assertTrue(i1.hasNext());
		assertSame(e, i1.next());

		IEntityIterator<IEntity> i2 = f.createFragmentRoot().iterator();
		i2.reset(im);
		assertTrue(i2.hasNext());
		assertSame(cu, i2.next());
	}

    @Test
    public void testRootIteratorMarkReset() {
		Grammar g = new TestXmlGrammar().create();
		NonTerminal prologNt = ((Production) ((Production) g.getPhraseStructure().wGet(0)).getRule().wGet(0)).getName();

		IEntityIterator<IEntity> i = f.createRoot().iterator();
		i.reset(prologNt);
		IEntityIterator<IEntity> i2 = i.clone().iterator();
		assertTrue(i.hasNext());
		assertSame(g, i.next());
		assertFalse(i.hasNext());

		assertTrue(i2.hasNext());
		assertSame(g, i2.next());
	}

	@Test
    public void testSelfIteratorMarkReset() {
		Grammar g = new TestXmlGrammar().create();
		
		IEntityIterator<Grammar> si = f.<Grammar>createSelf().iterator();
		si.reset(g);
		IEntityIterator<Grammar> si2 = si.clone().iterator();
		assertSame(g, si.next());
		assertFalse(si.hasNext());

		assertTrue(si2.hasNext());
		assertSame(g, si2.next());
	}

	@Test
    public void testChildIteratorMarkReset() {
		Grammar g =  new TestXmlGrammar().create();
		
		IEntityIterator<IEntity> i = f.<IEntity>createChild().iterator();
		i.reset(g);
		i.next();
		i.next();
		IEntityIterator<IEntity> i2 = i.clone().iterator();
		IEntityIterator<IEntity> i3 = i.clone().iterator();
		IEntity e1 = i.next();
		IEntity e2 = i.next();

		assertSame(e1, i2.next());

		assertSame(e1, i3.next());
		assertSame(e2, i3.next());
	}

	@Test
    public void testChildReverseIteratorMarkReset() {
		Grammar g = new TestXmlGrammar().create();
		
		IEntityIterator<IEntity> i = f.<IEntity>createChildReverse().iterator();
		i.reset(g);
		i.next();
		i.next();
		IEntityIterator<IEntity> i2 = i.clone().iterator();
		IEntityIterator<IEntity> i3 = i.clone().iterator();
		IEntity e1 = i.next();
		IEntity e2 = i.next();

		assertSame(e1, i2.next());

		assertSame(e1, i3.next());
		assertSame(e2, i3.next());
	}

	@Test
    public void testParentIteratorMarkReset() {
		Grammar g = new TestXmlGrammar().create();
		Rule r = Matcher.find(GrammarsEntityDescriptorEnum.As, g, false);

		IEntityIterator<IEntity> i = f.createParent().iterator();
		i.reset(r);
		IEntityIterator<IEntity> i2 = i.clone().iterator();
		assertTrue(i.hasNext());
		IEntity e1 = i.next();
		assertSame(r.wGetParent(), e1);

		assertTrue(i2.hasNext());
		assertSame(r.wGetParent(), i2.next());
	}

	@Test
    public void testAncestorIteratorMarkReset() {
		Grammar g = new TestXmlGrammar().create();
		Rule r = Matcher.find(GrammarsEntityDescriptorEnum.As, g, false);

		IEntityIterator<IEntity> i = f.createAncestor().iterator();
		i.reset(r);
		i.next();
		i.next();
		IEntityIterator<IEntity> i2 = i.clone().iterator();
		IEntityIterator<IEntity> i3 = i.clone().iterator();
		IEntity e1 = i.next();
		IEntity e2 = i.next();

		assertSame(e1, i2.next());

		assertSame(e1, i3.next());
		assertSame(e2, i3.next());
	}

	@Test
    public void testAncestorOrSelfIteratorMarkReset() {
		Grammar g = new TestXmlGrammar().create();
		Rule r = Matcher.find(GrammarsEntityDescriptorEnum.As, g, false);

		IEntityIterator<IEntity> i = f.createAncestorOrSelf().iterator();
		i.reset(r);
		IEntity e1 = i.next();
		assertSame(r, e1);
		e1 = i.next();
		assertSame(r.wGetParent(), e1);
		IEntityIterator<IEntity> i2 = i.clone().iterator();
		IEntityIterator<IEntity> i3 = i.clone().iterator();
		e1 = i.next();
		IEntity e2 = i.next();

		assertSame(e1, i2.next());

		assertSame(e1, i3.next());
		assertSame(e2, i3.next());
	}


	@Test
    public void testAncestorOrSelfIteratorRemoveSet() {
		Grammar g = new TestXmlGrammar().create();

		MiscEntityFactory mef = MiscEntityFactory.instance(RegistryConfigurations.RESOLVER);
		Any any = CommonsEntityAdapterFactory.create(MiscEntityDescriptorEnum.Any, g);
		Misc innerMisc = mef.createMisc(any);
		any = CommonsEntityAdapterFactory.create(MiscEntityDescriptorEnum.Any, innerMisc);
		Misc outerMisc = mef.createMisc(any);

		Rule r = Matcher.find(GrammarsEntityDescriptorEnum.As, outerMisc, false);

		IEntityIterator<IEntity> i = f.createAncestorOrSelf().iterator();
		i.reset(r);

		IEntity next = null;
		while (i.hasNext()) {
			next = i.next();
			if (Matcher.match(MiscEntityDescriptorEnum.Misc, next))
				break;
		}
		assertSame(innerMisc, next);

		i.set(EntityUtils.clone(any));		
		assertEquals(1, outerMisc.wSize());

		Rule r2 = Matcher.find(GrammarsEntityDescriptorEnum.As, outerMisc, false);
		assertTrue(Matcher.match(r, r2));
		assertNotSame(r, r2);

		i.remove();
		assertEquals(0, outerMisc.wSize());
		
		i.reset(r2);
		while (i.hasNext()) {
			next = i.next();
			if (i.hasNext())
				i.remove();
		}
		assertFalse(EntityUtils.hasParent(next));
	}

	@Test
    public void testVariableIterator() {
		Grammar g = new TestXmlGrammar().create();

		IBindingManager bindings = BindingManagerFactory.instance.createBindingManager();
		IEntityIterator<IEntity> i = f.createVariable("testVar").iterator();
		i.setBindings(bindings);
		i.reset(g);
		assertFalse(i.hasNext());
		bindings.wDef("testVar", g);
		assertTrue(i.hasNext());
		IEntity g1 = i.next();
		assertSame(g, g1);
		assertFalse(i.hasNext());
		i.reset(g);
		assertTrue(i.hasNext());
		g1 = i.next();
		assertSame(g, g1);
		assertFalse(i.hasNext());

		bindings = BindingManagerFactory.instance.createBindingManager();
		bindings.wDef("testVar", g);
		i = f.createVariable("testVar").iterator();
		i.setBindings(bindings);
		i.reset(BindingManagerFactory.instance.createNull());
		assertTrue(i.hasNext());
		g1 = i.next();
		assertSame(g, g1);
		assertFalse(i.hasNext());
		i.reset(g);
		IEntityIterator<IEntity> i2 = i.clone().iterator();
		assertTrue(i.hasNext());
		g1 = i.next();
		assertSame(g, g1);
		assertFalse(i.hasNext());

		assertTrue(i2.hasNext());
		g1 = i2.next();
		assertSame(g, g1);
		assertFalse(i2.hasNext());
	}

	@Test
    public void testRootBehavior() {
		Grammar g = new TestXmlGrammar().create();
		CommonsEntityFactory.instance.createRootFragment(
				g.wGetAdapter(CommonsEntityDescriptorEnum.Any));
		IEntity gParent = g.wGetParent(); //rootParent

		IEntityIterator<IEntity> i = f.createRoot().iterator();
		i.reset(g);
		assertTrue(i.hasNext());
		IEntity e1 = i.next();
		assertSame(g, e1);
		
		i = f.createRoot().iterator();
		i.reset(gParent);
		assertTrue(i.hasNext());
		e1 = i.next();
		assertSame(g, e1);
		
		i = f.createFragmentRoot().iterator();
		i.reset(gParent);
		assertTrue(i.hasNext());
		e1 = i.next();
		assertSame(g, e1);
		
		i = f.createParent().iterator();
		i.reset(g);
		assertTrue(i.hasNext());
		e1 = i.next();
		assertSame(g.wGetParent(), e1);

		i = f.createParent().iterator();
		i.reset(gParent);
		assertFalse(i.hasNext());
		assertNull(i.lookahead());

		i = f.createAncestor().iterator();
		i.reset(g);
		assertTrue(i.hasNext());
		e1 = i.next();
		assertSame(g.wGetParent(), e1);

		i = f.createAncestor().iterator();
		i.reset(gParent);
		assertFalse(i.hasNext());
		assertNull(i.lookahead());

		i = f.createAncestorOrSelf().iterator();
		i.reset(g);
		assertTrue(i.hasNext());
		e1 = i.next();
		assertSame(g, e1);
		assertTrue(i.hasNext());
		e1 = i.next();
		assertSame(g.wGetParent(), e1);

		i = f.createAncestorOrSelf().iterator();
		i.reset(gParent);
		assertTrue(i.hasNext());
		e1 = i.next();
		assertSame(g.wGetParent(), e1);
		assertFalse(i.hasNext());
		assertNull(i.lookahead());

		IEntityIterator<Grammar> i2 = f.<Grammar>createSelf().iterator();
		i2.reset(g);
		assertTrue(i2.hasNext());
		e1 = i2.next();
		assertSame(g, e1);
		assertFalse(i2.hasNext());
		assertNull(i2.lookahead());

		i = f.createSelf().iterator();
		i.reset(gParent);
		assertTrue(i.hasNext());
		e1 = i.next();
		assertSame(gParent, e1);
		assertFalse(i.hasNext());
		assertNull(i.lookahead());


		g = GrammarsEntityFactory.instance.createGrammar();

		gParent = g.wGetParent(); //nullEntity

		i = f.createRoot().iterator();
		i.reset(g);
		assertTrue(i.hasNext());
		e1 = i.next();
		assertSame(g, e1);
		
		i = f.createRoot().iterator();
		i.reset(gParent);
		assertFalse(i.hasNext());
		assertNull(i.lookahead());
		
		i = f.createParent().iterator();
		i.reset(g);
		assertFalse(i.hasNext());
		assertNull(i.lookahead());
		i = f.createParent().iterator();
		i.reset(gParent);
		assertFalse(i.hasNext());
		assertNull(i.lookahead());

		i = f.createAncestor().iterator();
		i.reset(g);
		assertFalse(i.hasNext());
		assertNull(i.lookahead());
		i = f.createAncestor().iterator();
		i.reset(gParent);
		assertFalse(i.hasNext());
		assertNull(i.lookahead());

		i = f.createAncestorOrSelf().iterator();
		i.reset(g);
		assertTrue(i.hasNext());
		e1 = i.next();
		assertSame(g, e1);
		assertFalse(i.hasNext());
		assertNull(i.lookahead());

		i = f.createAncestorOrSelf().iterator();
		i.reset(gParent);
		assertFalse(i.hasNext());
		assertNull(i.lookahead());

		i2 = f.<Grammar>createSelf().iterator();
		i2.reset(g);
		assertTrue(i2.hasNext());
		e1 = i2.next();
		assertSame(g, e1);
		assertFalse(i2.hasNext());
		assertNull(i2.lookahead());

		i = f.createSelf().iterator();
		i.reset(gParent);
		assertFalse(i.hasNext());
		assertNull(i.lookahead());		
	}

	@Test
    public void testTopDownIteratorMarkReset() {
		Grammar g = new TestXmlGrammar().create();

		IEntityIterator<IEntity> i = f.<IEntity>createDescendantOrSelf().iterator();
		i.reset(g);
		for (int j=0; j<15; j++)
			i.next();
		IEntityIterator<IEntity> i2 = i.clone().iterator();
		IEntityIterator<IEntity> i3 = i.clone().iterator();
		IEntity e1 = i.next();
		IEntity e2 = i.next();
		for (int j=0; j<7; j++)
			i.next();

		assertSame(e1, i2.next());

		assertSame(e1, i3.next());
		assertSame(e2, i3.next());
	}

	@Test
    public void testChildIteratorAdd() {
		Grammar g = new TestXmlGrammar().create();

		Productions productions = g.getPhraseStructure();
		int size = productions.wSize();
		int count = 0;
		Production pAdded1 = null;
		Production pAdded2 = null;
		
		IEntityIterator<Production> i = f.<Production>createChild().iterator();
		i.reset(productions);
		while (i.hasNext()) {
			Production p = i.next();
			assertNotSame(pAdded1, p);
			assertNotSame(pAdded2, p);

			count++;
			if (count == 1)
				i.add(pAdded1 = GrammarsEntityFactory.instance.createProduction());

			if (count == 3) {
				i.add(pAdded1 = GrammarsEntityFactory.instance.createProduction());
				i.add(pAdded2 = GrammarsEntityFactory.instance.createProduction());
			}
		}

		assertEquals(size, count);
		assertEquals(size+3, productions.wSize());
	}

	@Test
    public void testChildReverseIteratorAdd() {
		Grammar g = new TestXmlGrammar().create();

		Productions productions = g.getPhraseStructure();
		int size = productions.wSize();
		int count = 0;
		Production pAdded1 = null;
		Production pAdded2 = null;
		
		IEntityIterator<Production> i = f.<Production>createChildReverse().iterator();
		i.reset(productions);
		while (i.hasNext()) {
			Production p = i.next();
			assertNotSame(pAdded1, p);
			assertNotSame(pAdded2, p);

			count++;
			if (count == 1)
				i.add(pAdded1 = GrammarsEntityFactory.instance.createProduction());

			if (count == 3) {
				i.add(pAdded1 = GrammarsEntityFactory.instance.createProduction());
				i.add(pAdded2 = GrammarsEntityFactory.instance.createProduction());
			}
		}

		assertEquals(size, count);
		assertEquals(size+3, productions.wSize());
	}

	@Test
    public void testTopDownIteratorAdd() {
		Grammar g = new TestXmlGrammar().create();

		Production production = (Production) g.getPhraseStructure().wGet(3);
		Choose choose = (Choose) production.getRule();
		int size = choose.wSize();
		int count = 0;
		Rule rAdded1 = null;
		Rule rAdded2 = null;
		
		IEntityIterator<IEntity> i = f.<IEntity>createDescendantOrSelf().iterator();
		i.reset(production);
		i.next();
		i.next();
		while (i.hasNext()) {
			IEntity r = i.next();
			assertNotSame(rAdded1, r);
			assertNotSame(rAdded2, r);

			if (count == 0)
				assertSame(choose, r);
			else if (count == 1)
				i.add(rAdded1 = GrammarsEntityFactory.instance.createProduction());
			else if (count == 10) {
				i.add(rAdded1 = GrammarsEntityFactory.instance.createProduction());
				i.add(rAdded2 = GrammarsEntityFactory.instance.createProduction());
			}
			count++;
		}

		assertEquals(size+3, choose.wSize());
	}

	@SuppressWarnings("unchecked")
	@Test
    public void testSequenceIterator() {
		Grammar g = new TestXmlGrammar().create();

		Productions p1 = g.getPhraseStructure();
		Productions p2 = g.getLexicalStructure();
		
		ExecutableFactory f = ExecutableFactory.instance;
		
		List<Production> p3 = new ArrayList<Production>();
		IExecutable<Production> i11 = f.<Production>createChild().iterator();
		i11.reset(p1);
		for (Production p : i11)
			p3.add(p);
		IExecutable<Production> i12 = f.<Production>createChild().iterator();
		i12.reset(p2);
		for (Production p : i12)
			p3.add(p);
		
		Iterator<Production> i = p3.iterator();
		
		IExecutable<Production> pi = f.createSequence(f.createConstantChild(p1), f.createConstantChild(p2));
		pi.reset(BindingManagerFactory.instance.createNull());
		for (Production p : pi)
			assertSame(i.next(), p);
	}

	@Test
    public void testComposeIterator() {
		Grammar g = new TestXmlGrammar().create();

		//query: g/phraseStructure/child()[ED = Production]/rule//[ED = Production]
		IExecutable<Production> pi = f.createCompose(
				f.createFilter(f.createDescendantOrSelf(), f.createHasType(GrammarsEntityDescriptorEnum.Production.getURI())),
				f.createFeatureByName("rule"),
				f.createFilter(f.createChild(), f.createHasType(GrammarsEntityDescriptorEnum.Production.getURI())),
				f.createFeatureByName("phraseStructure"));

		pi.reset(g);
		Set<String> l = new HashSet<String>();
		for (Production p : pi)
			l.add(p.getName().getValue());
		
		assertEquals(16, l.size());


		NonTerminal prologNt = ((Production) ((Production) g.getPhraseStructure().wGet(0)).getRule().wGet(0)).getName();

		//query: g/phraseStructure/0/rule/0/name
		IEntityIterator<? extends IEntity> nti = f.createCompose(
				f.createFeatureByName("name"),
				f.createFeatureByIndex(0),
				f.createFeatureByName("rule"),
				f.createFeatureByIndex(0),
				f.createFeatureByName("phraseStructure")).iterator();
		nti.reset(g);

		assertTrue(nti.hasNext());
		assertSame(prologNt, nti.next());
		
		nti.reset(g.getPhraseStructure());
		assertFalse(nti.hasNext());

		nti.reset(g);
		assertTrue(nti.hasNext());
		assertSame(prologNt, nti.next());		
	}

	@Test
    public void testPrune() {
		Grammar g = new TestXmlGrammar().create();

		IEntityIterator<IEntity> i1 = f.<IEntity>createDescendantOrSelf().iterator();
		i1.reset(g);
		IEntityIterator<IEntity> i2 = f.<IEntity>createDescendantOrSelf().iterator();
		i2.reset(g);
		for (IEntity e : i1) {
			assertSame(e, i2.next());
			
			IEntityIterator<IEntity> i12 = i1.clone().iterator();
			i12.prune();
		}
		assertSame(i1.hasNext(), i2.hasNext());
		
		i1 = f.<IEntity>createDescendantOrSelf().iterator();
		i1.reset(g);
		for (IEntity e : i1) {
			IEntityIterator<IEntity> i3 = f.<IEntity>createFollowingSibling().iterator();
			i3.reset(e);
			if (i3.hasNext()) {
				IEntityIterator<IEntity> i12 = i1.clone().iterator();
				i12.prune();

				IEntity e1 = i12.next();
				IEntity e2 = i3.next();
				assertSame(e1, e2);
			}
		}
	}

	@Test
    public void testFollowingIterator() {
		Grammar g = new TestXmlGrammar().create();

		IExecutable<IEntity> tdi = f.<IEntity>createDescendantOrSelf().iterator();
		tdi.reset(g);

		for (IEntity e : tdi) {
			IEntityIterator<IEntity> fi = f.<IEntity>createFollowing().iterator();
			fi.reset(e);
			
			if (fi.hasNext()) {
				IEntityIterator<IEntity> tdi2 = tdi.clone().iterator();
				tdi2.prune();

				assertSame(tdi2.hasNext(), fi.hasNext());
				assertSame(tdi2.lookahead(), fi.lookahead());
				
				for (IEntity fe : fi) {
					IEntity e1 = tdi2.next();
					assertSame(e1, fe);
				}
			}
		}
	}

	@Test
    public void testPrecedingIterator() {
		Grammar g = new TestXmlGrammar().create();

		IExecutable<IEntity> tdi = f.<IEntity>createDescendantOrSelfReverse().iterator();
		tdi.reset(g);

		for (IEntity e : tdi) {
			IEntityIterator<IEntity> fi = f.<IEntity>createPreceding().iterator();
			fi.reset(e);
			
			if (fi.hasNext()) {
				IEntityIterator<IEntity> tdi2 = tdi.clone().iterator();
				tdi2.prune();
				
					
				assertSame(tdi2.hasNext(), fi.hasNext());
				assertSame(tdi2.lookahead(), fi.lookahead());
				
				for (IEntity fe : fi) {
					IEntity e1 = tdi2.next();
					assertSame(e1, fe);
				}
			}
		}
	}

	@Test
    public void testAxesPartitionInvariant() {
		Grammar g = new TestXmlGrammar().create();

		IExecutable<IEntity> i = f.<IEntity>createDescendantOrSelf().iterator();
		i.reset(g);
		Set<IEntity> s = entities(i);

		IExecutable<IEntity> i2 = f.<IEntity>createDescendantOrSelf().iterator();
		i2.reset(g);
		for (IEntity e : i2) {
			IExecutable<IEntity> i1 = f.<IEntity>createAncestor().iterator();
			i1.reset(e);
			Set<IEntity> s1 = entities(i1);
			IExecutable<IEntity> i22 = f.createSelf().iterator();
			i22.reset(e);
			Set<IEntity> s2 = entities(i22);
			IExecutable<IEntity> i3 = f.<IEntity>createDescendant().iterator();
			i3.reset(e);
			Set<IEntity> s3 = entities(i3);
			IExecutable<IEntity> i4 = f.<IEntity>createPreceding().iterator();
			i4.reset(e);
			Set<IEntity> s4 = entities(i4);
			IExecutable<IEntity> i5 = f.<IEntity>createFollowing().iterator();
			i5.reset(e);
			Set<IEntity> s5 = entities(i5);
		
			assertFalse(s1.removeAll(s2));
			assertFalse(s1.removeAll(s3));
			assertFalse(s1.removeAll(s4));
			assertFalse(s1.removeAll(s5));
			assertFalse(s2.removeAll(s3));
			assertFalse(s2.removeAll(s4));
			assertFalse(s2.removeAll(s5));
			assertFalse(s3.removeAll(s4));
			assertFalse(s3.removeAll(s5));
			assertFalse(s4.removeAll(s5));

			assertFalse(s.addAll(s1));
			assertFalse(s.addAll(s2));
			assertFalse(s.addAll(s3));
			assertFalse(s.addAll(s4));
			assertFalse(s.addAll(s5));
			
			assertEquals(s.size(), s1.size()+s2.size()+s3.size()+s4.size()+s5.size());
		}
	}
	private Set<IEntity> entities(IExecutable<?> i) {
		Set<IEntity> result = new HashSet<IEntity>();
		for (IEntity e : i)
			assertTrue(result.add(e));
		return result;
	}

	@Test
    public void testFilterByIndexIterator() {
		Grammar g = new TestXmlGrammar().create();
		Productions productions = g.getPhraseStructure();
		Production p = (Production) productions.wGet(1);
		
		IEntityIterator<?> i = f.createFilterByIndex(
				f.createFollowingSibling(), 0).iterator();
		i.reset(p);
		assertSingleton(i, productions.wGet(2));
		
		i = f.createFilterByIndex(
				f.createFollowingSibling(), 1).iterator();
		i.reset(p);
		assertSingleton(i, productions.wGet(3));
		
		i = f.createFilterByIndex(
				f.createAncestorOrSelf(), 2).iterator();
		i.reset(p);
		assertSingleton(i, productions.wGetParent());
		
		i = f.createFilterByIndex(
				f.createDescendantOrSelf(), 1).iterator();
		i.reset(p);
		assertSingleton(i, p.getName());
	}

	private void assertSingleton(IEntityIterator<?> i, IEntity e) {
		IEntityIterator<?> i2 = i.clone().iterator();
		assertTrue(i.hasNext());
		assertSame(e, i.lookahead());
		assertSame(e, i.next());
		assertFalse(i.hasNext());
		assertNull(i.lookahead());

		assertTrue(i2.hasNext());
		assertSame(e, i2.lookahead());
		assertSame(e, i2.next());
		assertFalse(i2.hasNext());
		assertNull(i2.lookahead());		
	}
}
