/**
 * Copyright 2004-2012 Riccardo Solmi. All rights reserved.
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
package org.whole.lang.queries.util;

import static org.whole.lang.operations.PrettyPrinterOperation.toPrettyPrintString;

import java.util.HashSet;
import java.util.Set;

import junit.framework.TestCase;

import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.codebase.ClasspathPersistenceProvider;
import org.whole.lang.grammars.codebase.QueriesGrammar;
import org.whole.lang.grammars.factories.GrammarsEntityFactory;
import org.whole.lang.grammars.model.As;
import org.whole.lang.grammars.model.Grammar;
import org.whole.lang.grammars.model.NonTerminal;
import org.whole.lang.grammars.model.Production;
import org.whole.lang.grammars.model.Productions;
import org.whole.lang.grammars.reflect.GrammarsEntityDescriptorEnum;
import org.whole.lang.grammars.util.TestXmlGrammar;
import org.whole.lang.iterators.IEntityIterator;
import org.whole.lang.java.model.FieldDeclaration;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.IEntity;
import org.whole.lang.models.codebase.XmlModel;
import org.whole.lang.models.model.Model;
import org.whole.lang.models.model.ModelDeclarations;
import org.whole.lang.models.model.SimpleName;
import org.whole.lang.operations.DynamicCompilerOperation;
import org.whole.lang.queries.factories.QueriesEntityFactory;
import org.whole.lang.queries.model.KindTestEnum;
import org.whole.lang.queries.model.Path;
import org.whole.lang.queries.model.PathExpression;
import org.whole.lang.reflect.EntityKinds;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.templates.ITemplateManager;
import org.whole.lang.util.BehaviorUtils;
import org.whole.lang.util.EntityUtils;
import org.whole.lang.visitors.GenericIdentityVisitor;
import org.whole.lang.visitors.VisitException;
import org.whole.lang.xml.codebase.XmlBuilderPersistenceKit;

/**
 * @author Riccardo Solmi
 */
public class PathExpressionsQueriesTest extends TestCase {
	protected void setUp() throws Exception {
		ReflectionFactory.deployWholePlatform();
	}


	private Path buildPath9(QueriesEntityFactory ef) {
		return ef.createPath(
				ef.createFeatureStep("phraseStructure"),
				ef.createFilter(
						ef.createChildStep(),
						ef.createAnd(
								ef.createTypeTest("Production"),
								ef.createExpressionTest(
										ef.createFilter(
												ef.createFeatureStep("name"),
												ef.createVisitorTest(new GenericIdentityVisitor() {
													public void visit(IEntity entity) {
														if (Matcher.matchImpl(GrammarsEntityDescriptorEnum.NonTerminal, entity) && entity.wStringValue().startsWith("I"))
															return;
														throw new VisitException();
													}
													public String toString() {
														return "startsWith(\"I\")";
													}
												})
										)))));
	}

	private Path buildPath10(QueriesEntityFactory ef) {
		return ef.createPath(
				ef.createFilter(
						ef.createChildStep(), ef.createTypeTest("As")),
						ef.createFilter(
								ef.createFollowingSiblingStep(),
								ef.createAnd(
										ef.createIndexTest(ef.createIntLiteral(0)),
										ef.createTypeTest("As"))));
	}

