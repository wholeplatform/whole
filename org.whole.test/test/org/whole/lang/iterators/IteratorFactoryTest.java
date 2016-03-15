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
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.codebase.ClasspathPersistenceProvider;
import org.whole.lang.commons.factories.CommonsEntityFactory;
import org.whole.lang.commons.reflect.CommonsEntityDescriptorEnum;
import org.whole.lang.grammars.factories.GrammarsEntityFactory;
import org.whole.lang.grammars.model.Choose;
import org.whole.lang.grammars.model.Grammar;
import org.whole.lang.grammars.model.NonTerminal;
import org.whole.lang.grammars.model.Production;
import org.whole.lang.grammars.model.Productions;
import org.whole.lang.grammars.model.Rule;
import org.whole.lang.grammars.reflect.GrammarsEntityDescriptorEnum;
import org.whole.lang.grammars.reflect.GrammarsFeatureDescriptorEnum;
import org.whole.lang.grammars.util.TestXmlGrammar;
import org.whole.lang.java.model.CompilationUnit;
import org.whole.lang.java.model.ImportModifier;
import org.whole.lang.java.reflect.JavaEntityDescriptorEnum;
import org.whole.lang.matchers.GenericMatcherFactory;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.IEntity;
import org.whole.lang.models.codebase.ArtifactsModel;
import org.whole.lang.models.factories.ModelsEntityFactory;
import org.whole.lang.models.model.Type;
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
    @BeforeClass
    public static void deployWholePlatform() {
    	ReflectionFactory.deployWholePlatform();
    }

    @Test
    public void testChildByNameAndByIndexIterators() {
		Grammar g = new TestXmlGrammar().create();
	
		IEntityIterator<IEntity> i1 = IteratorFactory.featureByNameIterator("phraseStructure");
		i1.reset(g);
		assertTrue(i1.hasNext());
		assertSame(g.getPhraseStructure(), i1.next());
		assertFalse(i1.hasNext());
		assertNull(i1.lookahead());

		IEntityIterator<IEntity> i2 = IteratorFactory.featureByIndexIterator(0);
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
		IEntityIterator<Production> ci = IteratorFactory.<Production>childIterator();
		ci.reset(productions);
		while (ci.hasNext()) {
			Production p = ci.next();
			assertSame(productions.wGet(index++), p);
		}

		index = 0;
		ci = IteratorFactory.<Production>childScannerIterator();
		ci.reset(productions);
		while (ci.hasNext()) {
			Production p = ci.next();
			assertSame(productions.wGet(index++), p);
		}

		index = 0;
		ci = IteratorFactory.<Production>childMatcherIterator()
				.withPattern(GrammarsEntityDescriptorEnum.Production);
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
		IEntityIterator<Production> ci = IteratorFactory.<Production>childIterator();
		ci.reset(productions);
		while (ci.hasNext()) {
			Production p = ci.next();
			IEntityIterator<Production> fi = IteratorFactory.<Production>followingSiblingIterator();
			fi.reset(p);
			int findex = ++index;
			for (Production fp : fi)
				assertSame(productions.wGet(findex++), fp);
		}
		
		for (int i=0; i<g.wSize(); i++) {
			IEntityIterator<IEntity> fi = IteratorFactory.<IEntity>followingSiblingIterator();
			fi.reset(g.wGet(i));
			for (int j=i+1; j<g.wSize(); j++)
				assertSame(g.wGet(j), fi.next());
		}

		for (int i=0; i<productions.wSize(); i++) {
			IEntityIterator<Production> fi = IteratorFactory.<Production>followingSiblingIterator();
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
		IEntityIterator<Production> ci = IteratorFactory.<Production>childIterator();
		ci.reset(productions);
		while (ci.hasNext()) {
			Production p = ci.next();
			IEntityIterator<Production> fi = IteratorFactory.<Production>precedingSiblingIterator();
			fi.reset(p);
			int findex = index++;
			for (Production fp : fi)
				assertSame(productions.wGet(--findex), fp);
		}
		
		for (int i=g.wSize()-1; i>=0; i--) {
			IEntityIterator<IEntity> fi = IteratorFactory.<IEntity>precedingSiblingIterator();
			fi.reset(g.wGet(i));
			for (int j=i-1; j>=0; j--)
				assertSame(g.wGet(j), fi.next());
		}

		for (int i=productions.wSize()-1; i>=0; i--) {
			IEntityIterator<Production> fi = IteratorFactory.<Production>precedingSiblingIterator();
			fi.reset(productions.wGet(i));
			for (int j=i-1; j>=0; j--)
				assertSame(productions.wGet(j), fi.next());
		}
	}

    @Test
    public void testChildIteratorRemove() {
		Grammar g = new TestXmlGrammar().create();

		Productions productions = EntityUtils.clone(g.getPhraseStructure());
		IEntityIterator<Production> ci = IteratorFactory.<Production>childIterator();
		ci.reset(productions);
		while (ci.hasNext()) {
			Production p = ci.next();
			assertSame(productions.wGet(0), p);
			ci.remove();
		}
		assertEquals(0, productions.wSize());

		productions = EntityUtils.clone(g.getPhraseStructure());
		ci = IteratorFactory.<Production>childScannerIterator();
		ci.reset(productions);
		while (ci.hasNext()) {
			Production p = ci.next();
			assertSame(productions.wGet(0), p);
			ci.remove();
		}
		assertEquals(0, productions.wSize());

		productions = EntityUtils.clone(g.getPhraseStructure());
		ci = IteratorFactory.<Production>childMatcherIterator()
				.withPattern(GrammarsEntityDescriptorEnum.Production);
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
		IEntityIterator<Production> ci = IteratorFactory.<Production>childReverseIterator();
		ci.reset(productions);
		while (ci.hasNext()) {
			Production p = ci.next();
			assertSame(productions.wGet(--index), p);
		}

		index = productions.wSize();
		ci = IteratorFactory.<Production>childReverseScannerIterator();
		ci.reset(productions);
		while (ci.hasNext()) {
			Production p = ci.next();
			assertSame(productions.wGet(--index), p);
		}

		index = productions.wSize();
		ci = IteratorFactory.<Production>childReverseMatcherIterator()
				.withPattern(GrammarsEntityDescriptorEnum.Production);
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
		IEntityIterator<Production> ci = IteratorFactory.<Production>childReverseIterator();
		ci.reset(productions);
		while (ci.hasNext()) {
			Production p = ci.next();
			assertSame(productions.wGet(productions.wSize()-1), p);
			ci.remove();
		}
		assertEquals(0, productions.wSize());

		productions = EntityUtils.clone(g.getPhraseStructure());
		ci = IteratorFactory.<Production>childReverseScannerIterator();
		ci.reset(productions);
		while (ci.hasNext()) {
			Production p = ci.next();
			assertSame(productions.wGet(productions.wSize()-1), p);
			ci.remove();
		}
		assertEquals(0, productions.wSize());

		productions = EntityUtils.clone(g.getPhraseStructure());
		ci = IteratorFactory.<Production>childReverseMatcherIterator()
				.withPattern(GrammarsEntityDescriptorEnum.Production);
		ci.reset(productions);
		while (ci.hasNext()) {
			Production p = ci.next();
			assertSame(productions.wGet(productions.wSize()-1), p);
			ci.remove();
		}
		assertEquals(0, productions.wSize());
	}

    @Test
    public void testTopDownIterator() {
		Grammar g = new TestXmlGrammar().create();
		final Productions productions = g.getPhraseStructure();

		final IEntityIterator<IEntity> ci = IteratorFactory.<IEntity>descendantOrSelfIterator();
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

		final IEntityIterator<IEntity> ci2 = IteratorFactory.<IEntity>descendantOrSelfScannerIterator();
		ci2.reset(productions);
		v = GenericTraversalFactory.instance.topDown(new GenericIdentityVisitor() {
			public void visit(IEntity entity) {
				if (EntityUtils.isResolver(entity))
					return;

				if (ci2.hasNext())
					assertSame(entity, ci2.next());
				else
					fail();
			}
		}, false);
		v.visit(productions);

		final IEntityIterator<IEntity> ci3 = IteratorFactory.<IEntity>descendantOrSelfMatcherIterator()
				.withPattern(GrammarsEntityDescriptorEnum.Production);
		ci3.reset(productions);
		v = GenericTraversalFactory.instance.topDown(new GenericIdentityVisitor() {
			public void visit(IEntity entity) {
				if (!Matcher.match(GrammarsEntityDescriptorEnum.Production, entity))
					return;
					
				if (ci3.hasNext())
					assertSame(entity, ci3.next());
				else
					fail();
			}
		}, false);
		v.visit(productions);
		
		IEntity artifactsModel = new ArtifactsModel().create();
		Set<Type> typeSet = new HashSet<Type>();
		IEntityIterator<Type> ci4 = IteratorFactory.<Type>descendantOrSelfMatcherIterator()
				.withPattern(ModelsEntityFactory.instance.createSimpleName("Atifacts"));
		ci4.reset(artifactsModel);
		while (ci4.hasNext())
			assertTrue(typeSet.add(ci4.next()));
	}

    @Test
    public void testDescendantAndDescendantOrSelfIterators() {
		Grammar g = new TestXmlGrammar().create();

		IEntityIterator<IEntity> dsi = IteratorFactory.<IEntity>descendantOrSelfIterator();
		dsi.reset(g);
		IEntityIterator<IEntity> di = IteratorFactory.<IEntity>descendantIterator();
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

		IEntityIterator<IEntity> i1 = IteratorFactory.rootIterator();
		i1.reset(im);
		assertTrue(i1.hasNext());
		assertSame(e, i1.next());

		IEntityIterator<IEntity> i2 = IteratorFactory.fragmentRootIterator();
		i2.reset(im);
		assertTrue(i2.hasNext());
		assertSame(cu, i2.next());
	}

    @Test
    public void testRootIteratorMarkReset() {
		Grammar g = new TestXmlGrammar().create();
		NonTerminal prologNt = ((Production) ((Production) g.getPhraseStructure().wGet(0)).getRule().wGet(0)).getName();

		IEntityIterator<IEntity> i = IteratorFactory.rootIterator();
		i.reset(prologNt);
		IEntityIterator<IEntity> i2 = i.clone();
		assertTrue(i.hasNext());
		assertSame(g, i.next());
		assertFalse(i.hasNext());

		assertTrue(i2.hasNext());
		assertSame(g, i2.next());
	}

	@Test
    public void testSelfIteratorMarkReset() {
		Grammar g = new TestXmlGrammar().create();
		
		IEntityIterator<Grammar> si = IteratorFactory.<Grammar>selfIterator();
		si.reset(g);
		IEntityIterator<Grammar> si2 = si.clone();
		assertSame(g, si.next());
		assertFalse(si.hasNext());

		assertTrue(si2.hasNext());
		assertSame(g, si2.next());
	}

	@Test
    public void testChildIteratorMarkReset() {
		Grammar g =  new TestXmlGrammar().create();
		
		IEntityIterator<IEntity> i = IteratorFactory.<IEntity>childIterator();
		i.reset(g);
		i.next();
		i.next();
		IEntityIterator<IEntity> i2 = i.clone();
		IEntityIterator<IEntity> i3 = i.clone();
		IEntity e1 = i.next();
		IEntity e2 = i.next();

		assertSame(e1, i2.next());

		assertSame(e1, i3.next());
		assertSame(e2, i3.next());
	}

	@Test
    public void testChildReverseIteratorMarkReset() {
		Grammar g = new TestXmlGrammar().create();
		
		IEntityIterator<IEntity> i = IteratorFactory.<IEntity>childReverseIterator();
		i.reset(g);
		i.next();
		i.next();
		IEntityIterator<IEntity> i2 = i.clone();
		IEntityIterator<IEntity> i3 = i.clone();
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

		IEntityIterator<IEntity> i = IteratorFactory.parentIterator();
		i.reset(r);
		IEntityIterator<IEntity> i2 = i.clone();
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

		IEntityIterator<IEntity> i = IteratorFactory.ancestorIterator();
		i.reset(r);
		i.next();
		i.next();
		IEntityIterator<IEntity> i2 = i.clone();
		IEntityIterator<IEntity> i3 = i.clone();
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

		IEntityIterator<IEntity> i = IteratorFactory.ancestorOrSelfIterator();
		i.reset(r);
		IEntity e1 = i.next();
		assertSame(r, e1);
		e1 = i.next();
		assertSame(r.wGetParent(), e1);
		IEntityIterator<IEntity> i2 = i.clone();
		IEntityIterator<IEntity> i3 = i.clone();
		e1 = i.next();
		IEntity e2 = i.next();

		assertSame(e1, i2.next());

		assertSame(e1, i3.next());
		assertSame(e2, i3.next());
	}

	@Test
    public void testVariableIterator() {
		Grammar g = new TestXmlGrammar().create();

		IBindingManager bindings = BindingManagerFactory.instance.createBindingManager();
		IEntityIterator<IEntity> i = IteratorFactory.variableIterator("testVar");
		i.setBindings(bindings);
		assertFalse(i.hasNext());
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
		i = IteratorFactory.variableIterator("testVar");
		i.setBindings(bindings);
		assertTrue(i.hasNext());
		g1 = i.next();
		assertSame(g, g1);
		assertFalse(i.hasNext());
		i.reset(g);
		IEntityIterator<IEntity> i2 = i.clone();
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

		IEntityIterator<IEntity> i = IteratorFactory.rootIterator();
		i.reset(g);
		assertTrue(i.hasNext());
		IEntity e1 = i.next();
		assertSame(g, e1);
		
		i = IteratorFactory.rootIterator();
		i.reset(gParent);
		assertTrue(i.hasNext());
		e1 = i.next();
		assertSame(g, e1);
		
		i = IteratorFactory.fragmentRootIterator();
		i.reset(gParent);
		assertTrue(i.hasNext());
		e1 = i.next();
		assertSame(g, e1);
		
		i = IteratorFactory.parentIterator();
		i.reset(g);
		assertTrue(i.hasNext());
		e1 = i.next();
		assertSame(g.wGetParent(), e1);

		i = IteratorFactory.parentIterator();
		i.reset(gParent);
		assertFalse(i.hasNext());
		assertNull(i.lookahead());

		i = IteratorFactory.ancestorIterator();
		i.reset(g);
		assertTrue(i.hasNext());
		e1 = i.next();
		assertSame(g.wGetParent(), e1);

		i = IteratorFactory.ancestorIterator();
		i.reset(gParent);
		assertFalse(i.hasNext());
		assertNull(i.lookahead());

		i = IteratorFactory.ancestorOrSelfIterator();
		i.reset(g);
		assertTrue(i.hasNext());
		e1 = i.next();
		assertSame(g, e1);
		assertTrue(i.hasNext());
		e1 = i.next();
		assertSame(g.wGetParent(), e1);

		i = IteratorFactory.ancestorOrSelfIterator();
		i.reset(gParent);
		assertTrue(i.hasNext());
		e1 = i.next();
		assertSame(g.wGetParent(), e1);
		assertFalse(i.hasNext());
		assertNull(i.lookahead());

		IEntityIterator<Grammar> i2 = IteratorFactory.selfIterator();
		i2.reset(g);
		assertTrue(i2.hasNext());
		e1 = i2.next();
		assertSame(g, e1);
		assertFalse(i2.hasNext());
		assertNull(i2.lookahead());

		i = IteratorFactory.selfIterator();
		i.reset(gParent);
		assertTrue(i.hasNext());
		e1 = i.next();
		assertSame(gParent, e1);
		assertFalse(i.hasNext());
		assertNull(i.lookahead());


		g = GrammarsEntityFactory.instance.createGrammar();

		gParent = g.wGetParent(); //nullEntity

		i = IteratorFactory.rootIterator();
		i.reset(g);
		assertTrue(i.hasNext());
		e1 = i.next();
		assertSame(g, e1);
		
		i = IteratorFactory.rootIterator();
		i.reset(gParent);
		assertFalse(i.hasNext());
		assertNull(i.lookahead());
		
		i = IteratorFactory.parentIterator();
		i.reset(g);
		assertFalse(i.hasNext());
		assertNull(i.lookahead());
		i = IteratorFactory.parentIterator();
		i.reset(gParent);
		assertFalse(i.hasNext());
		assertNull(i.lookahead());

		i = IteratorFactory.ancestorIterator();
		i.reset(g);
		assertFalse(i.hasNext());
		assertNull(i.lookahead());
		i = IteratorFactory.ancestorIterator();
		i.reset(gParent);
		assertFalse(i.hasNext());
		assertNull(i.lookahead());

		i = IteratorFactory.ancestorOrSelfIterator();
		i.reset(g);
		assertTrue(i.hasNext());
		e1 = i.next();
		assertSame(g, e1);
		assertFalse(i.hasNext());
		assertNull(i.lookahead());

		i = IteratorFactory.ancestorOrSelfIterator();
		i.reset(gParent);
		assertFalse(i.hasNext());
		assertNull(i.lookahead());

		i2 = IteratorFactory.selfIterator();
		i2.reset(g);
		assertTrue(i2.hasNext());
		e1 = i2.next();
		assertSame(g, e1);
		assertFalse(i2.hasNext());
		assertNull(i2.lookahead());

		i = IteratorFactory.selfIterator();
		i.reset(gParent);
		assertFalse(i.hasNext());
		assertNull(i.lookahead());		
	}

	@Test
    public void testTopDownIteratorMarkReset() {
		Grammar g = new TestXmlGrammar().create();

		IEntityIterator<IEntity> i = IteratorFactory.<IEntity>descendantOrSelfIterator();
		i.reset(g);
		for (int j=0; j<15; j++)
			i.next();
		IEntityIterator<IEntity> i2 = i.clone();
		IEntityIterator<IEntity> i3 = i.clone();
		IEntity e1 = i.next();
		IEntity e2 = i.next();
		for (int j=0; j<7; j++)
			i.next();

		assertSame(e1, i2.next());

		assertSame(e1, i3.next());
		assertSame(e2, i3.next());
	}

	@Test
    public void testTopDownScannerIteratorMarkReset() {
		Grammar g = new TestXmlGrammar().create();

		IEntityIterator<IEntity> i = IteratorFactory.<IEntity>descendantOrSelfScannerIterator();
		i.reset(g);
		for (int j=0; j<15; j++)
			i.next();
		IEntityIterator<IEntity> i2 = i.clone();
		IEntityIterator<IEntity> i3 = i.clone();
		IEntity e1 = i.next();
		IEntity e2 = i.next();
		for (int j=0; j<7; j++)
			i.next();

		assertSame(e1, i2.next());

		assertSame(e1, i3.next());
		assertSame(e2, i3.next());
	}

	@Test
    public void testTopDownMatcherIteratorMarkReset() {
		Grammar g = new TestXmlGrammar().create();

		IEntityIterator<IEntity> i = IteratorFactory.<IEntity>descendantOrSelfMatcherIterator()
				.withPattern(GrammarsEntityDescriptorEnum.Rule);
		i.reset(g);
		for (int j=0; j<15; j++)
			i.next();
		IEntityIterator<IEntity> i2 = i.clone();
		IEntityIterator<IEntity> i3 = i.clone();
		IEntity e1 = i.next();
		IEntity e2 = i.next();
		for (int j=0; j<7; j++)
			i.next();

		assertSame(e1, i2.next());

		assertSame(e1, i3.next());
		assertSame(e2, i3.next());
	}
	@Test
    public void testTopDownMatcherIteratorRemove() {
		Grammar g = new TestXmlGrammar().create();
		g.wRemove(GrammarsFeatureDescriptorEnum.lexicalStructure);

		Productions productions = g.getPhraseStructure();
		IEntityIterator<Production> ci = IteratorFactory.<Production>descendantOrSelfMatcherIterator()
				.withPattern(GrammarsEntityDescriptorEnum.Production);
		ci.reset(g);
		while (ci.hasNext()) {
			Production p = ci.next();
			assertSame(productions.wGet(0), p);
			ci.remove();
		}
		assertEquals(0, productions.wSize());

		g = new TestXmlGrammar().create();
		IEntityIterator<NonTerminal> ci2 = IteratorFactory.<NonTerminal>descendantOrSelfMatcherIterator()
				.withPattern(GrammarsEntityDescriptorEnum.NonTerminal);
		ci2.reset(g);
		while (ci2.hasNext()) {
			NonTerminal nt = ci2.next();
			ci2.remove();
		}
		assertNull(Matcher.find(GenericTraversalFactory.instance.sequence(
				GenericMatcherFactory.instance.hasTypeMatcher(GrammarsEntityDescriptorEnum.NonTerminal),
				GenericMatcherFactory.instance.isImplMatcher()), g, false));
	}

	@Test
    public void testChildIteratorAdd() {
		Grammar g = new TestXmlGrammar().create();

		Productions productions = g.getPhraseStructure();
		int size = productions.wSize();
		int count = 0;
		Production pAdded1 = null;
		Production pAdded2 = null;
		
		IEntityIterator<Production> i = IteratorFactory.<Production>childIterator();
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
    public void testChildScannerIteratorAdd() {
		Grammar g = new TestXmlGrammar().create();

		Productions productions = g.getPhraseStructure();
		int size = productions.wSize();
		int count = 0;
		Production pAdded1 = null;
		Production pAdded2 = null;
		
		IEntityIterator<Production> i = IteratorFactory.<Production>childScannerIterator();
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
		
		IEntityIterator<Production> i = IteratorFactory.<Production>childReverseIterator();
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
		
		IEntityIterator<IEntity> i = IteratorFactory.<IEntity>descendantOrSelfIterator();
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
		
		List<Production> p3 = new ArrayList<Production>();
		IEntityIterator<Production> i11 = IteratorFactory.<Production>childIterator();
		i11.reset(p1);
		for (Production p : i11)
			p3.add(p);
		IEntityIterator<Production> i12 = IteratorFactory.<Production>childIterator();
		i12.reset(p2);
		for (Production p : i12)
			p3.add(p);
		
		Iterator<Production> i = p3.iterator();
		IEntityIterator<Production> i21 = IteratorFactory.<Production>childIterator();
		i21.reset(p1);
		IEntityIterator<Production> i22 = IteratorFactory.<Production>childIterator();
		i22.reset(p2);
		for (Production p : IteratorFactory.sequenceIterator(i21, i22))
			assertSame(i.next(), p);
		
		//FIXME remove <NonTerminal> from topDownIterators
		IEntityIterator<NonTerminal> i1p1 = IteratorFactory.<NonTerminal>descendantOrSelfIterator();
		i1p1.reset(p1);
		IEntityIterator<NonTerminal> i1p2 = IteratorFactory.<NonTerminal>descendantOrSelfIterator();
		i1p2.reset(p2);
		IEntityIterator<NonTerminal> i1 = IteratorFactory.<NonTerminal>matcherIterator(
				IteratorFactory.sequenceIterator(i1p1, i1p2))
						.withPattern(GrammarsEntityDescriptorEnum.NonTerminal);

		IEntityIterator<NonTerminal> i2p1 = IteratorFactory.<NonTerminal>descendantOrSelfIterator();
		i2p1.reset(p1);
		IEntityIterator<NonTerminal> i2p2 = IteratorFactory.<NonTerminal>descendantOrSelfIterator();
		i2p2.reset(p2);
		IEntityIterator<NonTerminal> i2 = IteratorFactory.sequenceIterator(
				IteratorFactory.<NonTerminal>matcherIterator(i2p1).withPattern(GrammarsEntityDescriptorEnum.NonTerminal),
				IteratorFactory.matcherIterator(i2p2).withPattern(GrammarsEntityDescriptorEnum.NonTerminal));

		for (NonTerminal nt : i1)
			assertSame(i2.next(), nt);
	}

	@Test
    public void testComposeIterator() {
		Grammar g = new TestXmlGrammar().create();

		//query: g/phraseStructure/child()[ED = Production]/rule//[ED = Production]
		IEntityIterator<Production> pi = IteratorFactory.composeIterator(
				IteratorFactory.<Production>descendantOrSelfMatcherIterator().withPattern(GrammarsEntityDescriptorEnum.Production),
				IteratorFactory.featureByNameIterator("rule"),
				IteratorFactory.<Production>childMatcherIterator().withPattern(GrammarsEntityDescriptorEnum.Production),
				IteratorFactory.featureByNameIterator("phraseStructure"));

		pi.reset(g);
		Set<String> l = new HashSet<String>();
		for (Production p : pi)
			l.add(p.getName().getValue());
		
		assertEquals(16, l.size());


		NonTerminal prologNt = ((Production) ((Production) g.getPhraseStructure().wGet(0)).getRule().wGet(0)).getName();

		//query: g/phraseStructure/0/rule/0/name
		IEntityIterator<? extends IEntity> nti = IteratorFactory.composeIterator(
				IteratorFactory.featureByNameIterator("name"),
				IteratorFactory.featureByIndexIterator(0),
				IteratorFactory.featureByNameIterator("rule"),
				IteratorFactory.featureByIndexIterator(0),
				IteratorFactory.featureByNameIterator("phraseStructure"));
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

		IEntityIterator<IEntity> i1 = IteratorFactory.<IEntity>descendantOrSelfIterator();
		i1.reset(g);
		IEntityIterator<IEntity> i2 = IteratorFactory.<IEntity>descendantOrSelfIterator();
		i2.reset(g);
		for (IEntity e : i1) {
			assertSame(e, i2.next());
			
			IEntityIterator<IEntity> i12 = i1.clone();
			i12.prune();
		}
		assertSame(i1.hasNext(), i2.hasNext());
		
		i1 = IteratorFactory.<IEntity>descendantOrSelfIterator();
		i1.reset(g);
		for (IEntity e : i1) {
			IEntityIterator<IEntity> i3 = IteratorFactory.<IEntity>followingSiblingIterator();
			i3.reset(e);
			if (i3.hasNext()) {
				IEntityIterator<IEntity> i12 = i1.clone();
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

		IEntityIterator<IEntity> tdi = IteratorFactory.<IEntity>descendantOrSelfIterator();
		tdi.reset(g);

		for (IEntity e : tdi) {
			IEntityIterator<IEntity> fi = IteratorFactory.<IEntity>followingIterator();
			fi.reset(e);
			
			if (fi.hasNext()) {
				IEntityIterator<IEntity> tdi2 = tdi.clone();
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

		IEntityIterator<IEntity> tdi = IteratorFactory.<IEntity>descendantOrSelfReverseIterator();
		tdi.reset(g);

		for (IEntity e : tdi) {
			IEntityIterator<IEntity> fi = IteratorFactory.<IEntity>precedingIterator();
			fi.reset(e);
			
			if (fi.hasNext()) {
				IEntityIterator<IEntity> tdi2 = tdi.clone();
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

		IEntityIterator<IEntity> i = IteratorFactory.<IEntity>descendantOrSelfIterator();
		i.reset(g);
		Set<IEntity> s = entities(i);

		IEntityIterator<IEntity> i2 = IteratorFactory.<IEntity>descendantOrSelfIterator();
		i2.reset(g);
		for (IEntity e : i2) {
			IEntityIterator<IEntity> i1 = IteratorFactory.<IEntity>ancestorIterator();
			i1.reset(e);
			Set<IEntity> s1 = entities(i1);
			IEntityIterator<IEntity> i22 = IteratorFactory.selfIterator();
			i22.reset(e);
			Set<IEntity> s2 = entities(i22);
			IEntityIterator<IEntity> i3 = IteratorFactory.<IEntity>descendantIterator();
			i3.reset(e);
			Set<IEntity> s3 = entities(i3);
			IEntityIterator<IEntity> i4 = IteratorFactory.<IEntity>precedingIterator();
			i4.reset(e);
			Set<IEntity> s4 = entities(i4);
			IEntityIterator<IEntity> i5 = IteratorFactory.<IEntity>followingIterator();
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
	private Set<IEntity> entities(IEntityIterator<IEntity> i) {
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
		
		IEntityIterator<?> i = IteratorFactory.filterByIndexIterator(
				IteratorFactory.followingSiblingIterator(), 0);
		i.reset(p);
		assertSingleton(i, productions.wGet(2));
		
		i = IteratorFactory.filterByIndexIterator(
				IteratorFactory.followingSiblingIterator(), 1);
		i.reset(p);
		assertSingleton(i, productions.wGet(3));
		
		i = IteratorFactory.filterByIndexIterator(
				IteratorFactory.ancestorOrSelfIterator(), 2);
		i.reset(p);
		assertSingleton(i, productions.wGetParent());
		
		i = IteratorFactory.filterByIndexIterator(
				IteratorFactory.descendantOrSelfIterator(), 1);
		i.reset(p);
		assertSingleton(i, p.getName());
	}

	private void assertSingleton(IEntityIterator<?> i, IEntity e) {
		IEntityIterator<?> i2 = i.clone();
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
