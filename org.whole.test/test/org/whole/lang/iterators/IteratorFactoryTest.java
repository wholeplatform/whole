/**
 * Copyright 2004-2019 Riccardo Solmi. All rights reserved.
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

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.codebase.ClasspathPersistenceProvider;
import org.whole.lang.commons.factories.CommonsEntityAdapterFactory;
import org.whole.lang.commons.factories.CommonsEntityFactory;
import org.whole.lang.commons.reflect.CommonsEntityDescriptorEnum;
import org.whole.lang.executables.ExecutableFactory;
import org.whole.lang.executables.IExecutable;
import org.whole.lang.executables.IExecutableClient;
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
	
		IExecutable i1 = f.createFeatureByName("phraseStructure");
		i1.reset(g);
		assertSame(g.getPhraseStructure(), i1.evaluateNext());
		Assert.assertNull(i1.evaluateNext());

		IExecutable i2 = f.createFeatureByIndex(0);
		i2.reset(g);
		assertSame(g.wGet(0), i2.evaluateNext());
		Assert.assertNull(i2.evaluateNext());
	}

    @Test
    public void testChildIterator() {
		Grammar g = new TestXmlGrammar().create();
		Productions productions = g.getPhraseStructure();

		int index = 0;
		IExecutableClient<Production> ci = f.createChild().client();
		ci.reset(productions);
		for (Production p = ci.evaluateNext(); p != null; p = ci.evaluateNext()) {
			assertSame(productions.wGet(index++), p);
		}
	}

    @Test
    public void testFollowingSiblingIterator() {
		Grammar g = new TestXmlGrammar().create();
		Productions productions = g.getPhraseStructure();

		int index = 0;
		IExecutableClient<Production> ci = f.createChild().client();
		ci.reset(productions);
		for (Production p = ci.evaluateNext(); p != null; p = ci.evaluateNext()) {
			IExecutableClient<Production> fi = f.createFollowingSibling().client();
			fi.reset(p);
			int findex = ++index;
			for (Production fp : fi)
				assertSame(productions.wGet(findex++), fp);
		}
		
		for (int i=0; i<g.wSize(); i++) {
			IExecutableClient<IEntity> fi = f.createFollowingSibling().client();
			fi.reset(g.wGet(i));
			for (int j=i+1; j<g.wSize(); j++)
				assertSame(g.wGet(j), fi.evaluateNext());
		}

		for (int i=0; i<productions.wSize(); i++) {
			IExecutableClient<Production> fi = f.createFollowingSibling().client();
			fi.reset(productions.wGet(i));
			for (int j=i+1; j<productions.wSize(); j++)
				assertSame(productions.wGet(j), fi.evaluateNext());
		}
	}

    @Test
    public void testPrecedingSiblingIterator() {
		Grammar g = new TestXmlGrammar().create();
		Productions productions = g.getPhraseStructure();

		int index = 0;
		IExecutableClient<Production> ci = f.createChild().client();
		ci.reset(productions);
		for (Production p = ci.evaluateNext(); p != null; p = ci.evaluateNext()) {
			IExecutableClient<Production> fi = f.createPrecedingSibling().client();
			fi.reset(p);
			int findex = index++;
			for (Production fp : fi)
				assertSame(productions.wGet(--findex), fp);
		}
		
		for (int i=g.wSize()-1; i>=0; i--) {
			IExecutableClient<IEntity> fi = f.createPrecedingSibling().client();
			fi.reset(g.wGet(i));
			for (int j=i-1; j>=0; j--)
				assertSame(g.wGet(j), fi.evaluateNext());
		}

		for (int i=productions.wSize()-1; i>=0; i--) {
			IExecutableClient<Production> fi = f.createPrecedingSibling().client();
			fi.reset(productions.wGet(i));
			for (int j=i-1; j>=0; j--)
				assertSame(productions.wGet(j), fi.evaluateNext());
		}
	}

    @Test
    public void testChildIteratorRemove() {
		Grammar g = new TestXmlGrammar().create();

		Productions productions = EntityUtils.clone(g.getPhraseStructure());
		IExecutableClient<Production> ci = f.createChild().client();
		ci.reset(productions);
		for (Production p = ci.evaluateNext(); p != null; p = ci.evaluateNext()) {
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
		IExecutableClient<Production> ci = f.createChildReverse().client();
		ci.reset(productions);
		for (Production p = ci.evaluateNext(); p != null; p = ci.evaluateNext()) {
			assertSame(productions.wGet(--index), p);
		}
	}

    @Test
    public void testChildReverseIteratorRemove() {
		Grammar g = new TestXmlGrammar().create();

		Productions productions = EntityUtils.clone(g.getPhraseStructure());
		IExecutableClient<Production> ci = f.createChildReverse().client();
		ci.reset(productions);
		for (Production p = ci.evaluateNext(); p != null; p = ci.evaluateNext()) {
			assertSame(productions.wGet(productions.wSize()-1), p);
			ci.remove();
		}
		assertEquals(0, productions.wSize());
	}

    @Test
    public void testTopDownIterator() throws Exception {
		Grammar g = new TestXmlGrammar().create();
		final Productions productions = g.getPhraseStructure();

		final IExecutableClient<IEntity> ci = f.createDescendantOrSelf().clone();
		ci.reset(productions);
		IVisitor v = GenericTraversalFactory.instance.topDown(new GenericIdentityVisitor() {
			public void visit(IEntity entity) {
				assertSame(entity, ci.evaluateNext());
			}
		}, false);
		v.visit(productions);
	}

    @Test
    public void testDescendantAndDescendantOrSelfIterators() {
		Grammar g = new TestXmlGrammar().create();

		IExecutableClient<IEntity> dsi = f.createDescendantOrSelf();
		dsi.reset(g);
		IExecutableClient<IEntity> di = f.createDescendant();
		di.reset(g);

		assertSame(g, dsi.evaluateNext());
		assertSame(dsi.evaluateNext(), di.evaluateNext());
		
		IEntity next;
		do {
			assertSame(dsi.evaluateNext(), di.evaluateNext());
			assertSame(next = dsi.evaluateNext(), di.evaluateNext());
		} while (next != null);
	}

    @Test
    public void testFragmentRootIterator() throws Exception {
		IEntity e = XmlBuilderPersistenceKit.instance().readModel(
				new ClasspathPersistenceProvider("org/whole/lang/templates/codebase/TemplateManagerArtifactsTemplates.xwl"));

		CompilationUnit cu = Matcher.find(JavaEntityDescriptorEnum.CompilationUnit, e, false);
		ImportModifier im = Matcher.find(JavaEntityDescriptorEnum.ImportModifier, e, false);

		IExecutable i1 = f.createRoot();
		i1.reset(im);
		assertSame(e, i1.evaluateNext());

		IExecutable i2 = f.createFragmentRoot();
		i2.reset(im);
		assertSame(cu, i2.evaluateNext());
	}

    @Test
    public void testRootIteratorMarkReset() {
		Grammar g = new TestXmlGrammar().create();
		NonTerminal prologNt = ((Production) ((Production) g.getPhraseStructure().wGet(0)).getRule().wGet(0)).getName();

		IExecutable i = f.createRoot();
		i.reset(prologNt);
		IExecutable i2 = i.clone();
		assertSame(g, i.evaluateNext());
		Assert.assertNull(i.evaluateNext());

		assertSame(g, i2.evaluateNext());
	}

	@Test
    public void testSelfIteratorMarkReset() {
		Grammar g = new TestXmlGrammar().create();
		
		IExecutableClient<Grammar> si = f.createSelf().client();
		si.reset(g);
		IExecutableClient<Grammar> si2 = si.clone();
		assertSame(g, si.evaluateNext());
		Assert.assertNull(si.evaluateNext());

		assertSame(g, si2.evaluateNext());
	}

	@Test
    public void testChildIteratorMarkReset() {
		Grammar g =  new TestXmlGrammar().create();
		
		IExecutableClient<IEntity> i = f.createChild().client();
		i.reset(g);
		i.evaluateNext();
		i.evaluateNext();
		IExecutableClient<IEntity> i2 = i.clone();
		IExecutableClient<IEntity> i3 = i.clone();
		IEntity e1 = i.evaluateNext();
		IEntity e2 = i.evaluateNext();

		assertSame(e1, i2.evaluateNext());

		assertSame(e1, i3.evaluateNext());
		assertSame(e2, i3.evaluateNext());
	}

	@Test
    public void testChildReverseIteratorMarkReset() {
		Grammar g = new TestXmlGrammar().create();
		
		IExecutableClient<IEntity> i = f.createChildReverse().client();
		i.reset(g);
		i.evaluateNext();
		i.evaluateNext();
		IExecutableClient<IEntity> i2 = i.clone();
		IExecutableClient<IEntity> i3 = i.clone();
		IEntity e1 = i.evaluateNext();
		IEntity e2 = i.evaluateNext();

		assertSame(e1, i2.evaluateNext());

		assertSame(e1, i3.evaluateNext());
		assertSame(e2, i3.evaluateNext());
	}

	@Test
    public void testParentIteratorMarkReset() {
		Grammar g = new TestXmlGrammar().create();
		Rule r = Matcher.find(GrammarsEntityDescriptorEnum.As, g, false);

		IExecutable i = f.createParent();
		i.reset(r);
		IExecutable i2 = i.clone();
		IEntity e1 = i.evaluateNext();
		assertSame(r.wGetParent(), e1);

		assertSame(r.wGetParent(), i2.evaluateNext());
	}

	@Test
    public void testAncestorIteratorMarkReset() {
		Grammar g = new TestXmlGrammar().create();
		Rule r = Matcher.find(GrammarsEntityDescriptorEnum.As, g, false);

		IExecutable i = f.createAncestor();
		i.reset(r);
		i.evaluateNext();
		i.evaluateNext();
		IExecutable i2 = i.clone();
		IExecutable i3 = i.clone();
		IEntity e1 = i.evaluateNext();
		IEntity e2 = i.evaluateNext();

		assertSame(e1, i2.evaluateNext());

		assertSame(e1, i3.evaluateNext());
		assertSame(e2, i3.evaluateNext());
	}

	@Test
    public void testAncestorOrSelfIteratorMarkReset() {
		Grammar g = new TestXmlGrammar().create();
		Rule r = Matcher.find(GrammarsEntityDescriptorEnum.As, g, false);

		IExecutable i = f.createAncestorOrSelf();
		i.reset(r);
		IEntity e1 = i.evaluateNext();
		assertSame(r, e1);
		e1 = i.evaluateNext();
		assertSame(r.wGetParent(), e1);
		IExecutable i2 = i.clone();
		IExecutable i3 = i.clone();
		e1 = i.evaluateNext();
		IEntity e2 = i.evaluateNext();

		assertSame(e1, i2.evaluateNext());

		assertSame(e1, i3.evaluateNext());
		assertSame(e2, i3.evaluateNext());
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

		IExecutable i = f.createAncestorOrSelf();
		i.reset(r);

		IEntity next;
		for (next = i.evaluateNext(); next != null; next = i.evaluateNext()) {
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
	}

	@Test
    public void testVariableIterator() {
		Grammar g = new TestXmlGrammar().create();

		IBindingManager bindings = BindingManagerFactory.instance.createBindingManager();
		IExecutable i = f.createVariable("testVar");
		i.setBindings(bindings);
		i.reset(g);
		Assert.assertNull(i.evaluateNext());
		bindings.wDef("testVar", g);
		IEntity g1 = i.evaluateNext();
		assertSame(g, g1);
		Assert.assertNull(i.evaluateNext());
		i.reset(g);
		g1 = i.evaluateNext();
		assertSame(g, g1);
		Assert.assertNull(i.evaluateNext());

		bindings = BindingManagerFactory.instance.createBindingManager();
		bindings.wDef("testVar", g);
		i = f.createVariable("testVar");
		i.setBindings(bindings);
		i.reset(BindingManagerFactory.instance.createNull());
		g1 = i.evaluateNext();
		assertSame(g, g1);
		Assert.assertNull(i.evaluateNext());
		i.reset(g);
		IExecutable i2 = i.clone();
		g1 = i.evaluateNext();
		assertSame(g, g1);
		Assert.assertNull(i.evaluateNext());

		g1 = i2.evaluateNext();
		assertSame(g, g1);
		Assert.assertNull(i2.evaluateNext());
	}

	@Test
    public void testRootBehavior() {
		Grammar g = new TestXmlGrammar().create();
		CommonsEntityFactory.instance.createRootFragment(
				g.wGetAdapter(CommonsEntityDescriptorEnum.Any));
		IEntity gParent = g.wGetParent(); //rootParent

		IExecutableClient<IEntity> i = f.createRoot().client();
		i.reset(g);
		IEntity e1 = i.evaluateNext();
		assertSame(g, e1);
		
		i = f.createRoot().client();
		i.reset(gParent);
		e1 = i.evaluateNext();
		assertSame(g, e1);
		
		i = f.createFragmentRoot().client();
		i.reset(gParent);
		e1 = i.evaluateNext();
		assertSame(g, e1);
		
		i = f.createParent().client();
		i.reset(g);
		e1 = i.evaluateNext();
		assertSame(g.wGetParent(), e1);

		i = f.createParent().client();
		i.reset(gParent);
		assertNull(i.evaluateNext());

		i = f.createAncestor().client();
		i.reset(g);
		e1 = i.evaluateNext();
		assertSame(g.wGetParent(), e1);

		i = f.createAncestor().client();
		i.reset(gParent);
		assertNull(i.evaluateNext());

		i = f.createAncestorOrSelf().client();
		i.reset(g);
		e1 = i.evaluateNext();
		assertSame(g, e1);
		e1 = i.evaluateNext();
		assertSame(g.wGetParent(), e1);

		i = f.createAncestorOrSelf().client();
		i.reset(gParent);
		e1 = i.evaluateNext();
		assertSame(g.wGetParent(), e1);
		assertNull(i.evaluateNext());

		IExecutableClient<Grammar> i2 = f.createSelf().client();
		i2.reset(g);
		e1 = i2.evaluateNext();
		assertSame(g, e1);
		assertNull(i2.evaluateNext());

		i = f.createSelf().client();
		i.reset(gParent);
		e1 = i.evaluateNext();
		assertSame(gParent, e1);
		assertNull(i.evaluateNext());


		g = GrammarsEntityFactory.instance.createGrammar();

		gParent = g.wGetParent(); //nullEntity

		i = f.createRoot().client();
		i.reset(g);
		e1 = i.evaluateNext();
		assertSame(g, e1);
		
		i = f.createRoot().client();
		i.reset(gParent);
		assertNull(i.evaluateNext());
		
		i = f.createParent().client();
		i.reset(g);
		assertNull(i.evaluateNext());
		i = f.createParent().client();
		i.reset(gParent);
		assertNull(i.evaluateNext());

		i = f.createAncestor().client();
		i.reset(g);
		assertNull(i.evaluateNext());
		i = f.createAncestor().client();
		i.reset(gParent);
		assertNull(i.evaluateNext());

		i = f.createAncestorOrSelf().client();
		i.reset(g);
		e1 = i.evaluateNext();
		assertSame(g, e1);
		assertNull(i.evaluateNext());

		i = f.createAncestorOrSelf().client();
		i.reset(gParent);
		assertNull(i.evaluateNext());

		i2 = f.createSelf().client();
		i2.reset(g);
		e1 = i2.evaluateNext();
		assertSame(g, e1);
		assertNull(i2.evaluateNext());

		i = f.createSelf().client();
		i.reset(gParent);
		assertNull(i.evaluateNext());
	}

	@Test
    public void testTopDownIteratorMarkReset() {
		Grammar g = new TestXmlGrammar().create();

		IExecutableClient<IEntity> i = f.createDescendantOrSelf().client();
		i.reset(g);
		for (int j=0; j<15; j++)
			i.evaluateNext();
		IExecutableClient<IEntity> i2 = i.clone();
		IExecutableClient<IEntity> i3 = i.clone();
		IEntity e1 = i.evaluateNext();
		IEntity e2 = i.evaluateNext();
		for (int j=0; j<7; j++)
			i.evaluateNext();

		assertSame(e1, i2.evaluateNext());

		assertSame(e1, i3.evaluateNext());
		assertSame(e2, i3.evaluateNext());
	}

	@Test
    public void testChildIteratorAdd() {
		Grammar g = new TestXmlGrammar().create();

		Productions productions = g.getPhraseStructure();
		int size = productions.wSize();
		int count = 0;
		Production pAdded1 = null;
		Production pAdded2 = null;
		
		IExecutableClient<Production> i = f.createChild().client();
		i.reset(productions);
		Production p;
		while ((p = i.evaluateNext()) != null) {
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
		
		IExecutableClient<Production> i = f.createChildReverse().client();
		i.reset(productions);
		Production p;
		while ((p = i.evaluateNext()) != null) {
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
		
		IExecutableClient<IEntity> i = f.createDescendantOrSelf().client();
		i.reset(production);
		i.evaluateNext();
		i.evaluateNext();
		IEntity r;
		while ((r = i.evaluateNext()) != null) {
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

	@Test
    public void testSequenceIterator() {
		Grammar g = new TestXmlGrammar().create();

		Productions p1 = g.getPhraseStructure();
		Productions p2 = g.getLexicalStructure();
		
		ExecutableFactory f = ExecutableFactory.instance;
		
		List<Production> p3 = new ArrayList<Production>();
		IExecutableClient<Production> i11 = f.createChild().client();
		i11.reset(p1);
		for (Production p : i11)
			p3.add(p);
		IExecutableClient<Production> i12 = f.createChild().client();
		i12.reset(p2);
		for (Production p : i12)
			p3.add(p);
		
		Iterator<Production> i = p3.iterator();
		
		IExecutableClient<Production> pi = f.createSequence(f.createConstantChild(p1), f.createConstantChild(p2)).client();
		pi.reset(BindingManagerFactory.instance.createNull());
		for (Production p : pi)
			assertSame(i.next(), p);
	}

	@Test
    public void testComposeIterator() {
		Grammar g = new TestXmlGrammar().create();

		//query: g/phraseStructure/child()[ED = Production]/rule//[ED = Production]
		IExecutableClient<Production> pi = f.createCompose(
				f.createFilter(f.createDescendantOrSelf(), f.createHasType(GrammarsEntityDescriptorEnum.Production.getURI())),
				f.createFeatureByName("rule"),
				f.createFilter(f.createChild(), f.createHasType(GrammarsEntityDescriptorEnum.Production.getURI())),
				f.createFeatureByName("phraseStructure")).client();

		pi.reset(g);
		Set<String> l = new HashSet<String>();
		for (Production p : pi)
			l.add(p.getName().getValue());
		
		assertEquals(16, l.size());


		NonTerminal prologNt = ((Production) ((Production) g.getPhraseStructure().wGet(0)).getRule().wGet(0)).getName();

		//query: g/phraseStructure/0/rule/0/name
		IExecutable nti = f.createCompose(
				f.createFeatureByName("name"),
				f.createFeatureByIndex(0),
				f.createFeatureByName("rule"),
				f.createFeatureByIndex(0),
				f.createFeatureByName("phraseStructure"));
		nti.reset(g);

		assertSame(prologNt, nti.evaluateNext());
		
		nti.reset(g.getPhraseStructure());
		assertNull(nti.evaluateNext());

		nti.reset(g);
		assertSame(prologNt, nti.evaluateNext());		
	}

	@Test
    public void testPrune() {
		Grammar g = new TestXmlGrammar().create();

		IExecutableClient<IEntity> i1 = f.createDescendantOrSelf().client();
		i1.reset(g);
		IExecutableClient<IEntity> i2 = f.createDescendantOrSelf().client();
		i2.reset(g);
		for (IEntity e : i1) {
			assertSame(e, i2.evaluateNext());
			
			IExecutableClient<IEntity> i12 = i1.clone();
			i12.prune();
		}
		assertSame(i1.evaluateNext() != null, i2.evaluateNext() != null);
		
		i1 = f.createDescendantOrSelf().client();
		i1.reset(g);
		for (IEntity e : i1) {
			IExecutableClient<IEntity> i3 = f.createFollowingSibling().client();
			i3.reset(e);
			IEntity e2 = i3.evaluateNext();
			if (e2 != null) {
				IExecutableClient<IEntity> i12 = i1.clone();
				i12.prune();

				IEntity e1 = i12.evaluateNext();
				assertSame(e1, e2);
			}
		}
	}

	@Test
    public void testFollowingIterator() {
		Grammar g = new TestXmlGrammar().create();

		IExecutableClient<IEntity> tdi = f.createDescendantOrSelf().client();
		tdi.reset(g);

		for (IEntity e : tdi) {
			IExecutableClient<IEntity> fi = f.createFollowing().client();
			fi.reset(e);
			
			IEntity fe = fi.evaluateNext();
			if (fe != null) {
				IExecutableClient<IEntity> tdi2 = tdi.clone();
				tdi2.prune();
				
				for (; fe != null; fe = fi.evaluateNext()) {
					IEntity e1 = tdi2.evaluateNext();
					assertSame(e1, fe);
				}
			}
		}
	}

	@Test
    public void testPrecedingIterator() {
		Grammar g = new TestXmlGrammar().create();

		IExecutableClient<IEntity> tdi = f.createDescendantOrSelfReverse().client();
		tdi.reset(g);

		for (IEntity e : tdi) {
			IExecutableClient<IEntity> fi = f.createPreceding().client();
			fi.reset(e);
			
			IEntity fe = fi.evaluateNext();
			if (fe != null) {
				IExecutableClient<IEntity> tdi2 = tdi.clone();
				tdi2.prune();
				
				for (; fe != null; fe = fi.evaluateNext()) {
					IEntity e1 = tdi2.evaluateNext();
					assertSame(e1, fe);
				}
			}
		}
	}

	@Test
    public void testAxesPartitionInvariant() {
		Grammar g = new TestXmlGrammar().create();

		IExecutableClient<IEntity> i = f.createDescendantOrSelf().client();
		i.reset(g);
		Set<IEntity> s = entities(i);

		IExecutableClient<IEntity> i2 = f.createDescendantOrSelf().client();
		i2.reset(g);
		for (IEntity e : i2) {
			IExecutableClient<IEntity> i1 = f.createAncestor().client();
			i1.reset(e);
			Set<IEntity> s1 = entities(i1);
			IExecutableClient<IEntity> i22 = f.createSelf().client();
			i22.reset(e);
			Set<IEntity> s2 = entities(i22);
			IExecutableClient<IEntity> i3 = f.createDescendant().client();
			i3.reset(e);
			Set<IEntity> s3 = entities(i3);
			IExecutableClient<IEntity> i4 = f.createPreceding().client();
			i4.reset(e);
			Set<IEntity> s4 = entities(i4);
			IExecutableClient<IEntity> i5 = f.createFollowing().client();
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
	private Set<IEntity> entities(IExecutableClient<IEntity> i) {
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
		
		IExecutable i = f.createFilterByIndex(
				f.createFollowingSibling(), 0);
		i.reset(p);
		assertSingleton(i, productions.wGet(2));
		
		i = f.createFilterByIndex(
				f.createFollowingSibling(), 1);
		i.reset(p);
		assertSingleton(i, productions.wGet(3));
		
		i = f.createFilterByIndex(
				f.createAncestorOrSelf(), 2);
		i.reset(p);
		assertSingleton(i, productions.wGetParent());
		
		i = f.createFilterByIndex(
				f.createDescendantOrSelf(), 1);
		i.reset(p);
		assertSingleton(i, p.getName());
	}

	private void assertSingleton(IExecutable i, IEntity e) {
		IExecutable i2 = i.clone();
		assertSame(e, i.evaluateNext());
		assertNull(i.evaluateNext());

		assertSame(e, i2.evaluateNext());
		assertNull(i2.evaluateNext());
	}
}