	public void testPrettyPrint() {
		ITemplateManager tm = PathExpressionsQueriesTemplateManager.instance();
		QueriesEntityFactory ef = QueriesEntityFactory.instance;
		assertEquals("phraseStructure/child()[0]/rule/child()[0]/name", toPrettyPrintString(
				(PathExpression) tm.create("path1")));
		assertEquals("phraseStructure/child()[2]", toPrettyPrintString(
				(PathExpression) tm.create("path1a")));
		assertEquals("phraseStructure/child()[2][type() = Production]", toPrettyPrintString(
				(PathExpression) tm.create("path1b")));
		assertEquals("phraseStructure/child()[0]/following-sibling()[2]", toPrettyPrintString(
				(PathExpression) tm.create("path1c")));
		assertEquals("phraseStructure/child()[0]/following-sibling()[2][type() = Production]", toPrettyPrintString(
				(PathExpression) tm.create("path1d")));
		assertEquals("phraseStructure/child()[0]/rule/descendant()[kind() = SIMPLE]|[kind() = DATA]", toPrettyPrintString(
				(PathExpression) tm.create("path2")));		
		assertEquals("phraseStructure/child()[0]/rule/descendant()![kind() = COMPOSITE]", toPrettyPrintString(
				(PathExpression) tm.create("path3")));		
		assertEquals("phraseStructure/child()[type() <: Production]/rule/descendant()[type() <: Production]", toPrettyPrintString(
				(PathExpression) tm.create("path4")));		
		assertEquals("(phraseStructure, lexicalStructure)/child()[type() <: Production][rule[type() = Choose]]", toPrettyPrintString(
				(PathExpression) tm.create("path5")));		
		assertEquals("phraseStructure/child()[type() = Production][name[visitor: startsWith(\"I\")]]", toPrettyPrintString(buildPath9(ef)));		
	}

	public void testLanguageTest() throws Exception {
		IEntity model = XmlBuilderPersistenceKit.instance().readModel(
				new ClasspathPersistenceProvider("org/whole/lang/templates/codebase/TemplateManagerArtifactsTemplates.xwl"));

		QueriesEntityFactory ef = QueriesEntityFactory.instance;
		for (IEntity e : BehaviorUtils.compileAndLazyEvaluate(ef.createFilter(
				ef.createDescendantOrSelfStep(),
				ef.createLanguageTest("http://lang.whole.org/Java")), model))
			assertEquals("http://lang.whole.org/Java", e.wGetLanguageKit().getURI());
	}

	public void testKindTest() throws Exception {
		IEntity model = XmlBuilderPersistenceKit.instance().readModel(
				new ClasspathPersistenceProvider("org/whole/lang/templates/codebase/TemplateManagerArtifactsTemplates.xwl"));

		QueriesEntityFactory ef = QueriesEntityFactory.instance;
		for (IEntity e : BehaviorUtils.compileAndLazyEvaluate(ef.createFilter(
				ef.createDescendantOrSelfStep(),
				ef.createKindTest(KindTestEnum.RESOLVER)), model))
			assertTrue(EntityUtils.isResolver(e));

		for (IEntity e : BehaviorUtils.compileAndLazyEvaluate(ef.createFilter(
				ef.createDescendantOrSelfStep(),
				ef.createKindTest(KindTestEnum.DATA)), model))
			assertTrue(EntityUtils.isData(e));

		for (IEntity e : BehaviorUtils.compileAndLazyEvaluate(ef.createFilter(
				ef.createDescendantOrSelfStep(),
				ef.createKindTest(KindTestEnum.FRAGMENT)), model))
			assertTrue(EntityUtils.isFragment(e));
	}

	public void testVisitorTest() {
		Grammar g = new TestXmlGrammar().create();

		for (Production p : BehaviorUtils.<Production>compileAndLazyEvaluate(buildPath9(QueriesEntityFactory.instance), g))
			assertTrue(p.getName().getValue().startsWith("I"));
	}

	public void testPathByNameAndByIndexSteps() {
		ITemplateManager tm = PathExpressionsQueriesTemplateManager.instance();
		Grammar g = new TestXmlGrammar().create();
		NonTerminal prologNt = ((Production) ((Production) g.getPhraseStructure().wGet(0)).getRule().wGet(0)).getName();

		IEntityIterator<NonTerminal> nti = BehaviorUtils.compileAndLazyEvaluate((PathExpression) tm.create("path1"), g);

		assertTrue(nti.hasNext());
		assertSame(prologNt, nti.next());

		nti.reset(g.getPhraseStructure());
		assertFalse(nti.hasNext());

		nti.reset(g);
		assertTrue(nti.hasNext());
		assertSame(prologNt, nti.next());		
	} 

	public void testIndexTest() {
		ITemplateManager tm = PathExpressionsQueriesTemplateManager.instance();
		Grammar g = new TestXmlGrammar().create();

		IEntityIterator<Production> pi = BehaviorUtils.compileAndLazyEvaluate((PathExpression) tm.create("path1a"), g);
		assertTrue(pi.hasNext());
		assertSame(g.getPhraseStructure().wGet(2), pi.next());
		assertFalse(pi.hasNext());

		pi = BehaviorUtils.compileAndLazyEvaluate((PathExpression) tm.create("path1b"), g);
		assertTrue(pi.hasNext());
		assertSame(g.getPhraseStructure().wGet(2), pi.next());
		assertFalse(pi.hasNext());

		pi = BehaviorUtils.compileAndLazyEvaluate((PathExpression) tm.create("path1c"), g);
		assertTrue(pi.hasNext());
		assertSame(g.getPhraseStructure().wGet(3), pi.next());
		assertFalse(pi.hasNext());

		pi = BehaviorUtils.compileAndLazyEvaluate((PathExpression) tm.create("path1d"), g);
		assertTrue(pi.hasNext());
		assertSame(g.getPhraseStructure().wGet(3), pi.next());
		assertFalse(pi.hasNext());
	}

	public void testPathWithKindAndLogicFiltersIterator() {
		ITemplateManager tm = PathExpressionsQueriesTemplateManager.instance();
		QueriesEntityFactory ef = QueriesEntityFactory.instance;

		for (IEntity p : BehaviorUtils.compileAndLazyEvaluate((PathExpression) tm.create("path2"), new TestXmlGrammar().create()))
			assertTrue(p.wGetEntityKind().equals(EntityKinds.SIMPLE) || p.wGetEntityKind().equals(EntityKinds.DATA));

		for (IEntity p : BehaviorUtils.compileAndLazyEvaluate((PathExpression) tm.create("path3"), new TestXmlGrammar().create()))
			assertFalse(p.wGetEntityKind().equals(EntityKinds.COMPOSITE));
	}

	public void testPathWithFiltersIterator() {
		ITemplateManager tm = PathExpressionsQueriesTemplateManager.instance();
		Grammar g = new TestXmlGrammar().create();
		Set<String> l = new HashSet<String>();
		for (Production p : BehaviorUtils.<Production>compileAndLazyEvaluate((PathExpression) tm.create("path4"), g))
			l.add(p.getName().getValue());

		assertEquals(16, l.size());
	}

	public void testPathWithPatternFiltersIterator() {
		ITemplateManager tm = PathExpressionsQueriesTemplateManager.instance();
		Grammar g = new TestXmlGrammar().create();
		Set<String> l = new HashSet<String>();
		for (Production p : BehaviorUtils.<Production>compileAndLazyEvaluate((PathExpression) tm.create("path5"), g))
			l.add(p.getName().getValue());

		assertEquals(2, l.size());
	}

	public void testDistinct() {
		ITemplateManager tm = PathExpressionsQueriesTemplateManager.instance();
		Grammar g = new TestXmlGrammar().create();

		PathExpression pe1 = (PathExpression) tm.create("nonTerminalSet");

		Set<String> set = new HashSet<String>();
		for (NonTerminal nt : BehaviorUtils.<NonTerminal>compileAndLazyEvaluate(pe1, g))
			if (!set.add(nt.getValue()))
				fail();

		assertEquals(22, set.size());
	}

	//FIXME
	public void testPathWithTuple() {
		ITemplateManager tm = PathExpressionsQueriesTemplateManager.instance();
		IEntityIterator<IEntity> i = DynamicCompilerOperation.compile(
				tm.create("pathWithTuple"),
				BindingManagerFactory.instance.createArguments()).getResultIterator();
		assertTrue(i.hasNext());
		IEntity e0 = i.next();
		assertFalse(i.hasNext());
	}

	public void testProduct1() {
		ITemplateManager tm = PathExpressionsQueriesTemplateManager.instance();
		Grammar g = new TestXmlGrammar().create();

		PathExpression pe1 = (PathExpression) tm.create("testProduct1");

		IBindingManager bm = BindingManagerFactory.instance.createArguments();

		int count = 0;
		for (IEntity tuple : BehaviorUtils.compileAndLazyEvaluate(pe1, g, bm)) {
			String vname = ((Production) bm.wGet("pp")).getName().getValue()+"x"+((Production) bm.wGet("lp")).getName().getValue();
			String tname = ((Production) tuple.wGet(0)).getName().getValue()+"x"+((Production) tuple.wGet(1)).getName().getValue();
			assertEquals(vname, tname);
			count++;
		}

		assertEquals(g.getPhraseStructure().wSize()*g.getLexicalStructure().wSize(), count);
	}
	public void testProduct2() {
		ITemplateManager tm = PathExpressionsQueriesTemplateManager.instance();
		Grammar g = new TestXmlGrammar().create();

		PathExpression pe1 = (PathExpression) tm.create("testProduct2");

		IBindingManager bm = BindingManagerFactory.instance.createArguments();

		int count = 0;
		for (IEntity tuple : BehaviorUtils.compileAndLazyEvaluate(pe1, g, bm)) {
			String prodname = ((Production) bm.wGet("prod")).getName().getValue();
			assertEquals(prodname, tuple.wGet(0).wStringValue());
			count++;
		}

		assertEquals(g.getPhraseStructure().wSize(), count);
	}

	public void testProduct3() {
		ITemplateManager tm = PathExpressionsQueriesTemplateManager.instance();
		Grammar g = new TestXmlGrammar().create();

		PathExpression pe1 = (PathExpression) tm.create("testProduct3");

		IBindingManager bm = BindingManagerFactory.instance.createArguments();

		int count = 0;
		for (IEntity tuple : BehaviorUtils.compileAndLazyEvaluate(pe1, g, bm)) {
			String vname = ((NonTerminal) bm.wGet("name1")).getValue()+"x"+((NonTerminal) bm.wGet("name2")).getValue();
			String tname = tuple.wGet(0).wStringValue()+"x"+tuple.wGet(1).wStringValue();
			assertEquals(vname, tname);
			count++;
		}

		assertEquals(g.getPhraseStructure().wSize()*g.getPhraseStructure().wSize(), count);
	}

	public void testProduct4() {
		ITemplateManager tm = PathExpressionsQueriesTemplateManager.instance();
		Grammar g = new TestXmlGrammar().create();
		Productions productions = g.getPhraseStructure();

		PathExpression pe1 = (PathExpression) tm.create("testProduct4");

		IBindingManager bm = BindingManagerFactory.instance.createArguments();

		int count = 0;
		for (IEntity tuple : BehaviorUtils.compileAndLazyEvaluate(pe1, g, bm)) {
			Production p = (Production) productions.wGet(count++);

			assertSame(p.getName(), bm.wGet("name"));
			assertSame(p.getRule(), bm.wGet("rule"));
			assertSame(p.getName(), tuple.wGet(0));
			assertSame(p.getRule(), tuple.wGet(1));
		}

		assertEquals(g.getPhraseStructure().wSize(), count);
	}

	public void testSingleVariableTestInPathExpPredicate() {
		ITemplateManager tm = PathExpressionsQueriesTemplateManager.instance();
		Grammar g = new TestXmlGrammar().create();
		Production p = (Production) g.getPhraseStructure().wGet(1);

		PathExpression pe1 = (PathExpression) tm.create("findProduction");

		IBindingManager bm = BindingManagerFactory.instance.createArguments();

		//FIXME bm.wDefValue("pname", "Element");
		bm.wDef("pname", GrammarsEntityFactory.instance.createNonTerminal("Element"));
		IEntity p1 = BehaviorUtils.evaluateFirstResult(pe1, g, bm);
		assertSame(p, p1);

		bm.wDef("pname", GrammarsEntityFactory.instance.createNonTerminal("invented"));
		p1 = BehaviorUtils.evaluateFirstResult(pe1, g, bm);
		assertNull(p1);
	}

	public void testSingleVariableTestInPathExpPredicateOfPathInternalStep() {
		ITemplateManager tm = PathExpressionsQueriesTemplateManager.instance();
		Grammar g = new TestXmlGrammar().create();

		PathExpression pe1 = (PathExpression) tm.create("findAllNonTerminalsUsed");

		IBindingManager bm = BindingManagerFactory.instance.createArguments();

		//FIXME bm.wDefValue("pname", "Element");
		bm.wDef("pname", GrammarsEntityFactory.instance.createNonTerminal("IName"));
		int count = 0;
		for (NonTerminal nt : BehaviorUtils.<NonTerminal>compileAndLazyEvaluate(pe1, g, bm))
			count++;
		assertEquals(4, count);
	}

	public void testSingleVariableTestInPathLastStep() {
		ITemplateManager tm = PathExpressionsQueriesTemplateManager.instance();
		Grammar g = new TestXmlGrammar().create();

		PathExpression pe1 = (PathExpression) tm.create("findNonTerminalOccurrences");
		PathExpression pe2 = (PathExpression) tm.create("bindNonTerminalOccurrences");
		IBindingManager bm = BindingManagerFactory.instance.createArguments();

		IEntityIterator<NonTerminal> i1 = BehaviorUtils.<NonTerminal>compileAndLazyEvaluate(pe1, g);
		for (NonTerminal nt : BehaviorUtils.<NonTerminal>compileAndLazyEvaluate(pe2, g, bm)) {
			assertSame(nt, i1.next());
			assertEquals(nt.getValue(), bm.wStringValue("nt"));
		}
		assertFalse(i1.hasNext());
	}

	public void testLookaheadScope() {
		ITemplateManager tm = PathExpressionsQueriesTemplateManager.instance();
		Grammar g = new TestXmlGrammar().create();

		String[] templates = {
				"findNonTerminalOccurrences", "findProduction",
				"bindNonTerminalOccurrences", "recursiveProduction2",
				"testProduct1", "testProduct2", "testProduct3"};
		for (String template : templates) {
			PathExpression pe1 = (PathExpression) tm.create(template);
			IBindingManager bm = BindingManagerFactory.instance.createArguments();
			IEntityIterator<IEntity> i1 = BehaviorUtils.<IEntity>compileAndLazyEvaluate(pe1, g, bm);
			IEntity p1 = null;
			while ((p1 = i1.lookahead()) != null) {
				Set<String> s1 = i1.lookaheadScope().wNames();
				IEntity p2 = i1.next();
//				false for tuples        		assertSame(p1,p2);
				assertEquals(bm.wNames().size(), s1.size());
				for(String name : s1)
					assertTrue(bm.wIsSet(name));
			}
		}
	}

	public void testVariableJoinTest2() {
		ITemplateManager tm = PathExpressionsQueriesTemplateManager.instance();
		Grammar g = new QueriesGrammar().create();

		PathExpression pe1 = (PathExpression) tm.create("recursiveProduction2");

		StringBuilder names = new StringBuilder();
		for (Production p : BehaviorUtils.<Production>compileAndLazyEvaluate(pe1, g))
			names.append(p.getName().getValue());

		assertEquals("ExpressionPathExpressionStepExpressionPredicate", names.toString());
	}
	public void testVariableJoinTest3() {
		ITemplateManager tm = PathExpressionsQueriesTemplateManager.instance();
		Grammar g = new QueriesGrammar().create();

		PathExpression pe1 = (PathExpression) tm.create("recursiveProduction3");

		StringBuilder names = new StringBuilder();
		for (Production p : BehaviorUtils.<Production>compileAndLazyEvaluate(pe1, g))
			names.append(p.getName().getValue());

		assertEquals("ExpressionPathExpressionStepExpressionPredicate", names.toString());
	}
	public void testVariableJoinTest4() {
		ITemplateManager tm = PathExpressionsQueriesTemplateManager.instance();
		Grammar g = new QueriesGrammar().create();

		PathExpression pe1 = (PathExpression) tm.create("recursiveProduction4");

		StringBuilder names = new StringBuilder();
		for (Production p : BehaviorUtils.<Production>compileAndLazyEvaluate(pe1, g))
			names.append(p.getName().getValue());

		assertEquals("ExpressionPathExpressionStepExpressionPredicate", names.toString());
	}
	public void testVariableJoinTest5() {
		ITemplateManager tm = PathExpressionsQueriesTemplateManager.instance();
		Grammar g = new QueriesGrammar().create();

		PathExpression pe1 = (PathExpression) tm.create("recursiveProduction5");

		StringBuilder names = new StringBuilder();
		for (Production p : BehaviorUtils.<Production>compileAndLazyEvaluate(pe1, g))
			names.append(p.getName().getValue());

		assertEquals("ExpressionPathExpressionStepExpressionPredicate", names.toString());
	}

	public void testSomePredicate() {
		ITemplateManager tm = PathExpressionsQueriesTemplateManager.instance();
		Grammar g = new QueriesGrammar().create();

		PathExpression pe1 = (PathExpression) tm.create("recursiveProduction6");

		StringBuilder names = new StringBuilder();
		for (Production p : BehaviorUtils.<Production>compileAndLazyEvaluate(pe1, g))
			names.append(p.getName().getValue());

		assertEquals("ExpressionPathExpressionStepExpressionPredicate", names.toString());
	}

	public void testEveryPredicate() {
		ITemplateManager tm = PathExpressionsQueriesTemplateManager.instance();
		Grammar g = new QueriesGrammar().create();

		PathExpression pe1 = (PathExpression) tm.create("unusedProduction");

		IEntityIterator<Production> iterator = BehaviorUtils.<Production>compileAndLazyEvaluate(pe1, g);
		assertTrue(iterator.hasNext());
		Production p = iterator.next();
		assertEquals("Statement", p.getName().getValue());
		assertTrue(iterator.hasNext());
		p = iterator.next();
		assertEquals("Declaration", p.getName().getValue());
		assertTrue(iterator.hasNext());
		p = iterator.next();
		assertEquals("Index", p.getName().getValue());
		assertFalse(iterator.hasNext());
	}

	public void testOnePredicate() {
		ITemplateManager tm = PathExpressionsQueriesTemplateManager.instance();
		Grammar g = new TestXmlGrammar().create();

		PathExpression pe1 = (PathExpression) tm.create("exactlyOneDefUse");
		IBindingManager bm = BindingManagerFactory.instance.createArguments();

		IEntityIterator<Production> iterator = BehaviorUtils.<Production>compileAndLazyEvaluate(pe1, g, bm);
		assertTrue(iterator.hasNext());
		Production p = iterator.next();
		assertEquals("IName", p.getName().getValue());
		assertFalse(iterator.hasNext());
	}

	public void testVariablesInQuantifiedPredicate() {
		ITemplateManager tm = PathExpressionsQueriesTemplateManager.instance();
		Grammar g = new TestXmlGrammar().create();

		PathExpression pe1 = (PathExpression) tm.create("recursiveProduction6");
		IBindingManager bm = BindingManagerFactory.instance.createArguments();
		IEntityIterator<Production> iterator = BehaviorUtils.<Production>compileAndLazyEvaluate(pe1, g, bm);
		iterator.next();
		assertTrue(bm.wIsSet("pname"));
		assertTrue(bm.wIsSet("nt"));

		pe1 = (PathExpression) tm.create("exactlyOneDefUse");
		bm = BindingManagerFactory.instance.createArguments();
		iterator = BehaviorUtils.<Production>compileAndLazyEvaluate(pe1, g, bm);
		iterator.next();
		assertTrue(bm.wIsSet("pname"));
		assertTrue(bm.wIsSet("nt"));

		pe1 = (PathExpression) tm.create("unusedProduction");
		bm = BindingManagerFactory.instance.createArguments();
		iterator = BehaviorUtils.<Production>compileAndLazyEvaluate(pe1, g, bm);
		iterator.next();
		assertTrue(bm.wNames().isEmpty());
	}

	public void testRebindVariable() {
		ITemplateManager tm = PathExpressionsQueriesTemplateManager.instance();
		Grammar g = new TestXmlGrammar().create();

		IBindingManager bm = BindingManagerFactory.instance.createArguments();
		bm.wDef("pname", GrammarsEntityFactory.instance.createNonTerminal("Element"));

		int count = 0;
		for (Production p : BehaviorUtils.<Production>compileAndLazyEvaluate((PathExpression) tm.create("findProduction"), g, bm))
			count++;
		assertEquals(1, count);

		count = 0;
		for (Production p : BehaviorUtils.<Production>compileAndLazyEvaluate((PathExpression) tm.create("findProduction"), g))
			count++;
		assertEquals(6, count);		
	}

	public void testPatternPredicate() {
		ITemplateManager tm = PathExpressionsQueriesTemplateManager.instance();
		Grammar g = new TestXmlGrammar().create();

		int count = 0;
		for (As as : BehaviorUtils.<As>compileAndLazyEvaluate((PathExpression) tm.create("path7"), g)) {
			assertEquals("tag", as.getName().wStringValue());
			count++;
		}

		assertEquals(2, count);
	}

	public void testPatternWithVariablePredicate() {
		ITemplateManager tm = PathExpressionsQueriesTemplateManager.instance();
		Grammar g = new TestXmlGrammar().create();

		StringBuilder names = new StringBuilder();
		IBindingManager bm = BindingManagerFactory.instance.createArguments();
		IEntityIterator<Production> iterator = BehaviorUtils.<Production>compileAndLazyEvaluate(
				(PathExpression) tm.create("path8"), g, bm);
		for (Production p : iterator) {
			assertEquals(bm.wStringValue("name"), p.getName().getValue());
			names.append(p.getName().getValue());
		}

		assertEquals("VersionEncodingValueNameNameSpaceCharDataCDataSectDataCommentText", names.toString());
	}

	//FIXME
	public void testBindingOfSelfIndex() {
		ITemplateManager tm = PathExpressionsQueriesTemplateManager.instance();
		Grammar g = new TestXmlGrammar().create();

		int count = 0;
		for (Production p : BehaviorUtils.<Production>compileAndLazyEvaluate(
				(PathExpression) tm.create("path6"), g)) {
			assertTrue(g.getPhraseStructure().wIndexOf(p) >= 2);
			count++;
		}

		assertEquals(2, count);
	}

	public void testChildStepByName() {
		Model model = new XmlModel().create();

		SimpleName name = model.getName();

		QueriesEntityFactory ef = QueriesEntityFactory.instance;
		IEntity result = BehaviorUtils.evaluateFirstResult(
				ef.createFeatureStep("name"), model);

		assertSame(name, result);
	}

	public void testChildStepByIndex() {
		Model model = new XmlModel().create();
		ModelDeclarations decls = model.getDeclarations();

		IEntity decl3 = decls.wGet(3);

		QueriesEntityFactory ef = QueriesEntityFactory.instance;
		IEntity result = BehaviorUtils.evaluateFirstResult(
				ef.createFilter(ef.createChildStep(), ef.createIndexTest(ef.createIntLiteral(3))), decls);

		assertSame(decl3, result);
	}

	public void testPathOfChildSteps() {
		Model model = new XmlModel().create();

		IEntity decl3 = model.getDeclarations().wGet(3);

		QueriesEntityFactory ef = QueriesEntityFactory.instance;
		PathExpression pe = ef.createPath(
				ef.createFeatureStep("declarations"),
				ef.createFilter(ef.createChildStep(), ef.createIndexTest(ef.createIntLiteral(3))));
		IEntity result = BehaviorUtils.evaluateFirstResult(pe, model);

		assertSame(decl3, result);
	}

	public void testHelperResultAs() {
		ITemplateManager tm = PathExpressionsQueriesTemplateManager.instance();
		Model m = new XmlModel().create();

		PathExpression query = (PathExpression) tm.create("helperResultAs");
		
		IBindingManager bm = BindingManagerFactory.instance.createArguments();
		bm.wDefValue("ftype", "firstName");

		IEntityIterator<?> iterator = BehaviorUtils.<FieldDeclaration>compileAndLazyEvaluate(query, m, bm);
		assertTrue(iterator.hasNext());
		IEntity result = iterator.next();
		IEntity as = bm.wGet("jtype");
		assertEquals("FirstName", result.wStringValue());
		assertEquals("FirstName", as.wStringValue());

		assertFalse(iterator.hasNext());
		iterator.reset(m);

		bm.wDefValue("ftype", "secondName");
		assertTrue(iterator.hasNext());
		IEntity result2 = iterator.next();
		IEntity as2 = bm.wGet("jtype");
		assertEquals("SecondName", result2.wStringValue());
		assertEquals("SecondName", as2.wStringValue());
	}
}
